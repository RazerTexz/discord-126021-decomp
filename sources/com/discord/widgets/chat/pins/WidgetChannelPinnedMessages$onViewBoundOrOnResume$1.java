package com.discord.widgets.chat.pins;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelPinnedMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelPinnedMessages$onViewBoundOrOnResume$1 extends o implements Function1<WidgetChannelPinnedMessages$Model, Unit> {
    public final /* synthetic */ WidgetChannelPinnedMessages this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelPinnedMessages$onViewBoundOrOnResume$1(WidgetChannelPinnedMessages widgetChannelPinnedMessages) {
        super(1);
        this.this$0 = widgetChannelPinnedMessages;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelPinnedMessages$Model widgetChannelPinnedMessages$Model) {
        invoke2(widgetChannelPinnedMessages$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChannelPinnedMessages$Model widgetChannelPinnedMessages$Model) {
        WidgetChannelPinnedMessages.access$configureUI(this.this$0, widgetChannelPinnedMessages$Model);
    }
}
