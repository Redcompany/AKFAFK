package com.AFK.travel56.dao;

import java.util.List;

public interface FileDAO {
	public List<FileVO> findAllFileByArticle(int articleNumber);

	public int addFile(String fileName, int articleNumber);

	public List<FileVO> findAllFile();

	public int deleteFile(String fileName);
	public FileVO findAllFileByFileName(String fileName);
}
