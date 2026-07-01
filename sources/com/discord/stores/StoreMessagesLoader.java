package com.discord.stores;

import android.content.Context;
import b.a.d.o;
import com.discord.app.AppLog;
import com.discord.models.message.Message;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import d0.t.n0;
import d0.z.d.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: StoreMessagesLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessagesLoader extends Store {
    public static final StoreMessagesLoader$Companion Companion = new StoreMessagesLoader$Companion(null);
    public static final long SCROLL_TO_LAST_UNREAD = 0;
    public static final long SCROLL_TO_LATEST = 1;
    private boolean authed;
    private boolean backgrounded;
    private final SerializedSubject<Map<Long, StoreMessagesLoader$ChannelLoadedState>, Map<Long, StoreMessagesLoader$ChannelLoadedState>> channelLoadedStateSubject;
    private final HashMap<Long, StoreMessagesLoader$ChannelLoadedState> channelLoadedStates;
    private final SerializedSubject<StoreMessagesLoader$ChannelChunk, StoreMessagesLoader$ChannelChunk> channelMessageChunksSubject;
    private final SerializedSubject<Boolean, Boolean> channelMessagesLoadingSubject;
    private Subscription delayLoadingMessagesSubscription;
    private Set<Long> detachedChannels;
    private final Dispatcher dispatcher;
    private boolean hasConnected;
    private StoreChat$InteractionState interactionState;
    private final long loadingMessagesRetryDelayDefault;
    private long loadingMessagesRetryDelayMillis;
    private final int loadingMessagesRetryJitter;
    private int loadingMessagesRetryMax;
    private Subscription loadingMessagesSubscription;
    private final int messageRequestSize;
    private final SerializedSubject<Long, Long> scrollToSubject;
    private long selectedChannelId;
    private final StoreStream stream;

    public StoreMessagesLoader(StoreStream storeStream, Dispatcher dispatcher) {
        m.checkNotNullParameter(storeStream, "stream");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.messageRequestSize = 50;
        this.channelMessageChunksSubject = new SerializedSubject<>(BehaviorSubject.k0());
        HashMap<Long, StoreMessagesLoader$ChannelLoadedState> map = new HashMap<>();
        this.channelLoadedStates = map;
        this.channelLoadedStateSubject = new SerializedSubject<>(BehaviorSubject.l0(new HashMap(map)));
        this.scrollToSubject = new SerializedSubject<>(BehaviorSubject.l0(null));
        this.channelMessagesLoadingSubject = new SerializedSubject<>(BehaviorSubject.l0(Boolean.FALSE));
        this.detachedChannels = n0.emptySet();
        this.backgrounded = true;
        this.loadingMessagesRetryDelayDefault = 1500L;
        this.loadingMessagesRetryJitter = 2000;
        this.loadingMessagesRetryDelayMillis = 1500L;
        this.loadingMessagesRetryMax = 30000;
    }

    public static final /* synthetic */ void access$channelLoadedStateUpdate(StoreMessagesLoader storeMessagesLoader, long j, Function1 function1) {
        storeMessagesLoader.channelLoadedStateUpdate(j, function1);
    }

    public static final /* synthetic */ SerializedSubject access$getChannelMessagesLoadingSubject$p(StoreMessagesLoader storeMessagesLoader) {
        return storeMessagesLoader.channelMessagesLoadingSubject;
    }

    public static final /* synthetic */ Subscription access$getDelayLoadingMessagesSubscription$p(StoreMessagesLoader storeMessagesLoader) {
        return storeMessagesLoader.delayLoadingMessagesSubscription;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreMessagesLoader storeMessagesLoader) {
        return storeMessagesLoader.dispatcher;
    }

    public static final /* synthetic */ Subscription access$getLoadingMessagesSubscription$p(StoreMessagesLoader storeMessagesLoader) {
        return storeMessagesLoader.loadingMessagesSubscription;
    }

    public static final /* synthetic */ int access$getMessageRequestSize$p(StoreMessagesLoader storeMessagesLoader) {
        return storeMessagesLoader.messageRequestSize;
    }

    public static final /* synthetic */ SerializedSubject access$getScrollToSubject$p(StoreMessagesLoader storeMessagesLoader) {
        return storeMessagesLoader.scrollToSubject;
    }

    public static final /* synthetic */ long access$getSelectedChannelId$p(StoreMessagesLoader storeMessagesLoader) {
        return storeMessagesLoader.selectedChannelId;
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreMessagesLoader storeMessagesLoader) {
        return storeMessagesLoader.stream;
    }

    public static final /* synthetic */ void access$handleChatDetached(StoreMessagesLoader storeMessagesLoader, Set set) {
        storeMessagesLoader.handleChatDetached(set);
    }

    public static final /* synthetic */ void access$handleChatInteraction(StoreMessagesLoader storeMessagesLoader, StoreChat$InteractionState storeChat$InteractionState) {
        storeMessagesLoader.handleChatInteraction(storeChat$InteractionState);
    }

    public static final /* synthetic */ void access$handleLoadMessagesError(StoreMessagesLoader storeMessagesLoader, long j) {
        storeMessagesLoader.handleLoadMessagesError(j);
    }

    public static final /* synthetic */ void access$handleLoadedMessages(StoreMessagesLoader storeMessagesLoader, List list, long j, long j2, Long l, Long l2) {
        storeMessagesLoader.handleLoadedMessages(list, j, j2, l, l2);
    }

    public static final /* synthetic */ void access$setDelayLoadingMessagesSubscription$p(StoreMessagesLoader storeMessagesLoader, Subscription subscription) {
        storeMessagesLoader.delayLoadingMessagesSubscription = subscription;
    }

    public static final /* synthetic */ void access$setLoadingMessagesSubscription$p(StoreMessagesLoader storeMessagesLoader, Subscription subscription) {
        storeMessagesLoader.loadingMessagesSubscription = subscription;
    }

    public static final /* synthetic */ void access$setSelectedChannelId$p(StoreMessagesLoader storeMessagesLoader, long j) {
        storeMessagesLoader.selectedChannelId = j;
    }

    private final synchronized void channelLoadedStateUpdate(long channelId, Function1<? super StoreMessagesLoader$ChannelLoadedState, StoreMessagesLoader$ChannelLoadedState> updater) {
        StoreMessagesLoader$ChannelLoadedState storeMessagesLoader$ChannelLoadedState = this.channelLoadedStates.get(Long.valueOf(channelId));
        if (storeMessagesLoader$ChannelLoadedState == null) {
            storeMessagesLoader$ChannelLoadedState = new StoreMessagesLoader$ChannelLoadedState(false, false, false, false, null, 31, null);
        }
        m.checkNotNullExpressionValue(storeMessagesLoader$ChannelLoadedState, "channelLoadedStates[chan…] ?: ChannelLoadedState()");
        this.channelLoadedStates.put(Long.valueOf(channelId), updater.invoke(storeMessagesLoader$ChannelLoadedState));
        SerializedSubject<Map<Long, StoreMessagesLoader$ChannelLoadedState>, Map<Long, StoreMessagesLoader$ChannelLoadedState>> serializedSubject = this.channelLoadedStateSubject;
        serializedSubject.k.onNext(new HashMap(this.channelLoadedStates));
    }

    private final void channelLoadedStatesReset() {
        this.channelLoadedStates.clear();
        SerializedSubject<Map<Long, StoreMessagesLoader$ChannelLoadedState>, Map<Long, StoreMessagesLoader$ChannelLoadedState>> serializedSubject = this.channelLoadedStateSubject;
        serializedSubject.k.onNext(new HashMap(this.channelLoadedStates));
        Subscription subscription = this.loadingMessagesSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.loadingMessagesRetryDelayMillis = this.loadingMessagesRetryDelayDefault;
        log("Disconnected, resetting all message loaded states.");
    }

    private final synchronized void handleChatDetached(Set<Long> detachedChannels) {
        this.detachedChannels = detachedChannels;
        log("Loaded detached channel state: " + detachedChannels);
        tryLoadMessages$default(this, 0L, false, true, false, null, null, 59, null);
    }

    private final synchronized void handleChatInteraction(StoreChat$InteractionState interactionState) {
        channelLoadedStateUpdate(interactionState.getChannelId(), new StoreMessagesLoader$handleChatInteraction$1$1(interactionState));
        this.interactionState = interactionState;
        tryLoadMessages$default(this, 0L, false, true, false, null, null, 59, null);
    }

    private final synchronized void handleLoadMessagesError(long channelId) {
        channelLoadedStateUpdate(channelId, StoreMessagesLoader$handleLoadMessagesError$1.INSTANCE);
        long j = this.loadingMessagesRetryDelayMillis;
        if (j < this.loadingMessagesRetryMax) {
            this.loadingMessagesRetryDelayMillis = (j * ((long) 2)) + ((long) new Random().nextInt(this.loadingMessagesRetryJitter));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to load messages for channel [" + channelId + "], ");
        sb.append("retrying in " + this.loadingMessagesRetryDelayMillis + "ms");
        String string = sb.toString();
        m.checkNotNullExpressionValue(string, "StringBuilder()\n        …}ms\")\n        .toString()");
        log(string);
        tryLoadMessages$default(this, this.loadingMessagesRetryDelayMillis, false, false, false, null, null, 58, null);
    }

    private final synchronized void handleLoadedMessages(List<Message> messages, long channelId, long messageId, Long before, Long after) {
        Object next;
        boolean z2 = messages.size() < this.messageRequestSize;
        boolean z3 = after != null;
        boolean z4 = before != null;
        boolean z5 = !Companion.isScrollToAction(messageId);
        boolean z6 = (z5 || z3 || z4) ? false : true;
        boolean z7 = z6 || (z3 && z2);
        channelLoadedStateUpdate(channelId, new StoreMessagesLoader$handleLoadedMessages$1(this, z6, z4, z2, messages));
        this.channelMessagesLoadingSubject.k.onNext(Boolean.FALSE);
        this.channelMessageChunksSubject.k.onNext(new StoreMessagesLoader$ChannelChunk(channelId, messages, z6, z7, z4, z5));
        boolean z8 = z6 && (messages.isEmpty() ^ true) && messageId == 1;
        if (z8) {
            this.scrollToSubject.k.onNext(1L);
        } else if (z6) {
            this.scrollToSubject.k.onNext(0L);
        }
        if (z5) {
            Iterator<T> it = messages.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(((Message) next).getId() == messageId));
            Message message = (Message) next;
            if (message == null) {
                StoreStream.Companion.getReadStates().markAsRead(Long.valueOf(channelId));
            } else {
                this.scrollToSubject.k.onNext(Long.valueOf(message.getId()));
            }
        }
        if (!z5 && !z8) {
            clearScrollTo();
        }
        log("Loaded " + messages.size() + " messages for channel [" + channelId + "], all loaded: " + z2 + '.');
        tryLoadMessages$default(this, this.loadingMessagesRetryDelayDefault, false, false, false, null, null, 58, null);
    }

    public static /* synthetic */ void handleLoadedMessages$default(StoreMessagesLoader storeMessagesLoader, List list, long j, long j2, Long l, Long l2, int i, Object obj) {
        storeMessagesLoader.handleLoadedMessages(list, j, (i & 4) != 0 ? 0L : j2, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : l2);
    }

    private final void log(String message) {
        AppLog.i("[MessageLoader] " + message);
    }

    private final synchronized void tryLoadMessages(long delay, boolean force, boolean resetRetry, boolean resetDelay, Long targetChannelId, Long targetMessageId) {
        try {
            long jLongValue = targetChannelId != null ? targetChannelId.longValue() : this.selectedChannelId;
            Subscription subscription = this.delayLoadingMessagesSubscription;
            if (subscription != null && resetDelay) {
                if (subscription != null) {
                    subscription.unsubscribe();
                }
                this.delayLoadingMessagesSubscription = null;
            }
            if (this.delayLoadingMessagesSubscription == null || force) {
                if (delay > 0) {
                    Observable<Long> observableD0 = Observable.d0(delay, TimeUnit.MILLISECONDS);
                    m.checkNotNullExpressionValue(observableD0, "Observable\n          .ti…y, TimeUnit.MILLISECONDS)");
                    ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(observableD0), getClass(), (Context) null, new StoreMessagesLoader$tryLoadMessages$2(this), (Function1) null, (Function0) null, (Function0) null, new StoreMessagesLoader$tryLoadMessages$1(this), 58, (Object) null);
                    return;
                }
                if (resetRetry) {
                    this.loadingMessagesRetryDelayMillis = this.loadingMessagesRetryDelayDefault;
                }
                StoreMessagesLoader$ChannelLoadedState storeMessagesLoader$ChannelLoadedState = this.channelLoadedStates.get(Long.valueOf(jLongValue));
                if (storeMessagesLoader$ChannelLoadedState == null || !storeMessagesLoader$ChannelLoadedState.isLoadingMessages() || force) {
                    Subscription subscription2 = this.loadingMessagesSubscription;
                    if (subscription2 != null) {
                        subscription2.unsubscribe();
                    }
                    if (jLongValue > 0 && !this.backgrounded && this.authed) {
                        StoreMessagesLoader$tryLoadMessages$3 storeMessagesLoader$tryLoadMessages$3 = new StoreMessagesLoader$tryLoadMessages$3(this);
                        StoreMessagesLoader$tryLoadMessages$4 storeMessagesLoader$tryLoadMessages$4 = new StoreMessagesLoader$tryLoadMessages$4(this, storeMessagesLoader$tryLoadMessages$3);
                        if (targetMessageId != null) {
                            StoreMessagesLoader$tryLoadMessages$3.invoke$default(storeMessagesLoader$tryLoadMessages$3, jLongValue, targetMessageId, null, null, 12, null);
                        } else if (storeMessagesLoader$ChannelLoadedState == null || !storeMessagesLoader$ChannelLoadedState.isInitialMessagesLoaded()) {
                            StoreMessagesLoader$tryLoadMessages$3.invoke$default(storeMessagesLoader$tryLoadMessages$3, jLongValue, 0L, null, null, 12, null);
                        } else {
                            this.channelMessagesLoadingSubject.k.onNext(Boolean.FALSE);
                            StoreChat$InteractionState storeChat$InteractionState = this.interactionState;
                            if (storeChat$InteractionState != null) {
                                boolean z2 = false;
                                boolean z3 = storeChat$InteractionState.getIsAtTop() && !storeMessagesLoader$ChannelLoadedState.isOldestMessagesLoaded();
                                if (storeChat$InteractionState.getIsAtBottom() && this.detachedChannels.contains(Long.valueOf(jLongValue))) {
                                    z2 = true;
                                }
                                if (storeChat$InteractionState.getChannelId() == jLongValue && (z3 || z2)) {
                                    channelLoadedStateUpdate(jLongValue, StoreMessagesLoader$tryLoadMessages$5$1.INSTANCE);
                                    ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(ObservableExtensionsKt.takeSingleUntilTimeout$default(this.stream.getMessages().observeMessagesForChannel(jLongValue), 0L, false, 3, null)), storeChat$InteractionState.getClass(), (Context) null, (Function1) null, new StoreMessagesLoader$tryLoadMessages$$inlined$apply$lambda$2(this, storeMessagesLoader$ChannelLoadedState, jLongValue, storeMessagesLoader$tryLoadMessages$4), (Function0) null, (Function0) null, new StoreMessagesLoader$tryLoadMessages$$inlined$apply$lambda$1(z3, z2, this, storeMessagesLoader$ChannelLoadedState, jLongValue, storeMessagesLoader$tryLoadMessages$4), 54, (Object) null);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static /* synthetic */ void tryLoadMessages$default(StoreMessagesLoader storeMessagesLoader, long j, boolean z2, boolean z3, boolean z4, Long l, Long l2, int i, Object obj) {
        storeMessagesLoader.tryLoadMessages((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) == 0 ? z4 : false, (i & 16) != 0 ? null : l, (i & 32) == 0 ? l2 : null);
    }

    public final void clearScrollTo() {
        this.scrollToSubject.k.onNext(null);
    }

    public final Observable<StoreMessagesLoader$ChannelChunk> get() {
        return ObservableExtensionsKt.computationBuffered(this.channelMessageChunksSubject);
    }

    public final Observable<StoreMessagesLoader$ChannelLoadedState> getMessagesLoadedState(long channelId) {
        Observable<R> observableG = this.channelLoadedStateSubject.G(new StoreMessagesLoader$getMessagesLoadedState$1(channelId));
        m.checkNotNullExpressionValue(observableG, "channelLoadedStateSubjec…?: ChannelLoadedState() }");
        Observable<StoreMessagesLoader$ChannelLoadedState> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
        m.checkNotNullExpressionValue(observableR, "channelLoadedStateSubjec…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Long> getScrollTo() {
        Observable<R> observableG = this.scrollToSubject.y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        return ObservableExtensionsKt.computationLatest(observableG);
    }

    public final synchronized void handleAuthToken(String authToken) {
        this.authed = authToken != null;
        tryLoadMessages$default(this, 0L, false, true, false, null, null, 59, null);
    }

    public final synchronized void handleBackgrounded(boolean backgrounded) {
        this.backgrounded = backgrounded;
        tryLoadMessages$default(this, 0L, false, true, false, null, null, 59, null);
    }

    @StoreThread
    public final synchronized void handleChannelSelected(long selectedChannelId) {
        channelLoadedStateUpdate(this.selectedChannelId, StoreMessagesLoader$handleChannelSelected$1.INSTANCE);
        this.selectedChannelId = selectedChannelId;
        tryLoadMessages$default(this, 0L, true, true, false, null, null, 57, null);
    }

    public final synchronized void handleConnected(boolean connected) {
        try {
            if (connected) {
                this.hasConnected = true;
            } else if (this.hasConnected) {
                channelLoadedStatesReset();
            }
            tryLoadMessages$default(this, 0L, false, true, this.hasConnected, null, null, 51, null);
        } catch (Throwable th) {
            throw th;
        }
    }

    @StoreThread
    public final synchronized void handleVoiceChannelJoined(long selectedVoiceChannelId) {
        tryLoadMessages$default(this, 0L, true, true, false, Long.valueOf(selectedVoiceChannelId), null, 41, null);
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        m.checkNotNullParameter(context, "context");
        super.init(context);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(this.stream.getChat().observeInteractionState()), StoreMessagesLoader.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreMessagesLoader$init$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(this.stream.getMessages().getAllDetached(), StoreMessagesLoader.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreMessagesLoader$init$2(this), 62, (Object) null);
    }

    public final synchronized void jumpToMessage(long channelId, long messageId) {
        if (messageId <= 0) {
            return;
        }
        StoreMessagesLoader$jumpToMessage$1 storeMessagesLoader$jumpToMessage$1 = new StoreMessagesLoader$jumpToMessage$1(this, channelId, messageId);
        StoreMessagesLoader$jumpToMessage$2 storeMessagesLoader$jumpToMessage$2 = new StoreMessagesLoader$jumpToMessage$2(this, channelId);
        Observable observableY = this.stream.getChannelsSelected().observeId().k(o.c(new StoreMessagesLoader$jumpToMessage$3(channelId), -1L, 1000L, TimeUnit.MILLISECONDS)).Y(new StoreMessagesLoader$jumpToMessage$4(this, channelId, messageId));
        m.checkNotNullExpressionValue(observableY, "stream\n        .channels…lId, messageId)\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 0L, false, 3, null)), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreMessagesLoader$jumpToMessage$5(this, storeMessagesLoader$jumpToMessage$1), 62, (Object) null);
        Observable observableA = StoreConnectionOpen.observeConnectionOpen$default(this.stream.getConnectionOpen(), false, 1, null).Z(1).A(new StoreMessagesLoader$jumpToMessage$6(this, channelId));
        m.checkNotNullExpressionValue(observableA, "stream\n        .connecti…mes.ONE_SECOND)\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(observableA), getClass(), (Context) null, (Function1) null, StoreMessagesLoader$jumpToMessage$7.INSTANCE, (Function0) null, (Function0) null, new StoreMessagesLoader$jumpToMessage$8(storeMessagesLoader$jumpToMessage$2), 54, (Object) null);
    }

    public final Observable<Boolean> observeChannelMessagesLoading() {
        Observable<Boolean> observableR = ObservableExtensionsKt.computationBuffered(this.channelMessagesLoadingSubject).r();
        m.checkNotNullExpressionValue(observableR, "channelMessagesLoadingSu…  .distinctUntilChanged()");
        return observableR;
    }

    public final synchronized void requestNewestMessages() {
        StoreMessagesLoader$ChannelLoadedState storeMessagesLoader$ChannelLoadedState;
        if (!this.detachedChannels.contains(Long.valueOf(this.selectedChannelId)) && (storeMessagesLoader$ChannelLoadedState = this.channelLoadedStates.get(Long.valueOf(this.selectedChannelId))) != null && storeMessagesLoader$ChannelLoadedState.isInitialMessagesLoaded()) {
            this.scrollToSubject.k.onNext(1L);
        } else {
            channelLoadedStateUpdate(this.selectedChannelId, StoreMessagesLoader$requestNewestMessages$1.INSTANCE);
            tryLoadMessages$default(this, 0L, true, false, false, null, 1L, 25, null);
        }
    }
}
