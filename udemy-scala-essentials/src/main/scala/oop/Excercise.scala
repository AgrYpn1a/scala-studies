package oop

import scala.annotation.tailrec

/*
 * Implement a single linked list of integers:
 *
 * - head = first element of the list
 * - tail = remainder of the list
 * - isEmpty
 * - add(int) => new list with this element added
 * - toString => returns a string representation of the list
 */

/*
 * Implementation by Rastko, first try.
 */
class Node(val value: Int, val next: Node)
class MyList(val root: Node = null) {

  def isEmpty = root == null

  def head: Int = {
    if (isEmpty) -1
    else root.value
  }

  def tail(curr: Node = root): Int = {
    if (curr == null) -1
    else if (curr.next == null) curr.value
    else tail(curr.next)
  }

  def add(value: Int) = {
    if (isEmpty) new MyList(new Node(value, null))
    else new MyList(new Node(value, this.root))
  }

  override def toString = toString(root, "")

  private def toString(curr: Node = root, listStr: String = ""): String = {
    if (curr == null) listStr
    else toString(curr.next, curr.value.toString + " " + listStr)
  }
}

/*
 * Implementation from the course, the correct way
 */

abstract class AList {
  def head: Int
  def tail: AList
  def isEmpty: Boolean
  def add(element: Int): AList
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

object Empty extends AList {
  def head: Int = throw new NoSuchElementException
  def tail: AList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(element: Int): AList = new Cons(element, Empty)
  override def printElements: String = ""
}

class Cons(h: Int, t: AList) extends AList {
  def head: Int = h
  def tail: AList = t
  def isEmpty: Boolean = false
  def add(element: Int): AList = new Cons(element, this)
  override def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
}

object Excercise extends App {
  val l1 = new MyList
  println("*** List 1 ***")
  println(l1.add(1).add(2).add(3).toString)
  println(l1.add(1).add(2).add(3).head)
  println(l1.add(1).add(2).add(3).tail())

  val l2 = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println("*** List 2 ***")
  println(l2.head)
  println(l2.tail.head)
  println(l2.add(4).head)
}
