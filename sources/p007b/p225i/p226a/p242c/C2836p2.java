package p007b.p225i.p226a.p242c;

import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p243a3.C2556n0;
import p007b.p225i.p355b.p357b.AbstractC4493a;
import p007b.p225i.p355b.p357b.AbstractC4523p;
import p007b.p225i.p355b.p357b.C4508h0;

/* JADX INFO: renamed from: b.i.a.c.p2 */
/* JADX INFO: compiled from: TracksInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2836p2 implements InterfaceC2963w0 {

    /* JADX INFO: renamed from: j */
    public static final C2836p2 f7433j;

    /* JADX INFO: renamed from: k */
    public final AbstractC4523p<a> f7434k;

    /* JADX INFO: renamed from: b.i.a.c.p2$a */
    /* JADX INFO: compiled from: TracksInfo.java */
    public static final class a implements InterfaceC2963w0 {

        /* JADX INFO: renamed from: j */
        public final C2556n0 f7435j;

        /* JADX INFO: renamed from: k */
        public final int[] f7436k;

        /* JADX INFO: renamed from: l */
        public final int f7437l;

        /* JADX INFO: renamed from: m */
        public final boolean[] f7438m;

        public a(C2556n0 c2556n0, int[] iArr, int i, boolean[] zArr) {
            int i2 = c2556n0.f5661k;
            C1460d.m531j(i2 == iArr.length && i2 == zArr.length);
            this.f7435j = c2556n0;
            this.f7436k = (int[]) iArr.clone();
            this.f7437l = i;
            this.f7438m = (boolean[]) zArr.clone();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f7437l == aVar.f7437l && this.f7435j.equals(aVar.f7435j) && Arrays.equals(this.f7436k, aVar.f7436k) && Arrays.equals(this.f7438m, aVar.f7438m);
        }

        public int hashCode() {
            return Arrays.hashCode(this.f7438m) + ((((Arrays.hashCode(this.f7436k) + (this.f7435j.hashCode() * 31)) * 31) + this.f7437l) * 31);
        }
    }

    static {
        AbstractC4493a<Object> abstractC4493a = AbstractC4523p.f12045k;
        f7433j = new C2836p2(C4508h0.f12012l);
    }

    public C2836p2(List<a> list) {
        this.f7434k = AbstractC4523p.m6264n(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2836p2.class != obj.getClass()) {
            return false;
        }
        return this.f7434k.equals(((C2836p2) obj).f7434k);
    }

    public int hashCode() {
        return this.f7434k.hashCode();
    }
}
