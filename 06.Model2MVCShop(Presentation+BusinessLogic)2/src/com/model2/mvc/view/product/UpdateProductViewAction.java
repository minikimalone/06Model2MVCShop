package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.domain.Product;

import com.model2.mvc.framework.Action;


public class UpdateProductViewAction extends Action{

	public String execute(	HttpServletRequest request, HttpServletResponse response) throws Exception {
		Product product=null;
		int prodNo=(Integer.parseInt(request.getParameter("prodNo")));
		
	
		ProductService service=new ProductServiceImpl();
		product=service.getProduct(prodNo);
		
		System.out.println("UpdateProductViewAction - Product : "+product);
		
		request.setAttribute("product", product);
		
		return "forward:/product/updateProductView.jsp"; 
}

}
