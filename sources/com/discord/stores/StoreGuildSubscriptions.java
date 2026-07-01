package com.discord.stores;

import com.discord.utilities.lazy.subscriptions.GuildSubscriptionsManager;
import d0.t.n;
import d0.z.d.m;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: StoreGuildSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildSubscriptions extends StoreV2 {
    private final Dispatcher dispatcher;
    private final StoreStream storeStream;
    private final GuildSubscriptionsManager subscriptionsManager;

    public StoreGuildSubscriptions(StoreStream storeStream, Dispatcher dispatcher) {
        m.checkNotNullParameter(storeStream, "storeStream");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        this.storeStream = storeStream;
        this.dispatcher = dispatcher;
        this.subscriptionsManager = new GuildSubscriptionsManager(new StoreGuildSubscriptions$subscriptionsManager$1(this));
    }

    public static final /* synthetic */ StoreStream access$getStoreStream$p(StoreGuildSubscriptions storeGuildSubscriptions) {
        return storeGuildSubscriptions.storeStream;
    }

    public static final /* synthetic */ GuildSubscriptionsManager access$getSubscriptionsManager$p(StoreGuildSubscriptions storeGuildSubscriptions) {
        return storeGuildSubscriptions.subscriptionsManager;
    }

    @StoreThread
    public final void handleConnectionReady(boolean isConnectionReady) {
        if (!isConnectionReady) {
            this.subscriptionsManager.retainAll(n.listOf((Object[]) new Long[]{Long.valueOf(this.storeStream.getGuildSelected().getSelectedGuildId()), Long.valueOf(this.storeStream.getRtcConnection().getConnectedGuildId())}));
            markChanged();
            return;
        }
        long selectedGuildId = this.storeStream.getGuildSelected().getSelectedGuildId();
        if (selectedGuildId > 0) {
            handleGuildSelect(selectedGuildId);
        }
        this.subscriptionsManager.queueExistingSubscriptions();
        markChanged();
    }

    @StoreThread
    public final void handleGuildRemove(long guildId) {
        this.subscriptionsManager.remove(guildId);
        markChanged();
    }

    @StoreThread
    public final void handleGuildSelect(long guildId) {
        if (guildId <= 0) {
            return;
        }
        this.subscriptionsManager.subscribeTyping(guildId);
        this.subscriptionsManager.subscribeActivities(guildId);
        this.subscriptionsManager.subscribeThreads(guildId);
        markChanged();
    }

    @StoreThread
    public final void handlePreLogout() {
        this.subscriptionsManager.reset();
        markChanged();
    }

    @StoreThread
    public final void handleSubscribeMember(long guildId, long userId) {
        if (guildId <= 0) {
            return;
        }
        this.subscriptionsManager.subscribeMember(guildId, userId);
        markChanged();
    }

    @StoreThread
    public final void handleUnsubscribeMember(long guildId, long userId) {
        if (guildId <= 0) {
            return;
        }
        this.subscriptionsManager.unsubscribeMember(guildId, userId);
        markChanged();
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.subscriptionsManager.flush();
    }

    public final void subscribeChannelRange(long guildId, long channelId, IntRange range) {
        m.checkNotNullParameter(range, "range");
        if (guildId <= 0 || channelId <= 0) {
            return;
        }
        this.dispatcher.schedule(new StoreGuildSubscriptions$subscribeChannelRange$1(this, range, guildId, channelId));
    }

    public final void subscribeThread(long guildId, long channelId) {
        if (guildId <= 0 || channelId <= 0) {
            return;
        }
        this.dispatcher.schedule(new StoreGuildSubscriptions$subscribeThread$1(this, guildId, channelId));
    }

    public final void subscribeUser(long guildId, long userId) {
        this.dispatcher.schedule(new StoreGuildSubscriptions$subscribeUser$1(this, guildId, userId));
    }

    public final void unsubscribeUser(long guildId, long userId) {
        this.dispatcher.schedule(new StoreGuildSubscriptions$unsubscribeUser$1(this, guildId, userId));
    }
}
