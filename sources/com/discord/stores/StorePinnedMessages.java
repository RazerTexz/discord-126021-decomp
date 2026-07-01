package com.discord.stores;

import android.content.Context;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.message.Message;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: StorePinnedMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StorePinnedMessages extends StoreV2 {
    public static final StorePinnedMessages$Companion Companion = new StorePinnedMessages$Companion(null);
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final Map<Long, List<Message>> pinnedMessages;
    private Map<Long, ? extends List<Message>> pinnedMessagesSnapshot;
    private final Set<Long> updatedChannelIds;

    public StorePinnedMessages(Dispatcher dispatcher, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.pinnedMessages = new HashMap();
        this.pinnedMessagesSnapshot = new HashMap();
        this.updatedChannelIds = new HashSet();
    }

    public static final /* synthetic */ Map access$getPinnedMessages$p(StorePinnedMessages storePinnedMessages) {
        return storePinnedMessages.pinnedMessages;
    }

    public static final /* synthetic */ void access$handlePinnedMessagesLoaded(StorePinnedMessages storePinnedMessages, long j, List list) {
        storePinnedMessages.handlePinnedMessagesLoaded(j, list);
    }

    @StoreThread
    private final void handlePinnedMessagesLoaded(long channelId, List<Message> messages) {
        this.pinnedMessages.put(Long.valueOf(channelId), u.toMutableList((Collection) messages));
        this.updatedChannelIds.add(Long.valueOf(channelId));
        markChanged();
    }

    private final void loadPinnedMessages(long channelId) {
        if (this.pinnedMessagesSnapshot.containsKey(Long.valueOf(channelId))) {
            return;
        }
        Observable observableG = ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().getChannelPins(channelId), false, 1, null).G(StorePinnedMessages$loadPinnedMessages$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "api\n        .getChannelP…messages.map(::Message) }");
        ObservableExtensionsKt.appSubscribe$default(observableG, StorePinnedMessages.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StorePinnedMessages$loadPinnedMessages$2(this, channelId), 62, (Object) null);
    }

    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final ObservationDeck getObservationDeck() {
        return this.observationDeck;
    }

    @StoreThread
    public final void handleMessageDeleteBulk(long channelId, Collection<Long> messageIds) {
        m.checkNotNullParameter(messageIds, "messageIds");
        List<Message> list = this.pinnedMessages.get(Long.valueOf(channelId));
        if (list != null) {
            Iterator<Message> it = list.iterator();
            while (it.hasNext()) {
                if (messageIds.contains(Long.valueOf(it.next().getId()))) {
                    it.remove();
                    this.updatedChannelIds.add(Long.valueOf(channelId));
                }
            }
            if (!this.updatedChannelIds.isEmpty()) {
                markChanged();
            }
        }
    }

    @StoreThread
    public final void handleMessageUpdate(com.discord.api.message.Message updatedMessage) {
        UtcDateTime timestamp;
        m.checkNotNullParameter(updatedMessage, "updatedMessage");
        long channelId = updatedMessage.getChannelId();
        long id2 = updatedMessage.getId();
        boolean zAreEqual = m.areEqual(updatedMessage.getPinned(), Boolean.TRUE);
        List<Message> list = this.pinnedMessages.get(Long.valueOf(channelId));
        if (list != null) {
            int iAccess$getMessageIndex = StorePinnedMessages$Companion.access$getMessageIndex(Companion, list, id2);
            if (iAccess$getMessageIndex != -1) {
                if (zAreEqual) {
                    list.set(iAccess$getMessageIndex, list.get(iAccess$getMessageIndex).merge(updatedMessage));
                } else {
                    list.remove(iAccess$getMessageIndex);
                }
                this.updatedChannelIds.add(Long.valueOf(channelId));
                markChanged();
                return;
            }
            if (zAreEqual) {
                UtcDateTime timestamp2 = updatedMessage.getTimestamp();
                long dateTimeMillis = 0;
                long dateTimeMillis2 = timestamp2 != null ? timestamp2.getDateTimeMillis() : 0L;
                int i = 0;
                if (list.size() > 0 && (timestamp = list.get(0).getTimestamp()) != null) {
                    dateTimeMillis = timestamp.getDateTimeMillis();
                }
                while (i < list.size() && dateTimeMillis2 < dateTimeMillis) {
                    i++;
                }
                list.add(i, new Message(updatedMessage));
                this.updatedChannelIds.add(Long.valueOf(channelId));
                markChanged();
            }
        }
    }

    public final Observable<List<Message>> observeForChannel(long channelId) {
        loadPinnedMessages(channelId);
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StorePinnedMessages$observeForChannel$1(this, channelId), 14, null);
    }

    public final Observable<Message> observePinnedMessage(long channelId, long messageId) {
        Observable<Message> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StorePinnedMessages$observePinnedMessage$1(this, channelId, messageId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        HashMap map = new HashMap(this.pinnedMessages);
        Iterator<Long> it = this.updatedChannelIds.iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            Long lValueOf = Long.valueOf(jLongValue);
            List listEmptyList = (List) map.get(Long.valueOf(jLongValue));
            if (listEmptyList == null) {
                listEmptyList = n.emptyList();
            }
            map.put(lValueOf, new ArrayList(listEmptyList));
        }
        this.pinnedMessagesSnapshot = map;
        this.updatedChannelIds.clear();
    }
}
