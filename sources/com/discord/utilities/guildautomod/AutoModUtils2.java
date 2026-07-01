package com.discord.utilities.guildautomod;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.utilities.guildautomod.AutoModBlockFailure, reason: use source file name */
/* JADX INFO: compiled from: AutoModUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AutoModUtils2 extends Throwable {
    private final int errorStringId;
    private final String reasonCode;

    public AutoModUtils2(int i, String str) {
        Intrinsics3.checkNotNullParameter(str, "reasonCode");
        this.errorStringId = i;
        this.reasonCode = str;
    }

    public static /* synthetic */ AutoModUtils2 copy$default(AutoModUtils2 autoModUtils2, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = autoModUtils2.errorStringId;
        }
        if ((i2 & 2) != 0) {
            str = autoModUtils2.reasonCode;
        }
        return autoModUtils2.copy(i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getErrorStringId() {
        return this.errorStringId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getReasonCode() {
        return this.reasonCode;
    }

    public final AutoModUtils2 copy(int errorStringId, String reasonCode) {
        Intrinsics3.checkNotNullParameter(reasonCode, "reasonCode");
        return new AutoModUtils2(errorStringId, reasonCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AutoModUtils2)) {
            return false;
        }
        AutoModUtils2 autoModUtils2 = (AutoModUtils2) other;
        return this.errorStringId == autoModUtils2.errorStringId && Intrinsics3.areEqual(this.reasonCode, autoModUtils2.reasonCode);
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
        StringBuilder sbU = outline.U("AutoModBlockFailure(errorStringId=");
        sbU.append(this.errorStringId);
        sbU.append(", reasonCode=");
        return outline.J(sbU, this.reasonCode, ")");
    }
}
