package com.discord.widgets.voice.sheet;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetVoiceBottomSheetViewModel$Event$LaunchStageChannel extends WidgetVoiceBottomSheetViewModel$Event {
    private final long channelId;

    public WidgetVoiceBottomSheetViewModel$Event$LaunchStageChannel(long j) {
        super(null);
        this.channelId = j;
    }

    public static /* synthetic */ WidgetVoiceBottomSheetViewModel$Event$LaunchStageChannel copy$default(WidgetVoiceBottomSheetViewModel$Event$LaunchStageChannel widgetVoiceBottomSheetViewModel$Event$LaunchStageChannel, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetVoiceBottomSheetViewModel$Event$LaunchStageChannel.channelId;
        }
        return widgetVoiceBottomSheetViewModel$Event$LaunchStageChannel.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    public final WidgetVoiceBottomSheetViewModel$Event$LaunchStageChannel copy(long channelId) {
        return new WidgetVoiceBottomSheetViewModel$Event$LaunchStageChannel(channelId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetVoiceBottomSheetViewModel$Event$LaunchStageChannel) && this.channelId == ((WidgetVoiceBottomSheetViewModel$Event$LaunchStageChannel) other).channelId;
        }
        return true;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public int hashCode() {
        return b.a(this.channelId);
    }

    public String toString() {
        return a.C(a.U("LaunchStageChannel(channelId="), this.channelId, ")");
    }
}
