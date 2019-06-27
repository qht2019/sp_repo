package com.tedu.sp09.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tedu.sp01.pojo.Item;
import com.tedu.web.util.JsonResult;

//通过指定服务id,可以知道向那一台主机来转发调用
//localhost:8001,localhost:8002
@FeignClient(name="item-service",fallback=ItemFeignServerFB.class)
public interface ItemFeignService {
	/**
	 *	Feign利用springmvc注解 来反向生成访问路径
	 *	根据在mapping中指定的路径,在主机地址后面拼接路径
	 *	http://localhost:8001/{orderd}	I
	 *	http://localhost:3001/item-server/34
	 *	根据@PathVariable配置,把参数数据,拼接到路径当中
	 *	假设参数是"123",主机后边跟/123
	 */
	@GetMapping("/{orderId}")
	JsonResult<List<Item>> getItems(@PathVariable String orderId);

	@PostMapping("/decreaseNumber")
	JsonResult decreaseNumber(@RequestBody List<Item> items);
}
