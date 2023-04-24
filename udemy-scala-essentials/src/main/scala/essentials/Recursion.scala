package essentials

import scala.annotation.tailrec

object Recursion extends App {

  /** Stack recursion
    */
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println(
        "Computing factorial of " + n + " - I first need factorial of " + (n - 1)
      )
      // ->>>>
      val res = n * factorial(n - 1)
      // <<<<-
      println("Computed factorial of " + n)

      res
    }

  /** Tail recursion
    */
  def factorialTail(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, acc: BigInt): BigInt =
      if (x <= 1) acc
      else factHelper(x - 1, x * acc)

    factHelper(n, 1)
  }

  /** Tail recursion practice
    */
  /*
   * 1) Concat a string n times
   */
  def concat(word: String, n: Int): String =
    if (n == 1) word
    else word + concat(word, n - 1)

  @tailrec
  def concat(word: String, n: Int, acc: String): String =
    if (n == 0) acc
    else concat(word, n - 1, acc + word)

  /*
   * 2) Fibonacci
   */
  def fibonacci(n: Int): Int =
    if (n <= 1) n
    else fibonacci(n - 1) + fibonacci(n - 2)

  @tailrec
  def fibonacci(n: Int, n1: Int, n2: Int): Int =
    if (n == 0) n1
    else fibonacci(n - 1, n1 + n2, n1)

  println(fibonacci(16, 0, 1))

}
