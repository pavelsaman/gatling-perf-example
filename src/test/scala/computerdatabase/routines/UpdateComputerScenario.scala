package computerdatabase

import io.gatling.core.Predef._
import io.gatling.core.feeder.BatchableFeederBuilder
import scala.concurrent.duration._

object UpdateComputerScenario {

  private val searchComputerData: BatchableFeederBuilder[String] = csv("data/searchComputers.csv").random
  private val updateComputerData: BatchableFeederBuilder[String] = csv("data/computers.csv").random

  val updateComputerScenario = scenario("Update Computer")
    .exec(GoToHomepage.goToHomepage)
    .pause(Config.defaultPausePeriodSec.seconds)
    .feed(searchComputerData)
    .exec(Search.search)
    .pause(Config.defaultPausePeriodSec)
    .exec(GetComputer.getComputer)
    .pause(10, 20) // give user some time to fill in new computer info
    .feed(updateComputerData)
    .exec(PostComputer.postComputer)
}
