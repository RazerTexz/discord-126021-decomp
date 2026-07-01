package com.discord.models.domain.premium;

import androidx.room.RoomDatabase;
import b.d.b.a.outline;
import com.discord.api.premium.PremiumTier;
import com.discord.api.premium.SubscriptionInterval;
import com.discord.models.domain.ModelSubscription;
import d0.t.Iterables2;
import d0.t.Sets5;
import d0.t.SetsJVM;
import d0.t._Collections;
import d0.t._Sets;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'NONE_MONTH' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: SubscriptionPlanType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SubscriptionPlanType {
    private static final /* synthetic */ SubscriptionPlanType[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final Set<SubscriptionPlanType> LEGACY_PLANS;
    public static final SubscriptionPlanType NONE_3_MONTH;
    public static final SubscriptionPlanType NONE_6_MONTH;
    public static final SubscriptionPlanType NONE_MONTH;
    public static final SubscriptionPlanType NONE_YEAR;
    public static final SubscriptionPlanType PREMIUM_3_MONTH_TIER_2;
    public static final SubscriptionPlanType PREMIUM_6_MONTH_TIER_2;
    public static final SubscriptionPlanType PREMIUM_GUILD_3_MONTH;
    public static final SubscriptionPlanType PREMIUM_GUILD_6_MONTH;
    public static final SubscriptionPlanType PREMIUM_GUILD_MONTH;
    private static final Set<SubscriptionPlanType> PREMIUM_GUILD_PLANS;
    public static final SubscriptionPlanType PREMIUM_GUILD_YEAR;
    public static final SubscriptionPlanType PREMIUM_MONTH_LEGACY;
    public static final SubscriptionPlanType PREMIUM_MONTH_TIER_0;
    public static final SubscriptionPlanType PREMIUM_MONTH_TIER_1;
    public static final SubscriptionPlanType PREMIUM_MONTH_TIER_2;
    private static final Set<SubscriptionPlanType> PREMIUM_PLANS;
    public static final SubscriptionPlanType PREMIUM_YEAR_LEGACY;
    public static final SubscriptionPlanType PREMIUM_YEAR_TIER_1;
    public static final SubscriptionPlanType PREMIUM_YEAR_TIER_2;
    private static final Set<SubscriptionPlanType> TIER_0_PLANS;
    private static final Set<SubscriptionPlanType> TIER_1_PLANS;
    private static final Set<SubscriptionPlanType> TIER_2_PLANS;
    private final SubscriptionInterval interval;
    private final int intervalCount;
    private final long planId;
    private final String planTypeString;
    private final PremiumTier premiumTier;
    private final int price;

    /* JADX INFO: compiled from: SubscriptionPlanType.kt */
    public static final class Companion {

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                SubscriptionInterval.values();
                int[] iArr = new int[2];
                $EnumSwitchMapping$0 = iArr;
                iArr[SubscriptionInterval.MONTHLY.ordinal()] = 1;
                iArr[SubscriptionInterval.YEARLY.ordinal()] = 2;
            }
        }

        private Companion() {
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
                    throw new IllegalArgumentException(outline.t("unsupported type plan id: ", planId));
                }
            }
            subscriptionPlanType = null;
            if (subscriptionPlanType != null) {
                return subscriptionPlanType;
            }
            throw new IllegalArgumentException(outline.t("unsupported type plan id: ", planId));
        }

        public final SubscriptionPlanType getBasePlanFromSubscriptionItems(List<ModelSubscription.SubscriptionItem> items, SubscriptionInterval interval, int intervalCount) {
            Object next;
            SubscriptionInterval interval2;
            Intrinsics3.checkNotNullParameter(items, "items");
            Intrinsics3.checkNotNullParameter(interval, "interval");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(items, 10));
            Iterator<T> it = items.iterator();
            while (it.hasNext()) {
                arrayList.add(SubscriptionPlanType.INSTANCE.from(((ModelSubscription.SubscriptionItem) it.next()).getPlanId()));
            }
            SubscriptionPlanType subscriptionPlanType = (SubscriptionPlanType) _Collections.firstOrNull((List) arrayList);
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
            return SubscriptionPlanType.LEGACY_PLANS;
        }

        public final Set<SubscriptionPlanType> getPREMIUM_GUILD_PLANS() {
            return SubscriptionPlanType.PREMIUM_GUILD_PLANS;
        }

        public final Set<SubscriptionPlanType> getPREMIUM_PLANS() {
            return SubscriptionPlanType.PREMIUM_PLANS;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0022 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:12:0x0023  */
        public final SubscriptionPlanType from(String planTypeString) {
            SubscriptionPlanType subscriptionPlanType;
            Intrinsics3.checkNotNullParameter(planTypeString, "planTypeString");
            SubscriptionPlanType[] subscriptionPlanTypeArrValues = SubscriptionPlanType.values();
            for (int i = 0; i < 17; i++) {
                subscriptionPlanType = subscriptionPlanTypeArrValues[i];
                if (Intrinsics3.areEqual(subscriptionPlanType.getPlanTypeString(), planTypeString)) {
                    if (subscriptionPlanType != null) {
                        return subscriptionPlanType;
                    }
                    throw new IllegalArgumentException(outline.w("unsupported planTypeString: ", planTypeString));
                }
            }
            subscriptionPlanType = null;
            if (subscriptionPlanType != null) {
                return subscriptionPlanType;
            }
            throw new IllegalArgumentException(outline.w("unsupported planTypeString: ", planTypeString));
        }
    }

    static {
        SubscriptionInterval subscriptionInterval = SubscriptionInterval.MONTHLY;
        PremiumTier premiumTier = PremiumTier.PREMIUM_GUILD_SUBSCRIPTION_ONLY;
        SubscriptionPlanType subscriptionPlanType = new SubscriptionPlanType("NONE_MONTH", 0, 0, subscriptionInterval, 1, "none_month", 628379151761408000L, premiumTier);
        NONE_MONTH = subscriptionPlanType;
        SubscriptionPlanType subscriptionPlanType2 = new SubscriptionPlanType("NONE_3_MONTH", 1, 0, subscriptionInterval, 3, "none_3_month", 944265614527037440L, premiumTier);
        NONE_3_MONTH = subscriptionPlanType2;
        SubscriptionPlanType subscriptionPlanType3 = new SubscriptionPlanType("NONE_6_MONTH", 2, 0, subscriptionInterval, 6, "none_6_month", 944265636643602432L, premiumTier);
        NONE_6_MONTH = subscriptionPlanType3;
        SubscriptionInterval subscriptionInterval2 = SubscriptionInterval.YEARLY;
        SubscriptionPlanType subscriptionPlanType4 = new SubscriptionPlanType("NONE_YEAR", 3, 0, subscriptionInterval2, 1, "none_year", 628381571568631808L, premiumTier);
        NONE_YEAR = subscriptionPlanType4;
        PremiumTier premiumTier2 = PremiumTier.TIER_2;
        SubscriptionPlanType subscriptionPlanType5 = new SubscriptionPlanType("PREMIUM_MONTH_LEGACY", 4, 499, subscriptionInterval, 1, "premium_month", 511651856145973248L, premiumTier2);
        PREMIUM_MONTH_LEGACY = subscriptionPlanType5;
        SubscriptionPlanType subscriptionPlanType6 = new SubscriptionPlanType("PREMIUM_YEAR_LEGACY", 5, 4999, subscriptionInterval2, 1, "premium_year", 511651860671627264L, premiumTier2);
        PREMIUM_YEAR_LEGACY = subscriptionPlanType6;
        PremiumTier premiumTier3 = PremiumTier.TIER_1;
        SubscriptionPlanType subscriptionPlanType7 = new SubscriptionPlanType("PREMIUM_MONTH_TIER_1", 6, 499, subscriptionInterval, 1, "premium_month_tier_1", 511651871736201216L, premiumTier3);
        PREMIUM_MONTH_TIER_1 = subscriptionPlanType7;
        SubscriptionPlanType subscriptionPlanType8 = new SubscriptionPlanType("PREMIUM_YEAR_TIER_1", 7, 4999, subscriptionInterval2, 1, "premium_year_tier_1", 511651876987469824L, premiumTier3);
        PREMIUM_YEAR_TIER_1 = subscriptionPlanType8;
        SubscriptionPlanType subscriptionPlanType9 = new SubscriptionPlanType("PREMIUM_MONTH_TIER_2", 8, RoomDatabase.MAX_BIND_PARAMETER_CNT, subscriptionInterval, 1, "premium_month_tier_2", 511651880837840896L, premiumTier2);
        PREMIUM_MONTH_TIER_2 = subscriptionPlanType9;
        SubscriptionPlanType subscriptionPlanType10 = new SubscriptionPlanType("PREMIUM_3_MONTH_TIER_2", 9, 2849, subscriptionInterval, 3, "premium_3_month_tier_2", 642251038925127690L, premiumTier2);
        PREMIUM_3_MONTH_TIER_2 = subscriptionPlanType10;
        SubscriptionPlanType subscriptionPlanType11 = new SubscriptionPlanType("PREMIUM_6_MONTH_TIER_2", 10, 5499, subscriptionInterval, 6, "premium_6_month_tier_2", 944037208325619722L, premiumTier2);
        PREMIUM_6_MONTH_TIER_2 = subscriptionPlanType11;
        SubscriptionPlanType subscriptionPlanType12 = new SubscriptionPlanType("PREMIUM_YEAR_TIER_2", 11, 9999, subscriptionInterval2, 1, "premium_year_tier_2", 511651885459963904L, premiumTier2);
        PREMIUM_YEAR_TIER_2 = subscriptionPlanType12;
        SubscriptionPlanType subscriptionPlanType13 = new SubscriptionPlanType("PREMIUM_MONTH_TIER_0", 12, 299, subscriptionInterval, 1, "premium_month_tier_0", 978380692553465866L, PremiumTier.TIER_0);
        PREMIUM_MONTH_TIER_0 = subscriptionPlanType13;
        SubscriptionPlanType subscriptionPlanType14 = new SubscriptionPlanType("PREMIUM_GUILD_MONTH", 13, 499, subscriptionInterval, 1, null, 590665532894740483L, null);
        PREMIUM_GUILD_MONTH = subscriptionPlanType14;
        SubscriptionPlanType subscriptionPlanType15 = new SubscriptionPlanType("PREMIUM_GUILD_3_MONTH", 14, 1427, subscriptionInterval, 3, null, 944037355453415424L, null);
        PREMIUM_GUILD_3_MONTH = subscriptionPlanType15;
        SubscriptionPlanType subscriptionPlanType16 = new SubscriptionPlanType("PREMIUM_GUILD_6_MONTH", 15, 2750, subscriptionInterval, 6, null, 944037391444738048L, null);
        PREMIUM_GUILD_6_MONTH = subscriptionPlanType16;
        SubscriptionPlanType subscriptionPlanType17 = new SubscriptionPlanType("PREMIUM_GUILD_YEAR", 16, 4999, subscriptionInterval2, 1, null, 590665538238152709L, null);
        PREMIUM_GUILD_YEAR = subscriptionPlanType17;
        $VALUES = new SubscriptionPlanType[]{subscriptionPlanType, subscriptionPlanType2, subscriptionPlanType3, subscriptionPlanType4, subscriptionPlanType5, subscriptionPlanType6, subscriptionPlanType7, subscriptionPlanType8, subscriptionPlanType9, subscriptionPlanType10, subscriptionPlanType11, subscriptionPlanType12, subscriptionPlanType13, subscriptionPlanType14, subscriptionPlanType15, subscriptionPlanType16, subscriptionPlanType17};
        INSTANCE = new Companion(null);
        Set<SubscriptionPlanType> of = SetsJVM.setOf(subscriptionPlanType13);
        TIER_0_PLANS = of;
        Set<SubscriptionPlanType> of2 = Sets5.setOf((Object[]) new SubscriptionPlanType[]{subscriptionPlanType8, subscriptionPlanType7});
        TIER_1_PLANS = of2;
        Set<SubscriptionPlanType> of3 = Sets5.setOf((Object[]) new SubscriptionPlanType[]{subscriptionPlanType6, subscriptionPlanType5});
        LEGACY_PLANS = of3;
        Set<SubscriptionPlanType> setPlus = _Sets.plus(Sets5.setOf((Object[]) new SubscriptionPlanType[]{subscriptionPlanType9, subscriptionPlanType10, subscriptionPlanType11, subscriptionPlanType12}), (Iterable) of3);
        TIER_2_PLANS = setPlus;
        PREMIUM_PLANS = _Sets.plus(_Sets.plus((Set) of, (Iterable) of2), (Iterable) setPlus);
        PREMIUM_GUILD_PLANS = Sets5.setOf((Object[]) new SubscriptionPlanType[]{subscriptionPlanType14, subscriptionPlanType10, subscriptionPlanType11, subscriptionPlanType17});
    }

    private SubscriptionPlanType(String str, int i, int i2, SubscriptionInterval subscriptionInterval, int i3, String str2, long j, PremiumTier premiumTier) {
        super(str, i);
        this.price = i2;
        this.interval = subscriptionInterval;
        this.intervalCount = i3;
        this.planTypeString = str2;
        this.planId = j;
        this.premiumTier = premiumTier;
    }

    public static SubscriptionPlanType valueOf(String str) {
        return (SubscriptionPlanType) Enum.valueOf(SubscriptionPlanType.class, str);
    }

    public static SubscriptionPlanType[] values() {
        return (SubscriptionPlanType[]) $VALUES.clone();
    }

    public final SubscriptionInterval getInterval() {
        return this.interval;
    }

    public final int getIntervalCount() {
        return this.intervalCount;
    }

    public final long getPlanId() {
        return this.planId;
    }

    public final String getPlanTypeString() {
        return this.planTypeString;
    }

    public final PremiumTier getPremiumTier() {
        return this.premiumTier;
    }

    public final int getPrice() {
        return this.price;
    }

    public final boolean isGrandfathered() {
        return LEGACY_PLANS.contains(this);
    }

    public final boolean isMonthlyInterval() {
        return this.interval == SubscriptionInterval.MONTHLY;
    }

    public final boolean isPremiumSubscription() {
        return PREMIUM_PLANS.contains(this);
    }
}
