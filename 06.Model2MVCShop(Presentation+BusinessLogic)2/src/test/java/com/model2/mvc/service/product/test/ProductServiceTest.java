package com.model2.mvc.service.product.test;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)

////==> Meta-Data 를 다양하게 Wiring 하자...
//@ContextConfiguration(locations = { "classpath:config/context-*.xml" })
@ContextConfiguration	(locations = {	"classpath:config/context-common.xml",
																	"classpath:config/context-aspect.xml",
																	"classpath:config/context-mybatis.xml",
																	"classpath:config/context-transaction.xml" })
////@ContextConfiguration(locations = { "classpath:config/context-common.xml" })
public class ProductServiceTest {

	//==>@RunWith,@ContextConfiguration 이용 Wiring, Test 할 instance DI
	
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;

	//@Test
	public void testAddProduct() throws Exception {
		
		Product product = new Product();
		//product.setProdNo(789);
		
		product.setProdName("Phone");
		product.setProdDetail("testPhone");
		product.setManuDate("20180708");
		product.setPrice(980000);
		product.setFileName("pic");
		//product.setRegDate();
		
		productService.addProduct(product);
		
		//product = productService.getProduct(789);

		//==> console 확인
		System.out.println(product);
		
		//==> API 확인
		//Assert.assertEquals(789, product.getProdNo());
		Assert.assertEquals("Phone", product.getProdName());
		Assert.assertEquals("testPhone", product.getProdDetail());
		Assert.assertEquals("20180708", product.getManuDate());
		Assert.assertEquals(980000, product.getPrice());
		Assert.assertEquals("pic", product.getFileName());
	}
	
     	//@Test
	public void testGetProduct() throws Exception {
//		
		Product product = new Product();
//		//==> 필요하다면...
//		product.setProdNo("Phone");
//		product.setProdName("testProductName");
//		product.setPassword("testPasswd");
//		product.setSsn("1111112222222");
//		product.setPhone("111-2222-3333");
//		product.setAddr("경기도");
//		product.setEmail("test@test.com");
//		
		product = productService.getProduct(10060);
//
//		//==> console 확인
		System.out.println(product);
//		
//		//==> API 확인
//		Assert.assertEquals("testProdu", product.getProdNo());
//		Assert.assertEquals("testProductName", product.getProdtName());
//		Assert.assertEquals("testPasswd", product.getPassword());
//		Assert.assertEquals("111-2222-3333", product.getPhone());
//		Assert.assertEquals("경기도", product.getAddr());
//		Assert.assertEquals("test@test.com", product.getEmail());
//
//		Assert.assertNotNull(productService.getProduct("product02"));
//		Assert.assertNotNull(productService.getProduct("product05"));
	}
//	
     //@Test
	 public void testUpdateProduct() throws Exception{
		 
		Product product = productService.getProduct(10081);
		Assert.assertNotNull(product);
		
		
		Assert.assertEquals("Phone", product.getProdName());
		Assert.assertEquals("testPhone", product.getProdDetail());
		Assert.assertEquals("20180708", product.getManuDate());
		Assert.assertEquals(980000, product.getPrice());
		Assert.assertEquals("pic", product.getFileName());

		product.setProdName("newPhone");
		product.setProdDetail("chachachacha change");
		product.setManuDate("20190420");
		product.setPrice(1000000);
		product.setFileName("change pic");
		
		productService.updateProduct(product);
		
		product = productService.getProduct(10081);
		Assert.assertNotNull(product);
		
		//==> console 확인
		//System.out.println(product);
			
		//==> API 확인
		Assert.assertEquals("newPhone", product.getProdName());
		Assert.assertEquals("chachachacha change", product.getProdDetail());
		Assert.assertEquals("20190420", product.getManuDate());
		Assert.assertEquals(1000000, product.getPrice());
		Assert.assertEquals("change pic", product.getFileName());
	
	 }


//	 //==>  주석을 풀고 실행하면....
	 	//@Test
	 public void testGetProductListAll() throws Exception{
		 
	 	Search search = new Search();
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	Map<String,Object> map = productService.getProductList(search);
	 	
	 	List<Object> list = (List<Object>)map.get("list");
	 	Assert.assertEquals(3, list.size());
	 	
		//==> console 확인
	 	System.out.println(list);
	 	
	 	Integer totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 	
	 	System.out.println("=======================================");
	 	
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	search.setSearchCondition("0");
	 	search.setSearchKeyword("");
	 	map = productService.getProductList(search);
	 	
	 	list = (List<Object>)map.get("list");
	 	Assert.assertEquals(3, list.size());
	 	
	 	//==> console 확인
	 	//System.out.println(list);
	 	
	 	totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 }
	 
	// @Test
	 public void testGetProductListByProdNo() throws Exception{
		 
	 	Search search = new Search();
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	
	 	search.setSearchCondition("0");       //prodNo로 
	 	search.setSearchKeyword("10060");
	 	

	 	
	 	
	 	Map<String,Object> map = productService.getProductList(search);
	 	
	 	List<Object> list = (List<Object>)map.get("list");
	 	Assert.assertEquals(1, list.size());
	 	
		//==> console 확인
	 	System.out.println(list);
	 	
	 	Integer totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 	
	 	System.out.println("=======================================");
	 	
	 	search.setSearchCondition("0");
	 	search.setSearchKeyword(""+System.currentTimeMillis());       //unique한 수를 잡아내기 위해..
	 	map = productService.getProductList(search);
	 	
	 	list = (List<Object>)map.get("list");
	 	Assert.assertEquals(0, list.size());
	 	
		//==> console 확인
	 	//System.out.println(list);
	 	
	 	totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 }
	 
	 //@Test
	 public void testGetProductListByProdName() throws Exception{
		 
	 	Search search = new Search();
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	
	 	
	 	search.setSearchCondition("1");
	 	search.setSearchKeyword("123");
	 	Map<String,Object> map = productService.getProductList(search);
	 	
	 	List<Object> list = (List<Object>)map.get("list");
	 	Assert.assertEquals(3, list.size());
	 	
		//==> console 확인
	 	System.out.println(list);
	 	
	 	Integer totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 	
	 	System.out.println("=======================================");
	 	
	 	search.setSearchCondition("1");
	 	search.setSearchKeyword(""+System.currentTimeMillis());
	 	map = productService.getProductList(search);
	 	
	 	list = (List<Object>)map.get("list");
	 	Assert.assertEquals(0, list.size());
	 	
		//==> console 확인
	 	System.out.println(list);
	 	
	 	totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 }
	 
}