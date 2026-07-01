package com.discord.widgets.servers;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsEmojis$Model {
    public static final WidgetServerSettingsEmojis$Model$Companion Companion = new WidgetServerSettingsEmojis$Model$Companion(null);
    private final String defaultName;
    private final Guild guild;
    private final List<WidgetServerSettingsEmojis$Item> items;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetServerSettingsEmojis$Model(Guild guild, List<? extends WidgetServerSettingsEmojis$Item> list, String str) {
        m.checkNotNullParameter(guild, "guild");
        this.guild = guild;
        this.items = list;
        this.defaultName = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetServerSettingsEmojis$Model copy$default(WidgetServerSettingsEmojis$Model widgetServerSettingsEmojis$Model, Guild guild, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = widgetServerSettingsEmojis$Model.guild;
        }
        if ((i & 2) != 0) {
            list = widgetServerSettingsEmojis$Model.items;
        }
        if ((i & 4) != 0) {
            str = widgetServerSettingsEmojis$Model.defaultName;
        }
        return widgetServerSettingsEmojis$Model.copy(guild, list, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final List<WidgetServerSettingsEmojis$Item> component2() {
        return this.items;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDefaultName() {
        return this.defaultName;
    }

    public final WidgetServerSettingsEmojis$Model copy(Guild guild, List<? extends WidgetServerSettingsEmojis$Item> items, String defaultName) {
        m.checkNotNullParameter(guild, "guild");
        return new WidgetServerSettingsEmojis$Model(guild, items, defaultName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetServerSettingsEmojis$Model)) {
            return false;
        }
        WidgetServerSettingsEmojis$Model widgetServerSettingsEmojis$Model = (WidgetServerSettingsEmojis$Model) other;
        return m.areEqual(this.guild, widgetServerSettingsEmojis$Model.guild) && m.areEqual(this.items, widgetServerSettingsEmojis$Model.items) && m.areEqual(this.defaultName, widgetServerSettingsEmojis$Model.defaultName);
    }

    public final String getDefaultName() {
        return this.defaultName;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final List<WidgetServerSettingsEmojis$Item> getItems() {
        return this.items;
    }

    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        List<WidgetServerSettingsEmojis$Item> list = this.items;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str = this.defaultName;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(guild=");
        sbU.append(this.guild);
        sbU.append(", items=");
        sbU.append(this.items);
        sbU.append(", defaultName=");
        return a.J(sbU, this.defaultName, ")");
    }
}
