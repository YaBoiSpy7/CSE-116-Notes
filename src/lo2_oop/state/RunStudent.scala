package lo2_oop.state

object RunStudent {
  def main(args: Array[String]): Unit={
    var bob:Student = new Student()
    bob.study()
    bob.getCloseToExam()
  }

}
