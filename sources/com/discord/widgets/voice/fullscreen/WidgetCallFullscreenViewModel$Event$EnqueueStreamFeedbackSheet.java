package com.discord.widgets.voice.fullscreen;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetCallFullscreenViewModel$Event$EnqueueStreamFeedbackSheet extends WidgetCallFullscreenViewModel$Event {
    private final String mediaSessionId;
    private final String streamKey;
    private final int triggerRateDenominator;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreenViewModel$Event$EnqueueStreamFeedbackSheet(String str, String str2, int i) {
        super(null);
        m.checkNotNullParameter(str, "streamKey");
        this.streamKey = str;
        this.mediaSessionId = str2;
        this.triggerRateDenominator = i;
    }

    public static /* synthetic */ WidgetCallFullscreenViewModel$Event$EnqueueStreamFeedbackSheet copy$default(WidgetCallFullscreenViewModel$Event$EnqueueStreamFeedbackSheet widgetCallFullscreenViewModel$Event$EnqueueStreamFeedbackSheet, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = widgetCallFullscreenViewModel$Event$EnqueueStreamFeedbackSheet.streamKey;
        }
        if ((i2 & 2) != 0) {
            str2 = widgetCallFullscreenViewModel$Event$EnqueueStreamFeedbackSheet.mediaSessionId;
        }
        if ((i2 & 4) != 0) {
            i = widgetCallFullscreenViewModel$Event$EnqueueStreamFeedbackSheet.triggerRateDenominator;
        }
        return widgetCallFullscreenViewModel$Event$EnqueueStreamFeedbackSheet.copy(str, str2, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStreamKey() {
        return this.streamKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMediaSessionId() {
        return this.mediaSessionId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getTriggerRateDenominator() {
        return this.triggerRateDenominator;
    }

    public final WidgetCallFullscreenViewModel$Event$EnqueueStreamFeedbackSheet copy(String streamKey, String mediaSessionId, int triggerRateDenominator) {
        m.checkNotNullParameter(streamKey, "streamKey");
        return new WidgetCallFullscreenViewModel$Event$EnqueueStreamFeedbackSheet(streamKey, mediaSessionId, triggerRateDenominator);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetCallFullscreenViewModel$Event$EnqueueStreamFeedbackSheet)) {
            return false;
        }
        WidgetCallFullscreenViewModel$Event$EnqueueStreamFeedbackSheet widgetCallFullscreenViewModel$Event$EnqueueStreamFeedbackSheet = (WidgetCallFullscreenViewModel$Event$EnqueueStreamFeedbackSheet) other;
        return m.areEqual(this.streamKey, widgetCallFullscreenViewModel$Event$EnqueueStreamFeedbackSheet.streamKey) && m.areEqual(this.mediaSessionId, widgetCallFullscreenViewModel$Event$EnqueueStreamFeedbackSheet.mediaSessionId) && this.triggerRateDenominator == widgetCallFullscreenViewModel$Event$EnqueueStreamFeedbackSheet.triggerRateDenominator;
    }

    public final String getMediaSessionId() {
        return this.mediaSessionId;
    }

    public final String getStreamKey() {
        return this.streamKey;
    }

    public final int getTriggerRateDenominator() {
        return this.triggerRateDenominator;
    }

    public int hashCode() {
        String str = this.streamKey;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.mediaSessionId;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.triggerRateDenominator;
    }

    public String toString() {
        StringBuilder sbU = a.U("EnqueueStreamFeedbackSheet(streamKey=");
        sbU.append(this.streamKey);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", triggerRateDenominator=");
        return a.B(sbU, this.triggerRateDenominator, ")");
    }
}
