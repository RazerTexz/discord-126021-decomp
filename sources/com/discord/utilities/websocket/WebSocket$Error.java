package com.discord.utilities.websocket;

import d0.z.d.m;
import okhttp3.Response;

/* JADX INFO: compiled from: WebSocket.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WebSocket$Error {
    private final Response response;
    private final Throwable throwable;

    public WebSocket$Error(Throwable th, Response response) {
        m.checkNotNullParameter(th, "throwable");
        this.throwable = th;
        this.response = response;
    }

    public final Response getResponse() {
        return this.response;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }
}
