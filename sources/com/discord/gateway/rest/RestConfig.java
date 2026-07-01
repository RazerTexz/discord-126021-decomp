package com.discord.gateway.rest;

import b.d.b.a.a;
import com.discord.restapi.RequiredHeadersInterceptor$HeadersProvider;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Interceptor;

/* JADX INFO: compiled from: RestConfig.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestConfig {
    private final String baseUrl;
    private final RequiredHeadersInterceptor$HeadersProvider headersProvider;
    private final List<Interceptor> optionalInterceptors;

    /* JADX WARN: Multi-variable type inference failed */
    public RestConfig(String str, RequiredHeadersInterceptor$HeadersProvider requiredHeadersInterceptor$HeadersProvider, List<? extends Interceptor> list) {
        m.checkNotNullParameter(str, "baseUrl");
        m.checkNotNullParameter(requiredHeadersInterceptor$HeadersProvider, "headersProvider");
        m.checkNotNullParameter(list, "optionalInterceptors");
        this.baseUrl = str;
        this.headersProvider = requiredHeadersInterceptor$HeadersProvider;
        this.optionalInterceptors = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RestConfig copy$default(RestConfig restConfig, String str, RequiredHeadersInterceptor$HeadersProvider requiredHeadersInterceptor$HeadersProvider, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = restConfig.baseUrl;
        }
        if ((i & 2) != 0) {
            requiredHeadersInterceptor$HeadersProvider = restConfig.headersProvider;
        }
        if ((i & 4) != 0) {
            list = restConfig.optionalInterceptors;
        }
        return restConfig.copy(str, requiredHeadersInterceptor$HeadersProvider, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final RequiredHeadersInterceptor$HeadersProvider getHeadersProvider() {
        return this.headersProvider;
    }

    public final List<Interceptor> component3() {
        return this.optionalInterceptors;
    }

    public final RestConfig copy(String baseUrl, RequiredHeadersInterceptor$HeadersProvider headersProvider, List<? extends Interceptor> optionalInterceptors) {
        m.checkNotNullParameter(baseUrl, "baseUrl");
        m.checkNotNullParameter(headersProvider, "headersProvider");
        m.checkNotNullParameter(optionalInterceptors, "optionalInterceptors");
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
        return m.areEqual(this.baseUrl, restConfig.baseUrl) && m.areEqual(this.headersProvider, restConfig.headersProvider) && m.areEqual(this.optionalInterceptors, restConfig.optionalInterceptors);
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final RequiredHeadersInterceptor$HeadersProvider getHeadersProvider() {
        return this.headersProvider;
    }

    public final List<Interceptor> getOptionalInterceptors() {
        return this.optionalInterceptors;
    }

    public int hashCode() {
        String str = this.baseUrl;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        RequiredHeadersInterceptor$HeadersProvider requiredHeadersInterceptor$HeadersProvider = this.headersProvider;
        int iHashCode2 = (iHashCode + (requiredHeadersInterceptor$HeadersProvider != null ? requiredHeadersInterceptor$HeadersProvider.hashCode() : 0)) * 31;
        List<Interceptor> list = this.optionalInterceptors;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("RestConfig(baseUrl=");
        sbU.append(this.baseUrl);
        sbU.append(", headersProvider=");
        sbU.append(this.headersProvider);
        sbU.append(", optionalInterceptors=");
        return a.L(sbU, this.optionalInterceptors, ")");
    }

    public /* synthetic */ RestConfig(String str, RequiredHeadersInterceptor$HeadersProvider requiredHeadersInterceptor$HeadersProvider, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, requiredHeadersInterceptor$HeadersProvider, (i & 4) != 0 ? n.emptyList() : list);
    }
}
