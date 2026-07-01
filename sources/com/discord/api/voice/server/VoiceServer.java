package com.discord.api.voice.server;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: VoiceServer.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class VoiceServer {
    private final Long channelId;
    private final String endpoint;
    private final Long guildId;
    private final String token;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getEndpoint() {
        return this.endpoint;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceServer)) {
            return false;
        }
        VoiceServer voiceServer = (VoiceServer) other;
        return m.areEqual(this.guildId, voiceServer.guildId) && m.areEqual(this.channelId, voiceServer.channelId) && m.areEqual(this.endpoint, voiceServer.endpoint) && m.areEqual(this.token, voiceServer.token);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        String str = this.endpoint;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.token;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("VoiceServer(guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", endpoint=");
        sbU.append(this.endpoint);
        sbU.append(", token=");
        return a.J(sbU, this.token, ")");
    }
}
