package com.AFK.travel56.dao;

public class FileVO {

	private int fileNumber;
	private String fileName;
	private int articleNumber;

	public FileVO(int fileNumber, String fileName, int articleNumber) {
		this.fileNumber = fileNumber;
		this.fileName = fileName;
		this.articleNumber = articleNumber;
	}

	public int getFileNumber() {
		return fileNumber;
	}

	public void setFileNumber(int fileNumber) {
		this.fileNumber = fileNumber;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(int articleNumber) {
		this.articleNumber = articleNumber;
	}
}
