package com.discord.widgets.user;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import b.a.k.b;
import com.discord.api.user.UserProfile;
import com.discord.models.user.User;
import com.discord.utilities.user.UserProfileUtilsKt;
import com.discord.utilities.user.UserUtils;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Badge.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Badge$Companion {
    private Badge$Companion() {
    }

    public final List<Badge> getBadgesForUser(User user, UserProfile profile, boolean isMeUserPremium, boolean isMeUserVerified, Context context) {
        int i;
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(profile, "profile");
        m.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList(8);
        UserUtils userUtils = UserUtils.INSTANCE;
        if (userUtils.isStaff(user)) {
            arrayList.add(new Badge(2131232069, context.getString(2131895762), null, false, null, 28, null));
        }
        if (userUtils.isPartner(user)) {
            arrayList.add(new Badge(2131232058, context.getString(2131893618), null, false, null, 28, null));
        }
        if (userUtils.isCertifiedModerator(user)) {
            arrayList.add(new Badge(2131232055, context.getString(2131887479), null, false, null, 28, null));
        }
        if (userUtils.isHypeSquad(user)) {
            arrayList.add(new Badge(2131232056, context.getString(2131891877), null, false, null, 28, null));
        }
        if (userUtils.isHypesquadHouse1(user)) {
            arrayList.add(new Badge(2131231875, context.getString(2131891885), b.h(context, 2131891894, new Object[]{b.h(context, 2131891885, new Object[0], null, 4)}, null, 4), false, null, 24, null));
        }
        if (userUtils.isHypesquadHouse2(user)) {
            arrayList.add(new Badge(2131231877, b.h(context, 2131891886, new Object[0], null, 4), b.h(context, 2131891894, new Object[]{context.getString(2131891886)}, null, 4), false, null, 24, null));
        }
        if (userUtils.isHypesquadHouse3(user)) {
            arrayList.add(new Badge(2131231879, context.getString(2131891887), b.h(context, 2131891894, new Object[]{b.h(context, 2131891887, new Object[0], null, 4)}, null, 4), false, null, 24, null));
        }
        if (userUtils.isBugHunterLevel1(user)) {
            arrayList.add(new Badge(2131232053, context.getString(2131887306), null, false, null, 28, null));
        }
        if (userUtils.isBugHunterLevel2(user)) {
            arrayList.add(new Badge(2131232054, context.getString(2131887306), null, false, null, 28, null));
        }
        if (userUtils.isVerifiedDeveloper(user)) {
            arrayList.add(new Badge(2131232070, context.getString(2131897058), null, false, null, 28, null));
        }
        if (userUtils.isPremiumEarlySupporter(user)) {
            arrayList.add(new Badge(2131232059, context.getString(2131888624), null, !isMeUserPremium && isMeUserVerified, "PREMIUM_EARLY_SUPPORTER", 4, null));
        }
        if (UserProfileUtilsKt.isPremium(profile)) {
            arrayList.add(new Badge(2131232057, context.getString(2131894450), b.h(context, 2131893945, new Object[]{UserProfileUtilsKt.getPremiumSince(profile, context)}, null, 4), !isMeUserPremium && isMeUserVerified, "PREMIUM"));
        }
        if (UserProfileUtilsKt.isGuildBooster(profile)) {
            Integer guildBoostMonthsSubscribed = UserProfileUtilsKt.getGuildBoostMonthsSubscribed(profile);
            int iIntValue = guildBoostMonthsSubscribed != null ? guildBoostMonthsSubscribed.intValue() : 0;
            if (iIntValue >= 24) {
                i = 2131232068;
            } else if (iIntValue >= 18) {
                i = 2131232067;
            } else if (iIntValue >= 15) {
                i = 2131232066;
            } else if (iIntValue >= 12) {
                i = 2131232065;
            } else if (iIntValue >= 9) {
                i = 2131232064;
            } else if (iIntValue >= 6) {
                i = 2131232063;
            } else if (iIntValue >= 3) {
                i = 2131232062;
            } else {
                i = iIntValue >= 2 ? 2131232061 : 2131232060;
            }
            arrayList.add(new Badge(i, context.getString(2131894450), b.h(context, 2131894155, new Object[]{UserProfileUtilsKt.getBoostingSince(profile, context)}, null, 4), !isMeUserPremium && isMeUserVerified, "PREMIUM_GUILD"));
        }
        return arrayList;
    }

    public final Function1<Badge, Unit> onBadgeClick(FragmentManager fragmentManager, Context context) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(context, "context");
        return new Badge$Companion$onBadgeClick$1(fragmentManager, context);
    }

    public /* synthetic */ Badge$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
