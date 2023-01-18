package com.app.inventory.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.inventory.feignmodels.Product;
import com.app.inventory.utils.DTOUtil;

@FeignClient(name="product-service", url="http://localhost:8090")
//@RequestMapping("/product")
public interface ProductFeignClient{

	@RequestMapping(method = RequestMethod.GET, value="/product")
	public List<Product> getProduct();
	
	@RequestMapping(method = RequestMethod.POST, value="/product")
	public ResponseEntity<DTOUtil> createProduct(@RequestBody Product product);
}
