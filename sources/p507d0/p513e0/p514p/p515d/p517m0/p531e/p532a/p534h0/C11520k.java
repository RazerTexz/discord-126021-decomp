package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11384l0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.C11486a0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.C11548o;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11831w;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.h0.k */
/* JADX INFO: compiled from: util.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11520k {
    public static final List<InterfaceC11326c1> copyValueParameters(Collection<C11521l> collection, Collection<? extends InterfaceC11326c1> collection2, InterfaceC11318a interfaceC11318a) {
        C12238m.checkNotNullParameter(collection, "newValueParametersTypes");
        C12238m.checkNotNullParameter(collection2, "oldValueParameters");
        C12238m.checkNotNullParameter(interfaceC11318a, "newOwner");
        collection.size();
        collection2.size();
        List<Pair> listZip = C12163u.zip(collection, collection2);
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listZip, 10));
        for (Pair pair : listZip) {
            C11521l c11521l = (C11521l) pair.component1();
            InterfaceC11326c1 interfaceC11326c1 = (InterfaceC11326c1) pair.component2();
            int index = interfaceC11326c1.getIndex();
            InterfaceC11344g annotations = interfaceC11326c1.getAnnotations();
            C11716e name = interfaceC11326c1.getName();
            C12238m.checkNotNullExpressionValue(name, "oldParameter.name");
            AbstractC11913c0 type = c11521l.getType();
            boolean hasDefaultValue = c11521l.getHasDefaultValue();
            boolean zIsCrossinline = interfaceC11326c1.isCrossinline();
            boolean zIsNoinline = interfaceC11326c1.isNoinline();
            AbstractC11913c0 arrayElementType = interfaceC11326c1.getVarargElementType() != null ? C11836a.getModule(interfaceC11318a).getBuiltIns().getArrayElementType(c11521l.getType()) : null;
            InterfaceC11467u0 source = interfaceC11326c1.getSource();
            C12238m.checkNotNullExpressionValue(source, "oldParameter.source");
            arrayList.add(new C11384l0(interfaceC11318a, null, index, annotations, name, type, hasDefaultValue, zIsCrossinline, zIsNoinline, arrayElementType, source));
        }
        return arrayList;
    }

    public static final AbstractC11510a getDefaultValueFromAnnotation(InterfaceC11326c1 interfaceC11326c1) {
        AbstractC11815g<?> abstractC11815gFirstArgument;
        C11831w c11831w;
        String value;
        C12238m.checkNotNullParameter(interfaceC11326c1, "<this>");
        InterfaceC11344g annotations = interfaceC11326c1.getAnnotations();
        C11713b c11713b = C11486a0.f23164r;
        C12238m.checkNotNullExpressionValue(c11713b, "DEFAULT_VALUE_FQ_NAME");
        InterfaceC11340c interfaceC11340cFindAnnotation = annotations.findAnnotation(c11713b);
        if (interfaceC11340cFindAnnotation == null || (abstractC11815gFirstArgument = C11836a.firstArgument(interfaceC11340cFindAnnotation)) == null) {
            c11831w = null;
        } else {
            if (!(abstractC11815gFirstArgument instanceof C11831w)) {
                abstractC11815gFirstArgument = null;
            }
            c11831w = (C11831w) abstractC11815gFirstArgument;
        }
        if (c11831w != null && (value = c11831w.getValue()) != null) {
            return new C11519j(value);
        }
        InterfaceC11344g annotations2 = interfaceC11326c1.getAnnotations();
        C11713b c11713b2 = C11486a0.f23165s;
        C12238m.checkNotNullExpressionValue(c11713b2, "DEFAULT_NULL_FQ_NAME");
        if (annotations2.hasAnnotation(c11713b2)) {
            return C11517h.f23272a;
        }
        return null;
    }

    public static final C11548o getParentJavaStaticClassScope(InterfaceC11330e interfaceC11330e) {
        C12238m.checkNotNullParameter(interfaceC11330e, "<this>");
        InterfaceC11330e superClassNotAny = C11836a.getSuperClassNotAny(interfaceC11330e);
        if (superClassNotAny == null) {
            return null;
        }
        InterfaceC11770i staticScope = superClassNotAny.getStaticScope();
        C11548o c11548o = staticScope instanceof C11548o ? (C11548o) staticScope : null;
        return c11548o == null ? getParentJavaStaticClassScope(superClassNotAny) : c11548o;
    }
}
