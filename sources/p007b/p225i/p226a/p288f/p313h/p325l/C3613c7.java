package p007b.p225i.p226a.p288f.p313h.p325l;

import com.google.android.gms.internal.measurement.zzhi;
import com.google.android.gms.internal.measurement.zzii;
import com.google.android.gms.internal.measurement.zzij;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.f.h.l.c7 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3613c7 {

    /* JADX INFO: renamed from: a */
    public static final C3613c7 f9877a = new C3613c7(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: b */
    public int f9878b;

    /* JADX INFO: renamed from: c */
    public int[] f9879c;

    /* JADX INFO: renamed from: d */
    public Object[] f9880d;

    /* JADX INFO: renamed from: e */
    public int f9881e;

    /* JADX INFO: renamed from: f */
    public boolean f9882f;

    public C3613c7() {
        this(0, new int[8], new Object[8], true);
    }

    /* JADX INFO: renamed from: b */
    public static void m4609b(int i, Object obj, InterfaceC3867v7 interfaceC3867v7) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            ((C3666g4) interfaceC3867v7).f9967a.mo9087g(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 1) {
            ((C3666g4) interfaceC3867v7).f9967a.mo9098z(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 2) {
            ((C3666g4) interfaceC3867v7).f9967a.mo9088h(i2, (AbstractC3837t3) obj);
            return;
        }
        if (i3 == 3) {
            C3666g4 c3666g4 = (C3666g4) interfaceC3867v7;
            c3666g4.f9967a.mo9086f(i2, 3);
            ((C3613c7) obj).m4612d(interfaceC3867v7);
            c3666g4.f9967a.mo9086f(i2, 4);
            return;
        }
        if (i3 != 5) {
            int i4 = zzij.f20634j;
            throw new RuntimeException(new zzii("Protocol message tag had invalid wire type."));
        }
        ((C3666g4) interfaceC3867v7).f9967a.mo9082G(i2, ((Integer) obj).intValue());
    }

    /* JADX INFO: renamed from: c */
    public static C3613c7 m4610c() {
        return new C3613c7(0, new int[8], new Object[8], true);
    }

    /* JADX INFO: renamed from: a */
    public final void m4611a(int i, Object obj) {
        if (!this.f9882f) {
            throw new UnsupportedOperationException();
        }
        int i2 = this.f9878b;
        int[] iArr = this.f9879c;
        if (i2 == iArr.length) {
            int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
            this.f9879c = Arrays.copyOf(iArr, i3);
            this.f9880d = Arrays.copyOf(this.f9880d, i3);
        }
        int[] iArr2 = this.f9879c;
        int i4 = this.f9878b;
        iArr2[i4] = i;
        this.f9880d[i4] = obj;
        this.f9878b = i4 + 1;
    }

    /* JADX INFO: renamed from: d */
    public final void m4612d(InterfaceC3867v7 interfaceC3867v7) throws IOException {
        if (this.f9878b == 0) {
            return;
        }
        Objects.requireNonNull(interfaceC3867v7);
        for (int i = 0; i < this.f9878b; i++) {
            m4609b(this.f9879c[i], this.f9880d[i], interfaceC3867v7);
        }
    }

    /* JADX INFO: renamed from: e */
    public final int m4613e() {
        int iM9053E;
        int i = this.f9881e;
        if (i != -1) {
            return i;
        }
        int iM4613e = 0;
        for (int i2 = 0; i2 < this.f9878b; i2++) {
            int i3 = this.f9879c[i2];
            int i4 = i3 >>> 3;
            int i5 = i3 & 7;
            if (i5 == 0) {
                iM9053E = zzhi.m9053E(i4, ((Long) this.f9880d[i2]).longValue());
            } else if (i5 == 1) {
                ((Long) this.f9880d[i2]).longValue();
                iM9053E = zzhi.m9061N(i4);
            } else if (i5 != 2) {
                if (i5 == 3) {
                    iM4613e = ((C3613c7) this.f9880d[i2]).m4613e() + (zzhi.m9052D(i4) << 1) + iM4613e;
                } else {
                    if (i5 != 5) {
                        int i6 = zzij.f20634j;
                        throw new IllegalStateException(new zzii("Protocol message tag had invalid wire type."));
                    }
                    ((Integer) this.f9880d[i2]).intValue();
                    iM9053E = zzhi.m9066S(i4);
                }
            } else {
                iM9053E = zzhi.m9078w(i4, (AbstractC3837t3) this.f9880d[i2]);
            }
            iM4613e = iM9053E + iM4613e;
        }
        this.f9881e = iM4613e;
        return iM4613e;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0046 A[RETURN] */
    public final boolean equals(Object obj) {
        boolean z2;
        boolean z3;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C3613c7)) {
            return false;
        }
        C3613c7 c3613c7 = (C3613c7) obj;
        int i = this.f9878b;
        if (i == c3613c7.f9878b) {
            int[] iArr = this.f9879c;
            int[] iArr2 = c3613c7.f9879c;
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
                Object[] objArr = this.f9880d;
                Object[] objArr2 = c3613c7.f9880d;
                int i3 = this.f9878b;
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
        int i = this.f9878b;
        int i2 = (i + 527) * 31;
        int[] iArr = this.f9879c;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = (i2 + i3) * 31;
        Object[] objArr = this.f9880d;
        int i6 = this.f9878b;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    public C3613c7(int i, int[] iArr, Object[] objArr, boolean z2) {
        this.f9881e = -1;
        this.f9878b = i;
        this.f9879c = iArr;
        this.f9880d = objArr;
        this.f9882f = z2;
    }
}
