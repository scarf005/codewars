# Coding Style

- always use indentation style
- on `munit.FunSuite.test` methods, use indentation instead of braces

# AI Instructions

When given task `munit`:

- replace scalatest tests with munit tests (specifically, `munit.FunSuite`).
- remove "expected" messages from assertions.
- rename `Spec` to `Suite`.
- in `foreach` loop,
  - shorten them to single line.
  - replace `foreach { case (a, b) => ??? }` with `foreach { (a, b) => ??? }`.
