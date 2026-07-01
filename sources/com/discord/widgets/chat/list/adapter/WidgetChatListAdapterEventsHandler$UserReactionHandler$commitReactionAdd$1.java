package com.discord.widgets.chat.list.adapter;

import com.discord.api.message.reaction.MessageReactionUpdate;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterEventsHandler$UserReactionHandler$commitReactionAdd$1 extends o implements Function1<MessageReactionUpdate, Unit> {
    public final /* synthetic */ WidgetChatListAdapterEventsHandler$UserReactionHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterEventsHandler$UserReactionHandler$commitReactionAdd$1(WidgetChatListAdapterEventsHandler$UserReactionHandler widgetChatListAdapterEventsHandler$UserReactionHandler) {
        super(1);
        this.this$0 = widgetChatListAdapterEventsHandler$UserReactionHandler;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MessageReactionUpdate messageReactionUpdate) {
        invoke2(messageReactionUpdate);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MessageReactionUpdate messageReactionUpdate) {
        m.checkNotNullParameter(messageReactionUpdate, "reactionUpdate");
        WidgetChatListAdapterEventsHandler$UserReactionHandler.access$getStoreMessages$p(this.this$0).handleReactionUpdate(d0.t.m.listOf(messageReactionUpdate), true);
    }
}
