/** https://www.codewars.com/kata/55f2b110f61eb01779000053 */
package `7kyu`.beginnerseriesnumber3sumofnumbers

object Sum:
    def getSum(a: Int, b: Int): Int =
        val small = a min b
        val large = a max b

        (small to large).sum

class SumSuite extends munit.FunSuite:
    test("getSum should pass basic tests"):
        assertEquals(Sum.getSum(0, -1), -1)
        assertEquals(Sum.getSum(0, 1), 1)
