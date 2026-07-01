package com.discord.widgets.user.usersheet;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetUserSheetViewModel$Event$LaunchVideoCall extends WidgetUserSheetViewModel$Event {
    private final long channelId;

    public WidgetUserSheetViewModel$Event$LaunchVideoCall(long j) {
        super(null);
        this.channelId = j;
    }

    public static /* synthetic */ WidgetUserSheetViewModel$Event$LaunchVideoCall copy$default(WidgetUserSheetViewModel$Event$LaunchVideoCall widgetUserSheetViewModel$Event$LaunchVideoCall, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetUserSheetViewModel$Event$LaunchVideoCall.channelId;
        }
        return widgetUserSheetViewModel$Event$LaunchVideoCall.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    public final WidgetUserSheetViewModel$Event$LaunchVideoCall copy(long channelId) {
        return new WidgetUserSheetViewModel$Event$LaunchVideoCall(channelId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetUserSheetViewModel$Event$LaunchVideoCall) && this.channelId == ((WidgetUserSheetViewModel$Event$LaunchVideoCall) other).channelId;
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
        return a.C(a.U("LaunchVideoCall(channelId="), this.channelId, ")");
    }
}
