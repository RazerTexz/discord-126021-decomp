package com.discord.widgets.user.phone;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetUserPhoneVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserPhoneVerify$autofillCode$1$2 extends C12236k implements Function1<String, Unit> {
    public WidgetUserPhoneVerify$autofillCode$1$2(WidgetUserPhoneVerify widgetUserPhoneVerify) {
        super(1, widgetUserPhoneVerify, WidgetUserPhoneVerify.class, "handleCodeEntered", "handleCodeEntered(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        C12238m.checkNotNullParameter(str, "p1");
        ((WidgetUserPhoneVerify) this.receiver).handleCodeEntered(str);
    }
}
