package com.discord.widgets.servers.community;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.settings.WidgetSettingsLanguageSelect;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityOverview$configureValidUI$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsCommunityOverview this$0;

    public WidgetServerSettingsCommunityOverview$configureValidUI$3(WidgetServerSettingsCommunityOverview widgetServerSettingsCommunityOverview) {
        this.this$0 = widgetServerSettingsCommunityOverview;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsLanguageSelect.Companion.show(this.this$0);
    }
}
