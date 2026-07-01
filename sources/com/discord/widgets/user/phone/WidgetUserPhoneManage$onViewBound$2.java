package com.discord.widgets.user.phone;

import com.discord.models.phone.PhoneCountryCode;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPhoneManage$onViewBound$2 extends o implements Function1<PhoneCountryCode, Unit> {
    public final /* synthetic */ WidgetUserPhoneManage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserPhoneManage$onViewBound$2(WidgetUserPhoneManage widgetUserPhoneManage) {
        super(1);
        this.this$0 = widgetUserPhoneManage;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PhoneCountryCode phoneCountryCode) {
        invoke2(phoneCountryCode);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PhoneCountryCode phoneCountryCode) {
        m.checkNotNullParameter(phoneCountryCode, "it");
        WidgetUserPhoneManage.access$getBinding$p(this.this$0).f.setCountryCode(phoneCountryCode);
    }
}
