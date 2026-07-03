package p007b.p225i.p226a.p242c.p259f3;

import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.c.f3.n */
/* JADX INFO: compiled from: FlagSet.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2747n {

    /* JADX INFO: renamed from: a */
    public final SparseBooleanArray f6733a;

    /* JADX INFO: renamed from: b.i.a.c.f3.n$b */
    /* JADX INFO: compiled from: FlagSet.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final SparseBooleanArray f6734a = new SparseBooleanArray();

        /* JADX INFO: renamed from: b */
        public boolean f6735b;

        /* JADX INFO: renamed from: a */
        public b m3032a(int i) {
            C1460d.m426D(!this.f6735b);
            this.f6734a.append(i, true);
            return this;
        }

        /* JADX INFO: renamed from: b */
        public C2747n m3033b() {
            C1460d.m426D(!this.f6735b);
            this.f6735b = true;
            return new C2747n(this.f6734a, null);
        }
    }

    public C2747n(SparseBooleanArray sparseBooleanArray, a aVar) {
        this.f6733a = sparseBooleanArray;
    }

    /* JADX INFO: renamed from: a */
    public boolean m3029a(int i) {
        return this.f6733a.get(i);
    }

    /* JADX INFO: renamed from: b */
    public int m3030b(int i) {
        C1460d.m571t(i, 0, m3031c());
        return this.f6733a.keyAt(i);
    }

    /* JADX INFO: renamed from: c */
    public int m3031c() {
        return this.f6733a.size();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2747n)) {
            return false;
        }
        C2747n c2747n = (C2747n) obj;
        if (C2738e0.f6708a >= 24) {
            return this.f6733a.equals(c2747n.f6733a);
        }
        if (m3031c() != c2747n.m3031c()) {
            return false;
        }
        for (int i = 0; i < m3031c(); i++) {
            if (m3030b(i) != c2747n.m3030b(i)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (C2738e0.f6708a >= 24) {
            return this.f6733a.hashCode();
        }
        int iM3031c = m3031c();
        for (int i = 0; i < m3031c(); i++) {
            iM3031c = (iM3031c * 31) + m3030b(i);
        }
        return iM3031c;
    }
}
