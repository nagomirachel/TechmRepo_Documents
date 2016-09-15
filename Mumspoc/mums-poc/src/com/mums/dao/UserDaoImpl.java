package com.mums.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.mums.bean.UserBean;
import com.mums.model.User;

@Repository("employeeDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addEmployee(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> listEmployeess() {
		return (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

	public User getEmployee(String cdsId) {
		return (User) sessionFactory.getCurrentSession().get(User.class, cdsId);
	}
	@Override
	public void deleteUser(User user) {
		System.out.println("To check"+user.getCdsId());
		sessionFactory.getCurrentSession().createQuery("DELETE FROM User WHERE cdsId = '"+user.getCdsId()+"'").executeUpdate();
	}

	@Override
	public void addUser(User user) {
		//sessionFactory.getCurrentSession().createQuery("insert into Employee (cdsId,firstName,lastName) SELECT '"+employee.getCdsid()+"','"+employee.getFirstName()+"','"+employee.getLastName()+"' FROM Employee").executeUpdate();
		 Session session = null;
	        session = this.sessionFactory.getCurrentSession();
		Query query = session
                .createSQLQuery(
                        "INSERT INTO user (cdsid,first_name,last_name) VALUES(:cdsId,:firstName,:lastName)")
                .setString("cdsId", user.getCdsId())
                .setString("firstName", user.getFirstName())
                .setString("lastName", user.getLastName());
        @SuppressWarnings("unused")
		int updated = query.executeUpdate();
		
		
		
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void editUser(String cdsId, String firstName, String lastName) {
		// TODO Auto-generated method stub
		User user=getEmployee(cdsId);
		System.out.println(user);
		if(user!= null) {
			user.setFirstName(firstName);
			user.setLastName(lastName);
			  }
		System.out.println("Into Query");
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public void addEmpnew(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		
	}

	 @SuppressWarnings("unchecked") 
	 @Override
	 public List<User> searchUser(UserBean userBean) 
	 { 
		 Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class); 
		 criteria.add(Restrictions.ilike("cdsId", userBean.getCdsId()+"%"));
	
		 return criteria.list(); 
		 }

	@Override
	public List<User> getAllEmpId() {
		// TODO Auto-generated method stub
		 @SuppressWarnings("unused")
		Session session = null;
	        session = this.sessionFactory.getCurrentSession();
			Query q= sessionFactory.getCurrentSession().createQuery("select e from User e");
			@SuppressWarnings("unchecked")
			List<User> cdsIds = q.list();
			System.out.println("getallgroupid is exiting.");
			return cdsIds;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> searchEmployee(String cdsId) {
		// TODO Auto-generated method stub
	
		 Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class); 
		 criteria.add(Restrictions.ilike(cdsId, criteria));
		return criteria.list(); 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> searchEmployee(User user) {
		// TODO Auto-generated method stub
		 Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class); 
		 criteria.add(Restrictions.ilike("cdsId", user.getCdsId()+"%"));
		 criteria.add(Restrictions.ilike("firstName", user.getFirstName()+"%"));
		 criteria.add(Restrictions.ilike("lastName", user.getLastName()+"%"));
		 return criteria.list(); 
		 }

	@Override
	public void deleteEmployee(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEmp(String cdsId, String firstName, String lastName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEmp(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> searchEmployee(UserBean userBean) {
		// TODO Auto-generated method stub
		return null;
	}

	}

	

