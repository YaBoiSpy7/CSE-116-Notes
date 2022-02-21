package lo2_oop.memory

class Box(val bird1: Bird, val bird2: Bird) {

  def inDanger(): Boolean = {
    bird1.inDanger() && bird2.inDanger()
  }

}
