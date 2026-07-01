package com.discord.widgets.hubs;

import b.d.b.a.outline;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.models.guild.Guild;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.widgets.hubs.HubAddServerState, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubAddServerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetHubAddServerViewModel2 {
    private final List<DirectoryEntryGuild> addedDirectories;
    private final List<Guild> addedGuilds;
    private final Long directoryChannelId;
    private final String hubName;
    private final List<Guild> selectableGuilds;
    private final int selectedIndex;

    public WidgetHubAddServerViewModel2() {
        this(null, null, 0, null, null, null, 63, null);
    }

    public WidgetHubAddServerViewModel2(String str, Long l, int i, List<Guild> list, List<Guild> list2, List<DirectoryEntryGuild> list3) {
        Intrinsics3.checkNotNullParameter(str, "hubName");
        Intrinsics3.checkNotNullParameter(list, "selectableGuilds");
        Intrinsics3.checkNotNullParameter(list2, "addedGuilds");
        Intrinsics3.checkNotNullParameter(list3, "addedDirectories");
        this.hubName = str;
        this.directoryChannelId = l;
        this.selectedIndex = i;
        this.selectableGuilds = list;
        this.addedGuilds = list2;
        this.addedDirectories = list3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetHubAddServerViewModel2 copy$default(WidgetHubAddServerViewModel2 widgetHubAddServerViewModel2, String str, Long l, int i, List list, List list2, List list3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = widgetHubAddServerViewModel2.hubName;
        }
        if ((i2 & 2) != 0) {
            l = widgetHubAddServerViewModel2.directoryChannelId;
        }
        Long l2 = l;
        if ((i2 & 4) != 0) {
            i = widgetHubAddServerViewModel2.selectedIndex;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            list = widgetHubAddServerViewModel2.selectableGuilds;
        }
        List list4 = list;
        if ((i2 & 16) != 0) {
            list2 = widgetHubAddServerViewModel2.addedGuilds;
        }
        List list5 = list2;
        if ((i2 & 32) != 0) {
            list3 = widgetHubAddServerViewModel2.addedDirectories;
        }
        return widgetHubAddServerViewModel2.copy(str, l2, i3, list4, list5, list3);
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

    public final WidgetHubAddServerViewModel2 copy(String hubName, Long directoryChannelId, int selectedIndex, List<Guild> selectableGuilds, List<Guild> addedGuilds, List<DirectoryEntryGuild> addedDirectories) {
        Intrinsics3.checkNotNullParameter(hubName, "hubName");
        Intrinsics3.checkNotNullParameter(selectableGuilds, "selectableGuilds");
        Intrinsics3.checkNotNullParameter(addedGuilds, "addedGuilds");
        Intrinsics3.checkNotNullParameter(addedDirectories, "addedDirectories");
        return new WidgetHubAddServerViewModel2(hubName, directoryChannelId, selectedIndex, selectableGuilds, addedGuilds, addedDirectories);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubAddServerViewModel2)) {
            return false;
        }
        WidgetHubAddServerViewModel2 widgetHubAddServerViewModel2 = (WidgetHubAddServerViewModel2) other;
        return Intrinsics3.areEqual(this.hubName, widgetHubAddServerViewModel2.hubName) && Intrinsics3.areEqual(this.directoryChannelId, widgetHubAddServerViewModel2.directoryChannelId) && this.selectedIndex == widgetHubAddServerViewModel2.selectedIndex && Intrinsics3.areEqual(this.selectableGuilds, widgetHubAddServerViewModel2.selectableGuilds) && Intrinsics3.areEqual(this.addedGuilds, widgetHubAddServerViewModel2.addedGuilds) && Intrinsics3.areEqual(this.addedDirectories, widgetHubAddServerViewModel2.addedDirectories);
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
        StringBuilder sbU = outline.U("HubAddServerState(hubName=");
        sbU.append(this.hubName);
        sbU.append(", directoryChannelId=");
        sbU.append(this.directoryChannelId);
        sbU.append(", selectedIndex=");
        sbU.append(this.selectedIndex);
        sbU.append(", selectableGuilds=");
        sbU.append(this.selectableGuilds);
        sbU.append(", addedGuilds=");
        sbU.append(this.addedGuilds);
        sbU.append(", addedDirectories=");
        return outline.L(sbU, this.addedDirectories, ")");
    }

    public /* synthetic */ WidgetHubAddServerViewModel2(String str, Long l, int i, List list, List list2, List list3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : l, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? Collections2.emptyList() : list, (i2 & 16) != 0 ? Collections2.emptyList() : list2, (i2 & 32) != 0 ? Collections2.emptyList() : list3);
    }
}
