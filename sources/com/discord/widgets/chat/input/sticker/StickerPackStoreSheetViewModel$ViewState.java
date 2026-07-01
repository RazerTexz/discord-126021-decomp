package com.discord.widgets.chat.input.sticker;

import b.d.b.a.a;
import com.discord.api.premium.PremiumTier;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.premium.PremiumUtilsKt;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: StickerPackStoreSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StickerPackStoreSheetViewModel$ViewState {
    private final boolean isPackEnabled;
    private final PremiumTier meUserPremiumTier;
    private final List<MGRecyclerDataPayload> stickerItems;
    private final ModelStickerPack stickerPack;

    /* JADX WARN: Multi-variable type inference failed */
    public StickerPackStoreSheetViewModel$ViewState(ModelStickerPack modelStickerPack, List<? extends MGRecyclerDataPayload> list, PremiumTier premiumTier, boolean z2) {
        m.checkNotNullParameter(modelStickerPack, "stickerPack");
        m.checkNotNullParameter(list, "stickerItems");
        m.checkNotNullParameter(premiumTier, "meUserPremiumTier");
        this.stickerPack = modelStickerPack;
        this.stickerItems = list;
        this.meUserPremiumTier = premiumTier;
        this.isPackEnabled = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StickerPackStoreSheetViewModel$ViewState copy$default(StickerPackStoreSheetViewModel$ViewState stickerPackStoreSheetViewModel$ViewState, ModelStickerPack modelStickerPack, List list, PremiumTier premiumTier, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            modelStickerPack = stickerPackStoreSheetViewModel$ViewState.stickerPack;
        }
        if ((i & 2) != 0) {
            list = stickerPackStoreSheetViewModel$ViewState.stickerItems;
        }
        if ((i & 4) != 0) {
            premiumTier = stickerPackStoreSheetViewModel$ViewState.meUserPremiumTier;
        }
        if ((i & 8) != 0) {
            z2 = stickerPackStoreSheetViewModel$ViewState.isPackEnabled;
        }
        return stickerPackStoreSheetViewModel$ViewState.copy(modelStickerPack, list, premiumTier, z2);
    }

    public final boolean canUserAccessToPremiumStickers() {
        return PremiumUtilsKt.grantsAccessToPremiumStickers(this.meUserPremiumTier);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelStickerPack getStickerPack() {
        return this.stickerPack;
    }

    public final List<MGRecyclerDataPayload> component2() {
        return this.stickerItems;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PremiumTier getMeUserPremiumTier() {
        return this.meUserPremiumTier;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsPackEnabled() {
        return this.isPackEnabled;
    }

    public final StickerPackStoreSheetViewModel$ViewState copy(ModelStickerPack stickerPack, List<? extends MGRecyclerDataPayload> stickerItems, PremiumTier meUserPremiumTier, boolean isPackEnabled) {
        m.checkNotNullParameter(stickerPack, "stickerPack");
        m.checkNotNullParameter(stickerItems, "stickerItems");
        m.checkNotNullParameter(meUserPremiumTier, "meUserPremiumTier");
        return new StickerPackStoreSheetViewModel$ViewState(stickerPack, stickerItems, meUserPremiumTier, isPackEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerPackStoreSheetViewModel$ViewState)) {
            return false;
        }
        StickerPackStoreSheetViewModel$ViewState stickerPackStoreSheetViewModel$ViewState = (StickerPackStoreSheetViewModel$ViewState) other;
        return m.areEqual(this.stickerPack, stickerPackStoreSheetViewModel$ViewState.stickerPack) && m.areEqual(this.stickerItems, stickerPackStoreSheetViewModel$ViewState.stickerItems) && m.areEqual(this.meUserPremiumTier, stickerPackStoreSheetViewModel$ViewState.meUserPremiumTier) && this.isPackEnabled == stickerPackStoreSheetViewModel$ViewState.isPackEnabled;
    }

    public final PremiumTier getMeUserPremiumTier() {
        return this.meUserPremiumTier;
    }

    public final List<MGRecyclerDataPayload> getStickerItems() {
        return this.stickerItems;
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
        List<MGRecyclerDataPayload> list = this.stickerItems;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        PremiumTier premiumTier = this.meUserPremiumTier;
        int iHashCode3 = (iHashCode2 + (premiumTier != null ? premiumTier.hashCode() : 0)) * 31;
        boolean z2 = this.isPackEnabled;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode3 + r1;
    }

    public final boolean isPackEnabled() {
        return this.isPackEnabled;
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(stickerPack=");
        sbU.append(this.stickerPack);
        sbU.append(", stickerItems=");
        sbU.append(this.stickerItems);
        sbU.append(", meUserPremiumTier=");
        sbU.append(this.meUserPremiumTier);
        sbU.append(", isPackEnabled=");
        return a.O(sbU, this.isPackEnabled, ")");
    }
}
