package util
import scala.io.Source
// default path : src/main/resources
object FileReaderUtil {

  implicit  def readFile(fileName: String): List[String] = {
    return Source.fromResource(fileName).getLines().toList
  }
  def head (lines: List[String]) : String = {
    return lines.head
  }

  def body (lines: List[String]) : List[String] = {
    return lines.tail
  }
}
