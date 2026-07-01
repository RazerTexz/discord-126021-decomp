package com.discord.widgets.settings.connections;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.connectedaccounts.ConnectedAccountIntegration;

/* JADX INFO: compiled from: WidgetSettingsUserConnections.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$7 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsUserConnections$UserConnectionItem $data$inlined;
    public final /* synthetic */ ConnectedAccountIntegration $integration$inlined;
    public final /* synthetic */ WidgetSettingsUserConnections$Adapter$ViewHolder this$0;

    public WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$7(ConnectedAccountIntegration connectedAccountIntegration, WidgetSettingsUserConnections$Adapter$ViewHolder widgetSettingsUserConnections$Adapter$ViewHolder, WidgetSettingsUserConnections$UserConnectionItem widgetSettingsUserConnections$UserConnectionItem) {
        this.$integration$inlined = connectedAccountIntegration;
        this.this$0 = widgetSettingsUserConnections$Adapter$ViewHolder;
        this.$data$inlined = widgetSettingsUserConnections$UserConnectionItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.this$0.getOnJoinIntegration().invoke(this.$integration$inlined.getId());
    }
}
