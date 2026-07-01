package b.i.a.f.h.l;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class w2<T> extends x2<T> {
    public static final w2<Object> j = new w2<>();

    @Override // b.i.a.f.h.l.x2
    public final boolean b() {
        return false;
    }

    @Override // b.i.a.f.h.l.x2
    public final T c() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    public final boolean equals(@NullableDecl Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }
}
