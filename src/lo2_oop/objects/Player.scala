package lo2_oop.objects

class Player(var xLocation: Double, var yLocation: Double, val maxHitPoints: Int) {

  var hp: Int = this.maxHitPoints
  val damage: Int = 4

  def takeDamage(damage: Int): Unit = {
    this.hp -= damage //called as eg. Player1.takeDamage. "this" takes the damage from the player calling the method
  }

  def attack(otherPlayer: Player): Unit ={
    otherPlayer.takeDamage(this.damage)
  }

  def conscious(): Boolean = {
    this.hp > 0
  }

  def move(dx: Double, dy: Double): Unit = {
    this.xLocation + dx
    this.yLocation + dy
  }

  override def toString():String={
    var out:String="xLocation: "+this.xLocation
    out+=" yLocation: " +this.yLocation
    out+="health "+this.hp+"/"+this.maxHitPoints
    out
  }

}
