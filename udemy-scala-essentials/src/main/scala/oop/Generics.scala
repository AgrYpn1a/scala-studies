package oop

object Generics extends App {

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. yes, List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? What happens here - we return a list of Animal

  // 2. no, these lists are two separate things = INVARIANCE
  class InvariantList[A]
  // val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat] - does not work!

  // 3. hell no! = CONTRAVARIANCE
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // Bounded types
  // <: subtype, >: supertype
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

  class Car
  // val newCage = new Cage(new Car)
  //
  class MyList[+A] {
    def add[B >: A](element: B): List[B] = ???
  }
}
