package com.discord.widgets.channels;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCreateChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetCreateChannel$onViewBoundOrOnResume$1 extends k implements Function1<WidgetCreateChannel$Model, Unit> {
    public WidgetCreateChannel$onViewBoundOrOnResume$1(WidgetCreateChannel widgetCreateChannel) {
        super(1, widgetCreateChannel, WidgetCreateChannel.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/WidgetCreateChannel$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetCreateChannel$Model widgetCreateChannel$Model) {
        invoke2(widgetCreateChannel$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetCreateChannel$Model widgetCreateChannel$Model) {
        WidgetCreateChannel.access$configureUI((WidgetCreateChannel) this.receiver, widgetCreateChannel$Model);
    }
}
