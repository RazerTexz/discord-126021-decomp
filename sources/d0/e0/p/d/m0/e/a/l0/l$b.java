package d0.e0.p.d.m0.e.a.l0;

import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.e.a.b0;
import d0.e0.p.d.m0.e.a.c$a;
import d0.e0.p.d.m0.e.a.y;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.e0;
import d0.e0.p.d.m0.n.e1;
import d0.e0.p.d.m0.n.g1;
import d0.e0.p.d.m0.n.w0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: signatureEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l$b {
    public final d0.e0.p.d.m0.c.g1.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f3350b;
    public final Collection<c0> c;
    public final boolean d;
    public final d0.e0.p.d.m0.e.a.i0.g e;
    public final d0.e0.p.d.m0.e.a.a f;
    public final boolean g;
    public final /* synthetic */ l h;

    /* JADX WARN: Multi-variable type inference failed */
    public l$b(l lVar, d0.e0.p.d.m0.c.g1.a aVar, c0 c0Var, Collection<? extends c0> collection, boolean z2, d0.e0.p.d.m0.e.a.i0.g gVar, d0.e0.p.d.m0.e.a.a aVar2, boolean z3) {
        d0.z.d.m.checkNotNullParameter(lVar, "this$0");
        d0.z.d.m.checkNotNullParameter(c0Var, "fromOverride");
        d0.z.d.m.checkNotNullParameter(collection, "fromOverridden");
        d0.z.d.m.checkNotNullParameter(gVar, "containerContext");
        d0.z.d.m.checkNotNullParameter(aVar2, "containerApplicabilityType");
        this.h = lVar;
        this.a = aVar;
        this.f3350b = c0Var;
        this.c = collection;
        this.d = z2;
        this.e = gVar;
        this.f = aVar2;
        this.g = z3;
    }

    public static final <T> T c(List<d0.e0.p.d.m0.g.b> list, d0.e0.p.d.m0.c.g1.g gVar, T t) {
        boolean z2 = false;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (gVar.findAnnotation((d0.e0.p.d.m0.g.b) it.next()) != null) {
                    z2 = true;
                    break;
                }
            }
        }
        if (z2) {
            return t;
        }
        return null;
    }

    public static final void d(l$b l_b, ArrayList<s> arrayList, c0 c0Var, d0.e0.p.d.m0.e.a.i0.g gVar, z0 z0Var) {
        d0.e0.p.d.m0.e.a.i0.g gVarCopyWithNewDefaultTypeQualifiers = d0.e0.p.d.m0.e.a.i0.a.copyWithNewDefaultTypeQualifiers(gVar, c0Var.getAnnotations());
        y defaultTypeQualifiers = gVarCopyWithNewDefaultTypeQualifiers.getDefaultTypeQualifiers();
        d0.e0.p.d.m0.e.a.u uVar = defaultTypeQualifiers == null ? null : defaultTypeQualifiers.get(l_b.g ? d0.e0.p.d.m0.e.a.a.TYPE_PARAMETER_BOUNDS : d0.e0.p.d.m0.e.a.a.TYPE_USE);
        arrayList.add(new s(c0Var, uVar, z0Var, false));
        List<w0> arguments = c0Var.getArguments();
        List<z0> parameters = c0Var.getConstructor().getParameters();
        d0.z.d.m.checkNotNullExpressionValue(parameters, "type.constructor.parameters");
        for (Pair pair : d0.t.u.zip(arguments, parameters)) {
            w0 w0Var = (w0) pair.component1();
            z0 z0Var2 = (z0) pair.component2();
            if (w0Var.isStarProjection()) {
                c0 type = w0Var.getType();
                d0.z.d.m.checkNotNullExpressionValue(type, "arg.type");
                arrayList.add(new s(type, uVar, z0Var2, true));
            } else {
                c0 type2 = w0Var.getType();
                d0.z.d.m.checkNotNullExpressionValue(type2, "arg.type");
                d(l_b, arrayList, type2, gVarCopyWithNewDefaultTypeQualifiers, z0Var2);
            }
        }
    }

    public static /* synthetic */ l$a enhance$default(l$b l_b, w wVar, int i, Object obj) {
        if ((i & 1) != 0) {
            wVar = null;
        }
        return l_b.enhance(wVar);
    }

    public final h a(z0 z0Var) {
        boolean z2;
        boolean z3;
        if (!(z0Var instanceof d0.e0.p.d.m0.e.a.i0.l.s)) {
            return null;
        }
        d0.e0.p.d.m0.e.a.i0.l.s sVar = (d0.e0.p.d.m0.e.a.i0.l.s) z0Var;
        List<c0> upperBounds = sVar.getUpperBounds();
        d0.z.d.m.checkNotNullExpressionValue(upperBounds, "upperBounds");
        boolean z4 = false;
        if (!(upperBounds instanceof Collection) || !upperBounds.isEmpty()) {
            Iterator<T> it = upperBounds.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = true;
                    break;
                }
                if (!e0.isError((c0) it.next())) {
                    z2 = false;
                    break;
                }
            }
        } else {
            z2 = true;
            break;
        }
        if (z2) {
            return null;
        }
        List<c0> upperBounds2 = sVar.getUpperBounds();
        d0.z.d.m.checkNotNullExpressionValue(upperBounds2, "upperBounds");
        if (!(upperBounds2 instanceof Collection) || !upperBounds2.isEmpty()) {
            Iterator<T> it2 = upperBounds2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z3 = true;
                    break;
                }
                if (!r.access$isNullabilityFlexible((c0) it2.next())) {
                    z3 = false;
                    break;
                }
            }
        } else {
            z3 = true;
            break;
        }
        if (z3) {
            return null;
        }
        List<c0> upperBounds3 = sVar.getUpperBounds();
        d0.z.d.m.checkNotNullExpressionValue(upperBounds3, "upperBounds");
        if (!(upperBounds3 instanceof Collection) || !upperBounds3.isEmpty()) {
            for (c0 c0Var : upperBounds3) {
                d0.z.d.m.checkNotNullExpressionValue(c0Var, "it");
                if (!e0.isNullable(c0Var)) {
                    z4 = true;
                    break;
                }
            }
        }
        return z4 ? h.NOT_NULL : h.NULLABLE;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0048  */
    /* JADX WARN: Code duplicated, block: B:17:0x004b  */
    /* JADX WARN: Code duplicated, block: B:19:0x0051  */
    /* JADX WARN: Code duplicated, block: B:20:0x0054  */
    public final e b(c0 c0Var) {
        Pair pair;
        h hVar;
        h hVar2;
        f fVar;
        if (d0.e0.p.d.m0.n.y.isFlexible(c0Var)) {
            d0.e0.p.d.m0.n.v vVarAsFlexibleType = d0.e0.p.d.m0.n.y.asFlexibleType(c0Var);
            pair = new Pair(vVarAsFlexibleType.getLowerBound(), vVarAsFlexibleType.getUpperBound());
        } else {
            pair = new Pair(c0Var, c0Var);
        }
        c0 c0Var2 = (c0) pair.component1();
        c0 c0Var3 = (c0) pair.component2();
        d0.e0.p.d.m0.b.q.d dVar = d0.e0.p.d.m0.b.q.d.a;
        if (!c0Var2.isMarkedNullable()) {
            if (c0Var3.isMarkedNullable()) {
                hVar = null;
            } else {
                hVar2 = h.NOT_NULL;
            }
            if (dVar.isReadOnly(c0Var2)) {
                fVar = f.READ_ONLY;
            } else if (dVar.isMutable(c0Var3)) {
                fVar = f.MUTABLE;
            } else {
                fVar = null;
            }
            return new e(hVar, fVar, c0Var.unwrap() instanceof g, false, 8, null);
        }
        hVar2 = h.NULLABLE;
        hVar = hVar2;
        if (dVar.isReadOnly(c0Var2)) {
            fVar = f.READ_ONLY;
        } else if (dVar.isMutable(c0Var3)) {
            fVar = f.MUTABLE;
        } else {
            fVar = null;
        }
        return new e(hVar, fVar, c0Var.unwrap() instanceof g, false, 8, null);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0227  */
    /* JADX WARN: Code duplicated, block: B:107:0x0236  */
    /* JADX WARN: Code duplicated, block: B:110:0x023a  */
    /* JADX WARN: Code duplicated, block: B:113:0x0247  */
    /* JADX WARN: Code duplicated, block: B:114:0x024a  */
    /* JADX WARN: Code duplicated, block: B:116:0x024d  */
    /* JADX WARN: Code duplicated, block: B:117:0x024f  */
    /* JADX WARN: Code duplicated, block: B:119:0x0255  */
    /* JADX WARN: Code duplicated, block: B:120:0x0264  */
    /* JADX WARN: Code duplicated, block: B:122:0x0276  */
    /* JADX WARN: Code duplicated, block: B:123:0x0278  */
    /* JADX WARN: Code duplicated, block: B:128:0x029f  */
    /* JADX WARN: Code duplicated, block: B:136:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:138:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:139:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:143:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:146:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:147:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:149:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:150:0x02df A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:151:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:152:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:155:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:157:0x02fa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:158:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:159:0x02fe A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:161:0x0304  */
    /* JADX WARN: Code duplicated, block: B:163:0x030a  */
    /* JADX WARN: Code duplicated, block: B:165:0x030e  */
    /* JADX WARN: Code duplicated, block: B:168:0x0315  */
    /* JADX WARN: Code duplicated, block: B:169:0x0317 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:170:0x0319  */
    /* JADX WARN: Code duplicated, block: B:171:0x031b  */
    /* JADX WARN: Code duplicated, block: B:175:0x032c  */
    /* JADX WARN: Code duplicated, block: B:176:0x032e  */
    /* JADX WARN: Code duplicated, block: B:179:0x0333  */
    /* JADX WARN: Code duplicated, block: B:180:0x0335  */
    /* JADX WARN: Code duplicated, block: B:188:0x035a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:190:0x035d  */
    /* JADX WARN: Code duplicated, block: B:196:0x036a  */
    /* JADX WARN: Code duplicated, block: B:198:0x036d  */
    /* JADX WARN: Code duplicated, block: B:199:0x036f  */
    /* JADX WARN: Code duplicated, block: B:202:0x0388  */
    /* JADX WARN: Code duplicated, block: B:203:0x038a  */
    /* JADX WARN: Code duplicated, block: B:205:0x038d  */
    /* JADX WARN: Code duplicated, block: B:206:0x038f  */
    /* JADX WARN: Code duplicated, block: B:211:0x03a1  */
    /* JADX WARN: Code duplicated, block: B:215:0x03ab  */
    /* JADX WARN: Code duplicated, block: B:217:0x03b1  */
    /* JADX WARN: Code duplicated, block: B:220:0x03b6  */
    /* JADX WARN: Code duplicated, block: B:221:0x03b8  */
    /* JADX WARN: Code duplicated, block: B:223:0x03be  */
    /* JADX WARN: Code duplicated, block: B:224:0x03c0  */
    /* JADX WARN: Code duplicated, block: B:229:0x03c9  */
    /* JADX WARN: Code duplicated, block: B:22:0x0070  */
    /* JADX WARN: Code duplicated, block: B:232:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:235:0x03dc  */
    /* JADX WARN: Code duplicated, block: B:238:0x03e5  */
    /* JADX WARN: Code duplicated, block: B:239:0x03e7  */
    /* JADX WARN: Code duplicated, block: B:243:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:246:0x03f7  */
    /* JADX WARN: Code duplicated, block: B:249:0x0401  */
    /* JADX WARN: Code duplicated, block: B:252:0x040f A[EDGE_INSN: B:252:0x040f->B:253:0x0410 BREAK  A[LOOP:9: B:247:0x03fb->B:307:?]] */
    /* JADX WARN: Code duplicated, block: B:255:0x0413  */
    /* JADX WARN: Code duplicated, block: B:256:0x0415  */
    /* JADX WARN: Code duplicated, block: B:258:0x0418 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:260:0x0424 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:261:0x0426  */
    /* JADX WARN: Code duplicated, block: B:262:0x0428  */
    /* JADX WARN: Code duplicated, block: B:303:0x02ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:305:0x040f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:306:0x040d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:307:? A[LOOP:9: B:247:0x03fb->B:307:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x0211  */
    /* JADX WARN: Code duplicated, block: B:96:0x0219  */
    /* JADX WARN: Code duplicated, block: B:97:0x021b  */
    /* JADX WARN: Code duplicated, block: B:98:0x0222  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18, types: [d0.e0.p.d.m0.e.a.l0.e] */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v49 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r4v4, types: [d0.e0.p.d.m0.e.a.l0.d] */
    /* JADX WARN: Type inference failed for: r6v3, types: [d0.e0.p.d.m0.e.a.l0.l$a] */
    /* JADX WARN: Type inference failed for: r6v44 */
    /* JADX WARN: Type inference failed for: r6v5 */
    public final l$a enhance(w wVar) {
        Object obj;
        boolean z2;
        l$a l_a;
        ?? r6;
        d0.e0.p.d.m0.e.a.u uVar;
        d0.e0.p.d.m0.c.g1.g annotations;
        d0.e0.p.d.m0.c.g1.a aVar;
        d0.e0.p.d.m0.e.a.u uVar2;
        d0.e0.p.d.m0.c.h declarationDescriptor;
        z0 z0Var;
        h hVarA;
        boolean z3;
        Pair pair;
        i iVar;
        boolean zBooleanValue;
        boolean z4;
        l lVar;
        Iterator<d0.e0.p.d.m0.c.g1.c> it;
        i iVarExtractNullability;
        i iVar2;
        h hVar;
        i iVar3;
        Object objValueOf;
        boolean z5;
        e eVar;
        h qualifier;
        Object objC;
        Object objC2;
        boolean z6;
        Object objValueOf2;
        ?? r1;
        h nullability;
        h nullability2;
        boolean z7;
        h hVarSelect;
        f fVar;
        Set set;
        boolean z8;
        boolean z9;
        boolean z10;
        e eVarCreateJavaTypeQualifiers;
        boolean z11;
        Iterator it2;
        Object obj2;
        c1 c1Var;
        Object varargElementType;
        boolean z12;
        boolean z13;
        h hVarA2;
        h qualifier2;
        h hVar2;
        i nullabilityQualifier;
        boolean z14;
        y defaultTypeQualifiers;
        boolean z15;
        Collection<c0> collection = this.c;
        int i = 10;
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(collection, 10));
        Iterator it3 = collection.iterator();
        while (true) {
            obj = null;
            if (!it3.hasNext()) {
                break;
            }
            c0 c0Var = (c0) it3.next();
            ArrayList arrayList2 = new ArrayList(1);
            d(this, arrayList2, c0Var, this.e, null);
            arrayList.add(arrayList2);
        }
        c0 c0Var2 = this.f3350b;
        ArrayList arrayList3 = new ArrayList(1);
        d(this, arrayList3, c0Var2, this.e, null);
        if (this.d) {
            Collection<c0> collection2 = this.c;
            if (!(collection2 instanceof Collection) || !collection2.isEmpty()) {
                Iterator it4 = collection2.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        z15 = false;
                        break;
                    }
                    if (!d0.e0.p.d.m0.n.l1.f.a.equalTypes((c0) it4.next(), this.f3350b)) {
                        z15 = true;
                        break;
                    }
                }
            } else {
                z15 = false;
                break;
            }
            if (z15) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        int size = z2 ? 1 : arrayList3.size();
        e[] eVarArr = new e[size];
        int i2 = 0;
        while (i2 < size) {
            boolean z16 = i2 == 0;
            s sVar = (s) arrayList3.get(i2);
            c0 c0VarComponent1 = sVar.component1();
            d0.e0.p.d.m0.e.a.u uVarComponent2 = sVar.component2();
            z0 z0VarComponent3 = sVar.component3();
            boolean zComponent4 = sVar.component4();
            ArrayList arrayList4 = new ArrayList();
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                s sVar2 = (s) d0.t.u.getOrNull((List) it5.next(), i2);
                Object type = sVar2 == null ? obj : sVar2.getType();
                if (type != null) {
                    arrayList4.add(type);
                }
            }
            h hVar3 = h.NULLABLE;
            int i3 = size;
            ArrayList arrayList5 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList4, i));
            Iterator it6 = arrayList4.iterator();
            while (it6.hasNext()) {
                arrayList5.add(b((c0) it6.next()));
            }
            ArrayList arrayList6 = new ArrayList();
            Iterator it7 = arrayList5.iterator();
            while (it7.hasNext()) {
                ArrayList arrayList7 = arrayList;
                f mutability = ((e) it7.next()).getMutability();
                if (mutability != null) {
                    arrayList6.add(mutability);
                }
                arrayList = arrayList7;
            }
            ArrayList arrayList8 = arrayList;
            Set set2 = d0.t.u.toSet(arrayList6);
            ArrayList arrayList9 = new ArrayList();
            Iterator it8 = arrayList5.iterator();
            while (it8.hasNext()) {
                Iterator it9 = it8;
                h nullability3 = ((e) it8.next()).getNullability();
                if (nullability3 != null) {
                    arrayList9.add(nullability3);
                }
                it8 = it9;
            }
            Set set3 = d0.t.u.toSet(arrayList9);
            ArrayList arrayList10 = new ArrayList();
            Iterator it10 = arrayList4.iterator();
            while (it10.hasNext()) {
                ArrayList arrayList11 = arrayList3;
                h nullability4 = b(g1.unwrapEnhancement((c0) it10.next())).getNullability();
                if (nullability4 != null) {
                    arrayList10.add(nullability4);
                }
                arrayList3 = arrayList11;
            }
            ArrayList arrayList12 = arrayList3;
            Set set4 = d0.t.u.toSet(arrayList10);
            h hVar4 = h.NOT_NULL;
            boolean typeEnhancementImprovements = this.e.getComponents().getSettings().getTypeEnhancementImprovements();
            if (z16) {
                uVar = uVarComponent2;
                d0.e0.p.d.m0.c.g1.a aVar2 = this.a;
                if (aVar2 != null && !(aVar2 instanceof z0) && typeEnhancementImprovements) {
                    d0.e0.p.d.m0.c.g1.g annotations2 = aVar2.getAnnotations();
                    l lVar2 = this.h;
                    eVarArr = eVarArr;
                    ArrayList arrayList13 = new ArrayList();
                    Iterator<d0.e0.p.d.m0.c.g1.c> it11 = annotations2.iterator();
                    while (it11.hasNext()) {
                        int i4 = i2;
                        d0.e0.p.d.m0.c.g1.c next = it11.next();
                        Iterator<d0.e0.p.d.m0.c.g1.c> it12 = it11;
                        ArrayList arrayList14 = arrayList5;
                        c$a c_aResolveAnnotation = l.access$getAnnotationTypeQualifierResolver$p(lVar2).resolveAnnotation(next);
                        if ((c_aResolveAnnotation == null || c_aResolveAnnotation.component2().contains(d0.e0.p.d.m0.e.a.a.TYPE_USE)) ? false : true) {
                            arrayList13.add(next);
                        }
                        i2 = i4;
                        it11 = it12;
                        arrayList5 = arrayList14;
                    }
                    arrayList5 = arrayList5;
                    i2 = i2;
                    annotations = d0.e0.p.d.m0.c.g1.i.composeAnnotations(d0.e0.p.d.m0.c.g1.g.f.create(arrayList13), c0VarComponent1.getAnnotations());
                }
                if (z16) {
                    defaultTypeQualifiers = this.e.getDefaultTypeQualifiers();
                    if (defaultTypeQualifiers == null) {
                        uVar2 = null;
                    } else {
                        uVar2 = defaultTypeQualifiers.get(this.f);
                    }
                } else {
                    uVar2 = uVar;
                }
                if (uVar2 != null) {
                    if (uVar2.getAffectsTypeParameterBasedTypes() && d0.e0.p.d.m0.n.o1.a.isTypeParameter(c0VarComponent1)) {
                        z14 = false;
                    } else {
                        z14 = true;
                    }
                    if (!z14) {
                        uVar2 = null;
                    }
                } else {
                    uVar2 = null;
                }
                declarationDescriptor = c0VarComponent1.getConstructor().getDeclarationDescriptor();
                if (declarationDescriptor instanceof z0) {
                    z0Var = (z0) declarationDescriptor;
                } else {
                    z0Var = null;
                }
                if (z0Var == null) {
                    hVarA = null;
                } else {
                    hVarA = a(z0Var);
                }
                if (hVarA == null) {
                    pair = new Pair(null, Boolean.FALSE);
                } else {
                    i iVar4 = new i(hVar4, false, 2, null);
                    if (hVarA == hVar4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    pair = new Pair(iVar4, Boolean.valueOf(z3));
                }
                iVar = (i) pair.component1();
                zBooleanValue = ((Boolean) pair.component2()).booleanValue();
                z4 = this.g;
                lVar = this.h;
                it = annotations.iterator();
                do {
                    if (it.hasNext()) {
                        iVarExtractNullability = null;
                        break;
                    }
                    iVarExtractNullability = lVar.extractNullability(it.next(), typeEnhancementImprovements, z4);
                } while (iVarExtractNullability == null);
                if (iVarExtractNullability == null && !zComponent4) {
                    iVar2 = iVarExtractNullability;
                } else {
                    iVar2 = null;
                }
                if (iVar2 == null) {
                    if (iVar == null) {
                        if (uVar2 == null && (nullabilityQualifier = uVar2.getNullabilityQualifier()) != null) {
                            iVar = new i(nullabilityQualifier.getQualifier(), nullabilityQualifier.isForWarningOnly());
                        } else {
                            iVar = null;
                        }
                    }
                    if (z0VarComponent3 == null) {
                        hVarA2 = null;
                    } else {
                        hVarA2 = a(z0VarComponent3);
                    }
                    if (hVarA2 == null) {
                        iVar3 = iVar;
                        hVar = null;
                    } else if (iVar == null) {
                        iVar3 = new i(hVarA2, false, 2, null);
                        hVar = null;
                    } else {
                        qualifier2 = iVar.getQualifier();
                        hVar2 = h.FORCE_FLEXIBILITY;
                        if (hVarA2 != hVar2) {
                            hVarA2 = qualifier2;
                        } else if (qualifier2 != hVar2) {
                            if (hVarA2 == hVar3) {
                                hVarA2 = qualifier2;
                            } else if (qualifier2 != hVar3) {
                                hVarA2 = hVar4;
                            }
                        }
                        hVar = null;
                        iVar3 = new i(hVarA2, false, 2, null);
                    }
                } else {
                    hVar = null;
                    iVar3 = iVar2;
                }
                if (iVar2 != null) {
                    if (!zBooleanValue) {
                        if (uVar2 == null) {
                            objValueOf = hVar;
                        } else {
                            objValueOf = Boolean.valueOf(uVar2.getMakesTypeParameterNotNull());
                        }
                        if (d0.z.d.m.areEqual(objValueOf, Boolean.TRUE)) {
                            z5 = false;
                        }
                    }
                    z5 = true;
                } else if (iVar2.getQualifier() == hVar4) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (iVar3 == null) {
                    qualifier = hVar;
                } else {
                    qualifier = iVar3.getQualifier();
                }
                List<d0.e0.p.d.m0.g.b> read_only_annotations = b0.getREAD_ONLY_ANNOTATIONS();
                f fVar2 = f.READ_ONLY;
                objC = c(read_only_annotations, annotations, fVar2);
                List<d0.e0.p.d.m0.g.b> mutable_annotations = b0.getMUTABLE_ANNOTATIONS();
                f fVar3 = f.MUTABLE;
                objC2 = c(mutable_annotations, annotations, fVar3);
                if (objC == null && objC2 != null && !d0.z.d.m.areEqual(objC, objC2)) {
                    objC2 = hVar;
                } else if (objC != null) {
                    objC2 = objC;
                }
                f fVar4 = (f) objC2;
                if (z5 || !d0.e0.p.d.m0.n.o1.a.isTypeParameter(c0VarComponent1)) {
                    z6 = false;
                } else {
                    z6 = true;
                }
                if (iVar3 == null) {
                    objValueOf2 = hVar;
                } else {
                    objValueOf2 = Boolean.valueOf(iVar3.isForWarningOnly());
                }
                eVar = new e(qualifier, fVar4, z6, d0.z.d.m.areEqual(objValueOf2, Boolean.TRUE));
                if (!eVar.isNullabilityQualifierForWarning()) {
                    r1 = eVar;
                } else {
                    r1 = hVar;
                }
                if (r1 == 0) {
                    nullability = hVar;
                } else {
                    nullability = r1.getNullability();
                }
                nullability2 = eVar.getNullability();
                if (this.d || !z16) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                hVarSelect = v.select(set3, nullability, z7);
                if (hVarSelect == null) {
                    hVarSelect = hVar;
                } else {
                    obj2 = this.a;
                    if (!(obj2 instanceof c1)) {
                        obj2 = hVar;
                    }
                    c1Var = (c1) obj2;
                    if (c1Var == null) {
                        varargElementType = hVar;
                    } else {
                        varargElementType = c1Var.getVarargElementType();
                    }
                    if (varargElementType != null) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (!z12 && z16 && hVarSelect == hVar3) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    if (z13) {
                        hVarSelect = hVar;
                    }
                }
                fVar = (f) v.select(set2, fVar3, fVar2, eVar.getMutability(), z7);
                if (nullability2 == nullability) {
                    set = set4;
                    if (!d0.z.d.m.areEqual(set, set3)) {
                        z8 = false;
                    }
                    if (eVar.isNotNullTypeParameter()) {
                        z9 = true;
                    } else {
                        if (arrayList5.isEmpty()) {
                            it2 = arrayList5.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    z11 = false;
                                    break;
                                }
                                if (((e) it2.next()).isNotNullTypeParameter()) {
                                    z11 = true;
                                    break;
                                }
                            }
                        } else {
                            z11 = false;
                            break;
                        }
                        if (z11) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                    }
                    if (hVarSelect == null || !z8) {
                        if (hVarSelect == null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        eVarCreateJavaTypeQualifiers = v.createJavaTypeQualifiers(hVarSelect, fVar, z10, z9);
                    } else {
                        eVarCreateJavaTypeQualifiers = v.createJavaTypeQualifiers(v.select(set, nullability2, z7), fVar, true, z9);
                    }
                    eVarArr[i2] = eVarCreateJavaTypeQualifiers;
                    i2++;
                    obj = hVar;
                    size = i3;
                    arrayList = arrayList8;
                    arrayList3 = arrayList12;
                    eVarArr = eVarArr;
                    i = 10;
                } else {
                    set = set4;
                }
                z8 = true;
                if (eVar.isNotNullTypeParameter()) {
                    z9 = true;
                } else {
                    if (arrayList5.isEmpty()) {
                        it2 = arrayList5.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                z11 = false;
                                break;
                            }
                            if (((e) it2.next()).isNotNullTypeParameter()) {
                                z11 = true;
                                break;
                            }
                        }
                    } else {
                        z11 = false;
                        break;
                    }
                    if (z11) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                }
                if (hVarSelect == null) {
                    if (hVarSelect == null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    eVarCreateJavaTypeQualifiers = v.createJavaTypeQualifiers(hVarSelect, fVar, z10, z9);
                } else {
                    if (hVarSelect == null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    eVarCreateJavaTypeQualifiers = v.createJavaTypeQualifiers(hVarSelect, fVar, z10, z9);
                }
                eVarArr[i2] = eVarCreateJavaTypeQualifiers;
                i2++;
                obj = hVar;
                size = i3;
                arrayList = arrayList8;
                arrayList3 = arrayList12;
                eVarArr = eVarArr;
                i = 10;
            } else {
                uVar = uVarComponent2;
            }
            annotations = (!z16 || (aVar = this.a) == null) ? c0VarComponent1.getAnnotations() : d0.e0.p.d.m0.c.g1.i.composeAnnotations(aVar.getAnnotations(), c0VarComponent1.getAnnotations());
            if (z16) {
                defaultTypeQualifiers = this.e.getDefaultTypeQualifiers();
                if (defaultTypeQualifiers == null) {
                    uVar2 = null;
                } else {
                    uVar2 = defaultTypeQualifiers.get(this.f);
                }
            } else {
                uVar2 = uVar;
            }
            if (uVar2 != null) {
                if (uVar2.getAffectsTypeParameterBasedTypes()) {
                    z14 = true;
                } else {
                    z14 = true;
                }
                if (!z14) {
                    uVar2 = null;
                }
            } else {
                uVar2 = null;
            }
            declarationDescriptor = c0VarComponent1.getConstructor().getDeclarationDescriptor();
            if (declarationDescriptor instanceof z0) {
                z0Var = (z0) declarationDescriptor;
            } else {
                z0Var = null;
            }
            if (z0Var == null) {
                hVarA = null;
            } else {
                hVarA = a(z0Var);
            }
            if (hVarA == null) {
                pair = new Pair(null, Boolean.FALSE);
            } else {
                i iVar5 = new i(hVar4, false, 2, null);
                if (hVarA == hVar4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                pair = new Pair(iVar5, Boolean.valueOf(z3));
            }
            iVar = (i) pair.component1();
            zBooleanValue = ((Boolean) pair.component2()).booleanValue();
            z4 = this.g;
            lVar = this.h;
            it = annotations.iterator();
            do {
                if (it.hasNext()) {
                    iVarExtractNullability = null;
                    break;
                }
                iVarExtractNullability = lVar.extractNullability(it.next(), typeEnhancementImprovements, z4);
            } while (iVarExtractNullability == null);
            if (iVarExtractNullability == null) {
                iVar2 = null;
            } else {
                iVar2 = iVarExtractNullability;
            }
            if (iVar2 == null) {
                if (iVar == null) {
                    if (uVar2 == null) {
                        iVar = null;
                    } else {
                        iVar = new i(nullabilityQualifier.getQualifier(), nullabilityQualifier.isForWarningOnly());
                    }
                }
                if (z0VarComponent3 == null) {
                    hVarA2 = null;
                } else {
                    hVarA2 = a(z0VarComponent3);
                }
                if (hVarA2 == null) {
                    iVar3 = iVar;
                    hVar = null;
                } else if (iVar == null) {
                    iVar3 = new i(hVarA2, false, 2, null);
                    hVar = null;
                } else {
                    qualifier2 = iVar.getQualifier();
                    hVar2 = h.FORCE_FLEXIBILITY;
                    if (hVarA2 != hVar2) {
                        hVarA2 = qualifier2;
                    } else if (qualifier2 != hVar2) {
                        if (hVarA2 == hVar3) {
                            hVarA2 = qualifier2;
                        } else if (qualifier2 != hVar3) {
                            hVarA2 = hVar4;
                        }
                    }
                    hVar = null;
                    iVar3 = new i(hVarA2, false, 2, null);
                }
            } else {
                hVar = null;
                iVar3 = iVar2;
            }
            if (iVar2 != null) {
                if (!zBooleanValue) {
                    if (uVar2 == null) {
                        objValueOf = hVar;
                    } else {
                        objValueOf = Boolean.valueOf(uVar2.getMakesTypeParameterNotNull());
                    }
                    if (d0.z.d.m.areEqual(objValueOf, Boolean.TRUE)) {
                        z5 = false;
                    }
                }
                z5 = true;
            } else if (iVar2.getQualifier() == hVar4) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (iVar3 == null) {
                qualifier = hVar;
            } else {
                qualifier = iVar3.getQualifier();
            }
            List<d0.e0.p.d.m0.g.b> read_only_annotations2 = b0.getREAD_ONLY_ANNOTATIONS();
            f fVar5 = f.READ_ONLY;
            objC = c(read_only_annotations2, annotations, fVar5);
            List<d0.e0.p.d.m0.g.b> mutable_annotations2 = b0.getMUTABLE_ANNOTATIONS();
            f fVar6 = f.MUTABLE;
            objC2 = c(mutable_annotations2, annotations, fVar6);
            if (objC == null) {
                if (objC != null) {
                    objC2 = objC;
                }
            } else if (objC != null) {
                objC2 = objC;
            }
            f fVar7 = (f) objC2;
            if (z5) {
                z6 = false;
            } else {
                z6 = false;
            }
            if (iVar3 == null) {
                objValueOf2 = hVar;
            } else {
                objValueOf2 = Boolean.valueOf(iVar3.isForWarningOnly());
            }
            eVar = new e(qualifier, fVar7, z6, d0.z.d.m.areEqual(objValueOf2, Boolean.TRUE));
            if (!eVar.isNullabilityQualifierForWarning()) {
                r1 = eVar;
            } else {
                r1 = hVar;
            }
            if (r1 == 0) {
                nullability = hVar;
            } else {
                nullability = r1.getNullability();
            }
            nullability2 = eVar.getNullability();
            if (this.d) {
                z7 = false;
            } else {
                z7 = false;
            }
            hVarSelect = v.select(set3, nullability, z7);
            if (hVarSelect == null) {
                hVarSelect = hVar;
            } else {
                obj2 = this.a;
                if (!(obj2 instanceof c1)) {
                    obj2 = hVar;
                }
                c1Var = (c1) obj2;
                if (c1Var == null) {
                    varargElementType = hVar;
                } else {
                    varargElementType = c1Var.getVarargElementType();
                }
                if (varargElementType != null) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (!z12) {
                    z13 = false;
                } else {
                    z13 = false;
                }
                if (z13) {
                    hVarSelect = hVar;
                }
            }
            fVar = (f) v.select(set2, fVar6, fVar5, eVar.getMutability(), z7);
            if (nullability2 == nullability) {
                set = set4;
                if (!d0.z.d.m.areEqual(set, set3)) {
                    z8 = false;
                }
                if (eVar.isNotNullTypeParameter()) {
                    z9 = true;
                } else {
                    if (arrayList5.isEmpty()) {
                        it2 = arrayList5.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                z11 = false;
                                break;
                            }
                            if (((e) it2.next()).isNotNullTypeParameter()) {
                                z11 = true;
                                break;
                            }
                        }
                    } else {
                        z11 = false;
                        break;
                    }
                    if (z11) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                }
                if (hVarSelect == null) {
                    if (hVarSelect == null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    eVarCreateJavaTypeQualifiers = v.createJavaTypeQualifiers(hVarSelect, fVar, z10, z9);
                } else {
                    if (hVarSelect == null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    eVarCreateJavaTypeQualifiers = v.createJavaTypeQualifiers(hVarSelect, fVar, z10, z9);
                }
                eVarArr[i2] = eVarCreateJavaTypeQualifiers;
                i2++;
                obj = hVar;
                size = i3;
                arrayList = arrayList8;
                arrayList3 = arrayList12;
                eVarArr = eVarArr;
                i = 10;
            } else {
                set = set4;
            }
            z8 = true;
            if (eVar.isNotNullTypeParameter()) {
                z9 = true;
            } else {
                if (arrayList5.isEmpty()) {
                    it2 = arrayList5.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            z11 = false;
                            break;
                        }
                        if (((e) it2.next()).isNotNullTypeParameter()) {
                            z11 = true;
                            break;
                        }
                    }
                } else {
                    z11 = false;
                    break;
                }
                if (z11) {
                    z9 = true;
                } else {
                    z9 = false;
                }
            }
            if (hVarSelect == null) {
                if (hVarSelect == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                eVarCreateJavaTypeQualifiers = v.createJavaTypeQualifiers(hVarSelect, fVar, z10, z9);
            } else {
                if (hVarSelect == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                eVarCreateJavaTypeQualifiers = v.createJavaTypeQualifiers(hVarSelect, fVar, z10, z9);
            }
            eVarArr[i2] = eVarCreateJavaTypeQualifiers;
            i2++;
            obj = hVar;
            size = i3;
            arrayList = arrayList8;
            arrayList3 = arrayList12;
            eVarArr = eVarArr;
            i = 10;
        }
        Object obj3 = obj;
        m mVar = new m(eVarArr);
        Object l_b_b = wVar == null ? obj3 : new l$b$b(wVar, mVar);
        boolean zContains = e1.contains(this.f3350b, l$b$a.j);
        ?? Access$getTypeEnhancement$p = l.access$getTypeEnhancement$p(this.h);
        c0 c0Var3 = this.f3350b;
        ?? r2 = mVar;
        if (l_b_b != null) {
            r2 = l_b_b;
        }
        c0 c0VarEnhance = Access$getTypeEnhancement$p.enhance(c0Var3, r2);
        if (c0VarEnhance == null) {
            r6 = obj3;
        } else {
            l_a = new l$a(c0VarEnhance, true, zContains);
        }
        if (r6 == 0) {
            r6 = l_a;
            return new l$a(this.f3350b, false, zContains);
        }
        r6 = l_a;
        return r6;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l$b(l lVar, d0.e0.p.d.m0.c.g1.a aVar, c0 c0Var, Collection collection, boolean z2, d0.e0.p.d.m0.e.a.i0.g gVar, d0.e0.p.d.m0.e.a.a aVar2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(lVar, aVar, c0Var, collection, z2, gVar, aVar2, (i & 64) != 0 ? false : z3);
        this.h = lVar;
    }
}
