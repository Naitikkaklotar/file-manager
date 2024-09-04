
package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.DocumentVO;
import com.project.service.DocumentService;

@Controller
public class DocumentController {

	@Autowired
	private DocumentService documentService;

	@GetMapping("user/filemanager")
	public ModelAndView users() {
		List<DocumentVO> documentList = this.documentService.findByParentId(null);
		return new ModelAndView("user/filemanager", "DocumentVO", new DocumentVO()).addObject("documentList",
				documentList);
	}

}
