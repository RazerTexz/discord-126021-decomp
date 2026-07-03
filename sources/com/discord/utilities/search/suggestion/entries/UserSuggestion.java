package com.discord.utilities.search.suggestion.entries;

import android.annotation.SuppressLint;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.search.suggestion.entries.SearchSuggestion;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.chat.AutocompleteTypes;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: UserSuggestion.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class UserSuggestion implements SearchSuggestion, Comparable<UserSuggestion> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final SearchSuggestion.Category category;
    private final int discriminator;
    private final GuildMember guildMember;
    private final String nickname;
    private final TargetType targetType;
    private final User user;
    private final long userId;
    private final String userName;
    private final String usernameWithDiscriminator;

    /* JADX INFO: compiled from: UserSuggestion.kt */
    public static final class Companion {
        private Companion() {
        }

        private final String getUsernameWithDiscriminator(String userName, int discriminator) {
            StringBuilder sbM833U = C1643a.m833U(userName);
            sbM833U.append(UserUtils.INSTANCE.padDiscriminator(discriminator));
            return sbM833U.toString();
        }

        @SuppressLint({"DefaultLocale"})
        public final boolean canComplete(String username, int discriminator, String nickname, CharSequence currentInput) {
            C12238m.checkNotNullParameter(username, "username");
            C12238m.checkNotNullParameter(currentInput, "currentInput");
            String usernameWithDiscriminator = getUsernameWithDiscriminator(username, discriminator);
            String string = currentInput.toString();
            Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = string.toLowerCase();
            C12238m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (C12106w.contains((CharSequence) usernameWithDiscriminator, (CharSequence) lowerCase, true)) {
                return true;
            }
            return nickname != null ? C12106w.contains((CharSequence) nickname, (CharSequence) lowerCase, true) : false;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: UserSuggestion.kt */
    public enum TargetType {
        FROM,
        MENTIONS
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            TargetType.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[TargetType.FROM.ordinal()] = 1;
            iArr[TargetType.MENTIONS.ordinal()] = 2;
        }
    }

    public UserSuggestion(User user, TargetType targetType, GuildMember guildMember) {
        SearchSuggestion.Category category;
        C12238m.checkNotNullParameter(user, "user");
        C12238m.checkNotNullParameter(targetType, "targetType");
        this.user = user;
        this.targetType = targetType;
        this.guildMember = guildMember;
        String username = user.getUsername();
        this.userName = username;
        int discriminator = user.getDiscriminator();
        this.discriminator = discriminator;
        this.userId = user.getId();
        this.nickname = guildMember != null ? guildMember.getNick() : null;
        int iOrdinal = targetType.ordinal();
        if (iOrdinal == 0) {
            category = SearchSuggestion.Category.FROM_USER;
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            category = SearchSuggestion.Category.MENTIONS_USER;
        }
        this.category = category;
        this.usernameWithDiscriminator = INSTANCE.getUsernameWithDiscriminator(username, discriminator);
    }

    public static /* synthetic */ UserSuggestion copy$default(UserSuggestion userSuggestion, User user, TargetType targetType, GuildMember guildMember, int i, Object obj) {
        if ((i & 1) != 0) {
            user = userSuggestion.user;
        }
        if ((i & 2) != 0) {
            targetType = userSuggestion.targetType;
        }
        if ((i & 4) != 0) {
            guildMember = userSuggestion.guildMember;
        }
        return userSuggestion.copy(user, targetType, guildMember);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final TargetType getTargetType() {
        return this.targetType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final UserSuggestion copy(User user, TargetType targetType, GuildMember guildMember) {
        C12238m.checkNotNullParameter(user, "user");
        C12238m.checkNotNullParameter(targetType, "targetType");
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
        return C12238m.areEqual(this.user, userSuggestion.user) && C12238m.areEqual(this.targetType, userSuggestion.targetType) && C12238m.areEqual(this.guildMember, userSuggestion.guildMember);
    }

    @Override // com.discord.utilities.search.suggestion.entries.SearchSuggestion
    public SearchSuggestion.Category getCategory() {
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

    public final TargetType getTargetType() {
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
        TargetType targetType = this.targetType;
        int iHashCode2 = (iHashCode + (targetType != null ? targetType.hashCode() : 0)) * 31;
        GuildMember guildMember = this.guildMember;
        return iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("UserSuggestion(user=");
        sbM833U.append(this.user);
        sbM833U.append(", targetType=");
        sbM833U.append(this.targetType);
        sbM833U.append(", guildMember=");
        sbM833U.append(this.guildMember);
        sbM833U.append(")");
        return sbM833U.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(UserSuggestion other) {
        C12238m.checkNotNullParameter(other, "other");
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
