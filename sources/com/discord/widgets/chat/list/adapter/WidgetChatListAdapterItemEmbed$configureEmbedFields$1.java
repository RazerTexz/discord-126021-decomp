package com.discord.widgets.chat.list.adapter;

import com.discord.simpleast.core.node.Node;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Collection;
import java.util.Map;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmbed$configureEmbedFields$1 extends o implements Function2<Collection<? extends Node<MessageRenderContext>>, String, DraweeSpanStringBuilder> {
    public final /* synthetic */ int $embedIndex;
    public final /* synthetic */ long $messageId;
    public final /* synthetic */ WidgetChatListAdapterItemEmbed$Model $model;
    public final /* synthetic */ MessageRenderContext $renderContext;
    public final /* synthetic */ Map $visibleSpoilerEmbedMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemEmbed$configureEmbedFields$1(WidgetChatListAdapterItemEmbed$Model widgetChatListAdapterItemEmbed$Model, Map map, int i, MessageRenderContext messageRenderContext, long j) {
        super(2);
        this.$model = widgetChatListAdapterItemEmbed$Model;
        this.$visibleSpoilerEmbedMap = map;
        this.$embedIndex = i;
        this.$renderContext = messageRenderContext;
        this.$messageId = j;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ DraweeSpanStringBuilder invoke(Collection<? extends Node<MessageRenderContext>> collection, String str) {
        return invoke2(collection, str);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final DraweeSpanStringBuilder invoke2(Collection<? extends Node<MessageRenderContext>> collection, String str) {
        m.checkNotNullParameter(collection, "$this$toDraweeSpanStringBuilder");
        m.checkNotNullParameter(str, "prefixKey");
        long myId = this.$model.getMyId();
        Map map = this.$visibleSpoilerEmbedMap;
        new MessagePreprocessor(myId, map != null ? WidgetChatListAdapterItemEmbed$Companion.access$getEmbedFieldVisibleIndices(WidgetChatListAdapterItemEmbed.Companion, map, this.$embedIndex, str) : null, null, false, null, 28, null).process(collection);
        return AstRenderer.render(collection, MessageRenderContext.copy$default(this.$renderContext, null, 0L, false, null, null, null, 0, null, null, 0, 0, new WidgetChatListAdapterItemEmbed$configureEmbedFields$1$1(this, str), null, null, 14335, null));
    }
}
