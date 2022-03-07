package lo2_oop.objects

abstract class GameItem (var xLoc1:Double,var yLoc1:Double)
      extends GameObject (xLoc1, yLoc1){
  def use(player: Player): Unit

}
