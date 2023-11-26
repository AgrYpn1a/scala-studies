package oop

object CaseClasses extends App {
  case class Person(name: String, age: Int)

  /*
   * 1. class parameters are promoted to fields
   * 2. sensible toString
   * 3. equals and hashCode implemented
   * 4. handy copy methodsa
   * 5. have companion objects
   * 6. are serializable
   * 7. have extractor patterns - can be used in **pattern matching**!
   */
  val johnDoe = new Person("John", 27)
  println(johnDoe)

  val johnDoe2 = johnDoe.copy()

  val janeDoe = Person("Jane", 27)

  case object UnitedKingdom {
    def name: String = "United Kingdom"
  }
}
