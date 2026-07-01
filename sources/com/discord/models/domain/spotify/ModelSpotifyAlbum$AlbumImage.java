package com.discord.models.domain.spotify;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ModelSpotifyAlbum.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelSpotifyAlbum$AlbumImage {
    private final String url;

    public ModelSpotifyAlbum$AlbumImage(String str) {
        this.url = str;
    }

    public static /* synthetic */ ModelSpotifyAlbum$AlbumImage copy$default(ModelSpotifyAlbum$AlbumImage modelSpotifyAlbum$AlbumImage, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelSpotifyAlbum$AlbumImage.url;
        }
        return modelSpotifyAlbum$AlbumImage.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final ModelSpotifyAlbum$AlbumImage copy(String url) {
        return new ModelSpotifyAlbum$AlbumImage(url);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ModelSpotifyAlbum$AlbumImage) && m.areEqual(this.url, ((ModelSpotifyAlbum$AlbumImage) other).url);
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
        return a.J(a.U("AlbumImage(url="), this.url, ")");
    }
}
