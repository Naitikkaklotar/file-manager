package com.project.DAO;

import java.util.List;

import com.project.model.DocumentVO;

public interface DocumentDAO {

	void saveDocument(DocumentVO documentVO);

	List<DocumentVO> findByParentId(Integer id);
}
