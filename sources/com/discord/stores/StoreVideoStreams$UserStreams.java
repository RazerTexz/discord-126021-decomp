package com.discord.stores;

import b.d.b.a.a;
import com.discord.rtcconnection.VideoMetadata;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreVideoStreams.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreVideoStreams$UserStreams {
    public static final StoreVideoStreams$UserStreams$Companion Companion = new StoreVideoStreams$UserStreams$Companion(null);
    private static final StoreVideoStreams$UserStreams Empty = new StoreVideoStreams$UserStreams(null, null, null, null);
    private final Integer applicationStreamId;
    private final VideoMetadata applicationStreamMetadata;
    private final Integer callStreamId;
    private final VideoMetadata callStreamMetadata;
    private final boolean isEmpty = m.areEqual(this, Empty);

    public StoreVideoStreams$UserStreams(Integer num, VideoMetadata videoMetadata, Integer num2, VideoMetadata videoMetadata2) {
        this.callStreamId = num;
        this.callStreamMetadata = videoMetadata;
        this.applicationStreamId = num2;
        this.applicationStreamMetadata = videoMetadata2;
    }

    public static final /* synthetic */ StoreVideoStreams$UserStreams access$getEmpty$cp() {
        return Empty;
    }

    public static /* synthetic */ StoreVideoStreams$UserStreams copy$default(StoreVideoStreams$UserStreams storeVideoStreams$UserStreams, Integer num, VideoMetadata videoMetadata, Integer num2, VideoMetadata videoMetadata2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = storeVideoStreams$UserStreams.callStreamId;
        }
        if ((i & 2) != 0) {
            videoMetadata = storeVideoStreams$UserStreams.callStreamMetadata;
        }
        if ((i & 4) != 0) {
            num2 = storeVideoStreams$UserStreams.applicationStreamId;
        }
        if ((i & 8) != 0) {
            videoMetadata2 = storeVideoStreams$UserStreams.applicationStreamMetadata;
        }
        return storeVideoStreams$UserStreams.copy(num, videoMetadata, num2, videoMetadata2);
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

    public final StoreVideoStreams$UserStreams copy(Integer callStreamId, VideoMetadata callStreamMetadata, Integer applicationStreamId, VideoMetadata applicationStreamMetadata) {
        return new StoreVideoStreams$UserStreams(callStreamId, callStreamMetadata, applicationStreamId, applicationStreamMetadata);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreVideoStreams$UserStreams)) {
            return false;
        }
        StoreVideoStreams$UserStreams storeVideoStreams$UserStreams = (StoreVideoStreams$UserStreams) other;
        return m.areEqual(this.callStreamId, storeVideoStreams$UserStreams.callStreamId) && m.areEqual(this.callStreamMetadata, storeVideoStreams$UserStreams.callStreamMetadata) && m.areEqual(this.applicationStreamId, storeVideoStreams$UserStreams.applicationStreamId) && m.areEqual(this.applicationStreamMetadata, storeVideoStreams$UserStreams.applicationStreamMetadata);
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
        StringBuilder sbU = a.U("UserStreams(callStreamId=");
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
