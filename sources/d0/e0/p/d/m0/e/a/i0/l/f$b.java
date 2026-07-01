package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.c.d0$b;
import d0.e0.p.d.m0.c.x0;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.e.a.a0;
import d0.e0.p.d.m0.e.a.k0.x;
import d0.e0.p.d.m0.k.v.w;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.d0;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.u0;
import d0.e0.p.d.m0.n.y0;
import d0.t.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: LazyJavaClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f$b extends d0.e0.p.d.m0.n.b {
    public final d0.e0.p.d.m0.m.j<List<z0>> c;
    public final /* synthetic */ f d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f$b(f fVar) {
        super(f.access$getC$p(fVar).getStorageManager());
        d0.z.d.m.checkNotNullParameter(fVar, "this$0");
        this.d = fVar;
        this.c = f.access$getC$p(fVar).getStorageManager().createLazyValue(new f$b$a(fVar));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0057  */
    /* JADX WARN: Code duplicated, block: B:29:0x0076  */
    /* JADX WARN: Code duplicated, block: B:34:0x0089  */
    /* JADX WARN: Code duplicated, block: B:57:0x0135  */
    /* JADX WARN: Code duplicated, block: B:59:0x0164  */
    /* JADX WARN: Code duplicated, block: B:62:0x0188  */
    /* JADX WARN: Code duplicated, block: B:65:0x0191  */
    /* JADX WARN: Code duplicated, block: B:66:0x0193  */
    /* JADX WARN: Code duplicated, block: B:76:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:79:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:82:0x01f5 A[LOOP:1: B:80:0x01ef->B:82:0x01f5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:86:0x020f  */
    /* JADX WARN: Code duplicated, block: B:87:0x0214  */
    @Override // d0.e0.p.d.m0.n.g
    public Collection<c0> a() {
        d0.e0.p.d.m0.g.b bVar;
        d0.e0.p.d.m0.g.b purelyImplementedInterface;
        ArrayList arrayList;
        j0 j0VarSimpleNotNullType;
        ArrayList arrayList2;
        Iterator it;
        c0 c0VarTransformJavaType;
        u0 constructor;
        u0 constructor2;
        j1 j1Var = j1.INVARIANT;
        Collection<d0.e0.p.d.m0.e.a.k0.j> supertypes = this.d.getJClass().getSupertypes();
        ArrayList arrayList3 = new ArrayList(supertypes.size());
        ArrayList arrayList4 = new ArrayList(0);
        d0.e0.p.d.m0.c.g1.g annotations = this.d.getAnnotations();
        d0.e0.p.d.m0.g.b bVar2 = a0.n;
        d0.z.d.m.checkNotNullExpressionValue(bVar2, "PURELY_IMPLEMENTS_ANNOTATION");
        d0.e0.p.d.m0.c.g1.c cVarFindAnnotation = annotations.findAnnotation(bVar2);
        if (cVarFindAnnotation == null) {
            bVar = null;
        } else {
            Object objSingleOrNull = u.singleOrNull(cVarFindAnnotation.getAllValueArguments().values());
            w wVar = objSingleOrNull instanceof w ? (w) objSingleOrNull : null;
            String value = wVar == null ? null : wVar.getValue();
            if (value != null && d0.e0.p.d.m0.g.d.isValidJavaFqName(value)) {
                bVar = new d0.e0.p.d.m0.g.b(value);
            } else {
                bVar = null;
            }
        }
        if (bVar == null) {
            bVar = null;
        } else if (!(!bVar.isRoot() && bVar.startsWith(d0.e0.p.d.m0.b.k.k))) {
            bVar = null;
        }
        if (bVar == null) {
            purelyImplementedInterface = d0.e0.p.d.m0.e.a.q.a.getPurelyImplementedInterface(d0.e0.p.d.m0.k.x.a.getFqNameSafe(this.d));
            if (purelyImplementedInterface == null) {
                j0VarSimpleNotNullType = null;
            }
            for (d0.e0.p.d.m0.e.a.k0.j jVar : supertypes) {
                c0VarTransformJavaType = f.access$getC$p(this.d).getTypeResolver().transformJavaType(jVar, d0.e0.p.d.m0.e.a.i0.m.e.toAttributes$default(d0.e0.p.d.m0.e.a.g0.k.SUPERTYPE, false, null, 3, null));
                if (f.access$getC$p(this.d).getComponents().getSettings().getTypeEnhancementImprovements()) {
                    c0VarTransformJavaType = f.access$getC$p(this.d).getComponents().getSignatureEnhancement().enhanceSuperType(c0VarTransformJavaType, f.access$getC$p(this.d));
                }
                if (c0VarTransformJavaType.getConstructor().getDeclarationDescriptor() instanceof d0$b) {
                    arrayList4.add(jVar);
                }
                constructor = c0VarTransformJavaType.getConstructor();
                if (j0VarSimpleNotNullType == null) {
                    constructor2 = null;
                } else {
                    constructor2 = j0VarSimpleNotNullType.getConstructor();
                }
                if (!d0.z.d.m.areEqual(constructor, constructor2) && !d0.e0.p.d.m0.b.h.isAnyOrNullableAny(c0VarTransformJavaType)) {
                    arrayList3.add(c0VarTransformJavaType);
                }
            }
            d0.e0.p.d.m0.c.e eVarAccess$getAdditionalSupertypeClassDescriptor$p = f.access$getAdditionalSupertypeClassDescriptor$p(this.d);
            d0.e0.p.d.m0.p.a.addIfNotNull(arrayList3, eVarAccess$getAdditionalSupertypeClassDescriptor$p != null ? d0.e0.p.d.m0.b.q.q.createMappedTypeParametersSubstitution(eVarAccess$getAdditionalSupertypeClassDescriptor$p, this.d).buildSubstitutor().substitute(eVarAccess$getAdditionalSupertypeClassDescriptor$p.getDefaultType(), j1Var) : null);
            d0.e0.p.d.m0.p.a.addIfNotNull(arrayList3, j0VarSimpleNotNullType);
            if (!arrayList4.isEmpty()) {
                d0.e0.p.d.m0.l.b.p errorReporter = f.access$getC$p(this.d).getComponents().getErrorReporter();
                d0.e0.p.d.m0.c.e declarationDescriptor = getDeclarationDescriptor();
                arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList4, 10));
                it = arrayList4.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((d0.e0.p.d.m0.e.a.k0.j) ((x) it.next())).getPresentableText());
                }
                errorReporter.reportIncompleteHierarchy(declarationDescriptor, arrayList2);
            }
            return arrayList3.isEmpty() ^ true ? u.toList(arrayList3) : d0.t.m.listOf(f.access$getC$p(this.d).getModule().getBuiltIns().getAnyType());
        }
        purelyImplementedInterface = bVar;
        d0.e0.p.d.m0.c.e eVarResolveTopLevelClass = d0.e0.p.d.m0.k.x.a.resolveTopLevelClass(f.access$getC$p(this.d).getModule(), purelyImplementedInterface, d0.e0.p.d.m0.d.b.d.FROM_JAVA_LOADER);
        if (eVarResolveTopLevelClass == null) {
            j0VarSimpleNotNullType = null;
        } else {
            int size = eVarResolveTopLevelClass.getTypeConstructor().getParameters().size();
            List<z0> parameters = this.d.getTypeConstructor().getParameters();
            d0.z.d.m.checkNotNullExpressionValue(parameters, "getTypeConstructor().parameters");
            int size2 = parameters.size();
            if (size2 == size) {
                arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(parameters, 10));
                Iterator<T> it2 = parameters.iterator();
                while (it2.hasNext()) {
                    arrayList.add(new y0(j1Var, ((z0) it2.next()).getDefaultType()));
                }
            } else if (size2 == 1 && size > 1 && bVar == null) {
                y0 y0Var = new y0(j1Var, ((z0) u.single((List) parameters)).getDefaultType());
                IntRange intRange = new IntRange(1, size);
                ArrayList arrayList5 = new ArrayList(d0.t.o.collectionSizeOrDefault(intRange, 10));
                Iterator<Integer> it3 = intRange.iterator();
                while (it3.hasNext()) {
                    ((d0.t.c0) it3).nextInt();
                    arrayList5.add(y0Var);
                }
                arrayList = arrayList5;
            } else {
                j0VarSimpleNotNullType = null;
            }
            d0 d0Var = d0.a;
            j0VarSimpleNotNullType = d0.simpleNotNullType(d0.e0.p.d.m0.c.g1.g.f.getEMPTY(), eVarResolveTopLevelClass, arrayList);
        }
        while (r1.hasNext()) {
            c0VarTransformJavaType = f.access$getC$p(this.d).getTypeResolver().transformJavaType(jVar, d0.e0.p.d.m0.e.a.i0.m.e.toAttributes$default(d0.e0.p.d.m0.e.a.g0.k.SUPERTYPE, false, null, 3, null));
            if (f.access$getC$p(this.d).getComponents().getSettings().getTypeEnhancementImprovements()) {
                c0VarTransformJavaType = f.access$getC$p(this.d).getComponents().getSignatureEnhancement().enhanceSuperType(c0VarTransformJavaType, f.access$getC$p(this.d));
            }
            if (c0VarTransformJavaType.getConstructor().getDeclarationDescriptor() instanceof d0$b) {
                arrayList4.add(jVar);
            }
            constructor = c0VarTransformJavaType.getConstructor();
            if (j0VarSimpleNotNullType == null) {
                constructor2 = null;
            } else {
                constructor2 = j0VarSimpleNotNullType.getConstructor();
            }
            if (!d0.z.d.m.areEqual(constructor, constructor2)) {
                arrayList3.add(c0VarTransformJavaType);
            }
        }
        d0.e0.p.d.m0.c.e eVarAccess$getAdditionalSupertypeClassDescriptor$p2 = f.access$getAdditionalSupertypeClassDescriptor$p(this.d);
        d0.e0.p.d.m0.p.a.addIfNotNull(arrayList3, eVarAccess$getAdditionalSupertypeClassDescriptor$p2 != null ? d0.e0.p.d.m0.b.q.q.createMappedTypeParametersSubstitution(eVarAccess$getAdditionalSupertypeClassDescriptor$p2, this.d).buildSubstitutor().substitute(eVarAccess$getAdditionalSupertypeClassDescriptor$p2.getDefaultType(), j1Var) : null);
        d0.e0.p.d.m0.p.a.addIfNotNull(arrayList3, j0VarSimpleNotNullType);
        if (!arrayList4.isEmpty()) {
            d0.e0.p.d.m0.l.b.p errorReporter2 = f.access$getC$p(this.d).getComponents().getErrorReporter();
            d0.e0.p.d.m0.c.e declarationDescriptor2 = getDeclarationDescriptor();
            arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList4, 10));
            it = arrayList4.iterator();
            while (it.hasNext()) {
                arrayList2.add(((d0.e0.p.d.m0.e.a.k0.j) ((x) it.next())).getPresentableText());
            }
            errorReporter2.reportIncompleteHierarchy(declarationDescriptor2, arrayList2);
        }
        if (arrayList3.isEmpty() ^ true) {
        }
    }

    @Override // d0.e0.p.d.m0.n.g
    public x0 d() {
        return f.access$getC$p(this.d).getComponents().getSupertypeLoopChecker();
    }

    @Override // d0.e0.p.d.m0.n.g, d0.e0.p.d.m0.n.u0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.h getDeclarationDescriptor() {
        return getDeclarationDescriptor();
    }

    @Override // d0.e0.p.d.m0.n.u0
    public List<z0> getParameters() {
        return this.c.invoke();
    }

    @Override // d0.e0.p.d.m0.n.u0
    public boolean isDenotable() {
        return true;
    }

    public String toString() {
        String strAsString = this.d.getName().asString();
        d0.z.d.m.checkNotNullExpressionValue(strAsString, "name.asString()");
        return strAsString;
    }

    @Override // d0.e0.p.d.m0.n.b, d0.e0.p.d.m0.n.g, d0.e0.p.d.m0.n.u0
    public d0.e0.p.d.m0.c.e getDeclarationDescriptor() {
        return this.d;
    }
}
