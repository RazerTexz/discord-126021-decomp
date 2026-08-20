package com.discord.models.domain;

import com.discord.api.premium.SubscriptionInterval;
import com.discord.models.domain.premium.SubscriptionPlanType;
import java.util.ArrayList;
import java.util.List;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;

/* JADX INFO: compiled from: ModelSubscription.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class HasSubscriptionItems {
    public final Long getGuildBoostPlanId() {
        ModelSubscription.SubscriptionAdditionalPlan subscriptionAdditionalPlan = (ModelSubscription.SubscriptionAdditionalPlan) C12163u.firstOrNull((List) getPremiumAdditionalPlans());
        if (subscriptionAdditionalPlan != null) {
            return Long.valueOf(subscriptionAdditionalPlan.getPlanId());
        }
        return null;
    }

    public abstract List<ModelSubscription.SubscriptionItem> getItems();

    public final List<ModelSubscription.SubscriptionAdditionalPlan> getPremiumAdditionalPlans() {
        List<ModelSubscription.SubscriptionItem> items = getItems();
        ArrayList<ModelSubscription.SubscriptionItem> arrayList = new ArrayList();
        for (Object obj : items) {
            if (((ModelSubscription.SubscriptionItem) obj).getPlanId() != getPremiumBasePlanId()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
        for (ModelSubscription.SubscriptionItem subscriptionItem : arrayList) {
            arrayList2.add(new ModelSubscription.SubscriptionAdditionalPlan(subscriptionItem.getPlanId(), subscriptionItem.getQuantity()));
        }
        return arrayList2;
    }

    public final long getPremiumBasePlanId() {
        ModelSubscription.SubscriptionItem subscriptionItem = (ModelSubscription.SubscriptionItem) C12163u.firstOrNull((List) getItems());
        Long lValueOf = subscriptionItem != null ? Long.valueOf(subscriptionItem.getPlanId()) : null;
        SubscriptionInterval interval = lValueOf != null ? SubscriptionPlanType.INSTANCE.from(lValueOf.longValue()).getInterval() : SubscriptionInterval.MONTHLY;
        ModelSubscription.SubscriptionItem subscriptionItem2 = (ModelSubscription.SubscriptionItem) C12163u.firstOrNull((List) getItems());
        Long lValueOf2 = subscriptionItem2 != null ? Long.valueOf(subscriptionItem2.getPlanId()) : null;
        return SubscriptionPlanType.INSTANCE.getBasePlanFromSubscriptionItems(getItems(), interval, lValueOf2 != null ? SubscriptionPlanType.INSTANCE.from(lValueOf2.longValue()).getIntervalCount() : 1).getPlanId();
    }
}
