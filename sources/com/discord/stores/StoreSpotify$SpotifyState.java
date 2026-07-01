package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.spotify.ModelSpotifyTrack;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreSpotify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreSpotify$SpotifyState {
    private final boolean playing;
    private final int position;
    private final long start;
    private final ModelSpotifyTrack track;

    public StoreSpotify$SpotifyState() {
        this(null, false, 0, 0L, 15, null);
    }

    public StoreSpotify$SpotifyState(ModelSpotifyTrack modelSpotifyTrack, boolean z2, int i, long j) {
        this.track = modelSpotifyTrack;
        this.playing = z2;
        this.position = i;
        this.start = j;
    }

    public static /* synthetic */ StoreSpotify$SpotifyState copy$default(StoreSpotify$SpotifyState storeSpotify$SpotifyState, ModelSpotifyTrack modelSpotifyTrack, boolean z2, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            modelSpotifyTrack = storeSpotify$SpotifyState.track;
        }
        if ((i2 & 2) != 0) {
            z2 = storeSpotify$SpotifyState.playing;
        }
        boolean z3 = z2;
        if ((i2 & 4) != 0) {
            i = storeSpotify$SpotifyState.position;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            j = storeSpotify$SpotifyState.start;
        }
        return storeSpotify$SpotifyState.copy(modelSpotifyTrack, z3, i3, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelSpotifyTrack getTrack() {
        return this.track;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getPlaying() {
        return this.playing;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getStart() {
        return this.start;
    }

    public final StoreSpotify$SpotifyState copy(ModelSpotifyTrack track, boolean playing, int position, long start) {
        return new StoreSpotify$SpotifyState(track, playing, position, start);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreSpotify$SpotifyState)) {
            return false;
        }
        StoreSpotify$SpotifyState storeSpotify$SpotifyState = (StoreSpotify$SpotifyState) other;
        return m.areEqual(this.track, storeSpotify$SpotifyState.track) && this.playing == storeSpotify$SpotifyState.playing && this.position == storeSpotify$SpotifyState.position && this.start == storeSpotify$SpotifyState.start;
    }

    public final boolean getPlaying() {
        return this.playing;
    }

    public final int getPosition() {
        return this.position;
    }

    public final long getStart() {
        return this.start;
    }

    public final ModelSpotifyTrack getTrack() {
        return this.track;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        ModelSpotifyTrack modelSpotifyTrack = this.track;
        int iHashCode = (modelSpotifyTrack != null ? modelSpotifyTrack.hashCode() : 0) * 31;
        boolean z2 = this.playing;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return b.a(this.start) + ((((iHashCode + r1) * 31) + this.position) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("SpotifyState(track=");
        sbU.append(this.track);
        sbU.append(", playing=");
        sbU.append(this.playing);
        sbU.append(", position=");
        sbU.append(this.position);
        sbU.append(", start=");
        return a.C(sbU, this.start, ")");
    }

    public /* synthetic */ StoreSpotify$SpotifyState(ModelSpotifyTrack modelSpotifyTrack, boolean z2, int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : modelSpotifyTrack, (i2 & 2) != 0 ? false : z2, (i2 & 4) == 0 ? i : 0, (i2 & 8) != 0 ? 0L : j);
    }
}
