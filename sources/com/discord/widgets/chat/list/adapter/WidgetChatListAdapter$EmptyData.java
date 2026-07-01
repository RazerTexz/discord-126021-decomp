package com.discord.widgets.chat.list.adapter;

import com.discord.models.guild.Guild;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import d0.t.h0;
import d0.t.n;
import d0.t.n0;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: WidgetChatListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapter$EmptyData implements WidgetChatListAdapter$Data {
    private final long channelId;
    private final Guild guild;
    private final long guildId;
    private final boolean isSpoilerClickAllowed;
    private final long newMessagesMarkerMessageId;
    private final long oldestMessageId;
    private final long userId;
    private final Map<Long, String> channelNames = h0.emptyMap();
    private final List<ChatListEntry> list = n.emptyList();
    private final Set<Long> myRoleIds = n0.emptySet();

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$Data
    public long getChannelId() {
        return this.channelId;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$Data
    public Map<Long, String> getChannelNames() {
        return this.channelNames;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$Data
    public Guild getGuild() {
        return this.guild;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$Data
    public long getGuildId() {
        return this.guildId;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$Data
    public List<ChatListEntry> getList() {
        return this.list;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$Data
    public Set<Long> getMyRoleIds() {
        return this.myRoleIds;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$Data
    public long getNewMessagesMarkerMessageId() {
        return this.newMessagesMarkerMessageId;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$Data
    public long getOldestMessageId() {
        return this.oldestMessageId;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$Data
    public long getUserId() {
        return this.userId;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$Data
    /* JADX INFO: renamed from: isSpoilerClickAllowed, reason: from getter */
    public boolean getIsSpoilerClickAllowed() {
        return this.isSpoilerClickAllowed;
    }
}
