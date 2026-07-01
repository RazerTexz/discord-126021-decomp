package com.discord.widgets.hubs;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubEmailFlow.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEmailFlow$onViewBoundOrOnResume$1 extends o implements Function1<HubEmailState, Unit> {
    public final /* synthetic */ WidgetHubEmailFlow this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubEmailFlow$onViewBoundOrOnResume$1(WidgetHubEmailFlow widgetHubEmailFlow) {
        super(1);
        this.this$0 = widgetHubEmailFlow;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(HubEmailState hubEmailState) {
        invoke2(hubEmailState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(HubEmailState hubEmailState) {
        WidgetHubEmailFlow widgetHubEmailFlow = this.this$0;
        m.checkNotNullExpressionValue(hubEmailState, "viewState");
        WidgetHubEmailFlow.access$updateView(widgetHubEmailFlow, hubEmailState);
    }
}
