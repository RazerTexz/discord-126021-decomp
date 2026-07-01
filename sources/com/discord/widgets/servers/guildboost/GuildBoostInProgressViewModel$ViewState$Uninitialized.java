package com.discord.widgets.servers.guildboost;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildBoostInProgressViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildBoostInProgressViewModel$ViewState$Uninitialized extends GuildBoostInProgressViewModel$ViewState {
    private final GuildBoostInProgressViewModel$GuildBoostState guildBoostState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostInProgressViewModel$ViewState$Uninitialized(GuildBoostInProgressViewModel$GuildBoostState guildBoostInProgressViewModel$GuildBoostState) {
        super(guildBoostInProgressViewModel$GuildBoostState, null);
        m.checkNotNullParameter(guildBoostInProgressViewModel$GuildBoostState, "guildBoostState");
        this.guildBoostState = guildBoostInProgressViewModel$GuildBoostState;
    }

    public static /* synthetic */ GuildBoostInProgressViewModel$ViewState$Uninitialized copy$default(GuildBoostInProgressViewModel$ViewState$Uninitialized guildBoostInProgressViewModel$ViewState$Uninitialized, GuildBoostInProgressViewModel$GuildBoostState guildBoostInProgressViewModel$GuildBoostState, int i, Object obj) {
        if ((i & 1) != 0) {
            guildBoostInProgressViewModel$GuildBoostState = guildBoostInProgressViewModel$ViewState$Uninitialized.getGuildBoostState();
        }
        return guildBoostInProgressViewModel$ViewState$Uninitialized.copy(guildBoostInProgressViewModel$GuildBoostState);
    }

    public final GuildBoostInProgressViewModel$GuildBoostState component1() {
        return getGuildBoostState();
    }

    public final GuildBoostInProgressViewModel$ViewState$Uninitialized copy(GuildBoostInProgressViewModel$GuildBoostState guildBoostState) {
        m.checkNotNullParameter(guildBoostState, "guildBoostState");
        return new GuildBoostInProgressViewModel$ViewState$Uninitialized(guildBoostState);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildBoostInProgressViewModel$ViewState$Uninitialized) && m.areEqual(getGuildBoostState(), ((GuildBoostInProgressViewModel$ViewState$Uninitialized) other).getGuildBoostState());
        }
        return true;
    }

    @Override // com.discord.widgets.servers.guildboost.GuildBoostInProgressViewModel$ViewState
    public GuildBoostInProgressViewModel$GuildBoostState getGuildBoostState() {
        return this.guildBoostState;
    }

    public int hashCode() {
        GuildBoostInProgressViewModel$GuildBoostState guildBoostState = getGuildBoostState();
        if (guildBoostState != null) {
            return guildBoostState.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Uninitialized(guildBoostState=");
        sbU.append(getGuildBoostState());
        sbU.append(")");
        return sbU.toString();
    }
}
