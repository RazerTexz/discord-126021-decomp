package com.discord.widgets.settings;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$configureDefaultGuildsRestricted$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsPrivacy$Model $model;
    public final /* synthetic */ WidgetSettingsPrivacy this$0;

    public WidgetSettingsPrivacy$configureDefaultGuildsRestricted$1(WidgetSettingsPrivacy widgetSettingsPrivacy, WidgetSettingsPrivacy$Model widgetSettingsPrivacy$Model) {
        this.this$0 = widgetSettingsPrivacy;
        this.$model = widgetSettingsPrivacy$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsPrivacy.access$showDefaultGuildsRestrictedExistingServers(this.this$0, !this.$model.getDefaultRestrictedGuilds());
    }
}
