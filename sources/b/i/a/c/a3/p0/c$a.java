package b.i.a.c.a3.p0;

import android.net.Uri;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import b.c.a.a0.d;
import b.i.a.c.w0;
import java.util.Arrays;

/* JADX INFO: compiled from: AdPlaybackState.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c$a implements w0 {
    public static final /* synthetic */ int j = 0;
    public final long k;
    public final int l;
    public final Uri[] m;
    public final int[] n;
    public final long[] o;
    public final long p;
    public final boolean q;

    public c$a(long j2, int i, int[] iArr, Uri[] uriArr, long[] jArr, long j3, boolean z2) {
        d.j(iArr.length == uriArr.length);
        this.k = j2;
        this.l = i;
        this.n = iArr;
        this.m = uriArr;
        this.o = jArr;
        this.p = j3;
        this.q = z2;
    }

    public static String c(int i) {
        return Integer.toString(i, 36);
    }

    public int a(@IntRange(from = -1) int i) {
        int i2 = i + 1;
        while (true) {
            int[] iArr = this.n;
            if (i2 >= iArr.length || this.q || iArr[i2] == 0 || iArr[i2] == 1) {
                break;
            }
            i2++;
        }
        return i2;
    }

    public boolean b() {
        if (this.l == -1) {
            return true;
        }
        for (int i = 0; i < this.l; i++) {
            int[] iArr = this.n;
            if (iArr[i] == 0 || iArr[i] == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c$a.class != obj.getClass()) {
            return false;
        }
        c$a c_a = (c$a) obj;
        return this.k == c_a.k && this.l == c_a.l && Arrays.equals(this.m, c_a.m) && Arrays.equals(this.n, c_a.n) && Arrays.equals(this.o, c_a.o) && this.p == c_a.p && this.q == c_a.q;
    }

    public int hashCode() {
        int i = this.l * 31;
        long j2 = this.k;
        int iHashCode = (Arrays.hashCode(this.o) + ((Arrays.hashCode(this.n) + ((((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + Arrays.hashCode(this.m)) * 31)) * 31)) * 31;
        long j3 = this.p;
        return ((iHashCode + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.q ? 1 : 0);
    }
}
