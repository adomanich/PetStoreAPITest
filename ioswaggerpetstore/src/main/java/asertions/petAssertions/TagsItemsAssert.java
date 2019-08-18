package asertions.petAssertions;

import models.TagsItemsModel;
import org.assertj.core.api.SoftAssertions;

public class TagsItemsAssert {

    SoftAssertions softAssertions = new SoftAssertions();
    private static TagsItemsModel actual;

    public static TagsItemsAssert assertThat(TagsItemsModel tagsItemsModel) {
        actual = tagsItemsModel;
        return new TagsItemsAssert();
    }

    private void hasId(int id) {

        int actualId = actual.getId();
        softAssertions.assertThat(actualId).as("Id").isEqualTo(id);

    }

    private void hasName(String name) {

        String actualName = actual.getName();
        softAssertions.assertThat(actualName).as("Name").isEqualTo(name);

    }

    public void isEqualTo(TagsItemsModel categoryModel) {
        hasId(categoryModel.getId());
        hasName(categoryModel.getName());
        //softAssertions.assertAll();
    }

}
