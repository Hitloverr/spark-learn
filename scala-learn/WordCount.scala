import java.io.File
import scala.io.Source

object WordCount {
  def main(args: Array[String]): Unit = {
    val dirFile = new File("/file")
    val files = dirFile.listFiles
    for (file <- files) println(file.getName)
    val listFiles = files.toList

    var wordsMap = Map[String, Int]()
    listFiles.foreach(file => {
      Source.fromFile(file).getLines().foreach(line => line.split(" ")
      .foreach(word => wordsMap += (word -> (wordsMap.getOrElse(word, 0) + 1)))
      )
    })
  }
}
