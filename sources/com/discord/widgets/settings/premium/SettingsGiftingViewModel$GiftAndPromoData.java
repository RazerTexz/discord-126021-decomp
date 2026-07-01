package com.discord.widgets.settings.premium;

import b.d.b.a.a;
import com.discord.api.premium.ClaimedOutboundPromotion;
import com.discord.models.domain.ModelGift;
import com.discord.stores.StoreEntitlements$State;
import com.discord.stores.StoreOutboundPromotions$State;
import d0.z.d.m;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SettingsGiftingViewModel$GiftAndPromoData {
    private final List<ClaimedOutboundPromotion> claimedOutboundPromotions;
    private final StoreEntitlements$State entitlementState;
    private final Map<Long, List<ModelGift>> myPurchasedGifts;
    private final StoreOutboundPromotions$State outboundPromoState;
    private final SettingsGiftingViewModel$ResolvingGiftState resolvingGiftState;

    /* JADX WARN: Multi-variable type inference failed */
    public SettingsGiftingViewModel$GiftAndPromoData(StoreEntitlements$State storeEntitlements$State, SettingsGiftingViewModel$ResolvingGiftState settingsGiftingViewModel$ResolvingGiftState, Map<Long, ? extends List<ModelGift>> map, StoreOutboundPromotions$State storeOutboundPromotions$State, List<ClaimedOutboundPromotion> list) {
        m.checkNotNullParameter(storeEntitlements$State, "entitlementState");
        m.checkNotNullParameter(settingsGiftingViewModel$ResolvingGiftState, "resolvingGiftState");
        m.checkNotNullParameter(map, "myPurchasedGifts");
        m.checkNotNullParameter(storeOutboundPromotions$State, "outboundPromoState");
        m.checkNotNullParameter(list, "claimedOutboundPromotions");
        this.entitlementState = storeEntitlements$State;
        this.resolvingGiftState = settingsGiftingViewModel$ResolvingGiftState;
        this.myPurchasedGifts = map;
        this.outboundPromoState = storeOutboundPromotions$State;
        this.claimedOutboundPromotions = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SettingsGiftingViewModel$GiftAndPromoData copy$default(SettingsGiftingViewModel$GiftAndPromoData settingsGiftingViewModel$GiftAndPromoData, StoreEntitlements$State storeEntitlements$State, SettingsGiftingViewModel$ResolvingGiftState settingsGiftingViewModel$ResolvingGiftState, Map map, StoreOutboundPromotions$State storeOutboundPromotions$State, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            storeEntitlements$State = settingsGiftingViewModel$GiftAndPromoData.entitlementState;
        }
        if ((i & 2) != 0) {
            settingsGiftingViewModel$ResolvingGiftState = settingsGiftingViewModel$GiftAndPromoData.resolvingGiftState;
        }
        SettingsGiftingViewModel$ResolvingGiftState settingsGiftingViewModel$ResolvingGiftState2 = settingsGiftingViewModel$ResolvingGiftState;
        if ((i & 4) != 0) {
            map = settingsGiftingViewModel$GiftAndPromoData.myPurchasedGifts;
        }
        Map map2 = map;
        if ((i & 8) != 0) {
            storeOutboundPromotions$State = settingsGiftingViewModel$GiftAndPromoData.outboundPromoState;
        }
        StoreOutboundPromotions$State storeOutboundPromotions$State2 = storeOutboundPromotions$State;
        if ((i & 16) != 0) {
            list = settingsGiftingViewModel$GiftAndPromoData.claimedOutboundPromotions;
        }
        return settingsGiftingViewModel$GiftAndPromoData.copy(storeEntitlements$State, settingsGiftingViewModel$ResolvingGiftState2, map2, storeOutboundPromotions$State2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreEntitlements$State getEntitlementState() {
        return this.entitlementState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SettingsGiftingViewModel$ResolvingGiftState getResolvingGiftState() {
        return this.resolvingGiftState;
    }

    public final Map<Long, List<ModelGift>> component3() {
        return this.myPurchasedGifts;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final StoreOutboundPromotions$State getOutboundPromoState() {
        return this.outboundPromoState;
    }

    public final List<ClaimedOutboundPromotion> component5() {
        return this.claimedOutboundPromotions;
    }

    public final SettingsGiftingViewModel$GiftAndPromoData copy(StoreEntitlements$State entitlementState, SettingsGiftingViewModel$ResolvingGiftState resolvingGiftState, Map<Long, ? extends List<ModelGift>> myPurchasedGifts, StoreOutboundPromotions$State outboundPromoState, List<ClaimedOutboundPromotion> claimedOutboundPromotions) {
        m.checkNotNullParameter(entitlementState, "entitlementState");
        m.checkNotNullParameter(resolvingGiftState, "resolvingGiftState");
        m.checkNotNullParameter(myPurchasedGifts, "myPurchasedGifts");
        m.checkNotNullParameter(outboundPromoState, "outboundPromoState");
        m.checkNotNullParameter(claimedOutboundPromotions, "claimedOutboundPromotions");
        return new SettingsGiftingViewModel$GiftAndPromoData(entitlementState, resolvingGiftState, myPurchasedGifts, outboundPromoState, claimedOutboundPromotions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsGiftingViewModel$GiftAndPromoData)) {
            return false;
        }
        SettingsGiftingViewModel$GiftAndPromoData settingsGiftingViewModel$GiftAndPromoData = (SettingsGiftingViewModel$GiftAndPromoData) other;
        return m.areEqual(this.entitlementState, settingsGiftingViewModel$GiftAndPromoData.entitlementState) && m.areEqual(this.resolvingGiftState, settingsGiftingViewModel$GiftAndPromoData.resolvingGiftState) && m.areEqual(this.myPurchasedGifts, settingsGiftingViewModel$GiftAndPromoData.myPurchasedGifts) && m.areEqual(this.outboundPromoState, settingsGiftingViewModel$GiftAndPromoData.outboundPromoState) && m.areEqual(this.claimedOutboundPromotions, settingsGiftingViewModel$GiftAndPromoData.claimedOutboundPromotions);
    }

    public final List<ClaimedOutboundPromotion> getClaimedOutboundPromotions() {
        return this.claimedOutboundPromotions;
    }

    public final StoreEntitlements$State getEntitlementState() {
        return this.entitlementState;
    }

    public final Map<Long, List<ModelGift>> getMyPurchasedGifts() {
        return this.myPurchasedGifts;
    }

    public final StoreOutboundPromotions$State getOutboundPromoState() {
        return this.outboundPromoState;
    }

    public final SettingsGiftingViewModel$ResolvingGiftState getResolvingGiftState() {
        return this.resolvingGiftState;
    }

    public int hashCode() {
        StoreEntitlements$State storeEntitlements$State = this.entitlementState;
        int iHashCode = (storeEntitlements$State != null ? storeEntitlements$State.hashCode() : 0) * 31;
        SettingsGiftingViewModel$ResolvingGiftState settingsGiftingViewModel$ResolvingGiftState = this.resolvingGiftState;
        int iHashCode2 = (iHashCode + (settingsGiftingViewModel$ResolvingGiftState != null ? settingsGiftingViewModel$ResolvingGiftState.hashCode() : 0)) * 31;
        Map<Long, List<ModelGift>> map = this.myPurchasedGifts;
        int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
        StoreOutboundPromotions$State storeOutboundPromotions$State = this.outboundPromoState;
        int iHashCode4 = (iHashCode3 + (storeOutboundPromotions$State != null ? storeOutboundPromotions$State.hashCode() : 0)) * 31;
        List<ClaimedOutboundPromotion> list = this.claimedOutboundPromotions;
        return iHashCode4 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("GiftAndPromoData(entitlementState=");
        sbU.append(this.entitlementState);
        sbU.append(", resolvingGiftState=");
        sbU.append(this.resolvingGiftState);
        sbU.append(", myPurchasedGifts=");
        sbU.append(this.myPurchasedGifts);
        sbU.append(", outboundPromoState=");
        sbU.append(this.outboundPromoState);
        sbU.append(", claimedOutboundPromotions=");
        return a.L(sbU, this.claimedOutboundPromotions, ")");
    }
}
