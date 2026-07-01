package com.discord.widgets.guild_role_subscriptions.tier;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.ViewGuildRoleSubscriptionPlanDetailsReviewBinding;
import com.discord.databinding.ViewGuildRoleSubscriptionSectionHeaderItemBinding;
import com.discord.databinding.ViewGuildRoleSubscriptionTierHeaderBinding;
import com.discord.utilities.billing.PremiumUtils2;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionBenefitItemView;
import com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierAdapterItem;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionMemberPreview;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GuildRoleSubscriptionTierViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: compiled from: GuildRoleSubscriptionTierViewHolder.kt */
    public static final /* data */ class BenefitViewHolder extends GuildRoleSubscriptionTierViewHolder {
        private final GuildRoleSubscriptionBenefitItemView view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BenefitViewHolder(GuildRoleSubscriptionBenefitItemView guildRoleSubscriptionBenefitItemView) {
            super(guildRoleSubscriptionBenefitItemView, null);
            Intrinsics3.checkNotNullParameter(guildRoleSubscriptionBenefitItemView, "view");
            this.view = guildRoleSubscriptionBenefitItemView;
            guildRoleSubscriptionBenefitItemView.setPadding(0, 0, 0, 0);
            guildRoleSubscriptionBenefitItemView.setBackground(null);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final GuildRoleSubscriptionBenefitItemView getView() {
            return this.view;
        }

        public static /* synthetic */ BenefitViewHolder copy$default(BenefitViewHolder benefitViewHolder, GuildRoleSubscriptionBenefitItemView guildRoleSubscriptionBenefitItemView, int i, Object obj) {
            if ((i & 1) != 0) {
                guildRoleSubscriptionBenefitItemView = benefitViewHolder.view;
            }
            return benefitViewHolder.copy(guildRoleSubscriptionBenefitItemView);
        }

        @Override // com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierViewHolder
        public void bind(GuildRoleSubscriptionTierAdapterItem item) {
            Intrinsics3.checkNotNullParameter(item, "item");
            if (item instanceof GuildRoleSubscriptionTierAdapterItem.BenefitItem) {
                this.view.configureUI(((GuildRoleSubscriptionTierAdapterItem.BenefitItem) item).getBenefit());
            } else if (item instanceof GuildRoleSubscriptionTierAdapterItem.AllChannelsAccessBenefitItem) {
                GuildRoleSubscriptionBenefitItemView guildRoleSubscriptionBenefitItemView = this.view;
                String string = guildRoleSubscriptionBenefitItemView.getContext().getString(R.string.guild_role_subscription_tier_review_entire_server_access_benefit);
                Intrinsics3.checkNotNullExpressionValue(string, "view.context.getString(R…re_server_access_benefit)");
                guildRoleSubscriptionBenefitItemView.configureUI(string, R.drawable.ic_key_24dp, (String) null);
            }
        }

        public final BenefitViewHolder copy(GuildRoleSubscriptionBenefitItemView view) {
            Intrinsics3.checkNotNullParameter(view, "view");
            return new BenefitViewHolder(view);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof BenefitViewHolder) && Intrinsics3.areEqual(this.view, ((BenefitViewHolder) other).view);
            }
            return true;
        }

        public int hashCode() {
            GuildRoleSubscriptionBenefitItemView guildRoleSubscriptionBenefitItemView = this.view;
            if (guildRoleSubscriptionBenefitItemView != null) {
                return guildRoleSubscriptionBenefitItemView.hashCode();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ViewHolder
        public String toString() {
            StringBuilder sbU = outline.U("BenefitViewHolder(view=");
            sbU.append(this.view);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: GuildRoleSubscriptionTierViewHolder.kt */
    public static final /* data */ class MemberPreviewViewHolder extends GuildRoleSubscriptionTierViewHolder {
        private final GuildRoleSubscriptionMemberPreview memberPreview;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MemberPreviewViewHolder(GuildRoleSubscriptionMemberPreview guildRoleSubscriptionMemberPreview) {
            super(guildRoleSubscriptionMemberPreview, null);
            Intrinsics3.checkNotNullParameter(guildRoleSubscriptionMemberPreview, "memberPreview");
            this.memberPreview = guildRoleSubscriptionMemberPreview;
            guildRoleSubscriptionMemberPreview.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            guildRoleSubscriptionMemberPreview.setBackgroundColor(ColorCompat.getThemedColor(guildRoleSubscriptionMemberPreview, R.attr.colorBackgroundSecondary));
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final GuildRoleSubscriptionMemberPreview getMemberPreview() {
            return this.memberPreview;
        }

        public static /* synthetic */ MemberPreviewViewHolder copy$default(MemberPreviewViewHolder memberPreviewViewHolder, GuildRoleSubscriptionMemberPreview guildRoleSubscriptionMemberPreview, int i, Object obj) {
            if ((i & 1) != 0) {
                guildRoleSubscriptionMemberPreview = memberPreviewViewHolder.memberPreview;
            }
            return memberPreviewViewHolder.copy(guildRoleSubscriptionMemberPreview);
        }

        @Override // com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierViewHolder
        public void bind(GuildRoleSubscriptionTierAdapterItem item) {
            Intrinsics3.checkNotNullParameter(item, "item");
            GuildRoleSubscriptionTierAdapterItem.MemberPreview memberPreview = (GuildRoleSubscriptionTierAdapterItem.MemberPreview) item;
            GuildRoleSubscriptionMemberPreview.setMemberDesign$default(this.memberPreview, memberPreview.getMemberColor(), memberPreview.getMemberIcon(), null, 4, null);
        }

        public final MemberPreviewViewHolder copy(GuildRoleSubscriptionMemberPreview memberPreview) {
            Intrinsics3.checkNotNullParameter(memberPreview, "memberPreview");
            return new MemberPreviewViewHolder(memberPreview);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof MemberPreviewViewHolder) && Intrinsics3.areEqual(this.memberPreview, ((MemberPreviewViewHolder) other).memberPreview);
            }
            return true;
        }

        public int hashCode() {
            GuildRoleSubscriptionMemberPreview guildRoleSubscriptionMemberPreview = this.memberPreview;
            if (guildRoleSubscriptionMemberPreview != null) {
                return guildRoleSubscriptionMemberPreview.hashCode();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ViewHolder
        public String toString() {
            StringBuilder sbU = outline.U("MemberPreviewViewHolder(memberPreview=");
            sbU.append(this.memberPreview);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: GuildRoleSubscriptionTierViewHolder.kt */
    public static final /* data */ class PlanDetailsViewHolder extends GuildRoleSubscriptionTierViewHolder {
        private final ViewGuildRoleSubscriptionPlanDetailsReviewBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public PlanDetailsViewHolder(ViewGuildRoleSubscriptionPlanDetailsReviewBinding viewGuildRoleSubscriptionPlanDetailsReviewBinding) {
            Intrinsics3.checkNotNullParameter(viewGuildRoleSubscriptionPlanDetailsReviewBinding, "binding");
            LinearLayout linearLayout = viewGuildRoleSubscriptionPlanDetailsReviewBinding.a;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
            super(linearLayout, null);
            this.binding = viewGuildRoleSubscriptionPlanDetailsReviewBinding;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final ViewGuildRoleSubscriptionPlanDetailsReviewBinding getBinding() {
            return this.binding;
        }

        public static /* synthetic */ PlanDetailsViewHolder copy$default(PlanDetailsViewHolder planDetailsViewHolder, ViewGuildRoleSubscriptionPlanDetailsReviewBinding viewGuildRoleSubscriptionPlanDetailsReviewBinding, int i, Object obj) {
            if ((i & 1) != 0) {
                viewGuildRoleSubscriptionPlanDetailsReviewBinding = planDetailsViewHolder.binding;
            }
            return planDetailsViewHolder.copy(viewGuildRoleSubscriptionPlanDetailsReviewBinding);
        }

        @Override // com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierViewHolder
        public void bind(GuildRoleSubscriptionTierAdapterItem item) {
            Intrinsics3.checkNotNullParameter(item, "item");
            GuildRoleSubscriptionTierAdapterItem.PlanDetails planDetails = (GuildRoleSubscriptionTierAdapterItem.PlanDetails) item;
            TextView textView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionPlanReviewDescription");
            textView.setText(planDetails.getDescription());
            SimpleDraweeView simpleDraweeView = this.binding.f2196b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildRoleSubscriptionPlanReviewCoverImage");
            MGImages.setImage$default(simpleDraweeView, planDetails.getCoverImage(), 0, 0, false, null, null, 124, null);
        }

        public final PlanDetailsViewHolder copy(ViewGuildRoleSubscriptionPlanDetailsReviewBinding binding) {
            Intrinsics3.checkNotNullParameter(binding, "binding");
            return new PlanDetailsViewHolder(binding);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof PlanDetailsViewHolder) && Intrinsics3.areEqual(this.binding, ((PlanDetailsViewHolder) other).binding);
            }
            return true;
        }

        public int hashCode() {
            ViewGuildRoleSubscriptionPlanDetailsReviewBinding viewGuildRoleSubscriptionPlanDetailsReviewBinding = this.binding;
            if (viewGuildRoleSubscriptionPlanDetailsReviewBinding != null) {
                return viewGuildRoleSubscriptionPlanDetailsReviewBinding.hashCode();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ViewHolder
        public String toString() {
            StringBuilder sbU = outline.U("PlanDetailsViewHolder(binding=");
            sbU.append(this.binding);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: GuildRoleSubscriptionTierViewHolder.kt */
    public static final /* data */ class SectionHeaderViewHolder extends GuildRoleSubscriptionTierViewHolder {
        private final ViewGuildRoleSubscriptionSectionHeaderItemBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public SectionHeaderViewHolder(ViewGuildRoleSubscriptionSectionHeaderItemBinding viewGuildRoleSubscriptionSectionHeaderItemBinding) {
            Intrinsics3.checkNotNullParameter(viewGuildRoleSubscriptionSectionHeaderItemBinding, "binding");
            LinearLayout linearLayout = viewGuildRoleSubscriptionSectionHeaderItemBinding.a;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
            super(linearLayout, null);
            this.binding = viewGuildRoleSubscriptionSectionHeaderItemBinding;
            View view = this.itemView;
            view.setPadding(0, 0, 0, 0);
            view.setBackground(null);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final ViewGuildRoleSubscriptionSectionHeaderItemBinding getBinding() {
            return this.binding;
        }

        public static /* synthetic */ SectionHeaderViewHolder copy$default(SectionHeaderViewHolder sectionHeaderViewHolder, ViewGuildRoleSubscriptionSectionHeaderItemBinding viewGuildRoleSubscriptionSectionHeaderItemBinding, int i, Object obj) {
            if ((i & 1) != 0) {
                viewGuildRoleSubscriptionSectionHeaderItemBinding = sectionHeaderViewHolder.binding;
            }
            return sectionHeaderViewHolder.copy(viewGuildRoleSubscriptionSectionHeaderItemBinding);
        }

        @Override // com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierViewHolder
        public void bind(GuildRoleSubscriptionTierAdapterItem item) {
            CharSequence i18nPluralString;
            Intrinsics3.checkNotNullParameter(item, "item");
            GuildRoleSubscriptionTierAdapterItem.SectionHeader sectionHeader = (GuildRoleSubscriptionTierAdapterItem.SectionHeader) item;
            if (sectionHeader.getTitleResId() != null) {
                View view = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view, "itemView");
                i18nPluralString = view.getContext().getString(sectionHeader.getTitleResId().intValue());
            } else {
                i18nPluralString = (sectionHeader.getTitlePluralResId() == null || sectionHeader.getFormatArgument() == null) ? null : StringResourceUtils.getI18nPluralString(outline.x(this.itemView, "itemView", "itemView.context"), sectionHeader.getTitlePluralResId().intValue(), sectionHeader.getFormatArgument().intValue(), sectionHeader.getFormatArgument());
            }
            TextView textView = this.binding.f2198b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionSectionHeader");
            textView.setText(i18nPluralString);
        }

        public final SectionHeaderViewHolder copy(ViewGuildRoleSubscriptionSectionHeaderItemBinding binding) {
            Intrinsics3.checkNotNullParameter(binding, "binding");
            return new SectionHeaderViewHolder(binding);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof SectionHeaderViewHolder) && Intrinsics3.areEqual(this.binding, ((SectionHeaderViewHolder) other).binding);
            }
            return true;
        }

        public int hashCode() {
            ViewGuildRoleSubscriptionSectionHeaderItemBinding viewGuildRoleSubscriptionSectionHeaderItemBinding = this.binding;
            if (viewGuildRoleSubscriptionSectionHeaderItemBinding != null) {
                return viewGuildRoleSubscriptionSectionHeaderItemBinding.hashCode();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ViewHolder
        public String toString() {
            StringBuilder sbU = outline.U("SectionHeaderViewHolder(binding=");
            sbU.append(this.binding);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: GuildRoleSubscriptionTierViewHolder.kt */
    public static final /* data */ class TierHeaderViewHolder extends GuildRoleSubscriptionTierViewHolder {
        private final ViewGuildRoleSubscriptionTierHeaderBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public TierHeaderViewHolder(ViewGuildRoleSubscriptionTierHeaderBinding viewGuildRoleSubscriptionTierHeaderBinding) {
            Intrinsics3.checkNotNullParameter(viewGuildRoleSubscriptionTierHeaderBinding, "binding");
            LinearLayout linearLayout = viewGuildRoleSubscriptionTierHeaderBinding.a;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
            super(linearLayout, null);
            this.binding = viewGuildRoleSubscriptionTierHeaderBinding;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final ViewGuildRoleSubscriptionTierHeaderBinding getBinding() {
            return this.binding;
        }

        public static /* synthetic */ TierHeaderViewHolder copy$default(TierHeaderViewHolder tierHeaderViewHolder, ViewGuildRoleSubscriptionTierHeaderBinding viewGuildRoleSubscriptionTierHeaderBinding, int i, Object obj) {
            if ((i & 1) != 0) {
                viewGuildRoleSubscriptionTierHeaderBinding = tierHeaderViewHolder.binding;
            }
            return tierHeaderViewHolder.copy(viewGuildRoleSubscriptionTierHeaderBinding);
        }

        @Override // com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierViewHolder
        public void bind(GuildRoleSubscriptionTierAdapterItem item) {
            CharSequence formattedPriceUsd;
            Intrinsics3.checkNotNullParameter(item, "item");
            GuildRoleSubscriptionTierAdapterItem.Header header = (GuildRoleSubscriptionTierAdapterItem.Header) item;
            TextView textView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierHeaderName");
            textView.setText(header.getName());
            TextView textView2 = this.binding.f2199b;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierHeaderDescription");
            textView2.setText(header.getDescription());
            if (header.getPrice() != null) {
                int iIntValue = header.getPrice().intValue();
                View view = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view, "itemView");
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "itemView.context");
                formattedPriceUsd = PremiumUtils2.getFormattedPriceUsd(iIntValue, context);
            } else {
                formattedPriceUsd = null;
            }
            TextView textView3 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildRoleSubscriptionTierHeaderPrice");
            ViewExtensions.setTextAndVisibilityBy(textView3, formattedPriceUsd);
            SimpleDraweeView simpleDraweeView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildRoleSubscriptionTierHeaderImage");
            IconUtils.setIcon$default(simpleDraweeView, header.getImage(), R.dimen.avatar_size_xxlarge, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
        }

        public final TierHeaderViewHolder copy(ViewGuildRoleSubscriptionTierHeaderBinding binding) {
            Intrinsics3.checkNotNullParameter(binding, "binding");
            return new TierHeaderViewHolder(binding);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof TierHeaderViewHolder) && Intrinsics3.areEqual(this.binding, ((TierHeaderViewHolder) other).binding);
            }
            return true;
        }

        public int hashCode() {
            ViewGuildRoleSubscriptionTierHeaderBinding viewGuildRoleSubscriptionTierHeaderBinding = this.binding;
            if (viewGuildRoleSubscriptionTierHeaderBinding != null) {
                return viewGuildRoleSubscriptionTierHeaderBinding.hashCode();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ViewHolder
        public String toString() {
            StringBuilder sbU = outline.U("TierHeaderViewHolder(binding=");
            sbU.append(this.binding);
            sbU.append(")");
            return sbU.toString();
        }
    }

    private GuildRoleSubscriptionTierViewHolder(View view) {
        super(view);
    }

    public abstract void bind(GuildRoleSubscriptionTierAdapterItem item);

    public /* synthetic */ GuildRoleSubscriptionTierViewHolder(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }
}
