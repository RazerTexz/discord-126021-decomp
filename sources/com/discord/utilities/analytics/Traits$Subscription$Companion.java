package com.discord.utilities.analytics;

import com.discord.models.domain.premium.SubscriptionPlanType;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Traits.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Traits$Subscription$Companion {
    private Traits$Subscription$Companion() {
    }

    public final Traits$Subscription from(SubscriptionPlanType subscriptionPlanType) {
        m.checkNotNullParameter(subscriptionPlanType, "subscriptionPlanType");
        return new Traits$Subscription(subscriptionPlanType.getPlanTypeString(), 1, Long.valueOf(subscriptionPlanType.getPlanId()));
    }

    public final Traits$Subscription withGatewayPlanId(String gatewayPlanId) {
        m.checkNotNullParameter(gatewayPlanId, "gatewayPlanId");
        return new Traits$Subscription(gatewayPlanId, 1, null);
    }

    public /* synthetic */ Traits$Subscription$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
