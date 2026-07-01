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
public final class WidgetChatListAdapterItemEmbed$configureEmbedTitle$1 extends o implements Function1<SpoilerNode<?>, Unit> {
    public final /* synthetic */ int $embedIndex;
    public final /* synthetic */ WidgetChatListAdapterItemEmbed$Model $model;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemEmbed$configureEmbedTitle$1(WidgetChatListAdapterItemEmbed$Model widgetChatListAdapterItemEmbed$Model, int i) {
        super(1);
        this.$model = widgetChatListAdapterItemEmbed$Model;
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
        long id2 = this.$model.getEmbedEntry().getMessage().getId();
        int i = this.$embedIndex;
        StringBuilder sbU = a.U("title:");
        sbU.append(spoilerNode.getId());
        messageState.revealSpoilerEmbedData(id2, i, sbU.toString());
    }
}
