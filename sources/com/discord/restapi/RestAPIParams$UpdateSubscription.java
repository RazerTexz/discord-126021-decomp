package com.discord.restapi;

import com.discord.models.domain.ModelSubscription$SubscriptionAdditionalPlan;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$UpdateSubscription {
    private final List<ModelSubscription$SubscriptionAdditionalPlan> additionalPlans;
    private final String paymentSourceId;
    private final Long planId;
    private final Integer status;

    public RestAPIParams$UpdateSubscription() {
        this(null, null, null, null, 15, null);
    }

    public RestAPIParams$UpdateSubscription(Integer num, String str, Long l, List<ModelSubscription$SubscriptionAdditionalPlan> list) {
        this.status = num;
        this.paymentSourceId = str;
        this.planId = l;
        this.additionalPlans = list;
    }

    public /* synthetic */ RestAPIParams$UpdateSubscription(Integer num, String str, Long l, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : list);
    }
}
