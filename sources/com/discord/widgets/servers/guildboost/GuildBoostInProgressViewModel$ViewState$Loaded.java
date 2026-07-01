package com.discord.widgets.servers.guildboost;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildBoostInProgressViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildBoostInProgressViewModel$ViewState$Loaded extends GuildBoostInProgressViewModel$ViewState {
    private final boolean canShowConfirmationDialog;
    private final Guild guild;
    private final GuildBoostInProgressViewModel$GuildBoostState guildBoostState;
    private final int subscriptionCount;

    public /* synthetic */ GuildBoostInProgressViewModel$ViewState$Loaded(GuildBoostInProgressViewModel$GuildBoostState guildBoostInProgressViewModel$GuildBoostState, Guild guild, int i, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(guildBoostInProgressViewModel$GuildBoostState, guild, i, (i2 & 8) != 0 ? false : z2);
    }

    public static /* synthetic */ GuildBoostInProgressViewModel$ViewState$Loaded copy$default(GuildBoostInProgressViewModel$ViewState$Loaded guildBoostInProgressViewModel$ViewState$Loaded, GuildBoostInProgressViewModel$GuildBoostState guildBoostInProgressViewModel$GuildBoostState, Guild guild, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            guildBoostInProgressViewModel$GuildBoostState = guildBoostInProgressViewModel$ViewState$Loaded.getGuildBoostState();
        }
        if ((i2 & 2) != 0) {
            guild = guildBoostInProgressViewModel$ViewState$Loaded.guild;
        }
        if ((i2 & 4) != 0) {
            i = guildBoostInProgressViewModel$ViewState$Loaded.subscriptionCount;
        }
        if ((i2 & 8) != 0) {
            z2 = guildBoostInProgressViewModel$ViewState$Loaded.canShowConfirmationDialog;
        }
        return guildBoostInProgressViewModel$ViewState$Loaded.copy(guildBoostInProgressViewModel$GuildBoostState, guild, i, z2);
    }

    public final GuildBoostInProgressViewModel$GuildBoostState component1() {
        return getGuildBoostState();
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getSubscriptionCount() {
        return this.subscriptionCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getCanShowConfirmationDialog() {
        return this.canShowConfirmationDialog;
    }

    public final GuildBoostInProgressViewModel$ViewState$Loaded copy(GuildBoostInProgressViewModel$GuildBoostState guildBoostState, Guild guild, int subscriptionCount, boolean canShowConfirmationDialog) {
        m.checkNotNullParameter(guildBoostState, "guildBoostState");
        return new GuildBoostInProgressViewModel$ViewState$Loaded(guildBoostState, guild, subscriptionCount, canShowConfirmationDialog);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildBoostInProgressViewModel$ViewState$Loaded)) {
            return false;
        }
        GuildBoostInProgressViewModel$ViewState$Loaded guildBoostInProgressViewModel$ViewState$Loaded = (GuildBoostInProgressViewModel$ViewState$Loaded) other;
        return m.areEqual(getGuildBoostState(), guildBoostInProgressViewModel$ViewState$Loaded.getGuildBoostState()) && m.areEqual(this.guild, guildBoostInProgressViewModel$ViewState$Loaded.guild) && this.subscriptionCount == guildBoostInProgressViewModel$ViewState$Loaded.subscriptionCount && this.canShowConfirmationDialog == guildBoostInProgressViewModel$ViewState$Loaded.canShowConfirmationDialog;
    }

    public final boolean getCanShowConfirmationDialog() {
        return this.canShowConfirmationDialog;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    @Override // com.discord.widgets.servers.guildboost.GuildBoostInProgressViewModel$ViewState
    public GuildBoostInProgressViewModel$GuildBoostState getGuildBoostState() {
        return this.guildBoostState;
    }

    public final int getSubscriptionCount() {
        return this.subscriptionCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        GuildBoostInProgressViewModel$GuildBoostState guildBoostState = getGuildBoostState();
        int iHashCode = (guildBoostState != null ? guildBoostState.hashCode() : 0) * 31;
        Guild guild = this.guild;
        int iHashCode2 = (((iHashCode + (guild != null ? guild.hashCode() : 0)) * 31) + this.subscriptionCount) * 31;
        boolean z2 = this.canShowConfirmationDialog;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(guildBoostState=");
        sbU.append(getGuildBoostState());
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", subscriptionCount=");
        sbU.append(this.subscriptionCount);
        sbU.append(", canShowConfirmationDialog=");
        return a.O(sbU, this.canShowConfirmationDialog, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostInProgressViewModel$ViewState$Loaded(GuildBoostInProgressViewModel$GuildBoostState guildBoostInProgressViewModel$GuildBoostState, Guild guild, int i, boolean z2) {
        super(guildBoostInProgressViewModel$GuildBoostState, null);
        m.checkNotNullParameter(guildBoostInProgressViewModel$GuildBoostState, "guildBoostState");
        this.guildBoostState = guildBoostInProgressViewModel$GuildBoostState;
        this.guild = guild;
        this.subscriptionCount = i;
        this.canShowConfirmationDialog = z2;
    }
}
