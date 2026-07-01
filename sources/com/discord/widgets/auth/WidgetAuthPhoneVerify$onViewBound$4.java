package com.discord.widgets.auth;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthPhoneVerify$onViewBound$4 extends k implements Function1<String, Unit> {
    public WidgetAuthPhoneVerify$onViewBound$4(WidgetAuthPhoneVerify widgetAuthPhoneVerify) {
        super(1, widgetAuthPhoneVerify, WidgetAuthPhoneVerify.class, "inputCode", "inputCode(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullParameter(str, "p1");
        WidgetAuthPhoneVerify.access$inputCode((WidgetAuthPhoneVerify) this.receiver, str);
    }
}
