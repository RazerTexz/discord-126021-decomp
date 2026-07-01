package com.discord.utilities.voice;

import android.content.Intent;
import android.graphics.Bitmap;
import androidx.annotation.MainThread;
import b.a.j.FloatingViewManager;
import b.a.v.AcknowledgedTooltipsCache;
import b.d.b.a.outline;
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
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.a.EmptyObservableHolder;
import java.lang.ref.WeakReference;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func3;
import rx.subjects.BehaviorSubject;
import rx.subscriptions.CompositeSubscription;

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
    public final class RtcConnectionListener extends RtcConnection.b {
        public RtcConnectionListener() {
        }

        @Override // com.discord.rtcconnection.RtcConnection.b, com.discord.rtcconnection.RtcConnection.c
        public void onStateChange(RtcConnection.StateChange stateChange) {
            Intrinsics3.checkNotNullParameter(stateChange, "stateChange");
            RtcConnection.State state = stateChange.state;
            if (!Intrinsics3.areEqual(state, RtcConnection.State.f.a)) {
                if (state instanceof RtcConnection.State.d) {
                    ScreenShareManager.this.stopStream();
                }
            } else {
                State state2 = ScreenShareManager.this.previousState;
                RtcConnection rtcConnection = state2 != null ? state2.getRtcConnection() : null;
                if (rtcConnection != null) {
                    rtcConnection.t(ScreenShareManager.this.screenshareIntent, ScreenShareManager.this.createThumbnailEmitter());
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
            return Intrinsics3.areEqual(this.activeStream, state.activeStream) && Intrinsics3.areEqual(this.rtcConnection, state.rtcConnection) && Intrinsics3.areEqual(this.meId, state.meId);
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
            StringBuilder sbU = outline.U("State(activeStream=");
            sbU.append(this.activeStream);
            sbU.append(", rtcConnection=");
            sbU.append(this.rtcConnection);
            sbU.append(", meId=");
            return outline.G(sbU, this.meId, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.ScreenShareManager$createThumbnailEmitter$1, reason: invalid class name */
    /* JADX INFO: compiled from: ScreenShareManager.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Bitmap, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
            invoke2(bitmap);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Bitmap bitmap) {
            Intrinsics3.checkNotNullParameter(bitmap, "thumbnailBitmap");
            ScreenShareManager.this.thumbnailBitmapSubject.onNext(bitmap);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.ScreenShareManager$startStream$2, reason: invalid class name */
    /* JADX INFO: compiled from: ScreenShareManager.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            ScreenShareManager.this.compositeSubscription.a(subscription);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.ScreenShareManager$startStream$3, reason: invalid class name */
    /* JADX INFO: compiled from: ScreenShareManager.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<RtcConnection.Metadata, Unit> {
        public final /* synthetic */ Intent $intent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Intent intent) {
            super(1);
            this.$intent = intent;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RtcConnection.Metadata metadata) {
            invoke2(metadata);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RtcConnection.Metadata metadata) {
            ScreenShareManager.this.handleStartStream(this.$intent);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.ScreenShareManager$subscribeToStores$2, reason: invalid class name */
    /* JADX INFO: compiled from: ScreenShareManager.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            ScreenShareManager.this.compositeSubscription.a(subscription);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.ScreenShareManager$subscribeToStores$3, reason: invalid class name */
    /* JADX INFO: compiled from: ScreenShareManager.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<State, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(State state) {
            invoke2(state);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(State state) {
            ScreenShareManager screenShareManager = ScreenShareManager.this;
            Intrinsics3.checkNotNullExpressionValue(state, "it");
            screenShareManager.handleStateUpdate(state);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.ScreenShareManager$uploadScreenSharePreviews$2, reason: invalid class name */
    /* JADX INFO: compiled from: ScreenShareManager.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            ScreenShareManager.this.compositeSubscription.a(subscription);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.voice.ScreenShareManager$uploadScreenSharePreviews$3, reason: invalid class name */
    /* JADX INFO: compiled from: ScreenShareManager.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
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

    public ScreenShareManager(AppComponent appComponent, long j, Long l, StoreApplicationStreaming storeApplicationStreaming, StoreRtcConnection storeRtcConnection, StoreStreamRtcConnection storeStreamRtcConnection, StoreUser storeUser, RestAPI restAPI, ImageEncoder imageEncoder, TooltipManager tooltipManager) {
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(storeApplicationStreaming, "storeApplicationStreaming");
        Intrinsics3.checkNotNullParameter(storeRtcConnection, "storeRtcConnection");
        Intrinsics3.checkNotNullParameter(storeStreamRtcConnection, "storeStreamRtcConnection");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(imageEncoder, "imageEncoder");
        Intrinsics3.checkNotNullParameter(tooltipManager, "tooltipManager");
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
        BehaviorSubject<Bitmap> behaviorSubjectK0 = BehaviorSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectK0, "BehaviorSubject.create()");
        this.thumbnailBitmapSubject = behaviorSubjectK0;
        this.compositeSubscription = new CompositeSubscription();
        subscribeToStores();
    }

    private final ThumbnailEmitter createThumbnailEmitter() {
        return new ThumbnailEmitter(512, THUMBNAIL_HEIGHT_PX, 300000L, 5000L, null, new AnonymousClass1(), 16);
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
            if (!Intrinsics3.areEqual(encodedStreamKey, (state3 == null || (activeStream = state3.getActiveStream()) == null || (stream2 = activeStream.getStream()) == null) ? null : stream2.getEncodedStreamKey())) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        if (z2 && (rtcConnection2 = state.getRtcConnection()) != null) {
            rtcConnection2.t(null, null);
        }
        StoreApplicationStreaming.ActiveApplicationStream activeStream3 = state.getActiveStream();
        if (Intrinsics3.areEqual((activeStream3 == null || (stream = activeStream3.getStream()) == null) ? null : Long.valueOf(stream.getOwnerId()), state.getMeId())) {
            State state4 = this.previousState;
            if ((state4 != null ? state4.getRtcConnection() : null) == null && state.getRtcConnection() != null) {
                z3 = true;
            }
            if (z3 && (rtcConnection = state.getRtcConnection()) != null) {
                rtcConnection.c(new RtcConnectionListener());
            }
            this.previousState = state;
        }
    }

    private final void subscribeToStores() {
        Observable observableR = Observable.i(this.storeApplicationStreaming.observeActiveStream(), this.storeStreamRtcConnection.observeRtcConnection(), StoreUser.observeMe$default(this.storeUser, false, 1, null), new Func3<StoreApplicationStreaming.ActiveApplicationStream, RtcConnection, MeUser, State>() { // from class: com.discord.utilities.voice.ScreenShareManager.subscribeToStores.1
            @Override // rx.functions.Func3
            public final State call(StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream, RtcConnection rtcConnection, MeUser meUser) {
                return new State(activeApplicationStream, rtcConnection, meUser != null ? Long.valueOf(meUser.getId()) : null);
            }
        }).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableR, this.appComponent, null, 2, null), (Class<?>) ScreenShareManager.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass2()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3());
    }

    private final void uploadScreenSharePreviews() {
        Observable<R> observableA = this.thumbnailBitmapSubject.A(new Func1<Bitmap, Observable<? extends Void>>() { // from class: com.discord.utilities.voice.ScreenShareManager.uploadScreenSharePreviews.1
            @Override // j0.k.Func1
            public final Observable<? extends Void> call(Bitmap bitmap) {
                State state = ScreenShareManager.this.previousState;
                StoreApplicationStreaming.ActiveApplicationStream activeStream = state != null ? state.getActiveStream() : null;
                if (activeStream == null) {
                    return EmptyObservableHolder.k;
                }
                ImageEncoder imageEncoder = ScreenShareManager.this.imageEncoder;
                Intrinsics3.checkNotNullExpressionValue(bitmap, "thumbnailBitmap");
                return ScreenShareManager.this.restAPI.postStreamPreview(activeStream.getStream().getEncodedStreamKey(), imageEncoder.encodeBitmapAsJpegDataUrl(bitmap, 92));
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableA, "thumbnailBitmapSubject\n …>()\n          }\n        }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableA, this.appComponent, null, 2, null), false, 1, null), (Class<?>) ScreenShareManager.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass2()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), AnonymousClass3.INSTANCE);
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
        Intrinsics3.checkNotNullParameter(intent, "intent");
        Observable<RtcConnection.Metadata> observableZ = this.storeRtcConnection.observeRtcConnectionMetadata().y(new Func1<RtcConnection.Metadata, Boolean>() { // from class: com.discord.utilities.voice.ScreenShareManager.startStream.1
            @Override // j0.k.Func1
            public final Boolean call(RtcConnection.Metadata metadata) {
                Long l = metadata != null ? metadata.channelId : null;
                return Boolean.valueOf(l != null && l.longValue() == ScreenShareManager.this.getChannelId() && Intrinsics3.areEqual(metadata.guildId, ScreenShareManager.this.getGuildId()));
            }
        }).Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableZ, "storeRtcConnection.obser…       }\n        .take(1)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableZ, this.appComponent, null, 2, null), (Class<?>) ScreenShareManager.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass2()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3(intent));
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
            AppLog appLog = AppLog.g;
            Intrinsics3.checkNotNullParameter(appLog, "logger");
            WeakReference<FloatingViewManager> weakReference = FloatingViewManager.b.a;
            FloatingViewManager floatingViewManager = weakReference != null ? weakReference.get() : null;
            if (floatingViewManager == null) {
                floatingViewManager = new FloatingViewManager(appLog);
                FloatingViewManager.b.a = new WeakReference<>(floatingViewManager);
            }
            TooltipManager.a aVar = TooltipManager.a.d;
            Intrinsics3.checkNotNullParameter(floatingViewManager, "floatingViewManager");
            WeakReference<TooltipManager> weakReference2 = TooltipManager.a.a;
            TooltipManager tooltipManager3 = weakReference2 != null ? weakReference2.get() : null;
            if (tooltipManager3 == null) {
                TooltipManager tooltipManager4 = new TooltipManager((AcknowledgedTooltipsCache) TooltipManager.a.f2815b.getValue(), (Set) TooltipManager.a.c.getValue(), 0, floatingViewManager, 4);
                TooltipManager.a.a = new WeakReference<>(tooltipManager4);
                tooltipManager3 = tooltipManager4;
            }
            tooltipManager2 = tooltipManager3;
        } else {
            tooltipManager2 = tooltipManager;
        }
        this(appComponent, j, l, applicationStreaming, rtcConnection, streamRtcConnection, users, api, imageEncoder2, tooltipManager2);
    }
}
