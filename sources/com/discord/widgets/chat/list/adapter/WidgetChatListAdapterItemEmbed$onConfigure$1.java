package com.discord.widgets.chat.list.adapter;

import android.view.View;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.EmbedEntry;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmbed$onConfigure$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ ChatListEntry $data;
    public final /* synthetic */ WidgetChatListAdapterItemEmbed this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemEmbed$onConfigure$1(WidgetChatListAdapterItemEmbed widgetChatListAdapterItemEmbed, ChatListEntry chatListEntry) {
        super(1);
        this.this$0 = widgetChatListAdapterItemEmbed;
        this.$data = chatListEntry;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        WidgetChatListAdapterItemEmbed.access$getAdapter$p(this.this$0).getEventHandler().onMessageLongClicked(((EmbedEntry) this.$data).getMessage(), "", ((EmbedEntry) this.$data).isThreadStarterMessage());
    }
}
