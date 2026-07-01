package com.discord.widgets.servers;

import b.k.a.a.f;
import com.discord.restapi.RestAPIParams$Role;
import com.discord.utilities.color.ColorCompat;

/* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditRole$launchColorPicker$1 implements f {
    public final /* synthetic */ WidgetServerSettingsEditRole$Model $data;
    public final /* synthetic */ WidgetServerSettingsEditRole this$0;

    public WidgetServerSettingsEditRole$launchColorPicker$1(WidgetServerSettingsEditRole widgetServerSettingsEditRole, WidgetServerSettingsEditRole$Model widgetServerSettingsEditRole$Model) {
        this.this$0 = widgetServerSettingsEditRole;
        this.$data = widgetServerSettingsEditRole$Model;
    }

    @Override // b.k.a.a.f
    public void onColorReset(int dialogId) {
        RestAPIParams$Role restAPIParams$RoleCreateWithRole = RestAPIParams$Role.Companion.createWithRole(this.$data.getRole());
        restAPIParams$RoleCreateWithRole.setColor(0);
        WidgetServerSettingsEditRole.access$patchRole(this.this$0, this.$data.getGuildId(), restAPIParams$RoleCreateWithRole);
    }

    @Override // b.k.a.a.f
    public void onColorSelected(int dialogId, int selectedColor) {
        RestAPIParams$Role restAPIParams$RoleCreateWithRole = RestAPIParams$Role.Companion.createWithRole(this.$data.getRole());
        restAPIParams$RoleCreateWithRole.setColor(Integer.valueOf(ColorCompat.INSTANCE.removeAlphaComponent(selectedColor)));
        WidgetServerSettingsEditRole.access$patchRole(this.this$0, this.$data.getGuildId(), restAPIParams$RoleCreateWithRole);
    }

    @Override // b.k.a.a.f
    public void onDialogDismissed(int dialogId) {
    }
}
