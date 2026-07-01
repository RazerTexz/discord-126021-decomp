package com.discord.widgets.settings.premium;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.api.application.Application;
import com.discord.api.premium.SubscriptionInterval;
import com.discord.databinding.ViewGiftSkuListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import kotlin.Pair;

/* JADX INFO: compiled from: WidgetSettingsGiftingAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGiftingAdapter$SkuListItem extends MGRecyclerViewHolder<WidgetSettingsGiftingAdapter, WidgetSettingsGiftingAdapter$GiftItem> {
    private final ViewGiftSkuListItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGiftingAdapter$SkuListItem(WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter) {
        super(R$layout.view_gift_sku_list_item, widgetSettingsGiftingAdapter);
        m.checkNotNullParameter(widgetSettingsGiftingAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.gift_sku_arrow;
        ImageView imageView = (ImageView) view.findViewById(R$id.gift_sku_arrow);
        if (imageView != null) {
            i = R$id.gift_sku_copies;
            TextView textView = (TextView) view.findViewById(R$id.gift_sku_copies);
            if (textView != null) {
                i = R$id.gift_sku_icon;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.gift_sku_icon);
                if (simpleDraweeView != null) {
                    i = R$id.gift_sku_name;
                    TextView textView2 = (TextView) view.findViewById(R$id.gift_sku_name);
                    if (textView2 != null) {
                        ViewGiftSkuListItemBinding viewGiftSkuListItemBinding = new ViewGiftSkuListItemBinding((CardView) view, imageView, textView, simpleDraweeView, textView2);
                        m.checkNotNullExpressionValue(viewGiftSkuListItemBinding, "ViewGiftSkuListItemBinding.bind(itemView)");
                        this.binding = viewGiftSkuListItemBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetSettingsGiftingAdapter access$getAdapter$p(WidgetSettingsGiftingAdapter$SkuListItem widgetSettingsGiftingAdapter$SkuListItem) {
        return (WidgetSettingsGiftingAdapter) widgetSettingsGiftingAdapter$SkuListItem.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetSettingsGiftingAdapter$GiftItem widgetSettingsGiftingAdapter$GiftItem) {
        onConfigure2(i, widgetSettingsGiftingAdapter$GiftItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetSettingsGiftingAdapter$GiftItem data) {
        CharSequence name;
        String icon;
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (data.getSku() == null || data.getCopies() == null || data.getExpanded() == null) {
            return;
        }
        TextView textView = this.binding.e;
        m.checkNotNullExpressionValue(textView, "binding.giftSkuName");
        textView.setText(data.getSku().getName());
        String applicationIcon$default = null;
        SubscriptionPlanType subscriptionPlanTypeFrom = data.getPlanId() != null ? SubscriptionPlanType.Companion.from(data.getPlanId().longValue()) : null;
        TextView textView2 = this.binding.e;
        m.checkNotNullExpressionValue(textView2, "binding.giftSkuName");
        if (subscriptionPlanTypeFrom != null) {
            Pair pair = subscriptionPlanTypeFrom.getInterval() == SubscriptionInterval.MONTHLY ? new Pair(2131889755, Integer.valueOf(R$plurals.gift_inventory_subscription_months_intervalCount)) : new Pair(2131889756, Integer.valueOf(R$plurals.gift_inventory_subscription_years_intervalCount));
            int iIntValue = ((Number) pair.component1()).intValue();
            int iIntValue2 = ((Number) pair.component2()).intValue();
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            name = b.d(view, iIntValue, new Object[0], new WidgetSettingsGiftingAdapter$SkuListItem$onConfigure$1(this, data, iIntValue2, 1));
        } else {
            name = data.getSku().getName();
        }
        textView2.setText(name);
        TextView textView3 = this.binding.c;
        m.checkNotNullExpressionValue(textView3, "binding.giftSkuCopies");
        textView3.setText(StringResourceUtilsKt.getI18nPluralString(a.x(this.itemView, "itemView", "itemView.context"), R$plurals.gift_inventory_copies_copies, data.getCopies().intValue(), data.getCopies()));
        this.binding.f2188b.setImageResource(data.getExpanded().booleanValue() ? 2131231665 : 2131231669);
        PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
        if (premiumUtils.isNitroSku(data.getSku())) {
            this.binding.d.setImageResource(premiumUtils.getNitroGiftIcon(data.getSku()));
        } else {
            Application application = data.getSku().getApplication();
            if (application != null && (icon = application.getIcon()) != null) {
                applicationIcon$default = IconUtils.getApplicationIcon$default(data.getSku().getApplicationId(), icon, 0, 4, (Object) null);
            }
            this.binding.d.setImageURI(applicationIcon$default);
        }
        this.itemView.setOnClickListener(new WidgetSettingsGiftingAdapter$SkuListItem$onConfigure$2(this, data));
    }
}
