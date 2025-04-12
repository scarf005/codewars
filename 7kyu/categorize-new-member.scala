/** https://www.codewars.com/kata/5502c9e7b3216ec63c0001aa */
package `7kyu`.categorizenewmember

def openOrSenior(data: List[(Int, Int)]): List[String] =
    data.map((age, handicap) => if age >= 55 && handicap > 7 then "Senior" else "Open")

class CroquetSuite extends munit.FunSuite:
    test("openOrSenior should pass basic tests"):
        List(
          (List((45, 12), (55, 21), (19, -2), (104, 20)), List("Open", "Senior", "Open", "Senior")),
          (List((3, 12), (55, 1), (91, -2), (54, 23)), List("Open", "Open", "Open", "Open")),
          (List((59, 12), (55, -1), (12, -2), (12, 12)), List("Senior", "Open", "Open", "Open")),
          (List((74, 10), (55, 6), (12, -2), (68, 7)), List("Senior", "Open", "Open", "Open")),
          (List((16, 23), (56, 2), (56, 8), (54, 6)), List("Open", "Open", "Senior", "Open")),
        ).foreach { (data, expected) => assertEquals(openOrSenior(data), expected) }
