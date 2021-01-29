package com.hktvcodingtask.inventory.repositories;

import com.hktvcodingtask.inventory.models.Inventory;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Long> {

    List<Inventory> findAll();

    Optional<Inventory> findById(Long id);

    Optional<Inventory> findByCode(String code);
}