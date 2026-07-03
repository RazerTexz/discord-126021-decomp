package com.discord.api.auth.mfa;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: BackupCode.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class BackupCode {
    private final String code;
    private final boolean consumed;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final boolean getConsumed() {
        return this.consumed;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BackupCode)) {
            return false;
        }
        BackupCode backupCode = (BackupCode) other;
        return C12238m.areEqual(this.code, backupCode.code) && this.consumed == backupCode.consumed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        String str = this.code;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z2 = this.consumed;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("BackupCode(code=");
        sbM833U.append(this.code);
        sbM833U.append(", consumed=");
        return C1643a.m827O(sbM833U, this.consumed, ")");
    }
}
