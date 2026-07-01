package com.discord.app;

import d0.z.d.k;
import d0.z.d.m;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: App.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class App$e extends k implements Function3<String, Throwable, Map<String, ? extends String>, Unit> {
    public App$e(AppLog appLog) {
        super(3, appLog, AppLog.class, "e", "e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/util/Map;)V", 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function3
    public Unit invoke(String str, Throwable th, Map<String, ? extends String> map) {
        String str2 = str;
        m.checkNotNullParameter(str2, "p1");
        ((AppLog) this.receiver).e(str2, th, map);
        return Unit.a;
    }
}
