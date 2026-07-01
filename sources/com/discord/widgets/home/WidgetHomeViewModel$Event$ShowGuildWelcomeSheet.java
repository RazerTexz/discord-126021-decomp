package com.discord.widgets.home;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetHomeViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetHomeViewModel$Event$ShowGuildWelcomeSheet extends WidgetHomeViewModel$Event {
    private final long guildId;

    public WidgetHomeViewModel$Event$ShowGuildWelcomeSheet(long j) {
        super(null);
        this.guildId = j;
    }

    public static /* synthetic */ WidgetHomeViewModel$Event$ShowGuildWelcomeSheet copy$default(WidgetHomeViewModel$Event$ShowGuildWelcomeSheet widgetHomeViewModel$Event$ShowGuildWelcomeSheet, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetHomeViewModel$Event$ShowGuildWelcomeSheet.guildId;
        }
        return widgetHomeViewModel$Event$ShowGuildWelcomeSheet.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final WidgetHomeViewModel$Event$ShowGuildWelcomeSheet copy(long guildId) {
        return new WidgetHomeViewModel$Event$ShowGuildWelcomeSheet(guildId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetHomeViewModel$Event$ShowGuildWelcomeSheet) && this.guildId == ((WidgetHomeViewModel$Event$ShowGuildWelcomeSheet) other).guildId;
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
        return a.C(a.U("ShowGuildWelcomeSheet(guildId="), this.guildId, ")");
    }
}
