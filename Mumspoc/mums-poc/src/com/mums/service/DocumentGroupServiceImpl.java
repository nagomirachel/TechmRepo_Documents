package com.mums.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mums.dao.DocumentGroupDao;
import com.mums.model.Document;
import com.mums.model.DocumentGroup;

@Service("documentGroupService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DocumentGroupServiceImpl implements DocumentGroupService {
	@Autowired
	private DocumentGroupDao documentGroupDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addDocumentGroup(DocumentGroup documentGroup) {
		// TODO Auto-generated method stub
		documentGroupDao.addDocumentGroup(documentGroup);
	}

	@Override
	public List<DocumentGroup> listDocumentGroups() {
		// TODO Auto-generated method stub
		return documentGroupDao.listDocumentGroups();
	}

	@Override
	public DocumentGroup getDocumentGroup(String documentGroupId) {
		// TODO Auto-generated method stub
		return documentGroupDao.getDocumentGroup(documentGroupId);
	}

	@Override
	public void deleteDocumentGroup(DocumentGroup documentGroup) {
		// TODO Auto-generated method stub
		documentGroupDao.deleteDocumentGroup(documentGroup);
	}

	@Override
	public List<Document> getDocumentOptions() {
		// TODO Auto-generated method stub
		return documentGroupDao.getDocumentOptions();
	}

	@Override
	public List<DocumentGroup> searchDocumentGroup(String documentGroupId, String documentGroupName) {
		// TODO Auto-generated method stub
		return documentGroupDao.searchDocumentGroup(documentGroupId,documentGroupName);
	}


}
