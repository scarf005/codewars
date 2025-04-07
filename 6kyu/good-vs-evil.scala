/** https://www.codewars.com/kata/52761ee4cffbc69732000738 */
package `6kyu`.goodvsevil

val goodWorth = List(1, 2, 3, 3, 4, 10)
val evilWorth = List(1, 2, 2, 2, 3, 5, 10)

extension (s: String)
    inline def toWorths(worth: List[Int]) =
        s.split(" ").map(_.toInt).toList.lazyZip(worth).map(_ * _).sum

def goodVsEvil(good: String, evil: String): String =
    val result = good.toWorths(goodWorth) `compareTo` evil.toWorths(evilWorth) match
        case 0          => "No victor on this battle field"
        case x if x > 0 => "Good triumphs over Evil"
        case _          => "Evil eradicates all trace of Good"

    s"Battle Result: $result"

class GoodVsEvilSpec extends munit.FunSuite:
    test("goodVsEvil should pass basic tests"):
        Seq(
          ("1 1 1 1 1 1", "1 1 1 1 1 1 1", "Battle Result: Evil eradicates all trace of Good"),
          ("0 0 0 0 0 10", "0 1 1 1 1 0 0", "Battle Result: Good triumphs over Evil"),
          ("1 0 0 0 0 0", "1 0 0 0 0 0 0", "Battle Result: No victor on this battle field"),
        ).foreach { (good, evil, expected) => assertEquals(goodVsEvil(good, evil), expected) }
