package com.discord.utilities.user;

import android.content.Context;
import com.discord.api.user.UserProfile;
import com.discord.utilities.time.TimeUtils;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import p507d0.p592z.p594d.C12238m;
import p600f0.p601e0.C12272c;

/* JADX INFO: compiled from: UserProfileUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserProfileUtilsKt {
    public static final String getBoostingSince(UserProfile userProfile, Context context) {
        C12238m.checkNotNullParameter(userProfile, "$this$getBoostingSince");
        C12238m.checkNotNullParameter(context, "context");
        String premiumGuildSince = userProfile.getPremiumGuildSince();
        if (premiumGuildSince != null) {
            return TimeUtils.getReadableTimeString(context, premiumGuildSince);
        }
        return null;
    }

    public static final Integer getGuildBoostMonthsSubscribed(UserProfile userProfile) {
        C12238m.checkNotNullParameter(userProfile, "$this$guildBoostMonthsSubscribed");
        String premiumGuildSince = userProfile.getPremiumGuildSince();
        if (premiumGuildSince != null) {
            return Integer.valueOf(TimeUtils.getMonthsBetweenDates(new Date(TimeUtils.parseUTCDate(premiumGuildSince)), new Date()));
        }
        return null;
    }

    public static final Map<Long, UserProfile.GuildReference> getMutualGuildsById(UserProfile userProfile) {
        C12238m.checkNotNullParameter(userProfile, "$this$mutualGuildsById");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : userProfile.m8308d()) {
            linkedHashMap.put(Long.valueOf(((UserProfile.GuildReference) obj).getId()), obj);
        }
        return C12272c.m10116A(linkedHashMap);
    }

    public static final String getPremiumSince(UserProfile userProfile, Context context) {
        C12238m.checkNotNullParameter(userProfile, "$this$getPremiumSince");
        C12238m.checkNotNullParameter(context, "context");
        String premiumSince = userProfile.getPremiumSince();
        if (premiumSince != null) {
            return TimeUtils.getReadableTimeString(context, premiumSince);
        }
        return null;
    }

    public static final boolean isGuildBooster(UserProfile userProfile) {
        C12238m.checkNotNullParameter(userProfile, "$this$isGuildBooster");
        String premiumGuildSince = userProfile.getPremiumGuildSince();
        return !(premiumGuildSince == null || premiumGuildSince.length() == 0);
    }

    public static final boolean isPremium(UserProfile userProfile) {
        C12238m.checkNotNullParameter(userProfile, "$this$isPremium");
        String premiumSince = userProfile.getPremiumSince();
        return !(premiumSince == null || premiumSince.length() == 0);
    }
}
