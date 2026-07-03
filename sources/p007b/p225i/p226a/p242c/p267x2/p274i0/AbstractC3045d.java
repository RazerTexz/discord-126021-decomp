package p007b.p225i.p226a.p242c.p267x2.p274i0;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.p259f3.C2757x;

/* JADX INFO: renamed from: b.i.a.c.x2.i0.d */
/* JADX INFO: compiled from: Atom.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3045d {

    /* JADX INFO: renamed from: a */
    public final int f8349a;

    /* JADX INFO: renamed from: b.i.a.c.x2.i0.d$a */
    /* JADX INFO: compiled from: Atom.java */
    public static final class a extends AbstractC3045d {

        /* JADX INFO: renamed from: b */
        public final long f8350b;

        /* JADX INFO: renamed from: c */
        public final List<b> f8351c;

        /* JADX INFO: renamed from: d */
        public final List<a> f8352d;

        public a(int i, long j) {
            super(i);
            this.f8350b = j;
            this.f8351c = new ArrayList();
            this.f8352d = new ArrayList();
        }

        @Nullable
        /* JADX INFO: renamed from: b */
        public a m3700b(int i) {
            int size = this.f8352d.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = this.f8352d.get(i2);
                if (aVar.f8349a == i) {
                    return aVar;
                }
            }
            return null;
        }

        @Nullable
        /* JADX INFO: renamed from: c */
        public b m3701c(int i) {
            int size = this.f8351c.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = this.f8351c.get(i2);
                if (bVar.f8349a == i) {
                    return bVar;
                }
            }
            return null;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p274i0.AbstractC3045d
        public String toString() {
            String strM3699a = AbstractC3045d.m3699a(this.f8349a);
            String string = Arrays.toString(this.f8351c.toArray());
            String string2 = Arrays.toString(this.f8352d.toArray());
            StringBuilder sbM831S = C1643a.m831S(C1643a.m841b(string2, C1643a.m841b(string, C1643a.m841b(strM3699a, 22))), strM3699a, " leaves: ", string, " containers: ");
            sbM831S.append(string2);
            return sbM831S.toString();
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.i0.d$b */
    /* JADX INFO: compiled from: Atom.java */
    public static final class b extends AbstractC3045d {

        /* JADX INFO: renamed from: b */
        public final C2757x f8353b;

        public b(int i, C2757x c2757x) {
            super(i);
            this.f8353b = c2757x;
        }
    }

    public AbstractC3045d(int i) {
        this.f8349a = i;
    }

    /* JADX INFO: renamed from: a */
    public static String m3699a(int i) {
        StringBuilder sb = new StringBuilder(4);
        sb.append((char) ((i >> 24) & 255));
        sb.append((char) ((i >> 16) & 255));
        sb.append((char) ((i >> 8) & 255));
        sb.append((char) (i & 255));
        return sb.toString();
    }

    public String toString() {
        return m3699a(this.f8349a);
    }
}
