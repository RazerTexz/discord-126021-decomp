package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12379w;
import p600f0.p601e0.C12272c;

/* JADX INFO: compiled from: RestInterceptors.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RequiredHeadersInterceptor implements Interceptor {
    private final HeadersProvider headersProvider;

    /* JADX INFO: compiled from: RestInterceptors.kt */
    public interface HeadersProvider {
        String getAcceptLanguages();

        String getAuthToken();

        String getFingerprint();

        String getLocale();

        String getSpotifyToken();

        String getUserAgent();
    }

    public RequiredHeadersInterceptor(HeadersProvider headersProvider) {
        C12238m.checkNotNullParameter(headersProvider, "headersProvider");
        this.headersProvider = headersProvider;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        C12238m.checkNotNullParameter(chain, "chain");
        String authToken = this.headersProvider.getAuthToken();
        String fingerprint = this.headersProvider.getFingerprint();
        String locale = this.headersProvider.getLocale();
        String userAgent = this.headersProvider.getUserAgent();
        String acceptLanguages = this.headersProvider.getAcceptLanguages();
        Request requestMo10230c = chain.mo10230c();
        C12238m.checkParameterIsNotNull(requestMo10230c, "request");
        new LinkedHashMap();
        C12379w c12379w = requestMo10230c.url;
        String str = requestMo10230c.method;
        RequestBody requestBody = requestMo10230c.body;
        Map linkedHashMap = requestMo10230c.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String.isEmpty() ? new LinkedHashMap() : C12136h0.toMutableMap(requestMo10230c.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String);
        Headers.C12930a c12930aM10956e = requestMo10230c.headers.m10956e();
        C12238m.checkParameterIsNotNull("User-Agent", ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkParameterIsNotNull(userAgent, "value");
        c12930aM10956e.m10958a("User-Agent", userAgent);
        if (authToken != null) {
            C12238m.checkParameterIsNotNull("Authorization", ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkParameterIsNotNull(authToken, "value");
            c12930aM10956e.m10958a("Authorization", authToken);
        }
        if (fingerprint != null) {
            C12238m.checkParameterIsNotNull("X-Fingerprint", ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkParameterIsNotNull(fingerprint, "value");
            c12930aM10956e.m10958a("X-Fingerprint", fingerprint);
        }
        if (locale != null) {
            C12238m.checkParameterIsNotNull("X-Discord-Locale", ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkParameterIsNotNull(locale, "value");
            c12930aM10956e.m10958a("X-Discord-Locale", locale);
        }
        if (acceptLanguages != null) {
            C12238m.checkParameterIsNotNull("Accept-Language", ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkParameterIsNotNull(acceptLanguages, "value");
            c12930aM10956e.m10958a("Accept-Language", acceptLanguages);
        }
        if (c12379w != null) {
            return chain.mo10228a(new Request(c12379w, str, c12930aM10956e.m10960c(), requestBody, C12272c.m10116A(linkedHashMap)));
        }
        throw new IllegalStateException("url == null".toString());
    }
}
