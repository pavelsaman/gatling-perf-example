package computerdatabase

import io.gatling.core.Predef._
import scala.concurrent.duration._

class SearchComputers extends Simulation {

  setUp(
    SearchComputersScenario.searchComputersAndShowDetailScenario
      .inject(
        nothingFor(Config.defaultDoNothingPeriodSec.seconds),
        atOnceUsers(Config.defaultNOfUsers),
        rampUsers(Config.rampUpNOfUsers).during(Config.rampUpPeriodSec.seconds),
        constantUsersPerSec(Config.usersPerSec).during(Config.usersPerSecPeriodSec.seconds)
      ))
      .protocols(Config.httpProtocol)
      .assertions(
        forAll.responseTime.percentile3.lt(Config.percentile95),
        forAll.responseTime.percentile4.lt(Config.percentile99),
        forAll.failedRequests.percent.lte(Config.maxFailedReqsPercent)
      )
}
