package lo2_oop.objects

object ObjectWithState {

  // State of the object
  var x: Int = 10
  var y: Int = 7

  // Behavior of the object
  def doubleX(): Unit = {
    this.x *= 2
  }

  def main(args: Array[String]): Unit ={
    ObjectWithState.doubleX()
    println(ObjectWithState.x)
  }

}
