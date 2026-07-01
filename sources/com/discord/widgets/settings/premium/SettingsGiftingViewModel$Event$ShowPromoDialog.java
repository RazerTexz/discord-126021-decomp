package com.discord.widgets.settings.premium;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SettingsGiftingViewModel$Event$ShowPromoDialog extends SettingsGiftingViewModel$Event {
    private final ClaimStatus claimStatus;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsGiftingViewModel$Event$ShowPromoDialog(ClaimStatus claimStatus) {
        super(null);
        m.checkNotNullParameter(claimStatus, "claimStatus");
        this.claimStatus = claimStatus;
    }

    public static /* synthetic */ SettingsGiftingViewModel$Event$ShowPromoDialog copy$default(SettingsGiftingViewModel$Event$ShowPromoDialog settingsGiftingViewModel$Event$ShowPromoDialog, ClaimStatus claimStatus, int i, Object obj) {
        if ((i & 1) != 0) {
            claimStatus = settingsGiftingViewModel$Event$ShowPromoDialog.claimStatus;
        }
        return settingsGiftingViewModel$Event$ShowPromoDialog.copy(claimStatus);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ClaimStatus getClaimStatus() {
        return this.claimStatus;
    }

    public final SettingsGiftingViewModel$Event$ShowPromoDialog copy(ClaimStatus claimStatus) {
        m.checkNotNullParameter(claimStatus, "claimStatus");
        return new SettingsGiftingViewModel$Event$ShowPromoDialog(claimStatus);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof SettingsGiftingViewModel$Event$ShowPromoDialog) && m.areEqual(this.claimStatus, ((SettingsGiftingViewModel$Event$ShowPromoDialog) other).claimStatus);
        }
        return true;
    }

    public final ClaimStatus getClaimStatus() {
        return this.claimStatus;
    }

    public int hashCode() {
        ClaimStatus claimStatus = this.claimStatus;
        if (claimStatus != null) {
            return claimStatus.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("ShowPromoDialog(claimStatus=");
        sbU.append(this.claimStatus);
        sbU.append(")");
        return sbU.toString();
    }
}
