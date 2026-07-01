package com.discord.stores;

import b.d.b.a.a;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierFreeTrial;
import d0.z.d.m;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState$Loaded extends StoreGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState {
    private final Map<Long, GuildRoleSubscriptionTierFreeTrial> freeTrials;

    public StoreGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState$Loaded() {
        this(null, 1, null);
    }

    public /* synthetic */ StoreGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState$Loaded(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState$Loaded copy$default(StoreGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState$Loaded storeGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState$Loaded, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = storeGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState$Loaded.freeTrials;
        }
        return storeGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState$Loaded.copy(map);
    }

    public final Map<Long, GuildRoleSubscriptionTierFreeTrial> component1() {
        return this.freeTrials;
    }

    public final StoreGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState$Loaded copy(Map<Long, GuildRoleSubscriptionTierFreeTrial> freeTrials) {
        return new StoreGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState$Loaded(freeTrials);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState$Loaded) && m.areEqual(this.freeTrials, ((StoreGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState$Loaded) other).freeTrials);
        }
        return true;
    }

    public final Map<Long, GuildRoleSubscriptionTierFreeTrial> getFreeTrials() {
        return this.freeTrials;
    }

    public int hashCode() {
        Map<Long, GuildRoleSubscriptionTierFreeTrial> map = this.freeTrials;
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.M(a.U("Loaded(freeTrials="), this.freeTrials, ")");
    }

    public StoreGuildRoleSubscriptions$GuildRoleSubscriptionFreeTrialsState$Loaded(Map<Long, GuildRoleSubscriptionTierFreeTrial> map) {
        super(null);
        this.freeTrials = map;
    }
}
