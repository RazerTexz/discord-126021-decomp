package b.i.a.c.a3.p0;

import android.net.Uri;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import b.i.a.c.w0;
import b.i.a.c.w0$a;
import java.util.Arrays;

/* JADX INFO: compiled from: AdPlaybackState.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements w0 {
    public static final c j = new c(null, new c$a[0], 0, -9223372036854775807L, 0);
    public static final c$a k;
    public static final w0$a<c> l;

    @Nullable
    public final Object m = null;
    public final int n;
    public final long o;
    public final long p;
    public final int q;
    public final c$a[] r;

    static {
        c$a c_a = new c$a(0L, -1, new int[0], new Uri[0], new long[0], 0L, false);
        int[] iArr = c_a.n;
        int length = iArr.length;
        int iMax = Math.max(0, length);
        int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
        Arrays.fill(iArrCopyOf, length, iMax, 0);
        long[] jArr = c_a.o;
        int length2 = jArr.length;
        int iMax2 = Math.max(0, length2);
        long[] jArrCopyOf = Arrays.copyOf(jArr, iMax2);
        Arrays.fill(jArrCopyOf, length2, iMax2, -9223372036854775807L);
        k = new c$a(c_a.k, 0, iArrCopyOf, (Uri[]) Arrays.copyOf(c_a.m, 0), jArrCopyOf, c_a.p, c_a.q);
        l = b.a;
    }

    public c(@Nullable Object obj, c$a[] c_aArr, long j2, long j3, int i) {
        this.o = j2;
        this.p = j3;
        this.n = c_aArr.length + i;
        this.r = c_aArr;
        this.q = i;
    }

    public static String b(int i) {
        return Integer.toString(i, 36);
    }

    public c$a a(@IntRange(from = 0) int i) {
        int i2 = this.q;
        return i < i2 ? k : this.r[i - i2];
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return e0.a(this.m, cVar.m) && this.n == cVar.n && this.o == cVar.o && this.p == cVar.p && this.q == cVar.q && Arrays.equals(this.r, cVar.r);
    }

    public int hashCode() {
        int i = this.n * 31;
        Object obj = this.m;
        return ((((((((i + (obj == null ? 0 : obj.hashCode())) * 31) + ((int) this.o)) * 31) + ((int) this.p)) * 31) + this.q) * 31) + Arrays.hashCode(this.r);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("AdPlaybackState(adsId=");
        sbU.append(this.m);
        sbU.append(", adResumePositionUs=");
        sbU.append(this.o);
        sbU.append(", adGroups=[");
        for (int i = 0; i < this.r.length; i++) {
            sbU.append("adGroup(timeUs=");
            sbU.append(this.r[i].k);
            sbU.append(", ads=[");
            for (int i2 = 0; i2 < this.r[i].n.length; i2++) {
                sbU.append("ad(state=");
                int i3 = this.r[i].n[i2];
                if (i3 == 0) {
                    sbU.append('_');
                } else if (i3 == 1) {
                    sbU.append('R');
                } else if (i3 == 2) {
                    sbU.append('S');
                } else if (i3 == 3) {
                    sbU.append('P');
                } else if (i3 != 4) {
                    sbU.append('?');
                } else {
                    sbU.append('!');
                }
                sbU.append(", durationUs=");
                sbU.append(this.r[i].o[i2]);
                sbU.append(')');
                if (i2 < this.r[i].n.length - 1) {
                    sbU.append(", ");
                }
            }
            sbU.append("])");
            if (i < this.r.length - 1) {
                sbU.append(", ");
            }
        }
        sbU.append("])");
        return sbU.toString();
    }
}
