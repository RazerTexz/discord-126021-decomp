package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.GuildWelcomeEntry;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare$Companion;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGuildWelcome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildWelcome$onConfigure$2 implements View$OnClickListener {
    public final /* synthetic */ ChatListEntry $data;
    public final /* synthetic */ WidgetChatListAdapterItemGuildWelcome this$0;

    public WidgetChatListAdapterItemGuildWelcome$onConfigure$2(WidgetChatListAdapterItemGuildWelcome widgetChatListAdapterItemGuildWelcome, ChatListEntry chatListEntry) {
        this.this$0 = widgetChatListAdapterItemGuildWelcome;
        this.$data = chatListEntry;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildInviteShare$Companion.launch$default(WidgetGuildInviteShare.Companion, a.x(view, "view", "view.context"), WidgetChatListAdapterItemGuildWelcome.access$getAdapter$p(this.this$0).getFragmentManager(), ((GuildWelcomeEntry) this.$data).getGuildId(), null, false, null, null, "Welcome Message", 120, null);
    }
}
