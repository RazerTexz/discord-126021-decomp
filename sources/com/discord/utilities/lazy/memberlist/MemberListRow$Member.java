package com.discord.utilities.lazy.memberlist;

import a0.a.a.b;
import androidx.annotation.ColorInt;
import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.presence.Presence;
import d0.z.d.m;

/* JADX INFO: compiled from: MemberListRow.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MemberListRow$Member extends MemberListRow {
    private final String avatarUrl;
    private final Integer color;
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
    public MemberListRow$Member(long j, String str, boolean z2, Integer num, boolean z3, Presence presence, @ColorInt Integer num2, String str2, boolean z4, String str3, boolean z5, int i) {
        super(String.valueOf(j), null);
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.userId = j;
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
        this.userFlags = i;
    }

    public static /* synthetic */ MemberListRow$Member copy$default(MemberListRow$Member memberListRow$Member, long j, String str, boolean z2, Integer num, boolean z3, Presence presence, Integer num2, String str2, boolean z4, String str3, boolean z5, int i, int i2, Object obj) {
        return memberListRow$Member.copy((i2 & 1) != 0 ? memberListRow$Member.userId : j, (i2 & 2) != 0 ? memberListRow$Member.name : str, (i2 & 4) != 0 ? memberListRow$Member.isBot : z2, (i2 & 8) != 0 ? memberListRow$Member.tagText : num, (i2 & 16) != 0 ? memberListRow$Member.tagVerified : z3, (i2 & 32) != 0 ? memberListRow$Member.presence : presence, (i2 & 64) != 0 ? memberListRow$Member.color : num2, (i2 & 128) != 0 ? memberListRow$Member.avatarUrl : str2, (i2 & 256) != 0 ? memberListRow$Member.showOwnerIndicator : z4, (i2 & 512) != 0 ? memberListRow$Member.premiumSince : str3, (i2 & 1024) != 0 ? memberListRow$Member.isApplicationStreaming : z5, (i2 & 2048) != 0 ? memberListRow$Member.userFlags : i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getPremiumSince() {
        return this.premiumSince;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getIsApplicationStreaming() {
        return this.isApplicationStreaming;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getUserFlags() {
        return this.userFlags;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsBot() {
        return this.isBot;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getTagText() {
        return this.tagText;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getTagVerified() {
        return this.tagVerified;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Presence getPresence() {
        return this.presence;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getShowOwnerIndicator() {
        return this.showOwnerIndicator;
    }

    public final MemberListRow$Member copy(long userId, String name, boolean isBot, Integer tagText, boolean tagVerified, Presence presence, @ColorInt Integer color, String avatarUrl, boolean showOwnerIndicator, String premiumSince, boolean isApplicationStreaming, int userFlags) {
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new MemberListRow$Member(userId, name, isBot, tagText, tagVerified, presence, color, avatarUrl, showOwnerIndicator, premiumSince, isApplicationStreaming, userFlags);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemberListRow$Member)) {
            return false;
        }
        MemberListRow$Member memberListRow$Member = (MemberListRow$Member) other;
        return this.userId == memberListRow$Member.userId && m.areEqual(this.name, memberListRow$Member.name) && this.isBot == memberListRow$Member.isBot && m.areEqual(this.tagText, memberListRow$Member.tagText) && this.tagVerified == memberListRow$Member.tagVerified && m.areEqual(this.presence, memberListRow$Member.presence) && m.areEqual(this.color, memberListRow$Member.color) && m.areEqual(this.avatarUrl, memberListRow$Member.avatarUrl) && this.showOwnerIndicator == memberListRow$Member.showOwnerIndicator && m.areEqual(this.premiumSince, memberListRow$Member.premiumSince) && this.isApplicationStreaming == memberListRow$Member.isApplicationStreaming && this.userFlags == memberListRow$Member.userFlags;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final Integer getColor() {
        return this.color;
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
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20, types: [int] */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int iA = b.a(this.userId) * 31;
        String str = this.name;
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.isBot;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        Integer num = this.tagText;
        int iHashCode2 = (i + (num != null ? num.hashCode() : 0)) * 31;
        boolean z3 = this.tagVerified;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (iHashCode2 + r2) * 31;
        Presence presence = this.presence;
        int iHashCode3 = (i2 + (presence != null ? presence.hashCode() : 0)) * 31;
        Integer num2 = this.color;
        int iHashCode4 = (iHashCode3 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str2 = this.avatarUrl;
        int iHashCode5 = (iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z4 = this.showOwnerIndicator;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (iHashCode5 + r3) * 31;
        String str3 = this.premiumSince;
        int iHashCode6 = (i3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z5 = this.isApplicationStreaming;
        return ((iHashCode6 + (z5 ? 1 : z5)) * 31) + this.userFlags;
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
        sbU.append(", userFlags=");
        return a.B(sbU, this.userFlags, ")");
    }
}
