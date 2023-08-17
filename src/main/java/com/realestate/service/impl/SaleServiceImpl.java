package com.realestate.service.impl;

import com.realestate.entities.Sale;
import com.realestate.payload.SaleDto;
import com.realestate.repositories.ClientRegRepository;
import com.realestate.repositories.SaleRepository;
import com.realestate.service.SaleService;
import org.springframework.stereotype.Service;


@Service
public class SaleServiceImpl implements SaleService {

    private SaleRepository saleRepository;

    private ClientRegRepository clientRegRepository;

    public SaleServiceImpl(SaleRepository saleRepository, ClientRegRepository clientRegRepository) {
        this.saleRepository = saleRepository;
        this.clientRegRepository = clientRegRepository;
    }

    @Override
    public SaleDto saveSale(SaleDto saleDto) {

//        ClientReg clientReg =clientRegRepository.findById(saleDto.getId()).orElseThrow(
//                ()-> new EntityNotFoundException("Client Not found with id: "+saleDto.getId())
//        ) ;

        Sale sale = mapToEntity(saleDto);
        // sale.setClientReg(clientReg);
        Sale newSale = saleRepository.save(sale);
        return mapToDto(newSale);
    }


    @Override
    public void deleteSale(Long clientId) {
        saleRepository.deleteById(clientId);
    }


    private SaleDto mapToDto(Sale newSale) {
        SaleDto saleDto = new SaleDto();
        saleDto.setId(newSale.getId());
        saleDto.setAgentId(newSale.getAgentId());
        saleDto.setSaleDate(newSale.getSaleDate());
        //saleDto.setClientReg(newSale.getClientReg());
        //saleDto.setPropertyId(newSale.getPropertyId());

        return saleDto;

    }


    public Sale mapToEntity(SaleDto saleDto) {
        Sale sale = new Sale();
        sale.setId(saleDto.getId());
        sale.setAgentId(saleDto.getAgentId());
        // sale.setPropertyId(saleDto.getPropertyId());
        sale.setSaleDate(saleDto.getSaleDate());
        return sale;
    }


}
