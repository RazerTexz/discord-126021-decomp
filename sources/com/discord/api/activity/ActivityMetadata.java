package com.discord.api.activity;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: ActivityMetadata.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ActivityMetadata {
    private final String albumId;
    private final List<String> artistIds;
    private final List<String> buttonUrls;
    private final String contextUri;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getAlbumId() {
        return this.albumId;
    }

    public final List<String> b() {
        return this.buttonUrls;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivityMetadata)) {
            return false;
        }
        ActivityMetadata activityMetadata = (ActivityMetadata) other;
        return m.areEqual(this.contextUri, activityMetadata.contextUri) && m.areEqual(this.albumId, activityMetadata.albumId) && m.areEqual(this.artistIds, activityMetadata.artistIds) && m.areEqual(this.buttonUrls, activityMetadata.buttonUrls);
    }

    public int hashCode() {
        String str = this.contextUri;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.albumId;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<String> list = this.artistIds;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        List<String> list2 = this.buttonUrls;
        return iHashCode3 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ActivityMetadata(contextUri=");
        sbU.append(this.contextUri);
        sbU.append(", albumId=");
        sbU.append(this.albumId);
        sbU.append(", artistIds=");
        sbU.append(this.artistIds);
        sbU.append(", buttonUrls=");
        return a.L(sbU, this.buttonUrls, ")");
    }
}
