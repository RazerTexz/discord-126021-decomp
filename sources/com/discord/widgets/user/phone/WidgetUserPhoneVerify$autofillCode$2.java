package com.discord.widgets.user.phone;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserPhoneVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPhoneVerify$autofillCode$2 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ String $verificationCode;
    public final /* synthetic */ WidgetUserPhoneVerify this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserPhoneVerify$autofillCode$2(WidgetUserPhoneVerify widgetUserPhoneVerify, String str) {
        super(1);
        this.this$0 = widgetUserPhoneVerify;
        this.$verificationCode = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke2(l);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long l) {
        WidgetUserPhoneVerify.access$handleCodeEntered(this.this$0, this.$verificationCode);
    }
}
