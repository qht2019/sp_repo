package com.tedu.sp09.service;

import org.springframework.stereotype.Component;

import com.tedu.sp01.pojo.Order;
import com.tedu.web.util.JsonResult;
@Component
public class OrderFeignServiceFB implements OrderFeignService{
	
	@Override
	public JsonResult addOrder() {
		return JsonResult.err("保存订单失败");
	}
	
	@Override
	public JsonResult<Order> getOrder(String orderId) {
		return JsonResult.err("无法获取订单数据");
	}
}
