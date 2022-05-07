package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object PostComputer {

  private val endpoint = "/computers"
  private val successStatusCode = 200

  val postComputer = exec(
    http("Post new computer")
      .post(s"$endpoint")
      .formParam("name", "#{name}")
      .formParam("introduced", "#{introduced}")
      .formParam("discontinued", "#{discontinued}")
      .formParam("company", "#{company}")
      .check(status.is(successStatusCode))
  )
}
