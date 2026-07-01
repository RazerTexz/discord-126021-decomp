package b.i.a.c;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.f3.Util2;

/* JADX INFO: renamed from: b.i.a.c.x1, reason: use source file name */
/* JADX INFO: compiled from: PlaybackParameters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class PlaybackParameters implements Bundleable {
    public static final PlaybackParameters j = new PlaybackParameters(1.0f, 1.0f);
    public final float k;
    public final float l;
    public final int m;

    public PlaybackParameters(@FloatRange(from = 0.0d, fromInclusive = false) float f, @FloatRange(from = 0.0d, fromInclusive = false) float f2) {
        AnimatableValueParser.j(f > 0.0f);
        AnimatableValueParser.j(f2 > 0.0f);
        this.k = f;
        this.l = f2;
        this.m = Math.round(f * 1000.0f);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PlaybackParameters.class != obj.getClass()) {
            return false;
        }
        PlaybackParameters playbackParameters = (PlaybackParameters) obj;
        return this.k == playbackParameters.k && this.l == playbackParameters.l;
    }

    public int hashCode() {
        return Float.floatToRawIntBits(this.l) + ((Float.floatToRawIntBits(this.k) + 527) * 31);
    }

    public String toString() {
        return Util2.k("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.k), Float.valueOf(this.l));
    }
}
