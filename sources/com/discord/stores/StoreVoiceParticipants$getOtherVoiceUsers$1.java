package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.user.User;
import j0.k.b;
import java.util.Collection;
import java.util.Map;
import rx.Observable;

/* JADX INFO: compiled from: StoreVoiceParticipants.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVoiceParticipants$getOtherVoiceUsers$1<T, R> implements b<Long, Observable<? extends Collection<? extends User>>> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ Map $voiceStates;

    public StoreVoiceParticipants$getOtherVoiceUsers$1(Channel channel, Map map) {
        this.$channel = channel;
        this.$voiceStates = map;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Collection<? extends User>> call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Collection<User>> call2(Long l) {
        return StoreStream.Companion.getGuilds().observeComputed(this.$channel.getGuildId()).G(StoreVoiceParticipants$getOtherVoiceUsers$1$1.INSTANCE).G(new StoreVoiceParticipants$getOtherVoiceUsers$1$2(this, l)).Y(new StoreVoiceParticipants$getOtherVoiceUsers$1$3(this));
    }
}
