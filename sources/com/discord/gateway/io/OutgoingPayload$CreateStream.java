package com.discord.gateway.io;

import d0.z.d.m;

/* JADX INFO: compiled from: Outgoing.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OutgoingPayload$CreateStream {
    private final long channelId;
    private final Long guildId;
    private final String preferredRegion;
    private final String type;

    public OutgoingPayload$CreateStream(String str, long j, Long l, String str2) {
        m.checkNotNullParameter(str, "type");
        this.type = str;
        this.channelId = j;
        this.guildId = l;
        this.preferredRegion = str2;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final String getPreferredRegion() {
        return this.preferredRegion;
    }

    public final String getType() {
        return this.type;
    }
}
