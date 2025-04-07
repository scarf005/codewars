/** https://www.codewars.com/kata/52597aa56021e91c93000cb0 */
package `5kyu`.movingzerostotheend

def moveZeroes(lst: List[Int]): List[Int] = lst.sortBy(_ == 0)

class MoveZeroesSpec extends munit.FunSuite:
    test("moveZeroes should pass basic tests"):
        List(
          (List(1, 2, 0, 1, 0, 1, 0, 3, 0, 1), List(1, 2, 1, 1, 3, 1, 0, 0, 0, 0)),
          (
            List(9, 0, 0, 9, 1, 2, 0, 1, 0, 1, 0, 3, 0, 1, 9, 0, 0, 0, 0, 9),
            List(9, 9, 1, 2, 1, 1, 3, 1, 9, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
          ),
          (List(0, 0), List(0, 0)),
          (List(0), List(0)),
          (List[Int](), List[Int]()),
        ).foreach { (lst, expected) => assertEquals(moveZeroes(lst), expected) }
