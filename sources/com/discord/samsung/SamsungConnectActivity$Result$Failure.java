package com.discord.samsung;

import b.d.b.a.a;

/* JADX INFO: compiled from: SamsungConnectActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class SamsungConnectActivity$Result$Failure extends SamsungConnectActivity$Result {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final boolean isRetryAllowed;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int attemptCount;

    public SamsungConnectActivity$Result$Failure(boolean z2, int i) {
        super(null);
        this.isRetryAllowed = z2;
        this.attemptCount = i;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SamsungConnectActivity$Result$Failure)) {
            return false;
        }
        SamsungConnectActivity$Result$Failure samsungConnectActivity$Result$Failure = (SamsungConnectActivity$Result$Failure) other;
        return this.isRetryAllowed == samsungConnectActivity$Result$Failure.isRetryAllowed && this.attemptCount == samsungConnectActivity$Result$Failure.attemptCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z2 = this.isRetryAllowed;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        return (r0 * 31) + this.attemptCount;
    }

    public String toString() {
        StringBuilder sbU = a.U("Failure(isRetryAllowed=");
        sbU.append(this.isRetryAllowed);
        sbU.append(", attemptCount=");
        return a.B(sbU, this.attemptCount, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SamsungConnectActivity$Result$Failure(boolean z2, int i, int i2) {
        super(null);
        i = (i2 & 2) != 0 ? 0 : i;
        this.isRetryAllowed = z2;
        this.attemptCount = i;
    }
}
