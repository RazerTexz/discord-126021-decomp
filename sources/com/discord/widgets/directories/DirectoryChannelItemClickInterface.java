package com.discord.widgets.directories;

import com.discord.api.directory.DirectoryEntryGuild;

/* JADX INFO: compiled from: WidgetDirectoryEntryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface DirectoryChannelItemClickInterface {

    /* JADX INFO: compiled from: WidgetDirectoryEntryViewHolder.kt */
    public static final class DefaultImpls {
        public static void onAddServerClicked(DirectoryChannelItemClickInterface directoryChannelItemClickInterface) {
        }
    }

    void onAddServerClicked();

    void onEntryClicked(long guildId, long channelId);

    void onGoToGuildClicked(long guildId);

    void onOverflowClicked(DirectoryEntryGuild directoryEntry, long channelId, boolean isServerOwner);
}
