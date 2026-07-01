package com.discord.widgets.chat.list.adapter;

import com.discord.widgets.chat.list.ViewEmbedGameInvite$Model;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGameInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGameInvite$onConfigure$2 extends o implements Function1<ViewEmbedGameInvite$Model, Unit> {
    public final /* synthetic */ WidgetChatListAdapterItemGameInvite this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGameInvite$onConfigure$2(WidgetChatListAdapterItemGameInvite widgetChatListAdapterItemGameInvite) {
        super(1);
        this.this$0 = widgetChatListAdapterItemGameInvite;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ViewEmbedGameInvite$Model viewEmbedGameInvite$Model) {
        invoke2(viewEmbedGameInvite$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ViewEmbedGameInvite$Model viewEmbedGameInvite$Model) {
        m.checkNotNullParameter(viewEmbedGameInvite$Model, "it");
        WidgetChatListAdapterItemGameInvite.access$getBinding$p(this.this$0).f2319b.bind(viewEmbedGameInvite$Model, WidgetChatListAdapterItemGameInvite.access$getAdapter$p(this.this$0).getClock());
    }
}
