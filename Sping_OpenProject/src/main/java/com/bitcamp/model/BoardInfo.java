package com.bitcamp.model;

public class BoardInfo {
	private int board_id;
	private String writer_id;
	private String title;
	private String content;
	private String writedate;
	
	public BoardInfo() { }

	public BoardInfo(int board_id, String writer_id, String title, String content, String writedate) {
		super();
		this.board_id = board_id;
		this.writer_id = writer_id;
		this.title = title;
		this.content = content;
		this.writedate = writedate;
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public String getWriter_id() {
		return writer_id;
	}

	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
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

	public String getWritedate() {
		return writedate;
	}

	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}

	@Override
	public String toString() {
		return "BoardInfo [board_id=" + board_id + ", writer_id=" + writer_id + ", title=" + title + ", content="
				+ content + ", writedate=" + writedate + "]";
	}	
}