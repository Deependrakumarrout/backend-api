package com.realestate.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.realestate.entities.ClientReg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SaleDto {
    private Long id;
    private Long agentId;
    //private Long propertyId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date saleDate;

   // private ClientReg clientReg;

}
