package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11475y0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.C11346i;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.InterfaceC11946f;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.C11992a;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.q0 */
/* JADX INFO: compiled from: TypeAliasExpander.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12000q0 {

    /* JADX INFO: renamed from: a */
    public static final a f24863a = new a(null);

    /* JADX INFO: renamed from: b */
    public final InterfaceC12004s0 f24864b;

    /* JADX INFO: renamed from: c */
    public final boolean f24865c;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.q0$a */
    /* JADX INFO: compiled from: TypeAliasExpander.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final void access$assertRecursionDepth(a aVar, int i, InterfaceC11475y0 interfaceC11475y0) {
            Objects.requireNonNull(aVar);
            if (i > 100) {
                throw new AssertionError(C12238m.stringPlus("Too deep recursion while expanding type alias ", interfaceC11475y0.getName()));
            }
        }

        public final void checkBoundsInTypeAlias(InterfaceC12004s0 interfaceC12004s0, AbstractC11913c0 abstractC11913c0, AbstractC11913c0 abstractC11913c1, InterfaceC11477z0 interfaceC11477z0, C11914c1 c11914c1) {
            C12238m.checkNotNullParameter(interfaceC12004s0, "reportStrategy");
            C12238m.checkNotNullParameter(abstractC11913c0, "unsubstitutedArgument");
            C12238m.checkNotNullParameter(abstractC11913c1, "typeArgument");
            C12238m.checkNotNullParameter(interfaceC11477z0, "typeParameterDescriptor");
            C12238m.checkNotNullParameter(c11914c1, "substitutor");
            Iterator<AbstractC11913c0> it = interfaceC11477z0.getUpperBounds().iterator();
            while (it.hasNext()) {
                AbstractC11913c0 abstractC11913c0SafeSubstitute = c11914c1.safeSubstitute(it.next(), EnumC11935j1.INVARIANT);
                C12238m.checkNotNullExpressionValue(abstractC11913c0SafeSubstitute, "substitutor.safeSubstitute(bound, Variance.INVARIANT)");
                if (!InterfaceC11946f.f24806a.isSubtypeOf(abstractC11913c1, abstractC11913c0SafeSubstitute)) {
                    interfaceC12004s0.boundsViolationInSubstitution(abstractC11913c0SafeSubstitute, abstractC11913c0, abstractC11913c1, interfaceC11477z0);
                }
            }
        }
    }

    static {
        new C12000q0(InterfaceC12004s0.a.f24876a, false);
    }

    public C12000q0(InterfaceC12004s0 interfaceC12004s0, boolean z2) {
        C12238m.checkNotNullParameter(interfaceC12004s0, "reportStrategy");
        this.f24864b = interfaceC12004s0;
        this.f24865c = z2;
    }

    /* JADX INFO: renamed from: a */
    public final void m10024a(InterfaceC11344g interfaceC11344g, InterfaceC11344g interfaceC11344g2) {
        HashSet hashSet = new HashSet();
        Iterator<InterfaceC11340c> it = interfaceC11344g.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getFqName());
        }
        for (InterfaceC11340c interfaceC11340c : interfaceC11344g2) {
            if (hashSet.contains(interfaceC11340c.getFqName())) {
                this.f24864b.repeatedAnnotation(interfaceC11340c);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final AbstractC11934j0 m10025b(AbstractC11934j0 abstractC11934j0, InterfaceC11344g interfaceC11344g) {
        return C11919e0.isError(abstractC11934j0) ? abstractC11934j0 : C11908a1.replace$default(abstractC11934j0, null, m10026c(abstractC11934j0, interfaceC11344g), 1, null);
    }

    /* JADX INFO: renamed from: c */
    public final InterfaceC11344g m10026c(AbstractC11913c0 abstractC11913c0, InterfaceC11344g interfaceC11344g) {
        return C11919e0.isError(abstractC11913c0) ? abstractC11913c0.getAnnotations() : C11346i.composeAnnotations(interfaceC11344g, abstractC11913c0.getAnnotations());
    }

    /* JADX INFO: renamed from: d */
    public final AbstractC11934j0 m10027d(C12002r0 c12002r0, InterfaceC11344g interfaceC11344g, boolean z2, int i, boolean z3) {
        InterfaceC12012w0 interfaceC12012w0M10028e = m10028e(new C12016y0(EnumC11935j1.INVARIANT, c12002r0.getDescriptor().getUnderlyingType()), c12002r0, null, i);
        AbstractC11913c0 type = interfaceC12012w0M10028e.getType();
        C12238m.checkNotNullExpressionValue(type, "expandedProjection.type");
        AbstractC11934j0 abstractC11934j0AsSimpleType = C11908a1.asSimpleType(type);
        if (C11919e0.isError(abstractC11934j0AsSimpleType)) {
            return abstractC11934j0AsSimpleType;
        }
        interfaceC12012w0M10028e.getProjectionKind();
        m10024a(abstractC11934j0AsSimpleType.getAnnotations(), interfaceC11344g);
        AbstractC11934j0 abstractC11934j0MakeNullableIfNeeded = C11920e1.makeNullableIfNeeded(m10025b(abstractC11934j0AsSimpleType, interfaceC11344g), z2);
        C12238m.checkNotNullExpressionValue(abstractC11934j0MakeNullableIfNeeded, "expandedType.combineAnnotations(annotations).let { TypeUtils.makeNullableIfNeeded(it, isNullable) }");
        if (!z3) {
            return abstractC11934j0MakeNullableIfNeeded;
        }
        C11916d0 c11916d0 = C11916d0.f24748a;
        InterfaceC12008u0 typeConstructor = c12002r0.getDescriptor().getTypeConstructor();
        C12238m.checkNotNullExpressionValue(typeConstructor, "descriptor.typeConstructor");
        return C11968m0.withAbbreviation(abstractC11934j0MakeNullableIfNeeded, C11916d0.simpleTypeWithNonTrivialMemberScope(interfaceC11344g, typeConstructor, c12002r0.getArguments(), z2, InterfaceC11770i.b.f24373b));
    }

    /* JADX INFO: renamed from: e */
    public final InterfaceC12012w0 m10028e(InterfaceC12012w0 interfaceC12012w0, C12002r0 c12002r0, InterfaceC11477z0 interfaceC11477z0, int i) {
        AbstractC11913c0 abstractC11913c0M10025b;
        EnumC11935j1 enumC11935j1 = EnumC11935j1.INVARIANT;
        a.access$assertRecursionDepth(f24863a, i, c12002r0.getDescriptor());
        if (interfaceC12012w0.isStarProjection()) {
            C12238m.checkNotNull(interfaceC11477z0);
            InterfaceC12012w0 interfaceC12012w0MakeStarProjection = C11920e1.makeStarProjection(interfaceC11477z0);
            C12238m.checkNotNullExpressionValue(interfaceC12012w0MakeStarProjection, "makeStarProjection(typeParameterDescriptor!!)");
            return interfaceC12012w0MakeStarProjection;
        }
        AbstractC11913c0 type = interfaceC12012w0.getType();
        C12238m.checkNotNullExpressionValue(type, "underlyingProjection.type");
        InterfaceC12012w0 replacement = c12002r0.getReplacement(type.getConstructor());
        if (replacement != null) {
            if (replacement.isStarProjection()) {
                C12238m.checkNotNull(interfaceC11477z0);
                InterfaceC12012w0 interfaceC12012w0MakeStarProjection2 = C11920e1.makeStarProjection(interfaceC11477z0);
                C12238m.checkNotNullExpressionValue(interfaceC12012w0MakeStarProjection2, "makeStarProjection(typeParameterDescriptor!!)");
                return interfaceC12012w0MakeStarProjection2;
            }
            AbstractC11932i1 abstractC11932i1Unwrap = replacement.getType().unwrap();
            EnumC11935j1 projectionKind = replacement.getProjectionKind();
            C12238m.checkNotNullExpressionValue(projectionKind, "argument.projectionKind");
            EnumC11935j1 projectionKind2 = interfaceC12012w0.getProjectionKind();
            C12238m.checkNotNullExpressionValue(projectionKind2, "underlyingProjection.projectionKind");
            if (projectionKind2 != projectionKind && projectionKind2 != enumC11935j1) {
                if (projectionKind == enumC11935j1) {
                    projectionKind = projectionKind2;
                } else {
                    this.f24864b.conflictingProjection(c12002r0.getDescriptor(), interfaceC11477z0, abstractC11932i1Unwrap);
                }
            }
            EnumC11935j1 variance = interfaceC11477z0 == null ? null : interfaceC11477z0.getVariance();
            if (variance == null) {
                variance = enumC11935j1;
            }
            C12238m.checkNotNullExpressionValue(variance, "typeParameterDescriptor?.variance ?: Variance.INVARIANT");
            if (variance == projectionKind || variance == enumC11935j1) {
                enumC11935j1 = projectionKind;
            } else if (projectionKind != enumC11935j1) {
                this.f24864b.conflictingProjection(c12002r0.getDescriptor(), interfaceC11477z0, abstractC11932i1Unwrap);
                enumC11935j1 = projectionKind;
            }
            m10024a(type.getAnnotations(), abstractC11932i1Unwrap.getAnnotations());
            if (abstractC11932i1Unwrap instanceof C11999q) {
                C11999q c11999q = (C11999q) abstractC11932i1Unwrap;
                abstractC11913c0M10025b = c11999q.replaceAnnotations(m10026c(c11999q, type.getAnnotations()));
            } else {
                AbstractC11934j0 abstractC11934j0MakeNullableIfNeeded = C11920e1.makeNullableIfNeeded(C11908a1.asSimpleType(abstractC11932i1Unwrap), type.isMarkedNullable());
                C12238m.checkNotNullExpressionValue(abstractC11934j0MakeNullableIfNeeded, "makeNullableIfNeeded(this, fromType.isMarkedNullable)");
                abstractC11913c0M10025b = m10025b(abstractC11934j0MakeNullableIfNeeded, type.getAnnotations());
            }
            return new C12016y0(enumC11935j1, abstractC11913c0M10025b);
        }
        AbstractC11932i1 abstractC11932i1Unwrap2 = interfaceC12012w0.getType().unwrap();
        if (C12001r.isDynamic(abstractC11932i1Unwrap2)) {
            return interfaceC12012w0;
        }
        AbstractC11934j0 abstractC11934j0AsSimpleType = C11908a1.asSimpleType(abstractC11932i1Unwrap2);
        if (C11919e0.isError(abstractC11934j0AsSimpleType) || !C11992a.requiresTypeAliasExpansion(abstractC11934j0AsSimpleType)) {
            return interfaceC12012w0;
        }
        InterfaceC12008u0 constructor = abstractC11934j0AsSimpleType.getConstructor();
        InterfaceC11352h declarationDescriptor = constructor.getDeclarationDescriptor();
        constructor.getParameters().size();
        abstractC11934j0AsSimpleType.getArguments().size();
        if (declarationDescriptor instanceof InterfaceC11477z0) {
            return interfaceC12012w0;
        }
        int i2 = 0;
        if (declarationDescriptor instanceof InterfaceC11475y0) {
            InterfaceC11475y0 interfaceC11475y0 = (InterfaceC11475y0) declarationDescriptor;
            if (c12002r0.isRecursion(interfaceC11475y0)) {
                this.f24864b.recursiveTypeAlias(interfaceC11475y0);
                return new C12016y0(enumC11935j1, C12005t.createErrorType(C12238m.stringPlus("Recursive type alias: ", interfaceC11475y0.getName())));
            }
            List<InterfaceC12012w0> arguments = abstractC11934j0AsSimpleType.getArguments();
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(arguments, 10));
            for (Object obj : arguments) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    C12147n.throwIndexOverflow();
                }
                arrayList.add(m10028e((InterfaceC12012w0) obj, c12002r0, constructor.getParameters().get(i2), i + 1));
                i2 = i3;
            }
            AbstractC11934j0 abstractC11934j0M10027d = m10027d(C12002r0.f24866a.create(c12002r0, interfaceC11475y0, arrayList), abstractC11934j0AsSimpleType.getAnnotations(), abstractC11934j0AsSimpleType.isMarkedNullable(), i + 1, false);
            AbstractC11934j0 abstractC11934j0M10029f = m10029f(abstractC11934j0AsSimpleType, c12002r0, i);
            if (!C12001r.isDynamic(abstractC11934j0M10027d)) {
                abstractC11934j0M10027d = C11968m0.withAbbreviation(abstractC11934j0M10027d, abstractC11934j0M10029f);
            }
            return new C12016y0(interfaceC12012w0.getProjectionKind(), abstractC11934j0M10027d);
        }
        AbstractC11934j0 abstractC11934j0M10029f2 = m10029f(abstractC11934j0AsSimpleType, c12002r0, i);
        C11914c1 c11914c1Create = C11914c1.create(abstractC11934j0M10029f2);
        C12238m.checkNotNullExpressionValue(c11914c1Create, "create(substitutedType)");
        for (Object obj2 : abstractC11934j0M10029f2.getArguments()) {
            int i4 = i2 + 1;
            if (i2 < 0) {
                C12147n.throwIndexOverflow();
            }
            InterfaceC12012w0 interfaceC12012w1 = (InterfaceC12012w0) obj2;
            if (!interfaceC12012w1.isStarProjection()) {
                AbstractC11913c0 type2 = interfaceC12012w1.getType();
                C12238m.checkNotNullExpressionValue(type2, "substitutedArgument.type");
                if (!C11992a.containsTypeAliasParameters(type2)) {
                    InterfaceC12012w0 interfaceC12012w2 = abstractC11934j0AsSimpleType.getArguments().get(i2);
                    InterfaceC11477z0 interfaceC11477z1 = abstractC11934j0AsSimpleType.getConstructor().getParameters().get(i2);
                    if (this.f24865c) {
                        a aVar = f24863a;
                        InterfaceC12004s0 interfaceC12004s0 = this.f24864b;
                        AbstractC11913c0 type3 = interfaceC12012w2.getType();
                        C12238m.checkNotNullExpressionValue(type3, "unsubstitutedArgument.type");
                        AbstractC11913c0 type4 = interfaceC12012w1.getType();
                        C12238m.checkNotNullExpressionValue(type4, "substitutedArgument.type");
                        C12238m.checkNotNullExpressionValue(interfaceC11477z1, "typeParameter");
                        aVar.checkBoundsInTypeAlias(interfaceC12004s0, type3, type4, interfaceC11477z1, c11914c1Create);
                    }
                }
            }
            i2 = i4;
        }
        return new C12016y0(interfaceC12012w0.getProjectionKind(), abstractC11934j0M10029f2);
    }

    public final AbstractC11934j0 expand(C12002r0 c12002r0, InterfaceC11344g interfaceC11344g) {
        C12238m.checkNotNullParameter(c12002r0, "typeAliasExpansion");
        C12238m.checkNotNullParameter(interfaceC11344g, "annotations");
        return m10027d(c12002r0, interfaceC11344g, false, 0, true);
    }

    /* JADX INFO: renamed from: f */
    public final AbstractC11934j0 m10029f(AbstractC11934j0 abstractC11934j0, C12002r0 c12002r0, int i) {
        InterfaceC12008u0 constructor = abstractC11934j0.getConstructor();
        List<InterfaceC12012w0> arguments = abstractC11934j0.getArguments();
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(arguments, 10));
        int i2 = 0;
        for (Object obj : arguments) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                C12147n.throwIndexOverflow();
            }
            InterfaceC12012w0 interfaceC12012w0 = (InterfaceC12012w0) obj;
            InterfaceC12012w0 interfaceC12012w0M10028e = m10028e(interfaceC12012w0, c12002r0, constructor.getParameters().get(i2), i + 1);
            if (!interfaceC12012w0M10028e.isStarProjection()) {
                interfaceC12012w0M10028e = new C12016y0(interfaceC12012w0M10028e.getProjectionKind(), C11920e1.makeNullableIfNeeded(interfaceC12012w0M10028e.getType(), interfaceC12012w0.getType().isMarkedNullable()));
            }
            arrayList.add(interfaceC12012w0M10028e);
            i2 = i3;
        }
        return C11908a1.replace$default(abstractC11934j0, arrayList, null, 2, null);
    }
}
