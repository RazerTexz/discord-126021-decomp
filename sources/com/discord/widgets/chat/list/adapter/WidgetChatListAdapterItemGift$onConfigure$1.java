package com.discord.widgets.chat.list.adapter;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatListAdapterItemGift$onConfigure$1 extends k implements Function1<WidgetChatListAdapterItemGift$Model, Unit> {
    public WidgetChatListAdapterItemGift$onConfigure$1(WidgetChatListAdapterItemGift widgetChatListAdapterItemGift) {
        super(1, widgetChatListAdapterItemGift, WidgetChatListAdapterItemGift.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChatListAdapterItemGift$Model widgetChatListAdapterItemGift$Model) {
        invoke2(widgetChatListAdapterItemGift$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChatListAdapterItemGift$Model widgetChatListAdapterItemGift$Model) {
        m.checkNotNullParameter(widgetChatListAdapterItemGift$Model, "p1");
        WidgetChatListAdapterItemGift.access$configureUI((WidgetChatListAdapterItemGift) this.receiver, widgetChatListAdapterItemGift$Model);
    }
}
