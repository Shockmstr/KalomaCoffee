package vn.fpt.edu.service;

import vn.fpt.edu.entity.CheckoutEntity;

public interface CheckoutService {
	public CheckoutEntity getCheckout(int id) throws Exception;
	public CheckoutEntity createCheckout(CheckoutEntity entity) throws Exception;
	public CheckoutEntity updateCheckout(int id, CheckoutEntity entity) throws Exception;
	public void deleteCheckout(int id) throws Exception;
}
