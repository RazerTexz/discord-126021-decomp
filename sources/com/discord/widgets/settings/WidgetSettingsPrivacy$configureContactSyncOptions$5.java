package com.discord.widgets.settings;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.user.UserUtils;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$configureContactSyncOptions$5 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsPrivacy$Model $model;
    public final /* synthetic */ WidgetSettingsPrivacy this$0;

    public WidgetSettingsPrivacy$configureContactSyncOptions$5(WidgetSettingsPrivacy widgetSettingsPrivacy, WidgetSettingsPrivacy$Model widgetSettingsPrivacy$Model) {
        this.this$0 = widgetSettingsPrivacy;
        this.$model = widgetSettingsPrivacy$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (UserUtils.INSTANCE.isStaff(this.$model.getMe())) {
            WidgetSettingsPrivacy.access$deleteContactSync(this.this$0);
        }
    }
}
