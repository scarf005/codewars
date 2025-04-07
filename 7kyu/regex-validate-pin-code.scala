/** https://www.codewars.com/kata/55f8a9c06c018a0d6e000132 */
package `7kyu`.regexvalidatepincode

val validatePin = """\d{4}|\d{6}""".r.matches

class PinSuite extends munit.FunSuite:
    test("validatePin should return false for pins with length other than 4 or 6"):
        val testCases = List(
          "1",
          "12",
          "123",
          "12345",
          "1234567",
          "00000000",
        )

        testCases.foreach { pin => assertEquals(validatePin(pin), false) }

    test("validatePin should return false for pins characters other than digits"):
        val testCases = List(
          "a234",
          ".234",
          "-123",
          "-1234",
          "1.23",
        )

        testCases.foreach { pin => assertEquals(validatePin(pin), false) }

    test("validatePin should return true for valid pins"):
        val testCases = List(
          "1234",
          "0000",
          "1111",
          "123456",
          "098765",
          "000000",
          "123456",
          "090909",
        )

        testCases.foreach { pin => assertEquals(validatePin(pin), true) }
