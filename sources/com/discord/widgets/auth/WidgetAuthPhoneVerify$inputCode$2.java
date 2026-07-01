package com.discord.widgets.auth;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthPhoneVerify$inputCode$2 extends k implements Function1<String, Unit> {
    public WidgetAuthPhoneVerify$inputCode$2(WidgetAuthPhoneVerify widgetAuthPhoneVerify) {
        super(1, widgetAuthPhoneVerify, WidgetAuthPhoneVerify.class, "evaluateCode", "evaluateCode(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullParameter(str, "p1");
        WidgetAuthPhoneVerify.access$evaluateCode((WidgetAuthPhoneVerify) this.receiver, str);
    }
}
