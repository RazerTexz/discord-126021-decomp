package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.widgets.chat.list.entries.AutoModSystemMessageEmbedEntry;

/* JADX INFO: compiled from: WidgetChatListAdapterItemAutoModSystemMessageEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$6 implements View$OnClickListener {
    public final /* synthetic */ AutoModSystemMessageEmbedEntry $messageEntry;
    public final /* synthetic */ WidgetChatListAdapterItemAutoModSystemMessageEmbed this$0;

    public WidgetChatListAdapterItemAutoModSystemMessageEmbed$onConfigure$6(WidgetChatListAdapterItemAutoModSystemMessageEmbed widgetChatListAdapterItemAutoModSystemMessageEmbed, AutoModSystemMessageEmbedEntry autoModSystemMessageEmbedEntry) {
        this.this$0 = widgetChatListAdapterItemAutoModSystemMessageEmbed;
        this.$messageEntry = autoModSystemMessageEmbedEntry;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChatListAdapter$EventHandler eventHandler = WidgetChatListAdapterItemAutoModSystemMessageEmbed.access$getAdapter$p(this.this$0).getEventHandler();
        Message message = this.$messageEntry.getMessage();
        GuildMember author = this.$messageEntry.getAuthor();
        eventHandler.onMessageAuthorLongClicked(message, author != null ? Long.valueOf(author.getGuildId()) : null);
    }
}
