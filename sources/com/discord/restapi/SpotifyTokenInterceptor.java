package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RequiredHeadersInterceptor;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12379w;
import p600f0.p601e0.C12272c;

/* JADX INFO: compiled from: RestInterceptors.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SpotifyTokenInterceptor implements Interceptor {
    private final RequiredHeadersInterceptor.HeadersProvider headersProvider;

    public SpotifyTokenInterceptor(RequiredHeadersInterceptor.HeadersProvider headersProvider) {
        C12238m.checkNotNullParameter(headersProvider, "headersProvider");
        this.headersProvider = headersProvider;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        C12238m.checkNotNullParameter(chain, "chain");
        Request requestMo10230c = chain.mo10230c();
        C12238m.checkParameterIsNotNull(requestMo10230c, "request");
        new LinkedHashMap();
        C12379w c12379w = requestMo10230c.url;
        String str = requestMo10230c.method;
        RequestBody requestBody = requestMo10230c.body;
        Map linkedHashMap = requestMo10230c.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String.isEmpty() ? new LinkedHashMap() : C12136h0.toMutableMap(requestMo10230c.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String);
        Headers.C12930a c12930aM10956e = requestMo10230c.headers.m10956e();
        StringBuilder sbM833U = C1643a.m833U("Bearer ");
        sbM833U.append(this.headersProvider.getSpotifyToken());
        String string = sbM833U.toString();
        C12238m.checkParameterIsNotNull("Authorization", ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkParameterIsNotNull(string, "value");
        c12930aM10956e.m10958a("Authorization", string);
        if (c12379w != null) {
            return chain.mo10228a(new Request(c12379w, str, c12930aM10956e.m10960c(), requestBody, C12272c.m10116A(linkedHashMap)));
        }
        throw new IllegalStateException("url == null".toString());
    }
}
