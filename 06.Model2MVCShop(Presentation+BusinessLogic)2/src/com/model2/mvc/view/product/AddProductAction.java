package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.domain.*;


public class AddProductAction extends Action {

	@Override
	public String execute(HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		Product product=new Product();
		
		
		String s =request.getParameter("manuDate");
		String ss []=s.split("-");
		String manud= ss[0]+ss[1]+ss[2];
		
		
		//product.setProdNo(Integer.parseInt(request.getParameter("prodNo"))); 
		product.setProdName(request.getParameter("prodName"));
		product.setProdDetail(request.getParameter("prodDetail"));
		product.setManuDate(manud);
		product.setPrice(Integer.parseInt(request.getParameter("price")));
		product.setFileName(request.getParameter("fileName"));
	
		System.out.println(product);
		
		ProductService service=new ProductServiceImpl();
		service.addProduct(product);
		request.setAttribute("product",product);                        //Ãß°¡ ***********
		
		
		
		return "forward:/product/addProduct.jsp";
	}
}