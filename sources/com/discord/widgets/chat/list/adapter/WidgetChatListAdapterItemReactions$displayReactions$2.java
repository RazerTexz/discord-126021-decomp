package com.discord.widgets.chat.list.adapter;

import android.view.View;
import com.discord.api.message.reaction.MessageReaction;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemReactions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemReactions$displayReactions$2 extends o implements Function1<View, Unit> {
    public final /* synthetic */ long $messageId;
    public final /* synthetic */ MessageReaction $reaction;
    public final /* synthetic */ WidgetChatListAdapterItemReactions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemReactions$displayReactions$2(WidgetChatListAdapterItemReactions widgetChatListAdapterItemReactions, long j, MessageReaction messageReaction) {
        super(1);
        this.this$0 = widgetChatListAdapterItemReactions;
        this.$messageId = j;
        this.$reaction = messageReaction;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        WidgetChatListAdapterItemReactions.access$getAdapter$p(this.this$0).onReactionLongClicked(this.$messageId, this.$reaction);
    }
}
