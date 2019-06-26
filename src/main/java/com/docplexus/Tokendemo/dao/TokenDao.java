package com.docplexus.Tokendemo.dao;

import java.util.List;

import com.docplexus.Tokendemo.bean.Token;

public interface TokenDao {
	public Token createToken(Token token);
	public List<Token> getToken();
	public Token findById(long id);
	public Token update(Token token, long id);
	public void deleteById(long id);
	public Token NextByPriority();
}
