package com.discord.restapi;

import b.d.b.a.a;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.nullserializable.NullSerializable;
import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$UpdateGuildRoleSubscriptionTierFreeTrial {
    private final NullSerializable<Integer> maxNumActiveTrialUsers;
    private final NullSerializable<SubscriptionTrialInterval> trial;

    public RestAPIParams$UpdateGuildRoleSubscriptionTierFreeTrial(NullSerializable<SubscriptionTrialInterval> nullSerializable, NullSerializable<Integer> nullSerializable2) {
        this.trial = nullSerializable;
        this.maxNumActiveTrialUsers = nullSerializable2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RestAPIParams$UpdateGuildRoleSubscriptionTierFreeTrial copy$default(RestAPIParams$UpdateGuildRoleSubscriptionTierFreeTrial restAPIParams$UpdateGuildRoleSubscriptionTierFreeTrial, NullSerializable nullSerializable, NullSerializable nullSerializable2, int i, Object obj) {
        if ((i & 1) != 0) {
            nullSerializable = restAPIParams$UpdateGuildRoleSubscriptionTierFreeTrial.trial;
        }
        if ((i & 2) != 0) {
            nullSerializable2 = restAPIParams$UpdateGuildRoleSubscriptionTierFreeTrial.maxNumActiveTrialUsers;
        }
        return restAPIParams$UpdateGuildRoleSubscriptionTierFreeTrial.copy(nullSerializable, nullSerializable2);
    }

    public final NullSerializable<SubscriptionTrialInterval> component1() {
        return this.trial;
    }

    public final NullSerializable<Integer> component2() {
        return this.maxNumActiveTrialUsers;
    }

    public final RestAPIParams$UpdateGuildRoleSubscriptionTierFreeTrial copy(NullSerializable<SubscriptionTrialInterval> trial, NullSerializable<Integer> maxNumActiveTrialUsers) {
        return new RestAPIParams$UpdateGuildRoleSubscriptionTierFreeTrial(trial, maxNumActiveTrialUsers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RestAPIParams$UpdateGuildRoleSubscriptionTierFreeTrial)) {
            return false;
        }
        RestAPIParams$UpdateGuildRoleSubscriptionTierFreeTrial restAPIParams$UpdateGuildRoleSubscriptionTierFreeTrial = (RestAPIParams$UpdateGuildRoleSubscriptionTierFreeTrial) other;
        return m.areEqual(this.trial, restAPIParams$UpdateGuildRoleSubscriptionTierFreeTrial.trial) && m.areEqual(this.maxNumActiveTrialUsers, restAPIParams$UpdateGuildRoleSubscriptionTierFreeTrial.maxNumActiveTrialUsers);
    }

    public final NullSerializable<Integer> getMaxNumActiveTrialUsers() {
        return this.maxNumActiveTrialUsers;
    }

    public final NullSerializable<SubscriptionTrialInterval> getTrial() {
        return this.trial;
    }

    public int hashCode() {
        NullSerializable<SubscriptionTrialInterval> nullSerializable = this.trial;
        int iHashCode = (nullSerializable != null ? nullSerializable.hashCode() : 0) * 31;
        NullSerializable<Integer> nullSerializable2 = this.maxNumActiveTrialUsers;
        return iHashCode + (nullSerializable2 != null ? nullSerializable2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("UpdateGuildRoleSubscriptionTierFreeTrial(trial=");
        sbU.append(this.trial);
        sbU.append(", maxNumActiveTrialUsers=");
        sbU.append(this.maxNumActiveTrialUsers);
        sbU.append(")");
        return sbU.toString();
    }
}
