package com.discord.widgets.chat.list.adapter;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatListAdapterItemInvite$onConfigure$1 extends k implements Function1<WidgetChatListAdapterItemInvite$Model, Unit> {
    public WidgetChatListAdapterItemInvite$onConfigure$1(WidgetChatListAdapterItemInvite widgetChatListAdapterItemInvite) {
        super(1, widgetChatListAdapterItemInvite, WidgetChatListAdapterItemInvite.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInvite$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChatListAdapterItemInvite$Model widgetChatListAdapterItemInvite$Model) {
        invoke2(widgetChatListAdapterItemInvite$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChatListAdapterItemInvite$Model widgetChatListAdapterItemInvite$Model) {
        m.checkNotNullParameter(widgetChatListAdapterItemInvite$Model, "p1");
        WidgetChatListAdapterItemInvite.access$configureUI((WidgetChatListAdapterItemInvite) this.receiver, widgetChatListAdapterItemInvite$Model);
    }
}
