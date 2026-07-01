package d0.e0.p.d;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.KParameter;
import d0.e0.p.d.FunctionWithAllInvokes;
import d0.e0.p.d.ReflectProperties;
import d0.e0.p.d.RuntimeTypeMapper;
import d0.e0.p.d.l0.AnnotationConstructorCaller;
import d0.e0.p.d.l0.Caller2;
import d0.e0.p.d.l0.Caller3;
import d0.e0.p.d.l0.CallerImpl;
import d0.e0.p.d.l0.InlineClassAwareCaller2;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.k.y.inlineClassManglingRules;
import d0.t.Iterables2;
import d0.z.d.CallableReference;
import d0.z.d.FunctionBase;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.PropertyReference1Impl;
import d0.z.d.Reflection2;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: d0.e0.p.d.j, reason: use source file name */
/* JADX INFO: compiled from: KFunctionImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KFunctionImpl extends KCallableImpl<Object> implements FunctionBase<Object>, KFunction<Object>, FunctionWithAllInvokes {
    public static final /* synthetic */ KProperty[] n = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(KFunctionImpl.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(KFunctionImpl.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(KFunctionImpl.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
    public final ReflectProperties.a o;
    public final ReflectProperties.b p;
    public final ReflectProperties.b q;
    public final KDeclarationContainerImpl r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f3200s;
    public final Object t;

    /* JADX INFO: renamed from: d0.e0.p.d.j$a */
    /* JADX INFO: compiled from: KFunctionImpl.kt */
    public static final class a extends Lambda implements Function0<Caller2<? extends Member>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Caller2<? extends Member> invoke() {
            Object constructor;
            Caller2 caller2Access$createJvmStaticInObjectCaller;
            AnnotationConstructorCaller.a aVar = AnnotationConstructorCaller.a.POSITIONAL_CALL;
            RuntimeTypeMapper runtimeTypeMapperMapSignature = RuntimeTypeMapper3.f3198b.mapSignature(KFunctionImpl.this.getDescriptor());
            if (runtimeTypeMapperMapSignature instanceof RuntimeTypeMapper.d) {
                if (KFunctionImpl.this.b()) {
                    Class<?> jClass = KFunctionImpl.this.getContainer().getJClass();
                    List<KParameter> parameters = KFunctionImpl.this.getParameters();
                    ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(parameters, 10));
                    Iterator<T> it = parameters.iterator();
                    while (it.hasNext()) {
                        String name = ((KParameter) it.next()).getName();
                        Intrinsics3.checkNotNull(name);
                        arrayList.add(name);
                    }
                    return new AnnotationConstructorCaller(jClass, arrayList, aVar, AnnotationConstructorCaller.b.KOTLIN, null, 16, null);
                }
                constructor = KFunctionImpl.this.getContainer().findConstructorBySignature(((RuntimeTypeMapper.d) runtimeTypeMapperMapSignature).getConstructorDesc());
            } else if (runtimeTypeMapperMapSignature instanceof RuntimeTypeMapper.e) {
                RuntimeTypeMapper.e eVar = (RuntimeTypeMapper.e) runtimeTypeMapperMapSignature;
                constructor = KFunctionImpl.this.getContainer().findMethodBySignature(eVar.getMethodName(), eVar.getMethodDesc());
            } else if (runtimeTypeMapperMapSignature instanceof RuntimeTypeMapper.c) {
                constructor = ((RuntimeTypeMapper.c) runtimeTypeMapperMapSignature).getMethod();
            } else {
                if (!(runtimeTypeMapperMapSignature instanceof RuntimeTypeMapper.b)) {
                    if (!(runtimeTypeMapperMapSignature instanceof RuntimeTypeMapper.a)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    List<Method> methods = ((RuntimeTypeMapper.a) runtimeTypeMapperMapSignature).getMethods();
                    Class<?> jClass2 = KFunctionImpl.this.getContainer().getJClass();
                    ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(methods, 10));
                    for (Method method : methods) {
                        Intrinsics3.checkNotNullExpressionValue(method, "it");
                        arrayList2.add(method.getName());
                    }
                    return new AnnotationConstructorCaller(jClass2, arrayList2, aVar, AnnotationConstructorCaller.b.JAVA, methods);
                }
                constructor = ((RuntimeTypeMapper.b) runtimeTypeMapperMapSignature).getConstructor();
            }
            if (constructor instanceof Constructor) {
                KFunctionImpl kFunctionImpl = KFunctionImpl.this;
                caller2Access$createJvmStaticInObjectCaller = KFunctionImpl.access$createConstructorCaller(kFunctionImpl, (Constructor) constructor, kFunctionImpl.getDescriptor());
            } else {
                if (!(constructor instanceof Method)) {
                    StringBuilder sbU = outline.U("Could not compute caller for function: ");
                    sbU.append(KFunctionImpl.this.getDescriptor());
                    sbU.append(" (member = ");
                    sbU.append(constructor);
                    sbU.append(')');
                    throw new KotlinReflectionInternalError(sbU.toString());
                }
                Method method2 = (Method) constructor;
                caller2Access$createJvmStaticInObjectCaller = Modifier.isStatic(method2.getModifiers()) ? KFunctionImpl.this.getDescriptor().getAnnotations().findAnnotation(util2.getJVM_STATIC()) != null ? KFunctionImpl.access$createJvmStaticInObjectCaller(KFunctionImpl.this, method2) : KFunctionImpl.access$createStaticMethodCaller(KFunctionImpl.this, method2) : KFunctionImpl.access$createInstanceMethodCaller(KFunctionImpl.this, method2);
            }
            return InlineClassAwareCaller2.createInlineClassAwareCallerIfNeeded$default(caller2Access$createJvmStaticInObjectCaller, KFunctionImpl.this.getDescriptor(), false, 2, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.j$b */
    /* JADX INFO: compiled from: KFunctionImpl.kt */
    public static final class b extends Lambda implements Function0<Caller2<? extends Member>> {
        public b() {
            super(0);
        }

        /* JADX WARN: Code duplicated, block: B:35:0x012e  */
        @Override // kotlin.jvm.functions.Function0
        public final Caller2<? extends Member> invoke() {
            GenericDeclaration genericDeclarationFindDefaultConstructor;
            Caller2 caller2Access$createStaticMethodCaller;
            AnnotationConstructorCaller.a aVar = AnnotationConstructorCaller.a.CALL_BY_NAME;
            RuntimeTypeMapper runtimeTypeMapperMapSignature = RuntimeTypeMapper3.f3198b.mapSignature(KFunctionImpl.this.getDescriptor());
            if (runtimeTypeMapperMapSignature instanceof RuntimeTypeMapper.e) {
                KDeclarationContainerImpl container = KFunctionImpl.this.getContainer();
                RuntimeTypeMapper.e eVar = (RuntimeTypeMapper.e) runtimeTypeMapperMapSignature;
                String methodName = eVar.getMethodName();
                String methodDesc = eVar.getMethodDesc();
                Member memberMo80getMember = KFunctionImpl.this.getCaller().mo80getMember();
                Intrinsics3.checkNotNull(memberMo80getMember);
                genericDeclarationFindDefaultConstructor = container.findDefaultMethod(methodName, methodDesc, !Modifier.isStatic(memberMo80getMember.getModifiers()));
            } else if (runtimeTypeMapperMapSignature instanceof RuntimeTypeMapper.d) {
                if (KFunctionImpl.this.b()) {
                    Class<?> jClass = KFunctionImpl.this.getContainer().getJClass();
                    List<KParameter> parameters = KFunctionImpl.this.getParameters();
                    ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(parameters, 10));
                    Iterator<T> it = parameters.iterator();
                    while (it.hasNext()) {
                        String name = ((KParameter) it.next()).getName();
                        Intrinsics3.checkNotNull(name);
                        arrayList.add(name);
                    }
                    return new AnnotationConstructorCaller(jClass, arrayList, aVar, AnnotationConstructorCaller.b.KOTLIN, null, 16, null);
                }
                genericDeclarationFindDefaultConstructor = KFunctionImpl.this.getContainer().findDefaultConstructor(((RuntimeTypeMapper.d) runtimeTypeMapperMapSignature).getConstructorDesc());
            } else {
                if (runtimeTypeMapperMapSignature instanceof RuntimeTypeMapper.a) {
                    List<Method> methods = ((RuntimeTypeMapper.a) runtimeTypeMapperMapSignature).getMethods();
                    Class<?> jClass2 = KFunctionImpl.this.getContainer().getJClass();
                    ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(methods, 10));
                    for (Method method : methods) {
                        Intrinsics3.checkNotNullExpressionValue(method, "it");
                        arrayList2.add(method.getName());
                    }
                    return new AnnotationConstructorCaller(jClass2, arrayList2, aVar, AnnotationConstructorCaller.b.JAVA, methods);
                }
                genericDeclarationFindDefaultConstructor = null;
            }
            if (genericDeclarationFindDefaultConstructor instanceof Constructor) {
                KFunctionImpl kFunctionImpl = KFunctionImpl.this;
                caller2Access$createStaticMethodCaller = KFunctionImpl.access$createConstructorCaller(kFunctionImpl, (Constructor) genericDeclarationFindDefaultConstructor, kFunctionImpl.getDescriptor());
            } else if (!(genericDeclarationFindDefaultConstructor instanceof Method)) {
                caller2Access$createStaticMethodCaller = null;
            } else if (KFunctionImpl.this.getDescriptor().getAnnotations().findAnnotation(util2.getJVM_STATIC()) != null) {
                DeclarationDescriptor containingDeclaration = KFunctionImpl.this.getDescriptor().getContainingDeclaration();
                Objects.requireNonNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                if (((ClassDescriptor) containingDeclaration).isCompanionObject()) {
                    caller2Access$createStaticMethodCaller = KFunctionImpl.access$createStaticMethodCaller(KFunctionImpl.this, (Method) genericDeclarationFindDefaultConstructor);
                } else {
                    caller2Access$createStaticMethodCaller = KFunctionImpl.access$createJvmStaticInObjectCaller(KFunctionImpl.this, (Method) genericDeclarationFindDefaultConstructor);
                }
            } else {
                caller2Access$createStaticMethodCaller = KFunctionImpl.access$createStaticMethodCaller(KFunctionImpl.this, (Method) genericDeclarationFindDefaultConstructor);
            }
            if (caller2Access$createStaticMethodCaller != null) {
                return InlineClassAwareCaller2.createInlineClassAwareCallerIfNeeded(caller2Access$createStaticMethodCaller, KFunctionImpl.this.getDescriptor(), true);
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.j$c */
    /* JADX INFO: compiled from: KFunctionImpl.kt */
    public static final class c extends Lambda implements Function0<FunctionDescriptor> {
        public final /* synthetic */ String $name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(0);
            this.$name = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FunctionDescriptor invoke() {
            return KFunctionImpl.this.getContainer().findFunctionDescriptor(this.$name, KFunctionImpl.this.f3200s);
        }
    }

    public KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, FunctionDescriptor functionDescriptor, Object obj) {
        this.r = kDeclarationContainerImpl;
        this.f3200s = str2;
        this.t = obj;
        this.o = ReflectProperties.lazySoft(functionDescriptor, new c(str));
        this.p = ReflectProperties.lazy(new a());
        this.q = ReflectProperties.lazy(new b());
    }

    public static final CallerImpl access$createConstructorCaller(KFunctionImpl kFunctionImpl, Constructor constructor, FunctionDescriptor functionDescriptor) {
        Objects.requireNonNull(kFunctionImpl);
        if (inlineClassManglingRules.shouldHideConstructorDueToInlineClassTypeValueParameters(functionDescriptor)) {
            return kFunctionImpl.isBound() ? new CallerImpl.a(constructor, kFunctionImpl.getBoundReceiver()) : new CallerImpl.b(constructor);
        }
        return kFunctionImpl.isBound() ? new CallerImpl.c(constructor, kFunctionImpl.getBoundReceiver()) : new CallerImpl.e(constructor);
    }

    public static final CallerImpl.h access$createInstanceMethodCaller(KFunctionImpl kFunctionImpl, Method method) {
        return kFunctionImpl.isBound() ? new CallerImpl.h.a(method, kFunctionImpl.getBoundReceiver()) : new CallerImpl.h.d(method);
    }

    public static final CallerImpl.h access$createJvmStaticInObjectCaller(KFunctionImpl kFunctionImpl, Method method) {
        return kFunctionImpl.isBound() ? new CallerImpl.h.b(method) : new CallerImpl.h.e(method);
    }

    public static final CallerImpl.h access$createStaticMethodCaller(KFunctionImpl kFunctionImpl, Method method) {
        return kFunctionImpl.isBound() ? new CallerImpl.h.c(method, kFunctionImpl.getBoundReceiver()) : new CallerImpl.h.f(method);
    }

    public boolean equals(Object obj) {
        KFunctionImpl kFunctionImplAsKFunctionImpl = util2.asKFunctionImpl(obj);
        return kFunctionImplAsKFunctionImpl != null && Intrinsics3.areEqual(getContainer(), kFunctionImplAsKFunctionImpl.getContainer()) && Intrinsics3.areEqual(getName(), kFunctionImplAsKFunctionImpl.getName()) && Intrinsics3.areEqual(this.f3200s, kFunctionImplAsKFunctionImpl.f3200s) && Intrinsics3.areEqual(this.t, kFunctionImplAsKFunctionImpl.t);
    }

    @Override // d0.z.d.FunctionBase
    public int getArity() {
        return Caller3.getArity(getCaller());
    }

    public final Object getBoundReceiver() {
        return InlineClassAwareCaller2.coerceToExpectedReceiverType(this.t, getDescriptor());
    }

    @Override // d0.e0.p.d.KCallableImpl
    public Caller2<?> getCaller() {
        return (Caller2) this.p.getValue(this, n[1]);
    }

    @Override // d0.e0.p.d.KCallableImpl
    public KDeclarationContainerImpl getContainer() {
        return this.r;
    }

    @Override // d0.e0.p.d.KCallableImpl
    public Caller2<?> getDefaultCaller() {
        return (Caller2) this.q.getValue(this, n[2]);
    }

    @Override // d0.e0.p.d.KCallableImpl
    public FunctionDescriptor getDescriptor() {
        return (FunctionDescriptor) this.o.getValue(this, n[0]);
    }

    @Override // kotlin.reflect.KCallable
    public String getName() {
        String strAsString = getDescriptor().getName().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "descriptor.name.asString()");
        return strAsString;
    }

    public int hashCode() {
        return this.f3200s.hashCode() + ((getName().hashCode() + (getContainer().hashCode() * 31)) * 31);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return FunctionWithAllInvokes.a.invoke(this);
    }

    @Override // d0.e0.p.d.KCallableImpl
    public boolean isBound() {
        return !Intrinsics3.areEqual(this.t, CallableReference.NO_RECEIVER);
    }

    @Override // kotlin.reflect.KFunction
    public boolean isExternal() {
        return getDescriptor().isExternal();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInfix() {
        return getDescriptor().isInfix();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInline() {
        return getDescriptor().isInline();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isOperator() {
        return getDescriptor().isOperator();
    }

    @Override // kotlin.reflect.KCallable, kotlin.reflect.KFunction
    public boolean isSuspend() {
        return getDescriptor().isSuspend();
    }

    public String toString() {
        return ReflectionObjectRenderer.f3197b.renderFunction(getDescriptor());
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return FunctionWithAllInvokes.a.invoke(this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(Object obj, Object obj2) {
        return FunctionWithAllInvokes.a.invoke(this, obj, obj2);
    }

    @Override // kotlin.jvm.functions.Function3
    public Object invoke(Object obj, Object obj2, Object obj3) {
        return FunctionWithAllInvokes.a.invoke(this, obj, obj2, obj3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, Object obj) {
        this(kDeclarationContainerImpl, str, str2, null, obj);
        Intrinsics3.checkNotNullParameter(kDeclarationContainerImpl, "container");
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "signature");
    }

    @Override // kotlin.jvm.functions.Function4
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return FunctionWithAllInvokes.a.invoke(this, obj, obj2, obj3, obj4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, FunctionDescriptor functionDescriptor) {
        Intrinsics3.checkNotNullParameter(kDeclarationContainerImpl, "container");
        Intrinsics3.checkNotNullParameter(functionDescriptor, "descriptor");
        String strAsString = functionDescriptor.getName().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "descriptor.name.asString()");
        this(kDeclarationContainerImpl, strAsString, RuntimeTypeMapper3.f3198b.mapSignature(functionDescriptor).asString(), functionDescriptor, CallableReference.NO_RECEIVER);
    }

    @Override // kotlin.jvm.functions.Function5
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return FunctionWithAllInvokes.a.invoke(this, obj, obj2, obj3, obj4, obj5);
    }

    @Override // kotlin.jvm.functions.Function6
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return FunctionWithAllInvokes.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // kotlin.jvm.functions.Function7
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return FunctionWithAllInvokes.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // kotlin.jvm.functions.Function8
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        return FunctionWithAllInvokes.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // kotlin.jvm.functions.Function9
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        return FunctionWithAllInvokes.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // kotlin.jvm.functions.Function10
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        return FunctionWithAllInvokes.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // kotlin.jvm.functions.Function11
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11) {
        return FunctionWithAllInvokes.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11);
    }

    @Override // kotlin.jvm.functions.Function12
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
        return FunctionWithAllInvokes.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    @Override // kotlin.jvm.functions.Function13
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13) {
        return FunctionWithAllInvokes.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13);
    }

    @Override // kotlin.jvm.functions.Function14
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14) {
        return FunctionWithAllInvokes.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14);
    }

    @Override // kotlin.jvm.functions.Function15
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15) {
        return FunctionWithAllInvokes.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15);
    }

    @Override // kotlin.jvm.functions.Function16
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16) {
        return FunctionWithAllInvokes.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16);
    }

    @Override // kotlin.jvm.functions.Function17
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17) {
        return FunctionWithAllInvokes.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17);
    }

    @Override // kotlin.jvm.functions.Function22
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21, Object obj22) {
        return FunctionWithAllInvokes.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22);
    }
}
