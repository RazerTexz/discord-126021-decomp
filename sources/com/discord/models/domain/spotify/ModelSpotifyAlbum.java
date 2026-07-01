package com.discord.models.domain.spotify;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: ModelSpotifyAlbum.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelSpotifyAlbum {
    private final String albumType;
    private final String id;
    private final List<ModelSpotifyAlbum$AlbumImage> images;
    private final String name;

    public ModelSpotifyAlbum(String str, String str2, List<ModelSpotifyAlbum$AlbumImage> list, String str3) {
        m.checkNotNullParameter(str, "albumType");
        m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_ID);
        m.checkNotNullParameter(list, "images");
        m.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.albumType = str;
        this.id = str2;
        this.images = list;
        this.name = str3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelSpotifyAlbum copy$default(ModelSpotifyAlbum modelSpotifyAlbum, String str, String str2, List list, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelSpotifyAlbum.albumType;
        }
        if ((i & 2) != 0) {
            str2 = modelSpotifyAlbum.id;
        }
        if ((i & 4) != 0) {
            list = modelSpotifyAlbum.images;
        }
        if ((i & 8) != 0) {
            str3 = modelSpotifyAlbum.name;
        }
        return modelSpotifyAlbum.copy(str, str2, list, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAlbumType() {
        return this.albumType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final List<ModelSpotifyAlbum$AlbumImage> component3() {
        return this.images;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final ModelSpotifyAlbum copy(String albumType, String id2, List<ModelSpotifyAlbum$AlbumImage> images, String name) {
        m.checkNotNullParameter(albumType, "albumType");
        m.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        m.checkNotNullParameter(images, "images");
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new ModelSpotifyAlbum(albumType, id2, images, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelSpotifyAlbum)) {
            return false;
        }
        ModelSpotifyAlbum modelSpotifyAlbum = (ModelSpotifyAlbum) other;
        return m.areEqual(this.albumType, modelSpotifyAlbum.albumType) && m.areEqual(this.id, modelSpotifyAlbum.id) && m.areEqual(this.images, modelSpotifyAlbum.images) && m.areEqual(this.name, modelSpotifyAlbum.name);
    }

    public final String getAlbumType() {
        return this.albumType;
    }

    public final String getId() {
        return this.id;
    }

    public final List<ModelSpotifyAlbum$AlbumImage> getImages() {
        return this.images;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.albumType;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.id;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<ModelSpotifyAlbum$AlbumImage> list = this.images;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str3 = this.name;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelSpotifyAlbum(albumType=");
        sbU.append(this.albumType);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", images=");
        sbU.append(this.images);
        sbU.append(", name=");
        return a.J(sbU, this.name, ")");
    }
}
