package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ModelApplicationStream.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class StreamServerUpdate {
    private final String endpoint;
    private final String streamKey;
    private final String token;

    public StreamServerUpdate(String str, String str2, String str3) {
        m.checkNotNullParameter(str, "streamKey");
        this.streamKey = str;
        this.endpoint = str2;
        this.token = str3;
    }

    public static /* synthetic */ StreamServerUpdate copy$default(StreamServerUpdate streamServerUpdate, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = streamServerUpdate.streamKey;
        }
        if ((i & 2) != 0) {
            str2 = streamServerUpdate.endpoint;
        }
        if ((i & 4) != 0) {
            str3 = streamServerUpdate.token;
        }
        return streamServerUpdate.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStreamKey() {
        return this.streamKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEndpoint() {
        return this.endpoint;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public final StreamServerUpdate copy(String streamKey, String endpoint, String token) {
        m.checkNotNullParameter(streamKey, "streamKey");
        return new StreamServerUpdate(streamKey, endpoint, token);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StreamServerUpdate)) {
            return false;
        }
        StreamServerUpdate streamServerUpdate = (StreamServerUpdate) other;
        return m.areEqual(this.streamKey, streamServerUpdate.streamKey) && m.areEqual(this.endpoint, streamServerUpdate.endpoint) && m.areEqual(this.token, streamServerUpdate.token);
    }

    public final String getEndpoint() {
        return this.endpoint;
    }

    public final String getStreamKey() {
        return this.streamKey;
    }

    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        String str = this.streamKey;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.endpoint;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.token;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StreamServerUpdate(streamKey=");
        sbU.append(this.streamKey);
        sbU.append(", endpoint=");
        sbU.append(this.endpoint);
        sbU.append(", token=");
        return a.J(sbU, this.token, ")");
    }
}
