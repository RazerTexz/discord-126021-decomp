package com.discord.rtcconnection;

import com.discord.rtcconnection.socket.p499io.Payloads;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: VideoMetadata.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class VideoMetadata {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final long userID;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final int maxWidth;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final int maxHeight;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Integer maxFrameRate;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final Payloads.ResolutionType type;

    public VideoMetadata(long j, int i, int i2, Integer num, Payloads.ResolutionType resolutionType) {
        C12238m.checkNotNullParameter(resolutionType, "type");
        this.userID = j;
        this.maxWidth = i;
        this.maxHeight = i2;
        this.maxFrameRate = num;
        this.type = resolutionType;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoMetadata)) {
            return false;
        }
        VideoMetadata videoMetadata = (VideoMetadata) other;
        return this.userID == videoMetadata.userID && this.maxWidth == videoMetadata.maxWidth && this.maxHeight == videoMetadata.maxHeight && C12238m.areEqual(this.maxFrameRate, videoMetadata.maxFrameRate) && C12238m.areEqual(this.type, videoMetadata.type);
    }

    public int hashCode() {
        int iM3a = ((((C0002b.m3a(this.userID) * 31) + this.maxWidth) * 31) + this.maxHeight) * 31;
        Integer num = this.maxFrameRate;
        int iHashCode = (iM3a + (num != null ? num.hashCode() : 0)) * 31;
        Payloads.ResolutionType resolutionType = this.type;
        return iHashCode + (resolutionType != null ? resolutionType.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("VideoMetadata(userID=");
        sbM833U.append(this.userID);
        sbM833U.append(", maxWidth=");
        sbM833U.append(this.maxWidth);
        sbM833U.append(", maxHeight=");
        sbM833U.append(this.maxHeight);
        sbM833U.append(", maxFrameRate=");
        sbM833U.append(this.maxFrameRate);
        sbM833U.append(", type=");
        sbM833U.append(this.type);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
