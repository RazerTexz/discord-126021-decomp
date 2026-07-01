package com.discord.widgets.stickers;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.analytics.Traits$Location$Section;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.discord.widgets.settings.premium.WidgetSettingsPremium$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: StickerPremiumUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StickerPremiumUpsellDialog$onViewBoundOrOnResume$2 implements View$OnClickListener {
    public final /* synthetic */ StickerPremiumUpsellDialog this$0;

    public StickerPremiumUpsellDialog$onViewBoundOrOnResume$2(StickerPremiumUpsellDialog stickerPremiumUpsellDialog) {
        this.this$0 = stickerPremiumUpsellDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
        WidgetSettingsPremium$Companion widgetSettingsPremium$Companion = WidgetSettingsPremium.Companion;
        Context contextRequireContext = this.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        widgetSettingsPremium$Companion.launch(contextRequireContext, 1, Traits$Location$Section.STICKER_PREMIUM_TIER_2_UPSELL_MODAL);
    }
}
