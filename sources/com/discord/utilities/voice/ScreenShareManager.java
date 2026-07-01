package com.discord.utilities.voice;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import androidx.annotation.MainThread;
import b.a.j.a;
import b.a.j.a$b;
import com.discord.app.AppComponent;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.RtcConnection$Metadata;
import com.discord.rtcconnection.mediaengine.ThumbnailEmitter;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreApplicationStreaming$ActiveApplicationStream;
import com.discord.stores.StoreRtcConnection;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStreamRtcConnection;
import com.discord.stores.StoreUser;
import com.discord.tooltips.TooltipManager;
import com.discord.tooltips.TooltipManager$a;
import com.discord.utilities.images.ImageEncoder;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.lang.ref.WeakReference;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: ScreenShareManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ScreenShareManager {
    public static final ScreenShareManager$Companion Companion = new ScreenShareManager$Companion(null);
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
    private ScreenShareManager$State previousState;
    private final RestAPI restAPI;
    private Intent screenshareIntent;
    private final StoreApplicationStreaming storeApplicationStreaming;
    private final StoreRtcConnection storeRtcConnection;
    private final StoreStreamRtcConnection storeStreamRtcConnection;
    private final StoreUser storeUser;
    private final BehaviorSubject<Bitmap> thumbnailBitmapSubject;
    private final TooltipManager tooltipManager;

    public ScreenShareManager(AppComponent appComponent, long j, Long l, StoreApplicationStreaming storeApplicationStreaming, StoreRtcConnection storeRtcConnection, StoreStreamRtcConnection storeStreamRtcConnection, StoreUser storeUser, RestAPI restAPI, ImageEncoder imageEncoder, TooltipManager tooltipManager) {
        m.checkNotNullParameter(appComponent, "appComponent");
        m.checkNotNullParameter(storeApplicationStreaming, "storeApplicationStreaming");
        m.checkNotNullParameter(storeRtcConnection, "storeRtcConnection");
        m.checkNotNullParameter(storeStreamRtcConnection, "storeStreamRtcConnection");
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(imageEncoder, "imageEncoder");
        m.checkNotNullParameter(tooltipManager, "tooltipManager");
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
        m.checkNotNullExpressionValue(behaviorSubjectK0, "BehaviorSubject.create()");
        this.thumbnailBitmapSubject = behaviorSubjectK0;
        this.compositeSubscription = new CompositeSubscription();
        subscribeToStores();
    }

    public static final /* synthetic */ ThumbnailEmitter access$createThumbnailEmitter(ScreenShareManager screenShareManager) {
        return screenShareManager.createThumbnailEmitter();
    }

    public static final /* synthetic */ CompositeSubscription access$getCompositeSubscription$p(ScreenShareManager screenShareManager) {
        return screenShareManager.compositeSubscription;
    }

    public static final /* synthetic */ ImageEncoder access$getImageEncoder$p(ScreenShareManager screenShareManager) {
        return screenShareManager.imageEncoder;
    }

    public static final /* synthetic */ ScreenShareManager$State access$getPreviousState$p(ScreenShareManager screenShareManager) {
        return screenShareManager.previousState;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(ScreenShareManager screenShareManager) {
        return screenShareManager.restAPI;
    }

    public static final /* synthetic */ Intent access$getScreenshareIntent$p(ScreenShareManager screenShareManager) {
        return screenShareManager.screenshareIntent;
    }

    public static final /* synthetic */ BehaviorSubject access$getThumbnailBitmapSubject$p(ScreenShareManager screenShareManager) {
        return screenShareManager.thumbnailBitmapSubject;
    }

    public static final /* synthetic */ void access$handleStartStream(ScreenShareManager screenShareManager, Intent intent) {
        screenShareManager.handleStartStream(intent);
    }

    public static final /* synthetic */ void access$handleStateUpdate(ScreenShareManager screenShareManager, ScreenShareManager$State screenShareManager$State) {
        screenShareManager.handleStateUpdate(screenShareManager$State);
    }

    public static final /* synthetic */ void access$setPreviousState$p(ScreenShareManager screenShareManager, ScreenShareManager$State screenShareManager$State) {
        screenShareManager.previousState = screenShareManager$State;
    }

    public static final /* synthetic */ void access$setScreenshareIntent$p(ScreenShareManager screenShareManager, Intent intent) {
        screenShareManager.screenshareIntent = intent;
    }

    public static final /* synthetic */ void access$uploadScreenSharePreviews(ScreenShareManager screenShareManager) {
        screenShareManager.uploadScreenSharePreviews();
    }

    private final ThumbnailEmitter createThumbnailEmitter() {
        return new ThumbnailEmitter(512, THUMBNAIL_HEIGHT_PX, 300000L, 5000L, null, new ScreenShareManager$createThumbnailEmitter$1(this), 16);
    }

    @MainThread
    private final void handleStartStream(Intent intent) {
        StoreApplicationStreaming.createStream$default(this.storeApplicationStreaming, this.channelId, this.guildId, null, 4, null);
        this.screenshareIntent = intent;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0040  */
    @MainThread
    private final void handleStateUpdate(ScreenShareManager$State state) {
        boolean z2;
        RtcConnection rtcConnection;
        ModelApplicationStream stream;
        RtcConnection rtcConnection2;
        StoreApplicationStreaming$ActiveApplicationStream activeStream;
        ModelApplicationStream stream2;
        ModelApplicationStream stream3;
        ScreenShareManager$State screenShareManager$State = this.previousState;
        boolean z3 = false;
        if ((screenShareManager$State != null ? screenShareManager$State.getActiveStream() : null) == null) {
            z2 = false;
        } else {
            StoreApplicationStreaming$ActiveApplicationStream activeStream2 = state.getActiveStream();
            String encodedStreamKey = (activeStream2 == null || (stream3 = activeStream2.getStream()) == null) ? null : stream3.getEncodedStreamKey();
            ScreenShareManager$State screenShareManager$State2 = this.previousState;
            if (!m.areEqual(encodedStreamKey, (screenShareManager$State2 == null || (activeStream = screenShareManager$State2.getActiveStream()) == null || (stream2 = activeStream.getStream()) == null) ? null : stream2.getEncodedStreamKey())) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        if (z2 && (rtcConnection2 = state.getRtcConnection()) != null) {
            rtcConnection2.t(null, null);
        }
        StoreApplicationStreaming$ActiveApplicationStream activeStream3 = state.getActiveStream();
        if (m.areEqual((activeStream3 == null || (stream = activeStream3.getStream()) == null) ? null : Long.valueOf(stream.getOwnerId()), state.getMeId())) {
            ScreenShareManager$State screenShareManager$State3 = this.previousState;
            if ((screenShareManager$State3 != null ? screenShareManager$State3.getRtcConnection() : null) == null && state.getRtcConnection() != null) {
                z3 = true;
            }
            if (z3 && (rtcConnection = state.getRtcConnection()) != null) {
                rtcConnection.c(new ScreenShareManager$RtcConnectionListener(this));
            }
            this.previousState = state;
        }
    }

    private final void subscribeToStores() {
        Observable observableR = Observable.i(this.storeApplicationStreaming.observeActiveStream(), this.storeStreamRtcConnection.observeRtcConnection(), StoreUser.observeMe$default(this.storeUser, false, 1, null), ScreenShareManager$subscribeToStores$1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR, this.appComponent, null, 2, null), ScreenShareManager.class, (Context) null, new ScreenShareManager$subscribeToStores$2(this), (Function1) null, (Function0) null, (Function0) null, new ScreenShareManager$subscribeToStores$3(this), 58, (Object) null);
    }

    private final void uploadScreenSharePreviews() {
        Observable<R> observableA = this.thumbnailBitmapSubject.A(new ScreenShareManager$uploadScreenSharePreviews$1(this));
        m.checkNotNullExpressionValue(observableA, "thumbnailBitmapSubject\n …>()\n          }\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableA, this.appComponent, null, 2, null), false, 1, null), ScreenShareManager.class, (Context) null, new ScreenShareManager$uploadScreenSharePreviews$2(this), (Function1) null, (Function0) null, (Function0) null, ScreenShareManager$uploadScreenSharePreviews$3.INSTANCE, 58, (Object) null);
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
        m.checkNotNullParameter(intent, "intent");
        Observable<RtcConnection$Metadata> observableZ = this.storeRtcConnection.observeRtcConnectionMetadata().y(new ScreenShareManager$startStream$1(this)).Z(1);
        m.checkNotNullExpressionValue(observableZ, "storeRtcConnection.obser…       }\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableZ, this.appComponent, null, 2, null), ScreenShareManager.class, (Context) null, new ScreenShareManager$startStream$2(this), (Function1) null, (Function0) null, (Function0) null, new ScreenShareManager$startStream$3(this, intent), 58, (Object) null);
    }

    public final void stopStream() {
        StoreApplicationStreaming$ActiveApplicationStream activeStream;
        ScreenShareManager$State screenShareManager$State = this.previousState;
        if (screenShareManager$State == null || (activeStream = screenShareManager$State.getActiveStream()) == null) {
            return;
        }
        this.storeApplicationStreaming.stopStream(activeStream.getStream().getEncodedStreamKey());
        this.screenshareIntent = null;
    }

    public ScreenShareManager(AppComponent appComponent, long j, Long l, StoreApplicationStreaming storeApplicationStreaming, StoreRtcConnection storeRtcConnection, StoreStreamRtcConnection storeStreamRtcConnection, StoreUser storeUser, RestAPI restAPI, ImageEncoder imageEncoder, TooltipManager tooltipManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        TooltipManager tooltipManager2;
        StoreApplicationStreaming applicationStreaming = (i & 8) != 0 ? StoreStream.Companion.getApplicationStreaming() : storeApplicationStreaming;
        StoreRtcConnection rtcConnection = (i & 16) != 0 ? StoreStream.Companion.getRtcConnection() : storeRtcConnection;
        StoreStreamRtcConnection streamRtcConnection = (i & 32) != 0 ? StoreStream.Companion.getStreamRtcConnection() : storeStreamRtcConnection;
        StoreUser users = (i & 64) != 0 ? StoreStream.Companion.getUsers() : storeUser;
        RestAPI api = (i & 128) != 0 ? RestAPI.Companion.getApi() : restAPI;
        ImageEncoder imageEncoder2 = (i & 256) != 0 ? new ImageEncoder() : imageEncoder;
        if ((i & 512) != 0) {
            AppLog appLog = AppLog.g;
            m.checkNotNullParameter(appLog, "logger");
            WeakReference<a> weakReference = a$b.a;
            a aVar = weakReference != null ? weakReference.get() : null;
            if (aVar == null) {
                aVar = new a(appLog);
                a$b.a = new WeakReference<>(aVar);
            }
            TooltipManager$a tooltipManager$a = TooltipManager$a.d;
            m.checkNotNullParameter(aVar, "floatingViewManager");
            WeakReference<TooltipManager> weakReference2 = TooltipManager$a.a;
            TooltipManager tooltipManager3 = weakReference2 != null ? weakReference2.get() : null;
            if (tooltipManager3 == null) {
                TooltipManager tooltipManager4 = new TooltipManager((b.a.v.a) TooltipManager$a.f2815b.getValue(), (Set) TooltipManager$a.c.getValue(), 0, aVar, 4);
                TooltipManager$a.a = new WeakReference<>(tooltipManager4);
                tooltipManager3 = tooltipManager4;
            }
            tooltipManager2 = tooltipManager3;
        } else {
            tooltipManager2 = tooltipManager;
        }
        this(appComponent, j, l, applicationStreaming, rtcConnection, streamRtcConnection, users, api, imageEncoder2, tooltipManager2);
    }
}
