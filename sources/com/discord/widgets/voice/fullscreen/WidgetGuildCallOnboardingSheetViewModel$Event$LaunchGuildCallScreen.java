package com.discord.widgets.voice.fullscreen;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildCallOnboardingSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetGuildCallOnboardingSheetViewModel$Event$LaunchGuildCallScreen extends WidgetGuildCallOnboardingSheetViewModel$Event {
    private final long channelId;
    private final Long guildId;

    public WidgetGuildCallOnboardingSheetViewModel$Event$LaunchGuildCallScreen(long j, Long l) {
        super(null);
        this.channelId = j;
        this.guildId = l;
    }

    public static /* synthetic */ WidgetGuildCallOnboardingSheetViewModel$Event$LaunchGuildCallScreen copy$default(WidgetGuildCallOnboardingSheetViewModel$Event$LaunchGuildCallScreen widgetGuildCallOnboardingSheetViewModel$Event$LaunchGuildCallScreen, long j, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetGuildCallOnboardingSheetViewModel$Event$LaunchGuildCallScreen.channelId;
        }
        if ((i & 2) != 0) {
            l = widgetGuildCallOnboardingSheetViewModel$Event$LaunchGuildCallScreen.guildId;
        }
        return widgetGuildCallOnboardingSheetViewModel$Event$LaunchGuildCallScreen.copy(j, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    public final WidgetGuildCallOnboardingSheetViewModel$Event$LaunchGuildCallScreen copy(long channelId, Long guildId) {
        return new WidgetGuildCallOnboardingSheetViewModel$Event$LaunchGuildCallScreen(channelId, guildId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildCallOnboardingSheetViewModel$Event$LaunchGuildCallScreen)) {
            return false;
        }
        WidgetGuildCallOnboardingSheetViewModel$Event$LaunchGuildCallScreen widgetGuildCallOnboardingSheetViewModel$Event$LaunchGuildCallScreen = (WidgetGuildCallOnboardingSheetViewModel$Event$LaunchGuildCallScreen) other;
        return this.channelId == widgetGuildCallOnboardingSheetViewModel$Event$LaunchGuildCallScreen.channelId && m.areEqual(this.guildId, widgetGuildCallOnboardingSheetViewModel$Event$LaunchGuildCallScreen.guildId);
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public int hashCode() {
        int iA = b.a(this.channelId) * 31;
        Long l = this.guildId;
        return iA + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("LaunchGuildCallScreen(channelId=");
        sbU.append(this.channelId);
        sbU.append(", guildId=");
        return a.G(sbU, this.guildId, ")");
    }
}
