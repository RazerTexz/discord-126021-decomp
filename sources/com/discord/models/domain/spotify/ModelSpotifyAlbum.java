package com.discord.models.domain.spotify;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ModelSpotifyAlbum.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelSpotifyAlbum {
    private final String albumType;
    private final String id;
    private final List<AlbumImage> images;
    private final String name;

    /* JADX INFO: compiled from: ModelSpotifyAlbum.kt */
    public static final /* data */ class AlbumImage {
        private final String url;

        public AlbumImage(String str) {
            this.url = str;
        }

        public static /* synthetic */ AlbumImage copy$default(AlbumImage albumImage, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = albumImage.url;
            }
            return albumImage.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final AlbumImage copy(String url) {
            return new AlbumImage(url);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof AlbumImage) && C12238m.areEqual(this.url, ((AlbumImage) other).url);
            }
            return true;
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            String str = this.url;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return C1643a.m822J(C1643a.m833U("AlbumImage(url="), this.url, ")");
        }
    }

    public ModelSpotifyAlbum(String str, String str2, List<AlbumImage> list, String str3) {
        C12238m.checkNotNullParameter(str, "albumType");
        C12238m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_ID);
        C12238m.checkNotNullParameter(list, "images");
        C12238m.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_NAME);
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

    public final List<AlbumImage> component3() {
        return this.images;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final ModelSpotifyAlbum copy(String albumType, String id2, List<AlbumImage> images, String name) {
        C12238m.checkNotNullParameter(albumType, "albumType");
        C12238m.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        C12238m.checkNotNullParameter(images, "images");
        C12238m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
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
        return C12238m.areEqual(this.albumType, modelSpotifyAlbum.albumType) && C12238m.areEqual(this.id, modelSpotifyAlbum.id) && C12238m.areEqual(this.images, modelSpotifyAlbum.images) && C12238m.areEqual(this.name, modelSpotifyAlbum.name);
    }

    public final String getAlbumType() {
        return this.albumType;
    }

    public final String getId() {
        return this.id;
    }

    public final List<AlbumImage> getImages() {
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
        List<AlbumImage> list = this.images;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str3 = this.name;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ModelSpotifyAlbum(albumType=");
        sbM833U.append(this.albumType);
        sbM833U.append(", id=");
        sbM833U.append(this.id);
        sbM833U.append(", images=");
        sbM833U.append(this.images);
        sbM833U.append(", name=");
        return C1643a.m822J(sbM833U, this.name, ")");
    }
}
