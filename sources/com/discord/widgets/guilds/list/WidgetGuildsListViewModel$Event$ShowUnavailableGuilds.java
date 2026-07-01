package com.discord.widgets.guilds.list;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildsListViewModel$Event$ShowUnavailableGuilds extends WidgetGuildsListViewModel$Event {
    private final int unavailableGuildCount;

    public WidgetGuildsListViewModel$Event$ShowUnavailableGuilds(int i) {
        super(null);
        this.unavailableGuildCount = i;
    }

    public static /* synthetic */ WidgetGuildsListViewModel$Event$ShowUnavailableGuilds copy$default(WidgetGuildsListViewModel$Event$ShowUnavailableGuilds widgetGuildsListViewModel$Event$ShowUnavailableGuilds, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetGuildsListViewModel$Event$ShowUnavailableGuilds.unavailableGuildCount;
        }
        return widgetGuildsListViewModel$Event$ShowUnavailableGuilds.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getUnavailableGuildCount() {
        return this.unavailableGuildCount;
    }

    public final WidgetGuildsListViewModel$Event$ShowUnavailableGuilds copy(int unavailableGuildCount) {
        return new WidgetGuildsListViewModel$Event$ShowUnavailableGuilds(unavailableGuildCount);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetGuildsListViewModel$Event$ShowUnavailableGuilds) && this.unavailableGuildCount == ((WidgetGuildsListViewModel$Event$ShowUnavailableGuilds) other).unavailableGuildCount;
        }
        return true;
    }

    public final int getUnavailableGuildCount() {
        return this.unavailableGuildCount;
    }

    public int hashCode() {
        return this.unavailableGuildCount;
    }

    public String toString() {
        return a.B(a.U("ShowUnavailableGuilds(unavailableGuildCount="), this.unavailableGuildCount, ")");
    }
}
