package ag.csv

import java.io.{File, FileOutputStream, PrintStream, StringWriter}

import com.github.tototoshi.csv._

object CSVTable {

  def mergeFiles(fileNames: List[String]): String = {
    val clazz = getClass()

    // open a reader for each file
    // build up a list of columns including unified lat and long
    // add to writer

    val data: List[Map[String, String]] = (for {
      fileName <- fileNames
      reader = CSVReader.open(scala.io.Source.fromInputStream(clazz.getResourceAsStream("/" + fileName)))
      fileData: List[Map[String, String]] = reader.allWithHeaders()
    } yield fileData).flatten

    // TODO: fill in blank values

    val allHeaders: Set[String] = {
      for (row <- data)
        yield (row.keys)
    }.flatten.toSet

    // write it back to one file, to String initially
    val internalWriter = new StringWriter()
    val writer = CSVWriter.open(internalWriter)

    // make a list of header names so it's consistent order
    val headerAsLines = allHeaders.toList

    writer.writeRow(headerAsLines)

    for (row <- data) {
      val values = headerAsLines.map(row.getOrElse(_, ""))
      writer.writeRow(values)
    }

    internalWriter.toString
    // TODO: write to stream
  }


}
