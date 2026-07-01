package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.R$id;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.views.CheckedSetting;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditIntegration$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsEditIntegration this$0;

    public WidgetServerSettingsEditIntegration$onViewBound$2(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration) {
        this.this$0 = widgetServerSettingsEditIntegration;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsEditIntegration.access$getBinding$p(this.this$0).d.toggle();
        StatefulViews statefulViewsAccess$getState$p = WidgetServerSettingsEditIntegration.access$getState$p(this.this$0);
        CheckedSetting checkedSetting = WidgetServerSettingsEditIntegration.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(checkedSetting, "binding.editIntegrationCustomEmotesToggle");
        statefulViewsAccess$getState$p.put(R$id.edit_integration_custom_emotes_toggle, Boolean.valueOf(checkedSetting.isChecked()));
        WidgetServerSettingsEditIntegration.access$getState$p(this.this$0).configureSaveActionView(WidgetServerSettingsEditIntegration.access$getBinding$p(this.this$0).o);
    }
}
