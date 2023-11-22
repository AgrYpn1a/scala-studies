package essentials

object FunctionArgs extends App {

  /*
   * Call by value vs. Call by name
   * */
  def callByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def callByName(x: => Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  // callByValue(System.nanoTime());
  // callByName(System.nanoTime());

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  // printFirst(infinite(), 34)
  // printFirst(34, infinite())
  //

  /*
   * Default arguments
   * */
  def trFact(n: Int, acc: Int = 1): Int = {
    if (n <= 1) acc
    else trFact(n - 1, acc * n)
  }

  val fact10 = trFact(10, 1)

  /*
   * Named arguments
   * */
  def savePicture(format: String = "jpg", width: Int, height: Int): Unit =
    println("saving picture...")
}
