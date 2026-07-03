package p007b.p225i.p226a.p288f.p313h.p325l;

import java.io.Serializable;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.f.h.l.a3 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3581a3<T> implements InterfaceC3914z2<T>, Serializable {

    /* JADX INFO: renamed from: j */
    public volatile transient boolean f9844j;

    /* JADX INFO: renamed from: k */
    @NullableDecl
    public transient T f9845k;
    private final InterfaceC3914z2<T> zza;

    public C3581a3(InterfaceC3914z2<T> interfaceC3914z2) {
        Objects.requireNonNull(interfaceC3914z2);
        this.zza = interfaceC3914z2;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3914z2
    /* JADX INFO: renamed from: a */
    public final T mo4555a() {
        if (!this.f9844j) {
            synchronized (this) {
                if (!this.f9844j) {
                    T tMo4555a = this.zza.mo4555a();
                    this.f9845k = tMo4555a;
                    this.f9844j = true;
                    return tMo4555a;
                }
            }
        }
        return this.f9845k;
    }

    public final String toString() {
        Object objM859k;
        if (this.f9844j) {
            String strValueOf = String.valueOf(this.f9845k);
            objM859k = C1643a.m859k(strValueOf.length() + 25, "<supplier that returned ", strValueOf, ">");
        } else {
            objM859k = this.zza;
        }
        String strValueOf2 = String.valueOf(objM859k);
        return C1643a.m859k(strValueOf2.length() + 19, "Suppliers.memoize(", strValueOf2, ")");
    }
}
