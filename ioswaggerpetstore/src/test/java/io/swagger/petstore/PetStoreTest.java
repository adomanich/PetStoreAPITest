package io.swagger.petstore;

import asertions.petAssertions.PetAssert;
import business.petBL.PetCreateBL;
import business.petBL.PetUpdateBL;
import client.pet.PetServices;
import io.restassured.response.Response;
import models.PetModel;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class PetStoreTest extends PetServices {
    private static PetModel testPetOne;
    private PetModel testPetTwo;


    @BeforeSuite
    public static void setUp() {
        System.out.println("Before all");
        testPetOne = new PetCreateBL().createPet();
    }

    @Test(priority = 1)
    public void addNewPetTest() {
        Response response = addNewPet(testPetOne);
        PetModel newPet = new PetCreateBL().createPet();
        PetAssert.assertThat(response.getBody().as(PetModel.class)).isEqualTo(newPet);

    }

    @Test(priority = 2)
    public void getPetTest() {
        Response response = getPetByID(testPetOne.getId());
        assertEquals(200, response.getStatusCode());
    }

    @Test(priority = 5)
    public void getPetByStatusTest() {
        Response response = getPetByStatus(PetModel.Status.PENDING.getValue());
        assertEquals(200, response.getStatusCode());

    }

    @Test(priority = 3)
    public void updatePetTest() {
        System.out.println(" updatePetTest");
        testPetTwo = new PetUpdateBL().doUpdate(testPetOne.getId());
        Response response = updatePet(testPetTwo);
        PetAssert.assertThat(response.getBody().as(PetModel.class))
                .hasId(testPetTwo.getId())
                .hasCategory(testPetTwo.getCategory());

    }

    @Test(priority = 4)
    public void deletePetTest() {
        System.out.println(" deletePetTest");
        Response response = deletePet(testPetOne.getId());
        assertEquals(200, response.getStatusCode());
    }
}


