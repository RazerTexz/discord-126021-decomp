package com.discord.widgets.chat.list.adapter;

import com.discord.i18n.RenderContext;
import com.discord.models.message.Message;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemEphemeralMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEphemeralMessage$onConfigure$2 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ Message $message;
    public final /* synthetic */ WidgetChatListAdapterItemEphemeralMessage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemEphemeralMessage$onConfigure$2(WidgetChatListAdapterItemEphemeralMessage widgetChatListAdapterItemEphemeralMessage, Message message) {
        super(1);
        this.this$0 = widgetChatListAdapterItemEphemeralMessage;
        this.$message = message;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.a("handleDelete", new WidgetChatListAdapterItemEphemeralMessage$onConfigure$2$1(this));
    }
}
