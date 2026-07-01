package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsOverview$configureBannerImage$2 implements View$OnClickListener {
    public final /* synthetic */ String $bannerOriginalUrl;
    public final /* synthetic */ WidgetServerSettingsOverview this$0;

    public WidgetServerSettingsOverview$configureBannerImage$2(WidgetServerSettingsOverview widgetServerSettingsOverview, String str) {
        this.this$0 = widgetServerSettingsOverview;
        this.$bannerOriginalUrl = str;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsOverview.access$configureBannerImage(this.this$0, this.$bannerOriginalUrl, null, true);
    }
}
