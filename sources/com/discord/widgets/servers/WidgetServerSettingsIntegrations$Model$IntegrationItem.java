package com.discord.widgets.servers;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.domain.ModelGuildIntegration;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsIntegrations.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsIntegrations$Model$IntegrationItem implements MGRecyclerDataPayload {
    public static final WidgetServerSettingsIntegrations$Model$IntegrationItem$Companion Companion = new WidgetServerSettingsIntegrations$Model$IntegrationItem$Companion(null);
    public static final int TYPE_INTEGRATION = 0;
    private final long guildId;
    private final ModelGuildIntegration integration;
    private final String key;
    private final int type;

    public WidgetServerSettingsIntegrations$Model$IntegrationItem(ModelGuildIntegration modelGuildIntegration, long j) {
        m.checkNotNullParameter(modelGuildIntegration, "integration");
        this.integration = modelGuildIntegration;
        this.guildId = j;
        this.key = String.valueOf(modelGuildIntegration.getId());
    }

    public static /* synthetic */ WidgetServerSettingsIntegrations$Model$IntegrationItem copy$default(WidgetServerSettingsIntegrations$Model$IntegrationItem widgetServerSettingsIntegrations$Model$IntegrationItem, ModelGuildIntegration modelGuildIntegration, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            modelGuildIntegration = widgetServerSettingsIntegrations$Model$IntegrationItem.integration;
        }
        if ((i & 2) != 0) {
            j = widgetServerSettingsIntegrations$Model$IntegrationItem.guildId;
        }
        return widgetServerSettingsIntegrations$Model$IntegrationItem.copy(modelGuildIntegration, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelGuildIntegration getIntegration() {
        return this.integration;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final WidgetServerSettingsIntegrations$Model$IntegrationItem copy(ModelGuildIntegration integration, long guildId) {
        m.checkNotNullParameter(integration, "integration");
        return new WidgetServerSettingsIntegrations$Model$IntegrationItem(integration, guildId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetServerSettingsIntegrations$Model$IntegrationItem)) {
            return false;
        }
        WidgetServerSettingsIntegrations$Model$IntegrationItem widgetServerSettingsIntegrations$Model$IntegrationItem = (WidgetServerSettingsIntegrations$Model$IntegrationItem) other;
        return m.areEqual(this.integration, widgetServerSettingsIntegrations$Model$IntegrationItem.integration) && this.guildId == widgetServerSettingsIntegrations$Model$IntegrationItem.guildId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final ModelGuildIntegration getIntegration() {
        return this.integration;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        ModelGuildIntegration modelGuildIntegration = this.integration;
        return b.a(this.guildId) + ((modelGuildIntegration != null ? modelGuildIntegration.hashCode() : 0) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("IntegrationItem(integration=");
        sbU.append(this.integration);
        sbU.append(", guildId=");
        return a.C(sbU, this.guildId, ")");
    }
}
