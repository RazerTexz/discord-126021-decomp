package com.discord.gateway.rest;

import com.discord.restapi.RequiredHeadersInterceptor;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Interceptor;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: RestConfig.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestConfig {
    private final String baseUrl;
    private final RequiredHeadersInterceptor.HeadersProvider headersProvider;
    private final List<Interceptor> optionalInterceptors;

    /* JADX WARN: Multi-variable type inference failed */
    public RestConfig(String str, RequiredHeadersInterceptor.HeadersProvider headersProvider, List<? extends Interceptor> list) {
        C12238m.checkNotNullParameter(str, "baseUrl");
        C12238m.checkNotNullParameter(headersProvider, "headersProvider");
        C12238m.checkNotNullParameter(list, "optionalInterceptors");
        this.baseUrl = str;
        this.headersProvider = headersProvider;
        this.optionalInterceptors = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RestConfig copy$default(RestConfig restConfig, String str, RequiredHeadersInterceptor.HeadersProvider headersProvider, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = restConfig.baseUrl;
        }
        if ((i & 2) != 0) {
            headersProvider = restConfig.headersProvider;
        }
        if ((i & 4) != 0) {
            list = restConfig.optionalInterceptors;
        }
        return restConfig.copy(str, headersProvider, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final RequiredHeadersInterceptor.HeadersProvider getHeadersProvider() {
        return this.headersProvider;
    }

    public final List<Interceptor> component3() {
        return this.optionalInterceptors;
    }

    public final RestConfig copy(String baseUrl, RequiredHeadersInterceptor.HeadersProvider headersProvider, List<? extends Interceptor> optionalInterceptors) {
        C12238m.checkNotNullParameter(baseUrl, "baseUrl");
        C12238m.checkNotNullParameter(headersProvider, "headersProvider");
        C12238m.checkNotNullParameter(optionalInterceptors, "optionalInterceptors");
        return new RestConfig(baseUrl, headersProvider, optionalInterceptors);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestConfig)) {
            return false;
        }
        RestConfig restConfig = (RestConfig) other;
        return C12238m.areEqual(this.baseUrl, restConfig.baseUrl) && C12238m.areEqual(this.headersProvider, restConfig.headersProvider) && C12238m.areEqual(this.optionalInterceptors, restConfig.optionalInterceptors);
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final RequiredHeadersInterceptor.HeadersProvider getHeadersProvider() {
        return this.headersProvider;
    }

    public final List<Interceptor> getOptionalInterceptors() {
        return this.optionalInterceptors;
    }

    public int hashCode() {
        String str = this.baseUrl;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        RequiredHeadersInterceptor.HeadersProvider headersProvider = this.headersProvider;
        int iHashCode2 = (iHashCode + (headersProvider != null ? headersProvider.hashCode() : 0)) * 31;
        List<Interceptor> list = this.optionalInterceptors;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("RestConfig(baseUrl=");
        sbM833U.append(this.baseUrl);
        sbM833U.append(", headersProvider=");
        sbM833U.append(this.headersProvider);
        sbM833U.append(", optionalInterceptors=");
        return C1643a.m824L(sbM833U, this.optionalInterceptors, ")");
    }

    public /* synthetic */ RestConfig(String str, RequiredHeadersInterceptor.HeadersProvider headersProvider, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, headersProvider, (i & 4) != 0 ? C12147n.emptyList() : list);
    }
}
