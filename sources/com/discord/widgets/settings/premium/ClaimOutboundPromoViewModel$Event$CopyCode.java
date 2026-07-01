package com.discord.widgets.settings.premium;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: ClaimOutboundPromoViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ClaimOutboundPromoViewModel$Event$CopyCode extends ClaimOutboundPromoViewModel$Event {
    private final String code;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClaimOutboundPromoViewModel$Event$CopyCode(String str) {
        super(null);
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
        this.code = str;
    }

    public static /* synthetic */ ClaimOutboundPromoViewModel$Event$CopyCode copy$default(ClaimOutboundPromoViewModel$Event$CopyCode claimOutboundPromoViewModel$Event$CopyCode, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = claimOutboundPromoViewModel$Event$CopyCode.code;
        }
        return claimOutboundPromoViewModel$Event$CopyCode.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    public final ClaimOutboundPromoViewModel$Event$CopyCode copy(String code) {
        m.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        return new ClaimOutboundPromoViewModel$Event$CopyCode(code);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ClaimOutboundPromoViewModel$Event$CopyCode) && m.areEqual(this.code, ((ClaimOutboundPromoViewModel$Event$CopyCode) other).code);
        }
        return true;
    }

    public final String getCode() {
        return this.code;
    }

    public int hashCode() {
        String str = this.code;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.J(a.U("CopyCode(code="), this.code, ")");
    }
}
