package co.discord.media_engine.internal;

import b.d.b.a.a;

/* JADX INFO: compiled from: NativeStatistics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Screenshare {
    private final int capturedFramesCount;
    private final int capturedFramesDropped;
    private final int capturedFramesMean;
    private final int capturedFramesStdev;

    public Screenshare(int i, int i2, int i3, int i4) {
        this.capturedFramesDropped = i;
        this.capturedFramesCount = i2;
        this.capturedFramesMean = i3;
        this.capturedFramesStdev = i4;
    }

    public static /* synthetic */ Screenshare copy$default(Screenshare screenshare, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = screenshare.capturedFramesDropped;
        }
        if ((i5 & 2) != 0) {
            i2 = screenshare.capturedFramesCount;
        }
        if ((i5 & 4) != 0) {
            i3 = screenshare.capturedFramesMean;
        }
        if ((i5 & 8) != 0) {
            i4 = screenshare.capturedFramesStdev;
        }
        return screenshare.copy(i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCapturedFramesDropped() {
        return this.capturedFramesDropped;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getCapturedFramesCount() {
        return this.capturedFramesCount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getCapturedFramesMean() {
        return this.capturedFramesMean;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getCapturedFramesStdev() {
        return this.capturedFramesStdev;
    }

    public final Screenshare copy(int capturedFramesDropped, int capturedFramesCount, int capturedFramesMean, int capturedFramesStdev) {
        return new Screenshare(capturedFramesDropped, capturedFramesCount, capturedFramesMean, capturedFramesStdev);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Screenshare)) {
            return false;
        }
        Screenshare screenshare = (Screenshare) other;
        return this.capturedFramesDropped == screenshare.capturedFramesDropped && this.capturedFramesCount == screenshare.capturedFramesCount && this.capturedFramesMean == screenshare.capturedFramesMean && this.capturedFramesStdev == screenshare.capturedFramesStdev;
    }

    public final int getCapturedFramesCount() {
        return this.capturedFramesCount;
    }

    public final int getCapturedFramesDropped() {
        return this.capturedFramesDropped;
    }

    public final int getCapturedFramesMean() {
        return this.capturedFramesMean;
    }

    public final int getCapturedFramesStdev() {
        return this.capturedFramesStdev;
    }

    public int hashCode() {
        return (((((this.capturedFramesDropped * 31) + this.capturedFramesCount) * 31) + this.capturedFramesMean) * 31) + this.capturedFramesStdev;
    }

    public String toString() {
        StringBuilder sbU = a.U("Screenshare(capturedFramesDropped=");
        sbU.append(this.capturedFramesDropped);
        sbU.append(", capturedFramesCount=");
        sbU.append(this.capturedFramesCount);
        sbU.append(", capturedFramesMean=");
        sbU.append(this.capturedFramesMean);
        sbU.append(", capturedFramesStdev=");
        return a.B(sbU, this.capturedFramesStdev, ")");
    }
}
