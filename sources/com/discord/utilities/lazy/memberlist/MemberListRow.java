package com.discord.utilities.lazy.memberlist;

import androidx.annotation.ColorInt;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.presence.Presence;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: MemberListRow.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class MemberListRow {
    private final String rowId;

    /* JADX INFO: compiled from: MemberListRow.kt */
    public static final /* data */ class Member extends MemberListRow {
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
        public Member(long j, String str, boolean z2, Integer num, boolean z3, Presence presence, @ColorInt Integer num2, String str2, boolean z4, String str3, boolean z5, int i) {
            super(String.valueOf(j), null);
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
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

        public final Member copy(long userId, String name, boolean isBot, Integer tagText, boolean tagVerified, Presence presence, @ColorInt Integer color, String avatarUrl, boolean showOwnerIndicator, String premiumSince, boolean isApplicationStreaming, int userFlags) {
            C12238m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return new Member(userId, name, isBot, tagText, tagVerified, presence, color, avatarUrl, showOwnerIndicator, premiumSince, isApplicationStreaming, userFlags);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Member)) {
                return false;
            }
            Member member = (Member) other;
            return this.userId == member.userId && C12238m.areEqual(this.name, member.name) && this.isBot == member.isBot && C12238m.areEqual(this.tagText, member.tagText) && this.tagVerified == member.tagVerified && C12238m.areEqual(this.presence, member.presence) && C12238m.areEqual(this.color, member.color) && C12238m.areEqual(this.avatarUrl, member.avatarUrl) && this.showOwnerIndicator == member.showOwnerIndicator && C12238m.areEqual(this.premiumSince, member.premiumSince) && this.isApplicationStreaming == member.isApplicationStreaming && this.userFlags == member.userFlags;
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
            int iM3a = C0002b.m3a(this.userId) * 31;
            String str = this.name;
            int iHashCode = (iM3a + (str != null ? str.hashCode() : 0)) * 31;
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
            StringBuilder sbM833U = C1643a.m833U("Member(userId=");
            sbM833U.append(this.userId);
            sbM833U.append(", name=");
            sbM833U.append(this.name);
            sbM833U.append(", isBot=");
            sbM833U.append(this.isBot);
            sbM833U.append(", tagText=");
            sbM833U.append(this.tagText);
            sbM833U.append(", tagVerified=");
            sbM833U.append(this.tagVerified);
            sbM833U.append(", presence=");
            sbM833U.append(this.presence);
            sbM833U.append(", color=");
            sbM833U.append(this.color);
            sbM833U.append(", avatarUrl=");
            sbM833U.append(this.avatarUrl);
            sbM833U.append(", showOwnerIndicator=");
            sbM833U.append(this.showOwnerIndicator);
            sbM833U.append(", premiumSince=");
            sbM833U.append(this.premiumSince);
            sbM833U.append(", isApplicationStreaming=");
            sbM833U.append(this.isApplicationStreaming);
            sbM833U.append(", userFlags=");
            return C1643a.m814B(sbM833U, this.userFlags, ")");
        }
    }

    /* JADX INFO: compiled from: MemberListRow.kt */
    public static final /* data */ class RoleHeader extends MemberListRow {
        private final int memberCount;
        private final long roleId;
        private final String roleName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RoleHeader(long j, String str, int i) {
            super(String.valueOf(j), null);
            C12238m.checkNotNullParameter(str, "roleName");
            this.roleId = j;
            this.roleName = str;
            this.memberCount = i;
        }

        public static /* synthetic */ RoleHeader copy$default(RoleHeader roleHeader, long j, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = roleHeader.roleId;
            }
            if ((i2 & 2) != 0) {
                str = roleHeader.roleName;
            }
            if ((i2 & 4) != 0) {
                i = roleHeader.memberCount;
            }
            return roleHeader.copy(j, str, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getRoleId() {
            return this.roleId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getRoleName() {
            return this.roleName;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getMemberCount() {
            return this.memberCount;
        }

        public final RoleHeader copy(long roleId, String roleName, int memberCount) {
            C12238m.checkNotNullParameter(roleName, "roleName");
            return new RoleHeader(roleId, roleName, memberCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RoleHeader)) {
                return false;
            }
            RoleHeader roleHeader = (RoleHeader) other;
            return this.roleId == roleHeader.roleId && C12238m.areEqual(this.roleName, roleHeader.roleName) && this.memberCount == roleHeader.memberCount;
        }

        public final int getMemberCount() {
            return this.memberCount;
        }

        public final long getRoleId() {
            return this.roleId;
        }

        public final String getRoleName() {
            return this.roleName;
        }

        public int hashCode() {
            int iM3a = C0002b.m3a(this.roleId) * 31;
            String str = this.roleName;
            return ((iM3a + (str != null ? str.hashCode() : 0)) * 31) + this.memberCount;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("RoleHeader(roleId=");
            sbM833U.append(this.roleId);
            sbM833U.append(", roleName=");
            sbM833U.append(this.roleName);
            sbM833U.append(", memberCount=");
            return C1643a.m814B(sbM833U, this.memberCount, ")");
        }
    }

    /* JADX INFO: compiled from: MemberListRow.kt */
    public static final /* data */ class StatusHeader extends MemberListRow {
        private final int memberCount;
        private final String rowId;
        private final Type type;

        /* JADX INFO: compiled from: MemberListRow.kt */
        public enum Type {
            ONLINE(0),
            OFFLINE(1);

            private final long id;

            Type(long j) {
                this.id = j;
            }

            public final long getId() {
                return this.id;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StatusHeader(String str, Type type, int i) {
            super(str, null);
            C12238m.checkNotNullParameter(str, "rowId");
            C12238m.checkNotNullParameter(type, "type");
            this.rowId = str;
            this.type = type;
            this.memberCount = i;
        }

        public static /* synthetic */ StatusHeader copy$default(StatusHeader statusHeader, String str, Type type, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = statusHeader.getRowId();
            }
            if ((i2 & 2) != 0) {
                type = statusHeader.type;
            }
            if ((i2 & 4) != 0) {
                i = statusHeader.memberCount;
            }
            return statusHeader.copy(str, type, i);
        }

        public final String component1() {
            return getRowId();
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Type getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getMemberCount() {
            return this.memberCount;
        }

        public final StatusHeader copy(String rowId, Type type, int memberCount) {
            C12238m.checkNotNullParameter(rowId, "rowId");
            C12238m.checkNotNullParameter(type, "type");
            return new StatusHeader(rowId, type, memberCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StatusHeader)) {
                return false;
            }
            StatusHeader statusHeader = (StatusHeader) other;
            return C12238m.areEqual(getRowId(), statusHeader.getRowId()) && C12238m.areEqual(this.type, statusHeader.type) && this.memberCount == statusHeader.memberCount;
        }

        public final int getMemberCount() {
            return this.memberCount;
        }

        @Override // com.discord.utilities.lazy.memberlist.MemberListRow
        public String getRowId() {
            return this.rowId;
        }

        public final Type getType() {
            return this.type;
        }

        public int hashCode() {
            String rowId = getRowId();
            int iHashCode = (rowId != null ? rowId.hashCode() : 0) * 31;
            Type type = this.type;
            return ((iHashCode + (type != null ? type.hashCode() : 0)) * 31) + this.memberCount;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StatusHeader(rowId=");
            sbM833U.append(getRowId());
            sbM833U.append(", type=");
            sbM833U.append(this.type);
            sbM833U.append(", memberCount=");
            return C1643a.m814B(sbM833U, this.memberCount, ")");
        }
    }

    private MemberListRow(String str) {
        this.rowId = str;
    }

    public String getRowId() {
        return this.rowId;
    }

    public /* synthetic */ MemberListRow(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}
