package p507d0.p513e0.p514p.p515d.p517m0.p552k;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11476z;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11331e0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.C11765d;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a */
/* JADX INFO: compiled from: SealedClassInheritorsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11761a extends AbstractC11801s {

    /* JADX INFO: renamed from: a */
    public static final C11761a f24332a = new C11761a();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public static final void m9909a(InterfaceC11330e interfaceC11330e, LinkedHashSet<InterfaceC11330e> linkedHashSet, InterfaceC11770i interfaceC11770i, boolean z2) {
        for (InterfaceC11450m interfaceC11450m : InterfaceC11773l.a.getContributedDescriptors$default(interfaceC11770i, C11765d.f24353o, null, 2, null)) {
            if (interfaceC11450m instanceof InterfaceC11330e) {
                InterfaceC11330e interfaceC11330e2 = (InterfaceC11330e) interfaceC11450m;
                if (C11787e.isDirectSubclass(interfaceC11330e2, interfaceC11330e)) {
                    linkedHashSet.add(interfaceC11450m);
                }
                if (z2) {
                    InterfaceC11770i unsubstitutedInnerClassesScope = interfaceC11330e2.getUnsubstitutedInnerClassesScope();
                    C12238m.checkNotNullExpressionValue(unsubstitutedInnerClassesScope, "descriptor.unsubstitutedInnerClassesScope");
                    m9909a(interfaceC11330e, linkedHashSet, unsubstitutedInnerClassesScope, z2);
                }
            }
        }
    }

    public Collection<InterfaceC11330e> computeSealedSubclasses(InterfaceC11330e interfaceC11330e, boolean z2) {
        InterfaceC11450m next;
        InterfaceC11450m containingDeclaration;
        C12238m.checkNotNullParameter(interfaceC11330e, "sealedClass");
        if (interfaceC11330e.getModality() != EnumC11476z.SEALED) {
            return C12147n.emptyList();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (z2) {
            Iterator<InterfaceC11450m> it = C11836a.getParents(interfaceC11330e).iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(next instanceof InterfaceC11331e0));
            containingDeclaration = next;
        } else {
            containingDeclaration = interfaceC11330e.getContainingDeclaration();
        }
        if (containingDeclaration instanceof InterfaceC11331e0) {
            m9909a(interfaceC11330e, linkedHashSet, ((InterfaceC11331e0) containingDeclaration).getMemberScope(), z2);
        }
        InterfaceC11770i unsubstitutedInnerClassesScope = interfaceC11330e.getUnsubstitutedInnerClassesScope();
        C12238m.checkNotNullExpressionValue(unsubstitutedInnerClassesScope, "sealedClass.unsubstitutedInnerClassesScope");
        m9909a(interfaceC11330e, linkedHashSet, unsubstitutedInnerClassesScope, true);
        return linkedHashSet;
    }
}
