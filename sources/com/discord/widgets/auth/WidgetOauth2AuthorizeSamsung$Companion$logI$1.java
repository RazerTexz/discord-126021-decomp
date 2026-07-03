package com.discord.widgets.auth;

import com.discord.app.AppLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetOauth2AuthorizeSamsung$Companion$logI$1 extends C12236k implements Function2<String, Throwable, Unit> {
    public WidgetOauth2AuthorizeSamsung$Companion$logI$1(AppLog appLog) {
        super(2, appLog, AppLog.class, "i", "i(Ljava/lang/String;Ljava/lang/Throwable;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, Throwable th) {
        invoke2(str, th);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str, Throwable th) {
        C12238m.checkNotNullParameter(str, "p1");
        ((AppLog) this.receiver).mo8367i(str, th);
    }
}
