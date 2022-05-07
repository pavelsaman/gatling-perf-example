package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Config {

  val sys = scala.util.Properties

  // environment for tests
  val env = sys.envOrElse("ENV", "prod")

  // URLs for different environments
  val baseUrl = env match {
    case "prod"     => "https://computer-database.gatling.io"
    case "stage"    => ""
    case "dev"      => ""
    case "perf" | _ => ""
  }

  // workload model setup
  val defaultDoNothingPeriodSec = 2
  val defaultNOfUsers = 1
  val rampUpNOfUsers = sys.envOrElse("RAMPUPUSERS", "10").toInt
  val rampUpPeriodSec = sys.envOrElse("RAMPUPPERIOD", "10").toInt
  val usersPerSec = sys.envOrElse("USERSPERSEC", "3").toInt
  val usersPerSecPeriodSec = sys.envOrElse("USERSPERSECPERIOD", "60").toInt

  // http protocol setup
  val httpProtocol = http
    .baseUrl(baseUrl)
    .asyncNameResolution()

  // performance budgets
  val percentile95 = sys.envOrElse("PERCENTILE95", "3000").toInt
  val percentile99 = sys.envOrElse("PERCENTILE99", "5000").toInt
  val maxFailedReqsPercent = sys.envOrElse("MAXFAILEDREQS", "1").toInt

  // other setting
  val defaultPausePeriodSec = sys.envOrElse("PAUSE", "1").toInt
}
