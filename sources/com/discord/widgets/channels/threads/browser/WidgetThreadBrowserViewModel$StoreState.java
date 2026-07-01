package com.discord.widgets.channels.threads.browser;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetThreadBrowserViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetThreadBrowserViewModel$StoreState {
    private final Channel channel;
    private final Guild guild;
    private final Long permissions;

    public WidgetThreadBrowserViewModel$StoreState(Channel channel, Guild guild, Long l) {
        this.channel = channel;
        this.guild = guild;
        this.permissions = l;
    }

    public static /* synthetic */ WidgetThreadBrowserViewModel$StoreState copy$default(WidgetThreadBrowserViewModel$StoreState widgetThreadBrowserViewModel$StoreState, Channel channel, Guild guild, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = widgetThreadBrowserViewModel$StoreState.channel;
        }
        if ((i & 2) != 0) {
            guild = widgetThreadBrowserViewModel$StoreState.guild;
        }
        if ((i & 4) != 0) {
            l = widgetThreadBrowserViewModel$StoreState.permissions;
        }
        return widgetThreadBrowserViewModel$StoreState.copy(channel, guild, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getPermissions() {
        return this.permissions;
    }

    public final WidgetThreadBrowserViewModel$StoreState copy(Channel channel, Guild guild, Long permissions) {
        return new WidgetThreadBrowserViewModel$StoreState(channel, guild, permissions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetThreadBrowserViewModel$StoreState)) {
            return false;
        }
        WidgetThreadBrowserViewModel$StoreState widgetThreadBrowserViewModel$StoreState = (WidgetThreadBrowserViewModel$StoreState) other;
        return m.areEqual(this.channel, widgetThreadBrowserViewModel$StoreState.channel) && m.areEqual(this.guild, widgetThreadBrowserViewModel$StoreState.guild) && m.areEqual(this.permissions, widgetThreadBrowserViewModel$StoreState.permissions);
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final Long getPermissions() {
        return this.permissions;
    }

    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        Guild guild = this.guild;
        int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
        Long l = this.permissions;
        return iHashCode2 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(channel=");
        sbU.append(this.channel);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", permissions=");
        return a.G(sbU, this.permissions, ")");
    }
}
