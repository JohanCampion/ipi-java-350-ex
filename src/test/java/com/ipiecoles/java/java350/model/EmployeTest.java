package com.ipiecoles.java.java350.model;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

public class EmployeTest {

    @Test
    public void getNombreAnneeAncienneteNow(){
        //Given
        Employe e = new Employe();
        e.setDateEmbauche(LocalDate.now());

        //When
        Integer anneeAnciennete = e.getNombreAnneeAnciennete();

        //Then
        Assertions.assertEquals(0, anneeAnciennete.intValue());
    }

    @Test
    public void getNombreAnneeAncienneteNminus2(){
        //Given
        Employe e = new Employe();
        e.setDateEmbauche(LocalDate.now().minusYears(2L));

        //When
        Integer anneeAnciennete = e.getNombreAnneeAnciennete();

        //Then
        Assertions.assertEquals(2, anneeAnciennete.intValue());
    }

    @Test
    public void getNombreAnneeAncienneteNull(){
        //Given
        Employe e = new Employe();
        e.setDateEmbauche(null);

        //When
        Integer anneeAnciennete = e.getNombreAnneeAnciennete();

        //Then
        Assertions.assertEquals(0, anneeAnciennete.intValue());
    }

    @Test
    public void getNombreAnneeAncienneteNplus2(){
        //Given
        Employe e = new Employe();
        e.setDateEmbauche(LocalDate.now().plusYears(2L));

        //When
        Integer anneeAnciennete = e.getNombreAnneeAnciennete();

        //Then
        Assertions.assertEquals(0, anneeAnciennete.intValue());
    }

    @ParameterizedTest
    @CsvSource({
            "1, 'T12345', 0, 1.0, 1000.0",
            "1, 'T12345', 2, 0.5, 600.0",
            "1, 'T12345', 2, 1.0, 1200.0",
            "2, 'T12345', 0, 1.0, 2300.0",
            "2, 'T12345', 1, 1.0, 2400.0",
            "1, 'M12345', 0, 1.0, 1700.0",
            "1, 'M12345', 5, 1.0, 2200.0",
            "2, 'M12345', 0, 1.0, 1700.0",
            "2, 'M12345', 8, 1.0, 2500.0"
    })
    public void getPrimeAnnuelle(Integer performance, String matricule, Long nbYearsAnciennete, Double tempsPartiel, Double primeAnnuelle){
        //Given
        Employe employe = new Employe("Doe", "John", matricule, LocalDate.now().minusYears(nbYearsAnciennete), Entreprise.SALAIRE_BASE, performance, tempsPartiel);

        //When
        Double prime = employe.getPrimeAnnuelle();

        //Then
        Assertions.assertEquals(primeAnnuelle, prime);

    }
    @Test
    public void augmenterSalaire50() {
        //Given
        Employe employe = new Employe();
        employe.setSalaire(1256.00);

        //When
        employe.augmenterSalaire(50.00);

        //Then
        Assertions.assertEquals(1884.00,employe.getSalaire().doubleValue());

    }
    @Test
    public void augmenterSalaire0() {
        //Given
        Employe employe = new Employe();
        employe.setSalaire(1500.00);

        //When
        employe.augmenterSalaire(0);

        //Then
        Assertions.assertEquals(1500,employe.getSalaire().doubleValue());

    }
    @Test
    public void augmenterSalaire(){
        //Given
        Employe employe = new Employe();
        employe.setSalaire(100.00);

        //When
        employe.augmenterSalaire(2.60);

        //Then
        Assertions.assertEquals(102.60,employe.getSalaire().doubleValue());

    }

    @Test
    public void augmenterSalaireNull(){
        //Given
        Employe employe = new Employe();
        employe.setSalaire(null);
        //When
        employe.augmenterSalaire(50);

        //Then
        Assertions.assertEquals(0,employe.getSalaire().doubleValue());
    }

    @Test
    public void augmenterSalaireWithNegativeParameter(){
        //Given
        Employe employe = new Employe();
        employe.setSalaire(1500.00);

        //When
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,() -> employe.augmenterSalaire(-15.5));

        //Then
        Assert.assertEquals("Le pourcentage d'augmentation ne peut pas être négative !",e.getMessage());

    }

    @ParameterizedTest
    @CsvSource({
            "2019-01-01,1,8",
            "2021-01-01,1,10",
            "2022-01-01,1,10",
            "2022-01-01,0.5,5",
            "2032-01-01,1,11"
    })
    public void getNbRTT(LocalDate d,double tempPartiel,int RttExpect){
        //Given
        Employe employe = new Employe("Doe", "Jhon", "T00001", LocalDate.now(),Entreprise.SALAIRE_BASE, 1,tempPartiel);

        //When
        int RttCalculated = employe.getNbRtt(d);

        //Then
        Assertions.assertEquals(RttCalculated, RttExpect);

    }





}
