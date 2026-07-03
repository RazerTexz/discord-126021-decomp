package com.discord.api.guildrolesubscription;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ImageAsset.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ImageAsset {
    private final String filename;
    private final Integer height;
    private final long id;
    private final String mimeType;
    private final Integer size;
    private final Integer width;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageAsset)) {
            return false;
        }
        ImageAsset imageAsset = (ImageAsset) other;
        return this.id == imageAsset.id && C12238m.areEqual(this.size, imageAsset.size) && C12238m.areEqual(this.mimeType, imageAsset.mimeType) && C12238m.areEqual(this.filename, imageAsset.filename) && C12238m.areEqual(this.width, imageAsset.width) && C12238m.areEqual(this.height, imageAsset.height);
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        Integer num = this.size;
        int iHashCode = (i + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.mimeType;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.filename;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num2 = this.width;
        int iHashCode4 = (iHashCode3 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.height;
        return iHashCode4 + (num3 != null ? num3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ImageAsset(id=");
        sbM833U.append(this.id);
        sbM833U.append(", size=");
        sbM833U.append(this.size);
        sbM833U.append(", mimeType=");
        sbM833U.append(this.mimeType);
        sbM833U.append(", filename=");
        sbM833U.append(this.filename);
        sbM833U.append(", width=");
        sbM833U.append(this.width);
        sbM833U.append(", height=");
        return C1643a.m818F(sbM833U, this.height, ")");
    }
}
