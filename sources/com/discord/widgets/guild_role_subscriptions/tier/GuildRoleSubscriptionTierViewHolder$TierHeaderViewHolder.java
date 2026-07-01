package com.discord.widgets.guild_role_subscriptions.tier;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.d.b.a.a;
import com.discord.databinding.ViewGuildRoleSubscriptionTierHeaderBinding;
import com.discord.utilities.billing.PremiumUtilsKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildRoleSubscriptionTierViewHolder$TierHeaderViewHolder extends GuildRoleSubscriptionTierViewHolder {
    private final ViewGuildRoleSubscriptionTierHeaderBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    public GuildRoleSubscriptionTierViewHolder$TierHeaderViewHolder(ViewGuildRoleSubscriptionTierHeaderBinding viewGuildRoleSubscriptionTierHeaderBinding) {
        m.checkNotNullParameter(viewGuildRoleSubscriptionTierHeaderBinding, "binding");
        LinearLayout linearLayout = viewGuildRoleSubscriptionTierHeaderBinding.a;
        m.checkNotNullExpressionValue(linearLayout, "binding.root");
        super(linearLayout, null);
        this.binding = viewGuildRoleSubscriptionTierHeaderBinding;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final ViewGuildRoleSubscriptionTierHeaderBinding getBinding() {
        return this.binding;
    }

    public static /* synthetic */ GuildRoleSubscriptionTierViewHolder$TierHeaderViewHolder copy$default(GuildRoleSubscriptionTierViewHolder$TierHeaderViewHolder guildRoleSubscriptionTierViewHolder$TierHeaderViewHolder, ViewGuildRoleSubscriptionTierHeaderBinding viewGuildRoleSubscriptionTierHeaderBinding, int i, Object obj) {
        if ((i & 1) != 0) {
            viewGuildRoleSubscriptionTierHeaderBinding = guildRoleSubscriptionTierViewHolder$TierHeaderViewHolder.binding;
        }
        return guildRoleSubscriptionTierViewHolder$TierHeaderViewHolder.copy(viewGuildRoleSubscriptionTierHeaderBinding);
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierViewHolder
    public void bind(GuildRoleSubscriptionTierAdapterItem item) {
        CharSequence formattedPriceUsd;
        m.checkNotNullParameter(item, "item");
        GuildRoleSubscriptionTierAdapterItem$Header guildRoleSubscriptionTierAdapterItem$Header = (GuildRoleSubscriptionTierAdapterItem$Header) item;
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierHeaderName");
        textView.setText(guildRoleSubscriptionTierAdapterItem$Header.getName());
        TextView textView2 = this.binding.f2199b;
        m.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierHeaderDescription");
        textView2.setText(guildRoleSubscriptionTierAdapterItem$Header.getDescription());
        if (guildRoleSubscriptionTierAdapterItem$Header.getPrice() != null) {
            int iIntValue = guildRoleSubscriptionTierAdapterItem$Header.getPrice().intValue();
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            Context context = view.getContext();
            m.checkNotNullExpressionValue(context, "itemView.context");
            formattedPriceUsd = PremiumUtilsKt.getFormattedPriceUsd(iIntValue, context);
        } else {
            formattedPriceUsd = null;
        }
        TextView textView3 = this.binding.e;
        m.checkNotNullExpressionValue(textView3, "binding.guildRoleSubscriptionTierHeaderPrice");
        ViewExtensions.setTextAndVisibilityBy(textView3, formattedPriceUsd);
        SimpleDraweeView simpleDraweeView = this.binding.c;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildRoleSubscriptionTierHeaderImage");
        IconUtils.setIcon$default(simpleDraweeView, guildRoleSubscriptionTierAdapterItem$Header.getImage(), 2131165302, (Function1) null, (MGImages$ChangeDetector) null, 24, (Object) null);
    }

    public final GuildRoleSubscriptionTierViewHolder$TierHeaderViewHolder copy(ViewGuildRoleSubscriptionTierHeaderBinding binding) {
        m.checkNotNullParameter(binding, "binding");
        return new GuildRoleSubscriptionTierViewHolder$TierHeaderViewHolder(binding);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildRoleSubscriptionTierViewHolder$TierHeaderViewHolder) && m.areEqual(this.binding, ((GuildRoleSubscriptionTierViewHolder$TierHeaderViewHolder) other).binding);
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

    @Override // androidx.recyclerview.widget.RecyclerView$ViewHolder
    public String toString() {
        StringBuilder sbU = a.U("TierHeaderViewHolder(binding=");
        sbU.append(this.binding);
        sbU.append(")");
        return sbU.toString();
    }
}
