package com.discord.widgets.settings.premium;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ClaimOutboundPromoViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ClaimOutboundPromoViewModel$ViewState$Claimed extends ClaimOutboundPromoViewModel$ViewState {
    private final ClaimStatus$Claimed claimedStatus;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClaimOutboundPromoViewModel$ViewState$Claimed(ClaimStatus$Claimed claimStatus$Claimed) {
        super(null);
        m.checkNotNullParameter(claimStatus$Claimed, "claimedStatus");
        this.claimedStatus = claimStatus$Claimed;
    }

    public static /* synthetic */ ClaimOutboundPromoViewModel$ViewState$Claimed copy$default(ClaimOutboundPromoViewModel$ViewState$Claimed claimOutboundPromoViewModel$ViewState$Claimed, ClaimStatus$Claimed claimStatus$Claimed, int i, Object obj) {
        if ((i & 1) != 0) {
            claimStatus$Claimed = claimOutboundPromoViewModel$ViewState$Claimed.claimedStatus;
        }
        return claimOutboundPromoViewModel$ViewState$Claimed.copy(claimStatus$Claimed);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ClaimStatus$Claimed getClaimedStatus() {
        return this.claimedStatus;
    }

    public final ClaimOutboundPromoViewModel$ViewState$Claimed copy(ClaimStatus$Claimed claimedStatus) {
        m.checkNotNullParameter(claimedStatus, "claimedStatus");
        return new ClaimOutboundPromoViewModel$ViewState$Claimed(claimedStatus);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ClaimOutboundPromoViewModel$ViewState$Claimed) && m.areEqual(this.claimedStatus, ((ClaimOutboundPromoViewModel$ViewState$Claimed) other).claimedStatus);
        }
        return true;
    }

    public final ClaimStatus$Claimed getClaimedStatus() {
        return this.claimedStatus;
    }

    public int hashCode() {
        ClaimStatus$Claimed claimStatus$Claimed = this.claimedStatus;
        if (claimStatus$Claimed != null) {
            return claimStatus$Claimed.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Claimed(claimedStatus=");
        sbU.append(this.claimedStatus);
        sbU.append(")");
        return sbU.toString();
    }
}
