package com.yugesh.OrderServices1;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Mallorder, Long> {
    List<Mallorder> findByProductName(String productName);
}
