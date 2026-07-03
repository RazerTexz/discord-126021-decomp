package com.discord.utilities.guildautomod;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AutoModUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AutoModBlockFailure extends Throwable {
    private final int errorStringId;
    private final String reasonCode;

    public AutoModBlockFailure(int i, String str) {
        C12238m.checkNotNullParameter(str, "reasonCode");
        this.errorStringId = i;
        this.reasonCode = str;
    }

    public static /* synthetic */ AutoModBlockFailure copy$default(AutoModBlockFailure autoModBlockFailure, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = autoModBlockFailure.errorStringId;
        }
        if ((i2 & 2) != 0) {
            str = autoModBlockFailure.reasonCode;
        }
        return autoModBlockFailure.copy(i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getErrorStringId() {
        return this.errorStringId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getReasonCode() {
        return this.reasonCode;
    }

    public final AutoModBlockFailure copy(int errorStringId, String reasonCode) {
        C12238m.checkNotNullParameter(reasonCode, "reasonCode");
        return new AutoModBlockFailure(errorStringId, reasonCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AutoModBlockFailure)) {
            return false;
        }
        AutoModBlockFailure autoModBlockFailure = (AutoModBlockFailure) other;
        return this.errorStringId == autoModBlockFailure.errorStringId && C12238m.areEqual(this.reasonCode, autoModBlockFailure.reasonCode);
    }

    public final int getErrorStringId() {
        return this.errorStringId;
    }

    public final String getReasonCode() {
        return this.reasonCode;
    }

    public int hashCode() {
        int i = this.errorStringId * 31;
        String str = this.reasonCode;
        return i + (str != null ? str.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("AutoModBlockFailure(errorStringId=");
        sbM833U.append(this.errorStringId);
        sbM833U.append(", reasonCode=");
        return C1643a.m822J(sbM833U, this.reasonCode, ")");
    }
}
