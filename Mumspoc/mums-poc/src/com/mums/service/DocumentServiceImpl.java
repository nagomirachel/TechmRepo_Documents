package com.mums.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.mums.bean.DocumentBean;
import com.mums.dao.DocumentDao;
import com.mums.model.Document;

@Service("documentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DocumentServiceImpl implements DocumentService {
	@Autowired
	private DocumentDao documentDao;
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addDocument(Document document) {
		// TODO Auto-generated method stub
		documentDao.addDocument(document);
	}

	@Override
	public List<Document> listDocuments() {
		// TODO Auto-generated method stub
		return documentDao.listDocuments();
	}

	@Override
	public Document getDocument(String documentid) {
		// TODO Auto-generated method stub
		 
		return documentDao.getDocument(documentid);
	}

	@Override
	public void deleteDocument(Document document) {
		// TODO Auto-generated method stub
		documentDao.deleteDocument(document);
	}

	@Override
	public List<Document> getAllDocId() {
		// TODO Auto-generated method stub
		return documentDao.allDocId();
	}

	@Override
	public List<DocumentBean> searchDocument(DocumentBean documentBean) {	
		List<Document> docs =  documentDao.searchDocument(documentBean);
	List<DocumentBean> docList = new ArrayList<DocumentBean>(0);
	DocumentBean bean = null;
	for (Document doc : docs) {
		bean = new DocumentBean();
		bean.setDocumentId(doc.getDocumentId());
		bean.setDocumentName(doc.getDocumentName());
		bean.setPrintId(doc.getPrintId());
		docList.add(bean);
	}
	
	return docList; 
	
}
	@Override
	public List<Document> searchDocument(String documentGroupId) {
		// TODO Auto-generated method stub

		return documentDao.searchDocument(documentGroupId);

}
	 @Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void addDoc(Document document) {
		// TODO Auto-generated method stub
		 documentDao.addDoc(document);
	}

	@Override
	public List<Document> searchDocument(Document document) {
		// TODO Auto-generated method stub
		return documentDao.searchDocument(document);
	}

	@Override
	public void updateDocument(String documentId, String documentName, String printId) {
		// TODO Auto-generated method stub
		 documentDao.updateDocument(documentId,documentName,printId);

	}
}