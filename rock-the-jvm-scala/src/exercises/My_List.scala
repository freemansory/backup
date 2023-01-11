package exercises

abstract class My_List[+A] {

  def head: A
  def tail: My_List[A]
  def isEmpty: Boolean
  def add[B >: A](item: B): My_List[B]
  def printElements: String
  override def toString(): String = "[" + printElements + "]"

  // higher order functions
  def map[B] (transformer: A => B): My_List[B]
  def flatmap[B](transformer: A => My_List[B]): My_List[B]
  def filter(predicate: A => Boolean): My_List[A]

  //concatenation
  def ++[B >: A](list: My_List[B]): My_List[B]
}

case object Empty_List extends My_List[Nothing] {
  def head: Nothing = throw new NoSuchElementException()
  def tail: My_List[Nothing] = throw new NoSuchElementException()
  def isEmpty: Boolean = true
  def add[B >: Nothing](item: B): My_List[B] = new List_1(item, Empty_List)

  override def printElements: String = ""
//  def toString(): String

  override def map[B](transformer: Nothing => B): My_List[B] = Empty_List

  override def flatmap[B](transformer: Nothing => My_List[B]): My_List[B] = Empty_List

  override def filter(predicate: Nothing => Boolean): My_List[Nothing] = Empty_List
  def ++[B >: Nothing](list: My_List[B]): My_List[B] = list
}

case class List_1[+A](h: A, t: My_List[A]) extends My_List[A] {
  def head: A = h
  def tail: My_List[A] = t
  override def isEmpty: Boolean = false
  def add[B >: A](item: B): My_List[B] = new List_1(item, this)
  def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + this.t.printElements

  override def map[B](transformer: A => B): My_List[B] = new List_1(transformer(h), t.map(transformer))

  override def flatmap[B](transformer: A => My_List[B]): My_List[B] = transformer(h) ++ t.flatmap(transformer)

  override def filter(predicate: A => Boolean): My_List[A] = if (predicate(h)) new List_1(h, t.filter(predicate))
  else t.filter(predicate)

  def ++[B >: A](list: My_List[B]): My_List[B] = new List_1(h, t ++ list)
}

object ListTest extends App {
  val listOfInteger: My_List[Int] = new List_1(1, new List_1(2, new List_1(3, Empty_List)))
  val cloneListOfInteger: My_List[Int] = new List_1(4, new List_1(5, new List_1(6, Empty_List)))
  val listOfString: My_List[String] = new List_1("Hello", new List_1[String]("Scala", Empty_List))

  println(listOfInteger.toString())
  println(listOfString.toString())
  println((listOfInteger ++ cloneListOfInteger).toString())
}
