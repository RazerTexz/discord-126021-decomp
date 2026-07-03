package p007b.p195g.p196a.p205c.p219i0;

import java.io.Serializable;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.g.a.c.i0.n */
/* JADX INFO: compiled from: NameTransformer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2352n {

    /* JADX INFO: renamed from: j */
    public static final AbstractC2352n f4961j = new b();

    /* JADX INFO: renamed from: b.g.a.c.i0.n$a */
    /* JADX INFO: compiled from: NameTransformer.java */
    public static class a extends AbstractC2352n implements Serializable {
        private static final long serialVersionUID = 1;
        public final AbstractC2352n _t1;
        public final AbstractC2352n _t2;

        public a(AbstractC2352n abstractC2352n, AbstractC2352n abstractC2352n2) {
            this._t1 = abstractC2352n;
            this._t2 = abstractC2352n2;
        }

        @Override // p007b.p195g.p196a.p205c.p219i0.AbstractC2352n
        /* JADX INFO: renamed from: a */
        public String mo2202a(String str) {
            return this._t1.mo2202a(this._t2.mo2202a(str));
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("[ChainedTransformer(");
            sbM833U.append(this._t1);
            sbM833U.append(", ");
            sbM833U.append(this._t2);
            sbM833U.append(")]");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.i0.n$b */
    /* JADX INFO: compiled from: NameTransformer.java */
    public static final class b extends AbstractC2352n implements Serializable {
        private static final long serialVersionUID = 1;

        @Override // p007b.p195g.p196a.p205c.p219i0.AbstractC2352n
        /* JADX INFO: renamed from: a */
        public String mo2202a(String str) {
            return str;
        }
    }

    /* JADX INFO: renamed from: a */
    public abstract String mo2202a(String str);
}
