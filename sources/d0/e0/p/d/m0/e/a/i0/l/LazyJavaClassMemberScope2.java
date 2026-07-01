package d0.e0.p.d.m0.e.a.i0.l;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.d0._Ranges;
import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.b.suspendFunctionTypes;
import d0.e0.p.d.m0.c.CallableDescriptor;
import d0.e0.p.d.m0.c.ClassConstructorDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.ConstructorDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.DescriptorVisibilities;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.PropertyGetterDescriptor;
import d0.e0.p.d.m0.c.PropertySetterDescriptor;
import d0.e0.p.d.m0.c.ReceiverParameterDescriptor;
import d0.e0.p.d.m0.c.SimpleFunctionDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.i1.ClassDescriptorBase;
import d0.e0.p.d.m0.c.i1.EnumEntrySyntheticClassDescriptor;
import d0.e0.p.d.m0.c.i1.PropertyGetterDescriptorImpl;
import d0.e0.p.d.m0.c.i1.PropertySetterDescriptorImpl;
import d0.e0.p.d.m0.c.i1.SimpleFunctionDescriptorImpl;
import d0.e0.p.d.m0.c.i1.ValueParameterDescriptorImpl;
import d0.e0.p.d.m0.d.b.LookupLocation2;
import d0.e0.p.d.m0.d.b.LookupLocation3;
import d0.e0.p.d.m0.d.utils;
import d0.e0.p.d.m0.e.a.ClassicBuiltinSpecialProperties;
import d0.e0.p.d.m0.e.a.JavaClassFinder;
import d0.e0.p.d.m0.e.a.JavaDescriptorVisibilities;
import d0.e0.p.d.m0.e.a.JavaIncompatibilityRulesOverridabilityCondition;
import d0.e0.p.d.m0.e.a.JvmAbi;
import d0.e0.p.d.m0.e.a.JvmAnnotationNames;
import d0.e0.p.d.m0.e.a.g0.DescriptorResolverUtils;
import d0.e0.p.d.m0.e.a.g0.JavaResolverCache;
import d0.e0.p.d.m0.e.a.g0.SignaturePropagator;
import d0.e0.p.d.m0.e.a.g0.TypeUsage;
import d0.e0.p.d.m0.e.a.h0.JavaClassConstructorDescriptor;
import d0.e0.p.d.m0.e.a.h0.JavaForKotlinOverridePropertyDescriptor;
import d0.e0.p.d.m0.e.a.h0.JavaMethodDescriptor;
import d0.e0.p.d.m0.e.a.h0.JavaPropertyDescriptor;
import d0.e0.p.d.m0.e.a.h0.util3;
import d0.e0.p.d.m0.e.a.h0.util4;
import d0.e0.p.d.m0.e.a.i0.LazyJavaAnnotations2;
import d0.e0.p.d.m0.e.a.i0.context;
import d0.e0.p.d.m0.e.a.i0.context4;
import d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope;
import d0.e0.p.d.m0.e.a.i0.m.JavaTypeResolver;
import d0.e0.p.d.m0.e.a.i0.m.JavaTypeResolver5;
import d0.e0.p.d.m0.e.a.k0.javaTypes2;
import d0.e0.p.d.m0.e.a.k0.javaTypes5;
import d0.e0.p.d.m0.e.a.k0.w;
import d0.e0.p.d.m0.e.a.k0.y;
import d0.e0.p.d.m0.e.a.l0.signatureEnhancement;
import d0.e0.p.d.m0.e.a.propertiesConventionUtil;
import d0.e0.p.d.m0.e.a.specialBuiltinMembers;
import d0.e0.p.d.m0.e.a.specialBuiltinMembers2;
import d0.e0.p.d.m0.e.a.specialBuiltinMembers3;
import d0.e0.p.d.m0.e.a.utils2;
import d0.e0.p.d.m0.e.b.methodSignatureMapping3;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.FqNameUnsafe;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.DescriptorFactory;
import d0.e0.p.d.m0.k.DescriptorUtils;
import d0.e0.p.d.m0.k.OverridingUtil;
import d0.e0.p.d.m0.k.a0.MemberScope2;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.l.b.ErrorReporter;
import d0.e0.p.d.m0.m.storage4;
import d0.e0.p.d.m0.m.storage5;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.TypeUtils;
import d0.e0.p.d.m0.n.l1.KotlinTypeChecker;
import d0.e0.p.d.m0.p.SmartSet;
import d0.e0.p.d.m0.p.collections;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
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
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.h, reason: use source file name */
/* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LazyJavaClassMemberScope2 extends LazyJavaScope {
    public final ClassDescriptor n;
    public final d0.e0.p.d.m0.e.a.k0.g o;
    public final boolean p;
    public final storage5<List<ClassConstructorDescriptor>> q;
    public final storage5<Set<Name>> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final storage5<Map<Name, d0.e0.p.d.m0.e.a.k0.n>> f3332s;
    public final storage4<Name, ClassDescriptorBase> t;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.h$a */
    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    public /* synthetic */ class a extends FunctionReference implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
        public a(LazyJavaClassMemberScope2 lazyJavaClassMemberScope2) {
            super(1, lazyJavaClassMemberScope2);
        }

        @Override // d0.z.d.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "searchMethodsByNameWithoutBuiltinMagic";
        }

        @Override // d0.z.d.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinClass(LazyJavaClassMemberScope2.class);
        }

        @Override // d0.z.d.CallableReference
        public final String getSignature() {
            return "searchMethodsByNameWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
        }

        @Override // kotlin.jvm.functions.Function1
        public final Collection<SimpleFunctionDescriptor> invoke(Name name) {
            Intrinsics3.checkNotNullParameter(name, "p0");
            return LazyJavaClassMemberScope2.access$searchMethodsByNameWithoutBuiltinMagic((LazyJavaClassMemberScope2) this.receiver, name);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.h$b */
    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    public /* synthetic */ class b extends FunctionReference implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
        public b(LazyJavaClassMemberScope2 lazyJavaClassMemberScope2) {
            super(1, lazyJavaClassMemberScope2);
        }

        @Override // d0.z.d.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "searchMethodsInSupertypesWithoutBuiltinMagic";
        }

        @Override // d0.z.d.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinClass(LazyJavaClassMemberScope2.class);
        }

        @Override // d0.z.d.CallableReference
        public final String getSignature() {
            return "searchMethodsInSupertypesWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
        }

        @Override // kotlin.jvm.functions.Function1
        public final Collection<SimpleFunctionDescriptor> invoke(Name name) {
            Intrinsics3.checkNotNullParameter(name, "p0");
            return LazyJavaClassMemberScope2.access$searchMethodsInSupertypesWithoutBuiltinMagic((LazyJavaClassMemberScope2) this.receiver, name);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.h$c */
    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    public static final class c extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Collection<SimpleFunctionDescriptor> invoke(Name name) {
            Intrinsics3.checkNotNullParameter(name, "it");
            return LazyJavaClassMemberScope2.access$searchMethodsByNameWithoutBuiltinMagic(LazyJavaClassMemberScope2.this, name);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.h$d */
    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    public static final class d extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Collection<SimpleFunctionDescriptor> invoke(Name name) {
            Intrinsics3.checkNotNullParameter(name, "it");
            return LazyJavaClassMemberScope2.access$searchMethodsInSupertypesWithoutBuiltinMagic(LazyJavaClassMemberScope2.this, name);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.h$e */
    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    public static final class e extends Lambda implements Function0<List<? extends ClassConstructorDescriptor>> {
        public final /* synthetic */ context4 $c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(context4 context4Var) {
            super(0);
            this.$c = context4Var;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends ClassConstructorDescriptor> invoke() {
            Collection<d0.e0.p.d.m0.e.a.k0.k> constructors = LazyJavaClassMemberScope2.this.o.getConstructors();
            ArrayList arrayList = new ArrayList(constructors.size());
            Iterator<d0.e0.p.d.m0.e.a.k0.k> it = constructors.iterator();
            while (it.hasNext()) {
                arrayList.add(LazyJavaClassMemberScope2.access$resolveConstructor(LazyJavaClassMemberScope2.this, it.next()));
            }
            if (LazyJavaClassMemberScope2.this.o.isRecord()) {
                ClassConstructorDescriptor classConstructorDescriptorAccess$createDefaultRecordConstructor = LazyJavaClassMemberScope2.access$createDefaultRecordConstructor(LazyJavaClassMemberScope2.this);
                boolean z2 = false;
                String strComputeJvmDescriptor$default = methodSignatureMapping3.computeJvmDescriptor$default(classConstructorDescriptorAccess$createDefaultRecordConstructor, false, false, 2, null);
                if (!arrayList.isEmpty()) {
                    Iterator it2 = arrayList.iterator();
                    do {
                        if (!it2.hasNext()) {
                            z2 = true;
                            break;
                        }
                    } while (!Intrinsics3.areEqual(methodSignatureMapping3.computeJvmDescriptor$default((ClassConstructorDescriptor) it2.next(), false, false, 2, null), strComputeJvmDescriptor$default));
                } else {
                    z2 = true;
                    break;
                }
                if (z2) {
                    arrayList.add(classConstructorDescriptorAccess$createDefaultRecordConstructor);
                    ((JavaResolverCache.a) this.$c.getComponents().getJavaResolverCache()).recordConstructor(LazyJavaClassMemberScope2.this.o, classConstructorDescriptorAccess$createDefaultRecordConstructor);
                }
            }
            signatureEnhancement signatureEnhancement = this.$c.getComponents().getSignatureEnhancement();
            context4 context4Var = this.$c;
            LazyJavaClassMemberScope2 lazyJavaClassMemberScope2 = LazyJavaClassMemberScope2.this;
            boolean zIsEmpty = arrayList.isEmpty();
            List listListOfNotNull = arrayList;
            if (zIsEmpty) {
                listListOfNotNull = Collections2.listOfNotNull(LazyJavaClassMemberScope2.access$createDefaultConstructor(lazyJavaClassMemberScope2));
            }
            return _Collections.toList(signatureEnhancement.enhanceSignatures(context4Var, listListOfNotNull));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.h$f */
    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    public static final class f extends Lambda implements Function0<Map<Name, ? extends d0.e0.p.d.m0.e.a.k0.n>> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Name, ? extends d0.e0.p.d.m0.e.a.k0.n> invoke() {
            Collection<d0.e0.p.d.m0.e.a.k0.n> fields = LazyJavaClassMemberScope2.this.o.getFields();
            ArrayList arrayList = new ArrayList();
            for (Object obj : fields) {
                if (((d0.e0.p.d.m0.e.a.k0.n) obj).isEnumEntry()) {
                    arrayList.add(obj);
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(arrayList, 10)), 16));
            for (Object obj2 : arrayList) {
                linkedHashMap.put(((d0.e0.p.d.m0.e.a.k0.n) obj2).getName(), obj2);
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.h$g */
    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    public static final class g extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
        public final /* synthetic */ SimpleFunctionDescriptor $function;
        public final /* synthetic */ LazyJavaClassMemberScope2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(SimpleFunctionDescriptor simpleFunctionDescriptor, LazyJavaClassMemberScope2 lazyJavaClassMemberScope2) {
            super(1);
            this.$function = simpleFunctionDescriptor;
            this.this$0 = lazyJavaClassMemberScope2;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Collection<SimpleFunctionDescriptor> invoke(Name name) {
            Intrinsics3.checkNotNullParameter(name, "accessorName");
            return Intrinsics3.areEqual(this.$function.getName(), name) ? CollectionsJVM.listOf(this.$function) : _Collections.plus(LazyJavaClassMemberScope2.access$searchMethodsByNameWithoutBuiltinMagic(this.this$0, name), (Iterable) LazyJavaClassMemberScope2.access$searchMethodsInSupertypesWithoutBuiltinMagic(this.this$0, name));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.h$h */
    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    public static final class h extends Lambda implements Function0<Set<? extends Name>> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Set<? extends Name> invoke() {
            return _Collections.toSet(LazyJavaClassMemberScope2.this.o.getInnerClassNames());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.h$i */
    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    public static final class i extends Lambda implements Function1<Name, ClassDescriptorBase> {
        public final /* synthetic */ context4 $c;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.h$i$a */
        /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
        public static final class a extends Lambda implements Function0<Set<? extends Name>> {
            public final /* synthetic */ LazyJavaClassMemberScope2 this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(LazyJavaClassMemberScope2 lazyJavaClassMemberScope2) {
                super(0);
                this.this$0 = lazyJavaClassMemberScope2;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set<? extends Name> invoke() {
                return _Sets.plus((Set) this.this$0.getFunctionNames(), (Iterable) this.this$0.getVariableNames());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(context4 context4Var) {
            super(1);
            this.$c = context4Var;
        }

        @Override // kotlin.jvm.functions.Function1
        public final ClassDescriptorBase invoke(Name name) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            if (!((Set) LazyJavaClassMemberScope2.this.r.invoke()).contains(name)) {
                d0.e0.p.d.m0.e.a.k0.n nVar = (d0.e0.p.d.m0.e.a.k0.n) ((Map) LazyJavaClassMemberScope2.this.f3332s.invoke()).get(name);
                if (nVar == null) {
                    return null;
                }
                return EnumEntrySyntheticClassDescriptor.create(this.$c.getStorageManager(), LazyJavaClassMemberScope2.this.n, name, this.$c.getStorageManager().createLazyValue(new a(LazyJavaClassMemberScope2.this)), LazyJavaAnnotations2.resolveAnnotations(this.$c, nVar), this.$c.getComponents().getSourceElementFactory().source(nVar));
            }
            JavaClassFinder finder = this.$c.getComponents().getFinder();
            ClassId classId = DescriptorUtils2.getClassId(LazyJavaClassMemberScope2.this.n);
            Intrinsics3.checkNotNull(classId);
            ClassId classIdCreateNestedClassId = classId.createNestedClassId(name);
            Intrinsics3.checkNotNullExpressionValue(classIdCreateNestedClassId, "ownerDescriptor.classId!!.createNestedClassId(name)");
            d0.e0.p.d.m0.e.a.k0.g gVarFindClass = finder.findClass(new JavaClassFinder.a(classIdCreateNestedClassId, null, LazyJavaClassMemberScope2.this.o, 2, null));
            if (gVarFindClass == null) {
                return null;
            }
            context4 context4Var = this.$c;
            LazyJavaClassDescriptor lazyJavaClassDescriptor = new LazyJavaClassDescriptor(context4Var, LazyJavaClassMemberScope2.this.n, gVarFindClass, null, 8, null);
            context4Var.getComponents().getJavaClassesTracker().reportClass(lazyJavaClassDescriptor);
            return lazyJavaClassDescriptor;
        }
    }

    public /* synthetic */ LazyJavaClassMemberScope2(context4 context4Var, ClassDescriptor classDescriptor, d0.e0.p.d.m0.e.a.k0.g gVar, boolean z2, LazyJavaClassMemberScope2 lazyJavaClassMemberScope2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context4Var, classDescriptor, gVar, z2, (i2 & 16) != 0 ? null : lazyJavaClassMemberScope2);
    }

    public static final ClassConstructorDescriptor access$createDefaultConstructor(LazyJavaClassMemberScope2 lazyJavaClassMemberScope2) {
        List<ValueParameterDescriptor> listEmptyList;
        Tuples2 tuples2;
        boolean zIsAnnotationType = lazyJavaClassMemberScope2.o.isAnnotationType();
        if ((lazyJavaClassMemberScope2.o.isInterface() || !lazyJavaClassMemberScope2.o.hasDefaultConstructor()) && !zIsAnnotationType) {
            return null;
        }
        ClassDescriptor classDescriptor = lazyJavaClassMemberScope2.n;
        JavaClassConstructorDescriptor javaClassConstructorDescriptorCreateJavaConstructor = JavaClassConstructorDescriptor.createJavaConstructor(classDescriptor, Annotations4.f.getEMPTY(), true, lazyJavaClassMemberScope2.c.getComponents().getSourceElementFactory().source(lazyJavaClassMemberScope2.o));
        Intrinsics3.checkNotNullExpressionValue(javaClassConstructorDescriptorCreateJavaConstructor, "createJavaConstructor(\n            classDescriptor, Annotations.EMPTY, /* isPrimary = */ true, c.components.sourceElementFactory.source(jClass)\n        )");
        if (zIsAnnotationType) {
            Collection<d0.e0.p.d.m0.e.a.k0.r> methods = lazyJavaClassMemberScope2.o.getMethods();
            listEmptyList = new ArrayList<>(methods.size());
            JavaTypeResolver attributes$default = JavaTypeResolver5.toAttributes$default(TypeUsage.COMMON, true, null, 2, null);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : methods) {
                if (Intrinsics3.areEqual(((d0.e0.p.d.m0.e.a.k0.r) obj).getName(), JvmAnnotationNames.f3305b)) {
                    arrayList.add(obj);
                } else {
                    arrayList2.add(obj);
                }
            }
            Tuples2 tuples3 = new Tuples2(arrayList, arrayList2);
            List list = (List) tuples3.component1();
            List<d0.e0.p.d.m0.e.a.k0.r> list2 = (List) tuples3.component2();
            list.size();
            d0.e0.p.d.m0.e.a.k0.r rVar = (d0.e0.p.d.m0.e.a.k0.r) _Collections.firstOrNull(list);
            if (rVar != null) {
                javaTypes5 returnType = rVar.getReturnType();
                if (returnType instanceof javaTypes2) {
                    javaTypes2 javatypes2 = (javaTypes2) returnType;
                    tuples2 = new Tuples2(lazyJavaClassMemberScope2.c.getTypeResolver().transformArrayType(javatypes2, attributes$default, true), lazyJavaClassMemberScope2.c.getTypeResolver().transformJavaType(javatypes2.getComponentType(), attributes$default));
                } else {
                    tuples2 = new Tuples2(lazyJavaClassMemberScope2.c.getTypeResolver().transformJavaType(returnType, attributes$default), null);
                }
                lazyJavaClassMemberScope2.o(listEmptyList, javaClassConstructorDescriptorCreateJavaConstructor, 0, rVar, (KotlinType) tuples2.component1(), (KotlinType) tuples2.component2());
            }
            int i2 = rVar != null ? 1 : 0;
            int i3 = 0;
            for (d0.e0.p.d.m0.e.a.k0.r rVar2 : list2) {
                lazyJavaClassMemberScope2.o(listEmptyList, javaClassConstructorDescriptorCreateJavaConstructor, i3 + i2, rVar2, lazyJavaClassMemberScope2.c.getTypeResolver().transformJavaType(rVar2.getReturnType(), attributes$default), null);
                i3++;
            }
        } else {
            listEmptyList = Collections.emptyList();
        }
        javaClassConstructorDescriptorCreateJavaConstructor.setHasSynthesizedParameterNames(false);
        javaClassConstructorDescriptorCreateJavaConstructor.initialize(listEmptyList, lazyJavaClassMemberScope2.B(classDescriptor));
        javaClassConstructorDescriptorCreateJavaConstructor.setHasStableParameterNames(true);
        javaClassConstructorDescriptorCreateJavaConstructor.setReturnType(classDescriptor.getDefaultType());
        ((JavaResolverCache.a) lazyJavaClassMemberScope2.c.getComponents().getJavaResolverCache()).recordConstructor(lazyJavaClassMemberScope2.o, javaClassConstructorDescriptorCreateJavaConstructor);
        return javaClassConstructorDescriptorCreateJavaConstructor;
    }

    public static final ClassConstructorDescriptor access$createDefaultRecordConstructor(LazyJavaClassMemberScope2 lazyJavaClassMemberScope2) {
        ClassDescriptor classDescriptor = lazyJavaClassMemberScope2.n;
        JavaClassConstructorDescriptor javaClassConstructorDescriptorCreateJavaConstructor = JavaClassConstructorDescriptor.createJavaConstructor(classDescriptor, Annotations4.f.getEMPTY(), true, lazyJavaClassMemberScope2.c.getComponents().getSourceElementFactory().source(lazyJavaClassMemberScope2.o));
        Intrinsics3.checkNotNullExpressionValue(javaClassConstructorDescriptorCreateJavaConstructor, "createJavaConstructor(\n            classDescriptor, Annotations.EMPTY, /* isPrimary = */ true, c.components.sourceElementFactory.source(jClass)\n        )");
        Collection<w> recordComponents = lazyJavaClassMemberScope2.o.getRecordComponents();
        ArrayList arrayList = new ArrayList(recordComponents.size());
        KotlinType kotlinType = null;
        JavaTypeResolver attributes$default = JavaTypeResolver5.toAttributes$default(TypeUsage.COMMON, false, null, 2, null);
        int i2 = 0;
        for (w wVar : recordComponents) {
            int i3 = i2 + 1;
            KotlinType kotlinTypeTransformJavaType = lazyJavaClassMemberScope2.c.getTypeResolver().transformJavaType(wVar.getType(), attributes$default);
            arrayList.add(new ValueParameterDescriptorImpl(javaClassConstructorDescriptorCreateJavaConstructor, null, i2, Annotations4.f.getEMPTY(), wVar.getName(), kotlinTypeTransformJavaType, false, false, false, wVar.isVararg() ? lazyJavaClassMemberScope2.c.getComponents().getModule().getBuiltIns().getArrayElementType(kotlinTypeTransformJavaType) : kotlinType, lazyJavaClassMemberScope2.c.getComponents().getSourceElementFactory().source(wVar)));
            i2 = i3;
            attributes$default = attributes$default;
            kotlinType = kotlinType;
        }
        javaClassConstructorDescriptorCreateJavaConstructor.setHasSynthesizedParameterNames(false);
        javaClassConstructorDescriptorCreateJavaConstructor.initialize(arrayList, lazyJavaClassMemberScope2.B(classDescriptor));
        javaClassConstructorDescriptorCreateJavaConstructor.setHasStableParameterNames(false);
        javaClassConstructorDescriptorCreateJavaConstructor.setReturnType(classDescriptor.getDefaultType());
        return javaClassConstructorDescriptorCreateJavaConstructor;
    }

    public static final JavaClassConstructorDescriptor access$resolveConstructor(LazyJavaClassMemberScope2 lazyJavaClassMemberScope2, d0.e0.p.d.m0.e.a.k0.k kVar) {
        ClassDescriptor classDescriptor = lazyJavaClassMemberScope2.n;
        JavaClassConstructorDescriptor javaClassConstructorDescriptorCreateJavaConstructor = JavaClassConstructorDescriptor.createJavaConstructor(classDescriptor, LazyJavaAnnotations2.resolveAnnotations(lazyJavaClassMemberScope2.c, kVar), false, lazyJavaClassMemberScope2.c.getComponents().getSourceElementFactory().source(kVar));
        Intrinsics3.checkNotNullExpressionValue(javaClassConstructorDescriptorCreateJavaConstructor, "createJavaConstructor(\n            classDescriptor,\n            c.resolveAnnotations(constructor), /* isPrimary = */\n            false,\n            c.components.sourceElementFactory.source(constructor)\n        )");
        context4 context4VarChildForMethod = context.childForMethod(lazyJavaClassMemberScope2.c, javaClassConstructorDescriptorCreateJavaConstructor, kVar, classDescriptor.getDeclaredTypeParameters().size());
        LazyJavaScope.b bVarN = lazyJavaClassMemberScope2.n(context4VarChildForMethod, javaClassConstructorDescriptorCreateJavaConstructor, kVar.getValueParameters());
        List<TypeParameterDescriptor> declaredTypeParameters = classDescriptor.getDeclaredTypeParameters();
        Intrinsics3.checkNotNullExpressionValue(declaredTypeParameters, "classDescriptor.declaredTypeParameters");
        List<y> typeParameters = kVar.getTypeParameters();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(typeParameters, 10));
        Iterator<T> it = typeParameters.iterator();
        while (it.hasNext()) {
            TypeParameterDescriptor typeParameterDescriptorResolveTypeParameter = context4VarChildForMethod.getTypeParameterResolver().resolveTypeParameter((y) it.next());
            Intrinsics3.checkNotNull(typeParameterDescriptorResolveTypeParameter);
            arrayList.add(typeParameterDescriptorResolveTypeParameter);
        }
        javaClassConstructorDescriptorCreateJavaConstructor.initialize(bVarN.getDescriptors(), utils2.toDescriptorVisibility(kVar.getVisibility()), _Collections.plus((Collection) declaredTypeParameters, (Iterable) arrayList));
        javaClassConstructorDescriptorCreateJavaConstructor.setHasStableParameterNames(false);
        javaClassConstructorDescriptorCreateJavaConstructor.setHasSynthesizedParameterNames(bVarN.getHasSynthesizedNames());
        javaClassConstructorDescriptorCreateJavaConstructor.setReturnType(classDescriptor.getDefaultType());
        ((JavaResolverCache.a) context4VarChildForMethod.getComponents().getJavaResolverCache()).recordConstructor(kVar, javaClassConstructorDescriptorCreateJavaConstructor);
        return javaClassConstructorDescriptorCreateJavaConstructor;
    }

    public static final Collection access$searchMethodsByNameWithoutBuiltinMagic(LazyJavaClassMemberScope2 lazyJavaClassMemberScope2, Name name) {
        Collection<d0.e0.p.d.m0.e.a.k0.r> collectionFindMethodsByName = lazyJavaClassMemberScope2.f.invoke().findMethodsByName(name);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(collectionFindMethodsByName, 10));
        Iterator<T> it = collectionFindMethodsByName.iterator();
        while (it.hasNext()) {
            arrayList.add(lazyJavaClassMemberScope2.m((d0.e0.p.d.m0.e.a.k0.r) it.next()));
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002b  */
    public static final Collection access$searchMethodsInSupertypesWithoutBuiltinMagic(LazyJavaClassMemberScope2 lazyJavaClassMemberScope2, Name name) {
        boolean z2;
        Set<SimpleFunctionDescriptor> setC = lazyJavaClassMemberScope2.C(name);
        ArrayList arrayList = new ArrayList();
        for (Object obj : setC) {
            SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) obj;
            if (specialBuiltinMembers.doesOverrideBuiltinWithDifferentJvmName(simpleFunctionDescriptor)) {
                z2 = true;
            } else {
                specialBuiltinMembers3 specialbuiltinmembers3 = specialBuiltinMembers3.m;
                if (specialBuiltinMembers3.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(simpleFunctionDescriptor) != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            if (!z2) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final SimpleFunctionDescriptor A(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        KotlinType returnType;
        JvmAbi jvmAbi = JvmAbi.a;
        String strAsString = propertyDescriptor.getName().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "name.asString()");
        Name nameIdentifier = Name.identifier(JvmAbi.setterName(strAsString));
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(JvmAbi.setterName(name.asString()))");
        Iterator<T> it = function1.invoke(nameIdentifier).iterator();
        do {
            simpleFunctionDescriptor = null;
            if (!it.hasNext()) {
                break;
            }
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) it.next();
            if (simpleFunctionDescriptor2.getValueParameters().size() == 1 && (returnType = simpleFunctionDescriptor2.getReturnType()) != null && KotlinBuiltIns.isUnit(returnType)) {
                KotlinTypeChecker kotlinTypeChecker = KotlinTypeChecker.a;
                List<ValueParameterDescriptor> valueParameters = simpleFunctionDescriptor2.getValueParameters();
                Intrinsics3.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
                if (kotlinTypeChecker.equalTypes(((ValueParameterDescriptor) _Collections.single((List) valueParameters)).getType(), propertyDescriptor.getType())) {
                    simpleFunctionDescriptor = simpleFunctionDescriptor2;
                }
            }
        } while (simpleFunctionDescriptor == null);
        return simpleFunctionDescriptor;
    }

    public final DescriptorVisibility2 B(ClassDescriptor classDescriptor) {
        DescriptorVisibility2 visibility = classDescriptor.getVisibility();
        Intrinsics3.checkNotNullExpressionValue(visibility, "classDescriptor.visibility");
        if (!Intrinsics3.areEqual(visibility, JavaDescriptorVisibilities.f3359b)) {
            return visibility;
        }
        DescriptorVisibility2 descriptorVisibility2 = JavaDescriptorVisibilities.c;
        Intrinsics3.checkNotNullExpressionValue(descriptorVisibility2, "PROTECTED_AND_PACKAGE");
        return descriptorVisibility2;
    }

    public final Set<SimpleFunctionDescriptor> C(Name name) {
        Collection<KotlinType> collectionS = s();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = collectionS.iterator();
        while (it.hasNext()) {
            MutableCollections.addAll(linkedHashSet, ((KotlinType) it.next()).getMemberScope().getContributedFunctions(name, LookupLocation3.WHEN_GET_SUPER_MEMBERS));
        }
        return linkedHashSet;
    }

    public final Set<PropertyDescriptor> D(Name name) {
        Collection<KotlinType> collectionS = s();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionS.iterator();
        while (it.hasNext()) {
            Collection<? extends PropertyDescriptor> contributedVariables = ((KotlinType) it.next()).getMemberScope().getContributedVariables(name, LookupLocation3.WHEN_GET_SUPER_MEMBERS);
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(contributedVariables, 10));
            Iterator<T> it2 = contributedVariables.iterator();
            while (it2.hasNext()) {
                arrayList2.add((PropertyDescriptor) it2.next());
            }
            MutableCollections.addAll(arrayList, arrayList2);
        }
        return _Collections.toSet(arrayList);
    }

    public final boolean E(SimpleFunctionDescriptor simpleFunctionDescriptor, FunctionDescriptor functionDescriptor) {
        String strComputeJvmDescriptor$default = methodSignatureMapping3.computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 2, null);
        FunctionDescriptor original = functionDescriptor.getOriginal();
        Intrinsics3.checkNotNullExpressionValue(original, "builtinWithErasedParameters.original");
        return Intrinsics3.areEqual(strComputeJvmDescriptor$default, methodSignatureMapping3.computeJvmDescriptor$default(original, false, false, 2, null)) && !w(simpleFunctionDescriptor, functionDescriptor);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:25:0x0071  */
    /* JADX WARN: Code duplicated, block: B:60:0x010a  */
    /* JADX WARN: Code duplicated, block: B:83:0x016d  */
    public final boolean F(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        Name name = simpleFunctionDescriptor.getName();
        Intrinsics3.checkNotNullExpressionValue(name, "function.name");
        List<Name> propertyNamesCandidatesByAccessorName = propertiesConventionUtil.getPropertyNamesCandidatesByAccessorName(name);
        if (!(propertyNamesCandidatesByAccessorName instanceof Collection) || !propertyNamesCandidatesByAccessorName.isEmpty()) {
            Iterator<T> it = propertyNamesCandidatesByAccessorName.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z4 = false;
                    break;
                }
                Set<PropertyDescriptor> setD = D((Name) it.next());
                if (!(setD instanceof Collection) || !setD.isEmpty()) {
                    Iterator<T> it2 = setD.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z3 = false;
                            break;
                        }
                        PropertyDescriptor propertyDescriptor = (PropertyDescriptor) it2.next();
                        if (v(propertyDescriptor, new g(simpleFunctionDescriptor, this))) {
                            if (!propertyDescriptor.isVar()) {
                                JvmAbi jvmAbi = JvmAbi.a;
                                String strAsString = simpleFunctionDescriptor.getName().asString();
                                Intrinsics3.checkNotNullExpressionValue(strAsString, "function.name.asString()");
                                if (JvmAbi.isSetterName(strAsString)) {
                                    z2 = false;
                                }
                            }
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
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
            return false;
        }
        specialBuiltinMembers2 specialbuiltinmembers2 = specialBuiltinMembers2.m;
        Name name2 = simpleFunctionDescriptor.getName();
        Intrinsics3.checkNotNullExpressionValue(name2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        List<Name> builtinFunctionNamesByJvmName = specialbuiltinmembers2.getBuiltinFunctionNamesByJvmName(name2);
        if (!(builtinFunctionNamesByJvmName instanceof Collection) || !builtinFunctionNamesByJvmName.isEmpty()) {
            Iterator<T> it3 = builtinFunctionNamesByJvmName.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    z6 = false;
                    break;
                }
                Name name3 = (Name) it3.next();
                Set<SimpleFunctionDescriptor> setC = C(name3);
                ArrayList arrayList = new ArrayList();
                for (Object obj : setC) {
                    if (specialBuiltinMembers.doesOverrideBuiltinWithDifferentJvmName((SimpleFunctionDescriptor) obj)) {
                        arrayList.add(obj);
                    }
                }
                if (arrayList.isEmpty()) {
                    z5 = false;
                    break;
                }
                FunctionDescriptor.a<? extends SimpleFunctionDescriptor> aVarNewCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
                aVarNewCopyBuilder.setName(name3);
                aVarNewCopyBuilder.setSignatureChange();
                aVarNewCopyBuilder.setPreserveSourceElement();
                FunctionDescriptor functionDescriptor = (SimpleFunctionDescriptor) aVarNewCopyBuilder.build();
                Intrinsics3.checkNotNull(functionDescriptor);
                if (arrayList.isEmpty()) {
                    z5 = false;
                    break;
                    break;
                }
                Iterator it4 = arrayList.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        z5 = false;
                        break;
                        break;
                    }
                    if (x((SimpleFunctionDescriptor) it4.next(), functionDescriptor)) {
                        z5 = true;
                        break;
                    }
                }
                if (z5) {
                    z6 = true;
                    break;
                }
            }
        } else {
            z6 = false;
            break;
        }
        if (!z6) {
            specialBuiltinMembers3 specialbuiltinmembers3 = specialBuiltinMembers3.m;
            Name name4 = simpleFunctionDescriptor.getName();
            Intrinsics3.checkNotNullExpressionValue(name4, ModelAuditLogEntry.CHANGE_KEY_NAME);
            if (!specialbuiltinmembers3.getSameAsBuiltinMethodWithErasedValueParameters(name4)) {
                z7 = false;
                break;
            }
            Name name5 = simpleFunctionDescriptor.getName();
            Intrinsics3.checkNotNullExpressionValue(name5, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Set<SimpleFunctionDescriptor> setC2 = C(name5);
            ArrayList arrayList2 = new ArrayList();
            for (SimpleFunctionDescriptor simpleFunctionDescriptor2 : setC2) {
                specialBuiltinMembers3 specialbuiltinmembers4 = specialBuiltinMembers3.m;
                FunctionDescriptor overriddenBuiltinFunctionWithErasedValueParametersInJava = specialBuiltinMembers3.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(simpleFunctionDescriptor2);
                if (overriddenBuiltinFunctionWithErasedValueParametersInJava != null) {
                    arrayList2.add(overriddenBuiltinFunctionWithErasedValueParametersInJava);
                }
            }
            if (arrayList2.isEmpty()) {
                z7 = false;
                break;
            }
            Iterator it5 = arrayList2.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    z7 = false;
                    break;
                }
                if (E(simpleFunctionDescriptor, (FunctionDescriptor) it5.next())) {
                    z7 = true;
                    break;
                }
            }
            if (!z7) {
                SimpleFunctionDescriptor simpleFunctionDescriptorU = u(simpleFunctionDescriptor);
                if (simpleFunctionDescriptorU == null) {
                    z8 = false;
                } else {
                    Name name6 = simpleFunctionDescriptor.getName();
                    Intrinsics3.checkNotNullExpressionValue(name6, ModelAuditLogEntry.CHANGE_KEY_NAME);
                    Set<SimpleFunctionDescriptor> setC3 = C(name6);
                    if (setC3.isEmpty()) {
                        z8 = false;
                    } else {
                        for (SimpleFunctionDescriptor simpleFunctionDescriptor3 : setC3) {
                            if (simpleFunctionDescriptor3.isSuspend() && w(simpleFunctionDescriptorU, simpleFunctionDescriptor3)) {
                                z8 = true;
                            }
                        }
                        z8 = false;
                    }
                }
                if (!z8) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope
    public Set<Name> a(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        return _Sets.plus((Set) this.r.invoke(), (Iterable) this.f3332s.invoke().keySet());
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope
    public Set b(MemberScope2 memberScope2, Function1 function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        Collection<KotlinType> supertypes = this.n.getTypeConstructor().getSupertypes();
        Intrinsics3.checkNotNullExpressionValue(supertypes, "ownerDescriptor.typeConstructor.supertypes");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = supertypes.iterator();
        while (it.hasNext()) {
            MutableCollections.addAll(linkedHashSet, ((KotlinType) it.next()).getMemberScope().getFunctionNames());
        }
        linkedHashSet.addAll(this.f.invoke().getMethodNames());
        linkedHashSet.addAll(this.f.invoke().getRecordComponentNames());
        linkedHashSet.addAll(a(memberScope2, function1));
        return linkedHashSet;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope
    public void c(Collection<SimpleFunctionDescriptor> collection, Name name) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(collection, "result");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (!this.o.isRecord() || this.f.invoke().findRecordComponentByName(name) == null) {
            return;
        }
        if (!collection.isEmpty()) {
            Iterator it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = true;
                    break;
                } else if (((SimpleFunctionDescriptor) it.next()).getValueParameters().isEmpty()) {
                    z2 = false;
                    break;
                }
            }
        } else {
            z2 = true;
            break;
        }
        if (z2) {
            w wVarFindRecordComponentByName = this.f.invoke().findRecordComponentByName(name);
            Intrinsics3.checkNotNull(wVarFindRecordComponentByName);
            JavaMethodDescriptor javaMethodDescriptorCreateJavaMethod = JavaMethodDescriptor.createJavaMethod(this.n, LazyJavaAnnotations2.resolveAnnotations(this.c, wVarFindRecordComponentByName), wVarFindRecordComponentByName.getName(), this.c.getComponents().getSourceElementFactory().source(wVarFindRecordComponentByName), true);
            Intrinsics3.checkNotNullExpressionValue(javaMethodDescriptorCreateJavaMethod, "createJavaMethod(\n            ownerDescriptor, annotations, recordComponent.name, c.components.sourceElementFactory.source(recordComponent), true\n        )");
            javaMethodDescriptorCreateJavaMethod.initialize(null, i(), Collections2.emptyList(), Collections2.emptyList(), this.c.getTypeResolver().transformJavaType(wVarFindRecordComponentByName.getType(), JavaTypeResolver5.toAttributes$default(TypeUsage.COMMON, false, null, 2, null)), Modality.j.convertFromFlags(false, false, true), DescriptorVisibilities.e, null);
            javaMethodDescriptorCreateJavaMethod.setParameterNamesStatus(false, false);
            ((JavaResolverCache.a) this.c.getComponents().getJavaResolverCache()).recordMethod(wVarFindRecordComponentByName, javaMethodDescriptorCreateJavaMethod);
            collection.add(javaMethodDescriptorCreateJavaMethod);
        }
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope
    public DeclaredMemberIndex2 d() {
        return new DeclaredMemberIndex(this.o, LazyJavaClassMemberScope.j);
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope
    public void f(Collection<SimpleFunctionDescriptor> collection, Name name) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(collection, "result");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Set<SimpleFunctionDescriptor> setC = C(name);
        if (!specialBuiltinMembers2.m.getSameAsRenamedInJvmBuiltin(name) && !specialBuiltinMembers3.m.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            if (setC.isEmpty()) {
                z2 = true;
                break;
            }
            Iterator<T> it = setC.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((FunctionDescriptor) it.next()).isSuspend()) {
                        z2 = false;
                        break;
                    }
                } else {
                    z2 = true;
                    break;
                }
            }
            if (z2) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : setC) {
                    if (F((SimpleFunctionDescriptor) obj)) {
                        arrayList.add(obj);
                    }
                }
                p(collection, name, arrayList, false);
                return;
            }
        }
        Collection<SimpleFunctionDescriptor> collectionCreate = SmartSet.j.create();
        Collection<? extends SimpleFunctionDescriptor> collectionResolveOverridesForNonStaticMembers = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name, setC, Collections2.emptyList(), this.n, ErrorReporter.a, this.c.getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics3.checkNotNullExpressionValue(collectionResolveOverridesForNonStaticMembers, "resolveOverridesForNonStaticMembers(\n            name, functionsFromSupertypes, emptyList(), ownerDescriptor, ErrorReporter.DO_NOTHING,\n            c.components.kotlinTypeChecker.overridingUtil\n        )");
        q(name, collection, collectionResolveOverridesForNonStaticMembers, collection, new a(this));
        q(name, collection, collectionResolveOverridesForNonStaticMembers, collectionCreate, new b(this));
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : setC) {
            if (F((SimpleFunctionDescriptor) obj2)) {
                arrayList2.add(obj2);
            }
        }
        p(collection, name, _Collections.plus((Collection) arrayList2, (Iterable) collectionCreate), true);
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope
    public void g(Name name, Collection<PropertyDescriptor> collection) {
        d0.e0.p.d.m0.e.a.k0.r rVar;
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(collection, "result");
        if (this.o.isAnnotationType() && (rVar = (d0.e0.p.d.m0.e.a.k0.r) _Collections.singleOrNull(this.f.invoke().findMethodsByName(name))) != null) {
            JavaPropertyDescriptor javaPropertyDescriptorCreate = JavaPropertyDescriptor.create(this.n, LazyJavaAnnotations2.resolveAnnotations(this.c, rVar), Modality.FINAL, utils2.toDescriptorVisibility(rVar.getVisibility()), false, rVar.getName(), this.c.getComponents().getSourceElementFactory().source(rVar), false);
            Intrinsics3.checkNotNullExpressionValue(javaPropertyDescriptorCreate, "create(\n            ownerDescriptor, annotations, modality, method.visibility.toDescriptorVisibility(),\n            /* isVar = */ false, method.name, c.components.sourceElementFactory.source(method),\n            /* isStaticFinal = */ false\n        )");
            PropertyGetterDescriptorImpl propertyGetterDescriptorImplCreateDefaultGetter = DescriptorFactory.createDefaultGetter(javaPropertyDescriptorCreate, Annotations4.f.getEMPTY());
            Intrinsics3.checkNotNullExpressionValue(propertyGetterDescriptorImplCreateDefaultGetter, "createDefaultGetter(propertyDescriptor, Annotations.EMPTY)");
            javaPropertyDescriptorCreate.initialize(propertyGetterDescriptorImplCreateDefaultGetter, null);
            KotlinType kotlinTypeE = e(rVar, context.childForMethod$default(this.c, javaPropertyDescriptorCreate, rVar, 0, 4, null));
            javaPropertyDescriptorCreate.setType(kotlinTypeE, Collections2.emptyList(), i(), null);
            propertyGetterDescriptorImplCreateDefaultGetter.initialize(kotlinTypeE);
            collection.add(javaPropertyDescriptorCreate);
        }
        Set<PropertyDescriptor> setD = D(name);
        if (setD.isEmpty()) {
            return;
        }
        SmartSet.b bVar = SmartSet.j;
        SmartSet smartSetCreate = bVar.create();
        SmartSet smartSetCreate2 = bVar.create();
        r(setD, collection, smartSetCreate, new c());
        r(_Sets.minus((Set) setD, (Iterable) smartSetCreate), smartSetCreate2, null, new d());
        Collection<? extends PropertyDescriptor> collectionResolveOverridesForNonStaticMembers = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name, _Sets.plus((Set) setD, (Iterable) smartSetCreate2), collection, this.n, this.c.getComponents().getErrorReporter(), this.c.getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics3.checkNotNullExpressionValue(collectionResolveOverridesForNonStaticMembers, "resolveOverridesForNonStaticMembers(\n                name,\n                propertiesFromSupertypes + propertiesOverridesFromSuperTypes,\n                result,\n                ownerDescriptor,\n                c.components.errorReporter,\n                c.components.kotlinTypeChecker.overridingUtil\n            )");
        collection.addAll(collectionResolveOverridesForNonStaticMembers);
    }

    public final storage5<List<ClassConstructorDescriptor>> getConstructors$descriptors_jvm() {
        return this.q;
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.ResolutionScope
    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation2 lookupLocation2) {
        storage4<Name, ClassDescriptorBase> storage4Var;
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        recordLookup(name, lookupLocation2);
        LazyJavaClassMemberScope2 lazyJavaClassMemberScope2 = (LazyJavaClassMemberScope2) this.d;
        ClassDescriptorBase classDescriptorBaseInvoke = null;
        if (lazyJavaClassMemberScope2 != null && (storage4Var = lazyJavaClassMemberScope2.t) != null) {
            classDescriptorBaseInvoke = storage4Var.invoke(name);
        }
        return classDescriptorBaseInvoke == null ? this.t.invoke(name) : classDescriptorBaseInvoke;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope, d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        recordLookup(name, lookupLocation2);
        return super.getContributedFunctions(name, lookupLocation2);
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope, d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        recordLookup(name, lookupLocation2);
        return super.getContributedVariables(name, lookupLocation2);
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope
    public Set<Name> h(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        if (this.o.isAnnotationType()) {
            return getFunctionNames();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.f.invoke().getFieldNames());
        Collection<KotlinType> supertypes = this.n.getTypeConstructor().getSupertypes();
        Intrinsics3.checkNotNullExpressionValue(supertypes, "ownerDescriptor.typeConstructor.supertypes");
        Iterator<T> it = supertypes.iterator();
        while (it.hasNext()) {
            MutableCollections.addAll(linkedHashSet, ((KotlinType) it.next()).getMemberScope().getVariableNames());
        }
        return linkedHashSet;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope
    public ReceiverParameterDescriptor i() {
        return DescriptorUtils.getDispatchReceiverParameterIfNeeded(this.n);
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope
    public DeclarationDescriptor j() {
        return this.n;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope
    public boolean k(JavaMethodDescriptor javaMethodDescriptor) {
        Intrinsics3.checkNotNullParameter(javaMethodDescriptor, "<this>");
        if (this.o.isAnnotationType()) {
            return false;
        }
        return F(javaMethodDescriptor);
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope
    public LazyJavaScope.a l(d0.e0.p.d.m0.e.a.k0.r rVar, List<? extends TypeParameterDescriptor> list, KotlinType kotlinType, List<? extends ValueParameterDescriptor> list2) {
        Intrinsics3.checkNotNullParameter(rVar, "method");
        Intrinsics3.checkNotNullParameter(list, "methodTypeParameters");
        Intrinsics3.checkNotNullParameter(kotlinType, "returnType");
        Intrinsics3.checkNotNullParameter(list2, "valueParameters");
        SignaturePropagator.b bVarResolvePropagatedSignature = ((SignaturePropagator.a) this.c.getComponents().getSignaturePropagator()).resolvePropagatedSignature(rVar, this.n, kotlinType, null, list2, list);
        Intrinsics3.checkNotNullExpressionValue(bVarResolvePropagatedSignature, "c.components.signaturePropagator.resolvePropagatedSignature(\n            method, ownerDescriptor, returnType, null, valueParameters, methodTypeParameters\n        )");
        KotlinType returnType = bVarResolvePropagatedSignature.getReturnType();
        Intrinsics3.checkNotNullExpressionValue(returnType, "propagated.returnType");
        KotlinType receiverType = bVarResolvePropagatedSignature.getReceiverType();
        List<ValueParameterDescriptor> valueParameters = bVarResolvePropagatedSignature.getValueParameters();
        Intrinsics3.checkNotNullExpressionValue(valueParameters, "propagated.valueParameters");
        List<TypeParameterDescriptor> typeParameters = bVarResolvePropagatedSignature.getTypeParameters();
        Intrinsics3.checkNotNullExpressionValue(typeParameters, "propagated.typeParameters");
        boolean zHasStableParameterNames = bVarResolvePropagatedSignature.hasStableParameterNames();
        List<String> errors = bVarResolvePropagatedSignature.getErrors();
        Intrinsics3.checkNotNullExpressionValue(errors, "propagated.errors");
        return new LazyJavaScope.a(returnType, receiverType, valueParameters, typeParameters, zHasStableParameterNames, errors);
    }

    public final void o(List<ValueParameterDescriptor> list, ConstructorDescriptor constructorDescriptor, int i2, d0.e0.p.d.m0.e.a.k0.r rVar, KotlinType kotlinType, KotlinType kotlinType2) {
        Annotations4 empty = Annotations4.f.getEMPTY();
        Name name = rVar.getName();
        KotlinType kotlinTypeMakeNotNullable = TypeUtils.makeNotNullable(kotlinType);
        Intrinsics3.checkNotNullExpressionValue(kotlinTypeMakeNotNullable, "makeNotNullable(returnType)");
        list.add(new ValueParameterDescriptorImpl(constructorDescriptor, null, i2, empty, name, kotlinTypeMakeNotNullable, rVar.getHasAnnotationParameterDefaultValue(), false, false, kotlinType2 == null ? null : TypeUtils.makeNotNullable(kotlinType2), this.c.getComponents().getSourceElementFactory().source(rVar)));
    }

    public final void p(Collection<SimpleFunctionDescriptor> collection, Name name, Collection<? extends SimpleFunctionDescriptor> collection2, boolean z2) {
        Collection<? extends SimpleFunctionDescriptor> collectionResolveOverridesForNonStaticMembers = DescriptorResolverUtils.resolveOverridesForNonStaticMembers(name, collection2, collection, this.n, this.c.getComponents().getErrorReporter(), this.c.getComponents().getKotlinTypeChecker().getOverridingUtil());
        Intrinsics3.checkNotNullExpressionValue(collectionResolveOverridesForNonStaticMembers, "resolveOverridesForNonStaticMembers(\n            name, functionsFromSupertypes, result, ownerDescriptor, c.components.errorReporter,\n            c.components.kotlinTypeChecker.overridingUtil\n        )");
        if (!z2) {
            collection.addAll(collectionResolveOverridesForNonStaticMembers);
            return;
        }
        List listPlus = _Collections.plus((Collection) collection, (Iterable) collectionResolveOverridesForNonStaticMembers);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(collectionResolveOverridesForNonStaticMembers, 10));
        for (SimpleFunctionDescriptor simpleFunctionDescriptorT : collectionResolveOverridesForNonStaticMembers) {
            SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) specialBuiltinMembers.getOverriddenSpecialBuiltin(simpleFunctionDescriptorT);
            if (simpleFunctionDescriptor == null) {
                Intrinsics3.checkNotNullExpressionValue(simpleFunctionDescriptorT, "resolvedOverride");
            } else {
                Intrinsics3.checkNotNullExpressionValue(simpleFunctionDescriptorT, "resolvedOverride");
                simpleFunctionDescriptorT = t(simpleFunctionDescriptorT, simpleFunctionDescriptor, listPlus);
            }
            arrayList.add(simpleFunctionDescriptorT);
        }
        collection.addAll(arrayList);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x010f  */
    public final void q(Name name, Collection<? extends SimpleFunctionDescriptor> collection, Collection<? extends SimpleFunctionDescriptor> collection2, Collection<SimpleFunctionDescriptor> collection3, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptorT;
        SimpleFunctionDescriptor simpleFunctionDescriptorT2;
        SimpleFunctionDescriptor simpleFunctionDescriptorU;
        Object next;
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        for (SimpleFunctionDescriptor simpleFunctionDescriptor2 : collection2) {
            SimpleFunctionDescriptor simpleFunctionDescriptor3 = (SimpleFunctionDescriptor) specialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName(simpleFunctionDescriptor2);
            if (simpleFunctionDescriptor3 == null) {
                simpleFunctionDescriptorT = null;
            } else {
                String jvmMethodNameIfSpecial = specialBuiltinMembers.getJvmMethodNameIfSpecial(simpleFunctionDescriptor3);
                Intrinsics3.checkNotNull(jvmMethodNameIfSpecial);
                Name nameIdentifier = Name.identifier(jvmMethodNameIfSpecial);
                Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(nameInJava)");
                Iterator<? extends SimpleFunctionDescriptor> it = function1.invoke(nameIdentifier).iterator();
                while (true) {
                    if (it.hasNext()) {
                        FunctionDescriptor.a<? extends SimpleFunctionDescriptor> aVarNewCopyBuilder = it.next().newCopyBuilder();
                        aVarNewCopyBuilder.setName(name);
                        aVarNewCopyBuilder.setSignatureChange();
                        aVarNewCopyBuilder.setPreserveSourceElement();
                        SimpleFunctionDescriptor simpleFunctionDescriptor4 = (SimpleFunctionDescriptor) aVarNewCopyBuilder.build();
                        Intrinsics3.checkNotNull(simpleFunctionDescriptor4);
                        if (x(simpleFunctionDescriptor3, simpleFunctionDescriptor4)) {
                            simpleFunctionDescriptorT = t(simpleFunctionDescriptor4, simpleFunctionDescriptor3, collection);
                        }
                    } else {
                        simpleFunctionDescriptorT = null;
                    }
                }
            }
            collections.addIfNotNull(collection3, simpleFunctionDescriptorT);
            specialBuiltinMembers3 specialbuiltinmembers3 = specialBuiltinMembers3.m;
            FunctionDescriptor overriddenBuiltinFunctionWithErasedValueParametersInJava = specialBuiltinMembers3.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(simpleFunctionDescriptor2);
            if (overriddenBuiltinFunctionWithErasedValueParametersInJava == null) {
                simpleFunctionDescriptorT2 = null;
            } else {
                Name name2 = overriddenBuiltinFunctionWithErasedValueParametersInJava.getName();
                Intrinsics3.checkNotNullExpressionValue(name2, "overridden.name");
                Iterator<T> it2 = function1.invoke(name2).iterator();
                do {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                } while (!E((SimpleFunctionDescriptor) next, overriddenBuiltinFunctionWithErasedValueParametersInJava));
                SimpleFunctionDescriptor simpleFunctionDescriptor5 = (SimpleFunctionDescriptor) next;
                if (simpleFunctionDescriptor5 == null) {
                    simpleFunctionDescriptor = null;
                } else {
                    FunctionDescriptor.a<? extends SimpleFunctionDescriptor> aVarNewCopyBuilder2 = simpleFunctionDescriptor5.newCopyBuilder();
                    List<ValueParameterDescriptor> valueParameters = overriddenBuiltinFunctionWithErasedValueParametersInJava.getValueParameters();
                    Intrinsics3.checkNotNullExpressionValue(valueParameters, "overridden.valueParameters");
                    ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(valueParameters, 10));
                    for (ValueParameterDescriptor valueParameterDescriptor : valueParameters) {
                        KotlinType type = valueParameterDescriptor.getType();
                        Intrinsics3.checkNotNullExpressionValue(type, "it.type");
                        arrayList.add(new util4(type, valueParameterDescriptor.declaresDefaultValue()));
                    }
                    List<ValueParameterDescriptor> valueParameters2 = simpleFunctionDescriptor5.getValueParameters();
                    Intrinsics3.checkNotNullExpressionValue(valueParameters2, "override.valueParameters");
                    aVarNewCopyBuilder2.setValueParameters(util3.copyValueParameters(arrayList, valueParameters2, overriddenBuiltinFunctionWithErasedValueParametersInJava));
                    aVarNewCopyBuilder2.setSignatureChange();
                    aVarNewCopyBuilder2.setPreserveSourceElement();
                    simpleFunctionDescriptor = (SimpleFunctionDescriptor) aVarNewCopyBuilder2.build();
                }
                if (simpleFunctionDescriptor != null) {
                    if (!F(simpleFunctionDescriptor)) {
                        simpleFunctionDescriptor = null;
                    }
                    if (simpleFunctionDescriptor == null) {
                        simpleFunctionDescriptorT2 = null;
                    } else {
                        simpleFunctionDescriptorT2 = t(simpleFunctionDescriptor, overriddenBuiltinFunctionWithErasedValueParametersInJava, collection);
                    }
                } else {
                    simpleFunctionDescriptorT2 = null;
                }
            }
            collections.addIfNotNull(collection3, simpleFunctionDescriptorT2);
            if (!simpleFunctionDescriptor2.isSuspend()) {
                simpleFunctionDescriptorU = null;
                break;
            }
            Name name3 = simpleFunctionDescriptor2.getName();
            Intrinsics3.checkNotNullExpressionValue(name3, "descriptor.name");
            Iterator<T> it3 = function1.invoke(name3).iterator();
            do {
                if (!it3.hasNext()) {
                    simpleFunctionDescriptorU = null;
                    break;
                    break;
                } else {
                    simpleFunctionDescriptorU = u((SimpleFunctionDescriptor) it3.next());
                    if (simpleFunctionDescriptorU == null || !w(simpleFunctionDescriptorU, simpleFunctionDescriptor2)) {
                        simpleFunctionDescriptorU = null;
                    }
                }
            } while (simpleFunctionDescriptorU == null);
            collections.addIfNotNull(collection3, simpleFunctionDescriptorU);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r(Set<? extends PropertyDescriptor> set, Collection<PropertyDescriptor> collection, Set<PropertyDescriptor> set2, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptorA;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
        for (PropertyDescriptor propertyDescriptor : set) {
            JavaForKotlinOverridePropertyDescriptor javaForKotlinOverridePropertyDescriptor = null;
            PropertySetterDescriptor propertySetterDescriptor = null;
            if (v(propertyDescriptor, function1)) {
                SimpleFunctionDescriptor simpleFunctionDescriptorZ = z(propertyDescriptor, function1);
                Intrinsics3.checkNotNull(simpleFunctionDescriptorZ);
                if (propertyDescriptor.isVar()) {
                    simpleFunctionDescriptorA = A(propertyDescriptor, function1);
                    Intrinsics3.checkNotNull(simpleFunctionDescriptorA);
                } else {
                    simpleFunctionDescriptorA = null;
                }
                if (simpleFunctionDescriptorA != null) {
                    simpleFunctionDescriptorA.getModality();
                    simpleFunctionDescriptorZ.getModality();
                }
                JavaForKotlinOverridePropertyDescriptor javaForKotlinOverridePropertyDescriptor2 = new JavaForKotlinOverridePropertyDescriptor(this.n, simpleFunctionDescriptorZ, simpleFunctionDescriptorA, propertyDescriptor);
                KotlinType returnType = simpleFunctionDescriptorZ.getReturnType();
                Intrinsics3.checkNotNull(returnType);
                javaForKotlinOverridePropertyDescriptor2.setType(returnType, Collections2.emptyList(), i(), null);
                PropertyGetterDescriptorImpl propertyGetterDescriptorImplCreateGetter = DescriptorFactory.createGetter(javaForKotlinOverridePropertyDescriptor2, simpleFunctionDescriptorZ.getAnnotations(), false, false, false, simpleFunctionDescriptorZ.getSource());
                propertyGetterDescriptorImplCreateGetter.setInitialSignatureDescriptor(simpleFunctionDescriptorZ);
                propertyGetterDescriptorImplCreateGetter.initialize(javaForKotlinOverridePropertyDescriptor2.getType());
                Intrinsics3.checkNotNullExpressionValue(propertyGetterDescriptorImplCreateGetter, "createGetter(\n            propertyDescriptor, getterMethod.annotations, /* isDefault = */false,\n            /* isExternal = */ false, /* isInline = */ false, getterMethod.source\n        ).apply {\n            initialSignatureDescriptor = getterMethod\n            initialize(propertyDescriptor.type)\n        }");
                if (simpleFunctionDescriptorA != null) {
                    List<ValueParameterDescriptor> valueParameters = simpleFunctionDescriptorA.getValueParameters();
                    Intrinsics3.checkNotNullExpressionValue(valueParameters, "setterMethod.valueParameters");
                    ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) _Collections.firstOrNull((List) valueParameters);
                    if (valueParameterDescriptor == null) {
                        throw new AssertionError(Intrinsics3.stringPlus("No parameter found for ", simpleFunctionDescriptorA));
                    }
                    PropertySetterDescriptorImpl propertySetterDescriptorImplCreateSetter = DescriptorFactory.createSetter(javaForKotlinOverridePropertyDescriptor2, simpleFunctionDescriptorA.getAnnotations(), valueParameterDescriptor.getAnnotations(), false, false, false, simpleFunctionDescriptorA.getVisibility(), simpleFunctionDescriptorA.getSource());
                    propertySetterDescriptorImplCreateSetter.setInitialSignatureDescriptor(simpleFunctionDescriptorA);
                    propertySetterDescriptor = propertySetterDescriptorImplCreateSetter;
                    propertyGetterDescriptorImpl = propertyGetterDescriptorImplCreateGetter;
                } else {
                    propertyGetterDescriptorImpl = propertyGetterDescriptorImplCreateGetter;
                }
                javaForKotlinOverridePropertyDescriptor2.initialize(propertyGetterDescriptorImpl, propertySetterDescriptor);
                javaForKotlinOverridePropertyDescriptor = javaForKotlinOverridePropertyDescriptor2;
            }
            if (javaForKotlinOverridePropertyDescriptor != null) {
                collection.add(javaForKotlinOverridePropertyDescriptor);
                if (set2 == null) {
                    return;
                }
                ((SmartSet) set2).add(propertyDescriptor);
                return;
            }
        }
    }

    public void recordLookup(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        utils.record(this.c.getComponents().getLookupTracker(), lookupLocation2, this.n, name);
    }

    public final Collection<KotlinType> s() {
        if (!this.p) {
            return this.c.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner().refineSupertypes(this.n);
        }
        Collection<KotlinType> supertypes = this.n.getTypeConstructor().getSupertypes();
        Intrinsics3.checkNotNullExpressionValue(supertypes, "ownerDescriptor.typeConstructor.supertypes");
        return supertypes;
    }

    public final SimpleFunctionDescriptor t(SimpleFunctionDescriptor simpleFunctionDescriptor, CallableDescriptor callableDescriptor, Collection<? extends SimpleFunctionDescriptor> collection) {
        boolean z2 = true;
        if (!(collection instanceof Collection) || !collection.isEmpty()) {
            for (SimpleFunctionDescriptor simpleFunctionDescriptor2 : collection) {
                if (!Intrinsics3.areEqual(simpleFunctionDescriptor, simpleFunctionDescriptor2) && simpleFunctionDescriptor2.getInitialSignatureDescriptor() == null && w(simpleFunctionDescriptor2, callableDescriptor)) {
                    z2 = false;
                    break;
                }
            }
        }
        if (z2) {
            return simpleFunctionDescriptor;
        }
        SimpleFunctionDescriptor simpleFunctionDescriptor3 = (SimpleFunctionDescriptor) simpleFunctionDescriptor.newCopyBuilder().setHiddenToOvercomeSignatureClash().build();
        Intrinsics3.checkNotNull(simpleFunctionDescriptor3);
        return simpleFunctionDescriptor3;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.l.LazyJavaScope
    public String toString() {
        return Intrinsics3.stringPlus("Lazy Java member scope for ", this.o.getFqName());
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002a  */
    /* JADX WARN: Code duplicated, block: B:4:0x0012  */
    public final SimpleFunctionDescriptor u(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        FqName safe;
        List<ValueParameterDescriptor> valueParameters = simpleFunctionDescriptor.getValueParameters();
        Intrinsics3.checkNotNullExpressionValue(valueParameters, "valueParameters");
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) _Collections.lastOrNull((List) valueParameters);
        if (valueParameterDescriptor != null) {
            ClassifierDescriptor declarationDescriptor = valueParameterDescriptor.getType().getConstructor().getDeclarationDescriptor();
            FqNameUnsafe fqNameUnsafe = declarationDescriptor == null ? null : DescriptorUtils2.getFqNameUnsafe(declarationDescriptor);
            if (fqNameUnsafe != null) {
                if (!fqNameUnsafe.isSafe()) {
                    fqNameUnsafe = null;
                }
                if (fqNameUnsafe == null) {
                    safe = null;
                } else {
                    safe = fqNameUnsafe.toSafe();
                }
            } else {
                safe = null;
            }
            if (!suspendFunctionTypes.isContinuation(safe, this.c.getComponents().getSettings().isReleaseCoroutines())) {
                valueParameterDescriptor = null;
            }
        } else {
            valueParameterDescriptor = null;
        }
        if (valueParameterDescriptor == null) {
            return null;
        }
        FunctionDescriptor.a<? extends SimpleFunctionDescriptor> aVarNewCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
        List<ValueParameterDescriptor> valueParameters2 = simpleFunctionDescriptor.getValueParameters();
        Intrinsics3.checkNotNullExpressionValue(valueParameters2, "valueParameters");
        SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) aVarNewCopyBuilder.setValueParameters(_Collections.dropLast(valueParameters2, 1)).setReturnType(valueParameterDescriptor.getType().getArguments().get(0).getType()).build();
        SimpleFunctionDescriptorImpl simpleFunctionDescriptorImpl = (SimpleFunctionDescriptorImpl) simpleFunctionDescriptor2;
        if (simpleFunctionDescriptorImpl != null) {
            simpleFunctionDescriptorImpl.setSuspend(true);
        }
        return simpleFunctionDescriptor2;
    }

    public final boolean v(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        if (JavaDescriptorUtil.isJavaField(propertyDescriptor)) {
            return false;
        }
        SimpleFunctionDescriptor simpleFunctionDescriptorZ = z(propertyDescriptor, function1);
        SimpleFunctionDescriptor simpleFunctionDescriptorA = A(propertyDescriptor, function1);
        if (simpleFunctionDescriptorZ == null) {
            return false;
        }
        if (propertyDescriptor.isVar()) {
            return simpleFunctionDescriptorA != null && simpleFunctionDescriptorA.getModality() == simpleFunctionDescriptorZ.getModality();
        }
        return true;
    }

    public final boolean w(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        OverridingUtil.d.a result = OverridingUtil.f3468b.isOverridableByWithoutExternalConditions(callableDescriptor2, callableDescriptor, true).getResult();
        Intrinsics3.checkNotNullExpressionValue(result, "DEFAULT.isOverridableByWithoutExternalConditions(superDescriptor, this, true).result");
        return result == OverridingUtil.d.a.OVERRIDABLE && !JavaIncompatibilityRulesOverridabilityCondition.a.doesJavaOverrideHaveIncompatibleValueParameterKinds(callableDescriptor2, callableDescriptor);
    }

    public final boolean x(SimpleFunctionDescriptor simpleFunctionDescriptor, FunctionDescriptor functionDescriptor) {
        if (specialBuiltinMembers2.m.isRemoveAtByIndex(simpleFunctionDescriptor)) {
            functionDescriptor = functionDescriptor.getOriginal();
        }
        Intrinsics3.checkNotNullExpressionValue(functionDescriptor, "if (superDescriptor.isRemoveAtByIndex) subDescriptor.original else subDescriptor");
        return w(functionDescriptor, simpleFunctionDescriptor);
    }

    public final SimpleFunctionDescriptor y(PropertyDescriptor propertyDescriptor, String str, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        Name nameIdentifier = Name.identifier(str);
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(getterName)");
        Iterator<T> it = function1.invoke(nameIdentifier).iterator();
        do {
            simpleFunctionDescriptor = null;
            if (!it.hasNext()) {
                break;
            }
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) it.next();
            if (simpleFunctionDescriptor2.getValueParameters().size() == 0) {
                KotlinTypeChecker kotlinTypeChecker = KotlinTypeChecker.a;
                KotlinType returnType = simpleFunctionDescriptor2.getReturnType();
                if (returnType == null ? false : kotlinTypeChecker.isSubtypeOf(returnType, propertyDescriptor.getType())) {
                    simpleFunctionDescriptor = simpleFunctionDescriptor2;
                }
            }
        } while (simpleFunctionDescriptor == null);
        return simpleFunctionDescriptor;
    }

    public final SimpleFunctionDescriptor z(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
        PropertyGetterDescriptor propertyGetterDescriptor = getter == null ? null : (PropertyGetterDescriptor) specialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName(getter);
        String builtinSpecialPropertyGetterName = propertyGetterDescriptor != null ? ClassicBuiltinSpecialProperties.a.getBuiltinSpecialPropertyGetterName(propertyGetterDescriptor) : null;
        if (builtinSpecialPropertyGetterName != null && !specialBuiltinMembers.hasRealKotlinSuperClassWithOverrideOf(this.n, propertyGetterDescriptor)) {
            return y(propertyDescriptor, builtinSpecialPropertyGetterName, function1);
        }
        JvmAbi jvmAbi = JvmAbi.a;
        String strAsString = propertyDescriptor.getName().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "name.asString()");
        return y(propertyDescriptor, JvmAbi.getterName(strAsString), function1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope2(context4 context4Var, ClassDescriptor classDescriptor, d0.e0.p.d.m0.e.a.k0.g gVar, boolean z2, LazyJavaClassMemberScope2 lazyJavaClassMemberScope2) {
        super(context4Var, lazyJavaClassMemberScope2);
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        Intrinsics3.checkNotNullParameter(classDescriptor, "ownerDescriptor");
        Intrinsics3.checkNotNullParameter(gVar, "jClass");
        this.n = classDescriptor;
        this.o = gVar;
        this.p = z2;
        this.q = context4Var.getStorageManager().createLazyValue(new e(context4Var));
        this.r = context4Var.getStorageManager().createLazyValue(new h());
        this.f3332s = context4Var.getStorageManager().createLazyValue(new f());
        this.t = context4Var.getStorageManager().createMemoizedFunctionWithNullableValues(new i(context4Var));
    }
}
