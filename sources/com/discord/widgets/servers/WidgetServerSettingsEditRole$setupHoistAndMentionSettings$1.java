package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.restapi.RestAPIParams$Role;
import com.discord.views.CheckedSetting;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditRole$setupHoistAndMentionSettings$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsEditRole$Model $data;
    public final /* synthetic */ WidgetServerSettingsEditRole this$0;

    public WidgetServerSettingsEditRole$setupHoistAndMentionSettings$1(WidgetServerSettingsEditRole widgetServerSettingsEditRole, WidgetServerSettingsEditRole$Model widgetServerSettingsEditRole$Model) {
        this.this$0 = widgetServerSettingsEditRole;
        this.$data = widgetServerSettingsEditRole$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsEditRole.access$getBinding$p(this.this$0).f2371b.clearFocus();
        RestAPIParams$Role restAPIParams$RoleCreateWithRole = RestAPIParams$Role.Companion.createWithRole(this.$data.getRole());
        CheckedSetting checkedSetting = WidgetServerSettingsEditRole.access$getBinding$p(this.this$0).q;
        m.checkNotNullExpressionValue(checkedSetting, "binding.roleSettingsHoistCheckedsetting");
        restAPIParams$RoleCreateWithRole.setHoist(Boolean.valueOf(!checkedSetting.isChecked()));
        WidgetServerSettingsEditRole.access$patchRole(this.this$0, this.$data.getGuildId(), restAPIParams$RoleCreateWithRole);
    }
}
