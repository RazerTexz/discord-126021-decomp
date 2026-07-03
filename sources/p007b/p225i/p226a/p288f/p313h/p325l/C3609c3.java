package p007b.p225i.p226a.p288f.p313h.p325l;

import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.f.h.l.c3 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3609c3<T> implements InterfaceC3914z2<T> {

    /* JADX INFO: renamed from: j */
    public volatile InterfaceC3914z2<T> f9874j;

    /* JADX INFO: renamed from: k */
    public volatile boolean f9875k;

    /* JADX INFO: renamed from: l */
    @NullableDecl
    public T f9876l;

    public C3609c3(InterfaceC3914z2<T> interfaceC3914z2) {
        Objects.requireNonNull(interfaceC3914z2);
        this.f9874j = interfaceC3914z2;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3914z2
    /* JADX INFO: renamed from: a */
    public final T mo4555a() {
        if (!this.f9875k) {
            synchronized (this) {
                if (!this.f9875k) {
                    T tMo4555a = this.f9874j.mo4555a();
                    this.f9876l = tMo4555a;
                    this.f9875k = true;
                    this.f9874j = null;
                    return tMo4555a;
                }
            }
        }
        return this.f9876l;
    }

    public final String toString() {
        Object objM859k = this.f9874j;
        if (objM859k == null) {
            String strValueOf = String.valueOf(this.f9876l);
            objM859k = C1643a.m859k(strValueOf.length() + 25, "<supplier that returned ", strValueOf, ">");
        }
        String strValueOf2 = String.valueOf(objM859k);
        return C1643a.m859k(strValueOf2.length() + 19, "Suppliers.memoize(", strValueOf2, ")");
    }
}
