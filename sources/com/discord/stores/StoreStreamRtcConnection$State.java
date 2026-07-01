package com.discord.stores;

import b.d.b.a.a;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.RtcConnection$Quality;
import com.discord.rtcconnection.RtcConnection$State;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreStreamRtcConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreStreamRtcConnection$State {
    private final RtcConnection$Quality connectionQuality;
    private final String mediaSessionId;
    private final RtcConnection rtcConnection;
    private final RtcConnection$State rtcConnectionState;

    public StoreStreamRtcConnection$State(RtcConnection$State rtcConnection$State, RtcConnection$Quality rtcConnection$Quality, String str, RtcConnection rtcConnection) {
        m.checkNotNullParameter(rtcConnection$State, "rtcConnectionState");
        this.rtcConnectionState = rtcConnection$State;
        this.connectionQuality = rtcConnection$Quality;
        this.mediaSessionId = str;
        this.rtcConnection = rtcConnection;
    }

    public static /* synthetic */ StoreStreamRtcConnection$State copy$default(StoreStreamRtcConnection$State storeStreamRtcConnection$State, RtcConnection$State rtcConnection$State, RtcConnection$Quality rtcConnection$Quality, String str, RtcConnection rtcConnection, int i, Object obj) {
        if ((i & 1) != 0) {
            rtcConnection$State = storeStreamRtcConnection$State.rtcConnectionState;
        }
        if ((i & 2) != 0) {
            rtcConnection$Quality = storeStreamRtcConnection$State.connectionQuality;
        }
        if ((i & 4) != 0) {
            str = storeStreamRtcConnection$State.mediaSessionId;
        }
        if ((i & 8) != 0) {
            rtcConnection = storeStreamRtcConnection$State.rtcConnection;
        }
        return storeStreamRtcConnection$State.copy(rtcConnection$State, rtcConnection$Quality, str, rtcConnection);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final RtcConnection$State getRtcConnectionState() {
        return this.rtcConnectionState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final RtcConnection$Quality getConnectionQuality() {
        return this.connectionQuality;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMediaSessionId() {
        return this.mediaSessionId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final RtcConnection getRtcConnection() {
        return this.rtcConnection;
    }

    public final StoreStreamRtcConnection$State copy(RtcConnection$State rtcConnectionState, RtcConnection$Quality connectionQuality, String mediaSessionId, RtcConnection rtcConnection) {
        m.checkNotNullParameter(rtcConnectionState, "rtcConnectionState");
        return new StoreStreamRtcConnection$State(rtcConnectionState, connectionQuality, mediaSessionId, rtcConnection);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreStreamRtcConnection$State)) {
            return false;
        }
        StoreStreamRtcConnection$State storeStreamRtcConnection$State = (StoreStreamRtcConnection$State) other;
        return m.areEqual(this.rtcConnectionState, storeStreamRtcConnection$State.rtcConnectionState) && m.areEqual(this.connectionQuality, storeStreamRtcConnection$State.connectionQuality) && m.areEqual(this.mediaSessionId, storeStreamRtcConnection$State.mediaSessionId) && m.areEqual(this.rtcConnection, storeStreamRtcConnection$State.rtcConnection);
    }

    public final RtcConnection$Quality getConnectionQuality() {
        return this.connectionQuality;
    }

    public final String getMediaSessionId() {
        return this.mediaSessionId;
    }

    public final RtcConnection getRtcConnection() {
        return this.rtcConnection;
    }

    public final RtcConnection$State getRtcConnectionState() {
        return this.rtcConnectionState;
    }

    public int hashCode() {
        RtcConnection$State rtcConnection$State = this.rtcConnectionState;
        int iHashCode = (rtcConnection$State != null ? rtcConnection$State.hashCode() : 0) * 31;
        RtcConnection$Quality rtcConnection$Quality = this.connectionQuality;
        int iHashCode2 = (iHashCode + (rtcConnection$Quality != null ? rtcConnection$Quality.hashCode() : 0)) * 31;
        String str = this.mediaSessionId;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        RtcConnection rtcConnection = this.rtcConnection;
        return iHashCode3 + (rtcConnection != null ? rtcConnection.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("State(rtcConnectionState=");
        sbU.append(this.rtcConnectionState);
        sbU.append(", connectionQuality=");
        sbU.append(this.connectionQuality);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", rtcConnection=");
        sbU.append(this.rtcConnection);
        sbU.append(")");
        return sbU.toString();
    }
}
