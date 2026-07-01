package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsOverview$configureSplashImage$2 implements View$OnClickListener {
    public final /* synthetic */ String $splashOriginalUrl;
    public final /* synthetic */ WidgetServerSettingsOverview this$0;

    public WidgetServerSettingsOverview$configureSplashImage$2(WidgetServerSettingsOverview widgetServerSettingsOverview, String str) {
        this.this$0 = widgetServerSettingsOverview;
        this.$splashOriginalUrl = str;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsOverview.access$configureSplashImage(this.this$0, this.$splashOriginalUrl, null, true);
    }
}
