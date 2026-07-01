package com.discord.widgets.chat.input.sticker;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.discord.widgets.settings.premium.WidgetSettingsPremium$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetStickerPackStoreSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStickerPackStoreSheet$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ StickerPackStoreSheetViewModel$ViewState $viewState;
    public final /* synthetic */ WidgetStickerPackStoreSheet this$0;

    public WidgetStickerPackStoreSheet$configureUI$1(WidgetStickerPackStoreSheet widgetStickerPackStoreSheet, StickerPackStoreSheetViewModel$ViewState stickerPackStoreSheetViewModel$ViewState) {
        this.this$0 = widgetStickerPackStoreSheet;
        this.$viewState = stickerPackStoreSheetViewModel$ViewState;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (!this.$viewState.isPackEnabled() || this.$viewState.canUserAccessToPremiumStickers()) {
            return;
        }
        WidgetSettingsPremium$Companion widgetSettingsPremium$Companion = WidgetSettingsPremium.Companion;
        Context contextRequireContext = this.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        WidgetSettingsPremium$Companion.launch$default(widgetSettingsPremium$Companion, contextRequireContext, 1, null, 4, null);
    }
}
