package asertions.petAssertions;

import models.CategoryModel;
import models.PetModel;
import models.TagsItemsModel;
import org.assertj.core.api.SoftAssertions;

import java.util.List;


public class PetAssert {

    private static PetModel actual;
    SoftAssertions softAssertions = new SoftAssertions();


    public static PetAssert assertThat(PetModel petModel) {
        actual = petModel;
        return new PetAssert();
    }

    public PetAssert hasId(int id) {

        int actualId = actual.getId();
        softAssertions.assertThat(actualId).as("Id").isEqualTo(id);
        return this;

    }

    public PetAssert hasName(String name) {
        String actualName = actual.getName();
        softAssertions.assertThat(actualName).as("Name").isEqualTo(name);
        return this;
    }

    public PetAssert hasCategory(CategoryModel categoryModel) {

        CategoryModel actualCategory = actual.getCategory();
        CategoryAssert.assertThat(actualCategory).isEqualTo(categoryModel);

        return this;
    }

    public PetAssert hasListOfPhotoUrls(List<String> photooUrls) {

        List<String> actualPhotoUrls = actual.getPhotoUrls();
        softAssertions.assertThat(actualPhotoUrls).as("PhotoUrls").isEqualTo(photooUrls);
        return this;

    }

    public PetAssert hasListOfTagsItems(List<TagsItemsModel> tagsItemsModelList) {


        List<TagsItemsModel> actualTagsItemsList = actual.getTagsItems();
        for (int i = 0; i < actualTagsItemsList.size(); i++) {
            TagsItemsAssert.assertThat(actualTagsItemsList.get(i)).isEqualTo(tagsItemsModelList.get(i));
        }
        return this;
    }


    public PetAssert hasStatus(String status) {
        String actualStatus = actual.getStatus();
        softAssertions.assertThat(actualStatus).as("Status").isEqualTo(status);
        return this;
    }


    public PetAssert isEqualTo(PetModel petModel) {
        hasId(petModel.getId());
        hasName(petModel.getName());
        hasCategory(petModel.getCategory());
        hasListOfPhotoUrls(petModel.getPhotoUrls());
        hasListOfTagsItems(petModel.getTagsItems());
        hasStatus(petModel.getStatus());
        softAssertions.assertAll();
        return this;
    }
}

