package com.discord.api.application;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ProfileApplication.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ProfileApplication {
    private final String customInstallUrl;
    private final String id;
    private final ApplicationInstallParams installParams;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getCustomInstallUrl() {
        return this.customInstallUrl;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final ApplicationInstallParams getInstallParams() {
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
        return C12238m.areEqual(this.id, profileApplication.id) && C12238m.areEqual(this.customInstallUrl, profileApplication.customInstallUrl) && C12238m.areEqual(this.installParams, profileApplication.installParams);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.customInstallUrl;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ApplicationInstallParams applicationInstallParams = this.installParams;
        return iHashCode2 + (applicationInstallParams != null ? applicationInstallParams.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ProfileApplication(id=");
        sbM833U.append(this.id);
        sbM833U.append(", customInstallUrl=");
        sbM833U.append(this.customInstallUrl);
        sbM833U.append(", installParams=");
        sbM833U.append(this.installParams);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
