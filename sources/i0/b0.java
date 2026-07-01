package i0;

import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: SkipCallbackExecutorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b0 implements a0 {
    public static final a0 a = new b0();

    @Override // java.lang.annotation.Annotation
    public Class<? extends Annotation> annotationType() {
        return a0.class;
    }

    @Override // java.lang.annotation.Annotation
    public boolean equals(Object obj) {
        return obj instanceof a0;
    }

    @Override // java.lang.annotation.Annotation
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.annotation.Annotation
    public String toString() {
        return b.d.b.a.a.o(a0.class, b.d.b.a.a.U("@"), "()");
    }
}
