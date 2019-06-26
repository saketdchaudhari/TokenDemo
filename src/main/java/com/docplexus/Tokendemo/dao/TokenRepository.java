package com.docplexus.Tokendemo.dao;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.docplexus.Tokendemo.bean.Token;

@Repository
@Transactional
public interface TokenRepository extends JpaRepository<Token, Long> {
//    @Query("SELECT con FROM Contact con  WHERE con.phoneType=(:pType) AND con.lastName= (:lName)")
//    List<Token> findByLastNameAndPhoneType(@Param("pType") Token pType, @Param("lName") String lName);
	
	@Query("SELECT token FROM Token token WHERE token.creationDate=(:date)")
	List<Token> findAllByCreationDate(@Param("date") Date date);
	
	@Query("SELECT token FROM Token token WHERE token.status = 'A' order by token.creationTime")
	Token findByStatusAndPriority();
	
	Token saveAndFlush(Token token);
}