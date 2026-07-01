package com.discord.widgets.channels.permissions;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsAdvanced$configureUI$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetChannelSettingsPermissionsAdvanced$Model $model;
    public final /* synthetic */ WidgetChannelSettingsPermissionsAdvanced this$0;

    public WidgetChannelSettingsPermissionsAdvanced$configureUI$2(WidgetChannelSettingsPermissionsAdvanced widgetChannelSettingsPermissionsAdvanced, WidgetChannelSettingsPermissionsAdvanced$Model widgetChannelSettingsPermissionsAdvanced$Model) {
        this.this$0 = widgetChannelSettingsPermissionsAdvanced;
        this.$model = widgetChannelSettingsPermissionsAdvanced$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChannelSettingsPermissionsAddMember.create(this.this$0.getContext(), this.$model.getGuild().getId(), this.$model.getChannel().getId());
    }
}
