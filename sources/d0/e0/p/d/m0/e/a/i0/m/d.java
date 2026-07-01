package d0.e0.p.d.m0.e.a.i0.m;

import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.e.a.i0.k;
import d0.e0.p.d.m0.e.a.k0.b0;
import d0.e0.p.d.m0.e.a.k0.i;
import d0.e0.p.d.m0.e.a.k0.j;
import d0.e0.p.d.m0.e.a.k0.v;
import d0.e0.p.d.m0.e.a.k0.x;
import d0.e0.p.d.m0.e.a.k0.y;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.d0;
import d0.e0.p.d.m0.n.f0;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.t;
import d0.e0.p.d.m0.n.u0;
import d0.e0.p.d.m0.n.w0;
import d0.e0.p.d.m0.n.y0;
import d0.t.o;
import d0.t.u;
import d0.t.z;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: JavaTypeResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public final d0.e0.p.d.m0.e.a.i0.g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f3340b;

    public d(d0.e0.p.d.m0.e.a.i0.g gVar, k kVar) {
        m.checkNotNullParameter(gVar, "c");
        m.checkNotNullParameter(kVar, "typeParameterResolver");
        this.a = gVar;
        this.f3340b = kVar;
    }

    public static final j0 c(j jVar) {
        j0 j0VarCreateErrorType = t.createErrorType(m.stringPlus("Unresolved java class ", jVar.getPresentableText()));
        m.checkNotNullExpressionValue(j0VarCreateErrorType, "createErrorType(\"Unresolved java class ${javaType.presentableText}\")");
        return j0VarCreateErrorType;
    }

    public static /* synthetic */ c0 transformArrayType$default(d dVar, d0.e0.p.d.m0.e.a.k0.f fVar, a aVar, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return dVar.transformArrayType(fVar, aVar, z2);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0184  */
    /* JADX WARN: Code duplicated, block: B:104:0x0192  */
    /* JADX WARN: Code duplicated, block: B:107:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:109:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:110:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:114:0x01da  */
    /* JADX WARN: Code duplicated, block: B:116:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:119:0x01fb A[LOOP:1: B:117:0x01f5->B:119:0x01fb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:121:0x021b  */
    /* JADX WARN: Code duplicated, block: B:124:0x0236  */
    /* JADX WARN: Code duplicated, block: B:126:0x025f  */
    /* JADX WARN: Code duplicated, block: B:128:0x026b  */
    /* JADX WARN: Code duplicated, block: B:129:0x026d  */
    /* JADX WARN: Code duplicated, block: B:131:0x0271  */
    /* JADX WARN: Code duplicated, block: B:137:0x0280  */
    /* JADX WARN: Code duplicated, block: B:140:0x0284  */
    /* JADX WARN: Code duplicated, block: B:141:0x0293  */
    /* JADX WARN: Code duplicated, block: B:143:0x029b  */
    /* JADX WARN: Code duplicated, block: B:52:0x00de  */
    /* JADX WARN: Code duplicated, block: B:55:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:72:0x012b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:73:0x012c  */
    /* JADX WARN: Code duplicated, block: B:75:0x0132  */
    /* JADX WARN: Code duplicated, block: B:76:0x0135  */
    /* JADX WARN: Code duplicated, block: B:81:0x0143  */
    /* JADX WARN: Code duplicated, block: B:84:0x0148  */
    /* JADX WARN: Code duplicated, block: B:85:0x014a  */
    /* JADX WARN: Code duplicated, block: B:95:0x0169  */
    /* JADX WARN: Code duplicated, block: B:97:0x0173  */
    public final j0 a(j jVar, a aVar, j0 j0Var) {
        u0 typeConstructor;
        u0 u0Var;
        d0.e0.p.d.m0.c.e eVarConvertReadOnlyToMutable;
        boolean z2;
        boolean z3;
        boolean z4;
        u0 constructor;
        boolean zIsRaw;
        boolean z5;
        List<z0> parameters;
        ArrayList arrayList;
        List list;
        x xVar;
        z0 z0Var;
        d0.e0.p.d.m0.e.a.g0.k kVar;
        a attributes$default;
        j1 j1Var;
        z0 z0Var2;
        w0 y0Var;
        b0 b0Var;
        x bound;
        j1 j1Var2;
        boolean z6;
        ArrayList arrayList2;
        Iterator<T> it;
        ArrayList arrayList3;
        a aVarWithFlexibility;
        j1 j1Var3 = j1.OUT_VARIANCE;
        d0.e0.p.d.m0.e.a.g0.k kVar2 = d0.e0.p.d.m0.e.a.g0.k.SUPERTYPE;
        b bVar = b.FLEXIBLE_LOWER_BOUND;
        z0 z0Var3 = null;
        d0.e0.p.d.m0.c.g1.g annotations = j0Var == null ? null : j0Var.getAnnotations();
        if (annotations == null) {
            annotations = new d0.e0.p.d.m0.e.a.i0.d(this.a, jVar, false, 4, null);
        }
        d0.e0.p.d.m0.c.g1.g gVar = annotations;
        i classifier = jVar.getClassifier();
        boolean z7 = false;
        if (classifier == null) {
            typeConstructor = b(jVar);
        } else {
            if (!(classifier instanceof d0.e0.p.d.m0.e.a.k0.g)) {
                if (!(classifier instanceof y)) {
                    throw new IllegalStateException(m.stringPlus("Unknown classifier kind: ", classifier));
                }
                z0 z0VarResolveTypeParameter = this.f3340b.resolveTypeParameter((y) classifier);
                if (z0VarResolveTypeParameter == null) {
                    u0Var = null;
                } else {
                    typeConstructor = z0VarResolveTypeParameter.getTypeConstructor();
                }
                if (u0Var == null) {
                    return null;
                }
                if (aVar.getFlexibility() == bVar) {
                    z4 = false;
                } else {
                    if (!aVar.isForAnnotationParameter() || aVar.getHowThisTypeIsUsed() == kVar2) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    z4 = z3;
                }
                if (j0Var == null) {
                    constructor = null;
                } else {
                    constructor = j0Var.getConstructor();
                }
                if (!m.areEqual(constructor, u0Var) && !jVar.isRaw() && z4) {
                    return j0Var.makeNullableAsSpecified(true);
                }
                zIsRaw = jVar.isRaw();
                if (zIsRaw) {
                    if (jVar.getTypeArguments().isEmpty()) {
                        List<z0> parameters2 = u0Var.getParameters();
                        m.checkNotNullExpressionValue(parameters2, "constructor.parameters");
                        z5 = parameters2.isEmpty() ^ true;
                    }
                }
                parameters = u0Var.getParameters();
                m.checkNotNullExpressionValue(parameters, "constructor.parameters");
                if (z5) {
                    arrayList3 = new ArrayList(o.collectionSizeOrDefault(parameters, 10));
                    for (z0 z0Var4 : parameters) {
                        f0 f0Var = new f0(this.a.getStorageManager(), new c(z0Var4, aVar, u0Var));
                        f fVar = f.f3341b;
                        m.checkNotNullExpressionValue(z0Var4, "parameter");
                        if (zIsRaw) {
                            aVarWithFlexibility = aVar;
                        } else {
                            aVarWithFlexibility = aVar.withFlexibility(b.INFLEXIBLE);
                        }
                        arrayList3.add(fVar.computeProjection(z0Var4, aVarWithFlexibility, f0Var));
                    }
                    list = u.toList(arrayList3);
                } else if (parameters.size() != jVar.getTypeArguments().size()) {
                    arrayList2 = new ArrayList(o.collectionSizeOrDefault(parameters, 10));
                    it = parameters.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(new y0(t.createErrorType(((z0) it.next()).getName().asString())));
                    }
                    list = u.toList(arrayList2);
                } else {
                    Iterable<z> iterableWithIndex = u.withIndex(jVar.getTypeArguments());
                    arrayList = new ArrayList(o.collectionSizeOrDefault(iterableWithIndex, 10));
                    for (z zVar : iterableWithIndex) {
                        int iComponent1 = zVar.component1();
                        xVar = (x) zVar.component2();
                        parameters.size();
                        z0Var = parameters.get(iComponent1);
                        kVar = d0.e0.p.d.m0.e.a.g0.k.COMMON;
                        attributes$default = e.toAttributes$default(kVar, z7, z0Var3, 3, z0Var3);
                        m.checkNotNullExpressionValue(z0Var, "parameter");
                        j1Var = j1.INVARIANT;
                        if (xVar instanceof b0) {
                            b0Var = (b0) xVar;
                            bound = b0Var.getBound();
                            if (b0Var.isExtends()) {
                                j1Var2 = j1Var3;
                            } else {
                                j1Var2 = j1.IN_VARIANCE;
                            }
                            if (bound == null) {
                                z0Var2 = null;
                                y0Var = e.makeStarProjection(z0Var, attributes$default);
                            } else {
                                if (z0Var.getVariance() == j1Var && j1Var2 != z0Var.getVariance()) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                if (z6) {
                                    z0Var2 = null;
                                    y0Var = e.makeStarProjection(z0Var, attributes$default);
                                } else {
                                    z0Var2 = null;
                                    y0Var = d0.e0.p.d.m0.n.o1.a.createProjection(transformJavaType(bound, e.toAttributes$default(kVar, false, null, 3, null)), j1Var2, z0Var);
                                }
                            }
                        } else {
                            z0Var2 = null;
                            y0Var = new y0(j1Var, transformJavaType(xVar, attributes$default));
                        }
                        arrayList.add(y0Var);
                        z0Var3 = z0Var2;
                        z7 = false;
                    }
                    list = u.toList(arrayList);
                }
                List list2 = list;
                d0 d0Var = d0.a;
                return d0.simpleType$default(gVar, u0Var, list2, z4, null, 16, null);
            }
            d0.e0.p.d.m0.e.a.k0.g gVar2 = (d0.e0.p.d.m0.e.a.k0.g) classifier;
            d0.e0.p.d.m0.g.b fqName = gVar2.getFqName();
            if (fqName == null) {
                throw new AssertionError(m.stringPlus("Class type should have a FQ name: ", classifier));
            }
            if (aVar.isForAnnotationParameter() && m.areEqual(fqName, e.access$getJAVA_LANG_CLASS_FQ_NAME$p$s1946801611())) {
                eVarConvertReadOnlyToMutable = this.a.getComponents().getReflectionTypes().getKClass();
            } else {
                d0.e0.p.d.m0.b.q.d dVar = d0.e0.p.d.m0.b.q.d.a;
                d0.e0.p.d.m0.c.e eVarMapJavaToKotlin$default = d0.e0.p.d.m0.b.q.d.mapJavaToKotlin$default(dVar, fqName, this.a.getModule().getBuiltIns(), null, 4, null);
                if (eVarMapJavaToKotlin$default == null) {
                    eVarConvertReadOnlyToMutable = null;
                } else if (dVar.isReadOnly(eVarMapJavaToKotlin$default)) {
                    if (aVar.getFlexibility() != bVar && aVar.getHowThisTypeIsUsed() != kVar2) {
                        x xVar2 = (x) u.lastOrNull((List) jVar.getTypeArguments());
                        b0 b0Var2 = xVar2 instanceof b0 ? (b0) xVar2 : null;
                        if ((b0Var2 == null || b0Var2.getBound() == null || b0Var2.isExtends()) ? false : true) {
                            List<z0> parameters3 = dVar.convertReadOnlyToMutable(eVarMapJavaToKotlin$default).getTypeConstructor().getParameters();
                            m.checkNotNullExpressionValue(parameters3, "JavaToKotlinClassMapper.convertReadOnlyToMutable(readOnlyContainer)\n            .typeConstructor.parameters");
                            z0 z0Var5 = (z0) u.lastOrNull((List) parameters3);
                            j1 variance = z0Var5 == null ? null : z0Var5.getVariance();
                            if (variance == null || variance == j1Var3) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                        } else {
                            z2 = false;
                        }
                        if (!z2) {
                            eVarConvertReadOnlyToMutable = eVarMapJavaToKotlin$default;
                        }
                    }
                    eVarConvertReadOnlyToMutable = dVar.convertReadOnlyToMutable(eVarMapJavaToKotlin$default);
                } else {
                    eVarConvertReadOnlyToMutable = eVarMapJavaToKotlin$default;
                }
            }
            if (eVarConvertReadOnlyToMutable == null) {
                eVarConvertReadOnlyToMutable = this.a.getComponents().getModuleClassResolver().resolveClass(gVar2);
            }
            typeConstructor = eVarConvertReadOnlyToMutable == null ? null : eVarConvertReadOnlyToMutable.getTypeConstructor();
            if (typeConstructor == null) {
                typeConstructor = b(jVar);
            }
        }
        u0Var = typeConstructor;
        if (u0Var == null) {
            return null;
        }
        if (aVar.getFlexibility() == bVar) {
            z4 = false;
        } else {
            if (aVar.isForAnnotationParameter()) {
                z3 = false;
            } else {
                z3 = false;
            }
            z4 = z3;
        }
        if (j0Var == null) {
            constructor = null;
        } else {
            constructor = j0Var.getConstructor();
        }
        if (!m.areEqual(constructor, u0Var)) {
        }
        zIsRaw = jVar.isRaw();
        if (zIsRaw) {
            if (jVar.getTypeArguments().isEmpty()) {
                List<z0> parameters4 = u0Var.getParameters();
                m.checkNotNullExpressionValue(parameters4, "constructor.parameters");
                if (parameters4.isEmpty() ^ true) {
                }
            }
        }
        parameters = u0Var.getParameters();
        m.checkNotNullExpressionValue(parameters, "constructor.parameters");
        if (z5) {
            arrayList3 = new ArrayList(o.collectionSizeOrDefault(parameters, 10));
            while (r5.hasNext()) {
                f0 f0Var2 = new f0(this.a.getStorageManager(), new c(z0Var4, aVar, u0Var));
                f fVar2 = f.f3341b;
                m.checkNotNullExpressionValue(z0Var4, "parameter");
                if (zIsRaw) {
                    aVarWithFlexibility = aVar;
                } else {
                    aVarWithFlexibility = aVar.withFlexibility(b.INFLEXIBLE);
                }
                arrayList3.add(fVar2.computeProjection(z0Var4, aVarWithFlexibility, f0Var2));
            }
            list = u.toList(arrayList3);
        } else if (parameters.size() != jVar.getTypeArguments().size()) {
            arrayList2 = new ArrayList(o.collectionSizeOrDefault(parameters, 10));
            it = parameters.iterator();
            while (it.hasNext()) {
                arrayList2.add(new y0(t.createErrorType(((z0) it.next()).getName().asString())));
            }
            list = u.toList(arrayList2);
        } else {
            Iterable<z> iterableWithIndex2 = u.withIndex(jVar.getTypeArguments());
            arrayList = new ArrayList(o.collectionSizeOrDefault(iterableWithIndex2, 10));
            while (r1.hasNext()) {
                int iComponent2 = zVar.component1();
                xVar = (x) zVar.component2();
                parameters.size();
                z0Var = parameters.get(iComponent2);
                kVar = d0.e0.p.d.m0.e.a.g0.k.COMMON;
                attributes$default = e.toAttributes$default(kVar, z7, z0Var3, 3, z0Var3);
                m.checkNotNullExpressionValue(z0Var, "parameter");
                j1Var = j1.INVARIANT;
                if (xVar instanceof b0) {
                    b0Var = (b0) xVar;
                    bound = b0Var.getBound();
                    if (b0Var.isExtends()) {
                        j1Var2 = j1Var3;
                    } else {
                        j1Var2 = j1.IN_VARIANCE;
                    }
                    if (bound == null) {
                        z0Var2 = null;
                        y0Var = e.makeStarProjection(z0Var, attributes$default);
                    } else {
                        if (z0Var.getVariance() == j1Var) {
                            z6 = false;
                        } else {
                            z6 = true;
                        }
                        if (z6) {
                            z0Var2 = null;
                            y0Var = e.makeStarProjection(z0Var, attributes$default);
                        } else {
                            z0Var2 = null;
                            y0Var = d0.e0.p.d.m0.n.o1.a.createProjection(transformJavaType(bound, e.toAttributes$default(kVar, false, null, 3, null)), j1Var2, z0Var);
                        }
                    }
                } else {
                    z0Var2 = null;
                    y0Var = new y0(j1Var, transformJavaType(xVar, attributes$default));
                }
                arrayList.add(y0Var);
                z0Var3 = z0Var2;
                z7 = false;
            }
            list = u.toList(arrayList);
        }
        List list3 = list;
        d0 d0Var2 = d0.a;
        return d0.simpleType$default(gVar, u0Var, list3, z4, null, 16, null);
    }

    public final u0 b(j jVar) {
        d0.e0.p.d.m0.g.a aVar = d0.e0.p.d.m0.g.a.topLevel(new d0.e0.p.d.m0.g.b(jVar.getClassifierQualifiedName()));
        m.checkNotNullExpressionValue(aVar, "topLevel(FqName(javaType.classifierQualifiedName))");
        u0 typeConstructor = this.a.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses().getClass(aVar, d0.t.m.listOf(0)).getTypeConstructor();
        m.checkNotNullExpressionValue(typeConstructor, "c.components.deserializedDescriptorResolver.components.notFoundClasses.getClass(classId, listOf(0)).typeConstructor");
        return typeConstructor;
    }

    public final c0 transformArrayType(d0.e0.p.d.m0.e.a.k0.f fVar, a aVar, boolean z2) {
        j1 j1Var = j1.OUT_VARIANCE;
        j1 j1Var2 = j1.INVARIANT;
        m.checkNotNullParameter(fVar, "arrayType");
        m.checkNotNullParameter(aVar, "attr");
        x componentType = fVar.getComponentType();
        v vVar = componentType instanceof v ? (v) componentType : null;
        d0.e0.p.d.m0.b.i type = vVar == null ? null : vVar.getType();
        d0.e0.p.d.m0.e.a.i0.d dVar = new d0.e0.p.d.m0.e.a.i0.d(this.a, fVar, true);
        if (type != null) {
            j0 primitiveArrayKotlinType = this.a.getModule().getBuiltIns().getPrimitiveArrayKotlinType(type);
            m.checkNotNullExpressionValue(primitiveArrayKotlinType, "c.module.builtIns.getPrimitiveArrayKotlinType(primitiveType)");
            primitiveArrayKotlinType.replaceAnnotations(d0.e0.p.d.m0.c.g1.g.f.create(u.plus((Iterable) dVar, (Iterable) primitiveArrayKotlinType.getAnnotations())));
            if (aVar.isForAnnotationParameter()) {
                return primitiveArrayKotlinType;
            }
            d0 d0Var = d0.a;
            return d0.flexibleType(primitiveArrayKotlinType, primitiveArrayKotlinType.makeNullableAsSpecified(true));
        }
        c0 c0VarTransformJavaType = transformJavaType(componentType, e.toAttributes$default(d0.e0.p.d.m0.e.a.g0.k.COMMON, aVar.isForAnnotationParameter(), null, 2, null));
        if (!aVar.isForAnnotationParameter()) {
            d0 d0Var2 = d0.a;
            j0 arrayType = this.a.getModule().getBuiltIns().getArrayType(j1Var2, c0VarTransformJavaType, dVar);
            m.checkNotNullExpressionValue(arrayType, "c.module.builtIns.getArrayType(INVARIANT, componentType, annotations)");
            return d0.flexibleType(arrayType, this.a.getModule().getBuiltIns().getArrayType(j1Var, c0VarTransformJavaType, dVar).makeNullableAsSpecified(true));
        }
        if (!z2) {
            j1Var = j1Var2;
        }
        j0 arrayType2 = this.a.getModule().getBuiltIns().getArrayType(j1Var, c0VarTransformJavaType, dVar);
        m.checkNotNullExpressionValue(arrayType2, "c.module.builtIns.getArrayType(projectionKind, componentType, annotations)");
        return arrayType2;
    }

    public final c0 transformJavaType(x xVar, a aVar) {
        m.checkNotNullParameter(aVar, "attr");
        if (xVar instanceof v) {
            d0.e0.p.d.m0.b.i type = ((v) xVar).getType();
            j0 primitiveKotlinType = type != null ? this.a.getModule().getBuiltIns().getPrimitiveKotlinType(type) : this.a.getModule().getBuiltIns().getUnitType();
            m.checkNotNullExpressionValue(primitiveKotlinType, "{\n                val primitiveType = javaType.type\n                if (primitiveType != null) c.module.builtIns.getPrimitiveKotlinType(primitiveType)\n                else c.module.builtIns.unitType\n            }");
            return primitiveKotlinType;
        }
        if (!(xVar instanceof j)) {
            if (xVar instanceof d0.e0.p.d.m0.e.a.k0.f) {
                return transformArrayType$default(this, (d0.e0.p.d.m0.e.a.k0.f) xVar, aVar, false, 4, null);
            }
            if (!(xVar instanceof b0)) {
                if (xVar != null) {
                    throw new UnsupportedOperationException(m.stringPlus("Unsupported type: ", xVar));
                }
                j0 defaultBound = this.a.getModule().getBuiltIns().getDefaultBound();
                m.checkNotNullExpressionValue(defaultBound, "c.module.builtIns.defaultBound");
                return defaultBound;
            }
            x bound = ((b0) xVar).getBound();
            c0 c0VarTransformJavaType = bound == null ? null : transformJavaType(bound, aVar);
            if (c0VarTransformJavaType != null) {
                return c0VarTransformJavaType;
            }
            j0 defaultBound2 = this.a.getModule().getBuiltIns().getDefaultBound();
            m.checkNotNullExpressionValue(defaultBound2, "c.module.builtIns.defaultBound");
            return defaultBound2;
        }
        j jVar = (j) xVar;
        boolean z2 = (aVar.isForAnnotationParameter() || aVar.getHowThisTypeIsUsed() == d0.e0.p.d.m0.e.a.g0.k.SUPERTYPE) ? false : true;
        boolean zIsRaw = jVar.isRaw();
        if (!zIsRaw && !z2) {
            j0 j0VarA = a(jVar, aVar, null);
            if (j0VarA == null) {
                j0VarA = c(jVar);
            }
            return j0VarA;
        }
        j0 j0VarA2 = a(jVar, aVar.withFlexibility(b.FLEXIBLE_LOWER_BOUND), null);
        if (j0VarA2 == null) {
            return c(jVar);
        }
        j0 j0VarA3 = a(jVar, aVar.withFlexibility(b.FLEXIBLE_UPPER_BOUND), j0VarA2);
        if (j0VarA3 == null) {
            return c(jVar);
        }
        if (zIsRaw) {
            return new g(j0VarA2, j0VarA3);
        }
        d0 d0Var = d0.a;
        return d0.flexibleType(j0VarA2, j0VarA3);
    }
}
