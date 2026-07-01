package com.discord.widgets.guilds.create;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetGuildCreateViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildCreateViewModel$Event$CloseWithResult extends WidgetGuildCreateViewModel$Event {
    private final long guildId;

    public WidgetGuildCreateViewModel$Event$CloseWithResult(long j) {
        super(null);
        this.guildId = j;
    }

    public static /* synthetic */ WidgetGuildCreateViewModel$Event$CloseWithResult copy$default(WidgetGuildCreateViewModel$Event$CloseWithResult widgetGuildCreateViewModel$Event$CloseWithResult, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetGuildCreateViewModel$Event$CloseWithResult.guildId;
        }
        return widgetGuildCreateViewModel$Event$CloseWithResult.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final WidgetGuildCreateViewModel$Event$CloseWithResult copy(long guildId) {
        return new WidgetGuildCreateViewModel$Event$CloseWithResult(guildId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetGuildCreateViewModel$Event$CloseWithResult) && this.guildId == ((WidgetGuildCreateViewModel$Event$CloseWithResult) other).guildId;
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
        return a.C(a.U("CloseWithResult(guildId="), this.guildId, ")");
    }
}
