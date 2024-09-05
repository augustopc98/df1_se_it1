package com.example.demo.repositories;

import com.example.demo.entities.CustomOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomOrderRepository extends JpaRepository<CustomOrder, Long> {
}
