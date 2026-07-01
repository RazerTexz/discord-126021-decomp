package com.discord.api.directory;


/* JADX INFO: renamed from: com.discord.api.directory.DirectoryEntryType, reason: use source file name */
/* JADX INFO: compiled from: DirectoryEntryGuild.kt */
/* JADX INFO: loaded from: classes.dex */
public enum DirectoryEntryGuild3 {
    Guild(0),
    GuildScheduledEvent(1);

    private final int key;

    DirectoryEntryGuild3(int i) {
        this.key = i;
    }

    public final int getKey() {
        return this.key;
    }
}
