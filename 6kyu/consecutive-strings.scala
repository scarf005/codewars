/** https://www.codewars.com/kata/56a5d994ac971f1ac500003e */
package `6kyu`.consecutivestrings

object LongestConsec:
    def longestConsec(strarr: Array[String], k: Int): String =
        if k <= 0 || k > strarr.size then ""
        else strarr.sliding(k).map(_.mkString).maxByOption(_.size).getOrElse("")

class LongestConsecSuite extends munit.FunSuite:
    test("longestConsec should pass basic tests"):
        val testCases = List(
          (
            Array("zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"),
            2,
            "abigailtheta",
          ),
          (
            Array(
              "ejjjjmmtthh",
              "zxxuueeg",
              "aanlljrrrxx",
              "dqqqaaabbb",
              "oocccffuucccjjjkkkjyyyeehh",
            ),
            1,
            "oocccffuucccjjjkkkjyyyeehh",
          ),
          (Array[String](), 3, ""),
        )

        testCases.foreach { (strarr, k, expected) =>
            assertEquals(LongestConsec.longestConsec(strarr, k), expected)
        }
