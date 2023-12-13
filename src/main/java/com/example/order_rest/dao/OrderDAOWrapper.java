package com.example.order_rest.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.order_rest.business.bean.OrderBean;
import com.example.order_rest.entity.OrderEntity;

@Repository
public class OrderDAOWrapper {

	@Autowired
	private OrderDAO orderDAO;

	public OrderBean save(OrderBean orderBean) {
		OrderEntity orderEntity = convertBeanToEntity(orderBean);
		OrderEntity savedOrderEntity = orderDAO.save(orderEntity);
		OrderBean savedOrderBean = convertEntityToBean(savedOrderEntity);
		return savedOrderBean;
	}

	public List<OrderBean> getOrdersInBillingRange(Double minBillAmount, Double maxBillAmount) {
		List<OrderEntity> foundOrderList = orderDAO.findByBillAmountBetween(minBillAmount, maxBillAmount);
		List<OrderBean> orders = foundOrderList.stream().map(this::convertEntityToBean).collect(Collectors.toList());
		return orders;
	}

	public boolean updateOrderStatus(OrderBean orderBean) {
		boolean flag = false;
		int orderId = orderBean.getOrderId();
		Optional<OrderEntity> foundOrderEntity = orderDAO.findById(orderId);
		if(foundOrderEntity.isPresent()) {
			OrderEntity orderEntity = convertBeanToEntity(orderBean);
			orderDAO.save(orderEntity);
			flag = true;
		}
		return flag;
	}

	public OrderBean deleteOrder(Integer orderId) {
		OrderBean removedOrderBean = null;
		Optional<OrderEntity> foundOrderEntity = orderDAO.findById(orderId);
		if(foundOrderEntity.isPresent()) {
			orderDAO.delete(foundOrderEntity.get());
			removedOrderBean = convertEntityToBean(foundOrderEntity.get());
		}
		return removedOrderBean;
	}

	private OrderBean convertEntityToBean(OrderEntity orderEntity) {
		OrderBean orderBean=new OrderBean();
		BeanUtils.copyProperties(orderEntity, orderBean);
		return orderBean;
	}
	private OrderEntity convertBeanToEntity(OrderBean orderBean) {
		OrderEntity orderEntity=new OrderEntity();
		BeanUtils.copyProperties(orderBean, orderEntity);
		return orderEntity;
	}
}