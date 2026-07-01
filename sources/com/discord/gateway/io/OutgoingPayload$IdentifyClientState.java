package com.discord.gateway.io;

import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: Outgoing.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OutgoingPayload$IdentifyClientState {
    private final Map<Long, String[]> guildHashes;
    private final long highestLastMessageId;
    private final int readStateVersion;
    private final int useruserGuildSettingsVersion;

    public OutgoingPayload$IdentifyClientState(Map<Long, String[]> map, long j, int i, int i2) {
        m.checkNotNullParameter(map, "guildHashes");
        this.guildHashes = map;
        this.highestLastMessageId = j;
        this.readStateVersion = i;
        this.useruserGuildSettingsVersion = i2;
    }

    public final Map<Long, String[]> getGuildHashes() {
        return this.guildHashes;
    }

    public final long getHighestLastMessageId() {
        return this.highestLastMessageId;
    }

    public final int getReadStateVersion() {
        return this.readStateVersion;
    }

    public final int getUseruserGuildSettingsVersion() {
        return this.useruserGuildSettingsVersion;
    }
}
