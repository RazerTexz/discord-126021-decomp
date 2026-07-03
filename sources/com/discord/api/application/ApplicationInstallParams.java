package com.discord.api.application;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Arrays;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.permissions, applicationInstallParams.permissions) && C12238m.areEqual(this.scopes, applicationInstallParams.scopes);
    }

    public int hashCode() {
        String str = this.permissions;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String[] strArr = this.scopes;
        return iHashCode + (strArr != null ? Arrays.hashCode(strArr) : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ApplicationInstallParams(permissions=");
        sbM833U.append(this.permissions);
        sbM833U.append(", scopes=");
        return C1643a.m822J(sbM833U, Arrays.toString(this.scopes), ")");
    }
}
