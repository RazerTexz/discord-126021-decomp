package com.discord.widgets.servers;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetServerSettingsIntegrations.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsIntegrations$Model {
    public static final WidgetServerSettingsIntegrations$Model$Companion Companion = new WidgetServerSettingsIntegrations$Model$Companion(null);
    private final long guildId;
    private final String guildName;
    private final List<WidgetServerSettingsIntegrations$Model$IntegrationItem> integrations;

    public WidgetServerSettingsIntegrations$Model(long j, String str, List<WidgetServerSettingsIntegrations$Model$IntegrationItem> list) {
        m.checkNotNullParameter(str, "guildName");
        m.checkNotNullParameter(list, "integrations");
        this.guildId = j;
        this.guildName = str;
        this.integrations = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetServerSettingsIntegrations$Model copy$default(WidgetServerSettingsIntegrations$Model widgetServerSettingsIntegrations$Model, long j, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetServerSettingsIntegrations$Model.guildId;
        }
        if ((i & 2) != 0) {
            str = widgetServerSettingsIntegrations$Model.guildName;
        }
        if ((i & 4) != 0) {
            list = widgetServerSettingsIntegrations$Model.integrations;
        }
        return widgetServerSettingsIntegrations$Model.copy(j, str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    public final List<WidgetServerSettingsIntegrations$Model$IntegrationItem> component3() {
        return this.integrations;
    }

    public final WidgetServerSettingsIntegrations$Model copy(long guildId, String guildName, List<WidgetServerSettingsIntegrations$Model$IntegrationItem> integrations) {
        m.checkNotNullParameter(guildName, "guildName");
        m.checkNotNullParameter(integrations, "integrations");
        return new WidgetServerSettingsIntegrations$Model(guildId, guildName, integrations);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetServerSettingsIntegrations$Model)) {
            return false;
        }
        WidgetServerSettingsIntegrations$Model widgetServerSettingsIntegrations$Model = (WidgetServerSettingsIntegrations$Model) other;
        return this.guildId == widgetServerSettingsIntegrations$Model.guildId && m.areEqual(this.guildName, widgetServerSettingsIntegrations$Model.guildName) && m.areEqual(this.integrations, widgetServerSettingsIntegrations$Model.integrations);
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getGuildName() {
        return this.guildName;
    }

    public final List<WidgetServerSettingsIntegrations$Model$IntegrationItem> getIntegrations() {
        return this.integrations;
    }

    public int hashCode() {
        int iA = b.a(this.guildId) * 31;
        String str = this.guildName;
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        List<WidgetServerSettingsIntegrations$Model$IntegrationItem> list = this.integrations;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(guildId=");
        sbU.append(this.guildId);
        sbU.append(", guildName=");
        sbU.append(this.guildName);
        sbU.append(", integrations=");
        return a.L(sbU, this.integrations, ")");
    }
}
