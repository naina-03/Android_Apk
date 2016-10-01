
package com.ibm.mobileappbuilder.storecatalog20150911132549.ds;
import java.net.URL;
import com.ibm.mobileappbuilder.storecatalog20150911132549.R;
import ibmmobileappbuilder.ds.RestService;
import ibmmobileappbuilder.util.StringUtils;

/**
 * "ProductsDSService" REST Service implementation
 */
public class ProductsDSService extends RestService<ProductsDSServiceRest>{

    public static ProductsDSService getInstance(){
          return new ProductsDSService();
    }

    private ProductsDSService() {
        super(ProductsDSServiceRest.class);

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

