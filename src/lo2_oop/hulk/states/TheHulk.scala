package lo2_oop.hulk.states

import lo2_oop.hulk.{BruceBanner, Car}

class TheHulk(banner: BruceBanner) extends State(banner){

  override def makeAngry(): Unit = {
    println("already angry")
  }

  override def calmDown(): Unit = {
    banner.state = new DrBanner(banner)
  }

  override def useCar(car: Car): Unit = {
    car.smash()
  }

  override def fight(): Unit = {
    println("Hulk Smash!")
  }

}
