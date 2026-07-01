package com.discord.widgets.servers.guild_role_subscription;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.k.b;
import com.discord.databinding.ViewServerSettingsGuildRoleSubscriptionTierItemBinding;
import com.discord.utilities.billing.PremiumUtilsKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TierViewHolder$TierItemViewHolder extends TierViewHolder {
    public static final TierViewHolder$TierItemViewHolder$Companion Companion = new TierViewHolder$TierItemViewHolder$Companion(null);
    private static final int MAX_TIER_IMAGE_SIZE = 64;
    private final ViewServerSettingsGuildRoleSubscriptionTierItemBinding binding;
    private final int tierImageSizePx;

    /* JADX WARN: Illegal instructions before constructor call */
    public TierViewHolder$TierItemViewHolder(ViewServerSettingsGuildRoleSubscriptionTierItemBinding viewServerSettingsGuildRoleSubscriptionTierItemBinding) {
        m.checkNotNullParameter(viewServerSettingsGuildRoleSubscriptionTierItemBinding, "binding");
        ConstraintLayout constraintLayout = viewServerSettingsGuildRoleSubscriptionTierItemBinding.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        super(constraintLayout, null);
        this.binding = viewServerSettingsGuildRoleSubscriptionTierItemBinding;
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        this.tierImageSizePx = view.getResources().getDimensionPixelSize(2131165457);
    }

    public final void configureUI(ServerSettingsGuildRoleSubscriptionTierAdapterItem$Tier tierAdapterItem, ServerSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener itemClickListener) {
        m.checkNotNullParameter(tierAdapterItem, "tierAdapterItem");
        m.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.itemView.setOnClickListener(new TierViewHolder$TierItemViewHolder$configureUI$1(itemClickListener, tierAdapterItem));
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierName");
        textView.setText(tierAdapterItem.getTierName());
        TextView textView2 = this.binding.e;
        m.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierPrice");
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        int tierPrice = tierAdapterItem.getTierPrice();
        View view2 = this.itemView;
        m.checkNotNullExpressionValue(view2, "itemView");
        Context context = view2.getContext();
        m.checkNotNullExpressionValue(context, "itemView.context");
        textView2.setText(b.j(view, 2131887143, new Object[]{PremiumUtilsKt.getFormattedPriceUsd(tierPrice, context)}, null, 4));
        String storeAssetImage = tierAdapterItem.getTierImageAssetId() != null ? IconUtils.INSTANCE.getStoreAssetImage(Long.valueOf(tierAdapterItem.getApplicationId()), String.valueOf(tierAdapterItem.getTierImageAssetId().longValue()), 64) : null;
        SimpleDraweeView simpleDraweeView = this.binding.c;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildRoleSubscriptionTierIcon");
        int i = this.tierImageSizePx;
        MGImages.setImage$default(simpleDraweeView, storeAssetImage, i, i, false, null, null, 112, null);
        TextView textView3 = this.binding.f2210b;
        m.checkNotNullExpressionValue(textView3, "binding.guildRoleSubscriptionTierDraftTag");
        textView3.setVisibility(tierAdapterItem.isPublished() ^ true ? 0 : 8);
    }
}
