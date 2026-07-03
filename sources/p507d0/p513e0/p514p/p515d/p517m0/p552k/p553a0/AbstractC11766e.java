package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11465t0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.InterfaceC11480b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11793k;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.C11904n;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11900j;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12033a;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12041i;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12160r;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.C12250y;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.e */
/* JADX INFO: compiled from: GivenFunctionsMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11766e extends AbstractC11771j {

    /* JADX INFO: renamed from: b */
    public static final /* synthetic */ KProperty<Object>[] f24362b = {C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(AbstractC11766e.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;"))};

    /* JADX INFO: renamed from: c */
    public final InterfaceC11330e f24363c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC11900j f24364d;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.e$a */
    /* JADX INFO: compiled from: GivenFunctionsMemberScope.kt */
    public static final class a extends AbstractC12240o implements Function0<List<? extends InterfaceC11450m>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends InterfaceC11450m> invoke() {
            List<InterfaceC11472x> listMo9372a = AbstractC11766e.this.mo9372a();
            return C12163u.plus((Collection) listMo9372a, (Iterable) AbstractC11766e.access$createFakeOverrides(AbstractC11766e.this, listMo9372a));
        }
    }

    public AbstractC11766e(InterfaceC11905o interfaceC11905o, InterfaceC11330e interfaceC11330e) {
        C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
        C12238m.checkNotNullParameter(interfaceC11330e, "containingClass");
        this.f24363c = interfaceC11330e;
        this.f24364d = interfaceC11905o.createLazyValue(new a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [d0.e0.p.d.m0.k.k] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.Collection] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final List access$createFakeOverrides(AbstractC11766e abstractC11766e, List list) {
        ?? EmptyList;
        Objects.requireNonNull(abstractC11766e);
        ArrayList arrayList = new ArrayList(3);
        Collection<AbstractC11913c0> supertypes = abstractC11766e.f24363c.getTypeConstructor().getSupertypes();
        C12238m.checkNotNullExpressionValue(supertypes, "containingClass.typeConstructor.supertypes");
        ArrayList arrayList2 = new ArrayList();
        Iterator it = supertypes.iterator();
        while (it.hasNext()) {
            C12160r.addAll(arrayList2, InterfaceC11773l.a.getContributedDescriptors$default(((AbstractC11913c0) it.next()).getMemberScope(), null, null, 3, null));
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (obj instanceof InterfaceC11321b) {
                arrayList3.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList3) {
            C11716e name = ((InterfaceC11321b) obj2).getName();
            Object arrayList4 = linkedHashMap.get(name);
            if (arrayList4 == null) {
                arrayList4 = new ArrayList();
                linkedHashMap.put(name, arrayList4);
            }
            ((List) arrayList4).add(obj2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            C11716e c11716e = (C11716e) entry.getKey();
            List list2 = (List) entry.getValue();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj3 : list2) {
                Boolean boolValueOf = Boolean.valueOf(((InterfaceC11321b) obj3) instanceof InterfaceC11472x);
                Object arrayList5 = linkedHashMap2.get(boolValueOf);
                if (arrayList5 == null) {
                    arrayList5 = new ArrayList();
                    linkedHashMap2.put(boolValueOf, arrayList5);
                }
                ((List) arrayList5).add(obj3);
            }
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                boolean zBooleanValue = ((Boolean) entry2.getKey()).booleanValue();
                List list3 = (List) entry2.getValue();
                ?? r4 = C11793k.f24411b;
                if (zBooleanValue) {
                    EmptyList = new ArrayList();
                    for (Object obj4 : list) {
                        if (C12238m.areEqual(((InterfaceC11472x) obj4).getName(), c11716e)) {
                            EmptyList.add(obj4);
                        }
                    }
                } else {
                    EmptyList = C12147n.emptyList();
                }
                r4.generateOverridesInFunctionGroup(c11716e, list3, EmptyList, abstractC11766e.f24363c, new C11767f(arrayList, abstractC11766e));
            }
        }
        return C12033a.compact(arrayList);
    }

    /* JADX INFO: renamed from: a */
    public abstract List<InterfaceC11472x> mo9372a();

    /* JADX INFO: renamed from: b */
    public final List<InterfaceC11450m> m9911b() {
        return (List) C11904n.getValue(this.f24364d, this, (KProperty<?>) f24362b[0]);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l
    public Collection<InterfaceC11450m> getContributedDescriptors(C11765d c11765d, Function1<? super C11716e, Boolean> function1) {
        C12238m.checkNotNullParameter(c11765d, "kindFilter");
        C12238m.checkNotNullParameter(function1, "nameFilter");
        return !c11765d.acceptsKinds(C11765d.f24352n.getKindMask()) ? C12147n.emptyList() : m9911b();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Collection<InterfaceC11465t0> getContributedFunctions(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        List<InterfaceC11450m> listM9911b = m9911b();
        C12041i c12041i = new C12041i();
        for (Object obj : listM9911b) {
            if ((obj instanceof InterfaceC11465t0) && C12238m.areEqual(((InterfaceC11465t0) obj).getName(), c11716e)) {
                c12041i.add(obj);
            }
        }
        return c12041i;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Collection<InterfaceC11453n0> getContributedVariables(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        List<InterfaceC11450m> listM9911b = m9911b();
        C12041i c12041i = new C12041i();
        for (Object obj : listM9911b) {
            if ((obj instanceof InterfaceC11453n0) && C12238m.areEqual(((InterfaceC11453n0) obj).getName(), c11716e)) {
                c12041i.add(obj);
            }
        }
        return c12041i;
    }
}
