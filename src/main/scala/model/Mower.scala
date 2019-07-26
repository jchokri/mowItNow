package model

case class Mower(var position: Position, var direction: Direction.Direction) {

  def rotate(r: RotationEnum.RotationEnum) = r match {

    case RotationEnum.G => if(this.direction == Direction.Est) this.direction = Direction.apply(0) else this.direction = Direction.apply(this.direction.id+1)
    case RotationEnum.D =>  if(this.direction == Direction.North) this.direction = Direction.apply(3) else this.direction = Direction.apply(this.direction.id-1)
    case RotationEnum.A => this.direction match {
      case Direction.North => this.position.abscissa = this.position.abscissa; this.position.ordinate = this.position.ordinate +1
      case Direction.South => this.position.abscissa = this.position.abscissa; this.position.ordinate = this.position.ordinate - 1
      case Direction.Est => this.position.abscissa = this.position.abscissa + 1 ; this.position.ordinate = this.position.ordinate
      case Direction.Ouest => this.position.abscissa = this.position.abscissa - 1; this.position.ordinate = this.position.ordinate
    }
  }
}
