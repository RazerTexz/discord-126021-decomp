package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11291k;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11465t0;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.EnumC11482d;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.InterfaceC11480b;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.C11498a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.C11520k;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.C11529g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11786d;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.C11765d;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12034b;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12160r;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.o */
/* JADX INFO: compiled from: LazyJavaStaticClassScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11548o extends AbstractC11551r {

    /* JADX INFO: renamed from: n */
    public final InterfaceC11574g f23410n;

    /* JADX INFO: renamed from: o */
    public final C11539f f23411o;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.o$a */
    /* JADX INFO: compiled from: LazyJavaStaticClassScope.kt */
    public static final class a extends AbstractC12240o implements Function1<InterfaceC11770i, Collection<? extends InterfaceC11453n0>> {
        public final /* synthetic */ C11716e $name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(C11716e c11716e) {
            super(1);
            this.$name = c11716e;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Collection<? extends InterfaceC11453n0> invoke(InterfaceC11770i interfaceC11770i) {
            C12238m.checkNotNullParameter(interfaceC11770i, "it");
            return interfaceC11770i.getContributedVariables(this.$name, EnumC11482d.WHEN_GET_SUPER_MEMBERS);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.o$b */
    /* JADX INFO: compiled from: LazyJavaStaticClassScope.kt */
    public static final class b extends AbstractC12240o implements Function1<InterfaceC11770i, Collection<? extends C11716e>> {

        /* JADX INFO: renamed from: j */
        public static final b f23412j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Collection<C11716e> invoke(InterfaceC11770i interfaceC11770i) {
            C12238m.checkNotNullParameter(interfaceC11770i, "it");
            return interfaceC11770i.getVariableNames();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11548o(C11529g c11529g, InterfaceC11574g interfaceC11574g, C11539f c11539f) {
        super(c11529g);
        C12238m.checkNotNullParameter(c11529g, "c");
        C12238m.checkNotNullParameter(interfaceC11574g, "jClass");
        C12238m.checkNotNullParameter(c11539f, "ownerDescriptor");
        this.f23410n = interfaceC11574g;
        this.f23411o = c11539f;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.AbstractC11544k
    /* JADX INFO: renamed from: a */
    public Set<C11716e> mo9470a(C11765d c11765d, Function1<? super C11716e, Boolean> function1) {
        C12238m.checkNotNullParameter(c11765d, "kindFilter");
        return C12148n0.emptySet();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.AbstractC11544k
    /* JADX INFO: renamed from: b */
    public Set<C11716e> mo9471b(C11765d c11765d, Function1<? super C11716e, Boolean> function1) {
        C12238m.checkNotNullParameter(c11765d, "kindFilter");
        Set<C11716e> mutableSet = C12163u.toMutableSet(this.f23392f.invoke().getMethodNames());
        C11548o parentJavaStaticClassScope = C11520k.getParentJavaStaticClassScope(this.f23411o);
        Set<C11716e> functionNames = parentJavaStaticClassScope == null ? null : parentJavaStaticClassScope.getFunctionNames();
        if (functionNames == null) {
            functionNames = C12148n0.emptySet();
        }
        mutableSet.addAll(functionNames);
        if (this.f23410n.isEnum()) {
            mutableSet.addAll(C12147n.listOf((Object[]) new C11716e[]{C11291k.f22490c, C11291k.f22489b}));
        }
        return mutableSet;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.AbstractC11544k
    /* JADX INFO: renamed from: d */
    public InterfaceC11535b mo9473d() {
        return new C11534a(this.f23410n, C11547n.f23409j);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.AbstractC11544k
    /* JADX INFO: renamed from: f */
    public void mo9474f(Collection<InterfaceC11465t0> collection, C11716e c11716e) {
        C12238m.checkNotNullParameter(collection, "result");
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C11548o parentJavaStaticClassScope = C11520k.getParentJavaStaticClassScope(this.f23411o);
        Collection<? extends InterfaceC11465t0> collectionResolveOverridesForStaticMembers = C11498a.resolveOverridesForStaticMembers(c11716e, parentJavaStaticClassScope == null ? C12148n0.emptySet() : C12163u.toSet(parentJavaStaticClassScope.getContributedFunctions(c11716e, EnumC11482d.WHEN_GET_SUPER_MEMBERS)), collection, this.f23411o, this.f23389c.getComponents().getErrorReporter(), this.f23389c.getComponents().getKotlinTypeChecker().getOverridingUtil());
        C12238m.checkNotNullExpressionValue(collectionResolveOverridesForStaticMembers, "resolveOverridesForStaticMembers(\n            name,\n            functionsFromSupertypes,\n            result,\n            ownerDescriptor,\n            c.components.errorReporter,\n            c.components.kotlinTypeChecker.overridingUtil\n        )");
        collection.addAll(collectionResolveOverridesForStaticMembers);
        if (this.f23410n.isEnum()) {
            if (C12238m.areEqual(c11716e, C11291k.f22490c)) {
                InterfaceC11465t0 interfaceC11465t0CreateEnumValueOfMethod = C11786d.createEnumValueOfMethod(this.f23411o);
                C12238m.checkNotNullExpressionValue(interfaceC11465t0CreateEnumValueOfMethod, "createEnumValueOfMethod(ownerDescriptor)");
                collection.add(interfaceC11465t0CreateEnumValueOfMethod);
            } else if (C12238m.areEqual(c11716e, C11291k.f22489b)) {
                InterfaceC11465t0 interfaceC11465t0CreateEnumValuesMethod = C11786d.createEnumValuesMethod(this.f23411o);
                C12238m.checkNotNullExpressionValue(interfaceC11465t0CreateEnumValuesMethod, "createEnumValuesMethod(ownerDescriptor)");
                collection.add(interfaceC11465t0CreateEnumValuesMethod);
            }
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.AbstractC11551r, p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.AbstractC11544k
    /* JADX INFO: renamed from: g */
    public void mo9475g(C11716e c11716e, Collection<InterfaceC11453n0> collection) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(collection, "result");
        C11539f c11539f = this.f23411o;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        C12034b.dfs(C12145m.listOf(c11539f), C11549p.f23413a, new C11550q(c11539f, linkedHashSet, new a(c11716e)));
        if (!collection.isEmpty()) {
            Collection<? extends InterfaceC11453n0> collectionResolveOverridesForStaticMembers = C11498a.resolveOverridesForStaticMembers(c11716e, linkedHashSet, collection, this.f23411o, this.f23389c.getComponents().getErrorReporter(), this.f23389c.getComponents().getKotlinTypeChecker().getOverridingUtil());
            C12238m.checkNotNullExpressionValue(collectionResolveOverridesForStaticMembers, "resolveOverridesForStaticMembers(\n                    name,\n                    propertiesFromSupertypes,\n                    result,\n                    ownerDescriptor,\n                    c.components.errorReporter,\n                    c.components.kotlinTypeChecker.overridingUtil\n                )");
            collection.addAll(collectionResolveOverridesForStaticMembers);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : linkedHashSet) {
            InterfaceC11453n0 interfaceC11453n0M9497o = m9497o((InterfaceC11453n0) obj);
            Object arrayList = linkedHashMap.get(interfaceC11453n0M9497o);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(interfaceC11453n0M9497o, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Collection collectionResolveOverridesForStaticMembers2 = C11498a.resolveOverridesForStaticMembers(c11716e, (Collection) ((Map.Entry) it.next()).getValue(), collection, this.f23411o, this.f23389c.getComponents().getErrorReporter(), this.f23389c.getComponents().getKotlinTypeChecker().getOverridingUtil());
            C12238m.checkNotNullExpressionValue(collectionResolveOverridesForStaticMembers2, "resolveOverridesForStaticMembers(\n                    name, it.value, result, ownerDescriptor, c.components.errorReporter,\n                    c.components.kotlinTypeChecker.overridingUtil\n                )");
            C12160r.addAll(arrayList2, collectionResolveOverridesForStaticMembers2);
        }
        collection.addAll(arrayList2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l
    public InterfaceC11352h getContributedClassifier(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.AbstractC11544k
    /* JADX INFO: renamed from: h */
    public Set<C11716e> mo9476h(C11765d c11765d, Function1<? super C11716e, Boolean> function1) {
        C12238m.checkNotNullParameter(c11765d, "kindFilter");
        Set<C11716e> mutableSet = C12163u.toMutableSet(this.f23392f.invoke().getFieldNames());
        C11539f c11539f = this.f23411o;
        C12034b.dfs(C12145m.listOf(c11539f), C11549p.f23413a, new C11550q(c11539f, mutableSet, b.f23412j));
        return mutableSet;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.AbstractC11544k
    /* JADX INFO: renamed from: j */
    public InterfaceC11450m mo9478j() {
        return this.f23411o;
    }

    /* JADX INFO: renamed from: o */
    public final InterfaceC11453n0 m9497o(InterfaceC11453n0 interfaceC11453n0) {
        if (interfaceC11453n0.getKind().isReal()) {
            return interfaceC11453n0;
        }
        Collection<? extends InterfaceC11453n0> overriddenDescriptors = interfaceC11453n0.getOverriddenDescriptors();
        C12238m.checkNotNullExpressionValue(overriddenDescriptors, "this.overriddenDescriptors");
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(overriddenDescriptors, 10));
        for (InterfaceC11453n0 interfaceC11453n1 : overriddenDescriptors) {
            C12238m.checkNotNullExpressionValue(interfaceC11453n1, "it");
            arrayList.add(m9497o(interfaceC11453n1));
        }
        return (InterfaceC11453n0) C12163u.single(C12163u.distinct(arrayList));
    }
}
