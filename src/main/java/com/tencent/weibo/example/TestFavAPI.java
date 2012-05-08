package com.tencent.weibo.example;

import com.tencent.weibo.api.StatusesAPI;
import com.tencent.weibo.api.TweetAPI;
import com.tencent.weibo.api.UserAPI;
import com.tencent.weibo.utils.OAuthClient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class TestFavAPI {


	private static String verify = null;
	public static void main(String[] args) {
		try {
			test_list_t();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test_list_t() throws Exception {
		com.tencent.weibo.beans.OAuth oauth=new com.tencent.weibo.beans.OAuth();
		OAuthClient auth=new OAuthClient();
 
		// 获取request token
		oauth = auth.requestToken(oauth);

		if (oauth.getStatus() == 1) {
			System.out.println("Get Request Token failed!");
			return;
		} else {
			String oauth_token = oauth.getOauth_token();
			
			String url = "http://open.t.qq.com/cgi-bin/authorize?oauth_token="
				+ oauth_token;
			 
		
	        System.out.println("Get verification code......");
	        if( !java.awt.Desktop.isDesktopSupported() ) {

	            System.err.println( "Desktop is not supported (fatal)" );
	            System.exit( 1 );
	        }
	        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
	        if(desktop == null || !desktop.isSupported( java.awt.Desktop.Action.BROWSE ) ) {

	            System.err.println( "Desktop doesn't support the browse action (fatal)" );
	            System.exit( 1 );
	        }
	        try {
				desktop.browse(new URI(url));
			} catch (IOException e) {
				e.printStackTrace();
				System.exit( 1 );
			} catch (URISyntaxException e) {
				e.printStackTrace();
				System.exit( 1 );
			}		

			
	        System.out.println("Input your verification code：");
	        Scanner in = new Scanner(System.in);
	        verify = in.nextLine(); 
	        
	        //获取access token
	        System.out.println("GetAccessToken......");
	        oauth.setOauth_verifier(verify);
	        oauth = auth.accessToken(oauth);
	        System.out.println("Response from server：");

 
			if (oauth.getStatus() == 2) {
				System.out.println("Get Access Token failed!");
				return;
			} else {		
				//FavAPI tAPI=new FavAPI();
				//String response=tAPI.list_t(oauth, WeiBoConst.ResultType.ResultType_Json, "20", "0", "0");
				//String response=tAPI.delt(oauth, WeiBoConst.ResultType.ResultType_Json, "104502055372919");
				//String response=tAPI.addt(oauth,  WeiBoConst.ResultType.ResultType_Json, "104502055372919");
				//FriendsAPI friends_API=new FriendsAPI();
				//String response=friends_API.fanlist_s(oauth,WeiBoConst.ResultType.ResultType_Json,"20","0");
				
				/*
				HtAPI htAPI=new HtAPI();
				String response=htAPI.info(oauth,WeiBoConst.ResultType.ResultType_Json,"20");
				*/
				

	 
				//TrendsAPI htAPI=new TrendsAPI();
				//String response=htAPI.ht(oauth,WeiBoConst.ResultType.ResultType_Xml,"3","20","0");
				
				
				/*
				StatusesAPI statuses_API=new StatusesAPI();
				String response=statuses_API.ht_timeline(oauth, WeiBoConst.ResultType.ResultType_Json,"pBroad","1","","100" );
				*/
				/*
				TweetAPI htAPI=new TweetAPI();
				 url="http://box.zhangmen.baidu.com/m?rf=idx&ct=134217728&tn=baidumt&gate=10&c_n=mp3ordeqqr&l_id=3&l_n=%E6%AD%8C%E6%9B%B2TOP500&s_o=0";
				String response=htAPI.add_music(oauth, WeiBoConst.ResultType.ResultType_Json, "hello", "127.0.0.1", "", "", url, "test", "test");
				*/
			 /*
				TagAPI tag=new TagAPI();
				String response=tag.add(oauth, WeiBoConst.ResultType.ResultType_Json, "测试");
				*/
				//SearchAPI search=new 	SearchAPI();
				UserAPI tUserAPI=new UserAPI();
				String feildid = "24037";
				String yearUser = "1985";
				String schoolid = "94229";
				String departmentid = "45823";
				String levelnum = "5";
				//userAPI.update_edu(oauth, format, feildid, year, schoolid, departmentid, level)
				//String response=search.userbytag(oauth, WeiBoConst.ResultType.ResultType_Json, "test", "20", "1");
				//StatusesAPI st=new StatusesAPI();
				//String response = "更新用户教育信息:" + tUserAPI.update_edu(oauth,  WeiBoConst.ResultType.ResultType_Json, feildid, yearUser, schoolid, departmentid, levelnum) + "\n\r";				
                String pagetime       = "0";
				String reqnum         = "20";
				String lastid         = "0";					
				String type           = "0";
				String contenttype    = "0";			                
				String accesslevel    = "0";		
				StatusesAPI tStatAPI=new StatusesAPI();
				//String response = "用户提及时间线索引:" + tStatAPI.mentions_timeline_ids(oauth, WeiBoConst.ResultType.ResultType_Json, pagetime, reqnum, lastid, type, contenttype, accesslevel)+ "\n\r";
				TweetAPI tAPI=new TweetAPI();
				//String response = "预发表视频微博" + tAPI.add_video_prev(oauth, WeiBoConst.ResultType.ResultType_Json, "cc", "127.0.0.1", "", "", "12348")+"\n\r";
				//System.out.println("response:"+response);

				//System.out.println("用户提及时间线索引:"+response);				
				//TweetAPI tAPI=new TweetAPI();
				//String response=tAPI.getvideoinfo(oauth, WeiBoConst.ResultType.ResultType_Json, "http://v.youku.com/v_show/id_XMjExODczODM2.html");
				//System.out.println("response:"+response);
			}
	        in.close();	        
		}
	}


}
