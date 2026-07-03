package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelCall;
import com.discord.stores.updates.ObservationDeck;
import java.util.HashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;

/* JADX INFO: compiled from: StoreCallsIncoming.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCallsIncoming extends StoreV2 {
    private final Dispatcher dispatcher;
    private Set<Long> incomingCallSnapshot;
    private final Set<Long> incomingCalls;
    private final ObservationDeck observationDeck;
    private final StoreUser userStore;

    /* JADX INFO: renamed from: com.discord.stores.StoreCallsIncoming$observeIncoming$1 */
    /* JADX INFO: compiled from: StoreCallsIncoming.kt */
    public static final class C58061 extends AbstractC12240o implements Function0<Set<? extends Long>> {
        public C58061() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Set<? extends Long> invoke() {
            return StoreCallsIncoming.this.getIncomingCalls();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreCallsIncoming$removeIncomingCall$1 */
    /* JADX INFO: compiled from: StoreCallsIncoming.kt */
    public static final class C58071 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58071(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreCallsIncoming.this.clearIncomingCall(this.$channelId);
        }
    }

    public StoreCallsIncoming(Dispatcher dispatcher, ObservationDeck observationDeck, StoreUser storeUser) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(storeUser, "userStore");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.userStore = storeUser;
        this.incomingCalls = new HashSet();
        this.incomingCallSnapshot = new HashSet();
    }

    @StoreThread
    private final void clearIncomingCall(long channelId) {
        if (this.incomingCalls.contains(Long.valueOf(channelId))) {
            this.incomingCalls.remove(Long.valueOf(channelId));
            markChanged();
        }
    }

    public final Set<Long> getIncomingCalls() {
        return this.incomingCallSnapshot;
    }

    @StoreThread
    public final void handleCallCreateOrUpdate(ModelCall call) {
        C12238m.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        long channelId = call.getChannelId();
        if (!call.getRinging().contains(Long.valueOf(this.userStore.getMeSnapshot().getId()))) {
            clearIncomingCall(channelId);
        } else {
            if (this.incomingCalls.contains(Long.valueOf(channelId))) {
                return;
            }
            this.incomingCalls.add(Long.valueOf(channelId));
            markChanged();
        }
    }

    @StoreThread
    public final void handleCallDelete(ModelCall callDelete) {
        C12238m.checkNotNullParameter(callDelete, "callDelete");
        clearIncomingCall(callDelete.getChannelId());
    }

    @StoreThread
    public final void handleVoiceChannelSelected(long channelId) {
        clearIncomingCall(channelId);
    }

    public final Observable<Boolean> observeHasIncoming() {
        Observable<Boolean> observableM11112r = observeIncoming().m11083G(new InterfaceC12589b<Set<? extends Long>, Boolean>() { // from class: com.discord.stores.StoreCallsIncoming.observeHasIncoming.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Boolean call(Set<? extends Long> set) {
                return call2((Set<Long>) set);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(Set<Long> set) {
                C12238m.checkNotNullExpressionValue(set, "incomingCalls");
                return Boolean.valueOf(!set.isEmpty());
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observeIncoming()\n      …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Set<Long>> observeIncoming() {
        Observable<Set<Long>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C58061(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck\n        …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final void removeIncomingCall(long channelId) {
        this.dispatcher.schedule(new C58071(channelId));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.incomingCallSnapshot = new HashSet(this.incomingCalls);
    }
}
