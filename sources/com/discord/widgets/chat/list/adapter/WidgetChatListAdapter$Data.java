package com.discord.widgets.chat.list.adapter;

import com.discord.models.guild.Guild;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: WidgetChatListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface WidgetChatListAdapter$Data {
    long getChannelId();

    Map<Long, String> getChannelNames();

    Guild getGuild();

    long getGuildId();

    List<ChatListEntry> getList();

    Set<Long> getMyRoleIds();

    long getNewMessagesMarkerMessageId();

    long getOldestMessageId();

    long getUserId();

    /* JADX INFO: renamed from: isSpoilerClickAllowed */
    boolean getIsSpoilerClickAllowed();
}
