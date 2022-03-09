package lo2_oop.state

class Panic (brain2:Student) extends State(brain2){
  override def study(): Unit={
    brain2.mentalState = new Calm(brain2)
  }

  override def getCloseToExam(): Unit={
    println("I'm already panicking")
  }

  override def expressFeelings(): Unit={
    println("I'm still a sissy")
  }

}