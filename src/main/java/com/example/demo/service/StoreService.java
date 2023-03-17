package com.example.demo.service;

import com.example.demo.domain.entity.Stores;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.repository.StoreRepository;
import com.example.demo.service.exception.ConflictException;
import com.example.demo.service.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public void saveStore(Stores store) {
        if (storeRepository.existsByNameIgnoreCase(store.getName())){
            throw new ConflictException("Store already exist!");
        }
       storeRepository.save(store);
    }
    public Stores findById(Long id) {
        return storeRepository.findById(id).orElseThrow(() -> new NotFoundException("Store not found."));
    }

    public void deleteStore(Long id) {
        var store = findById(id);
        storeRepository.delete(store);
    }

    public Page<Stores> findAllManagerStores(Long userId, Pageable pageable) {
        return storeRepository.findAllByUserId(userId, pageable);
    }

}