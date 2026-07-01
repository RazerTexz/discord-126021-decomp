package com.discord.rtcconnection;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: MediaSinkWantsManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSinkWantsManager$b {
    public final EncodeQuality a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f2772b;
    public final VideoMetadata c;

    public MediaSinkWantsManager$b(EncodeQuality encodeQuality, long j, VideoMetadata videoMetadata) {
        m.checkNotNullParameter(encodeQuality, "encodeQuality");
        this.a = encodeQuality;
        this.f2772b = j;
        this.c = videoMetadata;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaSinkWantsManager$b)) {
            return false;
        }
        MediaSinkWantsManager$b mediaSinkWantsManager$b = (MediaSinkWantsManager$b) obj;
        return m.areEqual(this.a, mediaSinkWantsManager$b.a) && this.f2772b == mediaSinkWantsManager$b.f2772b && m.areEqual(this.c, mediaSinkWantsManager$b.c);
    }

    public int hashCode() {
        EncodeQuality encodeQuality = this.a;
        int iA = (b.a(this.f2772b) + ((encodeQuality != null ? encodeQuality.hashCode() : 0) * 31)) * 31;
        VideoMetadata videoMetadata = this.c;
        return iA + (videoMetadata != null ? videoMetadata.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("VideoStreamDescriptor(encodeQuality=");
        sbU.append(this.a);
        sbU.append(", ssrc=");
        sbU.append(this.f2772b);
        sbU.append(", metadata=");
        sbU.append(this.c);
        sbU.append(")");
        return sbU.toString();
    }
}
