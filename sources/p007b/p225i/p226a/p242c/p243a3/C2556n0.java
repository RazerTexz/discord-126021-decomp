package p007b.p225i.p226a.p242c.p243a3;

import androidx.annotation.Nullable;
import java.util.Arrays;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.InterfaceC2963w0;
import p007b.p225i.p226a.p242c.p259f3.C2750q;

/* JADX INFO: renamed from: b.i.a.c.a3.n0 */
/* JADX INFO: compiled from: TrackGroup.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2556n0 implements InterfaceC2963w0 {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ int f5660j = 0;

    /* JADX INFO: renamed from: k */
    public final int f5661k;

    /* JADX INFO: renamed from: l */
    public final C2811j1[] f5662l;

    /* JADX INFO: renamed from: m */
    public int f5663m;

    public C2556n0(C2811j1... c2811j1Arr) {
        int i = 1;
        C1460d.m531j(c2811j1Arr.length > 0);
        this.f5662l = c2811j1Arr;
        this.f5661k = c2811j1Arr.length;
        String str = c2811j1Arr[0].f7146n;
        str = (str == null || str.equals("und")) ? "" : str;
        int i2 = c2811j1Arr[0].f7148p | 16384;
        while (true) {
            C2811j1[] c2811j1Arr2 = this.f5662l;
            if (i >= c2811j1Arr2.length) {
                return;
            }
            String str2 = c2811j1Arr2[i].f7146n;
            if (!str.equals((str2 == null || str2.equals("und")) ? "" : str2)) {
                C2811j1[] c2811j1Arr3 = this.f5662l;
                m2565a("languages", c2811j1Arr3[0].f7146n, c2811j1Arr3[i].f7146n, i);
                return;
            } else {
                C2811j1[] c2811j1Arr4 = this.f5662l;
                if (i2 != (c2811j1Arr4[i].f7148p | 16384)) {
                    m2565a("role flags", Integer.toBinaryString(c2811j1Arr4[0].f7148p), Integer.toBinaryString(this.f5662l[i].f7148p), i);
                    return;
                }
                i++;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2565a(String str, @Nullable String str2, @Nullable String str3, int i) {
        StringBuilder sbM831S = C1643a.m831S(C1643a.m841b(str3, C1643a.m841b(str2, str.length() + 78)), "Different ", str, " combined in one TrackGroup: '", str2);
        sbM831S.append("' (track 0) and '");
        sbM831S.append(str3);
        sbM831S.append("' (track ");
        sbM831S.append(i);
        sbM831S.append(")");
        C2750q.m3039b("TrackGroup", "", new IllegalStateException(sbM831S.toString()));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2556n0.class != obj.getClass()) {
            return false;
        }
        C2556n0 c2556n0 = (C2556n0) obj;
        return this.f5661k == c2556n0.f5661k && Arrays.equals(this.f5662l, c2556n0.f5662l);
    }

    public int hashCode() {
        if (this.f5663m == 0) {
            this.f5663m = 527 + Arrays.hashCode(this.f5662l);
        }
        return this.f5663m;
    }
}
