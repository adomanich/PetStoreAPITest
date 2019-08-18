package client.pet;

import client.BaseSetUp;
import client.ClassForPath;
import io.restassured.response.Response;
import models.PetModel;

import static io.restassured.RestAssured.given;

public class PetServices extends BaseSetUp {


    public PetServices() {
        super(ClassForPath.petUrl);
    }

    protected Response addNewPet(PetModel pet) {
        return given(createRequest())
                .body(pet)
                .post();
    }

    public Response getPetByID(int id) {
        return given(createRequest())
                .get("" + id);
    }

    public Response getPetByStatus(String status) {
        return given(createRequest())
                .get(ClassForPath.petFindByStatusPath + status);
    }

    protected Response updatePet(PetModel pet) {
        return given(createRequest())
                .body(pet)
                .put();
    }

    protected Response deletePet(int id) {
        return given(createRequest())
                .delete("" + id);
    }
}