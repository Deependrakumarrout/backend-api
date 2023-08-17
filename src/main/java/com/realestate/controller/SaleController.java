package com.realestate.controller;

import com.realestate.payload.SaleDto;
import com.realestate.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    // http://localhost:8080/api/sales/sale

    @Autowired
    SaleService service;

    @PostMapping("/sale")
    public ResponseEntity<SaleDto> createSale(@RequestBody SaleDto saleDto) {
        SaleDto saleDto1 = service.saveSale(saleDto);
        return new ResponseEntity<>(saleDto1, HttpStatus.CREATED);
    }


    @DeleteMapping("/sale/{id}")
    public ResponseEntity<String> deleteSale(@PathVariable("id") Long clientId) {
        service.deleteSale(clientId);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }


}
