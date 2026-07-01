package d0.e0.p.d.m0.e.a.i0.l;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.SimpleFunctionDescriptor;
import d0.e0.p.d.m0.d.b.LookupLocation2;
import d0.e0.p.d.m0.d.b.LookupLocation3;
import d0.e0.p.d.m0.e.a.g0.DescriptorResolverUtils;
import d0.e0.p.d.m0.e.a.h0.util3;
import d0.e0.p.d.m0.e.a.i0.context4;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.DescriptorFactory;
import d0.e0.p.d.m0.k.a0.MemberScope2;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.p.DFS;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.MutableCollections;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.o, reason: use source file name */
/* JADX INFO: compiled from: LazyJavaStaticClassScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LazyJavaStaticClassScope2 extends LazyJavaStaticScope {
    public final d0.e0.p.d.m0.e.a.k0.g n;
    public final LazyJavaClassDescriptor o;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.o$a */
    /* JADX INFO: compiled from: LazyJavaStaticClassScope.kt */
    public static final class a extends Lambda implements Function1<MemberScope3, Collection<? extends PropertyDescriptor>> {
        public final /* synthetic */ Name $name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Name name) {
            super(1);
            this.$name = name;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Collection<? extends PropertyDescriptor> invoke(MemberScope3 memberScope3) {
            Intrinsics3.checkNotNullParameter(memberScope3, "it");
            return memberScope3.getContributedVariables(this.$name, LookupLocation3.WHEN_GET_SUPER_MEMBERS);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.o$b */
    /* JADX INFO: compiled from: LazyJavaStaticClassScope.kt */
    public static final class b extends Lambda implements Function1<MemberScope3, Collection<? extends Name>> {
        public static final b j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Collection<Name> invoke(MemberScope3 memberScope3) {
            Intrinsics3.checkNotNullParameter(memberScope3, "it");
            return memberScope3.getVariableNames();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaStaticClassScope2(context4 context4Var, d0.e0.p.d.m0.e.a.k0.g gVar, LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        super(context4Var);
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        Intrinsics3.checkNotNullParameter(gVar, "jClass");
        Intrinsics3.checkNotNullParameter(lazyJavaClassDescriptor, "ownerDescriptor");
        this.n = gVar;
        this.o = lazyJavaClassDescriptor;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope
    public Set<Name> a(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        return Sets5.emptySet();
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope
    public Set<Name> b(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        Set<Name> mutableSet = _Collections.toMutableSet(this.f.invoke().getMethodNames());
        LazyJavaStaticClassScope2 parentJavaStaticClassScope = util3.getParentJavaStaticClassScope(this.o);
        Set<Name> functionNames = parentJavaStaticClassScope == null ? null : parentJavaStaticClassScope.getFunctionNames();
        if (functionNames == null) {
            functionNames = Sets5.emptySet();
        }
        mutableSet.addAll(functionNames);
        if (this.n.isEnum()) {
            mutableSet.addAll(Collections2.listOf((Object[]) new Name[]{StandardNames.c, StandardNames.f3215b}));
        }
        return mutableSet;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope
    public DeclaredMemberIndex2 d() {
        return new DeclaredMemberIndex(this.n, LazyJavaStaticClassScope.j);
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope
    public void f(Collection<SimpleFunctionDescriptor> collection, Name name) {
        Intrinsics3.checkNotNullParameter(collection, "result");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        LazyJavaStaticClassScope2 parentJavaStaticClassScope = util3.getParentJavaStaticClassScope(this.o);
        Collection<? extends SimpleFunctionDescriptor> collectionResolveOverridesForStaticMembers = DescriptorResolverUtils.resolveOverridesForStaticMembers(name, parentJavaStaticClassScope == null ? Sets5.emptySet() : _Collections.toSet(parentJavaStaticClassScope.getContributedFunctions(name, LookupLocation3.WHEN_GET_SUPER_MEMBERS)), collection, this.o, this.c.getComponents().getErrorReporter(), this.c.getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics3.checkNotNullExpressionValue(collectionResolveOverridesForStaticMembers, "resolveOverridesForStaticMembers(\n            name,\n            functionsFromSupertypes,\n            result,\n            ownerDescriptor,\n            c.components.errorReporter,\n            c.components.kotlinTypeChecker.overridingUtil\n        )");
        collection.addAll(collectionResolveOverridesForStaticMembers);
        if (this.n.isEnum()) {
            if (Intrinsics3.areEqual(name, StandardNames.c)) {
                SimpleFunctionDescriptor simpleFunctionDescriptorCreateEnumValueOfMethod = DescriptorFactory.createEnumValueOfMethod(this.o);
                Intrinsics3.checkNotNullExpressionValue(simpleFunctionDescriptorCreateEnumValueOfMethod, "createEnumValueOfMethod(ownerDescriptor)");
                collection.add(simpleFunctionDescriptorCreateEnumValueOfMethod);
            } else if (Intrinsics3.areEqual(name, StandardNames.f3215b)) {
                SimpleFunctionDescriptor simpleFunctionDescriptorCreateEnumValuesMethod = DescriptorFactory.createEnumValuesMethod(this.o);
                Intrinsics3.checkNotNullExpressionValue(simpleFunctionDescriptorCreateEnumValuesMethod, "createEnumValuesMethod(ownerDescriptor)");
                collection.add(simpleFunctionDescriptorCreateEnumValuesMethod);
            }
        }
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaStaticScope, d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope
    public void g(Name name, Collection<PropertyDescriptor> collection) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(collection, "result");
        LazyJavaClassDescriptor lazyJavaClassDescriptor = this.o;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        DFS.dfs(CollectionsJVM.listOf(lazyJavaClassDescriptor), LazyJavaStaticClassScope3.a, new LazyJavaStaticClassScope4(lazyJavaClassDescriptor, linkedHashSet, new a(name)));
        if (!collection.isEmpty()) {
            Collection<? extends PropertyDescriptor> collectionResolveOverridesForStaticMembers = DescriptorResolverUtils.resolveOverridesForStaticMembers(name, linkedHashSet, collection, this.o, this.c.getComponents().getErrorReporter(), this.c.getComponents().getKotlinTypeChecker().getOverridingUtil());
            Intrinsics3.checkNotNullExpressionValue(collectionResolveOverridesForStaticMembers, "resolveOverridesForStaticMembers(\n                    name,\n                    propertiesFromSupertypes,\n                    result,\n                    ownerDescriptor,\n                    c.components.errorReporter,\n                    c.components.kotlinTypeChecker.overridingUtil\n                )");
            collection.addAll(collectionResolveOverridesForStaticMembers);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : linkedHashSet) {
            PropertyDescriptor propertyDescriptorO = o((PropertyDescriptor) obj);
            Object arrayList = linkedHashMap.get(propertyDescriptorO);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(propertyDescriptorO, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Collection collectionResolveOverridesForStaticMembers2 = DescriptorResolverUtils.resolveOverridesForStaticMembers(name, (Collection) ((Map.Entry) it.next()).getValue(), collection, this.o, this.c.getComponents().getErrorReporter(), this.c.getComponents().getKotlinTypeChecker().getOverridingUtil());
            Intrinsics3.checkNotNullExpressionValue(collectionResolveOverridesForStaticMembers2, "resolveOverridesForStaticMembers(\n                    name, it.value, result, ownerDescriptor, c.components.errorReporter,\n                    c.components.kotlinTypeChecker.overridingUtil\n                )");
            MutableCollections.addAll(arrayList2, collectionResolveOverridesForStaticMembers2);
        }
        collection.addAll(arrayList2);
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.ResolutionScope
    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return null;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope
    public Set<Name> h(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        Set<Name> mutableSet = _Collections.toMutableSet(this.f.invoke().getFieldNames());
        LazyJavaClassDescriptor lazyJavaClassDescriptor = this.o;
        DFS.dfs(CollectionsJVM.listOf(lazyJavaClassDescriptor), LazyJavaStaticClassScope3.a, new LazyJavaStaticClassScope4(lazyJavaClassDescriptor, mutableSet, b.j));
        return mutableSet;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope
    public DeclarationDescriptor j() {
        return this.o;
    }

    public final PropertyDescriptor o(PropertyDescriptor propertyDescriptor) {
        if (propertyDescriptor.getKind().isReal()) {
            return propertyDescriptor;
        }
        Collection<? extends PropertyDescriptor> overriddenDescriptors = propertyDescriptor.getOverriddenDescriptors();
        Intrinsics3.checkNotNullExpressionValue(overriddenDescriptors, "this.overriddenDescriptors");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(overriddenDescriptors, 10));
        for (PropertyDescriptor propertyDescriptor2 : overriddenDescriptors) {
            Intrinsics3.checkNotNullExpressionValue(propertyDescriptor2, "it");
            arrayList.add(o(propertyDescriptor2));
        }
        return (PropertyDescriptor) _Collections.single(_Collections.distinct(arrayList));
    }
}
