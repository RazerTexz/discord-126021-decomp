package com.discord.widgets.guilds.create;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetGuildCreateViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildCreateViewModel$Event$LaunchChannelPrompt extends WidgetGuildCreateViewModel$Event {
    private final long guildId;

    public WidgetGuildCreateViewModel$Event$LaunchChannelPrompt(long j) {
        super(null);
        this.guildId = j;
    }

    public static /* synthetic */ WidgetGuildCreateViewModel$Event$LaunchChannelPrompt copy$default(WidgetGuildCreateViewModel$Event$LaunchChannelPrompt widgetGuildCreateViewModel$Event$LaunchChannelPrompt, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetGuildCreateViewModel$Event$LaunchChannelPrompt.guildId;
        }
        return widgetGuildCreateViewModel$Event$LaunchChannelPrompt.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final WidgetGuildCreateViewModel$Event$LaunchChannelPrompt copy(long guildId) {
        return new WidgetGuildCreateViewModel$Event$LaunchChannelPrompt(guildId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetGuildCreateViewModel$Event$LaunchChannelPrompt) && this.guildId == ((WidgetGuildCreateViewModel$Event$LaunchChannelPrompt) other).guildId;
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
        return a.C(a.U("LaunchChannelPrompt(guildId="), this.guildId, ")");
    }
}
