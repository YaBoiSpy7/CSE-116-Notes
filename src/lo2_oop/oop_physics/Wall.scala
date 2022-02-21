package lo2_oop.oop_physics

import archived.physics.PhysicsVector
import archived.physics.objects.{DynamicObject, Face, StaticObject}


class Wall(location: PhysicsVector, dimensions: PhysicsVector) extends StaticObject(location, dimensions){

  override def collideWithDynamicObject(otherObject: DynamicObject, face: Integer): Unit = {
    if(face == Face.negativeX){
      otherObject.velocity.x = 0.0
      otherObject.location.x = this.location.x - otherObject.dimensions.x
    }else if(face == Face.positiveX){
      otherObject.velocity.x = 0.0
      otherObject.location.x = this.location.x + this.dimensions.x
    }
  }

}
