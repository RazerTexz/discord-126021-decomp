package com.discord.widgets.chat.list.adapter;

import com.discord.api.message.reaction.MessageReaction;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterEventsHandler$UserReactionHandler$requestReactionUpdate$1 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ MessageReaction $reaction;
    public final /* synthetic */ WidgetChatListAdapterEventsHandler$UserReactionHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterEventsHandler$UserReactionHandler$requestReactionUpdate$1(WidgetChatListAdapterEventsHandler$UserReactionHandler widgetChatListAdapterEventsHandler$UserReactionHandler, MessageReaction messageReaction) {
        super(1);
        this.this$0 = widgetChatListAdapterEventsHandler$UserReactionHandler;
        this.$reaction = messageReaction;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r2) {
        if (this.$reaction.getMe()) {
            return;
        }
        WidgetChatListAdapterEventsHandler$UserReactionHandler.access$getStoreEmoji$p(this.this$0).onEmojiUsed(this.$reaction.getEmoji().c());
    }
}
