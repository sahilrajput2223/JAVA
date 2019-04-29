package model;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import VO.Student;

public class Dao {

	public void insert(Student sdata) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration()
				.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(sdata);
		transaction.commit();
		session.close();
	}
	
	public List display() {
		
		List list = new ArrayList();
		
				SessionFactory sessionFactory = new Configuration()
				 .configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Student");
				list = q.list();
				tr.commit();
				session.close();
		
		return list;
	}
	
	public List displayById(Student s) {
		
		List list = new ArrayList();
		
				SessionFactory sessionFactory = new Configuration()
				 .configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Student where sid ="+s.getSid()+"");
				list = q.list();
				tr.commit();
				session.close();
		
		return list;
	}
	
	
	public void update(Student s) {
		
				SessionFactory sessionFactory = new Configuration()
				 .configure().buildSessionFactory();
				Session session = sessionFactory.openSession();
				Transaction tr = session.beginTransaction();
				session.saveOrUpdate(s);
				tr.commit();
				session.close();
	}
	
	
	public void delete(Student s) {
		SessionFactory sessionFactory = new Configuration()
				.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(s);
		tr.commit();
		session.close();
	}
	
	
	

}
