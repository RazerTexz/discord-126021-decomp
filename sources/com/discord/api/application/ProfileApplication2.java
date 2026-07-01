package com.discord.api.application;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.Arrays;

/* JADX INFO: renamed from: com.discord.api.application.ApplicationInstallParams, reason: use source file name */
/* JADX INFO: compiled from: ProfileApplication.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ProfileApplication2 {
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
        if (!(other instanceof ProfileApplication2)) {
            return false;
        }
        ProfileApplication2 profileApplication2 = (ProfileApplication2) other;
        return Intrinsics3.areEqual(this.permissions, profileApplication2.permissions) && Intrinsics3.areEqual(this.scopes, profileApplication2.scopes);
    }

    public int hashCode() {
        String str = this.permissions;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String[] strArr = this.scopes;
        return iHashCode + (strArr != null ? Arrays.hashCode(strArr) : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ApplicationInstallParams(permissions=");
        sbU.append(this.permissions);
        sbU.append(", scopes=");
        return outline.J(sbU, Arrays.toString(this.scopes), ")");
    }
}
