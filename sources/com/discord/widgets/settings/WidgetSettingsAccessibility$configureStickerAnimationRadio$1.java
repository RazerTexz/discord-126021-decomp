package com.discord.widgets.settings;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.stores.StoreStream;

/* JADX INFO: compiled from: WidgetSettingsAccessibility.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccessibility$configureStickerAnimationRadio$1 implements View$OnClickListener {
    public final /* synthetic */ int $stickerAnimationSetting;
    public final /* synthetic */ WidgetSettingsAccessibility this$0;

    public WidgetSettingsAccessibility$configureStickerAnimationRadio$1(WidgetSettingsAccessibility widgetSettingsAccessibility, int i) {
        this.this$0 = widgetSettingsAccessibility;
        this.$stickerAnimationSetting = i;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        StoreStream.Companion.getUserSettings().setStickerAnimationSettings(this.this$0.getAppActivity(), this.$stickerAnimationSetting);
    }
}
