package com.model2.mvc.service.product.impl;

import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.dao.ProductDAO;
import com.model2.mvc.service.domain.*;


public class ProductServiceImpl implements ProductService{
	
	private ProductDAO productDAO;
	
	public ProductServiceImpl() {
		this.productDAO=new ProductDAO();
		
	}

	public void addProduct(Product productVO) throws Exception {
		
	try {
		productDAO.insertProduct(product);
	} catch (Exception e) {
		throw e;
	}
	return productVO;
}


	public Product getProduct(int prodNo) throws Exception {
	
	try {
		return productDAO.findProduct(prodNo);
	} catch (Exception e) {
		throw e;
	}
}

	public Map<String,Object> getProductList(Search searchVO) throws Exception {
	}
	try {
		return productDAO.getProductList(searchVO);
	} catch (Exception e) {
		throw e;
	}
}
	public void updateProduct(Product productVO) throws Exception {

	try {
		productDAO.updateProduct(productVO);
	} catch (Exception e) {
		throw e;
	}
	return userVO;
}
}
