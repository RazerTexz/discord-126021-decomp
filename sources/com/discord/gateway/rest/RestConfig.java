package com.discord.gateway.rest;

import b.d.b.a.outline;
import com.discord.restapi.RestInterceptors2;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Interceptor;

/* JADX INFO: compiled from: RestConfig.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestConfig {
    private final String baseUrl;
    private final RestInterceptors2.HeadersProvider headersProvider;
    private final List<Interceptor> optionalInterceptors;

    /* JADX WARN: Multi-variable type inference failed */
    public RestConfig(String str, RestInterceptors2.HeadersProvider headersProvider, List<? extends Interceptor> list) {
        Intrinsics3.checkNotNullParameter(str, "baseUrl");
        Intrinsics3.checkNotNullParameter(headersProvider, "headersProvider");
        Intrinsics3.checkNotNullParameter(list, "optionalInterceptors");
        this.baseUrl = str;
        this.headersProvider = headersProvider;
        this.optionalInterceptors = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RestConfig copy$default(RestConfig restConfig, String str, RestInterceptors2.HeadersProvider headersProvider, List list, int i, Object obj) {
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
    public final RestInterceptors2.HeadersProvider getHeadersProvider() {
        return this.headersProvider;
    }

    public final List<Interceptor> component3() {
        return this.optionalInterceptors;
    }

    public final RestConfig copy(String baseUrl, RestInterceptors2.HeadersProvider headersProvider, List<? extends Interceptor> optionalInterceptors) {
        Intrinsics3.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics3.checkNotNullParameter(headersProvider, "headersProvider");
        Intrinsics3.checkNotNullParameter(optionalInterceptors, "optionalInterceptors");
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
        return Intrinsics3.areEqual(this.baseUrl, restConfig.baseUrl) && Intrinsics3.areEqual(this.headersProvider, restConfig.headersProvider) && Intrinsics3.areEqual(this.optionalInterceptors, restConfig.optionalInterceptors);
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final RestInterceptors2.HeadersProvider getHeadersProvider() {
        return this.headersProvider;
    }

    public final List<Interceptor> getOptionalInterceptors() {
        return this.optionalInterceptors;
    }

    public int hashCode() {
        String str = this.baseUrl;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        RestInterceptors2.HeadersProvider headersProvider = this.headersProvider;
        int iHashCode2 = (iHashCode + (headersProvider != null ? headersProvider.hashCode() : 0)) * 31;
        List<Interceptor> list = this.optionalInterceptors;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("RestConfig(baseUrl=");
        sbU.append(this.baseUrl);
        sbU.append(", headersProvider=");
        sbU.append(this.headersProvider);
        sbU.append(", optionalInterceptors=");
        return outline.L(sbU, this.optionalInterceptors, ")");
    }

    public /* synthetic */ RestConfig(String str, RestInterceptors2.HeadersProvider headersProvider, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, headersProvider, (i & 4) != 0 ? Collections2.emptyList() : list);
    }
}
