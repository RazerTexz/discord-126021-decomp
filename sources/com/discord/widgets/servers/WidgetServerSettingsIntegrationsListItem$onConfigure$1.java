package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetServerSettingsIntegrationsListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsIntegrationsListItem$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ long $integrationId;
    public final /* synthetic */ WidgetServerSettingsIntegrationsListItem this$0;

    public WidgetServerSettingsIntegrationsListItem$onConfigure$1(WidgetServerSettingsIntegrationsListItem widgetServerSettingsIntegrationsListItem, long j) {
        this.this$0 = widgetServerSettingsIntegrationsListItem;
        this.$integrationId = j;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsIntegrationsListItem.access$getAdapter$p(this.this$0).onIntegrationSelected(this.$integrationId);
    }
}
