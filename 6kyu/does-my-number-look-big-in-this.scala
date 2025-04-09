/** https://www.codewars.com/kata/5287e858c6b5a9678200083c */
package `6kyu`.doesmynumberlookbiginthis

object Kata:
    extension (inline a: Int) inline def **(inline b: Int) = scala.math.pow(a, b).toInt

    def narcissistic(n: Int): Boolean =
        val xs = n.toString.map(_.asDigit)
        xs.map(_ ** xs.size).sum == n

class ExampleSuite extends munit.FunSuite:
    test("narcissistic(7) should return true"):
        assert(Kata.narcissistic(7))

    test("narcissistic(371) should return true"):
        assert(Kata.narcissistic(371))

    test("narcissistic(122) should return false"):
        assert(!Kata.narcissistic(122))

    test("narcissistic(4887) should return false"):
        assert(!Kata.narcissistic(4887))
