package com.app.inventory.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.inventory.models.Product;
import com.app.inventory.utils.ExceptionUtil;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Integer>{

	@Query(value="SELECT p FROM Product p WHERE state.id= ?1")
	List<Product> getProductByState(Integer idstate);
	
	@Query(value="SELECT p FROM Product p WHERE elaboration.id= :idelaboration")
	List<Product> getProductByElaboration(Integer idelaboration);
	
	@Query(value="SELECT p FROM Product p WHERE ubication.id= :idubication")
	List<Product> getProductByUbication(Integer idubication);
	
	@Query(value="SELECT p FROM Product p WHERE elaboration.id= ?1 AND state.id= ?2")
	List<Product> getProductByElaborationAndState(Integer idelaboration, Integer idstate);
	
	@Query(value="SELECT p FROM Product p WHERE elaboration.id= :idelaboration AND ubication.id= :idubication")
	List<Product> getProductByElaborationAndUbication(Integer idelaboration, Integer idubication);
	
	@Query(value="SELECT p FROM Product p WHERE state.id= :idstate AND ubication.id= :idubication")
	List<Product> getProductByStateAndUbication(Integer idstate, Integer idubication);
	
	@Query(value="SELECT p FROM Product p WHERE elaboration.id= :idelaboration AND state.id= :idstate AND ubication.id= :idubication")
	List<Product> getProductByElaborationAndStateAndUbication(Integer idelaboration, Integer idstate, Integer idubication);
		
}
