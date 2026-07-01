package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: ModelApplicationStream.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class StreamCreateOrUpdate {
    private final boolean paused;
    private final String rtcServerId;
    private final String streamKey;
    private final List<Long> viewerIds;

    public StreamCreateOrUpdate(String str, String str2, boolean z2, List<Long> list) {
        m.checkNotNullParameter(str, "streamKey");
        m.checkNotNullParameter(list, "viewerIds");
        this.streamKey = str;
        this.rtcServerId = str2;
        this.paused = z2;
        this.viewerIds = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StreamCreateOrUpdate copy$default(StreamCreateOrUpdate streamCreateOrUpdate, String str, String str2, boolean z2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = streamCreateOrUpdate.streamKey;
        }
        if ((i & 2) != 0) {
            str2 = streamCreateOrUpdate.rtcServerId;
        }
        if ((i & 4) != 0) {
            z2 = streamCreateOrUpdate.paused;
        }
        if ((i & 8) != 0) {
            list = streamCreateOrUpdate.viewerIds;
        }
        return streamCreateOrUpdate.copy(str, str2, z2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStreamKey() {
        return this.streamKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRtcServerId() {
        return this.rtcServerId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getPaused() {
        return this.paused;
    }

    public final List<Long> component4() {
        return this.viewerIds;
    }

    public final StreamCreateOrUpdate copy(String streamKey, String rtcServerId, boolean paused, List<Long> viewerIds) {
        m.checkNotNullParameter(streamKey, "streamKey");
        m.checkNotNullParameter(viewerIds, "viewerIds");
        return new StreamCreateOrUpdate(streamKey, rtcServerId, paused, viewerIds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StreamCreateOrUpdate)) {
            return false;
        }
        StreamCreateOrUpdate streamCreateOrUpdate = (StreamCreateOrUpdate) other;
        return m.areEqual(this.streamKey, streamCreateOrUpdate.streamKey) && m.areEqual(this.rtcServerId, streamCreateOrUpdate.rtcServerId) && this.paused == streamCreateOrUpdate.paused && m.areEqual(this.viewerIds, streamCreateOrUpdate.viewerIds);
    }

    public final boolean getPaused() {
        return this.paused;
    }

    public final String getRtcServerId() {
        return this.rtcServerId;
    }

    public final String getStreamKey() {
        return this.streamKey;
    }

    public final List<Long> getViewerIds() {
        return this.viewerIds;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public int hashCode() {
        String str = this.streamKey;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.rtcServerId;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z2 = this.paused;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode2 + r2) * 31;
        List<Long> list = this.viewerIds;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StreamCreateOrUpdate(streamKey=");
        sbU.append(this.streamKey);
        sbU.append(", rtcServerId=");
        sbU.append(this.rtcServerId);
        sbU.append(", paused=");
        sbU.append(this.paused);
        sbU.append(", viewerIds=");
        return a.L(sbU, this.viewerIds, ")");
    }
}
