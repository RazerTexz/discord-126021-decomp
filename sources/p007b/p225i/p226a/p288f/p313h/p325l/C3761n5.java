package p007b.p225i.p226a.p288f.p313h.p325l;

/* JADX INFO: renamed from: b.i.a.f.h.l.n5 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3761n5 extends AbstractC3748m5 {
    public C3761n5(C3735l5 c3735l5) {
        super(null);
    }

    /* JADX INFO: renamed from: c */
    public static <E> InterfaceC3597b5<E> m5137c(Object obj, long j) {
        return (InterfaceC3597b5) C3711j7.m4993r(obj, j);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3748m5
    /* JADX INFO: renamed from: a */
    public final <E> void mo5070a(Object obj, Object obj2, long j) {
        InterfaceC3597b5 interfaceC3597b5M5137c = m5137c(obj, j);
        InterfaceC3597b5 interfaceC3597b5M5137c2 = m5137c(obj2, j);
        int size = interfaceC3597b5M5137c.size();
        int size2 = interfaceC3597b5M5137c2.size();
        if (size > 0 && size2 > 0) {
            if (!interfaceC3597b5M5137c.mo4568a()) {
                interfaceC3597b5M5137c = interfaceC3597b5M5137c.mo4569f(size2 + size);
            }
            interfaceC3597b5M5137c.addAll(interfaceC3597b5M5137c2);
        }
        if (size > 0) {
            interfaceC3597b5M5137c2 = interfaceC3597b5M5137c;
        }
        C3711j7.m4981f(obj, j, interfaceC3597b5M5137c2);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3748m5
    /* JADX INFO: renamed from: b */
    public final void mo5071b(Object obj, long j) {
        m5137c(obj, j).mo4570g0();
    }
}
