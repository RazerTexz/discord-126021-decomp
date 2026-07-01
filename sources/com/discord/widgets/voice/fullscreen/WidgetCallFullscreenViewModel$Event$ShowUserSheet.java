package com.discord.widgets.voice.fullscreen;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetCallFullscreenViewModel$Event$ShowUserSheet extends WidgetCallFullscreenViewModel$Event {
    private final long channelId;
    private final long userId;

    public WidgetCallFullscreenViewModel$Event$ShowUserSheet(long j, long j2) {
        super(null);
        this.userId = j;
        this.channelId = j2;
    }

    public static /* synthetic */ WidgetCallFullscreenViewModel$Event$ShowUserSheet copy$default(WidgetCallFullscreenViewModel$Event$ShowUserSheet widgetCallFullscreenViewModel$Event$ShowUserSheet, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetCallFullscreenViewModel$Event$ShowUserSheet.userId;
        }
        if ((i & 2) != 0) {
            j2 = widgetCallFullscreenViewModel$Event$ShowUserSheet.channelId;
        }
        return widgetCallFullscreenViewModel$Event$ShowUserSheet.copy(j, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    public final WidgetCallFullscreenViewModel$Event$ShowUserSheet copy(long userId, long channelId) {
        return new WidgetCallFullscreenViewModel$Event$ShowUserSheet(userId, channelId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetCallFullscreenViewModel$Event$ShowUserSheet)) {
            return false;
        }
        WidgetCallFullscreenViewModel$Event$ShowUserSheet widgetCallFullscreenViewModel$Event$ShowUserSheet = (WidgetCallFullscreenViewModel$Event$ShowUserSheet) other;
        return this.userId == widgetCallFullscreenViewModel$Event$ShowUserSheet.userId && this.channelId == widgetCallFullscreenViewModel$Event$ShowUserSheet.channelId;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return b.a(this.channelId) + (b.a(this.userId) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("ShowUserSheet(userId=");
        sbU.append(this.userId);
        sbU.append(", channelId=");
        return a.C(sbU, this.channelId, ")");
    }
}
