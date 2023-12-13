package com.example.order_rest.service;

import java.util.List;

import com.example.order_rest.business.bean.OrderBean;

public interface OrderService {
	OrderBean save(OrderBean customerBean);
	List<OrderBean> getOrdersInBillingRange(Double minBillAmount, Double maxBillAmount);
	boolean updateOrderStatus(OrderBean orderBean);
	OrderBean deleteOrder(Integer orderId);
}
