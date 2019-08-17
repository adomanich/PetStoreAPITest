package asertions.petAssertions;

import models.CategoryModel;
import models.PetModel;
import models.TagsItemsModel;
import org.assertj.core.api.AbstractAssert;

import java.util.List;
import java.util.Objects;

public class PetAssert extends AbstractAssert<PetAssert, PetModel> {
    private String errorMessage;

    public PetAssert(PetModel actual) {
        super(actual, PetAssert.class);
    }

    public static PetAssert assertThat(PetModel actual) {
        return new PetAssert(actual);
    }

    public PetAssert hasId(int id) {
        isNotNull();
        errorMessage = "Expecting id to be:<%s> but was: <%s>";
        int actualId = actual.getId();
        if (actualId != id) {
            failWithMessage(errorMessage, id, actualId);
        }
        return this;
    }

    public PetAssert hasName(String name) {
        isNotNull();
        errorMessage = "Expecting name to be:<%s> but was: <%s>";
        String actualName = actual.getName();
        if (!Objects.equals(actualName, name)) {
            failWithMessage(errorMessage, name, actualName);
        }
        return this;
    }

    public PetAssert hasCategory(CategoryModel categoryModel) {
        isNotNull();
        errorMessage = "Expecting category to be:<%s> but was: <%s>";
        CategoryModel actualCategory = actual.getCategory();
        if (!actualCategory.equals(categoryModel)) {
            failWithMessage(errorMessage, categoryModel, actualCategory);
        }
        return this;
    }

    public PetAssert hasListOfPhotoUrls(List<String> photooUrls) {

        isNotNull();
        errorMessage = "Expecting photoUrls to be:<%s> but was:<%s>";
        List<String> actualPhotoUrls = actual.getPhotoUrls();
        if (!actualPhotoUrls.equals(photooUrls)) {
            failWithMessage(errorMessage, photooUrls, actualPhotoUrls);
        }

        return this;

    }

    public PetAssert hasListOfTagsItems(List<TagsItemsModel> tagsItemsModelList) {
        isNotNull();
        errorMessage = "Expecting tagsItemsModelUrls to be:<%s> but was: <%s>";
        List<TagsItemsModel> actualTagsItemsList = actual.getTagsItems();
        for (int i = 0; i < actualTagsItemsList.size(); i++) {
            if (!actualTagsItemsList.get(i).equals(tagsItemsModelList.get(i))) {
                failWithMessage(errorMessage, tagsItemsModelList, actualTagsItemsList);
            }
        }
        return this;
    }


    public PetAssert hasStatus(String status) {
        isNotNull();
        errorMessage = "Expecting status to be: <%s> but was: <%s>";
        String actualStatus = actual.getStatus();
        if (!actualStatus.equals(status)) {
            failWithMessage(errorMessage, status, actualStatus);
        }
        return this;
    }


    public PetAssert isEqualTo(PetModel petModel) {
        hasId(petModel.getId());
        hasCategory(petModel.getCategory());
        hasName(petModel.getName());
        hasListOfPhotoUrls(petModel.getPhotoUrls());
        hasListOfTagsItems(petModel.getTagsItems());
        hasStatus(petModel.getStatus());

        return this;
    }
}

