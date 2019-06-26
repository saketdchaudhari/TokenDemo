//package com.docplexus.Tokendemo.dao;
//
//import java.util.List;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import com.docplexus.Tokendemo.bean.Customer;
//import com.docplexus.Tokendemo.bean.Token;
//
//@Repository
//public class TokenDaoImp implements TokenDao{
//	@Autowired
//	private SessionFactory sessionFactory;
//	
//	public Integer createToken(Customer customer) {
//		 Session session = sessionFactory.getCurrentSession();
//		 session.save(customer.getId()); //required return id 
//		return null;
//	}
//	
//	public List<Token> getToken(){
//		Session session = sessionFactory.getCurrentSession();
////		session.get
//		return null;
//	}
//	
//	public Token findById(long id){
//		Session session = sessionFactory.getCurrentSession();
//		Token token=(Token) session.get(Token.class,id);
//		return token;
//	}
//	
//	public Token update(Token val, long id){
//		Session session = sessionFactory.getCurrentSession();
//		Token token =(Token)session.get(Token.class, id);
//		token.setCustomerid(val.getCustomerid());
//		session.update(token);
//		return token;
//	}
//	
//	public void deleteById(long id) {
//		Session session = sessionFactory.getCurrentSession();
//		Token token = findById(id);
//		session.delete(token);	
//	}
//	
//	@Query("select t.id from TokenInfo t join CustomerInfo c on t.customerid = c.id order by c.priorityid asc ,t.id asc limit 1 ")
//	public Token NextByPriority(){		
//		return null;
//	}
//
//	@Override
//	public Token createToken(Token token) {
//		Session session = sessionFactory.getCurrentSession();
//		return (Token) session.save(token);
//	}
//}
