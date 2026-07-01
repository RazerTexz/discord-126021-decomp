package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.GuildWelcomeEntry;
import com.discord.widgets.servers.WidgetServerSettingsOverview;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGuildWelcome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildWelcome$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ ChatListEntry $data;

    public WidgetChatListAdapterItemGuildWelcome$onConfigure$1(ChatListEntry chatListEntry) {
        this.$data = chatListEntry;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsOverview.Companion.create(a.x(view, "view", "view.context"), ((GuildWelcomeEntry) this.$data).getGuildId(), true);
    }
}
