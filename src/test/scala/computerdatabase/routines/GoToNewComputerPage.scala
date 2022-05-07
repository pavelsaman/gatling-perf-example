package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object GoToNewComputerPage {

  private val endpoint = "/computers/new"
  private val successStatusCode = 200

  val goToNewComputerPage = exec(
    http("Go to new computer page")
      .get(s"$endpoint")
      .check(status.is(successStatusCode))
    )
}
