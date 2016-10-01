
package com.ibm.mobileappbuilder.storecatalog20150911132549.ds;
import java.net.URL;
import com.ibm.mobileappbuilder.storecatalog20150911132549.R;
import ibmmobileappbuilder.ds.RestService;
import ibmmobileappbuilder.util.StringUtils;

/**
 * "AllStoreCatalogDSService" REST Service implementation
 */
public class AllStoreCatalogDSService extends RestService<AllStoreCatalogDSServiceRest>{

    public static AllStoreCatalogDSService getInstance(){
          return new AllStoreCatalogDSService();
    }

    private AllStoreCatalogDSService() {
        super(AllStoreCatalogDSServiceRest.class);

    }

    @Override
    public String getServerUrl() {
        return "https://ibm-pods.buildup.io";
    }

    @Override
    protected String getApiKey() {
        return "lKHGnaCb";
    }

    @Override
    public URL getImageUrl(String path){
        return StringUtils.parseUrl("https://ibm-pods.buildup.io/app/57ef4d8257acb00300064a39",
                path,
                "apikey=lKHGnaCb");
    }

}

