package com.discord.widgets.directories;

import com.discord.api.directory.DirectoryEntryGuild;

/* JADX INFO: compiled from: WidgetDirectoryEntryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface DirectoryChannelItemClickInterface {
    void onAddServerClicked();

    void onEntryClicked(long guildId, long channelId);

    void onGoToGuildClicked(long guildId);

    void onOverflowClicked(DirectoryEntryGuild directoryEntry, long channelId, boolean isServerOwner);
}
