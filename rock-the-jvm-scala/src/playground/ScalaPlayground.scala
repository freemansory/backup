package playground

object ScalaPlayground extends App {
//  println("Hello Scala!")

  def greetingFunction(name: String, age: Int): String = s"Hi, my name is $name and i am $age years old."

  def factorialFunction(n: Int): Int = {
    if (n <= 0) 1 else n * factorialFunction(n - 1)
  }

  def fibonacciFunction(n: Int): Int =
    if (n <= 2) 1
    else fibonacciFunction(n-1) + fibonacciFunction(n-2)

  def isAPrimeNumber(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    isPrimeUntil(n / 2)
  }

  println(greetingFunction("John", 12))
  println(factorialFunction(5))
  println(fibonacciFunction(8))
  println(isAPrimeNumber(37))
}
