package com.discord.utilities.threads;

import android.content.Context;
import com.discord.R$plurals;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.api.permission.Permission;
import com.discord.api.thread.ThreadMetadata;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIParams$ThreadCreationSettings;
import com.discord.stores.StoreSlowMode$Type$ThreadCreate;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadsActiveJoined$ActiveJoinedThread;
import com.discord.stores.StoreThreadsJoined$JoinedThread;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.chat.list.CreateThreadsFeatureFlag;
import com.discord.widgets.chat.list.NewThreadsPermissionsFeatureFlag;
import com.discord.widgets.chat.list.ViewThreadsFeatureFlag;
import d0.o;
import d0.t.g0;
import d0.t.h0;
import d0.t.n;
import d0.t.t;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.SortedSet;
import rx.Observable;

/* JADX INFO: compiled from: ThreadUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ThreadUtils {
    public static final int DEFAULT_AUTO_ARCHIVE_DURATION = 1440;
    public static final int MAX_DISPLAYED_THREAD_BROWSER_ICON_COUNT = 99;
    public static final ThreadUtils INSTANCE = new ThreadUtils();
    private static final LinkedHashMap<Integer, Integer> THREAD_AUTO_ARCHIVE_DURATION_NAMES = h0.linkedMapOf(o.to(60, 2131886935), o.to(1440, 2131886937), o.to(Integer.valueOf(ThreadUtils$ThreadArchiveDurations.THREE_DAYS_IN_MINUTES), 2131886938), o.to(Integer.valueOf(ThreadUtils$ThreadArchiveDurations.SEVEN_DAYS_IN_MINUTES), 2131886936));

    private ThreadUtils() {
    }

    public static /* synthetic */ boolean canCreatePrivateThread$default(ThreadUtils threadUtils, Long l, Channel channel, Guild guild, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = true;
        }
        return threadUtils.canCreatePrivateThread(l, channel, guild, z2);
    }

    public static /* synthetic */ Observable createThread$default(ThreadUtils threadUtils, long j, Long l, int i, String str, Integer num, String str2, int i2, Object obj) {
        return threadUtils.createThread(j, l, i, str, (i2 & 16) != 0 ? null : num, str2);
    }

    public static /* synthetic */ long getThreadAckMessageTimestamp$default(ThreadUtils threadUtils, Channel channel, Long l, Long l2, Clock clock, int i, Object obj) {
        if ((i & 4) != 0) {
            clock = ClockFactory.get();
        }
        return threadUtils.getThreadAckMessageTimestamp(channel, l, l2, clock);
    }

    private final Comparator<StoreThreadsActiveJoined$ActiveJoinedThread> getThreadTimestampComparator() {
        return ThreadUtils$getThreadTimestampComparator$1.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Map<Long, Collection<Channel>> prependSelectedThread(Map<Long, ? extends Collection<Channel>> sortedThreadsMap, Channel selectedThread) {
        boolean z2;
        Collection collectionEmptyList = (Collection) sortedThreadsMap.get(Long.valueOf(selectedThread.getParentId()));
        if (collectionEmptyList == null) {
            collectionEmptyList = n.emptyList();
        }
        if (!(collectionEmptyList instanceof Collection) || !collectionEmptyList.isEmpty()) {
            Iterator it = collectionEmptyList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                if (((Channel) it.next()).getId() == selectedThread.getId()) {
                    z2 = true;
                    break;
                }
            }
        } else {
            z2 = false;
            break;
        }
        if (z2) {
            return sortedThreadsMap;
        }
        Map<Long, Collection<Channel>> mutableMap = h0.toMutableMap(sortedThreadsMap);
        Long lValueOf = Long.valueOf(selectedThread.getParentId());
        List listMutableListOf = n.mutableListOf(selectedThread);
        listMutableListOf.addAll(collectionEmptyList);
        mutableMap.put(lValueOf, listMutableListOf);
        return mutableMap;
    }

    private final Map<Long, Collection<Channel>> sortThreadsByJoinedDate(Map<Long, ? extends Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread>> threadsMap) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(g0.mapCapacity(threadsMap.size()));
        Iterator<T> it = threadsMap.entrySet().iterator();
        while (it.hasNext()) {
            Map$Entry map$Entry = (Map$Entry) it.next();
            Object key = map$Entry.getKey();
            SortedSet sortedSet = t.toSortedSet(((Map) map$Entry.getValue()).values(), INSTANCE.getThreadTimestampComparator());
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(sortedSet, 10));
            Iterator it2 = sortedSet.iterator();
            while (it2.hasNext()) {
                arrayList.add(((StoreThreadsActiveJoined$ActiveJoinedThread) it2.next()).getChannel());
            }
            linkedHashMap.put(key, arrayList);
        }
        return linkedHashMap;
    }

    public final String autoArchiveDurationName(Context context, int minutes) {
        m.checkNotNullParameter(context, "context");
        Integer num = THREAD_AUTO_ARCHIVE_DURATION_NAMES.get(Integer.valueOf(minutes));
        if (num != null) {
            m.checkNotNullExpressionValue(num, "it");
            String string = context.getString(num.intValue());
            if (string != null) {
                return string;
            }
        }
        String quantityString = context.getResources().getQuantityString(R$plurals.duration_hours_hours, minutes / 60);
        m.checkNotNullExpressionValue(quantityString, "context.resources.getQua…ours_hours, minutes / 60)");
        return quantityString;
    }

    public final boolean canCreatePrivateThread(Long parentChannelPermissions, Channel parentChannel, Guild guild, boolean checkGuildFeature) {
        if (guild == null || parentChannel == null) {
            return false;
        }
        boolean zHasAccessWrite = PermissionUtils.INSTANCE.hasAccessWrite(parentChannel, parentChannelPermissions);
        boolean zCan = PermissionUtils.can(Permission.CREATE_PRIVATE_THREADS, parentChannelPermissions);
        if (!NewThreadsPermissionsFeatureFlag.Companion.getINSTANCE().isEnabled(guild.getId())) {
            zCan = zHasAccessWrite && zCan;
        }
        return isThreadsEnabled(guild.getId()) && zCan && (!ChannelUtils.H(parentChannel) && !ChannelUtils.J(parentChannel)) && (!checkGuildFeature || guild.hasFeature(GuildFeature.PRIVATE_THREADS)) && !ChannelUtils.i(parentChannel);
    }

    public final boolean canCreatePublicThread(Long parentChannelPermissions, Channel parentChannel, Message message, Guild guild) {
        if (guild == null || parentChannel == null) {
            return false;
        }
        boolean zHasAccessWrite = PermissionUtils.INSTANCE.hasAccessWrite(parentChannel, parentChannelPermissions);
        boolean zCan = PermissionUtils.can(Permission.CREATE_PUBLIC_THREADS, parentChannelPermissions);
        boolean z2 = message == null || PermissionUtils.can(Permission.READ_MESSAGE_HISTORY, parentChannelPermissions);
        return isThreadsEnabled(guild.getId()) && (!NewThreadsPermissionsFeatureFlag.Companion.getINSTANCE().isEnabled(guild.getId()) ? !(!zHasAccessWrite || !zCan || !z2) : !(!zCan || !z2)) && ((message == null || !message.isSystemMessage()) && !ChannelUtils.H(parentChannel) && ((message == null || !message.hasThread()) && !ChannelUtils.J(parentChannel)));
    }

    public final boolean canCreateThread(Long parentChannelPermissions, Channel parentChannel, Message message, Guild guild) {
        return canCreatePublicThread(parentChannelPermissions, parentChannel, message, guild) || canCreatePrivateThread$default(this, parentChannelPermissions, parentChannel, guild, false, 8, null);
    }

    public final boolean canManageThread(User user, Channel channel, Long channelPermissions) {
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(channel, "channel");
        if (channel.getOwnerId() == user.getId() && PermissionUtils.INSTANCE.hasAccessWrite(channel, channelPermissions)) {
            return true;
        }
        return PermissionUtils.can(Permission.MANAGE_THREADS, channelPermissions) && PermissionUtils.INSTANCE.hasAccess(channel, channelPermissions);
    }

    public final boolean canUnarchiveThread(Channel channel, Long channelPermissions) {
        m.checkNotNullParameter(channel, "channel");
        ThreadMetadata threadMetadata = channel.getThreadMetadata();
        if (m.areEqual(threadMetadata != null ? Boolean.valueOf(threadMetadata.getLocked()) : null, Boolean.TRUE)) {
            return PermissionUtils.can(Permission.MANAGE_THREADS, channelPermissions) && PermissionUtils.INSTANCE.hasAccessWrite(channel, channelPermissions);
        }
        return PermissionUtils.INSTANCE.hasAccessWrite(channel, channelPermissions);
    }

    public final boolean canViewAllPrivateThreads(Long channelPermissions) {
        return PermissionUtils.can(Permission.MANAGE_THREADS, channelPermissions) && PermissionUtils.can(Permission.READ_MESSAGE_HISTORY, channelPermissions);
    }

    public final boolean canViewAllPublicArchivedThreads(Channel channel, Long channelPermissions) {
        return channel != null && PermissionUtils.INSTANCE.hasAccess(channel, channelPermissions) && PermissionUtils.can(Permission.READ_MESSAGE_HISTORY, channelPermissions);
    }

    public final long computeThreadAutoArchiveTimeMs(Channel channel) {
        String archiveTimestamp;
        m.checkNotNullParameter(channel, "channel");
        long lastMessageId = (channel.getLastMessageId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH;
        ThreadMetadata threadMetadata = channel.getThreadMetadata();
        int autoArchiveDuration = (threadMetadata != null ? threadMetadata.getAutoArchiveDuration() : 0) * 60 * 1000;
        ThreadMetadata threadMetadata2 = channel.getThreadMetadata();
        return Math.max(lastMessageId, (threadMetadata2 == null || (archiveTimestamp = threadMetadata2.getArchiveTimestamp()) == null) ? 0L : TimeUtils.parseUTCDate(archiveTimestamp)) + ((long) autoArchiveDuration);
    }

    public final int computeThreadNotificationSetting(StoreThreadsJoined$JoinedThread joinedThread, boolean isGuildOrCategoryOrParentMuted, Integer parentNotificationSetting) {
        Integer numValueOf = joinedThread != null ? Integer.valueOf(joinedThread.getFlags()) : null;
        if (numValueOf != null) {
            if ((numValueOf.intValue() & 2) == 0) {
                if ((numValueOf.intValue() & 4) != 0) {
                    return 4;
                }
                if ((numValueOf.intValue() & 8) == 0 && !isGuildOrCategoryOrParentMuted) {
                    int i = ModelNotificationSettings.FREQUENCY_MENTIONS;
                    if (parentNotificationSetting != null && parentNotificationSetting.intValue() == i) {
                        return 4;
                    }
                    int i2 = ModelNotificationSettings.FREQUENCY_NOTHING;
                    if (parentNotificationSetting != null && parentNotificationSetting.intValue() == i2) {
                    }
                }
            }
            return 2;
        }
        return 8;
    }

    public final Observable<Channel> createThread(long parentChannelId, Long parentMessageId, int type, String name, Integer autoArchiveDuration, String location) {
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        RestAPIParams$ThreadCreationSettings restAPIParams$ThreadCreationSettings = new RestAPIParams$ThreadCreationSettings(name, type, autoArchiveDuration);
        return parentMessageId == null ? RestAPI.Companion.getApi().createThread(parentChannelId, location, restAPIParams$ThreadCreationSettings) : RestAPI.Companion.getApi().createThreadFromMessage(parentChannelId, parentMessageId.longValue(), location, restAPIParams$ThreadCreationSettings);
    }

    public final LinkedHashMap<Integer, Integer> getTHREAD_AUTO_ARCHIVE_DURATION_NAMES() {
        return THREAD_AUTO_ARCHIVE_DURATION_NAMES;
    }

    public final long getThreadAckMessageTimestamp(Channel channel, Long l, Long l2, Clock clock) {
        String archiveTimestamp;
        m.checkNotNullParameter(channel, "$this$getThreadAckMessageTimestamp");
        m.checkNotNullParameter(clock, "clock");
        long jLongValue = l != null ? l.longValue() : clock.currentTimeMillis();
        long jLongValue2 = l2 != null ? l2.longValue() - ((long) 5000) : 0L;
        ThreadMetadata threadMetadata = channel.getThreadMetadata();
        long jMax = Math.max(jLongValue2, (threadMetadata == null || (archiveTimestamp = threadMetadata.getArchiveTimestamp()) == null) ? 0L : TimeUtils.parseUTCDate(archiveTimestamp));
        if (jMax == 0) {
            jMax = TimeUtils.parseSnowflake(Long.valueOf(channel.getId()));
        }
        return Math.max(jLongValue, jMax);
    }

    public final void handleThreadCreateError(Context context, Error error, long channelId) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(error, "error");
        Error$Response response = error.getResponse();
        m.checkNotNullExpressionValue(response, "error.response");
        Integer abortCodeMessageResId = RestAPIAbortMessages.getAbortCodeMessageResId(response.getCode());
        Error$Response response2 = error.getResponse();
        m.checkNotNullExpressionValue(response2, "error.response");
        if (response2.getCode() == 20016) {
            Error$Response response3 = error.getResponse();
            m.checkNotNullExpressionValue(response3, "error.response");
            Long retryAfterMs = response3.getRetryAfterMs();
            if (retryAfterMs == null) {
                retryAfterMs = 0L;
            }
            m.checkNotNullExpressionValue(retryAfterMs, "error.response.retryAfterMs ?: 0");
            StoreStream.Companion.getSlowMode().onCooldown(channelId, retryAfterMs.longValue(), StoreSlowMode$Type$ThreadCreate.INSTANCE);
        }
        b.a.d.m.g(context, abortCodeMessageResId != null ? abortCodeMessageResId.intValue() : 2131893169, 0, null, 12);
    }

    public final boolean isThreadModerator(Long channelPermissions) {
        return PermissionUtils.can(Permission.MANAGE_THREADS, channelPermissions);
    }

    public final boolean isThreadsEnabled(long guildId) {
        return ViewThreadsFeatureFlag.Companion.getINSTANCE().isEnabled() && CreateThreadsFeatureFlag.Companion.getINSTANCE().isEnabled(guildId);
    }

    public final Map<Long, Collection<Channel>> sortThreadsForChannelList(Map<Long, ? extends Map<Long, StoreThreadsActiveJoined$ActiveJoinedThread>> threadsMap, Channel selectedChannel) {
        m.checkNotNullParameter(threadsMap, "threadsMap");
        if (!ViewThreadsFeatureFlag.Companion.getINSTANCE().isEnabled()) {
            return h0.emptyMap();
        }
        Map<Long, Collection<Channel>> mapSortThreadsByJoinedDate = sortThreadsByJoinedDate(threadsMap);
        return (selectedChannel == null || !ChannelUtils.H(selectedChannel)) ? mapSortThreadsByJoinedDate : prependSelectedThread(mapSortThreadsByJoinedDate, selectedChannel);
    }
}
