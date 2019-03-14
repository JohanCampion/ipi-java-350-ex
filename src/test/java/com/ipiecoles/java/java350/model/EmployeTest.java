package com.ipiecoles.java.java350.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class EmployeTest {
    @Test
    public void testGetNombreAnneeAncienneteNow(){

        //Given
        LocalDate dateEmbauche = LocalDate.now();
        Employe employe = new Employe();
        employe.setDateEmbauche(dateEmbauche);

        //When
        Integer nbAnnee = employe.getNombreAnneeAnciennete();

        //Then
        Assertions.assertThat(nbAnnee).isEqualTo(0);


    }

}
