package oop

object Inheritance extends App {

  // Single class inheritance
  class Animal {
    val creatureType = "wild"
    def eat = println("nomnom")
  }

  class Cat extends Animal

  val cat = new Cat
  cat.eat

  class Person(name: String, age: Int)
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  class Dog(override val creatureType: String = "domestic") extends Animal {
    override def eat = println("crunch, crunch")
  }

  val dog = new Dog
  dog.eat
  println(dog.creatureType)

  /*
   * Type substituion (polymorphism)
   */
  val anAnimal: Animal = new Dog("K9")
}
