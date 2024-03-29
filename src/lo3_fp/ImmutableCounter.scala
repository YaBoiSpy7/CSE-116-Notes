package lo3_fp

import scalafx.scene.shape.Arc

class ImmutableCounter(counter:Int) {
  def printCounter(): Unit = {
    println(this.counter)
  }

  def increase(): ImmutableCounter = {
    new ImmutableCounter(this.counter + 1)
  }

  def decrease(): ImmutableCounter = {
    new ImmutableCounter(this.counter - 1)
  }

}

object runImmutable{
  def update(n:Int, counter : ImmutableCounter): ImmutableCounter ={
    if (n == 0){
      counter
    }
    else if (n > 0){
      val temp = counter.increase()
      update(n-1, temp)
    }
    else{
      val temp = counter.decrease()
      update(n+1, temp)
    }
  }

  def main(args: Array[String]): Unit ={
    val count = new ImmutableCounter(10)
    val count2 = update(-20, count)
    count.printCounter()
    count2.printCounter()
  }

}

