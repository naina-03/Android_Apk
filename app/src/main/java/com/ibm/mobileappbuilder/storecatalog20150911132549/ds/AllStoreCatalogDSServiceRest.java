
package com.ibm.mobileappbuilder.storecatalog20150911132549.ds;
import java.util.List;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
import retrofit.http.POST;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.Path;
import retrofit.http.PUT;
import retrofit.mime.TypedByteArray;
import retrofit.http.Part;
import retrofit.http.Multipart;

public interface AllStoreCatalogDSServiceRest{

	@GET("/app/57ef4d8257acb00300064a39/r/allStoreCatalogDS")
	void queryAllStoreCatalogDSItem(
		@Query("skip") String skip,
		@Query("limit") String limit,
		@Query("conditions") String conditions,
		@Query("sort") String sort,
		@Query("select") String select,
		@Query("populate") String populate,
		Callback<List<AllStoreCatalogDSItem>> cb);

	@GET("/app/57ef4d8257acb00300064a39/r/allStoreCatalogDS/{id}")
	void getAllStoreCatalogDSItemById(@Path("id") String id, Callback<AllStoreCatalogDSItem> cb);

	@DELETE("/app/57ef4d8257acb00300064a39/r/allStoreCatalogDS/{id}")
  void deleteAllStoreCatalogDSItemById(@Path("id") String id, Callback<AllStoreCatalogDSItem> cb);

  @POST("/app/57ef4d8257acb00300064a39/r/allStoreCatalogDS/deleteByIds")
  void deleteByIds(@Body List<String> ids, Callback<List<AllStoreCatalogDSItem>> cb);

  @POST("/app/57ef4d8257acb00300064a39/r/allStoreCatalogDS")
  void createAllStoreCatalogDSItem(@Body AllStoreCatalogDSItem item, Callback<AllStoreCatalogDSItem> cb);

  @PUT("/app/57ef4d8257acb00300064a39/r/allStoreCatalogDS/{id}")
  void updateAllStoreCatalogDSItem(@Path("id") String id, @Body AllStoreCatalogDSItem item, Callback<AllStoreCatalogDSItem> cb);

  @GET("/app/57ef4d8257acb00300064a39/r/allStoreCatalogDS")
  void distinct(
        @Query("distinct") String colName,
        @Query("conditions") String conditions,
        Callback<List<String>> cb);
    
    @Multipart
    @POST("/app/57ef4d8257acb00300064a39/r/allStoreCatalogDS")
    void createAllStoreCatalogDSItem(
        @Part("data") AllStoreCatalogDSItem item,
        @Part("picture") TypedByteArray picture,
        Callback<AllStoreCatalogDSItem> cb);
    
    @Multipart
    @PUT("/app/57ef4d8257acb00300064a39/r/allStoreCatalogDS/{id}")
    void updateAllStoreCatalogDSItem(
        @Path("id") String id,
        @Part("data") AllStoreCatalogDSItem item,
        @Part("picture") TypedByteArray picture,
        Callback<AllStoreCatalogDSItem> cb);
}

