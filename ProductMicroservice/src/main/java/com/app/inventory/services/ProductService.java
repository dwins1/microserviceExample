package com.app.inventory.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.inventory.models.Product;
import com.app.inventory.repository.ProductsRepository;
import com.app.inventory.userms.User;
import com.app.inventory.utils.ExceptionUtil;

@Service
public class ProductService{
	
	@Autowired
	ProductsRepository repository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	public List<Product> getAllProduct() {
		Optional<List<Product>> list=Optional.ofNullable(repository.findAll());
		list= (list.get().isEmpty()) ? Optional.ofNullable(null):list ;
		list.orElseThrow(ArithmeticException::new);
		return list.get();
	}
	
	public Product getProductById(Integer id) {
		Optional<Product> list= repository.findById(id);
		list.orElseThrow(ArithmeticException::new);
		System.out.println(list);
		System.out.println(list.orElseThrow(RuntimeException::new));
		return list.get();
	}
	
	public void deleteProductById(Integer id) {
		repository.deleteById(id);
	}
	
	public void createProduct(Product product) throws ExceptionUtil{
		try {
		repository.save(product); 
		}
		catch (Exception e) {
			throw new ExceptionUtil(500, "Error al crear el producto", e.toString());
		}
	}

	
	public void updateProduct(Product product) {
		repository.save(product);
	}
	
	public List<Product> getProductByState(Integer idState) {
		return repository.getProductByState(idState);
	}

	public List<Product> getProductByElaboration(Integer idelaboration) {
		return repository.getProductByElaboration(idelaboration);
	}
	
	public List<Product> getProductByElaborationAndState(Integer idelaboration, Integer idState) {
		return repository.getProductByElaborationAndState(idelaboration, idState);
	}
	
	public List<Product> getProductByUbication(Integer idUbication) {
		return repository.getProductByUbication(idUbication);
	}

	public List<Product> getProductByElaborationAndUbication(Integer idelaboration, Integer idUbication) {
		return repository.getProductByElaborationAndUbication(idelaboration, idUbication);
	}

	public List<Product> getProductByStateAndUbication(Integer idState, Integer idUbication) {
		return repository.getProductByStateAndUbication(idState, idUbication);
	}

	public List<Product> getProductByElaborationAndStateAndUbication(Integer idelaboration, Integer idState,
			Integer idUbication) {
		return repository.getProductByElaborationAndStateAndUbication(idelaboration, idState, idUbication);
	}
	
	public List<User> getAllUser() {
		List<User> user =restTemplate.getForObject("http://localhost:8091/user/", List.class);
		return user;
	}

	
	
}
