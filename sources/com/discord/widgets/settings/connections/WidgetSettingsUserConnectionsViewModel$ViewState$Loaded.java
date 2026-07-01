package com.discord.widgets.settings.connections;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetSettingsUserConnectionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetSettingsUserConnectionsViewModel$ViewState$Loaded extends WidgetSettingsUserConnectionsViewModel$ViewState {
    private final List<WidgetSettingsUserConnectionsViewModel$ConnectionState> data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsUserConnectionsViewModel$ViewState$Loaded(List<WidgetSettingsUserConnectionsViewModel$ConnectionState> list) {
        super(null);
        m.checkNotNullParameter(list, "data");
        this.data = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetSettingsUserConnectionsViewModel$ViewState$Loaded copy$default(WidgetSettingsUserConnectionsViewModel$ViewState$Loaded widgetSettingsUserConnectionsViewModel$ViewState$Loaded, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = widgetSettingsUserConnectionsViewModel$ViewState$Loaded.data;
        }
        return widgetSettingsUserConnectionsViewModel$ViewState$Loaded.copy(list);
    }

    public final List<WidgetSettingsUserConnectionsViewModel$ConnectionState> component1() {
        return this.data;
    }

    public final WidgetSettingsUserConnectionsViewModel$ViewState$Loaded copy(List<WidgetSettingsUserConnectionsViewModel$ConnectionState> data) {
        m.checkNotNullParameter(data, "data");
        return new WidgetSettingsUserConnectionsViewModel$ViewState$Loaded(data);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetSettingsUserConnectionsViewModel$ViewState$Loaded) && m.areEqual(this.data, ((WidgetSettingsUserConnectionsViewModel$ViewState$Loaded) other).data);
        }
        return true;
    }

    public final List<WidgetSettingsUserConnectionsViewModel$ConnectionState> getData() {
        return this.data;
    }

    public int hashCode() {
        List<WidgetSettingsUserConnectionsViewModel$ConnectionState> list = this.data;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.L(a.U("Loaded(data="), this.data, ")");
    }
}
