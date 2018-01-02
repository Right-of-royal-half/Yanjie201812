package jingou.jo.com.yanjie201812.url;

import jingou.jo.com.yanjie201812.net.Api;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 杨杰 on 2018/1/2.
 */

public class RetrfitHelper {
    private static OkHttpClient okHttpClient;

    private static ServiceApi serviceApi;

    static {



        initokhttp();



    }



    private static void initokhttp() {

        if (okHttpClient==null){



            synchronized (RetrfitHelper.class){



                if (okHttpClient==null){



                    okHttpClient= new OkHttpClient.Builder()



                            .build();



                }



            }



        }

    }

    public static  ServiceApi getserviceapi(){



        if (serviceApi==null){



            synchronized (RetrfitHelper.class){



                if (serviceApi==null){



                    serviceApi = onCreatApi(ServiceApi.class, Api.HOST);

                }



            }



        }



        return serviceApi;



    }



    public static <T> T onCreatApi(Class<T> tClass,String url){



        Retrofit retrofit = new Retrofit.Builder()



                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())



                .addConverterFactory(GsonConverterFactory.create())



                .baseUrl(url)



                .build();



        return retrofit.create(tClass);



    }




}
