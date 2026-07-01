package com.discord.widgets.user.usersheet;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetUserSheetViewModel$Event$LaunchDisableCommunication extends WidgetUserSheetViewModel$Event {
    private final long guildId;
    private final long userId;

    public WidgetUserSheetViewModel$Event$LaunchDisableCommunication(long j, long j2) {
        super(null);
        this.userId = j;
        this.guildId = j2;
    }

    public static /* synthetic */ WidgetUserSheetViewModel$Event$LaunchDisableCommunication copy$default(WidgetUserSheetViewModel$Event$LaunchDisableCommunication widgetUserSheetViewModel$Event$LaunchDisableCommunication, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetUserSheetViewModel$Event$LaunchDisableCommunication.userId;
        }
        if ((i & 2) != 0) {
            j2 = widgetUserSheetViewModel$Event$LaunchDisableCommunication.guildId;
        }
        return widgetUserSheetViewModel$Event$LaunchDisableCommunication.copy(j, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final WidgetUserSheetViewModel$Event$LaunchDisableCommunication copy(long userId, long guildId) {
        return new WidgetUserSheetViewModel$Event$LaunchDisableCommunication(userId, guildId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetUserSheetViewModel$Event$LaunchDisableCommunication)) {
            return false;
        }
        WidgetUserSheetViewModel$Event$LaunchDisableCommunication widgetUserSheetViewModel$Event$LaunchDisableCommunication = (WidgetUserSheetViewModel$Event$LaunchDisableCommunication) other;
        return this.userId == widgetUserSheetViewModel$Event$LaunchDisableCommunication.userId && this.guildId == widgetUserSheetViewModel$Event$LaunchDisableCommunication.guildId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return b.a(this.guildId) + (b.a(this.userId) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("LaunchDisableCommunication(userId=");
        sbU.append(this.userId);
        sbU.append(", guildId=");
        return a.C(sbU, this.guildId, ")");
    }
}
