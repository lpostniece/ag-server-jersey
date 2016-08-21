import java.io.StringReader

import ag.csv.CSVTable
import com.github.tototoshi.csv.CSVReader
import org.scalatest.FlatSpec

class CSVMergeSpec extends FlatSpec {

  "CSV table merge" should "merge three tables with different columns" in {
    val merged = CSVTable.mergeFiles(List("one.csv", "two.csv", "three.csv"))
    println("[" + merged.toString + "]")

    val strReader = new StringReader(merged.toString)
    val reader = CSVReader.open(strReader)
    val data = reader.allWithHeaders()

    assert(data.contains(Map("E" -> "", "A" -> "1", "B" -> "2", "C" -> "3", "D" -> "")))
    assert(data.contains(Map("E" -> "", "A" -> "3", "B" -> "4", "C" -> "5", "D" -> "")))
    assert(data.contains(Map("E" -> "", "A" -> "6", "B" -> "7", "C" -> "8", "D" -> "9")))
    assert(data.contains(Map("E" -> "", "A" -> "10", "B" -> "11", "C" -> "12", "D" -> "13")))
    assert(data.contains(Map("E" -> "21", "A" -> "", "B" -> "20", "C" -> "22", "D" -> "")))
    assert(data.contains(Map("E" -> "24", "A" -> "", "B" -> "23", "C" -> "25", "D" -> "")))

  }

}
