package com.discord.widgets.channels.threads.browser;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetThreadBrowserViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetThreadBrowserViewModel$ViewState$Browser extends WidgetThreadBrowserViewModel$ViewState {
    private final boolean canCreateThread;
    private final boolean canViewArchivedThreads;
    private final String channelName;
    private final boolean isForumChannel;

    public WidgetThreadBrowserViewModel$ViewState$Browser(String str, boolean z2, boolean z3, boolean z4) {
        super(null);
        this.channelName = str;
        this.canCreateThread = z2;
        this.canViewArchivedThreads = z3;
        this.isForumChannel = z4;
    }

    public static /* synthetic */ WidgetThreadBrowserViewModel$ViewState$Browser copy$default(WidgetThreadBrowserViewModel$ViewState$Browser widgetThreadBrowserViewModel$ViewState$Browser, String str, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetThreadBrowserViewModel$ViewState$Browser.channelName;
        }
        if ((i & 2) != 0) {
            z2 = widgetThreadBrowserViewModel$ViewState$Browser.canCreateThread;
        }
        if ((i & 4) != 0) {
            z3 = widgetThreadBrowserViewModel$ViewState$Browser.canViewArchivedThreads;
        }
        if ((i & 8) != 0) {
            z4 = widgetThreadBrowserViewModel$ViewState$Browser.isForumChannel;
        }
        return widgetThreadBrowserViewModel$ViewState$Browser.copy(str, z2, z3, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCanCreateThread() {
        return this.canCreateThread;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getCanViewArchivedThreads() {
        return this.canViewArchivedThreads;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsForumChannel() {
        return this.isForumChannel;
    }

    public final WidgetThreadBrowserViewModel$ViewState$Browser copy(String channelName, boolean canCreateThread, boolean canViewArchivedThreads, boolean isForumChannel) {
        return new WidgetThreadBrowserViewModel$ViewState$Browser(channelName, canCreateThread, canViewArchivedThreads, isForumChannel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetThreadBrowserViewModel$ViewState$Browser)) {
            return false;
        }
        WidgetThreadBrowserViewModel$ViewState$Browser widgetThreadBrowserViewModel$ViewState$Browser = (WidgetThreadBrowserViewModel$ViewState$Browser) other;
        return m.areEqual(this.channelName, widgetThreadBrowserViewModel$ViewState$Browser.channelName) && this.canCreateThread == widgetThreadBrowserViewModel$ViewState$Browser.canCreateThread && this.canViewArchivedThreads == widgetThreadBrowserViewModel$ViewState$Browser.canViewArchivedThreads && this.isForumChannel == widgetThreadBrowserViewModel$ViewState$Browser.isForumChannel;
    }

    public final boolean getCanCreateThread() {
        return this.canCreateThread;
    }

    public final boolean getCanViewArchivedThreads() {
        return this.canViewArchivedThreads;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        String str = this.channelName;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z2 = this.canCreateThread;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z3 = this.canViewArchivedThreads;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.isForumChannel;
        return i2 + (z4 ? 1 : z4);
    }

    public final boolean isForumChannel() {
        return this.isForumChannel;
    }

    public String toString() {
        StringBuilder sbU = a.U("Browser(channelName=");
        sbU.append(this.channelName);
        sbU.append(", canCreateThread=");
        sbU.append(this.canCreateThread);
        sbU.append(", canViewArchivedThreads=");
        sbU.append(this.canViewArchivedThreads);
        sbU.append(", isForumChannel=");
        return a.O(sbU, this.isForumChannel, ")");
    }
}
