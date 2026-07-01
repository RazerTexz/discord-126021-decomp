package com.discord.widgets.settings.premium;

import b.d.b.a.a;
import com.discord.models.domain.ModelEntitlement;
import com.discord.models.domain.ModelGift;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SettingsGiftingViewModel$ViewState$Loaded extends SettingsGiftingViewModel$ViewState {
    private final Set<Long> expandedSkuOrPlanIds;
    private final String lastCopiedCode;
    private final Map<Long, List<ModelEntitlement>> myEntitlements;
    private final Map<Long, List<ModelGift>> myPurchasedGifts;
    private final List<SettingsGiftingViewModel$OutboundPromoItem> outboundPromos;
    private final SettingsGiftingViewModel$ResolvingGiftState resolvingGiftState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SettingsGiftingViewModel$ViewState$Loaded(Map<Long, ? extends List<ModelEntitlement>> map, SettingsGiftingViewModel$ResolvingGiftState settingsGiftingViewModel$ResolvingGiftState, Set<Long> set, List<SettingsGiftingViewModel$OutboundPromoItem> list, Map<Long, ? extends List<ModelGift>> map2, String str) {
        super(null);
        m.checkNotNullParameter(map, "myEntitlements");
        m.checkNotNullParameter(settingsGiftingViewModel$ResolvingGiftState, "resolvingGiftState");
        m.checkNotNullParameter(set, "expandedSkuOrPlanIds");
        m.checkNotNullParameter(list, "outboundPromos");
        m.checkNotNullParameter(map2, "myPurchasedGifts");
        this.myEntitlements = map;
        this.resolvingGiftState = settingsGiftingViewModel$ResolvingGiftState;
        this.expandedSkuOrPlanIds = set;
        this.outboundPromos = list;
        this.myPurchasedGifts = map2;
        this.lastCopiedCode = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SettingsGiftingViewModel$ViewState$Loaded copy$default(SettingsGiftingViewModel$ViewState$Loaded settingsGiftingViewModel$ViewState$Loaded, Map map, SettingsGiftingViewModel$ResolvingGiftState settingsGiftingViewModel$ResolvingGiftState, Set set, List list, Map map2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            map = settingsGiftingViewModel$ViewState$Loaded.myEntitlements;
        }
        if ((i & 2) != 0) {
            settingsGiftingViewModel$ResolvingGiftState = settingsGiftingViewModel$ViewState$Loaded.resolvingGiftState;
        }
        SettingsGiftingViewModel$ResolvingGiftState settingsGiftingViewModel$ResolvingGiftState2 = settingsGiftingViewModel$ResolvingGiftState;
        if ((i & 4) != 0) {
            set = settingsGiftingViewModel$ViewState$Loaded.expandedSkuOrPlanIds;
        }
        Set set2 = set;
        if ((i & 8) != 0) {
            list = settingsGiftingViewModel$ViewState$Loaded.outboundPromos;
        }
        List list2 = list;
        if ((i & 16) != 0) {
            map2 = settingsGiftingViewModel$ViewState$Loaded.myPurchasedGifts;
        }
        Map map3 = map2;
        if ((i & 32) != 0) {
            str = settingsGiftingViewModel$ViewState$Loaded.lastCopiedCode;
        }
        return settingsGiftingViewModel$ViewState$Loaded.copy(map, settingsGiftingViewModel$ResolvingGiftState2, set2, list2, map3, str);
    }

    public final Map<Long, List<ModelEntitlement>> component1() {
        return this.myEntitlements;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SettingsGiftingViewModel$ResolvingGiftState getResolvingGiftState() {
        return this.resolvingGiftState;
    }

    public final Set<Long> component3() {
        return this.expandedSkuOrPlanIds;
    }

    public final List<SettingsGiftingViewModel$OutboundPromoItem> component4() {
        return this.outboundPromos;
    }

    public final Map<Long, List<ModelGift>> component5() {
        return this.myPurchasedGifts;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getLastCopiedCode() {
        return this.lastCopiedCode;
    }

    public final SettingsGiftingViewModel$ViewState$Loaded copy(Map<Long, ? extends List<ModelEntitlement>> myEntitlements, SettingsGiftingViewModel$ResolvingGiftState resolvingGiftState, Set<Long> expandedSkuOrPlanIds, List<SettingsGiftingViewModel$OutboundPromoItem> outboundPromos, Map<Long, ? extends List<ModelGift>> myPurchasedGifts, String lastCopiedCode) {
        m.checkNotNullParameter(myEntitlements, "myEntitlements");
        m.checkNotNullParameter(resolvingGiftState, "resolvingGiftState");
        m.checkNotNullParameter(expandedSkuOrPlanIds, "expandedSkuOrPlanIds");
        m.checkNotNullParameter(outboundPromos, "outboundPromos");
        m.checkNotNullParameter(myPurchasedGifts, "myPurchasedGifts");
        return new SettingsGiftingViewModel$ViewState$Loaded(myEntitlements, resolvingGiftState, expandedSkuOrPlanIds, outboundPromos, myPurchasedGifts, lastCopiedCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsGiftingViewModel$ViewState$Loaded)) {
            return false;
        }
        SettingsGiftingViewModel$ViewState$Loaded settingsGiftingViewModel$ViewState$Loaded = (SettingsGiftingViewModel$ViewState$Loaded) other;
        return m.areEqual(this.myEntitlements, settingsGiftingViewModel$ViewState$Loaded.myEntitlements) && m.areEqual(this.resolvingGiftState, settingsGiftingViewModel$ViewState$Loaded.resolvingGiftState) && m.areEqual(this.expandedSkuOrPlanIds, settingsGiftingViewModel$ViewState$Loaded.expandedSkuOrPlanIds) && m.areEqual(this.outboundPromos, settingsGiftingViewModel$ViewState$Loaded.outboundPromos) && m.areEqual(this.myPurchasedGifts, settingsGiftingViewModel$ViewState$Loaded.myPurchasedGifts) && m.areEqual(this.lastCopiedCode, settingsGiftingViewModel$ViewState$Loaded.lastCopiedCode);
    }

    public final Set<Long> getExpandedSkuOrPlanIds() {
        return this.expandedSkuOrPlanIds;
    }

    public final String getLastCopiedCode() {
        return this.lastCopiedCode;
    }

    public final Map<Long, List<ModelEntitlement>> getMyEntitlements() {
        return this.myEntitlements;
    }

    public final Map<Long, List<ModelGift>> getMyPurchasedGifts() {
        return this.myPurchasedGifts;
    }

    public final List<SettingsGiftingViewModel$OutboundPromoItem> getOutboundPromos() {
        return this.outboundPromos;
    }

    public final SettingsGiftingViewModel$ResolvingGiftState getResolvingGiftState() {
        return this.resolvingGiftState;
    }

    public int hashCode() {
        Map<Long, List<ModelEntitlement>> map = this.myEntitlements;
        int iHashCode = (map != null ? map.hashCode() : 0) * 31;
        SettingsGiftingViewModel$ResolvingGiftState settingsGiftingViewModel$ResolvingGiftState = this.resolvingGiftState;
        int iHashCode2 = (iHashCode + (settingsGiftingViewModel$ResolvingGiftState != null ? settingsGiftingViewModel$ResolvingGiftState.hashCode() : 0)) * 31;
        Set<Long> set = this.expandedSkuOrPlanIds;
        int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        List<SettingsGiftingViewModel$OutboundPromoItem> list = this.outboundPromos;
        int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        Map<Long, List<ModelGift>> map2 = this.myPurchasedGifts;
        int iHashCode5 = (iHashCode4 + (map2 != null ? map2.hashCode() : 0)) * 31;
        String str = this.lastCopiedCode;
        return iHashCode5 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(myEntitlements=");
        sbU.append(this.myEntitlements);
        sbU.append(", resolvingGiftState=");
        sbU.append(this.resolvingGiftState);
        sbU.append(", expandedSkuOrPlanIds=");
        sbU.append(this.expandedSkuOrPlanIds);
        sbU.append(", outboundPromos=");
        sbU.append(this.outboundPromos);
        sbU.append(", myPurchasedGifts=");
        sbU.append(this.myPurchasedGifts);
        sbU.append(", lastCopiedCode=");
        return a.J(sbU, this.lastCopiedCode, ")");
    }
}
