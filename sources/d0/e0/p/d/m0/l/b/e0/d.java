package d0.e0.p.d.m0.l.b.e0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.r0;
import d0.e0.p.d.m0.c.u;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.z;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.f.c$c;
import d0.e0.p.d.m0.f.s;
import d0.e0.p.d.m0.f.t;
import d0.e0.p.d.m0.f.z.i$a;
import d0.e0.p.d.m0.k.a0.i$b;
import d0.e0.p.d.m0.l.b.a0;
import d0.e0.p.d.m0.l.b.w;
import d0.e0.p.d.m0.l.b.y$a;
import d0.t.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends d0.e0.p.d.m0.c.i1.a implements d0.e0.p.d.m0.c.m {
    public final d0.e0.p.d.m0.c.m A;
    public final d0.e0.p.d.m0.m.k<d0.e0.p.d.m0.c.d> B;
    public final d0.e0.p.d.m0.m.j<Collection<d0.e0.p.d.m0.c.d>> C;
    public final d0.e0.p.d.m0.m.k<d0.e0.p.d.m0.c.e> D;
    public final d0.e0.p.d.m0.m.j<Collection<d0.e0.p.d.m0.c.e>> E;
    public final y$a F;
    public final d0.e0.p.d.m0.c.g1.g G;
    public final d0.e0.p.d.m0.f.c o;
    public final d0.e0.p.d.m0.f.z.a p;
    public final u0 q;
    public final d0.e0.p.d.m0.g.a r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final z f3487s;
    public final u t;
    public final d0.e0.p.d.m0.c.f u;
    public final d0.e0.p.d.m0.l.b.l v;
    public final d0.e0.p.d.m0.k.a0.j w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final d$b f3488x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final r0<d$a> f3489y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final d$c f3490z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(d0.e0.p.d.m0.l.b.l lVar, d0.e0.p.d.m0.f.c cVar, d0.e0.p.d.m0.f.z.c cVar2, d0.e0.p.d.m0.f.z.a aVar, u0 u0Var) {
        super(lVar.getStorageManager(), w.getClassId(cVar2, cVar.getFqName()).getShortClassName());
        d0.z.d.m.checkNotNullParameter(lVar, "outerContext");
        d0.z.d.m.checkNotNullParameter(cVar, "classProto");
        d0.z.d.m.checkNotNullParameter(cVar2, "nameResolver");
        d0.z.d.m.checkNotNullParameter(aVar, "metadataVersion");
        d0.z.d.m.checkNotNullParameter(u0Var, "sourceElement");
        this.o = cVar;
        this.p = aVar;
        this.q = u0Var;
        this.r = w.getClassId(cVar2, cVar.getFqName());
        d0.e0.p.d.m0.l.b.z zVar = d0.e0.p.d.m0.l.b.z.a;
        this.f3487s = zVar.modality(d0.e0.p.d.m0.f.z.b.d.get(cVar.getFlags()));
        this.t = a0.descriptorVisibility(zVar, d0.e0.p.d.m0.f.z.b.c.get(cVar.getFlags()));
        d0.e0.p.d.m0.c.f fVarClassKind = zVar.classKind(d0.e0.p.d.m0.f.z.b.e.get(cVar.getFlags()));
        this.u = fVarClassKind;
        List<s> typeParameterList = cVar.getTypeParameterList();
        d0.z.d.m.checkNotNullExpressionValue(typeParameterList, "classProto.typeParameterList");
        t typeTable = cVar.getTypeTable();
        d0.z.d.m.checkNotNullExpressionValue(typeTable, "classProto.typeTable");
        d0.e0.p.d.m0.f.z.g gVar = new d0.e0.p.d.m0.f.z.g(typeTable);
        i$a i_a = d0.e0.p.d.m0.f.z.i.a;
        d0.e0.p.d.m0.f.w versionRequirementTable = cVar.getVersionRequirementTable();
        d0.z.d.m.checkNotNullExpressionValue(versionRequirementTable, "classProto.versionRequirementTable");
        d0.e0.p.d.m0.l.b.l lVarChildContext = lVar.childContext(this, typeParameterList, cVar2, gVar, i_a.create(versionRequirementTable), aVar);
        this.v = lVarChildContext;
        d0.e0.p.d.m0.c.f fVar = d0.e0.p.d.m0.c.f.ENUM_CLASS;
        this.w = fVarClassKind == fVar ? new d0.e0.p.d.m0.k.a0.m(lVarChildContext.getStorageManager(), this) : i$b.f3461b;
        this.f3488x = new d$b(this);
        this.f3489y = r0.a.create(this, lVarChildContext.getStorageManager(), lVarChildContext.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner(), new d$g(this));
        this.f3490z = fVarClassKind == fVar ? new d$c(this) : null;
        d0.e0.p.d.m0.c.m containingDeclaration = lVar.getContainingDeclaration();
        this.A = containingDeclaration;
        this.B = lVarChildContext.getStorageManager().createNullableLazyValue(new d$h(this));
        this.C = lVarChildContext.getStorageManager().createLazyValue(new d$f(this));
        this.D = lVarChildContext.getStorageManager().createNullableLazyValue(new d$e(this));
        this.E = lVarChildContext.getStorageManager().createLazyValue(new d$i(this));
        d0.e0.p.d.m0.f.z.c nameResolver = lVarChildContext.getNameResolver();
        d0.e0.p.d.m0.f.z.g typeTable2 = lVarChildContext.getTypeTable();
        d dVar = containingDeclaration instanceof d ? (d) containingDeclaration : null;
        this.F = new y$a(cVar, nameResolver, typeTable2, u0Var, dVar != null ? dVar.F : null);
        this.G = !d0.e0.p.d.m0.f.z.b.f3412b.get(cVar.getFlags()).booleanValue() ? d0.e0.p.d.m0.c.g1.g.f.getEMPTY() : new n(lVarChildContext.getStorageManager(), new d$d(this));
    }

    public static final d0.e0.p.d.m0.c.e access$computeCompanionObjectDescriptor(d dVar) {
        if (!dVar.o.hasCompanionObjectName()) {
            return null;
        }
        d0.e0.p.d.m0.c.h contributedClassifier = dVar.b().getContributedClassifier(w.getName(dVar.v.getNameResolver(), dVar.o.getCompanionObjectName()), d0.e0.p.d.m0.d.b.d.FROM_DESERIALIZATION);
        if (contributedClassifier instanceof d0.e0.p.d.m0.c.e) {
            return (d0.e0.p.d.m0.c.e) contributedClassifier;
        }
        return null;
    }

    public static final Collection access$computeConstructors(d dVar) {
        List<d0.e0.p.d.m0.f.d> constructorList = dVar.o.getConstructorList();
        ArrayList<d0.e0.p.d.m0.f.d> arrayListA0 = b.d.b.a.a.a0(constructorList, "classProto.constructorList");
        for (Object obj : constructorList) {
            Boolean bool = d0.e0.p.d.m0.f.z.b.l.get(((d0.e0.p.d.m0.f.d) obj).getFlags());
            d0.z.d.m.checkNotNullExpressionValue(bool, "IS_SECONDARY.get(it.flags)");
            if (bool.booleanValue()) {
                arrayListA0.add(obj);
            }
        }
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(arrayListA0, 10));
        for (d0.e0.p.d.m0.f.d dVar2 : arrayListA0) {
            d0.e0.p.d.m0.l.b.u memberDeserializer = dVar.getC().getMemberDeserializer();
            d0.z.d.m.checkNotNullExpressionValue(dVar2, "it");
            arrayList.add(memberDeserializer.loadConstructor(dVar2, false));
        }
        return d0.t.u.plus((Collection) d0.t.u.plus((Collection) arrayList, (Iterable) d0.t.n.listOfNotNull(dVar.getUnsubstitutedPrimaryConstructor())), (Iterable) dVar.v.getComponents().getAdditionalClassPartsProvider().getConstructors(dVar));
    }

    public static final d0.e0.p.d.m0.c.d access$computePrimaryConstructor(d dVar) {
        Object next;
        if (dVar.u.isSingleton()) {
            d0.e0.p.d.m0.c.i1.g gVarCreatePrimaryConstructorForObject = d0.e0.p.d.m0.k.d.createPrimaryConstructorForObject(dVar, u0.a);
            gVarCreatePrimaryConstructorForObject.setReturnType(dVar.getDefaultType());
            return gVarCreatePrimaryConstructorForObject;
        }
        List<d0.e0.p.d.m0.f.d> constructorList = dVar.o.getConstructorList();
        d0.z.d.m.checkNotNullExpressionValue(constructorList, "classProto.constructorList");
        Iterator<T> it = constructorList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(!d0.e0.p.d.m0.f.z.b.l.get(((d0.e0.p.d.m0.f.d) next).getFlags()).booleanValue()));
        d0.e0.p.d.m0.f.d dVar2 = (d0.e0.p.d.m0.f.d) next;
        if (dVar2 == null) {
            return null;
        }
        return dVar.getC().getMemberDeserializer().loadConstructor(dVar2, true);
    }

    public static final Collection access$computeSubclassesForSealedClass(d dVar) {
        if (dVar.f3487s != z.SEALED) {
            return d0.t.n.emptyList();
        }
        List<Integer> sealedSubclassFqNameList = dVar.o.getSealedSubclassFqNameList();
        d0.z.d.m.checkNotNullExpressionValue(sealedSubclassFqNameList, "fqNames");
        if (!(!sealedSubclassFqNameList.isEmpty())) {
            return d0.e0.p.d.m0.k.a.a.computeSealedSubclasses(dVar, false);
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : sealedSubclassFqNameList) {
            d0.e0.p.d.m0.l.b.j components = dVar.getC().getComponents();
            d0.e0.p.d.m0.f.z.c nameResolver = dVar.getC().getNameResolver();
            d0.z.d.m.checkNotNullExpressionValue(num, "index");
            d0.e0.p.d.m0.c.e eVarDeserializeClass = components.deserializeClass(w.getClassId(nameResolver, num.intValue()));
            if (eVarDeserializeClass != null) {
                arrayList.add(eVarDeserializeClass);
            }
        }
        return arrayList;
    }

    public static final /* synthetic */ d0.e0.p.d.m0.g.a access$getClassId$p(d dVar) {
        return dVar.r;
    }

    public static final /* synthetic */ d$c access$getEnumEntries$p(d dVar) {
        return dVar.f3490z;
    }

    public static final /* synthetic */ d$b access$getTypeConstructor$p(d dVar) {
        return dVar.f3488x;
    }

    public final d$a b() {
        return (d$a) this.f3489y.getScope(this.v.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner());
    }

    @Override // d0.e0.p.d.m0.c.g1.a
    public d0.e0.p.d.m0.c.g1.g getAnnotations() {
        return this.G;
    }

    public final d0.e0.p.d.m0.l.b.l getC() {
        return this.v;
    }

    public final d0.e0.p.d.m0.f.c getClassProto() {
        return this.o;
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.c.e getCompanionObjectDescriptor() {
        return this.D.invoke();
    }

    @Override // d0.e0.p.d.m0.c.e
    public Collection<d0.e0.p.d.m0.c.d> getConstructors() {
        return this.C.invoke();
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.n, d0.e0.p.d.m0.c.m
    public d0.e0.p.d.m0.c.m getContainingDeclaration() {
        return this.A;
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.i
    public List<z0> getDeclaredTypeParameters() {
        return this.v.getTypeDeserializer().getOwnTypeParameters();
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.c.f getKind() {
        return this.u;
    }

    public final d0.e0.p.d.m0.f.z.a getMetadataVersion() {
        return this.p;
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.y
    public z getModality() {
        return this.f3487s;
    }

    @Override // d0.e0.p.d.m0.c.e
    public Collection<d0.e0.p.d.m0.c.e> getSealedSubclasses() {
        return this.E.invoke();
    }

    @Override // d0.e0.p.d.m0.c.p
    public u0 getSource() {
        return this.q;
    }

    @Override // d0.e0.p.d.m0.c.e
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.k.a0.i getStaticScope() {
        return getStaticScope();
    }

    public final y$a getThisAsProtoContainer$deserialization() {
        return this.F;
    }

    @Override // d0.e0.p.d.m0.c.h
    public d0.e0.p.d.m0.n.u0 getTypeConstructor() {
        return this.f3488x;
    }

    @Override // d0.e0.p.d.m0.c.i1.u
    public d0.e0.p.d.m0.k.a0.i getUnsubstitutedMemberScope(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        return this.f3489y.getScope(gVar);
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.c.d getUnsubstitutedPrimaryConstructor() {
        return this.B.invoke();
    }

    @Override // d0.e0.p.d.m0.c.e, d0.e0.p.d.m0.c.q, d0.e0.p.d.m0.c.y
    public u getVisibility() {
        return this.t;
    }

    public final boolean hasNestedClass$deserialization(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return b().getClassNames$deserialization().contains(eVar);
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isActual() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isCompanionObject() {
        return d0.e0.p.d.m0.f.z.b.e.get(this.o.getFlags()) == c$c.COMPANION_OBJECT;
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isData() {
        Boolean bool = d0.e0.p.d.m0.f.z.b.g.get(this.o.getFlags());
        d0.z.d.m.checkNotNullExpressionValue(bool, "IS_DATA.get(classProto.flags)");
        return bool.booleanValue();
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isExpect() {
        Boolean bool = d0.e0.p.d.m0.f.z.b.i.get(this.o.getFlags());
        d0.z.d.m.checkNotNullExpressionValue(bool, "IS_EXPECT_CLASS.get(classProto.flags)");
        return bool.booleanValue();
    }

    @Override // d0.e0.p.d.m0.c.y
    public boolean isExternal() {
        Boolean bool = d0.e0.p.d.m0.f.z.b.h.get(this.o.getFlags());
        d0.z.d.m.checkNotNullExpressionValue(bool, "IS_EXTERNAL_CLASS.get(classProto.flags)");
        return bool.booleanValue();
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isFun() {
        Boolean bool = d0.e0.p.d.m0.f.z.b.k.get(this.o.getFlags());
        d0.z.d.m.checkNotNullExpressionValue(bool, "IS_FUN_INTERFACE.get(classProto.flags)");
        return bool.booleanValue();
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isInline() {
        Boolean bool = d0.e0.p.d.m0.f.z.b.j.get(this.o.getFlags());
        d0.z.d.m.checkNotNullExpressionValue(bool, "IS_INLINE_CLASS.get(classProto.flags)");
        return bool.booleanValue() && this.p.isAtMost(1, 4, 1);
    }

    @Override // d0.e0.p.d.m0.c.i
    public boolean isInner() {
        Boolean bool = d0.e0.p.d.m0.f.z.b.f.get(this.o.getFlags());
        d0.z.d.m.checkNotNullExpressionValue(bool, "IS_INNER.get(classProto.flags)");
        return bool.booleanValue();
    }

    @Override // d0.e0.p.d.m0.c.e
    public boolean isValue() {
        Boolean bool = d0.e0.p.d.m0.f.z.b.j.get(this.o.getFlags());
        d0.z.d.m.checkNotNullExpressionValue(bool, "IS_INLINE_CLASS.get(classProto.flags)");
        return bool.booleanValue() && this.p.isAtLeast(1, 4, 2);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("deserialized ");
        sbU.append(isExpect() ? "expect " : "");
        sbU.append("class ");
        sbU.append(getName());
        return sbU.toString();
    }

    @Override // d0.e0.p.d.m0.c.e
    public d0.e0.p.d.m0.k.a0.j getStaticScope() {
        return this.w;
    }
}
