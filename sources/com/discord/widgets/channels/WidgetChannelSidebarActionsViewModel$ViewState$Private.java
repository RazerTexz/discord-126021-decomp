package com.discord.widgets.channels;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetChannelSidebarActionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelSidebarActionsViewModel$ViewState$Private extends WidgetChannelSidebarActionsViewModel$ViewState {
    private final long channelId;
    private final boolean isMuted;

    public WidgetChannelSidebarActionsViewModel$ViewState$Private(long j, boolean z2) {
        super(null);
        this.channelId = j;
        this.isMuted = z2;
    }

    public static /* synthetic */ WidgetChannelSidebarActionsViewModel$ViewState$Private copy$default(WidgetChannelSidebarActionsViewModel$ViewState$Private widgetChannelSidebarActionsViewModel$ViewState$Private, long j, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetChannelSidebarActionsViewModel$ViewState$Private.channelId;
        }
        if ((i & 2) != 0) {
            z2 = widgetChannelSidebarActionsViewModel$ViewState$Private.isMuted;
        }
        return widgetChannelSidebarActionsViewModel$ViewState$Private.copy(j, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsMuted() {
        return this.isMuted;
    }

    public final WidgetChannelSidebarActionsViewModel$ViewState$Private copy(long channelId, boolean isMuted) {
        return new WidgetChannelSidebarActionsViewModel$ViewState$Private(channelId, isMuted);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelSidebarActionsViewModel$ViewState$Private)) {
            return false;
        }
        WidgetChannelSidebarActionsViewModel$ViewState$Private widgetChannelSidebarActionsViewModel$ViewState$Private = (WidgetChannelSidebarActionsViewModel$ViewState$Private) other;
        return this.channelId == widgetChannelSidebarActionsViewModel$ViewState$Private.channelId && this.isMuted == widgetChannelSidebarActionsViewModel$ViewState$Private.isMuted;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        int iA = b.a(this.channelId) * 31;
        boolean z2 = this.isMuted;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iA + r1;
    }

    public final boolean isMuted() {
        return this.isMuted;
    }

    public String toString() {
        StringBuilder sbU = a.U("Private(channelId=");
        sbU.append(this.channelId);
        sbU.append(", isMuted=");
        return a.O(sbU, this.isMuted, ")");
    }
}
