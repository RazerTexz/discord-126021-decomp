package com.discord.widgets.channels.permissions;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.permission.PermissionOverwrite$Type;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragmentViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelSettingsAddMemberFragmentViewModel$ViewState {
    private final Channel channel;
    private final Guild guild;
    private final List<AddMemberAdapter$Item> items;
    private final String query;
    private final Map<Long, PermissionOverwrite$Type> selected;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChannelSettingsAddMemberFragmentViewModel$ViewState(Guild guild, Channel channel, String str, List<? extends AddMemberAdapter$Item> list, Map<Long, ? extends PermissionOverwrite$Type> map) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(str, "query");
        m.checkNotNullParameter(list, "items");
        m.checkNotNullParameter(map, "selected");
        this.guild = guild;
        this.channel = channel;
        this.query = str;
        this.items = list;
        this.selected = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChannelSettingsAddMemberFragmentViewModel$ViewState copy$default(WidgetChannelSettingsAddMemberFragmentViewModel$ViewState widgetChannelSettingsAddMemberFragmentViewModel$ViewState, Guild guild, Channel channel, String str, List list, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = widgetChannelSettingsAddMemberFragmentViewModel$ViewState.guild;
        }
        if ((i & 2) != 0) {
            channel = widgetChannelSettingsAddMemberFragmentViewModel$ViewState.channel;
        }
        Channel channel2 = channel;
        if ((i & 4) != 0) {
            str = widgetChannelSettingsAddMemberFragmentViewModel$ViewState.query;
        }
        String str2 = str;
        if ((i & 8) != 0) {
            list = widgetChannelSettingsAddMemberFragmentViewModel$ViewState.items;
        }
        List list2 = list;
        if ((i & 16) != 0) {
            map = widgetChannelSettingsAddMemberFragmentViewModel$ViewState.selected;
        }
        return widgetChannelSettingsAddMemberFragmentViewModel$ViewState.copy(guild, channel2, str2, list2, map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getQuery() {
        return this.query;
    }

    public final List<AddMemberAdapter$Item> component4() {
        return this.items;
    }

    public final Map<Long, PermissionOverwrite$Type> component5() {
        return this.selected;
    }

    public final WidgetChannelSettingsAddMemberFragmentViewModel$ViewState copy(Guild guild, Channel channel, String query, List<? extends AddMemberAdapter$Item> items, Map<Long, ? extends PermissionOverwrite$Type> selected) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(query, "query");
        m.checkNotNullParameter(items, "items");
        m.checkNotNullParameter(selected, "selected");
        return new WidgetChannelSettingsAddMemberFragmentViewModel$ViewState(guild, channel, query, items, selected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelSettingsAddMemberFragmentViewModel$ViewState)) {
            return false;
        }
        WidgetChannelSettingsAddMemberFragmentViewModel$ViewState widgetChannelSettingsAddMemberFragmentViewModel$ViewState = (WidgetChannelSettingsAddMemberFragmentViewModel$ViewState) other;
        return m.areEqual(this.guild, widgetChannelSettingsAddMemberFragmentViewModel$ViewState.guild) && m.areEqual(this.channel, widgetChannelSettingsAddMemberFragmentViewModel$ViewState.channel) && m.areEqual(this.query, widgetChannelSettingsAddMemberFragmentViewModel$ViewState.query) && m.areEqual(this.items, widgetChannelSettingsAddMemberFragmentViewModel$ViewState.items) && m.areEqual(this.selected, widgetChannelSettingsAddMemberFragmentViewModel$ViewState.selected);
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final List<AddMemberAdapter$Item> getItems() {
        return this.items;
    }

    public final String getQuery() {
        return this.query;
    }

    public final Map<Long, PermissionOverwrite$Type> getSelected() {
        return this.selected;
    }

    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        Channel channel = this.channel;
        int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
        String str = this.query;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        List<AddMemberAdapter$Item> list = this.items;
        int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        Map<Long, PermissionOverwrite$Type> map = this.selected;
        return iHashCode4 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(guild=");
        sbU.append(this.guild);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", query=");
        sbU.append(this.query);
        sbU.append(", items=");
        sbU.append(this.items);
        sbU.append(", selected=");
        return a.M(sbU, this.selected, ")");
    }
}
