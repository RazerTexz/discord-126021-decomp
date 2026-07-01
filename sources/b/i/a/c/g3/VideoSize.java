package b.i.a.c.g3;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import b.i.a.c.Bundleable;

/* JADX INFO: renamed from: b.i.a.c.g3.y, reason: use source file name */
/* JADX INFO: compiled from: VideoSize.java */
/* JADX INFO: loaded from: classes3.dex */
public final class VideoSize implements Bundleable {
    public static final VideoSize j = new VideoSize(0, 0);

    @IntRange(from = 0)
    public final int k;

    @IntRange(from = 0)
    public final int l;

    @IntRange(from = 0, to = 359)
    public final int m;

    @FloatRange(from = 0.0d, fromInclusive = false)
    public final float n;

    public VideoSize(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        this.k = i;
        this.l = i2;
        this.m = 0;
        this.n = 1.0f;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoSize)) {
            return false;
        }
        VideoSize videoSize = (VideoSize) obj;
        return this.k == videoSize.k && this.l == videoSize.l && this.m == videoSize.m && this.n == videoSize.n;
    }

    public int hashCode() {
        return Float.floatToRawIntBits(this.n) + ((((((217 + this.k) * 31) + this.l) * 31) + this.m) * 31);
    }

    public VideoSize(@IntRange(from = 0) int i, @IntRange(from = 0) int i2, @IntRange(from = 0, to = 359) int i3, @FloatRange(from = 0.0d, fromInclusive = false) float f) {
        this.k = i;
        this.l = i2;
        this.m = i3;
        this.n = f;
    }
}
