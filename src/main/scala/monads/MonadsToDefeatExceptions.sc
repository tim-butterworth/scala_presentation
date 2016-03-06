import java.io.{FileReader, File}
import scala.util.{Try,Success, Failure}

val file = new File("~/temp/file.txt")

val myReader = Try(new FileReader(file)).map(_.read()) match {
  case Success(i: Int) => i.toString
  case Failure(e) => e.getMessage
}

//val fileReader = new FileReader(file)
//Try(fileReader.read())
