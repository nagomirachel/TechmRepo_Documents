package com.mums.dao;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mums.bean.DocumentBean;
import com.mums.model.Document;


@Repository("documentDao")
public class DocumentDaoImpl implements DocumentDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addDocument(Document document) {
		System.out.println("Insisde Add of DAos Impl");
		sessionFactory.getCurrentSession().saveOrUpdate(document);
		
	}
	@SuppressWarnings("unchecked")
	public List<Document> listDocuments() {
		// TODO Auto-generated method stub
		return (List<Document>) sessionFactory.getCurrentSession().createCriteria(Document.class).list();
	}

	public Document getDocument(String documentId) {
		// TODO Auto-generated method stub
		System.out.println("Inside DAO IMPL");
		return (Document) sessionFactory.getCurrentSession().get(Document.class, documentId);
	
}

	
	public void deleteDocument(Document document) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Document WHERE documentId = '"+document.getDocumentId()+"'").executeUpdate();
		
	}
	
	public List<Document> allDocId() {
		 @SuppressWarnings("unused")
		Session session = null;
	        session = this.sessionFactory.getCurrentSession();
			Query q= sessionFactory.getCurrentSession().createQuery("select dg from Document dg");
			@SuppressWarnings("unchecked")
			List<Document> docIds = q.list();
			System.out.println("getallgroupid is exiting.");
			return docIds;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Document> searchDocument(DocumentBean documentBean) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Document.class); 
		 criteria.add(Restrictions.ilike("documentId", documentBean.getDocumentId()+"%"));
		 System.out.println("In data layer");
		 return criteria.list(); 
 }
	
	@Override
	public List<Document> searchDocument(String documentGroupId) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		Session session = null;
        session = this.sessionFactory.getCurrentSession();
		Query q= sessionFactory.getCurrentSession().createQuery("select doc_id from doc_group_doc where doc_group_id=?");
		@SuppressWarnings("unchecked")
		List<Document> docNewIds = q.list();
		return docNewIds;
		
	}
	@Override
	public void addDoc(Document document) {
		// TODO Auto-generated method stub
		Session session = null;
        session = this.sessionFactory.getCurrentSession();
	Query query = session
            .createSQLQuery(
                    "INSERT INTO doc(doc_id,doc_name,printer_id) VALUES(:documentId,:documentName,:printId)")
            .setString("documentId", document.getDocumentId())
            .setString("documentName", document.getDocumentName())
            .setString("printId",document.getPrintId());
	System.out.println("printId");
    @SuppressWarnings("unused")
	int updated = query.executeUpdate();
	
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Document> searchDocument(Document document) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Document.class); 
		 criteria.add(Restrictions.ilike("documentId", document.getDocumentId()+"%"));
		 //criteria.add(Restrictions.ilike("documentName", document.getDocumentName()+"%"));
		// criteria.add(Restrictions.ilike("printId", document.getPrintId()+"%"));
		 return criteria.list(); 
		 }
	
	
	@Override
	public void updateDocument(String documentId, String documentName, String printId) {
		Document document=getDocument(documentId);
		System.out.println(document);
		if(document!= null) {
			document.setDocumentName(documentName);
			document.setPrintId(printId);
			  }
		System.out.println("Into Query");
		sessionFactory.getCurrentSession().saveOrUpdate(document);
		
	}
		
}
