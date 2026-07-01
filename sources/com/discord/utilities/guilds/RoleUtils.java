package com.discord.utilities.guilds;

import android.content.Context;
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;
import com.discord.api.role.GuildRole;
import com.discord.api.role.GuildRoleTags;
import com.discord.models.member.GuildMember;
import com.discord.utilities.color.ColorCompat;
import d0.g0.t;
import d0.z.d.m;
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
    private static final Comparator<GuildRole> ROLE_COMPARATOR = new RoleUtils$ROLE_COMPARATOR$1();

    private RoleUtils() {
    }

    public static final boolean containsRoleMentions(String input) {
        return input != null && ROLE_MENTION_RE.matcher(input).find();
    }

    public static final GuildRole getHighestHoistedRole(Map<Long, GuildRole> guildRoles, GuildMember member) {
        m.checkNotNullParameter(guildRoles, "guildRoles");
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
        m.checkNotNullParameter(guildRoles, "guildRoles");
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
        m.checkNotNullParameter(guildRole, "$this$getRoleColor");
        m.checkNotNullParameter(context, "context");
        if (isDefaultColor(guildRole)) {
            return num != null ? num.intValue() : ColorCompat.getColor(context, 2131100171);
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
        m.checkNotNullParameter(guildRole, "$this$hasSubscriptionListingId");
        GuildRoleTags tags = guildRole.getTags();
        String subscriptionListingId = tags != null ? tags.getSubscriptionListingId() : null;
        return !(subscriptionListingId == null || t.isBlank(subscriptionListingId));
    }

    public static final boolean isDefaultColor(GuildRole guildRole) {
        m.checkNotNullParameter(guildRole, "$this$isDefaultColor");
        return guildRole.getColor() == 0;
    }

    public static final boolean isSubscriptionRolePurchasableOrHasSubscribers(GuildRole guildRole) {
        GuildRoleTags tags;
        m.checkNotNullParameter(guildRole, "$this$isSubscriptionRolePurchasableOrHasSubscribers");
        return hasSubscriptionListingId(guildRole) && (tags = guildRole.getTags()) != null && tags.b();
    }

    public static final boolean rankEquals(GuildRole role1, GuildRole role2) {
        return ROLE_COMPARATOR.compare(role1, role2) == 0;
    }

    public static final boolean rankIsHigher(GuildRole role1, GuildRole role2) {
        return ROLE_COMPARATOR.compare(role1, role2) < 0;
    }

    public static final GuildRole getHighestRole(Map<Long, GuildRole> guildRoles, Collection<Long> roleIds) {
        m.checkNotNullParameter(guildRoles, "guildRoles");
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
