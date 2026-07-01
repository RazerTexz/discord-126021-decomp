package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: ModelSubscription.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelSubscription$SubscriptionRenewalMutations extends HasSubscriptionItems {
    private final List<ModelSubscription$SubscriptionItem> items;
    private final String paymentGatewayPlanId;

    public ModelSubscription$SubscriptionRenewalMutations(List<ModelSubscription$SubscriptionItem> list, String str) {
        m.checkNotNullParameter(list, "items");
        this.items = list;
        this.paymentGatewayPlanId = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelSubscription$SubscriptionRenewalMutations copy$default(ModelSubscription$SubscriptionRenewalMutations modelSubscription$SubscriptionRenewalMutations, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = modelSubscription$SubscriptionRenewalMutations.getItems();
        }
        if ((i & 2) != 0) {
            str = modelSubscription$SubscriptionRenewalMutations.paymentGatewayPlanId;
        }
        return modelSubscription$SubscriptionRenewalMutations.copy(list, str);
    }

    public final List<ModelSubscription$SubscriptionItem> component1() {
        return getItems();
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPaymentGatewayPlanId() {
        return this.paymentGatewayPlanId;
    }

    public final ModelSubscription$SubscriptionRenewalMutations copy(List<ModelSubscription$SubscriptionItem> items, String paymentGatewayPlanId) {
        m.checkNotNullParameter(items, "items");
        return new ModelSubscription$SubscriptionRenewalMutations(items, paymentGatewayPlanId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelSubscription$SubscriptionRenewalMutations)) {
            return false;
        }
        ModelSubscription$SubscriptionRenewalMutations modelSubscription$SubscriptionRenewalMutations = (ModelSubscription$SubscriptionRenewalMutations) other;
        return m.areEqual(getItems(), modelSubscription$SubscriptionRenewalMutations.getItems()) && m.areEqual(this.paymentGatewayPlanId, modelSubscription$SubscriptionRenewalMutations.paymentGatewayPlanId);
    }

    @Override // com.discord.models.domain.HasSubscriptionItems
    public List<ModelSubscription$SubscriptionItem> getItems() {
        return this.items;
    }

    public final String getPaymentGatewayPlanId() {
        return this.paymentGatewayPlanId;
    }

    public int hashCode() {
        List<ModelSubscription$SubscriptionItem> items = getItems();
        int iHashCode = (items != null ? items.hashCode() : 0) * 31;
        String str = this.paymentGatewayPlanId;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("SubscriptionRenewalMutations(items=");
        sbU.append(getItems());
        sbU.append(", paymentGatewayPlanId=");
        return a.J(sbU, this.paymentGatewayPlanId, ")");
    }
}
