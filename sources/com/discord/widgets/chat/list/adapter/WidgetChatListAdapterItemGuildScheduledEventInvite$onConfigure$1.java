package com.discord.widgets.chat.list.adapter;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatListAdapterItemGuildScheduledEventInvite$onConfigure$1 extends k implements Function1<WidgetChatListAdapterItemGuildScheduledEventInvite$Model, Unit> {
    public WidgetChatListAdapterItemGuildScheduledEventInvite$onConfigure$1(WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite) {
        super(1, widgetChatListAdapterItemGuildScheduledEventInvite, WidgetChatListAdapterItemGuildScheduledEventInvite.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildScheduledEventInvite$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChatListAdapterItemGuildScheduledEventInvite$Model widgetChatListAdapterItemGuildScheduledEventInvite$Model) {
        invoke2(widgetChatListAdapterItemGuildScheduledEventInvite$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChatListAdapterItemGuildScheduledEventInvite$Model widgetChatListAdapterItemGuildScheduledEventInvite$Model) {
        m.checkNotNullParameter(widgetChatListAdapterItemGuildScheduledEventInvite$Model, "p1");
        WidgetChatListAdapterItemGuildScheduledEventInvite.access$configureUI((WidgetChatListAdapterItemGuildScheduledEventInvite) this.receiver, widgetChatListAdapterItemGuildScheduledEventInvite$Model);
    }
}
