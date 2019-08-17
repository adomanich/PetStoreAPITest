//package asertions;
//
//
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import org.assertj.core.api.SoftAssertions;
//
//public class BaseAssert {
//    private Response response;
//    public SoftAssertions softAssertions;
//
//    public BaseAssert(Response response) {
//        this.response = response;
//        softAssertions = new SoftAssertions();
//    }
//
//    public void baseAssertions() {
//        softAssertions.assertThat(response.getStatusCode()).isEqualTo(200);
//        softAssertions.assertThat(response.getContentType()).isEqualTo(ContentType.JSON);
//    }
//}
