package com.discord.api.application;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ProfileApplication.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ProfileApplication {
    private final String customInstallUrl;
    private final String id;
    private final ProfileApplication2 installParams;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getCustomInstallUrl() {
        return this.customInstallUrl;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final ProfileApplication2 getInstallParams() {
        return this.installParams;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProfileApplication)) {
            return false;
        }
        ProfileApplication profileApplication = (ProfileApplication) other;
        return Intrinsics3.areEqual(this.id, profileApplication.id) && Intrinsics3.areEqual(this.customInstallUrl, profileApplication.customInstallUrl) && Intrinsics3.areEqual(this.installParams, profileApplication.installParams);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.customInstallUrl;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ProfileApplication2 profileApplication2 = this.installParams;
        return iHashCode2 + (profileApplication2 != null ? profileApplication2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ProfileApplication(id=");
        sbU.append(this.id);
        sbU.append(", customInstallUrl=");
        sbU.append(this.customInstallUrl);
        sbU.append(", installParams=");
        sbU.append(this.installParams);
        sbU.append(")");
        return sbU.toString();
    }
}
