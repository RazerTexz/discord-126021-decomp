package com.discord.widgets.settings;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.stores.StoreStream;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$configureExplicitContentRadio$1 implements View$OnClickListener {
    public final /* synthetic */ int $explicitContentFilter;
    public final /* synthetic */ WidgetSettingsPrivacy this$0;

    public WidgetSettingsPrivacy$configureExplicitContentRadio$1(WidgetSettingsPrivacy widgetSettingsPrivacy, int i) {
        this.this$0 = widgetSettingsPrivacy;
        this.$explicitContentFilter = i;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        StoreStream.Companion.getUserSettings().setExplicitContentFilter(this.this$0.getAppActivity(), this.$explicitContentFilter);
    }
}
