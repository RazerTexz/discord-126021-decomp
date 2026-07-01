package com.discord.widgets.voice.sheet;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetVoiceBottomSheetViewModel$Event$LaunchVideoCall extends WidgetVoiceBottomSheetViewModel$Event {
    private final String autoTargetStreamKey;
    private final long channelId;

    public WidgetVoiceBottomSheetViewModel$Event$LaunchVideoCall(long j, String str) {
        super(null);
        this.channelId = j;
        this.autoTargetStreamKey = str;
    }

    public static /* synthetic */ WidgetVoiceBottomSheetViewModel$Event$LaunchVideoCall copy$default(WidgetVoiceBottomSheetViewModel$Event$LaunchVideoCall widgetVoiceBottomSheetViewModel$Event$LaunchVideoCall, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetVoiceBottomSheetViewModel$Event$LaunchVideoCall.channelId;
        }
        if ((i & 2) != 0) {
            str = widgetVoiceBottomSheetViewModel$Event$LaunchVideoCall.autoTargetStreamKey;
        }
        return widgetVoiceBottomSheetViewModel$Event$LaunchVideoCall.copy(j, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAutoTargetStreamKey() {
        return this.autoTargetStreamKey;
    }

    public final WidgetVoiceBottomSheetViewModel$Event$LaunchVideoCall copy(long channelId, String autoTargetStreamKey) {
        return new WidgetVoiceBottomSheetViewModel$Event$LaunchVideoCall(channelId, autoTargetStreamKey);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetVoiceBottomSheetViewModel$Event$LaunchVideoCall)) {
            return false;
        }
        WidgetVoiceBottomSheetViewModel$Event$LaunchVideoCall widgetVoiceBottomSheetViewModel$Event$LaunchVideoCall = (WidgetVoiceBottomSheetViewModel$Event$LaunchVideoCall) other;
        return this.channelId == widgetVoiceBottomSheetViewModel$Event$LaunchVideoCall.channelId && m.areEqual(this.autoTargetStreamKey, widgetVoiceBottomSheetViewModel$Event$LaunchVideoCall.autoTargetStreamKey);
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
