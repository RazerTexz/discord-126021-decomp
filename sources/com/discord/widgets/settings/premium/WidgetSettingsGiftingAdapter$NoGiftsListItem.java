package com.discord.widgets.settings.premium;

import com.discord.R$layout;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsGiftingAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGiftingAdapter$NoGiftsListItem extends MGRecyclerViewHolder<WidgetSettingsGiftingAdapter, WidgetSettingsGiftingAdapter$GiftItem> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGiftingAdapter$NoGiftsListItem(WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter) {
        super(R$layout.view_no_gifts_list_item, widgetSettingsGiftingAdapter);
        m.checkNotNullParameter(widgetSettingsGiftingAdapter, "adapter");
    }
}
