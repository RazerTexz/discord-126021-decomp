package com.discord.widgets.chat.list.adapter;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemStageInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatListAdapterItemStageInvite$onConfigure$1 extends k implements Function1<WidgetChatListAdapterItemStageInvite$Model, Unit> {
    public WidgetChatListAdapterItemStageInvite$onConfigure$1(WidgetChatListAdapterItemStageInvite widgetChatListAdapterItemStageInvite) {
        super(1, widgetChatListAdapterItemStageInvite, WidgetChatListAdapterItemStageInvite.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemStageInvite$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChatListAdapterItemStageInvite$Model widgetChatListAdapterItemStageInvite$Model) {
        invoke2(widgetChatListAdapterItemStageInvite$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChatListAdapterItemStageInvite$Model widgetChatListAdapterItemStageInvite$Model) {
        m.checkNotNullParameter(widgetChatListAdapterItemStageInvite$Model, "p1");
        WidgetChatListAdapterItemStageInvite.access$configureUI((WidgetChatListAdapterItemStageInvite) this.receiver, widgetChatListAdapterItemStageInvite$Model);
    }
}
