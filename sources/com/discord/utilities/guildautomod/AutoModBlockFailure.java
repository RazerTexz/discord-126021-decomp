package com.discord.utilities.guildautomod;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: AutoModUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AutoModBlockFailure extends Throwable {
    private final int errorStringId;
    private final String reasonCode;

    public AutoModBlockFailure(int i, String str) {
        m.checkNotNullParameter(str, "reasonCode");
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
        m.checkNotNullParameter(reasonCode, "reasonCode");
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
        return this.errorStringId == autoModBlockFailure.errorStringId && m.areEqual(this.reasonCode, autoModBlockFailure.reasonCode);
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
        StringBuilder sbU = a.U("AutoModBlockFailure(errorStringId=");
        sbU.append(this.errorStringId);
        sbU.append(", reasonCode=");
        return a.J(sbU, this.reasonCode, ")");
    }
}
