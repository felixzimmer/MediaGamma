import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

//This class flattens the Json info, so we can retrieve the features easily
@JsonIgnoreProperties(ignoreUnknown = true)
public class InputObject {

    @JsonProperty("bid_time")
    private String bidTime;

    //features regarding "app" element
    private List<String> bundleList;
    private List<String> catList;

    //feature regarding the "regs" element
    private List<String> coppaList;

    //features regarding the "site" element
    private List<String> userRatingList;
    private List<String> languageList;
    private List<String> domainList;
    private List<String> idList;

    //features regarding the "imp" element
    private List<ImpObject> impObjectList;

    //features regarding the "ext" element
    private List<String> segmentList;
    private List<String> targetingCountry;
    private List<String> targetingRegion;
    private List<String> targetingMetro;
    private List<String> targetingCity;
    private List<String> inventorySourceList;
    private List<String> timeOfWeekList;

    //features regarding the "device" element
    private List<String> augomentedOsList;
    private List<String> augmentedModelList;
    private List<String> augmentedBrowserList;
    private List<String> augmentedBrowserVersionList;
    private List<String> augmentedOsvList;
    private List<String> augmentedMakeList;
    private List<String> augmentedDeviceScreenSizeList;
    private List<String> carrierList;
    private List<String> deviceTypeList;
    private List<String> connectionTypeList;
    private List<String> jsList;


    public InputObject() {
        //noop
    }

    @SuppressWarnings("unchecked")
    @JsonProperty("app")
    private void unpackNestedApp(Map<String, Object> app) {
        this.bundleList = (List<String>) app.get("bundle");
        this.catList = (List<String>) app.get("cat");
    }

    @SuppressWarnings("unchecked")
    @JsonProperty("regs")
    private void unpackNestedRegs(Map<String, Object> regs) {
        this.coppaList = (List<String>) regs.get("coppa");
    }

    @SuppressWarnings("unchecked")
    @JsonProperty("site")
    private void unpackNestedSite(Map<String, Object> site) {
        Map<String, Object> contentMap = (Map<String, Object>) site.get("content");
        this.userRatingList = (List<String>) contentMap.get("userrating");
        this.languageList = (List<String>) contentMap.get("language");

        this.domainList = (List<String>) site.get("domain");
        this.idList = (List<String>) site.get("id");
    }

    @SuppressWarnings("unchecked")
    @JsonProperty("ext")
    private void unpackNestExt(Map<String, Object> ext) {
        this.segmentList = (List<String>) ext.get("segment");

        Map<String, Object> targetingGeoMap = (Map<String, Object>)ext.get("targeting_geo");
        this.targetingCountry = (List<String>) targetingGeoMap.get("country");
        this.targetingRegion = (List<String>) targetingGeoMap.get("region");
        this.targetingMetro = (List<String>) targetingGeoMap.get("metro");
        this.targetingCity = (List<String>) targetingGeoMap.get("city");

        this.inventorySourceList = (List<String>) ext.get("inventory_source");
        this.timeOfWeekList = (List<String>) ext.get("time_of_week");
    }

    @SuppressWarnings("unchecked")
    @JsonProperty("device")
    private void unpackNestedDevice(Map<String, Object> device) {
        Map<String,Object> extMap = (Map<String, Object>) device.get("ext");

        if (extMap != null) {
            this.augomentedOsList = (List<String>) extMap.get("augomented_os");
            this.augmentedModelList = (List<String>) extMap.get("augmented_model");
            this.augmentedBrowserList = (List<String>) extMap.get("augmented_browser");
            this.augmentedBrowserVersionList = (List<String>) extMap.get("augmented_browser_version");
            this.augmentedOsvList = (List<String>) extMap.get("augomented_osv");
            this.augmentedMakeList = (List<String>) extMap.get("augmented_make");
            this.augmentedDeviceScreenSizeList = (List<String>) extMap.get("augmented_device_screen_size");
        }

        this.carrierList = (List<String>) device.get("carrier");
        this.deviceTypeList = (List<String>) device.get("devicetype");
        this.connectionTypeList = (List<String>) device.get("connectiontype");
        this.jsList = (List<String>) device.get("js");

    }

    @SuppressWarnings("unchecked")
    @JsonProperty("imp")
    private void unpackNestedImp(List<Map<String, Object>> imp) {

        for (Map<String,Object> element : imp) {

            LinkedHashMap<String,Object> videoLinkedHashMap = (LinkedHashMap<String, Object>)element.get("video");


            List<String> placementList = null;
            List<String> placementTypeList = null;
            List<String> enviromentTypeList = null;

            Map<String, Object> extMap = (Map<String,Object>) element.get("ext");

            if (extMap != null) {
                placementList = (List<String>) extMap.get("placement");
                placementTypeList = (List<String>) extMap.get("placement_type");
                enviromentTypeList = (List<String>) extMap.get("environment_type");
            }

            List<String> bannerHList = null;
            List<String> bannerBattrList = null;
            List<String> bannerWList = null;

            Map<String, Object> bannerMap = (Map<String, Object>) element.get("banner");

            if (bannerMap != null) {
                bannerHList = (List<String>) bannerMap.get("h");
                bannerBattrList = (List<String>) bannerMap.get("battr");
                bannerWList = (List<String>) bannerMap.get("w");
            }

            List<String> instlList = (List<String>) element.get("instl");

            ImpObject impObject = new ImpObject(videoLinkedHashMap, placementList, placementTypeList, enviromentTypeList, bannerHList, bannerBattrList, bannerWList, instlList);


            if (impObjectList == null) {
                impObjectList = new ArrayList<>();
            }

            impObjectList.add(impObject);

        }
    }

    public String getBidTime() {
        return bidTime;
    }

    public List<String> getBundleList() {
        return bundleList;
    }

    public List<String> getCatList() {
        return catList;
    }

    public List<String> getCoppaList() {
        return coppaList;
    }

    public List<String> getUserRatingList() {
        return userRatingList;
    }

    public List<String> getLanguageList() {
        return languageList;
    }

    public List<String> getDomainList() {
        return domainList;
    }

    public List<String> getIdList() {
        return idList;
    }

    public List<ImpObject> getImpObjectList() {
        return impObjectList;
    }

    public List<String> getSegmentList() {
        return segmentList;
    }

    public List<String> getTargetingCountry() {
        return targetingCountry;
    }

    public List<String> getTargetingRegion() {
        return targetingRegion;
    }

    public List<String> getTargetingMetro() {
        return targetingMetro;
    }

    public List<String> getTargetingCity() {
        return targetingCity;
    }

    public List<String> getInventorySourceList() {
        return inventorySourceList;
    }

    public List<String> getTimeOfWeekList() {
        return timeOfWeekList;
    }

    public List<String> getAugomentedOsList() {
        return augomentedOsList;
    }

    public List<String> getAugmentedModelList() {
        return augmentedModelList;
    }

    public List<String> getAugmentedBrowserList() {
        return augmentedBrowserList;
    }

    public List<String> getAugmentedBrowserVersionList() {
        return augmentedBrowserVersionList;
    }

    public List<String> getAugmentedOsvList() {
        return augmentedOsvList;
    }

    public List<String> getAugmentedMakeList() {
        return augmentedMakeList;
    }

    public List<String> getAugmentedDeviceScreenSizeList() {
        return augmentedDeviceScreenSizeList;
    }

    public List<String> getCarrierList() {
        return carrierList;
    }

    public List<String> getDeviceTypeList() {
        return deviceTypeList;
    }

    public List<String> getConnectionTypeList() {
        return connectionTypeList;
    }

    public List<String> getJsList() {
        return jsList;
    }

    public class ImpObject {

        private Map<String,Object> videoMap;
        private List<String> placementList;
        private List<String> placementTypeList;
        private List<String> enviromentTypeList;
        private List<String> bannerHList;
        private List<String> bannerBattrList;
        private List<String> bannerWList;
        private List<String> instlList;


        private ImpObject(Map<String, Object> videoMap,
                          List<String> placementList,
                          List<String> placementTypeList,
                          List<String> enviromentTypeList,
                          List<String> bannerHList,
                          List<String> bannerBattrList,
                          List<String> bannerWList,
                          List<String> instlList) {

            this.videoMap = videoMap;
            this.placementList = placementList;
            this.placementTypeList = placementTypeList;
            this.enviromentTypeList = enviromentTypeList;
            this.bannerHList = bannerHList;
            this.bannerBattrList = bannerBattrList;
            this.bannerWList = bannerWList;
            this.instlList = instlList;
        }

        public Map<String, Object> getVideoMap() {
            return videoMap;
        }

        public List<String> getPlacementList() {
            return placementList;
        }

        public List<String> getPlacementTypeList() {
            return placementTypeList;
        }

        public List<String> getEnviromentTypeList() {
            return enviromentTypeList;
        }

        public List<String> getBannerHList() {
            return bannerHList;
        }

        public List<String> getBannerBattrList() {
            return bannerBattrList;
        }

        public List<String> getBannerWList() {
            return bannerWList;
        }

        public List<String> getInstlList() {
            return instlList;
        }
    }

}
