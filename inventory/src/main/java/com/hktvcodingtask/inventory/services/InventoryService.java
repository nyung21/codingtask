package com.hktvcodingtask.inventory.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.hktvcodingtask.inventory.helpers.csvHelper;
import com.hktvcodingtask.inventory.models.Inventory;
import com.hktvcodingtask.inventory.repositories.InventoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepo;

    public InventoryService(InventoryRepository initialInventoryRepo) {
        this.inventoryRepo = initialInventoryRepo;
    }

    public List<Inventory> showAllItems() {
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

    public void saveCsv(MultipartFile file) {
        try {
            List<Inventory> inventory = csvHelper.csvToInventories(file.getInputStream());
            inventoryRepo.saveAll(inventory);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public ByteArrayInputStream loadCsv() {
        List<Inventory> tutorials = inventoryRepo.findAll();

        ByteArrayInputStream in = csvHelper.inventoryToCSV(tutorials);
        return in;
    }

    public List<Inventory> getAllInventories() {
        return inventoryRepo.findAll();
    }
}
