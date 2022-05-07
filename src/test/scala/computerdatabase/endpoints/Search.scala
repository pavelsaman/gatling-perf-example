package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Search {

  private val endpoint = "/computers"
  private val successStatusCode = 200

  val search = exec(
    http("Search for #{computerName}")
      .get(s"/${endpoint}?f=#{computerName}")
      .check(status.is(successStatusCode))
      .check(css("td a[href]", "href").saveAs("computerEndpoint"))
  )
}
