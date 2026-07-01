package com.discord.widgets.guild_role_subscriptions.tier;

import androidx.annotation.ColorInt;
import androidx.annotation.PluralsRes;
import androidx.annotation.StringRes;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.recycler.DiffKeyProvider;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierAdapterItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GuildRoleSubscriptionTierAdapterItem implements DiffKeyProvider {

    /* JADX INFO: compiled from: GuildRoleSubscriptionTierAdapterItem.kt */
    public static final class AllChannelsAccessBenefitItem extends GuildRoleSubscriptionTierAdapterItem {
        public static final AllChannelsAccessBenefitItem INSTANCE = new AllChannelsAccessBenefitItem();
        private static final String key = "allChannelsAccessBenefitItem";

        private AllChannelsAccessBenefitItem() {
            super(null);
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return key;
        }
    }

    /* JADX INFO: compiled from: GuildRoleSubscriptionTierAdapterItem.kt */
    public static final /* data */ class BenefitItem extends GuildRoleSubscriptionTierAdapterItem {
        private final Benefit benefit;
        private final int index;
        private final String key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BenefitItem(int i, Benefit benefit) {
            super(null);
            Intrinsics3.checkNotNullParameter(benefit, "benefit");
            this.index = i;
            this.benefit = benefit;
            this.key = String.valueOf(i);
        }

        public static /* synthetic */ BenefitItem copy$default(BenefitItem benefitItem, int i, Benefit benefit, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = benefitItem.index;
            }
            if ((i2 & 2) != 0) {
                benefit = benefitItem.benefit;
            }
            return benefitItem.copy(i, benefit);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Benefit getBenefit() {
            return this.benefit;
        }

        public final BenefitItem copy(int index, Benefit benefit) {
            Intrinsics3.checkNotNullParameter(benefit, "benefit");
            return new BenefitItem(index, benefit);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BenefitItem)) {
                return false;
            }
            BenefitItem benefitItem = (BenefitItem) other;
            return this.index == benefitItem.index && Intrinsics3.areEqual(this.benefit, benefitItem.benefit);
        }

        public final Benefit getBenefit() {
            return this.benefit;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public int hashCode() {
            int i = this.index * 31;
            Benefit benefit = this.benefit;
            return i + (benefit != null ? benefit.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("BenefitItem(index=");
            sbU.append(this.index);
            sbU.append(", benefit=");
            sbU.append(this.benefit);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: GuildRoleSubscriptionTierAdapterItem.kt */
    public static final /* data */ class Header extends GuildRoleSubscriptionTierAdapterItem {
        private final String description;
        private final String image;
        private final String key;
        private final String name;
        private final Integer price;
        private final Long skuId;

        public /* synthetic */ Header(String str, Integer num, Long l, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, num, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3);
        }

        public static /* synthetic */ Header copy$default(Header header, String str, Integer num, Long l, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = header.name;
            }
            if ((i & 2) != 0) {
                num = header.price;
            }
            Integer num2 = num;
            if ((i & 4) != 0) {
                l = header.skuId;
            }
            Long l2 = l;
            if ((i & 8) != 0) {
                str2 = header.image;
            }
            String str4 = str2;
            if ((i & 16) != 0) {
                str3 = header.description;
            }
            return header.copy(str, num2, l2, str4, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getPrice() {
            return this.price;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Long getSkuId() {
            return this.skuId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getImage() {
            return this.image;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        public final Header copy(String name, Integer price, Long skuId, String image, String description) {
            return new Header(name, price, skuId, image, description);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Header)) {
                return false;
            }
            Header header = (Header) other;
            return Intrinsics3.areEqual(this.name, header.name) && Intrinsics3.areEqual(this.price, header.price) && Intrinsics3.areEqual(this.skuId, header.skuId) && Intrinsics3.areEqual(this.image, header.image) && Intrinsics3.areEqual(this.description, header.description);
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getImage() {
            return this.image;
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final String getName() {
            return this.name;
        }

        public final Integer getPrice() {
            return this.price;
        }

        public final Long getSkuId() {
            return this.skuId;
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            Integer num = this.price;
            int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 31;
            Long l = this.skuId;
            int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
            String str2 = this.image;
            int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.description;
            return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Header(name=");
            sbU.append(this.name);
            sbU.append(", price=");
            sbU.append(this.price);
            sbU.append(", skuId=");
            sbU.append(this.skuId);
            sbU.append(", image=");
            sbU.append(this.image);
            sbU.append(", description=");
            return outline.J(sbU, this.description, ")");
        }

        public Header(String str, Integer num, Long l, String str2, String str3) {
            super(null);
            this.name = str;
            this.price = num;
            this.skuId = l;
            this.image = str2;
            this.description = str3;
            this.key = outline.w("header:", str);
        }
    }

    /* JADX INFO: compiled from: GuildRoleSubscriptionTierAdapterItem.kt */
    public static final /* data */ class MemberPreview extends GuildRoleSubscriptionTierAdapterItem {
        private final String key;
        private final Integer memberColor;
        private final String memberIcon;

        public /* synthetic */ MemberPreview(Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(num, (i & 2) != 0 ? null : str);
        }

        public static /* synthetic */ MemberPreview copy$default(MemberPreview memberPreview, Integer num, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                num = memberPreview.memberColor;
            }
            if ((i & 2) != 0) {
                str = memberPreview.memberIcon;
            }
            return memberPreview.copy(num, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getMemberColor() {
            return this.memberColor;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMemberIcon() {
            return this.memberIcon;
        }

        public final MemberPreview copy(@ColorInt Integer memberColor, String memberIcon) {
            return new MemberPreview(memberColor, memberIcon);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MemberPreview)) {
                return false;
            }
            MemberPreview memberPreview = (MemberPreview) other;
            return Intrinsics3.areEqual(this.memberColor, memberPreview.memberColor) && Intrinsics3.areEqual(this.memberIcon, memberPreview.memberIcon);
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final Integer getMemberColor() {
            return this.memberColor;
        }

        public final String getMemberIcon() {
            return this.memberIcon;
        }

        public int hashCode() {
            Integer num = this.memberColor;
            int iHashCode = (num != null ? num.hashCode() : 0) * 31;
            String str = this.memberIcon;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("MemberPreview(memberColor=");
            sbU.append(this.memberColor);
            sbU.append(", memberIcon=");
            return outline.J(sbU, this.memberIcon, ")");
        }

        public MemberPreview(@ColorInt Integer num, String str) {
            super(null);
            this.memberColor = num;
            this.memberIcon = str;
            this.key = "member:" + num;
        }
    }

    /* JADX INFO: compiled from: GuildRoleSubscriptionTierAdapterItem.kt */
    public static final /* data */ class PlanDetails extends GuildRoleSubscriptionTierAdapterItem {
        private final String coverImage;
        private final String description;
        private final String key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PlanDetails(String str, String str2) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
            Intrinsics3.checkNotNullParameter(str2, "coverImage");
            this.description = str;
            this.coverImage = str2;
            this.key = "planDetails";
        }

        public static /* synthetic */ PlanDetails copy$default(PlanDetails planDetails, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = planDetails.description;
            }
            if ((i & 2) != 0) {
                str2 = planDetails.coverImage;
            }
            return planDetails.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCoverImage() {
            return this.coverImage;
        }

        public final PlanDetails copy(String description, String coverImage) {
            Intrinsics3.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
            Intrinsics3.checkNotNullParameter(coverImage, "coverImage");
            return new PlanDetails(description, coverImage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PlanDetails)) {
                return false;
            }
            PlanDetails planDetails = (PlanDetails) other;
            return Intrinsics3.areEqual(this.description, planDetails.description) && Intrinsics3.areEqual(this.coverImage, planDetails.coverImage);
        }

        public final String getCoverImage() {
            return this.coverImage;
        }

        public final String getDescription() {
            return this.description;
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public int hashCode() {
            String str = this.description;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.coverImage;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("PlanDetails(description=");
            sbU.append(this.description);
            sbU.append(", coverImage=");
            return outline.J(sbU, this.coverImage, ")");
        }
    }

    /* JADX INFO: compiled from: GuildRoleSubscriptionTierAdapterItem.kt */
    public static final /* data */ class SectionHeader extends GuildRoleSubscriptionTierAdapterItem {
        private final Integer formatArgument;
        private final String key;
        private final Integer titlePluralResId;
        private final Integer titleResId;

        public SectionHeader(@StringRes Integer num, @PluralsRes Integer num2, Integer num3) {
            super(null);
            this.titleResId = num;
            this.titlePluralResId = num2;
            this.formatArgument = num3;
            StringBuilder sb = new StringBuilder();
            sb.append(num2);
            sb.append(num);
            this.key = sb.toString();
        }

        public static /* synthetic */ SectionHeader copy$default(SectionHeader sectionHeader, Integer num, Integer num2, Integer num3, int i, Object obj) {
            if ((i & 1) != 0) {
                num = sectionHeader.titleResId;
            }
            if ((i & 2) != 0) {
                num2 = sectionHeader.titlePluralResId;
            }
            if ((i & 4) != 0) {
                num3 = sectionHeader.formatArgument;
            }
            return sectionHeader.copy(num, num2, num3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getTitleResId() {
            return this.titleResId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getTitlePluralResId() {
            return this.titlePluralResId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getFormatArgument() {
            return this.formatArgument;
        }

        public final SectionHeader copy(@StringRes Integer titleResId, @PluralsRes Integer titlePluralResId, Integer formatArgument) {
            return new SectionHeader(titleResId, titlePluralResId, formatArgument);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SectionHeader)) {
                return false;
            }
            SectionHeader sectionHeader = (SectionHeader) other;
            return Intrinsics3.areEqual(this.titleResId, sectionHeader.titleResId) && Intrinsics3.areEqual(this.titlePluralResId, sectionHeader.titlePluralResId) && Intrinsics3.areEqual(this.formatArgument, sectionHeader.formatArgument);
        }

        public final Integer getFormatArgument() {
            return this.formatArgument;
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final Integer getTitlePluralResId() {
            return this.titlePluralResId;
        }

        public final Integer getTitleResId() {
            return this.titleResId;
        }

        public int hashCode() {
            Integer num = this.titleResId;
            int iHashCode = (num != null ? num.hashCode() : 0) * 31;
            Integer num2 = this.titlePluralResId;
            int iHashCode2 = (iHashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
            Integer num3 = this.formatArgument;
            return iHashCode2 + (num3 != null ? num3.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("SectionHeader(titleResId=");
            sbU.append(this.titleResId);
            sbU.append(", titlePluralResId=");
            sbU.append(this.titlePluralResId);
            sbU.append(", formatArgument=");
            return outline.F(sbU, this.formatArgument, ")");
        }
    }

    private GuildRoleSubscriptionTierAdapterItem() {
    }

    public /* synthetic */ GuildRoleSubscriptionTierAdapterItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
