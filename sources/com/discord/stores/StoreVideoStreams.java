package com.discord.stores;

import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.api.voice.state.VoiceState;
import com.discord.rtcconnection.VideoMetadata;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreVideoStreams.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVideoStreams extends StoreV2 {
    private final ObservationDeck observationDeck;
    private final HashMap<Long, UserStreams> userStreamsByUser;
    private Map<Long, UserStreams> userStreamsByUserSnapshot;

    /* JADX INFO: compiled from: StoreVideoStreams.kt */
    public static final /* data */ class UserStreams {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final UserStreams Empty = new UserStreams(null, null, null, null);
        private final Integer applicationStreamId;
        private final VideoMetadata applicationStreamMetadata;
        private final Integer callStreamId;
        private final VideoMetadata callStreamMetadata;
        private final boolean isEmpty = Intrinsics3.areEqual(this, Empty);

        /* JADX INFO: compiled from: StoreVideoStreams.kt */
        public static final class Companion {
            private Companion() {
            }

            public final UserStreams getEmpty() {
                return UserStreams.Empty;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public UserStreams(Integer num, VideoMetadata videoMetadata, Integer num2, VideoMetadata videoMetadata2) {
            this.callStreamId = num;
            this.callStreamMetadata = videoMetadata;
            this.applicationStreamId = num2;
            this.applicationStreamMetadata = videoMetadata2;
        }

        public static /* synthetic */ UserStreams copy$default(UserStreams userStreams, Integer num, VideoMetadata videoMetadata, Integer num2, VideoMetadata videoMetadata2, int i, Object obj) {
            if ((i & 1) != 0) {
                num = userStreams.callStreamId;
            }
            if ((i & 2) != 0) {
                videoMetadata = userStreams.callStreamMetadata;
            }
            if ((i & 4) != 0) {
                num2 = userStreams.applicationStreamId;
            }
            if ((i & 8) != 0) {
                videoMetadata2 = userStreams.applicationStreamMetadata;
            }
            return userStreams.copy(num, videoMetadata, num2, videoMetadata2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getCallStreamId() {
            return this.callStreamId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final VideoMetadata getCallStreamMetadata() {
            return this.callStreamMetadata;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getApplicationStreamId() {
            return this.applicationStreamId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final VideoMetadata getApplicationStreamMetadata() {
            return this.applicationStreamMetadata;
        }

        public final UserStreams copy(Integer callStreamId, VideoMetadata callStreamMetadata, Integer applicationStreamId, VideoMetadata applicationStreamMetadata) {
            return new UserStreams(callStreamId, callStreamMetadata, applicationStreamId, applicationStreamMetadata);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UserStreams)) {
                return false;
            }
            UserStreams userStreams = (UserStreams) other;
            return Intrinsics3.areEqual(this.callStreamId, userStreams.callStreamId) && Intrinsics3.areEqual(this.callStreamMetadata, userStreams.callStreamMetadata) && Intrinsics3.areEqual(this.applicationStreamId, userStreams.applicationStreamId) && Intrinsics3.areEqual(this.applicationStreamMetadata, userStreams.applicationStreamMetadata);
        }

        public final Integer getApplicationStreamId() {
            return this.applicationStreamId;
        }

        public final VideoMetadata getApplicationStreamMetadata() {
            return this.applicationStreamMetadata;
        }

        public final Integer getCallStreamId() {
            return this.callStreamId;
        }

        public final VideoMetadata getCallStreamMetadata() {
            return this.callStreamMetadata;
        }

        public int hashCode() {
            Integer num = this.callStreamId;
            int iHashCode = (num != null ? num.hashCode() : 0) * 31;
            VideoMetadata videoMetadata = this.callStreamMetadata;
            int iHashCode2 = (iHashCode + (videoMetadata != null ? videoMetadata.hashCode() : 0)) * 31;
            Integer num2 = this.applicationStreamId;
            int iHashCode3 = (iHashCode2 + (num2 != null ? num2.hashCode() : 0)) * 31;
            VideoMetadata videoMetadata2 = this.applicationStreamMetadata;
            return iHashCode3 + (videoMetadata2 != null ? videoMetadata2.hashCode() : 0);
        }

        /* JADX INFO: renamed from: isEmpty, reason: from getter */
        public final boolean getIsEmpty() {
            return this.isEmpty;
        }

        public String toString() {
            StringBuilder sbU = outline.U("UserStreams(callStreamId=");
            sbU.append(this.callStreamId);
            sbU.append(", callStreamMetadata=");
            sbU.append(this.callStreamMetadata);
            sbU.append(", applicationStreamId=");
            sbU.append(this.applicationStreamId);
            sbU.append(", applicationStreamMetadata=");
            sbU.append(this.applicationStreamMetadata);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreVideoStreams$observeUserStreams$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreVideoStreams.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends UserStreams>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends UserStreams> invoke() {
            return StoreVideoStreams.this.userStreamsByUserSnapshot;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreVideoStreams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ StoreVideoStreams(ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    private final UserStreams currentUserStreams(long userId) {
        UserStreams userStreams = this.userStreamsByUser.get(Long.valueOf(userId));
        return userStreams != null ? userStreams : UserStreams.INSTANCE.getEmpty();
    }

    private final void setUserStreams(long userId, UserStreams userStreams) {
        if (userStreams.getIsEmpty()) {
            this.userStreamsByUser.remove(Long.valueOf(userId));
        } else {
            this.userStreamsByUser.put(Long.valueOf(userId), userStreams);
        }
        markChanged();
    }

    @Store3
    public final Long findUserForApplicationStream(int streamId) {
        for (Map.Entry<Long, UserStreams> entry : this.userStreamsByUser.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            Integer applicationStreamId = entry.getValue().getApplicationStreamId();
            if (applicationStreamId != null && applicationStreamId.intValue() == streamId) {
                return Long.valueOf(jLongValue);
            }
        }
        return null;
    }

    @Store3
    public final void handleApplicationStreamUpdate(long userId, Integer streamId) {
        setUserStreams(userId, UserStreams.copy$default(currentUserStreams(userId), null, null, streamId, null, 11, null));
    }

    @Store3
    public final void handleApplicationStreamVideoMetadataUpdate(VideoMetadata metadata) {
        Intrinsics3.checkNotNullParameter(metadata, "metadata");
        setUserStreams(metadata.userID, UserStreams.copy$default(currentUserStreams(metadata.userID), null, null, null, metadata, 7, null));
    }

    @Store3
    public final void handleVideoMetadataUpdate(VideoMetadata metadata) {
        Intrinsics3.checkNotNullParameter(metadata, "metadata");
        setUserStreams(metadata.userID, UserStreams.copy$default(currentUserStreams(metadata.userID), null, metadata, null, null, 13, null));
    }

    @Store3
    public final void handleVideoStreamUpdate(long userId, Integer streamId) {
        setUserStreams(userId, UserStreams.copy$default(currentUserStreams(userId), streamId, null, null, null, 14, null));
    }

    @Store3
    public final void handleVoiceChannelSelected(long channelId) {
        if (channelId == 0 && (!this.userStreamsByUser.isEmpty())) {
            this.userStreamsByUser.clear();
            markChanged();
        }
    }

    @Store3
    public final void handleVoiceStateUpdates(VoiceState voiceState) {
        Intrinsics3.checkNotNullParameter(voiceState, "voiceState");
        if (AnimatableValueParser.X0(voiceState)) {
            if (this.userStreamsByUser.remove(Long.valueOf(voiceState.getUserId())) != null) {
                markChanged();
            }
        }
    }

    public final Observable<Map<Long, UserStreams>> observeUserStreams() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.userStreamsByUserSnapshot = new HashMap(this.userStreamsByUser);
    }

    public StoreVideoStreams(ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.observationDeck = observationDeck;
        this.userStreamsByUserSnapshot = Maps6.emptyMap();
        this.userStreamsByUser = new HashMap<>();
    }
}
