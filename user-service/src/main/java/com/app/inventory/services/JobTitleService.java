package com.app.inventory.services;

import java.util.ArrayList;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.app.inventory.loginjwt.ResultUtil;
import com.app.inventory.models.JobTitle;
import com.app.inventory.models.User;
import com.app.inventory.models.UserDetail;
import com.app.inventory.repository.JobTitleRepository;
import com.app.inventory.utils.HibernateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Repository
@Transactional
public class JobTitleService implements JobTitleRepository{

		
	@SuppressWarnings("unchecked")
	@Override
	public List<JobTitle> getAllJobTitles() {
		List<JobTitle> result;
		Session session=HibernateUtil.getSessionFactory().openSession();
		try {
			String queryClause="From JobTitle";
			session.beginTransaction();
			result= session.createQuery(queryClause).getResultList();
			session.getTransaction().commit();
		} catch (Exception e) {
		// TODO: handle exception
			result=  null;
			e.printStackTrace();
		} finally {
			session.close();
			
		}
		return result;
	}
	
	@SuppressWarnings({ "unchecked"})
	@Override
	public List<String> getAllNamesJobTitles() {
		List<JobTitle> result;
		List<String> result1=new ArrayList<String>();  
		Session session=HibernateUtil.getSessionFactory().openSession();
		try {
			String queryClause="From JobTitle";
			session.beginTransaction();
			result= session.createQuery(queryClause).getResultList();
			session.getTransaction().commit();
		} catch (Exception e) {
		// TODO: handle exception
			result=  null;
			e.printStackTrace();
		} finally {
			session.close();
		}
		if(!result.isEmpty()) {
			int i=0;
			for (JobTitle j : result) {
				  result1.add(j.getJobTitle());
				  System.out.println(result1.get(i));
				  i++;
				}
		}
		return result1;
	}
	
	
	@SuppressWarnings({ "unchecked"})
	@Override
	public List<User> getUserByJobTitlesID(Integer id) {
		JobTitle result;
		List<User> result1 = null;  
		Session session=HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			result=session.find(JobTitle.class, id);		
			session.getTransaction().commit();
		} catch (Exception e) {
		// TODO: handle exception
			result=  null;
			e.printStackTrace();
		} finally {
			session.close();
			
		}
		if(result!=null) {
			result1=result.getUsers();
		}
		return result1;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public JobTitle getJobTitleById(Integer id) {
		JobTitle result;
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		System.out.println(id);
		try {
			
			session.beginTransaction();
			result=session.find(JobTitle.class, id);		
			session.getTransaction().commit();
			
		} catch (Exception e) {
		// TODO: handle exception
			result= null;
		} finally {
			session.close();
			
		}
		
		return result;
	}

	@Override
	public void deleteJobTitleById(Integer id) {
		Session session=HibernateUtil.getSessionFactory().openSession();

		try {		
			session.beginTransaction();
			JobTitle job= session.get(JobTitle.class, id);
			session.remove(job);
			session.getTransaction().commit();
		} catch (Exception e) {
		// TODO: handle exception
		} finally {
			session.close();
		
		}
	}

	@Override
	public void createJobTitle(JobTitle jobTitle) {
		
		Session session=HibernateUtil.getSessionFactory().openSession();

		try {		
			session.beginTransaction();
			session.save(jobTitle);
			session.getTransaction().commit();
		} catch (Exception e) {
		// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();

		}
	}

	@Override
	public void updateJobTitle(JobTitle jobTitle) {
		Session session=HibernateUtil.getSessionFactory().openSession();

		try {		
			session.beginTransaction();
			/*JobTitle job=session.get(JobTitle.class, jobTitle.getId());
			job.setJobTitle(jobTitle.getJobTitle());*/
			session.merge(jobTitle);
			session.getTransaction().commit();
		} catch (Exception e) {
		// TODO: handle exception
		} finally {
			session.close();
		};
	}

	

	
}
