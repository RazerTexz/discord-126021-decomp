package com.discord.widgets.settings.connections;

import android.widget.CompoundButton;
import android.widget.CompoundButton$OnCheckedChangeListener;
import com.discord.api.connectedaccounts.ConnectedAccount;

/* JADX INFO: compiled from: WidgetSettingsUserConnections.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$5 implements CompoundButton$OnCheckedChangeListener {
    public final /* synthetic */ ConnectedAccount $connectedAccount;
    public final /* synthetic */ WidgetSettingsUserConnections$UserConnectionItem $data$inlined;
    public final /* synthetic */ WidgetSettingsUserConnections$Adapter$ViewHolder this$0;

    public WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$5(ConnectedAccount connectedAccount, WidgetSettingsUserConnections$Adapter$ViewHolder widgetSettingsUserConnections$Adapter$ViewHolder, WidgetSettingsUserConnections$UserConnectionItem widgetSettingsUserConnections$UserConnectionItem) {
        this.$connectedAccount = connectedAccount;
        this.this$0 = widgetSettingsUserConnections$Adapter$ViewHolder;
        this.$data$inlined = widgetSettingsUserConnections$UserConnectionItem;
    }

    @Override // android.widget.CompoundButton$OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        WidgetSettingsUserConnections$Adapter$ViewHolder.access$updateUserConnection(this.this$0, this.$connectedAccount);
    }
}
