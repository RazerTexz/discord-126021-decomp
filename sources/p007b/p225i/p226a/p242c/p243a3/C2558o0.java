package p007b.p225i.p226a.p242c.p243a3;

import androidx.annotation.Nullable;
import java.util.Arrays;
import p007b.p225i.p226a.p242c.InterfaceC2963w0;

/* JADX INFO: renamed from: b.i.a.c.a3.o0 */
/* JADX INFO: compiled from: TrackGroupArray.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2558o0 implements InterfaceC2963w0 {

    /* JADX INFO: renamed from: j */
    public static final C2558o0 f5674j = new C2558o0(new C2556n0[0]);

    /* JADX INFO: renamed from: k */
    public final int f5675k;

    /* JADX INFO: renamed from: l */
    public final C2556n0[] f5676l;

    /* JADX INFO: renamed from: m */
    public int f5677m;

    public C2558o0(C2556n0... c2556n0Arr) {
        this.f5676l = c2556n0Arr;
        this.f5675k = c2556n0Arr.length;
    }

    /* JADX INFO: renamed from: a */
    public int m2575a(C2556n0 c2556n0) {
        for (int i = 0; i < this.f5675k; i++) {
            if (this.f5676l[i] == c2556n0) {
                return i;
            }
        }
        return -1;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2558o0.class != obj.getClass()) {
            return false;
        }
        C2558o0 c2558o0 = (C2558o0) obj;
        return this.f5675k == c2558o0.f5675k && Arrays.equals(this.f5676l, c2558o0.f5676l);
    }

    public int hashCode() {
        if (this.f5677m == 0) {
            this.f5677m = Arrays.hashCode(this.f5676l);
        }
        return this.f5677m;
    }
}
