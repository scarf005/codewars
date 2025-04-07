/** https://www.codewars.com/kata/53ee5429ba190077850011d4 */
package `8kyu`.youcantcodeunderpressurenumber1

def doubleInteger(i: Int): Int = i * 2

class DoubleIntegerSuite extends munit.FunSuite:
    test("doubleInteger should pass basic tests"):
        List(
          (2, 4),
          (4, 8),
          (-10, -20),
          (0, 0),
          (100, 200),
        ).foreach { (i, expected) => assertEquals(doubleInteger(i), expected) }
