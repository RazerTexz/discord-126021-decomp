package d0.e0.p.d.m0.e.a.i0.l;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.Tuples;
import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.ReceiverParameterDescriptor;
import d0.e0.p.d.m0.c.SimpleFunctionDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.i1.DeclarationDescriptorImpl;
import d0.e0.p.d.m0.c.i1.ValueParameterDescriptorImpl;
import d0.e0.p.d.m0.d.b.LookupLocation2;
import d0.e0.p.d.m0.d.b.LookupLocation3;
import d0.e0.p.d.m0.e.a.JvmAnnotationNames;
import d0.e0.p.d.m0.e.a.g0.JavaResolverCache;
import d0.e0.p.d.m0.e.a.g0.SignaturePropagator;
import d0.e0.p.d.m0.e.a.g0.TypeUsage;
import d0.e0.p.d.m0.e.a.h0.JavaMethodDescriptor;
import d0.e0.p.d.m0.e.a.h0.JavaPropertyDescriptor;
import d0.e0.p.d.m0.e.a.i0.LazyJavaAnnotations2;
import d0.e0.p.d.m0.e.a.i0.context;
import d0.e0.p.d.m0.e.a.i0.context4;
import d0.e0.p.d.m0.e.a.i0.m.JavaTypeResolver;
import d0.e0.p.d.m0.e.a.i0.m.JavaTypeResolver5;
import d0.e0.p.d.m0.e.a.k0.a0;
import d0.e0.p.d.m0.e.a.k0.javaTypes2;
import d0.e0.p.d.m0.e.a.k0.javaTypes5;
import d0.e0.p.d.m0.e.a.k0.y;
import d0.e0.p.d.m0.e.a.utils2;
import d0.e0.p.d.m0.e.b.methodSignatureMapping3;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.DescriptorFactory;
import d0.e0.p.d.m0.k.DescriptorUtils;
import d0.e0.p.d.m0.k.a0.MemberScope;
import d0.e0.p.d.m0.k.a0.MemberScope2;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.k.a0.MemberScopeImpl;
import d0.e0.p.d.m0.k.overridingUtils;
import d0.e0.p.d.m0.k.v.w;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.m.LockBasedStorageManager;
import d0.e0.p.d.m0.m.storage3;
import d0.e0.p.d.m0.m.storage4;
import d0.e0.p.d.m0.m.storage5;
import d0.e0.p.d.m0.m.storage7;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.TypeUtils;
import d0.e0.p.d.m0.p.collections;
import d0.t.Collections2;
import d0.t.IndexedValue;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.PropertyReference1Impl;
import d0.z.d.Reflection2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.k, reason: use source file name */
/* JADX INFO: compiled from: LazyJavaScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class LazyJavaScope extends MemberScopeImpl {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f3335b = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(LazyJavaScope.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(LazyJavaScope.class), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(LazyJavaScope.class), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};
    public final context4 c;
    public final LazyJavaScope d;
    public final storage5<Collection<DeclarationDescriptor>> e;
    public final storage5<DeclaredMemberIndex2> f;
    public final storage3<Name, Collection<SimpleFunctionDescriptor>> g;
    public final storage4<Name, PropertyDescriptor> h;
    public final storage3<Name, Collection<SimpleFunctionDescriptor>> i;
    public final storage5 j;
    public final storage5 k;
    public final storage5 l;
    public final storage3<Name, List<PropertyDescriptor>> m;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.k$a */
    /* JADX INFO: compiled from: LazyJavaScope.kt */
    public static final class a {
        public final KotlinType a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final KotlinType f3336b;
        public final List<ValueParameterDescriptor> c;
        public final List<TypeParameterDescriptor> d;
        public final boolean e;
        public final List<String> f;

        /* JADX WARN: Multi-variable type inference failed */
        public a(KotlinType kotlinType, KotlinType kotlinType2, List<? extends ValueParameterDescriptor> list, List<? extends TypeParameterDescriptor> list2, boolean z2, List<String> list3) {
            Intrinsics3.checkNotNullParameter(kotlinType, "returnType");
            Intrinsics3.checkNotNullParameter(list, "valueParameters");
            Intrinsics3.checkNotNullParameter(list2, "typeParameters");
            Intrinsics3.checkNotNullParameter(list3, "errors");
            this.a = kotlinType;
            this.f3336b = kotlinType2;
            this.c = list;
            this.d = list2;
            this.e = z2;
            this.f = list3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics3.areEqual(this.a, aVar.a) && Intrinsics3.areEqual(this.f3336b, aVar.f3336b) && Intrinsics3.areEqual(this.c, aVar.c) && Intrinsics3.areEqual(this.d, aVar.d) && this.e == aVar.e && Intrinsics3.areEqual(this.f, aVar.f);
        }

        public final List<String> getErrors() {
            return this.f;
        }

        public final boolean getHasStableParameterNames() {
            return this.e;
        }

        public final KotlinType getReceiverType() {
            return this.f3336b;
        }

        public final KotlinType getReturnType() {
            return this.a;
        }

        public final List<TypeParameterDescriptor> getTypeParameters() {
            return this.d;
        }

        public final List<ValueParameterDescriptor> getValueParameters() {
            return this.c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v8, types: [int] */
        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            KotlinType kotlinType = this.f3336b;
            int iHashCode2 = (this.d.hashCode() + ((this.c.hashCode() + ((iHashCode + (kotlinType == null ? 0 : kotlinType.hashCode())) * 31)) * 31)) * 31;
            boolean z2 = this.e;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return this.f.hashCode() + ((iHashCode2 + r1) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("MethodSignatureData(returnType=");
            sbU.append(this.a);
            sbU.append(", receiverType=");
            sbU.append(this.f3336b);
            sbU.append(", valueParameters=");
            sbU.append(this.c);
            sbU.append(", typeParameters=");
            sbU.append(this.d);
            sbU.append(", hasStableParameterNames=");
            sbU.append(this.e);
            sbU.append(", errors=");
            sbU.append(this.f);
            sbU.append(')');
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.k$b */
    /* JADX INFO: compiled from: LazyJavaScope.kt */
    public static final class b {
        public final List<ValueParameterDescriptor> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f3337b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(List<? extends ValueParameterDescriptor> list, boolean z2) {
            Intrinsics3.checkNotNullParameter(list, "descriptors");
            this.a = list;
            this.f3337b = z2;
        }

        public final List<ValueParameterDescriptor> getDescriptors() {
            return this.a;
        }

        public final boolean getHasSynthesizedNames() {
            return this.f3337b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.k$c */
    /* JADX INFO: compiled from: LazyJavaScope.kt */
    public static final class c extends Lambda implements Function0<Collection<? extends DeclarationDescriptor>> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Collection<? extends DeclarationDescriptor> invoke() {
            LazyJavaScope lazyJavaScope = LazyJavaScope.this;
            MemberScope2 memberScope2 = MemberScope2.m;
            Function1<Name, Boolean> all_name_filter = MemberScope3.a.getALL_NAME_FILTER();
            Objects.requireNonNull(lazyJavaScope);
            Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
            Intrinsics3.checkNotNullParameter(all_name_filter, "nameFilter");
            LookupLocation3 lookupLocation3 = LookupLocation3.WHEN_GET_ALL_DESCRIPTORS;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (memberScope2.acceptsKinds(MemberScope2.a.getCLASSIFIERS_MASK())) {
                for (Name name : lazyJavaScope.a(memberScope2, all_name_filter)) {
                    if (all_name_filter.invoke(name).booleanValue()) {
                        collections.addIfNotNull(linkedHashSet, lazyJavaScope.getContributedClassifier(name, lookupLocation3));
                    }
                }
            }
            if (memberScope2.acceptsKinds(MemberScope2.a.getFUNCTIONS_MASK()) && !memberScope2.getExcludes().contains(MemberScope.a.a)) {
                for (Name name2 : lazyJavaScope.b(memberScope2, all_name_filter)) {
                    if (all_name_filter.invoke(name2).booleanValue()) {
                        linkedHashSet.addAll(lazyJavaScope.getContributedFunctions(name2, lookupLocation3));
                    }
                }
            }
            if (memberScope2.acceptsKinds(MemberScope2.a.getVARIABLES_MASK()) && !memberScope2.getExcludes().contains(MemberScope.a.a)) {
                for (Name name3 : lazyJavaScope.h(memberScope2, all_name_filter)) {
                    if (all_name_filter.invoke(name3).booleanValue()) {
                        linkedHashSet.addAll(lazyJavaScope.getContributedVariables(name3, lookupLocation3));
                    }
                }
            }
            return _Collections.toList(linkedHashSet);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.k$d */
    /* JADX INFO: compiled from: LazyJavaScope.kt */
    public static final class d extends Lambda implements Function0<Set<? extends Name>> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Set<? extends Name> invoke() {
            return LazyJavaScope.this.a(MemberScope2.o, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.k$e */
    /* JADX INFO: compiled from: LazyJavaScope.kt */
    public static final class e extends Lambda implements Function1<Name, PropertyDescriptor> {
        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final PropertyDescriptor invoke(Name name) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            LazyJavaScope lazyJavaScope = LazyJavaScope.this;
            LazyJavaScope lazyJavaScope2 = lazyJavaScope.d;
            if (lazyJavaScope2 != null) {
                return (PropertyDescriptor) lazyJavaScope2.h.invoke(name);
            }
            d0.e0.p.d.m0.e.a.k0.n nVarFindFieldByName = lazyJavaScope.f.invoke().findFieldByName(name);
            if (nVarFindFieldByName == null || nVarFindFieldByName.isEnumEntry()) {
                return null;
            }
            return LazyJavaScope.access$resolveProperty(LazyJavaScope.this, nVarFindFieldByName);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.k$f */
    /* JADX INFO: compiled from: LazyJavaScope.kt */
    public static final class f extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Collection<SimpleFunctionDescriptor> invoke(Name name) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            LazyJavaScope lazyJavaScope = LazyJavaScope.this.d;
            if (lazyJavaScope != null) {
                return (Collection) ((LockBasedStorageManager.m) lazyJavaScope.g).invoke(name);
            }
            ArrayList arrayList = new ArrayList();
            for (d0.e0.p.d.m0.e.a.k0.r rVar : LazyJavaScope.this.f.invoke().findMethodsByName(name)) {
                JavaMethodDescriptor javaMethodDescriptorM = LazyJavaScope.this.m(rVar);
                if (LazyJavaScope.this.k(javaMethodDescriptorM)) {
                    ((JavaResolverCache.a) LazyJavaScope.this.c.getComponents().getJavaResolverCache()).recordMethod(rVar, javaMethodDescriptorM);
                    arrayList.add(javaMethodDescriptorM);
                }
            }
            LazyJavaScope.this.c(arrayList, name);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.k$g */
    /* JADX INFO: compiled from: LazyJavaScope.kt */
    public static final class g extends Lambda implements Function0<DeclaredMemberIndex2> {
        public g() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DeclaredMemberIndex2 invoke() {
            return LazyJavaScope.this.d();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.k$h */
    /* JADX INFO: compiled from: LazyJavaScope.kt */
    public static final class h extends Lambda implements Function0<Set<? extends Name>> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Set<? extends Name> invoke() {
            return LazyJavaScope.this.b(MemberScope2.p, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.k$i */
    /* JADX INFO: compiled from: LazyJavaScope.kt */
    public static final class i extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
        public i() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Collection<SimpleFunctionDescriptor> invoke(Name name) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            LinkedHashSet linkedHashSet = new LinkedHashSet((Collection) ((LockBasedStorageManager.m) LazyJavaScope.this.g).invoke(name));
            LazyJavaScope.access$retainMostSpecificMethods(LazyJavaScope.this, linkedHashSet);
            LazyJavaScope.this.f(linkedHashSet, name);
            return _Collections.toList(LazyJavaScope.this.c.getComponents().getSignatureEnhancement().enhanceSignatures(LazyJavaScope.this.c, linkedHashSet));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.k$j */
    /* JADX INFO: compiled from: LazyJavaScope.kt */
    public static final class j extends Lambda implements Function1<Name, List<? extends PropertyDescriptor>> {
        public j() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final List<PropertyDescriptor> invoke(Name name) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            ArrayList arrayList = new ArrayList();
            collections.addIfNotNull(arrayList, LazyJavaScope.this.h.invoke(name));
            LazyJavaScope.this.g(name, arrayList);
            return DescriptorUtils.isAnnotationClass(LazyJavaScope.this.j()) ? _Collections.toList(arrayList) : _Collections.toList(LazyJavaScope.this.c.getComponents().getSignatureEnhancement().enhanceSignatures(LazyJavaScope.this.c, arrayList));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.k$k */
    /* JADX INFO: compiled from: LazyJavaScope.kt */
    public static final class k extends Lambda implements Function0<Set<? extends Name>> {
        public k() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Set<? extends Name> invoke() {
            return LazyJavaScope.this.h(MemberScope2.q, null);
        }
    }

    public /* synthetic */ LazyJavaScope(context4 context4Var, LazyJavaScope lazyJavaScope, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context4Var, (i2 & 2) != 0 ? null : lazyJavaScope);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0086  */
    public static final PropertyDescriptor access$resolveProperty(LazyJavaScope lazyJavaScope, d0.e0.p.d.m0.e.a.k0.n nVar) {
        boolean z2;
        Objects.requireNonNull(lazyJavaScope);
        JavaPropertyDescriptor javaPropertyDescriptorCreate = JavaPropertyDescriptor.create(lazyJavaScope.j(), LazyJavaAnnotations2.resolveAnnotations(lazyJavaScope.c, nVar), Modality.FINAL, utils2.toDescriptorVisibility(nVar.getVisibility()), !nVar.isFinal(), nVar.getName(), lazyJavaScope.c.getComponents().getSourceElementFactory().source(nVar), nVar.isFinal() && nVar.isStatic());
        Intrinsics3.checkNotNullExpressionValue(javaPropertyDescriptorCreate, "create(\n            ownerDescriptor, annotations, Modality.FINAL, field.visibility.toDescriptorVisibility(), isVar, field.name,\n            c.components.sourceElementFactory.source(field), /* isConst = */ field.isFinalStatic\n        )");
        javaPropertyDescriptorCreate.initialize(null, null, null, null);
        KotlinType kotlinTypeTransformJavaType = lazyJavaScope.c.getTypeResolver().transformJavaType(nVar.getType(), JavaTypeResolver5.toAttributes$default(TypeUsage.COMMON, false, null, 3, null));
        if (KotlinBuiltIns.isPrimitiveType(kotlinTypeTransformJavaType) || KotlinBuiltIns.isString(kotlinTypeTransformJavaType)) {
            z2 = (nVar.isFinal() && nVar.isStatic()) && nVar.getHasConstantNotNullInitializer();
        }
        if (z2) {
            kotlinTypeTransformJavaType = TypeUtils.makeNotNullable(kotlinTypeTransformJavaType);
            Intrinsics3.checkNotNullExpressionValue(kotlinTypeTransformJavaType, "makeNotNullable(propertyType)");
        }
        javaPropertyDescriptorCreate.setType(kotlinTypeTransformJavaType, Collections2.emptyList(), lazyJavaScope.i(), null);
        if (DescriptorUtils.shouldRecordInitializerForProperty(javaPropertyDescriptorCreate, javaPropertyDescriptorCreate.getType())) {
            javaPropertyDescriptorCreate.setCompileTimeInitializer(lazyJavaScope.c.getStorageManager().createNullableLazyValue(new LazyJavaScope2(lazyJavaScope, nVar, javaPropertyDescriptorCreate)));
        }
        ((JavaResolverCache.a) lazyJavaScope.c.getComponents().getJavaResolverCache()).recordField(nVar, javaPropertyDescriptorCreate);
        return javaPropertyDescriptorCreate;
    }

    public static final void access$retainMostSpecificMethods(LazyJavaScope lazyJavaScope, Set set) {
        Objects.requireNonNull(lazyJavaScope);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : set) {
            String strComputeJvmDescriptor$default = methodSignatureMapping3.computeJvmDescriptor$default((SimpleFunctionDescriptor) obj, false, false, 2, null);
            Object arrayList = linkedHashMap.get(strComputeJvmDescriptor$default);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(strComputeJvmDescriptor$default, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        for (List list : linkedHashMap.values()) {
            if (list.size() != 1) {
                Collection collectionSelectMostSpecificInEachOverridableGroup = overridingUtils.selectMostSpecificInEachOverridableGroup(list, LazyJavaScope3.j);
                set.removeAll(list);
                set.addAll(collectionSelectMostSpecificInEachOverridableGroup);
            }
        }
    }

    public abstract Set<Name> a(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1);

    public abstract Set<Name> b(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1);

    public void c(Collection<SimpleFunctionDescriptor> collection, Name name) {
        Intrinsics3.checkNotNullParameter(collection, "result");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
    }

    public abstract DeclaredMemberIndex2 d();

    public final KotlinType e(d0.e0.p.d.m0.e.a.k0.r rVar, context4 context4Var) {
        Intrinsics3.checkNotNullParameter(rVar, "method");
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        return context4Var.getTypeResolver().transformJavaType(rVar.getReturnType(), JavaTypeResolver5.toAttributes$default(TypeUsage.COMMON, rVar.getContainingClass().isAnnotationType(), null, 2, null));
    }

    public abstract void f(Collection<SimpleFunctionDescriptor> collection, Name name);

    public abstract void g(Name name, Collection<PropertyDescriptor> collection);

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
    public Set<Name> getClassifierNames() {
        return (Set) storage7.getValue(this.l, this, (KProperty<?>) f3335b[2]);
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        return this.e.invoke();
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return !getFunctionNames().contains(name) ? Collections2.emptyList() : (Collection) ((LockBasedStorageManager.m) this.i).invoke(name);
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return !getVariableNames().contains(name) ? Collections2.emptyList() : (Collection) ((LockBasedStorageManager.m) this.m).invoke(name);
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
    public Set<Name> getFunctionNames() {
        return (Set) storage7.getValue(this.j, this, (KProperty<?>) f3335b[0]);
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
    public Set<Name> getVariableNames() {
        return (Set) storage7.getValue(this.k, this, (KProperty<?>) f3335b[1]);
    }

    public abstract Set<Name> h(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1);

    public abstract ReceiverParameterDescriptor i();

    public abstract DeclarationDescriptor j();

    public boolean k(JavaMethodDescriptor javaMethodDescriptor) {
        Intrinsics3.checkNotNullParameter(javaMethodDescriptor, "<this>");
        return true;
    }

    public abstract a l(d0.e0.p.d.m0.e.a.k0.r rVar, List<? extends TypeParameterDescriptor> list, KotlinType kotlinType, List<? extends ValueParameterDescriptor> list2);

    public final JavaMethodDescriptor m(d0.e0.p.d.m0.e.a.k0.r rVar) {
        Intrinsics3.checkNotNullParameter(rVar, "method");
        JavaMethodDescriptor javaMethodDescriptorCreateJavaMethod = JavaMethodDescriptor.createJavaMethod(j(), LazyJavaAnnotations2.resolveAnnotations(this.c, rVar), rVar.getName(), this.c.getComponents().getSourceElementFactory().source(rVar), this.f.invoke().findRecordComponentByName(rVar.getName()) != null && rVar.getValueParameters().isEmpty());
        Intrinsics3.checkNotNullExpressionValue(javaMethodDescriptorCreateJavaMethod, "createJavaMethod(\n            ownerDescriptor, annotations, method.name, c.components.sourceElementFactory.source(method),\n            declaredMemberIndex().findRecordComponentByName(method.name) != null && method.valueParameters.isEmpty()\n        )");
        context4 context4VarChildForMethod$default = context.childForMethod$default(this.c, javaMethodDescriptorCreateJavaMethod, rVar, 0, 4, null);
        List<y> typeParameters = rVar.getTypeParameters();
        List<? extends TypeParameterDescriptor> arrayList = new ArrayList<>(Iterables2.collectionSizeOrDefault(typeParameters, 10));
        Iterator<T> it = typeParameters.iterator();
        while (it.hasNext()) {
            TypeParameterDescriptor typeParameterDescriptorResolveTypeParameter = context4VarChildForMethod$default.getTypeParameterResolver().resolveTypeParameter((y) it.next());
            Intrinsics3.checkNotNull(typeParameterDescriptorResolveTypeParameter);
            arrayList.add(typeParameterDescriptorResolveTypeParameter);
        }
        b bVarN = n(context4VarChildForMethod$default, javaMethodDescriptorCreateJavaMethod, rVar.getValueParameters());
        a aVarL = l(rVar, arrayList, e(rVar, context4VarChildForMethod$default), bVarN.getDescriptors());
        KotlinType receiverType = aVarL.getReceiverType();
        javaMethodDescriptorCreateJavaMethod.initialize(receiverType == null ? null : DescriptorFactory.createExtensionReceiverParameterForCallable(javaMethodDescriptorCreateJavaMethod, receiverType, Annotations4.f.getEMPTY()), i(), aVarL.getTypeParameters(), aVarL.getValueParameters(), aVarL.getReturnType(), Modality.j.convertFromFlags(false, rVar.isAbstract(), !rVar.isFinal()), utils2.toDescriptorVisibility(rVar.getVisibility()), aVarL.getReceiverType() != null ? MapsJVM.mapOf(Tuples.to(JavaMethodDescriptor.M, _Collections.first((List) bVarN.getDescriptors()))) : Maps6.emptyMap());
        javaMethodDescriptorCreateJavaMethod.setParameterNamesStatus(aVarL.getHasStableParameterNames(), bVarN.getHasSynthesizedNames());
        if (!aVarL.getErrors().isEmpty()) {
            ((SignaturePropagator.a) context4VarChildForMethod$default.getComponents().getSignaturePropagator()).reportSignatureErrors(javaMethodDescriptorCreateJavaMethod, aVarL.getErrors());
        }
        return javaMethodDescriptorCreateJavaMethod;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0070  */
    /* JADX WARN: Code duplicated, block: B:44:0x0119  */
    /* JADX WARN: Code duplicated, block: B:46:0x011f  */
    /* JADX WARN: Code duplicated, block: B:48:0x0122  */
    /* JADX WARN: Code duplicated, block: B:57:0x0135 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public final b n(context4 context4Var, FunctionDescriptor functionDescriptor, List<? extends a0> list) {
        String value;
        Tuples2 tuples2;
        Name name;
        context4 context4Var2 = context4Var;
        Intrinsics3.checkNotNullParameter(context4Var2, "c");
        Intrinsics3.checkNotNullParameter(functionDescriptor, "function");
        Intrinsics3.checkNotNullParameter(list, "jValueParameters");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterable<IndexedValue> iterableWithIndex = _Collections.withIndex(list);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(iterableWithIndex, 10));
        boolean z2 = false;
        boolean z3 = false;
        for (IndexedValue indexedValue : iterableWithIndex) {
            int iComponent1 = indexedValue.component1();
            a0 a0Var = (a0) indexedValue.component2();
            Annotations4 annotations4ResolveAnnotations = LazyJavaAnnotations2.resolveAnnotations(context4Var2, a0Var);
            JavaTypeResolver attributes$default = JavaTypeResolver5.toAttributes$default(TypeUsage.COMMON, z2, null, 3, null);
            FqName fqName = JvmAnnotationNames.q;
            Intrinsics3.checkNotNullExpressionValue(fqName, "PARAMETER_NAME_FQ_NAME");
            AnnotationDescriptor annotationDescriptorFindAnnotation = annotations4ResolveAnnotations.findAnnotation(fqName);
            d0.e0.p.d.m0.k.v.g<?> gVarFirstArgument = annotationDescriptorFindAnnotation == null ? null : DescriptorUtils2.firstArgument(annotationDescriptorFindAnnotation);
            if (gVarFirstArgument != null) {
                if (!(gVarFirstArgument instanceof w)) {
                    gVarFirstArgument = null;
                }
                w wVar = (w) gVarFirstArgument;
                if (wVar == null) {
                    value = null;
                } else {
                    value = wVar.getValue();
                }
            } else {
                value = null;
            }
            if (a0Var.isVararg()) {
                javaTypes5 type = a0Var.getType();
                javaTypes2 javatypes2 = type instanceof javaTypes2 ? (javaTypes2) type : null;
                if (javatypes2 == null) {
                    throw new AssertionError(Intrinsics3.stringPlus("Vararg parameter should be an array: ", a0Var));
                }
                KotlinType kotlinTypeTransformArrayType = context4Var.getTypeResolver().transformArrayType(javatypes2, attributes$default, true);
                tuples2 = Tuples.to(kotlinTypeTransformArrayType, context4Var.getModule().getBuiltIns().getArrayElementType(kotlinTypeTransformArrayType));
            } else {
                tuples2 = Tuples.to(context4Var.getTypeResolver().transformJavaType(a0Var.getType(), attributes$default), null);
            }
            KotlinType kotlinType = (KotlinType) tuples2.component1();
            KotlinType kotlinType2 = (KotlinType) tuples2.component2();
            if (Intrinsics3.areEqual(((DeclarationDescriptorImpl) functionDescriptor).getName().asString(), "equals") && list.size() == 1 && Intrinsics3.areEqual(context4Var.getModule().getBuiltIns().getNullableAnyType(), kotlinType)) {
                name = Name.identifier("other");
            } else if (value == null) {
                name = a0Var.getName();
                if (name == null) {
                    z3 = true;
                }
                if (name == null) {
                    name = Name.identifier(Intrinsics3.stringPlus("p", Integer.valueOf(iComponent1)));
                    Intrinsics3.checkNotNullExpressionValue(name, "identifier(\"p$index\")");
                }
            } else if ((value.length() > 0) && linkedHashSet.add(value)) {
                name = Name.identifier(value);
            } else {
                name = a0Var.getName();
                if (name == null) {
                    z3 = true;
                }
                if (name == null) {
                    name = Name.identifier(Intrinsics3.stringPlus("p", Integer.valueOf(iComponent1)));
                    Intrinsics3.checkNotNullExpressionValue(name, "identifier(\"p$index\")");
                }
            }
            Name name2 = name;
            Intrinsics3.checkNotNullExpressionValue(name2, "if (function.name.asString() == \"equals\" &&\n                jValueParameters.size == 1 &&\n                c.module.builtIns.nullableAnyType == outType\n            ) {\n                // This is a hack to prevent numerous warnings on Kotlin classes that inherit Java classes: if you override \"equals\" in such\n                // class without this hack, you'll be warned that in the superclass the name is \"p0\" (regardless of the fact that it's\n                // \"other\" in Any)\n                // TODO: fix Java parameter name loading logic somehow (don't always load \"p0\", \"p1\", etc.)\n                Name.identifier(\"other\")\n            } else if (parameterName != null && parameterName.isNotEmpty() && usedNames.add(parameterName)) {\n                Name.identifier(parameterName)\n            } else {\n                // TODO: parameter names may be drawn from attached sources, which is slow; it's better to make them lazy\n                val javaName = javaParameter.name\n                if (javaName == null) synthesizedNames = true\n                javaName ?: Name.identifier(\"p$index\")\n            }");
            ArrayList arrayList2 = arrayList;
            arrayList2.add(new ValueParameterDescriptorImpl(functionDescriptor, null, iComponent1, annotations4ResolveAnnotations, name2, kotlinType, false, false, false, kotlinType2, context4Var.getComponents().getSourceElementFactory().source(a0Var)));
            arrayList = arrayList2;
            z3 = z3;
            z2 = false;
            context4Var2 = context4Var;
        }
        return new b(_Collections.toList(arrayList), z3);
    }

    public String toString() {
        return Intrinsics3.stringPlus("Lazy scope for ", j());
    }

    public LazyJavaScope(context4 context4Var, LazyJavaScope lazyJavaScope) {
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        this.c = context4Var;
        this.d = lazyJavaScope;
        this.e = context4Var.getStorageManager().createRecursionTolerantLazyValue(new c(), Collections2.emptyList());
        this.f = context4Var.getStorageManager().createLazyValue(new g());
        this.g = context4Var.getStorageManager().createMemoizedFunction(new f());
        this.h = context4Var.getStorageManager().createMemoizedFunctionWithNullableValues(new e());
        this.i = context4Var.getStorageManager().createMemoizedFunction(new i());
        this.j = context4Var.getStorageManager().createLazyValue(new h());
        this.k = context4Var.getStorageManager().createLazyValue(new k());
        this.l = context4Var.getStorageManager().createLazyValue(new d());
        this.m = context4Var.getStorageManager().createMemoizedFunction(new j());
    }
}
