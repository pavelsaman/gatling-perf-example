package computerdatabase

import io.gatling.core.Predef._
import io.gatling.core.feeder.BatchableFeederBuilder
import scala.concurrent.duration._

object InsertNewComputerScenario {

  private val csvData: BatchableFeederBuilder[String] = csv("data/computers.csv").random

  val insertNewComputerScenario = scenario("Insert new computer")
    .exec(GoToHomepage.goToHomepage)
    .pause(Config.defaultPausePeriodSec.seconds)
    .exec(GoToNewComputerPage.goToNewComputerPage)
    .pause(10, 20) // give user some time to fill in the form
    .feed(csvData)
    .exec(PostComputer.postComputer)
}
