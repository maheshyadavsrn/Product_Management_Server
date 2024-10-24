package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Product;
import com.project.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		
		return productRepository.findById(id).get();
	}

	@Override
	public String deleteProduct(Integer id) {
		Product product=productRepository.findById(id).get();
		
		if(product!=null) {
			productRepository.delete(product);
			return "Product Delete Successfully!";
		}
		return "Somthing is wrong server";
		
	}

	@Override
	public Product editProduct(Product p, int id) {
		Product oldproduct=productRepository.findById(id).get();
		oldproduct.setProductName(p.getProductName());
		oldproduct.setDescription(p.getDescription());
		oldproduct.setPrice(p.getPrice());
		oldproduct.setStatus(p.getStatus());
		return productRepository.save(oldproduct);
	}
	
	
	

}
