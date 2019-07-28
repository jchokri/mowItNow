package model

object RotationEnum extends  Enumeration {
 type  RotationEnum =  String

  val D = Value("D")
  val G = Value("G")
  val A = Value("A")
  val empty = Value(" ")



 implicit def getValue(x: String) = x.asInstanceOf[String]

}
