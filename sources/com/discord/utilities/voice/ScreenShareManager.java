package com.discord.utilities.voice;

import android.content.Intent;
import android.graphics.Bitmap;
import androidx.annotation.MainThread;
import com.discord.app.AppComponent;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.user.MeUser;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.mediaengine.ThumbnailEmitter;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreRtcConnection;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStreamRtcConnection;
import com.discord.stores.StoreUser;
import com.discord.tooltips.TooltipManager;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.images.ImageEncoder;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.lang.ref.WeakReference;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p026j.C1100a;
import p007b.p008a.p058v.C1311a;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p643a.EnumC12606c;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func3;
import p658rx.subjects.BehaviorSubject;
import p658rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: ScreenShareManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ScreenShareManager {
    public static final int JPEG_QUALITY = 92;
    public static final long PREVIEW_DELAY_MS = 5000;
    public static final long PREVIEW_INTERVAL_MS = 300000;
    public static final int THUMBNAIL_HEIGHT_PX = 288;
    public static final int THUMBNAIL_WIDTH_PX = 512;
    private final AppComponent appComponent;
    private final long channelId;
    private final CompositeSubscription compositeSubscription;
    private final Long guildId;
    private final ImageEncoder imageEncoder;
    private State previousState;
    private final RestAPI restAPI;
    private Intent screenshareIntent;
    private final StoreApplicationStreaming storeApplicationStreaming;
    private final StoreRtcConnection storeRtcConnection;
    private final StoreStreamRtcConnection storeStreamRtcConnection;
    private final StoreUser storeUser;
    private final BehaviorSubject<Bitmap> thumbnailBitmapSubject;
    private final TooltipManager tooltipManager;

    /* JADX INFO: compiled from: ScreenShareManager.kt */
    public final class RtcConnectionListener extends RtcConnection.AbstractC5616b {
        public RtcConnectionListener() {
        }

        @Override // com.discord.rtcconnection.RtcConnection.AbstractC5616b, com.discord.rtcconnection.RtcConnection.InterfaceC5617c
        public void onStateChange(RtcConnection.StateChange stateChange) {
            C12238m.checkNotNullParameter(stateChange, "stateChange");
            RtcConnection.State state = stateChange.state;
            if (!C12238m.areEqual(state, RtcConnection.State.C5612f.f18814a)) {
                if (state instanceof RtcConnection.State.C5610d) {
                    ScreenShareManager.this.stopStream();
                }
            } else {
                State state2 = ScreenShareManager.this.previousState;
                RtcConnection rtcConnection = state2 != null ? state2.getRtcConnection() : null;
                if (rtcConnection != null) {
                    rtcConnection.m8477t(ScreenShareManager.this.screenshareIntent, ScreenShareManager.this.createThumbnailEmitter());
                    ScreenShareManager.this.uploadScreenSharePreviews();
                }
            }
        }
    }

    /* JADX INFO: compiled from: ScreenShareManager.kt */
    public static final /* data */ class State {
        private final StoreApplicationStreaming.ActiveApplicationStream activeStream;
        private final Long meId;
        private final RtcConnection rtcConnection;

        public State(StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, RtcConnection rtcConnection, Long l) {
            this.activeStream = activeApplicationStream;
            this.rtcConnection = rtcConnection;
            this.meId = l;
        }

        public static /* synthetic */ State copy$default(State state, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, RtcConnection rtcConnection, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                activeApplicationStream = state.activeStream;
            }
            if ((i & 2) != 0) {
                rtcConnection = state.rtcConnection;
            }
            if ((i & 4) != 0) {
                l = state.meId;
            }
            return state.copy(activeApplicationStream, rtcConnection, l);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StoreApplicationStreaming.ActiveApplicationStream getActiveStream() {
            return this.activeStream;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final RtcConnection getRtcConnection() {
            return this.rtcConnection;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Long getMeId() {
            return this.meId;
        }

        public final State copy(StoreApplicationStreaming.ActiveApplicationStream activeStream, RtcConnection rtcConnection, Long meId) {
            return new State(activeStream, rtcConnection, meId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return C12238m.areEqual(this.activeStream, state.activeStream) && C12238m.areEqual(this.rtcConnection, state.rtcConnection) && C12238m.areEqual(this.meId, state.meId);
        }

        public final StoreApplicationStreaming.ActiveApplicationStream getActiveStream() {
            return this.activeStream;
        }

        public final Long getMeId() {
            return this.meId;
        }

        public final RtcConnection getRtcConnection() {
            return this.rtcConnection;
        }

        public int hashCode() {
            StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream = this.activeStream;
            int iHashCode = (activeApplicationStream != null ? activeApplicationStream.hashCode() : 0) * 31;
            RtcConnection rtcConnection = this.rtcConnection;
            int iHashCode2 = (iHashCode + (rtcConnection != null ? rtcConnection.hashCode() : 0)) * 31;
            Long l = this.meId;
            return iHashCode2 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("State(activeStream=");
            sbM833U.append(this.activeStream);
            sbM833U.append(", rtcConnection=");
            sbM833U.append(this.rtcConnection);
            sbM833U.append(", meId=");
            return C1643a.m819G(sbM833U, this.meId, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.ScreenShareManager$createThumbnailEmitter$1 */
    /* JADX INFO: compiled from: ScreenShareManager.kt */
    public static final class C70381 extends AbstractC12240o implements Function1<Bitmap, Unit> {
        public C70381() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
            invoke2(bitmap);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Bitmap bitmap) {
            C12238m.checkNotNullParameter(bitmap, "thumbnailBitmap");
            ScreenShareManager.this.thumbnailBitmapSubject.onNext(bitmap);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.ScreenShareManager$startStream$2 */
    /* JADX INFO: compiled from: ScreenShareManager.kt */
    public static final class C70402 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C70402() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            ScreenShareManager.this.compositeSubscription.m11136a(subscription);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.ScreenShareManager$startStream$3 */
    /* JADX INFO: compiled from: ScreenShareManager.kt */
    public static final class C70413 extends AbstractC12240o implements Function1<RtcConnection.Metadata, Unit> {
        public final /* synthetic */ Intent $intent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C70413(Intent intent) {
            super(1);
            this.$intent = intent;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RtcConnection.Metadata metadata) {
            invoke2(metadata);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RtcConnection.Metadata metadata) {
            ScreenShareManager.this.handleStartStream(this.$intent);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.ScreenShareManager$subscribeToStores$2 */
    /* JADX INFO: compiled from: ScreenShareManager.kt */
    public static final class C70432 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C70432() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            ScreenShareManager.this.compositeSubscription.m11136a(subscription);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.ScreenShareManager$subscribeToStores$3 */
    /* JADX INFO: compiled from: ScreenShareManager.kt */
    public static final class C70443 extends AbstractC12240o implements Function1<State, Unit> {
        public C70443() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(State state) {
            invoke2(state);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(State state) {
            ScreenShareManager screenShareManager = ScreenShareManager.this;
            C12238m.checkNotNullExpressionValue(state, "it");
            screenShareManager.handleStateUpdate(state);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.ScreenShareManager$uploadScreenSharePreviews$2 */
    /* JADX INFO: compiled from: ScreenShareManager.kt */
    public static final class C70462 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C70462() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            ScreenShareManager.this.compositeSubscription.m11136a(subscription);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.ScreenShareManager$uploadScreenSharePreviews$3 */
    /* JADX INFO: compiled from: ScreenShareManager.kt */
    public static final class C70473 extends AbstractC12240o implements Function1<Void, Unit> {
        public static final C70473 INSTANCE = new C70473();

        public C70473() {
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

    public ScreenShareManager(AppComponent appComponent, long j, Long l, StoreApplicationStreaming storeApplicationStreaming, StoreRtcConnection storeRtcConnection, StoreStreamRtcConnection storeStreamRtcConnection, StoreUser storeUser, RestAPI restAPI, ImageEncoder imageEncoder, TooltipManager tooltipManager) {
        C12238m.checkNotNullParameter(appComponent, "appComponent");
        C12238m.checkNotNullParameter(storeApplicationStreaming, "storeApplicationStreaming");
        C12238m.checkNotNullParameter(storeRtcConnection, "storeRtcConnection");
        C12238m.checkNotNullParameter(storeStreamRtcConnection, "storeStreamRtcConnection");
        C12238m.checkNotNullParameter(storeUser, "storeUser");
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        C12238m.checkNotNullParameter(imageEncoder, "imageEncoder");
        C12238m.checkNotNullParameter(tooltipManager, "tooltipManager");
        this.appComponent = appComponent;
        this.channelId = j;
        this.guildId = l;
        this.storeApplicationStreaming = storeApplicationStreaming;
        this.storeRtcConnection = storeRtcConnection;
        this.storeStreamRtcConnection = storeStreamRtcConnection;
        this.storeUser = storeUser;
        this.restAPI = restAPI;
        this.imageEncoder = imageEncoder;
        this.tooltipManager = tooltipManager;
        BehaviorSubject<Bitmap> behaviorSubjectM11129k0 = BehaviorSubject.m11129k0();
        C12238m.checkNotNullExpressionValue(behaviorSubjectM11129k0, "BehaviorSubject.create()");
        this.thumbnailBitmapSubject = behaviorSubjectM11129k0;
        this.compositeSubscription = new CompositeSubscription();
        subscribeToStores();
    }

    private final ThumbnailEmitter createThumbnailEmitter() {
        return new ThumbnailEmitter(512, THUMBNAIL_HEIGHT_PX, 300000L, 5000L, null, new C70381(), 16);
    }

    @MainThread
    private final void handleStartStream(Intent intent) {
        StoreApplicationStreaming.createStream$default(this.storeApplicationStreaming, this.channelId, this.guildId, null, 4, null);
        this.screenshareIntent = intent;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0040  */
    @MainThread
    private final void handleStateUpdate(State state) {
        boolean z2;
        RtcConnection rtcConnection;
        ModelApplicationStream stream;
        RtcConnection rtcConnection2;
        StoreApplicationStreaming.ActiveApplicationStream activeStream;
        ModelApplicationStream stream2;
        ModelApplicationStream stream3;
        State state2 = this.previousState;
        boolean z3 = false;
        if ((state2 != null ? state2.getActiveStream() : null) == null) {
            z2 = false;
        } else {
            StoreApplicationStreaming.ActiveApplicationStream activeStream2 = state.getActiveStream();
            String encodedStreamKey = (activeStream2 == null || (stream3 = activeStream2.getStream()) == null) ? null : stream3.getEncodedStreamKey();
            State state3 = this.previousState;
            if (!C12238m.areEqual(encodedStreamKey, (state3 == null || (activeStream = state3.getActiveStream()) == null || (stream2 = activeStream.getStream()) == null) ? null : stream2.getEncodedStreamKey())) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        if (z2 && (rtcConnection2 = state.getRtcConnection()) != null) {
            rtcConnection2.m8477t(null, null);
        }
        StoreApplicationStreaming.ActiveApplicationStream activeStream3 = state.getActiveStream();
        if (C12238m.areEqual((activeStream3 == null || (stream = activeStream3.getStream()) == null) ? null : Long.valueOf(stream.getOwnerId()), state.getMeId())) {
            State state4 = this.previousState;
            if ((state4 != null ? state4.getRtcConnection() : null) == null && state.getRtcConnection() != null) {
                z3 = true;
            }
            if (z3 && (rtcConnection = state.getRtcConnection()) != null) {
                rtcConnection.m8462c(new RtcConnectionListener());
            }
            this.previousState = state;
        }
    }

    private final void subscribeToStores() {
        Observable observableM11112r = Observable.m11075i(this.storeApplicationStreaming.observeActiveStream(), this.storeStreamRtcConnection.observeRtcConnection(), StoreUser.observeMe$default(this.storeUser, false, 1, null), new Func3<StoreApplicationStreaming.ActiveApplicationStream, RtcConnection, MeUser, State>() { // from class: com.discord.utilities.voice.ScreenShareManager.subscribeToStores.1
            @Override // p658rx.functions.Func3
            public final State call(StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, RtcConnection rtcConnection, MeUser meUser) {
                return new State(activeApplicationStream, rtcConnection, meUser != null ? Long.valueOf(meUser.getId()) : null);
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "Observable.combineLatest…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11112r, this.appComponent, null, 2, null), (Class<?>) ScreenShareManager.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C70432()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C70443());
    }

    private final void uploadScreenSharePreviews() {
        Observable<R> observableM11082A = this.thumbnailBitmapSubject.m11082A(new InterfaceC12589b<Bitmap, Observable<? extends Void>>() { // from class: com.discord.utilities.voice.ScreenShareManager.uploadScreenSharePreviews.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends Void> call(Bitmap bitmap) {
                State state = ScreenShareManager.this.previousState;
                StoreApplicationStreaming.ActiveApplicationStream activeStream = state != null ? state.getActiveStream() : null;
                if (activeStream == null) {
                    return EnumC12606c.f26751k;
                }
                ImageEncoder imageEncoder = ScreenShareManager.this.imageEncoder;
                C12238m.checkNotNullExpressionValue(bitmap, "thumbnailBitmap");
                return ScreenShareManager.this.restAPI.postStreamPreview(activeStream.getStream().getEncodedStreamKey(), imageEncoder.encodeBitmapAsJpegDataUrl(bitmap, 92));
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11082A, "thumbnailBitmapSubject\n …>()\n          }\n        }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11082A, this.appComponent, null, 2, null), false, 1, null), (Class<?>) ScreenShareManager.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C70462()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), C70473.INSTANCE);
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final void release() {
        this.compositeSubscription.unsubscribe();
    }

    public final void startStream(Intent intent) {
        C12238m.checkNotNullParameter(intent, "intent");
        Observable<RtcConnection.Metadata> observableM11100Z = this.storeRtcConnection.observeRtcConnectionMetadata().m11118y(new InterfaceC12589b<RtcConnection.Metadata, Boolean>() { // from class: com.discord.utilities.voice.ScreenShareManager.startStream.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(RtcConnection.Metadata metadata) {
                Long l = metadata != null ? metadata.channelId : null;
                return Boolean.valueOf(l != null && l.longValue() == ScreenShareManager.this.getChannelId() && C12238m.areEqual(metadata.guildId, ScreenShareManager.this.getGuildId()));
            }
        }).m11100Z(1);
        C12238m.checkNotNullExpressionValue(observableM11100Z, "storeRtcConnection.obser…       }\n        .take(1)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11100Z, this.appComponent, null, 2, null), (Class<?>) ScreenShareManager.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C70402()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C70413(intent));
    }

    public final void stopStream() {
        StoreApplicationStreaming.ActiveApplicationStream activeStream;
        State state = this.previousState;
        if (state == null || (activeStream = state.getActiveStream()) == null) {
            return;
        }
        this.storeApplicationStreaming.stopStream(activeStream.getStream().getEncodedStreamKey());
        this.screenshareIntent = null;
    }

    public ScreenShareManager(AppComponent appComponent, long j, Long l, StoreApplicationStreaming storeApplicationStreaming, StoreRtcConnection storeRtcConnection, StoreStreamRtcConnection storeStreamRtcConnection, StoreUser storeUser, RestAPI restAPI, ImageEncoder imageEncoder, TooltipManager tooltipManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        TooltipManager tooltipManager2;
        StoreApplicationStreaming applicationStreaming = (i & 8) != 0 ? StoreStream.INSTANCE.getApplicationStreaming() : storeApplicationStreaming;
        StoreRtcConnection rtcConnection = (i & 16) != 0 ? StoreStream.INSTANCE.getRtcConnection() : storeRtcConnection;
        StoreStreamRtcConnection streamRtcConnection = (i & 32) != 0 ? StoreStream.INSTANCE.getStreamRtcConnection() : storeStreamRtcConnection;
        StoreUser users = (i & 64) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        RestAPI api = (i & 128) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        ImageEncoder imageEncoder2 = (i & 256) != 0 ? new ImageEncoder() : imageEncoder;
        if ((i & 512) != 0) {
            AppLog appLog = AppLog.f14950g;
            C12238m.checkNotNullParameter(appLog, "logger");
            WeakReference<C1100a> weakReference = C1100a.b.f1460a;
            C1100a c1100a = weakReference != null ? weakReference.get() : null;
            if (c1100a == null) {
                c1100a = new C1100a(appLog);
                C1100a.b.f1460a = new WeakReference<>(c1100a);
            }
            TooltipManager.C6647a c6647a = TooltipManager.C6647a.f18975d;
            C12238m.checkNotNullParameter(c1100a, "floatingViewManager");
            WeakReference<TooltipManager> weakReference2 = TooltipManager.C6647a.f18972a;
            TooltipManager tooltipManager3 = weakReference2 != null ? weakReference2.get() : null;
            if (tooltipManager3 == null) {
                TooltipManager tooltipManager4 = new TooltipManager((C1311a) TooltipManager.C6647a.f18973b.getValue(), (Set) TooltipManager.C6647a.f18974c.getValue(), 0, c1100a, 4);
                TooltipManager.C6647a.f18972a = new WeakReference<>(tooltipManager4);
                tooltipManager3 = tooltipManager4;
            }
            tooltipManager2 = tooltipManager3;
        } else {
            tooltipManager2 = tooltipManager;
        }
        this(appComponent, j, l, applicationStreaming, rtcConnection, streamRtcConnection, users, api, imageEncoder2, tooltipManager2);
    }
}
