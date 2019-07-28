import model._
import util.FileReaderUtil

object MowMain extends  App {

  val file  = FileReaderUtil.readFile("task.txt")
  val head =  FileReaderUtil.head(file) // get first line
  val body =  FileReaderUtil.body(file) // get all commands

  val bounds = head.split(" ") // X , Y of Lawn
  // create new Lawn with head line data
  var lawn = new Lawn(bounds(0).toDouble, bounds(1).toDouble)

  // Calculate nb of mowers from input file and add their on the lawn
  val nbMowers =  (file.size  - (file.size % 2)) / 2
  var i = 0 ; var j = 2
  for (_ <- 0 until  nbMowers ) {
    val mower = new Mower(new Position(0, 0, lawn.width, lawn.height), Direction.North)
    mower.commands = body.slice(i, j).map(l => l.split(" ").filter(e=> e.nonEmpty).toList)
    lawn.mowers ::= mower
    i+=2 ; j+=2
  }

  // for each mower on the lawn => execute commands associated
  lawn.mowers.zipWithIndex.foreach ( mower => {
    println(s"Mower N°: ${mower._2 + 1}" )
    mower._1.commands.zipWithIndex.foreach{ case (commandList, index) => {
      if (index == 0) {
        val x = commandList(0).toDouble ; val y = commandList(1).toDouble
        if (x > lawn.width || y > lawn.height ) throw new IllegalArgumentException("Outbound lawn")
        val newPosition= new Position(x, y, lawn.width, lawn.height)
        mower._1.direction= Direction.withName(commandList(2))
        mower._1.position.move(newPosition.abscissa, newPosition.ordinate)
        mower._1.history.::(mower._1.position, mower._1.direction)

      }else commandList.map(rotationTask => {
        val rotation = RotationEnum.withName(rotationTask)
        mower._1.rotate(rotation)
        println("New state => " +  "Postion: " + mower._1.position, "Direction: " +mower._1.direction)
      })
    }
    }
  })
  println("********** Summary ***********")
  lawn.toString()

}
