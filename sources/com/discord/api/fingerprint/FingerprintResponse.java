package com.discord.api.fingerprint;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: FingerprintResponse.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class FingerprintResponse {
    private final String fingerprint;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getFingerprint() {
        return this.fingerprint;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof FingerprintResponse) && C12238m.areEqual(this.fingerprint, ((FingerprintResponse) other).fingerprint);
        }
        return true;
    }

    public int hashCode() {
        String str = this.fingerprint;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return C1643a.m822J(C1643a.m833U("FingerprintResponse(fingerprint="), this.fingerprint, ")");
    }
}
