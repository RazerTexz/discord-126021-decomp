package com.discord.widgets.servers;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter$Payload;
import d0.z.d.m;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsChannels$Model {
    public static final WidgetServerSettingsChannels$Model$Companion Companion = new WidgetServerSettingsChannels$Model$Companion(null);
    private final Map<Long, Long> channelPermissions;
    private final Map<Long, Channel> channels;
    private final Guild guild;
    private final boolean isSorting;
    private final List<CategoricalDragAndDropAdapter$Payload> items;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetServerSettingsChannels$Model(Guild guild, List<? extends CategoricalDragAndDropAdapter$Payload> list, boolean z2, Map<Long, Channel> map, Map<Long, Long> map2) {
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(list, "items");
        m.checkNotNullParameter(map, "channels");
        m.checkNotNullParameter(map2, "channelPermissions");
        this.guild = guild;
        this.items = list;
        this.isSorting = z2;
        this.channels = map;
        this.channelPermissions = map2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetServerSettingsChannels$Model copy$default(WidgetServerSettingsChannels$Model widgetServerSettingsChannels$Model, Guild guild, List list, boolean z2, Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = widgetServerSettingsChannels$Model.guild;
        }
        if ((i & 2) != 0) {
            list = widgetServerSettingsChannels$Model.items;
        }
        List list2 = list;
        if ((i & 4) != 0) {
            z2 = widgetServerSettingsChannels$Model.isSorting;
        }
        boolean z3 = z2;
        if ((i & 8) != 0) {
            map = widgetServerSettingsChannels$Model.channels;
        }
        Map map3 = map;
        if ((i & 16) != 0) {
            map2 = widgetServerSettingsChannels$Model.channelPermissions;
        }
        return widgetServerSettingsChannels$Model.copy(guild, list2, z3, map3, map2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final List<CategoricalDragAndDropAdapter$Payload> component2() {
        return this.items;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsSorting() {
        return this.isSorting;
    }

    public final Map<Long, Channel> component4() {
        return this.channels;
    }

    public final Map<Long, Long> component5() {
        return this.channelPermissions;
    }

    public final WidgetServerSettingsChannels$Model copy(Guild guild, List<? extends CategoricalDragAndDropAdapter$Payload> items, boolean isSorting, Map<Long, Channel> channels, Map<Long, Long> channelPermissions) {
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(items, "items");
        m.checkNotNullParameter(channels, "channels");
        m.checkNotNullParameter(channelPermissions, "channelPermissions");
        return new WidgetServerSettingsChannels$Model(guild, items, isSorting, channels, channelPermissions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetServerSettingsChannels$Model)) {
            return false;
        }
        WidgetServerSettingsChannels$Model widgetServerSettingsChannels$Model = (WidgetServerSettingsChannels$Model) other;
        return m.areEqual(this.guild, widgetServerSettingsChannels$Model.guild) && m.areEqual(this.items, widgetServerSettingsChannels$Model.items) && this.isSorting == widgetServerSettingsChannels$Model.isSorting && m.areEqual(this.channels, widgetServerSettingsChannels$Model.channels) && m.areEqual(this.channelPermissions, widgetServerSettingsChannels$Model.channelPermissions);
    }

    public final Map<Long, Long> getChannelPermissions() {
        return this.channelPermissions;
    }

    public final Map<Long, Channel> getChannels() {
        return this.channels;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final List<CategoricalDragAndDropAdapter$Payload> getItems() {
        return this.items;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        List<CategoricalDragAndDropAdapter$Payload> list = this.items;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.isSorting;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode2 + r2) * 31;
        Map<Long, Channel> map = this.channels;
        int iHashCode3 = (i + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, Long> map2 = this.channelPermissions;
        return iHashCode3 + (map2 != null ? map2.hashCode() : 0);
    }

    public final boolean isSorting() {
        return this.isSorting;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(guild=");
        sbU.append(this.guild);
        sbU.append(", items=");
        sbU.append(this.items);
        sbU.append(", isSorting=");
        sbU.append(this.isSorting);
        sbU.append(", channels=");
        sbU.append(this.channels);
        sbU.append(", channelPermissions=");
        return a.M(sbU, this.channelPermissions, ")");
    }
}
