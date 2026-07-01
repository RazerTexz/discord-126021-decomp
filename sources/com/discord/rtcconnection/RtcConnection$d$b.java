package com.discord.rtcconnection;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: RtcConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RtcConnection$d$b extends RtcConnection$d {
    public final long a;

    public RtcConnection$d$b(long j) {
        super(null);
        this.a = j;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RtcConnection$d$b) && this.a == ((RtcConnection$d$b) obj).a;
        }
        return true;
    }

    public int hashCode() {
        return b.a(this.a);
    }

    public String toString() {
        return a.C(a.U("Stream(senderId="), this.a, ")");
    }
}
