package com.nuri.MVCPracice.VO;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("boardVO")
public class BoardVO {
	
	private int no;
	private String id;
	private String title;
	private String content;
	private Date wdate;
	private int views;
	
	
	
	public BoardVO() {
		super();
	}

	public BoardVO(int no, String id, String title, String content) {
		super();
		this.no = no;
		this.id = id;
		this.title = title;
		this.content = content;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	
	

}
