package com.discord.rtcconnection;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RtcConnection$StateChange {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final RtcConnection$State state;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final RtcConnection$Metadata metadata;

    public RtcConnection$StateChange(RtcConnection$State rtcConnection$State, RtcConnection$Metadata rtcConnection$Metadata) {
        m.checkNotNullParameter(rtcConnection$State, "state");
        this.state = rtcConnection$State;
        this.metadata = rtcConnection$Metadata;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RtcConnection$StateChange)) {
            return false;
        }
        RtcConnection$StateChange rtcConnection$StateChange = (RtcConnection$StateChange) other;
        return m.areEqual(this.state, rtcConnection$StateChange.state) && m.areEqual(this.metadata, rtcConnection$StateChange.metadata);
    }

    public int hashCode() {
        RtcConnection$State rtcConnection$State = this.state;
        int iHashCode = (rtcConnection$State != null ? rtcConnection$State.hashCode() : 0) * 31;
        RtcConnection$Metadata rtcConnection$Metadata = this.metadata;
        return iHashCode + (rtcConnection$Metadata != null ? rtcConnection$Metadata.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StateChange(state=");
        sbU.append(this.state);
        sbU.append(", metadata=");
        sbU.append(this.metadata);
        sbU.append(")");
        return sbU.toString();
    }
}
