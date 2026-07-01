package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildRoleSubscriptionBenefitViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GuildRoleSubscriptionBenefitViewHolder extends RecyclerView$ViewHolder {
    private GuildRoleSubscriptionBenefitViewHolder(View view) {
        super(view);
    }

    public abstract void configure(GuildRoleSubscriptionBenefitAdapterItem benefitAdapterItem);

    public /* synthetic */ GuildRoleSubscriptionBenefitViewHolder(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }
}
