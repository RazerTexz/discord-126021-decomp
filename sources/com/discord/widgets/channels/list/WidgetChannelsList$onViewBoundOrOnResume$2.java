package com.discord.widgets.channels.list;

import com.discord.widgets.status.WidgetGlobalStatusIndicatorState$State;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelsList$onViewBoundOrOnResume$2 extends k implements Function1<WidgetGlobalStatusIndicatorState$State, Unit> {
    public WidgetChannelsList$onViewBoundOrOnResume$2(WidgetChannelsList widgetChannelsList) {
        super(1, widgetChannelsList, WidgetChannelsList.class, "handleGlobalStatusIndicatorState", "handleGlobalStatusIndicatorState(Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorState$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGlobalStatusIndicatorState$State widgetGlobalStatusIndicatorState$State) {
        invoke2(widgetGlobalStatusIndicatorState$State);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGlobalStatusIndicatorState$State widgetGlobalStatusIndicatorState$State) {
        m.checkNotNullParameter(widgetGlobalStatusIndicatorState$State, "p1");
        WidgetChannelsList.access$handleGlobalStatusIndicatorState((WidgetChannelsList) this.receiver, widgetGlobalStatusIndicatorState$State);
    }
}
