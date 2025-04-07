/** https://www.codewars.com/kata/5503013e34137eeeaa001648 */
package `6kyu`.givemeadiamond

def diamond(n: Int): Option[String] =
    def fill(i: Int) = " " * ((n - i + 1) / 2) + "*" * i
    Option.when(n > 0 && n % 2 == 1) {
        ((1 until n by 2) ++ (n to 1 by -2)).map(fill(_) + "\n").mkString
    }

class DiamondSuite extends munit.FunSuite:
    def prettify(s: Option[String]): Option[String] = s.map(_.replace("\n", "\\n"))

    test("diamond should pass basic tests"):
        val testCases = List(
          (0, None),
          (1, Some("*\n")),
          (2, None),
          (3, Some(" *\n***\n *\n")),
          (5, Some("  *\n ***\n*****\n ***\n  *\n")),
          (-1, None),
        )

        testCases.foreach { (n, expected) =>
            assertEquals(prettify(diamond(n)), prettify(expected))
        }
