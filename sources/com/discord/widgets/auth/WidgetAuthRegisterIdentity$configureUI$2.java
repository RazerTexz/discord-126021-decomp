package com.discord.widgets.auth;

import com.discord.models.phone.PhoneCountryCode;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthRegisterIdentity$configureUI$2 extends o implements Function1<PhoneCountryCode, Unit> {
    public final /* synthetic */ WidgetAuthRegisterIdentity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthRegisterIdentity$configureUI$2(WidgetAuthRegisterIdentity widgetAuthRegisterIdentity) {
        super(1);
        this.this$0 = widgetAuthRegisterIdentity;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PhoneCountryCode phoneCountryCode) {
        invoke2(phoneCountryCode);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PhoneCountryCode phoneCountryCode) {
        m.checkNotNullParameter(phoneCountryCode, "it");
        WidgetAuthRegisterIdentity.access$getBinding$p(this.this$0).d.setCountryCode(phoneCountryCode);
    }
}
