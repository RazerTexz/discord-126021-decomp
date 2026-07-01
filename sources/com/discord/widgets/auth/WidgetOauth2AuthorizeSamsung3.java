package com.discord.widgets.auth;

import com.discord.app.AppLog;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$Companion$logW$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetOauth2AuthorizeSamsung3 extends FunctionReferenceImpl implements Function2<String, Throwable, Unit> {
    public WidgetOauth2AuthorizeSamsung3(AppLog appLog) {
        super(2, appLog, AppLog.class, "w", "w(Ljava/lang/String;Ljava/lang/Throwable;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, Throwable th) {
        invoke2(str, th);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str, Throwable th) {
        Intrinsics3.checkNotNullParameter(str, "p1");
        ((AppLog) this.receiver).w(str, th);
    }
}
