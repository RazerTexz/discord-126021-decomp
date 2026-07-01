package d0.e0.p.d.m0.l.b.e0;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.d0._Ranges;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassConstructorDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassKind;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.c.NotFoundClasses;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.ScopesHolderForClass;
import d0.e0.p.d.m0.c.SimpleFunctionDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.SupertypeLoopChecker;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.i1.AbstractClassDescriptor;
import d0.e0.p.d.m0.c.i1.ClassConstructorDescriptorImpl;
import d0.e0.p.d.m0.c.i1.EnumEntrySyntheticClassDescriptor;
import d0.e0.p.d.m0.c.typeParameterUtils;
import d0.e0.p.d.m0.d.b.LookupLocation2;
import d0.e0.p.d.m0.d.b.LookupLocation3;
import d0.e0.p.d.m0.d.utils;
import d0.e0.p.d.m0.f.c;
import d0.e0.p.d.m0.f.q;
import d0.e0.p.d.m0.f.r;
import d0.e0.p.d.m0.f.s;
import d0.e0.p.d.m0.f.t;
import d0.e0.p.d.m0.f.w;
import d0.e0.p.d.m0.f.z.BinaryVersion;
import d0.e0.p.d.m0.f.z.Flags2;
import d0.e0.p.d.m0.f.z.NameResolver;
import d0.e0.p.d.m0.f.z.TypeTable;
import d0.e0.p.d.m0.f.z.VersionRequirement2;
import d0.e0.p.d.m0.f.z.protoTypeTableUtil;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.DescriptorFactory;
import d0.e0.p.d.m0.k.OverridingStrategy;
import d0.e0.p.d.m0.k.OverridingUtil;
import d0.e0.p.d.m0.k.SealedClassInheritorsProvider;
import d0.e0.p.d.m0.k.a0.MemberScope2;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.k.a0.MemberScopeImpl;
import d0.e0.p.d.m0.k.a0.ResolutionScope;
import d0.e0.p.d.m0.k.a0.StaticScopeForKotlinEnum;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.l.b.ErrorReporter;
import d0.e0.p.d.m0.l.b.MemberDeserializer;
import d0.e0.p.d.m0.l.b.NameResolverUtil;
import d0.e0.p.d.m0.l.b.ProtoContainer;
import d0.e0.p.d.m0.l.b.ProtoEnumFlags;
import d0.e0.p.d.m0.l.b.ProtoEnumFlagsUtils;
import d0.e0.p.d.m0.l.b.context5;
import d0.e0.p.d.m0.l.b.context6;
import d0.e0.p.d.m0.m.storage4;
import d0.e0.p.d.m0.m.storage5;
import d0.e0.p.d.m0.m.storage6;
import d0.e0.p.d.m0.n.AbstractClassTypeConstructor;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.MapsJVM;
import d0.t.MutableCollections;
import d0.t._Collections;
import d0.t._Sets;
import d0.z.d.FunctionReference;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.d, reason: use source file name */
/* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DeserializedClassDescriptor extends AbstractClassDescriptor implements DeclarationDescriptor {
    public final DeclarationDescriptor A;
    public final storage6<ClassConstructorDescriptor> B;
    public final storage5<Collection<ClassConstructorDescriptor>> C;
    public final storage6<ClassDescriptor> D;
    public final storage5<Collection<ClassDescriptor>> E;
    public final ProtoContainer.a F;
    public final Annotations4 G;
    public final d0.e0.p.d.m0.f.c o;
    public final BinaryVersion p;
    public final SourceElement q;
    public final ClassId r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Modality f3487s;
    public final DescriptorVisibility2 t;
    public final ClassKind u;
    public final context6 v;
    public final MemberScopeImpl w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final b f3488x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ScopesHolderForClass<a> f3489y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final c f3490z;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.d$a */
    /* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
    public final class a extends DeserializedMemberScope {
        public final KotlinTypeRefiner g;
        public final storage5<Collection<DeclarationDescriptor>> h;
        public final storage5<Collection<KotlinType>> i;
        public final /* synthetic */ DeserializedClassDescriptor j;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
        public static final class C0406a extends Lambda implements Function0<List<? extends Name>> {
            public final /* synthetic */ List<Name> $it;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0406a(List<Name> list) {
                super(0);
                this.$it = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Name> invoke() {
                return this.$it;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.d$a$b */
        /* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
        public static final class b extends Lambda implements Function0<Collection<? extends DeclarationDescriptor>> {
            public b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Collection<? extends DeclarationDescriptor> invoke() {
                return a.this.b(MemberScope2.m, MemberScope3.a.getALL_NAME_FILTER(), LookupLocation3.WHEN_GET_ALL_DESCRIPTORS);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.d$a$c */
        /* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
        public static final class c extends OverridingStrategy {
            public final /* synthetic */ List<D> a;

            public c(List<D> list) {
                this.a = list;
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // d0.e0.p.d.m0.k.OverridingStrategy2
            public void addFakeOverride(CallableMemberDescriptor callableMemberDescriptor) {
                Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "fakeOverride");
                OverridingUtil.resolveUnknownVisibilityForMember(callableMemberDescriptor, null);
                this.a.add((D) callableMemberDescriptor);
            }

            @Override // d0.e0.p.d.m0.k.OverridingStrategy
            public void conflict(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
                Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "fromSuper");
                Intrinsics3.checkNotNullParameter(callableMemberDescriptor2, "fromCurrent");
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.d$a$d */
        /* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
        public static final class d extends Lambda implements Function0<Collection<? extends KotlinType>> {
            public d() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Collection<? extends KotlinType> invoke() {
                return a.this.g.refineSupertypes(a.this.j);
            }
        }

        public a(DeserializedClassDescriptor deserializedClassDescriptor, KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics3.checkNotNullParameter(deserializedClassDescriptor, "this$0");
            Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            this.j = deserializedClassDescriptor;
            context6 c2 = deserializedClassDescriptor.getC();
            List<d0.e0.p.d.m0.f.i> functionList = deserializedClassDescriptor.getClassProto().getFunctionList();
            Intrinsics3.checkNotNullExpressionValue(functionList, "classProto.functionList");
            List<d0.e0.p.d.m0.f.n> propertyList = deserializedClassDescriptor.getClassProto().getPropertyList();
            Intrinsics3.checkNotNullExpressionValue(propertyList, "classProto.propertyList");
            List<r> typeAliasList = deserializedClassDescriptor.getClassProto().getTypeAliasList();
            Intrinsics3.checkNotNullExpressionValue(typeAliasList, "classProto.typeAliasList");
            List<Integer> nestedClassNameList = deserializedClassDescriptor.getClassProto().getNestedClassNameList();
            Intrinsics3.checkNotNullExpressionValue(nestedClassNameList, "classProto.nestedClassNameList");
            NameResolver nameResolver = deserializedClassDescriptor.getC().getNameResolver();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(nestedClassNameList, 10));
            Iterator<T> it = nestedClassNameList.iterator();
            while (it.hasNext()) {
                arrayList.add(NameResolverUtil.getName(nameResolver, ((Number) it.next()).intValue()));
            }
            super(c2, functionList, propertyList, typeAliasList, new C0406a(arrayList));
            this.g = kotlinTypeRefiner;
            this.h = this.c.getStorageManager().createLazyValue(new b());
            this.i = this.c.getStorageManager().createLazyValue(new d());
        }

        @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope
        public void a(Collection<DeclarationDescriptor> collection, Function1<? super Name, Boolean> function1) {
            Intrinsics3.checkNotNullParameter(collection, "result");
            Intrinsics3.checkNotNullParameter(function1, "nameFilter");
            c cVar = this.j.f3490z;
            Collection<ClassDescriptor> collectionAll = cVar == null ? null : cVar.all();
            if (collectionAll == null) {
                collectionAll = Collections2.emptyList();
            }
            collection.addAll(collectionAll);
        }

        @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope
        public void c(Name name, List<SimpleFunctionDescriptor> list) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(list, "functions");
            ArrayList arrayList = new ArrayList();
            Iterator<KotlinType> it = this.i.invoke().iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().getMemberScope().getContributedFunctions(name, LookupLocation3.FOR_ALREADY_TRACKED));
            }
            list.addAll(this.c.getComponents().getAdditionalClassPartsProvider().getFunctions(name, this.j));
            k(name, arrayList, list);
        }

        @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope
        public void d(Name name, List<PropertyDescriptor> list) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(list, "descriptors");
            ArrayList arrayList = new ArrayList();
            Iterator<KotlinType> it = this.i.invoke().iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().getMemberScope().getContributedVariables(name, LookupLocation3.FOR_ALREADY_TRACKED));
            }
            k(name, arrayList, list);
        }

        @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope
        public ClassId e(Name name) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            ClassId classIdCreateNestedClassId = this.j.r.createNestedClassId(name);
            Intrinsics3.checkNotNullExpressionValue(classIdCreateNestedClassId, "classId.createNestedClassId(name)");
            return classIdCreateNestedClassId;
        }

        @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope
        public Set<Name> f() {
            List<KotlinType> supertypes = this.j.f3488x.getSupertypes();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<T> it = supertypes.iterator();
            while (it.hasNext()) {
                Set<Name> classifierNames = ((KotlinType) it.next()).getMemberScope().getClassifierNames();
                if (classifierNames == null) {
                    return null;
                }
                MutableCollections.addAll(linkedHashSet, classifierNames);
            }
            return linkedHashSet;
        }

        @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope
        public Set<Name> g() {
            List<KotlinType> supertypes = this.j.f3488x.getSupertypes();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<T> it = supertypes.iterator();
            while (it.hasNext()) {
                MutableCollections.addAll(linkedHashSet, ((KotlinType) it.next()).getMemberScope().getFunctionNames());
            }
            linkedHashSet.addAll(this.c.getComponents().getAdditionalClassPartsProvider().getFunctionsNames(this.j));
            return linkedHashSet;
        }

        @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope, d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.ResolutionScope
        public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation2 lookupLocation2) {
            ClassDescriptor classDescriptorFindEnumEntry;
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            recordLookup(name, lookupLocation2);
            c cVar = this.j.f3490z;
            return (cVar == null || (classDescriptorFindEnumEntry = cVar.findEnumEntry(name)) == null) ? super.getContributedClassifier(name, lookupLocation2) : classDescriptorFindEnumEntry;
        }

        @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.ResolutionScope
        public Collection<DeclarationDescriptor> getContributedDescriptors(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
            Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
            Intrinsics3.checkNotNullParameter(function1, "nameFilter");
            return this.h.invoke();
        }

        @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope, d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            recordLookup(name, lookupLocation2);
            return super.getContributedFunctions(name, lookupLocation2);
        }

        @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope, d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
        public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            recordLookup(name, lookupLocation2);
            return super.getContributedVariables(name, lookupLocation2);
        }

        @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope
        public Set<Name> h() {
            List<KotlinType> supertypes = this.j.f3488x.getSupertypes();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<T> it = supertypes.iterator();
            while (it.hasNext()) {
                MutableCollections.addAll(linkedHashSet, ((KotlinType) it.next()).getMemberScope().getVariableNames());
            }
            return linkedHashSet;
        }

        @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope
        public boolean j(SimpleFunctionDescriptor simpleFunctionDescriptor) {
            Intrinsics3.checkNotNullParameter(simpleFunctionDescriptor, "function");
            return this.c.getComponents().getPlatformDependentDeclarationFilter().isFunctionAvailable(this.j, simpleFunctionDescriptor);
        }

        public final <D extends CallableMemberDescriptor> void k(Name name, Collection<? extends D> collection, List<D> list) {
            this.c.getComponents().getKotlinTypeChecker().getOverridingUtil().generateOverridesInFunctionGroup(name, collection, new ArrayList(list), this.j, new c(list));
        }

        public void recordLookup(Name name, LookupLocation2 lookupLocation2) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            utils.record(this.c.getComponents().getLookupTracker(), lookupLocation2, this.j, name);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.d$c */
    /* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
    public final class c {
        public final Map<Name, d0.e0.p.d.m0.f.g> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final storage4<Name, ClassDescriptor> f3491b;
        public final storage5<Set<Name>> c;
        public final /* synthetic */ DeserializedClassDescriptor d;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.d$c$a */
        /* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
        public static final class a extends Lambda implements Function1<Name, ClassDescriptor> {
            public final /* synthetic */ DeserializedClassDescriptor this$1;

            /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.d$c$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
            public static final class C0407a extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
                public final /* synthetic */ d0.e0.p.d.m0.f.g $proto;
                public final /* synthetic */ DeserializedClassDescriptor this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0407a(DeserializedClassDescriptor deserializedClassDescriptor, d0.e0.p.d.m0.f.g gVar) {
                    super(0);
                    this.this$0 = deserializedClassDescriptor;
                    this.$proto = gVar;
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<? extends AnnotationDescriptor> invoke() {
                    return _Collections.toList(this.this$0.getC().getComponents().getAnnotationAndConstantLoader().loadEnumEntryAnnotations(this.this$0.getThisAsProtoContainer$deserialization(), this.$proto));
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(DeserializedClassDescriptor deserializedClassDescriptor) {
                super(1);
                this.this$1 = deserializedClassDescriptor;
            }

            @Override // kotlin.jvm.functions.Function1
            public final ClassDescriptor invoke(Name name) {
                Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
                d0.e0.p.d.m0.f.g gVar = (d0.e0.p.d.m0.f.g) c.this.a.get(name);
                if (gVar == null) {
                    return null;
                }
                DeserializedClassDescriptor deserializedClassDescriptor = this.this$1;
                return EnumEntrySyntheticClassDescriptor.create(deserializedClassDescriptor.getC().getStorageManager(), deserializedClassDescriptor, name, c.this.c, new DeserializedAnnotations(deserializedClassDescriptor.getC().getStorageManager(), new C0407a(deserializedClassDescriptor, gVar)), SourceElement.a);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.d$c$b */
        /* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
        public static final class b extends Lambda implements Function0<Set<? extends Name>> {
            public b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set<? extends Name> invoke() {
                return c.access$computeEnumMemberNames(c.this);
            }
        }

        public c(DeserializedClassDescriptor deserializedClassDescriptor) {
            Intrinsics3.checkNotNullParameter(deserializedClassDescriptor, "this$0");
            this.d = deserializedClassDescriptor;
            List<d0.e0.p.d.m0.f.g> enumEntryList = deserializedClassDescriptor.getClassProto().getEnumEntryList();
            Intrinsics3.checkNotNullExpressionValue(enumEntryList, "classProto.enumEntryList");
            LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(enumEntryList, 10)), 16));
            for (Object obj : enumEntryList) {
                linkedHashMap.put(NameResolverUtil.getName(deserializedClassDescriptor.getC().getNameResolver(), ((d0.e0.p.d.m0.f.g) obj).getName()), obj);
            }
            this.a = linkedHashMap;
            this.f3491b = this.d.getC().getStorageManager().createMemoizedFunctionWithNullableValues(new a(this.d));
            this.c = this.d.getC().getStorageManager().createLazyValue(new b());
        }

        public static final Set access$computeEnumMemberNames(c cVar) {
            Objects.requireNonNull(cVar);
            HashSet hashSet = new HashSet();
            Iterator<KotlinType> it = cVar.d.getTypeConstructor().getSupertypes().iterator();
            while (it.hasNext()) {
                for (DeclarationDescriptor declarationDescriptor : ResolutionScope.a.getContributedDescriptors$default(it.next().getMemberScope(), null, null, 3, null)) {
                    if ((declarationDescriptor instanceof SimpleFunctionDescriptor) || (declarationDescriptor instanceof PropertyDescriptor)) {
                        hashSet.add(declarationDescriptor.getName());
                    }
                }
            }
            List<d0.e0.p.d.m0.f.i> functionList = cVar.d.getClassProto().getFunctionList();
            Intrinsics3.checkNotNullExpressionValue(functionList, "classProto.functionList");
            DeserializedClassDescriptor deserializedClassDescriptor = cVar.d;
            Iterator<T> it2 = functionList.iterator();
            while (it2.hasNext()) {
                hashSet.add(NameResolverUtil.getName(deserializedClassDescriptor.getC().getNameResolver(), ((d0.e0.p.d.m0.f.i) it2.next()).getName()));
            }
            List<d0.e0.p.d.m0.f.n> propertyList = cVar.d.getClassProto().getPropertyList();
            Intrinsics3.checkNotNullExpressionValue(propertyList, "classProto.propertyList");
            DeserializedClassDescriptor deserializedClassDescriptor2 = cVar.d;
            Iterator<T> it3 = propertyList.iterator();
            while (it3.hasNext()) {
                hashSet.add(NameResolverUtil.getName(deserializedClassDescriptor2.getC().getNameResolver(), ((d0.e0.p.d.m0.f.n) it3.next()).getName()));
            }
            return _Sets.plus((Set) hashSet, (Iterable) hashSet);
        }

        public final Collection<ClassDescriptor> all() {
            Set<Name> setKeySet = this.a.keySet();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = setKeySet.iterator();
            while (it.hasNext()) {
                ClassDescriptor classDescriptorFindEnumEntry = findEnumEntry((Name) it.next());
                if (classDescriptorFindEnumEntry != null) {
                    arrayList.add(classDescriptorFindEnumEntry);
                }
            }
            return arrayList;
        }

        public final ClassDescriptor findEnumEntry(Name name) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return this.f3491b.invoke(name);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.d$d */
    /* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
    public static final class d extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends AnnotationDescriptor> invoke() {
            return _Collections.toList(DeserializedClassDescriptor.this.getC().getComponents().getAnnotationAndConstantLoader().loadClassAnnotations(DeserializedClassDescriptor.this.getThisAsProtoContainer$deserialization()));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.d$e */
    /* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
    public static final class e extends Lambda implements Function0<ClassDescriptor> {
        public e() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ClassDescriptor invoke() {
            return DeserializedClassDescriptor.access$computeCompanionObjectDescriptor(DeserializedClassDescriptor.this);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.d$f */
    /* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
    public static final class f extends Lambda implements Function0<Collection<? extends ClassConstructorDescriptor>> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Collection<? extends ClassConstructorDescriptor> invoke() {
            return DeserializedClassDescriptor.access$computeConstructors(DeserializedClassDescriptor.this);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.d$g */
    /* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
    public /* synthetic */ class g extends FunctionReference implements Function1<KotlinTypeRefiner, a> {
        public g(DeserializedClassDescriptor deserializedClassDescriptor) {
            super(1, deserializedClassDescriptor);
        }

        @Override // d0.z.d.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "<init>";
        }

        @Override // d0.z.d.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinClass(a.class);
        }

        @Override // d0.z.d.CallableReference
        public final String getSignature() {
            return "<init>(Lorg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor;Lorg/jetbrains/kotlin/types/checker/KotlinTypeRefiner;)V";
        }

        @Override // kotlin.jvm.functions.Function1
        public final a invoke(KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "p0");
            return new a((DeserializedClassDescriptor) this.receiver, kotlinTypeRefiner);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.d$h */
    /* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
    public static final class h extends Lambda implements Function0<ClassConstructorDescriptor> {
        public h() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ClassConstructorDescriptor invoke() {
            return DeserializedClassDescriptor.access$computePrimaryConstructor(DeserializedClassDescriptor.this);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.d$i */
    /* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
    public static final class i extends Lambda implements Function0<Collection<? extends ClassDescriptor>> {
        public i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Collection<? extends ClassDescriptor> invoke() {
            return DeserializedClassDescriptor.access$computeSubclassesForSealedClass(DeserializedClassDescriptor.this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor(context6 context6Var, d0.e0.p.d.m0.f.c cVar, NameResolver nameResolver, BinaryVersion binaryVersion, SourceElement sourceElement) {
        super(context6Var.getStorageManager(), NameResolverUtil.getClassId(nameResolver, cVar.getFqName()).getShortClassName());
        Intrinsics3.checkNotNullParameter(context6Var, "outerContext");
        Intrinsics3.checkNotNullParameter(cVar, "classProto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(binaryVersion, "metadataVersion");
        Intrinsics3.checkNotNullParameter(sourceElement, "sourceElement");
        this.o = cVar;
        this.p = binaryVersion;
        this.q = sourceElement;
        this.r = NameResolverUtil.getClassId(nameResolver, cVar.getFqName());
        ProtoEnumFlags protoEnumFlags = ProtoEnumFlags.a;
        this.f3487s = protoEnumFlags.modality(Flags2.d.get(cVar.getFlags()));
        this.t = ProtoEnumFlagsUtils.descriptorVisibility(protoEnumFlags, Flags2.c.get(cVar.getFlags()));
        ClassKind classKind = protoEnumFlags.classKind(Flags2.e.get(cVar.getFlags()));
        this.u = classKind;
        List<s> typeParameterList = cVar.getTypeParameterList();
        Intrinsics3.checkNotNullExpressionValue(typeParameterList, "classProto.typeParameterList");
        t typeTable = cVar.getTypeTable();
        Intrinsics3.checkNotNullExpressionValue(typeTable, "classProto.typeTable");
        TypeTable typeTable2 = new TypeTable(typeTable);
        VersionRequirement2.a aVar = VersionRequirement2.a;
        w versionRequirementTable = cVar.getVersionRequirementTable();
        Intrinsics3.checkNotNullExpressionValue(versionRequirementTable, "classProto.versionRequirementTable");
        context6 context6VarChildContext = context6Var.childContext(this, typeParameterList, nameResolver, typeTable2, aVar.create(versionRequirementTable), binaryVersion);
        this.v = context6VarChildContext;
        ClassKind classKind2 = ClassKind.ENUM_CLASS;
        this.w = classKind == classKind2 ? new StaticScopeForKotlinEnum(context6VarChildContext.getStorageManager(), this) : MemberScope3.b.f3461b;
        this.f3488x = new b(this);
        this.f3489y = ScopesHolderForClass.a.create(this, context6VarChildContext.getStorageManager(), context6VarChildContext.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner(), new g(this));
        this.f3490z = classKind == classKind2 ? new c(this) : null;
        DeclarationDescriptor containingDeclaration = context6Var.getContainingDeclaration();
        this.A = containingDeclaration;
        this.B = context6VarChildContext.getStorageManager().createNullableLazyValue(new h());
        this.C = context6VarChildContext.getStorageManager().createLazyValue(new f());
        this.D = context6VarChildContext.getStorageManager().createNullableLazyValue(new e());
        this.E = context6VarChildContext.getStorageManager().createLazyValue(new i());
        NameResolver nameResolver2 = context6VarChildContext.getNameResolver();
        TypeTable typeTable3 = context6VarChildContext.getTypeTable();
        DeserializedClassDescriptor deserializedClassDescriptor = containingDeclaration instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) containingDeclaration : null;
        this.F = new ProtoContainer.a(cVar, nameResolver2, typeTable3, sourceElement, deserializedClassDescriptor != null ? deserializedClassDescriptor.F : null);
        this.G = !Flags2.f3412b.get(cVar.getFlags()).booleanValue() ? Annotations4.f.getEMPTY() : new DeserializedAnnotations2(context6VarChildContext.getStorageManager(), new d());
    }

    public static final ClassDescriptor access$computeCompanionObjectDescriptor(DeserializedClassDescriptor deserializedClassDescriptor) {
        if (!deserializedClassDescriptor.o.hasCompanionObjectName()) {
            return null;
        }
        ClassifierDescriptor contributedClassifier = deserializedClassDescriptor.b().getContributedClassifier(NameResolverUtil.getName(deserializedClassDescriptor.v.getNameResolver(), deserializedClassDescriptor.o.getCompanionObjectName()), LookupLocation3.FROM_DESERIALIZATION);
        if (contributedClassifier instanceof ClassDescriptor) {
            return (ClassDescriptor) contributedClassifier;
        }
        return null;
    }

    public static final Collection access$computeConstructors(DeserializedClassDescriptor deserializedClassDescriptor) {
        List<d0.e0.p.d.m0.f.d> constructorList = deserializedClassDescriptor.o.getConstructorList();
        ArrayList<d0.e0.p.d.m0.f.d> arrayListA0 = outline.a0(constructorList, "classProto.constructorList");
        for (Object obj : constructorList) {
            Boolean bool = Flags2.l.get(((d0.e0.p.d.m0.f.d) obj).getFlags());
            Intrinsics3.checkNotNullExpressionValue(bool, "IS_SECONDARY.get(it.flags)");
            if (bool.booleanValue()) {
                arrayListA0.add(obj);
            }
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(arrayListA0, 10));
        for (d0.e0.p.d.m0.f.d dVar : arrayListA0) {
            MemberDeserializer memberDeserializer = deserializedClassDescriptor.getC().getMemberDeserializer();
            Intrinsics3.checkNotNullExpressionValue(dVar, "it");
            arrayList.add(memberDeserializer.loadConstructor(dVar, false));
        }
        return _Collections.plus((Collection) _Collections.plus((Collection) arrayList, (Iterable) Collections2.listOfNotNull(deserializedClassDescriptor.getUnsubstitutedPrimaryConstructor())), (Iterable) deserializedClassDescriptor.v.getComponents().getAdditionalClassPartsProvider().getConstructors(deserializedClassDescriptor));
    }

    public static final ClassConstructorDescriptor access$computePrimaryConstructor(DeserializedClassDescriptor deserializedClassDescriptor) {
        Object next;
        if (deserializedClassDescriptor.u.isSingleton()) {
            ClassConstructorDescriptorImpl classConstructorDescriptorImplCreatePrimaryConstructorForObject = DescriptorFactory.createPrimaryConstructorForObject(deserializedClassDescriptor, SourceElement.a);
            classConstructorDescriptorImplCreatePrimaryConstructorForObject.setReturnType(deserializedClassDescriptor.getDefaultType());
            return classConstructorDescriptorImplCreatePrimaryConstructorForObject;
        }
        List<d0.e0.p.d.m0.f.d> constructorList = deserializedClassDescriptor.o.getConstructorList();
        Intrinsics3.checkNotNullExpressionValue(constructorList, "classProto.constructorList");
        Iterator<T> it = constructorList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(!Flags2.l.get(((d0.e0.p.d.m0.f.d) next).getFlags()).booleanValue()));
        d0.e0.p.d.m0.f.d dVar = (d0.e0.p.d.m0.f.d) next;
        if (dVar == null) {
            return null;
        }
        return deserializedClassDescriptor.getC().getMemberDeserializer().loadConstructor(dVar, true);
    }

    public static final Collection access$computeSubclassesForSealedClass(DeserializedClassDescriptor deserializedClassDescriptor) {
        if (deserializedClassDescriptor.f3487s != Modality.SEALED) {
            return Collections2.emptyList();
        }
        List<Integer> sealedSubclassFqNameList = deserializedClassDescriptor.o.getSealedSubclassFqNameList();
        Intrinsics3.checkNotNullExpressionValue(sealedSubclassFqNameList, "fqNames");
        if (!(!sealedSubclassFqNameList.isEmpty())) {
            return SealedClassInheritorsProvider.a.computeSealedSubclasses(deserializedClassDescriptor, false);
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : sealedSubclassFqNameList) {
            context5 components = deserializedClassDescriptor.getC().getComponents();
            NameResolver nameResolver = deserializedClassDescriptor.getC().getNameResolver();
            Intrinsics3.checkNotNullExpressionValue(num, "index");
            ClassDescriptor classDescriptorDeserializeClass = components.deserializeClass(NameResolverUtil.getClassId(nameResolver, num.intValue()));
            if (classDescriptorDeserializeClass != null) {
                arrayList.add(classDescriptorDeserializeClass);
            }
        }
        return arrayList;
    }

    public final a b() {
        return (a) this.f3489y.getScope(this.v.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner());
    }

    @Override // d0.e0.p.d.m0.c.g1.Annotations3
    public Annotations4 getAnnotations() {
        return this.G;
    }

    public final context6 getC() {
        return this.v;
    }

    public final d0.e0.p.d.m0.f.c getClassProto() {
        return this.o;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public ClassDescriptor getCompanionObjectDescriptor() {
        return this.D.invoke();
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public Collection<ClassConstructorDescriptor> getConstructors() {
        return this.C.invoke();
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor, d0.e0.p.d.m0.c.DeclarationDescriptorNonRoot, d0.e0.p.d.m0.c.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        return this.A;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor, d0.e0.p.d.m0.c.ClassifierDescriptorWithTypeParameters
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.v.getTypeDeserializer().getOwnTypeParameters();
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public ClassKind getKind() {
        return this.u;
    }

    public final BinaryVersion getMetadataVersion() {
        return this.p;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor, d0.e0.p.d.m0.c.MemberDescriptor
    public Modality getModality() {
        return this.f3487s;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public Collection<ClassDescriptor> getSealedSubclasses() {
        return this.E.invoke();
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        return this.q;
    }

    public final ProtoContainer.a getThisAsProtoContainer$deserialization() {
        return this.F;
    }

    @Override // d0.e0.p.d.m0.c.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        return this.f3488x;
    }

    @Override // d0.e0.p.d.m0.c.i1.ModuleAwareClassDescriptor
    public MemberScope3 getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.f3489y.getScope(kotlinTypeRefiner);
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return this.B.invoke();
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor, d0.e0.p.d.m0.c.DeclarationDescriptorWithVisibility, d0.e0.p.d.m0.c.MemberDescriptor
    public DescriptorVisibility2 getVisibility() {
        return this.t;
    }

    public final boolean hasNestedClass$deserialization(Name name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return b().getClassNames$deserialization().contains(name);
    }

    @Override // d0.e0.p.d.m0.c.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public boolean isCompanionObject() {
        return Flags2.e.get(this.o.getFlags()) == c.EnumC0397c.COMPANION_OBJECT;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public boolean isData() {
        Boolean bool = Flags2.g.get(this.o.getFlags());
        Intrinsics3.checkNotNullExpressionValue(bool, "IS_DATA.get(classProto.flags)");
        return bool.booleanValue();
    }

    @Override // d0.e0.p.d.m0.c.MemberDescriptor
    public boolean isExpect() {
        Boolean bool = Flags2.i.get(this.o.getFlags());
        Intrinsics3.checkNotNullExpressionValue(bool, "IS_EXPECT_CLASS.get(classProto.flags)");
        return bool.booleanValue();
    }

    @Override // d0.e0.p.d.m0.c.MemberDescriptor
    public boolean isExternal() {
        Boolean bool = Flags2.h.get(this.o.getFlags());
        Intrinsics3.checkNotNullExpressionValue(bool, "IS_EXTERNAL_CLASS.get(classProto.flags)");
        return bool.booleanValue();
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public boolean isFun() {
        Boolean bool = Flags2.k.get(this.o.getFlags());
        Intrinsics3.checkNotNullExpressionValue(bool, "IS_FUN_INTERFACE.get(classProto.flags)");
        return bool.booleanValue();
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public boolean isInline() {
        Boolean bool = Flags2.j.get(this.o.getFlags());
        Intrinsics3.checkNotNullExpressionValue(bool, "IS_INLINE_CLASS.get(classProto.flags)");
        return bool.booleanValue() && this.p.isAtMost(1, 4, 1);
    }

    @Override // d0.e0.p.d.m0.c.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        Boolean bool = Flags2.f.get(this.o.getFlags());
        Intrinsics3.checkNotNullExpressionValue(bool, "IS_INNER.get(classProto.flags)");
        return bool.booleanValue();
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public boolean isValue() {
        Boolean bool = Flags2.j.get(this.o.getFlags());
        Intrinsics3.checkNotNullExpressionValue(bool, "IS_INLINE_CLASS.get(classProto.flags)");
        return bool.booleanValue() && this.p.isAtLeast(1, 4, 2);
    }

    public String toString() {
        StringBuilder sbU = outline.U("deserialized ");
        sbU.append(isExpect() ? "expect " : "");
        sbU.append("class ");
        sbU.append(getName());
        return sbU.toString();
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.d$b */
    /* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
    public final class b extends AbstractClassTypeConstructor {
        public final storage5<List<TypeParameterDescriptor>> c;
        public final /* synthetic */ DeserializedClassDescriptor d;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.d$b$a */
        /* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
        public static final class a extends Lambda implements Function0<List<? extends TypeParameterDescriptor>> {
            public final /* synthetic */ DeserializedClassDescriptor this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(DeserializedClassDescriptor deserializedClassDescriptor) {
                super(0);
                this.this$0 = deserializedClassDescriptor;
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends TypeParameterDescriptor> invoke() {
                return typeParameterUtils.computeConstructorTypeParameters(this.this$0);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(DeserializedClassDescriptor deserializedClassDescriptor) {
            super(deserializedClassDescriptor.getC().getStorageManager());
            Intrinsics3.checkNotNullParameter(deserializedClassDescriptor, "this$0");
            this.d = deserializedClassDescriptor;
            this.c = deserializedClassDescriptor.getC().getStorageManager().createLazyValue(new a(deserializedClassDescriptor));
        }

        @Override // d0.e0.p.d.m0.n.AbstractTypeConstructor
        public Collection<KotlinType> a() {
            FqName fqNameAsSingleFqName;
            List<q> listSupertypes = protoTypeTableUtil.supertypes(this.d.getClassProto(), this.d.getC().getTypeTable());
            DeserializedClassDescriptor deserializedClassDescriptor = this.d;
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listSupertypes, 10));
            Iterator<T> it = listSupertypes.iterator();
            while (it.hasNext()) {
                arrayList.add(deserializedClassDescriptor.getC().getTypeDeserializer().type((q) it.next()));
            }
            List listPlus = _Collections.plus((Collection) arrayList, (Iterable) this.d.getC().getComponents().getAdditionalClassPartsProvider().getSupertypes(this.d));
            ArrayList<NotFoundClasses.b> arrayList2 = new ArrayList();
            Iterator it2 = listPlus.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                ClassifierDescriptor declarationDescriptor = ((KotlinType) it2.next()).getConstructor().getDeclarationDescriptor();
                NotFoundClasses.b bVar = declarationDescriptor instanceof NotFoundClasses.b ? (NotFoundClasses.b) declarationDescriptor : null;
                if (bVar != null) {
                    arrayList2.add(bVar);
                }
            }
            if (!arrayList2.isEmpty()) {
                ErrorReporter errorReporter = this.d.getC().getComponents().getErrorReporter();
                DeserializedClassDescriptor deserializedClassDescriptor2 = this.d;
                ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList2, 10));
                for (NotFoundClasses.b bVar2 : arrayList2) {
                    ClassId classId = DescriptorUtils2.getClassId(bVar2);
                    String strAsString = (classId == null || (fqNameAsSingleFqName = classId.asSingleFqName()) == null) ? null : fqNameAsSingleFqName.asString();
                    if (strAsString == null) {
                        strAsString = bVar2.getName().asString();
                    }
                    arrayList3.add(strAsString);
                }
                errorReporter.reportIncompleteHierarchy(deserializedClassDescriptor2, arrayList3);
            }
            return _Collections.toList(listPlus);
        }

        @Override // d0.e0.p.d.m0.n.AbstractTypeConstructor
        public SupertypeLoopChecker d() {
            return SupertypeLoopChecker.a.a;
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            return this.c.invoke();
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        public String toString() {
            String string = this.d.getName().toString();
            Intrinsics3.checkNotNullExpressionValue(string, "name.toString()");
            return string;
        }

        @Override // d0.e0.p.d.m0.n.AbstractTypeConstructor, d0.e0.p.d.m0.n.TypeConstructor
        public DeserializedClassDescriptor getDeclarationDescriptor() {
            return this.d;
        }
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public MemberScopeImpl getStaticScope() {
        return this.w;
    }
}
