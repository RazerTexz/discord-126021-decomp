package com.discord.widgets.directories;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.models.guild.Guild;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.stores.utilities.Default;
import com.discord.stores.utilities.RestCallState;
import d0.g;
import d0.t.n0;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: WidgetDirectoriesViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetDirectoriesViewModel$ViewState {
    private final Set<Long> adminGuildIds;

    /* JADX INFO: renamed from: allDirectoryEntryData$delegate, reason: from kotlin metadata */
    private final Lazy allDirectoryEntryData;
    private final Channel channel;
    private final RestCallState<List<DirectoryEntryGuild>> directories;

    /* JADX INFO: renamed from: directoryEntryData$delegate, reason: from kotlin metadata */
    private final Lazy directoryEntryData;
    private final Guild guild;
    private final boolean hasAddGuildPermissions;
    private final Set<Long> joinedGuildIds;

    /* JADX INFO: renamed from: mappedTabs$delegate, reason: from kotlin metadata */
    private final Lazy mappedTabs;
    private final RestCallState<Map<Integer, Integer>> tabs;

    public WidgetDirectoriesViewModel$ViewState() {
        this(null, null, null, null, false, null, null, Opcodes.LAND, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetDirectoriesViewModel$ViewState(Guild guild, Channel channel, Set<Long> set, Set<Long> set2, boolean z2, RestCallState<? extends List<DirectoryEntryGuild>> restCallState, RestCallState<? extends Map<Integer, Integer>> restCallState2) {
        m.checkNotNullParameter(set, "joinedGuildIds");
        m.checkNotNullParameter(set2, "adminGuildIds");
        m.checkNotNullParameter(restCallState, "directories");
        m.checkNotNullParameter(restCallState2, "tabs");
        this.guild = guild;
        this.channel = channel;
        this.joinedGuildIds = set;
        this.adminGuildIds = set2;
        this.hasAddGuildPermissions = z2;
        this.directories = restCallState;
        this.tabs = restCallState2;
        this.allDirectoryEntryData = g.lazy(new WidgetDirectoriesViewModel$ViewState$allDirectoryEntryData$2(this));
        this.directoryEntryData = g.lazy(new WidgetDirectoriesViewModel$ViewState$directoryEntryData$2(this));
        this.mappedTabs = g.lazy(new WidgetDirectoriesViewModel$ViewState$mappedTabs$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetDirectoriesViewModel$ViewState copy$default(WidgetDirectoriesViewModel$ViewState widgetDirectoriesViewModel$ViewState, Guild guild, Channel channel, Set set, Set set2, boolean z2, RestCallState restCallState, RestCallState restCallState2, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = widgetDirectoriesViewModel$ViewState.guild;
        }
        if ((i & 2) != 0) {
            channel = widgetDirectoriesViewModel$ViewState.channel;
        }
        Channel channel2 = channel;
        if ((i & 4) != 0) {
            set = widgetDirectoriesViewModel$ViewState.joinedGuildIds;
        }
        Set set3 = set;
        if ((i & 8) != 0) {
            set2 = widgetDirectoriesViewModel$ViewState.adminGuildIds;
        }
        Set set4 = set2;
        if ((i & 16) != 0) {
            z2 = widgetDirectoriesViewModel$ViewState.hasAddGuildPermissions;
        }
        boolean z3 = z2;
        if ((i & 32) != 0) {
            restCallState = widgetDirectoriesViewModel$ViewState.directories;
        }
        RestCallState restCallState3 = restCallState;
        if ((i & 64) != 0) {
            restCallState2 = widgetDirectoriesViewModel$ViewState.tabs;
        }
        return widgetDirectoriesViewModel$ViewState.copy(guild, channel2, set3, set4, z3, restCallState3, restCallState2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final Set<Long> component3() {
        return this.joinedGuildIds;
    }

    public final Set<Long> component4() {
        return this.adminGuildIds;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getHasAddGuildPermissions() {
        return this.hasAddGuildPermissions;
    }

    public final RestCallState<List<DirectoryEntryGuild>> component6() {
        return this.directories;
    }

    public final RestCallState<Map<Integer, Integer>> component7() {
        return this.tabs;
    }

    public final WidgetDirectoriesViewModel$ViewState copy(Guild guild, Channel channel, Set<Long> joinedGuildIds, Set<Long> adminGuildIds, boolean hasAddGuildPermissions, RestCallState<? extends List<DirectoryEntryGuild>> directories, RestCallState<? extends Map<Integer, Integer>> tabs) {
        m.checkNotNullParameter(joinedGuildIds, "joinedGuildIds");
        m.checkNotNullParameter(adminGuildIds, "adminGuildIds");
        m.checkNotNullParameter(directories, "directories");
        m.checkNotNullParameter(tabs, "tabs");
        return new WidgetDirectoriesViewModel$ViewState(guild, channel, joinedGuildIds, adminGuildIds, hasAddGuildPermissions, directories, tabs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetDirectoriesViewModel$ViewState)) {
            return false;
        }
        WidgetDirectoriesViewModel$ViewState widgetDirectoriesViewModel$ViewState = (WidgetDirectoriesViewModel$ViewState) other;
        return m.areEqual(this.guild, widgetDirectoriesViewModel$ViewState.guild) && m.areEqual(this.channel, widgetDirectoriesViewModel$ViewState.channel) && m.areEqual(this.joinedGuildIds, widgetDirectoriesViewModel$ViewState.joinedGuildIds) && m.areEqual(this.adminGuildIds, widgetDirectoriesViewModel$ViewState.adminGuildIds) && this.hasAddGuildPermissions == widgetDirectoriesViewModel$ViewState.hasAddGuildPermissions && m.areEqual(this.directories, widgetDirectoriesViewModel$ViewState.directories) && m.areEqual(this.tabs, widgetDirectoriesViewModel$ViewState.tabs);
    }

    public final Set<Long> getAdminGuildIds() {
        return this.adminGuildIds;
    }

    public final List<DirectoryEntryData> getAllDirectoryEntryData() {
        return (List) this.allDirectoryEntryData.getValue();
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final RestCallState<List<DirectoryEntryGuild>> getDirectories() {
        return this.directories;
    }

    public final Map<Integer, List<DirectoryEntryData>> getDirectoryEntryData() {
        return (Map) this.directoryEntryData.getValue();
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final boolean getHasAddGuildPermissions() {
        return this.hasAddGuildPermissions;
    }

    public final Set<Long> getJoinedGuildIds() {
        return this.joinedGuildIds;
    }

    public final List<Pair<DirectoryEntryCategory, Integer>> getMappedTabs() {
        return (List) this.mappedTabs.getValue();
    }

    public final RestCallState<Map<Integer, Integer>> getTabs() {
        return this.tabs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v20 */
    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        Channel channel = this.channel;
        int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
        Set<Long> set = this.joinedGuildIds;
        int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Set<Long> set2 = this.adminGuildIds;
        int iHashCode4 = (iHashCode3 + (set2 != null ? set2.hashCode() : 0)) * 31;
        boolean z2 = this.hasAddGuildPermissions;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode4 + r2) * 31;
        RestCallState<List<DirectoryEntryGuild>> restCallState = this.directories;
        int iHashCode5 = (i + (restCallState != null ? restCallState.hashCode() : 0)) * 31;
        RestCallState<Map<Integer, Integer>> restCallState2 = this.tabs;
        return iHashCode5 + (restCallState2 != null ? restCallState2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(guild=");
        sbU.append(this.guild);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", joinedGuildIds=");
        sbU.append(this.joinedGuildIds);
        sbU.append(", adminGuildIds=");
        sbU.append(this.adminGuildIds);
        sbU.append(", hasAddGuildPermissions=");
        sbU.append(this.hasAddGuildPermissions);
        sbU.append(", directories=");
        sbU.append(this.directories);
        sbU.append(", tabs=");
        sbU.append(this.tabs);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ WidgetDirectoriesViewModel$ViewState(Guild guild, Channel channel, Set set, Set set2, boolean z2, RestCallState restCallState, RestCallState restCallState2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : guild, (i & 2) == 0 ? channel : null, (i & 4) != 0 ? n0.emptySet() : set, (i & 8) != 0 ? n0.emptySet() : set2, (i & 16) != 0 ? true : z2, (i & 32) != 0 ? Default.INSTANCE : restCallState, (i & 64) != 0 ? Default.INSTANCE : restCallState2);
    }
}
