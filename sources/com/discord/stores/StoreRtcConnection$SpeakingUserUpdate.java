package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: StoreRtcConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreRtcConnection$SpeakingUserUpdate {
    private final boolean isSpeaking;
    private final long userId;

    public StoreRtcConnection$SpeakingUserUpdate(long j, boolean z2) {
        this.userId = j;
        this.isSpeaking = z2;
    }

    public static /* synthetic */ StoreRtcConnection$SpeakingUserUpdate copy$default(StoreRtcConnection$SpeakingUserUpdate storeRtcConnection$SpeakingUserUpdate, long j, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = storeRtcConnection$SpeakingUserUpdate.userId;
        }
        if ((i & 2) != 0) {
            z2 = storeRtcConnection$SpeakingUserUpdate.isSpeaking;
        }
        return storeRtcConnection$SpeakingUserUpdate.copy(j, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsSpeaking() {
        return this.isSpeaking;
    }

    public final StoreRtcConnection$SpeakingUserUpdate copy(long userId, boolean isSpeaking) {
        return new StoreRtcConnection$SpeakingUserUpdate(userId, isSpeaking);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreRtcConnection$SpeakingUserUpdate)) {
            return false;
        }
        StoreRtcConnection$SpeakingUserUpdate storeRtcConnection$SpeakingUserUpdate = (StoreRtcConnection$SpeakingUserUpdate) other;
        return this.userId == storeRtcConnection$SpeakingUserUpdate.userId && this.isSpeaking == storeRtcConnection$SpeakingUserUpdate.isSpeaking;
    }

    public final long getUserId() {
        return this.userId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        int iA = b.a(this.userId) * 31;
        boolean z2 = this.isSpeaking;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iA + r1;
    }

    public final boolean isSpeaking() {
        return this.isSpeaking;
    }

    public String toString() {
        StringBuilder sbU = a.U("SpeakingUserUpdate(userId=");
        sbU.append(this.userId);
        sbU.append(", isSpeaking=");
        return a.O(sbU, this.isSpeaking, ")");
    }
}
