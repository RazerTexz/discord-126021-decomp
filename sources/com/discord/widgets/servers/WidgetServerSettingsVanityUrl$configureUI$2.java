package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetServerSettingsVanityUrl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsVanityUrl$configureUI$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsVanityUrl$Model $model;
    public final /* synthetic */ WidgetServerSettingsVanityUrl this$0;

    public WidgetServerSettingsVanityUrl$configureUI$2(WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl, WidgetServerSettingsVanityUrl$Model widgetServerSettingsVanityUrl$Model) {
        this.this$0 = widgetServerSettingsVanityUrl;
        this.$model = widgetServerSettingsVanityUrl$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsVanityUrl.access$updateVanityUrl(this.this$0, this.$model.getGuildId(), "");
    }
}
