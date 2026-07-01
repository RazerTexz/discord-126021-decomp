package com.discord.widgets.chat.list.adapter;

import b.d.b.a.a;
import com.discord.stores.StoreMessageState;
import com.discord.stores.StoreStream;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmbed$configureEmbedDescription$1 extends o implements Function1<SpoilerNode<?>, Unit> {
    public final /* synthetic */ int $embedIndex;
    public final /* synthetic */ long $messageId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemEmbed$configureEmbedDescription$1(long j, int i) {
        super(1);
        this.$messageId = j;
        this.$embedIndex = i;
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
        long j = this.$messageId;
        int i = this.$embedIndex;
        StringBuilder sbU = a.U("desc:");
        sbU.append(spoilerNode.getId());
        messageState.revealSpoilerEmbedData(j, i, sbU.toString());
    }
}
