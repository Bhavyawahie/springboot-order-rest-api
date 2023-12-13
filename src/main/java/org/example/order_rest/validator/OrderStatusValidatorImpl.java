package org.example.order_rest.validator;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OrderStatusValidatorImpl implements ConstraintValidator<OrderStatusValidator, String>{//name of the related annotation
	@Override
	public void initialize(OrderStatusValidator arg0) { 
	}
	@Override
	public boolean isValid(String orderStatus, ConstraintValidatorContext arg1) {
		orderStatus=orderStatus.toUpperCase();
		switch (orderStatus) {
		case "INTRANSIT":
		case "CONFIRMED":
		case "OUTFORDELIVERY":
		case "DELIVERED":
		case "DISPATCHED":
			return true;
		default:
			return false;
		}
	}
}
