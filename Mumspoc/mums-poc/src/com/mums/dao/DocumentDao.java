package com.mums.dao;

import java.util.List;

import com.mums.bean.DocumentBean;
import com.mums.model.Document;

public interface DocumentDao {
	public void addDocument(Document document);
	
	public Document getDocument(String documentId);
	
	public void deleteDocument(Document document);

	public List<Document> listDocuments();

	public List<Document> allDocId();

	public List<Document> searchDocument(DocumentBean documentBean);

	public List<Document> searchDocument(String documentGroupId);

	public void addDoc(Document document);

	public List<Document> searchDocument(Document document);

	public void updateDocument(String documentId, String documentName, String printId);

}
