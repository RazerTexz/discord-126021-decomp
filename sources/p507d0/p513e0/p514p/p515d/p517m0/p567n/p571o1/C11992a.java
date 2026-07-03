package p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11333f;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11475y0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12009v;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11908a1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11916d0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11920e1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11926g1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11991o0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12016y0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.InterfaceC11946f;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.o1.a */
/* JADX INFO: compiled from: TypeUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11992a {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.o1.a$a */
    /* JADX INFO: compiled from: TypeUtils.kt */
    public static final class a extends AbstractC12240o implements Function1<AbstractC11932i1, Boolean> {

        /* JADX INFO: renamed from: j */
        public static final a f24850j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(AbstractC11932i1 abstractC11932i1) {
            return Boolean.valueOf(invoke2(abstractC11932i1));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(AbstractC11932i1 abstractC11932i1) {
            C12238m.checkNotNullParameter(abstractC11932i1, "it");
            InterfaceC11352h declarationDescriptor = abstractC11932i1.getConstructor().getDeclarationDescriptor();
            if (declarationDescriptor == null) {
                return false;
            }
            return C11992a.isTypeAliasParameter(declarationDescriptor);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.o1.a$b */
    /* JADX INFO: compiled from: TypeUtils.kt */
    public static final class b extends AbstractC12240o implements Function1<AbstractC11932i1, Boolean> {

        /* JADX INFO: renamed from: j */
        public static final b f24851j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(AbstractC11932i1 abstractC11932i1) {
            return Boolean.valueOf(invoke2(abstractC11932i1));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(AbstractC11932i1 abstractC11932i1) {
            C12238m.checkNotNullParameter(abstractC11932i1, "it");
            InterfaceC11352h declarationDescriptor = abstractC11932i1.getConstructor().getDeclarationDescriptor();
            if (declarationDescriptor == null) {
                return false;
            }
            return (declarationDescriptor instanceof InterfaceC11475y0) || (declarationDescriptor instanceof InterfaceC11477z0);
        }
    }

    public static final InterfaceC12012w0 asTypeProjection(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        return new C12016y0(abstractC11913c0);
    }

    public static final boolean contains(AbstractC11913c0 abstractC11913c0, Function1<? super AbstractC11932i1, Boolean> function1) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        C12238m.checkNotNullParameter(function1, "predicate");
        return C11920e1.contains(abstractC11913c0, function1);
    }

    public static final boolean containsTypeAliasParameters(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        return contains(abstractC11913c0, a.f24850j);
    }

    public static final InterfaceC12012w0 createProjection(AbstractC11913c0 abstractC11913c0, EnumC11935j1 enumC11935j1, InterfaceC11477z0 interfaceC11477z0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "type");
        C12238m.checkNotNullParameter(enumC11935j1, "projectionKind");
        if ((interfaceC11477z0 == null ? null : interfaceC11477z0.getVariance()) == enumC11935j1) {
            enumC11935j1 = EnumC11935j1.INVARIANT;
        }
        return new C12016y0(enumC11935j1, abstractC11913c0);
    }

    public static final AbstractC11288h getBuiltIns(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        AbstractC11288h builtIns = abstractC11913c0.getConstructor().getBuiltIns();
        C12238m.checkNotNullExpressionValue(builtIns, "constructor.builtIns");
        return builtIns;
    }

    public static final AbstractC11913c0 getRepresentativeUpperBound(InterfaceC11477z0 interfaceC11477z0) {
        Object obj;
        C12238m.checkNotNullParameter(interfaceC11477z0, "<this>");
        List<AbstractC11913c0> upperBounds = interfaceC11477z0.getUpperBounds();
        C12238m.checkNotNullExpressionValue(upperBounds, "upperBounds");
        upperBounds.isEmpty();
        List<AbstractC11913c0> upperBounds2 = interfaceC11477z0.getUpperBounds();
        C12238m.checkNotNullExpressionValue(upperBounds2, "upperBounds");
        Iterator<T> it = upperBounds2.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            InterfaceC11352h declarationDescriptor = ((AbstractC11913c0) next).getConstructor().getDeclarationDescriptor();
            InterfaceC11330e interfaceC11330e = declarationDescriptor instanceof InterfaceC11330e ? (InterfaceC11330e) declarationDescriptor : null;
            boolean z2 = false;
            if (interfaceC11330e != null && interfaceC11330e.getKind() != EnumC11333f.INTERFACE && interfaceC11330e.getKind() != EnumC11333f.ANNOTATION_CLASS) {
                z2 = true;
            }
            if (z2) {
                obj = next;
                break;
            }
        }
        AbstractC11913c0 abstractC11913c0 = (AbstractC11913c0) obj;
        if (abstractC11913c0 != null) {
            return abstractC11913c0;
        }
        List<AbstractC11913c0> upperBounds3 = interfaceC11477z0.getUpperBounds();
        C12238m.checkNotNullExpressionValue(upperBounds3, "upperBounds");
        Object objFirst = C12163u.first((List<? extends Object>) upperBounds3);
        C12238m.checkNotNullExpressionValue(objFirst, "upperBounds.first()");
        return (AbstractC11913c0) objFirst;
    }

    public static final boolean isSubtypeOf(AbstractC11913c0 abstractC11913c0, AbstractC11913c0 abstractC11913c1) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        C12238m.checkNotNullParameter(abstractC11913c1, "superType");
        return InterfaceC11946f.f24806a.isSubtypeOf(abstractC11913c0, abstractC11913c1);
    }

    public static final boolean isTypeAliasParameter(InterfaceC11352h interfaceC11352h) {
        C12238m.checkNotNullParameter(interfaceC11352h, "<this>");
        return (interfaceC11352h instanceof InterfaceC11477z0) && (((InterfaceC11477z0) interfaceC11352h).getContainingDeclaration() instanceof InterfaceC11475y0);
    }

    public static final boolean isTypeParameter(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        return C11920e1.isTypeParameter(abstractC11913c0);
    }

    public static final AbstractC11913c0 makeNotNullable(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        AbstractC11913c0 abstractC11913c0MakeNotNullable = C11920e1.makeNotNullable(abstractC11913c0);
        C12238m.checkNotNullExpressionValue(abstractC11913c0MakeNotNullable, "makeNotNullable(this)");
        return abstractC11913c0MakeNotNullable;
    }

    public static final AbstractC11913c0 makeNullable(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        AbstractC11913c0 abstractC11913c0MakeNullable = C11920e1.makeNullable(abstractC11913c0);
        C12238m.checkNotNullExpressionValue(abstractC11913c0MakeNullable, "makeNullable(this)");
        return abstractC11913c0MakeNullable;
    }

    public static final AbstractC11913c0 replaceAnnotations(AbstractC11913c0 abstractC11913c0, InterfaceC11344g interfaceC11344g) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        C12238m.checkNotNullParameter(interfaceC11344g, "newAnnotations");
        return (abstractC11913c0.getAnnotations().isEmpty() && interfaceC11344g.isEmpty()) ? abstractC11913c0 : abstractC11913c0.unwrap().replaceAnnotations(interfaceC11344g);
    }

    public static final AbstractC11913c0 replaceArgumentsWithStarProjections(AbstractC11913c0 abstractC11913c0) {
        AbstractC11934j0 abstractC11934j0;
        AbstractC11932i1 abstractC11932i1Replace$default;
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        AbstractC11932i1 abstractC11932i1Unwrap = abstractC11913c0.unwrap();
        if (abstractC11932i1Unwrap instanceof AbstractC12009v) {
            C11916d0 c11916d0 = C11916d0.f24748a;
            AbstractC12009v abstractC12009v = (AbstractC12009v) abstractC11932i1Unwrap;
            AbstractC11934j0 lowerBound = abstractC12009v.getLowerBound();
            if (!lowerBound.getConstructor().getParameters().isEmpty() && lowerBound.getConstructor().getDeclarationDescriptor() != null) {
                List<InterfaceC11477z0> parameters = lowerBound.getConstructor().getParameters();
                C12238m.checkNotNullExpressionValue(parameters, "constructor.parameters");
                ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(parameters, 10));
                Iterator<T> it = parameters.iterator();
                while (it.hasNext()) {
                    arrayList.add(new C11991o0((InterfaceC11477z0) it.next()));
                }
                lowerBound = C11908a1.replace$default(lowerBound, arrayList, null, 2, null);
            }
            AbstractC11934j0 upperBound = abstractC12009v.getUpperBound();
            if (!upperBound.getConstructor().getParameters().isEmpty() && upperBound.getConstructor().getDeclarationDescriptor() != null) {
                List<InterfaceC11477z0> parameters2 = upperBound.getConstructor().getParameters();
                C12238m.checkNotNullExpressionValue(parameters2, "constructor.parameters");
                ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(parameters2, 10));
                Iterator<T> it2 = parameters2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new C11991o0((InterfaceC11477z0) it2.next()));
                }
                upperBound = C11908a1.replace$default(upperBound, arrayList2, null, 2, null);
            }
            abstractC11932i1Replace$default = C11916d0.flexibleType(lowerBound, upperBound);
        } else {
            if (!(abstractC11932i1Unwrap instanceof AbstractC11934j0)) {
                throw new NoWhenBranchMatchedException();
            }
            abstractC11934j0 = (AbstractC11934j0) abstractC11932i1Unwrap;
            if (!abstractC11934j0.getConstructor().getParameters().isEmpty() && abstractC11934j0.getConstructor().getDeclarationDescriptor() != null) {
                abstractC11932i1Replace$default = abstractC11934j0;
                abstractC11932i1Replace$default = abstractC11934j0;
                List<InterfaceC11477z0> parameters3 = abstractC11934j0.getConstructor().getParameters();
                C12238m.checkNotNullExpressionValue(parameters3, "constructor.parameters");
                ArrayList arrayList3 = new ArrayList(C12149o.collectionSizeOrDefault(parameters3, 10));
                Iterator<T> it3 = parameters3.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(new C11991o0((InterfaceC11477z0) it3.next()));
                }
                abstractC11932i1Replace$default = C11908a1.replace$default(abstractC11934j0, arrayList3, null, 2, null);
            }
        }
        abstractC11932i1Replace$default = abstractC11934j0;
        abstractC11932i1Replace$default = abstractC11934j0;
        abstractC11932i1Replace$default = abstractC11934j0;
        return C11926g1.inheritEnhancement(abstractC11932i1Replace$default, abstractC11932i1Unwrap);
    }

    public static final boolean requiresTypeAliasExpansion(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        return contains(abstractC11913c0, b.f24851j);
    }
}
