package lectures.part200p

object OOBasics extends App {

  class Writer(firstName: String, surname: String, val year: Int = 2022) {

    def fullName = s"$firstName $surname"
    def print = println(fullName)
  }

  class Novel(name: String, yearOfRelease: Int, author: Writer) {
    def authorAge = yearOfRelease - author.year
    def isWrittenBy(author: Writer) = author == this.author
    def copy(newYear: Int): Novel = {
      new Novel(name, newYear, author)
    }
  }

  class Counter(val count: Int = 0) {

    def inc = {
      println("Incrementing")
      new Counter(count + 1)
    }
    def dec = {
      println("Incrementing")
      new Counter(count - 1)
    }

    def inc(value: Int): Counter =
      if (value <= 0) this
      else inc.inc(value - 1)

    def dec(value: Int): Counter =
      if (value <= 0) this
      else dec.dec(value - 1)

    def print = println(count)
  }

  val counter = new Counter
  counter.inc.inc.print
  counter.inc(4).print
}
