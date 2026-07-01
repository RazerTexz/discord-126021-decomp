package com.discord.widgets.user.usersheet;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetUserSheetViewModel$Event$LaunchVoiceCall extends WidgetUserSheetViewModel$Event {
    private final long channelId;

    public WidgetUserSheetViewModel$Event$LaunchVoiceCall(long j) {
        super(null);
        this.channelId = j;
    }

    public static /* synthetic */ WidgetUserSheetViewModel$Event$LaunchVoiceCall copy$default(WidgetUserSheetViewModel$Event$LaunchVoiceCall widgetUserSheetViewModel$Event$LaunchVoiceCall, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetUserSheetViewModel$Event$LaunchVoiceCall.channelId;
        }
        return widgetUserSheetViewModel$Event$LaunchVoiceCall.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    public final WidgetUserSheetViewModel$Event$LaunchVoiceCall copy(long channelId) {
        return new WidgetUserSheetViewModel$Event$LaunchVoiceCall(channelId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetUserSheetViewModel$Event$LaunchVoiceCall) && this.channelId == ((WidgetUserSheetViewModel$Event$LaunchVoiceCall) other).channelId;
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
        return a.C(a.U("LaunchVoiceCall(channelId="), this.channelId, ")");
    }
}
