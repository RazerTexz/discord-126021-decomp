package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import f0.HttpUrl;
import f0.e0.Util7;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: renamed from: com.discord.restapi.RequiredHeadersInterceptor, reason: use source file name */
/* JADX INFO: compiled from: RestInterceptors.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestInterceptors2 implements Interceptor {
    private final HeadersProvider headersProvider;

    /* JADX INFO: renamed from: com.discord.restapi.RequiredHeadersInterceptor$HeadersProvider */
    /* JADX INFO: compiled from: RestInterceptors.kt */
    public interface HeadersProvider {
        String getAcceptLanguages();

        String getAuthToken();

        String getFingerprint();

        String getLocale();

        String getSpotifyToken();

        String getUserAgent();
    }

    public RestInterceptors2(HeadersProvider headersProvider) {
        Intrinsics3.checkNotNullParameter(headersProvider, "headersProvider");
        this.headersProvider = headersProvider;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics3.checkNotNullParameter(chain, "chain");
        String authToken = this.headersProvider.getAuthToken();
        String fingerprint = this.headersProvider.getFingerprint();
        String locale = this.headersProvider.getLocale();
        String userAgent = this.headersProvider.getUserAgent();
        String acceptLanguages = this.headersProvider.getAcceptLanguages();
        Request requestC = chain.c();
        Intrinsics3.checkParameterIsNotNull(requestC, "request");
        new LinkedHashMap();
        HttpUrl httpUrl = requestC.url;
        String str = requestC.method;
        RequestBody requestBody = requestC.body;
        Map linkedHashMap = requestC.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String.isEmpty() ? new LinkedHashMap() : Maps6.toMutableMap(requestC.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String);
        Headers.a aVarE = requestC.headers.e();
        Intrinsics3.checkParameterIsNotNull("User-Agent", ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkParameterIsNotNull(userAgent, "value");
        aVarE.a("User-Agent", userAgent);
        if (authToken != null) {
            Intrinsics3.checkParameterIsNotNull("Authorization", ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkParameterIsNotNull(authToken, "value");
            aVarE.a("Authorization", authToken);
        }
        if (fingerprint != null) {
            Intrinsics3.checkParameterIsNotNull("X-Fingerprint", ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkParameterIsNotNull(fingerprint, "value");
            aVarE.a("X-Fingerprint", fingerprint);
        }
        if (locale != null) {
            Intrinsics3.checkParameterIsNotNull("X-Discord-Locale", ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkParameterIsNotNull(locale, "value");
            aVarE.a("X-Discord-Locale", locale);
        }
        if (acceptLanguages != null) {
            Intrinsics3.checkParameterIsNotNull("Accept-Language", ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkParameterIsNotNull(acceptLanguages, "value");
            aVarE.a("Accept-Language", acceptLanguages);
        }
        if (httpUrl != null) {
            return chain.a(new Request(httpUrl, str, aVarE.c(), requestBody, Util7.A(linkedHashMap)));
        }
        throw new IllegalStateException("url == null".toString());
    }
}
