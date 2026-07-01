package com.discord.widgets.voice.fullscreen;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetCallPreviewFullscreenViewModel$Event$LaunchVideoCall extends WidgetCallPreviewFullscreenViewModel$Event {
    private final String autoTargetStreamKey;
    private final long channelId;

    public WidgetCallPreviewFullscreenViewModel$Event$LaunchVideoCall(long j, String str) {
        super(null);
        this.channelId = j;
        this.autoTargetStreamKey = str;
    }

    public static /* synthetic */ WidgetCallPreviewFullscreenViewModel$Event$LaunchVideoCall copy$default(WidgetCallPreviewFullscreenViewModel$Event$LaunchVideoCall widgetCallPreviewFullscreenViewModel$Event$LaunchVideoCall, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetCallPreviewFullscreenViewModel$Event$LaunchVideoCall.channelId;
        }
        if ((i & 2) != 0) {
            str = widgetCallPreviewFullscreenViewModel$Event$LaunchVideoCall.autoTargetStreamKey;
        }
        return widgetCallPreviewFullscreenViewModel$Event$LaunchVideoCall.copy(j, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAutoTargetStreamKey() {
        return this.autoTargetStreamKey;
    }

    public final WidgetCallPreviewFullscreenViewModel$Event$LaunchVideoCall copy(long channelId, String autoTargetStreamKey) {
        return new WidgetCallPreviewFullscreenViewModel$Event$LaunchVideoCall(channelId, autoTargetStreamKey);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetCallPreviewFullscreenViewModel$Event$LaunchVideoCall)) {
            return false;
        }
        WidgetCallPreviewFullscreenViewModel$Event$LaunchVideoCall widgetCallPreviewFullscreenViewModel$Event$LaunchVideoCall = (WidgetCallPreviewFullscreenViewModel$Event$LaunchVideoCall) other;
        return this.channelId == widgetCallPreviewFullscreenViewModel$Event$LaunchVideoCall.channelId && m.areEqual(this.autoTargetStreamKey, widgetCallPreviewFullscreenViewModel$Event$LaunchVideoCall.autoTargetStreamKey);
    }

    public final String getAutoTargetStreamKey() {
        return this.autoTargetStreamKey;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public int hashCode() {
        int iA = b.a(this.channelId) * 31;
        String str = this.autoTargetStreamKey;
        return iA + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("LaunchVideoCall(channelId=");
        sbU.append(this.channelId);
        sbU.append(", autoTargetStreamKey=");
        return a.J(sbU, this.autoTargetStreamKey, ")");
    }
}
