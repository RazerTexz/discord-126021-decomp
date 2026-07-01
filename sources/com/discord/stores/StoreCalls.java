package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import b.a.d.o;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.voice.state.VoiceState;
import com.discord.app.AppComponent;
import com.discord.models.domain.ModelCall;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.voice.call.WidgetCallFailed;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: StoreCalls.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCalls {
    private final HashMap<Long, ModelCall> calls;
    private final SerializedSubject<HashMap<Long, ModelCall>, HashMap<Long, ModelCall>> callsSubject;
    private boolean connectionReady;
    private long selectedChannelId;
    private long selectedGuildId;
    private final StoreStream stream;

    /* JADX INFO: renamed from: com.discord.stores.StoreCalls$call$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreCalls.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            StoreCalls.this.stream.getVoiceChannelSelected().selectVoiceChannel(this.$channelId);
            if (z2) {
                StoreCalls.ring$default(StoreCalls.this, this.$channelId, null, 2, null);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreCalls$call$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreCalls.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ AppComponent $appComponent;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ AnonymousClass1 $doCall$1;
        public final /* synthetic */ FragmentManager $fragmentManager;
        public final /* synthetic */ Function0 $onError;

        /* JADX INFO: renamed from: com.discord.stores.StoreCalls$call$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreCalls.kt */
        public static final class C00962 extends Lambda implements Function1<Boolean, Unit> {
            public C00962() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                AnonymousClass1 anonymousClass1 = AnonymousClass2.this.$doCall$1;
                Intrinsics3.checkNotNullExpressionValue(bool, "isRingable");
                anonymousClass1.invoke(bool.booleanValue());
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreCalls$call$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: StoreCalls.kt */
        public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
            public final /* synthetic */ long $userId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(long j) {
                super(1);
                this.$userId = j;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "error");
                Function0 function0 = AnonymousClass2.this.$onError;
                if (function0 != null) {
                }
                Error.Response response = error.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "error.response");
                if (response.getCode() == 50013) {
                    error.setShowErrorToasts(false);
                    WidgetCallFailed.INSTANCE.show(AnonymousClass2.this.$fragmentManager, this.$userId);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j, AppComponent appComponent, Context context, AnonymousClass1 anonymousClass1, Function0 function0, FragmentManager fragmentManager) {
            super(1);
            this.$channelId = j;
            this.$appComponent = appComponent;
            this.$context = context;
            this.$doCall$1 = anonymousClass1;
            this.$onError = function0;
            this.$fragmentManager = fragmentManager;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            Observable<R> observableA = StoreStream.INSTANCE.getUserRelationships().observe(j).A(new Func1<Integer, Observable<? extends Boolean>>() { // from class: com.discord.stores.StoreCalls.call.2.1
                @Override // j0.k.Func1
                public final Observable<? extends Boolean> call(Integer num) {
                    return (num != null && num.intValue() == 1) ? new ScalarSynchronousObservable(Boolean.TRUE) : ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().call(AnonymousClass2.this.$channelId), false, 1, null).G(new Func1<ModelCall.Ringable, Boolean>() { // from class: com.discord.stores.StoreCalls.call.2.1.1
                        @Override // j0.k.Func1
                        public final Boolean call(ModelCall.Ringable ringable) {
                            Intrinsics3.checkNotNullExpressionValue(ringable, "it");
                            return Boolean.valueOf(ringable.isRingable());
                        }
                    });
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableA, "StoreStream\n          .g…            }\n          }");
            Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableA, 0L, false, 3, null), this.$appComponent, null, 2, null);
            Context context = this.$context;
            ObservableExtensionsKt.appSubscribe(observableUi$default, (Class<?>) StoreCalls.this.getClass(), (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass3(j)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new C00962());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreCalls$call$3, reason: invalid class name */
    /* JADX INFO: compiled from: StoreCalls.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Channel, Boolean> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Channel channel) {
            return Boolean.valueOf(invoke2(channel));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Channel channel) {
            return channel != null;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreCalls$call$5, reason: invalid class name */
    /* JADX INFO: compiled from: StoreCalls.kt */
    public static final class AnonymousClass5 extends Lambda implements Function1<Tuples2<? extends Channel, ? extends Map<Long, ? extends VoiceState>>, Unit> {
        public final /* synthetic */ AnonymousClass1 $doCall$1;
        public final /* synthetic */ AnonymousClass2 $doCallIfCallable$2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(AnonymousClass2 anonymousClass2, AnonymousClass1 anonymousClass1) {
            super(1);
            this.$doCallIfCallable$2 = anonymousClass2;
            this.$doCall$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends Channel, ? extends Map<Long, ? extends VoiceState>> tuples2) {
            invoke2((Tuples2<Channel, ? extends Map<Long, VoiceState>>) tuples2);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples2<Channel, ? extends Map<Long, VoiceState>> tuples2) {
            Channel channelComponent1 = tuples2.component1();
            Map<Long, VoiceState> mapComponent2 = tuples2.component2();
            User userA = channelComponent1 != null ? ChannelUtils.a(channelComponent1) : null;
            if (userA != null) {
                this.$doCallIfCallable$2.invoke(userA.getId());
            } else if (channelComponent1 != null) {
                this.$doCall$1.invoke(mapComponent2.isEmpty());
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreCalls$findCall$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreCalls.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelCall, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(ModelCall modelCall) {
            return Boolean.valueOf(invoke2(modelCall));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(ModelCall modelCall) {
            return modelCall != null;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreCalls$ring$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreCalls.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelCall, Unit> {
        public final /* synthetic */ List $recipients;

        /* JADX INFO: renamed from: com.discord.stores.StoreCalls$ring$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreCalls.kt */
        public static final class C00971 extends Lambda implements Function1<Void, Unit> {
            public static final C00971 INSTANCE = new C00971();

            public C00971() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list) {
            super(1);
            this.$recipients = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelCall modelCall) {
            invoke2(modelCall);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelCall modelCall) {
            if (modelCall != null) {
                ObservableExtensionsKt.appSubscribe(RestAPI.INSTANCE.getApi().ring(modelCall.getChannelId(), modelCall.getMessageId(), this.$recipients), (Class<?>) StoreCalls.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), C00971.INSTANCE);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreCalls$stopRinging$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreCalls.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelCall, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ List $recipients;

        /* JADX INFO: renamed from: com.discord.stores.StoreCalls$stopRinging$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreCalls.kt */
        public static final class C00981 extends Lambda implements Function1<Void, Unit> {
            public static final C00981 INSTANCE = new C00981();

            public C00981() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, List list) {
            super(1);
            this.$channelId = j;
            this.$recipients = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelCall modelCall) {
            invoke2(modelCall);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelCall modelCall) {
            if (modelCall == null) {
                StoreCalls.this.stream.getCallsIncoming().removeIncomingCall(this.$channelId);
                return;
            }
            ObservableExtensionsKt.appSubscribe(RestAPI.INSTANCE.getApi().stopRinging(modelCall.getChannelId(), modelCall.getMessageId(), this.$recipients), (Class<?>) StoreCalls.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), C00981.INSTANCE);
        }
    }

    public StoreCalls(StoreStream storeStream) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        this.stream = storeStream;
        this.calls = new HashMap<>();
        this.callsSubject = new SerializedSubject<>(BehaviorSubject.k0());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void call$default(StoreCalls storeCalls, AppComponent appComponent, Context context, FragmentManager fragmentManager, long j, Function0 function0, int i, Object obj) {
        if ((i & 16) != 0) {
            function0 = null;
        }
        storeCalls.call(appComponent, context, fragmentManager, j, function0);
    }

    private final void callConnect() {
        if (this.connectionReady && this.selectedGuildId == 0) {
            long j = this.selectedChannelId;
            if (j <= 0 || this.calls.containsKey(Long.valueOf(j))) {
                return;
            }
            this.calls.put(Long.valueOf(this.selectedChannelId), null);
            this.stream.getGatewaySocket().callConnect(this.selectedChannelId);
        }
    }

    private final void callSubjectUpdate(boolean updated) {
        if (updated) {
            SerializedSubject<HashMap<Long, ModelCall>, HashMap<Long, ModelCall>> serializedSubject = this.callsSubject;
            serializedSubject.k.onNext(new HashMap<>(this.calls));
        }
    }

    public static /* synthetic */ void callSubjectUpdate$default(StoreCalls storeCalls, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        storeCalls.callSubjectUpdate(z2);
    }

    private final void findCall(long channelId, Function1<? super ModelCall, Unit> onFoundCall) {
        Observable<R> observableK = get(channelId).k(o.c(AnonymousClass1.INSTANCE, null, 3L, TimeUnit.SECONDS));
        Intrinsics3.checkNotNullExpressionValue(observableK, "get(channelId)\n        .…l?, 3, TimeUnit.SECONDS))");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableK, 0L, false, 3, null), (Class<?>) StoreCalls.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), onFoundCall);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void ring$default(StoreCalls storeCalls, long j, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = null;
        }
        storeCalls.ring(j, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void stopRinging$default(StoreCalls storeCalls, long j, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = null;
        }
        storeCalls.stopRinging(j, list);
    }

    public final void call(AppComponent appComponent, Context context, FragmentManager fragmentManager, long channelId, Function0<Unit> onError) {
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(channelId);
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(channelId, appComponent, context, anonymousClass1, onError, fragmentManager);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableZ = Observable.j0(companion.getChannels().observeChannel(channelId).k(o.c(AnonymousClass3.INSTANCE, null, 5000L, TimeUnit.MILLISECONDS)), companion.getVoiceStates().observeForPrivateChannels(channelId), new Func2<Channel, Map<Long, ? extends VoiceState>, Tuples2<? extends Channel, ? extends Map<Long, ? extends VoiceState>>>() { // from class: com.discord.stores.StoreCalls.call.4
            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ Tuples2<? extends Channel, ? extends Map<Long, ? extends VoiceState>> call(Channel channel, Map<Long, ? extends VoiceState> map) {
                return call2(channel, (Map<Long, VoiceState>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Tuples2<Channel, Map<Long, VoiceState>> call2(Channel channel, Map<Long, VoiceState> map) {
                return new Tuples2<>(channel, map);
            }
        }).Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableZ, "Observable\n        .zip(…tates) }\n        .take(1)");
        ObservableExtensionsKt.appSubscribe(observableZ, (Class<?>) StoreCalls.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass5(anonymousClass2, anonymousClass1));
    }

    public final Observable<ModelCall> get(final long channelId) {
        Observable<R> observableG = this.callsSubject.G(new Func1<HashMap<Long, ModelCall>, ModelCall>() { // from class: com.discord.stores.StoreCalls.get.1
            @Override // j0.k.Func1
            public final ModelCall call(HashMap<Long, ModelCall> map) {
                return map.get(Long.valueOf(channelId));
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "callsSubject\n          .…lls -> calls[channelId] }");
        Observable<ModelCall> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "callsSubject\n          .…  .distinctUntilChanged()");
        return observableR;
    }

    public final void handleCallCreateOrUpdate(ModelCall call) {
        Intrinsics3.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        long channelId = call.getChannelId();
        boolean z2 = true;
        if (!Intrinsics3.areEqual(call, this.calls.get(Long.valueOf(channelId)))) {
            this.calls.put(Long.valueOf(channelId), call);
        } else {
            z2 = false;
        }
        callSubjectUpdate(z2);
    }

    public final void handleCallDelete(ModelCall callDelete) {
        Intrinsics3.checkNotNullParameter(callDelete, "callDelete");
        long channelId = callDelete.getChannelId();
        if (this.calls.containsKey(Long.valueOf(channelId))) {
            this.calls.put(Long.valueOf(channelId), null);
            callSubjectUpdate$default(this, false, 1, null);
        }
    }

    public final void handleChannelSelect(long channelId) {
        this.selectedChannelId = channelId;
        callConnect();
    }

    public final void handleConnectionOpen() {
        this.calls.clear();
        callSubjectUpdate$default(this, false, 1, null);
        callConnect();
    }

    public final void handleConnectionReady(boolean connectionReady) {
        this.connectionReady = connectionReady;
        callConnect();
    }

    public final void handleGuildSelect(long guildId) {
        this.selectedGuildId = guildId;
        callConnect();
    }

    public final void ring(long channelId, List<Long> recipients) {
        findCall(channelId, new AnonymousClass1(recipients));
    }

    public final void stopRinging(long channelId, List<Long> recipients) {
        findCall(channelId, new AnonymousClass1(channelId, recipients));
    }
}
