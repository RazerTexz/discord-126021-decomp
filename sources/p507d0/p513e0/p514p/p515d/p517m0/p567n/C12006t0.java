package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11979h;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.t0 */
/* JADX INFO: compiled from: TypeCapabilities.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12006t0 {
    public static final InterfaceC11933j getCustomTypeVariable(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        InterfaceC11979h interfaceC11979hUnwrap = abstractC11913c0.unwrap();
        InterfaceC11933j interfaceC11933j = interfaceC11979hUnwrap instanceof InterfaceC11933j ? (InterfaceC11933j) interfaceC11979hUnwrap : null;
        if (interfaceC11933j != null && interfaceC11933j.isTypeVariable()) {
            return interfaceC11933j;
        }
        return null;
    }

    public static final boolean isCustomTypeVariable(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        InterfaceC11979h interfaceC11979hUnwrap = abstractC11913c0.unwrap();
        InterfaceC11933j interfaceC11933j = interfaceC11979hUnwrap instanceof InterfaceC11933j ? (InterfaceC11933j) interfaceC11979hUnwrap : null;
        if (interfaceC11933j == null) {
            return false;
        }
        return interfaceC11933j.isTypeVariable();
    }
}
