package com.discord.models.domain.spotify;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: ModelSpotifyTrack.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelSpotifyTrack {
    private final ModelSpotifyAlbum album;
    private final List<ModelSpotifyArtist> artists;
    private final long durationMs;
    private final String id;
    private final boolean isLocal;
    private final String name;

    public ModelSpotifyTrack(String str, String str2, long j, ModelSpotifyAlbum modelSpotifyAlbum, List<ModelSpotifyArtist> list, boolean z2) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(list, "artists");
        this.id = str;
        this.name = str2;
        this.durationMs = j;
        this.album = modelSpotifyAlbum;
        this.artists = list;
        this.isLocal = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelSpotifyTrack copy$default(ModelSpotifyTrack modelSpotifyTrack, String str, String str2, long j, ModelSpotifyAlbum modelSpotifyAlbum, List list, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelSpotifyTrack.id;
        }
        if ((i & 2) != 0) {
            str2 = modelSpotifyTrack.name;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            j = modelSpotifyTrack.durationMs;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            modelSpotifyAlbum = modelSpotifyTrack.album;
        }
        ModelSpotifyAlbum modelSpotifyAlbum2 = modelSpotifyAlbum;
        if ((i & 16) != 0) {
            list = modelSpotifyTrack.artists;
        }
        List list2 = list;
        if ((i & 32) != 0) {
            z2 = modelSpotifyTrack.isLocal;
        }
        return modelSpotifyTrack.copy(str, str3, j2, modelSpotifyAlbum2, list2, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getDurationMs() {
        return this.durationMs;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ModelSpotifyAlbum getAlbum() {
        return this.album;
    }

    public final List<ModelSpotifyArtist> component5() {
        return this.artists;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsLocal() {
        return this.isLocal;
    }

    public final ModelSpotifyTrack copy(String id2, String name, long durationMs, ModelSpotifyAlbum album, List<ModelSpotifyArtist> artists, boolean isLocal) {
        Intrinsics3.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(artists, "artists");
        return new ModelSpotifyTrack(id2, name, durationMs, album, artists, isLocal);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelSpotifyTrack)) {
            return false;
        }
        ModelSpotifyTrack modelSpotifyTrack = (ModelSpotifyTrack) other;
        return Intrinsics3.areEqual(this.id, modelSpotifyTrack.id) && Intrinsics3.areEqual(this.name, modelSpotifyTrack.name) && this.durationMs == modelSpotifyTrack.durationMs && Intrinsics3.areEqual(this.album, modelSpotifyTrack.album) && Intrinsics3.areEqual(this.artists, modelSpotifyTrack.artists) && this.isLocal == modelSpotifyTrack.isLocal;
    }

    public final ModelSpotifyAlbum getAlbum() {
        return this.album;
    }

    public final List<ModelSpotifyArtist> getArtists() {
        return this.artists;
    }

    public final long getDurationMs() {
        return this.durationMs;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        long j = this.durationMs;
        int i = (iHashCode2 + ((int) (j ^ (j >>> 32)))) * 31;
        ModelSpotifyAlbum modelSpotifyAlbum = this.album;
        int iHashCode3 = (i + (modelSpotifyAlbum != null ? modelSpotifyAlbum.hashCode() : 0)) * 31;
        List<ModelSpotifyArtist> list = this.artists;
        int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.isLocal;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode4 + r1;
    }

    public final boolean isLocal() {
        return this.isLocal;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelSpotifyTrack(id=");
        sbU.append(this.id);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", durationMs=");
        sbU.append(this.durationMs);
        sbU.append(", album=");
        sbU.append(this.album);
        sbU.append(", artists=");
        sbU.append(this.artists);
        sbU.append(", isLocal=");
        return outline.O(sbU, this.isLocal, ")");
    }
}
