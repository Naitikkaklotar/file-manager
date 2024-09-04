package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "document_tbl")
public class DocumentVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "Folder_Name")
	private String folderName;

	@Column(name = "File_Name")
	private String fileName;

	@Column(name = "URL")
	private String url;
	
	@ManyToOne
    @JoinColumn(name = "parent_id")  
    private DocumentVO documentVO;
	
	@Column(name = "status")
	private boolean status = true;
	
	@Column(name = "isFolder")
	private boolean isFolder = true;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public DocumentVO getDocumentVO() {
		return documentVO;
	}

	public void setDocumentVO(DocumentVO documentVO) {
		this.documentVO = documentVO;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isFolder() {
		return isFolder;
	}

	public void setFolder(boolean isFolder) {
		this.isFolder = isFolder;
	}
}
