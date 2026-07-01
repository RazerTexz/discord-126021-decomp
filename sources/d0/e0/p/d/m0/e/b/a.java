package d0.e0.p.d.m0.e.b;

import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.f.a0.b.e$a;
import d0.e0.p.d.m0.f.a0.b.e$b;
import d0.e0.p.d.m0.f.c$c;
import d0.e0.p.d.m0.i.g$d;
import d0.e0.p.d.m0.i.g$f;
import d0.e0.p.d.m0.k.v.b0;
import d0.e0.p.d.m0.l.b.y$a;
import d0.e0.p.d.m0.l.b.y$b;
import d0.e0.p.d.m0.m.f$m;
import d0.e0.p.d.m0.n.c0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a<A, C> implements d0.e0.p.d.m0.l.b.c<A, C> {
    public final n a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.m.h<p, a$b<A, C>> f3361b;

    public a(d0.e0.p.d.m0.m.o oVar, n nVar) {
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(nVar, "kotlinClassFinder");
        this.a = nVar;
        this.f3361b = oVar.createMemoizedFunction(new a$d(this));
    }

    public static final p$a access$loadAnnotationIfNotSpecial(a aVar, d0.e0.p.d.m0.g.a aVar2, u0 u0Var, List list) {
        Objects.requireNonNull(aVar);
        if (d0.e0.p.d.m0.a.a.getSPECIAL_ANNOTATIONS().contains(aVar2)) {
            return null;
        }
        return aVar.h(aVar2, u0Var, list);
    }

    public static final a$b access$loadAnnotationsAndInitializers(a aVar, p pVar) {
        Objects.requireNonNull(aVar);
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        b bVar = new b(aVar, map, map2);
        d0.z.d.m.checkNotNullParameter(pVar, "kotlinClass");
        pVar.visitMembers(bVar, null);
        return new a$b(map, map2);
    }

    public static /* synthetic */ List b(a aVar, d0.e0.p.d.m0.l.b.y yVar, s sVar, boolean z2, boolean z3, Boolean bool, boolean z4, int i, Object obj) {
        return aVar.a(yVar, sVar, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? false : z4);
    }

    public static /* synthetic */ s d(a aVar, d0.e0.p.d.m0.i.n nVar, d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.z.g gVar, d0.e0.p.d.m0.l.b.b bVar, boolean z2, int i, Object obj) {
        return aVar.c(nVar, cVar, gVar, bVar, (i & 16) != 0 ? false : z2);
    }

    public static /* synthetic */ s f(a aVar, d0.e0.p.d.m0.f.n nVar, d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.z.g gVar, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        return aVar.e(nVar, cVar, gVar, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? true : z4);
    }

    public final List<A> a(d0.e0.p.d.m0.l.b.y yVar, s sVar, boolean z2, boolean z3, Boolean bool, boolean z4) {
        p pVarG = g(yVar, z2, z3, bool, z4);
        if (pVarG == null) {
            pVarG = yVar instanceof y$a ? j((y$a) yVar) : null;
        }
        if (pVarG == null) {
            return d0.t.n.emptyList();
        }
        List<A> list = ((a$b) ((f$m) this.f3361b).invoke(pVarG)).getMemberAnnotations().get(sVar);
        return list == null ? d0.t.n.emptyList() : list;
    }

    public final s c(d0.e0.p.d.m0.i.n nVar, d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.z.g gVar, d0.e0.p.d.m0.l.b.b bVar, boolean z2) {
        if (nVar instanceof d0.e0.p.d.m0.f.d) {
            s$a s_a = s.a;
            e$b jvmConstructorSignature = d0.e0.p.d.m0.f.a0.b.h.a.getJvmConstructorSignature((d0.e0.p.d.m0.f.d) nVar, cVar, gVar);
            if (jvmConstructorSignature == null) {
                return null;
            }
            return s_a.fromJvmMemberSignature(jvmConstructorSignature);
        }
        if (nVar instanceof d0.e0.p.d.m0.f.i) {
            s$a s_a2 = s.a;
            e$b jvmMethodSignature = d0.e0.p.d.m0.f.a0.b.h.a.getJvmMethodSignature((d0.e0.p.d.m0.f.i) nVar, cVar, gVar);
            if (jvmMethodSignature == null) {
                return null;
            }
            return s_a2.fromJvmMemberSignature(jvmMethodSignature);
        }
        if (!(nVar instanceof d0.e0.p.d.m0.f.n)) {
            return null;
        }
        g$f<d0.e0.p.d.m0.f.n, d0.e0.p.d.m0.f.a0.a$d> g_f = d0.e0.p.d.m0.f.a0.a.d;
        d0.z.d.m.checkNotNullExpressionValue(g_f, "propertySignature");
        d0.e0.p.d.m0.f.a0.a$d a_d = (d0.e0.p.d.m0.f.a0.a$d) d0.e0.p.d.m0.f.z.e.getExtensionOrNull((g$d) nVar, g_f);
        if (a_d == null) {
            return null;
        }
        int iOrdinal = bVar.ordinal();
        if (iOrdinal == 1) {
            return e((d0.e0.p.d.m0.f.n) nVar, cVar, gVar, true, true, z2);
        }
        if (iOrdinal == 2) {
            if (!a_d.hasGetter()) {
                return null;
            }
            s$a s_a3 = s.a;
            d0.e0.p.d.m0.f.a0.a$c getter = a_d.getGetter();
            d0.z.d.m.checkNotNullExpressionValue(getter, "signature.getter");
            return s_a3.fromMethod(cVar, getter);
        }
        if (iOrdinal != 3 || !a_d.hasSetter()) {
            return null;
        }
        s$a s_a4 = s.a;
        d0.e0.p.d.m0.f.a0.a$c setter = a_d.getSetter();
        d0.z.d.m.checkNotNullExpressionValue(setter, "signature.setter");
        return s_a4.fromMethod(cVar, setter);
    }

    public final s e(d0.e0.p.d.m0.f.n nVar, d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.z.g gVar, boolean z2, boolean z3, boolean z4) {
        g$f<d0.e0.p.d.m0.f.n, d0.e0.p.d.m0.f.a0.a$d> g_f = d0.e0.p.d.m0.f.a0.a.d;
        d0.z.d.m.checkNotNullExpressionValue(g_f, "propertySignature");
        d0.e0.p.d.m0.f.a0.a$d a_d = (d0.e0.p.d.m0.f.a0.a$d) d0.e0.p.d.m0.f.z.e.getExtensionOrNull(nVar, g_f);
        if (a_d == null) {
            return null;
        }
        if (z2) {
            e$a jvmFieldSignature = d0.e0.p.d.m0.f.a0.b.h.a.getJvmFieldSignature(nVar, cVar, gVar, z4);
            if (jvmFieldSignature == null) {
                return null;
            }
            return s.a.fromJvmMemberSignature(jvmFieldSignature);
        }
        if (!z3 || !a_d.hasSyntheticMethod()) {
            return null;
        }
        s$a s_a = s.a;
        d0.e0.p.d.m0.f.a0.a$c syntheticMethod = a_d.getSyntheticMethod();
        d0.z.d.m.checkNotNullExpressionValue(syntheticMethod, "signature.syntheticMethod");
        return s_a.fromMethod(cVar, syntheticMethod);
    }

    public final p g(d0.e0.p.d.m0.l.b.y yVar, boolean z2, boolean z3, Boolean bool, boolean z4) {
        y$a outerClass;
        c$c c_c = c$c.INTERFACE;
        if (z2) {
            if (bool == null) {
                throw new IllegalStateException(("isConst should not be null for property (container=" + yVar + ')').toString());
            }
            if (yVar instanceof y$a) {
                y$a y_a = (y$a) yVar;
                if (y_a.getKind() == c_c) {
                    n nVar = this.a;
                    d0.e0.p.d.m0.g.a aVarCreateNestedClassId = y_a.getClassId().createNestedClassId(d0.e0.p.d.m0.g.e.identifier("DefaultImpls"));
                    d0.z.d.m.checkNotNullExpressionValue(aVarCreateNestedClassId, "container.classId.createNestedClassId(Name.identifier(JvmAbi.DEFAULT_IMPLS_CLASS_NAME))");
                    return o.findKotlinClass(nVar, aVarCreateNestedClassId);
                }
            }
            if (bool.booleanValue() && (yVar instanceof y$b)) {
                u0 source = yVar.getSource();
                j jVar = source instanceof j ? (j) source : null;
                d0.e0.p.d.m0.k.y.c facadeClassName = jVar == null ? null : jVar.getFacadeClassName();
                if (facadeClassName != null) {
                    n nVar2 = this.a;
                    String internalName = facadeClassName.getInternalName();
                    d0.z.d.m.checkNotNullExpressionValue(internalName, "facadeClassName.internalName");
                    d0.e0.p.d.m0.g.a aVar = d0.e0.p.d.m0.g.a.topLevel(new d0.e0.p.d.m0.g.b(d0.g0.t.replace$default(internalName, MentionUtilsKt.SLASH_CHAR, '.', false, 4, (Object) null)));
                    d0.z.d.m.checkNotNullExpressionValue(aVar, "topLevel(FqName(facadeClassName.internalName.replace('/', '.')))");
                    return o.findKotlinClass(nVar2, aVar);
                }
            }
        }
        if (z3 && (yVar instanceof y$a)) {
            y$a y_a2 = (y$a) yVar;
            if (y_a2.getKind() == c$c.COMPANION_OBJECT && (outerClass = y_a2.getOuterClass()) != null && (outerClass.getKind() == c$c.CLASS || outerClass.getKind() == c$c.ENUM_CLASS || (z4 && (outerClass.getKind() == c_c || outerClass.getKind() == c$c.ANNOTATION_CLASS)))) {
                return j(outerClass);
            }
        }
        if (!(yVar instanceof y$b) || !(yVar.getSource() instanceof j)) {
            return null;
        }
        u0 source2 = yVar.getSource();
        Objects.requireNonNull(source2, "null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
        j jVar2 = (j) source2;
        p knownJvmBinaryClass = jVar2.getKnownJvmBinaryClass();
        return knownJvmBinaryClass == null ? o.findKotlinClass(this.a, jVar2.getClassId()) : knownJvmBinaryClass;
    }

    public abstract p$a h(d0.e0.p.d.m0.g.a aVar, u0 u0Var, List<A> list);

    public final List<A> i(d0.e0.p.d.m0.l.b.y yVar, d0.e0.p.d.m0.f.n nVar, a$a a_a) {
        Boolean bool = d0.e0.p.d.m0.f.z.b.f3416z.get(nVar.getFlags());
        d0.z.d.m.checkNotNullExpressionValue(bool, "IS_CONST.get(proto.flags)");
        boolean zBooleanValue = bool.booleanValue();
        d0.e0.p.d.m0.f.a0.b.h hVar = d0.e0.p.d.m0.f.a0.b.h.a;
        boolean zIsMovedFromInterfaceCompanion = d0.e0.p.d.m0.f.a0.b.h.isMovedFromInterfaceCompanion(nVar);
        if (a_a == a$a.PROPERTY) {
            s sVarF = f(this, nVar, yVar.getNameResolver(), yVar.getTypeTable(), false, true, false, 40, null);
            return sVarF == null ? d0.t.n.emptyList() : b(this, yVar, sVarF, true, false, Boolean.valueOf(zBooleanValue), zIsMovedFromInterfaceCompanion, 8, null);
        }
        s sVarF2 = f(this, nVar, yVar.getNameResolver(), yVar.getTypeTable(), true, false, false, 48, null);
        if (sVarF2 == null) {
            return d0.t.n.emptyList();
        }
        return d0.g0.w.contains$default((CharSequence) sVarF2.getSignature(), (CharSequence) "$delegate", false, 2, (Object) null) != (a_a == a$a.DELEGATE_FIELD) ? d0.t.n.emptyList() : a(yVar, sVarF2, true, true, Boolean.valueOf(zBooleanValue), zIsMovedFromInterfaceCompanion);
    }

    public final p j(y$a y_a) {
        u0 source = y_a.getSource();
        r rVar = source instanceof r ? (r) source : null;
        if (rVar == null) {
            return null;
        }
        return rVar.getBinaryClass();
    }

    @Override // d0.e0.p.d.m0.l.b.c
    public List<A> loadCallableAnnotations(d0.e0.p.d.m0.l.b.y yVar, d0.e0.p.d.m0.i.n nVar, d0.e0.p.d.m0.l.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(yVar, "container");
        d0.z.d.m.checkNotNullParameter(nVar, "proto");
        d0.z.d.m.checkNotNullParameter(bVar, "kind");
        if (bVar == d0.e0.p.d.m0.l.b.b.PROPERTY) {
            return i(yVar, (d0.e0.p.d.m0.f.n) nVar, a$a.PROPERTY);
        }
        s sVarD = d(this, nVar, yVar.getNameResolver(), yVar.getTypeTable(), bVar, false, 16, null);
        return sVarD == null ? d0.t.n.emptyList() : b(this, yVar, sVarD, false, false, null, false, 60, null);
    }

    @Override // d0.e0.p.d.m0.l.b.c
    public List<A> loadClassAnnotations(y$a y_a) {
        d0.z.d.m.checkNotNullParameter(y_a, "container");
        p pVarJ = j(y_a);
        if (pVarJ == null) {
            throw new IllegalStateException(d0.z.d.m.stringPlus("Class for loading annotations is not found: ", y_a.debugFqName()).toString());
        }
        ArrayList arrayList = new ArrayList(1);
        a$c a_c = new a$c(this, arrayList);
        d0.z.d.m.checkNotNullParameter(pVarJ, "kotlinClass");
        pVarJ.loadClassAnnotations(a_c, null);
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.l.b.c
    public List<A> loadEnumEntryAnnotations(d0.e0.p.d.m0.l.b.y yVar, d0.e0.p.d.m0.f.g gVar) {
        d0.z.d.m.checkNotNullParameter(yVar, "container");
        d0.z.d.m.checkNotNullParameter(gVar, "proto");
        s$a s_a = s.a;
        String string = yVar.getNameResolver().getString(gVar.getName());
        d0.e0.p.d.m0.f.a0.b.b bVar = d0.e0.p.d.m0.f.a0.b.b.a;
        String strAsString = ((y$a) yVar).getClassId().asString();
        d0.z.d.m.checkNotNullExpressionValue(strAsString, "container as ProtoContainer.Class).classId.asString()");
        return b(this, yVar, s_a.fromFieldNameAndDesc(string, d0.e0.p.d.m0.f.a0.b.b.mapClass(strAsString)), false, false, null, false, 60, null);
    }

    @Override // d0.e0.p.d.m0.l.b.c
    public List<A> loadExtensionReceiverParameterAnnotations(d0.e0.p.d.m0.l.b.y yVar, d0.e0.p.d.m0.i.n nVar, d0.e0.p.d.m0.l.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(yVar, "container");
        d0.z.d.m.checkNotNullParameter(nVar, "proto");
        d0.z.d.m.checkNotNullParameter(bVar, "kind");
        s sVarD = d(this, nVar, yVar.getNameResolver(), yVar.getTypeTable(), bVar, false, 16, null);
        return sVarD != null ? b(this, yVar, s.a.fromMethodSignatureAndParameterIndex(sVarD, 0), false, false, null, false, 60, null) : d0.t.n.emptyList();
    }

    @Override // d0.e0.p.d.m0.l.b.c
    public List<A> loadPropertyBackingFieldAnnotations(d0.e0.p.d.m0.l.b.y yVar, d0.e0.p.d.m0.f.n nVar) {
        d0.z.d.m.checkNotNullParameter(yVar, "container");
        d0.z.d.m.checkNotNullParameter(nVar, "proto");
        return i(yVar, nVar, a$a.BACKING_FIELD);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d0.e0.p.d.m0.l.b.c
    public C loadPropertyConstant(d0.e0.p.d.m0.l.b.y yVar, d0.e0.p.d.m0.f.n nVar, c0 c0Var) {
        C c;
        b0 zVar;
        d0.z.d.m.checkNotNullParameter(yVar, "container");
        d0.z.d.m.checkNotNullParameter(nVar, "proto");
        d0.z.d.m.checkNotNullParameter(c0Var, "expectedType");
        Boolean bool = d0.e0.p.d.m0.f.z.b.f3416z.get(nVar.getFlags());
        d0.e0.p.d.m0.f.a0.b.h hVar = d0.e0.p.d.m0.f.a0.b.h.a;
        p pVarG = g(yVar, true, true, bool, d0.e0.p.d.m0.f.a0.b.h.isMovedFromInterfaceCompanion(nVar));
        if (pVarG == null) {
            pVarG = yVar instanceof y$a ? j((y$a) yVar) : null;
        }
        if (pVarG == null) {
            return null;
        }
        s sVarC = c(nVar, yVar.getNameResolver(), yVar.getTypeTable(), d0.e0.p.d.m0.l.b.b.PROPERTY, pVarG.getClassHeader().getMetadataVersion().isAtLeast(f.a.getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm()));
        if (sVarC == null || (c = ((a$b) ((f$m) this.f3361b).invoke(pVarG)).getPropertyConstants().get(sVarC)) == 0) {
            return null;
        }
        d0.e0.p.d.m0.b.o oVar = d0.e0.p.d.m0.b.o.a;
        if (!d0.e0.p.d.m0.b.o.isUnsignedType(c0Var)) {
            return c;
        }
        C c2 = (C) ((d0.e0.p.d.m0.k.v.g) c);
        d0.z.d.m.checkNotNullParameter(c2, "constant");
        if (c2 instanceof d0.e0.p.d.m0.k.v.d) {
            zVar = new d0.e0.p.d.m0.k.v.x(((d0.e0.p.d.m0.k.v.d) c2).getValue().byteValue());
        } else if (c2 instanceof d0.e0.p.d.m0.k.v.v) {
            zVar = new d0.e0.p.d.m0.k.v.a0(((d0.e0.p.d.m0.k.v.v) c2).getValue().shortValue());
        } else if (c2 instanceof d0.e0.p.d.m0.k.v.m) {
            zVar = new d0.e0.p.d.m0.k.v.y(((d0.e0.p.d.m0.k.v.m) c2).getValue().intValue());
        } else {
            if (!(c2 instanceof d0.e0.p.d.m0.k.v.s)) {
                return c2;
            }
            zVar = new d0.e0.p.d.m0.k.v.z(((d0.e0.p.d.m0.k.v.s) c2).getValue().longValue());
        }
        return (C) zVar;
    }

    @Override // d0.e0.p.d.m0.l.b.c
    public List<A> loadPropertyDelegateFieldAnnotations(d0.e0.p.d.m0.l.b.y yVar, d0.e0.p.d.m0.f.n nVar) {
        d0.z.d.m.checkNotNullParameter(yVar, "container");
        d0.z.d.m.checkNotNullParameter(nVar, "proto");
        return i(yVar, nVar, a$a.DELEGATE_FIELD);
    }

    @Override // d0.e0.p.d.m0.l.b.c
    public List<A> loadTypeAnnotations(d0.e0.p.d.m0.f.q qVar, d0.e0.p.d.m0.f.z.c cVar) {
        d0.z.d.m.checkNotNullParameter(qVar, "proto");
        d0.z.d.m.checkNotNullParameter(cVar, "nameResolver");
        Object extension = qVar.getExtension(d0.e0.p.d.m0.f.a0.a.f);
        d0.z.d.m.checkNotNullExpressionValue(extension, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
        Iterable<d0.e0.p.d.m0.f.b> iterable = (Iterable) extension;
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(iterable, 10));
        for (d0.e0.p.d.m0.f.b bVar : iterable) {
            d0.z.d.m.checkNotNullExpressionValue(bVar, "it");
            d0.z.d.m.checkNotNullParameter(bVar, "proto");
            d0.z.d.m.checkNotNullParameter(cVar, "nameResolver");
            arrayList.add(((c) this).e.deserializeAnnotation(bVar, cVar));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.l.b.c
    public List<A> loadTypeParameterAnnotations(d0.e0.p.d.m0.f.s sVar, d0.e0.p.d.m0.f.z.c cVar) {
        d0.z.d.m.checkNotNullParameter(sVar, "proto");
        d0.z.d.m.checkNotNullParameter(cVar, "nameResolver");
        Object extension = sVar.getExtension(d0.e0.p.d.m0.f.a0.a.h);
        d0.z.d.m.checkNotNullExpressionValue(extension, "proto.getExtension(JvmProtoBuf.typeParameterAnnotation)");
        Iterable<d0.e0.p.d.m0.f.b> iterable = (Iterable) extension;
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(iterable, 10));
        for (d0.e0.p.d.m0.f.b bVar : iterable) {
            d0.z.d.m.checkNotNullExpressionValue(bVar, "it");
            d0.z.d.m.checkNotNullParameter(bVar, "proto");
            d0.z.d.m.checkNotNullParameter(cVar, "nameResolver");
            arrayList.add(((c) this).e.deserializeAnnotation(bVar, cVar));
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x005c  */
    @Override // d0.e0.p.d.m0.l.b.c
    public List<A> loadValueParameterAnnotations(d0.e0.p.d.m0.l.b.y yVar, d0.e0.p.d.m0.i.n nVar, d0.e0.p.d.m0.l.b.b bVar, int i, d0.e0.p.d.m0.f.u uVar) {
        d0.z.d.m.checkNotNullParameter(yVar, "container");
        d0.z.d.m.checkNotNullParameter(nVar, "callableProto");
        d0.z.d.m.checkNotNullParameter(bVar, "kind");
        d0.z.d.m.checkNotNullParameter(uVar, "proto");
        s sVarD = d(this, nVar, yVar.getNameResolver(), yVar.getTypeTable(), bVar, false, 16, null);
        if (sVarD == null) {
            return d0.t.n.emptyList();
        }
        int i2 = 1;
        if (nVar instanceof d0.e0.p.d.m0.f.i) {
            if (!d0.e0.p.d.m0.f.z.f.hasReceiver((d0.e0.p.d.m0.f.i) nVar)) {
                i2 = 0;
            }
        } else if (nVar instanceof d0.e0.p.d.m0.f.n) {
            if (!d0.e0.p.d.m0.f.z.f.hasReceiver((d0.e0.p.d.m0.f.n) nVar)) {
                i2 = 0;
            }
        } else {
            if (!(nVar instanceof d0.e0.p.d.m0.f.d)) {
                throw new UnsupportedOperationException(d0.z.d.m.stringPlus("Unsupported message: ", nVar.getClass()));
            }
            y$a y_a = (y$a) yVar;
            if (y_a.getKind() == c$c.ENUM_CLASS) {
                i2 = 2;
            } else if (!y_a.isInner()) {
                i2 = 0;
            }
        }
        return b(this, yVar, s.a.fromMethodSignatureAndParameterIndex(sVarD, i + i2), false, false, null, false, 60, null);
    }
}
