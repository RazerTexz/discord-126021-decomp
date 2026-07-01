package com.discord.widgets.chat.list.adapter;

import com.discord.i18n.RenderContext;
import com.discord.widgets.chat.list.entries.MessageEntry;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemAutoModBlocked.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemAutoModBlocked$onConfigure$1 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ MessageEntry $messageEntry;
    public final /* synthetic */ WidgetChatListAdapterItemAutoModBlocked this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemAutoModBlocked$onConfigure$1(WidgetChatListAdapterItemAutoModBlocked widgetChatListAdapterItemAutoModBlocked, MessageEntry messageEntry) {
        super(1);
        this.this$0 = widgetChatListAdapterItemAutoModBlocked;
        this.$messageEntry = messageEntry;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.b("onClick", new WidgetChatListAdapterItemAutoModBlocked$onConfigure$1$1(this));
    }
}
