package com.discord.utilities.user;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import androidx.annotation.ColorInt;
import b.d.b.a.outline;
import com.adjust.sdk.Constants;
import com.discord.api.premium.PremiumTier;
import com.discord.api.presence.ClientStatus;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.presence.Presence;
import com.discord.models.user.CoreUser;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.nullserializable.NullSerializable;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.premium.PremiumUtils3;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.g0.Charsets2;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: UserUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserUtils {
    public static final long CLYDE_BOT_USER_ID = -1;
    private static final int GUILD_VERIFICATION_ACCOUNT_AGE_THRESHOLD = 300000;
    private static final int NEW_USER_THRESHOLD = 604800000;
    public static final long SYSTEM_USER_ID = 643945264868098049L;
    public static final UserUtils INSTANCE = new UserUtils();
    private static final User EMPTY_USER = new CoreUser(0, "Empty User", null, null, false, false, 1, PremiumTier.PREMIUM_GUILD_SUBSCRIPTION_ONLY, 0, 0, null, null, 3900, null);

    private UserUtils() {
    }

    public static /* synthetic */ long getAgeMs$default(UserUtils userUtils, User user, Clock clock, int i, Object obj) {
        if ((i & 1) != 0) {
            clock = ClockFactory.get();
        }
        return userUtils.getAgeMs(user, clock);
    }

    public static /* synthetic */ CharSequence getUserNameWithDiscriminator$default(UserUtils userUtils, User user, Integer num, Float f, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            f = null;
        }
        return userUtils.getUserNameWithDiscriminator(user, num, f);
    }

    private final boolean hasFlag(int flags, int targetFlag) {
        return (flags & targetFlag) == targetFlag;
    }

    private final boolean hasFlag(User user, int i) {
        return hasFlag(user.getPublicFlags() | user.getFlags(), i);
    }

    public static /* synthetic */ boolean isAccountOldEnough$default(UserUtils userUtils, User user, Clock clock, int i, Object obj) {
        if ((i & 1) != 0) {
            clock = ClockFactory.get();
        }
        return userUtils.isAccountOldEnough(user, clock);
    }

    public static /* synthetic */ boolean isNewUser$default(UserUtils userUtils, User user, Clock clock, int i, Object obj) {
        if ((i & 1) != 0) {
            clock = ClockFactory.get();
        }
        return userUtils.isNewUser(user, clock);
    }

    public static /* synthetic */ boolean since$default(UserUtils userUtils, User user, Clock clock, UtcDateTime utcDateTime, int i, Object obj) {
        if ((i & 1) != 0) {
            clock = ClockFactory.get();
        }
        return userUtils.since(user, clock, utcDateTime);
    }

    public final int compareUserNames(User user1, User user2) {
        return compareUserNames(user1, user2, null, null);
    }

    public final long getAgeMs(User user, Clock clock) {
        Intrinsics3.checkNotNullParameter(user, "$this$getAgeMs");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        return clock.currentTimeMillis() - ((user.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH);
    }

    public final boolean getCanUsePremiumStickers(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$canUsePremiumStickers");
        return PremiumUtils3.grantsAccessToPremiumStickers(user.getPremiumTier());
    }

    public final String getDiscriminatorWithPadding(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$discriminatorWithPadding");
        return padDiscriminator(user.getDiscriminator());
    }

    public final User getEMPTY_USER() {
        return EMPTY_USER;
    }

    public final boolean getHasPhone(MeUser meUser) {
        Intrinsics3.checkNotNullParameter(meUser, "$this$hasPhone");
        return meUser.getPhoneNumber() != null;
    }

    public final boolean getHasSubscription(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$hasSubscription");
        return user.getPremiumTier() != PremiumTier.NONE;
    }

    public final boolean getHasUnreadUrgentMessages(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$hasUnreadUrgentMessages");
        return hasFlag(user, 8192);
    }

    public final String getObfuscatedUserId(Long id2) throws NoSuchAlgorithmException {
        if (id2 == null) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA256);
        String strValueOf = String.valueOf(id2.longValue());
        Charset charset = Charsets2.a;
        Objects.requireNonNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = strValueOf.getBytes(charset);
        Intrinsics3.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] bArrDigest = messageDigest.digest(bytes);
        Intrinsics3.checkNotNullExpressionValue(bArrDigest, "MessageDigest\n        .g…toString().toByteArray())");
        String string = "";
        for (byte b2 : bArrDigest) {
            StringBuilder sbU = outline.U(string);
            String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b2)}, 1));
            Intrinsics3.checkNotNullExpressionValue(str, "java.lang.String.format(this, *args)");
            sbU.append(str);
            string = sbU.toString();
        }
        return string;
    }

    public final CharSequence getUserNameWithDiscriminator(User user, @ColorInt Integer num, Float f) {
        Intrinsics3.checkNotNullParameter(user, "$this$getUserNameWithDiscriminator");
        String str = user.getUsername() + getDiscriminatorWithPadding(user);
        if (num == null && f == null) {
            return str;
        }
        SpannableString spannableString = new SpannableString(str);
        if (num != null) {
            spannableString.setSpan(new ForegroundColorSpan(num.intValue()), user.getUsername().length(), spannableString.length(), 17);
        }
        if (f != null) {
            spannableString.setSpan(new RelativeSizeSpan(f.floatValue()), user.getUsername().length(), spannableString.length(), 17);
        }
        return spannableString;
    }

    public final boolean isAccountOldEnough(User user, Clock clock) {
        Intrinsics3.checkNotNullParameter(user, "$this$isAccountOldEnough");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        return getAgeMs(user, clock) > ((long) GUILD_VERIFICATION_ACCOUNT_AGE_THRESHOLD);
    }

    public final boolean isBugHunterLevel1(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isBugHunterLevel1");
        return hasFlag(user, 8);
    }

    public final boolean isBugHunterLevel2(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isBugHunterLevel2");
        return hasFlag(user, 16384);
    }

    public final boolean isCertifiedModerator(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isCertifiedModerator");
        return hasFlag(user, 262144);
    }

    public final boolean isHttpInteractionsBot(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isHttpInteractionsBot");
        return hasFlag(user, 524288);
    }

    public final boolean isHypeSquad(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isHypeSquad");
        return hasFlag(user, 4);
    }

    public final boolean isHypesquadHouse1(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isHypesquadHouse1");
        return hasFlag(user, 64);
    }

    public final boolean isHypesquadHouse2(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isHypesquadHouse2");
        return hasFlag(user, 128);
    }

    public final boolean isHypesquadHouse3(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isHypesquadHouse3");
        return hasFlag(user, 256);
    }

    public final boolean isInHypesquadHouse(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isInHypesquadHouse");
        return isHypesquadHouse1(user) || isHypesquadHouse2(user) || isHypesquadHouse3(user);
    }

    public final boolean isMfaSMSEnabled(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isMfaSMSEnabled");
        return hasFlag(user, 16);
    }

    public final boolean isNewUser(User user, Clock clock) {
        Intrinsics3.checkNotNullParameter(user, "$this$isNewUser");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        return (user.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH >= clock.currentTimeMillis() - ((long) NEW_USER_THRESHOLD);
    }

    public final boolean isPartner(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isPartner");
        return hasFlag(user, 2);
    }

    public final boolean isPremium(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isPremium");
        return (user.getPremiumTier() == PremiumTier.PREMIUM_GUILD_SUBSCRIPTION_ONLY || user.getPremiumTier() == PremiumTier.NONE) ? false : true;
    }

    public final boolean isPremiumEarlySupporter(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isPremiumEarlySupporter");
        return hasFlag(user, 512);
    }

    public final boolean isPremiumTier2(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isPremiumTier2");
        return user.getPremiumTier() == PremiumTier.TIER_2;
    }

    public final boolean isStaff(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isStaff");
        return hasFlag(user, 1);
    }

    public final boolean isStatusVisible(int flags, Presence presence, boolean isMissingPresenceVisible) {
        if (hasFlag(flags, 524288)) {
            return (presence == null || presence.getStatus() == ClientStatus.OFFLINE) ? false : true;
        }
        return presence != null || isMissingPresenceVisible;
    }

    public final boolean isVerifiedBot(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isVerifiedBot");
        return hasFlag(user, 65536) || user.getIsSystemUser() || user.getId() == -1;
    }

    public final boolean isVerifiedDeveloper(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$isVerifiedDeveloper");
        return hasFlag(user, 131072);
    }

    public final String padDiscriminator(int discriminator) {
        return outline.P(new Object[]{Integer.valueOf(discriminator)}, 1, "#%04d", "java.lang.String.format(format, *args)");
    }

    public final boolean since(User user, Clock clock, UtcDateTime utcDateTime) {
        Intrinsics3.checkNotNullParameter(user, "$this$since");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(utcDateTime, "date");
        return new UtcDateTime((user.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH).compareTo(utcDateTime) <= 0;
    }

    public final com.discord.api.user.User synthesizeApiUser(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$synthesizeApiUser");
        long id2 = user.getId();
        String username = user.getUsername();
        String avatar = user.getAvatar();
        return new com.discord.api.user.User(id2, username, avatar != null ? new NullSerializable.b(avatar) : new NullSerializable.a(null, 1), null, String.valueOf(user.getDiscriminator()), Integer.valueOf(user.getPublicFlags()), Integer.valueOf(user.getFlags()), Boolean.valueOf(user.getIsBot()), Boolean.valueOf(user.getIsSystemUser()), null, null, null, null, null, null, null, null, null, null, null, null, null, 3145736);
    }

    public final int compareUserNames(User user1, User user2, String user1Nickname, String user2Nickname) {
        return compareUserNames(user1 != null ? user1.getUsername() : null, user2 != null ? user2.getUsername() : null, user1Nickname, user2Nickname, user1 != null ? user1.getId() : 0L, user2 != null ? user2.getId() : 0L);
    }

    public final boolean isStatusVisible(User user, Presence presence, boolean z2) {
        Intrinsics3.checkNotNullParameter(user, "$this$isStatusVisible");
        return isStatusVisible(user.getPublicFlags() | user.getFlags(), presence, z2);
    }

    public final int compareUserNames(String user1Username, String user2Username, String user1Nickname, String user2Nickname, long user1Id, long user2Id) {
        if (user1Username == null) {
            return user2Username == null ? 0 : -1;
        }
        if (user2Username == null) {
            return 1;
        }
        if (!(user1Nickname == null || StringsJVM.isBlank(user1Nickname))) {
            user1Username = user1Nickname;
        }
        if (!(user2Nickname == null || StringsJVM.isBlank(user2Nickname))) {
            user2Username = user2Nickname;
        }
        int iCompareTo = StringsJVM.compareTo(user1Username, user2Username, true);
        return iCompareTo != 0 ? iCompareTo : (user1Id > user2Id ? 1 : (user1Id == user2Id ? 0 : -1));
    }
}
