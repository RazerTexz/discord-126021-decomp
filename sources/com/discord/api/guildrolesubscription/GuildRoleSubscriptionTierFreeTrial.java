package com.discord.api.guildrolesubscription;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierFreeTrial.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildRoleSubscriptionTierFreeTrial {
    private final SubscriptionTrial activeTrial;
    private final long id;
    private final Integer maxNumActiveTrialUsers;
    private final Integer numActiveTrialUsers;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final SubscriptionTrial getActiveTrial() {
        return this.activeTrial;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final Integer getMaxNumActiveTrialUsers() {
        return this.maxNumActiveTrialUsers;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleSubscriptionTierFreeTrial)) {
            return false;
        }
        GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial = (GuildRoleSubscriptionTierFreeTrial) other;
        return this.id == guildRoleSubscriptionTierFreeTrial.id && C12238m.areEqual(this.numActiveTrialUsers, guildRoleSubscriptionTierFreeTrial.numActiveTrialUsers) && C12238m.areEqual(this.activeTrial, guildRoleSubscriptionTierFreeTrial.activeTrial) && C12238m.areEqual(this.maxNumActiveTrialUsers, guildRoleSubscriptionTierFreeTrial.maxNumActiveTrialUsers);
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        Integer num = this.numActiveTrialUsers;
        int iHashCode = (i + (num != null ? num.hashCode() : 0)) * 31;
        SubscriptionTrial subscriptionTrial = this.activeTrial;
        int iHashCode2 = (iHashCode + (subscriptionTrial != null ? subscriptionTrial.hashCode() : 0)) * 31;
        Integer num2 = this.maxNumActiveTrialUsers;
        return iHashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("GuildRoleSubscriptionTierFreeTrial(id=");
        sbM833U.append(this.id);
        sbM833U.append(", numActiveTrialUsers=");
        sbM833U.append(this.numActiveTrialUsers);
        sbM833U.append(", activeTrial=");
        sbM833U.append(this.activeTrial);
        sbM833U.append(", maxNumActiveTrialUsers=");
        return C1643a.m818F(sbM833U, this.maxNumActiveTrialUsers, ")");
    }
}
