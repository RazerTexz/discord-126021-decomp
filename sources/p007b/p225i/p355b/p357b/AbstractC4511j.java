package p007b.p225i.p355b.p357b;

import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: renamed from: b.i.b.b.j */
/* JADX INFO: compiled from: ComparisonChain.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4511j {

    /* JADX INFO: renamed from: a */
    public static final AbstractC4511j f12028a = new a();

    /* JADX INFO: renamed from: b */
    public static final AbstractC4511j f12029b = new b(-1);

    /* JADX INFO: renamed from: c */
    public static final AbstractC4511j f12030c = new b(1);

    /* JADX INFO: renamed from: b.i.b.b.j$a */
    /* JADX INFO: compiled from: ComparisonChain.java */
    public static class a extends AbstractC4511j {
        public a() {
            super(null);
        }

        @Override // p007b.p225i.p355b.p357b.AbstractC4511j
        /* JADX INFO: renamed from: a */
        public AbstractC4511j mo6254a(int i, int i2) {
            int i3;
            if (i < i2) {
                i3 = -1;
            } else {
                i3 = i > i2 ? 1 : 0;
            }
            return m6259f(i3);
        }

        @Override // p007b.p225i.p355b.p357b.AbstractC4511j
        /* JADX INFO: renamed from: b */
        public <T> AbstractC4511j mo6255b(@NullableDecl T t, @NullableDecl T t2, Comparator<T> comparator) {
            return m6259f(comparator.compare(t, t2));
        }

        @Override // p007b.p225i.p355b.p357b.AbstractC4511j
        /* JADX INFO: renamed from: c */
        public AbstractC4511j mo6256c(boolean z2, boolean z3) {
            int i;
            if (z2 == z3) {
                i = 0;
            } else {
                i = z2 ? 1 : -1;
            }
            return m6259f(i);
        }

        @Override // p007b.p225i.p355b.p357b.AbstractC4511j
        /* JADX INFO: renamed from: d */
        public AbstractC4511j mo6257d(boolean z2, boolean z3) {
            int i;
            if (z3 == z2) {
                i = 0;
            } else {
                i = z3 ? 1 : -1;
            }
            return m6259f(i);
        }

        @Override // p007b.p225i.p355b.p357b.AbstractC4511j
        /* JADX INFO: renamed from: e */
        public int mo6258e() {
            return 0;
        }

        /* JADX INFO: renamed from: f */
        public AbstractC4511j m6259f(int i) {
            if (i < 0) {
                return AbstractC4511j.f12029b;
            }
            return i > 0 ? AbstractC4511j.f12030c : AbstractC4511j.f12028a;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.j$b */
    /* JADX INFO: compiled from: ComparisonChain.java */
    public static final class b extends AbstractC4511j {

        /* JADX INFO: renamed from: d */
        public final int f12031d;

        public b(int i) {
            super(null);
            this.f12031d = i;
        }

        @Override // p007b.p225i.p355b.p357b.AbstractC4511j
        /* JADX INFO: renamed from: a */
        public AbstractC4511j mo6254a(int i, int i2) {
            return this;
        }

        @Override // p007b.p225i.p355b.p357b.AbstractC4511j
        /* JADX INFO: renamed from: b */
        public <T> AbstractC4511j mo6255b(@NullableDecl T t, @NullableDecl T t2, @NullableDecl Comparator<T> comparator) {
            return this;
        }

        @Override // p007b.p225i.p355b.p357b.AbstractC4511j
        /* JADX INFO: renamed from: c */
        public AbstractC4511j mo6256c(boolean z2, boolean z3) {
            return this;
        }

        @Override // p007b.p225i.p355b.p357b.AbstractC4511j
        /* JADX INFO: renamed from: d */
        public AbstractC4511j mo6257d(boolean z2, boolean z3) {
            return this;
        }

        @Override // p007b.p225i.p355b.p357b.AbstractC4511j
        /* JADX INFO: renamed from: e */
        public int mo6258e() {
            return this.f12031d;
        }
    }

    public AbstractC4511j(a aVar) {
    }

    /* JADX INFO: renamed from: a */
    public abstract AbstractC4511j mo6254a(int i, int i2);

    /* JADX INFO: renamed from: b */
    public abstract <T> AbstractC4511j mo6255b(@NullableDecl T t, @NullableDecl T t2, Comparator<T> comparator);

    /* JADX INFO: renamed from: c */
    public abstract AbstractC4511j mo6256c(boolean z2, boolean z3);

    /* JADX INFO: renamed from: d */
    public abstract AbstractC4511j mo6257d(boolean z2, boolean z3);

    /* JADX INFO: renamed from: e */
    public abstract int mo6258e();
}
