package com.discord.widgets.servers.guildboost;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildBoostTransferInProgressViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildBoostTransferInProgressViewModel$ViewState$PostTransfer extends GuildBoostTransferInProgressViewModel$ViewState {
    private final Guild targetGuild;
    private final int targetGuildSubscriptionCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostTransferInProgressViewModel$ViewState$PostTransfer(Guild guild, int i) {
        super(null);
        m.checkNotNullParameter(guild, "targetGuild");
        this.targetGuild = guild;
        this.targetGuildSubscriptionCount = i;
    }

    public static /* synthetic */ GuildBoostTransferInProgressViewModel$ViewState$PostTransfer copy$default(GuildBoostTransferInProgressViewModel$ViewState$PostTransfer guildBoostTransferInProgressViewModel$ViewState$PostTransfer, Guild guild, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            guild = guildBoostTransferInProgressViewModel$ViewState$PostTransfer.targetGuild;
        }
        if ((i2 & 2) != 0) {
            i = guildBoostTransferInProgressViewModel$ViewState$PostTransfer.targetGuildSubscriptionCount;
        }
        return guildBoostTransferInProgressViewModel$ViewState$PostTransfer.copy(guild, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getTargetGuild() {
        return this.targetGuild;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTargetGuildSubscriptionCount() {
        return this.targetGuildSubscriptionCount;
    }

    public final GuildBoostTransferInProgressViewModel$ViewState$PostTransfer copy(Guild targetGuild, int targetGuildSubscriptionCount) {
        m.checkNotNullParameter(targetGuild, "targetGuild");
        return new GuildBoostTransferInProgressViewModel$ViewState$PostTransfer(targetGuild, targetGuildSubscriptionCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildBoostTransferInProgressViewModel$ViewState$PostTransfer)) {
            return false;
        }
        GuildBoostTransferInProgressViewModel$ViewState$PostTransfer guildBoostTransferInProgressViewModel$ViewState$PostTransfer = (GuildBoostTransferInProgressViewModel$ViewState$PostTransfer) other;
        return m.areEqual(this.targetGuild, guildBoostTransferInProgressViewModel$ViewState$PostTransfer.targetGuild) && this.targetGuildSubscriptionCount == guildBoostTransferInProgressViewModel$ViewState$PostTransfer.targetGuildSubscriptionCount;
    }

    public final Guild getTargetGuild() {
        return this.targetGuild;
    }

    public final int getTargetGuildSubscriptionCount() {
        return this.targetGuildSubscriptionCount;
    }

    public int hashCode() {
        Guild guild = this.targetGuild;
        return ((guild != null ? guild.hashCode() : 0) * 31) + this.targetGuildSubscriptionCount;
    }

    public String toString() {
        StringBuilder sbU = a.U("PostTransfer(targetGuild=");
        sbU.append(this.targetGuild);
        sbU.append(", targetGuildSubscriptionCount=");
        return a.B(sbU, this.targetGuildSubscriptionCount, ")");
    }
}
