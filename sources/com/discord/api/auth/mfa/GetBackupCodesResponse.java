package com.discord.api.auth.mfa;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: GetBackupCodesResponse.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GetBackupCodesResponse {
    private final List<BackupCode> backupCodes;

    public final List<BackupCode> a() {
        return this.backupCodes;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GetBackupCodesResponse) && m.areEqual(this.backupCodes, ((GetBackupCodesResponse) other).backupCodes);
        }
        return true;
    }

    public int hashCode() {
        List<BackupCode> list = this.backupCodes;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.L(a.U("GetBackupCodesResponse(backupCodes="), this.backupCodes, ")");
    }
}
