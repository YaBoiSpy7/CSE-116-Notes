package lo4_data_structures

class LinkedListNode[T] (var value:T, var next:LinkedListNode[T]) {
  //size()
  def sizeWhile():Int ={
    var count = 1
    var current:LinkedListNode[T] = this
    while (current.next != null){
      count += 1
      current = current.next
    }
    count
  }
  def size(tracker:Int): Int ={
    if (this.next == null){
      return tracker + 1
    }
    else{
      this.next.size(tracker + 1)
    }
  }

  //print
  override def toString: String ={
    if (this.next == null){
      this.value.toString
    }
    else{
      this.value.toString + ", " + this.next.toString
    }
  }

  //getElement(loc)
  def getElement(loc:Int, tracker:Int): Unit ={
    if (tracker == loc){
      println(this.value)
      return this
    }
    else if(this.next == null){
      null
    }
    else{
      this.next.getElement(loc, tracker + 1)
    }
  }

  //add/remove elements
  //find(element)

}

object runLLN{
  def main(args: Array[String]): Unit ={
    var myList:LinkedListNode[Int] = new LinkedListNode[Int](1, null)
    myList = new LinkedListNode[Int](3, myList)
    myList = new LinkedListNode[Int](5, myList)
    val num = myList.size(0)
    println(num)
    println(myList.toString)
    myList.getElement(0, 0)
    myList.getElement(1, 0)
    myList.getElement(2, 0)
    myList.getElement(86, 0)
  }

}