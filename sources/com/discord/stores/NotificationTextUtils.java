package com.discord.stores;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.message.Message;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelNotificationSettings$ChannelOverride;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.threads.ThreadUtils;
import d0.t.n;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: NotificationTextUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationTextUtils {
    public static final NotificationTextUtils INSTANCE = new NotificationTextUtils();

    private NotificationTextUtils() {
    }

    private final boolean isNotificationAllowed(ModelNotificationSettings modelNotificationSettings, User user, Collection<Long> collection, Message message, Guild guild, Channel channel, Long l, long j) {
        if (modelNotificationSettings.isMobilePush() && !isGuildOrCategoryOrChannelMuted(modelNotificationSettings, channel)) {
            return shouldNotifyForLevel(channelMessageNotificationLevel(modelNotificationSettings, channel, guild), user, collection, message, channel, l, j, modelNotificationSettings.isSuppressEveryone(), modelNotificationSettings.isSuppressRoles());
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x005c  */
    /* JADX WARN: Code duplicated, block: B:28:0x0062  */
    /* JADX WARN: Code duplicated, block: B:30:0x0068  */
    /* JADX WARN: Code duplicated, block: B:31:0x006a  */
    /* JADX WARN: Code duplicated, block: B:34:0x0074  */
    /* JADX WARN: Code duplicated, block: B:46:0x0088 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:? A[LOOP:1: B:32:0x006e->B:47:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:? A[RETURN, SYNTHETIC] */
    private final boolean isThreadNotificationAllowed(User me2, Collection<Long> myRoleIds, Message message, StoreThreadsJoined$JoinedThread joinedThread, ModelNotificationSettings guildSettings, Guild guild, Channel thread, Channel parentChannel) {
        List<Long> listS;
        Iterator<T> it;
        boolean z2;
        boolean z3;
        if (isGuildOrCategoryOrChannelMuted(guildSettings, thread)) {
            return false;
        }
        int iComputeThreadNotificationSetting = ThreadUtils.INSTANCE.computeThreadNotificationSetting(joinedThread, isGuildOrCategoryOrChannelMuted(guildSettings, parentChannel), channelMessageNotificationLevel(guildSettings, parentChannel, guild));
        if (iComputeThreadNotificationSetting != 2) {
            if (iComputeThreadNotificationSetting == 8) {
                return false;
            }
            if (!m.areEqual(message.getMentionEveryone(), Boolean.TRUE)) {
                List<com.discord.api.user.User> listT = message.t();
                if (listT == null) {
                    listS = message.s();
                    if (listS != null) {
                        return false;
                    }
                    if (listS.isEmpty()) {
                        z2 = false;
                    } else {
                        it = listS.iterator();
                        while (it.hasNext()) {
                            if (myRoleIds.contains(Long.valueOf(((Number) it.next()).longValue()))) {
                                z2 = true;
                            }
                        }
                        z2 = false;
                    }
                    if (z2) {
                        return false;
                    }
                } else {
                    if (!listT.isEmpty()) {
                        Iterator<T> it2 = listT.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z3 = false;
                                break;
                            }
                            if (((com.discord.api.user.User) it2.next()).getId() == me2.getId()) {
                                z3 = true;
                                break;
                            }
                        }
                    } else {
                        z3 = false;
                        break;
                    }
                    if (!z3) {
                        listS = message.s();
                        if (listS != null) {
                            return false;
                        }
                        if (listS.isEmpty()) {
                            z2 = false;
                        } else {
                            it = listS.iterator();
                            while (it.hasNext()) {
                                if (myRoleIds.contains(Long.valueOf(((Number) it.next()).longValue()))) {
                                    z2 = true;
                                }
                            }
                            z2 = false;
                        }
                        if (z2) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0042  */
    private final boolean messageContainsMention(User me2, Collection<Long> myRoleIds, Message message, boolean isSuppressEveryone, boolean isSuppressRoles) {
        List<Long> listS;
        boolean z2;
        boolean z3;
        if (!m.areEqual(message.getMentionEveryone(), Boolean.TRUE) || isSuppressEveryone) {
            List<com.discord.api.user.User> listT = message.t();
            if (listT != null) {
                if (!listT.isEmpty()) {
                    Iterator<T> it = listT.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z3 = false;
                            break;
                        }
                        if (((com.discord.api.user.User) it.next()).getId() == me2.getId()) {
                            z3 = true;
                            break;
                        }
                    }
                } else {
                    z3 = false;
                    break;
                }
                if (!z3) {
                    return isSuppressRoles ? false : false;
                }
            } else if (isSuppressRoles && (listS = message.s()) != null) {
                if (listS.isEmpty()) {
                    z2 = false;
                } else {
                    Iterator<T> it2 = listS.iterator();
                    while (it2.hasNext()) {
                        if (myRoleIds.contains(Long.valueOf(((Number) it2.next()).longValue()))) {
                            z2 = true;
                        }
                    }
                    z2 = false;
                }
                if (!z2) {
                    return false;
                }
            }
        }
        return true;
    }

    public static /* synthetic */ boolean messageContainsMention$default(NotificationTextUtils notificationTextUtils, User user, Collection collection, Message message, boolean z2, boolean z3, int i, Object obj) {
        return notificationTextUtils.messageContainsMention(user, collection, message, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? false : z3);
    }

    private final Integer messageNotifications(ModelNotificationSettings modelNotificationSettings, long j) {
        ModelNotificationSettings$ChannelOverride channelOverride = modelNotificationSettings.getChannelOverride(j);
        if (channelOverride == null) {
            return null;
        }
        Integer numValueOf = Integer.valueOf(channelOverride.getMessageNotifications());
        if (numValueOf.intValue() == ModelNotificationSettings.FREQUENCY_UNSET) {
            return null;
        }
        return numValueOf;
    }

    private final boolean shouldNotifyForLevel(Integer msgNotifLevel, User me2, Collection<Long> myRoleIds, Message message, Channel channel, Long channelPermissions, long selectedVoiceChannelId, boolean isSuppressEveryone, boolean isSuppressRoles) {
        if (ChannelUtils.J(channel) && !PermissionUtils.can(Permission.CONNECT, channelPermissions)) {
            return false;
        }
        int i = ModelNotificationSettings.FREQUENCY_ALL;
        if (msgNotifLevel == null || msgNotifLevel.intValue() != i) {
            int i2 = ModelNotificationSettings.FREQUENCY_MENTIONS;
            if (msgNotifLevel != null && msgNotifLevel.intValue() == i2) {
                return messageContainsMention(me2, myRoleIds, message, isSuppressEveryone, isSuppressRoles);
            }
            int i3 = ModelNotificationSettings.FREQUENCY_NOTHING;
            if (msgNotifLevel != null && msgNotifLevel.intValue() == i3) {
                return false;
            }
        } else if (ChannelUtils.J(channel) && selectedVoiceChannelId != channel.getId() && !messageContainsMention(me2, myRoleIds, message, isSuppressEveryone, isSuppressRoles)) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean shouldNotifyForLevel$default(NotificationTextUtils notificationTextUtils, Integer num, User user, Collection collection, Message message, Channel channel, Long l, long j, boolean z2, boolean z3, int i, Object obj) {
        return notificationTextUtils.shouldNotifyForLevel(num, user, collection, message, channel, l, j, (i & 128) != 0 ? false : z2, (i & 256) != 0 ? false : z3);
    }

    public final Integer channelMessageNotificationLevel(ModelNotificationSettings modelNotificationSettings, Channel channel, Guild guild) {
        Integer num = null;
        Integer numValueOf = guild != null ? Integer.valueOf(guild.getDefaultMessageNotifications()) : null;
        if (channel == null || modelNotificationSettings == null) {
            return numValueOf;
        }
        Integer numMessageNotifications = messageNotifications(modelNotificationSettings, channel.getId());
        if (numMessageNotifications == null) {
            numMessageNotifications = messageNotifications(modelNotificationSettings, channel.getParentId());
        }
        if (numMessageNotifications != null) {
            num = numMessageNotifications;
        } else {
            Integer numValueOf2 = Integer.valueOf(modelNotificationSettings.getMessageNotifications());
            if (numValueOf2.intValue() != ModelNotificationSettings.FREQUENCY_UNSET) {
                num = numValueOf2;
            }
        }
        return num != null ? num : numValueOf;
    }

    public final boolean isGuildOrCategoryOrChannelMuted(ModelNotificationSettings modelNotificationSettings, Channel channel) {
        if (modelNotificationSettings == null) {
            return false;
        }
        if (modelNotificationSettings.isMuted()) {
            return true;
        }
        if (channel == null) {
            return false;
        }
        ModelNotificationSettings$ChannelOverride channelOverride = modelNotificationSettings.getChannelOverride(channel.getParentId());
        if (channelOverride != null && channelOverride.isMuted()) {
            return true;
        }
        ModelNotificationSettings$ChannelOverride channelOverride2 = modelNotificationSettings.getChannelOverride(channel.getId());
        return channelOverride2 != null && channelOverride2.isMuted();
    }

    public final boolean shouldNotifyInAppPopup(User me2, Message msg, Channel channel, Map<Long, Integer> blockedRelationships, Channel parentChannel, Guild guild, Map<Long, ? extends Map<Long, GuildMember>> guildMembers, Map<Long, ? extends ModelNotificationSettings> guildSettings, Map<Long, StoreThreadsJoined$JoinedThread> joinedThreads, long selectedVoiceChannelId, Long channelPermissions) {
        com.discord.api.user.User author;
        List<Long> listEmptyList;
        m.checkNotNullParameter(me2, "me");
        m.checkNotNullParameter(msg, NotificationCompat.CATEGORY_MESSAGE);
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(blockedRelationships, "blockedRelationships");
        m.checkNotNullParameter(guildMembers, "guildMembers");
        m.checkNotNullParameter(guildSettings, "guildSettings");
        m.checkNotNullParameter(joinedThreads, "joinedThreads");
        if (ChannelUtils.y(channel) || (author = msg.getAuthor()) == null || author.getId() == 0 || author.getId() == me2.getId() || blockedRelationships.containsKey(Long.valueOf(author.getId()))) {
            return false;
        }
        Integer type = msg.getType();
        if (type != null && type.intValue() == 3) {
            return false;
        }
        Map map = (Map) a.c(channel, guildMembers);
        GuildMember guildMember = map != null ? (GuildMember) a.f(me2, map) : null;
        if (guildMember == null || (listEmptyList = guildMember.getRoles()) == null) {
            listEmptyList = n.emptyList();
        }
        List<Long> list = listEmptyList;
        ModelNotificationSettings modelNotificationSettings = (ModelNotificationSettings) a.c(channel, guildSettings);
        if (ChannelUtils.H(channel)) {
            return isThreadNotificationAllowed(me2, list, msg, (StoreThreadsJoined$JoinedThread) a.d(channel, joinedThreads), modelNotificationSettings, guild, channel, parentChannel);
        }
        if (modelNotificationSettings != null) {
            return isNotificationAllowed(modelNotificationSettings, me2, list, msg, guild, channel, channelPermissions, selectedVoiceChannelId);
        }
        return shouldNotifyForLevel$default(this, guild != null ? Integer.valueOf(guild.getDefaultMessageNotifications()) : null, me2, list, msg, channel, channelPermissions, selectedVoiceChannelId, false, false, 384, null);
    }
}
