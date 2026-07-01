package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.databinding.ViewGuildRoleSubscriptionFreeTrialItemBinding;
import com.discord.views.CheckedSetting;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtilsKt;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildRoleSubscriptionBenefitViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder extends GuildRoleSubscriptionBenefitViewHolder {
    private final ViewGuildRoleSubscriptionFreeTrialItemBinding binding;
    private final GuildRoleSubscriptionBenefitAdapter$Listener listener;

    /* JADX WARN: Illegal instructions before constructor call */
    public GuildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder(ViewGuildRoleSubscriptionFreeTrialItemBinding viewGuildRoleSubscriptionFreeTrialItemBinding, GuildRoleSubscriptionBenefitAdapter$Listener guildRoleSubscriptionBenefitAdapter$Listener) {
        m.checkNotNullParameter(viewGuildRoleSubscriptionFreeTrialItemBinding, "binding");
        m.checkNotNullParameter(guildRoleSubscriptionBenefitAdapter$Listener, "listener");
        LinearLayout linearLayout = viewGuildRoleSubscriptionFreeTrialItemBinding.a;
        m.checkNotNullExpressionValue(linearLayout, "binding.root");
        super(linearLayout, null);
        this.binding = viewGuildRoleSubscriptionFreeTrialItemBinding;
        this.listener = guildRoleSubscriptionBenefitAdapter$Listener;
    }

    public static final /* synthetic */ ViewGuildRoleSubscriptionFreeTrialItemBinding access$getBinding$p(GuildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder guildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder) {
        return guildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder.binding;
    }

    public static final /* synthetic */ GuildRoleSubscriptionBenefitAdapter$Listener access$getListener$p(GuildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder guildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder) {
        return guildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder.listener;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x00d8  */
    @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder
    public void configure(GuildRoleSubscriptionBenefitAdapterItem benefitAdapterItem) {
        CharSequence text;
        CharSequence text2;
        m.checkNotNullParameter(benefitAdapterItem, "benefitAdapterItem");
        GuildRoleSubscriptionBenefitAdapterItem$FreeTrialItem guildRoleSubscriptionBenefitAdapterItem$FreeTrialItem = (GuildRoleSubscriptionBenefitAdapterItem$FreeTrialItem) benefitAdapterItem;
        CheckedSetting checkedSetting = this.binding.e;
        m.checkNotNullExpressionValue(checkedSetting, "binding.guildRoleSubscriptionFreeTrialEnableToggle");
        checkedSetting.setChecked(guildRoleSubscriptionBenefitAdapterItem$FreeTrialItem.isFreeTrialEnabled());
        this.binding.e.e(new GuildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder$configure$1(this));
        TextView textView = this.binding.f;
        m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionFreeTrialSubtitle");
        textView.setEnabled(guildRoleSubscriptionBenefitAdapterItem$FreeTrialItem.isFreeTrialEnabled());
        TextView textView2 = this.binding.d;
        m.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionActiveUserLimitTitle");
        textView2.setEnabled(guildRoleSubscriptionBenefitAdapterItem$FreeTrialItem.isFreeTrialEnabled());
        TextView textView3 = this.binding.f2194b;
        m.checkNotNullExpressionValue(textView3, "binding.guildRoleSubscri…ctiveUserLimitDescription");
        textView3.setEnabled(guildRoleSubscriptionBenefitAdapterItem$FreeTrialItem.isFreeTrialEnabled());
        TextView textView4 = this.binding.c;
        textView4.setSelected(guildRoleSubscriptionBenefitAdapterItem$FreeTrialItem.isFreeTrialEnabled());
        Integer activeTrialUserLimit = guildRoleSubscriptionBenefitAdapterItem$FreeTrialItem.getActiveTrialUserLimit();
        if (activeTrialUserLimit == null || (text = String.valueOf(activeTrialUserLimit.intValue())) == null) {
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            text = view.getContext().getText(2131890621);
        }
        textView4.setText(text);
        if (guildRoleSubscriptionBenefitAdapterItem$FreeTrialItem.isFreeTrialEnabled()) {
            textView4.setOnClickListener(new GuildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder$configure$$inlined$apply$lambda$1(this, guildRoleSubscriptionBenefitAdapterItem$FreeTrialItem));
        }
        TextView textView5 = this.binding.i;
        m.checkNotNullExpressionValue(textView5, "binding.guildRoleSubscriptionTimeLimitTitle");
        textView5.setEnabled(guildRoleSubscriptionBenefitAdapterItem$FreeTrialItem.isFreeTrialEnabled());
        TextView textView6 = this.binding.g;
        m.checkNotNullExpressionValue(textView6, "binding.guildRoleSubscriptionTimeLimitDescription");
        textView6.setEnabled(guildRoleSubscriptionBenefitAdapterItem$FreeTrialItem.isFreeTrialEnabled());
        TextView textView7 = this.binding.h;
        textView7.setSelected(guildRoleSubscriptionBenefitAdapterItem$FreeTrialItem.isFreeTrialEnabled());
        SubscriptionTrialInterval trialInterval = guildRoleSubscriptionBenefitAdapterItem$FreeTrialItem.getTrialInterval();
        if (trialInterval != null) {
            View view2 = this.itemView;
            m.checkNotNullExpressionValue(view2, "itemView");
            Context context = view2.getContext();
            m.checkNotNullExpressionValue(context, "itemView.context");
            text2 = GuildRoleSubscriptionUtilsKt.getFormattedLabel(trialInterval, context);
            if (text2 == null) {
                View view3 = this.itemView;
                m.checkNotNullExpressionValue(view3, "itemView");
                text2 = view3.getContext().getText(2131890604);
            }
        } else {
            View view4 = this.itemView;
            m.checkNotNullExpressionValue(view4, "itemView");
            text2 = view4.getContext().getText(2131890604);
        }
        textView7.setText(text2);
        if (guildRoleSubscriptionBenefitAdapterItem$FreeTrialItem.isFreeTrialEnabled()) {
            textView7.setOnClickListener(new GuildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder$configure$$inlined$apply$lambda$2(this, guildRoleSubscriptionBenefitAdapterItem$FreeTrialItem));
        }
    }
}
