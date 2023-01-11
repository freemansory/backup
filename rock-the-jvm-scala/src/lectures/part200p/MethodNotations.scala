package lectures.part200p

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, age: Int = 0) {

    def likes(movie: String): Boolean = movie == favoriteMovie
    def learns(subject: String) = s"${this.name} learns $subject"
    def learnsScala = this learns "Scala"
    def +(person: Person): String = s"${this.name} is hanging with ${person.name}"
    def +(nickName: String): Person = new Person(s"${this.name} ($nickName)", this.favoriteMovie)
    def unary_! : String = s"$name, what the heck?!"
    def unary_+ : Person = new Person(this.name, this.favoriteMovie, this.age + 1)
    def isActive: Boolean = true
    def apply(): String = s"Hi, my name is $name, am $age years old and i like $favoriteMovie"
    def apply(n: Int): String = s"${this.name} watched ${this.favoriteMovie} $n times!"
  }

  val mary = new Person("Mary", "Inception")
  // infix notation = operator notation ( syntactic sugar)
  println(mary.likes("Inception"))
  println(mary likes "Inception")
  println((mary + "the Rockstar")(2))
  println((+mary)())
  println(mary learnsScala)

  // "Operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

}
