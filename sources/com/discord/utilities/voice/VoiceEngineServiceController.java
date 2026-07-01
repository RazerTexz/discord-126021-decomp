package com.discord.utilities.voice;

import android.content.Context;
import android.content.Intent;
import com.discord.rtcconnection.RtcConnection$State$d;
import com.discord.stores.StoreAudioManagerV2;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreRtcConnection;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: VoiceEngineServiceController.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceEngineServiceController {
    public static final VoiceEngineServiceController$Companion Companion = new VoiceEngineServiceController$Companion(null);
    private static final Lazy INSTANCE$delegate = g.lazy(VoiceEngineServiceController$Companion$INSTANCE$2.INSTANCE);
    private static final VoiceEngineServiceController$NotificationData NOTIFICATION_DATA_DISCONNECTED = new VoiceEngineServiceController$NotificationData(new RtcConnection$State$d(false), "", false, false, false, false, -1, null, false, false);
    private final StoreAudioManagerV2 audioManagerStore;
    private final StoreMediaSettings mediaSettingsStore;
    private final Observable<VoiceEngineServiceController$NotificationData> notificationDataObservable;
    private VoiceEngineForegroundService$Connection serviceBinding;
    private final StoreVoiceChannelSelected voiceChannelSelectedStore;

    public VoiceEngineServiceController(StoreAudioManagerV2 storeAudioManagerV2, StoreMediaSettings storeMediaSettings, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreRtcConnection storeRtcConnection) {
        m.checkNotNullParameter(storeAudioManagerV2, "audioManagerStore");
        m.checkNotNullParameter(storeMediaSettings, "mediaSettingsStore");
        m.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelectedStore");
        m.checkNotNullParameter(storeRtcConnection, "rtcConnectionStore");
        this.audioManagerStore = storeAudioManagerV2;
        this.mediaSettingsStore = storeMediaSettings;
        this.voiceChannelSelectedStore = storeVoiceChannelSelected;
        Observable<R> observableY = storeRtcConnection.getConnectionState().Y(new VoiceEngineServiceController$notificationDataObservable$1(this));
        m.checkNotNullExpressionValue(observableY, "rtcConnectionStore\n     …            }\n          }");
        this.notificationDataObservable = ObservableExtensionsKt.computationLatest(observableY).r();
    }

    public static final /* synthetic */ StoreAudioManagerV2 access$getAudioManagerStore$p(VoiceEngineServiceController voiceEngineServiceController) {
        return voiceEngineServiceController.audioManagerStore;
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public static final /* synthetic */ StoreMediaSettings access$getMediaSettingsStore$p(VoiceEngineServiceController voiceEngineServiceController) {
        return voiceEngineServiceController.mediaSettingsStore;
    }

    public static final /* synthetic */ VoiceEngineServiceController$NotificationData access$getNOTIFICATION_DATA_DISCONNECTED$cp() {
        return NOTIFICATION_DATA_DISCONNECTED;
    }

    public static final /* synthetic */ VoiceEngineForegroundService$Connection access$getServiceBinding$p(VoiceEngineServiceController voiceEngineServiceController) {
        VoiceEngineForegroundService$Connection voiceEngineForegroundService$Connection = voiceEngineServiceController.serviceBinding;
        if (voiceEngineForegroundService$Connection == null) {
            m.throwUninitializedPropertyAccessException("serviceBinding");
        }
        return voiceEngineForegroundService$Connection;
    }

    public static final /* synthetic */ StoreVoiceChannelSelected access$getVoiceChannelSelectedStore$p(VoiceEngineServiceController voiceEngineServiceController) {
        return voiceEngineServiceController.voiceChannelSelectedStore;
    }

    public static final /* synthetic */ void access$setServiceBinding$p(VoiceEngineServiceController voiceEngineServiceController, VoiceEngineForegroundService$Connection voiceEngineForegroundService$Connection) {
        voiceEngineServiceController.serviceBinding = voiceEngineForegroundService$Connection;
    }

    public final void init(Context context) {
        m.checkNotNullParameter(context, "context");
        VoiceEngineForegroundService$Companion voiceEngineForegroundService$Companion = VoiceEngineForegroundService.Companion;
        voiceEngineForegroundService$Companion.setOnDisconnect(new VoiceEngineServiceController$init$1(this));
        voiceEngineForegroundService$Companion.setOnToggleSelfDeafen(new VoiceEngineServiceController$init$2(this));
        voiceEngineForegroundService$Companion.setOnToggleSelfMute(new VoiceEngineServiceController$init$3(this, context));
        this.serviceBinding = new VoiceEngineForegroundService$Connection(context);
        Observable<VoiceEngineServiceController$NotificationData> observable = this.notificationDataObservable;
        m.checkNotNullExpressionValue(observable, "notificationDataObservable");
        ObservableExtensionsKt.appSubscribe$default(observable, VoiceEngineServiceController.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new VoiceEngineServiceController$init$4(this, context), 62, (Object) null);
    }

    public final void startStream(Intent permissionIntent) {
        m.checkNotNullParameter(permissionIntent, "permissionIntent");
        VoiceEngineForegroundService$Companion voiceEngineForegroundService$Companion = VoiceEngineForegroundService.Companion;
        VoiceEngineForegroundService$Connection voiceEngineForegroundService$Connection = this.serviceBinding;
        if (voiceEngineForegroundService$Connection == null) {
            m.throwUninitializedPropertyAccessException("serviceBinding");
        }
        voiceEngineForegroundService$Companion.startStream(voiceEngineForegroundService$Connection, permissionIntent);
    }

    public final void stopStream() {
        VoiceEngineForegroundService$Companion voiceEngineForegroundService$Companion = VoiceEngineForegroundService.Companion;
        VoiceEngineForegroundService$Connection voiceEngineForegroundService$Connection = this.serviceBinding;
        if (voiceEngineForegroundService$Connection == null) {
            m.throwUninitializedPropertyAccessException("serviceBinding");
        }
        voiceEngineForegroundService$Companion.stopStream(voiceEngineForegroundService$Connection);
    }
}
