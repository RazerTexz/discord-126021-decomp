package p007b.p225i.p226a.p288f.p313h.p325l;

import android.content.Context;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.f.h.l.v1 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3861v1 extends AbstractC3836t2 {

    /* JADX INFO: renamed from: a */
    public final Context f10358a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC3914z2<AbstractC3888x2<C3678h2>> f10359b;

    public C3861v1(Context context, InterfaceC3914z2<AbstractC3888x2<C3678h2>> interfaceC3914z2) {
        this.f10358a = context;
        this.f10359b = interfaceC3914z2;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3836t2
    /* JADX INFO: renamed from: a */
    public final Context mo5277a() {
        return this.f10358a;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3836t2
    /* JADX INFO: renamed from: b */
    public final InterfaceC3914z2<AbstractC3888x2<C3678h2>> mo5278b() {
        return this.f10359b;
    }

    public final boolean equals(Object obj) {
        InterfaceC3914z2<AbstractC3888x2<C3678h2>> interfaceC3914z2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC3836t2) {
            AbstractC3836t2 abstractC3836t2 = (AbstractC3836t2) obj;
            if (this.f10358a.equals(abstractC3836t2.mo5277a()) && ((interfaceC3914z2 = this.f10359b) != null ? interfaceC3914z2.equals(abstractC3836t2.mo5278b()) : abstractC3836t2.mo5278b() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f10358a.hashCode() ^ 1000003) * 1000003;
        InterfaceC3914z2<AbstractC3888x2<C3678h2>> interfaceC3914z2 = this.f10359b;
        return iHashCode ^ (interfaceC3914z2 == null ? 0 : interfaceC3914z2.hashCode());
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f10358a);
        String strValueOf2 = String.valueOf(this.f10359b);
        StringBuilder sbM831S = C1643a.m831S(strValueOf2.length() + strValueOf.length() + 46, "FlagsContext{context=", strValueOf, ", hermeticFileOverrides=", strValueOf2);
        sbM831S.append("}");
        return sbM831S.toString();
    }
}
