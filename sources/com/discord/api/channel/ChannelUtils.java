package com.discord.api.channel;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
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
import com.discord.stores.StoreStream;
import com.discord.utilities.PermissionOverwriteUtilsKt;
import com.discord.utilities.guilds.GuildUtilsKt;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.user.UserUtils;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ChannelUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ChannelUtils {
    private static final long HQ_DIRECTORY_CHANNEL_ID = 883060064561299456L;

    public static final boolean A(Channel channel) {
        m.checkNotNullParameter(channel, "$this$isPinned");
        m.checkNotNullParameter(channel, "$this$hasFlag");
        Long flags = channel.getFlags();
        return ((flags != null ? flags.longValue() : 0L) & 2) == 2;
    }

    public static final boolean B(Channel channel) {
        m.checkNotNullParameter(channel, "$this$isPrivate");
        return channel.getType() == 1 || channel.getType() == 3;
    }

    public static final boolean C(Channel channel) {
        m.checkNotNullParameter(channel, "$this$isPrivateThread");
        return channel.getType() == 12;
    }

    public static final boolean D(Channel channel) {
        m.checkNotNullParameter(channel, "$this$isStageVoiceChannel");
        return channel.getType() == 13;
    }

    public static final boolean E(Channel channel) {
        User user;
        m.checkNotNullParameter(channel, "$this$isSystemDM");
        if (channel.getType() == 1) {
            List<User> listZ = channel.z();
            if (m.areEqual((listZ == null || (user = (User) u.firstOrNull((List) listZ)) == null) ? null : user.getSystem(), Boolean.TRUE)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean F(Channel channel) {
        m.checkNotNullParameter(channel, "$this$isTextChannel");
        return B(channel) || v(channel);
    }

    public static final boolean G(Channel channel) {
        m.checkNotNullParameter(channel, "$this$isTextOrVoiceChannel");
        return F(channel) || J(channel);
    }

    public static final boolean H(Channel channel) {
        m.checkNotNullParameter(channel, "$this$isThread");
        return channel.getType() == 10 || channel.getType() == 11 || channel.getType() == 12;
    }

    public static final boolean I(Channel channel) {
        m.checkNotNullParameter(channel, "$this$isThreaded");
        return channel.getType() == 0 || channel.getType() == 5 || channel.getType() == 15;
    }

    public static final boolean J(Channel channel) {
        m.checkNotNullParameter(channel, "$this$isVoiceChannel");
        return channel.getType() == 2;
    }

    public static final boolean K(Channel channel) {
        m.checkNotNullParameter(channel, "$this$shouldPlayJoinLeaveSounds");
        return J(channel) || B(channel);
    }

    public static final com.discord.models.user.User a(Channel channel) {
        List<User> listZ;
        List<User> listZ2;
        User user;
        m.checkNotNullParameter(channel, "$this$getDMRecipient");
        if (!m(channel) || (listZ = channel.z()) == null || listZ.size() != 1 || (listZ2 = channel.z()) == null || (user = (User) u.first((List) listZ2)) == null) {
            return null;
        }
        return new CoreUser(user);
    }

    public static final Integer b(Channel channel) {
        m.checkNotNullParameter(channel, "$this$getDeletedMessage");
        if (k(channel)) {
            return 2131887467;
        }
        if (H(channel)) {
            return 2131896374;
        }
        return B(channel) ? null : 2131887547;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0038  */
    /* JADX WARN: Code duplicated, block: B:23:? A[RETURN, SYNTHETIC] */
    public static final String c(Channel channel) {
        String name;
        m.checkNotNullParameter(channel, "$this$getDisplayName");
        if (B(channel)) {
            String name2 = channel.getName();
            if (name2 == null || name2.length() == 0) {
                List<User> listZ = channel.z();
                name = listZ != null ? u.joinToString$default(listZ, null, null, null, 0, null, ChannelUtils$getDisplayName$1.INSTANCE, 31, null) : null;
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

    public static final String d(Channel channel, Context context, boolean z2) {
        m.checkNotNullParameter(channel, "$this$getDisplayNameOrDefault");
        m.checkNotNullParameter(context, "context");
        String strC = c(channel);
        if (u(channel) || i(channel)) {
            if (strC.length() == 0) {
                String string = context.getString(2131892213);
                m.checkNotNullExpressionValue(string, "context.getString(R.string.invalid_text_channel)");
                return string;
            }
            if (z2) {
                StringBuilder sb = new StringBuilder();
                m.checkNotNullParameter(Channel.Companion, "$this$DISPLAY_PREFIX_GUILD");
                sb.append("#");
                sb.append(strC);
                return sb.toString();
            }
        } else if (w(channel)) {
            if (strC.length() == 0) {
                String string2 = context.getString(2131892214);
                m.checkNotNullExpressionValue(string2, "context.getString(R.string.invalid_voice_channel)");
                return string2;
            }
        } else if (p(channel)) {
            if (strC.length() == 0) {
                String string3 = context.getString(2131896595);
                m.checkNotNullExpressionValue(string3, "context.getString(R.string.unnamed)");
                return string3;
            }
        } else if (m(channel)) {
            if (strC.length() == 0) {
                String string4 = context.getString(2131888439);
                m.checkNotNullExpressionValue(string4, "context.getString(R.string.direct_message)");
                return string4;
            }
            if (z2) {
                StringBuilder sb2 = new StringBuilder();
                m.checkNotNullParameter(Channel.Companion, "$this$DISPLAY_PREFIX_DM");
                sb2.append("@");
                sb2.append(strC);
                return sb2.toString();
            }
        }
        return strC;
    }

    public static /* synthetic */ String e(Channel channel, Context context, boolean z2, int i) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        return d(channel, context, z2);
    }

    public static final PermissionOverwrite f(Channel channel, long j) {
        m.checkNotNullParameter(channel, "$this$getPermissionOverwriteForId");
        List<PermissionOverwrite> listV = channel.v();
        Object obj = null;
        if (listV == null) {
            return null;
        }
        for (Object obj2 : listV) {
            if (((PermissionOverwrite) obj2).e() == j) {
                obj = obj2;
                break;
            }
        }
        return (PermissionOverwrite) obj;
    }

    public static final List<com.discord.models.user.User> g(Channel channel) {
        m.checkNotNullParameter(channel, "$this$getRecipients");
        List<User> listZ = channel.z();
        if (listZ == null) {
            return n.emptyList();
        }
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(listZ, 10));
        Iterator<T> it = listZ.iterator();
        while (it.hasNext()) {
            arrayList.add(new CoreUser((User) it.next()));
        }
        return arrayList;
    }

    public static final Comparator<Channel> h(Channel$Companion channel$Companion) {
        m.checkNotNullParameter(channel$Companion, "$this$getSortByNameAndType");
        return new ChannelUtils$getSortByNameAndType$1(channel$Companion);
    }

    public static final boolean i(Channel channel) {
        m.checkNotNullParameter(channel, "$this$isAnnouncementChannel");
        return channel.getType() == 5;
    }

    public static final boolean j(Channel channel) {
        m.checkNotNullParameter(channel, "$this$isArchivedThread");
        ThreadMetadata threadMetadata = channel.getThreadMetadata();
        return threadMetadata != null && threadMetadata.getArchived();
    }

    public static final boolean k(Channel channel) {
        m.checkNotNullParameter(channel, "$this$isCategory");
        return channel.getType() == 4;
    }

    public static final boolean l(int i) {
        return i == 0 || i == 5 || i == 10 || i == 11 || i == 12 || i == 14 || i == 15;
    }

    public static final boolean m(Channel channel) {
        m.checkNotNullParameter(channel, "$this$isDM");
        return channel.getType() == 1;
    }

    public static final boolean n(Channel channel, Presence presence) {
        m.checkNotNullParameter(channel, "$this$isDMStatusVisible");
        com.discord.models.user.User userA = a(channel);
        return m(channel) && !E(channel) && (userA != null ? UserUtils.INSTANCE.isStatusVisible(userA, presence, true) : false);
    }

    public static final boolean o(Channel channel) {
        m.checkNotNullParameter(channel, "$this$isDirectory");
        return channel.getType() == 14;
    }

    public static final boolean p(Channel channel) {
        m.checkNotNullParameter(channel, "$this$isGroup");
        return channel.getType() == 3;
    }

    public static final boolean q(Channel channel) {
        m.checkNotNullParameter(channel, "$this$isGuildForumChannel");
        return channel.getType() == 15;
    }

    public static final boolean r(Channel channel, Channel channel2) {
        m.checkNotNullParameter(channel, "$this$isGuildForumPost");
        return channel2 != null && channel2.getType() == 15;
    }

    public static /* synthetic */ boolean s(Channel channel, Channel channel2, int i) {
        return r(channel, (i & 1) != 0 ? StoreStream.Companion.getChannels().getChannel(channel.getParentId()) : null);
    }

    public static final boolean t(Channel channel, Guild guild, GuildRole guildRole, Map<Long, GuildRole> map) {
        Object next;
        m.checkNotNullParameter(channel, "$this$isGuildRoleSubscriptionChannel");
        if (guild != null && guild.hasFeature(GuildFeature.ROLE_SUBSCRIPTIONS_AVAILABLE_FOR_PURCHASE)) {
            List<PermissionOverwrite> listV = channel.v();
            if (listV == null) {
                listV = n.emptyList();
            }
            for (PermissionOverwrite permissionOverwrite : listV) {
                GuildRole guildRole2 = GuildUtilsKt.getGuildRole(Long.valueOf(permissionOverwrite.e()));
                if (guildRole2 != null && RoleUtils.isSubscriptionRolePurchasableOrHasSubscribers(guildRole2) && PermissionOverwriteUtilsKt.grantsAccessTo(permissionOverwrite, channel)) {
                    return true;
                }
            }
            boolean zIsFullyGatedGuildRoleSubscriptionGuild = GuildUtilsKt.isFullyGatedGuildRoleSubscriptionGuild(guild, guildRole);
            Iterator<T> it = listV.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(((PermissionOverwrite) next).e() == guild.getId()));
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

    public static final boolean u(Channel channel) {
        m.checkNotNullParameter(channel, "$this$isGuildTextChannel");
        return channel.getType() == 0 || channel.getType() == 15;
    }

    public static final boolean v(Channel channel) {
        m.checkNotNullParameter(channel, "$this$isGuildTextyChannel");
        return l(channel.getType());
    }

    public static final boolean w(Channel channel) {
        m.checkNotNullParameter(channel, "$this$isGuildVocalChannel");
        return channel.getType() == 2 || channel.getType() == 13;
    }

    public static final boolean x(Channel channel) {
        m.checkNotNullParameter(channel, "$this$isHQDirectoryChannel");
        return channel.getId() == HQ_DIRECTORY_CHANNEL_ID;
    }

    public static final boolean y(Channel channel) {
        m.checkNotNullParameter(channel, "$this$isManaged");
        return channel.getApplicationId() != 0;
    }

    public static final boolean z(Channel channel) {
        m.checkNotNullParameter(channel, "$this$isMultiUserDM");
        return channel.getType() == 3;
    }
}
