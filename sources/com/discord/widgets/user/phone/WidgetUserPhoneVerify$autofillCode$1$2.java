package com.discord.widgets.user.phone;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserPhoneVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserPhoneVerify$autofillCode$1$2 extends k implements Function1<String, Unit> {
    public WidgetUserPhoneVerify$autofillCode$1$2(WidgetUserPhoneVerify widgetUserPhoneVerify) {
        super(1, widgetUserPhoneVerify, WidgetUserPhoneVerify.class, "handleCodeEntered", "handleCodeEntered(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullParameter(str, "p1");
        WidgetUserPhoneVerify.access$handleCodeEntered((WidgetUserPhoneVerify) this.receiver, str);
    }
}
