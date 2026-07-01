package com.discord.widgets.servers;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsModeration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsModeration$Model {
    public static final WidgetServerSettingsModeration$Model$Companion Companion = new WidgetServerSettingsModeration$Model$Companion(null);
    private final Guild guild;

    public WidgetServerSettingsModeration$Model(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        this.guild = guild;
    }

    public static /* synthetic */ WidgetServerSettingsModeration$Model copy$default(WidgetServerSettingsModeration$Model widgetServerSettingsModeration$Model, Guild guild, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = widgetServerSettingsModeration$Model.guild;
        }
        return widgetServerSettingsModeration$Model.copy(guild);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final WidgetServerSettingsModeration$Model copy(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        return new WidgetServerSettingsModeration$Model(guild);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetServerSettingsModeration$Model) && m.areEqual(this.guild, ((WidgetServerSettingsModeration$Model) other).guild);
        }
        return true;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public int hashCode() {
        Guild guild = this.guild;
        if (guild != null) {
            return guild.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(guild=");
        sbU.append(this.guild);
        sbU.append(")");
        return sbU.toString();
    }
}
