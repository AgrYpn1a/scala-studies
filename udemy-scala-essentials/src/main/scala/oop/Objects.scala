package oop

object Objects extends App {

  object Person {
    val N_EYES = 2
    def canFly: Boolean = false

    // A factory method
    def from(mother: Person, father: Person): Person = new Person("Bobbie")
    // Often in practice, we call these methods apply
    // so that we can write this in a more convinient way
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String) {
    def apply(): String =
      s"Hey I am ${this.name} and I have ${Person.N_EYES} eyes."

  }

  val john = new Person("John Doe")
  val mary = new Person("Mary")

  val bobbie = Person.from(john, mary)
  val bobbie1 = Person.apply(john, mary)
  // We want to use it like this
  val bobbie2 = Person(john, mary)

}
