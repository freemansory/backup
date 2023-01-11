object SherlockAndGCD {

  def main(args: Array[String]) {
    val lines = io.Source.stdin.getLines()
    val cases = lines.next().toInt
    (0 until cases) foreach { _ =>
      lines.next()
      val elements = lines.next().split(" ").map(_.toInt)
      println(if (sherlockAndGCD(elements) == 1) "YES" else "NO")
    }
  }

  def sherlockAndGCD(givenArray: Iterable[Int]): Int = {
    val elements = givenArray.iterator
    var approveValue = elements.next()
    while (elements.hasNext && approveValue > 1) {
      approveValue = gcd(approveValue, elements.next())
    }
    approveValue
  }

  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a
    else if (a >= b) gcd(b, a % b)
    else gcd(b, b % a)
  }

}
