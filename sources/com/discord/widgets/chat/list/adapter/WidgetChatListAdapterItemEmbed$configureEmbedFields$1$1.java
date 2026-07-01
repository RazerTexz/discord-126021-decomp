package com.discord.widgets.chat.list.adapter;

import com.discord.stores.StoreMessageState;
import com.discord.stores.StoreStream;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmbed$configureEmbedFields$1$1 extends o implements Function1<SpoilerNode<?>, Unit> {
    public final /* synthetic */ String $prefixKey;
    public final /* synthetic */ WidgetChatListAdapterItemEmbed$configureEmbedFields$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemEmbed$configureEmbedFields$1$1(WidgetChatListAdapterItemEmbed$configureEmbedFields$1 widgetChatListAdapterItemEmbed$configureEmbedFields$1, String str) {
        super(1);
        this.this$0 = widgetChatListAdapterItemEmbed$configureEmbedFields$1;
        this.$prefixKey = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SpoilerNode<?> spoilerNode) {
        invoke2(spoilerNode);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SpoilerNode<?> spoilerNode) {
        m.checkNotNullParameter(spoilerNode, "node");
        StoreMessageState messageState = StoreStream.Companion.getMessageState();
        WidgetChatListAdapterItemEmbed$configureEmbedFields$1 widgetChatListAdapterItemEmbed$configureEmbedFields$1 = this.this$0;
        messageState.revealSpoilerEmbedData(widgetChatListAdapterItemEmbed$configureEmbedFields$1.$messageId, widgetChatListAdapterItemEmbed$configureEmbedFields$1.$embedIndex, this.$prefixKey + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + spoilerNode.getId());
    }
}
