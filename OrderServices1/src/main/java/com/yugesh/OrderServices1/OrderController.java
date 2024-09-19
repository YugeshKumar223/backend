package com.yugesh.OrderServices1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    @GetMapping("/Mallorder")
    public ResponseEntity<List<Mallorder>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/Mallorder/{id}")
    public ResponseEntity<Mallorder> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/Mallorder")
    public ResponseEntity<Mallorder> createOrder(@RequestBody Mallorder order) {
        Mallorder createdOrder = orderService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @DeleteMapping("/Mallorder/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/Mallorder/search")
    public ResponseEntity<List<Mallorder>> getOrdersByProductName(@RequestParam String productName) {
        return ResponseEntity.ok(orderService.findByProductName(productName));
    }
}
