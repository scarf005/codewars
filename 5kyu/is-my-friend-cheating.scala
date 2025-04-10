/** https://www.codewars.com/kata/5547cc7dcad755e480000004 */
package `5kyu`.ismyfriendcheating

object RemovedNumbers:
    extension (a: Long) inline infix def safeDiv(b: Long) = Option.when(b != 0 && a % b == 0)(a / b)

    def removNb(n: Long): List[(Long, Long)] =
        val sum = n * (n + 1) / 2
        (1L to n)
            .collect(Function.unlift(a => ((sum - a) safeDiv (a + 1)).map(b => (a, b))))
            .filter((a, b) => b <= n && a * b == sum - (a + b))
            .toList

class RemovedNumbersSuite extends munit.FunSuite:
    test("pass basic tests"):
        Seq(
          (26L, List((15L, 21L), (21L, 15L))),
          (100L, List()),
          (101L, List((55L, 91L), (91L, 55L))),
        ).foreach((x, expected) => assertEquals(RemovedNumbers.removNb(x), expected))
