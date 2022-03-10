package lo2_oop.state

class Chillin (brain2:Student) extends State(brain2){
  override def study(): Unit={
    println("I'm a good student")
    brain2.mentalState = new Calm(brain2)
  }

  override def getCloseToExam(): Unit={
    println("I already passed")
  }

  override def expressFeelings(): Unit={
    println("I'm chilling")
  }

}