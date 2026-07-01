package com.discord.widgets.settings.premium;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetSettingsGiftingAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsGiftingAdapter$GiftItem $data;
    public final /* synthetic */ WidgetSettingsGiftingAdapter$EntitlementListItem this$0;

    public WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$3(WidgetSettingsGiftingAdapter$EntitlementListItem widgetSettingsGiftingAdapter$EntitlementListItem, WidgetSettingsGiftingAdapter$GiftItem widgetSettingsGiftingAdapter$GiftItem) {
        this.this$0 = widgetSettingsGiftingAdapter$EntitlementListItem;
        this.$data = widgetSettingsGiftingAdapter$GiftItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsGiftingAdapter.access$getOnClickCopyListener$p(WidgetSettingsGiftingAdapter$EntitlementListItem.access$getAdapter$p(this.this$0)).invoke(this.$data.getGift().getCode());
    }
}
