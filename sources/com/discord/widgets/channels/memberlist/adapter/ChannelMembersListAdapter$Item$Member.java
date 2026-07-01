package com.discord.widgets.channels.memberlist.adapter;

import a0.a.a.b;
import androidx.annotation.ColorInt;
import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.presence.Presence;
import d0.z.d.m;

/* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChannelMembersListAdapter$Item$Member extends ChannelMembersListAdapter$Item {
    private final String avatarUrl;
    private final boolean canDisplayStatusEmoji;
    private final Integer color;
    private final Long guildId;
    private final boolean isApplicationStreaming;
    private final boolean isBot;
    private final String name;
    private final String premiumSince;
    private final Presence presence;
    private final boolean showOwnerIndicator;
    private final Integer tagText;
    private final boolean tagVerified;
    private final int userFlags;
    private final long userId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListAdapter$Item$Member(long j, Long l, String str, boolean z2, Integer num, boolean z3, Presence presence, @ColorInt Integer num2, String str2, boolean z4, String str3, boolean z5, boolean z6, int i) {
        super(ChannelMembersListAdapter$ViewType.MEMBER, Long.valueOf(j), null);
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.userId = j;
        this.guildId = l;
        this.name = str;
        this.isBot = z2;
        this.tagText = num;
        this.tagVerified = z3;
        this.presence = presence;
        this.color = num2;
        this.avatarUrl = str2;
        this.showOwnerIndicator = z4;
        this.premiumSince = str3;
        this.isApplicationStreaming = z5;
        this.canDisplayStatusEmoji = z6;
        this.userFlags = i;
    }

    public static /* synthetic */ ChannelMembersListAdapter$Item$Member copy$default(ChannelMembersListAdapter$Item$Member channelMembersListAdapter$Item$Member, long j, Long l, String str, boolean z2, Integer num, boolean z3, Presence presence, Integer num2, String str2, boolean z4, String str3, boolean z5, boolean z6, int i, int i2, Object obj) {
        return channelMembersListAdapter$Item$Member.copy((i2 & 1) != 0 ? channelMembersListAdapter$Item$Member.userId : j, (i2 & 2) != 0 ? channelMembersListAdapter$Item$Member.guildId : l, (i2 & 4) != 0 ? channelMembersListAdapter$Item$Member.name : str, (i2 & 8) != 0 ? channelMembersListAdapter$Item$Member.isBot : z2, (i2 & 16) != 0 ? channelMembersListAdapter$Item$Member.tagText : num, (i2 & 32) != 0 ? channelMembersListAdapter$Item$Member.tagVerified : z3, (i2 & 64) != 0 ? channelMembersListAdapter$Item$Member.presence : presence, (i2 & 128) != 0 ? channelMembersListAdapter$Item$Member.color : num2, (i2 & 256) != 0 ? channelMembersListAdapter$Item$Member.avatarUrl : str2, (i2 & 512) != 0 ? channelMembersListAdapter$Item$Member.showOwnerIndicator : z4, (i2 & 1024) != 0 ? channelMembersListAdapter$Item$Member.premiumSince : str3, (i2 & 2048) != 0 ? channelMembersListAdapter$Item$Member.isApplicationStreaming : z5, (i2 & 4096) != 0 ? channelMembersListAdapter$Item$Member.canDisplayStatusEmoji : z6, (i2 & 8192) != 0 ? channelMembersListAdapter$Item$Member.userFlags : i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getShowOwnerIndicator() {
        return this.showOwnerIndicator;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getPremiumSince() {
        return this.premiumSince;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getIsApplicationStreaming() {
        return this.isApplicationStreaming;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getCanDisplayStatusEmoji() {
        return this.canDisplayStatusEmoji;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getUserFlags() {
        return this.userFlags;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsBot() {
        return this.isBot;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getTagText() {
        return this.tagText;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getTagVerified() {
        return this.tagVerified;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Presence getPresence() {
        return this.presence;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final ChannelMembersListAdapter$Item$Member copy(long userId, Long guildId, String name, boolean isBot, Integer tagText, boolean tagVerified, Presence presence, @ColorInt Integer color, String avatarUrl, boolean showOwnerIndicator, String premiumSince, boolean isApplicationStreaming, boolean canDisplayStatusEmoji, int userFlags) {
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new ChannelMembersListAdapter$Item$Member(userId, guildId, name, isBot, tagText, tagVerified, presence, color, avatarUrl, showOwnerIndicator, premiumSince, isApplicationStreaming, canDisplayStatusEmoji, userFlags);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelMembersListAdapter$Item$Member)) {
            return false;
        }
        ChannelMembersListAdapter$Item$Member channelMembersListAdapter$Item$Member = (ChannelMembersListAdapter$Item$Member) other;
        return this.userId == channelMembersListAdapter$Item$Member.userId && m.areEqual(this.guildId, channelMembersListAdapter$Item$Member.guildId) && m.areEqual(this.name, channelMembersListAdapter$Item$Member.name) && this.isBot == channelMembersListAdapter$Item$Member.isBot && m.areEqual(this.tagText, channelMembersListAdapter$Item$Member.tagText) && this.tagVerified == channelMembersListAdapter$Item$Member.tagVerified && m.areEqual(this.presence, channelMembersListAdapter$Item$Member.presence) && m.areEqual(this.color, channelMembersListAdapter$Item$Member.color) && m.areEqual(this.avatarUrl, channelMembersListAdapter$Item$Member.avatarUrl) && this.showOwnerIndicator == channelMembersListAdapter$Item$Member.showOwnerIndicator && m.areEqual(this.premiumSince, channelMembersListAdapter$Item$Member.premiumSince) && this.isApplicationStreaming == channelMembersListAdapter$Item$Member.isApplicationStreaming && this.canDisplayStatusEmoji == channelMembersListAdapter$Item$Member.canDisplayStatusEmoji && this.userFlags == channelMembersListAdapter$Item$Member.userFlags;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final boolean getCanDisplayStatusEmoji() {
        return this.canDisplayStatusEmoji;
    }

    public final Integer getColor() {
        return this.color;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPremiumSince() {
        return this.premiumSince;
    }

    public final Presence getPresence() {
        return this.presence;
    }

    public final boolean getShowOwnerIndicator() {
        return this.showOwnerIndicator;
    }

    public final Integer getTagText() {
        return this.tagText;
    }

    public final boolean getTagVerified() {
        return this.tagVerified;
    }

    public final int getUserFlags() {
        return this.userFlags;
    }

    public final long getUserId() {
        return this.userId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r0v25, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v23, types: [int] */
    /* JADX WARN: Type inference failed for: r1v26, types: [int] */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int iA = b.a(this.userId) * 31;
        Long l = this.guildId;
        int iHashCode = (iA + (l != null ? l.hashCode() : 0)) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.isBot;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode2 + r1) * 31;
        Integer num = this.tagText;
        int iHashCode3 = (i + (num != null ? num.hashCode() : 0)) * 31;
        boolean z3 = this.tagVerified;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (iHashCode3 + r2) * 31;
        Presence presence = this.presence;
        int iHashCode4 = (i2 + (presence != null ? presence.hashCode() : 0)) * 31;
        Integer num2 = this.color;
        int iHashCode5 = (iHashCode4 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str2 = this.avatarUrl;
        int iHashCode6 = (iHashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z4 = this.showOwnerIndicator;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (iHashCode6 + r3) * 31;
        String str3 = this.premiumSince;
        int iHashCode7 = (i3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z5 = this.isApplicationStreaming;
        ?? r4 = z5;
        if (z5) {
            r4 = 1;
        }
        int i4 = (iHashCode7 + r4) * 31;
        boolean z6 = this.canDisplayStatusEmoji;
        return ((i4 + (z6 ? 1 : z6)) * 31) + this.userFlags;
    }

    public final boolean isApplicationStreaming() {
        return this.isApplicationStreaming;
    }

    public final boolean isBot() {
        return this.isBot;
    }

    public String toString() {
        StringBuilder sbU = a.U("Member(userId=");
        sbU.append(this.userId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", isBot=");
        sbU.append(this.isBot);
        sbU.append(", tagText=");
        sbU.append(this.tagText);
        sbU.append(", tagVerified=");
        sbU.append(this.tagVerified);
        sbU.append(", presence=");
        sbU.append(this.presence);
        sbU.append(", color=");
        sbU.append(this.color);
        sbU.append(", avatarUrl=");
        sbU.append(this.avatarUrl);
        sbU.append(", showOwnerIndicator=");
        sbU.append(this.showOwnerIndicator);
        sbU.append(", premiumSince=");
        sbU.append(this.premiumSince);
        sbU.append(", isApplicationStreaming=");
        sbU.append(this.isApplicationStreaming);
        sbU.append(", canDisplayStatusEmoji=");
        sbU.append(this.canDisplayStatusEmoji);
        sbU.append(", userFlags=");
        return a.B(sbU, this.userFlags, ")");
    }
}
