/** https://www.codewars.com/kata/5ce399e0047a45001c853c2b */
package `6kyu`.sumsofparts

def partsSums(xs: Vector[Int]): Vector[Int] = xs.scanLeft(xs.sum)(_ - _)

class PartsSumsSuite extends munit.FunSuite:
    test("partsSums should pass basic tests"):
        val testCases = List(
          (Vector(), Vector(0)),
          (Vector(0, 1, 3, 6, 10), Vector(20, 20, 19, 16, 10, 0)),
          (Vector(1, 2, 3, 4, 5, 6), Vector(21, 20, 18, 15, 11, 6, 0)),
        )

        testCases.foreach { (xs, expected) => assertEquals(partsSums(xs), expected) }
