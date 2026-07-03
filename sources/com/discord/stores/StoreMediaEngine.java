package com.discord.stores;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import co.discord.media_engine.RtcRegion;
import co.discord.media_engine.VideoInputDeviceDescription;
import co.discord.media_engine.VideoInputDeviceFacing;
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
import com.discord.utilities.collections.ListenerCollectionSubject;
import com.discord.utilities.error.Error;
import com.discord.utilities.lifecycle.ApplicationProvider;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.systemlog.SystemLogUtils;
import com.hammerandchisel.libdiscord.Discord;
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
import p007b.p008a.p041q.ExecutorServiceC1192c;
import p007b.p008a.p041q.RunnableC1205i0;
import p007b.p008a.p041q.p042k0.C1215g;
import p007b.p008a.p041q.p044m0.p045c.C1233k;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12113l;
import p507d0.p580t.C12139j;
import p507d0.p580t.C12141k;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p584w.p585h.C12182b;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12187d;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.C12190g;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p642l.p643a.C12607c0;
import p637j0.p642l.p643a.C12624g1;
import p637j0.p642l.p643a.C12628h1;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action0;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.PublishSubject;
import p658rx.subjects.SerializedSubject;
import p659s.p660a.C13114h;
import p659s.p660a.C13124k0;
import p659s.p660a.C13126l;
import p659s.p660a.C13163x0;
import p659s.p660a.p661a.C13031n;

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
    private final ListenerCollectionSubject<Listener> listenerSubject;
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
    private VideoInputDeviceDescription selectedVideoInputDevice;
    private final BehaviorSubject<VideoInputDeviceDescription> selectedVideoInputDeviceSubject;
    private final StoreStream storeStream;
    private long userId;
    private VideoInputDeviceDescription[] videoInputDevices;
    private final BehaviorSubject<List<VideoInputDeviceDescription>> videoInputDevicesSubject;
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
    public final class EngineListener implements MediaEngine.InterfaceC5642c {
        private final LowMemoryDetector lowMemoryDetector = new LowMemoryDetector();
        private long debugPrintableId = -1;

        public EngineListener() {
        }

        private final Context getContext() {
            return ApplicationProvider.INSTANCE.get();
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngine.InterfaceC5642c
        public void onConnected() {
            StoreMediaEngine.this.listenerSubject.notify(StoreMediaEngine$EngineListener$onConnected$1.INSTANCE);
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngine.InterfaceC5642c
        public void onConnecting() {
            StoreMediaEngine.this.listenerSubject.notify(StoreMediaEngine$EngineListener$onConnecting$1.INSTANCE);
        }

        public void onDestroy() {
            getContext().unregisterComponentCallbacks(this.lowMemoryDetector);
            if (Build.VERSION.SDK_INT >= 29) {
                RunnableC1205i0 runnableC1205i0 = RunnableC1205i0.f1633n;
                synchronized (runnableC1205i0) {
                    if (RunnableC1205i0.f1630k) {
                        C1460d.m501b1("ThermalDetector", "unregister");
                        Object systemService = ApplicationProvider.INSTANCE.get().getSystemService("power");
                        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
                        ((PowerManager) systemService).removeThermalStatusListener(runnableC1205i0);
                        RunnableC1205i0.f1630k = false;
                        RunnableC1205i0.f1631l = false;
                        if (RunnableC1205i0.f1632m) {
                            ((Handler) RunnableC1205i0.f1629j.getValue()).removeCallbacks(runnableC1205i0);
                            RunnableC1205i0.f1632m = false;
                        }
                    }
                }
                SystemLogUtils.INSTANCE.getDebugPrintables$app_productionGoogleRelease().remove(this.debugPrintableId);
                this.debugPrintableId = -1L;
            }
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngine.InterfaceC5642c
        public void onNativeEngineInitialized() {
            getContext().registerComponentCallbacks(this.lowMemoryDetector);
            if (Build.VERSION.SDK_INT >= 29) {
                RunnableC1205i0 runnableC1205i0 = RunnableC1205i0.f1633n;
                synchronized (runnableC1205i0) {
                    if (!RunnableC1205i0.f1630k) {
                        C1460d.m501b1("ThermalDetector", "register");
                        Object systemService = ApplicationProvider.INSTANCE.get().getSystemService("power");
                        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
                        ((PowerManager) systemService).addThermalStatusListener(runnableC1205i0);
                        RunnableC1205i0.f1630k = true;
                    }
                }
                this.debugPrintableId = SystemLogUtils.INSTANCE.getDebugPrintables$app_productionGoogleRelease().add(runnableC1205i0, "ThermalDetector");
            }
            StoreMediaEngine.this.handleNativeEngineInitialized();
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngine.InterfaceC5642c
        public void onNewConnection(MediaEngineConnection connection) {
            C12238m.checkNotNullParameter(connection, "connection");
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

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$awaitVideoInputDevicesNativeAsync$1 */
    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    @InterfaceC12188e(m10084c = "com.discord.stores.StoreMediaEngine", m10085f = "StoreMediaEngine.kt", m10086l = {264}, m10087m = "awaitVideoInputDevicesNativeAsync")
    public static final class C61641 extends AbstractC12187d {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public C61641(Continuation continuation) {
            super(continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StoreMediaEngine.this.awaitVideoInputDevicesNativeAsync(this);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$enableLocalVoiceStatusListening$1 */
    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    public static final /* synthetic */ class C61651 extends C12236k implements Function1<MediaEngine.LocalVoiceStatus, Unit> {
        public C61651(SerializedSubject serializedSubject) {
            super(1, serializedSubject, SerializedSubject.class, "onNext", "onNext(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MediaEngine.LocalVoiceStatus localVoiceStatus) {
            invoke2(localVoiceStatus);
            return Unit.f27425a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MediaEngine.LocalVoiceStatus localVoiceStatus) {
            ((SerializedSubject) this.receiver).f27653k.onNext((T) localVoiceStatus);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$getDefaultVideoDeviceGUID$1 */
    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    @InterfaceC12188e(m10084c = "com.discord.stores.StoreMediaEngine", m10085f = "StoreMediaEngine.kt", m10086l = {209}, m10087m = "getDefaultVideoDeviceGUID")
    public static final class C61661 extends AbstractC12187d {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public C61661(Continuation continuation) {
            super(continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StoreMediaEngine.this.getDefaultVideoDeviceGUID(this);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$getRankedRtcRegions$1 */
    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    public static final class C61671 extends AbstractC12240o implements Function1<String[], Unit> {
        public final /* synthetic */ Function1 $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61671(Function1 function1) {
            super(1);
            this.$callback = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String[] strArr) {
            invoke2(strArr);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String[] strArr) {
            C12238m.checkNotNullParameter(strArr, "it");
            this.$callback.invoke(C12141k.toList(strArr));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$getVideoInputDevicesNative$1 */
    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    public static final /* synthetic */ class C61681 extends C12236k implements Function1<VideoInputDeviceDescription[], Unit> {
        public C61681(Function1 function1) {
            super(1, function1, Function1.class, "invoke", "invoke(Ljava/lang/Object;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(VideoInputDeviceDescription[] videoInputDeviceDescriptionArr) {
            invoke2(videoInputDeviceDescriptionArr);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(VideoInputDeviceDescription[] videoInputDeviceDescriptionArr) {
            C12238m.checkNotNullParameter(videoInputDeviceDescriptionArr, "p1");
            ((Function1) this.receiver).invoke(videoInputDeviceDescriptionArr);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$handleMicrophonePermissionGranted$1 */
    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    public static final class C61691 extends AbstractC12240o implements Function1<Boolean, Unit> {
        public C61691() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            C12238m.checkNotNullExpressionValue(bool, "isInitialized");
            if (bool.booleanValue()) {
                StoreMediaEngine.this.restartLocalMicrophone();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$handleNewConnection$2 */
    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    public static final class C61712 extends AbstractC12240o implements Function1<VideoInputDeviceDescription[], Unit> {
        public C61712() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(VideoInputDeviceDescription[] videoInputDeviceDescriptionArr) {
            invoke2(videoInputDeviceDescriptionArr);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(VideoInputDeviceDescription[] videoInputDeviceDescriptionArr) {
            C12238m.checkNotNullParameter(videoInputDeviceDescriptionArr, "devices");
            StoreMediaEngine storeMediaEngine = StoreMediaEngine.this;
            VideoInputDeviceDescription videoInputDeviceDescription = storeMediaEngine.selectedVideoInputDevice;
            StoreMediaEngine.handleVideoInputDevices$default(storeMediaEngine, videoInputDeviceDescriptionArr, videoInputDeviceDescription != null ? videoInputDeviceDescription.getGuid() : null, null, 4, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$handleVoiceChannelSelected$1 */
    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    public static final class C61721 extends AbstractC12240o implements Function1<VideoInputDeviceDescription[], Unit> {
        public C61721() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(VideoInputDeviceDescription[] videoInputDeviceDescriptionArr) {
            invoke2(videoInputDeviceDescriptionArr);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(VideoInputDeviceDescription[] videoInputDeviceDescriptionArr) {
            C12238m.checkNotNullParameter(videoInputDeviceDescriptionArr, "it");
            StoreMediaEngine.handleVideoInputDevices$default(StoreMediaEngine.this, videoInputDeviceDescriptionArr, null, null, 4, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$init$1 */
    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    public static final class C61731 extends AbstractC12240o implements Function1<Experiment, Unit> {
        public C61731() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Experiment experiment) {
            invoke2(experiment);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Experiment experiment) {
            int bucket = experiment.getBucket();
            StoreMediaEngine.this.getMediaEngine().mo328h((bucket == 1 || bucket == 3) ? MediaEngine.OpenSLUsageMode.EXCLUDE_LIST : MediaEngine.OpenSLUsageMode.ALLOW_LIST);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$selectDefaultVideoDevice$1 */
    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    @InterfaceC12188e(m10084c = "com.discord.stores.StoreMediaEngine$selectDefaultVideoDevice$1", m10085f = "StoreMediaEngine.kt", m10086l = {Opcodes.ANEWARRAY}, m10087m = "invokeSuspend")
    public static final class C61751 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Function1 $onSelected;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61751(Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.$onSelected = function1;
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            return StoreMediaEngine.this.new C61751(this.$onSelected, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61751) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                C12113l.throwOnFailure(obj);
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
                C12113l.throwOnFailure(obj);
            }
            VideoInputDeviceDescription[] videoInputDeviceDescriptionArr = (VideoInputDeviceDescription[]) obj;
            StoreMediaEngine.this.handleVideoInputDevices(videoInputDeviceDescriptionArr, StoreMediaEngine.this.pickDefaultDeviceGUID(videoInputDeviceDescriptionArr), this.$onSelected);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$selectDefaultVideoDeviceAsync$1 */
    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    @InterfaceC12188e(m10084c = "com.discord.stores.StoreMediaEngine", m10085f = "StoreMediaEngine.kt", m10086l = {202}, m10087m = "selectDefaultVideoDeviceAsync")
    public static final class C61761 extends AbstractC12187d {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public C61761(Continuation continuation) {
            super(continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StoreMediaEngine.this.selectDefaultVideoDeviceAsync(this);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$selectVideoInputDevice$1 */
    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    public static final class C61771 extends AbstractC12240o implements Function1<VideoInputDeviceDescription[], Unit> {
        public final /* synthetic */ String $deviceGUID;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61771(String str) {
            super(1);
            this.$deviceGUID = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(VideoInputDeviceDescription[] videoInputDeviceDescriptionArr) {
            invoke2(videoInputDeviceDescriptionArr);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(VideoInputDeviceDescription[] videoInputDeviceDescriptionArr) {
            C12238m.checkNotNullParameter(videoInputDeviceDescriptionArr, "devices");
            StoreMediaEngine.handleVideoInputDevices$default(StoreMediaEngine.this, videoInputDeviceDescriptionArr, this.$deviceGUID, null, 4, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$setupMediaEngineSettingsSubscription$1 */
    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    public static final class C61781 extends AbstractC12240o implements Function1<StoreMediaSettings.VoiceConfiguration, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$setupMediaEngineSettingsSubscription$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreMediaEngine.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ StoreMediaSettings.VoiceConfiguration $voiceConfig;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(StoreMediaSettings.VoiceConfiguration voiceConfiguration) {
                super(0);
                this.$voiceConfig = voiceConfiguration;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreMediaEngine.this.handleVoiceConfigChanged(this.$voiceConfig);
            }
        }

        public C61781() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreMediaSettings.VoiceConfiguration voiceConfiguration) {
            invoke2(voiceConfiguration);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreMediaSettings.VoiceConfiguration voiceConfiguration) {
            C12238m.checkNotNullParameter(voiceConfiguration, "voiceConfig");
            StoreMediaEngine.this.dispatcher.schedule(new AnonymousClass1(voiceConfiguration));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$setupMediaEngineSettingsSubscription$2 */
    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    public static final class C61792 extends AbstractC12240o implements Function1<Error, Unit> {
        public static final C61792 INSTANCE = new C61792();

        public C61792() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "error");
            Logger.e$default(AppLog.f14950g, "handleVoiceConfigChanged", error.getThrowable(), null, 4, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaEngine$setupMediaEngineSettingsSubscription$3 */
    /* JADX INFO: compiled from: StoreMediaEngine.kt */
    public static final class C61803 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C61803() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, "it");
            StoreMediaEngine.this.mediaEngineSettingsSubscription = subscription;
        }
    }

    public StoreMediaEngine(StoreMediaSettings storeMediaSettings, StoreStream storeStream, Dispatcher dispatcher) {
        C12238m.checkNotNullParameter(storeMediaSettings, "mediaSettingsStore");
        C12238m.checkNotNullParameter(storeStream, "storeStream");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        this.mediaSettingsStore = storeMediaSettings;
        this.storeStream = storeStream;
        this.dispatcher = dispatcher;
        ListenerCollectionSubject<Listener> listenerCollectionSubject = new ListenerCollectionSubject<>();
        this.listenerSubject = listenerCollectionSubject;
        this.listeners = listenerCollectionSubject;
        SerializedSubject<MediaEngine.LocalVoiceStatus, MediaEngine.LocalVoiceStatus> serializedSubject = new SerializedSubject<>(BehaviorSubject.m11130l0(LOCAL_VOICE_STATUS_DEFAULT));
        this.localVoiceStatusSubject = serializedSubject;
        Boolean bool = Boolean.FALSE;
        this.pttActiveSubject = new SerializedSubject<>(BehaviorSubject.m11130l0(bool));
        this.preferredVideoInputDeviceGUID = "";
        this.preferredVideoInputDeviceGuidCache = new Persister<>("PREFERRED_VIDEO_INPUT_DEVICE_GUID", this.preferredVideoInputDeviceGUID);
        this.selectedVideoInputDeviceSubject = BehaviorSubject.m11130l0(this.selectedVideoInputDevice);
        VideoInputDeviceDescription[] videoInputDeviceDescriptionArr = new VideoInputDeviceDescription[0];
        this.videoInputDevices = videoInputDeviceDescriptionArr;
        this.videoInputDevicesSubject = BehaviorSubject.m11130l0(C12139j.asList(videoInputDeviceDescriptionArr));
        this.openSLESConfigSubject = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.isNativeEngineInitializedSubject = new SerializedSubject<>(BehaviorSubject.m11130l0(bool));
        this.userId = -1L;
        this.hasNativeEngineEverInitializedCache = new Persister<>("CACHE_KEY_NATIVE_ENGINE_EVER_INITIALIZED", Boolean.valueOf(this.hasNativeEngineEverInitialized));
        this.onKrispStatusSubject = PublishSubject.m11133k0();
        Observable observableM11112r = ObservableExtensionsKt.computationLatest(serializedSubject).m11112r();
        final StoreMediaEngine$localVoiceStatus$1 storeMediaEngine$localVoiceStatus$1 = new StoreMediaEngine$localVoiceStatus$1(this);
        Observable observableM11116v = observableM11112r.m11116v(new Action0() { // from class: com.discord.stores.StoreMediaEngine$sam$rx_functions_Action0$0
            @Override // p658rx.functions.Action0
            public final /* synthetic */ void call() {
                C12238m.checkNotNullExpressionValue(storeMediaEngine$localVoiceStatus$1.invoke(), "invoke(...)");
            }
        });
        final StoreMediaEngine$localVoiceStatus$2 storeMediaEngine$localVoiceStatus$2 = new StoreMediaEngine$localVoiceStatus$2(this);
        Observable observableM11117w = observableM11116v.m11117w(new Action0() { // from class: com.discord.stores.StoreMediaEngine$sam$rx_functions_Action0$0
            @Override // p658rx.functions.Action0
            public final /* synthetic */ void call() {
                C12238m.checkNotNullExpressionValue(storeMediaEngine$localVoiceStatus$2.invoke(), "invoke(...)");
            }
        });
        AtomicReference atomicReference = new AtomicReference();
        Observable<MediaEngine.LocalVoiceStatus> observableM11074h0 = Observable.m11074h0(new C12607c0(new C12628h1(new C12624g1(atomicReference), observableM11117w, atomicReference)));
        C12238m.checkNotNullExpressionValue(observableM11074h0, "localVoiceStatusSubject\n…ening)\n          .share()");
        this.localVoiceStatus = observableM11074h0;
    }

    public static final /* synthetic */ MediaEngine access$getMediaEngine$p(StoreMediaEngine storeMediaEngine) {
        MediaEngine mediaEngine = storeMediaEngine.mediaEngine;
        if (mediaEngine == null) {
            C12238m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        return mediaEngine;
    }

    private final synchronized void disableLocalVoiceStatusListening() {
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            C12238m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine.mo332l(null);
    }

    private final synchronized void enableLocalVoiceStatusListening() {
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            C12238m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine.mo332l(new C61651(this.localVoiceStatusSubject));
    }

    private final synchronized void getVideoInputDevicesNative(Function1<? super VideoInputDeviceDescription[], Unit> callback) {
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            C12238m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine.mo330j(new C61681(callback));
    }

    private final synchronized void handleNativeEngineInitialized() {
        this.hasNativeEngineEverInitialized = true;
        Persister<Boolean> persister = this.hasNativeEngineEverInitializedCache;
        Boolean bool = Boolean.TRUE;
        persister.set(bool, true);
        this.isNativeEngineInitializedSubject.f27653k.onNext(bool);
    }

    private final synchronized void handleNewConnection(MediaEngineConnection connection) {
        setupMediaEngineSettingsSubscription();
        connection.mo306l(new MediaEngineConnection.AbstractC5645a() { // from class: com.discord.stores.StoreMediaEngine.handleNewConnection.1
            @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.AbstractC5645a, com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
            public void onDestroy(MediaEngineConnection connection2) {
                C12238m.checkNotNullParameter(connection2, "connection");
                if (C12163u.minus(StoreMediaEngine.this.getMediaEngine().getConnections(), connection2).isEmpty()) {
                    StoreMediaEngine.this.mediaSettingsStore.revertTemporaryDisableKrisp();
                }
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.AbstractC5645a, com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
            public void onKrispStatus(MediaEngineConnection connection2, KrispOveruseDetector.Status status) {
                C12238m.checkNotNullParameter(connection2, "connection");
                C12238m.checkNotNullParameter(status, "status");
                AppLog.m8358i("onKrispStatus(" + status + ')');
                StoreMediaEngine.this.onKrispStatusSubject.f27650k.onNext((T) status);
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
        getVideoInputDevicesNative(new C61712());
    }

    private final synchronized void handleVideoInputDevices(VideoInputDeviceDescription[] videoInputDevices, String deviceGUID, Function1<? super String, Unit> onSelected) {
        String guid;
        int length = videoInputDevices.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (C12238m.areEqual(videoInputDevices[i].getGuid(), deviceGUID)) {
                break;
            } else {
                i++;
            }
        }
        boolean z2 = i >= 0;
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            C12238m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine.mo326f(-1);
        MediaEngine mediaEngine2 = this.mediaEngine;
        if (mediaEngine2 == null) {
            C12238m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine2.mo326f(i);
        MediaEngine mediaEngine3 = this.mediaEngine;
        if (mediaEngine3 == null) {
            C12238m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        for (MediaEngineConnection mediaEngineConnection : mediaEngine3.getConnections()) {
            if (mediaEngineConnection.getType().ordinal() == 0) {
                mediaEngineConnection.mo304j(z2);
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
        this.videoInputDevicesSubject.onNext(C12139j.asList(videoInputDevices));
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
    private final synchronized void handleVoiceConfigChanged(StoreMediaSettings.VoiceConfiguration voiceConfig) {
        if (voiceConfig != null) {
            MediaEngine mediaEngine = this.mediaEngine;
            if (mediaEngine == null) {
                C12238m.throwUninitializedPropertyAccessException("mediaEngine");
            }
            mediaEngine.mo324d(voiceConfig.toMediaEngineVoiceConfig());
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
            if (C12238m.areEqual(videoInputDeviceDescriptionArr[i].getGuid(), this.preferredVideoInputDeviceGUID)) {
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
            videoInputDeviceDescription = (VideoInputDeviceDescription) C12141k.firstOrNull(videoInputDeviceDescriptionArr);
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
        Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig = this.mediaSettingsStore.getVoiceConfig();
        Class<?> cls = getClass();
        ObservableExtensionsKt.appSubscribe(voiceConfig, (Class<?>) cls, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C61803()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : C61792.INSTANCE), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C61781());
    }

    private final synchronized void updateSelectedVideoInputDevice(VideoInputDeviceDescription selectedVideoInputDevice) {
        this.selectedVideoInputDevice = selectedVideoInputDevice;
        this.selectedVideoInputDeviceSubject.onNext(selectedVideoInputDevice);
        this.storeStream.handleVideoInputDeviceSelected(selectedVideoInputDevice);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final /* synthetic */ Object awaitVideoInputDevicesNativeAsync(Continuation<? super VideoInputDeviceDescription[]> continuation) {
        C61641 c61641;
        StoreMediaEngine storeMediaEngine;
        if (continuation instanceof C61641) {
            c61641 = (C61641) continuation;
            int i = c61641.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c61641.label = i - Integer.MIN_VALUE;
            } else {
                c61641 = new C61641(continuation);
            }
        } else {
            c61641 = new C61641(continuation);
        }
        Object objM11283b = c61641.result;
        Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
        int i2 = c61641.label;
        boolean z2 = true;
        if (i2 == 0) {
            C12113l.throwOnFailure(objM11283b);
            StoreMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1 storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1 = new StoreMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1(this, null);
            c61641.L$0 = this;
            c61641.label = 1;
            objM11283b = C13114h.m11283b(MAX_WAIT_FOR_DEVICES_MS, storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1, c61641);
            if (objM11283b == coroutine_suspended) {
                return coroutine_suspended;
            }
            storeMediaEngine = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            storeMediaEngine = (StoreMediaEngine) c61641.L$0;
            C12113l.throwOnFailure(objM11283b);
        }
        VideoInputDeviceDescription[] videoInputDeviceDescriptionArr = (VideoInputDeviceDescription[]) objM11283b;
        if (!storeMediaEngine.hasTimedOutAwaitingDevice && videoInputDeviceDescriptionArr != null) {
            z2 = false;
        }
        storeMediaEngine.hasTimedOutAwaitingDevice = z2;
        return videoInputDeviceDescriptionArr != null ? videoInputDeviceDescriptionArr : new VideoInputDeviceDescription[0];
    }

    public final synchronized void cycleVideoInputDevice() {
        int iIndexOf = C12141k.indexOf(this.videoInputDevices, this.selectedVideoInputDevice);
        if (iIndexOf < 0) {
            return;
        }
        selectVideoInputDevice(this.videoInputDevices[iIndexOf == C12141k.getLastIndex(this.videoInputDevices) ? 0 : iIndexOf + 1].getGuid());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getDefaultVideoDeviceGUID(Continuation<? super String> continuation) {
        C61661 c61661;
        StoreMediaEngine storeMediaEngine;
        if (continuation instanceof C61661) {
            c61661 = (C61661) continuation;
            int i = c61661.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c61661.label = i - Integer.MIN_VALUE;
            } else {
                c61661 = new C61661(continuation);
            }
        } else {
            c61661 = new C61661(continuation);
        }
        Object objAwaitVideoInputDevicesNativeAsync = c61661.result;
        Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
        int i2 = c61661.label;
        if (i2 == 0) {
            C12113l.throwOnFailure(objAwaitVideoInputDevicesNativeAsync);
            c61661.L$0 = this;
            c61661.label = 1;
            objAwaitVideoInputDevicesNativeAsync = awaitVideoInputDevicesNativeAsync(c61661);
            if (objAwaitVideoInputDevicesNativeAsync == coroutine_suspended) {
                return coroutine_suspended;
            }
            storeMediaEngine = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            storeMediaEngine = (StoreMediaEngine) c61661.L$0;
            C12113l.throwOnFailure(objAwaitVideoInputDevicesNativeAsync);
        }
        return storeMediaEngine.pickDefaultDeviceGUID((VideoInputDeviceDescription[]) objAwaitVideoInputDevicesNativeAsync);
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
            C12238m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        return mediaEngine;
    }

    public final Observable<MediaEngine.OpenSLESConfig> getOpenSLESConfig() {
        return this.openSLESConfigSubject;
    }

    public final synchronized void getRankedRtcRegions(List<ModelRtcLatencyRegion> regionsWithIps, Function1<? super List<String>, Unit> callback) {
        C12238m.checkNotNullParameter(regionsWithIps, "regionsWithIps");
        C12238m.checkNotNullParameter(callback, "callback");
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(regionsWithIps, 10));
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
            C12238m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine.mo322b(rtcRegionArr, new C61671(callback));
    }

    public final Observable<VideoInputDeviceDescription> getSelectedVideoInputDevice() {
        Observable<VideoInputDeviceDescription> observableM11112r = this.selectedVideoInputDeviceSubject.m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "selectedVideoInputDevice…  .distinctUntilChanged()");
        return observableM11112r;
    }

    /* JADX INFO: renamed from: getSelectedVideoInputDeviceBlocking, reason: from getter */
    public final VideoInputDeviceDescription getSelectedVideoInputDevice() {
        return this.selectedVideoInputDevice;
    }

    public final Observable<List<VideoInputDeviceDescription>> getVideoInputDevices() {
        Observable<List<VideoInputDeviceDescription>> observableM11112r = this.videoInputDevicesSubject.m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "videoInputDevicesSubject…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Object getVideoInputDevicesNativeAsync(Continuation<? super VideoInputDeviceDescription[]> continuation) {
        C13126l c13126l = new C13126l(C12182b.intercepted(continuation), 1);
        c13126l.m11318A();
        getVideoInputDevicesNative(new StoreMediaEngine$getVideoInputDevicesNativeAsync$2$1(c13126l));
        Object objM11326u = c13126l.m11326u();
        if (objM11326u == C12183c.getCOROUTINE_SUSPENDED()) {
            C12190g.probeCoroutineSuspended(continuation);
        }
        return objM11326u;
    }

    public final synchronized Discord getVoiceEngineNative() {
        MediaEngine mediaEngine;
        mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            C12238m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        return mediaEngine.mo329i();
    }

    public final synchronized void handleConnectionOpen(ModelPayload payload) {
        C12238m.checkNotNullParameter(payload, "payload");
        this.userId = payload.getMe().getId();
    }

    public final void handleMicrophonePermissionGranted() {
        Observable<Boolean> observableM11100Z = this.isNativeEngineInitializedSubject.m11100Z(1);
        C12238m.checkNotNullExpressionValue(observableM11100Z, "isNativeEngineInitializedSubject\n        .take(1)");
        ObservableExtensionsKt.appSubscribe(observableM11100Z, (Class<?>) StoreMediaEngine.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C61691());
    }

    public final synchronized void handleVoiceChannelSelected(long channelId) {
        Long l = this.previousVoiceChannelId;
        if (l != null && (l == null || l.longValue() != 0)) {
            if (channelId == 0) {
                getVideoInputDevicesNative(new C61721());
            }
        }
        this.previousVoiceChannelId = Long.valueOf(channelId);
    }

    public final synchronized boolean hasNativeEngineEverInitialized() {
        return this.hasNativeEngineEverInitialized;
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        C12238m.checkNotNullParameter(context, "context");
        super.init(context);
        this.preferredVideoInputDeviceGUID = this.preferredVideoInputDeviceGuidCache.get();
        this.hasNativeEngineEverInitialized = this.hasNativeEngineEverInitializedCache.get().booleanValue();
        SharedPreferences prefsSessionDurable = getPrefsSessionDurable();
        MediaEngine.OpenSLESConfig openSLESConfig = DEFAULT_OPENSLES_CONFIG;
        String string = prefsSessionDurable.getString("OPEN_SLES", openSLESConfig.name());
        if (string == null) {
            string = openSLESConfig.name();
        }
        C12238m.checkNotNullExpressionValue(string, "prefsSessionDurable\n    …AULT_OPENSLES_CONFIG.name");
        MediaEngine.OpenSLESConfig openSLESConfigValueOf = MediaEngine.OpenSLESConfig.valueOf(string);
        this.openSLESConfigSubject.f27653k.onNext(openSLESConfigValueOf);
        MediaEngine.InterfaceC5641b interfaceC5641b = new MediaEngine.InterfaceC5641b() { // from class: com.discord.stores.StoreMediaEngine$init$echoCancellationCallback$1
            @Override // com.discord.rtcconnection.mediaengine.MediaEngine.InterfaceC5641b
            public void onEchoCancellationUpdated(MediaEngine.EchoCancellationInfo info) {
                C12238m.checkNotNullParameter(info, "info");
                this.this$0.dispatcher.schedule(new C6174x527da00c(info));
            }
        };
        EngineListener engineListener = new EngineListener();
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        C12238m.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "Executors.newSingleThreadExecutor()");
        AppLog appLog = AppLog.f14950g;
        C1215g.a aVar = C1215g.f1662c;
        C1215g c1215g = C1215g.f1661b;
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(engineListener, "listener");
        C12238m.checkNotNullParameter(executorServiceNewSingleThreadExecutor, "singleThreadExecutorService");
        C12238m.checkNotNullParameter(openSLESConfigValueOf, "openSLESConfig");
        C12238m.checkNotNullParameter(appLog, "logger");
        C12238m.checkNotNullParameter(c1215g, "echoCancellation");
        C12238m.checkNotNullParameter(interfaceC5641b, "echoCancellationCallback");
        this.mediaEngine = new C1233k(context, engineListener, new ExecutorServiceC1192c(executorServiceNewSingleThreadExecutor, false), openSLESConfigValueOf, appLog, c1215g, interfaceC5641b, null, null, 384);
        Observable<R> observableM11083G = this.storeStream.getExperiments().observeUserExperiment("2021-05_opensl_default_enable_android", true).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
        C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
        Observable observableM11100Z = observableM11083G.m11100Z(1);
        C12238m.checkNotNullExpressionValue(observableM11100Z, "storeStream.experiments.…erNull()\n        .take(1)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.computationLatest(observableM11100Z), (Class<?>) StoreMediaEngine.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C61731());
    }

    public final Observable<KrispOveruseDetector.Status> onKrispStatusEvent() {
        PublishSubject<KrispOveruseDetector.Status> publishSubject = this.onKrispStatusSubject;
        C12238m.checkNotNullExpressionValue(publishSubject, "onKrispStatusSubject");
        return publishSubject;
    }

    public final void selectDefaultVideoDevice(Function1<? super String, Unit> onSelected) {
        C13163x0 c13163x0 = C13163x0.f27919j;
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        C3404f.m4211H0(c13163x0, C13031n.f27700b.mo11194H(), null, new C61751(onSelected, null), 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object selectDefaultVideoDeviceAsync(Continuation<? super String> continuation) {
        C61761 c61761;
        StoreMediaEngine storeMediaEngine;
        if (continuation instanceof C61761) {
            c61761 = (C61761) continuation;
            int i = c61761.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c61761.label = i - Integer.MIN_VALUE;
            } else {
                c61761 = new C61761(continuation);
            }
        } else {
            c61761 = new C61761(continuation);
        }
        Object objAwaitVideoInputDevicesNativeAsync = c61761.result;
        Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
        int i2 = c61761.label;
        if (i2 == 0) {
            C12113l.throwOnFailure(objAwaitVideoInputDevicesNativeAsync);
            c61761.L$0 = this;
            c61761.label = 1;
            objAwaitVideoInputDevicesNativeAsync = awaitVideoInputDevicesNativeAsync(c61761);
            if (objAwaitVideoInputDevicesNativeAsync == coroutine_suspended) {
                return coroutine_suspended;
            }
            storeMediaEngine = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            storeMediaEngine = (StoreMediaEngine) c61761.L$0;
            C12113l.throwOnFailure(objAwaitVideoInputDevicesNativeAsync);
        }
        VideoInputDeviceDescription[] videoInputDeviceDescriptionArr = (VideoInputDeviceDescription[]) objAwaitVideoInputDevicesNativeAsync;
        String strPickDefaultDeviceGUID = storeMediaEngine.pickDefaultDeviceGUID(videoInputDeviceDescriptionArr);
        handleVideoInputDevices$default(storeMediaEngine, videoInputDeviceDescriptionArr, strPickDefaultDeviceGUID, null, 4, null);
        return strPickDefaultDeviceGUID;
    }

    public final void selectVideoInputDevice(String deviceGUID) {
        getVideoInputDevicesNative(new C61771(deviceGUID));
    }

    public final synchronized void setAudioInputEnabled(boolean audioInputEnabled) {
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            C12238m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine.mo331k(audioInputEnabled);
    }

    @SuppressLint({"ApplySharedPref"})
    public final synchronized void setOpenSLESConfig(MediaEngine.OpenSLESConfig openSLESConfig) {
        C12238m.checkNotNullParameter(openSLESConfig, "openSLESConfig");
        this.openSLESConfigSubject.f27653k.onNext(openSLESConfig);
        getPrefsSessionDurable().edit().putString("OPEN_SLES", openSLESConfig.name()).commit();
    }

    public final synchronized void setPttActive(boolean active) {
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            C12238m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        Iterator<T> it = mediaEngine.getConnections().iterator();
        while (it.hasNext()) {
            ((MediaEngineConnection) it.next()).mo311q(active);
        }
        SerializedSubject<Boolean, Boolean> serializedSubject = this.pttActiveSubject;
        serializedSubject.f27653k.onNext(Boolean.valueOf(active));
    }
}
