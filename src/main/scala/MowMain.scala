import model._
import scala.io.Source

object MowMain {
  def main(args: Array[String]) {
    val lawn = new Lawn(5, 5)

    val mower = new Mower(new Position(0, 0, lawn.width, lawn.height), Direction.Est)

    val mowers = List(mower)

    lawn.mowers = mowers

    lawn.toString()
    val input = Source.fromResource("task.txt")
    //println(resourcesPath.getLines())

     val list = input.getLines().map(line => {
       line.split(" ")
    })

    list.foreach(l => {
      println(l.toString())
    })

    lawn.mowers.foreach(mower => {
      mower.rotate(RotationEnum.G)
      mower.rotate(RotationEnum.A)
      mower.rotate(RotationEnum.G)
      mower.rotate(RotationEnum.A)
    })
    lawn.toString()
  }
}
