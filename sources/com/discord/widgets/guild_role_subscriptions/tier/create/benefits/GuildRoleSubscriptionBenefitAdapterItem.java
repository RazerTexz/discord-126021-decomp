package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.recycler.DiffKeyProvider;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildRoleSubscriptionBenefitAdapterItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GuildRoleSubscriptionBenefitAdapterItem implements DiffKeyProvider {

    /* JADX INFO: compiled from: GuildRoleSubscriptionBenefitAdapterItem.kt */
    public static final /* data */ class AddBenefitItem extends GuildRoleSubscriptionBenefitAdapterItem {
        private final long guildId;
        private final String key;
        private final String tierName;
        private final GuildRoleSubscriptionBenefitType type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddBenefitItem(GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType, long j, String str) {
            super(null);
            Intrinsics3.checkNotNullParameter(guildRoleSubscriptionBenefitType, "type");
            this.type = guildRoleSubscriptionBenefitType;
            this.guildId = j;
            this.tierName = str;
            this.key = "AddBenefitItem" + guildRoleSubscriptionBenefitType;
        }

        public static /* synthetic */ AddBenefitItem copy$default(AddBenefitItem addBenefitItem, GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType, long j, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                guildRoleSubscriptionBenefitType = addBenefitItem.type;
            }
            if ((i & 2) != 0) {
                j = addBenefitItem.guildId;
            }
            if ((i & 4) != 0) {
                str = addBenefitItem.tierName;
            }
            return addBenefitItem.copy(guildRoleSubscriptionBenefitType, j, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final GuildRoleSubscriptionBenefitType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTierName() {
            return this.tierName;
        }

        public final AddBenefitItem copy(GuildRoleSubscriptionBenefitType type, long guildId, String tierName) {
            Intrinsics3.checkNotNullParameter(type, "type");
            return new AddBenefitItem(type, guildId, tierName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddBenefitItem)) {
                return false;
            }
            AddBenefitItem addBenefitItem = (AddBenefitItem) other;
            return Intrinsics3.areEqual(this.type, addBenefitItem.type) && this.guildId == addBenefitItem.guildId && Intrinsics3.areEqual(this.tierName, addBenefitItem.tierName);
        }

        public final long getGuildId() {
            return this.guildId;
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final String getTierName() {
            return this.tierName;
        }

        public final GuildRoleSubscriptionBenefitType getType() {
            return this.type;
        }

        public int hashCode() {
            GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType = this.type;
            int iA = (b.a(this.guildId) + ((guildRoleSubscriptionBenefitType != null ? guildRoleSubscriptionBenefitType.hashCode() : 0) * 31)) * 31;
            String str = this.tierName;
            return iA + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("AddBenefitItem(type=");
            sbU.append(this.type);
            sbU.append(", guildId=");
            sbU.append(this.guildId);
            sbU.append(", tierName=");
            return outline.J(sbU, this.tierName, ")");
        }
    }

    /* JADX INFO: compiled from: GuildRoleSubscriptionBenefitAdapterItem.kt */
    public static final /* data */ class BenefitItem extends GuildRoleSubscriptionBenefitAdapterItem {
        private final Benefit benefit;
        private final long guildId;
        private final String key;
        private final String tierName;
        private final GuildRoleSubscriptionBenefitType type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BenefitItem(GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType, Benefit benefit, long j, String str) {
            super(null);
            Intrinsics3.checkNotNullParameter(guildRoleSubscriptionBenefitType, "type");
            Intrinsics3.checkNotNullParameter(benefit, "benefit");
            this.type = guildRoleSubscriptionBenefitType;
            this.benefit = benefit;
            this.guildId = j;
            this.tierName = str;
            this.key = String.valueOf(benefit.hashCode());
        }

        public static /* synthetic */ BenefitItem copy$default(BenefitItem benefitItem, GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType, Benefit benefit, long j, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                guildRoleSubscriptionBenefitType = benefitItem.type;
            }
            if ((i & 2) != 0) {
                benefit = benefitItem.benefit;
            }
            Benefit benefit2 = benefit;
            if ((i & 4) != 0) {
                j = benefitItem.guildId;
            }
            long j2 = j;
            if ((i & 8) != 0) {
                str = benefitItem.tierName;
            }
            return benefitItem.copy(guildRoleSubscriptionBenefitType, benefit2, j2, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final GuildRoleSubscriptionBenefitType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Benefit getBenefit() {
            return this.benefit;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getTierName() {
            return this.tierName;
        }

        public final BenefitItem copy(GuildRoleSubscriptionBenefitType type, Benefit benefit, long guildId, String tierName) {
            Intrinsics3.checkNotNullParameter(type, "type");
            Intrinsics3.checkNotNullParameter(benefit, "benefit");
            return new BenefitItem(type, benefit, guildId, tierName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BenefitItem)) {
                return false;
            }
            BenefitItem benefitItem = (BenefitItem) other;
            return Intrinsics3.areEqual(this.type, benefitItem.type) && Intrinsics3.areEqual(this.benefit, benefitItem.benefit) && this.guildId == benefitItem.guildId && Intrinsics3.areEqual(this.tierName, benefitItem.tierName);
        }

        public final Benefit getBenefit() {
            return this.benefit;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final String getTierName() {
            return this.tierName;
        }

        public final GuildRoleSubscriptionBenefitType getType() {
            return this.type;
        }

        public int hashCode() {
            GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType = this.type;
            int iHashCode = (guildRoleSubscriptionBenefitType != null ? guildRoleSubscriptionBenefitType.hashCode() : 0) * 31;
            Benefit benefit = this.benefit;
            int iA = (b.a(this.guildId) + ((iHashCode + (benefit != null ? benefit.hashCode() : 0)) * 31)) * 31;
            String str = this.tierName;
            return iA + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("BenefitItem(type=");
            sbU.append(this.type);
            sbU.append(", benefit=");
            sbU.append(this.benefit);
            sbU.append(", guildId=");
            sbU.append(this.guildId);
            sbU.append(", tierName=");
            return outline.J(sbU, this.tierName, ")");
        }
    }

    /* JADX INFO: compiled from: GuildRoleSubscriptionBenefitAdapterItem.kt */
    public static final /* data */ class FreeTrialItem extends GuildRoleSubscriptionBenefitAdapterItem {
        private final Integer activeTrialUserLimit;
        private final boolean isFreeTrialEnabled;
        private final String key;
        private final SubscriptionTrialInterval trialInterval;

        public FreeTrialItem(boolean z2, SubscriptionTrialInterval subscriptionTrialInterval, Integer num) {
            super(null);
            this.isFreeTrialEnabled = z2;
            this.trialInterval = subscriptionTrialInterval;
            this.activeTrialUserLimit = num;
            this.key = "FreeTrialItem";
        }

        public static /* synthetic */ FreeTrialItem copy$default(FreeTrialItem freeTrialItem, boolean z2, SubscriptionTrialInterval subscriptionTrialInterval, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = freeTrialItem.isFreeTrialEnabled;
            }
            if ((i & 2) != 0) {
                subscriptionTrialInterval = freeTrialItem.trialInterval;
            }
            if ((i & 4) != 0) {
                num = freeTrialItem.activeTrialUserLimit;
            }
            return freeTrialItem.copy(z2, subscriptionTrialInterval, num);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsFreeTrialEnabled() {
            return this.isFreeTrialEnabled;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final SubscriptionTrialInterval getTrialInterval() {
            return this.trialInterval;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getActiveTrialUserLimit() {
            return this.activeTrialUserLimit;
        }

        public final FreeTrialItem copy(boolean isFreeTrialEnabled, SubscriptionTrialInterval trialInterval, Integer activeTrialUserLimit) {
            return new FreeTrialItem(isFreeTrialEnabled, trialInterval, activeTrialUserLimit);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FreeTrialItem)) {
                return false;
            }
            FreeTrialItem freeTrialItem = (FreeTrialItem) other;
            return this.isFreeTrialEnabled == freeTrialItem.isFreeTrialEnabled && Intrinsics3.areEqual(this.trialInterval, freeTrialItem.trialInterval) && Intrinsics3.areEqual(this.activeTrialUserLimit, freeTrialItem.activeTrialUserLimit);
        }

        public final Integer getActiveTrialUserLimit() {
            return this.activeTrialUserLimit;
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final SubscriptionTrialInterval getTrialInterval() {
            return this.trialInterval;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z2 = this.isFreeTrialEnabled;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            SubscriptionTrialInterval subscriptionTrialInterval = this.trialInterval;
            int iHashCode = (i + (subscriptionTrialInterval != null ? subscriptionTrialInterval.hashCode() : 0)) * 31;
            Integer num = this.activeTrialUserLimit;
            return iHashCode + (num != null ? num.hashCode() : 0);
        }

        public final boolean isFreeTrialEnabled() {
            return this.isFreeTrialEnabled;
        }

        public String toString() {
            StringBuilder sbU = outline.U("FreeTrialItem(isFreeTrialEnabled=");
            sbU.append(this.isFreeTrialEnabled);
            sbU.append(", trialInterval=");
            sbU.append(this.trialInterval);
            sbU.append(", activeTrialUserLimit=");
            return outline.F(sbU, this.activeTrialUserLimit, ")");
        }
    }

    /* JADX INFO: compiled from: GuildRoleSubscriptionBenefitAdapterItem.kt */
    public static final /* data */ class Header extends GuildRoleSubscriptionBenefitAdapterItem {
        private final String key;
        private final GuildRoleSubscriptionBenefitType type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Header(GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType) {
            super(null);
            Intrinsics3.checkNotNullParameter(guildRoleSubscriptionBenefitType, "type");
            this.type = guildRoleSubscriptionBenefitType;
            this.key = "BenefitHeader" + guildRoleSubscriptionBenefitType;
        }

        public static /* synthetic */ Header copy$default(Header header, GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType, int i, Object obj) {
            if ((i & 1) != 0) {
                guildRoleSubscriptionBenefitType = header.type;
            }
            return header.copy(guildRoleSubscriptionBenefitType);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final GuildRoleSubscriptionBenefitType getType() {
            return this.type;
        }

        public final Header copy(GuildRoleSubscriptionBenefitType type) {
            Intrinsics3.checkNotNullParameter(type, "type");
            return new Header(type);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Header) && Intrinsics3.areEqual(this.type, ((Header) other).type);
            }
            return true;
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final GuildRoleSubscriptionBenefitType getType() {
            return this.type;
        }

        public int hashCode() {
            GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType = this.type;
            if (guildRoleSubscriptionBenefitType != null) {
                return guildRoleSubscriptionBenefitType.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Header(type=");
            sbU.append(this.type);
            sbU.append(")");
            return sbU.toString();
        }
    }

    private GuildRoleSubscriptionBenefitAdapterItem() {
    }

    public /* synthetic */ GuildRoleSubscriptionBenefitAdapterItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
