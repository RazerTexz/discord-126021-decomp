package com.discord.api.channel;

import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import com.discord.api.guildhash.GuildHashes;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.thread.ThreadMember;
import com.discord.api.thread.ThreadMetadata;
import com.discord.api.user.User;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Channel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Channel {
    public static final int ANNOUNCEMENT_THREAD = 10;
    public static final int CATEGORY = 4;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int DIRECTORY = 14;
    public static final int DM = 1;
    public static final long FLAGS_NONE = 0;
    public static final long FLAG_PINNED = 2;
    public static final int GROUP_DM = 3;
    public static final int GUILD_ANNOUNCEMENT = 5;
    public static final int GUILD_FORUM = 15;
    public static final int GUILD_STAGE_VOICE = 13;
    public static final int GUILD_STORE = 6;
    public static final int GUILD_TEXT = 0;
    public static final int GUILD_VOICE = 2;
    public static final int PRIVATE_THREAD = 12;
    public static final int PUBLIC_THREAD = 11;
    private final long applicationId;
    private final List<Long> appliedTags;
    private final List<ForumTag> availableTags;
    private final int bitrate;
    private final Integer defaultAutoArchiveDuration;
    private final Long flags;
    private transient GuildHashes guildHashes;
    private final long guildId;
    private final String icon;
    private final long id;
    private final long lastMessageId;
    private final transient ThreadMember member;
    private final transient Integer memberCount;
    private final transient List<Long> memberIdsPreview;
    private final String memberListId;
    private Integer messageCount;
    private final String name;
    private final List<ChannelRecipientNick> nicks;
    private final boolean nsfw;
    private final long originChannelId;
    private final long ownerId;
    private final long parentId;
    private final List<PermissionOverwrite> permissionOverwrites;
    private final int position;
    private final int rateLimitPerUser;
    private final List<Long> recipientIds;
    private final List<User> recipients;
    private final String rtcRegion;
    private final ThreadMetadata threadMetadata;
    private final String topic;
    private final int type;
    private final int userLimit;

    /* JADX INFO: compiled from: Channel.kt */
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public Channel(String str, int i, long j, String str2, long j2, long j3, long j4, List<Long> list, List<User> list2, int i2, List<PermissionOverwrite> list3, int i3, int i4, String str3, long j5, long j6, List<ChannelRecipientNick> list4, boolean z2, long j7, String str4, int i5, Integer num, String str5, Long l, GuildHashes guildHashes, List<ForumTag> list5, List<Long> list6, ThreadMetadata threadMetadata, Integer num2, Integer num3, List<Long> list7, ThreadMember threadMember) {
        this.topic = str;
        this.type = i;
        this.guildId = j;
        this.name = str2;
        this.lastMessageId = j2;
        this.id = j3;
        this.ownerId = j4;
        this.recipientIds = list;
        this.recipients = list2;
        this.position = i2;
        this.permissionOverwrites = list3;
        this.userLimit = i3;
        this.bitrate = i4;
        this.icon = str3;
        this.originChannelId = j5;
        this.applicationId = j6;
        this.nicks = list4;
        this.nsfw = z2;
        this.parentId = j7;
        this.memberListId = str4;
        this.rateLimitPerUser = i5;
        this.defaultAutoArchiveDuration = num;
        this.rtcRegion = str5;
        this.flags = l;
        this.guildHashes = guildHashes;
        this.availableTags = list5;
        this.appliedTags = list6;
        this.threadMetadata = threadMetadata;
        this.messageCount = num2;
        this.memberCount = num3;
        this.memberIdsPreview = list7;
        this.member = threadMember;
    }

    public static Channel a(Channel channel, String str, int i, long j, String str2, long j2, long j3, long j4, List list, List list2, int i2, List list3, int i3, int i4, String str3, long j5, long j6, List list4, boolean z2, long j7, String str4, int i5, Integer num, String str5, Long l, GuildHashes guildHashes, List list5, List list6, ThreadMetadata threadMetadata, Integer num2, Integer num3, List list7, ThreadMember threadMember, int i6) {
        String str6 = (i6 & 1) != 0 ? channel.topic : null;
        int i7 = (i6 & 2) != 0 ? channel.type : i;
        long j8 = (i6 & 4) != 0 ? channel.guildId : j;
        String str7 = (i6 & 8) != 0 ? channel.name : null;
        long j9 = (i6 & 16) != 0 ? channel.lastMessageId : j2;
        long j10 = (i6 & 32) != 0 ? channel.id : j3;
        long j11 = (i6 & 64) != 0 ? channel.ownerId : j4;
        List<Long> list8 = (i6 & 128) != 0 ? channel.recipientIds : null;
        List list9 = (i6 & 256) != 0 ? channel.recipients : list2;
        int i8 = (i6 & 512) != 0 ? channel.position : i2;
        List<PermissionOverwrite> list10 = (i6 & 1024) != 0 ? channel.permissionOverwrites : null;
        int i9 = (i6 & 2048) != 0 ? channel.userLimit : i3;
        int i10 = (i6 & 4096) != 0 ? channel.bitrate : i4;
        String str8 = (i6 & 8192) != 0 ? channel.icon : null;
        List<Long> list11 = list8;
        List list12 = list9;
        long j12 = (i6 & 16384) != 0 ? channel.originChannelId : j5;
        long j13 = (32768 & i6) != 0 ? channel.applicationId : j6;
        List list13 = (65536 & i6) != 0 ? channel.nicks : list4;
        boolean z3 = (i6 & 131072) != 0 ? channel.nsfw : z2;
        long j14 = j13;
        long j15 = (i6 & 262144) != 0 ? channel.parentId : j7;
        String str9 = (i6 & 524288) != 0 ? channel.memberListId : null;
        int i11 = (1048576 & i6) != 0 ? channel.rateLimitPerUser : i5;
        Integer num4 = (i6 & 2097152) != 0 ? channel.defaultAutoArchiveDuration : null;
        String str10 = (i6 & 4194304) != 0 ? channel.rtcRegion : null;
        Long l2 = (i6 & 8388608) != 0 ? channel.flags : null;
        GuildHashes guildHashes2 = (i6 & 16777216) != 0 ? channel.guildHashes : null;
        List<ForumTag> list14 = (i6 & 33554432) != 0 ? channel.availableTags : null;
        List<Long> list15 = (i6 & 67108864) != 0 ? channel.appliedTags : null;
        ThreadMetadata threadMetadata2 = (i6 & 134217728) != 0 ? channel.threadMetadata : null;
        Integer num5 = (i6 & 268435456) != 0 ? channel.messageCount : null;
        Integer num6 = (i6 & 536870912) != 0 ? channel.memberCount : null;
        List<Long> list16 = (i6 & BasicMeasure.EXACTLY) != 0 ? channel.memberIdsPreview : null;
        ThreadMember threadMember2 = (i6 & Integer.MIN_VALUE) != 0 ? channel.member : null;
        Objects.requireNonNull(channel);
        return new Channel(str6, i7, j8, str7, j9, j10, j11, list11, list12, i8, list10, i9, i10, str8, j12, j14, list13, z3, j15, str9, i11, num4, str10, l2, guildHashes2, list14, list15, threadMetadata2, num5, num6, list16, threadMember2);
    }

    /* JADX INFO: renamed from: A, reason: from getter */
    public final String getRtcRegion() {
        return this.rtcRegion;
    }

    /* JADX INFO: renamed from: B, reason: from getter */
    public final ThreadMetadata getThreadMetadata() {
        return this.threadMetadata;
    }

    /* JADX INFO: renamed from: C, reason: from getter */
    public final String getTopic() {
        return this.topic;
    }

    /* JADX INFO: renamed from: D, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: E, reason: from getter */
    public final int getUserLimit() {
        return this.userLimit;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final long getApplicationId() {
        return this.applicationId;
    }

    public final List<Long> c() {
        return this.appliedTags;
    }

    public final List<ForumTag> d() {
        return this.availableTags;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final int getBitrate() {
        return this.bitrate;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Channel)) {
            return false;
        }
        Channel channel = (Channel) other;
        return Intrinsics3.areEqual(this.topic, channel.topic) && this.type == channel.type && this.guildId == channel.guildId && Intrinsics3.areEqual(this.name, channel.name) && this.lastMessageId == channel.lastMessageId && this.id == channel.id && this.ownerId == channel.ownerId && Intrinsics3.areEqual(this.recipientIds, channel.recipientIds) && Intrinsics3.areEqual(this.recipients, channel.recipients) && this.position == channel.position && Intrinsics3.areEqual(this.permissionOverwrites, channel.permissionOverwrites) && this.userLimit == channel.userLimit && this.bitrate == channel.bitrate && Intrinsics3.areEqual(this.icon, channel.icon) && this.originChannelId == channel.originChannelId && this.applicationId == channel.applicationId && Intrinsics3.areEqual(this.nicks, channel.nicks) && this.nsfw == channel.nsfw && this.parentId == channel.parentId && Intrinsics3.areEqual(this.memberListId, channel.memberListId) && this.rateLimitPerUser == channel.rateLimitPerUser && Intrinsics3.areEqual(this.defaultAutoArchiveDuration, channel.defaultAutoArchiveDuration) && Intrinsics3.areEqual(this.rtcRegion, channel.rtcRegion) && Intrinsics3.areEqual(this.flags, channel.flags) && Intrinsics3.areEqual(this.guildHashes, channel.guildHashes) && Intrinsics3.areEqual(this.availableTags, channel.availableTags) && Intrinsics3.areEqual(this.appliedTags, channel.appliedTags) && Intrinsics3.areEqual(this.threadMetadata, channel.threadMetadata) && Intrinsics3.areEqual(this.messageCount, channel.messageCount) && Intrinsics3.areEqual(this.memberCount, channel.memberCount) && Intrinsics3.areEqual(this.memberIdsPreview, channel.memberIdsPreview) && Intrinsics3.areEqual(this.member, channel.member);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final Integer getDefaultAutoArchiveDuration() {
        return this.defaultAutoArchiveDuration;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final Long getFlags() {
        return this.flags;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final GuildHashes getGuildHashes() {
        return this.guildHashes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v36, types: [int] */
    /* JADX WARN: Type inference failed for: r2v35, types: [int] */
    /* JADX WARN: Type inference failed for: r2v84 */
    /* JADX WARN: Type inference failed for: r2v91 */
    public int hashCode() {
        String str = this.topic;
        int iHashCode = (((str != null ? str.hashCode() : 0) * 31) + this.type) * 31;
        long j = this.guildId;
        int i = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        String str2 = this.name;
        int iHashCode2 = (i + (str2 != null ? str2.hashCode() : 0)) * 31;
        long j2 = this.lastMessageId;
        int i2 = (iHashCode2 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.id;
        int i3 = (i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.ownerId;
        int i4 = (i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        List<Long> list = this.recipientIds;
        int iHashCode3 = (i4 + (list != null ? list.hashCode() : 0)) * 31;
        List<User> list2 = this.recipients;
        int iHashCode4 = (((iHashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31) + this.position) * 31;
        List<PermissionOverwrite> list3 = this.permissionOverwrites;
        int iHashCode5 = (((((iHashCode4 + (list3 != null ? list3.hashCode() : 0)) * 31) + this.userLimit) * 31) + this.bitrate) * 31;
        String str3 = this.icon;
        int iHashCode6 = (iHashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        long j5 = this.originChannelId;
        int i5 = (iHashCode6 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j6 = this.applicationId;
        int i6 = (i5 + ((int) (j6 ^ (j6 >>> 32)))) * 31;
        List<ChannelRecipientNick> list4 = this.nicks;
        int iHashCode7 = (i6 + (list4 != null ? list4.hashCode() : 0)) * 31;
        boolean z2 = this.nsfw;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i7 = (iHashCode7 + r2) * 31;
        long j7 = this.parentId;
        int i8 = (i7 + ((int) (j7 ^ (j7 >>> 32)))) * 31;
        String str4 = this.memberListId;
        int iHashCode8 = (((i8 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.rateLimitPerUser) * 31;
        Integer num = this.defaultAutoArchiveDuration;
        int iHashCode9 = (iHashCode8 + (num != null ? num.hashCode() : 0)) * 31;
        String str5 = this.rtcRegion;
        int iHashCode10 = (iHashCode9 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Long l = this.flags;
        int iHashCode11 = (iHashCode10 + (l != null ? l.hashCode() : 0)) * 31;
        GuildHashes guildHashes = this.guildHashes;
        int iHashCode12 = (iHashCode11 + (guildHashes != null ? guildHashes.hashCode() : 0)) * 31;
        List<ForumTag> list5 = this.availableTags;
        int iHashCode13 = (iHashCode12 + (list5 != null ? list5.hashCode() : 0)) * 31;
        List<Long> list6 = this.appliedTags;
        int iHashCode14 = (iHashCode13 + (list6 != null ? list6.hashCode() : 0)) * 31;
        ThreadMetadata threadMetadata = this.threadMetadata;
        int iHashCode15 = (iHashCode14 + (threadMetadata != null ? threadMetadata.hashCode() : 0)) * 31;
        Integer num2 = this.messageCount;
        int iHashCode16 = (iHashCode15 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.memberCount;
        int iHashCode17 = (iHashCode16 + (num3 != null ? num3.hashCode() : 0)) * 31;
        List<Long> list7 = this.memberIdsPreview;
        int iHashCode18 = (iHashCode17 + (list7 != null ? list7.hashCode() : 0)) * 31;
        ThreadMember threadMember = this.member;
        return iHashCode18 + (threadMember != null ? threadMember.hashCode() : 0);
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final long getLastMessageId() {
        return this.lastMessageId;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final ThreadMember getMember() {
        return this.member;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final String getMemberListId() {
        return this.memberListId;
    }

    /* JADX INFO: renamed from: o, reason: from getter */
    public final Integer getMessageCount() {
        return this.messageCount;
    }

    /* JADX INFO: renamed from: p, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<ChannelRecipientNick> q() {
        return this.nicks;
    }

    /* JADX INFO: renamed from: r, reason: from getter */
    public final boolean getNsfw() {
        return this.nsfw;
    }

    /* JADX INFO: renamed from: s, reason: from getter */
    public final long getOriginChannelId() {
        return this.originChannelId;
    }

    /* JADX INFO: renamed from: t, reason: from getter */
    public final long getOwnerId() {
        return this.ownerId;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Channel(topic=");
        sbU.append(this.topic);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", lastMessageId=");
        sbU.append(this.lastMessageId);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", ownerId=");
        sbU.append(this.ownerId);
        sbU.append(", recipientIds=");
        sbU.append(this.recipientIds);
        sbU.append(", recipients=");
        sbU.append(this.recipients);
        sbU.append(", position=");
        sbU.append(this.position);
        sbU.append(", permissionOverwrites=");
        sbU.append(this.permissionOverwrites);
        sbU.append(", userLimit=");
        sbU.append(this.userLimit);
        sbU.append(", bitrate=");
        sbU.append(this.bitrate);
        sbU.append(", icon=");
        sbU.append(this.icon);
        sbU.append(", originChannelId=");
        sbU.append(this.originChannelId);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", nicks=");
        sbU.append(this.nicks);
        sbU.append(", nsfw=");
        sbU.append(this.nsfw);
        sbU.append(", parentId=");
        sbU.append(this.parentId);
        sbU.append(", memberListId=");
        sbU.append(this.memberListId);
        sbU.append(", rateLimitPerUser=");
        sbU.append(this.rateLimitPerUser);
        sbU.append(", defaultAutoArchiveDuration=");
        sbU.append(this.defaultAutoArchiveDuration);
        sbU.append(", rtcRegion=");
        sbU.append(this.rtcRegion);
        sbU.append(", flags=");
        sbU.append(this.flags);
        sbU.append(", guildHashes=");
        sbU.append(this.guildHashes);
        sbU.append(", availableTags=");
        sbU.append(this.availableTags);
        sbU.append(", appliedTags=");
        sbU.append(this.appliedTags);
        sbU.append(", threadMetadata=");
        sbU.append(this.threadMetadata);
        sbU.append(", messageCount=");
        sbU.append(this.messageCount);
        sbU.append(", memberCount=");
        sbU.append(this.memberCount);
        sbU.append(", memberIdsPreview=");
        sbU.append(this.memberIdsPreview);
        sbU.append(", member=");
        sbU.append(this.member);
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX INFO: renamed from: u, reason: from getter */
    public final long getParentId() {
        return this.parentId;
    }

    public final List<PermissionOverwrite> v() {
        return this.permissionOverwrites;
    }

    /* JADX INFO: renamed from: w, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    /* JADX INFO: renamed from: x, reason: from getter */
    public final int getRateLimitPerUser() {
        return this.rateLimitPerUser;
    }

    public final List<Long> y() {
        return this.recipientIds;
    }

    public final List<User> z() {
        return this.recipients;
    }
}
