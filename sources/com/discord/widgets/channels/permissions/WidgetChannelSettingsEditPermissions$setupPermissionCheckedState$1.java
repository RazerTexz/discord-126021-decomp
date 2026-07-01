package com.discord.widgets.channels.permissions;

import com.discord.utilities.stateful.StatefulViews;
import com.discord.views.TernaryCheckBox$b;

/* JADX INFO: compiled from: WidgetChannelSettingsEditPermissions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsEditPermissions$setupPermissionCheckedState$1 implements TernaryCheckBox$b {
    public final /* synthetic */ int $checkboxId;
    public final /* synthetic */ WidgetChannelSettingsEditPermissions this$0;

    public WidgetChannelSettingsEditPermissions$setupPermissionCheckedState$1(WidgetChannelSettingsEditPermissions widgetChannelSettingsEditPermissions, int i) {
        this.this$0 = widgetChannelSettingsEditPermissions;
        this.$checkboxId = i;
    }

    @Override // com.discord.views.TernaryCheckBox$b
    public void onSwitchStatusChanged(int switchStatus) {
        StatefulViews statefulViewsAccess$getState$p = WidgetChannelSettingsEditPermissions.access$getState$p(this.this$0);
        if (statefulViewsAccess$getState$p != null) {
            statefulViewsAccess$getState$p.put(this.$checkboxId, Integer.valueOf(switchStatus));
        }
        StatefulViews statefulViewsAccess$getState$p2 = WidgetChannelSettingsEditPermissions.access$getState$p(this.this$0);
        if (statefulViewsAccess$getState$p2 != null) {
            statefulViewsAccess$getState$p2.configureSaveActionView(WidgetChannelSettingsEditPermissions.access$getBinding$p(this.this$0).H);
        }
    }
}
