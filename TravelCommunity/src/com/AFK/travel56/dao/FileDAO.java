package com.AFK.travel56.dao;

import java.util.List;

public interface FileDAO {
	public List<FileVO> findAllFileByArticle(int articleNumber);

	public int addFile(String fileName, int articleNumber);
	

	public int deleteFile(String fileName);
}
