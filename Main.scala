import com.fasterxml.jackson.databind.ObjectMapper

import scala.io.Source

object Main {


  def main(args: Array[String]): Unit = {


    /*val filePath = args(0)
    println("File Path -> [" + filePath + "]")*/

    val dummyFilePath = "C:\\Users\\felix\\Desktop\\MediaGammaExercise\\dummy\\dummyExampleFile.txt"
    val lineList = Source.fromFile(dummyFilePath).getLines().toList

    //we dont have the Json schema, therefore we are goint to process the information unaware of the raw input format we are handling
    val jsonExample = "{\"bid_time\": 1528731746.0, \"app\": {\"bundle\": [\"com.enflick.android.textnow\"], \"cat\": [\"iab12\\\\,iab17\\\\,iab19\"]}, \"regs\": {\"coppa\": [-1]}, \"site\": {\"content\": {\"userrating\": [null], \"language\": [null]}, \"domain\": [\"www.vervemobile.com\"], \"id\": [null]}, \"imp\": [{\"video\": {}, \"ext\": {\"placement\": [\"rp/443196\"], \"placement_type\": [\"banner\"], \"environment_type\": [\"app\"]}, \"banner\": {\"h\": [50], \"battr\": [null], \"w\": [320]}, \"instl\": [\"0\"]}], \"ext\": {\"segment\": [\"phunware-196\\\\,phunware-147\\\\,phunware-148\\\\,phunware-228\\\\,phunware-229\\\\,phunware-85\\\\,phunware-108\\\\,\"], \"targeting_geo\": {\"country\": [\"usa\"], \"region\": [\"usa/md\"], \"metro\": [\"512\"], \"city\": [\"4347778\"]}, \"inventory_source\": [\"rubicon\"], \"time_of_week\": [2382]}, \"device\": {\"ext\": {\"augomented_os\": [\"android\"], \"augmented_model\": [\"z899vl\"], \"augmented_browser\": [\"chrome mobile\"], \"augmented_browser_version\": [\"67\"], \"augomented_osv\": [\"7.1\"], \"augmented_make\": [\"zte\"], \"augmented_device_screen_size\": [\"l\"]}, \"carrier\": [null], \"devicetype\": [\"mobile\"], \"connectiontype\": [\"connection_unknown\"], \"js\": [\"1\"]}}"

    val mapper = new ObjectMapper()
    val inputObject = mapper.readValue(jsonExample, classOf[InputObject])

    val extractedFeatures = FeatureUtils.excludeFeatures(inputObject, "bid_time", "cat")
    val sparseVector = FeatureUtils.transformToSparseVector(extractedFeatures)

    println(sparseVector)

    println("hellor world")

  }
}
