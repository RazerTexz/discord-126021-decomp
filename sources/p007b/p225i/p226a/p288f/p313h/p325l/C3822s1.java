package p007b.p225i.p226a.p288f.p313h.p325l;

import p007b.p225i.p226a.p288f.p313h.p325l.C3796q1;

/* JADX INFO: renamed from: b.i.a.f.h.l.s1 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3822s1 implements InterfaceC3583a5 {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC3583a5 f10301a = new C3822s1();

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3583a5
    /* JADX INFO: renamed from: f */
    public final boolean mo4556f(int i) {
        C3796q1.a aVar;
        if (i == 0) {
            aVar = C3796q1.a.UNKNOWN;
        } else if (i == 1) {
            aVar = C3796q1.a.STRING;
        } else if (i == 2) {
            aVar = C3796q1.a.NUMBER;
        } else if (i != 3) {
            aVar = i != 4 ? null : C3796q1.a.STATEMENT;
        } else {
            aVar = C3796q1.a.BOOLEAN;
        }
        return aVar != null;
    }
}
