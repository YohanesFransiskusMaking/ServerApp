package com.myking.serverapp.dto.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data   
@AllArgsConstructor
@NoArgsConstructor
public class CountryRequest {
    private String countryCode;
    private String countryName;
    private Integer regionId;


}
