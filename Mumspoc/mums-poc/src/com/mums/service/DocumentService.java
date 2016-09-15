package com.mums.service;

import java.util.List;

import com.mums.bean.DocumentBean;
import com.mums.model.Document;


public interface DocumentService {
	public void addDocument(Document document);

	public List<Document> listDocuments();
	
	public Document getDocument(String cdsId);
	
	public void deleteDocument(Document document);

	public List<Document> getAllDocId();

	public List<DocumentBean> searchDocument(DocumentBean  documentBean);

	public List<Document> searchDocument(String documentGroupId);

	public void addDoc(Document document);

	public List<Document> searchDocument(Document document);

	public void updateDocument(String documentId, String documentName, String printId);
	
//	public List<DocumentBean> searchDoc(DocumentBean documentBean);
	
	
	}
