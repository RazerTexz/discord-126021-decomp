package com.discord.widgets.user;

import android.content.Context;
import androidx.annotation.DrawableRes;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.user.UserProfile;
import com.discord.models.user.User;
import com.discord.utilities.user.UserProfileUtils;
import com.discord.utilities.user.UserUtils;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Badge.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Badge {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int GUILD_BOOST_LEVEL_1_MONTHS = 1;
    private static final int GUILD_BOOST_LEVEL_2_MONTHS = 2;
    private static final int GUILD_BOOST_LEVEL_3_MONTHS = 3;
    private static final int GUILD_BOOST_LEVEL_4_MONTHS = 6;
    private static final int GUILD_BOOST_LEVEL_5_MONTHS = 9;
    private static final int GUILD_BOOST_LEVEL_6_MONTHS = 12;
    private static final int GUILD_BOOST_LEVEL_7_MONTHS = 15;
    private static final int GUILD_BOOST_LEVEL_8_MONTHS = 18;
    private static final int GUILD_BOOST_LEVEL_9_MONTHS = 24;
    private final int icon;
    private final String objectType;
    private final boolean showPremiumUpSell;
    private final CharSequence text;
    private final CharSequence tooltip;

    /* JADX INFO: compiled from: Badge.kt */
    public static final class Companion {
        private Companion() {
        }

        public final List<Badge> getBadgesForUser(User user, UserProfile profile, boolean isMeUserPremium, boolean isMeUserVerified, Context context) {
            int i;
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(profile, "profile");
            Intrinsics3.checkNotNullParameter(context, "context");
            ArrayList arrayList = new ArrayList(8);
            UserUtils userUtils = UserUtils.INSTANCE;
            if (userUtils.isStaff(user)) {
                arrayList.add(new Badge(R.drawable.ic_profile_badge_staff_32dp, context.getString(R.string.staff_badge_tooltip), null, false, null, 28, null));
            }
            if (userUtils.isPartner(user)) {
                arrayList.add(new Badge(R.drawable.ic_profile_badge_partner_32dp, context.getString(R.string.partner_badge_tooltip), null, false, null, 28, null));
            }
            if (userUtils.isCertifiedModerator(user)) {
                arrayList.add(new Badge(R.drawable.ic_profile_badge_certified_moderator_32dp, context.getString(R.string.certified_moderator_badge_tooltip), null, false, null, 28, null));
            }
            if (userUtils.isHypeSquad(user)) {
                arrayList.add(new Badge(R.drawable.ic_profile_badge_hypesquad_32dp, context.getString(R.string.hypesquad_badge_tooltip), null, false, null, 28, null));
            }
            if (userUtils.isHypesquadHouse1(user)) {
                arrayList.add(new Badge(R.drawable.ic_hypesquad_house1_32dp, context.getString(R.string.hypesquad_house_1), FormatUtils.b(context, R.string.hypesquad_online_badge_tooltip, new Object[]{FormatUtils.b(context, R.string.hypesquad_house_1, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null)}, (4 & 4) != 0 ? FormatUtils.b.j : null), false, null, 24, null));
            }
            if (userUtils.isHypesquadHouse2(user)) {
                arrayList.add(new Badge(R.drawable.ic_hypesquad_house2_32dp, FormatUtils.b(context, R.string.hypesquad_house_2, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null), FormatUtils.b(context, R.string.hypesquad_online_badge_tooltip, new Object[]{context.getString(R.string.hypesquad_house_2)}, (4 & 4) != 0 ? FormatUtils.b.j : null), false, null, 24, null));
            }
            if (userUtils.isHypesquadHouse3(user)) {
                arrayList.add(new Badge(R.drawable.ic_hypesquad_house3_32dp, context.getString(R.string.hypesquad_house_3), FormatUtils.b(context, R.string.hypesquad_online_badge_tooltip, new Object[]{FormatUtils.b(context, R.string.hypesquad_house_3, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null)}, (4 & 4) != 0 ? FormatUtils.b.j : null), false, null, 24, null));
            }
            if (userUtils.isBugHunterLevel1(user)) {
                arrayList.add(new Badge(R.drawable.ic_profile_badge_bughunter_level_1_32dp, context.getString(R.string.bug_hunter_badge_tooltip), null, false, null, 28, null));
            }
            if (userUtils.isBugHunterLevel2(user)) {
                arrayList.add(new Badge(R.drawable.ic_profile_badge_bughunter_level_2_32dp, context.getString(R.string.bug_hunter_badge_tooltip), null, false, null, 28, null));
            }
            if (userUtils.isVerifiedDeveloper(user)) {
                arrayList.add(new Badge(R.drawable.ic_profile_badge_verified_developer_32dp, context.getString(R.string.verified_developer_badge_tooltip), null, false, null, 28, null));
            }
            if (userUtils.isPremiumEarlySupporter(user)) {
                arrayList.add(new Badge(R.drawable.ic_profile_badge_premium_early_supporter_32dp, context.getString(R.string.early_supporter_tooltip), null, !isMeUserPremium && isMeUserVerified, "PREMIUM_EARLY_SUPPORTER", 4, null));
            }
            if (UserProfileUtils.isPremium(profile)) {
                arrayList.add(new Badge(R.drawable.ic_profile_badge_nitro_32dp, context.getString(R.string.premium_title), FormatUtils.b(context, R.string.premium_badge_tooltip, new Object[]{UserProfileUtils.getPremiumSince(profile, context)}, (4 & 4) != 0 ? FormatUtils.b.j : null), !isMeUserPremium && isMeUserVerified, "PREMIUM"));
            }
            if (UserProfileUtils.isGuildBooster(profile)) {
                Integer guildBoostMonthsSubscribed = UserProfileUtils.getGuildBoostMonthsSubscribed(profile);
                int iIntValue = guildBoostMonthsSubscribed != null ? guildBoostMonthsSubscribed.intValue() : 0;
                if (iIntValue >= 24) {
                    i = R.drawable.ic_profile_badge_premium_guild_subscription_lvl9_32dp;
                } else if (iIntValue >= 18) {
                    i = R.drawable.ic_profile_badge_premium_guild_subscription_lvl8_32dp;
                } else if (iIntValue >= 15) {
                    i = R.drawable.ic_profile_badge_premium_guild_subscription_lvl7_32dp;
                } else if (iIntValue >= 12) {
                    i = R.drawable.ic_profile_badge_premium_guild_subscription_lvl6_32dp;
                } else if (iIntValue >= 9) {
                    i = R.drawable.ic_profile_badge_premium_guild_subscription_lvl5_32dp;
                } else if (iIntValue >= 6) {
                    i = R.drawable.ic_profile_badge_premium_guild_subscription_lvl4_32dp;
                } else if (iIntValue >= 3) {
                    i = R.drawable.ic_profile_badge_premium_guild_subscription_lvl3_32dp;
                } else {
                    i = iIntValue >= 2 ? R.drawable.ic_profile_badge_premium_guild_subscription_lvl2_32dp : R.drawable.ic_profile_badge_premium_guild_subscription_lvl1_32dp;
                }
                arrayList.add(new Badge(i, context.getString(R.string.premium_title), FormatUtils.b(context, R.string.premium_guild_subscription_tooltip, new Object[]{UserProfileUtils.getBoostingSince(profile, context)}, (4 & 4) != 0 ? FormatUtils.b.j : null), !isMeUserPremium && isMeUserVerified, "PREMIUM_GUILD"));
            }
            return arrayList;
        }

        public final Function1<Badge, Unit> onBadgeClick(FragmentManager fragmentManager, Context context) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(context, "context");
            return new Badge2(fragmentManager, context);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Badge() {
        this(0, null, null, false, null, 31, null);
    }

    public Badge(@DrawableRes int i, CharSequence charSequence, CharSequence charSequence2, boolean z2, String str) {
        this.icon = i;
        this.text = charSequence;
        this.tooltip = charSequence2;
        this.showPremiumUpSell = z2;
        this.objectType = str;
    }

    public static /* synthetic */ Badge copy$default(Badge badge, int i, CharSequence charSequence, CharSequence charSequence2, boolean z2, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = badge.icon;
        }
        if ((i2 & 2) != 0) {
            charSequence = badge.text;
        }
        CharSequence charSequence3 = charSequence;
        if ((i2 & 4) != 0) {
            charSequence2 = badge.tooltip;
        }
        CharSequence charSequence4 = charSequence2;
        if ((i2 & 8) != 0) {
            z2 = badge.showPremiumUpSell;
        }
        boolean z3 = z2;
        if ((i2 & 16) != 0) {
            str = badge.objectType;
        }
        return badge.copy(i, charSequence3, charSequence4, z3, str);
    }

    public static final Function1<Badge, Unit> onBadgeClick(FragmentManager fragmentManager, Context context) {
        return INSTANCE.onBadgeClick(fragmentManager, context);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CharSequence getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final CharSequence getTooltip() {
        return this.tooltip;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getShowPremiumUpSell() {
        return this.showPremiumUpSell;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getObjectType() {
        return this.objectType;
    }

    public final Badge copy(@DrawableRes int icon, CharSequence text, CharSequence tooltip, boolean showPremiumUpSell, String objectType) {
        return new Badge(icon, text, tooltip, showPremiumUpSell, objectType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Badge)) {
            return false;
        }
        Badge badge = (Badge) other;
        return this.icon == badge.icon && Intrinsics3.areEqual(this.text, badge.text) && Intrinsics3.areEqual(this.tooltip, badge.tooltip) && this.showPremiumUpSell == badge.showPremiumUpSell && Intrinsics3.areEqual(this.objectType, badge.objectType);
    }

    public final int getIcon() {
        return this.icon;
    }

    public final String getObjectType() {
        return this.objectType;
    }

    public final boolean getShowPremiumUpSell() {
        return this.showPremiumUpSell;
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final CharSequence getTooltip() {
        return this.tooltip;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        int i = this.icon * 31;
        CharSequence charSequence = this.text;
        int iHashCode = (i + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.tooltip;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        boolean z2 = this.showPremiumUpSell;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i2 = (iHashCode2 + r1) * 31;
        String str = this.objectType;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Badge(icon=");
        sbU.append(this.icon);
        sbU.append(", text=");
        sbU.append(this.text);
        sbU.append(", tooltip=");
        sbU.append(this.tooltip);
        sbU.append(", showPremiumUpSell=");
        sbU.append(this.showPremiumUpSell);
        sbU.append(", objectType=");
        return outline.J(sbU, this.objectType, ")");
    }

    public /* synthetic */ Badge(int i, CharSequence charSequence, CharSequence charSequence2, boolean z2, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : charSequence, (i2 & 4) != 0 ? null : charSequence2, (i2 & 8) == 0 ? z2 : false, (i2 & 16) != 0 ? null : str);
    }
}
