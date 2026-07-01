package com.discord.widgets.home;

import com.discord.widgets.status.WidgetGlobalStatusIndicatorState$State;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetHome$onViewBoundOrOnResume$13 extends k implements Function1<WidgetGlobalStatusIndicatorState$State, Unit> {
    public WidgetHome$onViewBoundOrOnResume$13(WidgetHome widgetHome) {
        super(1, widgetHome, WidgetHome.class, "handleGlobalStatusIndicatorState", "handleGlobalStatusIndicatorState(Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorState$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGlobalStatusIndicatorState$State widgetGlobalStatusIndicatorState$State) {
        invoke2(widgetGlobalStatusIndicatorState$State);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGlobalStatusIndicatorState$State widgetGlobalStatusIndicatorState$State) {
        m.checkNotNullParameter(widgetGlobalStatusIndicatorState$State, "p1");
        WidgetHome.access$handleGlobalStatusIndicatorState((WidgetHome) this.receiver, widgetGlobalStatusIndicatorState$State);
    }
}
