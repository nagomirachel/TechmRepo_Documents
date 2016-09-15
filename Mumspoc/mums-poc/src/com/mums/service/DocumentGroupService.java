package com.mums.service;

import java.util.List;

import com.mums.model.Document;
import com.mums.model.DocumentGroup;



public interface DocumentGroupService {
	public void addDocumentGroup(DocumentGroup documentGroup);

	public List<DocumentGroup> listDocumentGroups();
	
	public DocumentGroup getDocumentGroup(String documentGroupId);
	
	public void deleteDocumentGroup(DocumentGroup documentGroup);
	
	List<Document> getDocumentOptions();

	public List<DocumentGroup> searchDocumentGroup(String documentGroupId, String documentGroupName);

	
}
