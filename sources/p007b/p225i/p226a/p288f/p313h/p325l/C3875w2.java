package p007b.p225i.p226a.p288f.p313h.p325l;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: renamed from: b.i.a.f.h.l.w2 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3875w2<T> extends AbstractC3888x2<T> {

    /* JADX INFO: renamed from: j */
    public static final C3875w2<Object> f10378j = new C3875w2<>();

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3888x2
    /* JADX INFO: renamed from: b */
    public final boolean mo5342b() {
        return false;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3888x2
    /* JADX INFO: renamed from: c */
    public final T mo5343c() {
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
