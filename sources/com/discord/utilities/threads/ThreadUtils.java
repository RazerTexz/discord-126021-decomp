package com.discord.utilities.threads;

import android.content.Context;
import b.a.d.AppToast;
import com.discord.R;
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
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreSlowMode;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadsActiveJoined;
import com.discord.stores.StoreThreadsJoined;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.chat.list.CreateThreadsFeatureFlag;
import com.discord.widgets.chat.list.NewThreadsPermissionsFeatureFlag;
import com.discord.widgets.chat.list.ViewThreadsFeatureFlag;
import d0.Tuples;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t._CollectionsJvm;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import rx.Observable;

/* JADX INFO: compiled from: ThreadUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ThreadUtils {
    public static final int DEFAULT_AUTO_ARCHIVE_DURATION = 1440;
    public static final int MAX_DISPLAYED_THREAD_BROWSER_ICON_COUNT = 99;
    public static final ThreadUtils INSTANCE = new ThreadUtils();
    private static final LinkedHashMap<Integer, Integer> THREAD_AUTO_ARCHIVE_DURATION_NAMES = Maps6.linkedMapOf(Tuples.to(60, Integer.valueOf(R.string.auto_archive_duration_1_hour)), Tuples.to(1440, Integer.valueOf(R.string.auto_archive_duration_24_hours)), Tuples.to(Integer.valueOf(ThreadArchiveDurations.THREE_DAYS_IN_MINUTES), Integer.valueOf(R.string.auto_archive_duration_3_days)), Tuples.to(Integer.valueOf(ThreadArchiveDurations.SEVEN_DAYS_IN_MINUTES), Integer.valueOf(R.string.auto_archive_duration_1_week)));

    /* JADX INFO: compiled from: ThreadUtils.kt */
    public static final class ThreadArchiveDurations {
        public static final ThreadArchiveDurations INSTANCE = new ThreadArchiveDurations();
        public static final int ONE_DAY_IN_MINUTES = 1440;
        public static final int ONE_HOUR_IN_MINUTES = 60;
        public static final int SEVEN_DAYS_IN_MINUTES = 10080;
        public static final int THREE_DAYS_IN_MINUTES = 4320;

        private ThreadArchiveDurations() {
        }
    }

    private ThreadUtils() {
    }

    public static /* synthetic */ boolean canCreatePrivateThread$default(ThreadUtils threadUtils, Long l, Channel channel, Guild guild, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = true;
        }
        return threadUtils.canCreatePrivateThread(l, channel, guild, z2);
    }

    public static /* synthetic */ long getThreadAckMessageTimestamp$default(ThreadUtils threadUtils, Channel channel, Long l, Long l2, Clock clock, int i, Object obj) {
        if ((i & 4) != 0) {
            clock = ClockFactory.get();
        }
        return threadUtils.getThreadAckMessageTimestamp(channel, l, l2, clock);
    }

    private final Comparator<StoreThreadsActiveJoined.ActiveJoinedThread> getThreadTimestampComparator() {
        return new Comparator<StoreThreadsActiveJoined.ActiveJoinedThread>() { // from class: com.discord.utilities.threads.ThreadUtils.getThreadTimestampComparator.1
            @Override // java.util.Comparator
            public final int compare(StoreThreadsActiveJoined.ActiveJoinedThread activeJoinedThread, StoreThreadsActiveJoined.ActiveJoinedThread activeJoinedThread2) {
                return (activeJoinedThread2.getJoinTimestamp().getDateTimeMillis() > activeJoinedThread.getJoinTimestamp().getDateTimeMillis() ? 1 : (activeJoinedThread2.getJoinTimestamp().getDateTimeMillis() == activeJoinedThread.getJoinTimestamp().getDateTimeMillis() ? 0 : -1));
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Map<Long, Collection<Channel>> prependSelectedThread(Map<Long, ? extends Collection<Channel>> sortedThreadsMap, Channel selectedThread) {
        boolean z2;
        Collection collectionEmptyList = (Collection) sortedThreadsMap.get(Long.valueOf(selectedThread.getParentId()));
        if (collectionEmptyList == null) {
            collectionEmptyList = Collections2.emptyList();
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
        Map<Long, Collection<Channel>> mutableMap = Maps6.toMutableMap(sortedThreadsMap);
        Long lValueOf = Long.valueOf(selectedThread.getParentId());
        List listMutableListOf = Collections2.mutableListOf(selectedThread);
        listMutableListOf.addAll(collectionEmptyList);
        mutableMap.put(lValueOf, listMutableListOf);
        return mutableMap;
    }

    private final Map<Long, Collection<Channel>> sortThreadsByJoinedDate(Map<Long, ? extends Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>> threadsMap) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(threadsMap.size()));
        Iterator<T> it = threadsMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            SortedSet sortedSet = _CollectionsJvm.toSortedSet(((Map) entry.getValue()).values(), INSTANCE.getThreadTimestampComparator());
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(sortedSet, 10));
            Iterator it2 = sortedSet.iterator();
            while (it2.hasNext()) {
                arrayList.add(((StoreThreadsActiveJoined.ActiveJoinedThread) it2.next()).getChannel());
            }
            linkedHashMap.put(key, arrayList);
        }
        return linkedHashMap;
    }

    public final String autoArchiveDurationName(Context context, int minutes) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Integer num = THREAD_AUTO_ARCHIVE_DURATION_NAMES.get(Integer.valueOf(minutes));
        if (num != null) {
            Intrinsics3.checkNotNullExpressionValue(num, "it");
            String string = context.getString(num.intValue());
            if (string != null) {
                return string;
            }
        }
        String quantityString = context.getResources().getQuantityString(R.plurals.duration_hours_hours, minutes / 60);
        Intrinsics3.checkNotNullExpressionValue(quantityString, "context.resources.getQua…ours_hours, minutes / 60)");
        return quantityString;
    }

    public final boolean canCreatePrivateThread(Long parentChannelPermissions, Channel parentChannel, Guild guild, boolean checkGuildFeature) {
        if (guild == null || parentChannel == null) {
            return false;
        }
        boolean zHasAccessWrite = PermissionUtils.INSTANCE.hasAccessWrite(parentChannel, parentChannelPermissions);
        boolean zCan = PermissionUtils.can(Permission.CREATE_PRIVATE_THREADS, parentChannelPermissions);
        if (!NewThreadsPermissionsFeatureFlag.INSTANCE.getINSTANCE().isEnabled(guild.getId())) {
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
        return isThreadsEnabled(guild.getId()) && (!NewThreadsPermissionsFeatureFlag.INSTANCE.getINSTANCE().isEnabled(guild.getId()) ? !(!zHasAccessWrite || !zCan || !z2) : !(!zCan || !z2)) && ((message == null || !message.isSystemMessage()) && !ChannelUtils.H(parentChannel) && ((message == null || !message.hasThread()) && !ChannelUtils.J(parentChannel)));
    }

    public final boolean canCreateThread(Long parentChannelPermissions, Channel parentChannel, Message message, Guild guild) {
        return canCreatePublicThread(parentChannelPermissions, parentChannel, message, guild) || canCreatePrivateThread$default(this, parentChannelPermissions, parentChannel, guild, false, 8, null);
    }

    public final boolean canManageThread(User user, Channel channel, Long channelPermissions) {
        Intrinsics3.checkNotNullParameter(user, "user");
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (channel.getOwnerId() == user.getId() && PermissionUtils.INSTANCE.hasAccessWrite(channel, channelPermissions)) {
            return true;
        }
        return PermissionUtils.can(Permission.MANAGE_THREADS, channelPermissions) && PermissionUtils.INSTANCE.hasAccess(channel, channelPermissions);
    }

    public final boolean canUnarchiveThread(Channel channel, Long channelPermissions) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        ThreadMetadata threadMetadata = channel.getThreadMetadata();
        if (Intrinsics3.areEqual(threadMetadata != null ? Boolean.valueOf(threadMetadata.getLocked()) : null, Boolean.TRUE)) {
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
        Intrinsics3.checkNotNullParameter(channel, "channel");
        long lastMessageId = (channel.getLastMessageId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH;
        ThreadMetadata threadMetadata = channel.getThreadMetadata();
        int autoArchiveDuration = (threadMetadata != null ? threadMetadata.getAutoArchiveDuration() : 0) * 60 * 1000;
        ThreadMetadata threadMetadata2 = channel.getThreadMetadata();
        return Math.max(lastMessageId, (threadMetadata2 == null || (archiveTimestamp = threadMetadata2.getArchiveTimestamp()) == null) ? 0L : TimeUtils.parseUTCDate(archiveTimestamp)) + ((long) autoArchiveDuration);
    }

    public final int computeThreadNotificationSetting(StoreThreadsJoined.JoinedThread joinedThread, boolean isGuildOrCategoryOrParentMuted, Integer parentNotificationSetting) {
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
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        RestAPIParams.ThreadCreationSettings threadCreationSettings = new RestAPIParams.ThreadCreationSettings(name, type, autoArchiveDuration);
        return parentMessageId == null ? RestAPI.INSTANCE.getApi().createThread(parentChannelId, location, threadCreationSettings) : RestAPI.INSTANCE.getApi().createThreadFromMessage(parentChannelId, parentMessageId.longValue(), location, threadCreationSettings);
    }

    public final LinkedHashMap<Integer, Integer> getTHREAD_AUTO_ARCHIVE_DURATION_NAMES() {
        return THREAD_AUTO_ARCHIVE_DURATION_NAMES;
    }

    public final long getThreadAckMessageTimestamp(Channel channel, Long l, Long l2, Clock clock) {
        String archiveTimestamp;
        Intrinsics3.checkNotNullParameter(channel, "$this$getThreadAckMessageTimestamp");
        Intrinsics3.checkNotNullParameter(clock, "clock");
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
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(error, "error");
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "error.response");
        Integer abortCodeMessageResId = RestAPIAbortMessages.getAbortCodeMessageResId(response.getCode());
        Error.Response response2 = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response2, "error.response");
        if (response2.getCode() == 20016) {
            Error.Response response3 = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response3, "error.response");
            Long retryAfterMs = response3.getRetryAfterMs();
            if (retryAfterMs == null) {
                retryAfterMs = 0L;
            }
            Intrinsics3.checkNotNullExpressionValue(retryAfterMs, "error.response.retryAfterMs ?: 0");
            StoreStream.INSTANCE.getSlowMode().onCooldown(channelId, retryAfterMs.longValue(), StoreSlowMode.Type.ThreadCreate.INSTANCE);
        }
        AppToast.g(context, abortCodeMessageResId != null ? abortCodeMessageResId.intValue() : R.string.network_error_bad_request, 0, null, 12);
    }

    public final boolean isThreadModerator(Long channelPermissions) {
        return PermissionUtils.can(Permission.MANAGE_THREADS, channelPermissions);
    }

    public final boolean isThreadsEnabled(long guildId) {
        return ViewThreadsFeatureFlag.INSTANCE.getINSTANCE().isEnabled() && CreateThreadsFeatureFlag.INSTANCE.getINSTANCE().isEnabled(guildId);
    }

    public final Map<Long, Collection<Channel>> sortThreadsForChannelList(Map<Long, ? extends Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>> threadsMap, Channel selectedChannel) {
        Intrinsics3.checkNotNullParameter(threadsMap, "threadsMap");
        if (!ViewThreadsFeatureFlag.INSTANCE.getINSTANCE().isEnabled()) {
            return Maps6.emptyMap();
        }
        Map<Long, Collection<Channel>> mapSortThreadsByJoinedDate = sortThreadsByJoinedDate(threadsMap);
        return (selectedChannel == null || !ChannelUtils.H(selectedChannel)) ? mapSortThreadsByJoinedDate : prependSelectedThread(mapSortThreadsByJoinedDate, selectedChannel);
    }
}
