package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a;

import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11880p;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.j */
/* JADX INFO: compiled from: RuntimeErrorReporter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11417j implements InterfaceC11880p {

    /* JADX INFO: renamed from: b */
    public static final C11417j f23021b = new C11417j();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11880p
    public void reportCannotInferVisibility(InterfaceC11321b interfaceC11321b) {
        C12238m.checkNotNullParameter(interfaceC11321b, "descriptor");
        throw new IllegalStateException(C12238m.stringPlus("Cannot infer visibility for ", interfaceC11321b));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11880p
    public void reportIncompleteHierarchy(InterfaceC11330e interfaceC11330e, List<String> list) {
        C12238m.checkNotNullParameter(interfaceC11330e, "descriptor");
        C12238m.checkNotNullParameter(list, "unresolvedSuperClasses");
        StringBuilder sbM833U = C1643a.m833U("Incomplete hierarchy for class ");
        sbM833U.append(interfaceC11330e.getName());
        sbM833U.append(", unresolved classes ");
        sbM833U.append(list);
        throw new IllegalStateException(sbM833U.toString());
    }
}
