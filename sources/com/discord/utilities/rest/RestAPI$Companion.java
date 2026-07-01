package com.discord.utilities.rest;

import android.content.Context;
import com.discord.BuildConfig;
import com.discord.app.AppLog;
import com.discord.restapi.BreadcrumbInterceptor;
import com.discord.restapi.RequiredHeadersInterceptor;
import com.discord.restapi.RestAPIBuilder;
import com.discord.restapi.RestAPIInterface;
import com.discord.restapi.RestAPIInterface$Dynamic;
import com.discord.restapi.RestAPIInterface$Files;
import com.discord.restapi.RestAPIInterface$RtcLatency;
import com.discord.restapi.SpotifyTokenInterceptor;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.systemlog.SystemLogUtils;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import d0.t.n;
import d0.z.d.m;
import f0.f0.a;
import f0.f0.a$a;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Interceptor;
import rx.Observable;

/* JADX INFO: compiled from: RestAPI.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestAPI$Companion {
    private RestAPI$Companion() {
    }

    public static /* synthetic */ void getApi$annotations() {
    }

    public static /* synthetic */ void getApiSerializeNulls$annotations() {
    }

    public static /* synthetic */ void getApiSpotify$annotations() {
    }

    public final Interceptor buildAnalyticsInterceptor() {
        int i = Interceptor.a;
        return new RestAPI$Companion$buildAnalyticsInterceptor$$inlined$invoke$1();
    }

    public final Interceptor buildLoggingInterceptor() {
        a aVar = new a(new RestAPI$Companion$buildLoggingInterceptor$1());
        a$a a_a = a$a.BASIC;
        m.checkParameterIsNotNull(a_a, "<set-?>");
        aVar.c = a_a;
        return aVar;
    }

    public final RestAPI getApi() {
        RestAPI restAPIAccess$getApi$cp = RestAPI.access$getApi$cp();
        if (restAPIAccess$getApi$cp == null) {
            m.throwUninitializedPropertyAccessException("api");
        }
        return restAPIAccess$getApi$cp;
    }

    public final RestAPIInterface$Dynamic getApiClientVersions() {
        RestAPIInterface$Dynamic restAPIInterface$DynamicAccess$getApiClientVersions$cp = RestAPI.access$getApiClientVersions$cp();
        if (restAPIInterface$DynamicAccess$getApiClientVersions$cp == null) {
            m.throwUninitializedPropertyAccessException("apiClientVersions");
        }
        return restAPIInterface$DynamicAccess$getApiClientVersions$cp;
    }

    public final RestAPIInterface$Files getApiFiles() {
        RestAPIInterface$Files restAPIInterface$FilesAccess$getApiFiles$cp = RestAPI.access$getApiFiles$cp();
        if (restAPIInterface$FilesAccess$getApiFiles$cp == null) {
            m.throwUninitializedPropertyAccessException("apiFiles");
        }
        return restAPIInterface$FilesAccess$getApiFiles$cp;
    }

    public final RestAPIInterface$RtcLatency getApiRtcLatency() {
        RestAPIInterface$RtcLatency restAPIInterface$RtcLatencyAccess$getApiRtcLatency$cp = RestAPI.access$getApiRtcLatency$cp();
        if (restAPIInterface$RtcLatencyAccess$getApiRtcLatency$cp == null) {
            m.throwUninitializedPropertyAccessException("apiRtcLatency");
        }
        return restAPIInterface$RtcLatencyAccess$getApiRtcLatency$cp;
    }

    public final RestAPI getApiSerializeNulls() {
        RestAPI restAPIAccess$getApiSerializeNulls$cp = RestAPI.access$getApiSerializeNulls$cp();
        if (restAPIAccess$getApiSerializeNulls$cp == null) {
            m.throwUninitializedPropertyAccessException("apiSerializeNulls");
        }
        return restAPIAccess$getApiSerializeNulls$cp;
    }

    public final RestAPI getApiSpotify() {
        RestAPI restAPIAccess$getApiSpotify$cp = RestAPI.access$getApiSpotify$cp();
        if (restAPIAccess$getApiSpotify$cp == null) {
            m.throwUninitializedPropertyAccessException("apiSpotify");
        }
        return restAPIAccess$getApiSpotify$cp;
    }

    public final void init(Context context) {
        m.checkNotNullParameter(context, "context");
        RestAPI$AppHeadersProvider restAPI$AppHeadersProvider = RestAPI$AppHeadersProvider.INSTANCE;
        RequiredHeadersInterceptor requiredHeadersInterceptor = new RequiredHeadersInterceptor(restAPI$AppHeadersProvider);
        BreadcrumbInterceptor breadcrumbInterceptor = new BreadcrumbInterceptor(AppLog.g);
        Interceptor interceptorBuildAnalyticsInterceptor = buildAnalyticsInterceptor();
        Interceptor interceptorBuildLoggingInterceptor = buildLoggingInterceptor();
        List listMutableListOf = n.mutableListOf(requiredHeadersInterceptor, interceptorBuildAnalyticsInterceptor, buildLoggingInterceptor(), breadcrumbInterceptor);
        List listListOf = n.listOf((Object[]) new Interceptor[]{interceptorBuildLoggingInterceptor, breadcrumbInterceptor});
        PersistentCookieJar persistentCookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context));
        RestAPIBuilder restAPIBuilder = new RestAPIBuilder(BuildConfig.HOST_API, persistentCookieJar);
        setApi(new RestAPI((RestAPIInterface) RestAPIBuilder.build$default(restAPIBuilder, RestAPIInterface.class, false, 0L, listMutableListOf, "client_base", false, null, 102, null)));
        setApiSerializeNulls(new RestAPI((RestAPIInterface) RestAPIBuilder.build$default(restAPIBuilder, RestAPIInterface.class, true, 0L, listMutableListOf, "client_serialize_nulls", false, null, 100, null)));
        setApiClientVersions((RestAPIInterface$Dynamic) RestAPIBuilder.build$default(restAPIBuilder, RestAPIInterface$Dynamic.class, false, 0L, listListOf, "client_dynamic", false, null, 102, null));
        setApiRtcLatency((RestAPIInterface$RtcLatency) RestAPIBuilder.build$default(restAPIBuilder, RestAPIInterface$RtcLatency.class, false, 0L, listListOf, "client_rtc_latency", false, null, 102, null));
        setApiSpotify(new RestAPI((RestAPIInterface) RestAPIBuilder.build$default(new RestAPIBuilder("https://api.spotify.com/v1/", persistentCookieJar), RestAPIInterface.class, false, 0L, n.listOf((Object[]) new Interceptor[]{interceptorBuildLoggingInterceptor, new SpotifyTokenInterceptor(restAPI$AppHeadersProvider)}), "client_spotify", false, null, 70, null)));
        setApiFiles((RestAPIInterface$Files) RestAPIBuilder.build$default(restAPIBuilder, RestAPIInterface$Files.class, false, 0L, d0.t.m.listOf(interceptorBuildLoggingInterceptor), "client_files", false, null, 102, null));
    }

    public final void setApi(RestAPI restAPI) {
        m.checkNotNullParameter(restAPI, "<set-?>");
        RestAPI.access$setApi$cp(restAPI);
    }

    public final void setApiClientVersions(RestAPIInterface$Dynamic restAPIInterface$Dynamic) {
        m.checkNotNullParameter(restAPIInterface$Dynamic, "<set-?>");
        RestAPI.access$setApiClientVersions$cp(restAPIInterface$Dynamic);
    }

    public final void setApiFiles(RestAPIInterface$Files restAPIInterface$Files) {
        m.checkNotNullParameter(restAPIInterface$Files, "<set-?>");
        RestAPI.access$setApiFiles$cp(restAPIInterface$Files);
    }

    public final void setApiRtcLatency(RestAPIInterface$RtcLatency restAPIInterface$RtcLatency) {
        m.checkNotNullParameter(restAPIInterface$RtcLatency, "<set-?>");
        RestAPI.access$setApiRtcLatency$cp(restAPIInterface$RtcLatency);
    }

    public final void setApiSerializeNulls(RestAPI restAPI) {
        m.checkNotNullParameter(restAPI, "<set-?>");
        RestAPI.access$setApiSerializeNulls$cp(restAPI);
    }

    public final void setApiSpotify(RestAPI restAPI) {
        m.checkNotNullParameter(restAPI, "<set-?>");
        RestAPI.access$setApiSpotify$cp(restAPI);
    }

    public final Observable<Void> uploadSystemLog() {
        return ObservableExtensionsKt.restSubscribeOn$default(getApi().uploadLog("android_system_log.txt", SystemLogUtils.INSTANCE.fetch()), false, 1, null);
    }

    public /* synthetic */ RestAPI$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
