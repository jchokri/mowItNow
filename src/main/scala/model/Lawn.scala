package model

class Lawn (var width: Double = 0 , var height: Double = 0) {
  var mowers : List[Mower]= List()

  override def toString: String = {
    println(s"Lawn dimension : (With: ${height}, Height: $height) \t")
    this.mowers.zipWithIndex.foreach({ case (mower: Mower, i: Int) => {
      println(s"Mower ${ i+1 } ${mower.toString}")
    }
    })
    return null
  }
}
