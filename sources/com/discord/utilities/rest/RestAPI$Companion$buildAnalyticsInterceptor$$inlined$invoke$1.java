package com.discord.utilities.rest;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.AnalyticSuperProperties;
import d0.t.h0;
import d0.z.d.m;
import f0.e0.c;
import f0.w;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.Headers$a;
import okhttp3.Interceptor;
import okhttp3.Interceptor$Chain;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: compiled from: Interceptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestAPI$Companion$buildAnalyticsInterceptor$$inlined$invoke$1 implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor$Chain chain) {
        m.checkParameterIsNotNull(chain, "chain");
        Request requestC = chain.c();
        m.checkParameterIsNotNull(requestC, "request");
        new LinkedHashMap();
        w wVar = requestC.url;
        String str = requestC.method;
        RequestBody requestBody = requestC.body;
        Map linkedHashMap = requestC.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String.isEmpty() ? new LinkedHashMap() : h0.toMutableMap(requestC.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String);
        Headers$a headers$aE = requestC.headers.e();
        String superPropertiesStringBase64 = AnalyticSuperProperties.INSTANCE.getSuperPropertiesStringBase64();
        m.checkParameterIsNotNull("X-Super-Properties", ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkParameterIsNotNull(superPropertiesStringBase64, "value");
        headers$aE.a("X-Super-Properties", superPropertiesStringBase64);
        if (wVar != null) {
            return chain.a(new Request(wVar, str, headers$aE.c(), requestBody, c.A(linkedHashMap)));
        }
        throw new IllegalStateException("url == null".toString());
    }
}
