package com.discord.utilities.lazy.subscriptions;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.Ranges2;

/* JADX INFO: compiled from: GuildSubscriptionsManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildSubscriptionsManager {
    private final HashSet<Long> activityGuilds;
    private final GuildChannelSubscriptionsManager guildChannelSubscriptionsManager;
    private final GuildMemberSubscriptionsManager guildMemberSubscriptionsManager;
    private final GuildThreadSubscriptionsManager guildThreadSubscriptionManager;
    private final Function2<Long, GuildSubscriptions, Unit> onChange;
    private final HashMap<Long, GuildSubscriptions> pendingEmissions;
    private final HashSet<Long> subscribedGuilds;
    private final HashSet<Long> threadGuilds;
    private final HashSet<Long> typingGuilds;

    /* JADX WARN: Multi-variable type inference failed */
    public GuildSubscriptionsManager(Function2<? super Long, ? super GuildSubscriptions, Unit> function2) {
        Intrinsics3.checkNotNullParameter(function2, "onChange");
        this.onChange = function2;
        this.typingGuilds = new HashSet<>();
        this.activityGuilds = new HashSet<>();
        this.threadGuilds = new HashSet<>();
        this.guildChannelSubscriptionsManager = new GuildChannelSubscriptionsManager(new GuildSubscriptionsManager2(this));
        this.guildMemberSubscriptionsManager = new GuildMemberSubscriptionsManager(new GuildSubscriptionsManager3(this), new GuildSubscriptionsManager4(this), null, 4, null);
        this.guildThreadSubscriptionManager = new GuildThreadSubscriptionsManager(new GuildSubscriptionsManager5(this));
        this.pendingEmissions = new HashMap<>();
        this.subscribedGuilds = new HashSet<>();
    }

    private final synchronized void handleChannelSubscriptionsChange(long guildId, Map<Long, ? extends List<Ranges2>> channelSubscriptions) {
        GuildSubscriptions guildSubscriptions;
        HashMap<Long, GuildSubscriptions> map = this.pendingEmissions;
        Long lValueOf = Long.valueOf(guildId);
        GuildSubscriptions guildSubscriptions2 = this.pendingEmissions.get(Long.valueOf(guildId));
        if (guildSubscriptions2 == null || (guildSubscriptions = GuildSubscriptions.copy$default(guildSubscriptions2, channelSubscriptions, null, null, null, null, null, 62, null)) == null) {
            guildSubscriptions = new GuildSubscriptions(channelSubscriptions, null, null, null, null, null, 62, null);
        }
        map.put(lValueOf, guildSubscriptions);
    }

    private final synchronized void handleMemberSubscriptionsChange(long guildId, Set<Long> users, boolean forceUpdate) {
        GuildSubscriptions guildSubscriptions;
        HashMap<Long, GuildSubscriptions> map = this.pendingEmissions;
        Long lValueOf = Long.valueOf(guildId);
        GuildSubscriptions guildSubscriptions2 = this.pendingEmissions.get(Long.valueOf(guildId));
        if (guildSubscriptions2 == null || (guildSubscriptions = GuildSubscriptions.copy$default(guildSubscriptions2, null, null, null, users, null, null, 55, null)) == null) {
            guildSubscriptions = new GuildSubscriptions(null, null, null, users, null, null, 55, null);
        }
        map.put(lValueOf, guildSubscriptions);
        if (forceUpdate) {
            flush();
        }
    }

    private final synchronized void handleThreadSubscriptionsChange(long guildId, List<Long> threadSubscriptions) {
        GuildSubscriptions guildSubscriptions;
        HashMap<Long, GuildSubscriptions> map = this.pendingEmissions;
        Long lValueOf = Long.valueOf(guildId);
        GuildSubscriptions guildSubscriptions2 = this.pendingEmissions.get(Long.valueOf(guildId));
        if (guildSubscriptions2 == null || (guildSubscriptions = GuildSubscriptions.copy$default(guildSubscriptions2, null, null, null, null, null, threadSubscriptions, 31, null)) == null) {
            guildSubscriptions = new GuildSubscriptions(null, null, null, null, null, threadSubscriptions, 31, null);
        }
        map.put(lValueOf, guildSubscriptions);
    }

    private final synchronized void requestFlushUnsubscriptions(Function0<Unit> flushUnsubscriptions) {
        flushUnsubscriptions.invoke();
    }

    public final synchronized void flush() {
        for (Map.Entry<Long, GuildSubscriptions> entry : this.pendingEmissions.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            GuildSubscriptions value = entry.getValue();
            this.subscribedGuilds.add(Long.valueOf(jLongValue));
            this.onChange.invoke(Long.valueOf(jLongValue), value);
        }
        this.pendingEmissions.clear();
    }

    public final synchronized GuildSubscriptions get(long guildId) {
        return new GuildSubscriptions(this.guildChannelSubscriptionsManager.get(guildId), Boolean.valueOf(this.typingGuilds.contains(Long.valueOf(guildId))), Boolean.valueOf(this.activityGuilds.contains(Long.valueOf(guildId))), this.guildMemberSubscriptionsManager.get(guildId), Boolean.valueOf(this.threadGuilds.contains(Long.valueOf(guildId))), this.guildThreadSubscriptionManager.get(guildId));
    }

    public final synchronized void queueExistingSubscriptions() {
        Iterator<T> it = this.subscribedGuilds.iterator();
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            this.pendingEmissions.put(Long.valueOf(jLongValue), get(jLongValue));
        }
    }

    public final synchronized void remove(long guildId) {
        this.subscribedGuilds.remove(Long.valueOf(guildId));
        this.pendingEmissions.remove(Long.valueOf(guildId));
        this.typingGuilds.remove(Long.valueOf(guildId));
        this.activityGuilds.remove(Long.valueOf(guildId));
        this.threadGuilds.remove(Long.valueOf(guildId));
        this.guildMemberSubscriptionsManager.remove(guildId);
        this.guildChannelSubscriptionsManager.remove(guildId);
        this.guildThreadSubscriptionManager.remove(guildId);
    }

    public final synchronized void reset() {
        this.subscribedGuilds.clear();
        this.pendingEmissions.clear();
        this.typingGuilds.clear();
        this.activityGuilds.clear();
        this.threadGuilds.clear();
        this.guildChannelSubscriptionsManager.reset();
        this.guildMemberSubscriptionsManager.reset();
        this.guildThreadSubscriptionManager.reset();
    }

    public final synchronized void retainAll(List<Long> guildIds) {
        Intrinsics3.checkNotNullParameter(guildIds, "guildIds");
        this.subscribedGuilds.retainAll(guildIds);
        Iterator<Map.Entry<Long, GuildSubscriptions>> it = this.pendingEmissions.entrySet().iterator();
        while (it.hasNext()) {
            if (!guildIds.contains(Long.valueOf(it.next().getKey().longValue()))) {
                it.remove();
            }
        }
        this.typingGuilds.retainAll(guildIds);
        this.activityGuilds.retainAll(guildIds);
        this.threadGuilds.retainAll(guildIds);
        this.guildChannelSubscriptionsManager.retainAll(guildIds);
        this.guildMemberSubscriptionsManager.retainAll(guildIds);
        this.guildThreadSubscriptionManager.retainAll(guildIds);
    }

    public final synchronized void subscribeActivities(long guildId) {
        GuildSubscriptions guildSubscriptions;
        if (this.activityGuilds.contains(Long.valueOf(guildId))) {
            return;
        }
        this.activityGuilds.add(Long.valueOf(guildId));
        HashMap<Long, GuildSubscriptions> map = this.pendingEmissions;
        Long lValueOf = Long.valueOf(guildId);
        GuildSubscriptions guildSubscriptions2 = this.pendingEmissions.get(Long.valueOf(guildId));
        if (guildSubscriptions2 == null || (guildSubscriptions = GuildSubscriptions.copy$default(guildSubscriptions2, null, null, Boolean.TRUE, null, null, null, 59, null)) == null) {
            guildSubscriptions = new GuildSubscriptions(null, null, Boolean.TRUE, null, null, null, 59, null);
        }
        map.put(lValueOf, guildSubscriptions);
    }

    public final synchronized void subscribeChannel(long guildId, long channelId, List<Ranges2> ranges) {
        Intrinsics3.checkNotNullParameter(ranges, "ranges");
        this.guildChannelSubscriptionsManager.subscribe(guildId, channelId, ranges);
    }

    public final synchronized void subscribeMember(long guildId, long userId) {
        this.guildMemberSubscriptionsManager.subscribe(guildId, userId);
    }

    public final synchronized void subscribeThread(long guildId, long threadId) {
        this.guildThreadSubscriptionManager.subscribe(guildId, threadId);
    }

    public final synchronized void subscribeThreads(long guildId) {
        GuildSubscriptions guildSubscriptions;
        if (this.threadGuilds.contains(Long.valueOf(guildId))) {
            return;
        }
        this.threadGuilds.add(Long.valueOf(guildId));
        HashMap<Long, GuildSubscriptions> map = this.pendingEmissions;
        Long lValueOf = Long.valueOf(guildId);
        GuildSubscriptions guildSubscriptions2 = this.pendingEmissions.get(Long.valueOf(guildId));
        if (guildSubscriptions2 == null || (guildSubscriptions = GuildSubscriptions.copy$default(guildSubscriptions2, null, null, null, null, Boolean.TRUE, null, 47, null)) == null) {
            guildSubscriptions = new GuildSubscriptions(null, null, null, null, Boolean.TRUE, null, 47, null);
        }
        map.put(lValueOf, guildSubscriptions);
    }

    public final synchronized void subscribeTyping(long guildId) {
        GuildSubscriptions guildSubscriptions;
        if (this.typingGuilds.contains(Long.valueOf(guildId))) {
            return;
        }
        this.typingGuilds.add(Long.valueOf(guildId));
        HashMap<Long, GuildSubscriptions> map = this.pendingEmissions;
        Long lValueOf = Long.valueOf(guildId);
        GuildSubscriptions guildSubscriptions2 = this.pendingEmissions.get(Long.valueOf(guildId));
        if (guildSubscriptions2 == null || (guildSubscriptions = GuildSubscriptions.copy$default(guildSubscriptions2, null, Boolean.TRUE, null, null, null, null, 61, null)) == null) {
            guildSubscriptions = new GuildSubscriptions(null, Boolean.TRUE, null, null, null, null, 61, null);
        }
        map.put(lValueOf, guildSubscriptions);
    }

    public final synchronized void unsubscribeMember(long guildId, long userId) {
        this.guildMemberSubscriptionsManager.unsubscribe(guildId, userId);
    }
}
