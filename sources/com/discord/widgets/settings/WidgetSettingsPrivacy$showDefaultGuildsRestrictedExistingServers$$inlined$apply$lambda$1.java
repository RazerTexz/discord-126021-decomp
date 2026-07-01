package com.discord.widgets.settings;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$showDefaultGuildsRestrictedExistingServers$$inlined$apply$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ boolean $defaultGuildsRestricted$inlined;
    public final /* synthetic */ WidgetSettingsPrivacy this$0;

    public WidgetSettingsPrivacy$showDefaultGuildsRestrictedExistingServers$$inlined$apply$lambda$1(WidgetSettingsPrivacy widgetSettingsPrivacy, boolean z2) {
        this.this$0 = widgetSettingsPrivacy;
        this.$defaultGuildsRestricted$inlined = z2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsPrivacy.access$updateDefaultGuildsRestricted(this.this$0, this.$defaultGuildsRestricted$inlined, false);
    }
}
