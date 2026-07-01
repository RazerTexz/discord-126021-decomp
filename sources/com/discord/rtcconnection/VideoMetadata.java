package com.discord.rtcconnection;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.rtcconnection.socket.io.Payloads$ResolutionType;
import d0.z.d.m;

/* JADX INFO: compiled from: VideoMetadata.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class VideoMetadata {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final long userID;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int maxWidth;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final int maxHeight;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Integer maxFrameRate;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final Payloads$ResolutionType type;

    public VideoMetadata(long j, int i, int i2, Integer num, Payloads$ResolutionType payloads$ResolutionType) {
        m.checkNotNullParameter(payloads$ResolutionType, "type");
        this.userID = j;
        this.maxWidth = i;
        this.maxHeight = i2;
        this.maxFrameRate = num;
        this.type = payloads$ResolutionType;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoMetadata)) {
            return false;
        }
        VideoMetadata videoMetadata = (VideoMetadata) other;
        return this.userID == videoMetadata.userID && this.maxWidth == videoMetadata.maxWidth && this.maxHeight == videoMetadata.maxHeight && m.areEqual(this.maxFrameRate, videoMetadata.maxFrameRate) && m.areEqual(this.type, videoMetadata.type);
    }

    public int hashCode() {
        int iA = ((((b.a(this.userID) * 31) + this.maxWidth) * 31) + this.maxHeight) * 31;
        Integer num = this.maxFrameRate;
        int iHashCode = (iA + (num != null ? num.hashCode() : 0)) * 31;
        Payloads$ResolutionType payloads$ResolutionType = this.type;
        return iHashCode + (payloads$ResolutionType != null ? payloads$ResolutionType.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("VideoMetadata(userID=");
        sbU.append(this.userID);
        sbU.append(", maxWidth=");
        sbU.append(this.maxWidth);
        sbU.append(", maxHeight=");
        sbU.append(this.maxHeight);
        sbU.append(", maxFrameRate=");
        sbU.append(this.maxFrameRate);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(")");
        return sbU.toString();
    }
}
