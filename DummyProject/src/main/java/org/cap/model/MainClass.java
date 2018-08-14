package org.cap.model;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainClass {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpademo");
		EntityManager entityManager = factory.createEntityManager();

		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();

		Customer customer = new Customer();

		customer.setCustomerName("Sush");
		customer.setPhoneNumber("8939787878");
		// customer.setEmailId("sush21@gmail.com");

		Address address = new Address();
		address.setCity("Chennai");
		address.setCustomer(customer);
		System.out.println("Customer id" + customer.getCustomerId());
		BankAccount bank = new BankAccount();
		bank.setBalance(1000);
		bank.setCustomer(customer);
		entityManager.persist(bank);

		Merchant merchant = new Merchant();
		merchant.setName("Sunitha");
		merchant.setCompanyName("BV Builders");
		Address address1 = new Address();
		address1.setCity("Mumbai");
		address1.setMerchant(merchant);

		Discount discount = new Discount();
		Category category = new Category();
		discount.setDiscountPercent(20);
		// discount.setCategory(category);

		category.setCategoryName("tv");
		category.setDiscount(discount);

		ManagingCart cart = new ManagingCart();
		cart.setQuantity(5);
		cart.setCustomer(customer);
	
		Inventory inventory = new Inventory();
		inventory.setProductName("Shampoo");
		inventory.setDescription("Excellant");
		//inventory.setManagingCart(cart);
		inventory.setMerchant(merchant);
		inventory.setMerchant(merchant);
		inventory.setDiscount(discount);
		inventory.setManagingCart(cart);

		Coupons coupon = new Coupons();
		coupon.setCouponDescription("good");
		inventory.setCoupon(coupon);

		ProductImages pimage = new ProductImages();
		pimage.setPriority(true);
		pimage.setInventory(inventory);

		entityManager.persist(cart);
		entityManager.persist(inventory);

		entityManager.persist(category);
		entityManager.persist(pimage);
		entityManager.persist(category);
		entityManager.persist(discount);
		entityManager.persist(coupon);
		
		
		FeedBack feedBack=new FeedBack();
		feedBack.setComments("Product is good");
		
		feedBack.setCustomer(customer);
		feedBack.setInventory(inventory);
		feedBack.setMerchant(merchant);
		Shipping shipping = new Shipping();
		System.out.println(customer.getCustomerId());
		shipping.setCustomer(customer);
		shipping.setShippingAddress(address);
		address1.setShipping(shipping);
		entityManager.persist(customer);
		entityManager.persist(address);
		entityManager.persist(shipping);
  entityManager.persist(feedBack);
		// entityManager.persist(order);

  
  
  Transaction trans=new Transaction();
  trans.setAmount(20000);
 
		// merchant.setAddress(address1);
		entityManager.persist(merchant);
		entityManager.persist(address1);
		
		
		WishList wish =new WishList();
		wish.setCustomer(customer);
		wish.setInventory(inventory);
		entityManager.persist(wish);
		
		Order order1 = new Order();
		
		order1.setCustomer(customer);
		//order1.setDeliveredDate(new Date());
		order1.setTransaction(trans);
		 
		ReturnOrders returnOrder=new ReturnOrders();
		returnOrder.setDescription("bad");
		returnOrder.setOrder(order1);
		returnOrder.setCustomer(customer);
		returnOrder.setTransaction(trans);
	//	order1.setShipping(shipping);
		
		cart.setOrder(order1);
		
		entityManager.persist(order1);
		
		shipping.setOrder(order1);
		entityManager.persist(returnOrder);
		trans.setOrder(order1);
		entityManager.persist(trans); 
		Email mail=new Email();
		entityManager.persist(mail);
		
		ForgotPassword fp=new ForgotPassword();
		entityManager.persist(fp);
		transaction.commit();

	}
}
