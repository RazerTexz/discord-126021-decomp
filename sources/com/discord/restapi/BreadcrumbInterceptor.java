package com.discord.restapi;

import com.discord.utilities.logging.Logger;
import d0.z.d.m;
import f0.w;
import okhttp3.Interceptor;
import okhttp3.Interceptor$Chain;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: RestInterceptors.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BreadcrumbInterceptor implements Interceptor {
    private final Logger logger;

    public BreadcrumbInterceptor(Logger logger) {
        m.checkNotNullParameter(logger, "logger");
        this.logger = logger;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor$Chain chain) {
        m.checkNotNullParameter(chain, "chain");
        Request requestC = chain.c();
        String str = requestC.method;
        w wVar = requestC.url;
        this.logger.recordBreadcrumb("HTTP[" + str + "] - " + wVar, "http");
        return chain.a(chain.c());
    }
}
