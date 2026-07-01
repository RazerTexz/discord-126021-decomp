package b.i.b.a;

import com.google.errorprone.annotations.ForOverride;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: renamed from: b.i.b.a.d, reason: use source file name */
/* JADX INFO: compiled from: Equivalence.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Equivalence<T> {

    /* JADX INFO: renamed from: b.i.b.a.d$a */
    /* JADX INFO: compiled from: Equivalence.java */
    public static final class a extends Equivalence<Object> implements Serializable {
        public static final a j = new a();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return j;
        }

        @Override // b.i.b.a.Equivalence
        public boolean a(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        @Override // b.i.b.a.Equivalence
        public int b(Object obj) {
            return obj.hashCode();
        }
    }

    /* JADX INFO: renamed from: b.i.b.a.d$b */
    /* JADX INFO: compiled from: Equivalence.java */
    public static final class b extends Equivalence<Object> implements Serializable {
        public static final b j = new b();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return j;
        }

        @Override // b.i.b.a.Equivalence
        public boolean a(Object obj, Object obj2) {
            return false;
        }

        @Override // b.i.b.a.Equivalence
        public int b(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    @ForOverride
    public abstract boolean a(T t, T t2);

    @ForOverride
    public abstract int b(T t);

    public final boolean c(@NullableDecl T t, @NullableDecl T t2) {
        if (t == t2) {
            return true;
        }
        if (t == null || t2 == null) {
            return false;
        }
        return a(t, t2);
    }
}
