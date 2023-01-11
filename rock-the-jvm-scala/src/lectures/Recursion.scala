package lectures

import scala.annotation.tailrec

object Recursion extends App {

  def concatenateStringNtimes(string: String, n: Int): String = {
    @tailrec
    def concateHelper(t: Int, string: String, accumulator2: String): String =
      if (t <= 0) accumulator2
      else concateHelper(t - 1, string, string + " " + accumulator2)
    concateHelper(n, string, "")
  }

//  println(concatenateStringNtimes("hello scala", 3))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeHelper(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeHelper(t - 1, n % t != 0 && isStillPrime)
    }
    isPrimeHelper(n / 2, true)
  }

//  println(isPrime(6))

  def isAPrimeNumber(n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)
  }

  def fibonacciFunction(n: Int): Int = {
    @tailrec
    def fibonacciHelper(i: Int, lastValue: Int, stepper: Int): Int =
      if (i >= n) lastValue
      else fibonacciHelper(i + 1, lastValue + stepper, lastValue)
    if (n <= 2) 1
    else fibonacciHelper(2, 1, 1)
  }

  println(fibonacciFunction(6))

//  println("Hello scala")
}
