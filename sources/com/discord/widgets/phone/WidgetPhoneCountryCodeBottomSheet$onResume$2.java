package com.discord.widgets.phone;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetPhoneCountryCodeBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPhoneCountryCodeBottomSheet$onResume$2 extends o implements Function1<String, Unit> {
    public final /* synthetic */ WidgetPhoneCountryCodeBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPhoneCountryCodeBottomSheet$onResume$2(WidgetPhoneCountryCodeBottomSheet widgetPhoneCountryCodeBottomSheet) {
        super(1);
        this.this$0 = widgetPhoneCountryCodeBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        WidgetPhoneCountryCodeBottomSheet widgetPhoneCountryCodeBottomSheet = this.this$0;
        m.checkNotNullExpressionValue(str, "it");
        WidgetPhoneCountryCodeBottomSheet.access$configureUI(widgetPhoneCountryCodeBottomSheet, str);
    }
}
