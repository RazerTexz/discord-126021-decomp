package com.discord.widgets.guild_role_subscriptions.tier;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.ViewGuildRoleSubscriptionPlanDetailsReviewBinding;
import com.discord.databinding.ViewGuildRoleSubscriptionSectionHeaderItemBinding;
import com.discord.databinding.ViewGuildRoleSubscriptionTierHeaderBinding;
import com.discord.utilities.billing.PremiumUtilsKt;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionBenefitItemView;
import com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierAdapterItem;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionMemberPreview;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GuildRoleSubscriptionTierViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: compiled from: GuildRoleSubscriptionTierViewHolder.kt */
    public static final /* data */ class BenefitViewHolder extends GuildRoleSubscriptionTierViewHolder {
        private final GuildRoleSubscriptionBenefitItemView view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BenefitViewHolder(GuildRoleSubscriptionBenefitItemView guildRoleSubscriptionBenefitItemView) {
            super(guildRoleSubscriptionBenefitItemView, null);
            C12238m.checkNotNullParameter(guildRoleSubscriptionBenefitItemView, "view");
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
            C12238m.checkNotNullParameter(item, "item");
            if (item instanceof GuildRoleSubscriptionTierAdapterItem.BenefitItem) {
                this.view.configureUI(((GuildRoleSubscriptionTierAdapterItem.BenefitItem) item).getBenefit());
            } else if (item instanceof GuildRoleSubscriptionTierAdapterItem.AllChannelsAccessBenefitItem) {
                GuildRoleSubscriptionBenefitItemView guildRoleSubscriptionBenefitItemView = this.view;
                String string = guildRoleSubscriptionBenefitItemView.getContext().getString(C5419R.string.guild_role_subscription_tier_review_entire_server_access_benefit);
                C12238m.checkNotNullExpressionValue(string, "view.context.getString(R…re_server_access_benefit)");
                guildRoleSubscriptionBenefitItemView.configureUI(string, C5419R.drawable.ic_key_24dp, (String) null);
            }
        }

        public final BenefitViewHolder copy(GuildRoleSubscriptionBenefitItemView view) {
            C12238m.checkNotNullParameter(view, "view");
            return new BenefitViewHolder(view);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof BenefitViewHolder) && C12238m.areEqual(this.view, ((BenefitViewHolder) other).view);
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
            StringBuilder sbM833U = C1643a.m833U("BenefitViewHolder(view=");
            sbM833U.append(this.view);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: GuildRoleSubscriptionTierViewHolder.kt */
    public static final /* data */ class MemberPreviewViewHolder extends GuildRoleSubscriptionTierViewHolder {
        private final GuildRoleSubscriptionMemberPreview memberPreview;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MemberPreviewViewHolder(GuildRoleSubscriptionMemberPreview guildRoleSubscriptionMemberPreview) {
            super(guildRoleSubscriptionMemberPreview, null);
            C12238m.checkNotNullParameter(guildRoleSubscriptionMemberPreview, "memberPreview");
            this.memberPreview = guildRoleSubscriptionMemberPreview;
            guildRoleSubscriptionMemberPreview.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            guildRoleSubscriptionMemberPreview.setBackgroundColor(ColorCompat.getThemedColor(guildRoleSubscriptionMemberPreview, C5419R.attr.colorBackgroundSecondary));
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
            C12238m.checkNotNullParameter(item, "item");
            GuildRoleSubscriptionTierAdapterItem.MemberPreview memberPreview = (GuildRoleSubscriptionTierAdapterItem.MemberPreview) item;
            GuildRoleSubscriptionMemberPreview.setMemberDesign$default(this.memberPreview, memberPreview.getMemberColor(), memberPreview.getMemberIcon(), null, 4, null);
        }

        public final MemberPreviewViewHolder copy(GuildRoleSubscriptionMemberPreview memberPreview) {
            C12238m.checkNotNullParameter(memberPreview, "memberPreview");
            return new MemberPreviewViewHolder(memberPreview);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof MemberPreviewViewHolder) && C12238m.areEqual(this.memberPreview, ((MemberPreviewViewHolder) other).memberPreview);
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
            StringBuilder sbM833U = C1643a.m833U("MemberPreviewViewHolder(memberPreview=");
            sbM833U.append(this.memberPreview);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: GuildRoleSubscriptionTierViewHolder.kt */
    public static final /* data */ class PlanDetailsViewHolder extends GuildRoleSubscriptionTierViewHolder {
        private final ViewGuildRoleSubscriptionPlanDetailsReviewBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public PlanDetailsViewHolder(ViewGuildRoleSubscriptionPlanDetailsReviewBinding viewGuildRoleSubscriptionPlanDetailsReviewBinding) {
            C12238m.checkNotNullParameter(viewGuildRoleSubscriptionPlanDetailsReviewBinding, "binding");
            LinearLayout linearLayout = viewGuildRoleSubscriptionPlanDetailsReviewBinding.f15483a;
            C12238m.checkNotNullExpressionValue(linearLayout, "binding.root");
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
            C12238m.checkNotNullParameter(item, "item");
            GuildRoleSubscriptionTierAdapterItem.PlanDetails planDetails = (GuildRoleSubscriptionTierAdapterItem.PlanDetails) item;
            TextView textView = this.binding.f15485c;
            C12238m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionPlanReviewDescription");
            textView.setText(planDetails.getDescription());
            SimpleDraweeView simpleDraweeView = this.binding.f15484b;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildRoleSubscriptionPlanReviewCoverImage");
            MGImages.setImage$default(simpleDraweeView, planDetails.getCoverImage(), 0, 0, false, null, null, 124, null);
        }

        public final PlanDetailsViewHolder copy(ViewGuildRoleSubscriptionPlanDetailsReviewBinding binding) {
            C12238m.checkNotNullParameter(binding, "binding");
            return new PlanDetailsViewHolder(binding);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof PlanDetailsViewHolder) && C12238m.areEqual(this.binding, ((PlanDetailsViewHolder) other).binding);
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
            StringBuilder sbM833U = C1643a.m833U("PlanDetailsViewHolder(binding=");
            sbM833U.append(this.binding);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: GuildRoleSubscriptionTierViewHolder.kt */
    public static final /* data */ class SectionHeaderViewHolder extends GuildRoleSubscriptionTierViewHolder {
        private final ViewGuildRoleSubscriptionSectionHeaderItemBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public SectionHeaderViewHolder(ViewGuildRoleSubscriptionSectionHeaderItemBinding viewGuildRoleSubscriptionSectionHeaderItemBinding) {
            C12238m.checkNotNullParameter(viewGuildRoleSubscriptionSectionHeaderItemBinding, "binding");
            LinearLayout linearLayout = viewGuildRoleSubscriptionSectionHeaderItemBinding.f15491a;
            C12238m.checkNotNullExpressionValue(linearLayout, "binding.root");
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
            C12238m.checkNotNullParameter(item, "item");
            GuildRoleSubscriptionTierAdapterItem.SectionHeader sectionHeader = (GuildRoleSubscriptionTierAdapterItem.SectionHeader) item;
            if (sectionHeader.getTitleResId() != null) {
                View view = this.itemView;
                C12238m.checkNotNullExpressionValue(view, "itemView");
                i18nPluralString = view.getContext().getString(sectionHeader.getTitleResId().intValue());
            } else {
                i18nPluralString = (sectionHeader.getTitlePluralResId() == null || sectionHeader.getFormatArgument() == null) ? null : StringResourceUtilsKt.getI18nPluralString(C1643a.m885x(this.itemView, "itemView", "itemView.context"), sectionHeader.getTitlePluralResId().intValue(), sectionHeader.getFormatArgument().intValue(), sectionHeader.getFormatArgument());
            }
            TextView textView = this.binding.f15492b;
            C12238m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionSectionHeader");
            textView.setText(i18nPluralString);
        }

        public final SectionHeaderViewHolder copy(ViewGuildRoleSubscriptionSectionHeaderItemBinding binding) {
            C12238m.checkNotNullParameter(binding, "binding");
            return new SectionHeaderViewHolder(binding);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof SectionHeaderViewHolder) && C12238m.areEqual(this.binding, ((SectionHeaderViewHolder) other).binding);
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
            StringBuilder sbM833U = C1643a.m833U("SectionHeaderViewHolder(binding=");
            sbM833U.append(this.binding);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: GuildRoleSubscriptionTierViewHolder.kt */
    public static final /* data */ class TierHeaderViewHolder extends GuildRoleSubscriptionTierViewHolder {
        private final ViewGuildRoleSubscriptionTierHeaderBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public TierHeaderViewHolder(ViewGuildRoleSubscriptionTierHeaderBinding viewGuildRoleSubscriptionTierHeaderBinding) {
            C12238m.checkNotNullParameter(viewGuildRoleSubscriptionTierHeaderBinding, "binding");
            LinearLayout linearLayout = viewGuildRoleSubscriptionTierHeaderBinding.f15493a;
            C12238m.checkNotNullExpressionValue(linearLayout, "binding.root");
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
            C12238m.checkNotNullParameter(item, "item");
            GuildRoleSubscriptionTierAdapterItem.Header header = (GuildRoleSubscriptionTierAdapterItem.Header) item;
            TextView textView = this.binding.f15496d;
            C12238m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierHeaderName");
            textView.setText(header.getName());
            TextView textView2 = this.binding.f15494b;
            C12238m.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierHeaderDescription");
            textView2.setText(header.getDescription());
            if (header.getPrice() != null) {
                int iIntValue = header.getPrice().intValue();
                View view = this.itemView;
                C12238m.checkNotNullExpressionValue(view, "itemView");
                Context context = view.getContext();
                C12238m.checkNotNullExpressionValue(context, "itemView.context");
                formattedPriceUsd = PremiumUtilsKt.getFormattedPriceUsd(iIntValue, context);
            } else {
                formattedPriceUsd = null;
            }
            TextView textView3 = this.binding.f15497e;
            C12238m.checkNotNullExpressionValue(textView3, "binding.guildRoleSubscriptionTierHeaderPrice");
            ViewExtensions.setTextAndVisibilityBy(textView3, formattedPriceUsd);
            SimpleDraweeView simpleDraweeView = this.binding.f15495c;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildRoleSubscriptionTierHeaderImage");
            IconUtils.setIcon$default(simpleDraweeView, header.getImage(), C5419R.dimen.avatar_size_xxlarge, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
        }

        public final TierHeaderViewHolder copy(ViewGuildRoleSubscriptionTierHeaderBinding binding) {
            C12238m.checkNotNullParameter(binding, "binding");
            return new TierHeaderViewHolder(binding);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof TierHeaderViewHolder) && C12238m.areEqual(this.binding, ((TierHeaderViewHolder) other).binding);
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
            StringBuilder sbM833U = C1643a.m833U("TierHeaderViewHolder(binding=");
            sbM833U.append(this.binding);
            sbM833U.append(")");
            return sbM833U.toString();
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
