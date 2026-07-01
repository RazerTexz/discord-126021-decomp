package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModelSubscription.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelSubscription extends ModelSubscription2 {
    private final String canceledAt;
    private final String createdAt;
    private final String currentPeriodEnd;
    private final String currentPeriodStart;
    private final String id;
    private final List<SubscriptionItem> items;
    private final Integer paymentGateway;
    private final String paymentGatewayPlanId;
    private final String paymentSourceId;
    private final SubscriptionRenewalMutations renewalMutations;
    private final int status;
    private final String trialEndsAt;
    private final String trialId;
    private final int type;

    /* JADX INFO: compiled from: ModelSubscription.kt */
    public enum PaymentGateway {
        STRIPE(1),
        BRAINTREE(2),
        APPLE(3),
        GOOGLE(4),
        UNKNOWN(null);


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Integer intRepresentation;

        /* JADX INFO: compiled from: ModelSubscription.kt */
        public static final class Companion {
            private Companion() {
            }

            /* JADX WARN: Code duplicated, block: B:12:0x001c  */
            /* JADX WARN: Code duplicated, block: B:16:? A[RETURN, SYNTHETIC] */
            public final PaymentGateway from(Integer paymentGatewayInt) {
                PaymentGateway paymentGateway;
                PaymentGateway[] paymentGatewayArrValues = PaymentGateway.values();
                for (int i = 0; i < 5; i++) {
                    paymentGateway = paymentGatewayArrValues[i];
                    if (Intrinsics3.areEqual(paymentGateway.getIntRepresentation(), paymentGatewayInt)) {
                        if (paymentGateway != null) {
                            return paymentGateway;
                        }
                        return PaymentGateway.UNKNOWN;
                    }
                }
                paymentGateway = null;
                if (paymentGateway != null) {
                    return paymentGateway;
                }
                return PaymentGateway.UNKNOWN;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        PaymentGateway(Integer num) {
            this.intRepresentation = num;
        }

        public final Integer getIntRepresentation() {
            return this.intRepresentation;
        }
    }

    /* JADX INFO: compiled from: ModelSubscription.kt */
    public enum Status {
        UNPAID(0),
        ACTIVE(1),
        PAST_DUE(2),
        CANCELED(3),
        ENDED(4),
        ACCOUNT_HOLD(6);


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int intRepresentation;

        /* JADX INFO: compiled from: ModelSubscription.kt */
        public static final class Companion {
            private Companion() {
            }

            /* JADX WARN: Code duplicated, block: B:14:0x001c A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            public final Status from(int statusInt) {
                Status status;
                Status[] statusArrValues = Status.values();
                for (int i = 0; i < 6; i++) {
                    status = statusArrValues[i];
                    if (status.getIntRepresentation() == statusInt) {
                        if (status != null) {
                            return status;
                        }
                        throw new IllegalArgumentException(outline.q("unsupported subscription status: ", statusInt));
                    }
                }
                status = null;
                if (status != null) {
                    return status;
                }
                throw new IllegalArgumentException(outline.q("unsupported subscription status: ", statusInt));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        Status(int i) {
            this.intRepresentation = i;
        }

        public final int getIntRepresentation() {
            return this.intRepresentation;
        }

        public final boolean isAccountHold() {
            return this == ACCOUNT_HOLD;
        }

        public final boolean isCanceled() {
            return this == CANCELED;
        }
    }

    /* JADX INFO: compiled from: ModelSubscription.kt */
    public static final /* data */ class SubscriptionAdditionalPlan {
        private final long planId;
        private final int quantity;

        public SubscriptionAdditionalPlan(long j, int i) {
            this.planId = j;
            this.quantity = i;
        }

        public static /* synthetic */ SubscriptionAdditionalPlan copy$default(SubscriptionAdditionalPlan subscriptionAdditionalPlan, long j, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = subscriptionAdditionalPlan.planId;
            }
            if ((i2 & 2) != 0) {
                i = subscriptionAdditionalPlan.quantity;
            }
            return subscriptionAdditionalPlan.copy(j, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getPlanId() {
            return this.planId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getQuantity() {
            return this.quantity;
        }

        public final SubscriptionAdditionalPlan copy(long planId, int quantity) {
            return new SubscriptionAdditionalPlan(planId, quantity);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubscriptionAdditionalPlan)) {
                return false;
            }
            SubscriptionAdditionalPlan subscriptionAdditionalPlan = (SubscriptionAdditionalPlan) other;
            return this.planId == subscriptionAdditionalPlan.planId && this.quantity == subscriptionAdditionalPlan.quantity;
        }

        public final long getPlanId() {
            return this.planId;
        }

        public final int getQuantity() {
            return this.quantity;
        }

        public int hashCode() {
            long j = this.planId;
            return (((int) (j ^ (j >>> 32))) * 31) + this.quantity;
        }

        public String toString() {
            StringBuilder sbU = outline.U("SubscriptionAdditionalPlan(planId=");
            sbU.append(this.planId);
            sbU.append(", quantity=");
            return outline.B(sbU, this.quantity, ")");
        }
    }

    /* JADX INFO: compiled from: ModelSubscription.kt */
    public static final /* data */ class SubscriptionItem {
        private final long id;
        private final long planId;
        private final int quantity;

        public SubscriptionItem(long j, long j2, int i) {
            this.id = j;
            this.planId = j2;
            this.quantity = i;
        }

        public static /* synthetic */ SubscriptionItem copy$default(SubscriptionItem subscriptionItem, long j, long j2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = subscriptionItem.id;
            }
            long j3 = j;
            if ((i2 & 2) != 0) {
                j2 = subscriptionItem.planId;
            }
            long j4 = j2;
            if ((i2 & 4) != 0) {
                i = subscriptionItem.quantity;
            }
            return subscriptionItem.copy(j3, j4, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getPlanId() {
            return this.planId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getQuantity() {
            return this.quantity;
        }

        public final SubscriptionItem copy(long id2, long planId, int quantity) {
            return new SubscriptionItem(id2, planId, quantity);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubscriptionItem)) {
                return false;
            }
            SubscriptionItem subscriptionItem = (SubscriptionItem) other;
            return this.id == subscriptionItem.id && this.planId == subscriptionItem.planId && this.quantity == subscriptionItem.quantity;
        }

        public final long getId() {
            return this.id;
        }

        public final long getPlanId() {
            return this.planId;
        }

        public final int getQuantity() {
            return this.quantity;
        }

        public int hashCode() {
            long j = this.id;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            long j2 = this.planId;
            return ((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.quantity;
        }

        public String toString() {
            StringBuilder sbU = outline.U("SubscriptionItem(id=");
            sbU.append(this.id);
            sbU.append(", planId=");
            sbU.append(this.planId);
            sbU.append(", quantity=");
            return outline.B(sbU, this.quantity, ")");
        }
    }

    /* JADX INFO: compiled from: ModelSubscription.kt */
    public static final /* data */ class SubscriptionRenewalMutations extends ModelSubscription2 {
        private final List<SubscriptionItem> items;
        private final String paymentGatewayPlanId;

        public SubscriptionRenewalMutations(List<SubscriptionItem> list, String str) {
            Intrinsics3.checkNotNullParameter(list, "items");
            this.items = list;
            this.paymentGatewayPlanId = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SubscriptionRenewalMutations copy$default(SubscriptionRenewalMutations subscriptionRenewalMutations, List list, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                list = subscriptionRenewalMutations.getItems();
            }
            if ((i & 2) != 0) {
                str = subscriptionRenewalMutations.paymentGatewayPlanId;
            }
            return subscriptionRenewalMutations.copy(list, str);
        }

        public final List<SubscriptionItem> component1() {
            return getItems();
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getPaymentGatewayPlanId() {
            return this.paymentGatewayPlanId;
        }

        public final SubscriptionRenewalMutations copy(List<SubscriptionItem> items, String paymentGatewayPlanId) {
            Intrinsics3.checkNotNullParameter(items, "items");
            return new SubscriptionRenewalMutations(items, paymentGatewayPlanId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubscriptionRenewalMutations)) {
                return false;
            }
            SubscriptionRenewalMutations subscriptionRenewalMutations = (SubscriptionRenewalMutations) other;
            return Intrinsics3.areEqual(getItems(), subscriptionRenewalMutations.getItems()) && Intrinsics3.areEqual(this.paymentGatewayPlanId, subscriptionRenewalMutations.paymentGatewayPlanId);
        }

        @Override // com.discord.models.domain.ModelSubscription2
        public List<SubscriptionItem> getItems() {
            return this.items;
        }

        public final String getPaymentGatewayPlanId() {
            return this.paymentGatewayPlanId;
        }

        public int hashCode() {
            List<SubscriptionItem> items = getItems();
            int iHashCode = (items != null ? items.hashCode() : 0) * 31;
            String str = this.paymentGatewayPlanId;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("SubscriptionRenewalMutations(items=");
            sbU.append(getItems());
            sbU.append(", paymentGatewayPlanId=");
            return outline.J(sbU, this.paymentGatewayPlanId, ")");
        }
    }

    /* JADX INFO: compiled from: ModelSubscription.kt */
    public enum Type {
        PREMIUM,
        GUILD;


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: compiled from: ModelSubscription.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Type from(int typeInt) {
                if (typeInt == 1) {
                    return Type.PREMIUM;
                }
                if (typeInt == 2) {
                    return Type.GUILD;
                }
                throw new IllegalArgumentException(outline.q("unsupported subscription type: ", typeInt));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    public ModelSubscription(String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, SubscriptionRenewalMutations subscriptionRenewalMutations, List<SubscriptionItem> list, String str9, int i, int i2) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(str2, "createdAt");
        Intrinsics3.checkNotNullParameter(str4, "currentPeriodStart");
        Intrinsics3.checkNotNullParameter(str5, "currentPeriodEnd");
        Intrinsics3.checkNotNullParameter(list, "items");
        this.id = str;
        this.createdAt = str2;
        this.canceledAt = str3;
        this.currentPeriodStart = str4;
        this.currentPeriodEnd = str5;
        this.paymentSourceId = str6;
        this.paymentGateway = num;
        this.trialId = str7;
        this.trialEndsAt = str8;
        this.renewalMutations = subscriptionRenewalMutations;
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

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final SubscriptionRenewalMutations getRenewalMutations() {
        return this.renewalMutations;
    }

    public final List<SubscriptionItem> component11() {
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

    public final ModelSubscription copy(String id2, String createdAt, String canceledAt, String currentPeriodStart, String currentPeriodEnd, String paymentSourceId, Integer paymentGateway, String trialId, String trialEndsAt, SubscriptionRenewalMutations renewalMutations, List<SubscriptionItem> items, String paymentGatewayPlanId, int status, int type) {
        Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics3.checkNotNullParameter(currentPeriodStart, "currentPeriodStart");
        Intrinsics3.checkNotNullParameter(currentPeriodEnd, "currentPeriodEnd");
        Intrinsics3.checkNotNullParameter(items, "items");
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
        return Intrinsics3.areEqual(this.id, modelSubscription.id) && Intrinsics3.areEqual(this.createdAt, modelSubscription.createdAt) && Intrinsics3.areEqual(this.canceledAt, modelSubscription.canceledAt) && Intrinsics3.areEqual(this.currentPeriodStart, modelSubscription.currentPeriodStart) && Intrinsics3.areEqual(this.currentPeriodEnd, modelSubscription.currentPeriodEnd) && Intrinsics3.areEqual(this.paymentSourceId, modelSubscription.paymentSourceId) && Intrinsics3.areEqual(this.paymentGateway, modelSubscription.paymentGateway) && Intrinsics3.areEqual(this.trialId, modelSubscription.trialId) && Intrinsics3.areEqual(this.trialEndsAt, modelSubscription.trialEndsAt) && Intrinsics3.areEqual(this.renewalMutations, modelSubscription.renewalMutations) && Intrinsics3.areEqual(getItems(), modelSubscription.getItems()) && Intrinsics3.areEqual(this.paymentGatewayPlanId, modelSubscription.paymentGatewayPlanId) && this.status == modelSubscription.status && this.type == modelSubscription.type;
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

    @Override // com.discord.models.domain.ModelSubscription2
    public List<SubscriptionItem> getItems() {
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
        return SubscriptionPlanType.INSTANCE.from(getPremiumBasePlanId());
    }

    public final SubscriptionRenewalMutations getRenewalMutations() {
        return this.renewalMutations;
    }

    public final Status getStatus() {
        return Status.INSTANCE.from(this.status);
    }

    public final String getTrialEndsAt() {
        return this.trialEndsAt;
    }

    public final String getTrialId() {
        return this.trialId;
    }

    public final Type getType() {
        return Type.INSTANCE.from(this.type);
    }

    public final boolean hasAnyOfPlans(Set<Long> planIds) {
        Intrinsics3.checkNotNullParameter(planIds, "planIds");
        List<SubscriptionItem> items = getItems();
        if ((items instanceof Collection) && items.isEmpty()) {
            return false;
        }
        Iterator<T> it = items.iterator();
        while (it.hasNext()) {
            if (planIds.contains(Long.valueOf(((SubscriptionItem) it.next()).getPlanId()))) {
                return true;
            }
        }
        return false;
    }

    public final boolean hasPlan(long planId) {
        List<SubscriptionItem> items = getItems();
        if (!(items instanceof Collection) || !items.isEmpty()) {
            Iterator<T> it = items.iterator();
            while (it.hasNext()) {
                if (((SubscriptionItem) it.next()).getPlanId() == planId) {
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
        SubscriptionRenewalMutations subscriptionRenewalMutations = this.renewalMutations;
        int iHashCode10 = (iHashCode9 + (subscriptionRenewalMutations != null ? subscriptionRenewalMutations.hashCode() : 0)) * 31;
        List<SubscriptionItem> items = getItems();
        int iHashCode11 = (iHashCode10 + (items != null ? items.hashCode() : 0)) * 31;
        String str9 = this.paymentGatewayPlanId;
        return ((((iHashCode11 + (str9 != null ? str9.hashCode() : 0)) * 31) + this.status) * 31) + this.type;
    }

    public final boolean isAppleSubscription() {
        return PaymentGateway.INSTANCE.from(this.paymentGateway) == PaymentGateway.APPLE;
    }

    public final boolean isGoogleSubscription() {
        return PaymentGateway.INSTANCE.from(this.paymentGateway) == PaymentGateway.GOOGLE;
    }

    public final boolean isMobileManaged() {
        return isAppleSubscription() || isGoogleSubscription();
    }

    public final boolean isNonePlan() {
        return getPlanType() == SubscriptionPlanType.NONE_MONTH || getPlanType() == SubscriptionPlanType.NONE_YEAR || getPlanType() == SubscriptionPlanType.NONE_3_MONTH || getPlanType() == SubscriptionPlanType.NONE_6_MONTH;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelSubscription(id=");
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
        return outline.B(sbU, this.type, ")");
    }
}
