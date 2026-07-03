package com.discord.stores;

import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.message.Message;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: StorePinnedMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StorePinnedMessages extends StoreV2 {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final Map<Long, List<Message>> pinnedMessages;
    private Map<Long, ? extends List<Message>> pinnedMessagesSnapshot;
    private final Set<Long> updatedChannelIds;

    /* JADX INFO: compiled from: StorePinnedMessages.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Message getMessage(List<Message> channelMessages, long messageId) {
            Object obj = null;
            if (channelMessages == null) {
                return null;
            }
            for (Object obj2 : channelMessages) {
                if (((Message) obj2).getId() == messageId) {
                    obj = obj2;
                    break;
                }
            }
            return (Message) obj;
        }

        private final int getMessageIndex(List<Message> channelPinnedMessages, long messageId) {
            Iterator<Message> it = channelPinnedMessages.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (it.next().getId() == messageId) {
                    return i;
                }
                i++;
            }
            return -1;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StorePinnedMessages$loadPinnedMessages$2 */
    /* JADX INFO: compiled from: StorePinnedMessages.kt */
    public static final class C63372 extends AbstractC12240o implements Function1<List<? extends Message>, Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX INFO: renamed from: com.discord.stores.StorePinnedMessages$loadPinnedMessages$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StorePinnedMessages.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ List $it;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$it = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C63372 c63372 = C63372.this;
                StorePinnedMessages storePinnedMessages = StorePinnedMessages.this;
                long j = c63372.$channelId;
                List list = this.$it;
                C12238m.checkNotNullExpressionValue(list, "it");
                storePinnedMessages.handlePinnedMessagesLoaded(j, list);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C63372(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Message> list) {
            invoke2((List<Message>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Message> list) {
            StorePinnedMessages.this.getDispatcher().schedule(new AnonymousClass1(list));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StorePinnedMessages$observeForChannel$1 */
    /* JADX INFO: compiled from: StorePinnedMessages.kt */
    public static final class C63381 extends AbstractC12240o implements Function0<List<? extends Message>> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C63381(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends Message> invoke() {
            List<? extends Message> list = (List) StorePinnedMessages.this.pinnedMessages.get(Long.valueOf(this.$channelId));
            return list != null ? list : C12147n.emptyList();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StorePinnedMessages$observePinnedMessage$1 */
    /* JADX INFO: compiled from: StorePinnedMessages.kt */
    public static final class C63391 extends AbstractC12240o implements Function0<Message> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $messageId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C63391(long j, long j2) {
            super(0);
            this.$channelId = j;
            this.$messageId = j2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Message invoke() {
            List listEmptyList = (List) StorePinnedMessages.this.pinnedMessages.get(Long.valueOf(this.$channelId));
            if (listEmptyList == null) {
                listEmptyList = C12147n.emptyList();
            }
            return StorePinnedMessages.INSTANCE.getMessage(listEmptyList, this.$messageId);
        }
    }

    public StorePinnedMessages(Dispatcher dispatcher, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.pinnedMessages = new HashMap();
        this.pinnedMessagesSnapshot = new HashMap();
        this.updatedChannelIds = new HashSet();
    }

    @StoreThread
    private final void handlePinnedMessagesLoaded(long channelId, List<Message> messages) {
        this.pinnedMessages.put(Long.valueOf(channelId), C12163u.toMutableList((Collection) messages));
        this.updatedChannelIds.add(Long.valueOf(channelId));
        markChanged();
    }

    private final void loadPinnedMessages(long channelId) {
        if (this.pinnedMessagesSnapshot.containsKey(Long.valueOf(channelId))) {
            return;
        }
        Observable observableM11083G = ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getChannelPins(channelId), false, 1, null).m11083G(new InterfaceC12589b<List<? extends com.discord.api.message.Message>, List<? extends Message>>() { // from class: com.discord.stores.StorePinnedMessages.loadPinnedMessages.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ List<? extends Message> call(List<? extends com.discord.api.message.Message> list) {
                return call2((List<com.discord.api.message.Message>) list);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final List<Message> call2(List<com.discord.api.message.Message> list) {
                C12238m.checkNotNullExpressionValue(list, "messages");
                ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new Message((com.discord.api.message.Message) it.next()));
                }
                return arrayList;
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "api\n        .getChannelP…messages.map(::Message) }");
        ObservableExtensionsKt.appSubscribe(observableM11083G, (Class<?>) StorePinnedMessages.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C63372(channelId));
    }

    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final ObservationDeck getObservationDeck() {
        return this.observationDeck;
    }

    @StoreThread
    public final void handleMessageDeleteBulk(long channelId, Collection<Long> messageIds) {
        C12238m.checkNotNullParameter(messageIds, "messageIds");
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
        C12238m.checkNotNullParameter(updatedMessage, "updatedMessage");
        long channelId = updatedMessage.getChannelId();
        long id2 = updatedMessage.getId();
        boolean zAreEqual = C12238m.areEqual(updatedMessage.getPinned(), Boolean.TRUE);
        List<Message> list = this.pinnedMessages.get(Long.valueOf(channelId));
        if (list != null) {
            int messageIndex = INSTANCE.getMessageIndex(list, id2);
            if (messageIndex != -1) {
                if (zAreEqual) {
                    list.set(messageIndex, list.get(messageIndex).merge(updatedMessage));
                } else {
                    list.remove(messageIndex);
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
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C63381(channelId), 14, null);
    }

    public final Observable<Message> observePinnedMessage(long channelId, long messageId) {
        Observable<Message> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C63391(channelId, messageId), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
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
                listEmptyList = C12147n.emptyList();
            }
            map.put(lValueOf, new ArrayList(listEmptyList));
        }
        this.pinnedMessagesSnapshot = map;
        this.updatedChannelIds.clear();
    }
}
