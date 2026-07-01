package com.discord.models.domain.premium;

import b.d.b.a.a;
import com.discord.api.premium.SubscriptionInterval;
import com.discord.models.domain.ModelSubscription$SubscriptionItem;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SubscriptionPlanType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SubscriptionPlanType$Companion {
    private SubscriptionPlanType$Companion() {
    }

    private final SubscriptionPlanType getNonePlanForIntervalType(SubscriptionInterval interval, int intervalCount) {
        int iOrdinal = interval.ordinal();
        if (iOrdinal == 0) {
            if (intervalCount != 3) {
                return intervalCount != 6 ? SubscriptionPlanType.NONE_MONTH : SubscriptionPlanType.NONE_6_MONTH;
            }
            return SubscriptionPlanType.NONE_3_MONTH;
        }
        if (iOrdinal == 1) {
            return SubscriptionPlanType.NONE_YEAR;
        }
        throw new IllegalArgumentException("unsupported plan interval: " + interval);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x001f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:15:0x0020  */
    public final SubscriptionPlanType from(long planId) {
        SubscriptionPlanType subscriptionPlanType;
        SubscriptionPlanType[] subscriptionPlanTypeArrValues = SubscriptionPlanType.values();
        for (int i = 0; i < 17; i++) {
            subscriptionPlanType = subscriptionPlanTypeArrValues[i];
            if (subscriptionPlanType.getPlanId() == planId) {
                if (subscriptionPlanType != null) {
                    return subscriptionPlanType;
                }
                throw new IllegalArgumentException(a.t("unsupported type plan id: ", planId));
            }
        }
        subscriptionPlanType = null;
        if (subscriptionPlanType != null) {
            return subscriptionPlanType;
        }
        throw new IllegalArgumentException(a.t("unsupported type plan id: ", planId));
    }

    public final SubscriptionPlanType getBasePlanFromSubscriptionItems(List<ModelSubscription$SubscriptionItem> items, SubscriptionInterval interval, int intervalCount) {
        Object next;
        SubscriptionInterval interval2;
        m.checkNotNullParameter(items, "items");
        m.checkNotNullParameter(interval, "interval");
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(items, 10));
        Iterator<T> it = items.iterator();
        while (it.hasNext()) {
            arrayList.add(SubscriptionPlanType.Companion.from(((ModelSubscription$SubscriptionItem) it.next()).getPlanId()));
        }
        SubscriptionPlanType subscriptionPlanType = (SubscriptionPlanType) u.firstOrNull((List) arrayList);
        if (subscriptionPlanType != null && (interval2 = subscriptionPlanType.getInterval()) != null) {
            interval = interval2;
        }
        Iterator it2 = arrayList.iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
        } while (!(((SubscriptionPlanType) next).getPremiumTier() != null));
        SubscriptionPlanType subscriptionPlanType2 = (SubscriptionPlanType) next;
        return subscriptionPlanType2 != null ? subscriptionPlanType2 : getNonePlanForIntervalType(interval, intervalCount);
    }

    public final Set<SubscriptionPlanType> getLEGACY_PLANS() {
        return SubscriptionPlanType.access$getLEGACY_PLANS$cp();
    }

    public final Set<SubscriptionPlanType> getPREMIUM_GUILD_PLANS() {
        return SubscriptionPlanType.access$getPREMIUM_GUILD_PLANS$cp();
    }

    public final Set<SubscriptionPlanType> getPREMIUM_PLANS() {
        return SubscriptionPlanType.access$getPREMIUM_PLANS$cp();
    }

    public /* synthetic */ SubscriptionPlanType$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0022 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:12:0x0023  */
    public final SubscriptionPlanType from(String planTypeString) {
        SubscriptionPlanType subscriptionPlanType;
        m.checkNotNullParameter(planTypeString, "planTypeString");
        SubscriptionPlanType[] subscriptionPlanTypeArrValues = SubscriptionPlanType.values();
        for (int i = 0; i < 17; i++) {
            subscriptionPlanType = subscriptionPlanTypeArrValues[i];
            if (m.areEqual(subscriptionPlanType.getPlanTypeString(), planTypeString)) {
                if (subscriptionPlanType != null) {
                    return subscriptionPlanType;
                }
                throw new IllegalArgumentException(a.w("unsupported planTypeString: ", planTypeString));
            }
        }
        subscriptionPlanType = null;
        if (subscriptionPlanType != null) {
            return subscriptionPlanType;
        }
        throw new IllegalArgumentException(a.w("unsupported planTypeString: ", planTypeString));
    }
}
