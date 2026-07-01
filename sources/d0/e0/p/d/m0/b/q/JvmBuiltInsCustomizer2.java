package d0.e0.p.d.m0.b.q;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.b.q.JvmBuiltIns;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassConstructorDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassKind;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.DescriptorVisibilities;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.c.ModalityUtils;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.NotFoundClasses;
import d0.e0.p.d.m0.c.SimpleFunctionDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.c.descriptorUtil;
import d0.e0.p.d.m0.c.findClassInModule;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.g1.annotationUtil;
import d0.e0.p.d.m0.c.h1.AdditionalClassPartsProvider;
import d0.e0.p.d.m0.c.h1.PlatformDependentDeclarationFilter;
import d0.e0.p.d.m0.c.h1.PlatformDependentDeclarationFilter2;
import d0.e0.p.d.m0.c.i1.ClassDescriptorImpl;
import d0.e0.p.d.m0.d.b.LookupLocation3;
import d0.e0.p.d.m0.e.a.i0.l.LazyJavaClassDescriptor;
import d0.e0.p.d.m0.e.a.i0.l.LazyJavaClassMemberScope2;
import d0.e0.p.d.m0.e.b.SignatureBuildingComponents;
import d0.e0.p.d.m0.e.b.methodSignatureBuildingUtils;
import d0.e0.p.d.m0.e.b.methodSignatureMapping3;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.FqNameUnsafe;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.OverridingUtil;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.l.b.NameResolverUtil;
import d0.e0.p.d.m0.l.b.e0.DeserializedClassDescriptor;
import d0.e0.p.d.m0.m.LockBasedStorageManager;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.m.storage;
import d0.e0.p.d.m0.m.storage5;
import d0.e0.p.d.m0.m.storage7;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.SpecialTypes2;
import d0.e0.p.d.m0.n.TypeSubstitutor2;
import d0.e0.p.d.m0.p.DFS;
import d0.e0.p.d.m0.p.SmartSet;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.PropertyReference1Impl;
import d0.z.d.Reflection2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.g, reason: use source file name */
/* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JvmBuiltInsCustomizer2 implements AdditionalClassPartsProvider, PlatformDependentDeclarationFilter {
    public static final /* synthetic */ KProperty<Object>[] a = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(JvmBuiltInsCustomizer2.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(JvmBuiltInsCustomizer2.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(JvmBuiltInsCustomizer2.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ModuleDescriptor2 f3240b;
    public final JavaToKotlinClassMapper c;
    public final storage5 d;
    public final KotlinType e;
    public final storage5 f;
    public final storage<FqName, ClassDescriptor> g;
    public final storage5 h;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.g$a */
    /* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
    public enum a {
        HIDDEN,
        VISIBLE,
        NOT_CONSIDERED,
        DROP;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            a[] aVarArr = new a[aVarArrValuesCustom.length];
            System.arraycopy(aVarArrValuesCustom, 0, aVarArr, 0, aVarArrValuesCustom.length);
            return aVarArr;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.g$b */
    /* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
    public static final class b extends Lambda implements Function0<KotlinType4> {
        public final /* synthetic */ StorageManager $storageManager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(StorageManager storageManager) {
            super(0);
            this.$storageManager = storageManager;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KotlinType4 invoke() {
            return findClassInModule.findNonGenericClassAcrossDependencies(JvmBuiltInsCustomizer2.this.b().getOwnerModuleDescriptor(), JvmBuiltInClassDescriptorFactory.a.getCLONEABLE_CLASS_ID(), new NotFoundClasses(this.$storageManager, JvmBuiltInsCustomizer2.this.b().getOwnerModuleDescriptor())).getDefaultType();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.g$c */
    /* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
    public static final class c extends Lambda implements Function1<MemberScope3, Collection<? extends SimpleFunctionDescriptor>> {
        public final /* synthetic */ Name $name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Name name) {
            super(1);
            this.$name = name;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Collection<SimpleFunctionDescriptor> invoke(MemberScope3 memberScope3) {
            Intrinsics3.checkNotNullParameter(memberScope3, "it");
            return memberScope3.getContributedFunctions(this.$name, LookupLocation3.FROM_BUILTINS);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.g$d */
    /* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
    public static final class d extends Lambda implements Function0<Annotations4> {
        public d() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Annotations4 invoke() {
            return Annotations4.f.create(CollectionsJVM.listOf(annotationUtil.createDeprecatedAnnotation$default(JvmBuiltInsCustomizer2.this.f3240b.getBuiltIns(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", null, null, 6, null)));
        }
    }

    public JvmBuiltInsCustomizer2(ModuleDescriptor2 moduleDescriptor2, StorageManager storageManager, Function0<JvmBuiltIns.b> function0) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "moduleDescriptor");
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(function0, "settingsComputation");
        this.f3240b = moduleDescriptor2;
        this.c = JavaToKotlinClassMapper.a;
        this.d = storageManager.createLazyValue(function0);
        ClassDescriptorImpl classDescriptorImpl = new ClassDescriptorImpl(new JvmBuiltInsCustomizer3(moduleDescriptor2, new FqName("java.io")), Name.identifier("Serializable"), Modality.ABSTRACT, ClassKind.INTERFACE, CollectionsJVM.listOf(new SpecialTypes2(storageManager, new JvmBuiltInsCustomizer4(this))), SourceElement.a, false, storageManager);
        classDescriptorImpl.initialize(MemberScope3.b.f3461b, Sets5.emptySet(), null);
        KotlinType4 defaultType = classDescriptorImpl.getDefaultType();
        Intrinsics3.checkNotNullExpressionValue(defaultType, "mockSerializableClass.defaultType");
        this.e = defaultType;
        this.f = storageManager.createLazyValue(new b(storageManager));
        this.g = storageManager.createCacheWithNotNullValues();
        this.h = storageManager.createLazyValue(new d());
    }

    public final LazyJavaClassDescriptor a(ClassDescriptor classDescriptor) {
        if (KotlinBuiltIns.isAny(classDescriptor) || !KotlinBuiltIns.isUnderKotlinPackage(classDescriptor)) {
            return null;
        }
        FqNameUnsafe fqNameUnsafe = DescriptorUtils2.getFqNameUnsafe(classDescriptor);
        if (!fqNameUnsafe.isSafe()) {
            return null;
        }
        ClassId classIdMapKotlinToJava = JavaToKotlinClassMap.a.mapKotlinToJava(fqNameUnsafe);
        FqName fqNameAsSingleFqName = classIdMapKotlinToJava == null ? null : classIdMapKotlinToJava.asSingleFqName();
        if (fqNameAsSingleFqName == null) {
            return null;
        }
        ClassDescriptor classDescriptorResolveClassByFqName = descriptorUtil.resolveClassByFqName(b().getOwnerModuleDescriptor(), fqNameAsSingleFqName, LookupLocation3.FROM_BUILTINS);
        if (classDescriptorResolveClassByFqName instanceof LazyJavaClassDescriptor) {
            return (LazyJavaClassDescriptor) classDescriptorResolveClassByFqName;
        }
        return null;
    }

    public final JvmBuiltIns.b b() {
        return (JvmBuiltIns.b) storage7.getValue(this.d, this, (KProperty<?>) a[0]);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00e2  */
    @Override // d0.e0.p.d.m0.c.h1.AdditionalClassPartsProvider
    public Collection<ClassConstructorDescriptor> getConstructors(ClassDescriptor classDescriptor) {
        ClassDescriptor classDescriptorMapJavaToKotlin$default;
        boolean z2;
        boolean z3;
        Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
        if (classDescriptor.getKind() != ClassKind.CLASS || !b().isAdditionalBuiltInsFeatureSupported()) {
            return Collections2.emptyList();
        }
        LazyJavaClassDescriptor lazyJavaClassDescriptorA = a(classDescriptor);
        if (lazyJavaClassDescriptorA != null && (classDescriptorMapJavaToKotlin$default = JavaToKotlinClassMapper.mapJavaToKotlin$default(this.c, DescriptorUtils2.getFqNameSafe(lazyJavaClassDescriptorA), JvmBuiltInsCustomizer.f.getInstance(), null, 4, null)) != null) {
            TypeSubstitutor2 typeSubstitutor2BuildSubstitutor = mappingUtil.createMappedTypeParametersSubstitution(classDescriptorMapJavaToKotlin$default, lazyJavaClassDescriptorA).buildSubstitutor();
            List<ClassConstructorDescriptor> constructors = lazyJavaClassDescriptorA.getConstructors();
            ArrayList<ClassConstructorDescriptor> arrayList = new ArrayList();
            Iterator<T> it = constructors.iterator();
            while (true) {
                boolean z4 = false;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) next;
                if (classConstructorDescriptor.getVisibility().isPublicAPI()) {
                    Collection<ClassConstructorDescriptor> constructors2 = classDescriptorMapJavaToKotlin$default.getConstructors();
                    Intrinsics3.checkNotNullExpressionValue(constructors2, "defaultKotlinVersion.constructors");
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
                        ClassConstructorDescriptor classConstructorDescriptor2 = (ClassConstructorDescriptor) it2.next();
                        Intrinsics3.checkNotNullExpressionValue(classConstructorDescriptor2, "it");
                        if (OverridingUtil.getBothWaysOverridability(classConstructorDescriptor2, classConstructorDescriptor.substitute(typeSubstitutor2BuildSubstitutor)) == OverridingUtil.d.a.OVERRIDABLE) {
                            z2 = false;
                            break;
                        }
                    }
                    if (z2) {
                        if (classConstructorDescriptor.getValueParameters().size() == 1) {
                            List<ValueParameterDescriptor> valueParameters = classConstructorDescriptor.getValueParameters();
                            Intrinsics3.checkNotNullExpressionValue(valueParameters, "valueParameters");
                            ClassifierDescriptor declarationDescriptor = ((ValueParameterDescriptor) _Collections.single((List) valueParameters)).getType().getConstructor().getDeclarationDescriptor();
                            if (Intrinsics3.areEqual(declarationDescriptor == null ? null : DescriptorUtils2.getFqNameUnsafe(declarationDescriptor), DescriptorUtils2.getFqNameUnsafe(classDescriptor))) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                        } else {
                            z3 = false;
                        }
                        if (!z3 && !KotlinBuiltIns.isDeprecated(classConstructorDescriptor) && !JvmBuiltInsSignatures.a.getHIDDEN_CONSTRUCTOR_SIGNATURES().contains(methodSignatureBuildingUtils.signature(SignatureBuildingComponents.a, lazyJavaClassDescriptorA, methodSignatureMapping3.computeJvmDescriptor$default(classConstructorDescriptor, false, false, 3, null)))) {
                            z4 = true;
                        }
                    }
                }
                if (z4) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
            for (ClassConstructorDescriptor classConstructorDescriptor3 : arrayList) {
                FunctionDescriptor.a<? extends FunctionDescriptor> aVarNewCopyBuilder = classConstructorDescriptor3.newCopyBuilder();
                aVarNewCopyBuilder.setOwner(classDescriptor);
                aVarNewCopyBuilder.setReturnType(classDescriptor.getDefaultType());
                aVarNewCopyBuilder.setPreserveSourceElement();
                aVarNewCopyBuilder.setSubstitution(typeSubstitutor2BuildSubstitutor.getSubstitution());
                if (!JvmBuiltInsSignatures.a.getVISIBLE_CONSTRUCTOR_SIGNATURES().contains(methodSignatureBuildingUtils.signature(SignatureBuildingComponents.a, lazyJavaClassDescriptorA, methodSignatureMapping3.computeJvmDescriptor$default(classConstructorDescriptor3, false, false, 3, null)))) {
                    aVarNewCopyBuilder.setAdditionalAnnotations((Annotations4) storage7.getValue(this.h, this, (KProperty<?>) a[2]));
                }
                FunctionDescriptor functionDescriptorBuild = aVarNewCopyBuilder.build();
                Objects.requireNonNull(functionDescriptorBuild, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
                arrayList2.add((ClassConstructorDescriptor) functionDescriptorBuild);
            }
            return arrayList2;
        }
        return Collections2.emptyList();
    }

    /* JADX WARN: Code duplicated, block: B:68:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:84:0x027f  */
    @Override // d0.e0.p.d.m0.c.h1.AdditionalClassPartsProvider
    public Collection<SimpleFunctionDescriptor> getFunctions(Name name, ClassDescriptor classDescriptor) {
        List<SimpleFunctionDescriptor> listEmptyList;
        boolean z2;
        boolean z3;
        boolean zBooleanValue;
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
        boolean z4 = false;
        if (Intrinsics3.areEqual(name, CloneableClassScope.e.getCLONE_NAME()) && (classDescriptor instanceof DeserializedClassDescriptor) && KotlinBuiltIns.isArrayOrPrimitiveArray(classDescriptor)) {
            DeserializedClassDescriptor deserializedClassDescriptor = (DeserializedClassDescriptor) classDescriptor;
            List<d0.e0.p.d.m0.f.i> functionList = deserializedClassDescriptor.getClassProto().getFunctionList();
            Intrinsics3.checkNotNullExpressionValue(functionList, "classDescriptor.classProto.functionList");
            if (!(functionList instanceof Collection) || !functionList.isEmpty()) {
                Iterator<T> it = functionList.iterator();
                while (it.hasNext()) {
                    if (Intrinsics3.areEqual(NameResolverUtil.getName(deserializedClassDescriptor.getC().getNameResolver(), ((d0.e0.p.d.m0.f.i) it.next()).getName()), CloneableClassScope.e.getCLONE_NAME())) {
                        z4 = true;
                        break;
                    }
                }
            }
            if (z4) {
                return Collections2.emptyList();
            }
            FunctionDescriptor.a<? extends SimpleFunctionDescriptor> aVarNewCopyBuilder = ((SimpleFunctionDescriptor) _Collections.single(((KotlinType4) storage7.getValue(this.f, this, (KProperty<?>) a[1])).getMemberScope().getContributedFunctions(name, LookupLocation3.FROM_BUILTINS))).newCopyBuilder();
            aVarNewCopyBuilder.setOwner(deserializedClassDescriptor);
            aVarNewCopyBuilder.setVisibility(DescriptorVisibilities.e);
            aVarNewCopyBuilder.setReturnType(deserializedClassDescriptor.getDefaultType());
            aVarNewCopyBuilder.setDispatchReceiverParameter(deserializedClassDescriptor.getThisAsReceiverParameter());
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) aVarNewCopyBuilder.build();
            Intrinsics3.checkNotNull(simpleFunctionDescriptor2);
            return CollectionsJVM.listOf(simpleFunctionDescriptor2);
        }
        if (!b().isAdditionalBuiltInsFeatureSupported()) {
            return Collections2.emptyList();
        }
        c cVar = new c(name);
        LazyJavaClassDescriptor lazyJavaClassDescriptorA = a(classDescriptor);
        if (lazyJavaClassDescriptorA == null) {
            listEmptyList = Collections2.emptyList();
        } else {
            Collection<ClassDescriptor> collectionMapPlatformClass = this.c.mapPlatformClass(DescriptorUtils2.getFqNameSafe(lazyJavaClassDescriptorA), JvmBuiltInsCustomizer.f.getInstance());
            ClassDescriptor classDescriptor2 = (ClassDescriptor) _Collections.lastOrNull(collectionMapPlatformClass);
            if (classDescriptor2 == null) {
                listEmptyList = Collections2.emptyList();
            } else {
                SmartSet.b bVar = SmartSet.j;
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(collectionMapPlatformClass, 10));
                Iterator<T> it2 = collectionMapPlatformClass.iterator();
                while (it2.hasNext()) {
                    arrayList.add(DescriptorUtils2.getFqNameSafe((ClassDescriptor) it2.next()));
                }
                SmartSet smartSetCreate = bVar.create(arrayList);
                boolean zIsMutable = this.c.isMutable(classDescriptor);
                MemberScope3 unsubstitutedMemberScope = ((ClassDescriptor) ((LockBasedStorageManager.d) this.g).computeIfAbsent(DescriptorUtils2.getFqNameSafe(lazyJavaClassDescriptorA), new JvmBuiltInsCustomizer5(lazyJavaClassDescriptorA, classDescriptor2))).getUnsubstitutedMemberScope();
                Intrinsics3.checkNotNullExpressionValue(unsubstitutedMemberScope, "fakeJavaClassDescriptor.unsubstitutedMemberScope");
                Collection<? extends SimpleFunctionDescriptor> collectionInvoke = cVar.invoke(unsubstitutedMemberScope);
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : collectionInvoke) {
                    SimpleFunctionDescriptor simpleFunctionDescriptor3 = (SimpleFunctionDescriptor) obj;
                    if (simpleFunctionDescriptor3.getKind() == CallableMemberDescriptor.a.DECLARATION && simpleFunctionDescriptor3.getVisibility().isPublicAPI() && !KotlinBuiltIns.isDeprecated(simpleFunctionDescriptor3)) {
                        Collection<? extends FunctionDescriptor> overriddenDescriptors = simpleFunctionDescriptor3.getOverriddenDescriptors();
                        Intrinsics3.checkNotNullExpressionValue(overriddenDescriptors, "analogueMember.overriddenDescriptors");
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
                            DeclarationDescriptor containingDeclaration = ((FunctionDescriptor) it3.next()).getContainingDeclaration();
                            Intrinsics3.checkNotNullExpressionValue(containingDeclaration, "it.containingDeclaration");
                            if (smartSetCreate.contains(DescriptorUtils2.getFqNameSafe(containingDeclaration))) {
                                z3 = true;
                                break;
                            }
                        }
                        if (z3) {
                            z2 = false;
                        } else {
                            if (JvmBuiltInsSignatures.a.getMUTABLE_METHOD_SIGNATURES().contains(methodSignatureBuildingUtils.signature(SignatureBuildingComponents.a, (ClassDescriptor) simpleFunctionDescriptor3.getContainingDeclaration(), methodSignatureMapping3.computeJvmDescriptor$default(simpleFunctionDescriptor3, false, false, 3, null))) ^ zIsMutable) {
                                zBooleanValue = true;
                            } else {
                                Boolean boolIfAny = DFS.ifAny(CollectionsJVM.listOf(simpleFunctionDescriptor3), JvmBuiltInsCustomizer8.a, new JvmBuiltInsCustomizer9(this));
                                Intrinsics3.checkNotNullExpressionValue(boolIfAny, "private fun SimpleFunctionDescriptor.isMutabilityViolation(isMutable: Boolean): Boolean {\n        val owner = containingDeclaration as ClassDescriptor\n        val jvmDescriptor = computeJvmDescriptor()\n\n        if ((SignatureBuildingComponents.signature(owner, jvmDescriptor) in MUTABLE_METHOD_SIGNATURES) xor isMutable) return true\n\n        return DFS.ifAny<CallableMemberDescriptor>(\n            listOf(this),\n            { it.original.overriddenDescriptors }\n        ) { overridden ->\n            overridden.kind == CallableMemberDescriptor.Kind.DECLARATION &&\n                    j2kClassMapper.isMutable(overridden.containingDeclaration as ClassDescriptor)\n        }\n    }");
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
        for (SimpleFunctionDescriptor simpleFunctionDescriptor4 : listEmptyList) {
            FunctionDescriptor functionDescriptorSubstitute = simpleFunctionDescriptor4.substitute(mappingUtil.createMappedTypeParametersSubstitution((ClassDescriptor) simpleFunctionDescriptor4.getContainingDeclaration(), classDescriptor).buildSubstitutor());
            Objects.requireNonNull(functionDescriptorSubstitute, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
            FunctionDescriptor.a<? extends SimpleFunctionDescriptor> aVarNewCopyBuilder2 = ((SimpleFunctionDescriptor) functionDescriptorSubstitute).newCopyBuilder();
            aVarNewCopyBuilder2.setOwner(classDescriptor);
            aVarNewCopyBuilder2.setDispatchReceiverParameter(classDescriptor.getThisAsReceiverParameter());
            aVarNewCopyBuilder2.setPreserveSourceElement();
            Object objDfs = DFS.dfs(CollectionsJVM.listOf((ClassDescriptor) simpleFunctionDescriptor4.getContainingDeclaration()), new JvmBuiltInsCustomizer6(this), new JvmBuiltInsCustomizer7(methodSignatureMapping3.computeJvmDescriptor$default(simpleFunctionDescriptor4, false, false, 3, null), new Ref$ObjectRef()));
            Intrinsics3.checkNotNullExpressionValue(objDfs, "private fun FunctionDescriptor.getJdkMethodStatus(): JDKMemberStatus {\n        val owner = containingDeclaration as ClassDescriptor\n        val jvmDescriptor = computeJvmDescriptor()\n        var result: JDKMemberStatus? = null\n        return DFS.dfs<ClassDescriptor, JDKMemberStatus>(\n            listOf(owner),\n            {\n                // Search through mapped supertypes to determine that Set.toArray should be invisible, while we have only\n                // Collection.toArray there explicitly\n                // Note, that we can't find j.u.Collection.toArray within overriddenDescriptors of j.u.Set.toArray\n                it.typeConstructor.supertypes.mapNotNull {\n                    (it.constructor.declarationDescriptor?.original as? ClassDescriptor)?.getJavaAnalogue()\n                }\n            },\n            object : DFS.AbstractNodeHandler<ClassDescriptor, JDKMemberStatus>() {\n                override fun beforeChildren(javaClassDescriptor: ClassDescriptor): Boolean {\n                    val signature = SignatureBuildingComponents.signature(javaClassDescriptor, jvmDescriptor)\n                    when (signature) {\n                        in HIDDEN_METHOD_SIGNATURES -> result = JDKMemberStatus.HIDDEN\n                        in VISIBLE_METHOD_SIGNATURES -> result = JDKMemberStatus.VISIBLE\n                        in DROP_LIST_METHOD_SIGNATURES -> result = JDKMemberStatus.DROP\n                    }\n\n                    return result == null\n                }\n\n                override fun result() = result ?: JDKMemberStatus.NOT_CONSIDERED\n            })\n    }");
            int iOrdinal = ((a) objDfs).ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal == 2) {
                    aVarNewCopyBuilder2.setAdditionalAnnotations((Annotations4) storage7.getValue(this.h, this, (KProperty<?>) a[2]));
                } else if (iOrdinal == 3) {
                    simpleFunctionDescriptor = null;
                }
                simpleFunctionDescriptor = (SimpleFunctionDescriptor) aVarNewCopyBuilder2.build();
                Intrinsics3.checkNotNull(simpleFunctionDescriptor);
            } else if (ModalityUtils.isFinalClass(classDescriptor)) {
                simpleFunctionDescriptor = null;
            } else {
                aVarNewCopyBuilder2.setHiddenForResolutionEverywhereBesideSupercalls();
                simpleFunctionDescriptor = (SimpleFunctionDescriptor) aVarNewCopyBuilder2.build();
                Intrinsics3.checkNotNull(simpleFunctionDescriptor);
            }
            if (simpleFunctionDescriptor != null) {
                arrayList3.add(simpleFunctionDescriptor);
            }
        }
        return arrayList3;
    }

    @Override // d0.e0.p.d.m0.c.h1.AdditionalClassPartsProvider
    public Collection<KotlinType> getSupertypes(ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
        FqNameUnsafe fqNameUnsafe = DescriptorUtils2.getFqNameUnsafe(classDescriptor);
        JvmBuiltInsSignatures jvmBuiltInsSignatures = JvmBuiltInsSignatures.a;
        if (!jvmBuiltInsSignatures.isArrayOrPrimitiveArray(fqNameUnsafe)) {
            return jvmBuiltInsSignatures.isSerializableInJava(fqNameUnsafe) ? CollectionsJVM.listOf(this.e) : Collections2.emptyList();
        }
        KotlinType4 kotlinType4 = (KotlinType4) storage7.getValue(this.f, this, (KProperty<?>) a[1]);
        Intrinsics3.checkNotNullExpressionValue(kotlinType4, "cloneableType");
        return Collections2.listOf((Object[]) new KotlinType[]{kotlinType4, this.e});
    }

    @Override // d0.e0.p.d.m0.c.h1.PlatformDependentDeclarationFilter
    public boolean isFunctionAvailable(ClassDescriptor classDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
        Intrinsics3.checkNotNullParameter(simpleFunctionDescriptor, "functionDescriptor");
        LazyJavaClassDescriptor lazyJavaClassDescriptorA = a(classDescriptor);
        if (lazyJavaClassDescriptorA == null || !simpleFunctionDescriptor.getAnnotations().hasAnnotation(PlatformDependentDeclarationFilter2.getPLATFORM_DEPENDENT_ANNOTATION_FQ_NAME())) {
            return true;
        }
        if (!b().isAdditionalBuiltInsFeatureSupported()) {
            return false;
        }
        String strComputeJvmDescriptor$default = methodSignatureMapping3.computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 3, null);
        LazyJavaClassMemberScope2 unsubstitutedMemberScope = lazyJavaClassDescriptorA.getUnsubstitutedMemberScope();
        Name name = simpleFunctionDescriptor.getName();
        Intrinsics3.checkNotNullExpressionValue(name, "functionDescriptor.name");
        Collection<SimpleFunctionDescriptor> contributedFunctions = unsubstitutedMemberScope.getContributedFunctions(name, LookupLocation3.FROM_BUILTINS);
        if (!(contributedFunctions instanceof Collection) || !contributedFunctions.isEmpty()) {
            Iterator<T> it = contributedFunctions.iterator();
            while (it.hasNext()) {
                if (Intrinsics3.areEqual(methodSignatureMapping3.computeJvmDescriptor$default((SimpleFunctionDescriptor) it.next(), false, false, 3, null), strComputeJvmDescriptor$default)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // d0.e0.p.d.m0.c.h1.AdditionalClassPartsProvider
    public Set<Name> getFunctionsNames(ClassDescriptor classDescriptor) {
        LazyJavaClassMemberScope2 unsubstitutedMemberScope;
        Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
        if (!b().isAdditionalBuiltInsFeatureSupported()) {
            return Sets5.emptySet();
        }
        LazyJavaClassDescriptor lazyJavaClassDescriptorA = a(classDescriptor);
        Set<Name> functionNames = null;
        if (lazyJavaClassDescriptorA != null && (unsubstitutedMemberScope = lazyJavaClassDescriptorA.getUnsubstitutedMemberScope()) != null) {
            functionNames = unsubstitutedMemberScope.getFunctionNames();
        }
        return functionNames == null ? Sets5.emptySet() : functionNames;
    }
}
