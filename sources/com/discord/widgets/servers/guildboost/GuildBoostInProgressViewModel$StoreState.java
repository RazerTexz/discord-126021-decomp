package com.discord.widgets.servers.guildboost;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildBoost$State;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildBoostInProgressViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildBoostInProgressViewModel$StoreState {
    private final Guild guild;
    private final StoreGuildBoost$State guildBoostState;

    public GuildBoostInProgressViewModel$StoreState(Guild guild, StoreGuildBoost$State storeGuildBoost$State) {
        m.checkNotNullParameter(storeGuildBoost$State, "guildBoostState");
        this.guild = guild;
        this.guildBoostState = storeGuildBoost$State;
    }

    public static /* synthetic */ GuildBoostInProgressViewModel$StoreState copy$default(GuildBoostInProgressViewModel$StoreState guildBoostInProgressViewModel$StoreState, Guild guild, StoreGuildBoost$State storeGuildBoost$State, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = guildBoostInProgressViewModel$StoreState.guild;
        }
        if ((i & 2) != 0) {
            storeGuildBoost$State = guildBoostInProgressViewModel$StoreState.guildBoostState;
        }
        return guildBoostInProgressViewModel$StoreState.copy(guild, storeGuildBoost$State);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StoreGuildBoost$State getGuildBoostState() {
        return this.guildBoostState;
    }

    public final GuildBoostInProgressViewModel$StoreState copy(Guild guild, StoreGuildBoost$State guildBoostState) {
        m.checkNotNullParameter(guildBoostState, "guildBoostState");
        return new GuildBoostInProgressViewModel$StoreState(guild, guildBoostState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildBoostInProgressViewModel$StoreState)) {
            return false;
        }
        GuildBoostInProgressViewModel$StoreState guildBoostInProgressViewModel$StoreState = (GuildBoostInProgressViewModel$StoreState) other;
        return m.areEqual(this.guild, guildBoostInProgressViewModel$StoreState.guild) && m.areEqual(this.guildBoostState, guildBoostInProgressViewModel$StoreState.guildBoostState);
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final StoreGuildBoost$State getGuildBoostState() {
        return this.guildBoostState;
    }

    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        StoreGuildBoost$State storeGuildBoost$State = this.guildBoostState;
        return iHashCode + (storeGuildBoost$State != null ? storeGuildBoost$State.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(guild=");
        sbU.append(this.guild);
        sbU.append(", guildBoostState=");
        sbU.append(this.guildBoostState);
        sbU.append(")");
        return sbU.toString();
    }
}
