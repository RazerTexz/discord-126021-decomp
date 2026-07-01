package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.restapi.RestAPIParams$Role;

/* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditRole$enableSetting$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsEditRole$Model $data;
    public final /* synthetic */ long $permission;
    public final /* synthetic */ WidgetServerSettingsEditRole this$0;

    public WidgetServerSettingsEditRole$enableSetting$1(WidgetServerSettingsEditRole widgetServerSettingsEditRole, WidgetServerSettingsEditRole$Model widgetServerSettingsEditRole$Model, long j) {
        this.this$0 = widgetServerSettingsEditRole;
        this.$data = widgetServerSettingsEditRole$Model;
        this.$permission = j;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsEditRole.access$getBinding$p(this.this$0).f2371b.clearFocus();
        RestAPIParams$Role restAPIParams$RoleCreateWithRole = RestAPIParams$Role.Companion.createWithRole(this.$data.getRole());
        restAPIParams$RoleCreateWithRole.setPermissions(Long.valueOf(this.$data.getRole().getPermissions() ^ this.$permission));
        WidgetServerSettingsEditRole.access$patchRole(this.this$0, this.$data.getGuildId(), restAPIParams$RoleCreateWithRole);
    }
}
