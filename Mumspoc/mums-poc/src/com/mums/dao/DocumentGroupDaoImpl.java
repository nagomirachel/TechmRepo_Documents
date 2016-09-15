package com.mums.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mums.model.Document;
import com.mums.model.DocumentGroup;

@Repository("documentGroupDao")
public class DocumentGroupDaoImpl implements DocumentGroupDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	
	public void addDocumentGroup(DocumentGroup documentGroup) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(documentGroup);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<DocumentGroup> listDocumentGroups() {
		// TODO Auto-generated method stub
		return (List<DocumentGroup>) sessionFactory.getCurrentSession().createCriteria(DocumentGroup.class).list();	}

	
	public DocumentGroup getDocumentGroup(String documentGroupId) {
		// TODO Auto-generated method stub
		return (DocumentGroup) sessionFactory.getCurrentSession().get(DocumentGroup.class, documentGroupId);
	}

	
	public void deleteDocumentGroup(DocumentGroup documentGroup) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().createQuery("DELETE FROM DocumentGroup WHERE documentGroupId = '"+documentGroup.getDocumentGroupId()+"'").executeUpdate();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Document> getDocumentOptions() {
		// TODO Auto-generated method stub
		return (List<Document>) sessionFactory.getCurrentSession().createCriteria(Document.class).list();}

	@SuppressWarnings("unchecked")
	@Override
	public List<DocumentGroup> searchDocumentGroup(String documentGroupId, String documentGroupName) {
		// TODO Auto-gnull;
	
		 Criteria criteria = sessionFactory.getCurrentSession().createCriteria(DocumentGroup.class); 
		 criteria.add(Restrictions.ilike(documentGroupId,documentGroupName));
		return criteria.list();
		
	}
		


}
