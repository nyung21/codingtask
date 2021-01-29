package com.hktvcodingtask.inventory.controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import javax.validation.Valid;

import com.hktvcodingtask.inventory.helpers.csvHelper;
import com.hktvcodingtask.inventory.messages.ResponseMessage;
import com.hktvcodingtask.inventory.models.Inventory;
import com.hktvcodingtask.inventory.repositories.InventoryRepository;
import com.hktvcodingtask.inventory.services.InventoryService;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class InventoryController {

    @Autowired
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
    public String showAllItems(@ModelAttribute("itemObject") Inventory inventory, Model model) {
        model.addAttribute("listOfItems", inventorySer.showAllItems());
        return "viewItems";
    }

    @PostMapping("/item")
    public String searchItem(@Valid @ModelAttribute("itemObject") Inventory newItem, BindingResult result) {
        if (result.hasErrors()) {
            return "";
        }
        inventorySer.createAItem(newItem);
        return "redirect:/item";
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

    @GetMapping("/upload")
    public String uploadForm(@RequestParam("file") MultipartFile file) {
        return "upload";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
        // if (file.isEmpty()) {
        // model.addAttribute("message", "Please select a CSV file to upload.");
        // model.addAttribute("status", false);
        // } else {

        // // parse CSV file to create a list of objects
        // try (Reader reader = new BufferedReader(new
        // InputStreamReader(file.getInputStream()))) {

        // // create csv bean reader
        // CsvToBean<Inventory> csvToBean = new
        // CsvToBeanBuilder(reader).withType(Inventory.class)
        // .withIgnoreLeadingWhiteSpace(true).build();

        // // convert `CsvToBean` object to list
        // List<Inventory> inventories = csvToBean.parse();

        // // TODO: save users in DB?

        // // save list on model
        // model.addAttribute("inventories", inventories);
        // model.addAttribute("status", true);

        // } catch (Exception ex) {
        // model.addAttribute("message", "An error occurred while processing the CSV
        // file.");
        // model.addAttribute("status", false);
        // }
        // }

        String message = "";

        if (csvHelper.hasCSVFormat(file)) {
            try {
                inventorySer.saveCsv(file);
                return "redirect:/item";
                // message = "Uploaded the file successfully: " + file.getOriginalFilename();
                // return ResponseEntity.status(HttpStatus.OK).body(new
                // ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return "upload";
                // return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new
                // ResponseMessage(message));
            }
        }

        message = "Please upload a csv file!";
        // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new
        // ResponseMessage(message));
        return "upload";
    }

    @GetMapping("/inventories")
    public ResponseEntity<List<Inventory>> getAllInventories() {
        try {
            List<Inventory> inventories = inventorySer.getAllInventories();

            if (inventories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(inventories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
