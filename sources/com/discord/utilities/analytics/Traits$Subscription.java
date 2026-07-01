package com.discord.utilities.analytics;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Traits.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class Traits$Subscription {
    public static final Traits$Subscription$Companion Companion = new Traits$Subscription$Companion(null);
    private final String gatewayPlanId;
    private final Long planId;
    private final Integer type;

    public Traits$Subscription(String str, Integer num, Long l) {
        this.gatewayPlanId = str;
        this.type = num;
        this.planId = l;
    }

    public static /* synthetic */ Traits$Subscription copy$default(Traits$Subscription traits$Subscription, String str, Integer num, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = traits$Subscription.gatewayPlanId;
        }
        if ((i & 2) != 0) {
            num = traits$Subscription.type;
        }
        if ((i & 4) != 0) {
            l = traits$Subscription.planId;
        }
        return traits$Subscription.copy(str, num, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGatewayPlanId() {
        return this.gatewayPlanId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getPlanId() {
        return this.planId;
    }

    public final Traits$Subscription copy(String gatewayPlanId, Integer type, Long planId) {
        return new Traits$Subscription(gatewayPlanId, type, planId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Traits$Subscription)) {
            return false;
        }
        Traits$Subscription traits$Subscription = (Traits$Subscription) other;
        return m.areEqual(this.gatewayPlanId, traits$Subscription.gatewayPlanId) && m.areEqual(this.type, traits$Subscription.type) && m.areEqual(this.planId, traits$Subscription.planId);
    }

    public final String getGatewayPlanId() {
        return this.gatewayPlanId;
    }

    public final Long getPlanId() {
        return this.planId;
    }

    public final Integer getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.gatewayPlanId;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.type;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 31;
        Long l = this.planId;
        return iHashCode2 + (l != null ? l.hashCode() : 0);
    }

    public final void serializeTo(Map<String, Object> properties) {
        m.checkNotNullParameter(properties, "properties");
        String str = this.gatewayPlanId;
        if (str != null) {
            properties.put("subscription_plan_gateway_plan_id", str);
        }
        Integer num = this.type;
        if (num != null) {
            properties.put("subscription_type", Integer.valueOf(num.intValue()));
        }
        Long l = this.planId;
        if (l != null) {
            properties.put("subscription_plan_id", Long.valueOf(l.longValue()));
        }
    }

    public String toString() {
        StringBuilder sbU = a.U("Subscription(gatewayPlanId=");
        sbU.append(this.gatewayPlanId);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", planId=");
        return a.G(sbU, this.planId, ")");
    }

    public /* synthetic */ Traits$Subscription(String str, Integer num, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, num, (i & 4) != 0 ? null : l);
    }
}
