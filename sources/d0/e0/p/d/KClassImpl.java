package d0.e0.p.d;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.KClass;
import d0.e0.p.d.KDeclarationContainerImpl;
import d0.e0.p.d.ReflectProperties;
import d0.e0.p.d.m0.b.CompanionObjectMapping;
import d0.e0.p.d.m0.b.CompanionObjectMappingUtils;
import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.ClassConstructorDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassKind;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.ConstructorDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.findClassInModule;
import d0.e0.p.d.m0.c.k1.a.ReflectKotlinClass2;
import d0.e0.p.d.m0.c.k1.a.RuntimeModuleData;
import d0.e0.p.d.m0.d.b.LookupLocation3;
import d0.e0.p.d.m0.e.b.b0.KotlinClassHeader;
import d0.e0.p.d.m0.f.a0.JvmProtoBuf;
import d0.e0.p.d.m0.f.z.ProtoBufUtil;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.i.GeneratedMessageLite;
import d0.e0.p.d.m0.k.DescriptorUtils;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.k.a0.ResolutionScope;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.l.b.MemberDeserializer;
import d0.e0.p.d.m0.l.b.e0.DeserializedClassDescriptor;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.e0.p.d.m0.p.collections;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Arrays;
import d0.t._Collections;
import d0.z.JvmClassMapping;
import d0.z.d.FunctionReference;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.PropertyReference1Impl;
import d0.z.d.Reflection2;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: d0.e0.p.d.h, reason: use source file name */
/* JADX INFO: compiled from: KClassImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KClassImpl<T> extends KDeclarationContainerImpl implements KClass<T>, KTypeParameterOwnerImpl {
    public final ReflectProperties.b<KClassImpl<T>.a> m;
    public final Class<T> n;

    /* JADX INFO: renamed from: d0.e0.p.d.h$a */
    /* JADX INFO: compiled from: KClassImpl.kt */
    public final class a extends KDeclarationContainerImpl.b {
        public static final /* synthetic */ KProperty[] d = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "annotations", "getAnnotations()Ljava/util/List;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "simpleName", "getSimpleName()Ljava/lang/String;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "constructors", "getConstructors()Ljava/util/Collection;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "supertypes", "getSupertypes()Ljava/util/List;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(a.class), "allMembers", "getAllMembers()Ljava/util/Collection;"))};
        public final ReflectProperties.a e;
        public final ReflectProperties.a f;
        public final ReflectProperties.a g;
        public final ReflectProperties.b h;
        public final ReflectProperties.a i;
        public final ReflectProperties.a j;
        public final ReflectProperties.a k;
        public final ReflectProperties.a l;
        public final ReflectProperties.a m;
        public final ReflectProperties.a n;
        public final ReflectProperties.a o;

        /* JADX INFO: renamed from: d0.e0.p.d.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: KClassImpl.kt */
        public static final class C0375a extends Lambda implements Function0<List<? extends KCallableImpl<?>>> {
            public C0375a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends KCallableImpl<?>> invoke() {
                return _Collections.plus((Collection) a.this.getAllNonStaticMembers(), (Iterable) a.this.getAllStaticMembers());
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.h$a$b */
        /* JADX INFO: compiled from: KClassImpl.kt */
        public static final class b extends Lambda implements Function0<List<? extends KCallableImpl<?>>> {
            public b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends KCallableImpl<?>> invoke() {
                return _Collections.plus((Collection) a.this.getDeclaredNonStaticMembers(), (Iterable) a.access$getInheritedNonStaticMembers$p(a.this));
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.h$a$c */
        /* JADX INFO: compiled from: KClassImpl.kt */
        public static final class c extends Lambda implements Function0<List<? extends KCallableImpl<?>>> {
            public c() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends KCallableImpl<?>> invoke() {
                return _Collections.plus(a.access$getDeclaredStaticMembers$p(a.this), (Iterable) a.access$getInheritedStaticMembers$p(a.this));
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.h$a$d */
        /* JADX INFO: compiled from: KClassImpl.kt */
        public static final class d extends Lambda implements Function0<List<? extends Annotation>> {
            public d() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Annotation> invoke() {
                return util2.computeAnnotations(a.this.getDescriptor());
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.h$a$e */
        /* JADX INFO: compiled from: KClassImpl.kt */
        public static final class e extends Lambda implements Function0<List<? extends KFunction<? extends T>>> {
            public e() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<KFunction<T>> invoke() {
                Collection<ConstructorDescriptor> constructorDescriptors = KClassImpl.this.getConstructorDescriptors();
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(constructorDescriptors, 10));
                Iterator<T> it = constructorDescriptors.iterator();
                while (it.hasNext()) {
                    arrayList.add(new KFunctionImpl(KClassImpl.this, (ConstructorDescriptor) it.next()));
                }
                return arrayList;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.h$a$f */
        /* JADX INFO: compiled from: KClassImpl.kt */
        public static final class f extends Lambda implements Function0<List<? extends KCallableImpl<?>>> {
            public f() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends KCallableImpl<?>> invoke() {
                return _Collections.plus((Collection) a.this.getDeclaredNonStaticMembers(), (Iterable) a.access$getDeclaredStaticMembers$p(a.this));
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.h$a$g */
        /* JADX INFO: compiled from: KClassImpl.kt */
        public static final class g extends Lambda implements Function0<Collection<? extends KCallableImpl<?>>> {
            public g() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Collection<? extends KCallableImpl<?>> invoke() {
                KClassImpl kClassImpl = KClassImpl.this;
                return kClassImpl.b(kClassImpl.getMemberScope$kotlin_reflection(), KDeclarationContainerImpl.c.DECLARED);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.h$a$h */
        /* JADX INFO: compiled from: KClassImpl.kt */
        public static final class h extends Lambda implements Function0<Collection<? extends KCallableImpl<?>>> {
            public h() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Collection<? extends KCallableImpl<?>> invoke() {
                KClassImpl kClassImpl = KClassImpl.this;
                return kClassImpl.b(kClassImpl.getStaticScope$kotlin_reflection(), KDeclarationContainerImpl.c.DECLARED);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.h$a$i */
        /* JADX INFO: compiled from: KClassImpl.kt */
        public static final class i extends Lambda implements Function0<ClassDescriptor> {
            public i() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ClassDescriptor invoke() {
                ClassId classIdAccess$getClassId$p = KClassImpl.access$getClassId$p(KClassImpl.this);
                RuntimeModuleData moduleData = KClassImpl.this.getData().invoke().getModuleData();
                ClassDescriptor classDescriptorDeserializeClass = classIdAccess$getClassId$p.isLocal() ? moduleData.getDeserialization().deserializeClass(classIdAccess$getClassId$p) : findClassInModule.findClassAcrossModuleDependencies(moduleData.getModule(), classIdAccess$getClassId$p);
                if (classDescriptorDeserializeClass != null) {
                    return classDescriptorDeserializeClass;
                }
                KClassImpl.access$reportUnresolvedClass(KClassImpl.this);
                throw null;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.h$a$j */
        /* JADX INFO: compiled from: KClassImpl.kt */
        public static final class j extends Lambda implements Function0<Collection<? extends KCallableImpl<?>>> {
            public j() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Collection<? extends KCallableImpl<?>> invoke() {
                KClassImpl kClassImpl = KClassImpl.this;
                return kClassImpl.b(kClassImpl.getMemberScope$kotlin_reflection(), KDeclarationContainerImpl.c.INHERITED);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.h$a$k */
        /* JADX INFO: compiled from: KClassImpl.kt */
        public static final class k extends Lambda implements Function0<Collection<? extends KCallableImpl<?>>> {
            public k() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Collection<? extends KCallableImpl<?>> invoke() {
                KClassImpl kClassImpl = KClassImpl.this;
                return kClassImpl.b(kClassImpl.getStaticScope$kotlin_reflection(), KDeclarationContainerImpl.c.INHERITED);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.h$a$l */
        /* JADX INFO: compiled from: KClassImpl.kt */
        public static final class l extends Lambda implements Function0<List<? extends KClassImpl<? extends Object>>> {
            public l() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends KClassImpl<? extends Object>> invoke() {
                Collection contributedDescriptors$default = ResolutionScope.a.getContributedDescriptors$default(a.this.getDescriptor().getUnsubstitutedInnerClassesScope(), null, null, 3, null);
                ArrayList<DeclarationDescriptor> arrayList = new ArrayList();
                for (T t : contributedDescriptors$default) {
                    if (!DescriptorUtils.isEnumEntry((DeclarationDescriptor) t)) {
                        arrayList.add(t);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                for (DeclarationDescriptor declarationDescriptor : arrayList) {
                    Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    Class<?> javaClass = util2.toJavaClass((ClassDescriptor) declarationDescriptor);
                    KClassImpl kClassImpl = javaClass != null ? new KClassImpl(javaClass) : null;
                    if (kClassImpl != null) {
                        arrayList2.add(kClassImpl);
                    }
                }
                return arrayList2;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.h$a$m */
        /* JADX INFO: compiled from: KClassImpl.kt */
        public static final class m extends Lambda implements Function0<T> {
            public m() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                ClassDescriptor descriptor = a.this.getDescriptor();
                if (descriptor.getKind() != ClassKind.OBJECT) {
                    return null;
                }
                T t = (T) ((!descriptor.isCompanionObject() || CompanionObjectMappingUtils.isMappedIntrinsicCompanionObject(CompanionObjectMapping.a, descriptor)) ? KClassImpl.this.getJClass().getDeclaredField("INSTANCE") : KClassImpl.this.getJClass().getEnclosingClass().getDeclaredField(descriptor.getName().asString())).get(null);
                Objects.requireNonNull(t, "null cannot be cast to non-null type T");
                return t;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.h$a$n */
        /* JADX INFO: compiled from: KClassImpl.kt */
        public static final class n extends Lambda implements Function0<String> {
            public n() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                if (KClassImpl.this.getJClass().isAnonymousClass()) {
                    return null;
                }
                ClassId classIdAccess$getClassId$p = KClassImpl.access$getClassId$p(KClassImpl.this);
                if (classIdAccess$getClassId$p.isLocal()) {
                    return null;
                }
                return classIdAccess$getClassId$p.asSingleFqName().asString();
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.h$a$o */
        /* JADX INFO: compiled from: KClassImpl.kt */
        public static final class o extends Lambda implements Function0<List<? extends KClassImpl<? extends T>>> {
            public o() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<KClassImpl<? extends T>> invoke() {
                Collection<ClassDescriptor> sealedSubclasses = a.this.getDescriptor().getSealedSubclasses();
                Intrinsics3.checkNotNullExpressionValue(sealedSubclasses, "descriptor.sealedSubclasses");
                ArrayList arrayList = new ArrayList();
                for (ClassDescriptor classDescriptor : sealedSubclasses) {
                    Objects.requireNonNull(classDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    Class<?> javaClass = util2.toJavaClass(classDescriptor);
                    KClassImpl kClassImpl = javaClass != null ? new KClassImpl(javaClass) : null;
                    if (kClassImpl != null) {
                        arrayList.add(kClassImpl);
                    }
                }
                return arrayList;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.h$a$p */
        /* JADX INFO: compiled from: KClassImpl.kt */
        public static final class p extends Lambda implements Function0<String> {
            public p() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                if (KClassImpl.this.getJClass().isAnonymousClass()) {
                    return null;
                }
                ClassId classIdAccess$getClassId$p = KClassImpl.access$getClassId$p(KClassImpl.this);
                if (classIdAccess$getClassId$p.isLocal()) {
                    a aVar = a.this;
                    return a.access$calculateLocalClassName(aVar, KClassImpl.this.getJClass());
                }
                String strAsString = classIdAccess$getClassId$p.getShortClassName().asString();
                Intrinsics3.checkNotNullExpressionValue(strAsString, "classId.shortClassName.asString()");
                return strAsString;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.h$a$q */
        /* JADX INFO: compiled from: KClassImpl.kt */
        public static final class q extends Lambda implements Function0<List<? extends KTypeImpl>> {

            /* JADX INFO: renamed from: d0.e0.p.d.h$a$q$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: KClassImpl.kt */
            public static final class C0376a extends Lambda implements Function0<Type> {
                public final /* synthetic */ KotlinType $kotlinType;
                public final /* synthetic */ q this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0376a(KotlinType kotlinType, q qVar) {
                    super(0);
                    this.$kotlinType = kotlinType;
                    this.this$0 = qVar;
                }

                @Override // kotlin.jvm.functions.Function0
                public final Type invoke() {
                    ClassifierDescriptor declarationDescriptor = this.$kotlinType.getConstructor().getDeclarationDescriptor();
                    if (!(declarationDescriptor instanceof ClassDescriptor)) {
                        throw new KotlinReflectionInternalError("Supertype not a class: " + declarationDescriptor);
                    }
                    Class<?> javaClass = util2.toJavaClass((ClassDescriptor) declarationDescriptor);
                    if (javaClass == null) {
                        StringBuilder sbU = outline.U("Unsupported superclass of ");
                        sbU.append(a.this);
                        sbU.append(": ");
                        sbU.append(declarationDescriptor);
                        throw new KotlinReflectionInternalError(sbU.toString());
                    }
                    if (Intrinsics3.areEqual(KClassImpl.this.getJClass().getSuperclass(), javaClass)) {
                        Type genericSuperclass = KClassImpl.this.getJClass().getGenericSuperclass();
                        Intrinsics3.checkNotNullExpressionValue(genericSuperclass, "jClass.genericSuperclass");
                        return genericSuperclass;
                    }
                    Class<?>[] interfaces = KClassImpl.this.getJClass().getInterfaces();
                    Intrinsics3.checkNotNullExpressionValue(interfaces, "jClass.interfaces");
                    int iIndexOf = _Arrays.indexOf(interfaces, javaClass);
                    if (iIndexOf >= 0) {
                        Type type = KClassImpl.this.getJClass().getGenericInterfaces()[iIndexOf];
                        Intrinsics3.checkNotNullExpressionValue(type, "jClass.genericInterfaces[index]");
                        return type;
                    }
                    StringBuilder sbU2 = outline.U("No superclass of ");
                    sbU2.append(a.this);
                    sbU2.append(" in Java reflection for ");
                    sbU2.append(declarationDescriptor);
                    throw new KotlinReflectionInternalError(sbU2.toString());
                }
            }

            /* JADX INFO: renamed from: d0.e0.p.d.h$a$q$b */
            /* JADX INFO: compiled from: KClassImpl.kt */
            public static final class b extends Lambda implements Function0<Type> {
                public static final b j = new b();

                public b() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Type invoke() {
                    return Object.class;
                }
            }

            public q() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends KTypeImpl> invoke() {
                ClassKind kind;
                TypeConstructor typeConstructor = a.this.getDescriptor().getTypeConstructor();
                Intrinsics3.checkNotNullExpressionValue(typeConstructor, "descriptor.typeConstructor");
                Collection<KotlinType> supertypes = typeConstructor.getSupertypes();
                Intrinsics3.checkNotNullExpressionValue(supertypes, "descriptor.typeConstructor.supertypes");
                ArrayList arrayList = new ArrayList(supertypes.size());
                for (KotlinType kotlinType : supertypes) {
                    Intrinsics3.checkNotNullExpressionValue(kotlinType, "kotlinType");
                    arrayList.add(new KTypeImpl(kotlinType, new C0376a(kotlinType, this)));
                }
                if (!KotlinBuiltIns.isSpecialClassWithNoSupertypes(a.this.getDescriptor())) {
                    boolean z2 = false;
                    if (arrayList.isEmpty()) {
                        z2 = true;
                        break;
                    }
                    Iterator<T> it = arrayList.iterator();
                    do {
                        if (!it.hasNext()) {
                            z2 = true;
                            break;
                        }
                        ClassDescriptor classDescriptorForType = DescriptorUtils.getClassDescriptorForType(((KTypeImpl) it.next()).getType());
                        Intrinsics3.checkNotNullExpressionValue(classDescriptorForType, "DescriptorUtils.getClassDescriptorForType(it.type)");
                        kind = classDescriptorForType.getKind();
                        Intrinsics3.checkNotNullExpressionValue(kind, "DescriptorUtils.getClass…ptorForType(it.type).kind");
                    } while (kind == ClassKind.INTERFACE || kind == ClassKind.ANNOTATION_CLASS);
                    if (z2) {
                        KotlinType4 anyType = DescriptorUtils2.getBuiltIns(a.this.getDescriptor()).getAnyType();
                        Intrinsics3.checkNotNullExpressionValue(anyType, "descriptor.builtIns.anyType");
                        arrayList.add(new KTypeImpl(anyType, b.j));
                    }
                }
                return collections.compact(arrayList);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.h$a$r */
        /* JADX INFO: compiled from: KClassImpl.kt */
        public static final class r extends Lambda implements Function0<List<? extends KTypeParameterImpl>> {
            public r() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends KTypeParameterImpl> invoke() {
                List<TypeParameterDescriptor> declaredTypeParameters = a.this.getDescriptor().getDeclaredTypeParameters();
                Intrinsics3.checkNotNullExpressionValue(declaredTypeParameters, "descriptor.declaredTypeParameters");
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(declaredTypeParameters, 10));
                for (TypeParameterDescriptor typeParameterDescriptor : declaredTypeParameters) {
                    KClassImpl kClassImpl = KClassImpl.this;
                    Intrinsics3.checkNotNullExpressionValue(typeParameterDescriptor, "descriptor");
                    arrayList.add(new KTypeParameterImpl(kClassImpl, typeParameterDescriptor));
                }
                return arrayList;
            }
        }

        public a() {
            super();
            this.e = ReflectProperties.lazySoft(new i());
            ReflectProperties.lazySoft(new d());
            this.f = ReflectProperties.lazySoft(new p());
            this.g = ReflectProperties.lazySoft(new n());
            ReflectProperties.lazySoft(new e());
            ReflectProperties.lazySoft(new l());
            this.h = ReflectProperties.lazy(new m());
            ReflectProperties.lazySoft(new r());
            ReflectProperties.lazySoft(new q());
            this.i = ReflectProperties.lazySoft(new o());
            this.j = ReflectProperties.lazySoft(new g());
            this.k = ReflectProperties.lazySoft(new h());
            this.l = ReflectProperties.lazySoft(new j());
            this.m = ReflectProperties.lazySoft(new k());
            this.n = ReflectProperties.lazySoft(new b());
            this.o = ReflectProperties.lazySoft(new c());
            ReflectProperties.lazySoft(new f());
            ReflectProperties.lazySoft(new C0375a());
        }

        public static final String access$calculateLocalClassName(a aVar, Class cls) {
            Objects.requireNonNull(aVar);
            String simpleName = cls.getSimpleName();
            Method enclosingMethod = cls.getEnclosingMethod();
            if (enclosingMethod != null) {
                Intrinsics3.checkNotNullExpressionValue(simpleName, ModelAuditLogEntry.CHANGE_KEY_NAME);
                return Strings4.substringAfter$default(simpleName, enclosingMethod.getName() + "$", (String) null, 2, (Object) null);
            }
            Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
            if (enclosingConstructor == null) {
                Intrinsics3.checkNotNullExpressionValue(simpleName, ModelAuditLogEntry.CHANGE_KEY_NAME);
                return Strings4.substringAfter$default(simpleName, '$', (String) null, 2, (Object) null);
            }
            Intrinsics3.checkNotNullExpressionValue(simpleName, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return Strings4.substringAfter$default(simpleName, enclosingConstructor.getName() + "$", (String) null, 2, (Object) null);
        }

        public static final Collection access$getDeclaredStaticMembers$p(a aVar) {
            return (Collection) aVar.k.getValue(aVar, d[11]);
        }

        public static final Collection access$getInheritedNonStaticMembers$p(a aVar) {
            return (Collection) aVar.l.getValue(aVar, d[12]);
        }

        public static final Collection access$getInheritedStaticMembers$p(a aVar) {
            return (Collection) aVar.m.getValue(aVar, d[13]);
        }

        public final Collection<KCallableImpl<?>> getAllNonStaticMembers() {
            return (Collection) this.n.getValue(this, d[14]);
        }

        public final Collection<KCallableImpl<?>> getAllStaticMembers() {
            return (Collection) this.o.getValue(this, d[15]);
        }

        public final Collection<KCallableImpl<?>> getDeclaredNonStaticMembers() {
            return (Collection) this.j.getValue(this, d[10]);
        }

        public final ClassDescriptor getDescriptor() {
            return (ClassDescriptor) this.e.getValue(this, d[0]);
        }

        public final T getObjectInstance() {
            return this.h.getValue(this, d[6]);
        }

        public final String getQualifiedName() {
            return (String) this.g.getValue(this, d[3]);
        }

        public final List<KClass<? extends T>> getSealedSubclasses() {
            return (List) this.i.getValue(this, d[9]);
        }

        public final String getSimpleName() {
            return (String) this.f.getValue(this, d[2]);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.h$b */
    /* JADX INFO: compiled from: KClassImpl.kt */
    public static final class b extends Lambda implements Function0<KClassImpl<T>.a> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final KClassImpl<T>.a invoke() {
            return new a();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.h$c */
    /* JADX INFO: compiled from: KClassImpl.kt */
    public static final /* synthetic */ class c extends FunctionReference implements Function2<MemberDeserializer, d0.e0.p.d.m0.f.n, PropertyDescriptor> {
        public static final c j = new c();

        public c() {
            super(2);
        }

        @Override // d0.z.d.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "loadProperty";
        }

        @Override // d0.z.d.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinClass(MemberDeserializer.class);
        }

        @Override // d0.z.d.CallableReference
        public final String getSignature() {
            return "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;";
        }

        @Override // kotlin.jvm.functions.Function2
        public final PropertyDescriptor invoke(MemberDeserializer memberDeserializer, d0.e0.p.d.m0.f.n nVar) {
            Intrinsics3.checkNotNullParameter(memberDeserializer, "p1");
            Intrinsics3.checkNotNullParameter(nVar, "p2");
            return memberDeserializer.loadProperty(nVar);
        }
    }

    public KClassImpl(Class<T> cls) {
        Intrinsics3.checkNotNullParameter(cls, "jClass");
        this.n = cls;
        ReflectProperties.b<KClassImpl<T>.a> bVarLazy = ReflectProperties.lazy(new b());
        Intrinsics3.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Data() }");
        this.m = bVarLazy;
    }

    public static final ClassId access$getClassId$p(KClassImpl kClassImpl) {
        Objects.requireNonNull(kClassImpl);
        return RuntimeTypeMapper3.f3198b.mapJvmClassToKotlinClassId(kClassImpl.getJClass());
    }

    public static final Void access$reportUnresolvedClass(KClassImpl kClassImpl) {
        KotlinClassHeader classHeader;
        Objects.requireNonNull(kClassImpl);
        ReflectKotlinClass2 reflectKotlinClass2Create = ReflectKotlinClass2.a.create(kClassImpl.getJClass());
        KotlinClassHeader.a kind = (reflectKotlinClass2Create == null || (classHeader = reflectKotlinClass2Create.getClassHeader()) == null) ? null : classHeader.getKind();
        if (kind != null) {
            int iOrdinal = kind.ordinal();
            if (iOrdinal == 0) {
                StringBuilder sbU = outline.U("Unknown class: ");
                sbU.append(kClassImpl.getJClass());
                sbU.append(" (kind = ");
                sbU.append(kind);
                sbU.append(')');
                throw new KotlinReflectionInternalError(sbU.toString());
            }
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    if (iOrdinal == 3) {
                        StringBuilder sbX = outline.X("This class is an internal synthetic class generated by the Kotlin compiler, such as an anonymous class for a lambda, a SAM wrapper, a callable reference, etc. It's not a Kotlin class or interface, so the reflection ", "library has no idea what declarations does it have. Please use Java reflection to inspect this class: ");
                        sbX.append(kClassImpl.getJClass());
                        throw new UnsupportedOperationException(sbX.toString());
                    }
                    if (iOrdinal != 4 && iOrdinal != 5) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                StringBuilder sbX2 = outline.X("Packages and file facades are not yet supported in Kotlin reflection. ", "Meanwhile please use Java reflection to inspect this class: ");
                sbX2.append(kClassImpl.getJClass());
                throw new UnsupportedOperationException(sbX2.toString());
            }
        }
        StringBuilder sbU2 = outline.U("Unresolved class: ");
        sbU2.append(kClassImpl.getJClass());
        throw new KotlinReflectionInternalError(sbU2.toString());
    }

    public boolean equals(Object obj) {
        return (obj instanceof KClassImpl) && Intrinsics3.areEqual(JvmClassMapping.getJavaObjectType(this), JvmClassMapping.getJavaObjectType((KClass) obj));
    }

    @Override // d0.e0.p.d.KDeclarationContainerImpl
    public Collection<ConstructorDescriptor> getConstructorDescriptors() {
        ClassDescriptor descriptor = getDescriptor();
        if (descriptor.getKind() == ClassKind.INTERFACE || descriptor.getKind() == ClassKind.OBJECT) {
            return Collections2.emptyList();
        }
        Collection<ClassConstructorDescriptor> constructors = descriptor.getConstructors();
        Intrinsics3.checkNotNullExpressionValue(constructors, "descriptor.constructors");
        return constructors;
    }

    public final ReflectProperties.b<KClassImpl<T>.a> getData() {
        return this.m;
    }

    public ClassDescriptor getDescriptor() {
        return this.m.invoke().getDescriptor();
    }

    @Override // d0.e0.p.d.KDeclarationContainerImpl
    public Collection<FunctionDescriptor> getFunctions(Name name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        MemberScope3 memberScope$kotlin_reflection = getMemberScope$kotlin_reflection();
        LookupLocation3 lookupLocation3 = LookupLocation3.FROM_REFLECTION;
        return _Collections.plus((Collection) memberScope$kotlin_reflection.getContributedFunctions(name, lookupLocation3), (Iterable) getStaticScope$kotlin_reflection().getContributedFunctions(name, lookupLocation3));
    }

    @Override // d0.z.d.ClassBasedDeclarationContainer
    public Class<T> getJClass() {
        return this.n;
    }

    @Override // d0.e0.p.d.KDeclarationContainerImpl
    public PropertyDescriptor getLocalProperty(int i) {
        Class<?> declaringClass;
        if (Intrinsics3.areEqual(getJClass().getSimpleName(), "DefaultImpls") && (declaringClass = getJClass().getDeclaringClass()) != null && declaringClass.isInterface()) {
            KClass kotlinClass = JvmClassMapping.getKotlinClass(declaringClass);
            Objects.requireNonNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
            return ((KClassImpl) kotlinClass).getLocalProperty(i);
        }
        ClassDescriptor descriptor = getDescriptor();
        if (!(descriptor instanceof DeserializedClassDescriptor)) {
            descriptor = null;
        }
        DeserializedClassDescriptor deserializedClassDescriptor = (DeserializedClassDescriptor) descriptor;
        if (deserializedClassDescriptor == null) {
            return null;
        }
        d0.e0.p.d.m0.f.c classProto = deserializedClassDescriptor.getClassProto();
        GeneratedMessageLite.f<d0.e0.p.d.m0.f.c, List<d0.e0.p.d.m0.f.n>> fVar = JvmProtoBuf.j;
        Intrinsics3.checkNotNullExpressionValue(fVar, "JvmProtoBuf.classLocalVariable");
        d0.e0.p.d.m0.f.n nVar = (d0.e0.p.d.m0.f.n) ProtoBufUtil.getExtensionOrNull(classProto, fVar, i);
        if (nVar != null) {
            return (PropertyDescriptor) util2.deserializeToDescriptor(getJClass(), nVar, deserializedClassDescriptor.getC().getNameResolver(), deserializedClassDescriptor.getC().getTypeTable(), deserializedClassDescriptor.getMetadataVersion(), c.j);
        }
        return null;
    }

    public final MemberScope3 getMemberScope$kotlin_reflection() {
        return getDescriptor().getDefaultType().getMemberScope();
    }

    @Override // d0.e0.KClass
    public T getObjectInstance() {
        return this.m.invoke().getObjectInstance();
    }

    @Override // d0.e0.p.d.KDeclarationContainerImpl
    public Collection<PropertyDescriptor> getProperties(Name name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        MemberScope3 memberScope$kotlin_reflection = getMemberScope$kotlin_reflection();
        LookupLocation3 lookupLocation3 = LookupLocation3.FROM_REFLECTION;
        return _Collections.plus((Collection) memberScope$kotlin_reflection.getContributedVariables(name, lookupLocation3), (Iterable) getStaticScope$kotlin_reflection().getContributedVariables(name, lookupLocation3));
    }

    @Override // d0.e0.KClass
    public String getQualifiedName() {
        return this.m.invoke().getQualifiedName();
    }

    @Override // d0.e0.KClass
    public List<KClass<? extends T>> getSealedSubclasses() {
        return this.m.invoke().getSealedSubclasses();
    }

    @Override // d0.e0.KClass
    public String getSimpleName() {
        return this.m.invoke().getSimpleName();
    }

    public final MemberScope3 getStaticScope$kotlin_reflection() {
        MemberScope3 staticScope = getDescriptor().getStaticScope();
        Intrinsics3.checkNotNullExpressionValue(staticScope, "descriptor.staticScope");
        return staticScope;
    }

    public int hashCode() {
        return JvmClassMapping.getJavaObjectType(this).hashCode();
    }

    public String toString() {
        String str;
        StringBuilder sbU = outline.U("class ");
        ClassId classIdMapJvmClassToKotlinClassId = RuntimeTypeMapper3.f3198b.mapJvmClassToKotlinClassId(getJClass());
        FqName packageFqName = classIdMapJvmClassToKotlinClassId.getPackageFqName();
        Intrinsics3.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
        if (packageFqName.isRoot()) {
            str = "";
        } else {
            str = packageFqName.asString() + ".";
        }
        String strAsString = classIdMapJvmClassToKotlinClassId.getRelativeClassName().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "classId.relativeClassName.asString()");
        sbU.append(str + StringsJVM.replace$default(strAsString, '.', '$', false, 4, (Object) null));
        return sbU.toString();
    }
}
