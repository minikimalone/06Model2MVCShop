package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.domain.*;
import com.model2.mvc.view.product.*;

public class GetProductAction extends Action{


	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int prodNo=Integer.parseInt(request.getParameter("prodNo"));

		
		ProductService service=new ProductServiceImpl();
		
		Product product=service.getProduct(prodNo);
		
		System.out.println("GetProductAction - Product : "+product);
		
		request.setAttribute("product", product);
		
		String menu=request.getParameter("menu");
		

	return "forward:/product/getProduct.jsp"; 

}
	}