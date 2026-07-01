package b.i.a.c.t2;

import android.media.AudioAttributes;
import android.media.AudioAttributes$Builder;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.i.a.c.w0;

/* JADX INFO: compiled from: AudioAttributes.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o implements w0 {
    public static final o j = new o(0, 0, 1, 1, null);
    public final int k;
    public final int l;
    public final int m;
    public final int n;

    @Nullable
    public AudioAttributes o;

    public o(int i, int i2, int i3, int i4, o$a o_a) {
        this.k = i;
        this.l = i2;
        this.m = i3;
        this.n = i4;
    }

    @RequiresApi(21)
    public AudioAttributes a() {
        if (this.o == null) {
            AudioAttributes$Builder usage = new AudioAttributes$Builder().setContentType(this.k).setFlags(this.l).setUsage(this.m);
            if (b.i.a.c.f3.e0.a >= 29) {
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
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        return this.k == oVar.k && this.l == oVar.l && this.m == oVar.m && this.n == oVar.n;
    }

    public int hashCode() {
        return ((((((527 + this.k) * 31) + this.l) * 31) + this.m) * 31) + this.n;
    }
}
