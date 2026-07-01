package d0.e0.p.d.m0.e.a.i0.l;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptorWithTypeParameters;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.SimpleFunctionDescriptor;
import d0.e0.p.d.m0.d.b.LookupLocation2;
import d0.e0.p.d.m0.d.utils;
import d0.e0.p.d.m0.e.a.i0.context4;
import d0.e0.p.d.m0.e.a.k0.u;
import d0.e0.p.d.m0.e.b.KotlinJvmBinaryClass;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.a0.MemberScope2;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.k.a0.MemberScope4;
import d0.e0.p.d.m0.m.storage5;
import d0.e0.p.d.m0.m.storage7;
import d0.e0.p.d.m0.o.n.scopeUtils;
import d0.t.MutableCollections;
import d0.t.Sets5;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.PropertyReference1Impl;
import d0.z.d.Reflection2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.d, reason: use source file name */
/* JADX INFO: compiled from: JvmPackageScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JvmPackageScope implements MemberScope3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f3326b = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(JvmPackageScope.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    public final context4 c;
    public final LazyJavaPackageFragment d;
    public final LazyJavaPackageScope e;
    public final storage5 f;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.d$a */
    /* JADX INFO: compiled from: JvmPackageScope.kt */
    public static final class a extends Lambda implements Function0<MemberScope3[]> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final MemberScope3[] invoke() {
            Collection<KotlinJvmBinaryClass> collectionValues = JvmPackageScope.this.d.getBinaryClasses$descriptors_jvm().values();
            JvmPackageScope jvmPackageScope = JvmPackageScope.this;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                MemberScope3 memberScope3CreateKotlinPackagePartScope = jvmPackageScope.c.getComponents().getDeserializedDescriptorResolver().createKotlinPackagePartScope(jvmPackageScope.d, (KotlinJvmBinaryClass) it.next());
                if (memberScope3CreateKotlinPackagePartScope != null) {
                    arrayList.add(memberScope3CreateKotlinPackagePartScope);
                }
            }
            Object[] array = scopeUtils.listOfNonEmptyScopes(arrayList).toArray(new MemberScope3[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return (MemberScope3[]) array;
        }
    }

    public JvmPackageScope(context4 context4Var, u uVar, LazyJavaPackageFragment lazyJavaPackageFragment) {
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        Intrinsics3.checkNotNullParameter(uVar, "jPackage");
        Intrinsics3.checkNotNullParameter(lazyJavaPackageFragment, "packageFragment");
        this.c = context4Var;
        this.d = lazyJavaPackageFragment;
        this.e = new LazyJavaPackageScope(context4Var, uVar, lazyJavaPackageFragment);
        this.f = context4Var.getStorageManager().createLazyValue(new a());
    }

    public final MemberScope3[] a() {
        return (MemberScope3[]) storage7.getValue(this.f, this, (KProperty<?>) f3326b[0]);
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScope3
    public Set<Name> getClassifierNames() {
        Set<Name> setFlatMapClassifierNamesOrNull = MemberScope4.flatMapClassifierNamesOrNull(_Arrays.asIterable(a()));
        if (setFlatMapClassifierNamesOrNull == null) {
            return null;
        }
        setFlatMapClassifierNamesOrNull.addAll(getJavaScope$descriptors_jvm().getClassifierNames());
        return setFlatMapClassifierNamesOrNull;
    }

    @Override // d0.e0.p.d.m0.k.a0.ResolutionScope
    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        recordLookup(name, lookupLocation2);
        ClassDescriptor contributedClassifier = this.e.getContributedClassifier(name, lookupLocation2);
        if (contributedClassifier != null) {
            return contributedClassifier;
        }
        MemberScope3[] memberScope3ArrA = a();
        ClassifierDescriptor classifierDescriptor = null;
        int i = 0;
        int length = memberScope3ArrA.length;
        while (i < length) {
            MemberScope3 memberScope3 = memberScope3ArrA[i];
            i++;
            ClassifierDescriptor contributedClassifier2 = memberScope3.getContributedClassifier(name, lookupLocation2);
            if (contributedClassifier2 != null) {
                if (!(contributedClassifier2 instanceof ClassifierDescriptorWithTypeParameters) || !((ClassifierDescriptorWithTypeParameters) contributedClassifier2).isExpect()) {
                    return contributedClassifier2;
                }
                if (classifierDescriptor == null) {
                    classifierDescriptor = contributedClassifier2;
                }
            }
        }
        return classifierDescriptor;
    }

    @Override // d0.e0.p.d.m0.k.a0.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        LazyJavaPackageScope lazyJavaPackageScope = this.e;
        MemberScope3[] memberScope3ArrA = a();
        Collection<DeclarationDescriptor> contributedDescriptors = lazyJavaPackageScope.getContributedDescriptors(memberScope2, function1);
        int length = memberScope3ArrA.length;
        int i = 0;
        while (i < length) {
            MemberScope3 memberScope3 = memberScope3ArrA[i];
            i++;
            contributedDescriptors = scopeUtils.concat(contributedDescriptors, memberScope3.getContributedDescriptors(memberScope2, function1));
        }
        return contributedDescriptors == null ? Sets5.emptySet() : contributedDescriptors;
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScope3
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        recordLookup(name, lookupLocation2);
        LazyJavaPackageScope lazyJavaPackageScope = this.e;
        MemberScope3[] memberScope3ArrA = a();
        Collection<? extends SimpleFunctionDescriptor> contributedFunctions = lazyJavaPackageScope.getContributedFunctions(name, lookupLocation2);
        int length = memberScope3ArrA.length;
        int i = 0;
        Collection collectionConcat = contributedFunctions;
        while (i < length) {
            MemberScope3 memberScope3 = memberScope3ArrA[i];
            i++;
            collectionConcat = scopeUtils.concat(collectionConcat, memberScope3.getContributedFunctions(name, lookupLocation2));
        }
        return collectionConcat == null ? Sets5.emptySet() : collectionConcat;
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScope3
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        recordLookup(name, lookupLocation2);
        LazyJavaPackageScope lazyJavaPackageScope = this.e;
        MemberScope3[] memberScope3ArrA = a();
        Collection<? extends PropertyDescriptor> contributedVariables = lazyJavaPackageScope.getContributedVariables(name, lookupLocation2);
        int length = memberScope3ArrA.length;
        int i = 0;
        Collection collectionConcat = contributedVariables;
        while (i < length) {
            MemberScope3 memberScope3 = memberScope3ArrA[i];
            i++;
            collectionConcat = scopeUtils.concat(collectionConcat, memberScope3.getContributedVariables(name, lookupLocation2));
        }
        return collectionConcat == null ? Sets5.emptySet() : collectionConcat;
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScope3
    public Set<Name> getFunctionNames() {
        MemberScope3[] memberScope3ArrA = a();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope3 memberScope3 : memberScope3ArrA) {
            MutableCollections.addAll(linkedHashSet, memberScope3.getFunctionNames());
        }
        linkedHashSet.addAll(getJavaScope$descriptors_jvm().getFunctionNames());
        return linkedHashSet;
    }

    public final LazyJavaPackageScope getJavaScope$descriptors_jvm() {
        return this.e;
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScope3
    public Set<Name> getVariableNames() {
        MemberScope3[] memberScope3ArrA = a();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope3 memberScope3 : memberScope3ArrA) {
            MutableCollections.addAll(linkedHashSet, memberScope3.getVariableNames());
        }
        linkedHashSet.addAll(getJavaScope$descriptors_jvm().getVariableNames());
        return linkedHashSet;
    }

    public void recordLookup(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        utils.record(this.c.getComponents().getLookupTracker(), lookupLocation2, this.d, name);
    }
}
