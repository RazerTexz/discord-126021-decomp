package com.discord.widgets.user.usersheet;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetUserSheetViewModel$Event$LaunchBanUser extends WidgetUserSheetViewModel$Event {
    private final long guildId;
    private final long userId;
    private final String username;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSheetViewModel$Event$LaunchBanUser(String str, long j, long j2) {
        super(null);
        m.checkNotNullParameter(str, "username");
        this.username = str;
        this.guildId = j;
        this.userId = j2;
    }

    public static /* synthetic */ WidgetUserSheetViewModel$Event$LaunchBanUser copy$default(WidgetUserSheetViewModel$Event$LaunchBanUser widgetUserSheetViewModel$Event$LaunchBanUser, String str, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetUserSheetViewModel$Event$LaunchBanUser.username;
        }
        if ((i & 2) != 0) {
            j = widgetUserSheetViewModel$Event$LaunchBanUser.guildId;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = widgetUserSheetViewModel$Event$LaunchBanUser.userId;
        }
        return widgetUserSheetViewModel$Event$LaunchBanUser.copy(str, j3, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    public final WidgetUserSheetViewModel$Event$LaunchBanUser copy(String username, long guildId, long userId) {
        m.checkNotNullParameter(username, "username");
        return new WidgetUserSheetViewModel$Event$LaunchBanUser(username, guildId, userId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetUserSheetViewModel$Event$LaunchBanUser)) {
            return false;
        }
        WidgetUserSheetViewModel$Event$LaunchBanUser widgetUserSheetViewModel$Event$LaunchBanUser = (WidgetUserSheetViewModel$Event$LaunchBanUser) other;
        return m.areEqual(this.username, widgetUserSheetViewModel$Event$LaunchBanUser.username) && this.guildId == widgetUserSheetViewModel$Event$LaunchBanUser.guildId && this.userId == widgetUserSheetViewModel$Event$LaunchBanUser.userId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final long getUserId() {
        return this.userId;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        String str = this.username;
        return b.a(this.userId) + ((b.a(this.guildId) + ((str != null ? str.hashCode() : 0) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("LaunchBanUser(username=");
        sbU.append(this.username);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", userId=");
        return a.C(sbU, this.userId, ")");
    }
}
