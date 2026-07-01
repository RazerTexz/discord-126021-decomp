package com.discord.api.application;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.Arrays;

/* JADX INFO: compiled from: ProfileApplication.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ApplicationInstallParams {
    private final String permissions;
    private final String[] scopes;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getPermissions() {
        return this.permissions;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String[] getScopes() {
        return this.scopes;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationInstallParams)) {
            return false;
        }
        ApplicationInstallParams applicationInstallParams = (ApplicationInstallParams) other;
        return m.areEqual(this.permissions, applicationInstallParams.permissions) && m.areEqual(this.scopes, applicationInstallParams.scopes);
    }

    public int hashCode() {
        String str = this.permissions;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String[] strArr = this.scopes;
        return iHashCode + (strArr != null ? Arrays.hashCode(strArr) : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ApplicationInstallParams(permissions=");
        sbU.append(this.permissions);
        sbU.append(", scopes=");
        return a.J(sbU, Arrays.toString(this.scopes), ")");
    }
}
