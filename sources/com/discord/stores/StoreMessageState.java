package com.discord.stores;

import com.discord.api.message.Message;
import com.discord.models.domain.ModelMessageDelete;
import d0.o;
import d0.t.h0;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StoreMessageState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageState {
    private final Dispatcher dispatcher;
    private final BehaviorSubject<Map<Long, StoreMessageState$State>> messageStateSubject;

    public StoreMessageState(Dispatcher dispatcher) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        BehaviorSubject<Map<Long, StoreMessageState$State>> behaviorSubjectL0 = BehaviorSubject.l0(h0.emptyMap());
        m.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(emptyMap())");
        this.messageStateSubject = behaviorSubjectL0;
    }

    public static final /* synthetic */ void access$updateState(StoreMessageState storeMessageState, long j, Function1 function1) {
        storeMessageState.updateState(j, function1);
    }

    @StoreThread
    private final void resetState(List<Long> messagesList) {
        Map<Long, StoreMessageState$State> mapN0 = this.messageStateSubject.n0();
        ArrayList arrayList = new ArrayList();
        for (Object obj : messagesList) {
            long jLongValue = ((Number) obj).longValue();
            m.checkNotNullExpressionValue(mapN0, "messageStateMap");
            if (mapN0.containsKey(Long.valueOf(jLongValue))) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        BehaviorSubject<Map<Long, StoreMessageState$State>> behaviorSubject = this.messageStateSubject;
        m.checkNotNullExpressionValue(mapN0, "messageStateMap");
        behaviorSubject.onNext(h0.minus((Map) mapN0, (Iterable) arrayList));
    }

    @StoreThread
    private final void updateState(long messageId, Function1<? super StoreMessageState$State, StoreMessageState$State> updateFunction) {
        Map<Long, StoreMessageState$State> mapN0 = this.messageStateSubject.n0();
        StoreMessageState$State storeMessageState$State = mapN0.get(Long.valueOf(messageId));
        if (storeMessageState$State == null) {
            storeMessageState$State = new StoreMessageState$State(null, null, 3, null);
        }
        StoreMessageState$State storeMessageState$StateInvoke = updateFunction.invoke(storeMessageState$State);
        BehaviorSubject<Map<Long, StoreMessageState$State>> behaviorSubject = this.messageStateSubject;
        m.checkNotNullExpressionValue(mapN0, "messageStateMap");
        behaviorSubject.onNext(h0.plus(mapN0, o.to(Long.valueOf(messageId), storeMessageState$StateInvoke)));
    }

    public final Observable<Map<Long, StoreMessageState$State>> getMessageState() {
        Observable<Map<Long, StoreMessageState$State>> observableR = this.messageStateSubject.r();
        m.checkNotNullExpressionValue(observableR, "messageStateSubject.distinctUntilChanged()");
        return observableR;
    }

    @StoreThread
    public final void handleChannelSelected() {
        this.messageStateSubject.onNext(h0.emptyMap());
    }

    @StoreThread
    public final void handleMessageDelete(ModelMessageDelete messageDelete) {
        m.checkNotNullParameter(messageDelete, "messageDelete");
        List<Long> messageIds = messageDelete.getMessageIds();
        m.checkNotNullExpressionValue(messageIds, "messageDelete.messageIds");
        resetState(messageIds);
    }

    @StoreThread
    public final void handleMessageUpdate(Message message) {
        m.checkNotNullParameter(message, "message");
        resetState(d0.t.m.listOf(Long.valueOf(message.getId())));
    }

    public final void revealSpoiler(long messageId, int spoilerIndex) {
        if (spoilerIndex < 0) {
            return;
        }
        this.dispatcher.schedule(new StoreMessageState$revealSpoiler$1(this, messageId, spoilerIndex));
    }

    public final void revealSpoilerEmbed(long messageId, int spoilerEmbedIndex) {
        if (spoilerEmbedIndex < 0) {
            return;
        }
        this.dispatcher.schedule(new StoreMessageState$revealSpoilerEmbed$1(this, messageId, spoilerEmbedIndex));
    }

    public final void revealSpoilerEmbedData(long messageId, int spoilerEmbedIndex, String key) {
        m.checkNotNullParameter(key, "key");
        if (spoilerEmbedIndex < 0) {
            return;
        }
        this.dispatcher.schedule(new StoreMessageState$revealSpoilerEmbedData$1(this, messageId, spoilerEmbedIndex, key));
    }
}
