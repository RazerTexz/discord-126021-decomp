package com.discord.widgets.auth;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAgeVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAgeVerify$onViewBound$1 extends o implements Function1<WidgetAgeVerifyViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetAgeVerify this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAgeVerify$onViewBound$1(WidgetAgeVerify widgetAgeVerify) {
        super(1);
        this.this$0 = widgetAgeVerify;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetAgeVerifyViewModel$ViewState widgetAgeVerifyViewModel$ViewState) {
        invoke2(widgetAgeVerifyViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetAgeVerifyViewModel$ViewState widgetAgeVerifyViewModel$ViewState) {
        m.checkNotNullParameter(widgetAgeVerifyViewModel$ViewState, "it");
        WidgetAgeVerify.access$configureUI(this.this$0, widgetAgeVerifyViewModel$ViewState);
    }
}
