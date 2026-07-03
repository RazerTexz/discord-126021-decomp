package com.discord.widgets.guildscheduledevent;

import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildScheduledEventRsvpUserListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GuildScheduledEventRsvpUserListItem implements MGRecyclerDataPayload {
    public static final int TYPE_EVENT_RSVP_USER = 0;

    /* JADX INFO: compiled from: GuildScheduledEventRsvpUserListItem.kt */
    public static final /* data */ class RsvpUser extends GuildScheduledEventRsvpUserListItem {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int discriminator;
        private final String displayName;
        private final String guildAvatar;
        private final long guildId;
        private final String key;
        private final String nickname;
        private final int type;
        private final String userAvatar;
        private final long userId;
        private final String username;

        /* JADX INFO: compiled from: GuildScheduledEventRsvpUserListItem.kt */
        public static final class Companion {
            private Companion() {
            }

            public final RsvpUser from(GuildScheduledEventUser guildScheduledEventUser, long guildId) {
                C12238m.checkNotNullParameter(guildScheduledEventUser, "guildScheduledEventUser");
                return new RsvpUser(guildScheduledEventUser.getUser().getId(), guildScheduledEventUser.getUser().getUsername(), guildScheduledEventUser.getUser().getAvatar(), guildScheduledEventUser.getUser().getDiscriminator(), guildScheduledEventUser.getGuildMember().getNick(), guildScheduledEventUser.getGuildMember().getAvatarHash(), guildId);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RsvpUser(long j, String str, String str2, int i, String str3, String str4, long j2) {
            super(null);
            C12238m.checkNotNullParameter(str, "username");
            this.userId = j;
            this.username = str;
            this.userAvatar = str2;
            this.discriminator = i;
            this.nickname = str3;
            this.guildAvatar = str4;
            this.guildId = j2;
            this.key = String.valueOf(j);
            this.displayName = str3 != null ? str3 : str;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getUserId() {
            return this.userId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUsername() {
            return this.username;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getUserAvatar() {
            return this.userAvatar;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getDiscriminator() {
            return this.discriminator;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getNickname() {
            return this.nickname;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getGuildAvatar() {
            return this.guildAvatar;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        public final RsvpUser copy(long userId, String username, String userAvatar, int discriminator, String nickname, String guildAvatar, long guildId) {
            C12238m.checkNotNullParameter(username, "username");
            return new RsvpUser(userId, username, userAvatar, discriminator, nickname, guildAvatar, guildId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RsvpUser)) {
                return false;
            }
            RsvpUser rsvpUser = (RsvpUser) other;
            return this.userId == rsvpUser.userId && C12238m.areEqual(this.username, rsvpUser.username) && C12238m.areEqual(this.userAvatar, rsvpUser.userAvatar) && this.discriminator == rsvpUser.discriminator && C12238m.areEqual(this.nickname, rsvpUser.nickname) && C12238m.areEqual(this.guildAvatar, rsvpUser.guildAvatar) && this.guildId == rsvpUser.guildId;
        }

        public final int getDiscriminator() {
            return this.discriminator;
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        public final String getGuildAvatar() {
            return this.guildAvatar;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final String getNickname() {
            return this.nickname;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public final String getUserAvatar() {
            return this.userAvatar;
        }

        public final long getUserId() {
            return this.userId;
        }

        public final String getUsername() {
            return this.username;
        }

        public int hashCode() {
            int iM3a = C0002b.m3a(this.userId) * 31;
            String str = this.username;
            int iHashCode = (iM3a + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.userAvatar;
            int iHashCode2 = (((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.discriminator) * 31;
            String str3 = this.nickname;
            int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.guildAvatar;
            return C0002b.m3a(this.guildId) + ((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("RsvpUser(userId=");
            sbM833U.append(this.userId);
            sbM833U.append(", username=");
            sbM833U.append(this.username);
            sbM833U.append(", userAvatar=");
            sbM833U.append(this.userAvatar);
            sbM833U.append(", discriminator=");
            sbM833U.append(this.discriminator);
            sbM833U.append(", nickname=");
            sbM833U.append(this.nickname);
            sbM833U.append(", guildAvatar=");
            sbM833U.append(this.guildAvatar);
            sbM833U.append(", guildId=");
            return C1643a.m815C(sbM833U, this.guildId, ")");
        }
    }

    private GuildScheduledEventRsvpUserListItem() {
    }

    public /* synthetic */ GuildScheduledEventRsvpUserListItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
