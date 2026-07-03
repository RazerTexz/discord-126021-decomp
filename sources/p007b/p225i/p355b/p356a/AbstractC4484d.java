package p007b.p225i.p355b.p356a;

import com.google.errorprone.annotations.ForOverride;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: renamed from: b.i.b.a.d */
/* JADX INFO: compiled from: Equivalence.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4484d<T> {

    /* JADX INFO: renamed from: b.i.b.a.d$a */
    /* JADX INFO: compiled from: Equivalence.java */
    public static final class a extends AbstractC4484d<Object> implements Serializable {

        /* JADX INFO: renamed from: j */
        public static final a f11948j = new a();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return f11948j;
        }

        @Override // p007b.p225i.p355b.p356a.AbstractC4484d
        /* JADX INFO: renamed from: a */
        public boolean mo6211a(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        @Override // p007b.p225i.p355b.p356a.AbstractC4484d
        /* JADX INFO: renamed from: b */
        public int mo6212b(Object obj) {
            return obj.hashCode();
        }
    }

    /* JADX INFO: renamed from: b.i.b.a.d$b */
    /* JADX INFO: compiled from: Equivalence.java */
    public static final class b extends AbstractC4484d<Object> implements Serializable {

        /* JADX INFO: renamed from: j */
        public static final b f11949j = new b();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return f11949j;
        }

        @Override // p007b.p225i.p355b.p356a.AbstractC4484d
        /* JADX INFO: renamed from: a */
        public boolean mo6211a(Object obj, Object obj2) {
            return false;
        }

        @Override // p007b.p225i.p355b.p356a.AbstractC4484d
        /* JADX INFO: renamed from: b */
        public int mo6212b(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    @ForOverride
    /* JADX INFO: renamed from: a */
    public abstract boolean mo6211a(T t, T t2);

    @ForOverride
    /* JADX INFO: renamed from: b */
    public abstract int mo6212b(T t);

    /* JADX INFO: renamed from: c */
    public final boolean m6213c(@NullableDecl T t, @NullableDecl T t2) {
        if (t == t2) {
            return true;
        }
        if (t == null || t2 == null) {
            return false;
        }
        return mo6211a(t, t2);
    }
}
