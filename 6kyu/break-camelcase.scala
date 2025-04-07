/** https://www.codewars.com/kata/5208f99aee097e6552000148 */
package `6kyu`.breakcamelcase

def breakCamelCase(s: String): String =
    "([A-Z])".r.replaceAllIn(s, " $1")

class BreakCamelCaseSuite extends munit.FunSuite:
    test("breakCamelCase should pass basic tests"):
        val testCases = List(
          ("helloWorld", "hello World"),
          ("camelCase", "camel Case"),
          ("breakCamelCase", "break Camel Case"),
        )

        testCases.foreach { (input, expected) => assertEquals(breakCamelCase(input), expected) }
