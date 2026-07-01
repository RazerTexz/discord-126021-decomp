package com.discord.widgets.chat.list.adapter;

import com.discord.api.message.reaction.MessageReaction;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterEventsHandler$onReactionClicked$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ long $messageId;
    public final /* synthetic */ long $myUserId;
    public final /* synthetic */ MessageReaction $reaction;
    public final /* synthetic */ WidgetChatListAdapterEventsHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterEventsHandler$onReactionClicked$1(WidgetChatListAdapterEventsHandler widgetChatListAdapterEventsHandler, long j, long j2, long j3, MessageReaction messageReaction) {
        super(0);
        this.this$0 = widgetChatListAdapterEventsHandler;
        this.$myUserId = j;
        this.$channelId = j2;
        this.$messageId = j3;
        this.$reaction = messageReaction;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetChatListAdapterEventsHandler.access$getUserReactionHandler$p(this.this$0).toggleReaction(this.$myUserId, this.$channelId, this.$messageId, this.$reaction);
    }
}
