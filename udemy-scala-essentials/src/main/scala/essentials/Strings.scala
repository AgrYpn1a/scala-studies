package essentials

object Strings extends App {

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(7, 11))
  // ...
  //
  //

  val aNumberString = "45"
  val aNumber = aNumberString.toInt

  /*
   * [Scala specfic]: String concatenation
   */
  println('a' +: aNumberString :+ 'z')

  /*
   * [Scala specfic]: S-interpolators
   */
  val name = "David"
  val age = 12

  val greeting = s"Hello, my name is $name and I am $age years old"

  /*
   * [Scala specfic]: F-interpolators
   */
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f"

  /*
   * [Scala specfic]: raw-interpolators
   */
  println(raw"this is a \n newline")
}
