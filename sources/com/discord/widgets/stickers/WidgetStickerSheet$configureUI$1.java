package com.discord.widgets.stickers;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.discord.widgets.settings.premium.WidgetSettingsPremium$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetStickerSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetStickerSheet$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetStickerSheet this$0;

    public WidgetStickerSheet$configureUI$1(WidgetStickerSheet widgetStickerSheet) {
        this.this$0 = widgetStickerSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsPremium$Companion widgetSettingsPremium$Companion = WidgetSettingsPremium.Companion;
        FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
        m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        WidgetSettingsPremium$Companion.launch$default(widgetSettingsPremium$Companion, fragmentActivityRequireActivity, null, "Sticker Nitro Upsell Popout", 2, null);
    }
}
