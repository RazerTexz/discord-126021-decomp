package com.discord.widgets.settings.premium;

import b.d.b.a.a;
import com.discord.models.domain.ModelGift;
import com.discord.stores.StoreEntitlements$State;
import com.discord.stores.StoreOutboundPromotions$State;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SettingsGiftingViewModel$StoreState {
    private final StoreEntitlements$State entitlementState;
    private final boolean isUserPremium;
    private final List<ModelGift> myResolvedGifts;
    private final StoreOutboundPromotions$State outboundPromoState;

    public SettingsGiftingViewModel$StoreState(StoreEntitlements$State storeEntitlements$State, List<ModelGift> list, StoreOutboundPromotions$State storeOutboundPromotions$State, boolean z2) {
        m.checkNotNullParameter(storeEntitlements$State, "entitlementState");
        m.checkNotNullParameter(list, "myResolvedGifts");
        m.checkNotNullParameter(storeOutboundPromotions$State, "outboundPromoState");
        this.entitlementState = storeEntitlements$State;
        this.myResolvedGifts = list;
        this.outboundPromoState = storeOutboundPromotions$State;
        this.isUserPremium = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SettingsGiftingViewModel$StoreState copy$default(SettingsGiftingViewModel$StoreState settingsGiftingViewModel$StoreState, StoreEntitlements$State storeEntitlements$State, List list, StoreOutboundPromotions$State storeOutboundPromotions$State, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            storeEntitlements$State = settingsGiftingViewModel$StoreState.entitlementState;
        }
        if ((i & 2) != 0) {
            list = settingsGiftingViewModel$StoreState.myResolvedGifts;
        }
        if ((i & 4) != 0) {
            storeOutboundPromotions$State = settingsGiftingViewModel$StoreState.outboundPromoState;
        }
        if ((i & 8) != 0) {
            z2 = settingsGiftingViewModel$StoreState.isUserPremium;
        }
        return settingsGiftingViewModel$StoreState.copy(storeEntitlements$State, list, storeOutboundPromotions$State, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreEntitlements$State getEntitlementState() {
        return this.entitlementState;
    }

    public final List<ModelGift> component2() {
        return this.myResolvedGifts;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final StoreOutboundPromotions$State getOutboundPromoState() {
        return this.outboundPromoState;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsUserPremium() {
        return this.isUserPremium;
    }

    public final SettingsGiftingViewModel$StoreState copy(StoreEntitlements$State entitlementState, List<ModelGift> myResolvedGifts, StoreOutboundPromotions$State outboundPromoState, boolean isUserPremium) {
        m.checkNotNullParameter(entitlementState, "entitlementState");
        m.checkNotNullParameter(myResolvedGifts, "myResolvedGifts");
        m.checkNotNullParameter(outboundPromoState, "outboundPromoState");
        return new SettingsGiftingViewModel$StoreState(entitlementState, myResolvedGifts, outboundPromoState, isUserPremium);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsGiftingViewModel$StoreState)) {
            return false;
        }
        SettingsGiftingViewModel$StoreState settingsGiftingViewModel$StoreState = (SettingsGiftingViewModel$StoreState) other;
        return m.areEqual(this.entitlementState, settingsGiftingViewModel$StoreState.entitlementState) && m.areEqual(this.myResolvedGifts, settingsGiftingViewModel$StoreState.myResolvedGifts) && m.areEqual(this.outboundPromoState, settingsGiftingViewModel$StoreState.outboundPromoState) && this.isUserPremium == settingsGiftingViewModel$StoreState.isUserPremium;
    }

    public final StoreEntitlements$State getEntitlementState() {
        return this.entitlementState;
    }

    public final List<ModelGift> getMyResolvedGifts() {
        return this.myResolvedGifts;
    }

    public final StoreOutboundPromotions$State getOutboundPromoState() {
        return this.outboundPromoState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        StoreEntitlements$State storeEntitlements$State = this.entitlementState;
        int iHashCode = (storeEntitlements$State != null ? storeEntitlements$State.hashCode() : 0) * 31;
        List<ModelGift> list = this.myResolvedGifts;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        StoreOutboundPromotions$State storeOutboundPromotions$State = this.outboundPromoState;
        int iHashCode3 = (iHashCode2 + (storeOutboundPromotions$State != null ? storeOutboundPromotions$State.hashCode() : 0)) * 31;
        boolean z2 = this.isUserPremium;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode3 + r1;
    }

    public final boolean isUserPremium() {
        return this.isUserPremium;
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(entitlementState=");
        sbU.append(this.entitlementState);
        sbU.append(", myResolvedGifts=");
        sbU.append(this.myResolvedGifts);
        sbU.append(", outboundPromoState=");
        sbU.append(this.outboundPromoState);
        sbU.append(", isUserPremium=");
        return a.O(sbU, this.isUserPremium, ")");
    }
}
