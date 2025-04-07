/** https://www.codewars.com/kata/5715eaedb436cf5606000381 */
package `8kyu`.sumofpositive

def positiveSum(xs: Seq[Int]): Int = xs.filter(_ > 0).sum

class PositiveSumSuite extends munit.FunSuite:
    test("positiveSum should pass basic tests"):
        assert(positiveSum(Seq(2, 2)) == 4)
        assert(positiveSum(Seq(1, 2, 3, 4, 5)) == 15)
        assert(positiveSum(Seq(1, -2, 3, 4, 5)) == 13)
        assert(positiveSum(Seq(-1, -2, -3, -4, -5)) == 0)
        assert(positiveSum(Seq(-1, 2, 3, 4, -5)) == 9)
        assert(positiveSum(Seq()) == 0)
