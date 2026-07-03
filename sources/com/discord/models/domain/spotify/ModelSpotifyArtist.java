package com.discord.models.domain.spotify;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ModelSpotifyArtist.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelSpotifyArtist {
    private final String id;
    private final String name;

    public ModelSpotifyArtist(String str, String str2) {
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        C12238m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.id = str;
        this.name = str2;
    }

    public static /* synthetic */ ModelSpotifyArtist copy$default(ModelSpotifyArtist modelSpotifyArtist, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelSpotifyArtist.id;
        }
        if ((i & 2) != 0) {
            str2 = modelSpotifyArtist.name;
        }
        return modelSpotifyArtist.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final ModelSpotifyArtist copy(String id2, String name) {
        C12238m.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        C12238m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new ModelSpotifyArtist(id2, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelSpotifyArtist)) {
            return false;
        }
        ModelSpotifyArtist modelSpotifyArtist = (ModelSpotifyArtist) other;
        return C12238m.areEqual(this.id, modelSpotifyArtist.id) && C12238m.areEqual(this.name, modelSpotifyArtist.name);
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ModelSpotifyArtist(id=");
        sbM833U.append(this.id);
        sbM833U.append(", name=");
        return C1643a.m822J(sbM833U, this.name, ")");
    }
}
