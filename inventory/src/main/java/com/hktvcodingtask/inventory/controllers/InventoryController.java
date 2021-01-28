package com.hktvcodingtask.inventory.controllers;

import java.util.List;

import javax.validation.Valid;

import com.hktvcodingtask.inventory.models.Inventory;
import com.hktvcodingtask.inventory.repositories.InventoryRepository;
import com.hktvcodingtask.inventory.services.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InventoryController {

    private InventoryService inventorySer;

    @Autowired
    private InventoryRepository inventoryRepo;

    public InventoryController(InventoryService inventorySer) {
        this.inventorySer = inventorySer;
    }

    @GetMapping("/")
    public String showIndex(Model model) {
        List<Inventory> inventoryList = inventoryRepo.findAll();
        model.addAttribute("itemList", inventoryList);
        return "index";
    }

    @GetMapping("/item")
    public String showAllItems(Model model) {
        model.addAttribute("listOfItems", inventorySer.showAllUser());
        return "viewItems";
    }

    @GetMapping("/create")
    public String createForm(@ModelAttribute("itemObject") Inventory inventory) {
        return "createItem";
    }

    @PostMapping("/create")
    public String createAnItem(@Valid @ModelAttribute("itemObject") Inventory newItem, BindingResult result) {
        if (result.hasErrors()) {
            return "createItem";
        }
        inventorySer.createAItem(newItem);
        return "redirect:/item";
    }

    @GetMapping("/transferInventory/{id}")
    public String viewItemById(@PathVariable("id") Long id, Model model) {
        Inventory item = inventorySer.getByIdAnItem(id);
        model.addAttribute("aSingleItemObject", item);
        return "transferInventory";
    }

    @PostMapping("/transferInventory/{id}")
    public String transferAnItem(@PathVariable("id") Long id,
            @Valid @ModelAttribute("aSingleItemObject") Inventory updateItem, BindingResult result) {
        if (result.hasErrors()) {
            return "transferInventory";
        }
        inventorySer.updateItem(updateItem);
        return "redirect:/item";
    }

    @PostMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id) {
        inventorySer.deleteById(id);
        return "redirect:/item";
    }
}
