package com.discord.gateway.rest;

import android.content.Context;
import com.discord.models.domain.ModelGateway;
import com.discord.restapi.RequiredHeadersInterceptor;
import com.discord.restapi.RestAPIBuilder;
import com.discord.restapi.utils.RetryWithDelay;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import java.util.List;
import java.util.Objects;
import okhttp3.Interceptor;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12220c0;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p653p.C12781a;
import p658rx.Observable;

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
            C12238m.throwUninitializedPropertyAccessException("restApi");
        }
        Observable<ModelGateway> observableM11098X = restApi2.getGateway().m11098X(C12781a.m10875c());
        C12238m.checkNotNullExpressionValue(observableM11098X, "restApi\n          .getGa…scribeOn(Schedulers.io())");
        Observable<String> observableM11083G = RetryWithDelay.restRetry$default(retryWithDelay, observableM11098X, 0L, null, null, 7, null).m11083G(new InterfaceC12589b<ModelGateway, String>() { // from class: com.discord.gateway.rest.RestClient.getGateway.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final String call(ModelGateway modelGateway) {
                C12238m.checkNotNullExpressionValue(modelGateway, "it");
                return modelGateway.getUrl();
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "restApi\n          .getGa…          .map { it.url }");
        return observableM11083G;
    }

    public final void init(RestConfig restConfig, Context context) {
        C12238m.checkNotNullParameter(restConfig, "restConfig");
        C12238m.checkNotNullParameter(context, "context");
        String baseUrl = restConfig.getBaseUrl();
        RequiredHeadersInterceptor.HeadersProvider headersProvider = restConfig.getHeadersProvider();
        List<Interceptor> listComponent3 = restConfig.component3();
        RequiredHeadersInterceptor requiredHeadersInterceptor = new RequiredHeadersInterceptor(headersProvider);
        PersistentCookieJar persistentCookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context));
        C12220c0 c12220c0 = new C12220c0(2);
        c12220c0.add(requiredHeadersInterceptor);
        Object[] array = listComponent3.toArray(new Interceptor[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        c12220c0.addSpread(array);
        restApi = (RestApi) new RestAPIBuilder(baseUrl, persistentCookieJar).build(RestApi.class, (102 & 2) != 0 ? false : false, (102 & 4) != 0 ? 10000L : 0L, (102 & 8) != 0 ? null : C12147n.listOf(c12220c0.toArray(new Interceptor[c12220c0.size()])), (102 & 16) == 0 ? null : null, (102 & 32) != 0, (102 & 64) != 0 ? RestAPIBuilder.CONTENT_TYPE_JSON : null);
    }
}
