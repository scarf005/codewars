/** https://www.codewars.com/kata/5277c8a221e209d3f6000b56 */
package `6kyu`.validbraces

import scala.annotation.tailrec

object Kata:
    def isMatchingPairs(l: Char, r: Char) = (l, r) match
        case ('(', ')') | ('{', '}') | ('[', ']') => true
        case _                                    => false

    def validBraces(s: String): Boolean =
        @tailrec def go(as: List[Char], bs: List[Char]): Boolean = (as, bs) match
            case (Nil, Nil)                          => true
            case ((l @ ('(' | '{' | '[')) :: ls, bs) => go(ls, l :: bs)
            case (')' :: ls, '(' :: bs)              => go(ls, bs)
            case ('}' :: ls, '{' :: bs)              => go(ls, bs)
            case (']' :: ls, '[' :: bs)              => go(ls, bs)
            case _                                   => false

        go(s.toList, Nil)

class ValidBracesSpec extends munit.FunSuite:
    test("validBraces should pass basic tests"):
        List[(String, Boolean)](
          ("()", true),
          ("[(])", false),
        ).foreach { (s, expected) => assertEquals(Kata.validBraces(s), expected) }
