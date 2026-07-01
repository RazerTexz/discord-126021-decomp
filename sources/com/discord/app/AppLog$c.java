package com.discord.app;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: AppLog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AppLog$c extends k implements Function2<String, Throwable, Unit> {
    public AppLog$c(AppLog appLog) {
        super(2, appLog, AppLog.class, "v", "v(Ljava/lang/String;Ljava/lang/Throwable;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(String str, Throwable th) {
        String str2 = str;
        m.checkNotNullParameter(str2, "p1");
        ((AppLog) this.receiver).v(str2, th);
        return Unit.a;
    }
}
