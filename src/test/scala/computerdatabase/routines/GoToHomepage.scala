package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object GoToHomepage {

  private val successStatusCode = 200

  val goToHomepage = exec(
    http("Go to homepage")
      .get("/")
      .check(status.is(successStatusCode))
  )
}
