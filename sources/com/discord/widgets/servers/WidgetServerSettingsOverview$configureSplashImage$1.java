package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsOverview$configureSplashImage$1 implements View$OnClickListener {
    public final /* synthetic */ String $splashOriginalUrl;
    public final /* synthetic */ WidgetServerSettingsOverview this$0;

    public WidgetServerSettingsOverview$configureSplashImage$1(WidgetServerSettingsOverview widgetServerSettingsOverview, String str) {
        this.this$0 = widgetServerSettingsOverview;
        this.$splashOriginalUrl = str;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsOverview.access$setImageSelectedResult$p(this.this$0, new WidgetServerSettingsOverview$configureSplashImage$1$1(this));
        this.this$0.openMediaChooser();
    }
}
