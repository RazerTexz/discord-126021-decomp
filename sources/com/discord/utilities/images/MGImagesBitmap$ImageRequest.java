package com.discord.utilities.images;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: MGImagesBitmap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class MGImagesBitmap$ImageRequest {
    private final String imageUri;
    private final boolean roundAsCircle;

    public MGImagesBitmap$ImageRequest(String str, boolean z2) {
        m.checkNotNullParameter(str, "imageUri");
        this.imageUri = str;
        this.roundAsCircle = z2;
    }

    public static /* synthetic */ MGImagesBitmap$ImageRequest copy$default(MGImagesBitmap$ImageRequest mGImagesBitmap$ImageRequest, String str, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mGImagesBitmap$ImageRequest.imageUri;
        }
        if ((i & 2) != 0) {
            z2 = mGImagesBitmap$ImageRequest.roundAsCircle;
        }
        return mGImagesBitmap$ImageRequest.copy(str, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getImageUri() {
        return this.imageUri;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getRoundAsCircle() {
        return this.roundAsCircle;
    }

    public final MGImagesBitmap$ImageRequest copy(String imageUri, boolean roundAsCircle) {
        m.checkNotNullParameter(imageUri, "imageUri");
        return new MGImagesBitmap$ImageRequest(imageUri, roundAsCircle);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MGImagesBitmap$ImageRequest)) {
            return false;
        }
        MGImagesBitmap$ImageRequest mGImagesBitmap$ImageRequest = (MGImagesBitmap$ImageRequest) other;
        return m.areEqual(this.imageUri, mGImagesBitmap$ImageRequest.imageUri) && this.roundAsCircle == mGImagesBitmap$ImageRequest.roundAsCircle;
    }

    public final String getImageUri() {
        return this.imageUri;
    }

    public final boolean getRoundAsCircle() {
        return this.roundAsCircle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        String str = this.imageUri;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z2 = this.roundAsCircle;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("ImageRequest(imageUri=");
        sbU.append(this.imageUri);
        sbU.append(", roundAsCircle=");
        return a.O(sbU, this.roundAsCircle, ")");
    }
}
