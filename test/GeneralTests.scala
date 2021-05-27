import org.scalatestplus.play.PlaySpec
import play.api.libs._
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.http.Status.OK
import play.api.test.FakeRequest
import play.api.test.Helpers.{GET, contentAsString, defaultAwaitTimeout, route, status, writeableOf_AnyContentAsEmpty}

class GeneralTests extends PlaySpec with GuiceOneAppPerSuite {
  "Slick" must {
    "connect to the postgres db" in {
      val request = FakeRequest(GET, "/doSomethingWithTheDb")
      val response = route(app, request).get
      val responseStatus = status(response)
      responseStatus mustBe OK

      println(contentAsString(response))
    }
  }
}
