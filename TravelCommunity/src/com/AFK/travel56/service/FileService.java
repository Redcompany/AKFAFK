package com.AFK.travel56.service;

import java.util.List;

import com.AFK.travel56.dao.FileDAO;
import com.AFK.travel56.dao.FileVO;
import com.AFK.travel56.dao.MySqlFileDAO;

public class FileService {
	FileDAO fileVO = new MySqlFileDAO();

	//글에대한 파일 보여주기
	public List<FileVO> showFilesByArticle(int articleNumber) {
		return fileVO.findAllFileByArticle(articleNumber);
	}
	public List<FileVO> allShowFiles(){
		return fileVO.findAllFile();
	}

	//파일등록
	public boolean registerFile(String fileName, int articleNumber) {
		fileVO.addFile(fileName, articleNumber);
		return true;
	}
	//파일 삭제  
	public void deleteFile(String fileName) {
		fileVO.deleteFile(fileName);
	}

}
