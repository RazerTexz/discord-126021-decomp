package com.discord.restapi;

import com.discord.utilities.logging.Logger;
import d0.z.d.Intrinsics3;
import f0.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: renamed from: com.discord.restapi.BreadcrumbInterceptor, reason: use source file name */
/* JADX INFO: compiled from: RestInterceptors.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestInterceptors implements Interceptor {
    private final Logger logger;

    public RestInterceptors(Logger logger) {
        Intrinsics3.checkNotNullParameter(logger, "logger");
        this.logger = logger;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics3.checkNotNullParameter(chain, "chain");
        Request requestC = chain.c();
        String str = requestC.method;
        HttpUrl httpUrl = requestC.url;
        this.logger.recordBreadcrumb("HTTP[" + str + "] - " + httpUrl, "http");
        return chain.a(chain.c());
    }
}
