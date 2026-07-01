package com.discord.stores;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelMessageDelete;
import com.discord.models.domain.ModelPayload;
import com.discord.models.message.Message;
import com.discord.models.thread.dto.ModelThreadListSync;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import d0.d0.f;
import d0.t.h0;
import d0.t.r;
import d0.z.d.m;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreThreadMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreThreadMessages extends StoreV2 {
    public static final StoreThreadMessages$Companion Companion = new StoreThreadMessages$Companion(null);
    public static final int MAX_THREAD_MESSAGE_COUNT = 50;
    private final ObservationDeck observationDeck;
    private final StoreChannels storeChannels;
    private final StoreMessages storeMessages;
    private final Map<Long, StoreThreadMessages$ThreadState> threads;
    private Map<Long, StoreThreadMessages$ThreadState> threadsSnapshot;

    public /* synthetic */ StoreThreadMessages(StoreMessages storeMessages, StoreChannels storeChannels, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeMessages, storeChannels, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ Map access$getThreadsSnapshot$p(StoreThreadMessages storeThreadMessages) {
        return storeThreadMessages.threadsSnapshot;
    }

    public static final /* synthetic */ void access$setThreadsSnapshot$p(StoreThreadMessages storeThreadMessages, Map map) {
        storeThreadMessages.threadsSnapshot = map;
    }

    @StoreThread
    private final void deleteForGuild(long guildId) {
        if (r.removeAll(this.threads.values(), new StoreThreadMessages$deleteForGuild$removed$1(guildId))) {
            markChanged();
        }
    }

    @StoreThread
    private final void deleteForParentChannel(long parentChannelId) {
        if (r.removeAll(this.threads.values(), new StoreThreadMessages$deleteForParentChannel$removed$1(parentChannelId))) {
            markChanged();
        }
    }

    @StoreThread
    private final StoreThreadMessages$ThreadState getOrAddState(Channel thread) {
        StoreThreadMessages$ThreadState storeThreadMessages$ThreadState = (StoreThreadMessages$ThreadState) a.d(thread, this.threads);
        if (storeThreadMessages$ThreadState == null) {
            long id2 = thread.getId();
            long guildId = thread.getGuildId();
            long parentId = thread.getParentId();
            Integer messageCount = thread.getMessageCount();
            storeThreadMessages$ThreadState = new StoreThreadMessages$ThreadState(id2, guildId, parentId, messageCount != null ? messageCount.intValue() : 0, null);
            this.threads.put(Long.valueOf(thread.getId()), storeThreadMessages$ThreadState);
            markChanged();
        }
        return storeThreadMessages$ThreadState;
    }

    @StoreThread
    private final void updateFromGuild(Guild guild) {
        List<Channel> listN = guild.N();
        if (listN != null) {
            Iterator<T> it = listN.iterator();
            while (it.hasNext()) {
                updateFromThread((Channel) it.next());
            }
        }
    }

    @StoreThread
    private final void updateFromThread(Channel thread) {
        StoreThreadMessages$ThreadState orAddState = getOrAddState(thread);
        Integer messageCount = thread.getMessageCount();
        if (messageCount != null) {
            this.threads.put(Long.valueOf(thread.getId()), StoreThreadMessages$ThreadState.copy$default(orAddState, 0L, 0L, 0L, messageCount.intValue(), null, 23, null));
            markChanged();
        }
        if (thread.getLastMessageId() != 0) {
            Message mostRecentMessage = orAddState.getMostRecentMessage();
            if (mostRecentMessage == null || mostRecentMessage.getId() != thread.getLastMessageId()) {
                this.threads.put(Long.valueOf(thread.getId()), StoreThreadMessages$ThreadState.copy$default(orAddState, 0L, 0L, 0L, 0, null, 15, null));
                markChanged();
            }
        }
    }

    public final Integer getThreadMessageCount(long channelId) {
        StoreThreadMessages$ThreadState storeThreadMessages$ThreadState = this.threadsSnapshot.get(Long.valueOf(channelId));
        if (storeThreadMessages$ThreadState != null) {
            return Integer.valueOf(storeThreadMessages$ThreadState.getCount());
        }
        return null;
    }

    @StoreThread
    public final void handleChannelDelete(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        deleteForParentChannel(channel.getId());
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        List<Guild> guilds = payload.getGuilds();
        m.checkNotNullExpressionValue(guilds, "payload.guilds");
        Iterator<T> it = guilds.iterator();
        while (it.hasNext()) {
            updateFromGuild((Guild) it.next());
        }
    }

    @StoreThread
    public final void handleGuildCreate(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        updateFromGuild(guild);
    }

    @StoreThread
    public final void handleGuildDelete(long guildId) {
        deleteForGuild(guildId);
    }

    @StoreThread
    public final void handleMessageCreate(com.discord.api.message.Message message) {
        m.checkNotNullParameter(message, "message");
        Channel channel = this.storeChannels.getChannel(message.getChannelId());
        if (channel == null || !ChannelUtils.H(channel)) {
            return;
        }
        StoreThreadMessages$ThreadState orAddState = getOrAddState(channel);
        this.threads.put(Long.valueOf(channel.getId()), StoreThreadMessages$ThreadState.copy$default(orAddState, 0L, 0L, 0L, f.coerceAtMost(orAddState.getCount() + 1, 50), new Message(message), 7, null));
        markChanged();
    }

    @StoreThread
    public final void handleMessageDelete(ModelMessageDelete messageDeleteBulk) {
        Message mostRecentMessage;
        m.checkNotNullParameter(messageDeleteBulk, "messageDeleteBulk");
        StoreThreadMessages$ThreadState storeThreadMessages$ThreadState = this.threads.get(Long.valueOf(messageDeleteBulk.getChannelId()));
        Long lValueOf = (storeThreadMessages$ThreadState == null || (mostRecentMessage = storeThreadMessages$ThreadState.getMostRecentMessage()) == null) ? null : Long.valueOf(mostRecentMessage.getId());
        if (lValueOf != null) {
            lValueOf.longValue();
            Iterator<Long> it = messageDeleteBulk.getMessageIds().iterator();
            while (it.hasNext()) {
                if (!(!m.areEqual(lValueOf, it.next()))) {
                    this.threads.put(Long.valueOf(messageDeleteBulk.getChannelId()), StoreThreadMessages$ThreadState.copy$default(storeThreadMessages$ThreadState, 0L, 0L, 0L, 0, null, 15, null));
                    markChanged();
                    return;
                }
            }
        }
    }

    @StoreThread
    public final void handleMessageUpdate(com.discord.api.message.Message message) {
        Message mostRecentMessage;
        m.checkNotNullParameter(message, "message");
        StoreThreadMessages$ThreadState storeThreadMessages$ThreadState = this.threads.get(Long.valueOf(message.getChannelId()));
        if (storeThreadMessages$ThreadState == null || (mostRecentMessage = storeThreadMessages$ThreadState.getMostRecentMessage()) == null || mostRecentMessage.getId() != message.getId()) {
            return;
        }
        this.threads.put(Long.valueOf(message.getChannelId()), StoreThreadMessages$ThreadState.copy$default(storeThreadMessages$ThreadState, 0L, 0L, 0L, 0, this.storeMessages.getMessage(message.getChannelId(), message.getId()), 15, null));
        markChanged();
    }

    @StoreThread
    public final void handleMessagesLoaded(StoreMessagesLoader$ChannelChunk chunk) {
        Channel channel;
        Channel channel2;
        m.checkNotNullParameter(chunk, "chunk");
        boolean z2 = false;
        boolean z3 = false;
        for (Message message : chunk.getMessages()) {
            if (message.hasThread() && !this.threads.containsKey(Long.valueOf(message.getId())) && (channel2 = this.storeChannels.getThreadsByIdInternal$app_productionGoogleRelease().get(Long.valueOf(message.getId()))) != null) {
                updateFromThread(channel2);
                z3 = true;
            }
        }
        if (z3) {
            markChanged();
        }
        if (chunk.isPresent() && (channel = this.storeChannels.getThreadsByIdInternal$app_productionGoogleRelease().get(Long.valueOf(chunk.getChannelId()))) != null && ChannelUtils.H(channel)) {
            StoreThreadMessages$ThreadState orAddState = getOrAddState(channel);
            if (chunk.getMessages().isEmpty()) {
                this.threads.put(Long.valueOf(channel.getId()), StoreThreadMessages$ThreadState.copy$default(orAddState, 0L, 0L, 0L, 0, null, 7, null));
            } else {
                Message message2 = this.storeMessages.getMessage(chunk.getChannelId(), chunk.getMessages().get(0).getId());
                int size = chunk.getMessages().size();
                List<Message> messages = chunk.getMessages();
                if (!(messages instanceof Collection) || !messages.isEmpty()) {
                    Iterator<T> it = messages.iterator();
                    while (it.hasNext()) {
                        Integer type = ((Message) it.next()).getType();
                        if (type != null && type.intValue() == 21) {
                            z2 = true;
                            break;
                        }
                    }
                }
                if (z2) {
                    size--;
                }
                Integer type2 = message2 != null ? message2.getType() : null;
                this.threads.put(Long.valueOf(channel.getId()), StoreThreadMessages$ThreadState.copy$default(orAddState, 0L, 0L, 0L, f.coerceAtMost(size, 50), (type2 != null && type2.intValue() == 21) ? null : message2, 7, null));
            }
            markChanged();
        }
    }

    @StoreThread
    public final void handleThreadCreateOrUpdate(Channel thread) {
        m.checkNotNullParameter(thread, "thread");
        updateFromThread(thread);
    }

    @StoreThread
    public final void handleThreadDelete(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        if (this.threads.containsKey(Long.valueOf(channel.getId()))) {
            this.threads.remove(Long.valueOf(channel.getId()));
            markChanged();
        }
    }

    @StoreThread
    public final void handleThreadListSync(ModelThreadListSync threadListSync) {
        m.checkNotNullParameter(threadListSync, "threadListSync");
        Iterator<T> it = threadListSync.getThreads().iterator();
        while (it.hasNext()) {
            updateFromThread((Channel) it.next());
        }
        List<com.discord.api.message.Message> mostRecentMessages = threadListSync.getMostRecentMessages();
        if (mostRecentMessages != null) {
            for (com.discord.api.message.Message message : mostRecentMessages) {
                StoreThreadMessages$ThreadState storeThreadMessages$ThreadState = this.threads.get(Long.valueOf(message.getChannelId()));
                if (storeThreadMessages$ThreadState != null) {
                    this.threads.put(Long.valueOf(message.getChannelId()), StoreThreadMessages$ThreadState.copy$default(storeThreadMessages$ThreadState, 0L, 0L, 0L, 0, new Message(message), 15, null));
                }
            }
        }
    }

    public final Observable<Map<Long, StoreThreadMessages$ThreadState>> observeThreadCountAndLatestMessage() {
        Observable<Map<Long, StoreThreadMessages$ThreadState>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreThreadMessages$observeThreadCountAndLatestMessage$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        this.threadsSnapshot = new HashMap(this.threads);
    }

    public StoreThreadMessages(StoreMessages storeMessages, StoreChannels storeChannels, ObservationDeck observationDeck) {
        m.checkNotNullParameter(storeMessages, "storeMessages");
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeMessages = storeMessages;
        this.storeChannels = storeChannels;
        this.observationDeck = observationDeck;
        this.threads = new HashMap();
        this.threadsSnapshot = h0.emptyMap();
    }

    public final Observable<StoreThreadMessages$ThreadState> observeThreadCountAndLatestMessage(long channelId) {
        Observable<StoreThreadMessages$ThreadState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreThreadMessages$observeThreadCountAndLatestMessage$2(this, channelId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }
}
