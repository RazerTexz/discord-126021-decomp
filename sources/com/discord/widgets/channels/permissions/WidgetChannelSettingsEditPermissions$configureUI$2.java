package com.discord.widgets.channels.permissions;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetChannelSettingsEditPermissions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsEditPermissions$configureUI$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetChannelSettingsEditPermissionsModel $model;
    public final /* synthetic */ WidgetChannelSettingsEditPermissions this$0;

    public WidgetChannelSettingsEditPermissions$configureUI$2(WidgetChannelSettingsEditPermissions widgetChannelSettingsEditPermissions, WidgetChannelSettingsEditPermissionsModel widgetChannelSettingsEditPermissionsModel) {
        this.this$0 = widgetChannelSettingsEditPermissions;
        this.$model = widgetChannelSettingsEditPermissionsModel;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChannelSettingsEditPermissions.access$updatePermissionOverwrites(this.this$0, this.$model.getChannel().getId(), this.$model.getTargetId(), this.$model.getType());
    }
}
