package business.petBL;

import client.pet.PetServices;
import io.restassured.response.Response;
import models.PetModel;

public class PetFromJsonBL {
    private Response response;

    public PetModel fromJson(int id) {
        response = new PetServices().getPetByID(id);
        PetModel newPet = response.as(PetModel.class);
        return newPet;
    }
}
