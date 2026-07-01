package b.i.a.f.h.l;

import com.google.android.gms.internal.measurement.zzhi;
import com.google.android.gms.internal.measurement.zzii;
import com.google.android.gms.internal.measurement.zzij;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class c7 {
    public static final c7 a = new c7(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1438b;
    public int[] c;
    public Object[] d;
    public int e;
    public boolean f;

    public c7() {
        this(0, new int[8], new Object[8], true);
    }

    public static void b(int i, Object obj, v7 v7Var) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            ((g4) v7Var).a.g(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 1) {
            ((g4) v7Var).a.z(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 2) {
            ((g4) v7Var).a.h(i2, (t3) obj);
            return;
        }
        if (i3 == 3) {
            g4 g4Var = (g4) v7Var;
            g4Var.a.f(i2, 3);
            ((c7) obj).d(v7Var);
            g4Var.a.f(i2, 4);
            return;
        }
        if (i3 != 5) {
            int i4 = zzij.j;
            throw new RuntimeException(new zzii("Protocol message tag had invalid wire type."));
        }
        ((g4) v7Var).a.G(i2, ((Integer) obj).intValue());
    }

    public static c7 c() {
        return new c7(0, new int[8], new Object[8], true);
    }

    public final void a(int i, Object obj) {
        if (!this.f) {
            throw new UnsupportedOperationException();
        }
        int i2 = this.f1438b;
        int[] iArr = this.c;
        if (i2 == iArr.length) {
            int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
            this.c = Arrays.copyOf(iArr, i3);
            this.d = Arrays.copyOf(this.d, i3);
        }
        int[] iArr2 = this.c;
        int i4 = this.f1438b;
        iArr2[i4] = i;
        this.d[i4] = obj;
        this.f1438b = i4 + 1;
    }

    public final void d(v7 v7Var) throws IOException {
        if (this.f1438b == 0) {
            return;
        }
        Objects.requireNonNull(v7Var);
        for (int i = 0; i < this.f1438b; i++) {
            b(this.c[i], this.d[i], v7Var);
        }
    }

    public final int e() {
        int iE;
        int i = this.e;
        if (i != -1) {
            return i;
        }
        int iE2 = 0;
        for (int i2 = 0; i2 < this.f1438b; i2++) {
            int i3 = this.c[i2];
            int i4 = i3 >>> 3;
            int i5 = i3 & 7;
            if (i5 == 0) {
                iE = zzhi.E(i4, ((Long) this.d[i2]).longValue());
            } else if (i5 == 1) {
                ((Long) this.d[i2]).longValue();
                iE = zzhi.N(i4);
            } else if (i5 != 2) {
                if (i5 == 3) {
                    iE2 = ((c7) this.d[i2]).e() + (zzhi.D(i4) << 1) + iE2;
                } else {
                    if (i5 != 5) {
                        int i6 = zzij.j;
                        throw new IllegalStateException(new zzii("Protocol message tag had invalid wire type."));
                    }
                    ((Integer) this.d[i2]).intValue();
                    iE = zzhi.S(i4);
                }
            } else {
                iE = zzhi.w(i4, (t3) this.d[i2]);
            }
            iE2 = iE + iE2;
        }
        this.e = iE2;
        return iE2;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0046 A[RETURN] */
    public final boolean equals(Object obj) {
        boolean z2;
        boolean z3;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof c7)) {
            return false;
        }
        c7 c7Var = (c7) obj;
        int i = this.f1438b;
        if (i == c7Var.f1438b) {
            int[] iArr = this.c;
            int[] iArr2 = c7Var.c;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z2 = true;
                    break;
                }
                if (iArr[i2] != iArr2[i2]) {
                    z2 = false;
                    break;
                }
                i2++;
            }
            if (z2) {
                Object[] objArr = this.d;
                Object[] objArr2 = c7Var.d;
                int i3 = this.f1438b;
                for (int i4 = 0; i4 < i3; i4++) {
                    if (!objArr[i4].equals(objArr2[i4])) {
                        z3 = false;
                        if (!z3) {
                            return true;
                        }
                    }
                }
                z3 = true;
                if (!z3) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f1438b;
        int i2 = (i + 527) * 31;
        int[] iArr = this.c;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = (i2 + i3) * 31;
        Object[] objArr = this.d;
        int i6 = this.f1438b;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    public c7(int i, int[] iArr, Object[] objArr, boolean z2) {
        this.e = -1;
        this.f1438b = i;
        this.c = iArr;
        this.d = objArr;
        this.f = z2;
    }
}
