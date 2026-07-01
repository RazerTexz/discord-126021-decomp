package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.voice.state.VoiceState;
import j0.k.b;
import j0.l.a.l0;
import j0.l.e.m$a;
import java.util.Map;
import rx.Observable;

/* JADX INFO: compiled from: StoreVoiceStates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVoiceStates$observe$2<T, R> implements b<Map<Long, ? extends VoiceState>, Observable<? extends Map<Long, VoiceState>>> {
    public final /* synthetic */ long $channelId;

    public StoreVoiceStates$observe$2(long j) {
        this.$channelId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Map<Long, VoiceState>> call(Map<Long, ? extends VoiceState> map) {
        return call2((Map<Long, VoiceState>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Map<Long, VoiceState>> call2(Map<Long, VoiceState> map) {
        return Observable.h0(new l0(Observable.B(map.values()).y(new StoreVoiceStates$observe$2$1(this)), StoreVoiceStates$observe$2$2.INSTANCE, m$a.INSTANCE));
    }
}
