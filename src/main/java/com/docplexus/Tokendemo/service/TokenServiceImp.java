package com.docplexus.Tokendemo.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.docplexus.Tokendemo.bean.Token;
import com.docplexus.Tokendemo.dao.TokenRepository;

@Service
@Transactional
public class TokenServiceImp implements TokenService {

	// @Autowired
	// TokenDao tokenDao;

	@Autowired
	TokenRepository tokenRepository;

	public Token createToken(long userId) {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		Token token = new Token();
		token.setStatus("A");
		token.setCreationDate(date);
		token.setCustomerid(userId);

		List<Token> tokens = tokenRepository.findAllByCreationDate(new Date());
		if (null == tokens) {
			token.setTokenNumber(1);
		} else {
			token.setTokenNumber(tokens.size() + 1);
		}
		return tokenRepository.saveAndFlush(token);
	}

	// public List<Token> getToken() {
	// // TODO Auto-generated method stub
	// return tokenDao.getToken();
	// }
	//
	// public Token findById(long id) {
	// // TODO Auto-generated method stub
	// return tokenDao.findById(id);
	// }
	//
	// public Token update(Token token, long id) {
	// // TODO Auto-generated method stub
	// return tokenDao.update(token, id);
	// }
	//
	// public void deleteUserById(int id) {
	// tokenDao.deleteById(id);
	// }
	//
	 public Token nextByPriority(int counter) {
		 Token nextToken = null;
		 List<Token> tokens = tokenRepository.findByStatusAndPriority();
		 System.out.println("tokens :: " + tokens);
		 for (Token token : tokens) {
			 System.out.println("token :: " + token);
			 token.setCounterNumber(counter);
			 token.setStatus("P");
			 nextToken = token;
			 break;
		 }
		 System.out.println("nextToken :: " + nextToken);
		 return nextToken;
	 }

}
