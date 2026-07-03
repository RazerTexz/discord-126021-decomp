package com.discord.widgets.chat.list.adapter;

import com.discord.api.message.reaction.MessageReactionUpdate;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p580t.C12145m;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$UserReactionHandler$commitReactionAdd$1 */
/* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C7993x67322e18 extends AbstractC12240o implements Function1<MessageReactionUpdate, Unit> {
    public final /* synthetic */ WidgetChatListAdapterEventsHandler.UserReactionHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7993x67322e18(WidgetChatListAdapterEventsHandler.UserReactionHandler userReactionHandler) {
        super(1);
        this.this$0 = userReactionHandler;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MessageReactionUpdate messageReactionUpdate) {
        invoke2(messageReactionUpdate);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MessageReactionUpdate messageReactionUpdate) {
        C12238m.checkNotNullParameter(messageReactionUpdate, "reactionUpdate");
        this.this$0.storeMessages.handleReactionUpdate(C12145m.listOf(messageReactionUpdate), true);
    }
}
