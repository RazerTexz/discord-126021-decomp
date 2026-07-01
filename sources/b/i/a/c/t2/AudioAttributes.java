package b.i.a.c.t2;

import android.media.AudioAttributes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.i.a.c.Bundleable;
import b.i.a.c.f3.Util2;

/* JADX INFO: renamed from: b.i.a.c.t2.o, reason: use source file name */
/* JADX INFO: compiled from: AudioAttributes.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AudioAttributes implements Bundleable {
    public static final AudioAttributes j = new AudioAttributes(0, 0, 1, 1, null);
    public final int k;
    public final int l;
    public final int m;
    public final int n;

    @Nullable
    public android.media.AudioAttributes o;

    public AudioAttributes(int i, int i2, int i3, int i4, a aVar) {
        this.k = i;
        this.l = i2;
        this.m = i3;
        this.n = i4;
    }

    @RequiresApi(21)
    public android.media.AudioAttributes a() {
        if (this.o == null) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(this.k).setFlags(this.l).setUsage(this.m);
            if (Util2.a >= 29) {
                usage.setAllowedCapturePolicy(this.n);
            }
            this.o = usage.build();
        }
        return this.o;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AudioAttributes.class != obj.getClass()) {
            return false;
        }
        AudioAttributes audioAttributes = (AudioAttributes) obj;
        return this.k == audioAttributes.k && this.l == audioAttributes.l && this.m == audioAttributes.m && this.n == audioAttributes.n;
    }

    public int hashCode() {
        return ((((((527 + this.k) * 31) + this.l) * 31) + this.m) * 31) + this.n;
    }
}
