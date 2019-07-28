package model

class Position (val x: Double, val y: Double, val boundX: Double,val boundY: Double) {

  var abscissa: Double = x
  var ordinate: Double = y

  def move(x: Double, y: Double): Boolean = {

    abscissa = abscissa + x
    ordinate = ordinate + y
    return true;
  }

  private def printWarning = println("WARNING: Out of bounds")

  override def toString: String =
    s"($abscissa, $ordinate)"
}
