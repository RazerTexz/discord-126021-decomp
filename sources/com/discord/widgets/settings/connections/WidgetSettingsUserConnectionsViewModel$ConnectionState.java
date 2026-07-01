package com.discord.widgets.settings.connections;

import b.d.b.a.a;
import com.discord.api.connectedaccounts.ConnectedAccount;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: WidgetSettingsUserConnectionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetSettingsUserConnectionsViewModel$ConnectionState {
    private final ConnectedAccount connection;
    private final Map<String, WidgetSettingsUserConnectionsViewModel$JoinStatus> integrationGuildJoinStatus;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetSettingsUserConnectionsViewModel$ConnectionState(ConnectedAccount connectedAccount, Map<String, ? extends WidgetSettingsUserConnectionsViewModel$JoinStatus> map) {
        m.checkNotNullParameter(connectedAccount, "connection");
        m.checkNotNullParameter(map, "integrationGuildJoinStatus");
        this.connection = connectedAccount;
        this.integrationGuildJoinStatus = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetSettingsUserConnectionsViewModel$ConnectionState copy$default(WidgetSettingsUserConnectionsViewModel$ConnectionState widgetSettingsUserConnectionsViewModel$ConnectionState, ConnectedAccount connectedAccount, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            connectedAccount = widgetSettingsUserConnectionsViewModel$ConnectionState.connection;
        }
        if ((i & 2) != 0) {
            map = widgetSettingsUserConnectionsViewModel$ConnectionState.integrationGuildJoinStatus;
        }
        return widgetSettingsUserConnectionsViewModel$ConnectionState.copy(connectedAccount, map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ConnectedAccount getConnection() {
        return this.connection;
    }

    public final Map<String, WidgetSettingsUserConnectionsViewModel$JoinStatus> component2() {
        return this.integrationGuildJoinStatus;
    }

    public final WidgetSettingsUserConnectionsViewModel$ConnectionState copy(ConnectedAccount connection, Map<String, ? extends WidgetSettingsUserConnectionsViewModel$JoinStatus> integrationGuildJoinStatus) {
        m.checkNotNullParameter(connection, "connection");
        m.checkNotNullParameter(integrationGuildJoinStatus, "integrationGuildJoinStatus");
        return new WidgetSettingsUserConnectionsViewModel$ConnectionState(connection, integrationGuildJoinStatus);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetSettingsUserConnectionsViewModel$ConnectionState)) {
            return false;
        }
        WidgetSettingsUserConnectionsViewModel$ConnectionState widgetSettingsUserConnectionsViewModel$ConnectionState = (WidgetSettingsUserConnectionsViewModel$ConnectionState) other;
        return m.areEqual(this.connection, widgetSettingsUserConnectionsViewModel$ConnectionState.connection) && m.areEqual(this.integrationGuildJoinStatus, widgetSettingsUserConnectionsViewModel$ConnectionState.integrationGuildJoinStatus);
    }

    public final ConnectedAccount getConnection() {
        return this.connection;
    }

    public final Map<String, WidgetSettingsUserConnectionsViewModel$JoinStatus> getIntegrationGuildJoinStatus() {
        return this.integrationGuildJoinStatus;
    }

    public int hashCode() {
        ConnectedAccount connectedAccount = this.connection;
        int iHashCode = (connectedAccount != null ? connectedAccount.hashCode() : 0) * 31;
        Map<String, WidgetSettingsUserConnectionsViewModel$JoinStatus> map = this.integrationGuildJoinStatus;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ConnectionState(connection=");
        sbU.append(this.connection);
        sbU.append(", integrationGuildJoinStatus=");
        return a.M(sbU, this.integrationGuildJoinStatus, ")");
    }
}
