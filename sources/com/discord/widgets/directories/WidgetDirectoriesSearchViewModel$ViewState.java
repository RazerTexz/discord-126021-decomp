package com.discord.widgets.directories;

import b.d.b.a.a;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.models.guild.Guild;
import com.discord.stores.utilities.Default;
import com.discord.stores.utilities.RestCallState;
import d0.g;
import d0.t.n;
import d0.t.n0;
import d0.z.d.m;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: WidgetDirectoriesSearchViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetDirectoriesSearchViewModel$ViewState {
    private final Set<Long> adminGuildIds;
    private final String currentSearchTerm;
    private final List<DirectoryEntryGuild> directories;
    private final RestCallState<List<DirectoryEntryGuild>> directoriesState;

    /* JADX INFO: renamed from: directoryEntryData$delegate, reason: from kotlin metadata */
    private final Lazy directoryEntryData;
    private final Guild guild;
    private final boolean hasAddGuildPermissions;
    private final Set<Long> joinedGuildIds;

    public WidgetDirectoriesSearchViewModel$ViewState() {
        this(null, null, null, null, null, false, null, Opcodes.LAND, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetDirectoriesSearchViewModel$ViewState(Guild guild, String str, List<DirectoryEntryGuild> list, Set<Long> set, Set<Long> set2, boolean z2, RestCallState<? extends List<DirectoryEntryGuild>> restCallState) {
        m.checkNotNullParameter(str, "currentSearchTerm");
        m.checkNotNullParameter(list, "directories");
        m.checkNotNullParameter(set, "joinedGuildIds");
        m.checkNotNullParameter(set2, "adminGuildIds");
        m.checkNotNullParameter(restCallState, "directoriesState");
        this.guild = guild;
        this.currentSearchTerm = str;
        this.directories = list;
        this.joinedGuildIds = set;
        this.adminGuildIds = set2;
        this.hasAddGuildPermissions = z2;
        this.directoriesState = restCallState;
        this.directoryEntryData = g.lazy(new WidgetDirectoriesSearchViewModel$ViewState$directoryEntryData$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetDirectoriesSearchViewModel$ViewState copy$default(WidgetDirectoriesSearchViewModel$ViewState widgetDirectoriesSearchViewModel$ViewState, Guild guild, String str, List list, Set set, Set set2, boolean z2, RestCallState restCallState, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = widgetDirectoriesSearchViewModel$ViewState.guild;
        }
        if ((i & 2) != 0) {
            str = widgetDirectoriesSearchViewModel$ViewState.currentSearchTerm;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            list = widgetDirectoriesSearchViewModel$ViewState.directories;
        }
        List list2 = list;
        if ((i & 8) != 0) {
            set = widgetDirectoriesSearchViewModel$ViewState.joinedGuildIds;
        }
        Set set3 = set;
        if ((i & 16) != 0) {
            set2 = widgetDirectoriesSearchViewModel$ViewState.adminGuildIds;
        }
        Set set4 = set2;
        if ((i & 32) != 0) {
            z2 = widgetDirectoriesSearchViewModel$ViewState.hasAddGuildPermissions;
        }
        boolean z3 = z2;
        if ((i & 64) != 0) {
            restCallState = widgetDirectoriesSearchViewModel$ViewState.directoriesState;
        }
        return widgetDirectoriesSearchViewModel$ViewState.copy(guild, str2, list2, set3, set4, z3, restCallState);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCurrentSearchTerm() {
        return this.currentSearchTerm;
    }

    public final List<DirectoryEntryGuild> component3() {
        return this.directories;
    }

    public final Set<Long> component4() {
        return this.joinedGuildIds;
    }

    public final Set<Long> component5() {
        return this.adminGuildIds;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getHasAddGuildPermissions() {
        return this.hasAddGuildPermissions;
    }

    public final RestCallState<List<DirectoryEntryGuild>> component7() {
        return this.directoriesState;
    }

    public final WidgetDirectoriesSearchViewModel$ViewState copy(Guild guild, String currentSearchTerm, List<DirectoryEntryGuild> directories, Set<Long> joinedGuildIds, Set<Long> adminGuildIds, boolean hasAddGuildPermissions, RestCallState<? extends List<DirectoryEntryGuild>> directoriesState) {
        m.checkNotNullParameter(currentSearchTerm, "currentSearchTerm");
        m.checkNotNullParameter(directories, "directories");
        m.checkNotNullParameter(joinedGuildIds, "joinedGuildIds");
        m.checkNotNullParameter(adminGuildIds, "adminGuildIds");
        m.checkNotNullParameter(directoriesState, "directoriesState");
        return new WidgetDirectoriesSearchViewModel$ViewState(guild, currentSearchTerm, directories, joinedGuildIds, adminGuildIds, hasAddGuildPermissions, directoriesState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetDirectoriesSearchViewModel$ViewState)) {
            return false;
        }
        WidgetDirectoriesSearchViewModel$ViewState widgetDirectoriesSearchViewModel$ViewState = (WidgetDirectoriesSearchViewModel$ViewState) other;
        return m.areEqual(this.guild, widgetDirectoriesSearchViewModel$ViewState.guild) && m.areEqual(this.currentSearchTerm, widgetDirectoriesSearchViewModel$ViewState.currentSearchTerm) && m.areEqual(this.directories, widgetDirectoriesSearchViewModel$ViewState.directories) && m.areEqual(this.joinedGuildIds, widgetDirectoriesSearchViewModel$ViewState.joinedGuildIds) && m.areEqual(this.adminGuildIds, widgetDirectoriesSearchViewModel$ViewState.adminGuildIds) && this.hasAddGuildPermissions == widgetDirectoriesSearchViewModel$ViewState.hasAddGuildPermissions && m.areEqual(this.directoriesState, widgetDirectoriesSearchViewModel$ViewState.directoriesState);
    }

    public final Set<Long> getAdminGuildIds() {
        return this.adminGuildIds;
    }

    public final String getCurrentSearchTerm() {
        return this.currentSearchTerm;
    }

    public final List<DirectoryEntryGuild> getDirectories() {
        return this.directories;
    }

    public final RestCallState<List<DirectoryEntryGuild>> getDirectoriesState() {
        return this.directoriesState;
    }

    public final List<DirectoryEntryData> getDirectoryEntryData() {
        return (List) this.directoryEntryData.getValue();
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v20 */
    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        String str = this.currentSearchTerm;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        List<DirectoryEntryGuild> list = this.directories;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        Set<Long> set = this.joinedGuildIds;
        int iHashCode4 = (iHashCode3 + (set != null ? set.hashCode() : 0)) * 31;
        Set<Long> set2 = this.adminGuildIds;
        int iHashCode5 = (iHashCode4 + (set2 != null ? set2.hashCode() : 0)) * 31;
        boolean z2 = this.hasAddGuildPermissions;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode5 + r2) * 31;
        RestCallState<List<DirectoryEntryGuild>> restCallState = this.directoriesState;
        return i + (restCallState != null ? restCallState.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(guild=");
        sbU.append(this.guild);
        sbU.append(", currentSearchTerm=");
        sbU.append(this.currentSearchTerm);
        sbU.append(", directories=");
        sbU.append(this.directories);
        sbU.append(", joinedGuildIds=");
        sbU.append(this.joinedGuildIds);
        sbU.append(", adminGuildIds=");
        sbU.append(this.adminGuildIds);
        sbU.append(", hasAddGuildPermissions=");
        sbU.append(this.hasAddGuildPermissions);
        sbU.append(", directoriesState=");
        sbU.append(this.directoriesState);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ WidgetDirectoriesSearchViewModel$ViewState(Guild guild, String str, List list, Set set, Set set2, boolean z2, RestCallState restCallState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : guild, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? n.emptyList() : list, (i & 8) != 0 ? n0.emptySet() : set, (i & 16) != 0 ? n0.emptySet() : set2, (i & 32) != 0 ? true : z2, (i & 64) != 0 ? Default.INSTANCE : restCallState);
    }
}
