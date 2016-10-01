

package com.ibm.mobileappbuilder.storecatalog20150911132549.ds;

import android.content.Context;

import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.restds.AppNowDatasource;
import ibmmobileappbuilder.util.StringUtils;
import ibmmobileappbuilder.ds.restds.TypedByteArrayUtils;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * "AllStoreCatalogDS" data source. (e37eb8dc-6eb2-4635-8592-5eb9696050e3)
 */
public class AllStoreCatalogDS extends AppNowDatasource<AllStoreCatalogDSItem>{

    // default page size
    private static final int PAGE_SIZE = 20;

    private AllStoreCatalogDSService service;

    public static AllStoreCatalogDS getInstance(SearchOptions searchOptions){
        return new AllStoreCatalogDS(searchOptions);
    }

    private AllStoreCatalogDS(SearchOptions searchOptions) {
        super(searchOptions);
        this.service = AllStoreCatalogDSService.getInstance();
    }

    @Override
    public void getItem(String id, final Listener<AllStoreCatalogDSItem> listener) {
        if ("0".equals(id)) {
                        getItems(new Listener<List<AllStoreCatalogDSItem>>() {
                @Override
                public void onSuccess(List<AllStoreCatalogDSItem> items) {
                    if(items != null && items.size() > 0) {
                        listener.onSuccess(items.get(0));
                    } else {
                        listener.onSuccess(new AllStoreCatalogDSItem());
                    }
                }

                @Override
                public void onFailure(Exception e) {
                    listener.onFailure(e);
                }
            });
        } else {
                      service.getServiceProxy().getAllStoreCatalogDSItemById(id, new Callback<AllStoreCatalogDSItem>() {
                @Override
                public void success(AllStoreCatalogDSItem result, Response response) {
                                        listener.onSuccess(result);
                }

                @Override
                public void failure(RetrofitError error) {
                                        listener.onFailure(error);
                }
            });
        }
    }

    @Override
    public void getItems(final Listener<List<AllStoreCatalogDSItem>> listener) {
        getItems(0, listener);
    }

    @Override
    public void getItems(int pagenum, final Listener<List<AllStoreCatalogDSItem>> listener) {
        String conditions = getConditions(searchOptions, getSearchableFields());
        int skipNum = pagenum * PAGE_SIZE;
        String skip = skipNum == 0 ? null : String.valueOf(skipNum);
        String limit = PAGE_SIZE == 0 ? null: String.valueOf(PAGE_SIZE);
        String sort = getSort(searchOptions);
                service.getServiceProxy().queryAllStoreCatalogDSItem(
                skip,
                limit,
                conditions,
                sort,
                null,
                null,
                new Callback<List<AllStoreCatalogDSItem>>() {
            @Override
            public void success(List<AllStoreCatalogDSItem> result, Response response) {
                                listener.onSuccess(result);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    private String[] getSearchableFields() {
        return new String[]{"text1", "text2", "text3"};
    }

    // Pagination

    @Override
    public int getPageSize(){
        return PAGE_SIZE;
    }

    @Override
    public void getUniqueValuesFor(String searchStr, final Listener<List<String>> listener) {
        String conditions = getConditions(searchOptions, getSearchableFields());
                service.getServiceProxy().distinct(searchStr, conditions, new Callback<List<String>>() {
             @Override
             public void success(List<String> result, Response response) {
                                  result.removeAll(Collections.<String>singleton(null));
                 listener.onSuccess(result);
             }

             @Override
             public void failure(RetrofitError error) {
                                  listener.onFailure(error);
             }
        });
    }

    @Override
    public URL getImageUrl(String path) {
        return service.getImageUrl(path);
    }

    @Override
    public void create(AllStoreCatalogDSItem item, Listener<AllStoreCatalogDSItem> listener) {
                    
        if(item.pictureUri != null){
            service.getServiceProxy().createAllStoreCatalogDSItem(item,
                TypedByteArrayUtils.fromUri(item.pictureUri),
                callbackFor(listener));
        }
        else
            service.getServiceProxy().createAllStoreCatalogDSItem(item, callbackFor(listener));
        
    }

    private Callback<AllStoreCatalogDSItem> callbackFor(final Listener<AllStoreCatalogDSItem> listener) {
      return new Callback<AllStoreCatalogDSItem>() {
          @Override
          public void success(AllStoreCatalogDSItem item, Response response) {
                            listener.onSuccess(item);
          }

          @Override
          public void failure(RetrofitError error) {
                            listener.onFailure(error);
          }
      };
    }

    @Override
    public void updateItem(AllStoreCatalogDSItem item, Listener<AllStoreCatalogDSItem> listener) {
                    
        if(item.pictureUri != null){
            service.getServiceProxy().updateAllStoreCatalogDSItem(item.getIdentifiableId(),
                item,
                TypedByteArrayUtils.fromUri(item.pictureUri),
                callbackFor(listener));
        }
        else
            service.getServiceProxy().updateAllStoreCatalogDSItem(item.getIdentifiableId(), item, callbackFor(listener));
        
    }

    @Override
    public void deleteItem(AllStoreCatalogDSItem item, final Listener<AllStoreCatalogDSItem> listener) {
                service.getServiceProxy().deleteAllStoreCatalogDSItemById(item.getIdentifiableId(), new Callback<AllStoreCatalogDSItem>() {
            @Override
            public void success(AllStoreCatalogDSItem result, Response response) {
                                listener.onSuccess(result);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    @Override
    public void deleteItems(List<AllStoreCatalogDSItem> items, final Listener<AllStoreCatalogDSItem> listener) {
                service.getServiceProxy().deleteByIds(collectIds(items), new Callback<List<AllStoreCatalogDSItem>>() {
            @Override
            public void success(List<AllStoreCatalogDSItem> item, Response response) {
                                listener.onSuccess(null);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    protected List<String> collectIds(List<AllStoreCatalogDSItem> items){
        List<String> ids = new ArrayList<>();
        for(AllStoreCatalogDSItem item: items){
            ids.add(item.getIdentifiableId());
        }
        return ids;
    }

}

