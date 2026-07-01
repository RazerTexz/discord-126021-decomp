package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.channel.ForumTag;
import com.discord.models.member.GuildMember;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: StartOfChatEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StartOfChatEntry extends ChatListEntry {
    private final List<Long> appliedTags;
    private final List<ForumTag> availableTags;
    private final boolean canAccessRedesignedForumChannels;
    private final boolean canManageChannel;
    private final boolean canManageThread;
    private final boolean canReadMessageHistory;
    private final long channelId;
    private final String channelName;
    private final boolean isGuildForumPost;
    private final boolean isTextInVoice;
    private final boolean isThread;
    private final String key;
    private final Integer threadAutoArchiveDuration;
    private final GuildMember threadCreatorMember;
    private final String threadCreatorName;
    private final int type;

    public StartOfChatEntry(long j, String str, boolean z2, boolean z3, boolean z4, boolean z5, Integer num, GuildMember guildMember, String str2, boolean z6, boolean z7, boolean z8, List<ForumTag> list, List<Long> list2) {
        Intrinsics3.checkNotNullParameter(str, "channelName");
        Intrinsics3.checkNotNullParameter(str2, "threadCreatorName");
        this.channelId = j;
        this.channelName = str;
        this.canReadMessageHistory = z2;
        this.canManageChannel = z3;
        this.canManageThread = z4;
        this.isThread = z5;
        this.threadAutoArchiveDuration = num;
        this.threadCreatorMember = guildMember;
        this.threadCreatorName = str2;
        this.isTextInVoice = z6;
        this.isGuildForumPost = z7;
        this.canAccessRedesignedForumChannels = z8;
        this.availableTags = list;
        this.appliedTags = list2;
        this.type = 3;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(j);
        this.key = sb.toString();
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsTextInVoice() {
        return this.isTextInVoice;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getIsGuildForumPost() {
        return this.isGuildForumPost;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getCanAccessRedesignedForumChannels() {
        return this.canAccessRedesignedForumChannels;
    }

    public final List<ForumTag> component13() {
        return this.availableTags;
    }

    public final List<Long> component14() {
        return this.appliedTags;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getCanReadMessageHistory() {
        return this.canReadMessageHistory;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getCanManageChannel() {
        return this.canManageChannel;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getCanManageThread() {
        return this.canManageThread;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsThread() {
        return this.isThread;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getThreadAutoArchiveDuration() {
        return this.threadAutoArchiveDuration;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final GuildMember getThreadCreatorMember() {
        return this.threadCreatorMember;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getThreadCreatorName() {
        return this.threadCreatorName;
    }

    public final StartOfChatEntry copy(long channelId, String channelName, boolean canReadMessageHistory, boolean canManageChannel, boolean canManageThread, boolean isThread, Integer threadAutoArchiveDuration, GuildMember threadCreatorMember, String threadCreatorName, boolean isTextInVoice, boolean isGuildForumPost, boolean canAccessRedesignedForumChannels, List<ForumTag> availableTags, List<Long> appliedTags) {
        Intrinsics3.checkNotNullParameter(channelName, "channelName");
        Intrinsics3.checkNotNullParameter(threadCreatorName, "threadCreatorName");
        return new StartOfChatEntry(channelId, channelName, canReadMessageHistory, canManageChannel, canManageThread, isThread, threadAutoArchiveDuration, threadCreatorMember, threadCreatorName, isTextInVoice, isGuildForumPost, canAccessRedesignedForumChannels, availableTags, appliedTags);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StartOfChatEntry)) {
            return false;
        }
        StartOfChatEntry startOfChatEntry = (StartOfChatEntry) other;
        return this.channelId == startOfChatEntry.channelId && Intrinsics3.areEqual(this.channelName, startOfChatEntry.channelName) && this.canReadMessageHistory == startOfChatEntry.canReadMessageHistory && this.canManageChannel == startOfChatEntry.canManageChannel && this.canManageThread == startOfChatEntry.canManageThread && this.isThread == startOfChatEntry.isThread && Intrinsics3.areEqual(this.threadAutoArchiveDuration, startOfChatEntry.threadAutoArchiveDuration) && Intrinsics3.areEqual(this.threadCreatorMember, startOfChatEntry.threadCreatorMember) && Intrinsics3.areEqual(this.threadCreatorName, startOfChatEntry.threadCreatorName) && this.isTextInVoice == startOfChatEntry.isTextInVoice && this.isGuildForumPost == startOfChatEntry.isGuildForumPost && this.canAccessRedesignedForumChannels == startOfChatEntry.canAccessRedesignedForumChannels && Intrinsics3.areEqual(this.availableTags, startOfChatEntry.availableTags) && Intrinsics3.areEqual(this.appliedTags, startOfChatEntry.appliedTags);
    }

    public final List<Long> getAppliedTags() {
        return this.appliedTags;
    }

    public final List<ForumTag> getAvailableTags() {
        return this.availableTags;
    }

    public final boolean getCanAccessRedesignedForumChannels() {
        return this.canAccessRedesignedForumChannels;
    }

    public final boolean getCanManageChannel() {
        return this.canManageChannel;
    }

    public final boolean getCanManageThread() {
        return this.canManageThread;
    }

    public final boolean getCanReadMessageHistory() {
        return this.canReadMessageHistory;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Integer getThreadAutoArchiveDuration() {
        return this.threadAutoArchiveDuration;
    }

    public final GuildMember getThreadCreatorMember() {
        return this.threadCreatorMember;
    }

    public final String getThreadCreatorName() {
        return this.threadCreatorName;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v21, types: [int] */
    /* JADX WARN: Type inference failed for: r1v23, types: [int] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int iA = b.a(this.channelId) * 31;
        String str = this.channelName;
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.canReadMessageHistory;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z3 = this.canManageChannel;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.canManageThread;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        boolean z5 = this.isThread;
        ?? r4 = z5;
        if (z5) {
            r4 = 1;
        }
        int i4 = (i3 + r4) * 31;
        Integer num = this.threadAutoArchiveDuration;
        int iHashCode2 = (i4 + (num != null ? num.hashCode() : 0)) * 31;
        GuildMember guildMember = this.threadCreatorMember;
        int iHashCode3 = (iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        String str2 = this.threadCreatorName;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z6 = this.isTextInVoice;
        ?? r5 = z6;
        if (z6) {
            r5 = 1;
        }
        int i5 = (iHashCode4 + r5) * 31;
        boolean z7 = this.isGuildForumPost;
        ?? r6 = z7;
        if (z7) {
            r6 = 1;
        }
        int i6 = (i5 + r6) * 31;
        boolean z8 = this.canAccessRedesignedForumChannels;
        int i7 = (i6 + (z8 ? 1 : z8)) * 31;
        List<ForumTag> list = this.availableTags;
        int iHashCode5 = (i7 + (list != null ? list.hashCode() : 0)) * 31;
        List<Long> list2 = this.appliedTags;
        return iHashCode5 + (list2 != null ? list2.hashCode() : 0);
    }

    public final boolean isGuildForumPost() {
        return this.isGuildForumPost;
    }

    public final boolean isTextInVoice() {
        return this.isTextInVoice;
    }

    public final boolean isThread() {
        return this.isThread;
    }

    public String toString() {
        StringBuilder sbU = outline.U("StartOfChatEntry(channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelName=");
        sbU.append(this.channelName);
        sbU.append(", canReadMessageHistory=");
        sbU.append(this.canReadMessageHistory);
        sbU.append(", canManageChannel=");
        sbU.append(this.canManageChannel);
        sbU.append(", canManageThread=");
        sbU.append(this.canManageThread);
        sbU.append(", isThread=");
        sbU.append(this.isThread);
        sbU.append(", threadAutoArchiveDuration=");
        sbU.append(this.threadAutoArchiveDuration);
        sbU.append(", threadCreatorMember=");
        sbU.append(this.threadCreatorMember);
        sbU.append(", threadCreatorName=");
        sbU.append(this.threadCreatorName);
        sbU.append(", isTextInVoice=");
        sbU.append(this.isTextInVoice);
        sbU.append(", isGuildForumPost=");
        sbU.append(this.isGuildForumPost);
        sbU.append(", canAccessRedesignedForumChannels=");
        sbU.append(this.canAccessRedesignedForumChannels);
        sbU.append(", availableTags=");
        sbU.append(this.availableTags);
        sbU.append(", appliedTags=");
        return outline.L(sbU, this.appliedTags, ")");
    }
}
