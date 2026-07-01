package co.discord.media_engine.internal;

import b.d.b.a.outline;

/* JADX INFO: compiled from: NativeStatistics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class FrameCounts {
    private final int deltaFrames;
    private final int keyFrames;

    public FrameCounts(int i, int i2) {
        this.deltaFrames = i;
        this.keyFrames = i2;
    }

    public static /* synthetic */ FrameCounts copy$default(FrameCounts frameCounts, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = frameCounts.deltaFrames;
        }
        if ((i3 & 2) != 0) {
            i2 = frameCounts.keyFrames;
        }
        return frameCounts.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getDeltaFrames() {
        return this.deltaFrames;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getKeyFrames() {
        return this.keyFrames;
    }

    public final FrameCounts copy(int deltaFrames, int keyFrames) {
        return new FrameCounts(deltaFrames, keyFrames);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FrameCounts)) {
            return false;
        }
        FrameCounts frameCounts = (FrameCounts) other;
        return this.deltaFrames == frameCounts.deltaFrames && this.keyFrames == frameCounts.keyFrames;
    }

    public final int getDeltaFrames() {
        return this.deltaFrames;
    }

    public final int getKeyFrames() {
        return this.keyFrames;
    }

    public int hashCode() {
        return (this.deltaFrames * 31) + this.keyFrames;
    }

    public String toString() {
        StringBuilder sbU = outline.U("FrameCounts(deltaFrames=");
        sbU.append(this.deltaFrames);
        sbU.append(", keyFrames=");
        return outline.B(sbU, this.keyFrames, ")");
    }
}
