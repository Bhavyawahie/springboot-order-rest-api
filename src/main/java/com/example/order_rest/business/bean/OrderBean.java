package com.example.order_rest.business.bean;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.example.order_rest.validator.OrderStatusValidator;
import org.hibernate.validator.constraints.Range;

public class OrderBean {
	private Integer orderId;
	@OrderStatusValidator(message = "{OrderStatusValidator.orderBean.status}")
	private String status;
	@NotEmpty(message = "{NotEmpty.orderBean.productName}")
	private String productName;
	@NotNull(message = "{NotNull.orderBean.quantity}")
	@Range(min = 1, max = 10, message = "{Range.orderBean.quantity}")
	private Integer quantity;
	@NotNull(message = "{NotNull.orderBean.billAmount}")
	private Double billAmount;
	
	public OrderBean() {
	}

	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}
}
