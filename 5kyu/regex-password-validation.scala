/** https://www.codewars.com/kata/52e1476c8147a7547a000811 */
package `5kyu`.regexpasswordvalidation

val regex: String = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]{6,}$"

class PasswordSuite extends munit.FunSuite:
    val pattern = regex.r

    test("regex should pass basic tests"):
        Seq(
          ("abcDE8_", false),
          ("fjd3IR9", true),
          ("ghdfj32", false),
          ("DSJKHD23", false),
          ("dsF43", false),
          ("4fdg5Fj3", true),
          ("DHSJdhjsU", false),
          ("fjd3IR9.;", false),
          ("fjd3  IR9", false),
          ("djI38D55", true),
          ("a2.d412", false),
          ("JHD5FJ53", false),
          ("!fdjn345", false),
          ("jfkdfj3j", false),
          ("123", false),
          ("abc", false),
          ("123abcABC", true),
          ("ABC123abc", true),
          ("Password123", true),
          ("", false),
        ).foreach { (password, expected) =>
            assert(pattern.matches(clue(password)) == clue(expected))
        }
