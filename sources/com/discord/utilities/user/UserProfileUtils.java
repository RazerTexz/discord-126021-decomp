package com.discord.utilities.user;

import android.content.Context;
import com.discord.api.user.UserProfile;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.Intrinsics3;
import f0.e0.Util7;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.discord.utilities.user.UserProfileUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: UserProfileUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserProfileUtils {
    public static final String getBoostingSince(UserProfile userProfile, Context context) {
        Intrinsics3.checkNotNullParameter(userProfile, "$this$getBoostingSince");
        Intrinsics3.checkNotNullParameter(context, "context");
        String premiumGuildSince = userProfile.getPremiumGuildSince();
        if (premiumGuildSince != null) {
            return TimeUtils.getReadableTimeString(context, premiumGuildSince);
        }
        return null;
    }

    public static final Integer getGuildBoostMonthsSubscribed(UserProfile userProfile) {
        Intrinsics3.checkNotNullParameter(userProfile, "$this$guildBoostMonthsSubscribed");
        String premiumGuildSince = userProfile.getPremiumGuildSince();
        if (premiumGuildSince != null) {
            return Integer.valueOf(TimeUtils.getMonthsBetweenDates(new Date(TimeUtils.parseUTCDate(premiumGuildSince)), new Date()));
        }
        return null;
    }

    public static final Map<Long, UserProfile.GuildReference> getMutualGuildsById(UserProfile userProfile) {
        Intrinsics3.checkNotNullParameter(userProfile, "$this$mutualGuildsById");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : userProfile.d()) {
            linkedHashMap.put(Long.valueOf(((UserProfile.GuildReference) obj).getId()), obj);
        }
        return Util7.A(linkedHashMap);
    }

    public static final String getPremiumSince(UserProfile userProfile, Context context) {
        Intrinsics3.checkNotNullParameter(userProfile, "$this$getPremiumSince");
        Intrinsics3.checkNotNullParameter(context, "context");
        String premiumSince = userProfile.getPremiumSince();
        if (premiumSince != null) {
            return TimeUtils.getReadableTimeString(context, premiumSince);
        }
        return null;
    }

    public static final boolean isGuildBooster(UserProfile userProfile) {
        Intrinsics3.checkNotNullParameter(userProfile, "$this$isGuildBooster");
        String premiumGuildSince = userProfile.getPremiumGuildSince();
        return !(premiumGuildSince == null || premiumGuildSince.length() == 0);
    }

    public static final boolean isPremium(UserProfile userProfile) {
        Intrinsics3.checkNotNullParameter(userProfile, "$this$isPremium");
        String premiumSince = userProfile.getPremiumSince();
        return !(premiumSince == null || premiumSince.length() == 0);
    }
}
