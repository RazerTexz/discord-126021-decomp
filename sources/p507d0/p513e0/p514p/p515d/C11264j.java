package p507d0.p513e0.p514p.p515d;

import com.discord.models.domain.ModelAuditLogEntry;
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
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.InterfaceC11233f;
import p507d0.p513e0.p514p.p515d.p516l0.AbstractC11273e;
import p507d0.p513e0.p514p.p515d.p516l0.C11269a;
import p507d0.p513e0.p514p.p515d.p516l0.C11274f;
import p507d0.p513e0.p514p.p515d.p516l0.C11276h;
import p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.C11837a;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12221d;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.C12250y;
import p507d0.p592z.p594d.InterfaceC12234i;

/* JADX INFO: renamed from: d0.e0.p.d.j */
/* JADX INFO: compiled from: KFunctionImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11264j extends AbstractC11256f<Object> implements InterfaceC12234i<Object>, KFunction<Object>, InterfaceC11250c {

    /* JADX INFO: renamed from: n */
    public static final /* synthetic */ KProperty[] f22390n = {C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(C11264j.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(C11264j.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")), C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(C11264j.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};

    /* JADX INFO: renamed from: o */
    public final C11251c0.a f22391o;

    /* JADX INFO: renamed from: p */
    public final C11251c0.b f22392p;

    /* JADX INFO: renamed from: q */
    public final C11251c0.b f22393q;

    /* JADX INFO: renamed from: r */
    public final AbstractC11262i f22394r;

    /* JADX INFO: renamed from: s */
    public final String f22395s;

    /* JADX INFO: renamed from: t */
    public final Object f22396t;

    /* JADX INFO: renamed from: d0.e0.p.d.j$a */
    /* JADX INFO: compiled from: KFunctionImpl.kt */
    public static final class a extends AbstractC12240o implements Function0<InterfaceC11272d<? extends Member>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final InterfaceC11272d<? extends Member> invoke() {
            Object constructor;
            InterfaceC11272d interfaceC11272dAccess$createJvmStaticInObjectCaller;
            C11269a.a aVar = C11269a.a.POSITIONAL_CALL;
            AbstractC11252d abstractC11252dMapSignature = C11257f0.f22358b.mapSignature(C11264j.this.getDescriptor());
            if (abstractC11252dMapSignature instanceof AbstractC11252d.d) {
                if (C11264j.this.m9337b()) {
                    Class<?> jClass = C11264j.this.getContainer().getJClass();
                    List<InterfaceC11233f> parameters = C11264j.this.getParameters();
                    ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(parameters, 10));
                    Iterator<T> it = parameters.iterator();
                    while (it.hasNext()) {
                        String name = ((InterfaceC11233f) it.next()).getName();
                        C12238m.checkNotNull(name);
                        arrayList.add(name);
                    }
                    return new C11269a(jClass, arrayList, aVar, C11269a.b.KOTLIN, null, 16, null);
                }
                constructor = C11264j.this.getContainer().findConstructorBySignature(((AbstractC11252d.d) abstractC11252dMapSignature).getConstructorDesc());
            } else if (abstractC11252dMapSignature instanceof AbstractC11252d.e) {
                AbstractC11252d.e eVar = (AbstractC11252d.e) abstractC11252dMapSignature;
                constructor = C11264j.this.getContainer().findMethodBySignature(eVar.getMethodName(), eVar.getMethodDesc());
            } else if (abstractC11252dMapSignature instanceof AbstractC11252d.c) {
                constructor = ((AbstractC11252d.c) abstractC11252dMapSignature).getMethod();
            } else {
                if (!(abstractC11252dMapSignature instanceof AbstractC11252d.b)) {
                    if (!(abstractC11252dMapSignature instanceof AbstractC11252d.a)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    List<Method> methods = ((AbstractC11252d.a) abstractC11252dMapSignature).getMethods();
                    Class<?> jClass2 = C11264j.this.getContainer().getJClass();
                    ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(methods, 10));
                    for (Method method : methods) {
                        C12238m.checkNotNullExpressionValue(method, "it");
                        arrayList2.add(method.getName());
                    }
                    return new C11269a(jClass2, arrayList2, aVar, C11269a.b.JAVA, methods);
                }
                constructor = ((AbstractC11252d.b) abstractC11252dMapSignature).getConstructor();
            }
            if (constructor instanceof Constructor) {
                C11264j c11264j = C11264j.this;
                interfaceC11272dAccess$createJvmStaticInObjectCaller = C11264j.access$createConstructorCaller(c11264j, (Constructor) constructor, c11264j.getDescriptor());
            } else {
                if (!(constructor instanceof Method)) {
                    StringBuilder sbM833U = C1643a.m833U("Could not compute caller for function: ");
                    sbM833U.append(C11264j.this.getDescriptor());
                    sbM833U.append(" (member = ");
                    sbM833U.append(constructor);
                    sbM833U.append(')');
                    throw new C11247a0(sbM833U.toString());
                }
                Method method2 = (Method) constructor;
                interfaceC11272dAccess$createJvmStaticInObjectCaller = Modifier.isStatic(method2.getModifiers()) ? C11264j.this.getDescriptor().getAnnotations().findAnnotation(C11265j0.getJVM_STATIC()) != null ? C11264j.access$createJvmStaticInObjectCaller(C11264j.this, method2) : C11264j.access$createStaticMethodCaller(C11264j.this, method2) : C11264j.access$createInstanceMethodCaller(C11264j.this, method2);
            }
            return C11276h.createInlineClassAwareCallerIfNeeded$default(interfaceC11272dAccess$createJvmStaticInObjectCaller, C11264j.this.getDescriptor(), false, 2, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.j$b */
    /* JADX INFO: compiled from: KFunctionImpl.kt */
    public static final class b extends AbstractC12240o implements Function0<InterfaceC11272d<? extends Member>> {
        public b() {
            super(0);
        }

        /* JADX WARN: Code duplicated, block: B:35:0x012e  */
        @Override // kotlin.jvm.functions.Function0
        public final InterfaceC11272d<? extends Member> invoke() {
            GenericDeclaration genericDeclarationFindDefaultConstructor;
            InterfaceC11272d interfaceC11272dAccess$createStaticMethodCaller;
            C11269a.a aVar = C11269a.a.CALL_BY_NAME;
            AbstractC11252d abstractC11252dMapSignature = C11257f0.f22358b.mapSignature(C11264j.this.getDescriptor());
            if (abstractC11252dMapSignature instanceof AbstractC11252d.e) {
                AbstractC11262i container = C11264j.this.getContainer();
                AbstractC11252d.e eVar = (AbstractC11252d.e) abstractC11252dMapSignature;
                String methodName = eVar.getMethodName();
                String methodDesc = eVar.getMethodDesc();
                Member memberMo11457getMember = C11264j.this.getCaller().mo11457getMember();
                C12238m.checkNotNull(memberMo11457getMember);
                genericDeclarationFindDefaultConstructor = container.findDefaultMethod(methodName, methodDesc, !Modifier.isStatic(memberMo11457getMember.getModifiers()));
            } else if (abstractC11252dMapSignature instanceof AbstractC11252d.d) {
                if (C11264j.this.m9337b()) {
                    Class<?> jClass = C11264j.this.getContainer().getJClass();
                    List<InterfaceC11233f> parameters = C11264j.this.getParameters();
                    ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(parameters, 10));
                    Iterator<T> it = parameters.iterator();
                    while (it.hasNext()) {
                        String name = ((InterfaceC11233f) it.next()).getName();
                        C12238m.checkNotNull(name);
                        arrayList.add(name);
                    }
                    return new C11269a(jClass, arrayList, aVar, C11269a.b.KOTLIN, null, 16, null);
                }
                genericDeclarationFindDefaultConstructor = C11264j.this.getContainer().findDefaultConstructor(((AbstractC11252d.d) abstractC11252dMapSignature).getConstructorDesc());
            } else {
                if (abstractC11252dMapSignature instanceof AbstractC11252d.a) {
                    List<Method> methods = ((AbstractC11252d.a) abstractC11252dMapSignature).getMethods();
                    Class<?> jClass2 = C11264j.this.getContainer().getJClass();
                    ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(methods, 10));
                    for (Method method : methods) {
                        C12238m.checkNotNullExpressionValue(method, "it");
                        arrayList2.add(method.getName());
                    }
                    return new C11269a(jClass2, arrayList2, aVar, C11269a.b.JAVA, methods);
                }
                genericDeclarationFindDefaultConstructor = null;
            }
            if (genericDeclarationFindDefaultConstructor instanceof Constructor) {
                C11264j c11264j = C11264j.this;
                interfaceC11272dAccess$createStaticMethodCaller = C11264j.access$createConstructorCaller(c11264j, (Constructor) genericDeclarationFindDefaultConstructor, c11264j.getDescriptor());
            } else if (!(genericDeclarationFindDefaultConstructor instanceof Method)) {
                interfaceC11272dAccess$createStaticMethodCaller = null;
            } else if (C11264j.this.getDescriptor().getAnnotations().findAnnotation(C11265j0.getJVM_STATIC()) != null) {
                InterfaceC11450m containingDeclaration = C11264j.this.getDescriptor().getContainingDeclaration();
                Objects.requireNonNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                if (((InterfaceC11330e) containingDeclaration).isCompanionObject()) {
                    interfaceC11272dAccess$createStaticMethodCaller = C11264j.access$createStaticMethodCaller(C11264j.this, (Method) genericDeclarationFindDefaultConstructor);
                } else {
                    interfaceC11272dAccess$createStaticMethodCaller = C11264j.access$createJvmStaticInObjectCaller(C11264j.this, (Method) genericDeclarationFindDefaultConstructor);
                }
            } else {
                interfaceC11272dAccess$createStaticMethodCaller = C11264j.access$createStaticMethodCaller(C11264j.this, (Method) genericDeclarationFindDefaultConstructor);
            }
            if (interfaceC11272dAccess$createStaticMethodCaller != null) {
                return C11276h.createInlineClassAwareCallerIfNeeded(interfaceC11272dAccess$createStaticMethodCaller, C11264j.this.getDescriptor(), true);
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.j$c */
    /* JADX INFO: compiled from: KFunctionImpl.kt */
    public static final class c extends AbstractC12240o implements Function0<InterfaceC11472x> {
        public final /* synthetic */ String $name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(0);
            this.$name = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final InterfaceC11472x invoke() {
            return C11264j.this.getContainer().findFunctionDescriptor(this.$name, C11264j.this.f22395s);
        }
    }

    public C11264j(AbstractC11262i abstractC11262i, String str, String str2, InterfaceC11472x interfaceC11472x, Object obj) {
        this.f22394r = abstractC11262i;
        this.f22395s = str2;
        this.f22396t = obj;
        this.f22391o = C11251c0.lazySoft(interfaceC11472x, new c(str));
        this.f22392p = C11251c0.lazy(new a());
        this.f22393q = C11251c0.lazy(new b());
    }

    public static final AbstractC11273e access$createConstructorCaller(C11264j c11264j, Constructor constructor, InterfaceC11472x interfaceC11472x) {
        Objects.requireNonNull(c11264j);
        if (C11837a.shouldHideConstructorDueToInlineClassTypeValueParameters(interfaceC11472x)) {
            return c11264j.isBound() ? new AbstractC11273e.a(constructor, c11264j.getBoundReceiver()) : new AbstractC11273e.b(constructor);
        }
        return c11264j.isBound() ? new AbstractC11273e.c(constructor, c11264j.getBoundReceiver()) : new AbstractC11273e.e(constructor);
    }

    public static final AbstractC11273e.h access$createInstanceMethodCaller(C11264j c11264j, Method method) {
        return c11264j.isBound() ? new AbstractC11273e.h.a(method, c11264j.getBoundReceiver()) : new AbstractC11273e.h.d(method);
    }

    public static final AbstractC11273e.h access$createJvmStaticInObjectCaller(C11264j c11264j, Method method) {
        return c11264j.isBound() ? new AbstractC11273e.h.b(method) : new AbstractC11273e.h.e(method);
    }

    public static final AbstractC11273e.h access$createStaticMethodCaller(C11264j c11264j, Method method) {
        return c11264j.isBound() ? new AbstractC11273e.h.c(method, c11264j.getBoundReceiver()) : new AbstractC11273e.h.f(method);
    }

    public boolean equals(Object obj) {
        C11264j c11264jAsKFunctionImpl = C11265j0.asKFunctionImpl(obj);
        return c11264jAsKFunctionImpl != null && C12238m.areEqual(getContainer(), c11264jAsKFunctionImpl.getContainer()) && C12238m.areEqual(getName(), c11264jAsKFunctionImpl.getName()) && C12238m.areEqual(this.f22395s, c11264jAsKFunctionImpl.f22395s) && C12238m.areEqual(this.f22396t, c11264jAsKFunctionImpl.f22396t);
    }

    @Override // p507d0.p592z.p594d.InterfaceC12234i
    public int getArity() {
        return C11274f.getArity(getCaller());
    }

    public final Object getBoundReceiver() {
        return C11276h.coerceToExpectedReceiverType(this.f22396t, getDescriptor());
    }

    @Override // p507d0.p513e0.p514p.p515d.AbstractC11256f
    public InterfaceC11272d<?> getCaller() {
        return (InterfaceC11272d) this.f22392p.getValue(this, f22390n[1]);
    }

    @Override // p507d0.p513e0.p514p.p515d.AbstractC11256f
    public AbstractC11262i getContainer() {
        return this.f22394r;
    }

    @Override // p507d0.p513e0.p514p.p515d.AbstractC11256f
    public InterfaceC11272d<?> getDefaultCaller() {
        return (InterfaceC11272d) this.f22393q.getValue(this, f22390n[2]);
    }

    @Override // p507d0.p513e0.p514p.p515d.AbstractC11256f
    public InterfaceC11472x getDescriptor() {
        return (InterfaceC11472x) this.f22391o.getValue(this, f22390n[0]);
    }

    @Override // kotlin.reflect.KCallable
    public String getName() {
        String strAsString = getDescriptor().getName().asString();
        C12238m.checkNotNullExpressionValue(strAsString, "descriptor.name.asString()");
        return strAsString;
    }

    public int hashCode() {
        return this.f22395s.hashCode() + ((getName().hashCode() + (getContainer().hashCode() * 31)) * 31);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return InterfaceC11250c.a.invoke(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.AbstractC11256f
    public boolean isBound() {
        return !C12238m.areEqual(this.f22396t, AbstractC12221d.NO_RECEIVER);
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
        return C11255e0.f22349b.renderFunction(getDescriptor());
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return InterfaceC11250c.a.invoke(this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(Object obj, Object obj2) {
        return InterfaceC11250c.a.invoke(this, obj, obj2);
    }

    @Override // kotlin.jvm.functions.Function3
    public Object invoke(Object obj, Object obj2, Object obj3) {
        return InterfaceC11250c.a.invoke(this, obj, obj2, obj3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C11264j(AbstractC11262i abstractC11262i, String str, String str2, Object obj) {
        this(abstractC11262i, str, str2, null, obj);
        C12238m.checkNotNullParameter(abstractC11262i, "container");
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(str2, "signature");
    }

    @Override // kotlin.jvm.functions.Function4
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return InterfaceC11250c.a.invoke(this, obj, obj2, obj3, obj4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C11264j(AbstractC11262i abstractC11262i, InterfaceC11472x interfaceC11472x) {
        C12238m.checkNotNullParameter(abstractC11262i, "container");
        C12238m.checkNotNullParameter(interfaceC11472x, "descriptor");
        String strAsString = interfaceC11472x.getName().asString();
        C12238m.checkNotNullExpressionValue(strAsString, "descriptor.name.asString()");
        this(abstractC11262i, strAsString, C11257f0.f22358b.mapSignature(interfaceC11472x).asString(), interfaceC11472x, AbstractC12221d.NO_RECEIVER);
    }

    @Override // kotlin.jvm.functions.Function5
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return InterfaceC11250c.a.invoke(this, obj, obj2, obj3, obj4, obj5);
    }

    @Override // kotlin.jvm.functions.Function6
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return InterfaceC11250c.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // kotlin.jvm.functions.Function7
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return InterfaceC11250c.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // kotlin.jvm.functions.Function8
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        return InterfaceC11250c.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // kotlin.jvm.functions.Function9
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        return InterfaceC11250c.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // kotlin.jvm.functions.Function10
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        return InterfaceC11250c.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // kotlin.jvm.functions.Function11
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11) {
        return InterfaceC11250c.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11);
    }

    @Override // kotlin.jvm.functions.Function12
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
        return InterfaceC11250c.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    @Override // kotlin.jvm.functions.Function13
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13) {
        return InterfaceC11250c.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13);
    }

    @Override // kotlin.jvm.functions.Function14
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14) {
        return InterfaceC11250c.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14);
    }

    @Override // kotlin.jvm.functions.Function15
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15) {
        return InterfaceC11250c.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15);
    }

    @Override // kotlin.jvm.functions.Function16
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16) {
        return InterfaceC11250c.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16);
    }

    @Override // kotlin.jvm.functions.Function17
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17) {
        return InterfaceC11250c.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17);
    }

    @Override // kotlin.jvm.functions.Function22
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21, Object obj22) {
        return InterfaceC11250c.a.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22);
    }
}
