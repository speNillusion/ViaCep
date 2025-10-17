package org.cep;

import org.cep.service.ApiService;
import org.cep.service.dto.AdressDTO;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ApiService api = new ApiService();
        Object adress;

        try {
            AdressDTO adressDTO = api.getAdress("38425500");
            System.out.println(adressDTO.getDdd());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}