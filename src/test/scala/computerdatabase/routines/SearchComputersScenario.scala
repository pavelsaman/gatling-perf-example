package computerdatabase

import io.gatling.core.Predef._
import io.gatling.core.feeder.BatchableFeederBuilder
import scala.concurrent.duration._

object SearchComputersScenario {

  private val csvData: BatchableFeederBuilder[String] = csv("data/searchComputers.csv").random

  val searchComputersScenario = scenario("Search Computers")
    .exec(GoToHomepage.goToHomepage)
    .pause(Config.defaultPausePeriodSec.seconds)
    .feed(csvData)
    .exec(Search.search)
    .pause(Config.defaultPausePeriodSec)

  val searchComputersAndShowDetailScenario = scenario("Search Computers and Show Detail")
    .exec(GoToHomepage.goToHomepage)
    .pause(Config.defaultPausePeriodSec.seconds)
    .feed(csvData)
    .exec(Search.search)
    .pause(Config.defaultPausePeriodSec)
    .exec(GetComputer.getComputer)
}
