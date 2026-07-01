package com.discord.widgets.guilds.create;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetGuildCreateViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildCreateViewModel$Event$LaunchInviteShareScreen extends WidgetGuildCreateViewModel$Event {
    private final long guildId;

    public WidgetGuildCreateViewModel$Event$LaunchInviteShareScreen(long j) {
        super(null);
        this.guildId = j;
    }

    public static /* synthetic */ WidgetGuildCreateViewModel$Event$LaunchInviteShareScreen copy$default(WidgetGuildCreateViewModel$Event$LaunchInviteShareScreen widgetGuildCreateViewModel$Event$LaunchInviteShareScreen, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetGuildCreateViewModel$Event$LaunchInviteShareScreen.guildId;
        }
        return widgetGuildCreateViewModel$Event$LaunchInviteShareScreen.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final WidgetGuildCreateViewModel$Event$LaunchInviteShareScreen copy(long guildId) {
        return new WidgetGuildCreateViewModel$Event$LaunchInviteShareScreen(guildId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetGuildCreateViewModel$Event$LaunchInviteShareScreen) && this.guildId == ((WidgetGuildCreateViewModel$Event$LaunchInviteShareScreen) other).guildId;
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
        return a.C(a.U("LaunchInviteShareScreen(guildId="), this.guildId, ")");
    }
}
