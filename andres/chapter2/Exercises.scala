package chapter2

import scala.annotation.tailrec

object Exercises {

  //2.1
  def fib(n: Int): Int = {
    @tailrec
    def go(c: Int, a: Int, b: Int): Int = {
      if (c == n) b
      else go(c + 1, b, a + b)
    }
    if (n <= 1) 0
    else go(2, 0, 1)
  }

  // 2.2
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    @tailrec
    def loop(n: Int): Boolean = {
      if (n >= as.length) true
      else ordered(as(n - 1), as(n)) && loop(n + 1)
    }
    loop(1)
  }

  def partial1[A, B, C](a: A, f: (A, B) => C): B => C =
    b => f(a, b)

  // 2.3
  def curry[A, B, C](f: (A, B) => C): A => (B => C) =
    (a) => (b) => f(a, b)

  // 2.4
  def uncurry[A, B, C](f: A => B => C): (A, B) => C =
    (a, b) => f(a)(b)

  // 2.5
  def compose[A, B, C](f: B => C, g: A => B): A => C =
    (a) => f(g(a))

  def main(args: Array[String]): Unit = {
    val f = (a: Int, b: Int) => a + b

  }
}