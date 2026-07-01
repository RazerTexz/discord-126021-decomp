package com.discord.widgets.status;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGlobalStatusIndicator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGlobalStatusIndicator$onViewBoundOrOnResume$1 extends k implements Function1<WidgetGlobalStatusIndicatorState$State, Unit> {
    public WidgetGlobalStatusIndicator$onViewBoundOrOnResume$1(WidgetGlobalStatusIndicator widgetGlobalStatusIndicator) {
        super(1, widgetGlobalStatusIndicator, WidgetGlobalStatusIndicator.class, "configureUIVisibility", "configureUIVisibility(Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorState$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGlobalStatusIndicatorState$State widgetGlobalStatusIndicatorState$State) {
        invoke2(widgetGlobalStatusIndicatorState$State);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGlobalStatusIndicatorState$State widgetGlobalStatusIndicatorState$State) {
        m.checkNotNullParameter(widgetGlobalStatusIndicatorState$State, "p1");
        WidgetGlobalStatusIndicator.access$configureUIVisibility((WidgetGlobalStatusIndicator) this.receiver, widgetGlobalStatusIndicatorState$State);
    }
}
