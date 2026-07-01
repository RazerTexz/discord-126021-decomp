package com.discord.widgets.chat.list.adapter;

import com.discord.models.message.Message;
import com.discord.stores.StoreStream;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemMessage$getSpoilerClickHandler$1 extends o implements Function1<SpoilerNode<?>, Unit> {
    public final /* synthetic */ Message $message;
    public final /* synthetic */ WidgetChatListAdapterItemMessage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemMessage$getSpoilerClickHandler$1(WidgetChatListAdapterItemMessage widgetChatListAdapterItemMessage, Message message) {
        super(1);
        this.this$0 = widgetChatListAdapterItemMessage;
        this.$message = message;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SpoilerNode<?> spoilerNode) {
        invoke2(spoilerNode);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SpoilerNode<?> spoilerNode) {
        m.checkNotNullParameter(spoilerNode, "spoilerNode");
        StoreStream.Companion.getMessageState().revealSpoiler(this.$message.getId(), spoilerNode.getId());
        this.this$0.itemView.sendAccessibilityEvent(16);
    }
}
