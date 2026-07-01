package com.discord.widgets.servers;

import b.d.b.a.a;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelGuildIntegration;
import com.discord.models.guild.Guild;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsEditIntegration$Model {
    public static final WidgetServerSettingsEditIntegration$Model$Companion Companion = new WidgetServerSettingsEditIntegration$Model$Companion(null);
    private final Guild guild;
    private final ModelGuildIntegration integration;
    private final GuildRole role;

    public WidgetServerSettingsEditIntegration$Model(Guild guild, ModelGuildIntegration modelGuildIntegration, GuildRole guildRole) {
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(modelGuildIntegration, "integration");
        this.guild = guild;
        this.integration = modelGuildIntegration;
        this.role = guildRole;
    }

    public static /* synthetic */ WidgetServerSettingsEditIntegration$Model copy$default(WidgetServerSettingsEditIntegration$Model widgetServerSettingsEditIntegration$Model, Guild guild, ModelGuildIntegration modelGuildIntegration, GuildRole guildRole, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = widgetServerSettingsEditIntegration$Model.guild;
        }
        if ((i & 2) != 0) {
            modelGuildIntegration = widgetServerSettingsEditIntegration$Model.integration;
        }
        if ((i & 4) != 0) {
            guildRole = widgetServerSettingsEditIntegration$Model.role;
        }
        return widgetServerSettingsEditIntegration$Model.copy(guild, modelGuildIntegration, guildRole);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ModelGuildIntegration getIntegration() {
        return this.integration;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final GuildRole getRole() {
        return this.role;
    }

    public final WidgetServerSettingsEditIntegration$Model copy(Guild guild, ModelGuildIntegration integration, GuildRole role) {
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(integration, "integration");
        return new WidgetServerSettingsEditIntegration$Model(guild, integration, role);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetServerSettingsEditIntegration$Model)) {
            return false;
        }
        WidgetServerSettingsEditIntegration$Model widgetServerSettingsEditIntegration$Model = (WidgetServerSettingsEditIntegration$Model) other;
        return m.areEqual(this.guild, widgetServerSettingsEditIntegration$Model.guild) && m.areEqual(this.integration, widgetServerSettingsEditIntegration$Model.integration) && m.areEqual(this.role, widgetServerSettingsEditIntegration$Model.role);
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final ModelGuildIntegration getIntegration() {
        return this.integration;
    }

    public final GuildRole getRole() {
        return this.role;
    }

    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        ModelGuildIntegration modelGuildIntegration = this.integration;
        int iHashCode2 = (iHashCode + (modelGuildIntegration != null ? modelGuildIntegration.hashCode() : 0)) * 31;
        GuildRole guildRole = this.role;
        return iHashCode2 + (guildRole != null ? guildRole.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(guild=");
        sbU.append(this.guild);
        sbU.append(", integration=");
        sbU.append(this.integration);
        sbU.append(", role=");
        sbU.append(this.role);
        sbU.append(")");
        return sbU.toString();
    }
}
