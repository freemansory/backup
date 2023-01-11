object BalancedExercises extends App {

  val openChar = List ('{', '[', '(')
  val closeChar = List('}', ']', ')')
  val mapOfChar: Map[Char, Char] = Map('}' -> '{', ']' -> '[', ')' -> '(')

  def isBalanced(brackets: String): String = {
    if (brackets.isEmpty) "NO"
    else {
      def isBalance(index: Int, stack: List[Char]): Boolean = {
        if (index == brackets.length) stack.isEmpty
        else {
          val char = brackets(index)
          val isOpenChar = openChar.contains(char)
          val isCloseChar = closeChar.contains(char)

          if (isOpenChar) isBalance(index + 1, char :: stack)
          else if(isCloseChar) {
            val correspondOpenChar = mapOfChar(char)
            stack match {
              case `correspondOpenChar` :: tail => isBalance(index + 1, tail)
              case _ => false
            }
          } else false
        }
      }
      if (isBalance(0, List.empty)) "YES"
      else "NO"
    }
  }

  val test = "{[}"
  println(isBalanced(test))

}
