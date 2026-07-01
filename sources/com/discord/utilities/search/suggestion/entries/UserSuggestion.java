package com.discord.utilities.search.suggestion.entries;

import b.d.b.a.a;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: UserSuggestion.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class UserSuggestion implements SearchSuggestion, Comparable<UserSuggestion> {
    public static final UserSuggestion$Companion Companion = new UserSuggestion$Companion(null);
    private final SearchSuggestion$Category category;
    private final int discriminator;
    private final GuildMember guildMember;
    private final String nickname;
    private final UserSuggestion$TargetType targetType;
    private final User user;
    private final long userId;
    private final String userName;
    private final String usernameWithDiscriminator;

    public UserSuggestion(User user, UserSuggestion$TargetType userSuggestion$TargetType, GuildMember guildMember) {
        SearchSuggestion$Category searchSuggestion$Category;
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(userSuggestion$TargetType, "targetType");
        this.user = user;
        this.targetType = userSuggestion$TargetType;
        this.guildMember = guildMember;
        String username = user.getUsername();
        this.userName = username;
        int discriminator = user.getDiscriminator();
        this.discriminator = discriminator;
        this.userId = user.getId();
        this.nickname = guildMember != null ? guildMember.getNick() : null;
        int iOrdinal = userSuggestion$TargetType.ordinal();
        if (iOrdinal == 0) {
            searchSuggestion$Category = SearchSuggestion$Category.FROM_USER;
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            searchSuggestion$Category = SearchSuggestion$Category.MENTIONS_USER;
        }
        this.category = searchSuggestion$Category;
        this.usernameWithDiscriminator = UserSuggestion$Companion.access$getUsernameWithDiscriminator(Companion, username, discriminator);
    }

    public static /* synthetic */ UserSuggestion copy$default(UserSuggestion userSuggestion, User user, UserSuggestion$TargetType userSuggestion$TargetType, GuildMember guildMember, int i, Object obj) {
        if ((i & 1) != 0) {
            user = userSuggestion.user;
        }
        if ((i & 2) != 0) {
            userSuggestion$TargetType = userSuggestion.targetType;
        }
        if ((i & 4) != 0) {
            guildMember = userSuggestion.guildMember;
        }
        return userSuggestion.copy(user, userSuggestion$TargetType, guildMember);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UserSuggestion userSuggestion) {
        return compareTo2(userSuggestion);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final UserSuggestion$TargetType getTargetType() {
        return this.targetType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final UserSuggestion copy(User user, UserSuggestion$TargetType targetType, GuildMember guildMember) {
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(targetType, "targetType");
        return new UserSuggestion(user, targetType, guildMember);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserSuggestion)) {
            return false;
        }
        UserSuggestion userSuggestion = (UserSuggestion) other;
        return m.areEqual(this.user, userSuggestion.user) && m.areEqual(this.targetType, userSuggestion.targetType) && m.areEqual(this.guildMember, userSuggestion.guildMember);
    }

    @Override // com.discord.utilities.search.suggestion.entries.SearchSuggestion
    public SearchSuggestion$Category getCategory() {
        return this.category;
    }

    public final int getDiscriminator() {
        return this.discriminator;
    }

    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final UserSuggestion$TargetType getTargetType() {
        return this.targetType;
    }

    public final User getUser() {
        return this.user;
    }

    public final long getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getUsernameWithDiscriminator() {
        return this.usernameWithDiscriminator;
    }

    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        UserSuggestion$TargetType userSuggestion$TargetType = this.targetType;
        int iHashCode2 = (iHashCode + (userSuggestion$TargetType != null ? userSuggestion$TargetType.hashCode() : 0)) * 31;
        GuildMember guildMember = this.guildMember;
        return iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("UserSuggestion(user=");
        sbU.append(this.user);
        sbU.append(", targetType=");
        sbU.append(this.targetType);
        sbU.append(", guildMember=");
        sbU.append(this.guildMember);
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(UserSuggestion other) {
        m.checkNotNullParameter(other, "other");
        String str = this.nickname;
        if (str == null) {
            str = this.usernameWithDiscriminator;
        }
        String str2 = other.nickname;
        if (str2 == null) {
            str2 = other.usernameWithDiscriminator;
        }
        int iCompareTo = str.compareTo(str2);
        return iCompareTo != 0 ? iCompareTo : this.usernameWithDiscriminator.compareTo(other.usernameWithDiscriminator);
    }
}
