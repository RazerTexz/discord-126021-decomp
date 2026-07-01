package com.discord.rtcconnection.enums;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ScoAudioState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ScoAudioState$b {
    public final ScoAudioState a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScoAudioState f2792b;

    public ScoAudioState$b(ScoAudioState scoAudioState, ScoAudioState scoAudioState2) {
        m.checkNotNullParameter(scoAudioState, "current");
        m.checkNotNullParameter(scoAudioState2, "previous");
        this.a = scoAudioState;
        this.f2792b = scoAudioState2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScoAudioState$b)) {
            return false;
        }
        ScoAudioState$b scoAudioState$b = (ScoAudioState$b) obj;
        return m.areEqual(this.a, scoAudioState$b.a) && m.areEqual(this.f2792b, scoAudioState$b.f2792b);
    }

    public int hashCode() {
        ScoAudioState scoAudioState = this.a;
        int iHashCode = (scoAudioState != null ? scoAudioState.hashCode() : 0) * 31;
        ScoAudioState scoAudioState2 = this.f2792b;
        return iHashCode + (scoAudioState2 != null ? scoAudioState2.hashCode() : 0);
    }

    public String toString() {
        if (this.f2792b == ScoAudioState.Error) {
            return String.valueOf(this.a);
        }
        StringBuilder sbU = a.U("Update(");
        sbU.append(this.f2792b);
        sbU.append(" -> ");
        sbU.append(this.a);
        sbU.append(')');
        return sbU.toString();
    }
}
