package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import b.a.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditRole$setupColorSetting$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsEditRole$Model $data;
    public final /* synthetic */ WidgetServerSettingsEditRole this$0;

    public WidgetServerSettingsEditRole$setupColorSetting$2(WidgetServerSettingsEditRole widgetServerSettingsEditRole, WidgetServerSettingsEditRole$Model widgetServerSettingsEditRole$Model) {
        this.this$0 = widgetServerSettingsEditRole;
        this.$data = widgetServerSettingsEditRole$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsEditRole widgetServerSettingsEditRole = this.this$0;
        m.j(widgetServerSettingsEditRole, WidgetServerSettingsEditRole.access$getLockMessage(widgetServerSettingsEditRole, this.$data, true), 0, 4);
    }
}
