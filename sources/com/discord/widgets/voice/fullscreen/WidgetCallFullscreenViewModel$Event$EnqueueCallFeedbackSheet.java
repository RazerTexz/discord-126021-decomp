package com.discord.widgets.voice.fullscreen;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet extends WidgetCallFullscreenViewModel$Event {
    private final long callDuration;
    private final long channelId;
    private final String mediaSessionId;
    private final String rtcConnectionId;
    private final int triggerRateDenominator;

    public WidgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet(long j, String str, String str2, long j2, int i) {
        super(null);
        this.channelId = j;
        this.rtcConnectionId = str;
        this.mediaSessionId = str2;
        this.callDuration = j2;
        this.triggerRateDenominator = i;
    }

    public static /* synthetic */ WidgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet copy$default(WidgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet widgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet, long j, String str, String str2, long j2, int i, int i2, Object obj) {
        return widgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet.copy((i2 & 1) != 0 ? widgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet.channelId : j, (i2 & 2) != 0 ? widgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet.rtcConnectionId : str, (i2 & 4) != 0 ? widgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet.mediaSessionId : str2, (i2 & 8) != 0 ? widgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet.callDuration : j2, (i2 & 16) != 0 ? widgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet.triggerRateDenominator : i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRtcConnectionId() {
        return this.rtcConnectionId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMediaSessionId() {
        return this.mediaSessionId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getCallDuration() {
        return this.callDuration;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getTriggerRateDenominator() {
        return this.triggerRateDenominator;
    }

    public final WidgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet copy(long channelId, String rtcConnectionId, String mediaSessionId, long callDuration, int triggerRateDenominator) {
        return new WidgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet(channelId, rtcConnectionId, mediaSessionId, callDuration, triggerRateDenominator);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet)) {
            return false;
        }
        WidgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet widgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet = (WidgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet) other;
        return this.channelId == widgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet.channelId && m.areEqual(this.rtcConnectionId, widgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet.rtcConnectionId) && m.areEqual(this.mediaSessionId, widgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet.mediaSessionId) && this.callDuration == widgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet.callDuration && this.triggerRateDenominator == widgetCallFullscreenViewModel$Event$EnqueueCallFeedbackSheet.triggerRateDenominator;
    }

    public final long getCallDuration() {
        return this.callDuration;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final String getMediaSessionId() {
        return this.mediaSessionId;
    }

    public final String getRtcConnectionId() {
        return this.rtcConnectionId;
    }

    public final int getTriggerRateDenominator() {
        return this.triggerRateDenominator;
    }

    public int hashCode() {
        int iA = b.a(this.channelId) * 31;
        String str = this.rtcConnectionId;
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.mediaSessionId;
        return ((b.a(this.callDuration) + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31)) * 31) + this.triggerRateDenominator;
    }

    public String toString() {
        StringBuilder sbU = a.U("EnqueueCallFeedbackSheet(channelId=");
        sbU.append(this.channelId);
        sbU.append(", rtcConnectionId=");
        sbU.append(this.rtcConnectionId);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", callDuration=");
        sbU.append(this.callDuration);
        sbU.append(", triggerRateDenominator=");
        return a.B(sbU, this.triggerRateDenominator, ")");
    }
}
