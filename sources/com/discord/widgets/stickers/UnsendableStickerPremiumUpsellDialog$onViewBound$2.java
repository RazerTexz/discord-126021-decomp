package com.discord.widgets.stickers;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.analytics.Traits$Location$Section;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.discord.widgets.settings.premium.WidgetSettingsPremium$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: UnsendableStickerPremiumUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UnsendableStickerPremiumUpsellDialog$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ UnsendableStickerPremiumUpsellDialog this$0;

    public UnsendableStickerPremiumUpsellDialog$onViewBound$2(UnsendableStickerPremiumUpsellDialog unsendableStickerPremiumUpsellDialog) {
        this.this$0 = unsendableStickerPremiumUpsellDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsPremium$Companion widgetSettingsPremium$Companion = WidgetSettingsPremium.Companion;
        Context contextRequireContext = this.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        WidgetSettingsPremium$Companion.launch$default(widgetSettingsPremium$Companion, contextRequireContext, null, Traits$Location$Section.EXPRESSION_PICKER, 2, null);
        this.this$0.dismiss();
    }
}
