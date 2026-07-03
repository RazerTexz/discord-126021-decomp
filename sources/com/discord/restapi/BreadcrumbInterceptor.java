package com.discord.restapi;

import com.discord.utilities.logging.Logger;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12379w;

/* JADX INFO: compiled from: RestInterceptors.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BreadcrumbInterceptor implements Interceptor {
    private final Logger logger;

    public BreadcrumbInterceptor(Logger logger) {
        C12238m.checkNotNullParameter(logger, "logger");
        this.logger = logger;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        C12238m.checkNotNullParameter(chain, "chain");
        Request requestMo10230c = chain.mo10230c();
        String str = requestMo10230c.method;
        C12379w c12379w = requestMo10230c.url;
        this.logger.recordBreadcrumb("HTTP[" + str + "] - " + c12379w, "http");
        return chain.mo10228a(chain.mo10230c());
    }
}
