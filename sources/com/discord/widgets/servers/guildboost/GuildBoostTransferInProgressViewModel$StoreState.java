package com.discord.widgets.servers.guildboost;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildBoost$State;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildBoostTransferInProgressViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildBoostTransferInProgressViewModel$StoreState {
    private final StoreGuildBoost$State guildBoostState;
    private final Guild previousGuild;
    private final Guild targetGuild;

    public GuildBoostTransferInProgressViewModel$StoreState(Guild guild, Guild guild2, StoreGuildBoost$State storeGuildBoost$State) {
        m.checkNotNullParameter(storeGuildBoost$State, "guildBoostState");
        this.previousGuild = guild;
        this.targetGuild = guild2;
        this.guildBoostState = storeGuildBoost$State;
    }

    public static /* synthetic */ GuildBoostTransferInProgressViewModel$StoreState copy$default(GuildBoostTransferInProgressViewModel$StoreState guildBoostTransferInProgressViewModel$StoreState, Guild guild, Guild guild2, StoreGuildBoost$State storeGuildBoost$State, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = guildBoostTransferInProgressViewModel$StoreState.previousGuild;
        }
        if ((i & 2) != 0) {
            guild2 = guildBoostTransferInProgressViewModel$StoreState.targetGuild;
        }
        if ((i & 4) != 0) {
            storeGuildBoost$State = guildBoostTransferInProgressViewModel$StoreState.guildBoostState;
        }
        return guildBoostTransferInProgressViewModel$StoreState.copy(guild, guild2, storeGuildBoost$State);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getPreviousGuild() {
        return this.previousGuild;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Guild getTargetGuild() {
        return this.targetGuild;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final StoreGuildBoost$State getGuildBoostState() {
        return this.guildBoostState;
    }

    public final GuildBoostTransferInProgressViewModel$StoreState copy(Guild previousGuild, Guild targetGuild, StoreGuildBoost$State guildBoostState) {
        m.checkNotNullParameter(guildBoostState, "guildBoostState");
        return new GuildBoostTransferInProgressViewModel$StoreState(previousGuild, targetGuild, guildBoostState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildBoostTransferInProgressViewModel$StoreState)) {
            return false;
        }
        GuildBoostTransferInProgressViewModel$StoreState guildBoostTransferInProgressViewModel$StoreState = (GuildBoostTransferInProgressViewModel$StoreState) other;
        return m.areEqual(this.previousGuild, guildBoostTransferInProgressViewModel$StoreState.previousGuild) && m.areEqual(this.targetGuild, guildBoostTransferInProgressViewModel$StoreState.targetGuild) && m.areEqual(this.guildBoostState, guildBoostTransferInProgressViewModel$StoreState.guildBoostState);
    }

    public final StoreGuildBoost$State getGuildBoostState() {
        return this.guildBoostState;
    }

    public final Guild getPreviousGuild() {
        return this.previousGuild;
    }

    public final Guild getTargetGuild() {
        return this.targetGuild;
    }

    public int hashCode() {
        Guild guild = this.previousGuild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        Guild guild2 = this.targetGuild;
        int iHashCode2 = (iHashCode + (guild2 != null ? guild2.hashCode() : 0)) * 31;
        StoreGuildBoost$State storeGuildBoost$State = this.guildBoostState;
        return iHashCode2 + (storeGuildBoost$State != null ? storeGuildBoost$State.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(previousGuild=");
        sbU.append(this.previousGuild);
        sbU.append(", targetGuild=");
        sbU.append(this.targetGuild);
        sbU.append(", guildBoostState=");
        sbU.append(this.guildBoostState);
        sbU.append(")");
        return sbU.toString();
    }
}
