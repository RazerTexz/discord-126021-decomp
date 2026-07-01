package com.discord.widgets.guildscheduledevent;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildScheduledEventRsvpUserListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventRsvpUserListItem$RsvpUser extends GuildScheduledEventRsvpUserListItem {
    public static final GuildScheduledEventRsvpUserListItem$RsvpUser$Companion Companion = new GuildScheduledEventRsvpUserListItem$RsvpUser$Companion(null);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventRsvpUserListItem$RsvpUser(long j, String str, String str2, int i, String str3, String str4, long j2) {
        super(null);
        m.checkNotNullParameter(str, "username");
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

    public static /* synthetic */ GuildScheduledEventRsvpUserListItem$RsvpUser copy$default(GuildScheduledEventRsvpUserListItem$RsvpUser guildScheduledEventRsvpUserListItem$RsvpUser, long j, String str, String str2, int i, String str3, String str4, long j2, int i2, Object obj) {
        return guildScheduledEventRsvpUserListItem$RsvpUser.copy((i2 & 1) != 0 ? guildScheduledEventRsvpUserListItem$RsvpUser.userId : j, (i2 & 2) != 0 ? guildScheduledEventRsvpUserListItem$RsvpUser.username : str, (i2 & 4) != 0 ? guildScheduledEventRsvpUserListItem$RsvpUser.userAvatar : str2, (i2 & 8) != 0 ? guildScheduledEventRsvpUserListItem$RsvpUser.discriminator : i, (i2 & 16) != 0 ? guildScheduledEventRsvpUserListItem$RsvpUser.nickname : str3, (i2 & 32) != 0 ? guildScheduledEventRsvpUserListItem$RsvpUser.guildAvatar : str4, (i2 & 64) != 0 ? guildScheduledEventRsvpUserListItem$RsvpUser.guildId : j2);
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

    public final GuildScheduledEventRsvpUserListItem$RsvpUser copy(long userId, String username, String userAvatar, int discriminator, String nickname, String guildAvatar, long guildId) {
        m.checkNotNullParameter(username, "username");
        return new GuildScheduledEventRsvpUserListItem$RsvpUser(userId, username, userAvatar, discriminator, nickname, guildAvatar, guildId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventRsvpUserListItem$RsvpUser)) {
            return false;
        }
        GuildScheduledEventRsvpUserListItem$RsvpUser guildScheduledEventRsvpUserListItem$RsvpUser = (GuildScheduledEventRsvpUserListItem$RsvpUser) other;
        return this.userId == guildScheduledEventRsvpUserListItem$RsvpUser.userId && m.areEqual(this.username, guildScheduledEventRsvpUserListItem$RsvpUser.username) && m.areEqual(this.userAvatar, guildScheduledEventRsvpUserListItem$RsvpUser.userAvatar) && this.discriminator == guildScheduledEventRsvpUserListItem$RsvpUser.discriminator && m.areEqual(this.nickname, guildScheduledEventRsvpUserListItem$RsvpUser.nickname) && m.areEqual(this.guildAvatar, guildScheduledEventRsvpUserListItem$RsvpUser.guildAvatar) && this.guildId == guildScheduledEventRsvpUserListItem$RsvpUser.guildId;
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
        int iA = b.a(this.userId) * 31;
        String str = this.username;
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.userAvatar;
        int iHashCode2 = (((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.discriminator) * 31;
        String str3 = this.nickname;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.guildAvatar;
        return b.a(this.guildId) + ((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("RsvpUser(userId=");
        sbU.append(this.userId);
        sbU.append(", username=");
        sbU.append(this.username);
        sbU.append(", userAvatar=");
        sbU.append(this.userAvatar);
        sbU.append(", discriminator=");
        sbU.append(this.discriminator);
        sbU.append(", nickname=");
        sbU.append(this.nickname);
        sbU.append(", guildAvatar=");
        sbU.append(this.guildAvatar);
        sbU.append(", guildId=");
        return a.C(sbU, this.guildId, ")");
    }
}
