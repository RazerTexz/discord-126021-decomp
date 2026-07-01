package com.discord.restapi;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestInterceptors2;
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

/* JADX INFO: renamed from: com.discord.restapi.SpotifyTokenInterceptor, reason: use source file name */
/* JADX INFO: compiled from: RestInterceptors.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestInterceptors3 implements Interceptor {
    private final RestInterceptors2.HeadersProvider headersProvider;

    public RestInterceptors3(RestInterceptors2.HeadersProvider headersProvider) {
        Intrinsics3.checkNotNullParameter(headersProvider, "headersProvider");
        this.headersProvider = headersProvider;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics3.checkNotNullParameter(chain, "chain");
        Request requestC = chain.c();
        Intrinsics3.checkParameterIsNotNull(requestC, "request");
        new LinkedHashMap();
        HttpUrl httpUrl = requestC.url;
        String str = requestC.method;
        RequestBody requestBody = requestC.body;
        Map linkedHashMap = requestC.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String.isEmpty() ? new LinkedHashMap() : Maps6.toMutableMap(requestC.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String);
        Headers.a aVarE = requestC.headers.e();
        StringBuilder sbU = outline.U("Bearer ");
        sbU.append(this.headersProvider.getSpotifyToken());
        String string = sbU.toString();
        Intrinsics3.checkParameterIsNotNull("Authorization", ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkParameterIsNotNull(string, "value");
        aVarE.a("Authorization", string);
        if (httpUrl != null) {
            return chain.a(new Request(httpUrl, str, aVarE.c(), requestBody, Util7.A(linkedHashMap)));
        }
        throw new IllegalStateException("url == null".toString());
    }
}
