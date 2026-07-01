package com.discord.utilities.voice;

import b.d.b.a.a;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreApplicationStreaming$ActiveApplicationStream;
import d0.z.d.m;

/* JADX INFO: compiled from: ScreenShareManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ScreenShareManager$State {
    private final StoreApplicationStreaming$ActiveApplicationStream activeStream;
    private final Long meId;
    private final RtcConnection rtcConnection;

    public ScreenShareManager$State(StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream, RtcConnection rtcConnection, Long l) {
        this.activeStream = storeApplicationStreaming$ActiveApplicationStream;
        this.rtcConnection = rtcConnection;
        this.meId = l;
    }

    public static /* synthetic */ ScreenShareManager$State copy$default(ScreenShareManager$State screenShareManager$State, StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream, RtcConnection rtcConnection, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            storeApplicationStreaming$ActiveApplicationStream = screenShareManager$State.activeStream;
        }
        if ((i & 2) != 0) {
            rtcConnection = screenShareManager$State.rtcConnection;
        }
        if ((i & 4) != 0) {
            l = screenShareManager$State.meId;
        }
        return screenShareManager$State.copy(storeApplicationStreaming$ActiveApplicationStream, rtcConnection, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreApplicationStreaming$ActiveApplicationStream getActiveStream() {
        return this.activeStream;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final RtcConnection getRtcConnection() {
        return this.rtcConnection;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getMeId() {
        return this.meId;
    }

    public final ScreenShareManager$State copy(StoreApplicationStreaming$ActiveApplicationStream activeStream, RtcConnection rtcConnection, Long meId) {
        return new ScreenShareManager$State(activeStream, rtcConnection, meId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScreenShareManager$State)) {
            return false;
        }
        ScreenShareManager$State screenShareManager$State = (ScreenShareManager$State) other;
        return m.areEqual(this.activeStream, screenShareManager$State.activeStream) && m.areEqual(this.rtcConnection, screenShareManager$State.rtcConnection) && m.areEqual(this.meId, screenShareManager$State.meId);
    }

    public final StoreApplicationStreaming$ActiveApplicationStream getActiveStream() {
        return this.activeStream;
    }

    public final Long getMeId() {
        return this.meId;
    }

    public final RtcConnection getRtcConnection() {
        return this.rtcConnection;
    }

    public int hashCode() {
        StoreApplicationStreaming$ActiveApplicationStream storeApplicationStreaming$ActiveApplicationStream = this.activeStream;
        int iHashCode = (storeApplicationStreaming$ActiveApplicationStream != null ? storeApplicationStreaming$ActiveApplicationStream.hashCode() : 0) * 31;
        RtcConnection rtcConnection = this.rtcConnection;
        int iHashCode2 = (iHashCode + (rtcConnection != null ? rtcConnection.hashCode() : 0)) * 31;
        Long l = this.meId;
        return iHashCode2 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("State(activeStream=");
        sbU.append(this.activeStream);
        sbU.append(", rtcConnection=");
        sbU.append(this.rtcConnection);
        sbU.append(", meId=");
        return a.G(sbU, this.meId, ")");
    }
}
