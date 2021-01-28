package com.hktvcodingtask.inventory.services;

import java.util.List;
import java.util.Optional;

import com.hktvcodingtask.inventory.models.Inventory;
import com.hktvcodingtask.inventory.repositories.InventoryRepository;

import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private InventoryRepository inventoryRepo;

    public InventoryService(InventoryRepository initialInventoryRepo) {
        this.inventoryRepo = initialInventoryRepo;
    }

    public List<Inventory> showAllUser() {
        return inventoryRepo.findAll();
    }

    public void createAItem(Inventory newInventory) {
        inventoryRepo.save(newInventory);
    }

    public Inventory getByIdAnItem(Long id) {
        Optional<Inventory> anItem = inventoryRepo.findById(id);
        if (anItem.isPresent()) {
            return anItem.get();
        }
        return null;
    }

    public void updateItem(Inventory newItem) {
        inventoryRepo.save(newItem);
    }

    public void deleteById(Long id) {
        inventoryRepo.deleteById(id);
    }
}
