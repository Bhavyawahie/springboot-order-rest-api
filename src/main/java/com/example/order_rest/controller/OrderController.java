package com.example.order_rest.controller;

import com.example.order_rest.business.bean.OrderBean;
import com.example.order_rest.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/order/controller")
public class OrderController {
	@Autowired
	private OrderServiceImpl orderService;

	@PostMapping(value="addOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addOrder(@RequestBody @Valid OrderBean orderBean, Errors errors) {
		if(errors.hasErrors()) {
			return new ResponseEntity<String>(errors.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
		}
		 	OrderBean savedOrderBean = orderService.save(orderBean);
			return new ResponseEntity<String>("Order Added Successfully with OrderId: " + savedOrderBean.getOrderId(), HttpStatus.CREATED);
	}

	@GetMapping(value = "getOrdersInBillingRange/{minBillAmount}--{maxBillAmount}", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<List<OrderBean>> getOrdersInBillingRange(@PathVariable("minBillAmount") Double minBillAmount, @PathVariable("maxBillAmount") Double maxBillAmount) {
		List<OrderBean> orders = orderService.getOrdersInBillingRange(minBillAmount, maxBillAmount);
		if(orders == null) {
			return new ResponseEntity<List<OrderBean>>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<OrderBean>>(orders, HttpStatus.OK);
	}

	@PutMapping(value = "updateOrderStatus", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateOrderStatus(@RequestBody @Valid OrderBean orderBean, Errors errors) {
		if(errors.hasErrors()) {
			return new ResponseEntity<String>(errors.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
		}
		boolean flag = orderService.updateOrderStatus(orderBean);
		if(!flag) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("Order status updated succesfully", HttpStatus.OK );
	}

	@DeleteMapping("deleteOrder/{id}")
	public ResponseEntity<OrderBean> deleteOrder(@PathVariable("id") int orderId) {
		OrderBean deletedOrderBean = orderService.deleteOrder(orderId);
		if(deletedOrderBean == null) {
			return new ResponseEntity<OrderBean>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<OrderBean>(deletedOrderBean, HttpStatus.OK);
	}
}
