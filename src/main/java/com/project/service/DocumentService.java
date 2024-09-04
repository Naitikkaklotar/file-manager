package com.project.service;

import java.util.List;

import com.project.model.DocumentVO;

public interface DocumentService {
	
	void saveDocument(DocumentVO documentVO);
	
	List<DocumentVO> findByParentId(Integer id);

}
