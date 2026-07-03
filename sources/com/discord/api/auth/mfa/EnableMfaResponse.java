package com.discord.api.auth.mfa;

import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.token, enableMfaResponse.token) && C12238m.areEqual(this.backupCodes, enableMfaResponse.backupCodes);
    }

    public int hashCode() {
        String str = this.token;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<BackupCode> list = this.backupCodes;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("EnableMfaResponse(token=");
        sbM833U.append(this.token);
        sbM833U.append(", backupCodes=");
        return C1643a.m824L(sbM833U, this.backupCodes, ")");
    }
}
