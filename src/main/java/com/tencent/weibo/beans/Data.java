package com.tencent.weibo.beans;

import java.io.Serializable;

/**
 * 
 * @author <a href="http://blog.javawind.net">Xuefang Xu</a> bywyu
 *	id:12345678,Timestamp:12863444444
 *
 */
public class Data implements Serializable {
    private static final long serialVersionUID = -6153996326767557307L;
    private String id = "";
	private int timeStamp = 0;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(int timeStamp) {
		this.timeStamp = timeStamp;
	}
}
