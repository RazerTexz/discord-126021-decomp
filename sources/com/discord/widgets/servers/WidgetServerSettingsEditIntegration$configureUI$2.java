package com.discord.widgets.servers;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditIntegration$configureUI$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsEditIntegration$Model $model;

    public WidgetServerSettingsEditIntegration$configureUI$2(WidgetServerSettingsEditIntegration$Model widgetServerSettingsEditIntegration$Model) {
        this.$model = widgetServerSettingsEditIntegration$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsEditRole$Companion widgetServerSettingsEditRole$Companion = WidgetServerSettingsEditRole.Companion;
        long id2 = this.$model.getGuild().getId();
        long id3 = this.$model.getRole().getId();
        m.checkNotNullExpressionValue(view, "v");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "v.context");
        widgetServerSettingsEditRole$Companion.launch(id2, id3, context);
    }
}
