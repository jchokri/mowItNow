package model

object Direction  extends  Enumeration {
  type Direction = Value

  val North = Value("N")
  val Ouest = Value("O")
  val South = Value("S")
  val Est = Value("E")
  val Empty = Value(" ")

  implicit def getValue(x: Value) = x.asInstanceOf[Char]

}
