package com.discord.widgets.chat.list.adapter;

import b.d.b.a.a;
import com.discord.utilities.textprocessing.MessageRenderContext;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmbed$onConfigure$4 extends o implements Function1<WidgetChatListAdapterItemEmbed$Model, Unit> {
    public final /* synthetic */ WidgetChatListAdapterItemEmbed this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemEmbed$onConfigure$4(WidgetChatListAdapterItemEmbed widgetChatListAdapterItemEmbed) {
        super(1);
        this.this$0 = widgetChatListAdapterItemEmbed;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChatListAdapterItemEmbed$Model widgetChatListAdapterItemEmbed$Model) {
        invoke2(widgetChatListAdapterItemEmbed$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChatListAdapterItemEmbed$Model widgetChatListAdapterItemEmbed$Model) {
        MessageRenderContext messageRenderContextCreateRenderContext = widgetChatListAdapterItemEmbed$Model.createRenderContext(a.x(this.this$0.itemView, "itemView", "itemView.context"), WidgetChatListAdapterItemEmbed.access$getAdapter$p(this.this$0).getEventHandler());
        WidgetChatListAdapterItemEmbed widgetChatListAdapterItemEmbed = this.this$0;
        m.checkNotNullExpressionValue(widgetChatListAdapterItemEmbed$Model, "model");
        WidgetChatListAdapterItemEmbed.access$configureEmbedTitle(widgetChatListAdapterItemEmbed, widgetChatListAdapterItemEmbed$Model, messageRenderContextCreateRenderContext);
        WidgetChatListAdapterItemEmbed.access$configureEmbedDescription(this.this$0, widgetChatListAdapterItemEmbed$Model, messageRenderContextCreateRenderContext);
        WidgetChatListAdapterItemEmbed.access$configureEmbedFields(this.this$0, widgetChatListAdapterItemEmbed$Model, messageRenderContextCreateRenderContext);
    }
}
