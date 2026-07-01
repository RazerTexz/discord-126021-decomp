package com.discord.widgets.guild_role_subscriptions.tier;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GuildRoleSubscriptionTierViewHolder extends RecyclerView$ViewHolder {
    private GuildRoleSubscriptionTierViewHolder(View view) {
        super(view);
    }

    public abstract void bind(GuildRoleSubscriptionTierAdapterItem item);

    public /* synthetic */ GuildRoleSubscriptionTierViewHolder(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }
}
