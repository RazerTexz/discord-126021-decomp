package d0.e0.p.d.m0.b.q;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.c0;
import d0.e0.p.d.m0.c.s;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.x;
import d0.e0.p.d.m0.c.x$a;
import d0.e0.p.d.m0.c.z;
import d0.e0.p.d.m0.e.b.t;
import d0.e0.p.d.m0.e.b.w;
import d0.e0.p.d.m0.k.a0.i$b;
import d0.e0.p.d.m0.k.k$d$a;
import d0.e0.p.d.m0.n.c1;
import d0.e0.p.d.m0.n.f0;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.p.j$b;
import d0.t.n0;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements d0.e0.p.d.m0.c.h1.a, d0.e0.p.d.m0.c.h1.c {
    public static final /* synthetic */ KProperty<Object>[] a = {a0.property1(new y(a0.getOrCreateKotlinClass(g.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;")), a0.property1(new y(a0.getOrCreateKotlinClass(g.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), a0.property1(new y(a0.getOrCreateKotlinClass(g.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f3240b;
    public final d c;
    public final d0.e0.p.d.m0.m.j d;
    public final d0.e0.p.d.m0.n.c0 e;
    public final d0.e0.p.d.m0.m.j f;
    public final d0.e0.p.d.m0.m.a<d0.e0.p.d.m0.g.b, d0.e0.p.d.m0.c.e> g;
    public final d0.e0.p.d.m0.m.j h;

    public g(c0 c0Var, d0.e0.p.d.m0.m.o oVar, Function0<f$b> function0) {
        d0.z.d.m.checkNotNullParameter(c0Var, "moduleDescriptor");
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(function0, "settingsComputation");
        this.f3240b = c0Var;
        this.c = d.a;
        this.d = oVar.createLazyValue(function0);
        d0.e0.p.d.m0.c.i1.i iVar = new d0.e0.p.d.m0.c.i1.i(new h(c0Var, new d0.e0.p.d.m0.g.b("java.io")), d0.e0.p.d.m0.g.e.identifier("Serializable"), z.ABSTRACT, d0.e0.p.d.m0.c.f.INTERFACE, d0.t.m.listOf(new f0(oVar, new i(this))), u0.a, false, oVar);
        iVar.initialize(i$b.f3461b, n0.emptySet(), null);
        j0 defaultType = iVar.getDefaultType();
        d0.z.d.m.checkNotNullExpressionValue(defaultType, "mockSerializableClass.defaultType");
        this.e = defaultType;
        this.f = oVar.createLazyValue(new g$b(this, oVar));
        this.g = oVar.createCacheWithNotNullValues();
        this.h = oVar.createLazyValue(new g$d(this));
    }

    public static final /* synthetic */ d access$getJ2kClassMapper$p(g gVar) {
        return gVar.c;
    }

    public static final /* synthetic */ d0.e0.p.d.m0.e.a.i0.l.f access$getJavaAnalogue(g gVar, d0.e0.p.d.m0.c.e eVar) {
        return gVar.a(eVar);
    }

    public static final /* synthetic */ c0 access$getModuleDescriptor$p(g gVar) {
        return gVar.f3240b;
    }

    public static final /* synthetic */ f$b access$getSettings(g gVar) {
        return gVar.b();
    }

    public final d0.e0.p.d.m0.e.a.i0.l.f a(d0.e0.p.d.m0.c.e eVar) {
        if (d0.e0.p.d.m0.b.h.isAny(eVar) || !d0.e0.p.d.m0.b.h.isUnderKotlinPackage(eVar)) {
            return null;
        }
        d0.e0.p.d.m0.g.c fqNameUnsafe = d0.e0.p.d.m0.k.x.a.getFqNameUnsafe(eVar);
        if (!fqNameUnsafe.isSafe()) {
            return null;
        }
        d0.e0.p.d.m0.g.a aVarMapKotlinToJava = c.a.mapKotlinToJava(fqNameUnsafe);
        d0.e0.p.d.m0.g.b bVarAsSingleFqName = aVarMapKotlinToJava == null ? null : aVarMapKotlinToJava.asSingleFqName();
        if (bVarAsSingleFqName == null) {
            return null;
        }
        d0.e0.p.d.m0.c.e eVarResolveClassByFqName = s.resolveClassByFqName(b().getOwnerModuleDescriptor(), bVarAsSingleFqName, d0.e0.p.d.m0.d.b.d.FROM_BUILTINS);
        if (eVarResolveClassByFqName instanceof d0.e0.p.d.m0.e.a.i0.l.f) {
            return (d0.e0.p.d.m0.e.a.i0.l.f) eVarResolveClassByFqName;
        }
        return null;
    }

    public final f$b b() {
        return (f$b) d0.e0.p.d.m0.m.n.getValue(this.d, this, (KProperty<?>) a[0]);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00e2  */
    @Override // d0.e0.p.d.m0.c.h1.a
    public Collection<d0.e0.p.d.m0.c.d> getConstructors(d0.e0.p.d.m0.c.e eVar) {
        d0.e0.p.d.m0.c.e eVarMapJavaToKotlin$default;
        boolean z2;
        boolean z3;
        d0.z.d.m.checkNotNullParameter(eVar, "classDescriptor");
        if (eVar.getKind() != d0.e0.p.d.m0.c.f.CLASS || !b().isAdditionalBuiltInsFeatureSupported()) {
            return d0.t.n.emptyList();
        }
        d0.e0.p.d.m0.e.a.i0.l.f fVarA = a(eVar);
        if (fVarA != null && (eVarMapJavaToKotlin$default = d.mapJavaToKotlin$default(this.c, d0.e0.p.d.m0.k.x.a.getFqNameSafe(fVarA), b.f.getInstance(), null, 4, null)) != null) {
            c1 c1VarBuildSubstitutor = q.createMappedTypeParametersSubstitution(eVarMapJavaToKotlin$default, fVarA).buildSubstitutor();
            List<d0.e0.p.d.m0.c.d> constructors = fVarA.getConstructors();
            ArrayList<d0.e0.p.d.m0.c.d> arrayList = new ArrayList();
            Iterator<T> it = constructors.iterator();
            while (true) {
                boolean z4 = false;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                d0.e0.p.d.m0.c.d dVar = (d0.e0.p.d.m0.c.d) next;
                if (dVar.getVisibility().isPublicAPI()) {
                    Collection<d0.e0.p.d.m0.c.d> constructors2 = eVarMapJavaToKotlin$default.getConstructors();
                    d0.z.d.m.checkNotNullExpressionValue(constructors2, "defaultKotlinVersion.constructors");
                    if (constructors2.isEmpty()) {
                        z2 = true;
                        break;
                    }
                    Iterator<T> it2 = constructors2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z2 = true;
                            break;
                        }
                        d0.e0.p.d.m0.c.d dVar2 = (d0.e0.p.d.m0.c.d) it2.next();
                        d0.z.d.m.checkNotNullExpressionValue(dVar2, "it");
                        if (d0.e0.p.d.m0.k.k.getBothWaysOverridability(dVar2, dVar.substitute(c1VarBuildSubstitutor)) == k$d$a.OVERRIDABLE) {
                            z2 = false;
                            break;
                        }
                    }
                    if (z2) {
                        if (dVar.getValueParameters().size() == 1) {
                            List<d0.e0.p.d.m0.c.c1> valueParameters = dVar.getValueParameters();
                            d0.z.d.m.checkNotNullExpressionValue(valueParameters, "valueParameters");
                            d0.e0.p.d.m0.c.h declarationDescriptor = ((d0.e0.p.d.m0.c.c1) u.single((List) valueParameters)).getType().getConstructor().getDeclarationDescriptor();
                            if (d0.z.d.m.areEqual(declarationDescriptor == null ? null : d0.e0.p.d.m0.k.x.a.getFqNameUnsafe(declarationDescriptor), d0.e0.p.d.m0.k.x.a.getFqNameUnsafe(eVar))) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                        } else {
                            z3 = false;
                        }
                        if (!z3 && !d0.e0.p.d.m0.b.h.isDeprecated(dVar) && !p.a.getHIDDEN_CONSTRUCTOR_SIGNATURES().contains(t.signature(w.a, fVarA, d0.e0.p.d.m0.e.b.u.computeJvmDescriptor$default(dVar, false, false, 3, null)))) {
                            z4 = true;
                        }
                    }
                }
                if (z4) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList, 10));
            for (d0.e0.p.d.m0.c.d dVar3 : arrayList) {
                x$a<? extends x> x_aNewCopyBuilder = dVar3.newCopyBuilder();
                x_aNewCopyBuilder.setOwner(eVar);
                x_aNewCopyBuilder.setReturnType(eVar.getDefaultType());
                x_aNewCopyBuilder.setPreserveSourceElement();
                x_aNewCopyBuilder.setSubstitution(c1VarBuildSubstitutor.getSubstitution());
                if (!p.a.getVISIBLE_CONSTRUCTOR_SIGNATURES().contains(t.signature(w.a, fVarA, d0.e0.p.d.m0.e.b.u.computeJvmDescriptor$default(dVar3, false, false, 3, null)))) {
                    x_aNewCopyBuilder.setAdditionalAnnotations((d0.e0.p.d.m0.c.g1.g) d0.e0.p.d.m0.m.n.getValue(this.h, this, (KProperty<?>) a[2]));
                }
                x xVarBuild = x_aNewCopyBuilder.build();
                Objects.requireNonNull(xVarBuild, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
                arrayList2.add((d0.e0.p.d.m0.c.d) xVarBuild);
            }
            return arrayList2;
        }
        return d0.t.n.emptyList();
    }

    /* JADX WARN: Code duplicated, block: B:68:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:84:0x027f  */
    @Override // d0.e0.p.d.m0.c.h1.a
    public Collection<t0> getFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.c.e eVar2) {
        List<t0> listEmptyList;
        boolean z2;
        boolean z3;
        boolean zBooleanValue;
        t0 t0Var;
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(eVar2, "classDescriptor");
        boolean z4 = false;
        if (d0.z.d.m.areEqual(eVar, a.e.getCLONE_NAME()) && (eVar2 instanceof d0.e0.p.d.m0.l.b.e0.d) && d0.e0.p.d.m0.b.h.isArrayOrPrimitiveArray(eVar2)) {
            d0.e0.p.d.m0.l.b.e0.d dVar = (d0.e0.p.d.m0.l.b.e0.d) eVar2;
            List<d0.e0.p.d.m0.f.i> functionList = dVar.getClassProto().getFunctionList();
            d0.z.d.m.checkNotNullExpressionValue(functionList, "classDescriptor.classProto.functionList");
            if (!(functionList instanceof Collection) || !functionList.isEmpty()) {
                Iterator<T> it = functionList.iterator();
                while (it.hasNext()) {
                    if (d0.z.d.m.areEqual(d0.e0.p.d.m0.l.b.w.getName(dVar.getC().getNameResolver(), ((d0.e0.p.d.m0.f.i) it.next()).getName()), a.e.getCLONE_NAME())) {
                        z4 = true;
                        break;
                    }
                }
            }
            if (z4) {
                return d0.t.n.emptyList();
            }
            x$a<? extends t0> x_aNewCopyBuilder = ((t0) u.single(((j0) d0.e0.p.d.m0.m.n.getValue(this.f, this, (KProperty<?>) a[1])).getMemberScope().getContributedFunctions(eVar, d0.e0.p.d.m0.d.b.d.FROM_BUILTINS))).newCopyBuilder();
            x_aNewCopyBuilder.setOwner(dVar);
            x_aNewCopyBuilder.setVisibility(d0.e0.p.d.m0.c.t.e);
            x_aNewCopyBuilder.setReturnType(dVar.getDefaultType());
            x_aNewCopyBuilder.setDispatchReceiverParameter(dVar.getThisAsReceiverParameter());
            t0 t0Var2 = (t0) x_aNewCopyBuilder.build();
            d0.z.d.m.checkNotNull(t0Var2);
            return d0.t.m.listOf(t0Var2);
        }
        if (!b().isAdditionalBuiltInsFeatureSupported()) {
            return d0.t.n.emptyList();
        }
        g$c g_c = new g$c(eVar);
        d0.e0.p.d.m0.e.a.i0.l.f fVarA = a(eVar2);
        if (fVarA == null) {
            listEmptyList = d0.t.n.emptyList();
        } else {
            Collection<d0.e0.p.d.m0.c.e> collectionMapPlatformClass = this.c.mapPlatformClass(d0.e0.p.d.m0.k.x.a.getFqNameSafe(fVarA), b.f.getInstance());
            d0.e0.p.d.m0.c.e eVar3 = (d0.e0.p.d.m0.c.e) u.lastOrNull(collectionMapPlatformClass);
            if (eVar3 == null) {
                listEmptyList = d0.t.n.emptyList();
            } else {
                j$b j_b = d0.e0.p.d.m0.p.j.j;
                ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(collectionMapPlatformClass, 10));
                Iterator<T> it2 = collectionMapPlatformClass.iterator();
                while (it2.hasNext()) {
                    arrayList.add(d0.e0.p.d.m0.k.x.a.getFqNameSafe((d0.e0.p.d.m0.c.e) it2.next()));
                }
                d0.e0.p.d.m0.p.j jVarCreate = j_b.create(arrayList);
                boolean zIsMutable = this.c.isMutable(eVar2);
                d0.e0.p.d.m0.k.a0.i unsubstitutedMemberScope = ((d0.e0.p.d.m0.c.e) ((d0.e0.p.d.m0.m.f$d) this.g).computeIfAbsent(d0.e0.p.d.m0.k.x.a.getFqNameSafe(fVarA), new j(fVarA, eVar3))).getUnsubstitutedMemberScope();
                d0.z.d.m.checkNotNullExpressionValue(unsubstitutedMemberScope, "fakeJavaClassDescriptor.unsubstitutedMemberScope");
                Collection<? extends t0> collectionInvoke = g_c.invoke(unsubstitutedMemberScope);
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : collectionInvoke) {
                    t0 t0Var3 = (t0) obj;
                    if (t0Var3.getKind() == d0.e0.p.d.m0.c.b$a.DECLARATION && t0Var3.getVisibility().isPublicAPI() && !d0.e0.p.d.m0.b.h.isDeprecated(t0Var3)) {
                        Collection<? extends x> overriddenDescriptors = t0Var3.getOverriddenDescriptors();
                        d0.z.d.m.checkNotNullExpressionValue(overriddenDescriptors, "analogueMember.overriddenDescriptors");
                        if (overriddenDescriptors.isEmpty()) {
                            z3 = false;
                            break;
                        }
                        Iterator<T> it3 = overriddenDescriptors.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                z3 = false;
                                break;
                            }
                            d0.e0.p.d.m0.c.m containingDeclaration = ((x) it3.next()).getContainingDeclaration();
                            d0.z.d.m.checkNotNullExpressionValue(containingDeclaration, "it.containingDeclaration");
                            if (jVarCreate.contains(d0.e0.p.d.m0.k.x.a.getFqNameSafe(containingDeclaration))) {
                                z3 = true;
                                break;
                            }
                        }
                        if (z3) {
                            z2 = false;
                        } else {
                            if (p.a.getMUTABLE_METHOD_SIGNATURES().contains(t.signature(w.a, (d0.e0.p.d.m0.c.e) t0Var3.getContainingDeclaration(), d0.e0.p.d.m0.e.b.u.computeJvmDescriptor$default(t0Var3, false, false, 3, null))) ^ zIsMutable) {
                                zBooleanValue = true;
                            } else {
                                Boolean boolIfAny = d0.e0.p.d.m0.p.b.ifAny(d0.t.m.listOf(t0Var3), m.a, new n(this));
                                d0.z.d.m.checkNotNullExpressionValue(boolIfAny, "private fun SimpleFunctionDescriptor.isMutabilityViolation(isMutable: Boolean): Boolean {\n        val owner = containingDeclaration as ClassDescriptor\n        val jvmDescriptor = computeJvmDescriptor()\n\n        if ((SignatureBuildingComponents.signature(owner, jvmDescriptor) in MUTABLE_METHOD_SIGNATURES) xor isMutable) return true\n\n        return DFS.ifAny<CallableMemberDescriptor>(\n            listOf(this),\n            { it.original.overriddenDescriptors }\n        ) { overridden ->\n            overridden.kind == CallableMemberDescriptor.Kind.DECLARATION &&\n                    j2kClassMapper.isMutable(overridden.containingDeclaration as ClassDescriptor)\n        }\n    }");
                                zBooleanValue = boolIfAny.booleanValue();
                            }
                            if (zBooleanValue) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                        }
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        arrayList2.add(obj);
                    }
                }
                listEmptyList = arrayList2;
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (t0 t0Var4 : listEmptyList) {
            x xVarSubstitute = t0Var4.substitute(q.createMappedTypeParametersSubstitution((d0.e0.p.d.m0.c.e) t0Var4.getContainingDeclaration(), eVar2).buildSubstitutor());
            Objects.requireNonNull(xVarSubstitute, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
            x$a<? extends t0> x_aNewCopyBuilder2 = ((t0) xVarSubstitute).newCopyBuilder();
            x_aNewCopyBuilder2.setOwner(eVar2);
            x_aNewCopyBuilder2.setDispatchReceiverParameter(eVar2.getThisAsReceiverParameter());
            x_aNewCopyBuilder2.setPreserveSourceElement();
            Object objDfs = d0.e0.p.d.m0.p.b.dfs(d0.t.m.listOf((d0.e0.p.d.m0.c.e) t0Var4.getContainingDeclaration()), new k(this), new l(d0.e0.p.d.m0.e.b.u.computeJvmDescriptor$default(t0Var4, false, false, 3, null), new Ref$ObjectRef()));
            d0.z.d.m.checkNotNullExpressionValue(objDfs, "private fun FunctionDescriptor.getJdkMethodStatus(): JDKMemberStatus {\n        val owner = containingDeclaration as ClassDescriptor\n        val jvmDescriptor = computeJvmDescriptor()\n        var result: JDKMemberStatus? = null\n        return DFS.dfs<ClassDescriptor, JDKMemberStatus>(\n            listOf(owner),\n            {\n                // Search through mapped supertypes to determine that Set.toArray should be invisible, while we have only\n                // Collection.toArray there explicitly\n                // Note, that we can't find j.u.Collection.toArray within overriddenDescriptors of j.u.Set.toArray\n                it.typeConstructor.supertypes.mapNotNull {\n                    (it.constructor.declarationDescriptor?.original as? ClassDescriptor)?.getJavaAnalogue()\n                }\n            },\n            object : DFS.AbstractNodeHandler<ClassDescriptor, JDKMemberStatus>() {\n                override fun beforeChildren(javaClassDescriptor: ClassDescriptor): Boolean {\n                    val signature = SignatureBuildingComponents.signature(javaClassDescriptor, jvmDescriptor)\n                    when (signature) {\n                        in HIDDEN_METHOD_SIGNATURES -> result = JDKMemberStatus.HIDDEN\n                        in VISIBLE_METHOD_SIGNATURES -> result = JDKMemberStatus.VISIBLE\n                        in DROP_LIST_METHOD_SIGNATURES -> result = JDKMemberStatus.DROP\n                    }\n\n                    return result == null\n                }\n\n                override fun result() = result ?: JDKMemberStatus.NOT_CONSIDERED\n            })\n    }");
            int iOrdinal = ((g$a) objDfs).ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal == 2) {
                    x_aNewCopyBuilder2.setAdditionalAnnotations((d0.e0.p.d.m0.c.g1.g) d0.e0.p.d.m0.m.n.getValue(this.h, this, (KProperty<?>) a[2]));
                } else if (iOrdinal == 3) {
                    t0Var = null;
                }
                t0Var = (t0) x_aNewCopyBuilder2.build();
                d0.z.d.m.checkNotNull(t0Var);
            } else if (d0.e0.p.d.m0.c.a0.isFinalClass(eVar2)) {
                t0Var = null;
            } else {
                x_aNewCopyBuilder2.setHiddenForResolutionEverywhereBesideSupercalls();
                t0Var = (t0) x_aNewCopyBuilder2.build();
                d0.z.d.m.checkNotNull(t0Var);
            }
            if (t0Var != null) {
                arrayList3.add(t0Var);
            }
        }
        return arrayList3;
    }

    @Override // d0.e0.p.d.m0.c.h1.a
    public /* bridge */ /* synthetic */ Collection getFunctionsNames(d0.e0.p.d.m0.c.e eVar) {
        return getFunctionsNames(eVar);
    }

    @Override // d0.e0.p.d.m0.c.h1.a
    public Collection<d0.e0.p.d.m0.n.c0> getSupertypes(d0.e0.p.d.m0.c.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "classDescriptor");
        d0.e0.p.d.m0.g.c fqNameUnsafe = d0.e0.p.d.m0.k.x.a.getFqNameUnsafe(eVar);
        p pVar = p.a;
        if (!pVar.isArrayOrPrimitiveArray(fqNameUnsafe)) {
            return pVar.isSerializableInJava(fqNameUnsafe) ? d0.t.m.listOf(this.e) : d0.t.n.emptyList();
        }
        j0 j0Var = (j0) d0.e0.p.d.m0.m.n.getValue(this.f, this, (KProperty<?>) a[1]);
        d0.z.d.m.checkNotNullExpressionValue(j0Var, "cloneableType");
        return d0.t.n.listOf((Object[]) new d0.e0.p.d.m0.n.c0[]{j0Var, this.e});
    }

    @Override // d0.e0.p.d.m0.c.h1.c
    public boolean isFunctionAvailable(d0.e0.p.d.m0.c.e eVar, t0 t0Var) {
        d0.z.d.m.checkNotNullParameter(eVar, "classDescriptor");
        d0.z.d.m.checkNotNullParameter(t0Var, "functionDescriptor");
        d0.e0.p.d.m0.e.a.i0.l.f fVarA = a(eVar);
        if (fVarA == null || !t0Var.getAnnotations().hasAnnotation(d0.e0.p.d.m0.c.h1.d.getPLATFORM_DEPENDENT_ANNOTATION_FQ_NAME())) {
            return true;
        }
        if (!b().isAdditionalBuiltInsFeatureSupported()) {
            return false;
        }
        String strComputeJvmDescriptor$default = d0.e0.p.d.m0.e.b.u.computeJvmDescriptor$default(t0Var, false, false, 3, null);
        d0.e0.p.d.m0.e.a.i0.l.h unsubstitutedMemberScope = fVarA.getUnsubstitutedMemberScope();
        d0.e0.p.d.m0.g.e name = t0Var.getName();
        d0.z.d.m.checkNotNullExpressionValue(name, "functionDescriptor.name");
        Collection<t0> contributedFunctions = unsubstitutedMemberScope.getContributedFunctions(name, d0.e0.p.d.m0.d.b.d.FROM_BUILTINS);
        if (!(contributedFunctions instanceof Collection) || !contributedFunctions.isEmpty()) {
            Iterator<T> it = contributedFunctions.iterator();
            while (it.hasNext()) {
                if (d0.z.d.m.areEqual(d0.e0.p.d.m0.e.b.u.computeJvmDescriptor$default((t0) it.next(), false, false, 3, null), strComputeJvmDescriptor$default)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // d0.e0.p.d.m0.c.h1.a
    public Set<d0.e0.p.d.m0.g.e> getFunctionsNames(d0.e0.p.d.m0.c.e eVar) {
        d0.e0.p.d.m0.e.a.i0.l.h unsubstitutedMemberScope;
        d0.z.d.m.checkNotNullParameter(eVar, "classDescriptor");
        if (!b().isAdditionalBuiltInsFeatureSupported()) {
            return n0.emptySet();
        }
        d0.e0.p.d.m0.e.a.i0.l.f fVarA = a(eVar);
        Set<d0.e0.p.d.m0.g.e> functionNames = null;
        if (fVarA != null && (unsubstitutedMemberScope = fVarA.getUnsubstitutedMemberScope()) != null) {
            functionNames = unsubstitutedMemberScope.getFunctionNames();
        }
        return functionNames == null ? n0.emptySet() : functionNames;
    }
}
