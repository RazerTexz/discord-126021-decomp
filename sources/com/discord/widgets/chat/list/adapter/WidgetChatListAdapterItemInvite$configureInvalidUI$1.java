package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreChat;
import com.discord.stores.StoreStream;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemInvite$configureInvalidUI$1 implements View$OnClickListener {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ boolean $isInviter;
    public final /* synthetic */ WidgetChatListAdapterItemInvite$Model$Invalid $model;
    public final /* synthetic */ WidgetChatListAdapterItemInvite this$0;

    public WidgetChatListAdapterItemInvite$configureInvalidUI$1(WidgetChatListAdapterItemInvite widgetChatListAdapterItemInvite, boolean z2, WidgetChatListAdapterItemInvite$Model$Invalid widgetChatListAdapterItemInvite$Model$Invalid, Context context) {
        this.this$0 = widgetChatListAdapterItemInvite;
        this.$isInviter = z2;
        this.$model = widgetChatListAdapterItemInvite$Model$Invalid;
        this.$context = context;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Channel channel;
        if (!this.$isInviter) {
            StoreChat chat = StoreStream.Companion.getChat();
            WidgetChatListAdapterItemInvite$Model$Invalid widgetChatListAdapterItemInvite$Model$Invalid = this.$model;
            chat.appendMention(widgetChatListAdapterItemInvite$Model$Invalid != null ? widgetChatListAdapterItemInvite$Model$Invalid.getAuthorUser() : null, WidgetChatListAdapterItemInvite.access$getItem$p(this.this$0).getGuildId());
            return;
        }
        WidgetChatListAdapterItemInvite$Model$Invalid widgetChatListAdapterItemInvite$Model$Invalid2 = this.$model;
        if (widgetChatListAdapterItemInvite$Model$Invalid2 == null || (channel = widgetChatListAdapterItemInvite$Model$Invalid2.getChannel()) == null) {
            return;
        }
        long guildId = channel.getGuildId();
        WidgetGuildInviteShare$Companion widgetGuildInviteShare$Companion = WidgetGuildInviteShare.Companion;
        Context context = this.$context;
        m.checkNotNullExpressionValue(context, "context");
        WidgetGuildInviteShare$Companion.launch$default(widgetGuildInviteShare$Companion, context, WidgetChatListAdapterItemInvite.access$getAdapter$p(this.this$0).getFragmentManager(), guildId, Long.valueOf(this.$model.getChannel().getId()), false, null, null, "Invite Button Embed", 112, null);
    }
}
