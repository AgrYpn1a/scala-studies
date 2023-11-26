package oop.excercies

/*
 * Generic list: Implementation by Rastko.
 */

abstract class AGenericList[+A] {
  def head: A
  def tail: AGenericList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): AGenericList[B]
  def printElements: String
  // override def toString: String = "[" + printElements + "]"
}

object EmptyGeneric extends AGenericList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: AGenericList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): AGenericList[B] = new ConsGeneric(element, EmptyGeneric)
  override def printElements: String = ""
}

class ConsGeneric[+A](h: A, t: AGenericList[A]) extends AGenericList[A] {
  def head: A = h
  def tail: AGenericList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): AGenericList[B] = new ConsGeneric(element, this)
  override def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
}

class Animal
class Cat extends Animal
class Dog extends Animal

object GenericListTest extends App {
  // val listOfIntegers: AGenericList[Int] = EmptyGeneric
  // val listOfStrings: AGenericList[String] = EmptyGeneric

  // var cats: AGenericList[Cat] = EmptyGeneric
  // println(cats)
  // cats = cats.add(new Cat)
  // println(cats)
  // cats = cats.add(new Dog)
  // println(cats)

  val cats: AGenericList[Cat] = EmptyGeneric
  val cats1 = cats.add(new Cat)
  println(cats1)
  val cats2 = cats1.add(new Dog)
  println(cats2)
}
