package com.discord.widgets.settings.connections;

import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsUserConnections.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsUserConnections$UserConnectionItem implements MGRecyclerDataPayload {
    private final WidgetSettingsUserConnectionsViewModel$ConnectionState connectedAccount;
    private final String key;
    private final int type;

    public WidgetSettingsUserConnections$UserConnectionItem(WidgetSettingsUserConnectionsViewModel$ConnectionState widgetSettingsUserConnectionsViewModel$ConnectionState) {
        m.checkNotNullParameter(widgetSettingsUserConnectionsViewModel$ConnectionState, "connectedAccount");
        this.connectedAccount = widgetSettingsUserConnectionsViewModel$ConnectionState;
        this.key = widgetSettingsUserConnectionsViewModel$ConnectionState.getConnection().getId();
    }

    public final WidgetSettingsUserConnectionsViewModel$ConnectionState getConnectedAccount() {
        return this.connectedAccount;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }
}
