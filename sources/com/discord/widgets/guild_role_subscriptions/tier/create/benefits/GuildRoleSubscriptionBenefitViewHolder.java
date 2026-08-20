package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.databinding.ViewGuildRoleSubscriptionAddBenefitItemBinding;
import com.discord.databinding.ViewGuildRoleSubscriptionFreeTrialItemBinding;
import com.discord.databinding.ViewGuildRoleSubscriptionSectionHeaderItemBinding;
import com.discord.views.CheckedSetting;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionBenefitItemView;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtilsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildRoleSubscriptionBenefitViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GuildRoleSubscriptionBenefitViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: compiled from: GuildRoleSubscriptionBenefitViewHolder.kt */
    public static final class AddItemViewHolder extends GuildRoleSubscriptionBenefitViewHolder {
        private final ViewGuildRoleSubscriptionAddBenefitItemBinding binding;
        private final GuildRoleSubscriptionBenefitAdapter.Listener listener;

        /* JADX WARN: Illegal instructions before constructor call */
        public AddItemViewHolder(ViewGuildRoleSubscriptionAddBenefitItemBinding viewGuildRoleSubscriptionAddBenefitItemBinding, GuildRoleSubscriptionBenefitAdapter.Listener listener) {
            C12238m.checkNotNullParameter(viewGuildRoleSubscriptionAddBenefitItemBinding, "binding");
            C12238m.checkNotNullParameter(listener, "listener");
            ConstraintLayout constraintLayout = viewGuildRoleSubscriptionAddBenefitItemBinding.f15458a;
            C12238m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            super(constraintLayout, null);
            this.binding = viewGuildRoleSubscriptionAddBenefitItemBinding;
            this.listener = listener;
        }

        @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder
        public void configure(GuildRoleSubscriptionBenefitAdapterItem benefitAdapterItem) {
            String string;
            C12238m.checkNotNullParameter(benefitAdapterItem, "benefitAdapterItem");
            final GuildRoleSubscriptionBenefitAdapterItem.AddBenefitItem addBenefitItem = (GuildRoleSubscriptionBenefitAdapterItem.AddBenefitItem) benefitAdapterItem;
            this.binding.f15458a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder$AddItemViewHolder$configure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.this$0.listener.onAddBenefitItemClick(addBenefitItem);
                }
            });
            if (addBenefitItem.getType() == GuildRoleSubscriptionBenefitType.CHANNEL) {
                View view = this.itemView;
                C12238m.checkNotNullExpressionValue(view, "itemView");
                string = view.getContext().getString(C5419R.string.guild_role_subscription_tier_benefits_add_channel_label);
            } else {
                View view2 = this.itemView;
                C12238m.checkNotNullExpressionValue(view2, "itemView");
                string = view2.getContext().getString(C5419R.string.guild_role_subscription_tier_benefits_add_benefit_label);
            }
            C12238m.checkNotNullExpressionValue(string, "if (data.type == GuildRo…dd_benefit_label)\n      }");
            TextView textView = this.binding.f15459b;
            C12238m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionAddBenefitText");
            textView.setText(string);
            TextView textView2 = this.binding.f15459b;
            C12238m.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionAddBenefitText");
            textView2.setContentDescription(string);
        }
    }

    /* JADX INFO: compiled from: GuildRoleSubscriptionBenefitViewHolder.kt */
    public static final class FreeTrialViewHolder extends GuildRoleSubscriptionBenefitViewHolder {
        private final ViewGuildRoleSubscriptionFreeTrialItemBinding binding;
        private final GuildRoleSubscriptionBenefitAdapter.Listener listener;

        /* JADX WARN: Illegal instructions before constructor call */
        public FreeTrialViewHolder(ViewGuildRoleSubscriptionFreeTrialItemBinding viewGuildRoleSubscriptionFreeTrialItemBinding, GuildRoleSubscriptionBenefitAdapter.Listener listener) {
            C12238m.checkNotNullParameter(viewGuildRoleSubscriptionFreeTrialItemBinding, "binding");
            C12238m.checkNotNullParameter(listener, "listener");
            LinearLayout linearLayout = viewGuildRoleSubscriptionFreeTrialItemBinding.f15468a;
            C12238m.checkNotNullExpressionValue(linearLayout, "binding.root");
            super(linearLayout, null);
            this.binding = viewGuildRoleSubscriptionFreeTrialItemBinding;
            this.listener = listener;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x00d8  */
        @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder
        public void configure(GuildRoleSubscriptionBenefitAdapterItem benefitAdapterItem) {
            CharSequence text;
            CharSequence text2;
            C12238m.checkNotNullParameter(benefitAdapterItem, "benefitAdapterItem");
            final GuildRoleSubscriptionBenefitAdapterItem.FreeTrialItem freeTrialItem = (GuildRoleSubscriptionBenefitAdapterItem.FreeTrialItem) benefitAdapterItem;
            CheckedSetting checkedSetting = this.binding.f15472e;
            C12238m.checkNotNullExpressionValue(checkedSetting, "binding.guildRoleSubscriptionFreeTrialEnableToggle");
            checkedSetting.setChecked(freeTrialItem.isFreeTrialEnabled());
            this.binding.f15472e.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder$configure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildRoleSubscriptionBenefitAdapter.Listener listener = this.this$0.listener;
                    CheckedSetting checkedSetting2 = this.this$0.binding.f15472e;
                    C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.guildRoleSubscriptionFreeTrialEnableToggle");
                    listener.onFreeTrialToggle(!checkedSetting2.isChecked());
                }
            });
            TextView textView = this.binding.f15473f;
            C12238m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionFreeTrialSubtitle");
            textView.setEnabled(freeTrialItem.isFreeTrialEnabled());
            TextView textView2 = this.binding.f15471d;
            C12238m.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionActiveUserLimitTitle");
            textView2.setEnabled(freeTrialItem.isFreeTrialEnabled());
            TextView textView3 = this.binding.f15469b;
            C12238m.checkNotNullExpressionValue(textView3, "binding.guildRoleSubscri…ctiveUserLimitDescription");
            textView3.setEnabled(freeTrialItem.isFreeTrialEnabled());
            TextView textView4 = this.binding.f15470c;
            textView4.setSelected(freeTrialItem.isFreeTrialEnabled());
            Integer activeTrialUserLimit = freeTrialItem.getActiveTrialUserLimit();
            if (activeTrialUserLimit == null || (text = String.valueOf(activeTrialUserLimit.intValue())) == null) {
                View view = this.itemView;
                C12238m.checkNotNullExpressionValue(view, "itemView");
                text = view.getContext().getText(C5419R.string.f14707x846378d0);
            }
            textView4.setText(text);
            if (freeTrialItem.isFreeTrialEnabled()) {
                textView4.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder$configure$$inlined$apply$lambda$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        if (freeTrialItem.isFreeTrialEnabled()) {
                            this.this$0.listener.onActiveTrialUserLimitClick();
                        }
                    }
                });
            }
            TextView textView5 = this.binding.f15476i;
            C12238m.checkNotNullExpressionValue(textView5, "binding.guildRoleSubscriptionTimeLimitTitle");
            textView5.setEnabled(freeTrialItem.isFreeTrialEnabled());
            TextView textView6 = this.binding.f15474g;
            C12238m.checkNotNullExpressionValue(textView6, "binding.guildRoleSubscriptionTimeLimitDescription");
            textView6.setEnabled(freeTrialItem.isFreeTrialEnabled());
            TextView textView7 = this.binding.f15475h;
            textView7.setSelected(freeTrialItem.isFreeTrialEnabled());
            SubscriptionTrialInterval trialInterval = freeTrialItem.getTrialInterval();
            if (trialInterval != null) {
                View view2 = this.itemView;
                C12238m.checkNotNullExpressionValue(view2, "itemView");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "itemView.context");
                text2 = GuildRoleSubscriptionUtilsKt.getFormattedLabel(trialInterval, context);
                if (text2 == null) {
                    View view3 = this.itemView;
                    C12238m.checkNotNullExpressionValue(view3, "itemView");
                    text2 = view3.getContext().getText(C5419R.string.guild_role_subscription_setup_free_trial_disabled);
                }
            } else {
                View view4 = this.itemView;
                C12238m.checkNotNullExpressionValue(view4, "itemView");
                text2 = view4.getContext().getText(C5419R.string.guild_role_subscription_setup_free_trial_disabled);
            }
            textView7.setText(text2);
            if (freeTrialItem.isFreeTrialEnabled()) {
                textView7.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder$configure$$inlined$apply$lambda$2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view5) {
                        this.this$0.listener.onTrialIntervalClick();
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: GuildRoleSubscriptionBenefitViewHolder.kt */
    public static final class HeaderViewHolder extends GuildRoleSubscriptionBenefitViewHolder {
        private final ViewGuildRoleSubscriptionSectionHeaderItemBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public HeaderViewHolder(ViewGuildRoleSubscriptionSectionHeaderItemBinding viewGuildRoleSubscriptionSectionHeaderItemBinding) {
            C12238m.checkNotNullParameter(viewGuildRoleSubscriptionSectionHeaderItemBinding, "binding");
            LinearLayout linearLayout = viewGuildRoleSubscriptionSectionHeaderItemBinding.f15491a;
            C12238m.checkNotNullExpressionValue(linearLayout, "binding.root");
            super(linearLayout, null);
            this.binding = viewGuildRoleSubscriptionSectionHeaderItemBinding;
        }

        @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder
        public void configure(GuildRoleSubscriptionBenefitAdapterItem benefitAdapterItem) {
            C12238m.checkNotNullParameter(benefitAdapterItem, "benefitAdapterItem");
            this.binding.f15492b.setText(((GuildRoleSubscriptionBenefitAdapterItem.Header) benefitAdapterItem).getType() == GuildRoleSubscriptionBenefitType.CHANNEL ? C5419R.string.guild_role_subscription_tier_exclusive_channels_section_title : C5419R.string.guild_role_subscription_tier_additional_benefits_section_title);
        }
    }

    /* JADX INFO: compiled from: GuildRoleSubscriptionBenefitViewHolder.kt */
    public static final class ItemViewHolder extends GuildRoleSubscriptionBenefitViewHolder {
        private final GuildRoleSubscriptionBenefitAdapter.Listener listener;
        private final GuildRoleSubscriptionBenefitItemView view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemViewHolder(GuildRoleSubscriptionBenefitItemView guildRoleSubscriptionBenefitItemView, GuildRoleSubscriptionBenefitAdapter.Listener listener) {
            super(guildRoleSubscriptionBenefitItemView, null);
            C12238m.checkNotNullParameter(guildRoleSubscriptionBenefitItemView, "view");
            C12238m.checkNotNullParameter(listener, "listener");
            this.view = guildRoleSubscriptionBenefitItemView;
            this.listener = listener;
        }

        @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder
        public void configure(final GuildRoleSubscriptionBenefitAdapterItem benefitAdapterItem) {
            C12238m.checkNotNullParameter(benefitAdapterItem, "benefitAdapterItem");
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder$ItemViewHolder$configure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.this$0.listener.onBenefitItemClick(benefitAdapterItem);
                }
            });
            if (!(benefitAdapterItem instanceof GuildRoleSubscriptionBenefitAdapterItem.BenefitItem)) {
                benefitAdapterItem = null;
            }
            GuildRoleSubscriptionBenefitAdapterItem.BenefitItem benefitItem = (GuildRoleSubscriptionBenefitAdapterItem.BenefitItem) benefitAdapterItem;
            if (benefitItem != null) {
                this.view.configureUI(benefitItem.getBenefit());
            }
        }
    }

    private GuildRoleSubscriptionBenefitViewHolder(View view) {
        super(view);
    }

    public abstract void configure(GuildRoleSubscriptionBenefitAdapterItem benefitAdapterItem);

    public /* synthetic */ GuildRoleSubscriptionBenefitViewHolder(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }
}
