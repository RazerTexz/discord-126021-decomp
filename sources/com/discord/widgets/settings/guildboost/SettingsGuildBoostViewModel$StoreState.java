package com.discord.widgets.settings.guildboost;

import b.d.b.a.a;
import com.discord.api.premium.PremiumTier;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildBoost$State;
import com.discord.stores.StoreSubscriptions$SubscriptionsState;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: SettingsGuildBoostViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SettingsGuildBoostViewModel$StoreState {
    private final StoreGuildBoost$State guildBoostState;
    private final Map<Long, Guild> guilds;
    private final StoreSubscriptions$SubscriptionsState subscriptionState;
    private final PremiumTier userPremiumTier;

    public SettingsGuildBoostViewModel$StoreState(StoreGuildBoost$State storeGuildBoost$State, StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState, Map<Long, Guild> map, PremiumTier premiumTier) {
        m.checkNotNullParameter(storeGuildBoost$State, "guildBoostState");
        m.checkNotNullParameter(storeSubscriptions$SubscriptionsState, "subscriptionState");
        m.checkNotNullParameter(map, "guilds");
        m.checkNotNullParameter(premiumTier, "userPremiumTier");
        this.guildBoostState = storeGuildBoost$State;
        this.subscriptionState = storeSubscriptions$SubscriptionsState;
        this.guilds = map;
        this.userPremiumTier = premiumTier;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SettingsGuildBoostViewModel$StoreState copy$default(SettingsGuildBoostViewModel$StoreState settingsGuildBoostViewModel$StoreState, StoreGuildBoost$State storeGuildBoost$State, StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState, Map map, PremiumTier premiumTier, int i, Object obj) {
        if ((i & 1) != 0) {
            storeGuildBoost$State = settingsGuildBoostViewModel$StoreState.guildBoostState;
        }
        if ((i & 2) != 0) {
            storeSubscriptions$SubscriptionsState = settingsGuildBoostViewModel$StoreState.subscriptionState;
        }
        if ((i & 4) != 0) {
            map = settingsGuildBoostViewModel$StoreState.guilds;
        }
        if ((i & 8) != 0) {
            premiumTier = settingsGuildBoostViewModel$StoreState.userPremiumTier;
        }
        return settingsGuildBoostViewModel$StoreState.copy(storeGuildBoost$State, storeSubscriptions$SubscriptionsState, map, premiumTier);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreGuildBoost$State getGuildBoostState() {
        return this.guildBoostState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StoreSubscriptions$SubscriptionsState getSubscriptionState() {
        return this.subscriptionState;
    }

    public final Map<Long, Guild> component3() {
        return this.guilds;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final PremiumTier getUserPremiumTier() {
        return this.userPremiumTier;
    }

    public final SettingsGuildBoostViewModel$StoreState copy(StoreGuildBoost$State guildBoostState, StoreSubscriptions$SubscriptionsState subscriptionState, Map<Long, Guild> guilds, PremiumTier userPremiumTier) {
        m.checkNotNullParameter(guildBoostState, "guildBoostState");
        m.checkNotNullParameter(subscriptionState, "subscriptionState");
        m.checkNotNullParameter(guilds, "guilds");
        m.checkNotNullParameter(userPremiumTier, "userPremiumTier");
        return new SettingsGuildBoostViewModel$StoreState(guildBoostState, subscriptionState, guilds, userPremiumTier);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsGuildBoostViewModel$StoreState)) {
            return false;
        }
        SettingsGuildBoostViewModel$StoreState settingsGuildBoostViewModel$StoreState = (SettingsGuildBoostViewModel$StoreState) other;
        return m.areEqual(this.guildBoostState, settingsGuildBoostViewModel$StoreState.guildBoostState) && m.areEqual(this.subscriptionState, settingsGuildBoostViewModel$StoreState.subscriptionState) && m.areEqual(this.guilds, settingsGuildBoostViewModel$StoreState.guilds) && m.areEqual(this.userPremiumTier, settingsGuildBoostViewModel$StoreState.userPremiumTier);
    }

    public final StoreGuildBoost$State getGuildBoostState() {
        return this.guildBoostState;
    }

    public final Map<Long, Guild> getGuilds() {
        return this.guilds;
    }

    public final StoreSubscriptions$SubscriptionsState getSubscriptionState() {
        return this.subscriptionState;
    }

    public final PremiumTier getUserPremiumTier() {
        return this.userPremiumTier;
    }

    public int hashCode() {
        StoreGuildBoost$State storeGuildBoost$State = this.guildBoostState;
        int iHashCode = (storeGuildBoost$State != null ? storeGuildBoost$State.hashCode() : 0) * 31;
        StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState = this.subscriptionState;
        int iHashCode2 = (iHashCode + (storeSubscriptions$SubscriptionsState != null ? storeSubscriptions$SubscriptionsState.hashCode() : 0)) * 31;
        Map<Long, Guild> map = this.guilds;
        int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
        PremiumTier premiumTier = this.userPremiumTier;
        return iHashCode3 + (premiumTier != null ? premiumTier.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(guildBoostState=");
        sbU.append(this.guildBoostState);
        sbU.append(", subscriptionState=");
        sbU.append(this.subscriptionState);
        sbU.append(", guilds=");
        sbU.append(this.guilds);
        sbU.append(", userPremiumTier=");
        sbU.append(this.userPremiumTier);
        sbU.append(")");
        return sbU.toString();
    }
}
