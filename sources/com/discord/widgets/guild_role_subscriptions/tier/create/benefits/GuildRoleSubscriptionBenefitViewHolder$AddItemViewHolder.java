package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.discord.databinding.ViewGuildRoleSubscriptionAddBenefitItemBinding;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildRoleSubscriptionBenefitViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionBenefitViewHolder$AddItemViewHolder extends GuildRoleSubscriptionBenefitViewHolder {
    private final ViewGuildRoleSubscriptionAddBenefitItemBinding binding;
    private final GuildRoleSubscriptionBenefitAdapter$Listener listener;

    /* JADX WARN: Illegal instructions before constructor call */
    public GuildRoleSubscriptionBenefitViewHolder$AddItemViewHolder(ViewGuildRoleSubscriptionAddBenefitItemBinding viewGuildRoleSubscriptionAddBenefitItemBinding, GuildRoleSubscriptionBenefitAdapter$Listener guildRoleSubscriptionBenefitAdapter$Listener) {
        m.checkNotNullParameter(viewGuildRoleSubscriptionAddBenefitItemBinding, "binding");
        m.checkNotNullParameter(guildRoleSubscriptionBenefitAdapter$Listener, "listener");
        ConstraintLayout constraintLayout = viewGuildRoleSubscriptionAddBenefitItemBinding.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        super(constraintLayout, null);
        this.binding = viewGuildRoleSubscriptionAddBenefitItemBinding;
        this.listener = guildRoleSubscriptionBenefitAdapter$Listener;
    }

    public static final /* synthetic */ GuildRoleSubscriptionBenefitAdapter$Listener access$getListener$p(GuildRoleSubscriptionBenefitViewHolder$AddItemViewHolder guildRoleSubscriptionBenefitViewHolder$AddItemViewHolder) {
        return guildRoleSubscriptionBenefitViewHolder$AddItemViewHolder.listener;
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder
    public void configure(GuildRoleSubscriptionBenefitAdapterItem benefitAdapterItem) {
        String string;
        m.checkNotNullParameter(benefitAdapterItem, "benefitAdapterItem");
        GuildRoleSubscriptionBenefitAdapterItem$AddBenefitItem guildRoleSubscriptionBenefitAdapterItem$AddBenefitItem = (GuildRoleSubscriptionBenefitAdapterItem$AddBenefitItem) benefitAdapterItem;
        this.binding.a.setOnClickListener(new GuildRoleSubscriptionBenefitViewHolder$AddItemViewHolder$configure$1(this, guildRoleSubscriptionBenefitAdapterItem$AddBenefitItem));
        if (guildRoleSubscriptionBenefitAdapterItem$AddBenefitItem.getType() == GuildRoleSubscriptionBenefitType.CHANNEL) {
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            string = view.getContext().getString(2131890648);
        } else {
            View view2 = this.itemView;
            m.checkNotNullExpressionValue(view2, "itemView");
            string = view2.getContext().getString(2131890647);
        }
        m.checkNotNullExpressionValue(string, "if (data.type == GuildRo…dd_benefit_label)\n      }");
        TextView textView = this.binding.f2191b;
        m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionAddBenefitText");
        textView.setText(string);
        TextView textView2 = this.binding.f2191b;
        m.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionAddBenefitText");
        textView2.setContentDescription(string);
    }
}
