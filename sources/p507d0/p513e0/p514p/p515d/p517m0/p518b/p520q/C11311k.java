package p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.C11539f;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12034b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.k */
/* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11311k implements C12034b.c<InterfaceC11330e> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C11307g f22662a;

    public C11311k(C11307g c11307g) {
        this.f22662a = c11307g;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p576p.C12034b.c
    public final Iterable<InterfaceC11330e> getNeighbors(InterfaceC11330e interfaceC11330e) {
        Collection<AbstractC11913c0> supertypes = interfaceC11330e.getTypeConstructor().getSupertypes();
        C12238m.checkNotNullExpressionValue(supertypes, "it.typeConstructor.supertypes");
        C11307g c11307g = this.f22662a;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = supertypes.iterator();
        while (it.hasNext()) {
            InterfaceC11352h declarationDescriptor = ((AbstractC11913c0) it.next()).getConstructor().getDeclarationDescriptor();
            InterfaceC11352h original = declarationDescriptor == null ? null : declarationDescriptor.getOriginal();
            InterfaceC11330e interfaceC11330e2 = original instanceof InterfaceC11330e ? (InterfaceC11330e) original : null;
            C11539f c11539fM9381a = interfaceC11330e2 != null ? c11307g.m9381a(interfaceC11330e2) : null;
            if (c11539fM9381a != null) {
                arrayList.add(c11539fM9381a);
            }
        }
        return arrayList;
    }
}
