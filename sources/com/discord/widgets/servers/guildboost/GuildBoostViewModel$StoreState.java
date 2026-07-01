package com.discord.widgets.servers.guildboost;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreGooglePlayPurchases$State;
import com.discord.stores.StoreGuildBoost$State;
import com.discord.stores.StoreSubscriptions$SubscriptionsState;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildBoostViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildBoostViewModel$StoreState {
    private final Guild guild;
    private final StoreGuildBoost$State guildBoostState;
    private final MeUser meUser;
    private final StoreGooglePlayPurchases$State purchasesState;
    private final StoreSubscriptions$SubscriptionsState subscriptionState;

    public GuildBoostViewModel$StoreState(StoreGuildBoost$State storeGuildBoost$State, StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState, MeUser meUser, Guild guild, StoreGooglePlayPurchases$State storeGooglePlayPurchases$State) {
        m.checkNotNullParameter(storeGuildBoost$State, "guildBoostState");
        m.checkNotNullParameter(storeSubscriptions$SubscriptionsState, "subscriptionState");
        m.checkNotNullParameter(meUser, "meUser");
        m.checkNotNullParameter(storeGooglePlayPurchases$State, "purchasesState");
        this.guildBoostState = storeGuildBoost$State;
        this.subscriptionState = storeSubscriptions$SubscriptionsState;
        this.meUser = meUser;
        this.guild = guild;
        this.purchasesState = storeGooglePlayPurchases$State;
    }

    public static /* synthetic */ GuildBoostViewModel$StoreState copy$default(GuildBoostViewModel$StoreState guildBoostViewModel$StoreState, StoreGuildBoost$State storeGuildBoost$State, StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState, MeUser meUser, Guild guild, StoreGooglePlayPurchases$State storeGooglePlayPurchases$State, int i, Object obj) {
        if ((i & 1) != 0) {
            storeGuildBoost$State = guildBoostViewModel$StoreState.guildBoostState;
        }
        if ((i & 2) != 0) {
            storeSubscriptions$SubscriptionsState = guildBoostViewModel$StoreState.subscriptionState;
        }
        StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState2 = storeSubscriptions$SubscriptionsState;
        if ((i & 4) != 0) {
            meUser = guildBoostViewModel$StoreState.meUser;
        }
        MeUser meUser2 = meUser;
        if ((i & 8) != 0) {
            guild = guildBoostViewModel$StoreState.guild;
        }
        Guild guild2 = guild;
        if ((i & 16) != 0) {
            storeGooglePlayPurchases$State = guildBoostViewModel$StoreState.purchasesState;
        }
        return guildBoostViewModel$StoreState.copy(storeGuildBoost$State, storeSubscriptions$SubscriptionsState2, meUser2, guild2, storeGooglePlayPurchases$State);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreGuildBoost$State getGuildBoostState() {
        return this.guildBoostState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StoreSubscriptions$SubscriptionsState getSubscriptionState() {
        return this.subscriptionState;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MeUser getMeUser() {
        return this.meUser;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final StoreGooglePlayPurchases$State getPurchasesState() {
        return this.purchasesState;
    }

    public final GuildBoostViewModel$StoreState copy(StoreGuildBoost$State guildBoostState, StoreSubscriptions$SubscriptionsState subscriptionState, MeUser meUser, Guild guild, StoreGooglePlayPurchases$State purchasesState) {
        m.checkNotNullParameter(guildBoostState, "guildBoostState");
        m.checkNotNullParameter(subscriptionState, "subscriptionState");
        m.checkNotNullParameter(meUser, "meUser");
        m.checkNotNullParameter(purchasesState, "purchasesState");
        return new GuildBoostViewModel$StoreState(guildBoostState, subscriptionState, meUser, guild, purchasesState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildBoostViewModel$StoreState)) {
            return false;
        }
        GuildBoostViewModel$StoreState guildBoostViewModel$StoreState = (GuildBoostViewModel$StoreState) other;
        return m.areEqual(this.guildBoostState, guildBoostViewModel$StoreState.guildBoostState) && m.areEqual(this.subscriptionState, guildBoostViewModel$StoreState.subscriptionState) && m.areEqual(this.meUser, guildBoostViewModel$StoreState.meUser) && m.areEqual(this.guild, guildBoostViewModel$StoreState.guild) && m.areEqual(this.purchasesState, guildBoostViewModel$StoreState.purchasesState);
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final StoreGuildBoost$State getGuildBoostState() {
        return this.guildBoostState;
    }

    public final MeUser getMeUser() {
        return this.meUser;
    }

    public final StoreGooglePlayPurchases$State getPurchasesState() {
        return this.purchasesState;
    }

    public final StoreSubscriptions$SubscriptionsState getSubscriptionState() {
        return this.subscriptionState;
    }

    public int hashCode() {
        StoreGuildBoost$State storeGuildBoost$State = this.guildBoostState;
        int iHashCode = (storeGuildBoost$State != null ? storeGuildBoost$State.hashCode() : 0) * 31;
        StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState = this.subscriptionState;
        int iHashCode2 = (iHashCode + (storeSubscriptions$SubscriptionsState != null ? storeSubscriptions$SubscriptionsState.hashCode() : 0)) * 31;
        MeUser meUser = this.meUser;
        int iHashCode3 = (iHashCode2 + (meUser != null ? meUser.hashCode() : 0)) * 31;
        Guild guild = this.guild;
        int iHashCode4 = (iHashCode3 + (guild != null ? guild.hashCode() : 0)) * 31;
        StoreGooglePlayPurchases$State storeGooglePlayPurchases$State = this.purchasesState;
        return iHashCode4 + (storeGooglePlayPurchases$State != null ? storeGooglePlayPurchases$State.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(guildBoostState=");
        sbU.append(this.guildBoostState);
        sbU.append(", subscriptionState=");
        sbU.append(this.subscriptionState);
        sbU.append(", meUser=");
        sbU.append(this.meUser);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", purchasesState=");
        sbU.append(this.purchasesState);
        sbU.append(")");
        return sbU.toString();
    }
}
