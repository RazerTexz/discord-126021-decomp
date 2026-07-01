package com.discord.widgets.user.phone;

import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.user.phone.WidgetUserPhoneVerify$autofillCode$1$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetUserPhoneVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserPhoneVerify4 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public WidgetUserPhoneVerify4(WidgetUserPhoneVerify widgetUserPhoneVerify) {
        super(1, widgetUserPhoneVerify, WidgetUserPhoneVerify.class, "handleCodeEntered", "handleCodeEntered(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        Intrinsics3.checkNotNullParameter(str, "p1");
        ((WidgetUserPhoneVerify) this.receiver).handleCodeEntered(str);
    }
}
