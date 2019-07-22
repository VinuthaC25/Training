package com.mphasis.cart.bo;

import com.mphasis.cart.beans.CartAUser;
import com.mphasis.cart.exceptions.BusinessException;

public interface CartAUserBo {
	
	public void register(CartAUser user)throws BusinessException;
	public int changePassword(String email, String oldpass, String newpass) throws BusinessException;
	public CartAUser login(String email, String pass);
	
	
	
}
