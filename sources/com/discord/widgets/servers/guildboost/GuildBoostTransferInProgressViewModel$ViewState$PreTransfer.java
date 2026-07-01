package com.discord.widgets.servers.guildboost;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildBoostTransferInProgressViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildBoostTransferInProgressViewModel$ViewState$PreTransfer extends GuildBoostTransferInProgressViewModel$ViewState {
    private final boolean isTransferInProgress;
    private final Guild previousGuild;
    private final Guild targetGuild;
    private final int targetGuildSubscriptionCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostTransferInProgressViewModel$ViewState$PreTransfer(Guild guild, Guild guild2, int i, boolean z2) {
        super(null);
        m.checkNotNullParameter(guild, "previousGuild");
        m.checkNotNullParameter(guild2, "targetGuild");
        this.previousGuild = guild;
        this.targetGuild = guild2;
        this.targetGuildSubscriptionCount = i;
        this.isTransferInProgress = z2;
    }

    public static /* synthetic */ GuildBoostTransferInProgressViewModel$ViewState$PreTransfer copy$default(GuildBoostTransferInProgressViewModel$ViewState$PreTransfer guildBoostTransferInProgressViewModel$ViewState$PreTransfer, Guild guild, Guild guild2, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            guild = guildBoostTransferInProgressViewModel$ViewState$PreTransfer.previousGuild;
        }
        if ((i2 & 2) != 0) {
            guild2 = guildBoostTransferInProgressViewModel$ViewState$PreTransfer.targetGuild;
        }
        if ((i2 & 4) != 0) {
            i = guildBoostTransferInProgressViewModel$ViewState$PreTransfer.targetGuildSubscriptionCount;
        }
        if ((i2 & 8) != 0) {
            z2 = guildBoostTransferInProgressViewModel$ViewState$PreTransfer.isTransferInProgress;
        }
        return guildBoostTransferInProgressViewModel$ViewState$PreTransfer.copy(guild, guild2, i, z2);
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
    public final int getTargetGuildSubscriptionCount() {
        return this.targetGuildSubscriptionCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsTransferInProgress() {
        return this.isTransferInProgress;
    }

    public final GuildBoostTransferInProgressViewModel$ViewState$PreTransfer copy(Guild previousGuild, Guild targetGuild, int targetGuildSubscriptionCount, boolean isTransferInProgress) {
        m.checkNotNullParameter(previousGuild, "previousGuild");
        m.checkNotNullParameter(targetGuild, "targetGuild");
        return new GuildBoostTransferInProgressViewModel$ViewState$PreTransfer(previousGuild, targetGuild, targetGuildSubscriptionCount, isTransferInProgress);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildBoostTransferInProgressViewModel$ViewState$PreTransfer)) {
            return false;
        }
        GuildBoostTransferInProgressViewModel$ViewState$PreTransfer guildBoostTransferInProgressViewModel$ViewState$PreTransfer = (GuildBoostTransferInProgressViewModel$ViewState$PreTransfer) other;
        return m.areEqual(this.previousGuild, guildBoostTransferInProgressViewModel$ViewState$PreTransfer.previousGuild) && m.areEqual(this.targetGuild, guildBoostTransferInProgressViewModel$ViewState$PreTransfer.targetGuild) && this.targetGuildSubscriptionCount == guildBoostTransferInProgressViewModel$ViewState$PreTransfer.targetGuildSubscriptionCount && this.isTransferInProgress == guildBoostTransferInProgressViewModel$ViewState$PreTransfer.isTransferInProgress;
    }

    public final Guild getPreviousGuild() {
        return this.previousGuild;
    }

    public final Guild getTargetGuild() {
        return this.targetGuild;
    }

    public final int getTargetGuildSubscriptionCount() {
        return this.targetGuildSubscriptionCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        Guild guild = this.previousGuild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        Guild guild2 = this.targetGuild;
        int iHashCode2 = (((iHashCode + (guild2 != null ? guild2.hashCode() : 0)) * 31) + this.targetGuildSubscriptionCount) * 31;
        boolean z2 = this.isTransferInProgress;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public final boolean isTransferInProgress() {
        return this.isTransferInProgress;
    }

    public String toString() {
        StringBuilder sbU = a.U("PreTransfer(previousGuild=");
        sbU.append(this.previousGuild);
        sbU.append(", targetGuild=");
        sbU.append(this.targetGuild);
        sbU.append(", targetGuildSubscriptionCount=");
        sbU.append(this.targetGuildSubscriptionCount);
        sbU.append(", isTransferInProgress=");
        return a.O(sbU, this.isTransferInProgress, ")");
    }
}
