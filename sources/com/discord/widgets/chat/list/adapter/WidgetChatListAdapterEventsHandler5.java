package com.discord.widgets.chat.list.adapter;

import com.discord.api.message.reaction.MessageReaction;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$UserReactionHandler$requestReactionUpdate$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterEventsHandler5 extends Lambda implements Function1<Void, Unit> {
    public final /* synthetic */ MessageReaction $reaction;
    public final /* synthetic */ WidgetChatListAdapterEventsHandler.UserReactionHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterEventsHandler5(WidgetChatListAdapterEventsHandler.UserReactionHandler userReactionHandler, MessageReaction messageReaction) {
        super(1);
        this.this$0 = userReactionHandler;
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
        this.this$0.storeEmoji.onEmojiUsed(this.$reaction.getEmoji().c());
    }
}
