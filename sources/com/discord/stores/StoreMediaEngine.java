package com.discord.stores;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import b.a.q.k0.g$a;
import b.i.a.f.e.o.f;
import co.discord.media_engine.RtcRegion;
import co.discord.media_engine.VideoInputDeviceDescription;
import co.discord.media_engine.VideoInputDeviceFacing;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelRtcLatencyRegion;
import com.discord.rtcconnection.KrispOveruseDetector$Status;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.rtcconnection.mediaengine.MediaEngine$LocalVoiceStatus;
import com.discord.rtcconnection.mediaengine.MediaEngine$OpenSLESConfig;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.utilities.collections.ListenerCollection;
import com.discord.utilities.collections.ListenerCollectionSubject;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import com.hammerandchisel.libdiscord.Discord;
import d0.l;
import d0.t.j;
import d0.t.k;
import d0.t.o;
import d0.w.h.b;
import d0.w.h.c;
import d0.w.i.a.g;
import d0.z.d.m;
import j0.l.a.c0;
import j0.l.a.g1;
import j0.l.a.h1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineDispatcher;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import s.a.a.n;
import s.a.h;
import s.a.k0;
import s.a.x0;

/* JADX INFO: compiled from: StoreMediaEngine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMediaEngine extends Store {
    private static final String DEFAULT_VIDEO_DEVICE_GUID = "";
    private static final long MAX_WAIT_FOR_DEVICES_MS = 750;
    private final Dispatcher dispatcher;
    private boolean hasNativeEngineEverInitialized;
    private Persister<Boolean> hasNativeEngineEverInitializedCache;
    private boolean hasTimedOutAwaitingDevice;
    private final SerializedSubject<Boolean, Boolean> isNativeEngineInitializedSubject;
    private final ListenerCollectionSubject<StoreMediaEngine$Listener> listenerSubject;
    private final ListenerCollection<StoreMediaEngine$Listener> listeners;
    private final Observable<MediaEngine$LocalVoiceStatus> localVoiceStatus;
    private final SerializedSubject<MediaEngine$LocalVoiceStatus, MediaEngine$LocalVoiceStatus> localVoiceStatusSubject;
    private MediaEngine mediaEngine;
    private Subscription mediaEngineSettingsSubscription;
    private final StoreMediaSettings mediaSettingsStore;
    private final PublishSubject<KrispOveruseDetector$Status> onKrispStatusSubject;
    private final SerializedSubject<MediaEngine$OpenSLESConfig, MediaEngine$OpenSLESConfig> openSLESConfigSubject;
    private String preferredVideoInputDeviceGUID;
    private final Persister<String> preferredVideoInputDeviceGuidCache;
    private Long previousVoiceChannelId;
    private final SerializedSubject<Boolean, Boolean> pttActiveSubject;
    private VideoInputDeviceDescription selectedVideoInputDevice;
    private final BehaviorSubject<VideoInputDeviceDescription> selectedVideoInputDeviceSubject;
    private final StoreStream storeStream;
    private long userId;
    private VideoInputDeviceDescription[] videoInputDevices;
    private final BehaviorSubject<List<VideoInputDeviceDescription>> videoInputDevicesSubject;
    public static final StoreMediaEngine$Companion Companion = new StoreMediaEngine$Companion(null);
    private static final MediaEngine$LocalVoiceStatus LOCAL_VOICE_STATUS_DEFAULT = new MediaEngine$LocalVoiceStatus(-100.0f, false);
    private static final MediaEngine$OpenSLESConfig DEFAULT_OPENSLES_CONFIG = MediaEngine$OpenSLESConfig.DEFAULT;

    public StoreMediaEngine(StoreMediaSettings storeMediaSettings, StoreStream storeStream, Dispatcher dispatcher) {
        m.checkNotNullParameter(storeMediaSettings, "mediaSettingsStore");
        m.checkNotNullParameter(storeStream, "storeStream");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        this.mediaSettingsStore = storeMediaSettings;
        this.storeStream = storeStream;
        this.dispatcher = dispatcher;
        ListenerCollectionSubject<StoreMediaEngine$Listener> listenerCollectionSubject = new ListenerCollectionSubject<>();
        this.listenerSubject = listenerCollectionSubject;
        this.listeners = listenerCollectionSubject;
        SerializedSubject<MediaEngine$LocalVoiceStatus, MediaEngine$LocalVoiceStatus> serializedSubject = new SerializedSubject<>(BehaviorSubject.l0(LOCAL_VOICE_STATUS_DEFAULT));
        this.localVoiceStatusSubject = serializedSubject;
        Boolean bool = Boolean.FALSE;
        this.pttActiveSubject = new SerializedSubject<>(BehaviorSubject.l0(bool));
        this.preferredVideoInputDeviceGUID = "";
        this.preferredVideoInputDeviceGuidCache = new Persister<>("PREFERRED_VIDEO_INPUT_DEVICE_GUID", this.preferredVideoInputDeviceGUID);
        this.selectedVideoInputDeviceSubject = BehaviorSubject.l0(this.selectedVideoInputDevice);
        VideoInputDeviceDescription[] videoInputDeviceDescriptionArr = new VideoInputDeviceDescription[0];
        this.videoInputDevices = videoInputDeviceDescriptionArr;
        this.videoInputDevicesSubject = BehaviorSubject.l0(j.asList(videoInputDeviceDescriptionArr));
        this.openSLESConfigSubject = new SerializedSubject<>(BehaviorSubject.k0());
        this.isNativeEngineInitializedSubject = new SerializedSubject<>(BehaviorSubject.l0(bool));
        this.userId = -1L;
        this.hasNativeEngineEverInitializedCache = new Persister<>("CACHE_KEY_NATIVE_ENGINE_EVER_INITIALIZED", Boolean.valueOf(this.hasNativeEngineEverInitialized));
        this.onKrispStatusSubject = PublishSubject.k0();
        Observable observableW = ObservableExtensionsKt.computationLatest(serializedSubject).r().v(new StoreMediaEngine$sam$rx_functions_Action0$0(new StoreMediaEngine$localVoiceStatus$1(this))).w(new StoreMediaEngine$sam$rx_functions_Action0$0(new StoreMediaEngine$localVoiceStatus$2(this)));
        AtomicReference atomicReference = new AtomicReference();
        Observable<MediaEngine$LocalVoiceStatus> observableH0 = Observable.h0(new c0(new h1(new g1(atomicReference), observableW, atomicReference)));
        m.checkNotNullExpressionValue(observableH0, "localVoiceStatusSubject\n…ening)\n          .share()");
        this.localVoiceStatus = observableH0;
    }

    public static final /* synthetic */ void access$disableLocalVoiceStatusListening(StoreMediaEngine storeMediaEngine) {
        storeMediaEngine.disableLocalVoiceStatusListening();
    }

    public static final /* synthetic */ void access$enableLocalVoiceStatusListening(StoreMediaEngine storeMediaEngine) {
        storeMediaEngine.enableLocalVoiceStatusListening();
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreMediaEngine storeMediaEngine) {
        return storeMediaEngine.dispatcher;
    }

    public static final /* synthetic */ boolean access$getHasTimedOutAwaitingDevice$p(StoreMediaEngine storeMediaEngine) {
        return storeMediaEngine.hasTimedOutAwaitingDevice;
    }

    public static final /* synthetic */ ListenerCollectionSubject access$getListenerSubject$p(StoreMediaEngine storeMediaEngine) {
        return storeMediaEngine.listenerSubject;
    }

    public static final /* synthetic */ MediaEngine access$getMediaEngine$p(StoreMediaEngine storeMediaEngine) {
        MediaEngine mediaEngine = storeMediaEngine.mediaEngine;
        if (mediaEngine == null) {
            m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        return mediaEngine;
    }

    public static final /* synthetic */ Subscription access$getMediaEngineSettingsSubscription$p(StoreMediaEngine storeMediaEngine) {
        return storeMediaEngine.mediaEngineSettingsSubscription;
    }

    public static final /* synthetic */ StoreMediaSettings access$getMediaSettingsStore$p(StoreMediaEngine storeMediaEngine) {
        return storeMediaEngine.mediaSettingsStore;
    }

    public static final /* synthetic */ PublishSubject access$getOnKrispStatusSubject$p(StoreMediaEngine storeMediaEngine) {
        return storeMediaEngine.onKrispStatusSubject;
    }

    public static final /* synthetic */ VideoInputDeviceDescription access$getSelectedVideoInputDevice$p(StoreMediaEngine storeMediaEngine) {
        return storeMediaEngine.selectedVideoInputDevice;
    }

    public static final /* synthetic */ void access$getVideoInputDevicesNative(StoreMediaEngine storeMediaEngine, Function1 function1) {
        storeMediaEngine.getVideoInputDevicesNative(function1);
    }

    public static final /* synthetic */ void access$handleNativeEngineInitialized(StoreMediaEngine storeMediaEngine) {
        storeMediaEngine.handleNativeEngineInitialized();
    }

    public static final /* synthetic */ void access$handleNewConnection(StoreMediaEngine storeMediaEngine, MediaEngineConnection mediaEngineConnection) {
        storeMediaEngine.handleNewConnection(mediaEngineConnection);
    }

    public static final /* synthetic */ void access$handleVideoInputDevices(StoreMediaEngine storeMediaEngine, VideoInputDeviceDescription[] videoInputDeviceDescriptionArr, String str, Function1 function1) {
        storeMediaEngine.handleVideoInputDevices(videoInputDeviceDescriptionArr, str, function1);
    }

    public static final /* synthetic */ void access$handleVoiceConfigChanged(StoreMediaEngine storeMediaEngine, StoreMediaSettings$VoiceConfiguration storeMediaSettings$VoiceConfiguration) {
        storeMediaEngine.handleVoiceConfigChanged(storeMediaSettings$VoiceConfiguration);
    }

    public static final /* synthetic */ String access$pickDefaultDeviceGUID(StoreMediaEngine storeMediaEngine, VideoInputDeviceDescription[] videoInputDeviceDescriptionArr) {
        return storeMediaEngine.pickDefaultDeviceGUID(videoInputDeviceDescriptionArr);
    }

    public static final /* synthetic */ void access$restartLocalMicrophone(StoreMediaEngine storeMediaEngine) {
        storeMediaEngine.restartLocalMicrophone();
    }

    public static final /* synthetic */ void access$setHasTimedOutAwaitingDevice$p(StoreMediaEngine storeMediaEngine, boolean z2) {
        storeMediaEngine.hasTimedOutAwaitingDevice = z2;
    }

    public static final /* synthetic */ void access$setMediaEngine$p(StoreMediaEngine storeMediaEngine, MediaEngine mediaEngine) {
        storeMediaEngine.mediaEngine = mediaEngine;
    }

    public static final /* synthetic */ void access$setMediaEngineSettingsSubscription$p(StoreMediaEngine storeMediaEngine, Subscription subscription) {
        storeMediaEngine.mediaEngineSettingsSubscription = subscription;
    }

    public static final /* synthetic */ void access$setSelectedVideoInputDevice$p(StoreMediaEngine storeMediaEngine, VideoInputDeviceDescription videoInputDeviceDescription) {
        storeMediaEngine.selectedVideoInputDevice = videoInputDeviceDescription;
    }

    private final synchronized void disableLocalVoiceStatusListening() {
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine.l(null);
    }

    private final synchronized void enableLocalVoiceStatusListening() {
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine.l(new StoreMediaEngine$enableLocalVoiceStatusListening$1(this.localVoiceStatusSubject));
    }

    private final synchronized void getVideoInputDevicesNative(Function1<? super VideoInputDeviceDescription[], Unit> callback) {
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine.j(new StoreMediaEngine$getVideoInputDevicesNative$1(callback));
    }

    private final synchronized void handleNativeEngineInitialized() {
        this.hasNativeEngineEverInitialized = true;
        Persister<Boolean> persister = this.hasNativeEngineEverInitializedCache;
        Boolean bool = Boolean.TRUE;
        persister.set(bool, true);
        this.isNativeEngineInitializedSubject.k.onNext(bool);
    }

    private final synchronized void handleNewConnection(MediaEngineConnection connection) {
        setupMediaEngineSettingsSubscription();
        connection.l(new StoreMediaEngine$handleNewConnection$1(this));
        getVideoInputDevicesNative(new StoreMediaEngine$handleNewConnection$2(this));
    }

    private final synchronized void handleVideoInputDevices(VideoInputDeviceDescription[] videoInputDevices, String deviceGUID, Function1<? super String, Unit> onSelected) {
        String guid;
        int length = videoInputDevices.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (m.areEqual(videoInputDevices[i].getGuid(), deviceGUID)) {
                break;
            } else {
                i++;
            }
        }
        boolean z2 = i >= 0;
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine.f(-1);
        MediaEngine mediaEngine2 = this.mediaEngine;
        if (mediaEngine2 == null) {
            m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine2.f(i);
        MediaEngine mediaEngine3 = this.mediaEngine;
        if (mediaEngine3 == null) {
            m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        for (MediaEngineConnection mediaEngineConnection : mediaEngine3.getConnections()) {
            if (mediaEngineConnection.getType().ordinal() == 0) {
                mediaEngineConnection.j(z2);
            }
        }
        if (onSelected != null) {
            if (!z2) {
                deviceGUID = null;
            }
            onSelected.invoke(deviceGUID);
        }
        updateSelectedVideoInputDevice(z2 ? videoInputDevices[i] : null);
        this.videoInputDevices = videoInputDevices;
        this.videoInputDevicesSubject.onNext(j.asList(videoInputDevices));
        VideoInputDeviceDescription videoInputDeviceDescription = this.selectedVideoInputDevice;
        if (videoInputDeviceDescription != null) {
            if (videoInputDeviceDescription == null || (guid = videoInputDeviceDescription.getGuid()) == null) {
                guid = "";
            }
            this.preferredVideoInputDeviceGUID = guid;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void handleVideoInputDevices$default(StoreMediaEngine storeMediaEngine, VideoInputDeviceDescription[] videoInputDeviceDescriptionArr, String str, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        storeMediaEngine.handleVideoInputDevices(videoInputDeviceDescriptionArr, str, function1);
    }

    @StoreThread
    private final synchronized void handleVoiceConfigChanged(StoreMediaSettings$VoiceConfiguration voiceConfig) {
        if (voiceConfig != null) {
            MediaEngine mediaEngine = this.mediaEngine;
            if (mediaEngine == null) {
                m.throwUninitializedPropertyAccessException("mediaEngine");
            }
            mediaEngine.d(voiceConfig.toMediaEngineVoiceConfig());
        }
    }

    private final String pickDefaultDeviceGUID(VideoInputDeviceDescription[] videoInputDeviceDescriptionArr) {
        boolean z2;
        VideoInputDeviceDescription videoInputDeviceDescription;
        int length = videoInputDeviceDescriptionArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z2 = false;
                break;
            }
            if (m.areEqual(videoInputDeviceDescriptionArr[i].getGuid(), this.preferredVideoInputDeviceGUID)) {
                z2 = true;
                break;
            }
            i++;
        }
        if (z2) {
            return this.preferredVideoInputDeviceGUID;
        }
        int length2 = videoInputDeviceDescriptionArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length2) {
                videoInputDeviceDescription = null;
                break;
            }
            videoInputDeviceDescription = videoInputDeviceDescriptionArr[i2];
            if (videoInputDeviceDescription.getFacing() == VideoInputDeviceFacing.Front) {
                break;
            }
            i2++;
        }
        if (videoInputDeviceDescription == null) {
            videoInputDeviceDescription = (VideoInputDeviceDescription) k.firstOrNull(videoInputDeviceDescriptionArr);
        }
        if (videoInputDeviceDescription != null) {
            return videoInputDeviceDescription.getGuid();
        }
        return null;
    }

    private final synchronized void restartLocalMicrophone() {
        enableLocalVoiceStatusListening();
        disableLocalVoiceStatusListening();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void selectDefaultVideoDevice$default(StoreMediaEngine storeMediaEngine, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        storeMediaEngine.selectDefaultVideoDevice(function1);
    }

    private final synchronized void setupMediaEngineSettingsSubscription() {
        Subscription subscription = this.mediaEngineSettingsSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Observable<StoreMediaSettings$VoiceConfiguration> voiceConfig = this.mediaSettingsStore.getVoiceConfig();
        Class<?> cls = getClass();
        StoreMediaEngine$setupMediaEngineSettingsSubscription$1 storeMediaEngine$setupMediaEngineSettingsSubscription$1 = new StoreMediaEngine$setupMediaEngineSettingsSubscription$1(this);
        ObservableExtensionsKt.appSubscribe$default(voiceConfig, cls, (Context) null, new StoreMediaEngine$setupMediaEngineSettingsSubscription$3(this), StoreMediaEngine$setupMediaEngineSettingsSubscription$2.INSTANCE, (Function0) null, (Function0) null, storeMediaEngine$setupMediaEngineSettingsSubscription$1, 50, (Object) null);
    }

    private final synchronized void updateSelectedVideoInputDevice(VideoInputDeviceDescription selectedVideoInputDevice) {
        this.selectedVideoInputDevice = selectedVideoInputDevice;
        this.selectedVideoInputDeviceSubject.onNext(selectedVideoInputDevice);
        this.storeStream.handleVideoInputDeviceSelected(selectedVideoInputDevice);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final /* synthetic */ Object awaitVideoInputDevicesNativeAsync(Continuation<? super VideoInputDeviceDescription[]> continuation) {
        StoreMediaEngine$awaitVideoInputDevicesNativeAsync$1 storeMediaEngine$awaitVideoInputDevicesNativeAsync$1;
        StoreMediaEngine storeMediaEngine;
        if (continuation instanceof StoreMediaEngine$awaitVideoInputDevicesNativeAsync$1) {
            storeMediaEngine$awaitVideoInputDevicesNativeAsync$1 = (StoreMediaEngine$awaitVideoInputDevicesNativeAsync$1) continuation;
            int i = storeMediaEngine$awaitVideoInputDevicesNativeAsync$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                storeMediaEngine$awaitVideoInputDevicesNativeAsync$1.label = i - Integer.MIN_VALUE;
            } else {
                storeMediaEngine$awaitVideoInputDevicesNativeAsync$1 = new StoreMediaEngine$awaitVideoInputDevicesNativeAsync$1(this, continuation);
            }
        } else {
            storeMediaEngine$awaitVideoInputDevicesNativeAsync$1 = new StoreMediaEngine$awaitVideoInputDevicesNativeAsync$1(this, continuation);
        }
        Object objB = storeMediaEngine$awaitVideoInputDevicesNativeAsync$1.result;
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i2 = storeMediaEngine$awaitVideoInputDevicesNativeAsync$1.label;
        boolean z2 = true;
        if (i2 == 0) {
            l.throwOnFailure(objB);
            StoreMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1 storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1 = new StoreMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1(this, null);
            storeMediaEngine$awaitVideoInputDevicesNativeAsync$1.L$0 = this;
            storeMediaEngine$awaitVideoInputDevicesNativeAsync$1.label = 1;
            objB = h.b(MAX_WAIT_FOR_DEVICES_MS, storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1, storeMediaEngine$awaitVideoInputDevicesNativeAsync$1);
            if (objB == coroutine_suspended) {
                return coroutine_suspended;
            }
            storeMediaEngine = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            storeMediaEngine = (StoreMediaEngine) storeMediaEngine$awaitVideoInputDevicesNativeAsync$1.L$0;
            l.throwOnFailure(objB);
        }
        VideoInputDeviceDescription[] videoInputDeviceDescriptionArr = (VideoInputDeviceDescription[]) objB;
        if (!storeMediaEngine.hasTimedOutAwaitingDevice && videoInputDeviceDescriptionArr != null) {
            z2 = false;
        }
        storeMediaEngine.hasTimedOutAwaitingDevice = z2;
        return videoInputDeviceDescriptionArr != null ? videoInputDeviceDescriptionArr : new VideoInputDeviceDescription[0];
    }

    public final synchronized void cycleVideoInputDevice() {
        int iIndexOf = k.indexOf(this.videoInputDevices, this.selectedVideoInputDevice);
        if (iIndexOf < 0) {
            return;
        }
        selectVideoInputDevice(this.videoInputDevices[iIndexOf == k.getLastIndex(this.videoInputDevices) ? 0 : iIndexOf + 1].getGuid());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getDefaultVideoDeviceGUID(Continuation<? super String> continuation) {
        StoreMediaEngine$getDefaultVideoDeviceGUID$1 storeMediaEngine$getDefaultVideoDeviceGUID$1;
        StoreMediaEngine storeMediaEngine;
        if (continuation instanceof StoreMediaEngine$getDefaultVideoDeviceGUID$1) {
            storeMediaEngine$getDefaultVideoDeviceGUID$1 = (StoreMediaEngine$getDefaultVideoDeviceGUID$1) continuation;
            int i = storeMediaEngine$getDefaultVideoDeviceGUID$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                storeMediaEngine$getDefaultVideoDeviceGUID$1.label = i - Integer.MIN_VALUE;
            } else {
                storeMediaEngine$getDefaultVideoDeviceGUID$1 = new StoreMediaEngine$getDefaultVideoDeviceGUID$1(this, continuation);
            }
        } else {
            storeMediaEngine$getDefaultVideoDeviceGUID$1 = new StoreMediaEngine$getDefaultVideoDeviceGUID$1(this, continuation);
        }
        Object objAwaitVideoInputDevicesNativeAsync = storeMediaEngine$getDefaultVideoDeviceGUID$1.result;
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i2 = storeMediaEngine$getDefaultVideoDeviceGUID$1.label;
        if (i2 == 0) {
            l.throwOnFailure(objAwaitVideoInputDevicesNativeAsync);
            storeMediaEngine$getDefaultVideoDeviceGUID$1.L$0 = this;
            storeMediaEngine$getDefaultVideoDeviceGUID$1.label = 1;
            objAwaitVideoInputDevicesNativeAsync = awaitVideoInputDevicesNativeAsync(storeMediaEngine$getDefaultVideoDeviceGUID$1);
            if (objAwaitVideoInputDevicesNativeAsync == coroutine_suspended) {
                return coroutine_suspended;
            }
            storeMediaEngine = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            storeMediaEngine = (StoreMediaEngine) storeMediaEngine$getDefaultVideoDeviceGUID$1.L$0;
            l.throwOnFailure(objAwaitVideoInputDevicesNativeAsync);
        }
        return storeMediaEngine.pickDefaultDeviceGUID((VideoInputDeviceDescription[]) objAwaitVideoInputDevicesNativeAsync);
    }

    public final Observable<Boolean> getIsNativeEngineInitialized() {
        return this.isNativeEngineInitializedSubject;
    }

    public final ListenerCollection<StoreMediaEngine$Listener> getListeners() {
        return this.listeners;
    }

    public final Observable<MediaEngine$LocalVoiceStatus> getLocalVoiceStatus() {
        return this.localVoiceStatus;
    }

    public final MediaEngine getMediaEngine() {
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        return mediaEngine;
    }

    public final Observable<MediaEngine$OpenSLESConfig> getOpenSLESConfig() {
        return this.openSLESConfigSubject;
    }

    public final synchronized void getRankedRtcRegions(List<ModelRtcLatencyRegion> regionsWithIps, Function1<? super List<String>, Unit> callback) {
        m.checkNotNullParameter(regionsWithIps, "regionsWithIps");
        m.checkNotNullParameter(callback, "callback");
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(regionsWithIps, 10));
        for (ModelRtcLatencyRegion modelRtcLatencyRegion : regionsWithIps) {
            String region = modelRtcLatencyRegion.getRegion();
            Object[] array = modelRtcLatencyRegion.getIps().toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            arrayList.add(new RtcRegion(region, (String[]) array));
        }
        Object[] array2 = arrayList.toArray(new RtcRegion[0]);
        if (array2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        RtcRegion[] rtcRegionArr = (RtcRegion[]) array2;
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine.b(rtcRegionArr, new StoreMediaEngine$getRankedRtcRegions$1(callback));
    }

    public final Observable<VideoInputDeviceDescription> getSelectedVideoInputDevice() {
        Observable<VideoInputDeviceDescription> observableR = this.selectedVideoInputDeviceSubject.r();
        m.checkNotNullExpressionValue(observableR, "selectedVideoInputDevice…  .distinctUntilChanged()");
        return observableR;
    }

    /* JADX INFO: renamed from: getSelectedVideoInputDeviceBlocking, reason: from getter */
    public final VideoInputDeviceDescription getSelectedVideoInputDevice() {
        return this.selectedVideoInputDevice;
    }

    public final Observable<List<VideoInputDeviceDescription>> getVideoInputDevices() {
        Observable<List<VideoInputDeviceDescription>> observableR = this.videoInputDevicesSubject.r();
        m.checkNotNullExpressionValue(observableR, "videoInputDevicesSubject…  .distinctUntilChanged()");
        return observableR;
    }

    public final Object getVideoInputDevicesNativeAsync(Continuation<? super VideoInputDeviceDescription[]> continuation) {
        s.a.l lVar = new s.a.l(b.intercepted(continuation), 1);
        lVar.A();
        access$getVideoInputDevicesNative(this, new StoreMediaEngine$getVideoInputDevicesNativeAsync$2$1(lVar));
        Object objU = lVar.u();
        if (objU == c.getCOROUTINE_SUSPENDED()) {
            g.probeCoroutineSuspended(continuation);
        }
        return objU;
    }

    public final synchronized Discord getVoiceEngineNative() {
        MediaEngine mediaEngine;
        mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        return mediaEngine.i();
    }

    public final synchronized void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        this.userId = payload.getMe().getId();
    }

    public final void handleMicrophonePermissionGranted() {
        Observable<Boolean> observableZ = this.isNativeEngineInitializedSubject.Z(1);
        m.checkNotNullExpressionValue(observableZ, "isNativeEngineInitializedSubject\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(observableZ, StoreMediaEngine.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreMediaEngine$handleMicrophonePermissionGranted$1(this), 62, (Object) null);
    }

    public final synchronized void handleVoiceChannelSelected(long channelId) {
        Long l = this.previousVoiceChannelId;
        if (l != null && (l == null || l.longValue() != 0)) {
            if (channelId == 0) {
                getVideoInputDevicesNative(new StoreMediaEngine$handleVoiceChannelSelected$1(this));
            }
        }
        this.previousVoiceChannelId = Long.valueOf(channelId);
    }

    public final synchronized boolean hasNativeEngineEverInitialized() {
        return this.hasNativeEngineEverInitialized;
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        m.checkNotNullParameter(context, "context");
        super.init(context);
        this.preferredVideoInputDeviceGUID = this.preferredVideoInputDeviceGuidCache.get();
        this.hasNativeEngineEverInitialized = this.hasNativeEngineEverInitializedCache.get().booleanValue();
        SharedPreferences prefsSessionDurable = getPrefsSessionDurable();
        MediaEngine$OpenSLESConfig mediaEngine$OpenSLESConfig = DEFAULT_OPENSLES_CONFIG;
        String string = prefsSessionDurable.getString("OPEN_SLES", mediaEngine$OpenSLESConfig.name());
        if (string == null) {
            string = mediaEngine$OpenSLESConfig.name();
        }
        m.checkNotNullExpressionValue(string, "prefsSessionDurable\n    …AULT_OPENSLES_CONFIG.name");
        MediaEngine$OpenSLESConfig mediaEngine$OpenSLESConfigValueOf = MediaEngine$OpenSLESConfig.valueOf(string);
        this.openSLESConfigSubject.k.onNext(mediaEngine$OpenSLESConfigValueOf);
        StoreMediaEngine$init$echoCancellationCallback$1 storeMediaEngine$init$echoCancellationCallback$1 = new StoreMediaEngine$init$echoCancellationCallback$1(this);
        StoreMediaEngine$EngineListener storeMediaEngine$EngineListener = new StoreMediaEngine$EngineListener(this);
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        m.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "Executors.newSingleThreadExecutor()");
        AppLog appLog = AppLog.g;
        g$a g_a = b.a.q.k0.g.c;
        b.a.q.k0.g gVar = b.a.q.k0.g.f264b;
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(storeMediaEngine$EngineListener, "listener");
        m.checkNotNullParameter(executorServiceNewSingleThreadExecutor, "singleThreadExecutorService");
        m.checkNotNullParameter(mediaEngine$OpenSLESConfigValueOf, "openSLESConfig");
        m.checkNotNullParameter(appLog, "logger");
        m.checkNotNullParameter(gVar, "echoCancellation");
        m.checkNotNullParameter(storeMediaEngine$init$echoCancellationCallback$1, "echoCancellationCallback");
        this.mediaEngine = new b.a.q.m0.c.k(context, storeMediaEngine$EngineListener, new b.a.q.c(executorServiceNewSingleThreadExecutor, false), mediaEngine$OpenSLESConfigValueOf, appLog, gVar, storeMediaEngine$init$echoCancellationCallback$1, null, null, 384);
        Observable<R> observableG = this.storeStream.getExperiments().observeUserExperiment("2021-05_opensl_default_enable_android", true).y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableZ = observableG.Z(1);
        m.checkNotNullExpressionValue(observableZ, "storeStream.experiments.…erNull()\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(observableZ), StoreMediaEngine.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreMediaEngine$init$1(this), 62, (Object) null);
    }

    public final Observable<KrispOveruseDetector$Status> onKrispStatusEvent() {
        PublishSubject<KrispOveruseDetector$Status> publishSubject = this.onKrispStatusSubject;
        m.checkNotNullExpressionValue(publishSubject, "onKrispStatusSubject");
        return publishSubject;
    }

    public final void selectDefaultVideoDevice(Function1<? super String, Unit> onSelected) {
        x0 x0Var = x0.j;
        CoroutineDispatcher coroutineDispatcher = k0.a;
        f.H0(x0Var, n.f3830b.H(), null, new StoreMediaEngine$selectDefaultVideoDevice$1(this, onSelected, null), 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object selectDefaultVideoDeviceAsync(Continuation<? super String> continuation) {
        StoreMediaEngine$selectDefaultVideoDeviceAsync$1 storeMediaEngine$selectDefaultVideoDeviceAsync$1;
        StoreMediaEngine storeMediaEngine;
        if (continuation instanceof StoreMediaEngine$selectDefaultVideoDeviceAsync$1) {
            storeMediaEngine$selectDefaultVideoDeviceAsync$1 = (StoreMediaEngine$selectDefaultVideoDeviceAsync$1) continuation;
            int i = storeMediaEngine$selectDefaultVideoDeviceAsync$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                storeMediaEngine$selectDefaultVideoDeviceAsync$1.label = i - Integer.MIN_VALUE;
            } else {
                storeMediaEngine$selectDefaultVideoDeviceAsync$1 = new StoreMediaEngine$selectDefaultVideoDeviceAsync$1(this, continuation);
            }
        } else {
            storeMediaEngine$selectDefaultVideoDeviceAsync$1 = new StoreMediaEngine$selectDefaultVideoDeviceAsync$1(this, continuation);
        }
        Object objAwaitVideoInputDevicesNativeAsync = storeMediaEngine$selectDefaultVideoDeviceAsync$1.result;
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i2 = storeMediaEngine$selectDefaultVideoDeviceAsync$1.label;
        if (i2 == 0) {
            l.throwOnFailure(objAwaitVideoInputDevicesNativeAsync);
            storeMediaEngine$selectDefaultVideoDeviceAsync$1.L$0 = this;
            storeMediaEngine$selectDefaultVideoDeviceAsync$1.label = 1;
            objAwaitVideoInputDevicesNativeAsync = awaitVideoInputDevicesNativeAsync(storeMediaEngine$selectDefaultVideoDeviceAsync$1);
            if (objAwaitVideoInputDevicesNativeAsync == coroutine_suspended) {
                return coroutine_suspended;
            }
            storeMediaEngine = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            storeMediaEngine = (StoreMediaEngine) storeMediaEngine$selectDefaultVideoDeviceAsync$1.L$0;
            l.throwOnFailure(objAwaitVideoInputDevicesNativeAsync);
        }
        VideoInputDeviceDescription[] videoInputDeviceDescriptionArr = (VideoInputDeviceDescription[]) objAwaitVideoInputDevicesNativeAsync;
        String strPickDefaultDeviceGUID = storeMediaEngine.pickDefaultDeviceGUID(videoInputDeviceDescriptionArr);
        handleVideoInputDevices$default(storeMediaEngine, videoInputDeviceDescriptionArr, strPickDefaultDeviceGUID, null, 4, null);
        return strPickDefaultDeviceGUID;
    }

    public final void selectVideoInputDevice(String deviceGUID) {
        getVideoInputDevicesNative(new StoreMediaEngine$selectVideoInputDevice$1(this, deviceGUID));
    }

    public final synchronized void setAudioInputEnabled(boolean audioInputEnabled) {
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine.k(audioInputEnabled);
    }

    @SuppressLint({"ApplySharedPref"})
    public final synchronized void setOpenSLESConfig(MediaEngine$OpenSLESConfig openSLESConfig) {
        m.checkNotNullParameter(openSLESConfig, "openSLESConfig");
        this.openSLESConfigSubject.k.onNext(openSLESConfig);
        getPrefsSessionDurable().edit().putString("OPEN_SLES", openSLESConfig.name()).commit();
    }

    public final synchronized void setPttActive(boolean active) {
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        Iterator<T> it = mediaEngine.getConnections().iterator();
        while (it.hasNext()) {
            ((MediaEngineConnection) it.next()).q(active);
        }
        SerializedSubject<Boolean, Boolean> serializedSubject = this.pttActiveSubject;
        serializedSubject.k.onNext(Boolean.valueOf(active));
    }
}
