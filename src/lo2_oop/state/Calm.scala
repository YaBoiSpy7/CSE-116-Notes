package lo2_oop.state

class Calm (brain2:Student) extends State(brain2){
  override def study(): Unit={
    println("I'm already calm")
  }

  override def getCloseToExam(): Unit={
    brain2.mentalState = new Panic(brain2)
  }

  override def expressFeelings(): Unit={
    println("I'm a sissy")
  }

}
