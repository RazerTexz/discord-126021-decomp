package com.discord.models.domain;

import b.d.b.a.a;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: ModelSubscription.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelSubscription extends HasSubscriptionItems {
    private final String canceledAt;
    private final String createdAt;
    private final String currentPeriodEnd;
    private final String currentPeriodStart;
    private final String id;
    private final List<ModelSubscription$SubscriptionItem> items;
    private final Integer paymentGateway;
    private final String paymentGatewayPlanId;
    private final String paymentSourceId;
    private final ModelSubscription$SubscriptionRenewalMutations renewalMutations;
    private final int status;
    private final String trialEndsAt;
    private final String trialId;
    private final int type;

    public ModelSubscription(String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, ModelSubscription$SubscriptionRenewalMutations modelSubscription$SubscriptionRenewalMutations, List<ModelSubscription$SubscriptionItem> list, String str9, int i, int i2) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        m.checkNotNullParameter(str2, "createdAt");
        m.checkNotNullParameter(str4, "currentPeriodStart");
        m.checkNotNullParameter(str5, "currentPeriodEnd");
        m.checkNotNullParameter(list, "items");
        this.id = str;
        this.createdAt = str2;
        this.canceledAt = str3;
        this.currentPeriodStart = str4;
        this.currentPeriodEnd = str5;
        this.paymentSourceId = str6;
        this.paymentGateway = num;
        this.trialId = str7;
        this.trialEndsAt = str8;
        this.renewalMutations = modelSubscription$SubscriptionRenewalMutations;
        this.items = list;
        this.paymentGatewayPlanId = str9;
        this.status = i;
        this.type = i2;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    private final int getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    private final int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelSubscription copy$default(ModelSubscription modelSubscription, String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, ModelSubscription$SubscriptionRenewalMutations modelSubscription$SubscriptionRenewalMutations, List list, String str9, int i, int i2, int i3, Object obj) {
        return modelSubscription.copy((i3 & 1) != 0 ? modelSubscription.id : str, (i3 & 2) != 0 ? modelSubscription.createdAt : str2, (i3 & 4) != 0 ? modelSubscription.canceledAt : str3, (i3 & 8) != 0 ? modelSubscription.currentPeriodStart : str4, (i3 & 16) != 0 ? modelSubscription.currentPeriodEnd : str5, (i3 & 32) != 0 ? modelSubscription.paymentSourceId : str6, (i3 & 64) != 0 ? modelSubscription.paymentGateway : num, (i3 & 128) != 0 ? modelSubscription.trialId : str7, (i3 & 256) != 0 ? modelSubscription.trialEndsAt : str8, (i3 & 512) != 0 ? modelSubscription.renewalMutations : modelSubscription$SubscriptionRenewalMutations, (i3 & 1024) != 0 ? modelSubscription.getItems() : list, (i3 & 2048) != 0 ? modelSubscription.paymentGatewayPlanId : str9, (i3 & 4096) != 0 ? modelSubscription.status : i, (i3 & 8192) != 0 ? modelSubscription.type : i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final ModelSubscription$SubscriptionRenewalMutations getRenewalMutations() {
        return this.renewalMutations;
    }

    public final List<ModelSubscription$SubscriptionItem> component11() {
        return getItems();
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getPaymentGatewayPlanId() {
        return this.paymentGatewayPlanId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCanceledAt() {
        return this.canceledAt;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCurrentPeriodStart() {
        return this.currentPeriodStart;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getCurrentPeriodEnd() {
        return this.currentPeriodEnd;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPaymentSourceId() {
        return this.paymentSourceId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getPaymentGateway() {
        return this.paymentGateway;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getTrialId() {
        return this.trialId;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getTrialEndsAt() {
        return this.trialEndsAt;
    }

    public final ModelSubscription copy(String id2, String createdAt, String canceledAt, String currentPeriodStart, String currentPeriodEnd, String paymentSourceId, Integer paymentGateway, String trialId, String trialEndsAt, ModelSubscription$SubscriptionRenewalMutations renewalMutations, List<ModelSubscription$SubscriptionItem> items, String paymentGatewayPlanId, int status, int type) {
        m.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        m.checkNotNullParameter(createdAt, "createdAt");
        m.checkNotNullParameter(currentPeriodStart, "currentPeriodStart");
        m.checkNotNullParameter(currentPeriodEnd, "currentPeriodEnd");
        m.checkNotNullParameter(items, "items");
        return new ModelSubscription(id2, createdAt, canceledAt, currentPeriodStart, currentPeriodEnd, paymentSourceId, paymentGateway, trialId, trialEndsAt, renewalMutations, items, paymentGatewayPlanId, status, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelSubscription)) {
            return false;
        }
        ModelSubscription modelSubscription = (ModelSubscription) other;
        return m.areEqual(this.id, modelSubscription.id) && m.areEqual(this.createdAt, modelSubscription.createdAt) && m.areEqual(this.canceledAt, modelSubscription.canceledAt) && m.areEqual(this.currentPeriodStart, modelSubscription.currentPeriodStart) && m.areEqual(this.currentPeriodEnd, modelSubscription.currentPeriodEnd) && m.areEqual(this.paymentSourceId, modelSubscription.paymentSourceId) && m.areEqual(this.paymentGateway, modelSubscription.paymentGateway) && m.areEqual(this.trialId, modelSubscription.trialId) && m.areEqual(this.trialEndsAt, modelSubscription.trialEndsAt) && m.areEqual(this.renewalMutations, modelSubscription.renewalMutations) && m.areEqual(getItems(), modelSubscription.getItems()) && m.areEqual(this.paymentGatewayPlanId, modelSubscription.paymentGatewayPlanId) && this.status == modelSubscription.status && this.type == modelSubscription.type;
    }

    public final long getAccountHoldEstimatedExpirationTimestamp() {
        return TimeUtils.addDaysToDate(this.currentPeriodEnd, 30);
    }

    public final String getCanceledAt() {
        return this.canceledAt;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getCurrentPeriodEnd() {
        return this.currentPeriodEnd;
    }

    public final String getCurrentPeriodStart() {
        return this.currentPeriodStart;
    }

    public final String getId() {
        return this.id;
    }

    @Override // com.discord.models.domain.HasSubscriptionItems
    public List<ModelSubscription$SubscriptionItem> getItems() {
        return this.items;
    }

    public final Integer getPaymentGateway() {
        return this.paymentGateway;
    }

    public final String getPaymentGatewayPlanId() {
        return this.paymentGatewayPlanId;
    }

    public final String getPaymentSourceId() {
        return this.paymentSourceId;
    }

    public final SubscriptionPlanType getPlanType() {
        return SubscriptionPlanType.Companion.from(getPremiumBasePlanId());
    }

    public final ModelSubscription$SubscriptionRenewalMutations getRenewalMutations() {
        return this.renewalMutations;
    }

    public final ModelSubscription$Status getStatus() {
        return ModelSubscription$Status.Companion.from(this.status);
    }

    public final String getTrialEndsAt() {
        return this.trialEndsAt;
    }

    public final String getTrialId() {
        return this.trialId;
    }

    public final ModelSubscription$Type getType() {
        return ModelSubscription$Type.Companion.from(this.type);
    }

    public final boolean hasAnyOfPlans(Set<Long> planIds) {
        m.checkNotNullParameter(planIds, "planIds");
        List<ModelSubscription$SubscriptionItem> items = getItems();
        if ((items instanceof Collection) && items.isEmpty()) {
            return false;
        }
        Iterator<T> it = items.iterator();
        while (it.hasNext()) {
            if (planIds.contains(Long.valueOf(((ModelSubscription$SubscriptionItem) it.next()).getPlanId()))) {
                return true;
            }
        }
        return false;
    }

    public final boolean hasPlan(long planId) {
        List<ModelSubscription$SubscriptionItem> items = getItems();
        if (!(items instanceof Collection) || !items.isEmpty()) {
            Iterator<T> it = items.iterator();
            while (it.hasNext()) {
                if (((ModelSubscription$SubscriptionItem) it.next()).getPlanId() == planId) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.createdAt;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.canceledAt;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.currentPeriodStart;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.currentPeriodEnd;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.paymentSourceId;
        int iHashCode6 = (iHashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Integer num = this.paymentGateway;
        int iHashCode7 = (iHashCode6 + (num != null ? num.hashCode() : 0)) * 31;
        String str7 = this.trialId;
        int iHashCode8 = (iHashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.trialEndsAt;
        int iHashCode9 = (iHashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        ModelSubscription$SubscriptionRenewalMutations modelSubscription$SubscriptionRenewalMutations = this.renewalMutations;
        int iHashCode10 = (iHashCode9 + (modelSubscription$SubscriptionRenewalMutations != null ? modelSubscription$SubscriptionRenewalMutations.hashCode() : 0)) * 31;
        List<ModelSubscription$SubscriptionItem> items = getItems();
        int iHashCode11 = (iHashCode10 + (items != null ? items.hashCode() : 0)) * 31;
        String str9 = this.paymentGatewayPlanId;
        return ((((iHashCode11 + (str9 != null ? str9.hashCode() : 0)) * 31) + this.status) * 31) + this.type;
    }

    public final boolean isAppleSubscription() {
        return ModelSubscription$PaymentGateway.Companion.from(this.paymentGateway) == ModelSubscription$PaymentGateway.APPLE;
    }

    public final boolean isGoogleSubscription() {
        return ModelSubscription$PaymentGateway.Companion.from(this.paymentGateway) == ModelSubscription$PaymentGateway.GOOGLE;
    }

    public final boolean isMobileManaged() {
        return isAppleSubscription() || isGoogleSubscription();
    }

    public final boolean isNonePlan() {
        return getPlanType() == SubscriptionPlanType.NONE_MONTH || getPlanType() == SubscriptionPlanType.NONE_YEAR || getPlanType() == SubscriptionPlanType.NONE_3_MONTH || getPlanType() == SubscriptionPlanType.NONE_6_MONTH;
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelSubscription(id=");
        sbU.append(this.id);
        sbU.append(", createdAt=");
        sbU.append(this.createdAt);
        sbU.append(", canceledAt=");
        sbU.append(this.canceledAt);
        sbU.append(", currentPeriodStart=");
        sbU.append(this.currentPeriodStart);
        sbU.append(", currentPeriodEnd=");
        sbU.append(this.currentPeriodEnd);
        sbU.append(", paymentSourceId=");
        sbU.append(this.paymentSourceId);
        sbU.append(", paymentGateway=");
        sbU.append(this.paymentGateway);
        sbU.append(", trialId=");
        sbU.append(this.trialId);
        sbU.append(", trialEndsAt=");
        sbU.append(this.trialEndsAt);
        sbU.append(", renewalMutations=");
        sbU.append(this.renewalMutations);
        sbU.append(", items=");
        sbU.append(getItems());
        sbU.append(", paymentGatewayPlanId=");
        sbU.append(this.paymentGatewayPlanId);
        sbU.append(", status=");
        sbU.append(this.status);
        sbU.append(", type=");
        return a.B(sbU, this.type, ")");
    }
}
