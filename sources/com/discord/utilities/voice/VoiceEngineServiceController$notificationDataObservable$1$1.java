package com.discord.utilities.voice;

import androidx.core.app.NotificationCompat;
import com.discord.rtcconnection.RtcConnection$State;
import com.discord.stores.StoreAudioManagerV2$State;
import com.discord.stores.StoreMediaSettings$VoiceConfiguration;
import com.discord.utilities.rx.ObservableWithLeadingEdgeThrottle;
import com.discord.widgets.voice.model.CallModel;
import com.discord.widgets.voice.model.CallModel$Companion;
import d0.z.d.m;
import j0.k.b;
import java.util.concurrent.TimeUnit;
import rx.Observable;

/* JADX INFO: compiled from: VoiceEngineServiceController.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceEngineServiceController$notificationDataObservable$1$1<T, R> implements b<Long, Observable<? extends VoiceEngineServiceController$NotificationData>> {
    public final /* synthetic */ RtcConnection$State $state;
    public final /* synthetic */ VoiceEngineServiceController$notificationDataObservable$1 this$0;

    public VoiceEngineServiceController$notificationDataObservable$1$1(VoiceEngineServiceController$notificationDataObservable$1 voiceEngineServiceController$notificationDataObservable$1, RtcConnection$State rtcConnection$State) {
        this.this$0 = voiceEngineServiceController$notificationDataObservable$1;
        this.$state = rtcConnection$State;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends VoiceEngineServiceController$NotificationData> call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends VoiceEngineServiceController$NotificationData> call2(Long l) {
        Observable<StoreMediaSettings$VoiceConfiguration> voiceConfig = VoiceEngineServiceController.access$getMediaSettingsStore$p(this.this$0.this$0).getVoiceConfig();
        Observable<StoreAudioManagerV2$State> observableObserveAudioManagerState = VoiceEngineServiceController.access$getAudioManagerStore$p(this.this$0.this$0).observeAudioManagerState();
        CallModel$Companion callModel$Companion = CallModel.Companion;
        m.checkNotNullExpressionValue(l, "selectedVoiceChannelId");
        return ObservableWithLeadingEdgeThrottle.combineLatest(voiceConfig, observableObserveAudioManagerState, callModel$Companion.get(l.longValue()), new VoiceEngineServiceController$notificationDataObservable$1$1$1(this), 300L, TimeUnit.MILLISECONDS);
    }
}
