package com.discord.widgets.channels.list;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelsList$onViewBoundOrOnResume$1 extends k implements Function1<WidgetChannelListModel, Unit> {
    public WidgetChannelsList$onViewBoundOrOnResume$1(WidgetChannelsList widgetChannelsList) {
        super(1, widgetChannelsList, WidgetChannelsList.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/list/WidgetChannelListModel;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelListModel widgetChannelListModel) {
        invoke2(widgetChannelListModel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChannelListModel widgetChannelListModel) {
        m.checkNotNullParameter(widgetChannelListModel, "p1");
        WidgetChannelsList.access$configureUI((WidgetChannelsList) this.receiver, widgetChannelListModel);
    }
}
