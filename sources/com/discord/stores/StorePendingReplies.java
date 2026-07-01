package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelMessageDelete;
import com.discord.models.message.Message;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.collections.SnowflakePartitionMap$CopiablePartitionMap;
import d0.t.h0;
import d0.z.d.m;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StorePendingReplies.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StorePendingReplies extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final SnowflakePartitionMap$CopiablePartitionMap<StorePendingReplies$PendingReply> pendingReplies;
    private Map<Long, StorePendingReplies$PendingReply> pendingRepliesSnapshot;

    public /* synthetic */ StorePendingReplies(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ SnowflakePartitionMap$CopiablePartitionMap access$getPendingReplies$p(StorePendingReplies storePendingReplies) {
        return storePendingReplies.pendingReplies;
    }

    public static /* synthetic */ void onCreatePendingReply$default(StorePendingReplies storePendingReplies, Channel channel, Message message, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = true;
        }
        if ((i & 8) != 0) {
            z3 = true;
        }
        storePendingReplies.onCreatePendingReply(channel, message, z2, z3);
    }

    public final StorePendingReplies$PendingReply getPendingReply(long channelId) {
        return this.pendingRepliesSnapshot.get(Long.valueOf(channelId));
    }

    @StoreThread
    public final void handleMessageDelete(ModelMessageDelete messageDeleteBulk) {
        m.checkNotNullParameter(messageDeleteBulk, "messageDeleteBulk");
        StorePendingReplies$PendingReply storePendingReplies$PendingReply = this.pendingReplies.get(Long.valueOf(messageDeleteBulk.getChannelId()));
        if (storePendingReplies$PendingReply == null || !messageDeleteBulk.getMessageIds().contains(storePendingReplies$PendingReply.getMessageReference().getMessageId())) {
            return;
        }
        this.pendingReplies.remove(Long.valueOf(messageDeleteBulk.getChannelId()));
        markChanged();
    }

    @StoreThread
    public final void handlePreLogout() {
        this.pendingReplies.clear();
        markChanged();
    }

    public final Observable<StorePendingReplies$PendingReply> observePendingReply(long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StorePendingReplies$observePendingReply$1(this, channelId), 14, null);
    }

    public final void onCreatePendingReply(Channel channel, Message message, boolean shouldMention, boolean showMentionToggle) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(message, "message");
        this.dispatcher.schedule(new StorePendingReplies$onCreatePendingReply$1(this, channel, message, shouldMention, showMentionToggle));
    }

    public final void onDeletePendingReply(long channelId) {
        this.dispatcher.schedule(new StorePendingReplies$onDeletePendingReply$1(this, channelId));
    }

    public final void onSetPendingReplyShouldMention(long channelId, boolean shouldMention) {
        this.dispatcher.schedule(new StorePendingReplies$onSetPendingReplyShouldMention$1(this, channelId, shouldMention));
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        this.pendingRepliesSnapshot = this.pendingReplies.fastCopy();
    }

    public StorePendingReplies(Dispatcher dispatcher, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.pendingReplies = new SnowflakePartitionMap$CopiablePartitionMap<>(0, 1, null);
        this.pendingRepliesSnapshot = h0.emptyMap();
    }
}
