package com.discord.stores;

import b.d.b.a.a;
import com.discord.models.domain.ModelEntitlement;
import d0.z.d.m;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: StoreEntitlements.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreEntitlements$State$Loaded extends StoreEntitlements$State {
    private final Map<Long, List<ModelEntitlement>> giftableEntitlements;
    private final Map<Long, List<ModelEntitlement>> ownedEntitlements;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StoreEntitlements$State$Loaded(Map<Long, ? extends List<ModelEntitlement>> map, Map<Long, ? extends List<ModelEntitlement>> map2) {
        super(null);
        m.checkNotNullParameter(map, "giftableEntitlements");
        m.checkNotNullParameter(map2, "ownedEntitlements");
        this.giftableEntitlements = map;
        this.ownedEntitlements = map2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreEntitlements$State$Loaded copy$default(StoreEntitlements$State$Loaded storeEntitlements$State$Loaded, Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            map = storeEntitlements$State$Loaded.giftableEntitlements;
        }
        if ((i & 2) != 0) {
            map2 = storeEntitlements$State$Loaded.ownedEntitlements;
        }
        return storeEntitlements$State$Loaded.copy(map, map2);
    }

    public final Map<Long, List<ModelEntitlement>> component1() {
        return this.giftableEntitlements;
    }

    public final Map<Long, List<ModelEntitlement>> component2() {
        return this.ownedEntitlements;
    }

    public final StoreEntitlements$State$Loaded copy(Map<Long, ? extends List<ModelEntitlement>> giftableEntitlements, Map<Long, ? extends List<ModelEntitlement>> ownedEntitlements) {
        m.checkNotNullParameter(giftableEntitlements, "giftableEntitlements");
        m.checkNotNullParameter(ownedEntitlements, "ownedEntitlements");
        return new StoreEntitlements$State$Loaded(giftableEntitlements, ownedEntitlements);
    }

    @Override // com.discord.stores.StoreEntitlements$State
    public /* bridge */ /* synthetic */ StoreEntitlements$State deepCopy() {
        return deepCopy();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreEntitlements$State$Loaded)) {
            return false;
        }
        StoreEntitlements$State$Loaded storeEntitlements$State$Loaded = (StoreEntitlements$State$Loaded) other;
        return m.areEqual(this.giftableEntitlements, storeEntitlements$State$Loaded.giftableEntitlements) && m.areEqual(this.ownedEntitlements, storeEntitlements$State$Loaded.ownedEntitlements);
    }

    public final Map<Long, List<ModelEntitlement>> getGiftableEntitlements() {
        return this.giftableEntitlements;
    }

    public final Map<Long, List<ModelEntitlement>> getOwnedEntitlements() {
        return this.ownedEntitlements;
    }

    public int hashCode() {
        Map<Long, List<ModelEntitlement>> map = this.giftableEntitlements;
        int iHashCode = (map != null ? map.hashCode() : 0) * 31;
        Map<Long, List<ModelEntitlement>> map2 = this.ownedEntitlements;
        return iHashCode + (map2 != null ? map2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(giftableEntitlements=");
        sbU.append(this.giftableEntitlements);
        sbU.append(", ownedEntitlements=");
        return a.M(sbU, this.ownedEntitlements, ")");
    }

    @Override // com.discord.stores.StoreEntitlements$State
    public StoreEntitlements$State$Loaded deepCopy() {
        return copy(new HashMap(this.giftableEntitlements), new HashMap(this.ownedEntitlements));
    }
}
