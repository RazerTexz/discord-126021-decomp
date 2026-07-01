package com.discord.api.auth.mfa;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: EnableMfaResponse.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class EnableMfaResponse {
    private final List<BackupCode> backupCodes;
    private final String token;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnableMfaResponse)) {
            return false;
        }
        EnableMfaResponse enableMfaResponse = (EnableMfaResponse) other;
        return Intrinsics3.areEqual(this.token, enableMfaResponse.token) && Intrinsics3.areEqual(this.backupCodes, enableMfaResponse.backupCodes);
    }

    public int hashCode() {
        String str = this.token;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<BackupCode> list = this.backupCodes;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("EnableMfaResponse(token=");
        sbU.append(this.token);
        sbU.append(", backupCodes=");
        return outline.L(sbU, this.backupCodes, ")");
    }
}
