package com.discord.widgets.voice.fullscreen;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetCallFullscreenViewModel$ParticipantTap {
    private final String participantFocusKey;
    private final long timestamp;

    public WidgetCallFullscreenViewModel$ParticipantTap(String str, long j) {
        m.checkNotNullParameter(str, "participantFocusKey");
        this.participantFocusKey = str;
        this.timestamp = j;
    }

    public static /* synthetic */ WidgetCallFullscreenViewModel$ParticipantTap copy$default(WidgetCallFullscreenViewModel$ParticipantTap widgetCallFullscreenViewModel$ParticipantTap, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetCallFullscreenViewModel$ParticipantTap.participantFocusKey;
        }
        if ((i & 2) != 0) {
            j = widgetCallFullscreenViewModel$ParticipantTap.timestamp;
        }
        return widgetCallFullscreenViewModel$ParticipantTap.copy(str, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getParticipantFocusKey() {
        return this.participantFocusKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    public final WidgetCallFullscreenViewModel$ParticipantTap copy(String participantFocusKey, long timestamp) {
        m.checkNotNullParameter(participantFocusKey, "participantFocusKey");
        return new WidgetCallFullscreenViewModel$ParticipantTap(participantFocusKey, timestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetCallFullscreenViewModel$ParticipantTap)) {
            return false;
        }
        WidgetCallFullscreenViewModel$ParticipantTap widgetCallFullscreenViewModel$ParticipantTap = (WidgetCallFullscreenViewModel$ParticipantTap) other;
        return m.areEqual(this.participantFocusKey, widgetCallFullscreenViewModel$ParticipantTap.participantFocusKey) && this.timestamp == widgetCallFullscreenViewModel$ParticipantTap.timestamp;
    }

    public final String getParticipantFocusKey() {
        return this.participantFocusKey;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        String str = this.participantFocusKey;
        return b.a(this.timestamp) + ((str != null ? str.hashCode() : 0) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("ParticipantTap(participantFocusKey=");
        sbU.append(this.participantFocusKey);
        sbU.append(", timestamp=");
        return a.C(sbU, this.timestamp, ")");
    }
}
