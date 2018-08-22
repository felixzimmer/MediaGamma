import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

//This class flattens the Json info, so we can retrieve the features easily
@JsonIgnoreProperties(ignoreUnknown = true)
public class InputObject {

    @JsonProperty("bid_time")
    private String bidTime;

    private List<String> bundleList;
    private List<String> catList;
    private List<String> coppaList;
    private List<String> userRatingList;
    private List<String> languageList;
    private List<String> domainList;
    private List<String> idList;

    //TODO: imp is a little bit different, let's leave it here for the moment
    private List<LinkedHashMap<String, Object>> videoProperty;
    private List<String> placementList;
    private List<String> envireomentTypeList;
    private List<String> bannerHList;
    private List<String> bannerBattrList;
    private List<String> bannerWList;
    private List<String> instlList;



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

 /*   @SuppressWarnings("unchecked")
    @JsonProperty("imp")
    private void unpackNestedImp(List<Map<String, Object>> imp) {

        for (Map<String,Object> element : imp) {

            //retrieve video info
            LinkedHashMap<String,Object> videoLinkedHashMap = (LinkedHashMap<String, Object>)element.get("video");
            if (videoLinkedHashMap != null && videoProperty == null) {
                this.videoProperty = new ArrayList<>();
            }
            this.videoProperty.add((LinkedHashMap<String, Object>)element.get("video"));




            //

        }
        System.out.println("asd");
    }*/




}
