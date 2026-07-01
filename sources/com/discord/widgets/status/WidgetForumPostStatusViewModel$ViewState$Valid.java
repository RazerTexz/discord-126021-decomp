package com.discord.widgets.status;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.message.reaction.MessageReaction;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetForumPostStatusViewModel$ViewState$Valid extends WidgetForumPostStatusViewModel$ViewState {
    private final long channelId;
    private final boolean followRequestInProgress;
    private final long guildId;
    private final boolean hasAddReactionPermission;
    private final boolean isArchivedThread;
    private final boolean isDefaultReaction;
    private final boolean isFollowedThread;
    private final int messageCount;
    private final Long messageId;
    private final long myUserId;
    private final MessageReaction reaction;

    public WidgetForumPostStatusViewModel$ViewState$Valid(long j, long j2, long j3, boolean z2, boolean z3, Long l, MessageReaction messageReaction, boolean z4, int i, boolean z5, boolean z6) {
        super(null);
        this.myUserId = j;
        this.channelId = j2;
        this.guildId = j3;
        this.isFollowedThread = z2;
        this.isArchivedThread = z3;
        this.messageId = l;
        this.reaction = messageReaction;
        this.isDefaultReaction = z4;
        this.messageCount = i;
        this.hasAddReactionPermission = z5;
        this.followRequestInProgress = z6;
    }

    public static /* synthetic */ WidgetForumPostStatusViewModel$ViewState$Valid copy$default(WidgetForumPostStatusViewModel$ViewState$Valid widgetForumPostStatusViewModel$ViewState$Valid, long j, long j2, long j3, boolean z2, boolean z3, Long l, MessageReaction messageReaction, boolean z4, int i, boolean z5, boolean z6, int i2, Object obj) {
        return widgetForumPostStatusViewModel$ViewState$Valid.copy((i2 & 1) != 0 ? widgetForumPostStatusViewModel$ViewState$Valid.myUserId : j, (i2 & 2) != 0 ? widgetForumPostStatusViewModel$ViewState$Valid.channelId : j2, (i2 & 4) != 0 ? widgetForumPostStatusViewModel$ViewState$Valid.guildId : j3, (i2 & 8) != 0 ? widgetForumPostStatusViewModel$ViewState$Valid.isFollowedThread : z2, (i2 & 16) != 0 ? widgetForumPostStatusViewModel$ViewState$Valid.isArchivedThread : z3, (i2 & 32) != 0 ? widgetForumPostStatusViewModel$ViewState$Valid.messageId : l, (i2 & 64) != 0 ? widgetForumPostStatusViewModel$ViewState$Valid.reaction : messageReaction, (i2 & 128) != 0 ? widgetForumPostStatusViewModel$ViewState$Valid.isDefaultReaction : z4, (i2 & 256) != 0 ? widgetForumPostStatusViewModel$ViewState$Valid.messageCount : i, (i2 & 512) != 0 ? widgetForumPostStatusViewModel$ViewState$Valid.hasAddReactionPermission : z5, (i2 & 1024) != 0 ? widgetForumPostStatusViewModel$ViewState$Valid.followRequestInProgress : z6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getMyUserId() {
        return this.myUserId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getHasAddReactionPermission() {
        return this.hasAddReactionPermission;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getFollowRequestInProgress() {
        return this.followRequestInProgress;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsFollowedThread() {
        return this.isFollowedThread;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsArchivedThread() {
        return this.isArchivedThread;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getMessageId() {
        return this.messageId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final MessageReaction getReaction() {
        return this.reaction;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsDefaultReaction() {
        return this.isDefaultReaction;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getMessageCount() {
        return this.messageCount;
    }

    public final WidgetForumPostStatusViewModel$ViewState$Valid copy(long myUserId, long channelId, long guildId, boolean isFollowedThread, boolean isArchivedThread, Long messageId, MessageReaction reaction, boolean isDefaultReaction, int messageCount, boolean hasAddReactionPermission, boolean followRequestInProgress) {
        return new WidgetForumPostStatusViewModel$ViewState$Valid(myUserId, channelId, guildId, isFollowedThread, isArchivedThread, messageId, reaction, isDefaultReaction, messageCount, hasAddReactionPermission, followRequestInProgress);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetForumPostStatusViewModel$ViewState$Valid)) {
            return false;
        }
        WidgetForumPostStatusViewModel$ViewState$Valid widgetForumPostStatusViewModel$ViewState$Valid = (WidgetForumPostStatusViewModel$ViewState$Valid) other;
        return this.myUserId == widgetForumPostStatusViewModel$ViewState$Valid.myUserId && this.channelId == widgetForumPostStatusViewModel$ViewState$Valid.channelId && this.guildId == widgetForumPostStatusViewModel$ViewState$Valid.guildId && this.isFollowedThread == widgetForumPostStatusViewModel$ViewState$Valid.isFollowedThread && this.isArchivedThread == widgetForumPostStatusViewModel$ViewState$Valid.isArchivedThread && m.areEqual(this.messageId, widgetForumPostStatusViewModel$ViewState$Valid.messageId) && m.areEqual(this.reaction, widgetForumPostStatusViewModel$ViewState$Valid.reaction) && this.isDefaultReaction == widgetForumPostStatusViewModel$ViewState$Valid.isDefaultReaction && this.messageCount == widgetForumPostStatusViewModel$ViewState$Valid.messageCount && this.hasAddReactionPermission == widgetForumPostStatusViewModel$ViewState$Valid.hasAddReactionPermission && this.followRequestInProgress == widgetForumPostStatusViewModel$ViewState$Valid.followRequestInProgress;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final boolean getFollowRequestInProgress() {
        return this.followRequestInProgress;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final boolean getHasAddReactionPermission() {
        return this.hasAddReactionPermission;
    }

    public final int getMessageCount() {
        return this.messageCount;
    }

    public final Long getMessageId() {
        return this.messageId;
    }

    public final long getMyUserId() {
        return this.myUserId;
    }

    public final MessageReaction getReaction() {
        return this.reaction;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public int hashCode() {
        int iA = (b.a(this.guildId) + ((b.a(this.channelId) + (b.a(this.myUserId) * 31)) * 31)) * 31;
        boolean z2 = this.isFollowedThread;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iA + r1) * 31;
        boolean z3 = this.isArchivedThread;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        Long l = this.messageId;
        int iHashCode = (i2 + (l != null ? l.hashCode() : 0)) * 31;
        MessageReaction messageReaction = this.reaction;
        int iHashCode2 = (iHashCode + (messageReaction != null ? messageReaction.hashCode() : 0)) * 31;
        boolean z4 = this.isDefaultReaction;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (((iHashCode2 + r3) * 31) + this.messageCount) * 31;
        boolean z5 = this.hasAddReactionPermission;
        ?? r4 = z5;
        if (z5) {
            r4 = 1;
        }
        int i4 = (i3 + r4) * 31;
        boolean z6 = this.followRequestInProgress;
        return i4 + (z6 ? 1 : z6);
    }

    public final boolean isArchivedThread() {
        return this.isArchivedThread;
    }

    public final boolean isDefaultReaction() {
        return this.isDefaultReaction;
    }

    public final boolean isFollowedThread() {
        return this.isFollowedThread;
    }

    public String toString() {
        StringBuilder sbU = a.U("Valid(myUserId=");
        sbU.append(this.myUserId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", isFollowedThread=");
        sbU.append(this.isFollowedThread);
        sbU.append(", isArchivedThread=");
        sbU.append(this.isArchivedThread);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", reaction=");
        sbU.append(this.reaction);
        sbU.append(", isDefaultReaction=");
        sbU.append(this.isDefaultReaction);
        sbU.append(", messageCount=");
        sbU.append(this.messageCount);
        sbU.append(", hasAddReactionPermission=");
        sbU.append(this.hasAddReactionPermission);
        sbU.append(", followRequestInProgress=");
        return a.O(sbU, this.followRequestInProgress, ")");
    }
}
