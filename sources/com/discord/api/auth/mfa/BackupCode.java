package com.discord.api.auth.mfa;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

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
        return m.areEqual(this.code, backupCode.code) && this.consumed == backupCode.consumed;
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
        StringBuilder sbU = a.U("BackupCode(code=");
        sbU.append(this.code);
        sbU.append(", consumed=");
        return a.O(sbU, this.consumed, ")");
    }
}
