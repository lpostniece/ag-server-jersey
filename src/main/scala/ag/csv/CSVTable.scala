package ag.csv

import java.io.{File, FileOutputStream, PrintStream, StringWriter}

import com.github.tototoshi.csv._

object CSVTable {

  def mergeFiles(): String = {
  //def mergeFiles(fileNames: List[String]): String = {
    // open a reader for each file
    // build up a list of columns including unified lat and long
    // add to writer

    val clazz = getClass()

    // read it in
    //val reader = CSVReader.open(scala.io.Source.fromString("ID,Name,Lat,Lon\n1,Bacchus Marsh Airport,-37.7313,144.4212"))
    val reader = CSVReader.open(scala.io.Source.fromInputStream(clazz.getResourceAsStream("/initial.csv")))
    val data: List[Map[String, String]] = reader.allWithHeaders()

    val allHeaders: Set[String] = {
      for (row <- data)
        yield (row.keys)
    }.flatten.toSet

    // TODO: merge with others

    // write it back, to String initially
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
