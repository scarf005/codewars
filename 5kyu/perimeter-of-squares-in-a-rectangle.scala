/** https://www.codewars.com/kata/559a28007caad2ac4e000083 */
package `5kyu`.perimeterofsquaresinarectangle

def perimeter(n: BigInt): BigInt =
    Iterator
        .iterate((BigInt(0), BigInt(1))) { (a, b) => (b, a + b) }
        .map(_._2)
        .take(n.toInt + 1)
        .sum * 4

class SquaresPerimeterSuite extends munit.FunSuite:
    test("perimeter should pass basic tests"):
        val testCases = List(
          (5, BigInt(80)),
          (7, BigInt(216)),
          (20, BigInt(114624)),
          (30, BigInt(14098308)),
          (100, BigInt("6002082144827584333104")),
        )

        testCases.foreach { (n, expected) => assertEquals(perimeter(n), expected) }
