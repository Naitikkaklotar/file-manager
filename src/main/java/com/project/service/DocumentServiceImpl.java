package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.DAO.DocumentDAO;
import com.project.model.DocumentVO;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentDAO documentDAO;

	@Override
	public void saveDocument(DocumentVO documentVO) {
		this.documentDAO.saveDocument(documentVO);
	}

	@Override
	public List<DocumentVO> findByParentId(Integer id) {
		return this.documentDAO.findByParentId(id);
	}
}
