package com.discord.widgets.user.usersheet;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetUserSheetViewModel$Event$LaunchEditMember extends WidgetUserSheetViewModel$Event {
    private final long guildId;
    private final long userId;

    public WidgetUserSheetViewModel$Event$LaunchEditMember(long j, long j2) {
        super(null);
        this.guildId = j;
        this.userId = j2;
    }

    public static /* synthetic */ WidgetUserSheetViewModel$Event$LaunchEditMember copy$default(WidgetUserSheetViewModel$Event$LaunchEditMember widgetUserSheetViewModel$Event$LaunchEditMember, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetUserSheetViewModel$Event$LaunchEditMember.guildId;
        }
        if ((i & 2) != 0) {
            j2 = widgetUserSheetViewModel$Event$LaunchEditMember.userId;
        }
        return widgetUserSheetViewModel$Event$LaunchEditMember.copy(j, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    public final WidgetUserSheetViewModel$Event$LaunchEditMember copy(long guildId, long userId) {
        return new WidgetUserSheetViewModel$Event$LaunchEditMember(guildId, userId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetUserSheetViewModel$Event$LaunchEditMember)) {
            return false;
        }
        WidgetUserSheetViewModel$Event$LaunchEditMember widgetUserSheetViewModel$Event$LaunchEditMember = (WidgetUserSheetViewModel$Event$LaunchEditMember) other;
        return this.guildId == widgetUserSheetViewModel$Event$LaunchEditMember.guildId && this.userId == widgetUserSheetViewModel$Event$LaunchEditMember.userId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return b.a(this.userId) + (b.a(this.guildId) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("LaunchEditMember(guildId=");
        sbU.append(this.guildId);
        sbU.append(", userId=");
        return a.C(sbU, this.userId, ")");
    }
}
