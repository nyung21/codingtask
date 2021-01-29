package com.hktvcodingtask.inventory.helpers;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hktvcodingtask.inventory.models.Inventory;

public class csvHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = { "name", "code", "weight", "TKO", "CWB", "TSW" };

    public static boolean hasCSVFormat(MultipartFile file) {
        if (TYPE.equals(file.getContentType()) || file.getContentType().equals("application/vnd.ms-excel")) {
            return true;
        }

        return false;
    }

    public static List<Inventory> csvToInventories(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                CSVParser csvParser = new CSVParser(fileReader,
                        CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Inventory> itemList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Inventory inventory = new Inventory(csvRecord.get("name"), csvRecord.get("code"),
                        Integer.parseInt(csvRecord.get("weight")), Integer.parseInt(csvRecord.get("TKO")),
                        Integer.parseInt(csvRecord.get("CWB")), Integer.parseInt(csvRecord.get("TSW")));

                itemList.add(inventory);
            }

            return itemList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static ByteArrayInputStream inventoryToCSV(List<Inventory> itemList) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
                CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (Inventory inventory : itemList) {
                List<Object> data = Arrays.asList(inventory.getName(), inventory.getCode(),
                        Integer.valueOf(inventory.getWeight()), Integer.valueOf(inventory.getTKO()),
                        Integer.valueOf(inventory.getCWB()), Integer.valueOf(inventory.getTSW()));

                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }
}
