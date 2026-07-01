package com.discord.widgets.settings.connections;

import b.d.b.a.a;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: WidgetSettingsUserConnectionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetSettingsUserConnectionsViewModel$StoreState {
    private final List<ConnectedAccount> connectedAccounts;
    private final Map<Long, Guild> guilds;

    public WidgetSettingsUserConnectionsViewModel$StoreState(List<ConnectedAccount> list, Map<Long, Guild> map) {
        m.checkNotNullParameter(list, "connectedAccounts");
        m.checkNotNullParameter(map, "guilds");
        this.connectedAccounts = list;
        this.guilds = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetSettingsUserConnectionsViewModel$StoreState copy$default(WidgetSettingsUserConnectionsViewModel$StoreState widgetSettingsUserConnectionsViewModel$StoreState, List list, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            list = widgetSettingsUserConnectionsViewModel$StoreState.connectedAccounts;
        }
        if ((i & 2) != 0) {
            map = widgetSettingsUserConnectionsViewModel$StoreState.guilds;
        }
        return widgetSettingsUserConnectionsViewModel$StoreState.copy(list, map);
    }

    public final List<ConnectedAccount> component1() {
        return this.connectedAccounts;
    }

    public final Map<Long, Guild> component2() {
        return this.guilds;
    }

    public final WidgetSettingsUserConnectionsViewModel$StoreState copy(List<ConnectedAccount> connectedAccounts, Map<Long, Guild> guilds) {
        m.checkNotNullParameter(connectedAccounts, "connectedAccounts");
        m.checkNotNullParameter(guilds, "guilds");
        return new WidgetSettingsUserConnectionsViewModel$StoreState(connectedAccounts, guilds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetSettingsUserConnectionsViewModel$StoreState)) {
            return false;
        }
        WidgetSettingsUserConnectionsViewModel$StoreState widgetSettingsUserConnectionsViewModel$StoreState = (WidgetSettingsUserConnectionsViewModel$StoreState) other;
        return m.areEqual(this.connectedAccounts, widgetSettingsUserConnectionsViewModel$StoreState.connectedAccounts) && m.areEqual(this.guilds, widgetSettingsUserConnectionsViewModel$StoreState.guilds);
    }

    public final List<ConnectedAccount> getConnectedAccounts() {
        return this.connectedAccounts;
    }

    public final Map<Long, Guild> getGuilds() {
        return this.guilds;
    }

    public int hashCode() {
        List<ConnectedAccount> list = this.connectedAccounts;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        Map<Long, Guild> map = this.guilds;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(connectedAccounts=");
        sbU.append(this.connectedAccounts);
        sbU.append(", guilds=");
        return a.M(sbU, this.guilds, ")");
    }
}
