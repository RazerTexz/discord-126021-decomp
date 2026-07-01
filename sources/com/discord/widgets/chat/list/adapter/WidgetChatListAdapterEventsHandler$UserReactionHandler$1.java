package com.discord.widgets.chat.list.adapter;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatListAdapterEventsHandler$UserReactionHandler$1 extends k implements Function1<WidgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest, Unit> {
    public WidgetChatListAdapterEventsHandler$UserReactionHandler$1(WidgetChatListAdapterEventsHandler$UserReactionHandler widgetChatListAdapterEventsHandler$UserReactionHandler) {
        super(1, widgetChatListAdapterEventsHandler$UserReactionHandler, WidgetChatListAdapterEventsHandler$UserReactionHandler.class, "requestReactionUpdate", "requestReactionUpdate(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest widgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest) {
        invoke2(widgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest widgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest) {
        m.checkNotNullParameter(widgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest, "p1");
        WidgetChatListAdapterEventsHandler$UserReactionHandler.access$requestReactionUpdate((WidgetChatListAdapterEventsHandler$UserReactionHandler) this.receiver, widgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest);
    }
}
