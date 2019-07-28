package model

case class Mower(var position: Position, var direction: Direction.Value) {

  val history = List((position, direction))

  def rotate(rotation: RotationEnum.Value ) = rotation match {
    case RotationEnum.G => if(this.direction == Direction.Est) this.direction = Direction.apply(0) else this.direction = Direction.apply(this.direction.id+1)
    case RotationEnum.D =>  if(this.direction == Direction.North) this.direction = Direction.apply(3) else this.direction = Direction.apply(this.direction.id-1)
    case RotationEnum.A => this.direction match {
      case Direction.North => this.position.abscissa = this.position.abscissa; this.position.ordinate = this.position.ordinate +1
      case Direction.South => this.position.abscissa = this.position.abscissa; this.position.ordinate = this.position.ordinate - 1
      case Direction.Est => this.position.abscissa = this.position.abscissa + 1 ; this.position.ordinate = this.position.ordinate
      case Direction.Ouest => this.position.abscissa = this.position.abscissa - 1; this.position.ordinate = this.position.ordinate
    }
    case _ => println("not match !")
  }

  override def toString: String = {
    history.foreach(h => {
      println(s"=> Mower ${history.indexOf(h) } State : (Position: ${h._1}, Direction: ${h._2}) \t")
    })
    return null
  }
}
