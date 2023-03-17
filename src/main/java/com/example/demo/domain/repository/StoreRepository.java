package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Stores;
import com.example.demo.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Stores, Long> {
    boolean existsByNameIgnoreCase(String name);

    Page<Stores> findAllByUserId(Long userId, Pageable pageable);
}
