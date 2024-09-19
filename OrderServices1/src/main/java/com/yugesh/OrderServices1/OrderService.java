package com.yugesh.OrderServices1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    public List<Mallorder> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Mallorder> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Transactional
    public Mallorder createOrder(Mallorder order) {
        return orderRepository.save(order);
    }

    @Transactional
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public List<Mallorder> findByProductName(String productName) {
        return orderRepository.findByProductName(productName);
    }
}
