package com.discord.widgets.auth;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetRemoteAuth.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetRemoteAuth$onViewBound$1 extends o implements Function1<WidgetRemoteAuthViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetRemoteAuth this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetRemoteAuth$onViewBound$1(WidgetRemoteAuth widgetRemoteAuth) {
        super(1);
        this.this$0 = widgetRemoteAuth;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetRemoteAuthViewModel$ViewState widgetRemoteAuthViewModel$ViewState) {
        invoke2(widgetRemoteAuthViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetRemoteAuthViewModel$ViewState widgetRemoteAuthViewModel$ViewState) {
        WidgetRemoteAuth widgetRemoteAuth = this.this$0;
        m.checkNotNullExpressionValue(widgetRemoteAuthViewModel$ViewState, "it");
        WidgetRemoteAuth.access$configureUI(widgetRemoteAuth, widgetRemoteAuthViewModel$ViewState);
    }
}
