package com.discord.widgets.channels.threads.browser;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.ArchivedThreadsStore$ThreadListingState;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: WidgetThreadBrowserArchivedViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetThreadBrowserArchivedViewModel$StoreState {
    private final Channel channel;
    private final Guild guild;
    private final Map<Long, GuildMember> guildMembers;
    private final boolean isModerator;
    private final ArchivedThreadsStore$ThreadListingState listingState;
    private final Long permissions;
    private final Map<Long, User> users;
    private final WidgetThreadBrowserArchivedViewModel$ViewMode viewMode;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetThreadBrowserArchivedViewModel$StoreState(WidgetThreadBrowserArchivedViewModel$ViewMode widgetThreadBrowserArchivedViewModel$ViewMode, Map<Long, GuildMember> map, Map<Long, ? extends User> map2, ArchivedThreadsStore$ThreadListingState archivedThreadsStore$ThreadListingState, boolean z2, Channel channel, Guild guild, Long l) {
        m.checkNotNullParameter(widgetThreadBrowserArchivedViewModel$ViewMode, "viewMode");
        m.checkNotNullParameter(map, "guildMembers");
        m.checkNotNullParameter(map2, "users");
        m.checkNotNullParameter(archivedThreadsStore$ThreadListingState, "listingState");
        m.checkNotNullParameter(channel, "channel");
        this.viewMode = widgetThreadBrowserArchivedViewModel$ViewMode;
        this.guildMembers = map;
        this.users = map2;
        this.listingState = archivedThreadsStore$ThreadListingState;
        this.isModerator = z2;
        this.channel = channel;
        this.guild = guild;
        this.permissions = l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetThreadBrowserArchivedViewModel$StoreState copy$default(WidgetThreadBrowserArchivedViewModel$StoreState widgetThreadBrowserArchivedViewModel$StoreState, WidgetThreadBrowserArchivedViewModel$ViewMode widgetThreadBrowserArchivedViewModel$ViewMode, Map map, Map map2, ArchivedThreadsStore$ThreadListingState archivedThreadsStore$ThreadListingState, boolean z2, Channel channel, Guild guild, Long l, int i, Object obj) {
        return widgetThreadBrowserArchivedViewModel$StoreState.copy((i & 1) != 0 ? widgetThreadBrowserArchivedViewModel$StoreState.viewMode : widgetThreadBrowserArchivedViewModel$ViewMode, (i & 2) != 0 ? widgetThreadBrowserArchivedViewModel$StoreState.guildMembers : map, (i & 4) != 0 ? widgetThreadBrowserArchivedViewModel$StoreState.users : map2, (i & 8) != 0 ? widgetThreadBrowserArchivedViewModel$StoreState.listingState : archivedThreadsStore$ThreadListingState, (i & 16) != 0 ? widgetThreadBrowserArchivedViewModel$StoreState.isModerator : z2, (i & 32) != 0 ? widgetThreadBrowserArchivedViewModel$StoreState.channel : channel, (i & 64) != 0 ? widgetThreadBrowserArchivedViewModel$StoreState.guild : guild, (i & 128) != 0 ? widgetThreadBrowserArchivedViewModel$StoreState.permissions : l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final WidgetThreadBrowserArchivedViewModel$ViewMode getViewMode() {
        return this.viewMode;
    }

    public final Map<Long, GuildMember> component2() {
        return this.guildMembers;
    }

    public final Map<Long, User> component3() {
        return this.users;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ArchivedThreadsStore$ThreadListingState getListingState() {
        return this.listingState;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsModerator() {
        return this.isModerator;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Long getPermissions() {
        return this.permissions;
    }

    public final WidgetThreadBrowserArchivedViewModel$StoreState copy(WidgetThreadBrowserArchivedViewModel$ViewMode viewMode, Map<Long, GuildMember> guildMembers, Map<Long, ? extends User> users, ArchivedThreadsStore$ThreadListingState listingState, boolean isModerator, Channel channel, Guild guild, Long permissions) {
        m.checkNotNullParameter(viewMode, "viewMode");
        m.checkNotNullParameter(guildMembers, "guildMembers");
        m.checkNotNullParameter(users, "users");
        m.checkNotNullParameter(listingState, "listingState");
        m.checkNotNullParameter(channel, "channel");
        return new WidgetThreadBrowserArchivedViewModel$StoreState(viewMode, guildMembers, users, listingState, isModerator, channel, guild, permissions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetThreadBrowserArchivedViewModel$StoreState)) {
            return false;
        }
        WidgetThreadBrowserArchivedViewModel$StoreState widgetThreadBrowserArchivedViewModel$StoreState = (WidgetThreadBrowserArchivedViewModel$StoreState) other;
        return m.areEqual(this.viewMode, widgetThreadBrowserArchivedViewModel$StoreState.viewMode) && m.areEqual(this.guildMembers, widgetThreadBrowserArchivedViewModel$StoreState.guildMembers) && m.areEqual(this.users, widgetThreadBrowserArchivedViewModel$StoreState.users) && m.areEqual(this.listingState, widgetThreadBrowserArchivedViewModel$StoreState.listingState) && this.isModerator == widgetThreadBrowserArchivedViewModel$StoreState.isModerator && m.areEqual(this.channel, widgetThreadBrowserArchivedViewModel$StoreState.channel) && m.areEqual(this.guild, widgetThreadBrowserArchivedViewModel$StoreState.guild) && m.areEqual(this.permissions, widgetThreadBrowserArchivedViewModel$StoreState.permissions);
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final Map<Long, GuildMember> getGuildMembers() {
        return this.guildMembers;
    }

    public final ArchivedThreadsStore$ThreadListingState getListingState() {
        return this.listingState;
    }

    public final Long getPermissions() {
        return this.permissions;
    }

    public final Map<Long, User> getUsers() {
        return this.users;
    }

    public final WidgetThreadBrowserArchivedViewModel$ViewMode getViewMode() {
        return this.viewMode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v24 */
    public int hashCode() {
        WidgetThreadBrowserArchivedViewModel$ViewMode widgetThreadBrowserArchivedViewModel$ViewMode = this.viewMode;
        int iHashCode = (widgetThreadBrowserArchivedViewModel$ViewMode != null ? widgetThreadBrowserArchivedViewModel$ViewMode.hashCode() : 0) * 31;
        Map<Long, GuildMember> map = this.guildMembers;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, User> map2 = this.users;
        int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
        ArchivedThreadsStore$ThreadListingState archivedThreadsStore$ThreadListingState = this.listingState;
        int iHashCode4 = (iHashCode3 + (archivedThreadsStore$ThreadListingState != null ? archivedThreadsStore$ThreadListingState.hashCode() : 0)) * 31;
        boolean z2 = this.isModerator;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode4 + r2) * 31;
        Channel channel = this.channel;
        int iHashCode5 = (i + (channel != null ? channel.hashCode() : 0)) * 31;
        Guild guild = this.guild;
        int iHashCode6 = (iHashCode5 + (guild != null ? guild.hashCode() : 0)) * 31;
        Long l = this.permissions;
        return iHashCode6 + (l != null ? l.hashCode() : 0);
    }

    public final boolean isModerator() {
        return this.isModerator;
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(viewMode=");
        sbU.append(this.viewMode);
        sbU.append(", guildMembers=");
        sbU.append(this.guildMembers);
        sbU.append(", users=");
        sbU.append(this.users);
        sbU.append(", listingState=");
        sbU.append(this.listingState);
        sbU.append(", isModerator=");
        sbU.append(this.isModerator);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", permissions=");
        return a.G(sbU, this.permissions, ")");
    }
}
