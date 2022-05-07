package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object GetComputer {

  private val successStatusCode = 200

  val getComputer = exec(
    http("Get computer #{computerEndpoint}")
      .get("#{computerEndpoint}")
      .check(status.is(successStatusCode))
  )
}
