package com.discord.widgets.servers.guild_role_subscription;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.ViewServerSettingsGuildRoleSubscriptionAddTierItemBinding;
import com.discord.databinding.ViewServerSettingsGuildRoleSubscriptionTierItemBinding;
import com.discord.utilities.billing.PremiumUtilsKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapter;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapterItem;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p027k.C1107b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class TierViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
    public static final class AddTierItemViewHolder extends TierViewHolder {
        /* JADX WARN: Illegal instructions before constructor call */
        public AddTierItemViewHolder(ViewServerSettingsGuildRoleSubscriptionAddTierItemBinding viewServerSettingsGuildRoleSubscriptionAddTierItemBinding, final ServerSettingsGuildRoleSubscriptionTierAdapter.ItemClickListener itemClickListener) {
            C12238m.checkNotNullParameter(viewServerSettingsGuildRoleSubscriptionAddTierItemBinding, "binding");
            C12238m.checkNotNullParameter(itemClickListener, "itemClickListener");
            ConstraintLayout constraintLayout = viewServerSettingsGuildRoleSubscriptionAddTierItemBinding.f15558a;
            C12238m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            super(constraintLayout, null);
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.guild_role_subscription.TierViewHolder.AddTierItemViewHolder.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    itemClickListener.onAddTierItemClick();
                }
            });
            viewServerSettingsGuildRoleSubscriptionAddTierItemBinding.f15559b.setText(C5419R.string.guild_settings_role_subscription_tier_card_create);
        }
    }

    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
    public static final class TierItemViewHolder extends TierViewHolder {
        private static final int MAX_TIER_IMAGE_SIZE = 64;
        private final ViewServerSettingsGuildRoleSubscriptionTierItemBinding binding;
        private final int tierImageSizePx;

        /* JADX WARN: Illegal instructions before constructor call */
        public TierItemViewHolder(ViewServerSettingsGuildRoleSubscriptionTierItemBinding viewServerSettingsGuildRoleSubscriptionTierItemBinding) {
            C12238m.checkNotNullParameter(viewServerSettingsGuildRoleSubscriptionTierItemBinding, "binding");
            ConstraintLayout constraintLayout = viewServerSettingsGuildRoleSubscriptionTierItemBinding.f15560a;
            C12238m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            super(constraintLayout, null);
            this.binding = viewServerSettingsGuildRoleSubscriptionTierItemBinding;
            View view = this.itemView;
            C12238m.checkNotNullExpressionValue(view, "itemView");
            this.tierImageSizePx = view.getResources().getDimensionPixelSize(C5419R.dimen.guild_role_subscription_tier_image_size);
        }

        public final void configureUI(final ServerSettingsGuildRoleSubscriptionTierAdapterItem.Tier tierAdapterItem, final ServerSettingsGuildRoleSubscriptionTierAdapter.ItemClickListener itemClickListener) {
            C12238m.checkNotNullParameter(tierAdapterItem, "tierAdapterItem");
            C12238m.checkNotNullParameter(itemClickListener, "itemClickListener");
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.guild_role_subscription.TierViewHolder$TierItemViewHolder$configureUI$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    itemClickListener.onTierItemClick(tierAdapterItem.getTierListingId());
                }
            });
            TextView textView = this.binding.f15563d;
            C12238m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierName");
            textView.setText(tierAdapterItem.getTierName());
            TextView textView2 = this.binding.f15564e;
            C12238m.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierPrice");
            View view = this.itemView;
            C12238m.checkNotNullExpressionValue(view, "itemView");
            int tierPrice = tierAdapterItem.getTierPrice();
            View view2 = this.itemView;
            C12238m.checkNotNullExpressionValue(view2, "itemView");
            Context context = view2.getContext();
            C12238m.checkNotNullExpressionValue(context, "itemView.context");
            textView2.setText(C1107b.m212d(view, C5419R.string.billing_price_per_month, new Object[]{PremiumUtilsKt.getFormattedPriceUsd(tierPrice, context)}, (4 & 4) != 0 ? C1107b.c.f1492j : null));
            String storeAssetImage = tierAdapterItem.getTierImageAssetId() != null ? IconUtils.INSTANCE.getStoreAssetImage(Long.valueOf(tierAdapterItem.getApplicationId()), String.valueOf(tierAdapterItem.getTierImageAssetId().longValue()), 64) : null;
            SimpleDraweeView simpleDraweeView = this.binding.f15562c;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildRoleSubscriptionTierIcon");
            int i = this.tierImageSizePx;
            MGImages.setImage$default(simpleDraweeView, storeAssetImage, i, i, false, null, null, 112, null);
            TextView textView3 = this.binding.f15561b;
            C12238m.checkNotNullExpressionValue(textView3, "binding.guildRoleSubscriptionTierDraftTag");
            textView3.setVisibility(tierAdapterItem.isPublished() ^ true ? 0 : 8);
        }
    }

    private TierViewHolder(View view) {
        super(view);
    }

    public /* synthetic */ TierViewHolder(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }
}
