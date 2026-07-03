package com.discord.api.voice.server;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.guildId, voiceServer.guildId) && C12238m.areEqual(this.channelId, voiceServer.channelId) && C12238m.areEqual(this.endpoint, voiceServer.endpoint) && C12238m.areEqual(this.token, voiceServer.token);
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
        StringBuilder sbM833U = C1643a.m833U("VoiceServer(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", endpoint=");
        sbM833U.append(this.endpoint);
        sbM833U.append(", token=");
        return C1643a.m822J(sbM833U, this.token, ")");
    }
}
