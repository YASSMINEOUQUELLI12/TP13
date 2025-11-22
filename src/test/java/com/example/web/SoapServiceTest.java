package com.example.web;

import com.example.web.entities.TypeCompte;
import com.example.web.Ws.CompteSoapService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SoapServiceTest {

    @Autowired
    private CompteSoapService compteSoapService;

    @Test
    void testCreateAndGetCompte() {

        var compte = compteSoapService.createCompte(1000.0, TypeCompte.COURANT);

        assertThat(compte).isNotNull();
        assertThat(compte.getId()).isNotNull();


        var loaded = compteSoapService.getCompteById(compte.getId());
        assertThat(loaded).isNotNull();
        assertThat(loaded.getSolde()).isEqualTo(1000.0);
    }
}





