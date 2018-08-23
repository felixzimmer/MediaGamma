
import scala.collection.mutable.ListBuffer

//This object provide the feature utility functions
object FeatureUtils {

  import collection.JavaConverters._

  def extractFeatures(inputObject: InputObject, features: String*): Seq[(String, String)] = {

    val allFeatures = getAllFeatures(inputObject)

    features.map(feat => {
      allFeatures.find(x => x._1 == feat) match {
        case Some(x) => x
        case _ => ((feat, "0"))
      }

    })
  }

  def excludeFeatures(inputObject: InputObject, features: String*): Seq[(String, String)] = {
    val allFeatures = getAllFeatures(inputObject)
    allFeatures.filter(feat => !features.contains(feat._1))
  }

  //TODO: work_in_progress
  def expandFeatures(feature: String, expandFeature: String) = {

  }

  def transformToSparseVector(inputSeq: Seq[(String, String)]): String = {
    val zippedInputSequence = "{" + inputSeq.zipWithIndex.map { case ((featureName, featureValue), index) => {

      index + ": " + featureValue
    }
    }.mkString(",") + "}"

    "(" + inputSeq.size + "," + zippedInputSequence + ")"
  }


  private def getAllFeatures(inputObject: InputObject): List[(String, String)] = {

    val featureList = ListBuffer.empty[(String, String)]

    featureList += (("bid_time", inputObject.getBidTime))
    featureList += (("bundle", inputObject.getBundleList.asScala.toList.mkString(";")))
    featureList += (("cat", inputObject.getCatList.asScala.toList.mkString(";")))
    featureList += (("coppa", inputObject.getCoppaList.asScala.toList.mkString(";")))
    featureList += (("userrating", inputObject.getUserRatingList.asScala.toList.mkString(";")))
    featureList += (("language", inputObject.getLanguageList.asScala.toList.mkString(";")))
    featureList += (("domain", inputObject.getDomainList.asScala.toList.mkString(";")))
    featureList += (("id", inputObject.getIdList.asScala.toList.mkString(";")))
    featureList += (("segment", inputObject.getSegmentList.asScala.toList.mkString(";")))
    featureList += (("country", inputObject.getTargetingCountry.asScala.toList.mkString(";")))
    featureList += (("region", inputObject.getTargetingRegion.asScala.toList.mkString(";")))
    featureList += (("metro", inputObject.getTargetingMetro.asScala.toList.mkString(";")))
    featureList += (("city", inputObject.getTargetingCity.asScala.toList.mkString(";")))
    featureList += (("inventory_source", inputObject.getInventorySourceList.asScala.toList.mkString(";")))
    featureList += (("time_of_week", inputObject.getTimeOfWeekList.asScala.toList.mkString(";")))
    featureList += (("augomented_os", inputObject.getAugomentedOsList.asScala.toList.mkString(";")))
    featureList += (("augmented_model", inputObject.getAugmentedModelList.asScala.toList.mkString(";")))
    featureList += (("augmented_browser", inputObject.getAugmentedBrowserList.asScala.toList.mkString(";")))
    featureList += (("augmented_browser_version", inputObject.getAugmentedBrowserVersionList.asScala.toList.mkString(";")))
    featureList += (("augomented_osv", inputObject.getAugmentedOsvList.asScala.toList.mkString(";")))
    featureList += (("augmented_make", inputObject.getAugmentedMakeList.asScala.toList.mkString(";")))


    featureList += (("augmented_device_screen_size", inputObject.getAugmentedDeviceScreenSizeList.asScala.toList.mkString(";")))
    featureList += (("carrier", inputObject.getCarrierList.asScala.toList.mkString(";")))
    featureList += (("devicetype", inputObject.getDeviceTypeList.asScala.toList.mkString(";")))
    featureList += (("connectiontype", inputObject.getConnectionTypeList.asScala.toList.mkString(";")))

    featureList += (("js", inputObject.getJsList.asScala.toList.mkString(";")))

    //we are going to merge every value as a concatenation of strings...
    val inputObjectTupleList = inputObject.getImpObjectList.asScala.toList
      .map(impObject => {
        (impObject.getVideoMap.asScala.mkString("|"), impObject.getPlacementList.asScala.mkString("|"), impObject.getPlacementTypeList.asScala.mkString("|"),
          impObject.getEnviromentTypeList.asScala.mkString("|"), impObject.getBannerHList.asScala.mkString("|"), impObject.getBannerBattrList.asScala.mkString("|"),
          impObject.getBannerWList.asScala.mkString("|"), impObject.getInstlList.asScala.mkString("|"))
      })

    featureList += (("video", inputObjectTupleList.map(_._1).mkString(";")))
    featureList += (("placement", inputObjectTupleList.map(_._2).mkString(";")))
    featureList += (("placement_type", inputObjectTupleList.map(_._3).mkString(";")))
    featureList += (("environment_type", inputObjectTupleList.map(_._4).mkString(";")))
    featureList += (("h", inputObjectTupleList.map(_._5).mkString(";")))
    featureList += (("battr", inputObjectTupleList.map(_._6).mkString(";")))
    featureList += (("w", inputObjectTupleList.map(_._7).mkString(";")))
    featureList += (("instl", inputObjectTupleList.map(_._8).mkString(";")))

    featureList.toList
  }

}
