package com.discord.stores;

import b.d.b.a.a;
import com.discord.api.premium.OutboundPromotion;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: StoreOutboundPromotions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreOutboundPromotions$State$Loaded extends StoreOutboundPromotions$State {
    private final int unseenCount;
    private final List<OutboundPromotion> validActivePromotions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreOutboundPromotions$State$Loaded(List<OutboundPromotion> list, int i) {
        super(null);
        m.checkNotNullParameter(list, "validActivePromotions");
        this.validActivePromotions = list;
        this.unseenCount = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreOutboundPromotions$State$Loaded copy$default(StoreOutboundPromotions$State$Loaded storeOutboundPromotions$State$Loaded, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = storeOutboundPromotions$State$Loaded.validActivePromotions;
        }
        if ((i2 & 2) != 0) {
            i = storeOutboundPromotions$State$Loaded.unseenCount;
        }
        return storeOutboundPromotions$State$Loaded.copy(list, i);
    }

    public final List<OutboundPromotion> component1() {
        return this.validActivePromotions;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getUnseenCount() {
        return this.unseenCount;
    }

    public final StoreOutboundPromotions$State$Loaded copy(List<OutboundPromotion> validActivePromotions, int unseenCount) {
        m.checkNotNullParameter(validActivePromotions, "validActivePromotions");
        return new StoreOutboundPromotions$State$Loaded(validActivePromotions, unseenCount);
    }

    @Override // com.discord.stores.StoreOutboundPromotions$State
    public /* bridge */ /* synthetic */ StoreOutboundPromotions$State deepCopy() {
        return deepCopy();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreOutboundPromotions$State$Loaded)) {
            return false;
        }
        StoreOutboundPromotions$State$Loaded storeOutboundPromotions$State$Loaded = (StoreOutboundPromotions$State$Loaded) other;
        return m.areEqual(this.validActivePromotions, storeOutboundPromotions$State$Loaded.validActivePromotions) && this.unseenCount == storeOutboundPromotions$State$Loaded.unseenCount;
    }

    public final int getUnseenCount() {
        return this.unseenCount;
    }

    public final List<OutboundPromotion> getValidActivePromotions() {
        return this.validActivePromotions;
    }

    public int hashCode() {
        List<OutboundPromotion> list = this.validActivePromotions;
        return ((list != null ? list.hashCode() : 0) * 31) + this.unseenCount;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(validActivePromotions=");
        sbU.append(this.validActivePromotions);
        sbU.append(", unseenCount=");
        return a.B(sbU, this.unseenCount, ")");
    }

    @Override // com.discord.stores.StoreOutboundPromotions$State
    public StoreOutboundPromotions$State$Loaded deepCopy() {
        return copy$default(this, new ArrayList(this.validActivePromotions), 0, 2, null);
    }
}
