package com.example.order_rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.order_rest.business.bean.OrderBean;
import com.example.order_rest.dao.OrderDAOWrapper;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAOWrapper orderDAOWrapper;

	@Override
	public OrderBean save(OrderBean orderBean) {
		return orderDAOWrapper.save(orderBean);
	}

	@Override
	public List<OrderBean> getOrdersInBillingRange(Double minBillAmount, Double maxBillAmount) {
		return orderDAOWrapper.getOrdersInBillingRange(minBillAmount,maxBillAmount);
	}

	@Override
	public boolean updateOrderStatus(OrderBean orderBean) {
		return orderDAOWrapper.updateOrderStatus(orderBean);
	}

	@Override
	public OrderBean deleteOrder(Integer orderId) {
		return orderDAOWrapper.deleteOrder(orderId);
	}
	
}
