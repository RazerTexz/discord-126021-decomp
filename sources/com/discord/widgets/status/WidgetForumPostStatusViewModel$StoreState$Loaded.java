package com.discord.widgets.status;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.message.reaction.MessageReaction;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetForumPostStatusViewModel$StoreState$Loaded extends WidgetForumPostStatusViewModel$StoreState {
    private final long channelId;
    private final long guildId;
    private final boolean hasAddReactionPermission;
    private final boolean isArchivedThread;
    private final boolean isDefaultReaction;
    private final boolean isFollowedThread;
    private final Integer messageCount;
    private final Long messageId;
    private final MessageReaction mostCommonReaction;
    private final long myUserId;

    public WidgetForumPostStatusViewModel$StoreState$Loaded(long j, long j2, long j3, Long l, boolean z2, boolean z3, Integer num, boolean z4, boolean z5, MessageReaction messageReaction) {
        super(null);
        this.myUserId = j;
        this.channelId = j2;
        this.guildId = j3;
        this.messageId = l;
        this.isFollowedThread = z2;
        this.isArchivedThread = z3;
        this.messageCount = num;
        this.hasAddReactionPermission = z4;
        this.isDefaultReaction = z5;
        this.mostCommonReaction = messageReaction;
    }

    public static /* synthetic */ WidgetForumPostStatusViewModel$StoreState$Loaded copy$default(WidgetForumPostStatusViewModel$StoreState$Loaded widgetForumPostStatusViewModel$StoreState$Loaded, long j, long j2, long j3, Long l, boolean z2, boolean z3, Integer num, boolean z4, boolean z5, MessageReaction messageReaction, int i, Object obj) {
        return widgetForumPostStatusViewModel$StoreState$Loaded.copy((i & 1) != 0 ? widgetForumPostStatusViewModel$StoreState$Loaded.myUserId : j, (i & 2) != 0 ? widgetForumPostStatusViewModel$StoreState$Loaded.channelId : j2, (i & 4) != 0 ? widgetForumPostStatusViewModel$StoreState$Loaded.guildId : j3, (i & 8) != 0 ? widgetForumPostStatusViewModel$StoreState$Loaded.messageId : l, (i & 16) != 0 ? widgetForumPostStatusViewModel$StoreState$Loaded.isFollowedThread : z2, (i & 32) != 0 ? widgetForumPostStatusViewModel$StoreState$Loaded.isArchivedThread : z3, (i & 64) != 0 ? widgetForumPostStatusViewModel$StoreState$Loaded.messageCount : num, (i & 128) != 0 ? widgetForumPostStatusViewModel$StoreState$Loaded.hasAddReactionPermission : z4, (i & 256) != 0 ? widgetForumPostStatusViewModel$StoreState$Loaded.isDefaultReaction : z5, (i & 512) != 0 ? widgetForumPostStatusViewModel$StoreState$Loaded.mostCommonReaction : messageReaction);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getMyUserId() {
        return this.myUserId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final MessageReaction getMostCommonReaction() {
        return this.mostCommonReaction;
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
    public final Long getMessageId() {
        return this.messageId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsFollowedThread() {
        return this.isFollowedThread;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsArchivedThread() {
        return this.isArchivedThread;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getMessageCount() {
        return this.messageCount;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getHasAddReactionPermission() {
        return this.hasAddReactionPermission;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsDefaultReaction() {
        return this.isDefaultReaction;
    }

    public final WidgetForumPostStatusViewModel$StoreState$Loaded copy(long myUserId, long channelId, long guildId, Long messageId, boolean isFollowedThread, boolean isArchivedThread, Integer messageCount, boolean hasAddReactionPermission, boolean isDefaultReaction, MessageReaction mostCommonReaction) {
        return new WidgetForumPostStatusViewModel$StoreState$Loaded(myUserId, channelId, guildId, messageId, isFollowedThread, isArchivedThread, messageCount, hasAddReactionPermission, isDefaultReaction, mostCommonReaction);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetForumPostStatusViewModel$StoreState$Loaded)) {
            return false;
        }
        WidgetForumPostStatusViewModel$StoreState$Loaded widgetForumPostStatusViewModel$StoreState$Loaded = (WidgetForumPostStatusViewModel$StoreState$Loaded) other;
        return this.myUserId == widgetForumPostStatusViewModel$StoreState$Loaded.myUserId && this.channelId == widgetForumPostStatusViewModel$StoreState$Loaded.channelId && this.guildId == widgetForumPostStatusViewModel$StoreState$Loaded.guildId && m.areEqual(this.messageId, widgetForumPostStatusViewModel$StoreState$Loaded.messageId) && this.isFollowedThread == widgetForumPostStatusViewModel$StoreState$Loaded.isFollowedThread && this.isArchivedThread == widgetForumPostStatusViewModel$StoreState$Loaded.isArchivedThread && m.areEqual(this.messageCount, widgetForumPostStatusViewModel$StoreState$Loaded.messageCount) && this.hasAddReactionPermission == widgetForumPostStatusViewModel$StoreState$Loaded.hasAddReactionPermission && this.isDefaultReaction == widgetForumPostStatusViewModel$StoreState$Loaded.isDefaultReaction && m.areEqual(this.mostCommonReaction, widgetForumPostStatusViewModel$StoreState$Loaded.mostCommonReaction);
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final boolean getHasAddReactionPermission() {
        return this.hasAddReactionPermission;
    }

    public final Integer getMessageCount() {
        return this.messageCount;
    }

    public final Long getMessageId() {
        return this.messageId;
    }

    public final MessageReaction getMostCommonReaction() {
        return this.mostCommonReaction;
    }

    public final long getMyUserId() {
        return this.myUserId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int iA = (b.a(this.guildId) + ((b.a(this.channelId) + (b.a(this.myUserId) * 31)) * 31)) * 31;
        Long l = this.messageId;
        int iHashCode = (iA + (l != null ? l.hashCode() : 0)) * 31;
        boolean z2 = this.isFollowedThread;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z3 = this.isArchivedThread;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        Integer num = this.messageCount;
        int iHashCode2 = (i2 + (num != null ? num.hashCode() : 0)) * 31;
        boolean z4 = this.hasAddReactionPermission;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (iHashCode2 + r3) * 31;
        boolean z5 = this.isDefaultReaction;
        int i4 = (i3 + (z5 ? 1 : z5)) * 31;
        MessageReaction messageReaction = this.mostCommonReaction;
        return i4 + (messageReaction != null ? messageReaction.hashCode() : 0);
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
        StringBuilder sbU = a.U("Loaded(myUserId=");
        sbU.append(this.myUserId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", isFollowedThread=");
        sbU.append(this.isFollowedThread);
        sbU.append(", isArchivedThread=");
        sbU.append(this.isArchivedThread);
        sbU.append(", messageCount=");
        sbU.append(this.messageCount);
        sbU.append(", hasAddReactionPermission=");
        sbU.append(this.hasAddReactionPermission);
        sbU.append(", isDefaultReaction=");
        sbU.append(this.isDefaultReaction);
        sbU.append(", mostCommonReaction=");
        sbU.append(this.mostCommonReaction);
        sbU.append(")");
        return sbU.toString();
    }
}
