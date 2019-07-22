package com.mphasis.cart.bo;

import com.mphasis.cart.beans.CartAUser;
import com.mphasis.cart.dao.CartAUserDao;
import com.mphasis.cart.dao.CartAUserDaoImpl;
import com.mphasis.cart.exceptions.BusinessException;

public class CartAUserBoImpl implements CartAUserBo {
	
	CartAUserDao cartAUserDao;
	
	public CartAUserBoImpl() {
		
		cartAUserDao = new CartAUserDaoImpl();
		
	}
	@Override
	public void register(CartAUser user) throws BusinessException{
		
		if(user.getGender().matches("[mMfF]{1}"))
		{
			cartAUserDao.register(user);
		}
		else 
		{
			throw new BusinessException("Invalid gender");
		}

	}

	@Override
	public int changePassword(String email, String oldpas,String newpas) throws BusinessException{
		int i=0;
		if(!oldpas.equals(newpas)) 
		{
			i=cartAUserDao.changePassword(email,oldpas, newpas);
		}
		else 
		{
			throw new BusinessException("Old and New password should not be same");
		}
		return i;
	}


	@Override
	public CartAUser login(String email, String pass) {
		
		return cartAUserDao.login(email, pass);
		
	}


	
}
