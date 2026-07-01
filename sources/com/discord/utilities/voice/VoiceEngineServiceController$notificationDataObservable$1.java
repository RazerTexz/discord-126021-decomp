package com.discord.utilities.voice;

import androidx.core.app.NotificationCompat;
import com.discord.rtcconnection.RtcConnection$State;
import com.discord.rtcconnection.RtcConnection$State$h;
import com.discord.rtcconnection.RtcConnection$StateChange;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: VoiceEngineServiceController.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceEngineServiceController$notificationDataObservable$1<T, R> implements b<RtcConnection$StateChange, Observable<? extends VoiceEngineServiceController$NotificationData>> {
    public final /* synthetic */ VoiceEngineServiceController this$0;

    public VoiceEngineServiceController$notificationDataObservable$1(VoiceEngineServiceController voiceEngineServiceController) {
        this.this$0 = voiceEngineServiceController;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends VoiceEngineServiceController$NotificationData> call(RtcConnection$StateChange rtcConnection$StateChange) {
        return call2(rtcConnection$StateChange);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends VoiceEngineServiceController$NotificationData> call2(RtcConnection$StateChange rtcConnection$StateChange) {
        RtcConnection$State rtcConnection$State = rtcConnection$StateChange.state;
        return m.areEqual(rtcConnection$State, RtcConnection$State$h.a) ? new k(VoiceEngineServiceController.access$getNOTIFICATION_DATA_DISCONNECTED$cp()) : VoiceEngineServiceController.access$getVoiceChannelSelectedStore$p(this.this$0).observeSelectedVoiceChannelId().Y(new VoiceEngineServiceController$notificationDataObservable$1$1(this, rtcConnection$State));
    }
}
