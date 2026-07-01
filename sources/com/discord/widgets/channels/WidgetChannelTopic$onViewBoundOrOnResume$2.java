package com.discord.widgets.channels;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelTopic.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelTopic$onViewBoundOrOnResume$2 extends o implements Function1<WidgetChannelTopicViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetChannelTopic this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelTopic$onViewBoundOrOnResume$2(WidgetChannelTopic widgetChannelTopic) {
        super(1);
        this.this$0 = widgetChannelTopic;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelTopicViewModel$ViewState widgetChannelTopicViewModel$ViewState) {
        invoke2(widgetChannelTopicViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChannelTopicViewModel$ViewState widgetChannelTopicViewModel$ViewState) {
        WidgetChannelTopic widgetChannelTopic = this.this$0;
        m.checkNotNullExpressionValue(widgetChannelTopicViewModel$ViewState, "viewState");
        WidgetChannelTopic.access$configureUI(widgetChannelTopic, widgetChannelTopicViewModel$ViewState);
    }
}
