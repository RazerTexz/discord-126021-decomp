package com.discord.widgets.hubs;

import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.models.guild.Guild;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubAddServerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HubAddServerState {
    private final List<DirectoryEntryGuild> addedDirectories;
    private final List<Guild> addedGuilds;
    private final Long directoryChannelId;
    private final String hubName;
    private final List<Guild> selectableGuilds;
    private final int selectedIndex;

    public HubAddServerState() {
        this(null, null, 0, null, null, null, 63, null);
    }

    public HubAddServerState(String str, Long l, int i, List<Guild> list, List<Guild> list2, List<DirectoryEntryGuild> list3) {
        C12238m.checkNotNullParameter(str, "hubName");
        C12238m.checkNotNullParameter(list, "selectableGuilds");
        C12238m.checkNotNullParameter(list2, "addedGuilds");
        C12238m.checkNotNullParameter(list3, "addedDirectories");
        this.hubName = str;
        this.directoryChannelId = l;
        this.selectedIndex = i;
        this.selectableGuilds = list;
        this.addedGuilds = list2;
        this.addedDirectories = list3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HubAddServerState copy$default(HubAddServerState hubAddServerState, String str, Long l, int i, List list, List list2, List list3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = hubAddServerState.hubName;
        }
        if ((i2 & 2) != 0) {
            l = hubAddServerState.directoryChannelId;
        }
        Long l2 = l;
        if ((i2 & 4) != 0) {
            i = hubAddServerState.selectedIndex;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            list = hubAddServerState.selectableGuilds;
        }
        List list4 = list;
        if ((i2 & 16) != 0) {
            list2 = hubAddServerState.addedGuilds;
        }
        List list5 = list2;
        if ((i2 & 32) != 0) {
            list3 = hubAddServerState.addedDirectories;
        }
        return hubAddServerState.copy(str, l2, i3, list4, list5, list3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getHubName() {
        return this.hubName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getDirectoryChannelId() {
        return this.directoryChannelId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    public final List<Guild> component4() {
        return this.selectableGuilds;
    }

    public final List<Guild> component5() {
        return this.addedGuilds;
    }

    public final List<DirectoryEntryGuild> component6() {
        return this.addedDirectories;
    }

    public final HubAddServerState copy(String hubName, Long directoryChannelId, int selectedIndex, List<Guild> selectableGuilds, List<Guild> addedGuilds, List<DirectoryEntryGuild> addedDirectories) {
        C12238m.checkNotNullParameter(hubName, "hubName");
        C12238m.checkNotNullParameter(selectableGuilds, "selectableGuilds");
        C12238m.checkNotNullParameter(addedGuilds, "addedGuilds");
        C12238m.checkNotNullParameter(addedDirectories, "addedDirectories");
        return new HubAddServerState(hubName, directoryChannelId, selectedIndex, selectableGuilds, addedGuilds, addedDirectories);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HubAddServerState)) {
            return false;
        }
        HubAddServerState hubAddServerState = (HubAddServerState) other;
        return C12238m.areEqual(this.hubName, hubAddServerState.hubName) && C12238m.areEqual(this.directoryChannelId, hubAddServerState.directoryChannelId) && this.selectedIndex == hubAddServerState.selectedIndex && C12238m.areEqual(this.selectableGuilds, hubAddServerState.selectableGuilds) && C12238m.areEqual(this.addedGuilds, hubAddServerState.addedGuilds) && C12238m.areEqual(this.addedDirectories, hubAddServerState.addedDirectories);
    }

    public final List<DirectoryEntryGuild> getAddedDirectories() {
        return this.addedDirectories;
    }

    public final List<Guild> getAddedGuilds() {
        return this.addedGuilds;
    }

    public final Long getDirectoryChannelId() {
        return this.directoryChannelId;
    }

    public final String getHubName() {
        return this.hubName;
    }

    public final List<Guild> getSelectableGuilds() {
        return this.selectableGuilds;
    }

    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    public int hashCode() {
        String str = this.hubName;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Long l = this.directoryChannelId;
        int iHashCode2 = (((iHashCode + (l != null ? l.hashCode() : 0)) * 31) + this.selectedIndex) * 31;
        List<Guild> list = this.selectableGuilds;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        List<Guild> list2 = this.addedGuilds;
        int iHashCode4 = (iHashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<DirectoryEntryGuild> list3 = this.addedDirectories;
        return iHashCode4 + (list3 != null ? list3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("HubAddServerState(hubName=");
        sbM833U.append(this.hubName);
        sbM833U.append(", directoryChannelId=");
        sbM833U.append(this.directoryChannelId);
        sbM833U.append(", selectedIndex=");
        sbM833U.append(this.selectedIndex);
        sbM833U.append(", selectableGuilds=");
        sbM833U.append(this.selectableGuilds);
        sbM833U.append(", addedGuilds=");
        sbM833U.append(this.addedGuilds);
        sbM833U.append(", addedDirectories=");
        return C1643a.m824L(sbM833U, this.addedDirectories, ")");
    }

    public /* synthetic */ HubAddServerState(String str, Long l, int i, List list, List list2, List list3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : l, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? C12147n.emptyList() : list, (i2 & 16) != 0 ? C12147n.emptyList() : list2, (i2 & 32) != 0 ? C12147n.emptyList() : list3);
    }
}
