package com.discord.widgets.servers;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsBans$Model {
    public static final int TYPE_BANNED_USER = 1;
    private final List<WidgetServerSettingsBans$Model$BanItem> filteredBannedUsers;
    private final long guildId;
    private final String guildName;
    private final boolean isLoading;
    private final int totalBannedUsers;
    public static final WidgetServerSettingsBans$Model$Companion Companion = new WidgetServerSettingsBans$Model$Companion(null);
    private static final ArrayList<WidgetServerSettingsBans$Model$BanItem> emptyBansList = new ArrayList<>();

    public WidgetServerSettingsBans$Model(int i, List<WidgetServerSettingsBans$Model$BanItem> list, long j, String str, boolean z2) {
        this.totalBannedUsers = i;
        this.filteredBannedUsers = list;
        this.guildId = j;
        this.guildName = str;
        this.isLoading = z2;
    }

    public static final /* synthetic */ ArrayList access$getEmptyBansList$cp() {
        return emptyBansList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetServerSettingsBans$Model copy$default(WidgetServerSettingsBans$Model widgetServerSettingsBans$Model, int i, List list, long j, String str, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetServerSettingsBans$Model.totalBannedUsers;
        }
        if ((i2 & 2) != 0) {
            list = widgetServerSettingsBans$Model.filteredBannedUsers;
        }
        List list2 = list;
        if ((i2 & 4) != 0) {
            j = widgetServerSettingsBans$Model.guildId;
        }
        long j2 = j;
        if ((i2 & 8) != 0) {
            str = widgetServerSettingsBans$Model.guildName;
        }
        String str2 = str;
        if ((i2 & 16) != 0) {
            z2 = widgetServerSettingsBans$Model.isLoading;
        }
        return widgetServerSettingsBans$Model.copy(i, list2, j2, str2, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTotalBannedUsers() {
        return this.totalBannedUsers;
    }

    public final List<WidgetServerSettingsBans$Model$BanItem> component2() {
        return this.filteredBannedUsers;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    public final WidgetServerSettingsBans$Model copy(int totalBannedUsers, List<WidgetServerSettingsBans$Model$BanItem> filteredBannedUsers, long guildId, String guildName, boolean isLoading) {
        return new WidgetServerSettingsBans$Model(totalBannedUsers, filteredBannedUsers, guildId, guildName, isLoading);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetServerSettingsBans$Model)) {
            return false;
        }
        WidgetServerSettingsBans$Model widgetServerSettingsBans$Model = (WidgetServerSettingsBans$Model) other;
        return this.totalBannedUsers == widgetServerSettingsBans$Model.totalBannedUsers && m.areEqual(this.filteredBannedUsers, widgetServerSettingsBans$Model.filteredBannedUsers) && this.guildId == widgetServerSettingsBans$Model.guildId && m.areEqual(this.guildName, widgetServerSettingsBans$Model.guildName) && this.isLoading == widgetServerSettingsBans$Model.isLoading;
    }

    public final List<WidgetServerSettingsBans$Model$BanItem> getFilteredBannedUsers() {
        return this.filteredBannedUsers;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getGuildName() {
        return this.guildName;
    }

    public final int getTotalBannedUsers() {
        return this.totalBannedUsers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    public int hashCode() {
        int i = this.totalBannedUsers * 31;
        List<WidgetServerSettingsBans$Model$BanItem> list = this.filteredBannedUsers;
        int iA = (b.a(this.guildId) + ((i + (list != null ? list.hashCode() : 0)) * 31)) * 31;
        String str = this.guildName;
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.isLoading;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        return iHashCode + r0;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(totalBannedUsers=");
        sbU.append(this.totalBannedUsers);
        sbU.append(", filteredBannedUsers=");
        sbU.append(this.filteredBannedUsers);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", guildName=");
        sbU.append(this.guildName);
        sbU.append(", isLoading=");
        return a.O(sbU, this.isLoading, ")");
    }
}
