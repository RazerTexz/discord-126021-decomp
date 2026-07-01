package com.discord.widgets.servers.guildboost;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildBoostInProgressViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GuildBoostInProgressViewModel$ViewState {
    private final GuildBoostInProgressViewModel$GuildBoostState guildBoostState;

    private GuildBoostInProgressViewModel$ViewState(GuildBoostInProgressViewModel$GuildBoostState guildBoostInProgressViewModel$GuildBoostState) {
        this.guildBoostState = guildBoostInProgressViewModel$GuildBoostState;
    }

    public GuildBoostInProgressViewModel$GuildBoostState getGuildBoostState() {
        return this.guildBoostState;
    }

    public /* synthetic */ GuildBoostInProgressViewModel$ViewState(GuildBoostInProgressViewModel$GuildBoostState guildBoostInProgressViewModel$GuildBoostState, DefaultConstructorMarker defaultConstructorMarker) {
        this(guildBoostInProgressViewModel$GuildBoostState);
    }
}
