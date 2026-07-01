package com.discord.models.domain;

import com.discord.api.premium.SubscriptionInterval;
import com.discord.models.domain.premium.SubscriptionPlanType;
import d0.t.o;
import d0.t.u;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ModelSubscription.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class HasSubscriptionItems {
    public final Long getGuildBoostPlanId() {
        ModelSubscription$SubscriptionAdditionalPlan modelSubscription$SubscriptionAdditionalPlan = (ModelSubscription$SubscriptionAdditionalPlan) u.firstOrNull((List) getPremiumAdditionalPlans());
        if (modelSubscription$SubscriptionAdditionalPlan != null) {
            return Long.valueOf(modelSubscription$SubscriptionAdditionalPlan.getPlanId());
        }
        return null;
    }

    public abstract List<ModelSubscription$SubscriptionItem> getItems();

    public final List<ModelSubscription$SubscriptionAdditionalPlan> getPremiumAdditionalPlans() {
        List<ModelSubscription$SubscriptionItem> items = getItems();
        ArrayList<ModelSubscription$SubscriptionItem> arrayList = new ArrayList();
        for (Object obj : items) {
            if (((ModelSubscription$SubscriptionItem) obj).getPlanId() != getPremiumBasePlanId()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
        for (ModelSubscription$SubscriptionItem modelSubscription$SubscriptionItem : arrayList) {
            arrayList2.add(new ModelSubscription$SubscriptionAdditionalPlan(modelSubscription$SubscriptionItem.getPlanId(), modelSubscription$SubscriptionItem.getQuantity()));
        }
        return arrayList2;
    }

    public final long getPremiumBasePlanId() {
        ModelSubscription$SubscriptionItem modelSubscription$SubscriptionItem = (ModelSubscription$SubscriptionItem) u.firstOrNull((List) getItems());
        Long lValueOf = modelSubscription$SubscriptionItem != null ? Long.valueOf(modelSubscription$SubscriptionItem.getPlanId()) : null;
        SubscriptionInterval interval = lValueOf != null ? SubscriptionPlanType.Companion.from(lValueOf.longValue()).getInterval() : SubscriptionInterval.MONTHLY;
        ModelSubscription$SubscriptionItem modelSubscription$SubscriptionItem2 = (ModelSubscription$SubscriptionItem) u.firstOrNull((List) getItems());
        Long lValueOf2 = modelSubscription$SubscriptionItem2 != null ? Long.valueOf(modelSubscription$SubscriptionItem2.getPlanId()) : null;
        return SubscriptionPlanType.Companion.getBasePlanFromSubscriptionItems(getItems(), interval, lValueOf2 != null ? SubscriptionPlanType.Companion.from(lValueOf2.longValue()).getIntervalCount() : 1).getPlanId();
    }
}
