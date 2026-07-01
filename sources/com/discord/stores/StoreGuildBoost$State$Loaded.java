package com.discord.stores;

import b.d.b.a.a;
import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.models.domain.ModelGuildBoostSlot;
import d0.z.d.m;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: compiled from: StoreGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreGuildBoost$State$Loaded extends StoreGuildBoost$State {
    private final Map<Long, ModelGuildBoostSlot> boostSlotMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildBoost$State$Loaded(Map<Long, ModelGuildBoostSlot> map) {
        super(null);
        m.checkNotNullParameter(map, "boostSlotMap");
        this.boostSlotMap = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreGuildBoost$State$Loaded copy$default(StoreGuildBoost$State$Loaded storeGuildBoost$State$Loaded, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = storeGuildBoost$State$Loaded.boostSlotMap;
        }
        return storeGuildBoost$State$Loaded.copy(map);
    }

    public final Map<Long, ModelGuildBoostSlot> component1() {
        return this.boostSlotMap;
    }

    public final StoreGuildBoost$State$Loaded copy(Map<Long, ModelGuildBoostSlot> boostSlotMap) {
        m.checkNotNullParameter(boostSlotMap, "boostSlotMap");
        return new StoreGuildBoost$State$Loaded(boostSlotMap);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreGuildBoost$State$Loaded) && m.areEqual(this.boostSlotMap, ((StoreGuildBoost$State$Loaded) other).boostSlotMap);
        }
        return true;
    }

    public final StoreGuildBoost$State$Loaded filterByGuildId(Long guildId) {
        Map<Long, ModelGuildBoostSlot> map;
        if (guildId == null) {
            map = this.boostSlotMap;
        } else {
            Map<Long, ModelGuildBoostSlot> map2 = this.boostSlotMap;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map$Entry<Long, ModelGuildBoostSlot> map$Entry : map2.entrySet()) {
                ModelAppliedGuildBoost premiumGuildSubscription = map$Entry.getValue().getPremiumGuildSubscription();
                if (m.areEqual(premiumGuildSubscription != null ? Long.valueOf(premiumGuildSubscription.getGuildId()) : null, guildId)) {
                    linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
                }
            }
            map = linkedHashMap;
        }
        return new StoreGuildBoost$State$Loaded(map);
    }

    public final Map<Long, ModelGuildBoostSlot> getBoostSlotMap() {
        return this.boostSlotMap;
    }

    public int hashCode() {
        Map<Long, ModelGuildBoostSlot> map = this.boostSlotMap;
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.M(a.U("Loaded(boostSlotMap="), this.boostSlotMap, ")");
    }
}
