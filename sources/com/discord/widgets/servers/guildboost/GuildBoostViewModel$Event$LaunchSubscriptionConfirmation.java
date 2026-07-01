package com.discord.widgets.servers.guildboost;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: GuildBoostViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildBoostViewModel$Event$LaunchSubscriptionConfirmation extends GuildBoostViewModel$Event {
    private final long guildId;
    private final long slotId;

    public GuildBoostViewModel$Event$LaunchSubscriptionConfirmation(long j, long j2) {
        super(null);
        this.guildId = j;
        this.slotId = j2;
    }

    public static /* synthetic */ GuildBoostViewModel$Event$LaunchSubscriptionConfirmation copy$default(GuildBoostViewModel$Event$LaunchSubscriptionConfirmation guildBoostViewModel$Event$LaunchSubscriptionConfirmation, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = guildBoostViewModel$Event$LaunchSubscriptionConfirmation.guildId;
        }
        if ((i & 2) != 0) {
            j2 = guildBoostViewModel$Event$LaunchSubscriptionConfirmation.slotId;
        }
        return guildBoostViewModel$Event$LaunchSubscriptionConfirmation.copy(j, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getSlotId() {
        return this.slotId;
    }

    public final GuildBoostViewModel$Event$LaunchSubscriptionConfirmation copy(long guildId, long slotId) {
        return new GuildBoostViewModel$Event$LaunchSubscriptionConfirmation(guildId, slotId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildBoostViewModel$Event$LaunchSubscriptionConfirmation)) {
            return false;
        }
        GuildBoostViewModel$Event$LaunchSubscriptionConfirmation guildBoostViewModel$Event$LaunchSubscriptionConfirmation = (GuildBoostViewModel$Event$LaunchSubscriptionConfirmation) other;
        return this.guildId == guildBoostViewModel$Event$LaunchSubscriptionConfirmation.guildId && this.slotId == guildBoostViewModel$Event$LaunchSubscriptionConfirmation.slotId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final long getSlotId() {
        return this.slotId;
    }

    public int hashCode() {
        return b.a(this.slotId) + (b.a(this.guildId) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("LaunchSubscriptionConfirmation(guildId=");
        sbU.append(this.guildId);
        sbU.append(", slotId=");
        return a.C(sbU, this.slotId, ")");
    }
}
