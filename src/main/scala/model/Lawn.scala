package model

class Lawn (var width: Double = 0 , var height: Double = 0) {
var mowers : List[Mower]= List()

  override def toString: String = {

    return "" + this.mowers.foreach(mower => {
      println("Position \t" + mower.position.toString())
      println("Direction \t" + mower.direction)
    })
  }
}
