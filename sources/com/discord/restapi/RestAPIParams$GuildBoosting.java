package com.discord.restapi;

import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$GuildBoosting {
    private final List<Long> userPremiumGuildSubscriptionSlotIds;

    public RestAPIParams$GuildBoosting(List<Long> list) {
        m.checkNotNullParameter(list, "userPremiumGuildSubscriptionSlotIds");
        this.userPremiumGuildSubscriptionSlotIds = list;
    }

    public final List<Long> getUserPremiumGuildSubscriptionSlotIds() {
        return this.userPremiumGuildSubscriptionSlotIds;
    }
}
