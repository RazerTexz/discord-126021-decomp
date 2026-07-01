package com.discord.gateway.rest;

import android.content.Context;
import com.discord.models.domain.ModelGateway;
import com.discord.restapi.RestAPIBuilder;
import com.discord.restapi.RestInterceptors2;
import com.discord.restapi.utils.RetryWithDelay;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.SpreadBuilder;
import j0.k.Func1;
import j0.p.Schedulers2;
import java.util.List;
import java.util.Objects;
import okhttp3.Interceptor;
import rx.Observable;

/* JADX INFO: compiled from: RestClient.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestClient {
    public static final RestClient INSTANCE = new RestClient();
    private static RestApi restApi;

    private RestClient() {
    }

    public final Observable<String> getGateway() {
        RetryWithDelay retryWithDelay = RetryWithDelay.INSTANCE;
        RestApi restApi2 = restApi;
        if (restApi2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("restApi");
        }
        Observable<ModelGateway> observableX = restApi2.getGateway().X(Schedulers2.c());
        Intrinsics3.checkNotNullExpressionValue(observableX, "restApi\n          .getGa…scribeOn(Schedulers.io())");
        Observable<String> observableG = RetryWithDelay.restRetry$default(retryWithDelay, observableX, 0L, null, null, 7, null).G(new Func1<ModelGateway, String>() { // from class: com.discord.gateway.rest.RestClient.getGateway.1
            @Override // j0.k.Func1
            public final String call(ModelGateway modelGateway) {
                Intrinsics3.checkNotNullExpressionValue(modelGateway, "it");
                return modelGateway.getUrl();
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "restApi\n          .getGa…          .map { it.url }");
        return observableG;
    }

    public final void init(RestConfig restConfig, Context context) {
        Intrinsics3.checkNotNullParameter(restConfig, "restConfig");
        Intrinsics3.checkNotNullParameter(context, "context");
        String baseUrl = restConfig.getBaseUrl();
        RestInterceptors2.HeadersProvider headersProvider = restConfig.getHeadersProvider();
        List<Interceptor> listComponent3 = restConfig.component3();
        RestInterceptors2 restInterceptors2 = new RestInterceptors2(headersProvider);
        PersistentCookieJar persistentCookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context));
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(restInterceptors2);
        Object[] array = listComponent3.toArray(new Interceptor[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        spreadBuilder.addSpread(array);
        restApi = (RestApi) new RestAPIBuilder(baseUrl, persistentCookieJar).build(RestApi.class, (102 & 2) != 0 ? false : false, (102 & 4) != 0 ? 10000L : 0L, (102 & 8) != 0 ? null : Collections2.listOf(spreadBuilder.toArray(new Interceptor[spreadBuilder.size()])), (102 & 16) == 0 ? null : null, (102 & 32) != 0, (102 & 64) != 0 ? RestAPIBuilder.CONTENT_TYPE_JSON : null);
    }
}
