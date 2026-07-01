package com.discord.utilities.guilds;

import android.content.Context;
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.api.role.GuildRoleTags;
import com.discord.models.member.GuildMember;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.time.TimeUtils;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: RoleUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RoleUtils {
    public static final RoleUtils INSTANCE = new RoleUtils();
    private static final Pattern ROLE_MENTION_RE = Pattern.compile("<@&(\\d+)>");
    private static final Comparator<GuildRole> ROLE_COMPARATOR = new Comparator<GuildRole>() { // from class: com.discord.utilities.guilds.RoleUtils$ROLE_COMPARATOR$1
        @Override // java.util.Comparator
        public int compare(GuildRole role1, GuildRole role2) {
            if (role1 != null && role2 != null) {
                int position = role1.getPosition();
                int position2 = role2.getPosition();
                return position2 != position ? position2 - position : (TimeUtils.parseSnowflake(Long.valueOf(role1.getId())) > TimeUtils.parseSnowflake(Long.valueOf(role2.getId())) ? 1 : (TimeUtils.parseSnowflake(Long.valueOf(role1.getId())) == TimeUtils.parseSnowflake(Long.valueOf(role2.getId())) ? 0 : -1));
            }
            if (role1 == null || role2 != null) {
                return (role1 != null || role2 == null) ? 0 : 1;
            }
            return -1;
        }
    };

    private RoleUtils() {
    }

    public static final boolean containsRoleMentions(String input) {
        return input != null && ROLE_MENTION_RE.matcher(input).find();
    }

    public static final GuildRole getHighestHoistedRole(Map<Long, GuildRole> guildRoles, GuildMember member) {
        Intrinsics3.checkNotNullParameter(guildRoles, "guildRoles");
        if (member == null) {
            return null;
        }
        List<Long> roles = member.getRoles();
        ArrayList arrayList = new ArrayList();
        for (Object obj : roles) {
            GuildRole guildRole = guildRoles.get(Long.valueOf(((Number) obj).longValue()));
            if (guildRole != null && guildRole.getHoist()) {
                arrayList.add(obj);
            }
        }
        return getHighestRole(guildRoles, arrayList);
    }

    public static final GuildRole getHighestRole(Map<Long, GuildRole> guildRoles, GuildMember member) {
        Intrinsics3.checkNotNullParameter(guildRoles, "guildRoles");
        if (member == null) {
            return null;
        }
        return getHighestRole(guildRoles, member.getRoles());
    }

    @ColorInt
    public static final int getOpaqueColor(GuildRole role, @ColorInt int defaultColor) {
        if (role != null) {
            try {
                if (role.getColor() != 0) {
                    defaultColor = role.getColor();
                }
            } catch (Exception unused) {
                return ViewCompat.MEASURED_STATE_MASK;
            }
        }
        return ViewCompat.MEASURED_STATE_MASK + defaultColor;
    }

    public static final Comparator<GuildRole> getROLE_COMPARATOR() {
        return ROLE_COMPARATOR;
    }

    public static /* synthetic */ void getROLE_COMPARATOR$annotations() {
    }

    @ColorInt
    public static final int getRoleColor(GuildRole guildRole, Context context) {
        return getRoleColor$default(guildRole, context, null, 2, null);
    }

    @ColorInt
    public static final int getRoleColor(GuildRole guildRole, Context context, @ColorInt Integer num) {
        Intrinsics3.checkNotNullParameter(guildRole, "$this$getRoleColor");
        Intrinsics3.checkNotNullParameter(context, "context");
        if (isDefaultColor(guildRole)) {
            return num != null ? num.intValue() : ColorCompat.getColor(context, R.color.primary_300);
        }
        return getOpaqueColor(guildRole);
    }

    public static /* synthetic */ int getRoleColor$default(GuildRole guildRole, Context context, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        return getRoleColor(guildRole, context, num);
    }

    public static final boolean hasSubscriptionListingId(GuildRole guildRole) {
        Intrinsics3.checkNotNullParameter(guildRole, "$this$hasSubscriptionListingId");
        GuildRoleTags tags = guildRole.getTags();
        String subscriptionListingId = tags != null ? tags.getSubscriptionListingId() : null;
        return !(subscriptionListingId == null || StringsJVM.isBlank(subscriptionListingId));
    }

    public static final boolean isDefaultColor(GuildRole guildRole) {
        Intrinsics3.checkNotNullParameter(guildRole, "$this$isDefaultColor");
        return guildRole.getColor() == 0;
    }

    public static final boolean isSubscriptionRolePurchasableOrHasSubscribers(GuildRole guildRole) {
        GuildRoleTags tags;
        Intrinsics3.checkNotNullParameter(guildRole, "$this$isSubscriptionRolePurchasableOrHasSubscribers");
        return hasSubscriptionListingId(guildRole) && (tags = guildRole.getTags()) != null && tags.b();
    }

    public static final boolean rankEquals(GuildRole role1, GuildRole role2) {
        return ROLE_COMPARATOR.compare(role1, role2) == 0;
    }

    public static final boolean rankIsHigher(GuildRole role1, GuildRole role2) {
        return ROLE_COMPARATOR.compare(role1, role2) < 0;
    }

    public static final GuildRole getHighestRole(Map<Long, GuildRole> guildRoles, Collection<Long> roleIds) {
        Intrinsics3.checkNotNullParameter(guildRoles, "guildRoles");
        GuildRole guildRole = null;
        if (roleIds == null) {
            return null;
        }
        Iterator<Long> it = roleIds.iterator();
        while (it.hasNext()) {
            GuildRole guildRole2 = guildRoles.get(Long.valueOf(it.next().longValue()));
            if (guildRole2 != null && rankIsHigher(guildRole2, guildRole)) {
                guildRole = guildRole2;
            }
        }
        return guildRole;
    }

    @ColorInt
    public static final int getOpaqueColor(GuildRole role) {
        return getOpaqueColor(role, 0);
    }
}
