package com.discord.utilities.voice;

import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreRtcConnection;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreVoiceParticipants;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: CallSoundManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CallSoundManager$StoreStateGenerator implements CallSoundManager$IStoreStateGenerator {
    private final StoreApplicationStreaming storeApplicationStreaming;
    private final StoreChannels storeChannels;
    private final StoreRtcConnection storeRtcConnection;
    private final StoreUser storeUser;
    private final StoreVoiceParticipants storeVoiceParticipants;

    public CallSoundManager$StoreStateGenerator() {
        this(null, null, null, null, null, 31, null);
    }

    public CallSoundManager$StoreStateGenerator(StoreVoiceParticipants storeVoiceParticipants, StoreRtcConnection storeRtcConnection, StoreApplicationStreaming storeApplicationStreaming, StoreUser storeUser, StoreChannels storeChannels) {
        m.checkNotNullParameter(storeVoiceParticipants, "storeVoiceParticipants");
        m.checkNotNullParameter(storeRtcConnection, "storeRtcConnection");
        m.checkNotNullParameter(storeApplicationStreaming, "storeApplicationStreaming");
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(storeChannels, "storeChannels");
        this.storeVoiceParticipants = storeVoiceParticipants;
        this.storeRtcConnection = storeRtcConnection;
        this.storeApplicationStreaming = storeApplicationStreaming;
        this.storeUser = storeUser;
        this.storeChannels = storeChannels;
    }

    @Override // com.discord.utilities.voice.CallSoundManager$IStoreStateGenerator
    public Observable<CallSoundManager$StoreState> observeStoreState(long voiceChannelId) {
        Observable<CallSoundManager$StoreState> observableE = Observable.e(this.storeVoiceParticipants.get(voiceChannelId), this.storeRtcConnection.getConnectionState(), this.storeApplicationStreaming.observeStreamsByUser(), this.storeApplicationStreaming.observeStreamSpectators(), this.storeApplicationStreaming.observeActiveStream(), StoreUser.observeMe$default(this.storeUser, false, 1, null), this.storeChannels.observeChannel(voiceChannelId), CallSoundManager$StoreStateGenerator$observeStoreState$1.INSTANCE);
        m.checkNotNullExpressionValue(observableE, "Observable.combineLatest…Channel\n        )\n      }");
        return observableE;
    }

    public /* synthetic */ CallSoundManager$StoreStateGenerator(StoreVoiceParticipants storeVoiceParticipants, StoreRtcConnection storeRtcConnection, StoreApplicationStreaming storeApplicationStreaming, StoreUser storeUser, StoreChannels storeChannels, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.Companion.getVoiceParticipants() : storeVoiceParticipants, (i & 2) != 0 ? StoreStream.Companion.getRtcConnection() : storeRtcConnection, (i & 4) != 0 ? StoreStream.Companion.getApplicationStreaming() : storeApplicationStreaming, (i & 8) != 0 ? StoreStream.Companion.getUsers() : storeUser, (i & 16) != 0 ? StoreStream.Companion.getChannels() : storeChannels);
    }
}
