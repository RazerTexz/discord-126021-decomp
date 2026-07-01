package com.discord.widgets.home;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetHomeViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetHomeViewModel$Event$ShowGuildEventUpsell extends WidgetHomeViewModel$Event {
    private final long guildId;

    public WidgetHomeViewModel$Event$ShowGuildEventUpsell(long j) {
        super(null);
        this.guildId = j;
    }

    public static /* synthetic */ WidgetHomeViewModel$Event$ShowGuildEventUpsell copy$default(WidgetHomeViewModel$Event$ShowGuildEventUpsell widgetHomeViewModel$Event$ShowGuildEventUpsell, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetHomeViewModel$Event$ShowGuildEventUpsell.guildId;
        }
        return widgetHomeViewModel$Event$ShowGuildEventUpsell.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final WidgetHomeViewModel$Event$ShowGuildEventUpsell copy(long guildId) {
        return new WidgetHomeViewModel$Event$ShowGuildEventUpsell(guildId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetHomeViewModel$Event$ShowGuildEventUpsell) && this.guildId == ((WidgetHomeViewModel$Event$ShowGuildEventUpsell) other).guildId;
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
        return a.C(a.U("ShowGuildEventUpsell(guildId="), this.guildId, ")");
    }
}
