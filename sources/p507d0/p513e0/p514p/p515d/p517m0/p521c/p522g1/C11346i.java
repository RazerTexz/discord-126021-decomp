package p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1;

import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.i */
/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11346i {
    public static final InterfaceC11344g composeAnnotations(InterfaceC11344g interfaceC11344g, InterfaceC11344g interfaceC11344g2) {
        C12238m.checkNotNullParameter(interfaceC11344g, "first");
        C12238m.checkNotNullParameter(interfaceC11344g2, "second");
        if (interfaceC11344g.isEmpty()) {
            return interfaceC11344g2;
        }
        return interfaceC11344g2.isEmpty() ? interfaceC11344g : new C11348k(interfaceC11344g, interfaceC11344g2);
    }
}
