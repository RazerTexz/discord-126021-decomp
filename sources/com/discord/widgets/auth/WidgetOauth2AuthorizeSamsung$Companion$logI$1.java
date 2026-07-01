package com.discord.widgets.auth;

import com.discord.app.AppLog;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetOauth2AuthorizeSamsung$Companion$logI$1 extends k implements Function2<String, Throwable, Unit> {
    public WidgetOauth2AuthorizeSamsung$Companion$logI$1(AppLog appLog) {
        super(2, appLog, AppLog.class, "i", "i(Ljava/lang/String;Ljava/lang/Throwable;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, Throwable th) {
        invoke2(str, th);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str, Throwable th) {
        m.checkNotNullParameter(str, "p1");
        ((AppLog) this.receiver).i(str, th);
    }
}
