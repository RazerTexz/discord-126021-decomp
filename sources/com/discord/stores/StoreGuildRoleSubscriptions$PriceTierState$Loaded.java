package com.discord.stores;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreGuildRoleSubscriptions$PriceTierState$Loaded extends StoreGuildRoleSubscriptions$PriceTierState {
    private final List<Integer> priceTiers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildRoleSubscriptions$PriceTierState$Loaded(List<Integer> list) {
        super(null);
        m.checkNotNullParameter(list, "priceTiers");
        this.priceTiers = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreGuildRoleSubscriptions$PriceTierState$Loaded copy$default(StoreGuildRoleSubscriptions$PriceTierState$Loaded storeGuildRoleSubscriptions$PriceTierState$Loaded, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = storeGuildRoleSubscriptions$PriceTierState$Loaded.priceTiers;
        }
        return storeGuildRoleSubscriptions$PriceTierState$Loaded.copy(list);
    }

    public final List<Integer> component1() {
        return this.priceTiers;
    }

    public final StoreGuildRoleSubscriptions$PriceTierState$Loaded copy(List<Integer> priceTiers) {
        m.checkNotNullParameter(priceTiers, "priceTiers");
        return new StoreGuildRoleSubscriptions$PriceTierState$Loaded(priceTiers);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreGuildRoleSubscriptions$PriceTierState$Loaded) && m.areEqual(this.priceTiers, ((StoreGuildRoleSubscriptions$PriceTierState$Loaded) other).priceTiers);
        }
        return true;
    }

    public final List<Integer> getPriceTiers() {
        return this.priceTiers;
    }

    public int hashCode() {
        List<Integer> list = this.priceTiers;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.L(a.U("Loaded(priceTiers="), this.priceTiers, ")");
    }
}
