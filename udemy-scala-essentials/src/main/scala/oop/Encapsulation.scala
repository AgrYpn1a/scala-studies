package oop.encapsulation

class Person(var firstName: String, private var lastName: String, val age: Int) {
  override def toString() =
    s"${this.firstName} ${this.lastName} aged ${this.age}"
}

object Encapsulation extends App {
  val person = new Person("John", "Doe", 24)

  person.firstName = "Jane"
  // person.lastName = "Doue"
  // person.age = 27
}
