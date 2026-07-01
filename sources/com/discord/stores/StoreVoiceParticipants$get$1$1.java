package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.voice.state.VoiceState;
import d0.z.d.m;
import j0.k.b;
import java.util.Map;
import rx.Observable;

/* JADX INFO: compiled from: StoreVoiceParticipants.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVoiceParticipants$get$1$1<T, R> implements b<Map<Long, ? extends VoiceState>, Observable<? extends Map<Long, ? extends StoreVoiceParticipants$VoiceUser>>> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreVoiceParticipants$get$1 this$0;

    public StoreVoiceParticipants$get$1$1(StoreVoiceParticipants$get$1 storeVoiceParticipants$get$1, Channel channel, long j) {
        this.this$0 = storeVoiceParticipants$get$1;
        this.$channel = channel;
        this.$guildId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends StoreVoiceParticipants$VoiceUser>> call(Map<Long, ? extends VoiceState> map) {
        return call2((Map<Long, VoiceState>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Map<Long, StoreVoiceParticipants$VoiceUser>> call2(Map<Long, VoiceState> map) {
        Observable observableObserveMe$default = StoreUser.observeMe$default(this.this$0.this$0.getStream().getUsers(), false, 1, null);
        StoreVoiceParticipants storeVoiceParticipants = this.this$0.this$0;
        Channel channel = this.$channel;
        m.checkNotNullExpressionValue(map, "voiceStates");
        return Observable.j(observableObserveMe$default, StoreVoiceParticipants.access$getOtherVoiceUsers(storeVoiceParticipants, channel, map), StoreVoiceParticipants$get$1$1$1.INSTANCE).Y(new StoreVoiceParticipants$get$1$1$2(this, map));
    }
}
