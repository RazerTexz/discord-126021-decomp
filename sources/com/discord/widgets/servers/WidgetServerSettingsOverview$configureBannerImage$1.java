package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsOverview$configureBannerImage$1 implements View$OnClickListener {
    public final /* synthetic */ String $bannerOriginalUrl;
    public final /* synthetic */ WidgetServerSettingsOverview this$0;

    public WidgetServerSettingsOverview$configureBannerImage$1(WidgetServerSettingsOverview widgetServerSettingsOverview, String str) {
        this.this$0 = widgetServerSettingsOverview;
        this.$bannerOriginalUrl = str;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsOverview.access$setImageSelectedResult$p(this.this$0, new WidgetServerSettingsOverview$configureBannerImage$1$1(this));
        this.this$0.requestMedia(new WidgetServerSettingsOverview$configureBannerImage$1$2(this));
    }
}
