/** https://www.codewars.com/kata/52742f58faf5485cae000b9a */
package `4kyu`.humanreadabledurationformat

import scala.concurrent.duration.*

object HumanTime:
    extension (x: Int)
        inline def /(y: FiniteDuration) = x / y.toSeconds.toInt
        inline def %(y: FiniteDuration) = x % y.toSeconds.toInt

    def formatDuration(seconds: Int): String = if seconds == 0 then "now"
    else
        Seq(
          seconds / 365.day -> "year",
          seconds % 365.day / 1.day -> "day",
          seconds % 1.day / 1.hour -> "hour",
          seconds % 1.hour / 1.minute -> "minute",
          seconds % 1.minute -> "second",
        ).collect {
            case (1, unit)          => s"1 $unit"
            case (x, unit) if x > 1 => s"$x ${unit}s"
        } match
            case Nil    => "now"
            case Seq(x) => x
            case xs     => s"${xs.init.mkString(", ")} and ${xs.last}"

class HumanTimeSuite extends munit.FunSuite:
    test("HumanTime.formatDuration should pass basic tests"):
        val testCases = List(
          (0, "now"),
          (1, "1 second"),
          (62, "1 minute and 2 seconds"),
          (120, "2 minutes"),
          (3600, "1 hour"),
          (3662, "1 hour, 1 minute and 2 seconds"),
          (15731080, "182 days, 1 hour, 44 minutes and 40 seconds"),
          (1358716939, "43 years, 30 days, 21 hours, 22 minutes and 19 seconds"),
        )

        testCases.foreach { (seconds, expected) =>
            assertEquals(HumanTime.formatDuration(seconds), expected)
        }
