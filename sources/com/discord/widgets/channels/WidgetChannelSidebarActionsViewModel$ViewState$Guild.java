package com.discord.widgets.channels;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetChannelSidebarActionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelSidebarActionsViewModel$ViewState$Guild extends WidgetChannelSidebarActionsViewModel$ViewState {
    private final long channelId;
    private final boolean disablePins;
    private final long guildId;
    private final boolean hasUnreadPins;
    private final boolean isGuildForumChannel;
    private final boolean isGuildForumPost;
    private final boolean isMuted;
    private final boolean isThread;
    private final boolean shouldHideChannelSidebar;

    public WidgetChannelSidebarActionsViewModel$ViewState$Guild(long j, long j2, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        super(null);
        this.channelId = j;
        this.guildId = j2;
        this.isMuted = z2;
        this.hasUnreadPins = z3;
        this.disablePins = z4;
        this.isThread = z5;
        this.isGuildForumPost = z6;
        this.isGuildForumChannel = z7;
        this.shouldHideChannelSidebar = z8;
    }

    public static /* synthetic */ WidgetChannelSidebarActionsViewModel$ViewState$Guild copy$default(WidgetChannelSidebarActionsViewModel$ViewState$Guild widgetChannelSidebarActionsViewModel$ViewState$Guild, long j, long j2, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, int i, Object obj) {
        return widgetChannelSidebarActionsViewModel$ViewState$Guild.copy((i & 1) != 0 ? widgetChannelSidebarActionsViewModel$ViewState$Guild.channelId : j, (i & 2) != 0 ? widgetChannelSidebarActionsViewModel$ViewState$Guild.guildId : j2, (i & 4) != 0 ? widgetChannelSidebarActionsViewModel$ViewState$Guild.isMuted : z2, (i & 8) != 0 ? widgetChannelSidebarActionsViewModel$ViewState$Guild.hasUnreadPins : z3, (i & 16) != 0 ? widgetChannelSidebarActionsViewModel$ViewState$Guild.disablePins : z4, (i & 32) != 0 ? widgetChannelSidebarActionsViewModel$ViewState$Guild.isThread : z5, (i & 64) != 0 ? widgetChannelSidebarActionsViewModel$ViewState$Guild.isGuildForumPost : z6, (i & 128) != 0 ? widgetChannelSidebarActionsViewModel$ViewState$Guild.isGuildForumChannel : z7, (i & 256) != 0 ? widgetChannelSidebarActionsViewModel$ViewState$Guild.shouldHideChannelSidebar : z8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsMuted() {
        return this.isMuted;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getHasUnreadPins() {
        return this.hasUnreadPins;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getDisablePins() {
        return this.disablePins;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsThread() {
        return this.isThread;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsGuildForumPost() {
        return this.isGuildForumPost;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsGuildForumChannel() {
        return this.isGuildForumChannel;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getShouldHideChannelSidebar() {
        return this.shouldHideChannelSidebar;
    }

    public final WidgetChannelSidebarActionsViewModel$ViewState$Guild copy(long channelId, long guildId, boolean isMuted, boolean hasUnreadPins, boolean disablePins, boolean isThread, boolean isGuildForumPost, boolean isGuildForumChannel, boolean shouldHideChannelSidebar) {
        return new WidgetChannelSidebarActionsViewModel$ViewState$Guild(channelId, guildId, isMuted, hasUnreadPins, disablePins, isThread, isGuildForumPost, isGuildForumChannel, shouldHideChannelSidebar);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelSidebarActionsViewModel$ViewState$Guild)) {
            return false;
        }
        WidgetChannelSidebarActionsViewModel$ViewState$Guild widgetChannelSidebarActionsViewModel$ViewState$Guild = (WidgetChannelSidebarActionsViewModel$ViewState$Guild) other;
        return this.channelId == widgetChannelSidebarActionsViewModel$ViewState$Guild.channelId && this.guildId == widgetChannelSidebarActionsViewModel$ViewState$Guild.guildId && this.isMuted == widgetChannelSidebarActionsViewModel$ViewState$Guild.isMuted && this.hasUnreadPins == widgetChannelSidebarActionsViewModel$ViewState$Guild.hasUnreadPins && this.disablePins == widgetChannelSidebarActionsViewModel$ViewState$Guild.disablePins && this.isThread == widgetChannelSidebarActionsViewModel$ViewState$Guild.isThread && this.isGuildForumPost == widgetChannelSidebarActionsViewModel$ViewState$Guild.isGuildForumPost && this.isGuildForumChannel == widgetChannelSidebarActionsViewModel$ViewState$Guild.isGuildForumChannel && this.shouldHideChannelSidebar == widgetChannelSidebarActionsViewModel$ViewState$Guild.shouldHideChannelSidebar;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final boolean getDisablePins() {
        return this.disablePins;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final boolean getHasUnreadPins() {
        return this.hasUnreadPins;
    }

    public final boolean getShouldHideChannelSidebar() {
        return this.shouldHideChannelSidebar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iA = (b.a(this.guildId) + (b.a(this.channelId) * 31)) * 31;
        boolean z2 = this.isMuted;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = (iA + r0) * 31;
        boolean z3 = this.hasUnreadPins;
        ?? r1 = z3;
        if (z3) {
            r1 = 1;
        }
        int i2 = (i + r1) * 31;
        boolean z4 = this.disablePins;
        ?? r2 = z4;
        if (z4) {
            r2 = 1;
        }
        int i3 = (i2 + r2) * 31;
        boolean z5 = this.isThread;
        ?? r3 = z5;
        if (z5) {
            r3 = 1;
        }
        int i4 = (i3 + r3) * 31;
        boolean z6 = this.isGuildForumPost;
        ?? r4 = z6;
        if (z6) {
            r4 = 1;
        }
        int i5 = (i4 + r4) * 31;
        boolean z7 = this.isGuildForumChannel;
        ?? r5 = z7;
        if (z7) {
            r5 = 1;
        }
        int i6 = (i5 + r5) * 31;
        boolean z8 = this.shouldHideChannelSidebar;
        return i6 + (z8 ? 1 : z8);
    }

    public final boolean isGuildForumChannel() {
        return this.isGuildForumChannel;
    }

    public final boolean isGuildForumPost() {
        return this.isGuildForumPost;
    }

    public final boolean isMuted() {
        return this.isMuted;
    }

    public final boolean isThread() {
        return this.isThread;
    }

    public String toString() {
        StringBuilder sbU = a.U("Guild(channelId=");
        sbU.append(this.channelId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", isMuted=");
        sbU.append(this.isMuted);
        sbU.append(", hasUnreadPins=");
        sbU.append(this.hasUnreadPins);
        sbU.append(", disablePins=");
        sbU.append(this.disablePins);
        sbU.append(", isThread=");
        sbU.append(this.isThread);
        sbU.append(", isGuildForumPost=");
        sbU.append(this.isGuildForumPost);
        sbU.append(", isGuildForumChannel=");
        sbU.append(this.isGuildForumChannel);
        sbU.append(", shouldHideChannelSidebar=");
        return a.O(sbU, this.shouldHideChannelSidebar, ")");
    }
}
