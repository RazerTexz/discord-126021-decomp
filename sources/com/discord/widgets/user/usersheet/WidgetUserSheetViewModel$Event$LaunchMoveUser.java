package com.discord.widgets.user.usersheet;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetUserSheetViewModel$Event$LaunchMoveUser extends WidgetUserSheetViewModel$Event {
    private final long guildId;

    public WidgetUserSheetViewModel$Event$LaunchMoveUser(long j) {
        super(null);
        this.guildId = j;
    }

    public static /* synthetic */ WidgetUserSheetViewModel$Event$LaunchMoveUser copy$default(WidgetUserSheetViewModel$Event$LaunchMoveUser widgetUserSheetViewModel$Event$LaunchMoveUser, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetUserSheetViewModel$Event$LaunchMoveUser.guildId;
        }
        return widgetUserSheetViewModel$Event$LaunchMoveUser.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final WidgetUserSheetViewModel$Event$LaunchMoveUser copy(long guildId) {
        return new WidgetUserSheetViewModel$Event$LaunchMoveUser(guildId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetUserSheetViewModel$Event$LaunchMoveUser) && this.guildId == ((WidgetUserSheetViewModel$Event$LaunchMoveUser) other).guildId;
        }
        return true;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public int hashCode() {
        return b.a(this.guildId);
    }

    public String toString() {
        return a.C(a.U("LaunchMoveUser(guildId="), this.guildId, ")");
    }
}
