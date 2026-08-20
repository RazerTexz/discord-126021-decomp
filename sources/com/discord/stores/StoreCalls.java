package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.voice.state.VoiceState;
import com.discord.app.AppComponent;
import com.discord.models.domain.ModelCall;
import com.discord.models.user.User;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.voice.call.WidgetCallFailed;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.C0879o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: StoreCalls.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCalls {
    private final HashMap<Long, ModelCall> calls;
    private final SerializedSubject<HashMap<Long, ModelCall>, HashMap<Long, ModelCall>> callsSubject;
    private boolean connectionReady;
    private long selectedChannelId;
    private long selectedGuildId;
    private final StoreStream stream;

    /* JADX INFO: renamed from: com.discord.stores.StoreCalls$call$1 */
    /* JADX INFO: compiled from: StoreCalls.kt */
    public static final class C57961 extends AbstractC12240o implements Function1<Boolean, Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57961(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            StoreCalls.this.stream.getVoiceChannelSelected().selectVoiceChannel(this.$channelId);
            if (z2) {
                StoreCalls.ring$default(StoreCalls.this, this.$channelId, null, 2, null);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreCalls$call$2 */
    /* JADX INFO: compiled from: StoreCalls.kt */
    public static final class C57972 extends AbstractC12240o implements Function1<Long, Unit> {
        public final /* synthetic */ AppComponent $appComponent;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ C57961 $doCall$1;
        public final /* synthetic */ FragmentManager $fragmentManager;
        public final /* synthetic */ Function0 $onError;

        /* JADX INFO: renamed from: com.discord.stores.StoreCalls$call$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreCalls.kt */
        public static final class AnonymousClass2 extends AbstractC12240o implements Function1<Boolean, Unit> {
            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                C57961 c57961 = C57972.this.$doCall$1;
                C12238m.checkNotNullExpressionValue(bool, "isRingable");
                c57961.invoke(bool.booleanValue());
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreCalls$call$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: StoreCalls.kt */
        public static final class AnonymousClass3 extends AbstractC12240o implements Function1<Error, Unit> {
            public final /* synthetic */ long $userId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(long j) {
                super(1);
                this.$userId = j;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                C12238m.checkNotNullParameter(error, "error");
                Function0 function0 = C57972.this.$onError;
                if (function0 != null) {
                }
                Error.Response response = error.getResponse();
                C12238m.checkNotNullExpressionValue(response, "error.response");
                if (response.getCode() == 50013) {
                    error.setShowErrorToasts(false);
                    WidgetCallFailed.INSTANCE.show(C57972.this.$fragmentManager, this.$userId);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57972(long j, AppComponent appComponent, Context context, C57961 c57961, Function0 function0, FragmentManager fragmentManager) {
            super(1);
            this.$channelId = j;
            this.$appComponent = appComponent;
            this.$context = context;
            this.$doCall$1 = c57961;
            this.$onError = function0;
            this.$fragmentManager = fragmentManager;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j) {
            Observable<R> observableM11082A = StoreStream.INSTANCE.getUserRelationships().observe(j).m11082A(new InterfaceC12589b<Integer, Observable<? extends Boolean>>() { // from class: com.discord.stores.StoreCalls.call.2.1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends Boolean> call(Integer num) {
                    return (num != null && num.intValue() == 1) ? new C12721k(Boolean.TRUE) : ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().call(C57972.this.$channelId), false, 1, null).m11083G(new InterfaceC12589b<ModelCall.Ringable, Boolean>() { // from class: com.discord.stores.StoreCalls.call.2.1.1
                        @Override // p637j0.p641k.InterfaceC12589b
                        public final Boolean call(ModelCall.Ringable ringable) {
                            C12238m.checkNotNullExpressionValue(ringable, "it");
                            return Boolean.valueOf(ringable.isRingable());
                        }
                    });
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11082A, "StoreStream\n          .g…            }\n          }");
            Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11082A, 0L, false, 3, null), this.$appComponent, null, 2, null);
            Context context = this.$context;
            ObservableExtensionsKt.appSubscribe(observableUi$default, (Class<?>) StoreCalls.this.getClass(), (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass3(j)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new AnonymousClass2());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreCalls$call$3 */
    /* JADX INFO: compiled from: StoreCalls.kt */
    public static final class C57983 extends AbstractC12240o implements Function1<Channel, Boolean> {
        public static final C57983 INSTANCE = new C57983();

        public C57983() {
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

    /* JADX INFO: renamed from: com.discord.stores.StoreCalls$call$5 */
    /* JADX INFO: compiled from: StoreCalls.kt */
    public static final class C58005 extends AbstractC12240o implements Function1<Pair<? extends Channel, ? extends Map<Long, ? extends VoiceState>>, Unit> {
        public final /* synthetic */ C57961 $doCall$1;
        public final /* synthetic */ C57972 $doCallIfCallable$2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58005(C57972 c57972, C57961 c57961) {
            super(1);
            this.$doCallIfCallable$2 = c57972;
            this.$doCall$1 = c57961;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Channel, ? extends Map<Long, ? extends VoiceState>> pair) {
            invoke2((Pair<Channel, ? extends Map<Long, VoiceState>>) pair);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Pair<Channel, ? extends Map<Long, VoiceState>> pair) {
            Channel channelComponent1 = pair.component1();
            Map<Long, VoiceState> mapComponent2 = pair.component2();
            User userM7677a = channelComponent1 != null ? ChannelUtils.m7677a(channelComponent1) : null;
            if (userM7677a != null) {
                this.$doCallIfCallable$2.invoke(userM7677a.getId());
            } else if (channelComponent1 != null) {
                this.$doCall$1.invoke(mapComponent2.isEmpty());
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreCalls$findCall$1 */
    /* JADX INFO: compiled from: StoreCalls.kt */
    public static final class C58011 extends AbstractC12240o implements Function1<ModelCall, Boolean> {
        public static final C58011 INSTANCE = new C58011();

        public C58011() {
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

    /* JADX INFO: renamed from: com.discord.stores.StoreCalls$ring$1 */
    /* JADX INFO: compiled from: StoreCalls.kt */
    public static final class C58031 extends AbstractC12240o implements Function1<ModelCall, Unit> {
        public final /* synthetic */ List $recipients;

        /* JADX INFO: renamed from: com.discord.stores.StoreCalls$ring$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreCalls.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Void, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58031(List list) {
            super(1);
            this.$recipients = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelCall modelCall) {
            invoke2(modelCall);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelCall modelCall) {
            if (modelCall != null) {
                ObservableExtensionsKt.appSubscribe(RestAPI.INSTANCE.getApi().ring(modelCall.getChannelId(), modelCall.getMessageId(), this.$recipients), (Class<?>) StoreCalls.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), AnonymousClass1.INSTANCE);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreCalls$stopRinging$1 */
    /* JADX INFO: compiled from: StoreCalls.kt */
    public static final class C58041 extends AbstractC12240o implements Function1<ModelCall, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ List $recipients;

        /* JADX INFO: renamed from: com.discord.stores.StoreCalls$stopRinging$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreCalls.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Void, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58041(long j, List list) {
            super(1);
            this.$channelId = j;
            this.$recipients = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelCall modelCall) {
            invoke2(modelCall);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelCall modelCall) {
            if (modelCall == null) {
                StoreCalls.this.stream.getCallsIncoming().removeIncomingCall(this.$channelId);
                return;
            }
            ObservableExtensionsKt.appSubscribe(RestAPI.INSTANCE.getApi().stopRinging(modelCall.getChannelId(), modelCall.getMessageId(), this.$recipients), (Class<?>) StoreCalls.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), AnonymousClass1.INSTANCE);
        }
    }

    public StoreCalls(StoreStream storeStream) {
        C12238m.checkNotNullParameter(storeStream, "stream");
        this.stream = storeStream;
        this.calls = new HashMap<>();
        this.callsSubject = new SerializedSubject<>(BehaviorSubject.m11129k0());
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
            serializedSubject.f27653k.onNext(new HashMap<>(this.calls));
        }
    }

    public static /* synthetic */ void callSubjectUpdate$default(StoreCalls storeCalls, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        storeCalls.callSubjectUpdate(z2);
    }

    private final void findCall(long channelId, Function1<? super ModelCall, Unit> onFoundCall) {
        Observable<R> observableM11108k = get(channelId).m11108k(C0879o.m177c(C58011.INSTANCE, null, 3L, TimeUnit.SECONDS));
        C12238m.checkNotNullExpressionValue(observableM11108k, "get(channelId)\n        .…l?, 3, TimeUnit.SECONDS))");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11108k, 0L, false, 3, null), (Class<?>) StoreCalls.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), onFoundCall);
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
        C12238m.checkNotNullParameter(appComponent, "appComponent");
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
        C57961 c57961 = new C57961(channelId);
        C57972 c57972 = new C57972(channelId, appComponent, context, c57961, onError, fragmentManager);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableM11100Z = Observable.m11077j0(companion.getChannels().observeChannel(channelId).m11108k(C0879o.m177c(C57983.INSTANCE, null, 5000L, TimeUnit.MILLISECONDS)), companion.getVoiceStates().observeForPrivateChannels(channelId), new Func2<Channel, Map<Long, ? extends VoiceState>, Pair<? extends Channel, ? extends Map<Long, ? extends VoiceState>>>() { // from class: com.discord.stores.StoreCalls.call.4
            @Override // p658rx.functions.Func2
            public /* bridge */ /* synthetic */ Pair<? extends Channel, ? extends Map<Long, ? extends VoiceState>> call(Channel channel, Map<Long, ? extends VoiceState> map) {
                return call2(channel, (Map<Long, VoiceState>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Pair<Channel, Map<Long, VoiceState>> call2(Channel channel, Map<Long, VoiceState> map) {
                return new Pair<>(channel, map);
            }
        }).m11100Z(1);
        C12238m.checkNotNullExpressionValue(observableM11100Z, "Observable\n        .zip(…tates) }\n        .take(1)");
        ObservableExtensionsKt.appSubscribe(observableM11100Z, (Class<?>) StoreCalls.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C58005(c57972, c57961));
    }

    public final Observable<ModelCall> get(final long channelId) {
        Observable<R> observableM11083G = this.callsSubject.m11083G(new InterfaceC12589b<HashMap<Long, ModelCall>, ModelCall>() { // from class: com.discord.stores.StoreCalls.get.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final ModelCall call(HashMap<Long, ModelCall> map) {
                return map.get(Long.valueOf(channelId));
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "callsSubject\n          .…lls -> calls[channelId] }");
        Observable<ModelCall> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11083G).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "callsSubject\n          .…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final void handleCallCreateOrUpdate(ModelCall call) {
        C12238m.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        long channelId = call.getChannelId();
        boolean z2 = true;
        if (!C12238m.areEqual(call, this.calls.get(Long.valueOf(channelId)))) {
            this.calls.put(Long.valueOf(channelId), call);
        } else {
            z2 = false;
        }
        callSubjectUpdate(z2);
    }

    public final void handleCallDelete(ModelCall callDelete) {
        C12238m.checkNotNullParameter(callDelete, "callDelete");
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
        findCall(channelId, new C58031(recipients));
    }

    public final void stopRinging(long channelId, List<Long> recipients) {
        findCall(channelId, new C58041(channelId, recipients));
    }
}
