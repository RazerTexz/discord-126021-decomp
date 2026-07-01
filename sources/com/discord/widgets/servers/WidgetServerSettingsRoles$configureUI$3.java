package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetServerSettingsRoles.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRoles$configureUI$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsRoles$Model $data;
    public final /* synthetic */ WidgetServerSettingsRoles this$0;

    public WidgetServerSettingsRoles$configureUI$3(WidgetServerSettingsRoles widgetServerSettingsRoles, WidgetServerSettingsRoles$Model widgetServerSettingsRoles$Model) {
        this.this$0 = widgetServerSettingsRoles;
        this.$data = widgetServerSettingsRoles$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsRoles.access$createRole(this.this$0, this.$data.getGuildId(), this.$data);
    }
}
