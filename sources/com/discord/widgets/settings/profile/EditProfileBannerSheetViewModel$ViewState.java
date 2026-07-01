package com.discord.widgets.settings.profile;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: EditProfileBannerSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class EditProfileBannerSheetViewModel$ViewState {
    private final String bannerColorHex;
    private final boolean showPremiumUpsell;

    public EditProfileBannerSheetViewModel$ViewState(String str, boolean z2) {
        m.checkNotNullParameter(str, "bannerColorHex");
        this.bannerColorHex = str;
        this.showPremiumUpsell = z2;
    }

    public static /* synthetic */ EditProfileBannerSheetViewModel$ViewState copy$default(EditProfileBannerSheetViewModel$ViewState editProfileBannerSheetViewModel$ViewState, String str, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = editProfileBannerSheetViewModel$ViewState.bannerColorHex;
        }
        if ((i & 2) != 0) {
            z2 = editProfileBannerSheetViewModel$ViewState.showPremiumUpsell;
        }
        return editProfileBannerSheetViewModel$ViewState.copy(str, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBannerColorHex() {
        return this.bannerColorHex;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getShowPremiumUpsell() {
        return this.showPremiumUpsell;
    }

    public final EditProfileBannerSheetViewModel$ViewState copy(String bannerColorHex, boolean showPremiumUpsell) {
        m.checkNotNullParameter(bannerColorHex, "bannerColorHex");
        return new EditProfileBannerSheetViewModel$ViewState(bannerColorHex, showPremiumUpsell);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EditProfileBannerSheetViewModel$ViewState)) {
            return false;
        }
        EditProfileBannerSheetViewModel$ViewState editProfileBannerSheetViewModel$ViewState = (EditProfileBannerSheetViewModel$ViewState) other;
        return m.areEqual(this.bannerColorHex, editProfileBannerSheetViewModel$ViewState.bannerColorHex) && this.showPremiumUpsell == editProfileBannerSheetViewModel$ViewState.showPremiumUpsell;
    }

    public final String getBannerColorHex() {
        return this.bannerColorHex;
    }

    public final boolean getShowPremiumUpsell() {
        return this.showPremiumUpsell;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        String str = this.bannerColorHex;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z2 = this.showPremiumUpsell;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(bannerColorHex=");
        sbU.append(this.bannerColorHex);
        sbU.append(", showPremiumUpsell=");
        return a.O(sbU, this.showPremiumUpsell, ")");
    }
}
