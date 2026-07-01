package com.discord.rtcconnection;

import b.d.b.a.a;

/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RtcConnection$State$d extends RtcConnection$State {
    public final boolean a;

    public RtcConnection$State$d(boolean z2) {
        super(null);
        this.a = z2;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RtcConnection$State$d) && this.a == ((RtcConnection$State$d) obj).a;
        }
        return true;
    }

    public int hashCode() {
        boolean z2 = this.a;
        if (z2) {
            return 1;
        }
        return z2 ? 1 : 0;
    }

    @Override // com.discord.rtcconnection.RtcConnection$State
    public String toString() {
        return a.O(a.U("Disconnected(willReconnect="), this.a, ")");
    }
}
