package p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12010v0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11914c1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11916d0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.EnumC11973b;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.C11992a;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.k */
/* JADX INFO: compiled from: NewCapturedType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11951k {
    /* JADX WARN: Code duplicated, block: B:20:0x0057  */
    public static final AbstractC11934j0 captureFromArguments(AbstractC11934j0 abstractC11934j0, EnumC11973b enumC11973b) {
        ArrayList arrayList;
        C12238m.checkNotNullParameter(abstractC11934j0, "type");
        C12238m.checkNotNullParameter(enumC11973b, "status");
        EnumC11935j1 enumC11935j1 = EnumC11935j1.INVARIANT;
        if (abstractC11934j0.getArguments().size() != abstractC11934j0.getConstructor().getParameters().size()) {
            arrayList = null;
        } else {
            List<InterfaceC12012w0> arguments = abstractC11934j0.getArguments();
            boolean z2 = true;
            int i = 0;
            if (!(arguments instanceof Collection) || !arguments.isEmpty()) {
                Iterator<T> it = arguments.iterator();
                while (it.hasNext()) {
                    if (!(((InterfaceC12012w0) it.next()).getProjectionKind() == enumC11935j1)) {
                        z2 = false;
                        break;
                    }
                }
            }
            if (z2) {
                arrayList = null;
            } else {
                List<InterfaceC11477z0> parameters = abstractC11934j0.getConstructor().getParameters();
                C12238m.checkNotNullExpressionValue(parameters, "type.constructor.parameters");
                List<Pair> listZip = C12163u.zip(arguments, parameters);
                ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(listZip, 10));
                for (Pair pair : listZip) {
                    InterfaceC12012w0 interfaceC12012w0AsTypeProjection = (InterfaceC12012w0) pair.component1();
                    InterfaceC11477z0 interfaceC11477z0 = (InterfaceC11477z0) pair.component2();
                    if (interfaceC12012w0AsTypeProjection.getProjectionKind() != enumC11935j1) {
                        AbstractC11932i1 abstractC11932i1Unwrap = (interfaceC12012w0AsTypeProjection.isStarProjection() || interfaceC12012w0AsTypeProjection.getProjectionKind() != EnumC11935j1.IN_VARIANCE) ? null : interfaceC12012w0AsTypeProjection.getType().unwrap();
                        C12238m.checkNotNullExpressionValue(interfaceC11477z0, "parameter");
                        interfaceC12012w0AsTypeProjection = C11992a.asTypeProjection(new C11949i(enumC11973b, abstractC11932i1Unwrap, interfaceC12012w0AsTypeProjection, interfaceC11477z0));
                    }
                    arrayList2.add(interfaceC12012w0AsTypeProjection);
                }
                C11914c1 c11914c1BuildSubstitutor = AbstractC12010v0.f24889b.create(abstractC11934j0.getConstructor(), arrayList2).buildSubstitutor();
                int size = arguments.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i2 = i + 1;
                        InterfaceC12012w0 interfaceC12012w0 = arguments.get(i);
                        InterfaceC12012w0 interfaceC12012w1 = (InterfaceC12012w0) arrayList2.get(i);
                        if (interfaceC12012w0.getProjectionKind() != enumC11935j1) {
                            List<AbstractC11913c0> upperBounds = abstractC11934j0.getConstructor().getParameters().get(i).getUpperBounds();
                            ArrayList arrayListM840a0 = C1643a.m840a0(upperBounds, "type.constructor.parameters[index].upperBounds");
                            Iterator<T> it2 = upperBounds.iterator();
                            while (it2.hasNext()) {
                                arrayListM840a0.add(InterfaceC11952l.f24820b.getDefault().transformToNewType(c11914c1BuildSubstitutor.safeSubstitute((AbstractC11913c0) it2.next(), enumC11935j1).unwrap()));
                            }
                            if (!interfaceC12012w0.isStarProjection() && interfaceC12012w0.getProjectionKind() == EnumC11935j1.OUT_VARIANCE) {
                                arrayListM840a0.add(InterfaceC11952l.f24820b.getDefault().transformToNewType(interfaceC12012w0.getType().unwrap()));
                            }
                            ((C11949i) interfaceC12012w1.getType()).getConstructor().initializeSupertypes(arrayListM840a0);
                        }
                        if (i2 > size) {
                            break;
                        }
                        i = i2;
                    }
                }
                arrayList = arrayList2;
            }
        }
        if (arrayList == null) {
            return null;
        }
        C11916d0 c11916d0 = C11916d0.f24748a;
        return C11916d0.simpleType$default(abstractC11934j0.getAnnotations(), abstractC11934j0.getConstructor(), arrayList, abstractC11934j0.isMarkedNullable(), null, 16, null);
    }
}
