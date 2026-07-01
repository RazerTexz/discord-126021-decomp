package com.discord.stores;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import b.a.q.MediaEngineExecutorService;
import b.a.q.ThermalDetector;
import b.a.q.k0.EchoCancellation;
import b.a.q.m0.c.k;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.e.o.f;
import co.discord.media_engine.DeviceDescription4;
import co.discord.media_engine.DeviceDescription5;
import co.discord.media_engine.RtcRegion;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelRtcLatencyRegion;
import com.discord.models.experiments.domain.Experiment;
import com.discord.rtcconnection.KrispOveruseDetector;
import com.discord.rtcconnection.LowMemoryDetector;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.stores.StoreMediaSettings;
import com.discord.utilities.collections.ListenerCollection;
import com.discord.utilities.collections.ListenerCollection2;
import com.discord.utilities.error.Error;
import com.discord.utilities.lifecycle.ApplicationProvider;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.systemlog.SystemLogUtils;
import com.hammerandchisel.libdiscord.Discord;
import d0.Result3;
import d0.t.Iterables2;
import d0.t._Arrays;
import d0.t._ArraysJvm;
import d0.t._Collections;
import d0.w.h.Intrinsics2;
import d0.w.h.IntrinsicsJvm;
import d0.w.i.a.ContinuationImpl3;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.w.i.a.DebugProbes;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.l.a.OnSubscribeRefCount3;
import j0.l.a.OperatorPublish;
import j0.l.a.OperatorPublish2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action0;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import s.a.Builders5;
import s.a.CancellableContinuationImpl5;
import s.a.CoroutineScope2;
import s.a.Dispatchers;
import s.a.a.MainDispatchers;

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
    private final ListenerCollection2<Listener> listenerSubject;
    private final ListenerCollection<Listener> listeners;
    private final Observable<MediaEngine.LocalVoiceStatus> localVoiceStatus;
    private final SerializedSubject<MediaEngine.LocalVoiceStatus, MediaEngine.LocalVoiceStatus> localVoiceStatusSubject;
    private MediaEngine mediaEngine;
    private Subscription mediaEngineSettingsSubscription;
    private final StoreMediaSettings mediaSettingsStore;
    private final PublishSubject<KrispOveruseDetector.Status> onKrispStatusSubject;
    private final SerializedSubject<MediaEngine.OpenSLESConfig, MediaEngine.OpenSLESConfig> openSLESConfigSubject;
    private String preferredVideoInputDeviceGUID;
    private final Persister<String> preferredVideoInputDeviceGuidCache;
    private Long previousVoiceChannelId;
    private final SerializedSubject<Boolean, Boolean> pttActiveSubject;
    private DeviceDescription4 selectedVideoInputDevice;
    private final BehaviorSubject<DeviceDescription4> selectedVideoInputDeviceSubject;
    private final StoreStream storeStream;
    private long userId;
    private DeviceDescription4[] videoInputDevices;
    private final BehaviorSubject<List<DeviceDescription4>> videoInputDevicesSubject;
    private static final MediaEngine.LocalVoiceStatus LOCAL_VOICE_STATUS_DEFAULT = new MediaEngine.LocalVoiceStatus(-100.0f, false);
    private static final MediaEngine.OpenSLESConfig DEFAULT_OPENSLES_CONFIG = MediaEngine.OpenSLESConfig.DEFAULT;

    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    public static abstract class DefaultListener implements Listener {
        @Override // com.discord.stores.StoreMediaEngine.Listener
        public void onConnected() {
        }

        @Override // com.discord.stores.StoreMediaEngine.Listener
        public void onConnecting() {
        }
    }

    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    public final class EngineListener implements MediaEngine.c {
        private final LowMemoryDetector lowMemoryDetector = new LowMemoryDetector();
        private long debugPrintableId = -1;

        public EngineListener() {
        }

        private final Context getContext() {
            return ApplicationProvider.INSTANCE.get();
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngine.c
        public void onConnected() {
            StoreMediaEngine.this.listenerSubject.notify(StoreMediaEngine$EngineListener$onConnected$1.INSTANCE);
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngine.c
        public void onConnecting() {
            StoreMediaEngine.this.listenerSubject.notify(StoreMediaEngine$EngineListener$onConnecting$1.INSTANCE);
        }

        public void onDestroy() {
            getContext().unregisterComponentCallbacks(this.lowMemoryDetector);
            if (Build.VERSION.SDK_INT >= 29) {
                ThermalDetector thermalDetector = ThermalDetector.n;
                synchronized (thermalDetector) {
                    if (ThermalDetector.k) {
                        AnimatableValueParser.b1("ThermalDetector", "unregister");
                        Object systemService = ApplicationProvider.INSTANCE.get().getSystemService("power");
                        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
                        ((PowerManager) systemService).removeThermalStatusListener(thermalDetector);
                        ThermalDetector.k = false;
                        ThermalDetector.l = false;
                        if (ThermalDetector.m) {
                            ((Handler) ThermalDetector.j.getValue()).removeCallbacks(thermalDetector);
                            ThermalDetector.m = false;
                        }
                    }
                }
                SystemLogUtils.INSTANCE.getDebugPrintables$app_productionGoogleRelease().remove(this.debugPrintableId);
                this.debugPrintableId = -1L;
            }
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngine.c
        public void onNativeEngineInitialized() {
            getContext().registerComponentCallbacks(this.lowMemoryDetector);
            if (Build.VERSION.SDK_INT >= 29) {
                ThermalDetector thermalDetector = ThermalDetector.n;
                synchronized (thermalDetector) {
                    if (!ThermalDetector.k) {
                        AnimatableValueParser.b1("ThermalDetector", "register");
                        Object systemService = ApplicationProvider.INSTANCE.get().getSystemService("power");
                        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
                        ((PowerManager) systemService).addThermalStatusListener(thermalDetector);
                        ThermalDetector.k = true;
                    }
                }
                this.debugPrintableId = SystemLogUtils.INSTANCE.getDebugPrintables$app_productionGoogleRelease().add(thermalDetector, "ThermalDetector");
            }
            StoreMediaEngine.this.handleNativeEngineInitialized();
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngine.c
        public void onNewConnection(MediaEngineConnection connection) {
            Intrinsics3.checkNotNullParameter(connection, "connection");
            StoreMediaEngine.this.handleNewConnection(connection);
        }
    }

    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    public interface Listener {
        void onConnected();

        void onConnecting();
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            KrispOveruseDetector.Status.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[KrispOveruseDetector.Status.FAILED.ordinal()] = 1;
            iArr[KrispOveruseDetector.Status.CPU_OVERUSE.ordinal()] = 2;
            iArr[KrispOveruseDetector.Status.VAD_CPU_OVERUSE.ordinal()] = 3;
            MediaEngineConnection.Type.values();
            int[] iArr2 = new int[2];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[MediaEngineConnection.Type.DEFAULT.ordinal()] = 1;
            iArr2[MediaEngineConnection.Type.STREAM.ordinal()] = 2;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$awaitVideoInputDevicesNativeAsync$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    @DebugMetadata(c = "com.discord.stores.StoreMediaEngine", f = "StoreMediaEngine.kt", l = {264}, m = "awaitVideoInputDevicesNativeAsync")
    public static final class AnonymousClass1 extends ContinuationImpl3 {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StoreMediaEngine.this.awaitVideoInputDevicesNativeAsync(this);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$enableLocalVoiceStatusListening$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<MediaEngine.LocalVoiceStatus, Unit> {
        public AnonymousClass1(SerializedSubject serializedSubject) {
            super(1, serializedSubject, SerializedSubject.class, "onNext", "onNext(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MediaEngine.LocalVoiceStatus localVoiceStatus) {
            invoke2(localVoiceStatus);
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MediaEngine.LocalVoiceStatus localVoiceStatus) {
            ((SerializedSubject) this.receiver).k.onNext((T) localVoiceStatus);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$getDefaultVideoDeviceGUID$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    @DebugMetadata(c = "com.discord.stores.StoreMediaEngine", f = "StoreMediaEngine.kt", l = {209}, m = "getDefaultVideoDeviceGUID")
    public static final class AnonymousClass1 extends ContinuationImpl3 {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StoreMediaEngine.this.getDefaultVideoDeviceGUID(this);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$getRankedRtcRegions$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<String[], Unit> {
        public final /* synthetic */ Function1 $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function1 function1) {
            super(1);
            this.$callback = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String[] strArr) {
            invoke2(strArr);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String[] strArr) {
            Intrinsics3.checkNotNullParameter(strArr, "it");
            this.$callback.invoke(_Arrays.toList(strArr));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$getVideoInputDevicesNative$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<DeviceDescription4[], Unit> {
        public AnonymousClass1(Function1 function1) {
            super(1, function1, Function1.class, "invoke", "invoke(Ljava/lang/Object;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DeviceDescription4[] deviceDescription4Arr) {
            invoke2(deviceDescription4Arr);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DeviceDescription4[] deviceDescription4Arr) {
            Intrinsics3.checkNotNullParameter(deviceDescription4Arr, "p1");
            ((Function1) this.receiver).invoke(deviceDescription4Arr);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$handleMicrophonePermissionGranted$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            Intrinsics3.checkNotNullExpressionValue(bool, "isInitialized");
            if (bool.booleanValue()) {
                StoreMediaEngine.this.restartLocalMicrophone();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$handleNewConnection$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<DeviceDescription4[], Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DeviceDescription4[] deviceDescription4Arr) {
            invoke2(deviceDescription4Arr);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DeviceDescription4[] deviceDescription4Arr) {
            Intrinsics3.checkNotNullParameter(deviceDescription4Arr, "devices");
            StoreMediaEngine storeMediaEngine = StoreMediaEngine.this;
            DeviceDescription4 deviceDescription4 = storeMediaEngine.selectedVideoInputDevice;
            StoreMediaEngine.handleVideoInputDevices$default(storeMediaEngine, deviceDescription4Arr, deviceDescription4 != null ? deviceDescription4.getGuid() : null, null, 4, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$handleVoiceChannelSelected$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<DeviceDescription4[], Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DeviceDescription4[] deviceDescription4Arr) {
            invoke2(deviceDescription4Arr);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DeviceDescription4[] deviceDescription4Arr) {
            Intrinsics3.checkNotNullParameter(deviceDescription4Arr, "it");
            StoreMediaEngine.handleVideoInputDevices$default(StoreMediaEngine.this, deviceDescription4Arr, null, null, 4, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$init$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Experiment, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Experiment experiment) {
            invoke2(experiment);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Experiment experiment) {
            int bucket = experiment.getBucket();
            StoreMediaEngine.this.getMediaEngine().h((bucket == 1 || bucket == 3) ? MediaEngine.OpenSLUsageMode.EXCLUDE_LIST : MediaEngine.OpenSLUsageMode.ALLOW_LIST);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$selectDefaultVideoDevice$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    @DebugMetadata(c = "com.discord.stores.StoreMediaEngine$selectDefaultVideoDevice$1", f = "StoreMediaEngine.kt", l = {Opcodes.ANEWARRAY}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Function1 $onSelected;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.$onSelected = function1;
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return StoreMediaEngine.this.new AnonymousClass1(this.$onSelected, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                StoreMediaEngine storeMediaEngine = StoreMediaEngine.this;
                this.label = 1;
                obj = storeMediaEngine.awaitVideoInputDevicesNativeAsync(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
            }
            DeviceDescription4[] deviceDescription4Arr = (DeviceDescription4[]) obj;
            StoreMediaEngine.this.handleVideoInputDevices(deviceDescription4Arr, StoreMediaEngine.this.pickDefaultDeviceGUID(deviceDescription4Arr), this.$onSelected);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$selectDefaultVideoDeviceAsync$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    @DebugMetadata(c = "com.discord.stores.StoreMediaEngine", f = "StoreMediaEngine.kt", l = {202}, m = "selectDefaultVideoDeviceAsync")
    public static final class AnonymousClass1 extends ContinuationImpl3 {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StoreMediaEngine.this.selectDefaultVideoDeviceAsync(this);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$selectVideoInputDevice$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<DeviceDescription4[], Unit> {
        public final /* synthetic */ String $deviceGUID;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$deviceGUID = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DeviceDescription4[] deviceDescription4Arr) {
            invoke2(deviceDescription4Arr);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DeviceDescription4[] deviceDescription4Arr) {
            Intrinsics3.checkNotNullParameter(deviceDescription4Arr, "devices");
            StoreMediaEngine.handleVideoInputDevices$default(StoreMediaEngine.this, deviceDescription4Arr, this.$deviceGUID, null, 4, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$setupMediaEngineSettingsSubscription$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreMediaSettings.VoiceConfiguration, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$setupMediaEngineSettingsSubscription$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreMediaEngine.kt */
        public static final class C01481 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ StoreMediaSettings.VoiceConfiguration $voiceConfig;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01481(StoreMediaSettings.VoiceConfiguration voiceConfiguration) {
                super(0);
                this.$voiceConfig = voiceConfiguration;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreMediaEngine.this.handleVoiceConfigChanged(this.$voiceConfig);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreMediaSettings.VoiceConfiguration voiceConfiguration) {
            invoke2(voiceConfiguration);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreMediaSettings.VoiceConfiguration voiceConfiguration) {
            Intrinsics3.checkNotNullParameter(voiceConfiguration, "voiceConfig");
            StoreMediaEngine.this.dispatcher.schedule(new C01481(voiceConfiguration));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$setupMediaEngineSettingsSubscription$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            Logger.e$default(AppLog.g, "handleVoiceConfigChanged", error.getThrowable(), null, 4, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$setupMediaEngineSettingsSubscription$3, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            StoreMediaEngine.this.mediaEngineSettingsSubscription = subscription;
        }
    }

    public StoreMediaEngine(StoreMediaSettings storeMediaSettings, StoreStream storeStream, Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(storeMediaSettings, "mediaSettingsStore");
        Intrinsics3.checkNotNullParameter(storeStream, "storeStream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.mediaSettingsStore = storeMediaSettings;
        this.storeStream = storeStream;
        this.dispatcher = dispatcher;
        ListenerCollection2<Listener> listenerCollection2 = new ListenerCollection2<>();
        this.listenerSubject = listenerCollection2;
        this.listeners = listenerCollection2;
        SerializedSubject<MediaEngine.LocalVoiceStatus, MediaEngine.LocalVoiceStatus> serializedSubject = new SerializedSubject<>(BehaviorSubject.l0(LOCAL_VOICE_STATUS_DEFAULT));
        this.localVoiceStatusSubject = serializedSubject;
        Boolean bool = Boolean.FALSE;
        this.pttActiveSubject = new SerializedSubject<>(BehaviorSubject.l0(bool));
        this.preferredVideoInputDeviceGUID = "";
        this.preferredVideoInputDeviceGuidCache = new Persister<>("PREFERRED_VIDEO_INPUT_DEVICE_GUID", this.preferredVideoInputDeviceGUID);
        this.selectedVideoInputDeviceSubject = BehaviorSubject.l0(this.selectedVideoInputDevice);
        DeviceDescription4[] deviceDescription4Arr = new DeviceDescription4[0];
        this.videoInputDevices = deviceDescription4Arr;
        this.videoInputDevicesSubject = BehaviorSubject.l0(_ArraysJvm.asList(deviceDescription4Arr));
        this.openSLESConfigSubject = new SerializedSubject<>(BehaviorSubject.k0());
        this.isNativeEngineInitializedSubject = new SerializedSubject<>(BehaviorSubject.l0(bool));
        this.userId = -1L;
        this.hasNativeEngineEverInitializedCache = new Persister<>("CACHE_KEY_NATIVE_ENGINE_EVER_INITIALIZED", Boolean.valueOf(this.hasNativeEngineEverInitialized));
        this.onKrispStatusSubject = PublishSubject.k0();
        Observable observableR = ObservableExtensionsKt.computationLatest(serializedSubject).r();
        final StoreMediaEngine$localVoiceStatus$1 storeMediaEngine$localVoiceStatus$1 = new StoreMediaEngine$localVoiceStatus$1(this);
        Observable observableV = observableR.v(new Action0() { // from class: com.discord.stores.StoreMediaEngine$sam$rx_functions_Action0$0
            @Override // rx.functions.Action0
            public final /* synthetic */ void call() {
                Intrinsics3.checkNotNullExpressionValue(storeMediaEngine$localVoiceStatus$1.invoke(), "invoke(...)");
            }
        });
        final StoreMediaEngine$localVoiceStatus$2 storeMediaEngine$localVoiceStatus$2 = new StoreMediaEngine$localVoiceStatus$2(this);
        Observable observableW = observableV.w(new Action0() { // from class: com.discord.stores.StoreMediaEngine$sam$rx_functions_Action0$0
            @Override // rx.functions.Action0
            public final /* synthetic */ void call() {
                Intrinsics3.checkNotNullExpressionValue(storeMediaEngine$localVoiceStatus$2.invoke(), "invoke(...)");
            }
        });
        AtomicReference atomicReference = new AtomicReference();
        Observable<MediaEngine.LocalVoiceStatus> observableH0 = Observable.h0(new OnSubscribeRefCount3(new OperatorPublish2(new OperatorPublish(atomicReference), observableW, atomicReference)));
        Intrinsics3.checkNotNullExpressionValue(observableH0, "localVoiceStatusSubject\n…ening)\n          .share()");
        this.localVoiceStatus = observableH0;
    }

    public static final /* synthetic */ MediaEngine access$getMediaEngine$p(StoreMediaEngine storeMediaEngine) {
        MediaEngine mediaEngine = storeMediaEngine.mediaEngine;
        if (mediaEngine == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mediaEngine");
        }
        return mediaEngine;
    }

    private final synchronized void disableLocalVoiceStatusListening() {
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine.l(null);
    }

    private final synchronized void enableLocalVoiceStatusListening() {
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine.l(new AnonymousClass1(this.localVoiceStatusSubject));
    }

    private final synchronized void getVideoInputDevicesNative(Function1<? super DeviceDescription4[], Unit> callback) {
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine.j(new AnonymousClass1(callback));
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
        connection.l(new MediaEngineConnection.a() { // from class: com.discord.stores.StoreMediaEngine.handleNewConnection.1
            @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.a, com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
            public void onDestroy(MediaEngineConnection connection2) {
                Intrinsics3.checkNotNullParameter(connection2, "connection");
                if (_Collections.minus(StoreMediaEngine.this.getMediaEngine().getConnections(), connection2).isEmpty()) {
                    StoreMediaEngine.this.mediaSettingsStore.revertTemporaryDisableKrisp();
                }
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.a, com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
            public void onKrispStatus(MediaEngineConnection connection2, KrispOveruseDetector.Status status) {
                Intrinsics3.checkNotNullParameter(connection2, "connection");
                Intrinsics3.checkNotNullParameter(status, "status");
                AppLog.i("onKrispStatus(" + status + ')');
                StoreMediaEngine.this.onKrispStatusSubject.k.onNext((T) status);
                int iOrdinal = status.ordinal();
                if (iOrdinal == 0 || iOrdinal == 1) {
                    StoreMediaEngine.this.mediaSettingsStore.setNoiseProcessing(StoreMediaSettings.NoiseProcessing.CancellationTemporarilyDisabled);
                } else {
                    if (iOrdinal != 2) {
                        return;
                    }
                    StoreMediaEngine.this.mediaSettingsStore.setVADUseKrisp(StoreMediaSettings.VadUseKrisp.TemporarilyDisabled);
                }
            }
        });
        getVideoInputDevicesNative(new AnonymousClass2());
    }

    private final synchronized void handleVideoInputDevices(DeviceDescription4[] videoInputDevices, String deviceGUID, Function1<? super String, Unit> onSelected) {
        String guid;
        int length = videoInputDevices.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (Intrinsics3.areEqual(videoInputDevices[i].getGuid(), deviceGUID)) {
                break;
            } else {
                i++;
            }
        }
        boolean z2 = i >= 0;
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine.f(-1);
        MediaEngine mediaEngine2 = this.mediaEngine;
        if (mediaEngine2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine2.f(i);
        MediaEngine mediaEngine3 = this.mediaEngine;
        if (mediaEngine3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mediaEngine");
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
        this.videoInputDevicesSubject.onNext(_ArraysJvm.asList(videoInputDevices));
        DeviceDescription4 deviceDescription4 = this.selectedVideoInputDevice;
        if (deviceDescription4 != null) {
            if (deviceDescription4 == null || (guid = deviceDescription4.getGuid()) == null) {
                guid = "";
            }
            this.preferredVideoInputDeviceGUID = guid;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void handleVideoInputDevices$default(StoreMediaEngine storeMediaEngine, DeviceDescription4[] deviceDescription4Arr, String str, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        storeMediaEngine.handleVideoInputDevices(deviceDescription4Arr, str, function1);
    }

    @Store3
    private final synchronized void handleVoiceConfigChanged(StoreMediaSettings.VoiceConfiguration voiceConfig) {
        if (voiceConfig != null) {
            MediaEngine mediaEngine = this.mediaEngine;
            if (mediaEngine == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("mediaEngine");
            }
            mediaEngine.d(voiceConfig.toMediaEngineVoiceConfig());
        }
    }

    private final String pickDefaultDeviceGUID(DeviceDescription4[] deviceDescription4Arr) {
        boolean z2;
        DeviceDescription4 deviceDescription4;
        int length = deviceDescription4Arr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z2 = false;
                break;
            }
            if (Intrinsics3.areEqual(deviceDescription4Arr[i].getGuid(), this.preferredVideoInputDeviceGUID)) {
                z2 = true;
                break;
            }
            i++;
        }
        if (z2) {
            return this.preferredVideoInputDeviceGUID;
        }
        int length2 = deviceDescription4Arr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length2) {
                deviceDescription4 = null;
                break;
            }
            deviceDescription4 = deviceDescription4Arr[i2];
            if (deviceDescription4.getFacing() == DeviceDescription5.Front) {
                break;
            }
            i2++;
        }
        if (deviceDescription4 == null) {
            deviceDescription4 = (DeviceDescription4) _Arrays.firstOrNull(deviceDescription4Arr);
        }
        if (deviceDescription4 != null) {
            return deviceDescription4.getGuid();
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
        Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig = this.mediaSettingsStore.getVoiceConfig();
        Class<?> cls = getClass();
        ObservableExtensionsKt.appSubscribe(voiceConfig, (Class<?>) cls, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass3()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : AnonymousClass2.INSTANCE), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    private final synchronized void updateSelectedVideoInputDevice(DeviceDescription4 selectedVideoInputDevice) {
        this.selectedVideoInputDevice = selectedVideoInputDevice;
        this.selectedVideoInputDeviceSubject.onNext(selectedVideoInputDevice);
        this.storeStream.handleVideoInputDeviceSelected(selectedVideoInputDevice);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final /* synthetic */ Object awaitVideoInputDevicesNativeAsync(Continuation<? super DeviceDescription4[]> continuation) {
        AnonymousClass1 anonymousClass1;
        StoreMediaEngine storeMediaEngine;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objB = anonymousClass1.result;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        boolean z2 = true;
        if (i2 == 0) {
            Result3.throwOnFailure(objB);
            StoreMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1 storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1 = new StoreMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1(this, null);
            anonymousClass1.L$0 = this;
            anonymousClass1.label = 1;
            objB = Builders5.b(MAX_WAIT_FOR_DEVICES_MS, storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1, anonymousClass1);
            if (objB == coroutine_suspended) {
                return coroutine_suspended;
            }
            storeMediaEngine = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            storeMediaEngine = (StoreMediaEngine) anonymousClass1.L$0;
            Result3.throwOnFailure(objB);
        }
        DeviceDescription4[] deviceDescription4Arr = (DeviceDescription4[]) objB;
        if (!storeMediaEngine.hasTimedOutAwaitingDevice && deviceDescription4Arr != null) {
            z2 = false;
        }
        storeMediaEngine.hasTimedOutAwaitingDevice = z2;
        return deviceDescription4Arr != null ? deviceDescription4Arr : new DeviceDescription4[0];
    }

    public final synchronized void cycleVideoInputDevice() {
        int iIndexOf = _Arrays.indexOf(this.videoInputDevices, this.selectedVideoInputDevice);
        if (iIndexOf < 0) {
            return;
        }
        selectVideoInputDevice(this.videoInputDevices[iIndexOf == _Arrays.getLastIndex(this.videoInputDevices) ? 0 : iIndexOf + 1].getGuid());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getDefaultVideoDeviceGUID(Continuation<? super String> continuation) {
        AnonymousClass1 anonymousClass1;
        StoreMediaEngine storeMediaEngine;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objAwaitVideoInputDevicesNativeAsync = anonymousClass1.result;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            Result3.throwOnFailure(objAwaitVideoInputDevicesNativeAsync);
            anonymousClass1.L$0 = this;
            anonymousClass1.label = 1;
            objAwaitVideoInputDevicesNativeAsync = awaitVideoInputDevicesNativeAsync(anonymousClass1);
            if (objAwaitVideoInputDevicesNativeAsync == coroutine_suspended) {
                return coroutine_suspended;
            }
            storeMediaEngine = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            storeMediaEngine = (StoreMediaEngine) anonymousClass1.L$0;
            Result3.throwOnFailure(objAwaitVideoInputDevicesNativeAsync);
        }
        return storeMediaEngine.pickDefaultDeviceGUID((DeviceDescription4[]) objAwaitVideoInputDevicesNativeAsync);
    }

    public final Observable<Boolean> getIsNativeEngineInitialized() {
        return this.isNativeEngineInitializedSubject;
    }

    public final ListenerCollection<Listener> getListeners() {
        return this.listeners;
    }

    public final Observable<MediaEngine.LocalVoiceStatus> getLocalVoiceStatus() {
        return this.localVoiceStatus;
    }

    public final MediaEngine getMediaEngine() {
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mediaEngine");
        }
        return mediaEngine;
    }

    public final Observable<MediaEngine.OpenSLESConfig> getOpenSLESConfig() {
        return this.openSLESConfigSubject;
    }

    public final synchronized void getRankedRtcRegions(List<ModelRtcLatencyRegion> regionsWithIps, Function1<? super List<String>, Unit> callback) {
        Intrinsics3.checkNotNullParameter(regionsWithIps, "regionsWithIps");
        Intrinsics3.checkNotNullParameter(callback, "callback");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(regionsWithIps, 10));
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
            Intrinsics3.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine.b(rtcRegionArr, new AnonymousClass1(callback));
    }

    public final Observable<DeviceDescription4> getSelectedVideoInputDevice() {
        Observable<DeviceDescription4> observableR = this.selectedVideoInputDeviceSubject.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "selectedVideoInputDevice…  .distinctUntilChanged()");
        return observableR;
    }

    /* JADX INFO: renamed from: getSelectedVideoInputDeviceBlocking, reason: from getter */
    public final DeviceDescription4 getSelectedVideoInputDevice() {
        return this.selectedVideoInputDevice;
    }

    public final Observable<List<DeviceDescription4>> getVideoInputDevices() {
        Observable<List<DeviceDescription4>> observableR = this.videoInputDevicesSubject.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "videoInputDevicesSubject…  .distinctUntilChanged()");
        return observableR;
    }

    public final Object getVideoInputDevicesNativeAsync(Continuation<? super DeviceDescription4[]> continuation) {
        CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
        cancellableContinuationImpl5.A();
        getVideoInputDevicesNative(new StoreMediaEngine$getVideoInputDevicesNativeAsync$2$1(cancellableContinuationImpl5));
        Object objU = cancellableContinuationImpl5.u();
        if (objU == Intrinsics2.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return objU;
    }

    public final synchronized Discord getVoiceEngineNative() {
        MediaEngine mediaEngine;
        mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mediaEngine");
        }
        return mediaEngine.i();
    }

    public final synchronized void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.userId = payload.getMe().getId();
    }

    public final void handleMicrophonePermissionGranted() {
        Observable<Boolean> observableZ = this.isNativeEngineInitializedSubject.Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableZ, "isNativeEngineInitializedSubject\n        .take(1)");
        ObservableExtensionsKt.appSubscribe(observableZ, (Class<?>) StoreMediaEngine.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    public final synchronized void handleVoiceChannelSelected(long channelId) {
        Long l = this.previousVoiceChannelId;
        if (l != null && (l == null || l.longValue() != 0)) {
            if (channelId == 0) {
                getVideoInputDevicesNative(new AnonymousClass1());
            }
        }
        this.previousVoiceChannelId = Long.valueOf(channelId);
    }

    public final synchronized boolean hasNativeEngineEverInitialized() {
        return this.hasNativeEngineEverInitialized;
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        this.preferredVideoInputDeviceGUID = this.preferredVideoInputDeviceGuidCache.get();
        this.hasNativeEngineEverInitialized = this.hasNativeEngineEverInitializedCache.get().booleanValue();
        SharedPreferences prefsSessionDurable = getPrefsSessionDurable();
        MediaEngine.OpenSLESConfig openSLESConfig = DEFAULT_OPENSLES_CONFIG;
        String string = prefsSessionDurable.getString("OPEN_SLES", openSLESConfig.name());
        if (string == null) {
            string = openSLESConfig.name();
        }
        Intrinsics3.checkNotNullExpressionValue(string, "prefsSessionDurable\n    …AULT_OPENSLES_CONFIG.name");
        MediaEngine.OpenSLESConfig openSLESConfigValueOf = MediaEngine.OpenSLESConfig.valueOf(string);
        this.openSLESConfigSubject.k.onNext(openSLESConfigValueOf);
        MediaEngine.b bVar = new MediaEngine.b() { // from class: com.discord.stores.StoreMediaEngine$init$echoCancellationCallback$1
            @Override // com.discord.rtcconnection.mediaengine.MediaEngine.b
            public void onEchoCancellationUpdated(MediaEngine.EchoCancellationInfo info) {
                Intrinsics3.checkNotNullParameter(info, "info");
                this.this$0.dispatcher.schedule(new StoreMediaEngine$init$echoCancellationCallback$1$onEchoCancellationUpdated$1(info));
            }
        };
        EngineListener engineListener = new EngineListener();
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics3.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "Executors.newSingleThreadExecutor()");
        AppLog appLog = AppLog.g;
        EchoCancellation.a aVar = EchoCancellation.c;
        EchoCancellation echoCancellation = EchoCancellation.f264b;
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(engineListener, "listener");
        Intrinsics3.checkNotNullParameter(executorServiceNewSingleThreadExecutor, "singleThreadExecutorService");
        Intrinsics3.checkNotNullParameter(openSLESConfigValueOf, "openSLESConfig");
        Intrinsics3.checkNotNullParameter(appLog, "logger");
        Intrinsics3.checkNotNullParameter(echoCancellation, "echoCancellation");
        Intrinsics3.checkNotNullParameter(bVar, "echoCancellationCallback");
        this.mediaEngine = new k(context, engineListener, new MediaEngineExecutorService(executorServiceNewSingleThreadExecutor, false), openSLESConfigValueOf, appLog, echoCancellation, bVar, null, null, 384);
        Observable<R> observableG = this.storeStream.getExperiments().observeUserExperiment("2021-05_opensl_default_enable_android", true).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableZ = observableG.Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableZ, "storeStream.experiments.…erNull()\n        .take(1)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.computationLatest(observableZ), (Class<?>) StoreMediaEngine.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    public final Observable<KrispOveruseDetector.Status> onKrispStatusEvent() {
        PublishSubject<KrispOveruseDetector.Status> publishSubject = this.onKrispStatusSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "onKrispStatusSubject");
        return publishSubject;
    }

    public final void selectDefaultVideoDevice(Function1<? super String, Unit> onSelected) {
        CoroutineScope2 coroutineScope2 = CoroutineScope2.j;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
        f.H0(coroutineScope2, MainDispatchers.f3830b.H(), null, new AnonymousClass1(onSelected, null), 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object selectDefaultVideoDeviceAsync(Continuation<? super String> continuation) {
        AnonymousClass1 anonymousClass1;
        StoreMediaEngine storeMediaEngine;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objAwaitVideoInputDevicesNativeAsync = anonymousClass1.result;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            Result3.throwOnFailure(objAwaitVideoInputDevicesNativeAsync);
            anonymousClass1.L$0 = this;
            anonymousClass1.label = 1;
            objAwaitVideoInputDevicesNativeAsync = awaitVideoInputDevicesNativeAsync(anonymousClass1);
            if (objAwaitVideoInputDevicesNativeAsync == coroutine_suspended) {
                return coroutine_suspended;
            }
            storeMediaEngine = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            storeMediaEngine = (StoreMediaEngine) anonymousClass1.L$0;
            Result3.throwOnFailure(objAwaitVideoInputDevicesNativeAsync);
        }
        DeviceDescription4[] deviceDescription4Arr = (DeviceDescription4[]) objAwaitVideoInputDevicesNativeAsync;
        String strPickDefaultDeviceGUID = storeMediaEngine.pickDefaultDeviceGUID(deviceDescription4Arr);
        handleVideoInputDevices$default(storeMediaEngine, deviceDescription4Arr, strPickDefaultDeviceGUID, null, 4, null);
        return strPickDefaultDeviceGUID;
    }

    public final void selectVideoInputDevice(String deviceGUID) {
        getVideoInputDevicesNative(new AnonymousClass1(deviceGUID));
    }

    public final synchronized void setAudioInputEnabled(boolean audioInputEnabled) {
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine.k(audioInputEnabled);
    }

    @SuppressLint({"ApplySharedPref"})
    public final synchronized void setOpenSLESConfig(MediaEngine.OpenSLESConfig openSLESConfig) {
        Intrinsics3.checkNotNullParameter(openSLESConfig, "openSLESConfig");
        this.openSLESConfigSubject.k.onNext(openSLESConfig);
        getPrefsSessionDurable().edit().putString("OPEN_SLES", openSLESConfig.name()).commit();
    }

    public final synchronized void setPttActive(boolean active) {
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mediaEngine");
        }
        Iterator<T> it = mediaEngine.getConnections().iterator();
        while (it.hasNext()) {
            ((MediaEngineConnection) it.next()).q(active);
        }
        SerializedSubject<Boolean, Boolean> serializedSubject = this.pttActiveSubject;
        serializedSubject.k.onNext(Boolean.valueOf(active));
    }
}
