package com.discord.widgets.status;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGlobalStatusIndicator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGlobalStatusIndicator$onViewBoundOrOnResume$2 extends k implements Function1<WidgetGlobalStatusIndicatorViewModel$ViewState, Unit> {
    public WidgetGlobalStatusIndicator$onViewBoundOrOnResume$2(WidgetGlobalStatusIndicator widgetGlobalStatusIndicator) {
        super(1, widgetGlobalStatusIndicator, WidgetGlobalStatusIndicator.class, "configureUI", "configureUI(Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGlobalStatusIndicatorViewModel$ViewState widgetGlobalStatusIndicatorViewModel$ViewState) {
        invoke2(widgetGlobalStatusIndicatorViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGlobalStatusIndicatorViewModel$ViewState widgetGlobalStatusIndicatorViewModel$ViewState) {
        m.checkNotNullParameter(widgetGlobalStatusIndicatorViewModel$ViewState, "p1");
        WidgetGlobalStatusIndicator.access$configureUI((WidgetGlobalStatusIndicator) this.receiver, widgetGlobalStatusIndicatorViewModel$ViewState);
    }
}
