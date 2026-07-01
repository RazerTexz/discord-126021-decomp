package com.discord.widgets.stickers;

import b.d.b.a.a;
import com.discord.api.premium.PremiumTier;
import com.discord.api.sticker.Sticker;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.utilities.premium.PremiumUtilsKt;
import d0.z.d.m;

/* JADX INFO: compiled from: StickerSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class StickerSheetViewModel$ViewState {
    private final boolean canUsePremiumStickers;
    private final boolean isStickerPackEnabled;
    private final PremiumTier meUserPremiumTier;
    private final Sticker sticker;
    private final ModelStickerPack stickerPack;

    public StickerSheetViewModel$ViewState(ModelStickerPack modelStickerPack, Sticker sticker, PremiumTier premiumTier, boolean z2) {
        m.checkNotNullParameter(modelStickerPack, "stickerPack");
        m.checkNotNullParameter(sticker, "sticker");
        m.checkNotNullParameter(premiumTier, "meUserPremiumTier");
        this.stickerPack = modelStickerPack;
        this.sticker = sticker;
        this.meUserPremiumTier = premiumTier;
        this.isStickerPackEnabled = z2;
        this.canUsePremiumStickers = PremiumUtilsKt.grantsAccessToPremiumStickers(premiumTier);
    }

    public static /* synthetic */ StickerSheetViewModel$ViewState copy$default(StickerSheetViewModel$ViewState stickerSheetViewModel$ViewState, ModelStickerPack modelStickerPack, Sticker sticker, PremiumTier premiumTier, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            modelStickerPack = stickerSheetViewModel$ViewState.stickerPack;
        }
        if ((i & 2) != 0) {
            sticker = stickerSheetViewModel$ViewState.sticker;
        }
        if ((i & 4) != 0) {
            premiumTier = stickerSheetViewModel$ViewState.meUserPremiumTier;
        }
        if ((i & 8) != 0) {
            z2 = stickerSheetViewModel$ViewState.isStickerPackEnabled;
        }
        return stickerSheetViewModel$ViewState.copy(modelStickerPack, sticker, premiumTier, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelStickerPack getStickerPack() {
        return this.stickerPack;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Sticker getSticker() {
        return this.sticker;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PremiumTier getMeUserPremiumTier() {
        return this.meUserPremiumTier;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsStickerPackEnabled() {
        return this.isStickerPackEnabled;
    }

    public final StickerSheetViewModel$ViewState copy(ModelStickerPack stickerPack, Sticker sticker, PremiumTier meUserPremiumTier, boolean isStickerPackEnabled) {
        m.checkNotNullParameter(stickerPack, "stickerPack");
        m.checkNotNullParameter(sticker, "sticker");
        m.checkNotNullParameter(meUserPremiumTier, "meUserPremiumTier");
        return new StickerSheetViewModel$ViewState(stickerPack, sticker, meUserPremiumTier, isStickerPackEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerSheetViewModel$ViewState)) {
            return false;
        }
        StickerSheetViewModel$ViewState stickerSheetViewModel$ViewState = (StickerSheetViewModel$ViewState) other;
        return m.areEqual(this.stickerPack, stickerSheetViewModel$ViewState.stickerPack) && m.areEqual(this.sticker, stickerSheetViewModel$ViewState.sticker) && m.areEqual(this.meUserPremiumTier, stickerSheetViewModel$ViewState.meUserPremiumTier) && this.isStickerPackEnabled == stickerSheetViewModel$ViewState.isStickerPackEnabled;
    }

    public final boolean getCanUsePremiumStickers() {
        return this.canUsePremiumStickers;
    }

    public final PremiumTier getMeUserPremiumTier() {
        return this.meUserPremiumTier;
    }

    public final Sticker getSticker() {
        return this.sticker;
    }

    public final ModelStickerPack getStickerPack() {
        return this.stickerPack;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        ModelStickerPack modelStickerPack = this.stickerPack;
        int iHashCode = (modelStickerPack != null ? modelStickerPack.hashCode() : 0) * 31;
        Sticker sticker = this.sticker;
        int iHashCode2 = (iHashCode + (sticker != null ? sticker.hashCode() : 0)) * 31;
        PremiumTier premiumTier = this.meUserPremiumTier;
        int iHashCode3 = (iHashCode2 + (premiumTier != null ? premiumTier.hashCode() : 0)) * 31;
        boolean z2 = this.isStickerPackEnabled;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode3 + r1;
    }

    public final boolean isStickerPackEnabled() {
        return this.isStickerPackEnabled;
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(stickerPack=");
        sbU.append(this.stickerPack);
        sbU.append(", sticker=");
        sbU.append(this.sticker);
        sbU.append(", meUserPremiumTier=");
        sbU.append(this.meUserPremiumTier);
        sbU.append(", isStickerPackEnabled=");
        return a.O(sbU, this.isStickerPackEnabled, ")");
    }
}
