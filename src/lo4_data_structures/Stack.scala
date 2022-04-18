package lo4_data_structures

import com.fasterxml.jackson.databind.util.LinkedNode

class Stack[A] {
  var top:LinkedListNode[A] = null

  //push
  def push(element:A): Unit ={
    this.top = new LinkedListNode[A](element, this.top)
  }

  //pop
  def pop(): A ={
    val toReturn = this.top.value
    this.top = this.top.next
    return toReturn
  }

  override def toString: String ={
    this.top.toString
  }
}

object runStack{
  def main(args: Array[String]): Unit ={
    val myStack = new Stack[Int]()
    myStack.push(2)
    myStack.push(4)
    myStack.push(8)
    println(myStack)
    val temp = myStack.pop()
    println(temp)
    println(myStack)


    val deck:Stack[Card] = new Stack()
    val suits:Array[String] = Array("Hearts", "Clubs", "Diamonds", "Spades")
    for (suit <- suits){
      for (i <- 1 to 13) {
        deck.push(new Card(suit, i))
      }
    }
    println(deck)
  }

}
