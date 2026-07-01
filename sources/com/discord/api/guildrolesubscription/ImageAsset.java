package com.discord.api.guildrolesubscription;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

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
        return this.id == imageAsset.id && Intrinsics3.areEqual(this.size, imageAsset.size) && Intrinsics3.areEqual(this.mimeType, imageAsset.mimeType) && Intrinsics3.areEqual(this.filename, imageAsset.filename) && Intrinsics3.areEqual(this.width, imageAsset.width) && Intrinsics3.areEqual(this.height, imageAsset.height);
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
        StringBuilder sbU = outline.U("ImageAsset(id=");
        sbU.append(this.id);
        sbU.append(", size=");
        sbU.append(this.size);
        sbU.append(", mimeType=");
        sbU.append(this.mimeType);
        sbU.append(", filename=");
        sbU.append(this.filename);
        sbU.append(", width=");
        sbU.append(this.width);
        sbU.append(", height=");
        return outline.F(sbU, this.height, ")");
    }
}
