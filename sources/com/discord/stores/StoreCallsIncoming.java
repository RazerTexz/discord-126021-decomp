package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelCall;
import com.discord.stores.updates.ObservationDeck;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.HashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.Observable;

/* JADX INFO: compiled from: StoreCallsIncoming.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCallsIncoming extends StoreV2 {
    private final Dispatcher dispatcher;
    private Set<Long> incomingCallSnapshot;
    private final Set<Long> incomingCalls;
    private final ObservationDeck observationDeck;
    private final StoreUser userStore;

    /* JADX INFO: renamed from: com.discord.stores.StoreCallsIncoming$observeIncoming$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreCallsIncoming.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Set<? extends Long>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Set<? extends Long> invoke() {
            return StoreCallsIncoming.this.getIncomingCalls();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreCallsIncoming$removeIncomingCall$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreCallsIncoming.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreCallsIncoming.this.clearIncomingCall(this.$channelId);
        }
    }

    public StoreCallsIncoming(Dispatcher dispatcher, ObservationDeck observationDeck, StoreUser storeUser) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.userStore = storeUser;
        this.incomingCalls = new HashSet();
        this.incomingCallSnapshot = new HashSet();
    }

    @Store3
    private final void clearIncomingCall(long channelId) {
        if (this.incomingCalls.contains(Long.valueOf(channelId))) {
            this.incomingCalls.remove(Long.valueOf(channelId));
            markChanged();
        }
    }

    public final Set<Long> getIncomingCalls() {
        return this.incomingCallSnapshot;
    }

    @Store3
    public final void handleCallCreateOrUpdate(ModelCall call) {
        Intrinsics3.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
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

    @Store3
    public final void handleCallDelete(ModelCall callDelete) {
        Intrinsics3.checkNotNullParameter(callDelete, "callDelete");
        clearIncomingCall(callDelete.getChannelId());
    }

    @Store3
    public final void handleVoiceChannelSelected(long channelId) {
        clearIncomingCall(channelId);
    }

    public final Observable<Boolean> observeHasIncoming() {
        Observable<Boolean> observableR = observeIncoming().G(new Func1<Set<? extends Long>, Boolean>() { // from class: com.discord.stores.StoreCallsIncoming.observeHasIncoming.1
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Boolean call(Set<? extends Long> set) {
                return call2((Set<Long>) set);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(Set<Long> set) {
                Intrinsics3.checkNotNullExpressionValue(set, "incomingCalls");
                return Boolean.valueOf(!set.isEmpty());
            }
        }).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeIncoming()\n      …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Set<Long>> observeIncoming() {
        Observable<Set<Long>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final void removeIncomingCall(long channelId) {
        this.dispatcher.schedule(new AnonymousClass1(channelId));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.incomingCallSnapshot = new HashSet(this.incomingCalls);
    }
}
