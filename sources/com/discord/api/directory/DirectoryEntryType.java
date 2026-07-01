package com.discord.api.directory;


/* JADX INFO: compiled from: DirectoryEntryGuild.kt */
/* JADX INFO: loaded from: classes.dex */
public enum DirectoryEntryType {
    Guild(0),
    GuildScheduledEvent(1);

    private final int key;

    DirectoryEntryType(int i) {
        this.key = i;
    }

    public final int getKey() {
        return this.key;
    }
}
