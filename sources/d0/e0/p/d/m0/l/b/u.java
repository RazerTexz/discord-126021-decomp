package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.b$a;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.e0;
import d0.e0.p.d.m0.c.i1.d0;
import d0.e0.p.d.m0.c.i1.l0;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.y0;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.f.v$d;
import d0.e0.p.d.m0.f.z.b$b;
import d0.e0.p.d.m0.f.z.b$d;
import d0.e0.p.d.m0.l.b.e0.g$a;
import d0.e0.p.d.m0.n.w0;
import d0.t.h0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: compiled from: MemberDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u {
    public final l a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f3508b;

    public u(l lVar) {
        d0.z.d.m.checkNotNullParameter(lVar, "c");
        this.a = lVar;
        this.f3508b = new e(lVar.getComponents().getModuleDescriptor(), lVar.getComponents().getNotFoundClasses());
    }

    public static final /* synthetic */ y access$asProtoContainer(u uVar, d0.e0.p.d.m0.c.m mVar) {
        return uVar.a(mVar);
    }

    public static final /* synthetic */ l access$getC$p(u uVar) {
        return uVar.a;
    }

    public final y a(d0.e0.p.d.m0.c.m mVar) {
        if (mVar instanceof e0) {
            return new y$b(((e0) mVar).getFqName(), this.a.getNameResolver(), this.a.getTypeTable(), this.a.getContainerSource());
        }
        if (mVar instanceof d0.e0.p.d.m0.l.b.e0.d) {
            return ((d0.e0.p.d.m0.l.b.e0.d) mVar).getThisAsProtoContainer$deserialization();
        }
        return null;
    }

    public final g$a b(d0.e0.p.d.m0.l.b.e0.g gVar, c0 c0Var) {
        g$a g_a = g$a.COMPATIBLE;
        if (!i(gVar)) {
            return g_a;
        }
        Iterator<T> it = c0Var.getOwnTypeParameters().iterator();
        while (it.hasNext()) {
            ((z0) it.next()).getUpperBounds();
        }
        return c0Var.getExperimentalSuspendFunctionTypeEncountered() ? g$a.INCOMPATIBLE : g_a;
    }

    /* JADX WARN: Code duplicated, block: B:72:0x0124  */
    public final g$a c(d0.e0.p.d.m0.l.b.e0.b bVar, q0 q0Var, Collection<? extends c1> collection, Collection<? extends z0> collection2, d0.e0.p.d.m0.n.c0 c0Var, boolean z2) {
        boolean z3;
        boolean z4;
        g$a g_a;
        boolean z5;
        g$a g_a2 = g$a.NEEDS_WRAPPER;
        g$a g_a3 = g$a.INCOMPATIBLE;
        g$a g_a4 = g$a.COMPATIBLE;
        if (!i(bVar) || d0.z.d.m.areEqual(d0.e0.p.d.m0.k.x.a.fqNameOrNull(bVar), b0.a)) {
            return g_a4;
        }
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((c1) it.next()).getType());
        }
        List<d0.e0.p.d.m0.n.c0> listPlus = d0.t.u.plus((Collection) arrayList, (Iterable) d0.t.n.listOfNotNull(q0Var == null ? null : q0Var.getType()));
        if (d0.z.d.m.areEqual(c0Var != null ? Boolean.valueOf(d(c0Var)) : null, Boolean.TRUE)) {
            return g_a3;
        }
        if (!(collection2 instanceof Collection) || !collection2.isEmpty()) {
            Iterator<T> it2 = collection2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z4 = false;
                    break;
                }
                List<d0.e0.p.d.m0.n.c0> upperBounds = ((z0) it2.next()).getUpperBounds();
                d0.z.d.m.checkNotNullExpressionValue(upperBounds, "typeParameter.upperBounds");
                if (!(upperBounds instanceof Collection) || !upperBounds.isEmpty()) {
                    Iterator<T> it3 = upperBounds.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            z3 = false;
                            break;
                        }
                        d0.e0.p.d.m0.n.c0 c0Var2 = (d0.e0.p.d.m0.n.c0) it3.next();
                        d0.z.d.m.checkNotNullExpressionValue(c0Var2, "it");
                        if (d(c0Var2)) {
                            z3 = true;
                            break;
                        }
                    }
                } else {
                    z3 = false;
                    break;
                    break;
                }
                if (z3) {
                    z4 = true;
                    break;
                }
            }
        } else {
            z4 = false;
            break;
        }
        if (z4) {
            return g_a3;
        }
        ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(listPlus, 10));
        for (d0.e0.p.d.m0.n.c0 c0Var3 : listPlus) {
            d0.z.d.m.checkNotNullExpressionValue(c0Var3, "type");
            if (d0.e0.p.d.m0.b.g.isSuspendFunctionType(c0Var3) && c0Var3.getArguments().size() <= 3) {
                List<w0> arguments = c0Var3.getArguments();
                if (!(arguments instanceof Collection) || !arguments.isEmpty()) {
                    Iterator<T> it4 = arguments.iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            z5 = false;
                            break;
                        }
                        d0.e0.p.d.m0.n.c0 type = ((w0) it4.next()).getType();
                        d0.z.d.m.checkNotNullExpressionValue(type, "it.type");
                        if (d(type)) {
                            z5 = true;
                            break;
                        }
                    }
                } else {
                    z5 = false;
                    break;
                }
                if (z5) {
                    g_a = g_a3;
                } else {
                    g_a = g_a2;
                }
            } else if (d(c0Var3)) {
                g_a = g_a3;
            } else {
                g_a = g_a4;
            }
            arrayList2.add(g_a);
        }
        g$a g_a5 = (g$a) d0.t.u.maxOrNull((Iterable) arrayList2);
        if (g_a5 == null) {
            g_a5 = g_a4;
        }
        if (!z2) {
            g_a2 = g_a4;
        }
        return (g$a) d0.u.b.maxOf(g_a2, g_a5);
    }

    public final boolean d(d0.e0.p.d.m0.n.c0 c0Var) {
        return d0.e0.p.d.m0.n.o1.a.contains(c0Var, u$a.j);
    }

    public final d0.e0.p.d.m0.c.g1.g e(d0.e0.p.d.m0.i.n nVar, int i, b bVar) {
        return !d0.e0.p.d.m0.f.z.b.f3412b.get(i).booleanValue() ? d0.e0.p.d.m0.c.g1.g.f.getEMPTY() : new d0.e0.p.d.m0.l.b.e0.n(this.a.getStorageManager(), new u$b(this, nVar, bVar));
    }

    public final q0 f() {
        d0.e0.p.d.m0.c.m containingDeclaration = this.a.getContainingDeclaration();
        d0.e0.p.d.m0.c.e eVar = containingDeclaration instanceof d0.e0.p.d.m0.c.e ? (d0.e0.p.d.m0.c.e) containingDeclaration : null;
        if (eVar == null) {
            return null;
        }
        return eVar.getThisAsReceiverParameter();
    }

    public final d0.e0.p.d.m0.c.g1.g g(d0.e0.p.d.m0.f.n nVar, boolean z2) {
        return !d0.e0.p.d.m0.f.z.b.f3412b.get(nVar.getFlags()).booleanValue() ? d0.e0.p.d.m0.c.g1.g.f.getEMPTY() : new d0.e0.p.d.m0.l.b.e0.n(this.a.getStorageManager(), new u$c(this, z2, nVar));
    }

    public final List<c1> h(List<d0.e0.p.d.m0.f.u> list, d0.e0.p.d.m0.i.n nVar, b bVar) {
        d0.e0.p.d.m0.c.a aVar = (d0.e0.p.d.m0.c.a) this.a.getContainingDeclaration();
        d0.e0.p.d.m0.c.m containingDeclaration = aVar.getContainingDeclaration();
        d0.z.d.m.checkNotNullExpressionValue(containingDeclaration, "callableDescriptor.containingDeclaration");
        y yVarA = a(containingDeclaration);
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                d0.t.n.throwIndexOverflow();
            }
            d0.e0.p.d.m0.f.u uVar = (d0.e0.p.d.m0.f.u) obj;
            int flags = uVar.hasFlags() ? uVar.getFlags() : 0;
            d0.e0.p.d.m0.c.g1.g empty = (yVarA == null || !b.d.b.a.a.u0(d0.e0.p.d.m0.f.z.b.f3412b, flags, "HAS_ANNOTATIONS.get(flags)")) ? d0.e0.p.d.m0.c.g1.g.f.getEMPTY() : new d0.e0.p.d.m0.l.b.e0.n(this.a.getStorageManager(), new u$e(this, yVarA, nVar, bVar, i, uVar));
            d0.e0.p.d.m0.g.e name = w.getName(this.a.getNameResolver(), uVar.getName());
            d0.e0.p.d.m0.n.c0 c0VarType = this.a.getTypeDeserializer().type(d0.e0.p.d.m0.f.z.f.type(uVar, this.a.getTypeTable()));
            boolean zU0 = b.d.b.a.a.u0(d0.e0.p.d.m0.f.z.b.F, flags, "DECLARES_DEFAULT_VALUE.get(flags)");
            boolean zU1 = b.d.b.a.a.u0(d0.e0.p.d.m0.f.z.b.G, flags, "IS_CROSSINLINE.get(flags)");
            boolean zU2 = b.d.b.a.a.u0(d0.e0.p.d.m0.f.z.b.H, flags, "IS_NOINLINE.get(flags)");
            d0.e0.p.d.m0.f.q qVarVarargElementType = d0.e0.p.d.m0.f.z.f.varargElementType(uVar, this.a.getTypeTable());
            d0.e0.p.d.m0.n.c0 c0VarType2 = qVarVarargElementType == null ? null : this.a.getTypeDeserializer().type(qVarVarargElementType);
            u0 u0Var = u0.a;
            d0.z.d.m.checkNotNullExpressionValue(u0Var, "NO_SOURCE");
            ArrayList arrayList2 = arrayList;
            arrayList2.add(new l0(aVar, null, i, empty, name, c0VarType, zU0, zU1, zU2, c0VarType2, u0Var));
            arrayList = arrayList2;
            i = i2;
        }
        return d0.t.u.toList(arrayList);
    }

    public final boolean i(d0.e0.p.d.m0.l.b.e0.g gVar) {
        boolean z2;
        if (!this.a.getComponents().getConfiguration().getReleaseCoroutines()) {
            return false;
        }
        List<d0.e0.p.d.m0.f.z.h> versionRequirements = gVar.getVersionRequirements();
        if ((versionRequirements instanceof Collection) && versionRequirements.isEmpty()) {
            z2 = true;
        } else {
            for (d0.e0.p.d.m0.f.z.h hVar : versionRequirements) {
                if (d0.z.d.m.areEqual(hVar.getVersion(), new d0.e0.p.d.m0.f.z.h$b(1, 3, 0, 4, null)) && hVar.getKind() == v$d.LANGUAGE_VERSION) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    public final d0.e0.p.d.m0.c.d loadConstructor(d0.e0.p.d.m0.f.d dVar, boolean z2) {
        g$a g_aC;
        c0 typeDeserializer;
        d0.z.d.m.checkNotNullParameter(dVar, "proto");
        d0.e0.p.d.m0.c.e eVar = (d0.e0.p.d.m0.c.e) this.a.getContainingDeclaration();
        int flags = dVar.getFlags();
        b bVar = b.FUNCTION;
        d0.e0.p.d.m0.l.b.e0.c cVar = new d0.e0.p.d.m0.l.b.e0.c(eVar, null, e(dVar, flags, bVar), z2, b$a.DECLARATION, dVar, this.a.getNameResolver(), this.a.getTypeTable(), this.a.getVersionRequirementTable(), this.a.getContainerSource(), null, 1024, null);
        u memberDeserializer = l.childContext$default(this.a, cVar, d0.t.n.emptyList(), null, null, null, null, 60, null).getMemberDeserializer();
        List<d0.e0.p.d.m0.f.u> valueParameterList = dVar.getValueParameterList();
        d0.z.d.m.checkNotNullExpressionValue(valueParameterList, "proto.valueParameterList");
        cVar.initialize(memberDeserializer.h(valueParameterList, dVar, bVar), a0.descriptorVisibility(z.a, d0.e0.p.d.m0.f.z.b.c.get(dVar.getFlags())));
        cVar.setReturnType(eVar.getDefaultType());
        cVar.setHasStableParameterNames(!d0.e0.p.d.m0.f.z.b.m.get(dVar.getFlags()).booleanValue());
        d0.e0.p.d.m0.c.m containingDeclaration = this.a.getContainingDeclaration();
        Boolean boolValueOf = null;
        d0.e0.p.d.m0.l.b.e0.d dVar2 = containingDeclaration instanceof d0.e0.p.d.m0.l.b.e0.d ? (d0.e0.p.d.m0.l.b.e0.d) containingDeclaration : null;
        l c = dVar2 == null ? null : dVar2.getC();
        if (c != null && (typeDeserializer = c.getTypeDeserializer()) != null) {
            boolValueOf = Boolean.valueOf(typeDeserializer.getExperimentalSuspendFunctionTypeEncountered());
        }
        if (d0.z.d.m.areEqual(boolValueOf, Boolean.TRUE) && i(cVar)) {
            g_aC = g$a.INCOMPATIBLE;
        } else {
            Collection<? extends c1> valueParameters = cVar.getValueParameters();
            d0.z.d.m.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
            Collection<? extends z0> typeParameters = cVar.getTypeParameters();
            d0.z.d.m.checkNotNullExpressionValue(typeParameters, "descriptor.typeParameters");
            g_aC = c(cVar, null, valueParameters, typeParameters, cVar.getReturnType(), false);
        }
        cVar.setCoroutinesExperimentalCompatibilityMode$deserialization(g_aC);
        return cVar;
    }

    public final t0 loadFunction(d0.e0.p.d.m0.f.i iVar) {
        int flags;
        d0.e0.p.d.m0.n.c0 c0VarType;
        d0.z.d.m.checkNotNullParameter(iVar, "proto");
        if (iVar.hasFlags()) {
            flags = iVar.getFlags();
        } else {
            int oldFlags = iVar.getOldFlags();
            flags = ((oldFlags >> 8) << 6) + (oldFlags & 63);
        }
        int i = flags;
        b bVar = b.FUNCTION;
        d0.e0.p.d.m0.c.g1.g gVarE = e(iVar, i, bVar);
        d0.e0.p.d.m0.c.g1.g aVar = d0.e0.p.d.m0.f.z.f.hasReceiver(iVar) ? new d0.e0.p.d.m0.l.b.e0.a(this.a.getStorageManager(), new v(this, iVar, bVar)) : d0.e0.p.d.m0.c.g1.g.f.getEMPTY();
        d0.e0.p.d.m0.f.z.i empty = d0.z.d.m.areEqual(d0.e0.p.d.m0.k.x.a.getFqNameSafe(this.a.getContainingDeclaration()).child(w.getName(this.a.getNameResolver(), iVar.getName())), b0.a) ? d0.e0.p.d.m0.f.z.i.a.getEMPTY() : this.a.getVersionRequirementTable();
        d0.e0.p.d.m0.c.m containingDeclaration = this.a.getContainingDeclaration();
        d0.e0.p.d.m0.g.e name = w.getName(this.a.getNameResolver(), iVar.getName());
        z zVar = z.a;
        d0.e0.p.d.m0.l.b.e0.k kVar = new d0.e0.p.d.m0.l.b.e0.k(containingDeclaration, null, gVarE, name, a0.memberKind(zVar, d0.e0.p.d.m0.f.z.b.n.get(i)), iVar, this.a.getNameResolver(), this.a.getTypeTable(), empty, this.a.getContainerSource(), null, 1024, null);
        l lVar = this.a;
        List<d0.e0.p.d.m0.f.s> typeParameterList = iVar.getTypeParameterList();
        d0.z.d.m.checkNotNullExpressionValue(typeParameterList, "proto.typeParameterList");
        l lVarChildContext$default = l.childContext$default(lVar, kVar, typeParameterList, null, null, null, null, 60, null);
        d0.e0.p.d.m0.f.q qVarReceiverType = d0.e0.p.d.m0.f.z.f.receiverType(iVar, this.a.getTypeTable());
        q0 q0VarCreateExtensionReceiverParameterForCallable = (qVarReceiverType == null || (c0VarType = lVarChildContext$default.getTypeDeserializer().type(qVarReceiverType)) == null) ? null : d0.e0.p.d.m0.k.d.createExtensionReceiverParameterForCallable(kVar, c0VarType, aVar);
        q0 q0VarF = f();
        List<z0> ownTypeParameters = lVarChildContext$default.getTypeDeserializer().getOwnTypeParameters();
        u memberDeserializer = lVarChildContext$default.getMemberDeserializer();
        List<d0.e0.p.d.m0.f.u> valueParameterList = iVar.getValueParameterList();
        d0.z.d.m.checkNotNullExpressionValue(valueParameterList, "proto.valueParameterList");
        List<c1> listH = memberDeserializer.h(valueParameterList, iVar, bVar);
        d0.e0.p.d.m0.n.c0 c0VarType2 = lVarChildContext$default.getTypeDeserializer().type(d0.e0.p.d.m0.f.z.f.returnType(iVar, this.a.getTypeTable()));
        d0.e0.p.d.m0.c.z zVarModality = zVar.modality(d0.e0.p.d.m0.f.z.b.d.get(i));
        d0.e0.p.d.m0.c.u uVarDescriptorVisibility = a0.descriptorVisibility(zVar, d0.e0.p.d.m0.f.z.b.c.get(i));
        Map<? extends d0.e0.p.d.m0.c.a$a<?>, ?> mapEmptyMap = h0.emptyMap();
        b$b b_b = d0.e0.p.d.m0.f.z.b.t;
        kVar.initialize(q0VarCreateExtensionReceiverParameterForCallable, q0VarF, ownTypeParameters, listH, c0VarType2, zVarModality, uVarDescriptorVisibility, mapEmptyMap, c(kVar, q0VarCreateExtensionReceiverParameterForCallable, listH, ownTypeParameters, c0VarType2, b.d.b.a.a.u0(b_b, i, "IS_SUSPEND.get(flags)")));
        Boolean bool = d0.e0.p.d.m0.f.z.b.o.get(i);
        d0.z.d.m.checkNotNullExpressionValue(bool, "IS_OPERATOR.get(flags)");
        kVar.setOperator(bool.booleanValue());
        Boolean bool2 = d0.e0.p.d.m0.f.z.b.p.get(i);
        d0.z.d.m.checkNotNullExpressionValue(bool2, "IS_INFIX.get(flags)");
        kVar.setInfix(bool2.booleanValue());
        Boolean bool3 = d0.e0.p.d.m0.f.z.b.f3413s.get(i);
        d0.z.d.m.checkNotNullExpressionValue(bool3, "IS_EXTERNAL_FUNCTION.get(flags)");
        kVar.setExternal(bool3.booleanValue());
        Boolean bool4 = d0.e0.p.d.m0.f.z.b.q.get(i);
        d0.z.d.m.checkNotNullExpressionValue(bool4, "IS_INLINE.get(flags)");
        kVar.setInline(bool4.booleanValue());
        Boolean bool5 = d0.e0.p.d.m0.f.z.b.r.get(i);
        d0.z.d.m.checkNotNullExpressionValue(bool5, "IS_TAILREC.get(flags)");
        kVar.setTailrec(bool5.booleanValue());
        Boolean bool6 = b_b.get(i);
        d0.z.d.m.checkNotNullExpressionValue(bool6, "IS_SUSPEND.get(flags)");
        kVar.setSuspend(bool6.booleanValue());
        Boolean bool7 = d0.e0.p.d.m0.f.z.b.u.get(i);
        d0.z.d.m.checkNotNullExpressionValue(bool7, "IS_EXPECT_FUNCTION.get(flags)");
        kVar.setExpect(bool7.booleanValue());
        kVar.setHasStableParameterNames(!d0.e0.p.d.m0.f.z.b.v.get(i).booleanValue());
        Pair<d0.e0.p.d.m0.c.a$a<?>, Object> pairDeserializeContractFromFunction = this.a.getComponents().getContractDeserializer().deserializeContractFromFunction(iVar, kVar, this.a.getTypeTable(), lVarChildContext$default.getTypeDeserializer());
        if (pairDeserializeContractFromFunction != null) {
            kVar.putInUserDataMap(pairDeserializeContractFromFunction.getFirst(), pairDeserializeContractFromFunction.getSecond());
        }
        return kVar;
    }

    public final n0 loadProperty(d0.e0.p.d.m0.f.n nVar) {
        int flags;
        d0.e0.p.d.m0.f.n nVar2;
        b bVar;
        d0.e0.p.d.m0.c.g1.g empty;
        q0 q0VarCreateExtensionReceiverParameterForCallable;
        d0.e0.p.d.m0.l.b.e0.j jVar;
        z zVar;
        d0 d0Var;
        d0.e0.p.d.m0.c.i1.e0 e0Var;
        d0 d0VarCreateDefaultGetter;
        d0.e0.p.d.m0.n.c0 c0VarType;
        b bVar2 = b.PROPERTY_GETTER;
        d0.z.d.m.checkNotNullParameter(nVar, "proto");
        if (nVar.hasFlags()) {
            flags = nVar.getFlags();
        } else {
            int oldFlags = nVar.getOldFlags();
            flags = ((oldFlags >> 8) << 6) + (oldFlags & 63);
        }
        int i = flags;
        d0.e0.p.d.m0.c.m containingDeclaration = this.a.getContainingDeclaration();
        d0.e0.p.d.m0.c.g1.g gVarE = e(nVar, i, b.PROPERTY);
        z zVar2 = z.a;
        b$d<d0.e0.p.d.m0.f.k> b_d = d0.e0.p.d.m0.f.z.b.d;
        d0.e0.p.d.m0.c.z zVarModality = zVar2.modality(b_d.get(i));
        b$d<d0.e0.p.d.m0.f.x> b_d2 = d0.e0.p.d.m0.f.z.b.c;
        d0.e0.p.d.m0.l.b.e0.j jVar2 = new d0.e0.p.d.m0.l.b.e0.j(containingDeclaration, null, gVarE, zVarModality, a0.descriptorVisibility(zVar2, b_d2.get(i)), b.d.b.a.a.u0(d0.e0.p.d.m0.f.z.b.w, i, "IS_VAR.get(flags)"), w.getName(this.a.getNameResolver(), nVar.getName()), a0.memberKind(zVar2, d0.e0.p.d.m0.f.z.b.n.get(i)), b.d.b.a.a.u0(d0.e0.p.d.m0.f.z.b.A, i, "IS_LATEINIT.get(flags)"), b.d.b.a.a.u0(d0.e0.p.d.m0.f.z.b.f3416z, i, "IS_CONST.get(flags)"), b.d.b.a.a.u0(d0.e0.p.d.m0.f.z.b.C, i, "IS_EXTERNAL_PROPERTY.get(flags)"), b.d.b.a.a.u0(d0.e0.p.d.m0.f.z.b.D, i, "IS_DELEGATED.get(flags)"), b.d.b.a.a.u0(d0.e0.p.d.m0.f.z.b.E, i, "IS_EXPECT_PROPERTY.get(flags)"), nVar, this.a.getNameResolver(), this.a.getTypeTable(), this.a.getVersionRequirementTable(), this.a.getContainerSource());
        l lVar = this.a;
        List<d0.e0.p.d.m0.f.s> typeParameterList = nVar.getTypeParameterList();
        d0.z.d.m.checkNotNullExpressionValue(typeParameterList, "proto.typeParameterList");
        l lVarChildContext$default = l.childContext$default(lVar, jVar2, typeParameterList, null, null, null, null, 60, null);
        boolean zU0 = b.d.b.a.a.u0(d0.e0.p.d.m0.f.z.b.f3414x, i, "HAS_GETTER.get(flags)");
        if (zU0 && d0.e0.p.d.m0.f.z.f.hasReceiver(nVar)) {
            nVar2 = nVar;
            bVar = bVar2;
            empty = new d0.e0.p.d.m0.l.b.e0.a(this.a.getStorageManager(), new v(this, nVar2, bVar));
        } else {
            nVar2 = nVar;
            bVar = bVar2;
            empty = d0.e0.p.d.m0.c.g1.g.f.getEMPTY();
        }
        d0.e0.p.d.m0.n.c0 c0VarType2 = lVarChildContext$default.getTypeDeserializer().type(d0.e0.p.d.m0.f.z.f.returnType(nVar2, this.a.getTypeTable()));
        List<z0> ownTypeParameters = lVarChildContext$default.getTypeDeserializer().getOwnTypeParameters();
        q0 q0VarF = f();
        d0.e0.p.d.m0.f.q qVarReceiverType = d0.e0.p.d.m0.f.z.f.receiverType(nVar2, this.a.getTypeTable());
        if (qVarReceiverType == null || (c0VarType = lVarChildContext$default.getTypeDeserializer().type(qVarReceiverType)) == null) {
            q0VarCreateExtensionReceiverParameterForCallable = null;
            jVar = jVar2;
        } else {
            jVar = jVar2;
            q0VarCreateExtensionReceiverParameterForCallable = d0.e0.p.d.m0.k.d.createExtensionReceiverParameterForCallable(jVar, c0VarType, empty);
        }
        jVar.setType(c0VarType2, ownTypeParameters, q0VarF, q0VarCreateExtensionReceiverParameterForCallable);
        int accessorFlags = d0.e0.p.d.m0.f.z.b.getAccessorFlags(b.d.b.a.a.u0(d0.e0.p.d.m0.f.z.b.f3412b, i, "HAS_ANNOTATIONS.get(flags)"), b_d2.get(i), b_d.get(i), false, false, false);
        if (zU0) {
            int getterFlags = nVar.hasGetterFlags() ? nVar.getGetterFlags() : accessorFlags;
            boolean zU1 = b.d.b.a.a.u0(d0.e0.p.d.m0.f.z.b.I, getterFlags, "IS_NOT_DEFAULT.get(getterFlags)");
            boolean zU2 = b.d.b.a.a.u0(d0.e0.p.d.m0.f.z.b.J, getterFlags, "IS_EXTERNAL_ACCESSOR.get(getterFlags)");
            boolean zU3 = b.d.b.a.a.u0(d0.e0.p.d.m0.f.z.b.K, getterFlags, "IS_INLINE_ACCESSOR.get(getterFlags)");
            d0.e0.p.d.m0.c.g1.g gVarE2 = e(nVar2, getterFlags, bVar);
            if (zU1) {
                zVar = zVar2;
                d0VarCreateDefaultGetter = new d0(jVar, gVarE2, zVar2.modality(b_d.get(getterFlags)), a0.descriptorVisibility(zVar2, b_d2.get(getterFlags)), !zU1, zU2, zU3, jVar.getKind(), null, u0.a);
            } else {
                zVar = zVar2;
                d0VarCreateDefaultGetter = d0.e0.p.d.m0.k.d.createDefaultGetter(jVar, gVarE2);
                d0.z.d.m.checkNotNullExpressionValue(d0VarCreateDefaultGetter, "{\n                DescriptorFactory.createDefaultGetter(property, annotations)\n            }");
            }
            d0VarCreateDefaultGetter.initialize(jVar.getReturnType());
            d0Var = d0VarCreateDefaultGetter;
        } else {
            zVar = zVar2;
            d0Var = null;
        }
        if (b.d.b.a.a.u0(d0.e0.p.d.m0.f.z.b.f3415y, i, "HAS_SETTER.get(flags)")) {
            if (nVar.hasSetterFlags()) {
                accessorFlags = nVar.getSetterFlags();
            }
            boolean zU4 = b.d.b.a.a.u0(d0.e0.p.d.m0.f.z.b.I, accessorFlags, "IS_NOT_DEFAULT.get(setterFlags)");
            boolean zU5 = b.d.b.a.a.u0(d0.e0.p.d.m0.f.z.b.J, accessorFlags, "IS_EXTERNAL_ACCESSOR.get(setterFlags)");
            boolean zU6 = b.d.b.a.a.u0(d0.e0.p.d.m0.f.z.b.K, accessorFlags, "IS_INLINE_ACCESSOR.get(setterFlags)");
            b bVar3 = b.PROPERTY_SETTER;
            d0.e0.p.d.m0.c.g1.g gVarE3 = e(nVar2, accessorFlags, bVar3);
            if (zU4) {
                d0.e0.p.d.m0.c.i1.e0 e0Var2 = new d0.e0.p.d.m0.c.i1.e0(jVar, gVarE3, zVar.modality(b_d.get(accessorFlags)), a0.descriptorVisibility(zVar, b_d2.get(accessorFlags)), !zU4, zU5, zU6, jVar.getKind(), null, u0.a);
                e0Var2.initialize((c1) d0.t.u.single((List) l.childContext$default(lVarChildContext$default, e0Var2, d0.t.n.emptyList(), null, null, null, null, 60, null).getMemberDeserializer().h(d0.t.m.listOf(nVar.getSetterValueParameter()), nVar2, bVar3)));
                e0Var = e0Var2;
            } else {
                d0.e0.p.d.m0.c.i1.e0 e0VarCreateDefaultSetter = d0.e0.p.d.m0.k.d.createDefaultSetter(jVar, gVarE3, d0.e0.p.d.m0.c.g1.g.f.getEMPTY());
                d0.z.d.m.checkNotNullExpressionValue(e0VarCreateDefaultSetter, "{\n                DescriptorFactory.createDefaultSetter(\n                    property, annotations,\n                    Annotations.EMPTY /* Otherwise the setter is not default, see DescriptorResolver.resolvePropertySetterDescriptor */\n                )\n            }");
                e0Var = e0VarCreateDefaultSetter;
            }
        } else {
            e0Var = null;
        }
        if (b.d.b.a.a.u0(d0.e0.p.d.m0.f.z.b.B, i, "HAS_CONSTANT.get(flags)")) {
            jVar.setCompileTimeInitializer(this.a.getStorageManager().createNullableLazyValue(new u$d(this, nVar2, jVar)));
        }
        jVar.initialize(d0Var, e0Var, new d0.e0.p.d.m0.c.i1.p(g(nVar2, false), jVar), new d0.e0.p.d.m0.c.i1.p(g(nVar2, true), jVar), b(jVar, lVarChildContext$default.getTypeDeserializer()));
        return jVar;
    }

    public final y0 loadTypeAlias(d0.e0.p.d.m0.f.r rVar) {
        d0.z.d.m.checkNotNullParameter(rVar, "proto");
        d0.e0.p.d.m0.c.g1.g$a g_a = d0.e0.p.d.m0.c.g1.g.f;
        List<d0.e0.p.d.m0.f.b> annotationList = rVar.getAnnotationList();
        d0.z.d.m.checkNotNullExpressionValue(annotationList, "proto.annotationList");
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(annotationList, 10));
        for (d0.e0.p.d.m0.f.b bVar : annotationList) {
            e eVar = this.f3508b;
            d0.z.d.m.checkNotNullExpressionValue(bVar, "it");
            arrayList.add(eVar.deserializeAnnotation(bVar, this.a.getNameResolver()));
        }
        d0.e0.p.d.m0.l.b.e0.l lVar = new d0.e0.p.d.m0.l.b.e0.l(this.a.getStorageManager(), this.a.getContainingDeclaration(), g_a.create(arrayList), w.getName(this.a.getNameResolver(), rVar.getName()), a0.descriptorVisibility(z.a, d0.e0.p.d.m0.f.z.b.c.get(rVar.getFlags())), rVar, this.a.getNameResolver(), this.a.getTypeTable(), this.a.getVersionRequirementTable(), this.a.getContainerSource());
        l lVar2 = this.a;
        List<d0.e0.p.d.m0.f.s> typeParameterList = rVar.getTypeParameterList();
        d0.z.d.m.checkNotNullExpressionValue(typeParameterList, "proto.typeParameterList");
        l lVarChildContext$default = l.childContext$default(lVar2, lVar, typeParameterList, null, null, null, null, 60, null);
        lVar.initialize(lVarChildContext$default.getTypeDeserializer().getOwnTypeParameters(), lVarChildContext$default.getTypeDeserializer().simpleType(d0.e0.p.d.m0.f.z.f.underlyingType(rVar, this.a.getTypeTable()), false), lVarChildContext$default.getTypeDeserializer().simpleType(d0.e0.p.d.m0.f.z.f.expandedType(rVar, this.a.getTypeTable()), false), b(lVar, lVarChildContext$default.getTypeDeserializer()));
        return lVar;
    }
}
