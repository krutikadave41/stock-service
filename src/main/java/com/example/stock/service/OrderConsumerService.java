package com.example.stock.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.base.dto.OrderEvent;
import com.example.stock.entity.Order;
import com.example.stock.repository.OrderRepository;

@Service
public class OrderConsumerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumerService.class);
	
	private OrderRepository orderRepository;
	
	
	public OrderConsumerService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}


	@KafkaListener(topics="${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(OrderEvent orderEvent) {
		
		LOGGER.info(String.format("Order Received in stock service:: %s", orderEvent.toString()));
		// save Order data into database
		Order order = new Order();
		order.setName(orderEvent.getOrder().getName());
		order.setPrice(orderEvent.getOrder().getPrice());
		order.setPrice(orderEvent.getOrder().getPrice());
		orderRepository.save(order);
	}
}
