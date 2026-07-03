package p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11291k;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11464t;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11327d;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11787e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11789g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.C11992a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.y.a */
/* JADX INFO: compiled from: inlineClassManglingRules.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11837a {
    /* JADX INFO: renamed from: a */
    public static final boolean m9943a(AbstractC11913c0 abstractC11913c0) {
        InterfaceC11352h declarationDescriptor = abstractC11913c0.getConstructor().getDeclarationDescriptor();
        InterfaceC11477z0 interfaceC11477z0 = declarationDescriptor instanceof InterfaceC11477z0 ? (InterfaceC11477z0) declarationDescriptor : null;
        if (interfaceC11477z0 == null) {
            return false;
        }
        return m9944b(C11992a.getRepresentativeUpperBound(interfaceC11477z0));
    }

    /* JADX INFO: renamed from: b */
    public static final boolean m9944b(AbstractC11913c0 abstractC11913c0) {
        return isInlineClassThatRequiresMangling(abstractC11913c0) || m9943a(abstractC11913c0);
    }

    public static final boolean isInlineClassThatRequiresMangling(InterfaceC11450m interfaceC11450m) {
        C12238m.checkNotNullParameter(interfaceC11450m, "<this>");
        return C11789g.isInlineClass(interfaceC11450m) && !C12238m.areEqual(C11836a.getFqNameSafe((InterfaceC11330e) interfaceC11450m), C11291k.f22495h);
    }

    public static final boolean shouldHideConstructorDueToInlineClassTypeValueParameters(InterfaceC11321b interfaceC11321b) {
        C12238m.checkNotNullParameter(interfaceC11321b, "descriptor");
        InterfaceC11327d interfaceC11327d = interfaceC11321b instanceof InterfaceC11327d ? (InterfaceC11327d) interfaceC11321b : null;
        if (interfaceC11327d == null || C11464t.isPrivate(interfaceC11327d.getVisibility())) {
            return false;
        }
        InterfaceC11330e constructedClass = interfaceC11327d.getConstructedClass();
        C12238m.checkNotNullExpressionValue(constructedClass, "constructorDescriptor.constructedClass");
        if (C11789g.isInlineClass(constructedClass) || C11787e.isSealedClass(interfaceC11327d.getConstructedClass())) {
            return false;
        }
        List<InterfaceC11326c1> valueParameters = interfaceC11327d.getValueParameters();
        C12238m.checkNotNullExpressionValue(valueParameters, "constructorDescriptor.valueParameters");
        if ((valueParameters instanceof Collection) && valueParameters.isEmpty()) {
            return false;
        }
        Iterator<T> it = valueParameters.iterator();
        while (it.hasNext()) {
            AbstractC11913c0 type = ((InterfaceC11326c1) it.next()).getType();
            C12238m.checkNotNullExpressionValue(type, "it.type");
            if (m9944b(type)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isInlineClassThatRequiresMangling(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        InterfaceC11352h declarationDescriptor = abstractC11913c0.getConstructor().getDeclarationDescriptor();
        return C12238m.areEqual(declarationDescriptor == null ? null : Boolean.valueOf(isInlineClassThatRequiresMangling(declarationDescriptor)), Boolean.TRUE);
    }
}
