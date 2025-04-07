/** https://www.codewars.com/kata/52685f7382004e774f0001f7 */
package `5kyu`.humanreadabletime

import munit.FunSuite

def makeReadable(s: Int): String =
    f"${s / 3600}%02d:${s / 60 % 60}%02d:${s % 60}%02d"

class TimeSpec extends FunSuite:
    test("makeReadable should pass basic tests"):
        assertEquals(makeReadable(0), "00:00:00")
        assertEquals(makeReadable(59), "00:00:59")
        assertEquals(makeReadable(60), "00:01:00")
        assertEquals(makeReadable(3599), "00:59:59")
        assertEquals(makeReadable(3600), "01:00:00")
        assertEquals(makeReadable(86399), "23:59:59")
        assertEquals(makeReadable(86400), "24:00:00")
        assertEquals(makeReadable(359999), "99:59:59")
