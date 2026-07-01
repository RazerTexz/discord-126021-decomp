package com.discord.widgets.servers.member_verification;

import b.d.b.a.a;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import d0.z.d.m;

/* JADX INFO: compiled from: MemberVerificationPendingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MemberVerificationPendingViewModel$StoreState {
    private final ApplicationStatus applicationStatus;
    private final boolean isFormOutdated;
    private final boolean isPreviewEnabled;
    private final String rejectionReason;

    public MemberVerificationPendingViewModel$StoreState(boolean z2, boolean z3, ApplicationStatus applicationStatus, String str) {
        m.checkNotNullParameter(applicationStatus, "applicationStatus");
        this.isFormOutdated = z2;
        this.isPreviewEnabled = z3;
        this.applicationStatus = applicationStatus;
        this.rejectionReason = str;
    }

    public static /* synthetic */ MemberVerificationPendingViewModel$StoreState copy$default(MemberVerificationPendingViewModel$StoreState memberVerificationPendingViewModel$StoreState, boolean z2, boolean z3, ApplicationStatus applicationStatus, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = memberVerificationPendingViewModel$StoreState.isFormOutdated;
        }
        if ((i & 2) != 0) {
            z3 = memberVerificationPendingViewModel$StoreState.isPreviewEnabled;
        }
        if ((i & 4) != 0) {
            applicationStatus = memberVerificationPendingViewModel$StoreState.applicationStatus;
        }
        if ((i & 8) != 0) {
            str = memberVerificationPendingViewModel$StoreState.rejectionReason;
        }
        return memberVerificationPendingViewModel$StoreState.copy(z2, z3, applicationStatus, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsFormOutdated() {
        return this.isFormOutdated;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsPreviewEnabled() {
        return this.isPreviewEnabled;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ApplicationStatus getApplicationStatus() {
        return this.applicationStatus;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getRejectionReason() {
        return this.rejectionReason;
    }

    public final MemberVerificationPendingViewModel$StoreState copy(boolean isFormOutdated, boolean isPreviewEnabled, ApplicationStatus applicationStatus, String rejectionReason) {
        m.checkNotNullParameter(applicationStatus, "applicationStatus");
        return new MemberVerificationPendingViewModel$StoreState(isFormOutdated, isPreviewEnabled, applicationStatus, rejectionReason);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemberVerificationPendingViewModel$StoreState)) {
            return false;
        }
        MemberVerificationPendingViewModel$StoreState memberVerificationPendingViewModel$StoreState = (MemberVerificationPendingViewModel$StoreState) other;
        return this.isFormOutdated == memberVerificationPendingViewModel$StoreState.isFormOutdated && this.isPreviewEnabled == memberVerificationPendingViewModel$StoreState.isPreviewEnabled && m.areEqual(this.applicationStatus, memberVerificationPendingViewModel$StoreState.applicationStatus) && m.areEqual(this.rejectionReason, memberVerificationPendingViewModel$StoreState.rejectionReason);
    }

    public final ApplicationStatus getApplicationStatus() {
        return this.applicationStatus;
    }

    public final String getRejectionReason() {
        return this.rejectionReason;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        boolean z2 = this.isFormOutdated;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.isPreviewEnabled;
        int i2 = (i + (z3 ? 1 : z3)) * 31;
        ApplicationStatus applicationStatus = this.applicationStatus;
        int iHashCode = (i2 + (applicationStatus != null ? applicationStatus.hashCode() : 0)) * 31;
        String str = this.rejectionReason;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final boolean isFormOutdated() {
        return this.isFormOutdated;
    }

    public final boolean isPreviewEnabled() {
        return this.isPreviewEnabled;
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(isFormOutdated=");
        sbU.append(this.isFormOutdated);
        sbU.append(", isPreviewEnabled=");
        sbU.append(this.isPreviewEnabled);
        sbU.append(", applicationStatus=");
        sbU.append(this.applicationStatus);
        sbU.append(", rejectionReason=");
        return a.J(sbU, this.rejectionReason, ")");
    }
}
