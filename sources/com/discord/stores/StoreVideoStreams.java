package com.discord.stores;

import b.c.a.a0.d;
import com.discord.api.voice.state.VoiceState;
import com.discord.rtcconnection.VideoMetadata;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import d0.t.h0;
import d0.z.d.m;
import java.util.HashMap;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreVideoStreams.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVideoStreams extends StoreV2 {
    private final ObservationDeck observationDeck;
    private final HashMap<Long, StoreVideoStreams$UserStreams> userStreamsByUser;
    private Map<Long, StoreVideoStreams$UserStreams> userStreamsByUserSnapshot;

    public StoreVideoStreams() {
        this(null, 1, null);
    }

    public /* synthetic */ StoreVideoStreams(ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ Map access$getUserStreamsByUserSnapshot$p(StoreVideoStreams storeVideoStreams) {
        return storeVideoStreams.userStreamsByUserSnapshot;
    }

    public static final /* synthetic */ void access$setUserStreamsByUserSnapshot$p(StoreVideoStreams storeVideoStreams, Map map) {
        storeVideoStreams.userStreamsByUserSnapshot = map;
    }

    private final StoreVideoStreams$UserStreams currentUserStreams(long userId) {
        StoreVideoStreams$UserStreams storeVideoStreams$UserStreams = this.userStreamsByUser.get(Long.valueOf(userId));
        return storeVideoStreams$UserStreams != null ? storeVideoStreams$UserStreams : StoreVideoStreams$UserStreams.Companion.getEmpty();
    }

    private final void setUserStreams(long userId, StoreVideoStreams$UserStreams userStreams) {
        if (userStreams.getIsEmpty()) {
            this.userStreamsByUser.remove(Long.valueOf(userId));
        } else {
            this.userStreamsByUser.put(Long.valueOf(userId), userStreams);
        }
        markChanged();
    }

    @StoreThread
    public final Long findUserForApplicationStream(int streamId) {
        for (Map$Entry<Long, StoreVideoStreams$UserStreams> map$Entry : this.userStreamsByUser.entrySet()) {
            long jLongValue = map$Entry.getKey().longValue();
            Integer applicationStreamId = map$Entry.getValue().getApplicationStreamId();
            if (applicationStreamId != null && applicationStreamId.intValue() == streamId) {
                return Long.valueOf(jLongValue);
            }
        }
        return null;
    }

    @StoreThread
    public final void handleApplicationStreamUpdate(long userId, Integer streamId) {
        setUserStreams(userId, StoreVideoStreams$UserStreams.copy$default(currentUserStreams(userId), null, null, streamId, null, 11, null));
    }

    @StoreThread
    public final void handleApplicationStreamVideoMetadataUpdate(VideoMetadata metadata) {
        m.checkNotNullParameter(metadata, "metadata");
        setUserStreams(metadata.userID, StoreVideoStreams$UserStreams.copy$default(currentUserStreams(metadata.userID), null, null, null, metadata, 7, null));
    }

    @StoreThread
    public final void handleVideoMetadataUpdate(VideoMetadata metadata) {
        m.checkNotNullParameter(metadata, "metadata");
        setUserStreams(metadata.userID, StoreVideoStreams$UserStreams.copy$default(currentUserStreams(metadata.userID), null, metadata, null, null, 13, null));
    }

    @StoreThread
    public final void handleVideoStreamUpdate(long userId, Integer streamId) {
        setUserStreams(userId, StoreVideoStreams$UserStreams.copy$default(currentUserStreams(userId), streamId, null, null, null, 14, null));
    }

    @StoreThread
    public final void handleVoiceChannelSelected(long channelId) {
        if (channelId == 0 && (!this.userStreamsByUser.isEmpty())) {
            this.userStreamsByUser.clear();
            markChanged();
        }
    }

    @StoreThread
    public final void handleVoiceStateUpdates(VoiceState voiceState) {
        m.checkNotNullParameter(voiceState, "voiceState");
        if (d.X0(voiceState)) {
            if (this.userStreamsByUser.remove(Long.valueOf(voiceState.getUserId())) != null) {
                markChanged();
            }
        }
    }

    public final Observable<Map<Long, StoreVideoStreams$UserStreams>> observeUserStreams() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreVideoStreams$observeUserStreams$1(this), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.userStreamsByUserSnapshot = new HashMap(this.userStreamsByUser);
    }

    public StoreVideoStreams(ObservationDeck observationDeck) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.observationDeck = observationDeck;
        this.userStreamsByUserSnapshot = h0.emptyMap();
        this.userStreamsByUser = new HashMap<>();
    }
}
