package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.voice.state.VoiceState;
import java.util.Map;
import kotlin.Pair;
import rx.functions.Func2;

/* JADX INFO: compiled from: StoreCalls.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCalls$call$4<T1, T2, R> implements Func2<Channel, Map<Long, ? extends VoiceState>, Pair<? extends Channel, ? extends Map<Long, ? extends VoiceState>>> {
    public static final StoreCalls$call$4 INSTANCE = new StoreCalls$call$4();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Pair<? extends Channel, ? extends Map<Long, ? extends VoiceState>> call(Channel channel, Map<Long, ? extends VoiceState> map) {
        return call2(channel, (Map<Long, VoiceState>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Pair<Channel, Map<Long, VoiceState>> call2(Channel channel, Map<Long, VoiceState> map) {
        return new Pair<>(channel, map);
    }
}
