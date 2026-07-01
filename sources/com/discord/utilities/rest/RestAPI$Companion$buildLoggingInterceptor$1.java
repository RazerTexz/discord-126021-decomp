package com.discord.utilities.rest;

import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import d0.z.d.m;
import f0.f0.a$b;

/* JADX INFO: compiled from: RestAPI.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestAPI$Companion$buildLoggingInterceptor$1 implements a$b {
    @Override // f0.f0.a$b
    public void log(String message) {
        m.checkNotNullParameter(message, "message");
        Logger.v$default(AppLog.g, message, null, 2, null);
    }
}
