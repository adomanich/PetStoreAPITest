package asertions.petAssertions;

import models.CategoryModel;
import org.assertj.core.api.SoftAssertions;

public class CategoryAssert {
    SoftAssertions softAssertions = new SoftAssertions();
    private static CategoryModel actual;

    public static CategoryAssert assertThat(CategoryModel categoryModel) {
        actual = categoryModel;
        return new CategoryAssert();
    }

    private void hasId(int id) {

        int actualId = actual.getId();
        softAssertions.assertThat(actualId).as("Id").isEqualTo(id);

    }

    private void hasName(String name) {

        String actualName = actual.getName();
        softAssertions.assertThat(actualName).as("Name").isEqualTo(name);

    }

    public void isEqualTo(CategoryModel categoryModel) {
        hasId(categoryModel.getId());
        hasName(categoryModel.getName());
    }

}
