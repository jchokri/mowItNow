import model._
import util.FileReaderUtil

object MowMain extends  App {

    val file  = FileReaderUtil.readFile("task.txt")
    val head =  FileReaderUtil.head(file) // get first line
    val body =  FileReaderUtil.body(file) // get all commands

    val bounds = head.split(" ") // X , Y of Lawn
    val commands = body.map(l => l.split(" ").filter(e=> e.nonEmpty).toList)
    // create new Lawn with head line data
    val lawn = new Lawn(bounds(0).toDouble, bounds(1).toDouble)

    // Calculate nb of mowers from input file
    val nbMowers =  (file.size  - (file.size % 2)) / 2

  /*
    var i=0
    while (i < nbMowers ) {
      var mower = new Mower(new Position(0, 0, lawn.width, lawn.height), Direction.North)
      lawn.mowers.::(mower)
      i+=1
    }
    */

    val mower = new Mower(new Position(0, 0, lawn.width, lawn.height), Direction.North)
    var mowers = List(mower)
    lawn.mowers = mowers

  commands.zipWithIndex.map{ case (commandList, index) => {

        if (index % 2 == 0) {

          val newPosition= new Position(commandList(0).toDouble, commandList(1).toDouble, lawn.width, lawn.height)
          mower.direction = Direction.withName(commandList(2))
          mower.position.move(newPosition.abscissa, newPosition.ordinate)
          println("Initial position " + ( mower.position , mower.direction) )
          mower.history.::(mower.position, mower.direction)

        }else commandList.map(rotationTask => {
          println("Command execution => " +  rotationTask)
          val rotation = RotationEnum.withName(rotationTask)
          mower.rotate(rotation)
          println("New state => " +  mower.position, mower.direction)
        })
  }
  }
      mower.toString
}
