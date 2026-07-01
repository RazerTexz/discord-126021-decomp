package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsSecurity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsSecurity$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsSecurity$Model $model;
    public final /* synthetic */ WidgetServerSettingsSecurity this$0;

    public WidgetServerSettingsSecurity$configureUI$1(WidgetServerSettingsSecurity widgetServerSettingsSecurity, WidgetServerSettingsSecurity$Model widgetServerSettingsSecurity$Model) {
        this.this$0 = widgetServerSettingsSecurity;
        this.$model = widgetServerSettingsSecurity$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsSecurity$ToggleMfaDialog$Companion widgetServerSettingsSecurity$ToggleMfaDialog$Companion = WidgetServerSettingsSecurity$ToggleMfaDialog.Companion;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetServerSettingsSecurity$ToggleMfaDialog$Companion.show(parentFragmentManager, this.$model.getGuildId(), this.$model.isMfaEnabled());
    }
}
