package com.discord.widgets.chat.list.adapter;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatListAdapterItemGuildTemplate$onConfigure$1 extends k implements Function1<WidgetChatListAdapterItemGuildTemplate$Model, Unit> {
    public WidgetChatListAdapterItemGuildTemplate$onConfigure$1(WidgetChatListAdapterItemGuildTemplate widgetChatListAdapterItemGuildTemplate) {
        super(1, widgetChatListAdapterItemGuildTemplate, WidgetChatListAdapterItemGuildTemplate.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildTemplate$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChatListAdapterItemGuildTemplate$Model widgetChatListAdapterItemGuildTemplate$Model) {
        invoke2(widgetChatListAdapterItemGuildTemplate$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChatListAdapterItemGuildTemplate$Model widgetChatListAdapterItemGuildTemplate$Model) {
        m.checkNotNullParameter(widgetChatListAdapterItemGuildTemplate$Model, "p1");
        WidgetChatListAdapterItemGuildTemplate.access$configureUI((WidgetChatListAdapterItemGuildTemplate) this.receiver, widgetChatListAdapterItemGuildTemplate$Model);
    }
}
