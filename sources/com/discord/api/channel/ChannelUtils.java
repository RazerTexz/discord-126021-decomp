package com.discord.api.channel;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.discord.C5419R;
import com.discord.api.guild.GuildFeature;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.api.thread.ThreadMetadata;
import com.discord.api.user.User;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.presence.Presence;
import com.discord.models.user.CoreUser;
import com.discord.utilities.PermissionOverwriteUtilsKt;
import com.discord.utilities.guilds.GuildUtilsKt;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.user.UserUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ChannelUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ChannelUtils {
    private static final long HQ_DIRECTORY_CHANNEL_ID = 883060064561299456L;

    /* JADX INFO: renamed from: A */
    public static final boolean m7666A(Channel channel) {
        C12238m.checkNotNullParameter(channel, "$this$isPinned");
        C12238m.checkNotNullParameter(channel, "$this$hasFlag");
        Long flags = channel.getFlags();
        return ((flags != null ? flags.longValue() : 0L) & 2) == 2;
    }

    /* JADX INFO: renamed from: B */
    public static final boolean m7667B(Channel channel) {
        C12238m.checkNotNullParameter(channel, "$this$isPrivate");
        return channel.getType() == 1 || channel.getType() == 3;
    }

    /* JADX INFO: renamed from: C */
    public static final boolean m7668C(Channel channel) {
        C12238m.checkNotNullParameter(channel, "$this$isPrivateThread");
        return channel.getType() == 12;
    }

    /* JADX INFO: renamed from: D */
    public static final boolean m7669D(Channel channel) {
        C12238m.checkNotNullParameter(channel, "$this$isStageVoiceChannel");
        return channel.getType() == 13;
    }

    /* JADX INFO: renamed from: E */
    public static final boolean m7670E(Channel channel) {
        User user;
        C12238m.checkNotNullParameter(channel, "$this$isSystemDM");
        if (channel.getType() == 1) {
            List<User> listM7659z = channel.m7659z();
            if (C12238m.areEqual((listM7659z == null || (user = (User) C12163u.firstOrNull((List) listM7659z)) == null) ? null : user.getSystem(), Boolean.TRUE)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: F */
    public static final boolean m7671F(Channel channel) {
        C12238m.checkNotNullParameter(channel, "$this$isTextChannel");
        return m7667B(channel) || m7698v(channel);
    }

    /* JADX INFO: renamed from: G */
    public static final boolean m7672G(Channel channel) {
        C12238m.checkNotNullParameter(channel, "$this$isTextOrVoiceChannel");
        return m7671F(channel) || m7675J(channel);
    }

    /* JADX INFO: renamed from: H */
    public static final boolean m7673H(Channel channel) {
        C12238m.checkNotNullParameter(channel, "$this$isThread");
        return channel.getType() == 10 || channel.getType() == 11 || channel.getType() == 12;
    }

    /* JADX INFO: renamed from: I */
    public static final boolean m7674I(Channel channel) {
        C12238m.checkNotNullParameter(channel, "$this$isThreaded");
        return channel.getType() == 0 || channel.getType() == 5 || channel.getType() == 15;
    }

    /* JADX INFO: renamed from: J */
    public static final boolean m7675J(Channel channel) {
        C12238m.checkNotNullParameter(channel, "$this$isVoiceChannel");
        return channel.getType() == 2;
    }

    /* JADX INFO: renamed from: K */
    public static final boolean m7676K(Channel channel) {
        C12238m.checkNotNullParameter(channel, "$this$shouldPlayJoinLeaveSounds");
        return m7675J(channel) || m7667B(channel);
    }

    /* JADX INFO: renamed from: a */
    public static final com.discord.models.user.User m7677a(Channel channel) {
        List<User> listM7659z;
        List<User> listM7659z2;
        User user;
        C12238m.checkNotNullParameter(channel, "$this$getDMRecipient");
        if (!m7689m(channel) || (listM7659z = channel.m7659z()) == null || listM7659z.size() != 1 || (listM7659z2 = channel.m7659z()) == null || (user = (User) C12163u.first((List) listM7659z2)) == null) {
            return null;
        }
        return new CoreUser(user);
    }

    /* JADX INFO: renamed from: b */
    public static final Integer m7678b(Channel channel) {
        C12238m.checkNotNullParameter(channel, "$this$getDeletedMessage");
        if (m7687k(channel)) {
            return Integer.valueOf(C5419R.string.category_has_been_deleted);
        }
        if (m7673H(channel)) {
            return Integer.valueOf(C5419R.string.thread_has_been_deleted);
        }
        if (m7667B(channel)) {
            return null;
        }
        return Integer.valueOf(C5419R.string.channel_has_been_deleted);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0038  */
    /* JADX WARN: Code duplicated, block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: c */
    public static final String m7679c(Channel channel) {
        String name;
        C12238m.checkNotNullParameter(channel, "$this$getDisplayName");
        if (m7667B(channel)) {
            String name2 = channel.getName();
            if (name2 == null || name2.length() == 0) {
                List<User> listM7659z = channel.m7659z();
                name = listM7659z != null ? C12163u.joinToString$default(listM7659z, null, null, null, 0, null, ChannelUtils$getDisplayName$1.INSTANCE, 31, null) : null;
                if (name == null) {
                    return "";
                }
            } else {
                name = channel.getName();
                if (name == null) {
                    return "";
                }
            }
        } else {
            name = channel.getName();
            if (name == null) {
                return "";
            }
        }
        return name;
    }

    /* JADX INFO: renamed from: d */
    public static final String m7680d(Channel channel, Context context, boolean z2) {
        C12238m.checkNotNullParameter(channel, "$this$getDisplayNameOrDefault");
        C12238m.checkNotNullParameter(context, "context");
        String strM7679c = m7679c(channel);
        if (m7697u(channel) || m7685i(channel)) {
            if (strM7679c.length() == 0) {
                String string = context.getString(C5419R.string.invalid_text_channel);
                C12238m.checkNotNullExpressionValue(string, "context.getString(R.string.invalid_text_channel)");
                return string;
            }
            if (z2) {
                StringBuilder sb = new StringBuilder();
                C12238m.checkNotNullParameter(Channel.INSTANCE, "$this$DISPLAY_PREFIX_GUILD");
                sb.append("#");
                sb.append(strM7679c);
                return sb.toString();
            }
        } else if (m7699w(channel)) {
            if (strM7679c.length() == 0) {
                String string2 = context.getString(C5419R.string.invalid_voice_channel);
                C12238m.checkNotNullExpressionValue(string2, "context.getString(R.string.invalid_voice_channel)");
                return string2;
            }
        } else if (m7692p(channel)) {
            if (strM7679c.length() == 0) {
                String string3 = context.getString(C5419R.string.unnamed);
                C12238m.checkNotNullExpressionValue(string3, "context.getString(R.string.unnamed)");
                return string3;
            }
        } else if (m7689m(channel)) {
            if (strM7679c.length() == 0) {
                String string4 = context.getString(C5419R.string.direct_message);
                C12238m.checkNotNullExpressionValue(string4, "context.getString(R.string.direct_message)");
                return string4;
            }
            if (z2) {
                StringBuilder sb2 = new StringBuilder();
                C12238m.checkNotNullParameter(Channel.INSTANCE, "$this$DISPLAY_PREFIX_DM");
                sb2.append("@");
                sb2.append(strM7679c);
                return sb2.toString();
            }
        }
        return strM7679c;
    }

    /* JADX INFO: renamed from: e */
    public static /* synthetic */ String m7681e(Channel channel, Context context, boolean z2, int i) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        return m7680d(channel, context, z2);
    }

    /* JADX INFO: renamed from: f */
    public static final PermissionOverwrite m7682f(Channel channel, long j) {
        C12238m.checkNotNullParameter(channel, "$this$getPermissionOverwriteForId");
        List<PermissionOverwrite> listM7655v = channel.m7655v();
        Object obj = null;
        if (listM7655v == null) {
            return null;
        }
        for (Object obj2 : listM7655v) {
            if (((PermissionOverwrite) obj2).m8131e() == j) {
                obj = obj2;
                break;
            }
        }
        return (PermissionOverwrite) obj;
    }

    /* JADX INFO: renamed from: g */
    public static final List<com.discord.models.user.User> m7683g(Channel channel) {
        C12238m.checkNotNullParameter(channel, "$this$getRecipients");
        List<User> listM7659z = channel.m7659z();
        if (listM7659z == null) {
            return C12147n.emptyList();
        }
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listM7659z, 10));
        Iterator<T> it = listM7659z.iterator();
        while (it.hasNext()) {
            arrayList.add(new CoreUser((User) it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: h */
    public static final Comparator<Channel> m7684h(Channel.Companion companion) {
        C12238m.checkNotNullParameter(companion, "$this$getSortByNameAndType");
        return new ChannelUtils$getSortByNameAndType$1(companion);
    }

    /* JADX INFO: renamed from: i */
    public static final boolean m7685i(Channel channel) {
        C12238m.checkNotNullParameter(channel, "$this$isAnnouncementChannel");
        return channel.getType() == 5;
    }

    /* JADX INFO: renamed from: j */
    public static final boolean m7686j(Channel channel) {
        C12238m.checkNotNullParameter(channel, "$this$isArchivedThread");
        ThreadMetadata threadMetadata = channel.getThreadMetadata();
        return threadMetadata != null && threadMetadata.getArchived();
    }

    /* JADX INFO: renamed from: k */
    public static final boolean m7687k(Channel channel) {
        C12238m.checkNotNullParameter(channel, "$this$isCategory");
        return channel.getType() == 4;
    }

    /* JADX INFO: renamed from: l */
    public static final boolean m7688l(int i) {
        return i == 0 || i == 5 || i == 10 || i == 11 || i == 12 || i == 14 || i == 15;
    }

    /* JADX INFO: renamed from: m */
    public static final boolean m7689m(Channel channel) {
        C12238m.checkNotNullParameter(channel, "$this$isDM");
        return channel.getType() == 1;
    }

    /* JADX INFO: renamed from: n */
    public static final boolean m7690n(Channel channel, Presence presence) {
        C12238m.checkNotNullParameter(channel, "$this$isDMStatusVisible");
        com.discord.models.user.User userM7677a = m7677a(channel);
        return m7689m(channel) && !m7670E(channel) && (userM7677a != null ? UserUtils.INSTANCE.isStatusVisible(userM7677a, presence, true) : false);
    }

    /* JADX INFO: renamed from: o */
    public static final boolean m7691o(Channel channel) {
        C12238m.checkNotNullParameter(channel, "$this$isDirectory");
        return channel.getType() == 14;
    }

    /* JADX INFO: renamed from: p */
    public static final boolean m7692p(Channel channel) {
        C12238m.checkNotNullParameter(channel, "$this$isGroup");
        return channel.getType() == 3;
    }

    /* JADX INFO: renamed from: q */
    public static final boolean m7693q(Channel channel) {
        C12238m.checkNotNullParameter(channel, "$this$isGuildForumChannel");
        return channel.getType() == 15;
    }

    /* JADX INFO: renamed from: r */
    public static final boolean m7694r(Channel channel, Channel channel2) {
        C12238m.checkNotNullParameter(channel, "$this$isGuildForumPost");
        return channel2 != null && channel2.getType() == 15;
    }

    /* JADX INFO: renamed from: t */
    public static final boolean m7696t(Channel channel, Guild guild, GuildRole guildRole, Map<Long, GuildRole> map) {
        Object next;
        C12238m.checkNotNullParameter(channel, "$this$isGuildRoleSubscriptionChannel");
        if (guild != null && guild.hasFeature(GuildFeature.ROLE_SUBSCRIPTIONS_AVAILABLE_FOR_PURCHASE)) {
            List<PermissionOverwrite> listM7655v = channel.m7655v();
            if (listM7655v == null) {
                listM7655v = C12147n.emptyList();
            }
            for (PermissionOverwrite permissionOverwrite : listM7655v) {
                GuildRole guildRole2 = GuildUtilsKt.getGuildRole(Long.valueOf(permissionOverwrite.m8131e()));
                if (guildRole2 != null && RoleUtils.isSubscriptionRolePurchasableOrHasSubscribers(guildRole2) && PermissionOverwriteUtilsKt.grantsAccessTo(permissionOverwrite, channel)) {
                    return true;
                }
            }
            boolean zIsFullyGatedGuildRoleSubscriptionGuild = GuildUtilsKt.isFullyGatedGuildRoleSubscriptionGuild(guild, guildRole);
            Iterator<T> it = listM7655v.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(((PermissionOverwrite) next).m8131e() == guild.getId()));
            PermissionOverwrite permissionOverwrite2 = (PermissionOverwrite) next;
            boolean zDeniesAccessTo = permissionOverwrite2 != null ? PermissionOverwriteUtilsKt.deniesAccessTo(permissionOverwrite2, channel) : false;
            if (map != null && !zDeniesAccessTo && zIsFullyGatedGuildRoleSubscriptionGuild) {
                for (GuildRole guildRole3 : map.values()) {
                    if (RoleUtils.isSubscriptionRolePurchasableOrHasSubscribers(guildRole3) && PermissionUtils.INSTANCE.canRole(Permission.VIEW_CHANNEL, guildRole3, null)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: u */
    public static final boolean m7697u(Channel channel) {
        C12238m.checkNotNullParameter(channel, "$this$isGuildTextChannel");
        return channel.getType() == 0 || channel.getType() == 15;
    }

    /* JADX INFO: renamed from: v */
    public static final boolean m7698v(Channel channel) {
        C12238m.checkNotNullParameter(channel, "$this$isGuildTextyChannel");
        return m7688l(channel.getType());
    }

    /* JADX INFO: renamed from: w */
    public static final boolean m7699w(Channel channel) {
        C12238m.checkNotNullParameter(channel, "$this$isGuildVocalChannel");
        return channel.getType() == 2 || channel.getType() == 13;
    }

    /* JADX INFO: renamed from: x */
    public static final boolean m7700x(Channel channel) {
        C12238m.checkNotNullParameter(channel, "$this$isHQDirectoryChannel");
        return channel.getId() == HQ_DIRECTORY_CHANNEL_ID;
    }

    /* JADX INFO: renamed from: y */
    public static final boolean m7701y(Channel channel) {
        C12238m.checkNotNullParameter(channel, "$this$isManaged");
        return channel.getApplicationId() != 0;
    }

    /* JADX INFO: renamed from: z */
    public static final boolean m7702z(Channel channel) {
        C12238m.checkNotNullParameter(channel, "$this$isMultiUserDM");
        return channel.getType() == 3;
    }
}
