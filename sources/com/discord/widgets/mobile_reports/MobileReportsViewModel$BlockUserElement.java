package com.discord.widgets.mobile_reports;

import b.d.b.a.a;
import com.discord.models.user.User;
import d0.z.d.m;

/* JADX INFO: compiled from: MobileReportsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MobileReportsViewModel$BlockUserElement {
    private final boolean isBlocked;
    private final User user;

    public MobileReportsViewModel$BlockUserElement(boolean z2, User user) {
        m.checkNotNullParameter(user, "user");
        this.isBlocked = z2;
        this.user = user;
    }

    public static /* synthetic */ MobileReportsViewModel$BlockUserElement copy$default(MobileReportsViewModel$BlockUserElement mobileReportsViewModel$BlockUserElement, boolean z2, User user, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = mobileReportsViewModel$BlockUserElement.isBlocked;
        }
        if ((i & 2) != 0) {
            user = mobileReportsViewModel$BlockUserElement.user;
        }
        return mobileReportsViewModel$BlockUserElement.copy(z2, user);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsBlocked() {
        return this.isBlocked;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    public final MobileReportsViewModel$BlockUserElement copy(boolean isBlocked, User user) {
        m.checkNotNullParameter(user, "user");
        return new MobileReportsViewModel$BlockUserElement(isBlocked, user);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MobileReportsViewModel$BlockUserElement)) {
            return false;
        }
        MobileReportsViewModel$BlockUserElement mobileReportsViewModel$BlockUserElement = (MobileReportsViewModel$BlockUserElement) other;
        return this.isBlocked == mobileReportsViewModel$BlockUserElement.isBlocked && m.areEqual(this.user, mobileReportsViewModel$BlockUserElement.user);
    }

    public final User getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z2 = this.isBlocked;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        User user = this.user;
        return i + (user != null ? user.hashCode() : 0);
    }

    public final boolean isBlocked() {
        return this.isBlocked;
    }

    public String toString() {
        StringBuilder sbU = a.U("BlockUserElement(isBlocked=");
        sbU.append(this.isBlocked);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(")");
        return sbU.toString();
    }
}
