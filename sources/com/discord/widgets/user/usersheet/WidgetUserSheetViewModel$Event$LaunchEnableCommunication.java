package com.discord.widgets.user.usersheet;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetUserSheetViewModel$Event$LaunchEnableCommunication extends WidgetUserSheetViewModel$Event {
    private final long guildId;
    private final long userId;

    public WidgetUserSheetViewModel$Event$LaunchEnableCommunication(long j, long j2) {
        super(null);
        this.userId = j;
        this.guildId = j2;
    }

    public static /* synthetic */ WidgetUserSheetViewModel$Event$LaunchEnableCommunication copy$default(WidgetUserSheetViewModel$Event$LaunchEnableCommunication widgetUserSheetViewModel$Event$LaunchEnableCommunication, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetUserSheetViewModel$Event$LaunchEnableCommunication.userId;
        }
        if ((i & 2) != 0) {
            j2 = widgetUserSheetViewModel$Event$LaunchEnableCommunication.guildId;
        }
        return widgetUserSheetViewModel$Event$LaunchEnableCommunication.copy(j, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final WidgetUserSheetViewModel$Event$LaunchEnableCommunication copy(long userId, long guildId) {
        return new WidgetUserSheetViewModel$Event$LaunchEnableCommunication(userId, guildId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetUserSheetViewModel$Event$LaunchEnableCommunication)) {
            return false;
        }
        WidgetUserSheetViewModel$Event$LaunchEnableCommunication widgetUserSheetViewModel$Event$LaunchEnableCommunication = (WidgetUserSheetViewModel$Event$LaunchEnableCommunication) other;
        return this.userId == widgetUserSheetViewModel$Event$LaunchEnableCommunication.userId && this.guildId == widgetUserSheetViewModel$Event$LaunchEnableCommunication.guildId;
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
        StringBuilder sbU = a.U("LaunchEnableCommunication(userId=");
        sbU.append(this.userId);
        sbU.append(", guildId=");
        return a.C(sbU, this.guildId, ")");
    }
}
