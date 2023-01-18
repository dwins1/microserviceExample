package com.app.inventory.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.app.inventory.feignclients.ProductFeignClient;
import com.app.inventory.feignmodels.Product;
import com.app.inventory.models.JobTitle;
import com.app.inventory.models.User;
import com.app.inventory.models.UserDetail;
import com.app.inventory.repository.UserRepository;
import com.app.inventory.utils.DTOUtil;
import com.app.inventory.utils.ExceptionUtil;
import com.app.inventory.utils.HibernateUtil;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;


@Repository
@Transactional
public class UserService implements UserRepository{

	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	private ProductFeignClient productFeign;
	
	//Http request to product microservice
	//Star
	public List<Product> getAllProduct() {
		return productFeign.getProduct();
	}
	
	public ResponseEntity<DTOUtil> createProduct(Product product) {
		return productFeign.createProduct(product);
	}
	//final
	//Http request to product microservice
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser() throws ExceptionUtil{
		
		List<User> result;
		Session session=HibernateUtil.getSessionFactory().openSession();
		try {
			String queryClause="From User";
			session.beginTransaction();
			result= session.createQuery(queryClause).getResultList();
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new ExceptionUtil(500, "Error al consultar los usuarios en la base de Datos", e.toString());
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public User getUserById(Integer id) throws ExceptionUtil {
		User result;
		Session session=HibernateUtil.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			result=session.get(User.class, id);
			//result=session.get(User.class, null);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			throw new ExceptionUtil(500, "Error al consultar el usuario en la base de Datos", e.toString());
		} finally {
			session.close();
		}
		return result;
	}
	

	@Override
	public void deleteUserById(Integer id) throws ExceptionUtil{
		Session session=HibernateUtil.getSessionFactory().openSession();
		try {		
			session.beginTransaction();
			User user=session.get(User.class, id);
			
			if(user!=null) {
			session.delete(user);
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new ExceptionUtil(500, "Error al eliminar el usuario en la base de Datos", e.toString());
		} finally {
			session.close();
		}
	}

	@Override
	public Integer createUser(User user) throws ExceptionUtil{
		Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		String hashPassword=argon2.hash(1, 1024, 1, user.getPassword().toCharArray());
		user.setPassword(hashPassword);
		Integer idUser=null;
		System.out.println(idUser);
		Session session=HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			 idUser=(Integer)session.save(user);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			throw new ExceptionUtil(500, "Error al crear el usuario en la base de Datos", e.toString());
		} finally {
			session.close();
		}
		return idUser;
	}
		
	
	@Override
	public void updateUser(User user) throws ExceptionUtil{
		entityManager.merge(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserByJobTitle(JobTitle jobTitle) throws ExceptionUtil{
		String query="SELECT u FROM User u WHERE jobTitle.id="+jobTitle.getId();
		return entityManager.createQuery(query).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public User validationUser(User user) throws ExceptionUtil{
		String query="SELECT u FROM User u WHERE user= :userQuery";
		List<User> user1=entityManager.createQuery(query)
				.setParameter("userQuery", user.getUser())
				.getResultList();
		
		if(user1.isEmpty()) {
			return null;
		}
		String passwordHashed=user1.get(0).getPassword();
		
		Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		boolean validate=argon2.verify(passwordHashed, user.getPassword().toCharArray());
		if(validate) {
			return user1.get(0);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserListByID(){
		
		List<User> result = null;
		Session session=HibernateUtil.getSessionFactory().openSession();
		try {
			String queryClause="Select user  From User user where user.id IN(1,2,3)";
			session.beginTransaction();
			result= session.createQuery(queryClause).getResultList();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}
	
}
