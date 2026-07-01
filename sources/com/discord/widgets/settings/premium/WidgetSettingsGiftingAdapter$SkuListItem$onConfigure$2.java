package com.discord.widgets.settings.premium;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetSettingsGiftingAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGiftingAdapter$SkuListItem$onConfigure$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsGiftingAdapter$GiftItem $data;
    public final /* synthetic */ WidgetSettingsGiftingAdapter$SkuListItem this$0;

    public WidgetSettingsGiftingAdapter$SkuListItem$onConfigure$2(WidgetSettingsGiftingAdapter$SkuListItem widgetSettingsGiftingAdapter$SkuListItem, WidgetSettingsGiftingAdapter$GiftItem widgetSettingsGiftingAdapter$GiftItem) {
        this.this$0 = widgetSettingsGiftingAdapter$SkuListItem;
        this.$data = widgetSettingsGiftingAdapter$GiftItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsGiftingAdapter.access$getOnClickSkuListener$p(WidgetSettingsGiftingAdapter$SkuListItem.access$getAdapter$p(this.this$0)).invoke(Long.valueOf(this.$data.getSku().getId()), this.$data.getPlanId());
    }
}
